package info.androidhive.slidingmenu;

/**
 * Created by UNKNOWN on 6/30/2016.
 */
public class Album {

    private String name;
    private int numOfSongs;
    private int thumbnail;

    public Album(){

    }

    public Album(String name,int numOfSongs,int thumbnail){
        this.setName(name);
        this.setNumOfSongs(numOfSongs);
        this.setThumbnail(thumbnail);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfSongs() {
        return numOfSongs;
    }

    public void setNumOfSongs(int numOfSongs) {
        this.numOfSongs = numOfSongs;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
