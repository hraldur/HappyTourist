package htr.happytourist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import htr.happytourist.Attractions.Reviews;

public class WriteReviewActivity extends AppCompatActivity {
    private Button mSubmitReview;
    private EditText mReviewText;
    private TextView mTextUser;
    private TextView mTextAttraction;

    private String personName;
    private String attractionName;
    private String personID;
    private String attractionID;
    private String comment;
    private String attractionRating;
    private String time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_review);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Firebase.setAndroidContext(this);


        //get information from MapsActivity
        Intent mapsIntent=this.getIntent();
        personName = mapsIntent.getStringExtra("personName");
        attractionName = mapsIntent.getStringExtra("attractionName");
        personID = mapsIntent.getStringExtra("personId");
        attractionID = mapsIntent.getStringExtra("attractionId");
        attractionRating = mapsIntent.getStringExtra("attracyionRating");

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy 'at' hh:mm");
        time = sdf.format(cal.getTime());

        mTextUser = (TextView) findViewById(R.id.textUser);
        mTextAttraction = (TextView) findViewById(R.id.textAttraction);
        mReviewText = (EditText) findViewById(R.id.reviewText);
        mSubmitReview = (Button) findViewById(R.id.submitReview);


        mTextUser.setText(personName);
        mTextAttraction.setText(attractionName);


        //Submit Review to database
        mSubmitReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comment = mReviewText.getText().toString();
                Firebase ref = new Firebase("https://happytourist.firebaseio.com/");
                Firebase reviewAttraction = ref.child("review").child("attraction").child(attractionID).child(personID);
                Firebase reviewUser = ref.child("review").child("user").child(personID).child(attractionID);
                Reviews comments = new Reviews(attractionName, attractionRating, attractionID, comment, time, personName, personID);
                reviewAttraction.setValue(comments);
                reviewUser.setValue(comments);

                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        System.out.println("There are " + snapshot.getChildrenCount() + " reviews");
                        System.out.println(snapshot.getValue());

                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                        System.out.println("The read failed: " + firebaseError.getMessage());
                    }
                });
            }
        });



    }

}
