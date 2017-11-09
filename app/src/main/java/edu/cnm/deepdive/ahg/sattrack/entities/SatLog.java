package edu.cnm.deepdive.ahg.sattrack.entities;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@DatabaseTable(tableName = "SATELLITE_LOG")
public class SatLog {

  @DatabaseField(columnName = "LOG_NUMBER", generatedId = true)
  private int logNumber;

  @DatabaseField(columnName = "CREATED", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",
      format = "yyyy-MM-dd HH:mm:ss", canBeNull = false, readOnly = true)
  private Timestamp created;

  @DatabaseField(columnName = "DATE", format = "yyyy-MM-dd", canBeNull = false)
  private Date date;

  @DatabaseField(columnName = "NOTES", canBeNull = true)
  private String notes;

  @DatabaseField(columnName = "SATNAME", canBeNull = false, foreign = true)
  private Satellite satName;


  public int getLogNumber() {
    return logNumber;
  }

  public Timestamp getCreated() {
    return created;
  }


  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public Satellite getSatName() {
    return satName;
  }

  public void setSatName(Satellite satName) {
    this.satName = satName;
  }

  @Override
  public String toString() {
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    return String.format("%s (%s)", format.format(date));
  }
}
