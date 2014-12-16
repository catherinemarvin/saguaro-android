package net.kevinhwang.saguaro.lists;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

import net.kevinhwang.saguaro.R;
import net.kevinhwang.saguaro.models.Food;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by khwang on 12/15/14.
 */
public class FoodAdapter extends ArrayAdapter<Food> {

    public FoodAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get data item for this position
        Food food = getItem(position);

        // Check if an existing view is being reused; else inflate the view.
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.food_item, parent, false);
        }

        // Lookup view for data population

        TextView foodName = (TextView) convertView.findViewById(R.id.foodName);
        TextView foodCalories = (TextView) convertView.findViewById(R.id.foodCalories);

        // Populate data
        foodName.setText(food.getName());
        foodCalories.setText(food.getCalories());

        return convertView;
    }
}
