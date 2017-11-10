package edu.cnm.deepdive.ahg.sattrack.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import edu.cnm.deepdive.ahg.sattrack.R;
import edu.cnm.deepdive.ahg.sattrack.entities.Organization;
import edu.cnm.deepdive.ahg.sattrack.entities.SatLog;
import edu.cnm.deepdive.ahg.sattrack.entities.Satellite;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import junit.framework.Assert;

public class OrmHelper extends OrmLiteSqliteOpenHelper {

  private static final String DATABASE_NAME = "satellites.db";
  private static final int DATABASE_VERSION = 1;

  private Dao<Organization, Integer> organizationDao = null;
  private Dao<Satellite, Integer> satelliteDao = null;
  private Dao<SatLog, Integer> satLogDao = null;
  private Context context;

  public OrmHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
    this.context = context;
  }

  @Override
  public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
    try {
      TableUtils.createTable(connectionSource, Organization.class);
      TableUtils.createTable(connectionSource, Satellite.class);
      TableUtils.createTable(connectionSource, SatLog.class);
      populateDatabase();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion,
      int newVersion) {

  }

  @Override
  public void close() {
    organizationDao = null;
    satelliteDao = null;
    satLogDao = null;
    super.close();
  }

  public synchronized Dao<Organization, Integer> getOrganizationDao() throws SQLException {
    if (organizationDao == null) {
      organizationDao = getDao(Organization.class);
    }
    return organizationDao;
  }

  public synchronized Dao<Satellite, Integer> getSatelliteDao() throws SQLException {
    if (satelliteDao == null) {
      satelliteDao = getDao(Satellite.class);
    }
    return satelliteDao;
  }

  public synchronized Dao<SatLog, Integer> getSatLogDao() throws SQLException {
    if (satLogDao == null) {
      satLogDao = getDao(SatLog.class);
    }
    return satLogDao;
  }

  private void populateDatabase() throws SQLException {
    // TODO add for loop to populate dropdown spinner for country filter

    Organization organization = null;
    Satellite satellite;
    Calendar calendar;
    SatLog satLog;
    List<Organization> testOrg;
    List<Satellite> testSat;

    try (Reader reader = new InputStreamReader(context.getResources().openRawResource(R.raw.sample_content))) {
      Gson data = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
      Organization[] orgs = data.fromJson(reader, Organization[].class);
      for (Organization org :orgs) {
        getOrganizationDao().create(org);
        organization = org;
      }
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }



    calendar = Calendar.getInstance();
    calendar.set(2017,11,10);
    satellite = new Satellite();
    satellite.setNoradId("20194");
    satellite.setObjectType("ROCKET BODY");
    satellite.setSatName("DELTA 1 R/B");
    satellite.setOrganization(organization);
    satellite.setOrbitPeriod(88.03);
    satellite.setInclination(26.69);
    satellite.setApogee(190);
    satellite.setPerigee(164);
    satellite.setObjectId("1989-067B");
    satellite.setLaunchDate(calendar.getTime());
    getSatelliteDao().create(satellite);
//
//    calendar = Calendar.getInstance();
//    satLog = new SatLog();
//    calendar.set(2017,11,10);
//    satLog.setDate(calendar.getTime());
//    satLog.setSatellite(satellite);
//    satLog.setNotes("Observed object");
//    getSatLogDao().create(satLog);
//
//    testOrg = getOrganizationDao().queryForAll();
//    Assert.assertEquals(testOrg.size(),1);
//    testSat = getSatelliteDao().queryForAll();
//    Assert.assertEquals(testSat.size(),1);
//    Assert.assertEquals(testSat.get(0).getOrganization().getId(),testOrg.get(0).getId());

  }

  public interface OrmInteraction {

    OrmHelper getHelper();

  }

}
