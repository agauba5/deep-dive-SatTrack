package edu.cnm.deepdive.ahg.sattrack.fragments;



import android.support.v4.app.DialogFragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import edu.cnm.deepdive.ahg.sattrack.R;


/**
 * A simple {@link Fragment} subclass. Activities that contain this fragment must implement the
 * {@link DisplaySatFragment.OnFragmentInteractionListener} interface to handle interaction events.
 * Use the {@link DisplaySatFragment#newInstance} factory method to create an instance of this
 * fragment.
 */
public class DisplaySatFragment extends Fragment  implements View.OnClickListener {
    private View rootView;
    private View notesBtn;
    private View favoritesBtn;
    private View trackBtn;


  // TODO: Rename and change types of parameters

  private OnFragmentInteractionListener mListener;

  public DisplaySatFragment() {
    // Required empty public constructor
  }

  // TODO: Rename and change types and number of parameters
  public static DisplaySatFragment newInstance(String param1, String param2) {
    DisplaySatFragment fragment = new DisplaySatFragment();
    Bundle args = new Bundle();
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {

    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_display_sat, container, false);
        notesBtn = rootView.findViewById(R.id.notes_button);
        favoritesBtn = rootView.findViewById(R.id.favorites_button);
        trackBtn = rootView.findViewById(R.id.track_button);

        notesBtn.setOnClickListener(this);
        favoritesBtn.setOnClickListener(this);
        trackBtn.setOnClickListener(this);

    return rootView;
  }

  // TODO: Rename method, update argument and hook method into UI event
  public void onButtonPressed(Uri uri) {
    if (mListener != null) {
      mListener.onFragmentInteraction(uri);
    }
  }

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    if (context instanceof OnFragmentInteractionListener) {
      mListener = (OnFragmentInteractionListener) context;
    } else {
      throw new RuntimeException(context.toString()
          + " must implement OnFragmentInteractionListener");
    }
  }

  @Override
  public void onDetach() {
    super.onDetach();
    mListener = null;
  }

  @Override
  public void onClick(View view) {
    DialogFragment fragment = new NotesDialogFragment();
    fragment.show(getFragmentManager(), fragment.getClass().getSimpleName());

  }

  /**
   * This interface must be implemented by activities that contain this fragment to allow an
   * interaction in this fragment to be communicated to the activity and potentially other fragments
   * contained in that activity. <p> See the Android Training lesson <a href=
   * "http://developer.android.com/training/basics/fragments/communicating.html" >Communicating with
   * Other Fragments</a> for more information.
   */
  public interface OnFragmentInteractionListener {

    void onFragmentInteraction(Uri uri);
  }

}
