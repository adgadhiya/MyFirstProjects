package info.androidhive.slidingmenu;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.zip.Inflater;

public class preference_acti extends AppCompatActivity {

    private TextView checkbox = null;
    private TextView ringtone = null;
    private TextView checkbox2 = null;
    private TextView text = null;
    private TextView list = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference_acti);

        checkbox = (TextView) findViewById(R.id.chkbox);
        ringtone = (TextView) findViewById(R.id.ringtone);
        checkbox2 = (TextView) findViewById(R.id.chkbox2);
        text = (TextView) findViewById(R.id.txt);
        list = (TextView) findViewById(R.id.list);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        checkbox.setText(new Boolean(preferences.getBoolean("checkbox", false)).toString());
        checkbox2.setText(new Boolean(preferences.getBoolean("checkbox2", false)).toString());
        ringtone.setText(preferences.getString("ringtone", "<unset>"));
        text.setText(preferences.getString("text", "<unset>"));
        list.setText(preferences.getString("list", "<unset>"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.edit_pref) {
            startActivity(new Intent(preference_acti.this, EditPreferences.class));
            return true;
        }

        if(item.getItemId() == R.id.action_settings){

            Toast.makeText(preference_acti.this, "Setting is selected", Toast.LENGTH_SHORT).show();


        }

        return super.onOptionsItemSelected(item);
    }
}
