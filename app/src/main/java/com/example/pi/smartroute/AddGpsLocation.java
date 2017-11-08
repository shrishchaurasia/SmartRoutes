package com.example.pi.smartroute;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pi.smartroute.adapters.GpsDetailAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Comment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddGpsLocation extends AppCompatActivity implements GpsDetailAdapter.ListItemClickListener{

    private RecyclerView recyclerView;

    GpsDetailAdapter gpsAdapter;

    final FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_gps_location);
        recyclerView = (RecyclerView) findViewById(R.id.postList);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(false);
        gpsAdapter = new GpsDetailAdapter(this);
        recyclerView.setAdapter(gpsAdapter);




        DatabaseReference ref = database.getReference("ClientData");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                HashMap<String, HashMap<String, String >> s =  (HashMap<String, HashMap<String,String>>) dataSnapshot.getValue();

                Iterator it = s.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry)it.next();
                    HashMap<String, String > p = (HashMap<String, String>) pair.getValue();
//                    Iterator it1 = p.entrySet().iterator();
//                    while (it1.hasNext()) {
//                        Map.Entry pair1 = (Map.Entry) it1.next();
//                        pair.getValue();
//                        it1.remove();
//                    }
                   ArrayList<String> data = new ArrayList<>();
                    data.add(p.get("Name"));
                    data.add(p.get("Address"));
                    data.add(p.get("OrderID"));
                    data.add(p.get("Phone"));
                    data.add(p.get("GPs"));
                    gpsAdapter.setGpsList(data);
                    it.remove(); // avoids a ConcurrentModificationException
                }

//  Log.d("yoyoy", s);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.route, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.route:
                Toast.makeText(this, "Menu Item 1 selected", Toast.LENGTH_SHORT).show();
                break;

        }
        return true;
    }

    @Override
    public void onListItemClick(final int id) {


//        CharSequence[] newItem;
//             newItem = new CharSequence[]{"View Customer Detail", "Return"};
//
//        final CharSequence[] items = newItem;
//
//        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
////                builder.setTitle("Select The Action");
//        builder.setItems(items, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int item) {
//                if (item == 1) {
//                    gpsAdapter.setRGpsList(id);
//                }
//                else if (item == 0) {
//                    Intent intent = new Intent( AddGpsLocation.this, CustomerDetail.class);
//                    startActivity(intent);
//                }
//            }
//        });
//        builder.show();
    }
}
