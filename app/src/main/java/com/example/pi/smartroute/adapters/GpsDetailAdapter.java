package com.example.pi.smartroute.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.example.pi.smartroute.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pi on 10/3/17.
 */

public class GpsDetailAdapter extends RecyclerView.Adapter<GpsDetailAdapter.ViewHolder> {

    List<String> mGps = new ArrayList<>();

    public GpsDetailAdapter(ListItemClickListener OnClickListener) {
        this.mOnClickListener = OnClickListener;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.gps_data_layout;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutIdForListItem, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mGps.size();
    }

    public void setGpsList(String gpsList) {
        mGps.add(gpsList);
        notifyDataSetChanged();
    }

    public void setRGpsList(int id) {
        mGps.remove(id);
        notifyDataSetChanged();
    }

    public interface ListItemClickListener {

        void onListItemClick(int id);
    }

    private ListItemClickListener mOnClickListener;

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

        TextView name;
//        Button b;
        ViewHolder(final View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.gpsData);
//            b = (Button) itemView.findViewById(R.id.close);

            itemView.setOnClickListener(this);
        }

        void bind(final int listIndex) {

            String gps = mGps.get(listIndex);
            name.setText(gps);



        }


        @Override
        public void onClick(View v) {
            int pos = getAdapterPosition();
            mOnClickListener.onListItemClick(pos);

        }

    }
}
