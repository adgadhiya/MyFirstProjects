package info.androidhive.slidingmenu;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;


public class Data_provider_Fragment extends Fragment {

    EditText editText;
    Button button;

    CommunicationFragment communicationFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_data_provider_, container, false);

        editText = (EditText)view.findViewById(R.id.etData);
        button = (Button)view.findViewById(R.id.submit_data);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = editText.getText().toString();
                communicationFragment.setData(name);

                InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(editText.getWindowToken(),0);
            }
        });
        return view;
    }

    public interface CommunicationFragment{
        public void setData(String name);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            communicationFragment = (CommunicationFragment) activity;
        }catch(Exception e) {}
    }
}
