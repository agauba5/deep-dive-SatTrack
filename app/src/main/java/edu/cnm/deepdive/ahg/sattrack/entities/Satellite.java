package edu.cnm.deepdive.ahg.sattrack.entities;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.Date;

@DatabaseTable(tableName = "SATELLITE")
public class Satellite {

  @DatabaseField(columnName = "SATELLITE_ID", generatedId = true)
  private int id;

  @Expose
  @SerializedName("NORAD_CAT_ID")
  @DatabaseField(columnName = "NORAD_CAT_ID", canBeNull = false, index = true)
  private String noradId;

  @Expose
  @SerializedName("OBJECT_TYPE")
  @DatabaseField(columnName = "OBJECT_TYPE", canBeNull = false)
  private String objectType;

  @Expose
  @SerializedName("OBJECT_NAME")
  @DatabaseField(columnName = "OBJECT_NAME", canBeNull = false)
  private String satName;



  @DatabaseField(columnName = "ORGANIZATION_ID", canBeNull = true, foreign = true, foreignAutoRefresh = true, index = true)
  private Organization organization;

  @Expose
  @SerializedName("PERIOD")
  @DatabaseField(columnName = "PERIOD", canBeNull = false)
  private double orbitPeriod;

  @Expose
  @SerializedName("MEAN_MOTION")
  @DatabaseField(columnName = "MEAN_MOTION", canBeNull = false)
  private double speed;

  @Expose
  @SerializedName("INCLINATION")
  @DatabaseField(columnName = "INCLINATION", canBeNull = false)
  private double inclination;

  @Expose
  @SerializedName("ECCENTRICITY")
  @DatabaseField(columnName = "ECCENTRICITY", canBeNull = false)
  private double eccentricity;

  @Expose
  @SerializedName("APOGEE")
  @DatabaseField(columnName = "APOGEE", canBeNull = false)
  private double apogee;

  @Expose
  @SerializedName("PERIGEE")
  @DatabaseField(columnName = "PERIGEE", canBeNull = false)
  private double perigee;

  @Expose
  @SerializedName("OBJECT_ID")
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

  public double getOrbitPeriod() {
    return orbitPeriod;
  }

  public void setOrbitPeriod(double orbitPeriod) {
    this.orbitPeriod = orbitPeriod;
  }

  public double getSpeed() {
    return speed;
  }

  public void setSpeed(double speed) {
    this.speed = speed;
  }

  public double getInclination() {
    return inclination;
  }

  public void setInclination(double inclination) {
    this.inclination = inclination;
  }

  public double getEccentricity() {
    return eccentricity;
  }

  public void setEccentricity(double eccentricity) {
    this.eccentricity = eccentricity;
  }

  public double getApogee() {
    return apogee;
  }

  public void setApogee(int apogee) {
    this.apogee = apogee;
  }

  public double getPerigee() {
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

  @Override
  public String toString() {
    return getSatName();
  }
}
