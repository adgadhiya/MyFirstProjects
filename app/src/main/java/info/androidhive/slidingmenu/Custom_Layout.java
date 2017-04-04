package info.androidhive.slidingmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Custom_Layout extends AppCompatActivity {

    ListView listView;

    int[] poster_resource ={R.mipmap.first,
                            R.mipmap.first2,
                            R.mipmap.first3,
                            R.mipmap.first4,
                            R.mipmap.first5,
                            R.mipmap.first6,
                            R.mipmap.first3,
                            R.mipmap.first2,
                            R.mipmap.first5};

    String[] names;
    String [] descripton;

    ListProviderAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom__layout);

        listView = (ListView)findViewById(R.id.custom_listview);

        names = getResources().getStringArray(R.array.name_array);
        descripton=getResources().getStringArray(R.array.description_array);

        int i=0;

        adapter = new ListProviderAdapter(getApplicationContext(),R.layout.activity_list_provider);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view.setSelected(true);
            }
        });

        for(String name : names){

            ListSetter listSetter = new ListSetter(poster_resource[i],name,descripton[i]);

            adapter.add(listSetter);

            i++;
        }
    }
}