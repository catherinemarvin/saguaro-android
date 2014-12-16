package net.kevinhwang.saguaro;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import net.kevinhwang.saguaro.models.Food;
import net.kevinhwang.saguaro.api.MealResponse;
import net.kevinhwang.saguaro.api.SaguaroApi;
import net.kevinhwang.saguaro.api.SaguaroApiClient;
import net.kevinhwang.saguaro.lists.FoodAdapter;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";
    private ListView foodList;
    private ArrayAdapter<Food> foodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
        this.foodList = (ListView) findViewById(R
                .id.food_list_view);
        this.foodAdapter = new FoodAdapter(this, R.layout.food_item);
        this.foodList.setAdapter(this.foodAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void submit(View view) {
        Log.v(TAG, "Submit!");
        SaguaroApi api = SaguaroApiClient.getClient();

        EditText moneyField = (EditText) findViewById(R.id.total_money);
        Integer money = Integer.parseInt(moneyField.getText().toString());
        api.getMeal(money, "Taco Bell", new Callback<List<Food>>() {
            @Override
            public void success(List<Food> food, Response response) {
                Log.v(TAG, "Successful response!");
                Log.v(TAG, food.toString());
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e(TAG, "Failed to get a response", error);
            }
        });
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }
}
