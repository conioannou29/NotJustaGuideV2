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


public class NightlifeActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    private void getImages(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://cdn2.fatsoma.com/media/W1siZiIsInB1YmxpYy8yMDE1LzMvMi8wLzIwLzI2LzUzOC8xNTM2IHggMjA0OHB4LmpwZyJdXQ");
        mNames.add("Shoosh");

        mImageUrls.add("http://mothershipgroup.com/wp-content/uploads/2015/03/patterns-blk-low-624x624.png");
        mNames.add("Patterns");

        mImageUrls.add("https://pbs.twimg.com/profile_images/378800000429263279/090b597455a9b2badcdaab6d68b547db.jpeg");
        mNames.add("Revolution");

        mImageUrls.add("https://media-cdn.tripadvisor.com/media/photo-s/04/7a/fc/1d/revenge.jpg");
        mNames.add("Revenge");

        mImageUrls.add("https://dhzjvxyl79yzn.cloudfront.net/8/22168.jpg");
        mNames.add("The Haunt");

        mImageUrls.add("https://pbs.twimg.com/profile_images/473860302186893314/le8Nv7dA.jpeg");
        mNames.add("Concorde 2");

        mImageUrls.add("data:image/png;base64,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");
        mNames.add("The Arch");

        mImageUrls.add("data:image/jpeg;base64,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");
        mNames.add("PRYZM");

        mImageUrls.add("http://thegreendoorstore.co.uk/wp-content/uploads/2017/02/sharingimage.png");
        mNames.add("Green Door");

        mImageUrls.add("https://dhzjvxyl79yzn.cloudfront.net/6/67606_1_no-32.jpg");
        mNames.add("No 32");

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
        navigation.getMenu().getItem(1).setChecked(true);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nightlife);

        getImages();

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);


    }

}
