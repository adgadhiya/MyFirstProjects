package info.androidhive.slidingmenu;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by UNKNOWN on 6/5/2016.
 */
public class NavDrawerItem extends AppCompatActivity {
    private String title;
    private int icon;
    private String count = "0";

    private boolean isCounterVisible = false;
    public  NavDrawerItem(){};

    public NavDrawerItem(String title,int icon){
        this.title = title;
        this.icon = icon;
    }

    public NavDrawerItem(String title,int icon,boolean isCounterVisible,String count){
        this.title = title;
        this.icon = icon;
        this.count = count;
        this.isCounterVisible = isCounterVisible;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public boolean getCounterVisibility() {
        return isCounterVisible;
    }

    public void setCounterVisible(boolean counterVisible) {
        isCounterVisible = counterVisible;
    }

    public String gettitle() {
        return title;
    }

    public void settitle(String title) {
        this.title = title;
    }

}
