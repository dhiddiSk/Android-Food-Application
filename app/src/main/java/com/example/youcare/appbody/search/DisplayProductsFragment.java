package com.example.youcare.appbody.search;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ProductsListAdapter;
import com.example.youcare.R;
import com.example.youcare.appbody.Product;

import java.util.ArrayList;
import java.util.List;

public class DisplayProductsFragment extends Fragment {

    private RecyclerView recyclerViewProducts;
    private List<Product> productsList;
    private ProductsListAdapter productsListAdapter;
    private AppCompatAutoCompleteTextView actv_searchproducts;

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
        recyclerViewProducts = view.findViewById(R.id.recyclerview_products);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerViewProducts.setLayoutManager(linearLayoutManager);

        productsList = new ArrayList<>();
        productsListAdapter = new ProductsListAdapter(getActivity(), productsList);

        productsList.add(new Product("milk", "Demeter MilchBauern Schwarzwald-","no","yes","yes","no",3,3,	"2.5",""));
        productsList.add(new Product( "milk", "Schwarzwaldmilch GmbH Freiburg","no",	"yes","yes","no",2,3,"1.5", ""));
        productsList.add(new Product( "milk","ARLA Foods Deutschl.GmbH/Hansa","no","yes","yes","no",1,3,"1",""));
        productsList.add(new Product("milk","Andechser Molkerei Scheitz GmbH","no","yes","yes","no",2,2,"1",""));
        productsList.add(new Product("milk","Milchw.Berchtesgad.Land Chiemgau eG","no","yes","yes","no",2,1	,"2",""));
        productsList.add(new Product("milk","Alpro Comm. VA/SCA","yes","no","yes","yes",2,1,"2",""));
        productsList.add(new Product("milk","Oatly Germany GmbH","yes","no","yes","yes",2,	3,"3",""));
        productsList.add(new Product( "choclate cream",	"Rigoni di Asiago Nocciolata","no","yes","yes","no",2,1,"4.45",""));
        productsList.add(new Product("choclate cream","Franken Genuss Haselnuss-Nougat Ausftrich","no","yes","yes","no",3,0,"6.9",""));
        productsList.add(new Product("choclate cream","Nudossi","no","yes","yes","no",2,0,"2.99",""));
        productsList.add(new Product("choclate cream","Keimling vegane Schokocreme","yes","no","yes","yes",2,2,"8.95",""));
        productsList.add(new Product("choclate cream","Gepa Cocoba","no","yes","yes","no",1,2,"4.49",""));
        productsList.add(new Product("choclate cream","Bionella- Rapunzel","yes","no","yes","yes",2,1,"3.99",""));
        productsList.add(new Product("choclate cream","Rewe Bio Nuss-Nougat-Creme","yes","no","yes",	"yes",2,1,"2.99",""));
        productsList.add(new Product("banana","Bananen Chiquita kg","no","yes","yes","yes",2,0,"1.99",""));
        productsList.add(new Product("banana","K-Bio Bananen kg","no","yes","yes","yes",1,0,"2.29",""));
        productsList.add(new Product("banana","Rewe Beste Wahl","no","yes","yes","yes",2,0,"1.89",""));
        productsList.add(new Product("banana","Bananen Baby 250g St.","no","yes","yes","yes",3,0,"1.99",""));
        productsList.add(new Product( "banana","Kochbananen kg","no","yes","yes","yes",2,3,"2.29",""));
        productsList.add(new Product("banana","Bananen kg","no","yes","yes","yes",2,3,"1.89",""));
        productsList.add(new Product( "banana","Bananen Demeter kg","no","yes","yes","yes",2,2,"1.99",""));

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
                    filterProducts(actv_searchproducts.getText().toString());
                }else{
                    productsListAdapter.filterProducts(productsList); // showing previous list
                }
            }
        });

    }

    private void filterProducts(String searchWord) {
        List<Product> filteredProducts = new ArrayList<>();

        for (Product product : productsList){
            if (product.getProductName().toLowerCase().matches(searchWord.toLowerCase())){
                filteredProducts.add(product);
            }
        }
        System.out.println("current products list count > "+productsList.size());
        productsListAdapter.filterProducts(filteredProducts);

    }


}
