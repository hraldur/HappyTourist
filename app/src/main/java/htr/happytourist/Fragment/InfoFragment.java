package htr.happytourist.Fragment;

import android.database.sqlite.SQLiteDatabase;
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
import htr.happytourist.Info.UsefulInfoHelper;
import htr.happytourist.Info.UsefulPhoneNumbers;
import htr.happytourist.R;

/**
 * Created by hlingunnlaugsdottir on 31/03/16.
 */
public class InfoFragment extends Fragment {

    Button mBtnPhrases;
    Button mBtnUsefulPhoneNumbers;
    TableLayout mViewUsefulInfo;

    public InfoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_info, container, false);

        //Create database info.db when view is created
        UsefulInfoHelper infoHelper = new UsefulInfoHelper(v.getContext());
        SQLiteDatabase db = infoHelper.getReadableDatabase();

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
 /*
                PhrasesList phrasesList = new PhrasesList(getContext());
                List<Phrases> listPhrases = phrasesList.getPhrases();

               for(int i=0; i<listPhrases.size();i++){
                    TableRow tr = new TableRow(v.getContext());
                    tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

                    TextView english = new TextView(v.getContext());
                    english.setText(listPhrases.get(i).ENG.toString());
                    tr.addView(english);

                    TextView icelandic = new TextView(v.getContext());
                    icelandic.setText(listPhrases.get(i).ISL.toString());
                    tr.addView(icelandic);

                    mViewUsefulInfo.addView(tr);
                }*/


                Firebase phrasesRef = new Firebase("https://happytourist.firebaseio.com/usefulinfo/phrases/");
                phrasesRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (DataSnapshot phrasesSnapshot : dataSnapshot.getChildren()) {

                            System.out.println(phrasesSnapshot.getValue());
                            Phrases phrases = phrasesSnapshot.getValue(Phrases.class);


                            TableRow tr = new TableRow(getContext());
                            tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

                            TextView english = new TextView(getContext());
                            english.setText(phrases.getEnglish());
                            tr.addView(english);

                            TextView icelandic = new TextView(getContext());
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
/*
                UsefulPhoneNumbersList usefulPhoneNumbersList = new UsefulPhoneNumbersList(getContext());
                List<UsefulPhoneNumbers> listUsefulPhoneNumbers = usefulPhoneNumbersList.getUsefulPhoneNumbers();

                for(int i=0; i<listUsefulPhoneNumbers.size();i++){
                    TableRow tr = new TableRow(v.getContext());
                    tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

                    TextView owner = new TextView(v.getContext());
                    owner.setText(listUsefulPhoneNumbers.get(i).OWNER.toString());
                    tr.addView(owner);

                    TextView phoneNumber = new TextView(v.getContext());
                    phoneNumber.setText(listUsefulPhoneNumbers.get(i).PHONENUMBER.toString());
                    tr.addView(phoneNumber);

                    mViewUsefulInfo.addView(tr);
                }
                */

                Firebase phrasesRef = new Firebase("https://happytourist.firebaseio.com/usefulinfo/phoneNumbers");
                phrasesRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (DataSnapshot phoneSnapshot : dataSnapshot.getChildren()) {

                            System.out.println(phoneSnapshot.getValue());
                            UsefulPhoneNumbers usefulPhoneNumbers = phoneSnapshot.getValue(UsefulPhoneNumbers.class);


                            TableRow tr = new TableRow(getContext());
                            tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

                            TextView number = new TextView(getContext());
                            number.setText(usefulPhoneNumbers.getNumber());
                            tr.addView(number);

                            TextView owner = new TextView(getContext());
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
