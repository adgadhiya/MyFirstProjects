package info.androidhive.slidingmenu;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class IPCMainClass extends AppCompatActivity implements View.OnClickListener {

    static final int JOB_1 = 1;
    static final int JOB_2 = 2;
    static final int JOB_1_RESPONSE = 3;
    static final int JOB_2_RESPONSE = 4;

    Messenger messenger = null;
    boolean isBind = false;

    Button btn1,btn2;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipcmain_class);

        btn1 = (Button)findViewById(R.id.button5);
        btn2 = (Button)findViewById(R.id.button7);

        tv = (TextView)findViewById(R.id.textView4);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

        Intent intent = new Intent(this,InterProcessCommunicationClass.class);
        bindService(intent,serviceConnection,BIND_AUTO_CREATE);

    }

    public class ResponseHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            String message;
            switch (msg.what){

                case JOB_1_RESPONSE:
                    message = msg.getData().getString("RESPONSE_MESSAGE");
                    tv.setText(message);
                    break;
                case JOB_2_RESPONSE:
                    message = msg.getData().getString("RESPONSE_MESSAGE");
                    tv.setText(message);
                    break;

            }

            super.handleMessage(msg);
        }
    }


    ServiceConnection serviceConnection = new ServiceConnection() {
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

        Message MSG;

        switch (v.getId()){

            case R.id.button5:
                MSG = Message.obtain(null,JOB_1);
                MSG.replyTo = new Messenger(new ResponseHandler());
                try {
                    messenger.send(MSG);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;

            case R.id.button7:
                MSG = Message.obtain(null,JOB_2);
                MSG.replyTo = new Messenger(new ResponseHandler());
                try {
                     messenger.send(MSG);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
        }


    }

}
