package com.constantinos.notjustaguidev2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;



public class MainActivity extends AppCompatActivity {

    //private TextView mTextMessage;
    //private FrameLayout mMainFrame;
    //private TrendingFragment trendingFragment;
    //private DrinkFragment drinkFragment;
    //private NightlifeFragment nightlifeFragment;
    //private FoodFragment foodFragment;
    //private SportsFragment sportsFragment;

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
