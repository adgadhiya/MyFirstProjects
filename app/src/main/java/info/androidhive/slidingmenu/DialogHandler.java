package info.androidhive.slidingmenu;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import java.text.DateFormat;
import java.util.Calendar;

/**
 * Created by UNKNOWN on 6/18/2016.
 */
public class DialogHandler extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute=calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog;
        TimeSettings timeSettings = new TimeSettings(getActivity());

        timePickerDialog = new TimePickerDialog(getActivity(),timeSettings,hour,minute,
                                                android.text.format.DateFormat.is24HourFormat(getActivity()));
        return timePickerDialog;

    }
}
