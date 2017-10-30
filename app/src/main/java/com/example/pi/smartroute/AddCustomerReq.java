package com.example.pi.smartroute;

import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.math.BigInteger;

public class AddCustomerReq extends AppCompatActivity {

    EditText name;
    EditText phone;
    EditText email;
    EditText address;
    EditText detail;
    EditText gps;
//    GoogleApiClient mGoogleApiClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer_req);
        name =(EditText) findViewById(R.id.name);
        phone =(EditText) findViewById(R.id.phone);
        email =(EditText) findViewById(R.id.email);
        address =(EditText) findViewById(R.id.address);
        detail =(EditText) findViewById(R.id.detail);
        gps =(EditText) findViewById(R.id.gps);

//        if (mGoogleApiClient == null) {
//            mGoogleApiClient = new GoogleApiClient.Builder(this)
//                    .addConnectionCallbacks(this)
//                    .addOnConnectionFailedListener(this)
//                    .addApi(LocationServices.API)
//                    .build();
//        }
//        Location currentLocation = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.save, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save:
                String mNmae = name.getText().toString();
                BigInteger mphone = new BigInteger(name.getText().toString());
                String memail = email.getText().toString();
                String maddress = address.getText().toString();
                String mDetail = detail.getText().toString();
                String mGps = gps.getText().toString();
                saveData(mNmae, mphone,memail, maddress, mDetail, mGps);
                break;

        }
        return true;
    }

    private static void saveData(String mNmae, BigInteger mphone, String memail, String maddress, String mDetail, String mGps) {

    }
}
