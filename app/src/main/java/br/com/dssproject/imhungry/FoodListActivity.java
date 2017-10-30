package br.com.dssproject.imhungry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FoodListActivity extends AppCompatActivity {

    private List<Food> listOfFoods;
    private GridView mGridView;
    private ArrayAdapter myArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        listOfFoods = loadFood();

        mGridView = (GridView)findViewById(R.id.grdFoodList);
        myArrayAdapter = new ArrayAdapter(this,R.layout.food_list_item,listOfFoods);

        if (mGridView!=null)
        {
           // mGridView.setAdapter(myArrayAdapter);

        }

    }

    private List<Food> loadFood() {

        ArrayList<Food> tmpFoods = new ArrayList<Food>();

        tmpFoods.add(new Food("Hot Hot", "Real hot thing. This will burn your tong", 666.00));
        tmpFoods.add(new Food("Blaaaaaa", "Disgusting thing that will make you throw up ", 12.34));
        tmpFoods.add(new Food("Hot Hot", "Real hot thing. This will burn your tong", 666.00));
        tmpFoods.add(new Food("Hot Hot", "Real hot thing. This will burn your tong", 666.00));
        tmpFoods.add(new Food("Hot Hot", "Real hot thing. This will burn your tong", 666.00));

        return tmpFoods;

    }


}
