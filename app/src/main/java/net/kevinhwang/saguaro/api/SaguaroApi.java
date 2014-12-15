package net.kevinhwang.saguaro.api;

import net.kevinhwang.saguaro.models.Food;

import java.util.List;
import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by khwang on 12/14/14.
 */

public interface SaguaroApi {

    @GET("/meal")
    void getMeal(@Query("money") Integer money, @Query("source") String source, Callback<List<MealResponse>> callback);
}
