package com.cons.not;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class PlacesDesc_Activity extends AppCompatActivity {

    private static final String TAG = "PlacesDesc_Activity";

    ImageButton dial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_desc_);

        Log.d(TAG, "onCreate: started.");

        getIncomingIntent();

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        TextView link = (TextView) findViewById(R.id.Website_Details);
        link.setMovementMethod(LinkMovementMethod.getInstance());

        TextView map = (TextView) findViewById(R.id.mapDetails);
        link.setMovementMethod(LinkMovementMethod.getInstance());

        // initiate and perform click event on button's
        ImageButton phone = (ImageButton)findViewById(R.id.phoneButton);
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialNumber();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(navigation);
        navigation.getMenu().getItem(2).setChecked(true);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void dialNumber() {
        TextView textView = (TextView) findViewById(R.id.Phone_Details);
        // Use format with "tel:" and phone number to create phoneNumber.
        String phoneNumber = String.format("tel: %s",
                textView.getText().toString());
        // Create the intent.
        Intent dialIntent = new Intent(Intent.ACTION_DIAL);
        // Set the data for the intent as the phone number.
        dialIntent.setData(Uri.parse(phoneNumber));
        // If package resolves to an app, send intent.
        if (dialIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(dialIntent);
        } else {
            Log.e(TAG, "Can't resolve app for ACTION_DIAL Intent.");
        }
    }
    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");

        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name") && getIntent().hasExtra("description")&& getIntent().hasExtra("address")&& getIntent().hasExtra("phone")&& getIntent().hasExtra("openingHours")&& getIntent().hasExtra("website")&& getIntent().hasExtra("map_url")){
            Log.d(TAG, "getIncomingIntent: found intent extras.");

            String imageUrl = getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("image_name");
            String descriptionDetails = getIntent().getStringExtra("description");
            String addressDetails = getIntent().getStringExtra("address");
            String phoneDetails = getIntent().getStringExtra("phone");
            String hoursDetails = getIntent().getStringExtra("openingHours");
            String websiteDetails = getIntent().getStringExtra("website");
            String mapLink = getIntent().getStringExtra("map_url");

            setImage(imageUrl, imageName, descriptionDetails, addressDetails, phoneDetails, hoursDetails, websiteDetails, mapLink);
        }
    }


    private void setImage(String imageUrl, String imageName, String descriptionDetails, String addressDetails, String phoneDetails, String hoursDetails, String websiteDetails, String mapLink){
        Log.d(TAG, "setImage: setting te image and name to widgets.");

        TextView name = findViewById(R.id.name);
        name.setText(imageName);

        TextView description = findViewById(R.id.Description_Details);
        description.setText(descriptionDetails);

        TextView address = findViewById(R.id.Address_Details);
        address.setText(addressDetails);

        TextView phone = findViewById(R.id.Phone_Details);
        phone.setText(phoneDetails);

        TextView hours = findViewById(R.id.Hours_Details);
        hours.setText(hoursDetails);

        TextView website = findViewById(R.id.Website_Details);
        website.setText(websiteDetails);

        TextView map = findViewById(R.id.mapDetails);
        map.setText(mapLink);

        ImageView image = findViewById(R.id.image_view);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(image);
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
                    Intent sportsIntent = new Intent(getBaseContext(),   SportsActivity.class);
                    startActivity(sportsIntent);
                    return true;
            }
            return false;
        }
    };
}

/*ImageButton mIdButtonHome = (ImageButton)findViewById(R.id.mapButton);
        mIdButtonHome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String mapLink = "http://www.google.com";
                Intent browserIntent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(mapLink));
                startActivity(browserIntent);
            }
        });*/