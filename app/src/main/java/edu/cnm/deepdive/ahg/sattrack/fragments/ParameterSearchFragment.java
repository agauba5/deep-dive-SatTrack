package edu.cnm.deepdive.ahg.sattrack.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.cnm.deepdive.ahg.sattrack.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ParameterSearchFragment extends Fragment {


  public ParameterSearchFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_parameter_search, container, false);
  }

}
