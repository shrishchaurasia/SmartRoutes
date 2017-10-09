package com.example.pi.smartroute;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Button process;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        process = (Button) findViewById(R.id.process);
        add = (Button) findViewById(R.id.add);

        process.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent( MainActivity.this, AddGpsLocation.class);
                startActivity(intent);

            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this, AddCustomerReq.class);
                startActivity(intent);
            }
        });

        //dfsdfsdfsdfsf
        //sdsdfsdfsf//
        //sdfsdf

//        LatLng f ;
//        double b = SphericalUtil.computeDistanceBetween(latLngFrom, latLngTo);

    }


    public void clicked(View view) throws JSONException {

        JSONObject locationJsonObject = new JSONObject();
        locationJsonObject.put("origin", "54.406505,18.67708");
        locationJsonObject.put("destination", "54.446251,18.570993");
        LatlngCalc(locationJsonObject);
    }

    private void LatlngCalc(JSONObject locationJsonObject) throws JSONException {

        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        String url = "http://maps.googleapis.com/maps/api/distancematrix/" +
                "json?origins=" + locationJsonObject.getString("origin") + "&destinations=" + locationJsonObject.getString("destination") + "&mode=driving&" +
                "language=en-EN&sensor=false";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

//                        mTextView.setText("Response is: " + response.substring(0, 500));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                mTextView.setText("That didn't work!");
            }
        });
        queue.add(stringRequest);
    }
}
