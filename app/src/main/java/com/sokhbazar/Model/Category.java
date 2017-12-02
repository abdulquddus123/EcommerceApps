package com.sokhbazar.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Areyen on 7/31/2017.
 */

public class Category {


    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }


    public class Datum {

        @SerializedName("category_id")
        @Expose
        private String categoryId;
        @SerializedName("category_name")
        @Expose
        private String categoryName;
        @SerializedName("description")
        @Expose
        private Object description;
        @SerializedName("digital")
        @Expose
        private Object digital;
        @SerializedName("banner")
        @Expose
        private String banner;
        @SerializedName("data_brands")
        @Expose
        private String dataBrands;
        @SerializedName("data_vendors")
        @Expose
        private String dataVendors;
        @SerializedName("data_subdets")
        @Expose
        private String dataSubdets;

        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }

        public Object getDigital() {
            return digital;
        }

        public void setDigital(Object digital) {
            this.digital = digital;
        }

        public String getBanner() {
            return "http://sokhbazar.com/uploads/category_image/"+banner;
        }

        public void setBanner(String banner) {
            this.banner = banner;
        }

        public String getDataBrands() {
            return dataBrands;
        }

        public void setDataBrands(String dataBrands) {
            this.dataBrands = dataBrands;
        }

        public String getDataVendors() {
            return dataVendors;
        }

        public void setDataVendors(String dataVendors) {
            this.dataVendors = dataVendors;
        }

        public String getDataSubdets() {
            return dataSubdets;
        }

        public void setDataSubdets(String dataSubdets) {
            this.dataSubdets = dataSubdets;
        }

    }
}

