package info.androidhive.slidingmenu.helper;

import android.content.Context;
import android.graphics.Point;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by UNKNOWN on 6/30/2016.
 */
public class Utils {

    private Context context;

    public Utils(Context context){
        this.context = context;
    }

    public ArrayList<String> getFilePath(){

        ArrayList<String> filePaths = new ArrayList<>();

        File directory = new File(Environment.getExternalStorageDirectory() + File.separator + AppConstant.PHOTO_ALBUM);

        if(directory.isDirectory()){

            File[] listfiles = directory.listFiles();

            if(listfiles.length > 0){
                for(int i=0 ; i<listfiles.length ; i++){
                    String filePath = listfiles[i].getAbsolutePath();

                    if(IsSupportedFile(filePath)){
                        filePaths.add(filePath);
                    }
                }
            }else{

                Toast.makeText(context,AppConstant.PHOTO_ALBUM + "is Empty",Toast.LENGTH_SHORT).show();
            }
        }else{
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("ERROR!!!");
            builder.setMessage(AppConstant.PHOTO_ALBUM + " directory path is not available");
            builder.setPositiveButton("OK",null);
            builder.show();
        }
        return filePaths;
    }

    private boolean IsSupportedFile(String filePath){
        String ext = filePath.substring((filePath.lastIndexOf(".")+1),filePath.length());

        if(AppConstant.PHOTO_ALBUM.contains(ext.toLowerCase(Locale.getDefault()))) return true;

        else return false;
    }

    public int getScreenWidth(){
        int columnWidth;

        WindowManager wm = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();

        final Point point = new Point();

        try {
            display.getSize(point);
        }catch (java.lang.NoSuchMethodError ignore){
            point.x = display.getWidth();
            point.y = display.getHeight();
        }

        columnWidth =   point.x;

        return columnWidth;
    }
}
