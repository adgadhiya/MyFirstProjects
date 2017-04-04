package info.androidhive.slidingmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.ImageView;

public class animatinacti extends AppCompatActivity implements View.OnClickListener {


    ImageView imageView;
    Button clockwise,fade,zoom,move,blink,slide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animatinacti);
        imageView = (ImageView)findViewById(R.id.imageView);
        imageView.setImageResource(R.mipmap.ic_launcher);

        clockwise = (Button)findViewById(R.id.clockwise);
        slide = (Button)findViewById(R.id.slide);
        blink = (Button)findViewById(R.id.blink);
        move = (Button)findViewById(R.id.move);
        zoom = (Button)findViewById(R.id.zoom);
        fade = (Button)findViewById(R.id.fade);

        clockwise.setOnClickListener(this);
        slide.setOnClickListener(this);
        blink.setOnClickListener(this);
        move.setOnClickListener(this);
        zoom.setOnClickListener(this);
        fade.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        final Animation[] animation = new Animation[1];
      final  View view  = v;

                switch (view.getId()){
                    case R.id.zoom :
                        animation[0] = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom);
                        imageView.startAnimation(animation[0]);
                        break;
                    case R.id.blink :
                        animation[0] = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
                        imageView.startAnimation(animation[0]);
                        break;
                    case R.id.move :
                        animation[0] = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
                        imageView.startAnimation(animation[0]);
                        break;
                    case R.id.fade :
                        animation[0] = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
                        imageView.startAnimation(animation[0]);
                        break;
                    case R.id.clockwise :
                        animation[0] = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.clockwise);
                        imageView.startAnimation(animation[0]);
                        break;
                    case R.id.slide :
                        animation[0] = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide);
                        imageView.startAnimation(animation[0]);
                        break;
                }
            }

    }

