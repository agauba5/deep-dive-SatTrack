package edu.cnm.deepdive.ahg.sattrack.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatSpinner;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import com.j256.ormlite.android.compat.ApiCompatibility;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import edu.cnm.deepdive.ahg.sattrack.R;
import edu.cnm.deepdive.ahg.sattrack.entities.Organization;
import edu.cnm.deepdive.ahg.sattrack.entities.Satellite;
import edu.cnm.deepdive.ahg.sattrack.helpers.OrmHelper.OrmInteraction;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainSearchFragment extends Fragment {
  private AppCompatSpinner country;
  private AppCompatSpinner objectType;


  public MainSearchFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View root =  inflater.inflate(R.layout.fragment_main_search, container, false);
    try {
      setupCountrySpinner(root);
    } catch (SQLException e) {
      throw new  RuntimeException(e);
    }
    try {
      setupObjectTypeSpinner(root);
    } catch (SQLException e) {
      throw new  RuntimeException(e);
    }
    return root;
  }

  private void setupCountrySpinner(View root) throws SQLException {
    country = root.findViewById(R.id.country);
    Dao<Organization, Integer> orgDao = ((OrmInteraction) getActivity()).getHelper().getOrganizationDao();
    QueryBuilder<Organization, Integer> builder = orgDao.queryBuilder();
    builder.orderBy("COUNTRY", true);
    List<Organization> orgs = orgDao.query(builder.prepare());
    ArrayAdapter<Organization> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, orgs);
    country.setAdapter(adapter);
  }

  private void setupObjectTypeSpinner(View root) throws SQLException {
    objectType = root.findViewById(R.id.object_type);
    Dao<Satellite, Integer> satDao = ((OrmInteraction) getActivity()).getHelper().getSatelliteDao();
    QueryBuilder<Satellite, Integer> builder = satDao.queryBuilder();
    builder.distinct();
    builder.selectRaw("OBJECT_TYPE");
    builder.orderBy("OBJECT_TYPE", true);
    List<String[]> sats = satDao.queryRaw(builder.prepareStatementString()).getResults();
    List<String> types = new ArrayList<>();
    for (String[] row : sats){
      types.add(row[0]);
    }
    ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, types);
    country.setAdapter(adapter);
  }

}
