package info.androidhive.slidingmenu;


import android.annotation.TargetApi;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ListView listView;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;

    private  Menu themenu;

    private String[] navMenuTitles;
    private TypedArray navMenuIcons;

    private ArrayList<NavDrawerItem> navDrawerItem;
    private NavDrawerListAdapter adapter;

    ActionBar actionBar;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        mDrawerTitle = mTitle = getTitle();
        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_item);
        navMenuIcons  = getResources().obtainTypedArray(R.array.nav_drawer_icon);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        listView = (ListView)findViewById(R.id.list_slidermenu);

        navDrawerItem = new ArrayList<NavDrawerItem>();

        navDrawerItem.add(new NavDrawerItem(navMenuTitles[0],navMenuIcons.getResourceId(0,-1)));
        navDrawerItem.add(new NavDrawerItem(navMenuTitles[1],navMenuIcons.getResourceId(0,-1)));
        navDrawerItem.add(new NavDrawerItem(navMenuTitles[2],navMenuIcons.getResourceId(0,-1)));
        navDrawerItem.add(new NavDrawerItem(navMenuTitles[3],navMenuIcons.getResourceId(0,-1),true,"22"));
        navDrawerItem.add(new NavDrawerItem(navMenuTitles[4],navMenuIcons.getResourceId(0,-1)));
        navDrawerItem.add(new NavDrawerItem(navMenuTitles[5],navMenuIcons.getResourceId(0,-1),true,"50+"));

        navMenuIcons.recycle();

        adapter = new NavDrawerListAdapter(this,navDrawerItem);
        listView.setAdapter(adapter);

        actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        drawerLayout.setDrawerTitle(Gravity.RIGHT,"My Drawer");

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.app_name,R.string.app_name){

            @Override
            public void onDrawerClosed(View drawerView) {
                actionBar.setTitle(mTitle);
                invalidateOptionsMenu();
            }
            @Override
            public void onDrawerOpened(View drawerView) {
                actionBar.setTitle(mTitle);
                invalidateOptionsMenu();
            }
        };

        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        listView.setOnItemClickListener(new SliderMenuClickListenr());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        themenu = menu;
        getMenuInflater().inflate(R.menu.main,themenu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        switch (item.getItemId()){
            case R.id.action_settings:
                return  true;
            default: return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean drawerOpen = drawerLayout.isDrawerOpen(listView);
        themenu.setGroupVisible(R.id.action_group,!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    public void setTitle (CharSequence title){
        mTitle = title;
        actionBar.setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }
/*
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

*/
    private class SliderMenuClickListenr implements ListView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            displayView(position);
        }

        private void displayView(int position){
            android.support.v4.app.Fragment fragment = null;

            switch (position){
                case 0:
                    fragment = new fragmentThree();
                    break;
                default: break;
            }

            if(fragment!=null){
                android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.frame_container,fragment).commit();

                listView.setItemChecked(position,true);
                listView.setSelection(position);
                setTitle(navMenuTitles[position]);
                drawerLayout.closeDrawer(listView);
            }else{
                Toast.makeText(MainActivity.this,"ERROR",Toast.LENGTH_LONG).show();
            }
        }
    }

}

