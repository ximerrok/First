package com.example.first.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.first.R;
import com.example.first.model.Product_main;
import com.example.first.model.Todo;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private final List<Product_main> list;
    private final Context context;

    public ProductAdapter(List<Product_main> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product_main product_main = list.get(position);
        holder.textView.setText(product_main.getDescription());
        holder.idTextView.setText(product_main.getTitle());
//        Picasso.with(context).load(product_main.getThumbnail()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textView;
        final TextView idTextView;
        final ImageView imageView;

        ViewHolder(View view){
            super(view);
            textView = view.findViewById(R.id.item_text);
            idTextView = view.findViewById(R.id.id);
            imageView = view.findViewById(R.id.thumbnail);
        }

    }
}
