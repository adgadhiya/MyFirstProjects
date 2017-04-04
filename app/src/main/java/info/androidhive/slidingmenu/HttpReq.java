package info.androidhive.slidingmenu;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.net.HttpURLConnection;

public class HttpReq extends AppCompatActivity implements View.OnClickListener {

    Button button;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_req);

        tv = (TextView)findViewById(R.id.tvHttp);
        button=(Button)findViewById(R.id.btnHttp);

        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String myInfo = "Hello";
        GetInformation getInformation = new GetInformation(HttpReq.this);
        String url = "https://www.youtube.com";
        getInformation.execute(url);

        tv.setText(myInfo);
    }
}
