package info.androidhive.slidingmenu;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NotificationServices extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_services);

            button = (Button) findViewById(R.id.btnNoti);

            button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(NotificationServices.this,alertDialog.class);
                        PendingIntent pIntent = PendingIntent.getActivity(NotificationServices.this,0,intent,0);

                        Notification noti = null;
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
                            noti = new Notification.Builder(NotificationServices.this).
                                                                    setContentTitle("Content Title").
                                                                    setTicker("This is Ticker").
                                                                    setContentText("Content Text").
                                                                    addAction(R.mipmap.ic_launcher,"Action 1",pIntent).
                                                                    setAutoCancel(true).setSmallIcon(R.mipmap.ic_launcher).
                                                                    setContentIntent(pIntent).getNotification();
                        }
                        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                        nm.notify(0,noti);

                    }
                }
        );

    }
}
