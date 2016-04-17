package htr.happytourist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import htr.happytourist.Fragment.MyReviewsFragment;

public class MyReviewsActivity extends AppCompatActivity {

    private String personID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_reviews);

        //get information from MapsActivity
        Intent mapsIntent=this.getIntent();
        personID = mapsIntent.getStringExtra("personId");

        System.out.println(personID);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().add(R.id.myReviewContainer, new MyReviewsFragment()).commit();
        }
    }



}
