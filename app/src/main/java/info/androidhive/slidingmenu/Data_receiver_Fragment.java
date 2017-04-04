package info.androidhive.slidingmenu;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Data_receiver_Fragment extends Fragment {

    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_data_receiver_, container, false);

        textView = (TextView)view.findViewById(R.id.received_data);
        textView.setVisibility(View.GONE);
        return view;
    }

    public void updateInfo(String name){
        textView.setText("Welcome " +name);
        textView.setVisibility(View.VISIBLE);
    }

}
