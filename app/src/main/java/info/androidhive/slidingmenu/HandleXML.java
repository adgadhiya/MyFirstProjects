package info.androidhive.slidingmenu;

import android.support.v7.app.AlertDialog;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by UNKNOWN on 6/7/2016.
 */
public class HandleXML {

    private String item = "country";
    private String name = "temperature";
    private String cost = "humidity";
    private String description = "pressure";
    private String urlString = "null";

    public boolean parsingComplete = true;

    public HandleXML(String finalurl) {
        this.urlString = finalurl;
    }

    public void fetchXML() {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(urlString);
                    HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                    conn.setReadTimeout(1000);
                    conn.setRequestMethod("POST");
                    conn.setDoInput(true);
                    conn.connect();

                    InputStream is = conn.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));

                    StringBuffer sb = new StringBuffer();
                    String line = null;

                    while ((line = br.readLine())!= null){
                        sb.append(line);
                    }

                    AlertDialog alertDialog = null;
                    alertDialog.setMessage(sb.toString());
                    alertDialog.show();


                    XmlPullParserFactory xmlPullParserFactory = XmlPullParserFactory.newInstance();
                    XmlPullParser xmlPullParser = xmlPullParserFactory.newPullParser();

                    xmlPullParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES,false);
                   xmlPullParser.setInput(is,null);

                    parseXMLAndStoreIt(xmlPullParser);

                    is.close();

                } catch (MalformedURLException e) {
                    e.printStackTrace();

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
    }

    public String getCountry() {
        return item;
    }

    public String getTemperature() {
        return name;
    }

    public String getHumidity() {
        return cost;
    }

    public String getPressure() {
        return description;
    }

    public void parseXMLAndStoreIt(XmlPullParser myParser){
        int event;
        String text = null;

        try{
                event = myParser.getEventType();
            while (event != XmlPullParser.END_DOCUMENT){
                String name = myParser.getName();

                switch (event){
                    case XmlPullParser.START_TAG:
                        break;

                    case XmlPullParser.TEXT:
                        text = myParser.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        if(name.equals("country")){
                            item = text;
                        }

                        else if(name.equals("temprature")){
                            cost = myParser.getAttributeValue(null,"value");
                        }

                        else if(name.equals("humidity")){
                            cost = myParser.getAttributeValue(null,"value");
                        }

                        else if(name.equals("pressure")){
                            cost = myParser.getAttributeValue(null,"value");
                        }
                        else{
                            break;
                        }
                        event  = myParser.next();
                }
                parsingComplete = false;
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
