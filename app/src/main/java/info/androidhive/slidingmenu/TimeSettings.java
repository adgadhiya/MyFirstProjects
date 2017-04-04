package info.androidhive.slidingmenu;

import android.app.TimePickerDialog;
import android.content.Context;
import android.widget.TimePicker;
import android.widget.Toast;

/**
 * Created by UNKNOWN on 6/18/2016.
 */
public class TimeSettings implements TimePickerDialog.OnTimeSetListener {
    Context context;
    public TimeSettings(Context context){
        this.context = context;
    }


    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Toast.makeText(context,"time is "+ hourOfDay + "/" + minute , Toast.LENGTH_LONG).show();

    }
}
