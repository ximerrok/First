package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.first.adapter.ProductAdapter;
import com.example.first.adapter.TodoAdapter;
import com.example.first.model.Product_main;
import com.example.first.model.Todo;
import com.example.first.model.Todos;
import com.example.first.model.User;
import com.example.first.repository.ProductRepository;
import com.example.first.repository.TodoRepository;
import com.example.first.retrofit.RetrofitInstance;
import com.example.first.service.DummyJsonService;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {

    private TextView title;
    private TextView desc;
    private ImageView image;
    private TextView price;
    private TextView rating;

    private User user;

    List<Product_main> product_mains;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        title = findViewById(R.id.product_title);
//        desc = findViewById(R.id.product_desc);
//       image = findViewById(R.id.product_image2);
//        price = findViewById(R.id.product_price);
//        rating = findViewById(R.id.product_rating);
        getProducts();
//        login();

    }

    private void login() {
        DummyJsonService dummyJsonService = RetrofitInstance.getService();
        Map<String, String> body = new HashMap<>();
        body.put("username", "kminchelle");
        body.put("password", "0lelplR");
//        Picasso.with(MainActivity2.this).load("https://robohash.org/autquiaut.png").into(image);
        Call<LoginModel> jsonObjectCall = dummyJsonService.login(body);
        jsonObjectCall.enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                if (response.body() != null) {
                    LoginModel loginModel = response.body();
                    Log.d("auth/login", loginModel.toString());
                }
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {

            }
        });
    }

    private void getProducts() {
        DummyJsonService dummyJsonService = RetrofitInstance.getService();

        Call<ProductRepository> call = dummyJsonService.getProducts("Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MTUsInVzZXJuYW1lIjoia21pbmNoZWxsZSIsImVtYWlsIjoia21pbmNoZWxsZUBxcS5jb20iLCJmaXJzdE5hbWUiOiJKZWFubmUiLCJsYXN0TmFtZSI6IkhhbHZvcnNvbiIsImdlbmRlciI6ImZlbWFsZSIsImltYWdlIjoiaHR0cHM6Ly9yb2JvaGFzaC5vcmcvYXV0cXVpYXV0LnBuZyIsImlhdCI6MTY3OTY2ODM2NiwiZXhwIjoxNjc5NjcxOTY2fQ.woDa5EdlMADcz_elyGliS94YD8GcrM5gqGZwnNUPVFU",10);

        call.enqueue(new Callback<ProductRepository>() {
            @Override
            public void onResponse(Call<ProductRepository> call, Response<ProductRepository> response) {
                ProductRepository productRepository = response.body();
                if (productRepository != null) {
                    product_mains = productRepository.getProducts();
                    RecyclerView recyclerView = findViewById(R.id.recycler_view);
                    ProductAdapter productAdapter = new ProductAdapter(product_mains , MainActivity2.this);
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity2.this, LinearLayoutManager.VERTICAL, false));
                    recyclerView.setAdapter(productAdapter);
                }
            }
//products, id, title, description, price, discountPercentage, rating, stock, brand, category, thumbnail, images
            @Override
            public void onFailure(Call<ProductRepository> call, Throwable t) {
                Log.d("Products get Error", t.toString());

            }
        });
    }
}