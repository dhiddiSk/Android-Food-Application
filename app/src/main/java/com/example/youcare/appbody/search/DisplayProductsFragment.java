package com.example.youcare.appbody.search;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ProductsListAdapter;
import com.example.youcare.R;
import com.example.youcare.appbody.Product;
import com.example.youcare.appbody.Products;

import java.util.ArrayList;
import java.util.List;

public class DisplayProductsFragment extends Fragment {

    private RecyclerView recyclerViewProducts;
    private List<Product> productsList;
    private ProductsListAdapter productsListAdapter;
    private AppCompatAutoCompleteTextView actv_searchproducts;
    private TextView tv_noProducts;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_display_products, container, false);
        actv_searchproducts = view.findViewById(R.id.et_searchproducts);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        System.out.println("---> view created");
        recyclerViewProducts = view.findViewById(R.id.recyclerview_products);
        tv_noProducts = view.findViewById(R.id.tv_no_products);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerViewProducts.setLayoutManager(linearLayoutManager);

        productsList = new Products().getInstance().getProducts();
        productsListAdapter = new ProductsListAdapter(getActivity(), productsList, tv_noProducts);

        recyclerViewProducts.setAdapter(productsListAdapter);
        productsListAdapter.notifyDataSetChanged();


        // search products

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (getActivity(), android.R.layout.select_dialog_item, getResources().getStringArray(R.array.array_productstypes));

        actv_searchproducts.setThreshold(2);
        actv_searchproducts.setAdapter(adapter);

        actv_searchproducts.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 1 || actv_searchproducts.getText().toString().length() > 1) {
                    filterProducts(actv_searchproducts.getText().toString(),getActivity());
                }else{
                    productsListAdapter.filterProducts(productsList); // showing previous list
                }
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    private void filterProducts(String searchWord, Activity activity) {
        List<Product> filteredProducts = new ArrayList<>();

        for (Product product : productsList){
            if (product.getProductName().toLowerCase().matches(searchWord.toLowerCase())){
                filteredProducts.add(product);
            }
        }
        System.out.println("current products list count > "+productsList.size());
        productsListAdapter.filterProducts(filteredProducts);

        if (productsList.size() > 0 || filteredProducts.size() > 0){
           // hideKeyBoard(activity);
        }

    }

    /***
     * Hiding Keyboard after getting Products
     * @param activity
     */
    private void hideKeyBoard(Activity activity) {
        View view1 = activity.getCurrentFocus();
        if(view1 != null){
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view1.getApplicationWindowToken(), 0);
        }
    }
}
