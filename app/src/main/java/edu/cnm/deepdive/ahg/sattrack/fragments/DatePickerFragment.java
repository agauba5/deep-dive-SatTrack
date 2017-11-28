package edu.cnm.deepdive.ahg.sattrack.fragments;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import java.util.Calendar;

/**
 * creates the date picker dialog fragment for the user selection of the date observed
 */
public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

  private Callback callback = null;

  public DatePickerFragment(){
    // empty constructor
  }

  /**
   *
   * @param callback sets the callback object in the context
   */
  public DatePickerFragment(Callback callback) {
    this.callback = callback;
  }

  /**
   * uses the saved instance to output the current calender information
   * @param savedInstanceState  contains the current date
   * @return returns the date picker dialog fragment with the date
   */
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    //use the current date as the default date
    final Calendar c = Calendar.getInstance();
    int year = c.get(Calendar.YEAR);
    int month = c.get(Calendar.MONTH);
    int day = c.get(Calendar.DAY_OF_MONTH);

    //create a new instance of DatePickerDialog and return it
    return new DatePickerDialog(getActivity(), this, year, month, day);
  }

  @Override
  public void onStart() {
    super.onStart();

  }


  @Override
  public void onDateSet(DatePicker view, int year, int month, int day) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.YEAR, year);
    calendar.set(Calendar.MONTH, month);
    calendar.set(Calendar.DAY_OF_MONTH, day);
    if (callback != null) {
      callback.setResult(calendar);
    }
  }

  /**
   * interface used to return the user selected calender information
   */
  public interface Callback {
    void setResult(Calendar calendar);
  }
}

