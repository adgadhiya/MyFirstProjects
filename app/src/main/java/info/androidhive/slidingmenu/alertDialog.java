package info.androidhive.slidingmenu;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class alertDialog extends AppCompatActivity {

    private CharSequence[] myChar = {"A","AA","AAA","AAAA","AAAAA","AAAAAA","AAAAAAA","AAAAAAA"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);

        Button btn = (Button)findViewById(R.id.btn);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final String[] name = {"Nothing is selected"};
        builder.setMultiChoiceItems(myChar, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if(isChecked){
                }
            }
        });


        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                Toast.makeText(alertDialog.this, name[0],Toast.LENGTH_SHORT).show();
            }
        });

        final AlertDialog alertDialog = builder.create();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.show();
            }
        });
    }
}