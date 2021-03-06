package edu.cnm.deepdive.ahg.sattrack.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import edu.cnm.deepdive.ahg.sattrack.R;
import edu.cnm.deepdive.ahg.sattrack.fragments.DisplaySatFragment;
import edu.cnm.deepdive.ahg.sattrack.fragments.HomeFragment;
import edu.cnm.deepdive.ahg.sattrack.fragments.MainSearchFragment;
import edu.cnm.deepdive.ahg.sattrack.fragments.NotesDialogFragment;
import edu.cnm.deepdive.ahg.sattrack.fragments.ParameterSearchFragment;
import edu.cnm.deepdive.ahg.sattrack.fragments.ResultsFragment;
import edu.cnm.deepdive.ahg.sattrack.helpers.OrmHelper;

/**
 *  The main activity controls the functionality of the fragment in this application
 */
public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener,
    HomeFragment.OnFragmentInteractionListener, OrmHelper.OrmInteraction {

  private OrmHelper helper = null;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getHelper().getWritableDatabase().close();
    setContentView(R.layout.activity_main);
    Toolbar toolbar = setupToolbar();
    setupDrawer(toolbar);
    HomeFragment homeFragment = new HomeFragment();
    FragmentTransaction home = getSupportFragmentManager().beginTransaction()
        .add(R.id.content_main, homeFragment);
    home.commit();
  }


  private Toolbar setupToolbar() {
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    return toolbar;
  }

  private void setupDrawer(Toolbar toolbar) {
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawer.setDrawerListener(toggle);
    toggle.syncState();

    NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);
  }

  @Override
  public void onBackPressed() {
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    if (drawer.isDrawerOpen(GravityCompat.START)) {
      drawer.closeDrawer(GravityCompat.START);
    } else {
      super.onBackPressed();
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  @SuppressWarnings("StatementWithEmptyBody")
  @Override
  public boolean onNavigationItemSelected(MenuItem item) {
    // Handle navigation view item clicks here.
    int id = item.getItemId();

    displaySelectedScreen(id);
    return true;
  }


  @Override
  public void onFragmentInteraction(Uri uri) {
  }

  private void displaySelectedScreen(int id) {
    Fragment fragment = null;

    switch (id) {
      case R.id.nav_saved:
        fragment = new ResultsFragment();
        break;
      case R.id.nav_track:
        fragment = new ResultsFragment();
        break;
      case R.id.nav_home:
        fragment = new HomeFragment();
        break;
    }
    if (fragment != null) {
      FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
      ft.replace(R.id.content_main, fragment);
      ft.commit();
    }

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
  }

  @Override
  protected void onStart() {
    super.onStart();
    getHelper();
  }

  @Override
  protected void onStop() {
    releaseHelper();
    super.onStop();
  }


  @Override
  public synchronized OrmHelper getHelper() {
    if (helper == null) {
      helper = OpenHelperManager.getHelper(this, OrmHelper.class);
    }
    return helper;
  }

  public synchronized void releaseHelper() {
    if (helper != null) {
      OpenHelperManager.releaseHelper();
      helper = null;
    }
  }

  /**
   * This method Loads the results fragment with the selected search information
   * @param args a bundle of information that is sent to load the search results
   */
  public void loadResultsFragment(Bundle args) {
    Fragment fragment = new ResultsFragment();
    fragment.setArguments(args);
    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
    ft.replace(R.id.content_main, fragment);
    ft.commit();
  }

  /**
   * This method Loads the satellite display fragment with the selected search information
   * @param id the id that correlates with the selected satellite
   */
  public void loadSatFragment(int id) {
    Fragment fragment = new DisplaySatFragment();
    Bundle args = new Bundle();
    args.putInt(DisplaySatFragment.SAT_ID_KEY, id);
    fragment.setArguments(args);
    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
    ft.replace(R.id.content_main, fragment);
    ft.commit();
  }

  /**
   * This method Loads the main search fragment
   * @param view uses a view input to replace the home fragment
   */
  public void loadMainSearch(View view) {
    Fragment fragment = new MainSearchFragment();
    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
    ft.replace(R.id.content_main, fragment);
    ft.commit();
  }

  /**
   * This method Loads the parameter search fragment
   * @param view uses a view input to replace the home fragment
   */
  public void loadParameterSearch(View view) {
    Fragment fragment = new ParameterSearchFragment();
    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
    ft.replace(R.id.content_main, fragment);
    ft.commit();
  }

}