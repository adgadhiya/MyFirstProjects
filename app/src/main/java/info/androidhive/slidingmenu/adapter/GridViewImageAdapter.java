package info.androidhive.slidingmenu.adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.provider.ContactsContract;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by UNKNOWN on 6/30/2016.
 */
public class GridViewImageAdapter extends BaseAdapter {
    private Activity activity;
    private ArrayList<String> filePaths = new ArrayList<>();
    private int imageWidth;

    public GridViewImageAdapter(Activity activity,ArrayList<String> filePaths,int imageWidth){
        this.activity = activity;
        this.filePaths = filePaths;
        this.imageWidth = imageWidth;
    }




    @Override
    public int getCount() {
        return filePaths.size();
    }

    @Override
    public Object getItem(int position) {
        return filePaths.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if(convertView == null){
            imageView = new ImageView(activity);
        }else{
            imageView = (ImageView) convertView;
        }

        return null;
    }
}
