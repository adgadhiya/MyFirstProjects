package info.androidhive.slidingmenu;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class jsonParsing extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_parsing);

        TextView tv = (TextView)findViewById(R.id.tv);
        tv.setText("HELLO");

        String string = "{ \"Employee\" :[ { \"id\":\"01\"  , \"name\":\"ABCD\" , \"salary\":\"50000\"}," +
                "{ \"id\":\"02\"  , \"name\":\"ABC\" , \"salary\":\"500\"}," +
                "{ \"id\":\"03\"  , \"name\":\"AB\" , \"salary\":\"50\"} ] }  ";

        String data = null;

        try {
            JSONObject jsonObject = new JSONObject(string);

            JSONArray jsonArray = jsonObject.optJSONArray("Employee");
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);


                int id = Integer.parseInt(jsonObject1.getString("id"));
                String name = jsonObject1.optString("name").toString();
                int salary = Integer.parseInt(jsonObject1.optString("salary").toString());

              data += "Node" + i + " : \n id = " + id + " \n Name= "+ name +" \n salary = "+ salary + "\n";

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
                tv.setText(data);

    }


}
