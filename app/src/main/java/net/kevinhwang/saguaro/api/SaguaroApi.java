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

    @FormUrlEncoded
    @GET("/meal")
    void getMeal(@Field("money") Integer money, @Field("source") String source, Callback<MealResponse> callback);
}
