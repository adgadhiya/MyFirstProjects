package info.androidhive.slidingmenu;

import android.content.ClipData;
import android.content.ClipDescription;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class dragndrop extends AppCompatActivity {

    ImageView iv;
    String msg;
    private android.widget.RelativeLayout.LayoutParams layoutParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dragndrop);

        iv = (ImageView)findViewById(R.id.iv);

        iv.setOnLongClickListener(
                new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        ClipData.Item item = new ClipData.Item((CharSequence)v.getTag());
                        String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                        ClipData dragData = new ClipData(v.getTag().toString(),mimeTypes,item);
                        View.DragShadowBuilder myshadow = new View.DragShadowBuilder(iv);

                        v.startDrag(dragData,myshadow,null,0);
                        return  true;
                    }
                }
        );


        iv.setOnDragListener(
                new View.OnDragListener() {
                    @Override
                    public boolean onDrag(View v, DragEvent event) {
                        int x_cord,y_cord;
                        switch (event.getAction()){
                            case DragEvent.ACTION_DRAG_STARTED :
                                layoutParams = (RelativeLayout.LayoutParams)v.getLayoutParams();
                                break;
                            case DragEvent.ACTION_DRAG_ENTERED:
                               break;
                            case DragEvent.ACTION_DRAG_LOCATION:
                                break;
                            case DragEvent.ACTION_DRAG_ENDED:
                                break;
                            case DragEvent.ACTION_DROP:
                                x_cord = (int) event.getX();
                                y_cord = (int) event.getY();
                                layoutParams.leftMargin = x_cord;
                                layoutParams.topMargin = y_cord;
                                v.setLayoutParams(layoutParams);
                                break;
                            default:
                                break;
                        }

                        return true;
                    }
                }
        );

        iv.setOnTouchListener(
                new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if(event.getAction() == MotionEvent.ACTION_DOWN){
                            ClipData data = ClipData.newPlainText("","");
                            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(iv);

                            iv.startDrag(data,shadowBuilder,iv,0);
                            iv.setVisibility(View.VISIBLE);
                            return  true;
                        }else{
                            iv.setVisibility(View.VISIBLE);
                            return false;
                        }
                    }
                }
        );
    }
}
