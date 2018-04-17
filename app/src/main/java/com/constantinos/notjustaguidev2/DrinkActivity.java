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

import java.util.ArrayList;

public class DrinkActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    private void getImages(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("http://www.bondstcoffee.co.uk/uploads/1/2/1/8/12180628/9294160.jpg?130");
        mNames.add("Bond St. Coffee");

        mImageUrls.add("https://pbs.twimg.com/profile_images/688772991061258242/fuzY1MUe_400x400.jpg");
        mNames.add("Cafe Coho");

        mImageUrls.add("http://static1.squarespace.com/static/57cea0f215d5db35c689f00a/t/57cea51459cc6804d1941d10/1522144696923/?format=1500w");
        mNames.add("The Hope and Ruin Bar");

        mImageUrls.add("https://pbs.twimg.com/profile_images/541539530486984704/aXc3_Jyc_400x400.jpeg");
        mNames.add("Sticky Mike's");

        mImageUrls.add("https://static1.squarespace.com/static/5869689344024318a07a2c5b/58e4203d03596e5486676b28/58e42040440243062e6f8c56/1491345475245/File_000.jpeg");
        mNames.add("The Pond Bar");

        mImageUrls.add("http://www.morgenrot.co.uk/wp-content/uploads/2018/01/BLOCK-logo-300x300.jpg");
        mNames.add("Block Bar");


        mImageUrls.add("https://restaurantsbrighton.co.uk/wp-content/uploads/2017/03/Pelicano-Coffee.jpg");
        mNames.add("Pelicano Cafe");

        mImageUrls.add("https://www.boxpark.co.uk/assets/Managed/RetailerGalleries/1183-small-batch-coffee/_resampled/ScaleWidthWyI3NTAiXQ/web-coffee-01.jpg");
        mNames.add("Small Batch Roasters");

        mImageUrls.add("https://thelatest.co.uk/files/2017/10/Lucky-Beach-pic.jpg");
        mNames.add("Lucky Beach Cafe");

        mImageUrls.add("http://static1.squarespace.com/static/555c66f2e4b0c9386f4ed370/t/555f1b12e4b07f0c95440914/1521892326402/?format=1500w");
        mNames.add("King & Queen Bar");

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
        navigation.getMenu().getItem(0).setChecked(true);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        getImages();

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }

}
