package edu.cnm.deepdive.ahg.sattrack.entities;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.Date;

@DatabaseTable(tableName = "SATELLITES")
public class Satellite {

  @DatabaseField(columnName = "NORAD_CAT_ID", canBeNull = false)
  private String noradId;

  @DatabaseField(columnName = "OBJECT_TYPE", canBeNull = false)
  private String objectType;

  @DatabaseField(columnName = "SATNAME", canBeNull = false)
  private String satName;

  @DatabaseField(columnName = "COUNTRY", canBeNull = false)
  private String countryId;

  @DatabaseField(columnName = "LAUNCH_DATE", format = "yyyy-MM-dd", canBeNull = false)
  private Date launchDate;

  @DatabaseField(columnName = "PERIOD", canBeNull = false)
  private int orbitPeriod;

  @DatabaseField(columnName = "INCLINATION", canBeNull = false)
  private int inclination;

  @DatabaseField(columnName = "APOGEE", canBeNull = false)
  private int apogee;

  @DatabaseField(columnName = "PERIGEE", canBeNull = false)
  private int perigee;

  @DatabaseField(columnName = "OBJECT_ID", canBeNull = false)
  private String objectId;


  public String getNoradId() {
    return noradId;
  }

  public void setNoradId(String noradId) {
    this.noradId = noradId;
  }

  public String getObjectType() {
    return objectType;
  }

  public void setObjectType(String objectType) {
    this.objectType = objectType;
  }

  public String getSatName() {
    return satName;
  }

  public void setSatName(String satName) {
    this.satName = satName;
  }

  public String getCountryId() {
    return countryId;
  }

  public void setCountryId(String countryId) {
    this.countryId = countryId;
  }

  public Date getLaunchDate() {
    return launchDate;
  }

  public void setLaunchDate(Date launchDate) {
    this.launchDate = launchDate;
  }

  public int getOrbitPeriod() {
    return orbitPeriod;
  }

  public void setOrbitPeriod(int orbitPeriod) {
    this.orbitPeriod = orbitPeriod;
  }

  public int getInclination() {
    return inclination;
  }

  public void setInclination(int inclination) {
    this.inclination = inclination;
  }

  public int getApogee() {
    return apogee;
  }

  public void setApogee(int apogee) {
    this.apogee = apogee;
  }

  public int getPerigee() {
    return perigee;
  }

  public void setPerigee(int perigee) {
    this.perigee = perigee;
  }
}
