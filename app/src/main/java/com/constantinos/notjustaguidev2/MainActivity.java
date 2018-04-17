package com.constantinos.notjustaguidev2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.constantinos.notjustaguidev2.model.PlacesModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //var
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    private void getImages(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("http://mothershipgroup.com/wp-content/uploads/2015/03/patterns-blk-low-624x624.png");
        mNames.add("Patterns");

        mImageUrls.add("https://pbs.twimg.com/profile_images/3636571478/3d77263fbbb4b46dafd36f86ab7554d7_400x400.jpeg");
        mNames.add("Burger Brothers");

        mImageUrls.add("https://renewable-world.org/app/uploads/2016/11/yellowave_logo.jpg");
        mNames.add("Yellowave Sports");

        mImageUrls.add("https://pbs.twimg.com/profile_images/598523721205297152/kMhM3RF-_400x400.png");
        mNames.add("Dead Wax Social");

        mImageUrls.add("https://pbs.twimg.com/profile_images/3507778530/92799f4aed9af1de5a5e3f3b45c4f9f5_400x400.png");
        mNames.add("Resident Music");

        mImageUrls.add("http://www.morgenrot.co.uk/wp-content/uploads/2018/01/BLOCK-logo-300x300.jpg");
        mNames.add("Block Bar");


        mImageUrls.add("http://www.b4bguide.com/brighton/wp-content/uploads/sites/2/2015/10/1112_Sorrento-1.jpg");
        mNames.add("V.I.P.");

        mImageUrls.add("http://www.cloud9brighton.co.uk/wp-content/uploads/2014/11/Cloud9_website_logo.png");
        mNames.add("Cloud 9");

        initRecyclerView();

    }


    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");

        GridLayoutManager layoutManager = new GridLayoutManager(this,2, GridLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls);
        recyclerView.setAdapter(adapter);
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
                    return true;
                case R.id.navigation_food:
                    Intent foodIntent = new Intent(getBaseContext(),   FoodActivityV2.class);
                    startActivity(foodIntent);
                    return true;
                case R.id.navigation_sports:
                    Intent sportsIntent = new Intent(getBaseContext(),   SportsActivity.class);
                    startActivity(sportsIntent);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.getMenu().getItem(2).setChecked(true);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getImages();

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        class JsonToJava {

            public void main(String[] args) throws IOException {
                try(Reader reader = new InputStreamReader(JsonToJava.class.getResourceAsStream("/assets/dataTrending.json"), "UTF-8")){
                    Gson gson = new GsonBuilder().create();
                    PlacesModel places = gson.fromJson(reader, PlacesModel.class);
                    System.out.println(places);
                }
            }
        }
    }
}
