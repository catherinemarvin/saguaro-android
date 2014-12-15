package net.kevinhwang.saguaro.api;

import net.kevinhwang.saguaro.models.Food;

import java.util.List;

/**
 * Created by khwang on 12/14/14.
 */
public class MealResponse {
    private List<Food> food;

    private MealResponse(List<Food> food) {
        super();
        this.food = food;
    }

    public List<Food> getFood() {
        return food;
    }

    public void setFood(List<Food> food) {
        this.food = food;
    }
}
