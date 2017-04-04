package info.androidhive.slidingmenu;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BinderMessangerClass extends AppCompatActivity implements View.OnClickListener {

    Messenger messenger = null;
    boolean isBind = false;

    Button button1,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binder_messanger_class);

        button1 = (Button)findViewById(R.id.hello);
        button1.setOnClickListener(BinderMessangerClass.this);

        button2 = (Button)findViewById(R.id.helloAgain);
        button2.setOnClickListener(BinderMessangerClass.this);

    }

    public void binding(View view){

        Intent intent = new Intent(this,MyMessangerService.class);
        bindService(intent,serviceConnection,BIND_AUTO_CREATE);

    }

    ServiceConnection serviceConnection  = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            messenger = new Messenger(service);
            isBind = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            messenger = null;
            isBind = false;
        }
    };

    @Override
    protected void onStop() {
        if(isBind){
            unbindService(serviceConnection);
            isBind = false;
            messenger = null;
        }
        super.onStop();
    }

    @Override
    public void onClick(View v) {
        Message message;
        if(isBind) {
            switch (v.getId()) {
                case R.id.hello:
                    message = Message.obtain(null,MyMessangerService.JOB_1,0,0,0);
                    try {
                        messenger.send(message);

                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }

                    break;

                case R.id.helloAgain:
                    message = Message.obtain(null, MyMessangerService.JOB_2, 0, 0, 0);
                    try {
                        messenger.send(message);

                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }

                    break;
            }
        }
        else {
            Toast.makeText(getApplicationContext(),"First Bind the Service",Toast.LENGTH_LONG).show();
        }

    }
}
