package info.androidhive.slidingmenu;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v4.app.ServiceCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BoundServiceClass extends AppCompatActivity {

    TextView textView;
    MyService myService;
    boolean isBind = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound_service_class);

        textView = (TextView)findViewById(R.id.textView3);
        Intent intent = new Intent(this,MyService.class);
        bindService(intent,serviceConnection,BIND_AUTO_CREATE);

    }

    public void firstMSG(View view){

        String MSG = myService.getFirstMessage();
        textView.setText(MSG);

    }

    public void secondMSG(View view){

        String MSG = myService.getSecondMessage();
        textView.setText(MSG);
    }


    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService.LocalService localService = (MyService.LocalService) service;
            myService = localService.getService();
            isBind = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBind = false;
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        if(isBind){
            isBind = false;
            unbindService(serviceConnection);
        }

    }
}
