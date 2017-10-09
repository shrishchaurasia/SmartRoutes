package com.example.pi.smartroute;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pi.smartroute.adapters.GpsDetailAdapter;

import org.w3c.dom.Comment;

import java.util.ArrayList;
import java.util.List;

public class AddGpsLocation extends AppCompatActivity implements GpsDetailAdapter.ListItemClickListener{

    private RecyclerView recyclerView;
    EditText lat;
    EditText lon;
    Button add;
    GpsDetailAdapter gpsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_gps_location);
        lat =(EditText) findViewById(R.id.lat);
        lon =(EditText) findViewById(R.id.lon);
        add =(Button) findViewById(R.id.addit);

        recyclerView = (RecyclerView) findViewById(R.id.postList);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(false);
        gpsAdapter = new GpsDetailAdapter(this);
        recyclerView.setAdapter(gpsAdapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mlat = String.valueOf(lat.getText());
                String mlon = String.valueOf(lon.getText());
                String data = mlat+"||"+mlon;
                gpsAdapter.setGpsList(data);

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


        CharSequence[] newItem;
             newItem = new CharSequence[]{"View Customer Detail", "Return"};

        final CharSequence[] items = newItem;

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
//                builder.setTitle("Select The Action");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (item == 1) {
                    gpsAdapter.setRGpsList(id);
                }
                else if (item == 0) {
                    Intent intent = new Intent( AddGpsLocation.this, CustomerDetail.class);
                    startActivity(intent);
                }
            }
        });
        builder.show();
    }
}
