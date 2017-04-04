package info.androidhive.slidingmenu;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;

public class Fragment_Fragment_Communication extends AppCompatActivity implements Data_provider_Fragment.CommunicationFragment {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment__fragment__communication);
    }

    @Override
    public void setData(String name) {
        Data_receiver_Fragment data_receiver_fragment = (Data_receiver_Fragment)getSupportFragmentManager().findFragmentById(R.id.fragment_two);
        data_receiver_fragment.updateInfo(name);
    }
}
