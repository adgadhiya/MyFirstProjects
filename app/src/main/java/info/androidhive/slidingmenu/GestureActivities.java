package info.androidhive.slidingmenu;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

public class GestureActivities extends AppCompatActivity implements GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener {

    TextView textView;
    GestureDetectorCompat compat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_activities);

        textView = (TextView)findViewById(R.id.tvGesture);
        compat = new GestureDetectorCompat(getApplicationContext(),this);
        compat.setOnDoubleTapListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        compat.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        textView.setText("Single Tap Confirmed");
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        textView.setText("Double Tap");
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        textView.setText("Double Tap Confirmed");
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        textView.setText("Down Confirmed");
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        textView.setText("Show press Confirmed");

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        textView.setText("Single Tap Up Confirmed");
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        textView.setText("Scroll Confirmed");
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        textView.setText("Long Press Confirmed");

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        textView.setText("Fling Confirmed");
        return false;
    }
}
