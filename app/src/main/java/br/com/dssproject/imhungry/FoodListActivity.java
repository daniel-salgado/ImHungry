package br.com.dssproject.imhungry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FoodListActivity extends AppCompatActivity {

    Button btnDecrFoodQuantity;
    Button btnIncrFoodQuantity;
    TextView txtFoodQuantity;
    private ArrayList<Food> listOfFoods;
    private ListView mGridView;
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

        mGridView = (ListView) findViewById(R.id.grdFoodList);
        //myArrayAdapter = new ArrayAdapter(this,R.layout.food_list_item,listOfFoods);
        myArrayAdapter = new FoodAdapter(this, R.layout.food_row_layout, listOfFoods);

        if (mGridView != null) {
            mGridView.setAdapter(myArrayAdapter);
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

        View v = mGridView.getChildAt(index - mGridView.getFirstVisiblePosition() + mGridView.getHeaderViewsCount());

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
