package info.androidhive.slidingmenu;

import android.content.res.Resources;
import android.graphics.Rect;
import android.media.Image;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class CardViewActivities extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AlbumsAdapter adapter;
    private List<Album> albumList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view_activities);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initCollapsingToolbar();

        recyclerView =(RecyclerView)findViewById(R.id.recycler_view);

        albumList = new ArrayList<>();

        adapter = new AlbumsAdapter(this,albumList);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2,dpToPx(10),true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareAlbums();

        Glide.with(this).load(R.mipmap.first3).into((ImageView)findViewById(R.id.backdrop));
    }

    private void initCollapsingToolbar(){

        final CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collepsing_toolbar);
        collapsingToolbarLayout.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout)findViewById(R.id.appbar);
        appBarLayout.setEnabled(true);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                if(scrollRange == -1){
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if(scrollRange + verticalOffset == 0){
                    collapsingToolbarLayout.setTitle(getString(R.string.app_name));
                    isShow = true;
                }
                else if(isShow){
                    collapsingToolbarLayout.setTitle("");
                    isShow = false;
                }
            }
        });
    }

    private void prepareAlbums(){

        int[] covers = new int[]{
                R.mipmap.first3,
                R.mipmap.first,
                R.mipmap.first4,
                R.mipmap.first5,
                R.mipmap.first2,
                R.mipmap.first6,
                R.mipmap.first,
                R.mipmap.first5,
                R.mipmap.first6,
                R.mipmap.first4,
                R.mipmap.first3};

        Album a = new Album("True Romance",13,covers[0]);
        albumList.add(a);
        a = new Album("Xscpae",8,covers[1]);
        albumList.add(a);
        a = new Album("Maroon 5",11,covers[2]);
        albumList.add(a);
        a = new Album("Born to Die",12,covers[3]);
        albumList.add(a);
        a = new Album("Honeymoon",14,covers[4]);
        albumList.add(a);
        a = new Album("I need a Doctor",1,covers[5]);
        albumList.add(a);
        a = new Album("Loud",11,covers[6]);
        albumList.add(a);
        a = new Album("Legend",14,covers[7]);
        albumList.add(a);
        a = new Album("Hello",11,covers[8]);
        albumList.add(a);
        a = new Album("Greatest Hits",17,covers[9]);
        albumList.add(a);

        adapter.notifyDataSetChanged();
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration{
        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount,int spacing,boolean includeEdge){
            this.spacing = spacing;
            this.spanCount = spanCount;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view);
            int column = position % spanCount;

            if(includeEdge)
            {
                outRect.left = spacing - column*spacing / spanCount;
                outRect.right=(column + 1) * spacing / spanCount;

                if(position < spanCount){
                    outRect.top = spacing;
                }
                outRect.bottom = spacing;
            } else {
                outRect.left = column * spacing /spanCount;
                outRect.right = spacing - (column + 1) * spacing / spanCount;
                if(position >= spanCount){
                    outRect.top = spacing;
                }
            }
        }
    }

    private int dpToPx(int dp){
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp,r.getDisplayMetrics()));
    }

}

