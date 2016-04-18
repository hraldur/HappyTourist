package htr.happytourist.Fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import htr.happytourist.Info.Phrases;
import htr.happytourist.Info.UsefulPhoneNumbers;
import htr.happytourist.R;

/**
 * Created by hlingunnlaugsdottir on 31/03/16.
 */
public class InfoFragment extends Fragment {

    Button mBtnPhrases;
    Button mBtnUsefulPhoneNumbers;
    TableLayout mViewUsefulInfo;

    // Required empty public constructor
    public InfoFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_info, container, false);

        //Useful information view
        mViewUsefulInfo = (TableLayout) v.findViewById(R.id.viewUsefulInfo);

        //Phrases button
        mBtnPhrases = (Button) v.findViewById(R.id.btnPhrases);

        Firebase.setAndroidContext(getContext());

        //Display phrases
        mBtnPhrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //First remove all views that already are present in the mViewUsefulInfo view
                mViewUsefulInfo.removeAllViews();

                Firebase phrasesRef = new Firebase("https://happytourist.firebaseio.com/usefulinfo/phrases/");
                phrasesRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        //Then add titles to the usefulInfo phrases table layout
                        TableRow titles = new TableRow(getContext());

                        TextView englishTitle = new TextView(getContext());
                        englishTitle.setText("English");
                        englishTitle.setTypeface(null, Typeface.BOLD);
                        titles.addView(englishTitle);

                        TextView icelandicTitle = new TextView(getContext());
                        icelandicTitle.setText("Icelandic");
                        icelandicTitle.setTypeface(null, Typeface.BOLD);
                        titles.addView(icelandicTitle);

                        mViewUsefulInfo.addView(titles);

                        for (DataSnapshot phrasesSnapshot : dataSnapshot.getChildren()) {

                            System.out.println(phrasesSnapshot.getValue());
                            Phrases phrases = phrasesSnapshot.getValue(Phrases.class);

                            TableRow tr = new TableRow(getContext());
                            tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

                            TextView english = new TextView(getContext());
                            english.setPadding(10, 5, 10, 5);
                            english.setText(phrases.getEnglish());
                            tr.addView(english);

                            TextView icelandic = new TextView(getContext());
                            icelandic.setPadding(10, 5, 10, 5);
                            icelandic.setText(phrases.getIcelandic());
                            tr.addView(icelandic);

                            mViewUsefulInfo.addView(tr);

                        }
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                        System.out.println("The read failed: " + firebaseError.getMessage());
                    }
                });

            }
        });

        mBtnUsefulPhoneNumbers = (Button) v.findViewById(R.id.btnUsefulPhoneNumbers);

        //Display usefulPhoneNumbers
        mBtnUsefulPhoneNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //First remove all views that already are present in the mViewUsefulInfo view
                mViewUsefulInfo.removeAllViews();

                Firebase phrasesRef = new Firebase("https://happytourist.firebaseio.com/usefulinfo/phoneNumbers");
                phrasesRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        //Then add titles to usefulinfo phonenumbers table layout
                        TableRow titles = new TableRow(getContext());

                        TextView numberTitle = new TextView(getContext());
                        numberTitle.setText("Number");
                        numberTitle.setTypeface(null, Typeface.BOLD);
                        titles.addView(numberTitle);

                        TextView ownerTitle = new TextView(getContext());
                        ownerTitle.setText("Owner");
                        ownerTitle.setTypeface(null, Typeface.BOLD);
                        titles.addView(ownerTitle);

                        mViewUsefulInfo.addView(titles);

                        for (DataSnapshot phoneSnapshot : dataSnapshot.getChildren()) {

                            System.out.println(phoneSnapshot.getValue());
                            UsefulPhoneNumbers usefulPhoneNumbers = phoneSnapshot.getValue(UsefulPhoneNumbers.class);

                            TableRow tr = new TableRow(getContext());
                            tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

                            TextView number = new TextView(getContext());
                            number.setPadding(10, 5, 10, 5);
                            number.setText(usefulPhoneNumbers.getNumber());
                            tr.addView(number);

                            TextView owner = new TextView(getContext());
                            owner.setPadding(10, 5, 10, 5);
                            owner.setText(usefulPhoneNumbers.getOwner());
                            tr.addView(owner);

                            mViewUsefulInfo.addView(tr);

                        }
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                        System.out.println("The read failed: " + firebaseError.getMessage());
                    }
                });


            }
        });

        return v;
    }
}
