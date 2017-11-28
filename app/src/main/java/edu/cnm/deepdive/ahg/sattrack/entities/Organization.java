package edu.cnm.deepdive.ahg.sattrack.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.HashMap;
import java.util.Map;

@DatabaseTable(tableName = "ORGANIZATION_DATA")
public class Organization {

  @DatabaseField(columnName ="ORGANIZATION_ID", generatedId = true)
  private int id;

  @Expose
  @SerializedName("COUNTRY")
  @DatabaseField(columnName = "COUNTRY", canBeNull = false)
  private String country;

  @Expose
  @SerializedName("SPADOC_CD")
  @DatabaseField(columnName = "SPADOC_CD", canBeNull = false, index = true)
  private String countryId;

  @Expose
  @SerializedName("ORBITAL_PAYLOAD_COUNT")
  @DatabaseField(columnName = "ORBITAL_PAYLOAD_COUNT", canBeNull = false)
  private int orbitalPayloadCount;

  @Expose
  @SerializedName("ORBITAL_ROCKET_BODY_COUNT")
  @DatabaseField(columnName = "ORBITAL_ROCKET_BODY_COUNT", canBeNull = false)
  private int orbitalRocketBodyCount;

  @Expose
  @SerializedName("ORBITAL_DEBRIS_COUNT")
  @DatabaseField(columnName = "ORBITAL_DEBRIS_COUNT", canBeNull = false)
  private int orbitalDebrisCount;

  @Expose
  @SerializedName("ORBITAL_TOTAL_COUNT")
  @DatabaseField(columnName = "ORBITAL_TOTAL_COUNT", canBeNull = false)
  private int orbitalTotalCount;

  @Expose
  @SerializedName("COUNTRY_TOTAL")
  @DatabaseField(columnName = "COUNTRY_TOTAL", canBeNull = false)
  private int countryTotalLaunched;

  /**
   *
   * @param country sets the country name
   */

  public void setCountry(String country) {
    this.country = country;
  }

  /**
   *
   * @param countryId sets the short name of the country
   */
  public void setCountryId(String countryId) {
    this.countryId = countryId;
  }

  /**
   *
   * @param orbitalPayloadCount  sets the number of payload objects in orbit for the country
   */
  public void setOrbitalPayloadCount(int orbitalPayloadCount) {
    this.orbitalPayloadCount = orbitalPayloadCount;
  }

  /**
   *
   * @param orbitalRocketBodyCount sets the number of rocket body objects in orbit for the country
   */
  public void setOrbitalRocketBodyCount(int orbitalRocketBodyCount) {
    this.orbitalRocketBodyCount = orbitalRocketBodyCount;
  }

  /**
   *
   * @param orbitalDebrisCount sets the number of debris objects in orbit for the country
   */

  public void setOrbitalDebrisCount(int orbitalDebrisCount) {
    this.orbitalDebrisCount = orbitalDebrisCount;
  }

  /**
   *
   * @param orbitalTotalCount sets the total number of objects in orbit for the country
   */
  public void setOrbitalTotalCount(int orbitalTotalCount) {
    this.orbitalTotalCount = orbitalTotalCount;
  }

  /**
   *
   * @param countryTotalLaunched sets the total number of objects launched by the country
   */

  public void setCountryTotalLaunched(int countryTotalLaunched) {
    this.countryTotalLaunched = countryTotalLaunched;
  }


  /**
   *
   * @return returns the generated id correlated to the country
   */

  public int getId() {
    return id;
  }

  /**
   *
   * @return returns the country name
   */
  public String getCountry() {
    return country;
  }


  /**
   *
   * @return returns the short name of the country
   */
  public String getCountryId() {
    return countryId;
  }

  /**
   *
   * @return returns the number of payload objects in orbit for the country
   */
  public int getOrbitalPayloadCount() {
    return orbitalPayloadCount;
  }

  /**
   *
   * @return returns the number of rocket body objects in orbit for the country
   */
  public int getOrbitalRocketBodyCount() {
    return orbitalRocketBodyCount;
  }

  /**
   *
   * @return returns the number of debris objects in orbit for the country
   */

  public int getOrbitalDebrisCount() {
    return orbitalDebrisCount;
  }

  /**
   *
   * @return returns the total number of objects in orbit for the country
   */

  public int getOrbitalTotalCount() {
    return orbitalTotalCount;
  }

  /**
   *
   * @return returns the total number of objects launced by the country
   */

  public int getCountryTotalLaunched() {
    return countryTotalLaunched;
  }

  /**
   *
   * @return returns the country name
   */
  @Override
  public String toString() {
  return getCountry();

  }
}
