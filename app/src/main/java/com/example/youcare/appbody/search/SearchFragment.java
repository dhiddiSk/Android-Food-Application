//package com.example.youcare.appbody.search;
//
//import androidx.annotation.Nullable;
//
//import android.app.Fragment;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ListView;
//import android.widget.SearchView;
//
//import com.example.youcare.FoodNames;
//import com.example.youcare.ListViewAdapter;
//import com.example.youcare.R;
//
//import java.util.ArrayList;
//
//public class SearchFragment extends Fragment implements SearchView.OnQueryTextListener{
//
//
//    ListView list;
//    ListViewAdapter adapter;
//    SearchView editsearch;
//    String[] foodNameList;
//    ArrayList<FoodNames> arraylist = new ArrayList<FoodNames>();
//
//
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.activity_app_body_navigation_search_fragment, container, false);
//
//        return view;
//    }
//
//
//    @Override
//    public boolean onQueryTextSubmit(String query) {
//        return false;
//    }
//
//    @Override
//    public boolean onQueryTextChange(String newText) {
//        return false;
//    }
//}
