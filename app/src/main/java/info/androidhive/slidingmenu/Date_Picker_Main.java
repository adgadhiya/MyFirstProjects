package info.androidhive.slidingmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Date_Picker_Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date__picker__main);
    }

    public void datePicker(View view){

        PickerDate pickerDate = new PickerDate();

        pickerDate.show(getSupportFragmentManager(),"MY_DATE_PICKER");
    }
}
