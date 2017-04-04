package info.androidhive.slidingmenu;

/**
 * Created by UNKNOWN on 6/17/2016.
 */
public class ListSetter {

    private int     poster_image;
    private String  name_image;
    private String  desc_image;


    public ListSetter(int poster_image,String name_image,String desc_image){

        this.setPoster_image(poster_image);
        this.setName_image(name_image);
        this.setDesc_image(desc_image);
    }

    public String getDesc_image() {
        return desc_image;
    }

    public void setDesc_image(String desc_image) {
        this.desc_image = desc_image;
    }

    public String getName_image() {
        return name_image;
    }

    public void setName_image(String name_image) {
        this.name_image = name_image;
    }

    public int getPoster_image() {
        return poster_image;
    }

    public void setPoster_image(int poster_image) {
        this.poster_image = poster_image;
    }
}
