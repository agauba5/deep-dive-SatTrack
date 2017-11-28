package edu.cnm.deepdive.ahg.sattrack.entities;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@DatabaseTable(tableName = "SATELLITE_LOG")
public class SatLog {

  @DatabaseField(columnName = "LOG_NUMBER", generatedId = true, canBeNull = true)
  private int logNumber;

  @DatabaseField(columnName = "CREATED", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",
      format = "yyyy-MM-dd HH:mm:ss", canBeNull = false, readOnly = true)
  private Timestamp created;

  @DatabaseField(columnName = "DATE", format = "yyyy-MM-dd", canBeNull = false)
  private Date date;

  @DatabaseField(columnName = "NOTES", canBeNull = true)
  private String notes;

  @DatabaseField(columnName = "SATELLITE", canBeNull = false, foreign = true, foreignAutoRefresh = true)
  private Satellite satellite;


  /**
   *
   * @param date sets the date the user inputs for the day the object was observed
   */
  public void setDate(Date date) {
    this.date = date;
  }

  /**
   *
   * @param notes sets the users inputted notes
   */

  public void setNotes(String notes) {
    this.notes = notes;
  }

  /**
   *
   * @param satellite sets the satellite object to correlate with the satellites entity
   */

  public void setSatellite(Satellite satellite) {
    this.satellite = satellite;
  }

  /**
   *
   * @return returns the log number for the specific object
   */

  public int getLogNumber() {
    return logNumber;
  }

  /**
   *
   * @return returns the time stamp of the note creation
   */

  public Timestamp getCreated() {
    return created;
  }

  /**
   *
   * @return returns the date the user inputted as the date the object was observed
   */

  public Date getDate() {
    return date;
  }

  /**
   *
   * @return returns the notes input by the user
   */

  public String getNotes() {
    return notes;
  }

  /**
   *
   * @return returns the satellite object
   */

  public Satellite getSatellite() {
    return satellite;
  }


  @Override
  public String toString() {
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    return String.format("%s (%s)", format.format(date));
  }
}
