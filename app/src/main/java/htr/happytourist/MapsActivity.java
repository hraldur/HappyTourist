package htr.happytourist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

import java.util.List;


public class MapsActivity extends AppCompatActivity {
    private static final String TAG = MapsActivity.class.getSimpleName();
    private int PLACE_AUTOCOMPLETE_REQUEST_CODE = 1;
    private static final int PLACE_PICKER_REQUEST = 1;
    private TextView mName;
    private TextView mAddress;
    private TextView mPhone;
    private TextView mAttribution;
    private TextView mRating;
    private CharSequence name;
    private String personName;
    private String personID;
    private String attractionId;
    private String stringRating;

    private static final LatLngBounds BOUNDS_MOUNTAIN_VIEW = new LatLngBounds(
            new LatLng(64.1419422, -21.9268126), new LatLng(64.147610, -21.922090));
    private Object mGoogleApiClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        map();
        mName = (TextView) findViewById(R.id.name);
        mAddress = (TextView) findViewById(R.id.address);
        mPhone = (TextView) findViewById(R.id.phone);
        mAttribution = (TextView) findViewById(R.id.attributions);
        mRating = (TextView) findViewById(R.id.rating);

        Button backToMap = (Button) findViewById(R.id.backToMap);
        Button writeReview = (Button) findViewById(R.id.writeReview);
        Button reviews = (Button) findViewById(R.id.reviews);





        backToMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                map();
            }
        });
        writeReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //send information to WriteReviewActivity
                Intent writeReviewIntent = new Intent(MapsActivity.this, WriteReviewActivity.class);
                writeReviewIntent.putExtra("attractionName", name.toString());
                writeReviewIntent.putExtra("attractionId", attractionId);
                writeReviewIntent.putExtra("personName", personName);
                writeReviewIntent.putExtra("personId", personID);
                writeReviewIntent.putExtra("attractionRating", stringRating);

                startActivity(writeReviewIntent);
            }
        });


        reviews.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //send information to ReviewActivity
                Intent reviewIntent = new Intent(MapsActivity.this, ReviewsActivity.class);
                reviewIntent.putExtra("attractionId", attractionId);
                reviewIntent.putExtra("attractionName", name);

                startActivity(reviewIntent);
            }
        });



    }

    public void map(){
        try {
            PlacePicker.IntentBuilder intentBuilder =
                    new PlacePicker.IntentBuilder();
            intentBuilder.setLatLngBounds(BOUNDS_MOUNTAIN_VIEW);
            Intent intent = intentBuilder.build(MapsActivity.this);
            startActivityForResult(intent, PLACE_PICKER_REQUEST);

        } catch (GooglePlayServicesRepairableException
                | GooglePlayServicesNotAvailableException e) {
         e.printStackTrace();
        }
    }
    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //get list of information about nearby places
        if (requestCode == PLACE_PICKER_REQUEST
                && resultCode == Activity.RESULT_OK) {

            Place place = PlacePicker.getPlace(data, this);

            name = place.getName();
            CharSequence address = place.getAddress();
            CharSequence number = place.getPhoneNumber();
            CharSequence attribution = place.getAttributions();
            attractionId = place.getId();
            List<Integer> types = place.getPlaceTypes();


            //get information from UserActivity
            Intent userIntent=this.getIntent();
            personName = userIntent.getStringExtra("personName");
            personID = userIntent.getStringExtra("personID");


            //set places rating
            float rating = place.getRating()*10;

            if(rating == -10.0){
                stringRating = " ";
            }
            else {
                stringRating = Float.toString(rating);
            }

            mName.setText(name);
            mAddress.setText(address);
            mPhone.setText(number);
            mAttribution.setText(attribution);
            mRating.setText(stringRating);


        }

        //set autocomplete searcher
        AutocompleteFilter typeFilter = new AutocompleteFilter.Builder()
                .setTypeFilter(AutocompleteFilter.TYPE_FILTER_ESTABLISHMENT)
                .build();

        try {
            Intent intent =
                    new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_FULLSCREEN)
                            .setFilter(typeFilter)
                            .build(this);
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }


    }

    //Override back button
    @Override
    public void onBackPressed() {

        Intent intent = new Intent(MapsActivity.this, UserActivity.class);
        startActivity(intent);
        finish();
        super.onBackPressed();

    }

}

