package edu.cnm.deepdive.ahg.sattrack.entities;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.Date;

@DatabaseTable(tableName = "SATELLITE")
public class Satellite {

  @DatabaseField(columnName = "SATELLITE_ID", generatedId = true)
  private int id;

  @DatabaseField(columnName = "NORAD_CAT_ID", canBeNull = false)
  private String noradId;

  @DatabaseField(columnName = "OBJECT_TYPE", canBeNull = false)
  private String objectType;

  @DatabaseField(columnName = "SATNAME", canBeNull = false)
  private String satName;

  @DatabaseField(columnName = "ORGANIZATION_ID", canBeNull = false, foreign = true, foreignAutoRefresh = true)
  private Organization organization;

  @DatabaseField(columnName = "LAUNCH_DATE", format = "yyyy-MM-dd", canBeNull = false)
  private Date launchDate;

  @DatabaseField(columnName = "PERIOD", canBeNull = false)
  private double orbitPeriod;

  @DatabaseField(columnName = "INCLINATION", canBeNull = false)
  private double inclination;

  @DatabaseField(columnName = "APOGEE", canBeNull = false)
  private int apogee;

  @DatabaseField(columnName = "PERIGEE", canBeNull = false)
  private int perigee;

  @DatabaseField(columnName = "OBJECT_ID", canBeNull = false)
  private String objectId;

  public int getId() {
    return id;
  }

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

  public Organization getOrganization() {
    return organization;
  }

  public void setOrganization(Organization organization) {
    this.organization = organization;
  }

  public Date getLaunchDate() {
    return launchDate;
  }

  public void setLaunchDate(Date launchDate) {
    this.launchDate = launchDate;
  }

  public double getOrbitPeriod() {
    return orbitPeriod;
  }

  public void setOrbitPeriod(double orbitPeriod) {
    this.orbitPeriod = orbitPeriod;
  }

  public double getInclination() {
    return inclination;
  }

  public void setInclination(double inclination) {
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

  public String getObjectId() {
    return objectId;
  }

  public void setObjectId(String objectId) {
    this.objectId = objectId;
  }
}
