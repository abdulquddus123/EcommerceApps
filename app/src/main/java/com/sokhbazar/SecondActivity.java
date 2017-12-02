package com.sokhbazar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.sokhbazar.Interface.ApiInterface;
import com.sokhbazar.Model.CatId;
import com.sokhbazar.Model.CategoryResponse;
import com.sokhbazar.Retrofit.RetrofitApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String stringData= intent.getStringExtra("cateid");
        CatId catid=new CatId();
        catid.setCateId(Integer.parseInt(stringData));
//        Toast.makeText(this, ""+stringData, Toast.LENGTH_SHORT).show();
        CategoryPost(catid);
    }


    public void CategoryPost(CatId catid){

        Toast.makeText(this, ""+String.valueOf(catid.getCateId()), Toast.LENGTH_SHORT).show();
        ApiInterface api = RetrofitApiClient.getApiInterface();
        Call<CategoryResponse> categoryResponseCall=api.CategoryIdPost(catid);
           categoryResponseCall.enqueue(new Callback<CategoryResponse>() {
               @Override
               public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                   CategoryResponse cr= response.body();
                //   Toast.makeText(SecondActivity.this, ""+cr.g=, Toast.LENGTH_SHORT).show();
                           Log.d("Testing","Response : "+ response.isSuccessful());
               }

               @Override
               public void onFailure(Call<CategoryResponse> call, Throwable t) {

                   Toast.makeText(SecondActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                   Log.d("Testing","SResponse : "+ t.getCause());
               }
           });

    }


}


