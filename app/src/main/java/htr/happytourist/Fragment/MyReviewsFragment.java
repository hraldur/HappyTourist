package htr.happytourist.Fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import htr.happytourist.Attractions.Reviews;
import htr.happytourist.R;

public class MyReviewsFragment extends Fragment {

    TableLayout mMyReview;


    public MyReviewsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_my_reviews, container, false);

        Firebase.setAndroidContext(getContext());

        mMyReview = (TableLayout) v.findViewById(R.id.myReview);

        //get information from UserActivity
        String personId = getActivity().getIntent().getStringExtra("personId");

        Firebase ref = new Firebase("https://happytourist.firebaseio.com/review/user/"+personId);

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    Reviews review = postSnapshot.getValue(Reviews.class);
                    System.out.println(review.getComment() + " - " + review.getTime() + "-" + review.getUsername());


                    TableRow tr = new TableRow(getContext());
                    tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

                    TextView attractionName = new TextView(getContext());
                    attractionName.setText(review.getAttractionName());
                    attractionName.setTextSize(16);
                    attractionName.setTypeface(null,Typeface.BOLD);
                    tr.addView(attractionName);

                    TableRow tr2 = new TableRow(getContext());
                    tr2.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

                    TextView time = new TextView(getContext());
                    time.setText(review.getTime());
                    time.setTextSize(8);
                    tr2.addView(time);

                    TableRow tr3 = new TableRow(getContext());
                    tr3.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));


                    TextView comments = new TextView(getContext());
                    comments.setText(review.getComment());
                    tr3.addView(comments);


                    mMyReview.addView(tr);
                    mMyReview.addView(tr2);
                    mMyReview.addView(tr3);
                }

            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });

    return v;
    }


}
