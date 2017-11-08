package br.com.dssproject.imhungry.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.com.dssproject.imhungry.R;

public class DeliveryDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_details);
    }

    public void btnPlaceOrder(View view)
    {

        Intent intent = new Intent(this, DeliveryStatusActivity.class);


        startActivity(intent);


    }

}
