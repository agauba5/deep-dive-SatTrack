package edu.cnm.deepdive.ahg.sattrack.fragments;


import android.app.AlertDialog;
import android.app.Dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.j256.ormlite.dao.Dao;
import edu.cnm.deepdive.ahg.sattrack.R;
import edu.cnm.deepdive.ahg.sattrack.entities.SatLog;
import edu.cnm.deepdive.ahg.sattrack.helpers.OrmHelper;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Calendar;


public class NotesDialogFragment extends DialogFragment implements OnClickListener, DatePickerFragment.Callback {

  public static final String DATE_FIELD_KEY = "date_observed";
  private OrmHelper helper = null;
  private EditText dateObserved;
  private View notesLog;
  private View noteInput;
  private SatLog satLog;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // TODO get satellite id from args and load satellite objects from the dao
    helper = ((OrmHelper.OrmInteraction) getActivity()).getHelper();

    try {
      Dao<SatLog, Integer> satLogsDao = helper.getSatLogDao();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }


  private View inflateView(LayoutInflater inflater) {

    notesLog = inflater.inflate(R.layout.note_log, null, false);
    noteInput = notesLog.findViewById(R.id.note_input);
    dateObserved = notesLog.findViewById(R.id.date_observed);
    dateObserved.setFocusable(false);
    dateObserved.setClickable(true);

    dateObserved.setOnClickListener(this);

    return notesLog;
  }

  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    //TODO associate actions with positive and negative buttons, see: https://developer.android.com/reference/android/app/DialogFragment.html#AlertDialog
//    return super.onCreateDialog(savedInstanceState);
    View layout = inflateView(getActivity().getLayoutInflater());
    return new AlertDialog.Builder(getActivity()).setView(layout)
                                    .setPositiveButton("Save",
                                        new DialogInterface.OnClickListener() {
                                          @Override
                                          public void onClick(DialogInterface dialogInterface,
                                              int i) {
                                            //TODO save notes
                                          }
                                        })
                                    .setNegativeButton("Cancel",
                                        new DialogInterface.OnClickListener() {
                                          @Override
                                          public void onClick(DialogInterface dialogInterface,
                                              int i) {
                                            // do nothing
                                          }
                                        })
                                    .create();
  }


  @Override

  public void onStart() {
    super.onStart();

  }

  @Override
  public void onClick(View view) {

    Bundle bundle = new Bundle();
    bundle.putInt(DATE_FIELD_KEY, view.getId());
    DialogFragment newFragment = new DatePickerFragment(this);
    newFragment.setArguments(bundle);
    newFragment.show(getFragmentManager(), "DatePicker");

  }


  @Override
  public void setResult(Calendar calendar) {
    DateFormat format = DateFormat.getDateInstance();
     dateObserved.setText(format.format(calendar.getTime()));
  }
}
