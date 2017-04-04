package info.androidhive.slidingmenu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by UNKNOWN on 6/30/2016.
 */
public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.MyViewHolder> {

    private Context ctx;
    private List<Album> albumList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView title,count;
        public ImageView thumbnail,overflow;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.title);
            count = (TextView)itemView.findViewById(R.id.count);
            thumbnail = (ImageView)itemView.findViewById(R.id.thumbnail);
            overflow = (ImageView)itemView.findViewById(R.id.overflow);
        }
    }

    public AlbumsAdapter(Context ctx,List<Album> albumList){

        this.ctx = ctx;
        this.albumList = albumList;

    }


    @Override
    public AlbumsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_card,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AlbumsAdapter.MyViewHolder holder, int position) {

        Album album = albumList.get(position);
        holder.title.setText(album.getName());
        holder.count.setText(album.getNumOfSongs() + " songs");

        Glide.with(ctx).load(album.getThumbnail()).into(holder.thumbnail);

        holder.overflow.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showPopupMenu(holder.overflow);
                    }
                }
        );
    }

    public void showPopupMenu(View view){
        PopupMenu popupMenu = new PopupMenu(ctx,view);
        popupMenu.getMenuInflater().inflate(R.menu.menu_album,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popupMenu.show();
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        MyMenuItemClickListener(){}

        @Override
        public boolean onMenuItemClick(MenuItem item) {

            switch (item.getItemId()){
                case R.id.action_add_favourite:
                    Toast.makeText(ctx,"Add to favourite",Toast.LENGTH_LONG).show();
                    return true;
                case R.id.action_play_next:
                    Toast.makeText(ctx,"Play Next",Toast.LENGTH_LONG).show();
                    return true;
            }
            return false;
        }
    }

}
