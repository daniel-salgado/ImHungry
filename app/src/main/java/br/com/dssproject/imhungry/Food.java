package br.com.dssproject.imhungry;

/**
 * Created by danie on 10/30/2017.
 */

public class Food {

    private String foodName;
    private String foodDescription;
    private double foddPrice;

    public Food(String foodName, String foodDescription, double foddPrice) {
        this.foodName = foodName;
        this.foodDescription = foodDescription;
        this.foddPrice = foddPrice;
    }

    public Food() {

    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodDescription() {
        return foodDescription;
    }

    public void setFoodDescription(String foodDescription) {
        this.foodDescription = foodDescription;
    }

    public double getFoddPrice() {
        return foddPrice;
    }

    public void setFoddPrice(double foddPrice) {
        this.foddPrice = foddPrice;
    }


}
