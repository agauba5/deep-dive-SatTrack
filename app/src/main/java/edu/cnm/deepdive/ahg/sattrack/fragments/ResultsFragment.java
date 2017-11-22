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
 * A fragment representing a list of Items. <p /> Activities containing this fragment MUST
 * implement
 */
public class ResultsFragment extends Fragment {

  public static final String SEARCH_TYPE_KEY = "search_type";
  public static final String ORG_ID_KEY = "org_id";
  public static final String OBJECT_TYPE_KEY = "object_type";

  public static final String SPEED_KEY = "speed";
  public static final String PERIOD_KEY = "period";
  public static final String APOGEE_KEY = "apogee";
  public static final String PERIGEE_KEY = "perigee";
  public static final String INCLINATION_KEY = "inclination";
  public static final String ECCENTRICITY_KEY = "eccentricity";

  private static final double searchUpperBound = 1.05;
  private static final double searchLowerBound = .95;

  public static final int PRIMARY_SEARCH = 0;
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
            Double speed = Double.parseDouble(args.getString(SPEED_KEY, null));
            Double period = Double.parseDouble(args.getString(PERIOD_KEY, null));
            Double apogee = Double.parseDouble(args.getString(APOGEE_KEY, null));
            Double perigee = Double.parseDouble(args.getString(PERIGEE_KEY, null));
            Double inclination = Double.parseDouble(args.getString(INCLINATION_KEY, null));
            Double eccentricity = Double.parseDouble(args.getString(ECCENTRICITY_KEY, null));

            if (speed != null) {
              where.and().between("MEAN_MOTION", speed* searchLowerBound, speed*searchUpperBound);
            }
            if (period != null) {
              where.and().between("PERIOD", period* searchLowerBound, period*searchUpperBound);
            }
            if (apogee != null) {
              where.and().between("APOGEE", apogee* searchLowerBound, apogee*searchUpperBound);
            }
            if (perigee != null) {
              where.and().between("PERIGEE", perigee* searchLowerBound, perigee*searchUpperBound);
            }
            if (inclination != null) {
              where.and().between("INCLINATION", inclination* searchLowerBound, inclination*searchUpperBound);
            }
            if (eccentricity != null) {
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


  private List<String> searchResultsFilter(List<String> types, List<String[]> sats) {

    for (String[] row : sats) {
      // TODO add filter to reduce list of sat's by country and object type
      // TODO if()
      types.add(row[0]);
    }
    return types;
  }

  private List<String> parmaeterSearchResultsFilter(List<String> types, List<String[]> sats) {
    // TODO add filter to reduce list of sat's by parameters searched
    for (String[] row : sats) {
      // TODO add filter
      types.add(row[0]);
    }
    return types;
  }

}
