package com.sokhbazar.Adapter;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.sokhbazar.Model.FeatureProduct;
import com.sokhbazar.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Areyen on 8/3/2017.
 */

public class FeatureProductAdapter extends RecyclerView.Adapter<FeatureProductAdapter.ViewHolder>{
    private Context context;
    private FeatureProduct featureProduct;

    public FeatureProductAdapter(Context context, FeatureProduct featureProduct) {
        this.context=context;
        this.featureProduct=featureProduct;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.feature_product_model,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

      holder.featureProduct.setText(featureProduct.getData().get(position).getTitle());
        Picasso.with(context).load(featureProduct.getData().get(position).getProductId()).resize(250,250).into(holder.featureImage);
        Log.d("total","title"+featureProduct.getData().get(1).getTitle());
    }

    @Override
    public int getItemCount() {
        return featureProduct.getData().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView featureProduct;
        ImageView featureImage;
        public ViewHolder(View itemView) {
            super(itemView);
            featureProduct=(TextView)itemView.findViewById(R.id.feature_product_name);
            featureImage=(ImageView)itemView.findViewById(R.id.feature_product_image);

        }
    }
}
