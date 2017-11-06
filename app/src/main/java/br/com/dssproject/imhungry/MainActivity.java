package br.com.dssproject.imhungry;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnHungry(View view) {

        Toast.makeText(MainActivity.this,"Hey", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, FoodListActivity.class);



        startActivity(intent);

    }

}
