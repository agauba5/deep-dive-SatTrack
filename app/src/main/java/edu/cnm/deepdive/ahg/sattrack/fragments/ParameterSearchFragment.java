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

/**
 * A simple {@link Fragment} subclass.
 */
public class ParameterSearchFragment extends Fragment {
  private EditText speed;
  private EditText period;
  private EditText apogee;
  private EditText perigee;
  private EditText inclination;
  private EditText eccentricity;

  private Button paramiterSearchBtn;

  public ParameterSearchFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View root =  inflater.inflate(R.layout.fragment_parameter_search, container, false);


    paramiterSearchBtn = root.findViewById(R.id.parameter_search_button);
    paramiterSearchBtn.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        Bundle args = new Bundle();
        if (!speed.getText().toString().trim().isEmpty()) {
          args.putString(ResultsFragment.SPEED_KEY,  speed.getText().toString().trim());
        }
        if (!period.getText().toString().trim().isEmpty()) {
          args.putString(ResultsFragment.PERIOD_KEY, period.getText().toString().trim());
        }
        if (!apogee.getText().toString().trim().isEmpty()) {
          args.putString(ResultsFragment.APOGEE_KEY, apogee.getText().toString().trim());
        }
        if (!perigee.getText().toString().trim().isEmpty()) {
          args.putString(ResultsFragment.PERIGEE_KEY, perigee.getText().toString().trim());
        }
        if (!inclination.getText().toString().trim().isEmpty()) {
          args.putString(ResultsFragment.INCLINATION_KEY, inclination.getText().toString().trim());
        }
        if (!eccentricity.getText().toString().trim().isEmpty()) {
          args.putString(ResultsFragment.ECCENTRICITY_KEY, eccentricity.getText().toString().trim());
        }
        args.putInt(ResultsFragment.SEARCH_TYPE_KEY, ResultsFragment.PARAMETER_SEARCH);
        ((MainActivity) getActivity()).loadResultsFragment(args);
      }
    });
    return root;
  }

}
