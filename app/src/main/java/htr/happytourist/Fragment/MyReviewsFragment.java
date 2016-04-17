package htr.happytourist.Fragment;

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
//        String personID = this.getArguments().getString("personID");


        Firebase.setAndroidContext(getContext());

        mMyReview = (TableLayout) v.findViewById(R.id.myReview);
        String personId = getActivity().getIntent().getStringExtra("personId");

        Firebase ref = new Firebase("https://happytourist.firebaseio.com/review/user/"+personId);
       // Firebase ref = new Firebase("https://happytourist.firebaseio.com/review/user/112374764511709985726");
        System.out.println(personId);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                System.out.println("There are " + snapshot.getChildrenCount() + " blog posts");
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    Reviews review = postSnapshot.getValue(Reviews.class);
                    System.out.println(review.getComment() + " - " + review.getUsername());


                    TableRow tr = new TableRow(getContext());
                    tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

                    TextView attractionName = new TextView(getContext());
                    attractionName.setText(review.getAttractionName());
                    tr.addView(attractionName);

                    TextView comments = new TextView(getContext());
                    comments.setText(review.getComment());
                    tr.addView(comments);


                    mMyReview.addView(tr);
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
