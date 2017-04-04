package info.androidhive.slidingmenu;

import android.content.Context;
import android.view.MenuItem;
import android.widget.PopupMenu;
import android.widget.Toast;

/**
 * Created by UNKNOWN on 6/22/2016.
 */
public class PopUpMenuEventHandler implements android.support.v7.widget.PopupMenu.OnMenuItemClickListener {

    Context context;

     public PopUpMenuEventHandler(Context context){
          this.context = context;
      }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        Toast.makeText(context,item.getTitle() + " is selected",Toast.LENGTH_SHORT).show();
        return true;
    }
}