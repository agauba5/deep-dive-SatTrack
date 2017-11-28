package edu.cnm.deepdive.ahg.sattrack.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import edu.cnm.deepdive.ahg.sattrack.R;
import edu.cnm.deepdive.ahg.sattrack.activities.MainActivity;
import edu.cnm.deepdive.ahg.sattrack.entities.Satellite;
import edu.cnm.deepdive.ahg.sattrack.helpers.OrmHelper.OrmInteraction;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * Set the displayed output once a search has been performed as well as containing the list of
 * favorite and tracked satellites
 */
public class ResultsFragment extends Fragment {

  /** Key to distinguish the type of search that was performed */
  public static final String SEARCH_TYPE_KEY = "search_type";
  /** Key to connect the organization id */
  public static final String ORG_ID_KEY = "org_id";
  /** Key to connect the pbject type */
  public static final String OBJECT_TYPE_KEY = "object_type";

  /** Key to connect the speed of the object */
  public static final String SPEED_KEY = "speed";
  /** Key to connect the period of the object*/
  public static final String PERIOD_KEY = "period";
  /** Key to connect the apogee position of the object*/
  public static final String APOGEE_KEY = "apogee";
  /** Key to connect the perigee position of the object*/
  public static final String PERIGEE_KEY = "perigee";
  /** Key to connect the inclination of the object*/
  public static final String INCLINATION_KEY = "inclination";
  /** Key to connect the eccentricity of the object*/
  public static final String ECCENTRICITY_KEY = "eccentricity";

  private static final double searchUpperBound = 1.05;
  private static final double searchLowerBound = .95;

  /**Assigns a integer value to the primary search key to be used in a switch statement*/
  public static final int PRIMARY_SEARCH = 0;
  /**Assigns a integer value to the parameter search key to be used in a switch statement*/
  public static final int PARAMETER_SEARCH = 1;

  private ListView searchResults;
  private Dao<Satellite, Integer> dao = null;
  private QueryBuilder<Satellite, Integer> builder = null;



  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Bundle args = getArguments();
    try {
      dao = ((OrmInteraction) getActivity()).getHelper().getSatelliteDao();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    builder = dao.queryBuilder();
    if (args != null) {
      int searchType = args.getInt(SEARCH_TYPE_KEY, PRIMARY_SEARCH);
      switch (searchType) {
        case PRIMARY_SEARCH:
          try {
            Where where = builder.where();
            where.isNotNull("SATELLITE_ID");
            int orgId = args.getInt(ORG_ID_KEY, 0);
            String objectType = args.getString(OBJECT_TYPE_KEY, null);
            if (orgId != 0) {
              where.and().eq("ORGANIZATION_ID", orgId);
            }
            if (objectType != null) {
              where.and().eq("OBJECT_TYPE", objectType);
            }
          } catch (SQLException e) {
            throw new RuntimeException(e);
          }
          break;
        case PARAMETER_SEARCH:
          try {
            Where where = builder.where();
            where.isNotNull("SATELLITE_ID");
            Double speed = args.getDouble(SPEED_KEY, 0.0);
            Double period = args.getDouble(PERIOD_KEY, 0.0);
            Double apogee = args.getDouble(APOGEE_KEY, 0.0);
            Double perigee = args.getDouble(PERIGEE_KEY, 0.0);
            Double inclination = args.getDouble(INCLINATION_KEY, 0.0);
            Double eccentricity = args.getDouble(ECCENTRICITY_KEY, 0.0);

            if (speed != 0.0) {
              where.and().between("MEAN_MOTION", speed* searchLowerBound, speed*searchUpperBound);
            }
            if (period != 0.0) {
              where.and().between("PERIOD", period* searchLowerBound, period*searchUpperBound);
            }
            if (apogee != 0.0) {
              where.and().between("APOGEE", apogee* searchLowerBound, apogee*searchUpperBound);
            }
            if (perigee != 0.0) {
              where.and().between("PERIGEE", perigee* searchLowerBound, perigee*searchUpperBound);
            }
            if (inclination != 0.0) {
              where.and().between("INCLINATION", inclination* searchLowerBound, inclination*searchUpperBound);
            }
            if (eccentricity != 0.0) {
              where.and().between("ECCENTRICITY", eccentricity* searchLowerBound, eccentricity*searchUpperBound);
            }

          } catch (SQLException e) {
            throw new RuntimeException(e);
          }
          break;
      }
    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_results_list, container, false);
    try {
      builder.orderBy("OBJECT_NAME", true);
      List<Satellite> sats = dao.query(builder.prepare());
      setupObjectNameTextView((ListView) root.findViewById(R.id.list), sats);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return root;
  }


  private void setupObjectNameTextView(ListView list, List<Satellite> sats) throws SQLException {

    ArrayAdapter<Satellite> adapter = new ArrayAdapter<>(getContext(), R.layout.fragment_results,
        sats);
    list.setAdapter(adapter);
    list.setOnItemClickListener(new OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Satellite item = (Satellite) adapterView.getItemAtPosition(position);
        ((MainActivity) getActivity()).loadSatFragment(item.getId());
      }
    });
  }

}
