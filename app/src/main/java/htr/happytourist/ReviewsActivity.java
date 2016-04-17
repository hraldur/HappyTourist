package htr.happytourist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import htr.happytourist.Fragment.ReviewsFragment;

public class ReviewsActivity extends AppCompatActivity {
    private String attractionId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);

        //get information from MapsActivity
        Intent mapsIntent=this.getIntent();
        attractionId = mapsIntent.getStringExtra("attractionId");

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().add(R.id.reviewsContainer, new ReviewsFragment()).commit();
        }

    }

}
