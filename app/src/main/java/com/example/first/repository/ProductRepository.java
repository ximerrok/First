package com.example.first.repository;

import java.util.List;

import com.example.first.Product;
import com.example.first.model.Product_main;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ProductRepository {

    @SerializedName("products")
    @Expose
    private List<Product_main> products;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("skip")
    @Expose
    private Integer skip;
    @SerializedName("limit")
    @Expose
    private Integer limit;

    public List<Product_main> getProducts() {
        return products;
    }

    public void setProducts(List<Product_main> products) {
        this.products = products;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getSkip() {
        return skip;
    }

    public void setSkip(Integer skip) {
        this.skip = skip;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

}