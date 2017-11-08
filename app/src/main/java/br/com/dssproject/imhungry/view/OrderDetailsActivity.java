package br.com.dssproject.imhungry.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.dssproject.imhungry.R;
import br.com.dssproject.imhungry.adapter.FoodAdapter;
import br.com.dssproject.imhungry.adapter.OrderAdapter;
import br.com.dssproject.imhungry.domain.Food;

public class OrderDetailsActivity extends AppCompatActivity {


    private ArrayList<Food> orderItems;
    private ListView orderDetailsListView;
    private ArrayAdapter myArrayAdapter;

    private TextView txtTotalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_order_details);

        txtTotalPrice = (TextView) findViewById(R.id.txtTotalPrice);

        Intent intent = getIntent();

        orderItems = (ArrayList<Food>) intent.getSerializableExtra("order_items");

        orderDetailsListView = (ListView) findViewById(R.id.orderDetailsListView);
        myArrayAdapter = new OrderAdapter(this, R.layout.order_item_layout, orderItems);

        if (orderDetailsListView != null) {
            orderDetailsListView.setAdapter(myArrayAdapter);
        }


        txtTotalPrice.setText("$ " + String.format("%.2f", calcTotal()));


    }

    public void btnCheckOut(View view)
    {

        Intent intent = new Intent(this, DeliveryDetailsActivity.class);
        startActivity(intent);

    }

    private double calcTotal() {

        double totalPrice = 0;

        for (Food orderItem : orderItems)
            totalPrice = +orderItem.getFoddPrice() * orderItem.getFoodQuantity();

        return totalPrice;
    }

}
