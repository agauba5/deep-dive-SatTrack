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

  /**
   *
   * @param noradId sets the norad catalog id
   */
  public void setNoradId(String noradId) {
    this.noradId = noradId;
  }

  /**
   *
   * @param objectType sets the type of object (PAYLOAD, ROCKETBODY, DEBRIS)
   */

  public void setObjectType(String objectType) {
    this.objectType = objectType;
  }

  /**
   *
   * @param satName sets the name of the satellite
   */

  public void setSatName(String satName) {
    this.satName = satName;
  }

  /**
   *
   * @param organization sets an organization object which correlates the country with the satellites
   */

  public void setOrganization(Organization organization) {
    this.organization = organization;
  }

  /**
   *
   * @param orbitPeriod sets the data for the period of the orbit for the satellite
   */

  public void setOrbitPeriod(double orbitPeriod) {
    this.orbitPeriod = orbitPeriod;
  }

  /**
   *
   * @param speed sets the data for the speed of the satellite
   */

  public void setSpeed(double speed) {
    this.speed = speed;
  }

  /**
   *
   * @param inclination sets the data for the inclination of the satellite
   */

  public void setInclination(double inclination) {
    this.inclination = inclination;
  }

  /**
   *
   * @param eccentricity sets the data for the eccentricity of the satellite
   */
  public void setEccentricity(double eccentricity) {
    this.eccentricity = eccentricity;
  }

  /**
   *
   * @param apogee sets the data for the apogee  position of the satellite
   */

  public void setApogee(int apogee) {
    this.apogee = apogee;
  }

  /**
   *
   * @param perigee sets the data for the perigee position of the satellite
   */

  public void setPerigee(int perigee) {
    this.perigee = perigee;
  }

  /**
   *
   * @param objectId sets the id of the object
   */

  public void setObjectId(String objectId) {
    this.objectId = objectId;
  }

  /**
   *
   * @return returns the id that is generated
   */
  public int getId() {
    return id;
  }

  /**
   *
   * @return returns the norad catalog id
   */
  public String getNoradId() {
    return noradId;
  }

  /**
   *
   * @return reurns the type of object (PAYLOAD, ROCKETBODY, DEBRIS)
   */
  public String getObjectType() {
    return objectType;
  }

  /**
   *
   * @return returns the name of the satellite
   */
  public String getSatName() {
    return satName;
  }

  /**
   *
   * @return returns an organization object which correlates the country with the satellites
   */

  public Organization getOrganization() {
    return organization;
  }

  /**
   *
   * @return returns the orbital period of the satellite
   */

  public double getOrbitPeriod() {
    return orbitPeriod;
  }

  /**
   *
   * @return returns the orbital speed of the satellite
   */

  public double getSpeed() {
    return speed;
  }

  /**
   *
   * @return returns the inclination of the satellite
   */

  public double getInclination() {
    return inclination;
  }

  /**
   *
   * @return returns the eccentricity of the satellite
   */

  public double getEccentricity() {
    return eccentricity;
  }

  /**
   *
   * @return returns the apogee position of the satellite
   */

  public double getApogee() {
    return apogee;
  }

  /**
   *
   * @return returns the perigee position of the satellite
   */


  public double getPerigee() {
    return perigee;
  }

  /**
   *
   * @return returns the objects id
   */

  public String getObjectId() {
    return objectId;
  }


  /**
   *
   * @return returns the satellite name
   */
  @Override
  public String toString() {
    return getSatName();
  }
}
