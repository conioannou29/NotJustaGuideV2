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


public class MainActivity extends AppCompatActivity {

    //private TextView mTextMessage;
    //private FrameLayout mMainFrame;
    //private TrendingFragment trendingFragment;
    //private DrinkFragment drinkFragment;
    //private NightlifeFragment nightlifeFragment;
    //private FoodFragment foodFragment;
    //private SportsFragment sportsFragment;
    private static final String TAG = "MainActivity";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    private void getImages(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        mNames.add("Havasu Falls");

        mImageUrls.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        mNames.add("Trondheim");

        mImageUrls.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        mNames.add("Portugal");

        mImageUrls.add("https://i.redd.it/j6myfqglup501.jpg");
        mNames.add("Rocky Mountain National Park");


        mImageUrls.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        mNames.add("Mahahual");

        mImageUrls.add("https://i.redd.it/k98uzl68eh501.jpg");
        mNames.add("Frozen Lake");


        mImageUrls.add("https://i.redd.it/glin0nwndo501.jpg");
        mNames.add("White Sands Desert");

        mImageUrls.add("https://i.redd.it/obx4zydshg601.jpg");
        mNames.add("Austrailia");

        mImageUrls.add("https://i.imgur.com/ZcLLrkY.jpg");
        mNames.add("Washington");

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
                    //mTextMessage.setText(R.string.title_drink);
                    Intent drinkIntent = new Intent(getBaseContext(),   DrinkActivity.class);
                    startActivity(drinkIntent);
                    //setFragment(drinkFragment);
                    return true;
                case R.id.navigation_nightlife:
                    //mTextMessage.setText(R.string.title_nightlife);
                    Intent nightlifeIntent = new Intent(getBaseContext(),   NightlifeActivity.class);
                    startActivity(nightlifeIntent);
                    //setFragment(nightlifeFragment);
                    return true;
                case R.id.navigation_trending:
                    //mTextMessage.setText(R.string.title_trending);
                    //setFragment(trendingFragment);
                    return true;
                case R.id.navigation_food:
                    //mTextMessage.setText(R.string.title_food);
                    Intent foodIntent = new Intent(getBaseContext(),   FoodActivityV2.class);
                    startActivity(foodIntent);
                    //setFragment(foodFragment);
                    return true;
                case R.id.navigation_sports:
                    //mTextMessage.setText(R.string.title_sports);
                    Intent sportsIntent = new Intent(getBaseContext(),   SportsActivity.class);
                    startActivity(sportsIntent);
                    //setFragment(sportsFragment);
                    return true;
            }
            return false;
        }

        //private void setFragment(Fragment fragment) {
        //    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        //    fragmentTransaction.replace(R.id.main_frame, fragment);
        //    fragmentTransaction.commit();
        //}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getImages();

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        //mMainFrame = (FrameLayout) findViewById(R.id.main_frame);
        //trendingFragment = new TrendingFragment();
        //drinkFragment = new DrinkFragment();
        //nightlifeFragment = new NightlifeFragment();
        //foodFragment = new FoodFragment();
        //sportsFragment = new SportsFragment();


        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.getMenu().getItem(2).setChecked(true);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


}
