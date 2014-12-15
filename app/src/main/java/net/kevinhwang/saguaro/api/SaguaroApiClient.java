package net.kevinhwang.saguaro.api;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by khwang on 12/14/14.
 */
public class SaguaroApiClient {

    private static final Object INSTANCE_LOCK = new Object();
    private static SaguaroApi SHARED_INSTANCE;
    private static final String ENDPOINT = "https://hidden-river-2667.herokuapp.com/api/v1/meal";

    public static SaguaroApi getClient() {
        if (SHARED_INSTANCE == null) {
            synchronized (INSTANCE_LOCK) {
                if (SHARED_INSTANCE == null) {

                    RestAdapter.Builder builder = new RestAdapter.Builder()
                            .setEndpoint(ENDPOINT);

                    RestAdapter adapter = builder.build();

                    SHARED_INSTANCE = adapter.create(SaguaroApi.class);
                }
            }

        }
        return SHARED_INSTANCE;

    }
}
