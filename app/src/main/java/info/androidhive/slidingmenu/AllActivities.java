package info.androidhive.slidingmenu;

import android.app.Activity;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AllActivities extends Activity {
    ListView listView;
    static final String[] activities = {"MainActivity","HttpReq","AudioPlayer ","XmlParser","dragndrop","alertDialog",
                                        "animatinacti"," clipboard_activity","jsonParsing","Connectivity","preference_acti",
                                        "fav_Pref","Custom_Layout","TimeDialogMain","Date_Picker_Main",
                                        "Contexual_Action_Mode","ListViewContexualMode","PopUpMenuClass",
                                        "Activity_Fragment_Communication","Fragment_Fragment_Communication","BoundServiceClass",
                                        "BinderMessangerClass","IPCMainClass","GestureActivities","NotificationServices"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_activities);

        listView = (ListView)findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,activities);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String myActivity = activities[position];
                        try {
                            Class myClass=Class.forName("info.androidhive.slidingmenu."+myActivity);
                            Intent intent = new Intent(AllActivities.this,myClass);
                            startActivity(intent);

                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }}
                }
        );

            }
}