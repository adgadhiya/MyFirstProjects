package info.androidhive.slidingmenu;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by UNKNOWN on 6/25/2016.
 */
public class MyService extends Service {

    private final IBinder mBinder = new LocalService();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public class LocalService extends Binder{
        public MyService getService(){
            return MyService.this;
        }
    }

    public String getFirstMessage(){
        return  "Hello Welcome";
    }

    public String getSecondMessage(){
        return  "Bound Service Example";
    }

}
