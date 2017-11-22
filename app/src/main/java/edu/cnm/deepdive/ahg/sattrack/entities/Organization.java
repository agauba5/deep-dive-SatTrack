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

  public int getId() {
    return id;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public void setCountryId(String countryId) {
    this.countryId = countryId;
  }

  public void setOrbitalPayloadCount(int orbitalPayloadCount) {
    this.orbitalPayloadCount = orbitalPayloadCount;
  }

  public void setOrbitalRocketBodyCount(int orbitalRocketBodyCount) {
    this.orbitalRocketBodyCount = orbitalRocketBodyCount;
  }

  public void setOrbitalDebrisCount(int orbitalDebrisCount) {
    this.orbitalDebrisCount = orbitalDebrisCount;
  }

  public void setOrbitalTotalCount(int orbitalTotalCount) {
    this.orbitalTotalCount = orbitalTotalCount;
  }

  public int getCountryTotalLaunched() {
    return countryTotalLaunched;
  }

  public void setCountryTotalLaunched(int countryTotalLaunched) {
    this.countryTotalLaunched = countryTotalLaunched;
  }

  public String getCountryId() {
    return countryId;
  }

  public int getOrbitalPayloadCount() {
    return orbitalPayloadCount;
  }

  public int getOrbitalRocketBodyCount() {
    return orbitalRocketBodyCount;
  }

  public int getOrbitalDebrisCount() {
    return orbitalDebrisCount;
  }

  public int getOrbitalTotalCount() {
    return orbitalTotalCount;
  }

  public int getCountryTotal() {
    return countryTotalLaunched;
  }

  @Override
  public String toString() {
  return getCountry();

  }
}
