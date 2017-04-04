package info.androidhive.slidingmenu;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class Activity_Fragment_Communication extends AppCompatActivity implements Fragment_Color.OnColorChangeListener {

    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity__fragment__communication);

        linearLayout = (LinearLayout)findViewById(R.id.Linear_Communication_layout);

        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction ft = fragmentManager.beginTransaction();
        Fragment_Color fragment_color = new Fragment_Color();
        ft.add(R.id.fragment_container,fragment_color);
        ft.commit();
    }

    @Override
    public void colorChanged(String color_name) {

        switch (color_name) {
            case "RED" :
                linearLayout.setBackgroundColor(Color.RED);
                break;

            case "GREEN":
                linearLayout.setBackgroundColor(Color.GREEN);
                break;

            case "BLUE":
                linearLayout.setBackgroundColor(Color.BLUE);
                break;
        }

    }
}
