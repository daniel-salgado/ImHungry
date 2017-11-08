package br.com.dssproject.imhungry.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import br.com.dssproject.imhungry.domain.Food;
import br.com.dssproject.imhungry.R;

/**
 * Created by danie on 10/30/2017.
 */

public class FoodAdapter extends ArrayAdapter<Food>
{
    Context mContext;
    int mLayoutResourceId;
    List<Food> listOfFoods;

    public FoodAdapter(Context context, int resource, List<Food> listOfFoods) {
        super(context, resource, listOfFoods);

        this.mContext=context;
        this.mLayoutResourceId = resource;
        this.listOfFoods = listOfFoods;
    }

    @Override
    public Food getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        //return super.getView(position, convertView, parent);

        View row = convertView;
        FoodHolder holder = null;

        if (row == null)
        {
            //Create a new View
            LayoutInflater inflater = LayoutInflater.from(mContext);
            row = inflater.inflate(mLayoutResourceId, parent, false);

            holder = new FoodHolder();

            holder.txtFoodTitle = (TextView) row.findViewById(R.id.txtFoodTitle);
            holder.txtFoodSubTitle = (TextView) row.findViewById(R.id.txtFoodSubTitle);
            holder.txtFoodPrice = (TextView) row.findViewById(R.id.txtFoodPrice);
            holder.txtFoodQuantity = (TextView) row.findViewById(R.id.txtFoodQuantity);

            row.setTag(holder);

        }
        else
        {
            holder = (FoodHolder) row.getTag();
        }

        Food food = listOfFoods.get(position);

        //get reference to the different view elements we wish to update

        holder.txtFoodTitle.setText(food.getFoodName());
        holder.txtFoodSubTitle.setText(food.getFoodDescription());
        holder.txtFoodPrice.setText(String.valueOf(food.getFoddPrice()));
        holder.txtFoodQuantity.setText(String.valueOf(food.getFoodQuantity()));

        holder.btnIncrFoodQuantity = (Button) row.findViewById(R.id.btnIncrFoodQuantity);
        holder.btnIncrFoodQuantity.setTag(position);

        holder.btnDecrFoodQuantity = (Button) row.findViewById(R.id.btnDecrFoodQuantity);
        holder.btnDecrFoodQuantity.setTag(position);

        return row;

    }

    private static class FoodHolder{
        TextView txtFoodTitle;
        TextView txtFoodSubTitle;
        TextView txtFoodPrice;
        TextView txtFoodQuantity;
        Button btnIncrFoodQuantity;
        Button btnDecrFoodQuantity;

    }

}
