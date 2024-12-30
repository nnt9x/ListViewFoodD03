package com.bkacad.edu.nnt.listviewfoodd03.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bkacad.edu.nnt.listviewfoodd03.R;
import com.bkacad.edu.nnt.listviewfoodd03.model.Food;
import com.bumptech.glide.Glide;

import java.util.List;

public class FoodAdapter extends BaseAdapter {

    private Context context;
    private List<Food> data;

    public FoodAdapter(Context context, List<Food> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Itemview
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_food, parent, false);
        }
        // View va bind Id
        ImageView imgFood = convertView.findViewById(R.id.img_item_food);
        TextView tvName = convertView.findViewById(R.id.tv_item_food_name);
        TextView tvDescription = convertView.findViewById(R.id.tv_item_food_description);
        TextView tvRating = convertView.findViewById(R.id.tv_item_food_rating);
        TextView tvDuration = convertView.findViewById(R.id.tv_item_food_duration);
        TextView tvDiscount = convertView.findViewById(R.id.tv_item_food_discount);

        // Do du lieu vao view
        Food food = data.get(position);
        Glide.with(convertView).load(food.getImage()).into(imgFood);
        tvName.setText(food.getName());
        tvDescription.setText("....");
        tvRating.setText(food.getRating() + " star");
        tvDuration.setText(food.getDiscount() + " mins");

        tvDiscount.setText(food.getDiscount() + "% off");
        if (food.getDiscount() == 0) {
            tvDiscount.setVisibility(View.GONE);
        }

        return convertView;
    }
}
