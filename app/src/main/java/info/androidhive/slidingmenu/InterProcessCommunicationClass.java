package info.androidhive.slidingmenu;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;

/**
 * Created by UNKNOWN on 6/25/2016.
 */
public class InterProcessCommunicationClass extends Service {

    Messenger messenger = new Messenger(new IncomingHandler());

    static final int JOB_1 = 1;
    static final int JOB_2 = 2;
    static final int JOB_1_RESPONSE = 3;
    static final int JOB_2_RESPONSE = 4;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return messenger.getBinder();
    }

    public class IncomingHandler extends Handler{

        @Override
        public void handleMessage(Message msg) {

            Message MSG;
            String message;
            Bundle bundle = new Bundle();

            switch (msg.what){
                case JOB_1:
                    message = "This is the first service";
                    MSG = Message.obtain(null,JOB_1_RESPONSE);
                    bundle.putString("RESPONSE_MESSAGE",message);
                    MSG.setData(bundle);
                    try {
                        msg.replyTo.send(MSG);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    break;

                case JOB_2:
                    message = "This is the second service";
                    MSG = Message.obtain(null,JOB_2_RESPONSE);
                    bundle.putString("RESPONSE_MESSAGE",message);
                    MSG.setData(bundle);
                    try {
                        msg.replyTo.send(MSG);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    break;

                default:
                    super.handleMessage(msg);
                    break;
            }

                    }
    }
}
