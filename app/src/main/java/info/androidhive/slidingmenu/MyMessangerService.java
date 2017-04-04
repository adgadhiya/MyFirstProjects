package info.androidhive.slidingmenu;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by UNKNOWN on 6/25/2016.
 */
public class MyMessangerService extends Service {

    Messenger messenger = new Messenger(new IncomingHandler());

    static final int JOB_1 = 1;
    static final int JOB_2 = 2;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(getApplicationContext(),"Service Binded",Toast.LENGTH_LONG).show();
        return messenger.getBinder();
    }
    public class IncomingHandler extends Handler{

        @Override
        public void handleMessage(Message msg) {

            switch(msg.what){
                case JOB_1:
                    Toast.makeText(getApplicationContext(),"Hello From JOB 1",Toast.LENGTH_LONG).show();
                    break;

                case JOB_2:
                    Toast.makeText(getApplicationContext(),"Hello From JOB 2",Toast.LENGTH_LONG).show();
                    break;

                default:
                    super.handleMessage(msg);
                    break;
            }

        }
    }


}
