package edu.cnm.deepdive.ahg.sattrack.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;
import edu.cnm.deepdive.ahg.sattrack.R;
import edu.cnm.deepdive.ahg.sattrack.activities.MainActivity;
import edu.cnm.deepdive.ahg.sattrack.entities.Satellite;

/**
 *
 * fragment that implements the parameter search , The class includes letting the user
 * search by the speed, period, apogee, perigee, inclination and eccentricity information of the
 * satellites
 */
public class ParameterSearchFragment extends Fragment {

  private EditText speed;
  private EditText period;
  private EditText apogee;
  private EditText perigee;
  private EditText inclination;
  private EditText eccentricity;

  public ParameterSearchFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_parameter_search, container, false);

    Button parameterSearchBan = root.findViewById(R.id.parameter_search_button);
    parameterSearchBan.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        Bundle args = new Bundle();
        // TODO create Satellite objects to pull data
        Satellite sat = new Satellite();
        if (speed.getText().toString().trim().isEmpty()) {
          args.putDouble(ResultsFragment.SPEED_KEY,
              Double.parseDouble(speed.getText().toString().trim()));
        }
        if (period.getText().toString().trim().isEmpty()) {
          args.putDouble(ResultsFragment.PERIOD_KEY,
              Double.parseDouble(period.getText().toString().trim()));
        }
        if (apogee.getText().toString().trim().isEmpty()) {
          args.putDouble(ResultsFragment.APOGEE_KEY,
              Double.parseDouble(apogee.getText().toString().trim()));
        }
        if (perigee.getText().toString().trim().isEmpty()) {
          args.putDouble(ResultsFragment.PERIGEE_KEY,
              Double.parseDouble(perigee.getText().toString().trim()));
        }
        if (inclination.getText().toString().trim().isEmpty()) {
          args.putDouble(ResultsFragment.INCLINATION_KEY,
              Double.parseDouble(inclination.getText().toString().trim()));
        }
        if (eccentricity.getText().toString().trim().isEmpty()) {
          args.putDouble(ResultsFragment.ECCENTRICITY_KEY,
              Double.parseDouble(eccentricity.getText().toString().trim()));
        }
        args.putInt(ResultsFragment.SEARCH_TYPE_KEY, ResultsFragment.PARAMETER_SEARCH);
        ((MainActivity) getActivity()).loadResultsFragment(args);
      }
    });
    return root;
  }

}
