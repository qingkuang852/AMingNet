package com.amingnet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.amingnetlib.base.AMingNet;
import com.amingnetlib.base.ARequest;
import com.amingnetlib.base.RequestQueue;
import com.amingnetlib.request.StringRequest;

public class MainActivity extends AppCompatActivity {
    final RequestQueue queue = AMingNet.newRequestQueue();
    private int time = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tv = (TextView) findViewById(R.id.show);
        final String url = "http://gank.io/api/data/福利/1/1";

        StringRequest request = new StringRequest(ARequest.HttpMethod.GET, url, new ARequest.RequestListener<String>() {
            @Override
            public void onComplete(int stCode, String response, String errMsg) {
                tv.setText(time+" response :"+response);
                time ++ ;
            }
        });

        queue.addRequest(request);

    }

    @Override
    protected void onDestroy() {
        queue.stop();
        super.onDestroy();
    }
}
