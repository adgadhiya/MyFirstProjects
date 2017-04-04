package info.androidhive.slidingmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.Gravity;
import android.view.View;

public class PopUpMenuClass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_menu);
    }

    public void showpopup(View view){
        PopupMenu popupMenu = new PopupMenu(PopUpMenuClass.this,view,Gravity.RIGHT);
        getMenuInflater().inflate(R.menu.popup, popupMenu.getMenu());
        PopUpMenuEventHandler popUpMenuEventHandler = new PopUpMenuEventHandler(PopUpMenuClass.this);
        popupMenu.setOnMenuItemClickListener(popUpMenuEventHandler);
        popupMenu.show();
    }

}
