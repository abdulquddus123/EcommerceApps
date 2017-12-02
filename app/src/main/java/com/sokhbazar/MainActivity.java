package com.sokhbazar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.sokhbazar.Adapter.BrandAdapter;
import com.sokhbazar.Adapter.CategroyAdapter;

import com.sokhbazar.Adapter.FeatureProductAdapter;
import com.sokhbazar.Interface.ApiInterface;
import com.sokhbazar.Model.Brand;
import com.sokhbazar.Model.CatId;
import com.sokhbazar.Model.Category;
import com.sokhbazar.Model.FeatureProduct;
import com.sokhbazar.Retrofit.RetrofitApiClient;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    RecyclerView myRecyclerView,brandRecyleView,featureRecycleView;
    CategroyAdapter categroyAdapter;
    FeatureProductAdapter featureProductAdapter;
    BrandAdapter brandAdapter;
    CatId catId;
    ArrayList<Category> categoryList;
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myRecyclerView = (RecyclerView) findViewById(R.id.recycleView);
        brandRecyleView=(RecyclerView)findViewById(R.id.brandRecycleView);
        featureRecycleView=(RecyclerView)findViewById(R.id.featureRecycleView);
       // myRecyclerView.setHasFixedSize(true);

        Category();
        getBrand();
        getFeatureProduct();
    }

   // Get Category
    public void Category(){
        ApiInterface api = RetrofitApiClient.getApiInterface();
        Call<Category> call = api.getInfo();

        call.enqueue(new Callback<Category>() {
            @Override
            public void onResponse(Call<Category> call, Response<Category> response) {
                if (response.isSuccessful()) {

                    Category category = response.body();
                //    Log.d("array","length :"+category.getData().size());
                //    Log.d("Image","Banar : "+category.getData().get(0).getBanner());

                        categroyAdapter = new CategroyAdapter(MainActivity.this, category , catId);
                        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
                        myRecyclerView.setLayoutManager(mLayoutManager);
                        myRecyclerView.setItemAnimator(new DefaultItemAnimator());
                        myRecyclerView.setAdapter(categroyAdapter);

                    //   Log.d(TAG, "Response: " + category.getData().get(0).getCategoryName());
                }
            }

            @Override
            public void onFailure(Call<Category> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
            }
        });
    }


//    Get Feature Product
public void getFeatureProduct(){
    ApiInterface api = RetrofitApiClient.getApiInterface();
    Call<FeatureProduct> call = api.getFeature();

    call.enqueue(new Callback<FeatureProduct>() {
        @Override
        public void onResponse(Call<FeatureProduct> call, Response<FeatureProduct> response) {
          //  Log.d("First","Response : "+ response.body());
            if (response.isSuccessful()) {
                FeatureProduct featureProduct = response.body();
              //  Log.d("response","show"+response.isSuccessful());
             //   Log.d("array","length :"+featureProduct.getData().size());
              //      Log.d("Image","Banar : "+featureProduct.getData().get(1).getProductId());
              featureProductAdapter=new FeatureProductAdapter(MainActivity.this,featureProduct);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
                featureRecycleView.setLayoutManager(mLayoutManager);
                featureRecycleView.setItemAnimator(new DefaultItemAnimator());
                featureRecycleView.setAdapter(featureProductAdapter);

                //   Log.d(TAG, "Response: " + category.getData().get(0).getCategoryName());
            }
        }

        @Override
        public void onFailure(Call<FeatureProduct> call, Throwable t) {

        }


    });
}


 //   Get Brand
    public void getBrand(){
        ApiInterface api = RetrofitApiClient.getApiInterface();
        Call<Brand> call = api.getBrand();

        call.enqueue(new Callback<Brand>() {
            @Override
            public void onResponse(Call<Brand> call, Response<Brand> response) {
                if (response.isSuccessful()) {


                    Brand brand = response.body();
                  //  Log.d("array","length :"+brand.getData().size());
                    Log.d("Name","Brand Name :"+brand.getData().get(5).getName());
                    //    Log.d("Image","Banar : "+category.getData().get(0).getBanner());

                    brandAdapter = new BrandAdapter(MainActivity.this, brand);
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
                    brandRecyleView.setLayoutManager(mLayoutManager);
                    brandRecyleView.setItemAnimator(new DefaultItemAnimator());
                    brandRecyleView.setAdapter(brandAdapter);

                    //   Log.d(TAG, "Response: " + category.getData().get(0).getCategoryName());
                }
            }

            @Override
            public void onFailure(Call<Brand> call, Throwable t) {

            }

        });

    }




}
