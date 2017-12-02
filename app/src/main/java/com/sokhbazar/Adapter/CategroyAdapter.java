package com.sokhbazar.Adapter;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sokhbazar.Model.CatId;
import com.sokhbazar.Model.Category;
import com.sokhbazar.R;
import com.sokhbazar.SecondActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * Created by Areyen on 7/31/2017.
 */

public class CategroyAdapter extends RecyclerView.Adapter<CategroyAdapter.ViewHolder> {
    private ArrayList<Category> categoryList;
    private Context context;
    private Category category;
    private CatId catId;


    public CategroyAdapter(Context context,Category category,CatId catId) {
        this.category=category;
        this.context =context;
        this.catId=catId;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.category_model,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.category_name.setText(category.getData().get(position).getCategoryName());
        Picasso.with(context).load(category.getData().get(position).getBanner()).resize(250,250).into(holder.imageView);
       // Log.d("Image","Banar"+category.getData().get(position).getBanner());


    }

    @Override
    public int getItemCount() {
        return category.getData().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView category_name;
        ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            category_name = (TextView) itemView.findViewById(R.id.category_name);
            imageView=(ImageView)itemView.findViewById(R.id.image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(), SecondActivity.class);
                    String num=category.getData().get(getAdapterPosition()).getCategoryId();
                 //   int id=Integer.parseInt(category.getData().get(getAdapterPosition()).getCategoryId());
//                    CatId catId=new CatId();
//                    catId.setCateId(id);
//                    Toast.makeText(v.getContext(), ""+String.valueOf(catId.getCateId()), Toast.LENGTH_SHORT).show();
                  //  Toast.makeText(v.getContext(), num, Toast.LENGTH_SHORT).show();
                    i.putExtra("cateid",num);
                    v.getContext().startActivity(i);


                }
            });
        }
    }
}
