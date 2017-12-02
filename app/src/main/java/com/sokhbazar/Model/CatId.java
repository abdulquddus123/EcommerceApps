package com.sokhbazar.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Areyen on 8/18/2017.
 */

public class CatId {

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    @SerializedName("cate_id")
    private int cateId;


    public CatId(){
    }


}
