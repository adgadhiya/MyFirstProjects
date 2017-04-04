package info.androidhive.slidingmenu;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by UNKNOWN on 6/5/2016.
 */
public class NavDrawerListAdapter extends BaseAdapter {
   private Context context;
    private ArrayList<NavDrawerItem> navDrawerItem = null;

    public NavDrawerListAdapter(Context context, ArrayList<NavDrawerItem> navDrawerItem){
        this.context = context;
        this.navDrawerItem = navDrawerItem;
    }

    @Override
    public int getCount() {
        return navDrawerItem.size();
    }

    @Override
    public Object getItem(int position) {
        return navDrawerItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.drawer_list_item,parent,false);
            ImageView iv = (ImageView)convertView.findViewById(R.id.icon);
            TextView title = (TextView)convertView.findViewById(R.id.title);
            TextView counter = (TextView)convertView.findViewById(R.id.counter);

            iv.setImageResource(navDrawerItem.get(position).getIcon());
            title.setText(navDrawerItem.get(position).gettitle());

            if(navDrawerItem.get(position).getCounterVisibility()){
                counter.setText(navDrawerItem.get(position).getCount());
            }else{
                counter.setVisibility(View.GONE);
            }
        }
        return convertView;
    }
}
