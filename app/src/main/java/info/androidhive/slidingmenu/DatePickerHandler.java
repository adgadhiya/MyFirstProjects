package info.androidhive.slidingmenu;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.Toast;

/**
 * Created by UNKNOWN on 6/22/2016.
 */
public class DatePickerHandler implements DatePickerDialog.OnDateSetListener {
    Context context;

    public DatePickerHandler(Context contex){
        this.context = contex;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        Toast.makeText(context,dayOfMonth+":"+ monthOfYear + ":" + year,Toast.LENGTH_SHORT).show();
    }
}
