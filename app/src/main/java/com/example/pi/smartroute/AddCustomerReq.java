package com.example.pi.smartroute;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.math.BigInteger;

public class AddCustomerReq extends AppCompatActivity {

    EditText orderID;
    EditText name;
    EditText phone;
    EditText email;
    EditText address;
    EditText detail;
    EditText gps;

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer_req);
        orderID =(EditText) findViewById(R.id.OrderID);
        name =(EditText) findViewById(R.id.name);
        phone =(EditText) findViewById(R.id.phone);
        email =(EditText) findViewById(R.id.email);
        address =(EditText) findViewById(R.id.address);
        detail =(EditText) findViewById(R.id.detail);
        gps =(EditText) findViewById(R.id.gps);

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
                String mOrderID = orderID.getText().toString();
                String mNmae = name.getText().toString();
                String mphone = phone.getText().toString();
                String memail = email.getText().toString();
                String maddress = address.getText().toString();
                String mDetail = detail.getText().toString();
                String mGps = gps.getText().toString();
                saveData(mOrderID, mNmae, mphone,memail, maddress, mDetail, mGps);
                break;

        }
        return true;
    }

    private void saveData(String orderID, String mNmae, String mphone, String memail, String maddress, String mDetail, String mGps) {

        DatabaseReference myRef = database.getReference("ClientData");
        myRef.child("users"+orderID).child("OrderID").setValue(orderID);
        myRef.child("users"+orderID).child("Name").setValue(mNmae);
        myRef.child("users"+orderID).child("Phone").setValue(mphone);
        myRef.child("users"+orderID).child("Email").setValue(memail);
        myRef.child("users"+orderID).child("Address").setValue(maddress);
        myRef.child("users"+orderID).child("Detail").setValue(mDetail);
        myRef.child("users"+orderID).child("GPs").setValue(mGps);

//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                String value = dataSnapshot.getValue(String.class);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w("yooooo", "Failed to read value.", error.toException());
//            }
//        });

    }
}
