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

import java.util.Currency;
import java.util.List;
import java.util.Locale;

public class ProductsListAdapter extends RecyclerView.Adapter<ProductsListAdapter.ViewHolder> {
    private List<Product> products;
    private Context context;
    private TextView textViewNoProducts;
    private static final String SYMBOL_EURO = "\u20ac";


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
        holder.producerName.setText(products.get(position).getProducerName());
        holder.productName.setText("Product: "+products.get(position).getProductName().toUpperCase());
        holder.tv_eco.setText("EcoScore: "+products.get(position).getEcoScore());
        holder.tv_price.setText("Price: "+products.get(position).getPrice()+SYMBOL_EURO);
        holder.imageView.setImageResource(products.get(position).getIconId());
   //   Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(holder.imageView);
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
    static class ViewHolder extends RecyclerView.ViewHolder {
        private AppCompatImageView imageView;
        private TextView productName,producerName,tv_price;
        private RelativeLayout relativeLayout;
        private CardView root_childview;
        private TextView tv_eco;
        private ViewHolder(View listItem) {
            super(listItem);
            this.tv_eco = (TextView) listItem.findViewById(R.id.tv_eco);
            this.imageView = (AppCompatImageView) listItem.findViewById(R.id.image_product);
            this.productName = (TextView) listItem.findViewById(R.id.tv_productname);
            this.producerName = (TextView) listItem.findViewById(R.id.tv_producername);
            this.tv_price = (TextView) listItem.findViewById(R.id.tv_price);
            this.root_childview = (CardView) listItem.findViewById(R.id.root_childview);
        }
    }
}
