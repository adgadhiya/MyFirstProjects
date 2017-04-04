package info.androidhive.slidingmenu;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;


/**
 * Created by UNKNOWN on 6/7/2016.
 */
public class GetInformation extends AsyncTask<String,Void,String> {
    Context c;
    AlertDialog alertDialog;
    GetInformation(Context c) {
        this.c = c;
    }


    @Override
    protected String doInBackground(String... params) {
        String data = null;
        try {
            URL url = new URL(params[0]);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");

            InputStream is = httpURLConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            StringBuffer sb = new StringBuffer();
            String s = null;

            while ((s = br.readLine()) != null) {
                sb.append(s + "\n");
            }
            br.close();
            is.close();
            httpURLConnection.disconnect();
            return  sb.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

return null;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(c).create();
    }

    @Override
    protected void onPostExecute(String result) {
        alertDialog.setTitle("Information");
        alertDialog.setMessage(result);
        alertDialog.show();

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}