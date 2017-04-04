package info.androidhive.slidingmenu;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Connectivity extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private Bitmap bitmap = null;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connectivity);


        b1 = (Button)findViewById(R.id.button4);

        b1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        checkInternetConnection();
                        downloadImage("http://www.tutorialspoint.com/green/images/logo.png");
                    }
                }
        );
    }

    private void downloadImage(String s) {
        progressDialog = ProgressDialog.show(this,"Image","Downloading Image from " + s);
        progressDialog.setCancelable(true);
        final String url = s;


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                InputStream is;

                Message msg = Message.obtain();
                msg.what = 1;
                try{
                    is = openHttpConnection(url);
                    bitmap = BitmapFactory.decodeStream(is);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("bitmap",bitmap);
                    msg.setData(bundle);
                    is.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
                messageHandler.sendMessage(msg);
            }
        });
        thread.start();
    }

    private Handler messageHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            ImageView iv = (ImageView)findViewById(R.id.imageView2);
            iv.setImageBitmap((Bitmap)msg.getData().getParcelable("bitmap"));
            progressDialog.dismiss();
            return false;
        }
    });

    private InputStream openHttpConnection(String url1) {

        InputStream is = null;
        int rescode = -1;

        try{
            URL url = new URL(url1);
            URLConnection urlConnection = url.openConnection();

            if(!(urlConnection instanceof HttpURLConnection)){
                throw  new IOException("URL is not an HTTP url");
            }

            HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setAllowUserInteraction(false);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.connect();

            rescode = httpURLConnection.getResponseCode();

            if(rescode == HttpURLConnection.HTTP_OK){
                is = httpURLConnection.getInputStream();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return is;
    }

    private boolean checkInternetConnection() {

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);

        if(connectivityManager.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTING ||
                connectivityManager.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTING ||
                connectivityManager.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED )
        {
            Toast.makeText(this,"Connected with Net",Toast.LENGTH_LONG).show();
            return true;
        }else if(
                connectivityManager.getNetworkInfo(0).getState() == NetworkInfo.State.DISCONNECTED ||
                        connectivityManager.getNetworkInfo(0).getState() == NetworkInfo.State.DISCONNECTING)
        {
            Toast.makeText(this," not Connected with Net",Toast.LENGTH_LONG).show();
            finish();

        }
        return false;
    }
}