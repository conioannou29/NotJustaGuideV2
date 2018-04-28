package com.cons.not;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cons.not.model.PlacesModel;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Constantinos on 29/03/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";

    //vars
    private ArrayList<PlacesModel> mPlaces = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(Context context, ArrayList<PlacesModel> places) {
        mContext = context;
        mPlaces = places;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(mContext)
                .asBitmap()
                .load(mPlaces.get(position).getImgUrl())
                .into(holder.image);

        holder.name.setText(mPlaces.get(position).getName());


        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + mPlaces.get(position).getName());

                //Toast.makeText(mContext, mPlaces.get(position).getName(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContext, PlacesDesc_Activity.class);
                intent.putExtra("image_url", mPlaces.get(position).getImgUrl());
                intent.putExtra("image_name", mPlaces.get(position).getName());
                intent.putExtra("description", mPlaces.get(position).getDescription());
                intent.putExtra("website", mPlaces.get(position).getWebsite());
                intent.putExtra("address", mPlaces.get(position).getAddress());
                intent.putExtra("phone", mPlaces.get(position).getPhone());
                intent.putExtra("openingHours", mPlaces.get(position).getOpeningHours());
                intent.putExtra("map_url", mPlaces.get(position).getMapUrl());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPlaces.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView name;
        TextView description;
        TextView website;
        TextView address;
        TextView phone;
        TextView openingHours;
        TextView map_url;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_view);
            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.Description_Details);
            website = itemView.findViewById(R.id.Website_Details);
            address = itemView.findViewById(R.id.Address_Details);
            phone = itemView.findViewById(R.id.Phone_Details);
            openingHours = itemView.findViewById(R.id.Hours_Details);
            map_url = itemView.findViewById(R.id.mapDetails);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
