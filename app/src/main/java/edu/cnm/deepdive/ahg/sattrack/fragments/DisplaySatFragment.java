package edu.cnm.deepdive.ahg.sattrack.fragments;


import android.support.v4.app.DialogFragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import com.j256.ormlite.dao.Dao;
import edu.cnm.deepdive.ahg.sattrack.R;
import edu.cnm.deepdive.ahg.sattrack.activities.MainActivity;
import edu.cnm.deepdive.ahg.sattrack.entities.Satellite;
import edu.cnm.deepdive.ahg.sattrack.helpers.OrmHelper.OrmInteraction;
import java.sql.SQLException;


/**
 *
 * fragment that contains the information of the user selected satellite
 */
public class DisplaySatFragment extends Fragment implements OnClickListener {

  /**
   * key to connect the selected satellites id
   */
  public static final String SAT_ID_KEY = "sat_id";

  private View rootView;
  private View notesBtn;
  private View favoritesBtn;
  private View trackBtn;
  private Satellite satellite;

  public DisplaySatFragment() {
    // Required empty public constructor
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      int satId = getArguments().getInt(SAT_ID_KEY, 0);
      if (satId != 0 ){
        try {
          Dao<Satellite, Integer> satDao = ((OrmInteraction) getActivity()).getHelper().getSatelliteDao();
          satellite = satDao.queryForId(satId);
        }catch (SQLException e){
          throw  new RuntimeException(e);
        }

        //TODO populate any fields as necessary and add API stuff
      }
    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    rootView = inflater.inflate(R.layout.fragment_display_sat, container, false);
    notesBtn = rootView.findViewById(R.id.notes_button);
    favoritesBtn = rootView.findViewById(R.id.favorites_button);
    trackBtn = rootView.findViewById(R.id.track_button);

    notesBtn.setOnClickListener(this);
    favoritesBtn.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        // TODO add favorites list
      }
    });
    trackBtn.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        // TODO add to tracked list
      }
    });
    // TODO set values of any widgets
    return rootView;
  }


  @Override
  public void onClick(View view) {
    DialogFragment fragment = new NotesDialogFragment();
    fragment.show(getFragmentManager(), fragment.getClass().getSimpleName());
  }
}
