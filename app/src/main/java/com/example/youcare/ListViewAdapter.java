package com.example.youcare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {

    Context mContext;
    LayoutInflater inflater;
    private List<FoodNames> foodNamesList = null;
    private ArrayList<FoodNames> arraylist;

    public ListViewAdapter(Context context, List<FoodNames> animalNamesList) {
        mContext = context;
        this.foodNamesList = animalNamesList;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<FoodNames>();
        this.arraylist.addAll(animalNamesList);
    }

    public class ViewHolder {
        TextView name;
    }

    @Override
    public int getCount() {
        return foodNamesList.size();
    }

    @Override
    public FoodNames getItem(int position) {
        return foodNamesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.activity_list_view_items, null);
            // Locate the TextViews in listview_item.xml
            holder.name = (TextView) view.findViewById(R.id.name);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.name.setText(foodNamesList.get(position).getFoodName());
        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        foodNamesList.clear();
        if (charText.length() == 0) {
            foodNamesList.addAll(arraylist);
        } else {
        for (FoodNames wp : arraylist) {
                if (wp.getFoodName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    foodNamesList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}
