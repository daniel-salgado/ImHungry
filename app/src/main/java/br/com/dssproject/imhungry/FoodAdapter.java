package br.com.dssproject.imhungry;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by danie on 10/30/2017.
 */

public class FoodAdapter extends ArrayAdapter<Food>
{
    Context mContext;
    int mLayoutResourceId;
    List<Food> listOfFoods;

    public FoodAdapter(@NonNull Context context, int resource, @NonNull List<Food> listOfFoods) {
        super(context, resource, listOfFoods);

        this.mContext=context;
        this.mLayoutResourceId = resource;
        this.listOfFoods = listOfFoods;
    }

    @Nullable
    @Override
    public Food getItem(int position) {
        return super.getItem(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //return super.getView(position, convertView, parent);

        View row = convertView;

        Food food = listOfFoods.get(position);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        row = inflater.inflate(mLayoutResourceId, parent, false);

        //get reference to the different view elements we wish to update

        TextView txtFoodTitle = (TextView) row.findViewById(R.id.txtFoodTitle);
        TextView txtFoodSubTitle = (TextView) row.findViewById(R.id.txtFoodSubTitle);
        TextView txtFoodPrice = (TextView)row.findViewById(R.id.txtFoodPrice);

        txtFoodTitle.setText(food.getFoodName());
        txtFoodSubTitle.setText(food.getFoodDescription());
        txtFoodPrice.setText(String.valueOf(food.getFoddPrice()));

        //int resId = mContext.getResources().getIdentifier(food.getFoodName(),"drawable", mContext.getPackageName());


        return row;

    }
}
