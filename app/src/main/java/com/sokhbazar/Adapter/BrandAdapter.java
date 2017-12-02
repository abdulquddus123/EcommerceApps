package com.sokhbazar.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sokhbazar.Model.Brand;
import com.sokhbazar.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Areyen on 8/4/2017.
 */

public class BrandAdapter extends RecyclerView.Adapter<BrandAdapter.ViewHolder> {
       private ArrayList<Brand> brandList;
      private Context context;
    private Brand brand;


    public BrandAdapter(Context context,Brand brand){
        this.context=context;
        this.brand=brand;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.brand_model,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
holder.brand_name.setText(brand.getData().get(position).getName());
        Picasso.with(context).load(brand.getData().get(position).getLogo()).resize(250,250).into(holder.brand_image);

    }

    @Override
    public int getItemCount() {
        return brand.getData().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView brand_name;
        ImageView brand_image;
        public ViewHolder(View itemView) {
            super(itemView);
            brand_name=(TextView)itemView.findViewById(R.id.brand_name);
            brand_image=(ImageView)itemView.findViewById(R.id.brand_image);
        }
    }
}
