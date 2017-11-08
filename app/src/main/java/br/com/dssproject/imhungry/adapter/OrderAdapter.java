package br.com.dssproject.imhungry.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.dssproject.imhungry.R;
import br.com.dssproject.imhungry.domain.Food;

/**
 * Created by danie on 10/30/2017.
 */

public class OrderAdapter extends ArrayAdapter<Food> {

    Context mContext;
    int mLayoutResourceId;
    List<Food> orderItems;

    public OrderAdapter(Context context, int resource, List<Food> orderItems) {
        super(context, resource, orderItems);

        this.mContext = context;
        this.mLayoutResourceId = resource;
        this.orderItems = orderItems;

    }

    @Override
    public Food getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);

        View row = convertView;
        OrderHolder holder = null;

        if (row == null) {
            //Create a new View
            LayoutInflater inflater = LayoutInflater.from(mContext);
            row = inflater.inflate(mLayoutResourceId, parent, false);

            holder = new OrderHolder();

            holder.txtFoodTitle = (TextView) row.findViewById(R.id.txtFoodTitle);
            holder.txtFoodPrice = (TextView) row.findViewById(R.id.txtFoodPrice);
            holder.txtFoodQuantity = (TextView) row.findViewById(R.id.txtFoodQuantity);

            row.setTag(holder);

        } else {
            holder = (OrderHolder) row.getTag();
        }

        Food food = orderItems.get(position);

        //get reference to the different view elements we wish to update

        holder.txtFoodTitle.setText(food.getFoodName());
        holder.txtFoodPrice.setText("$ " + String.valueOf(food.getFoddPrice()));
        holder.txtFoodQuantity.setText("x " + String.valueOf(food.getFoodQuantity()));

        return row;

    }

    private static class OrderHolder {
        TextView txtFoodTitle;
        TextView txtFoodPrice;
        TextView txtFoodQuantity;

    }


}
