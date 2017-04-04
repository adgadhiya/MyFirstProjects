package info.androidhive.slidingmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Contexual_Action_Mode extends AppCompatActivity {

    ImageView imageView;
    ActionMode actionMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contexual__action__mode);

        imageView = (ImageView)findViewById(R.id.image_view);

        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                if(actionMode != null){
                    return false;
                }
                else{
                    actionMode = startSupportActionMode(callback);
//                    actionMode = Contexual_Action_Mode.this.startSupportActionMode(callback);
                    return true;
                }
            }
        });

    }

    private ActionMode.Callback  callback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            getMenuInflater().inflate(R.menu.main,menu);
            mode.setTitle("One item selected");
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            //mode.setTitle("One item selected");
            Toast.makeText(Contexual_Action_Mode.this,"Prepare is called",Toast.LENGTH_SHORT).show();
            return true;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

              //mode.setTitle("One item selected");
//            Toast.makeText(Contexual_Action_Mode.this,"Prepare is called",Toast.LENGTH_SHORT).show();

            switch (item.getItemId()){
               case R.id.action_settings:
                   Toast.makeText(Contexual_Action_Mode.this,"Settings is selected",Toast.LENGTH_SHORT).show();
                   break;

               case R.id.edit_pref:
                   Toast.makeText(Contexual_Action_Mode.this,"Preference is selected",Toast.LENGTH_SHORT).show();
                   break;
           }


            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
                actionMode = null;
        }
    };
}
