package info.androidhive.slidingmenu;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class XmlParser extends AppCompatActivity {

    EditText et1,et2,et3,et4,et5;
    Button b1;

    private String url1 = "http://api.openweathermap.org/data/2.5/weather?q=";
    private String url2 = "&mode=xml";

    private HandleXML obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myxmlparser);

        b1 = (Button)findViewById(R.id.b1);
        et1 = (EditText)findViewById(R.id.et1);
        et2 = (EditText)findViewById(R.id.et2);
        et3 = (EditText)findViewById(R.id.et3);
        et4 = (EditText)findViewById(R.id.et4);
        et5 = (EditText)findViewById(R.id.et5);

        b1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String url = et1.getText().toString();
                        String finalurl = url1 + url + url2;

                        obj = new HandleXML(finalurl);
                        obj.fetchXML();

                        while(!obj.parsingComplete){
                            et2.setText(obj.getCountry());
                            et2.setText(obj.getTemperature());
                            et2.setText(obj.getHumidity());
                            et2.setText(obj.getPressure());
                        }
                    }
                }
        );
    }
}
