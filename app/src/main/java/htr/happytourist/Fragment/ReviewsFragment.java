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

public class ReviewsFragment extends Fragment {
    TableLayout attractionReview;


    public ReviewsFragment() {
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
        View v =  inflater.inflate(R.layout.fragment_reviews, container, false);
        attractionReview = (TableLayout) v.findViewById(R.id.attractionReview);

        //get attractionid
        String attractionId = getActivity().getIntent().getStringExtra("attractionId");

        Firebase.setAndroidContext(getContext());
        Firebase ref = new Firebase("https://happytourist.firebaseio.com/review/attraction/"+attractionId);

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
                    attractionName.setText(review.getUsername());
                    tr.addView(attractionName);

                    TextView comments = new TextView(getContext());
                    comments.setText(review.getComment());
                    tr.addView(comments);


                    attractionReview.addView(tr);
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
