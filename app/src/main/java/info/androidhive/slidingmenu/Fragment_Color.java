package info.androidhive.slidingmenu;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;


public class Fragment_Color extends Fragment {

    RadioGroup radioGroup;
    OnColorChangeListener onColorChangeListener;
    LinearLayout linearLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_fragment__color,container,false);
        radioGroup = (RadioGroup)view.findViewById(R.id.colorGroup);

        linearLayout = (LinearLayout)view.findViewById(R.id.fragment_layout);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId){

                    case R.id.color_blue  :
                        onColorChangeListener.colorChanged("BLUE");
                        linearLayout.setBackgroundColor(Color.rgb(0,0,200));

                        break;

                    case R.id.color_red   :
                        linearLayout.setBackgroundColor(Color.rgb(200,0,0));
                        onColorChangeListener.colorChanged("RED");
                        break;

                    case R.id.color_green :
                        linearLayout.setBackgroundColor(Color.rgb(0,200,0));
                        onColorChangeListener.colorChanged("GREEN");
                        break;

                }
            }
        });
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            onColorChangeListener = (OnColorChangeListener) activity;
        }catch (Exception e){ }
    }

    public interface OnColorChangeListener{

        public void colorChanged(String color_name);

    }


}