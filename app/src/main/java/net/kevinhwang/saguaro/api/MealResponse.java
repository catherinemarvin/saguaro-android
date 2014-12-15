package net.kevinhwang.saguaro.api;

import net.kevinhwang.saguaro.models.Food;

import java.util.List;

/**
 * Created by khwang on 12/14/14.
 */
public class MealResponse {
    private Food food;

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}
