package info.androidhive.slidingmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewContexualMode extends AppCompatActivity {

    ListView listView;
    ArrayAdapter arrayAdapter;
    String[] list;
    int counter = 0;
    List names = new ArrayList();

    List selectiion = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_contexual_mode);

        listView = (ListView)findViewById(R.id.list_view);
        list = getResources().getStringArray(R.array.name_array);

        for(String name : list){
            names.add(name);
        }

        arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,names);

        listView.setAdapter(arrayAdapter);

        listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);

        listView.setMultiChoiceModeListener(
                new AbsListView.MultiChoiceModeListener() {
                    @Override
                    public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {

                        if(checked){
                            counter++;
                            selectiion.add(names.get(position));
                        }
                        else{
                            counter--;
                            selectiion.remove(names.get(position));
                        }

                        mode.setTitle(counter + " item selected");

                    }

                    @Override
                    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                        getMenuInflater().inflate(R.menu.my_menu,menu);
                        return true;
                    }

                    @Override
                    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                        return false;
                    }

                    @Override
                    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

                        switch (item.getItemId()){
                            case R.id.delete:

                                for(Object obj : selectiion ){

                                    String name = obj.toString();

                                    names.remove(name);
                                    arrayAdapter.notifyDataSetChanged();
                                    mode.finish();
                                }

                                break;

                            case R.id.search:
                                Toast.makeText(ListViewContexualMode.this,"Search selected",Toast.LENGTH_SHORT).show();
                                break;
                        }

                        return false;
                    }

                    @Override
                    public void onDestroyActionMode(ActionMode mode) {
                        counter = 0 ;
                        selectiion = null;
                    }
                }
        );


    }
}
