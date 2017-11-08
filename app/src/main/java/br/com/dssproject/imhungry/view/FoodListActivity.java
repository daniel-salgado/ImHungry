package br.com.dssproject.imhungry.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.dssproject.imhungry.domain.Food;
import br.com.dssproject.imhungry.adapter.FoodAdapter;
import br.com.dssproject.imhungry.R;

public class FoodListActivity extends AppCompatActivity {

    Button btnDecrFoodQuantity;
    Button btnIncrFoodQuantity;
    TextView txtFoodQuantity;
    private ArrayList<Food> listOfFoods;
    private ListView foodListView;
    private ArrayAdapter myArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        overridePendingTransition(R.anim.grow_from_middle, R.anim.shrink_to_middle);

        btnDecrFoodQuantity = (Button) findViewById(R.id.btnDecrFoodQuantity);
        btnIncrFoodQuantity = (Button) findViewById(R.id.btnIncrFoodQuantity);
        txtFoodQuantity = (TextView) findViewById(R.id.txtFoodQuantity);

        listOfFoods = loadFood();

        foodListView = (ListView) findViewById(R.id.grdFoodList);

        myArrayAdapter = new FoodAdapter(this, R.layout.food_row_layout, listOfFoods);

        if (foodListView != null) {
            foodListView.setAdapter(myArrayAdapter);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    //https://stackoverflow.com/questions/7479992/handling-a-menu-item-click-event-android
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_cart:

                ArrayList<Food> orderItems = new ArrayList<Food>();

                for (Food food : listOfFoods) {

                    if (food.getFoodQuantity() > 0)
                        orderItems.add(food);

                }


                if (orderItems.size() > 0) {

                    Intent intent = new Intent(this, OrderDetailsActivity.class);
                    intent.putExtra("order_items", orderItems);

                    startActivity(intent);


                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }

    public void btnChangeFoodQuantity(View view) {

        Integer viewPosition = (Integer) view.getTag();
        Food food = listOfFoods.get(viewPosition);

        switch (view.getId()) {
            case (R.id.btnIncrFoodQuantity):
                food.addFoodQuantity();

                break;
            case (R.id.btnDecrFoodQuantity):
                food.subFoodQuantity();
                break;

        }

        updateSetTopState(viewPosition, food);


    }

    //WorkArround to get the list updated
    //https://stackoverflow.com/questions/3724874/how-can-i-update-a-single-row-in-a-listview
    private void updateSetTopState(int index, Food food) {

        View v = foodListView.getChildAt(index - foodListView.getFirstVisiblePosition() + foodListView.getHeaderViewsCount());

        if (v == null)
            return;

        TextView txtFoodQuantity = (TextView) v.findViewById(R.id.txtFoodQuantity);
        txtFoodQuantity.setVisibility(View.VISIBLE);

        txtFoodQuantity.setText(String.valueOf(food.getFoodQuantity()));

    }

    private ArrayList<Food> loadFood() {

        ArrayList<Food> tmpFoods = new ArrayList<Food>();

        tmpFoods.add(new Food("Hot Hot", "Real hot thing. This will burn your tong", 666.00));
        tmpFoods.add(new Food("Blaaaaaarggghhhhhh", "Disgusting thing that will make you throw up ", 12.34));
        tmpFoods.add(new Food("Nothing", "Nothing", 666.00));
        tmpFoods.add(new Food("Hot Hot", "Real hot thing. This will burn your tong", 666.00));
        tmpFoods.add(new Food("Hot Hot", "Real hot thing. This will burn your tong", 666.00));

        return tmpFoods;

    }


}
