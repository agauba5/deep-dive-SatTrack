package edu.cnm.deepdive.ahg.sattrack;


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
import edu.cnm.deepdive.ahg.sattrack.dummy.Content.Sats;

public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener, ResultsFragment.OnListFragmentInteractionListener ,
    HomeFragment.OnFragmentInteractionListener, DisplaySatFragment.OnFragmentInteractionListener{

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = setupToolbar();
    setupDrawer(toolbar);
    HomeFragment homeFragment = new  HomeFragment();
    FragmentTransaction home = getSupportFragmentManager().beginTransaction().add(R.id.content_main, homeFragment);
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
  public void onListFragmentInteraction(Sats item) {

  }

  @Override
  public void onFragmentInteraction(Uri uri) {
  }

  private void displaySelectedScreen(int id) {
    Fragment fragment = null;

    switch(id){
      case R.id.nav_saved:
        fragment = new ResultsFragment();
        break;
      case R.id.nav_track:
        fragment = new ResultsFragment();
        break;
      case  R.id.nav_home:
        fragment = new HomeFragment();
        break;
    }
    if(fragment != null) {
      FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
      ft.replace(R.id.content_main, fragment);
      ft.commit();
    }

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
  }

  public void searchClick(View view){
    Fragment fragment = new ResultsFragment();
    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
    ft.replace(R.id.content_main, fragment);
    ft.commit();
  }
  public void displayClick(View view){
    Fragment fragment = new DisplaySatFragment();
    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
    ft.replace(R.id.content_main, fragment);
    ft.commit();
  }
}
