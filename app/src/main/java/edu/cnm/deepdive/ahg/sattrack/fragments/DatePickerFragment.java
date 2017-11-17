package edu.cnm.deepdive.ahg.sattrack.fragments;

import static edu.cnm.deepdive.ahg.sattrack.fragments.NotesDialogFragment.DATE_FIELD_KEY;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.EditText;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

  private Callback callback = null;

  public DatePickerFragment(Callback callback) {
    this.callback = callback;
  }

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

  public interface Callback {
    void setResult(Calendar calendar);
  }
}
