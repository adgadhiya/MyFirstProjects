package info.androidhive.slidingmenu;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListProviderAdapter extends ArrayAdapter {

    List list = new ArrayList();

    public ListProviderAdapter(Context context,int resource){
            super(context,resource);
    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }

    static class DataHandler{
        ImageView poster;
        TextView title;
        TextView desc;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        DataHandler dataHandler;
        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.activity_list_provider,parent,false);

            dataHandler = new DataHandler();
            dataHandler.poster = (ImageView) view.findViewById(R.id.list_poster);
            dataHandler.title = (TextView)view.findViewById(R.id.name);
            dataHandler.desc = (TextView)view.findViewById(R.id.description);
            view.setTag(dataHandler);
        }
        else
        {
            dataHandler = (DataHandler) view.getTag();
        }

        ListSetter listSetter = (ListSetter) this.getItem(position);
        dataHandler.poster.setImageResource(listSetter.getPoster_image());
        dataHandler.title.setText(listSetter.getName_image());
        dataHandler.desc.setText(listSetter.getDesc_image());

        return view;

    }
}
