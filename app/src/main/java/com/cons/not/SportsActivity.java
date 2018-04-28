package com.cons.not;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.ParseException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.cons.not.model.PlacesModel;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class SportsActivity extends AppCompatActivity {

    private static final String TAG = "SportsActivity";

    //vars
    //private ArrayList<PlacesModel> mPlaces = new ArrayList<>();
    ArrayList<PlacesModel> placesList;

    RecyclerViewAdapter adapter;
    private RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);

        placesList = new ArrayList<PlacesModel>();
        new JSONAsyncTask().execute("https://api.myjson.com/bins/1e80q7");

        recyclerview = (RecyclerView) findViewById(R.id.recyclerView);
        adapter = new RecyclerViewAdapter(this,placesList);

        recyclerview.setAdapter(adapter);

        initRecyclerView();

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }

    class JSONAsyncTask extends AsyncTask<String, Void, Boolean> {

        ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(SportsActivity.this);
            dialog.setMessage("Be patience, please wait");
            dialog.setTitle("We are retrieve the best places for you");
            dialog.show();
            dialog.setCancelable(false);
        }

        @Override
        protected Boolean doInBackground(String... urls) {
            try {

                //------------------>>
                HttpGet httppost = new HttpGet(urls[0]);
                HttpClient httpclient = new DefaultHttpClient();
                HttpResponse response = httpclient.execute(httppost);

                // StatusLine stat = response.getStatusLine();
                int status = response.getStatusLine().getStatusCode();

                if (status == 200) {
                    HttpEntity entity = response.getEntity();
                    String data = EntityUtils.toString(entity);

                    JSONArray jarray = new JSONArray(data);

                    for (int i = 0; i < jarray.length(); i++) {
                        JSONObject object = jarray.getJSONObject(i);

                        PlacesModel places = new PlacesModel();

                        places.setImgUrl(object.getString("imgUrl"));
                        places.setName(object.getString("name"));
                        places.setDescription(object.getString("description"));
                        places.setWebsite(object.getString("website"));
                        places.setAddress(object.getString("address"));
                        places.setPhone(object.getString("phone"));
                        places.setOpeningHours(object.getString("openingHours"));
                        places.setMapUrl(object.getString("mapUrl"));

                        placesList.add(places);
                    }
                    return true;
                }

                //------------------>>

            } catch (ParseException e1) {
                e1.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return false;
        }

        protected void onPostExecute(Boolean result) {
            dialog.cancel();
            adapter = new RecyclerViewAdapter(SportsActivity.this,placesList);

            recyclerview.setAdapter(adapter);
            adapter.notifyDataSetChanged();
            if(result == false)
                Toast.makeText(getApplicationContext(), "Unable to fetch data from server", Toast.LENGTH_LONG).show();

        }
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");

        GridLayoutManager layoutManager = new GridLayoutManager(this,2, GridLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, placesList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_drink:
                    Intent drinkIntent = new Intent(getBaseContext(),   DrinkActivity.class);
                    startActivity(drinkIntent);
                    return true;
                case R.id.navigation_nightlife:
                    Intent nightlifeIntent = new Intent(getBaseContext(),   NightlifeActivity.class);
                    startActivity(nightlifeIntent);
                    return true;
                case R.id.navigation_trending:
                    Intent trendingIntent = new Intent(getBaseContext(),   MainActivity.class);
                    startActivity(trendingIntent);
                    return true;
                case R.id.navigation_food:
                    Intent foodIntent = new Intent(getBaseContext(),   FoodActivityV2.class);
                    startActivity(foodIntent);
                    return true;
                case R.id.navigation_sports:
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(navigation);
        navigation.getMenu().getItem(4).setChecked(true);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }




}
