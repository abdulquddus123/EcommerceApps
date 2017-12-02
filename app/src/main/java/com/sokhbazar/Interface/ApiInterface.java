package com.sokhbazar.Interface;
import com.sokhbazar.Model.Brand;
import com.sokhbazar.Model.CatId;
import com.sokhbazar.Model.Category;
import com.sokhbazar.Model.CategoryResponse;
import com.sokhbazar.Model.FeatureProduct;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Areyen on 7/31/2017.
 */

public interface ApiInterface {
    @GET("/index.php/api/")
    Call<Category> getInfo();

    @GET("/index.php/api/brand")
    Call<Brand> getBrand();

    @GET("/index.php/api/featured_products")
    Call<FeatureProduct> getFeature();

    @POST("/index.php/api/product_view")
    Call<CategoryResponse> CategoryIdPost(@Body CatId catId);
}
