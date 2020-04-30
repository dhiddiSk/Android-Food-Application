package com.example;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youcare.R;
import com.example.youcare.appbody.Product;

import java.util.List;

public class ProductsListAdapter extends RecyclerView.Adapter<ProductsListAdapter.ViewHolder> {
    private List<Product> products;
    private Context context;
    private TextView textViewNoProducts;

    /***
     * Setting the Adapter with Context Reference and Products Objects.
     * @param context
     * @param productsList
     * @param tv_noProducts
     */
    public ProductsListAdapter(Context context, List<Product> productsList, TextView tv_noProducts) {
        this.context = context;
        this.products = productsList;
        this.textViewNoProducts = tv_noProducts;
    }

    //setting the child view
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.layout_product_childview, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    //binding the products to child items
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.productName.setText("Product: "+products.get(position).getProductName());
        holder.producerName.setText("Manufacturer: "+products.get(position).getProducerName());
        holder.tv_env.setText("Environment Count: "+products.get(position).getEnvironment());
        holder.id_rating.setNumStars(products.get(position).getEnvironment());
   //     Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(holder.imageView);
    }

    //Set the products Count
    @Override
    public int getItemCount() {
        if (products.size() == 0){
            textViewNoProducts.setVisibility(View.VISIBLE);
        } else {
            textViewNoProducts.setVisibility(View.GONE);
        }
        return products.size();
    }

    public void filterProducts(List<Product> filteredProducts) {
        products = filteredProducts;
        notifyDataSetChanged();
    }

    //Setting the IDs
    public class ViewHolder extends RecyclerView.ViewHolder {
        public AppCompatImageView imageView;
        public TextView productName,producerName,tv_env;
        public RelativeLayout relativeLayout;
        public CardView root_childview;
        private RatingBar id_rating;
        public ViewHolder(View listItem) {
            super(listItem);
            this.id_rating = (RatingBar) listItem.findViewById(R.id.id_rating);
            this.imageView = (AppCompatImageView) listItem.findViewById(R.id.image_product);
            this.productName = (TextView) listItem.findViewById(R.id.tv_productname);
            this.producerName = (TextView) listItem.findViewById(R.id.tv_producername);
            this.tv_env = (TextView) listItem.findViewById(R.id.tv_env);
            this.root_childview = (CardView) listItem.findViewById(R.id.root_childview);
        }
    }
}
