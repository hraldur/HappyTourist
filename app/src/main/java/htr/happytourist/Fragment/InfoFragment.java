package htr.happytourist.Fragment;

import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import htr.happytourist.Info.Phrases;
import htr.happytourist.Info.PhrasesList;
import htr.happytourist.Info.UsefulInfoHelper;
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

        //Useful information view
        mViewUsefulInfo = (TableLayout) v.findViewById(R.id.viewUsefulInfo);

        //Phrases button
        mBtnPhrases = (Button) v.findViewById(R.id.btnPhrases);
        mBtnPhrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UsefulInfoHelper usefulInfoHelper = new UsefulInfoHelper(v.getContext());
                SQLiteDatabase db = usefulInfoHelper.getWritableDatabase();

                String eng = "Good morning";
                String isl = "Góðan dag";
                Phrases phrase = new Phrases(eng, isl);

                PhrasesList list = new PhrasesList(v.getContext());
                list.addPhrase(phrase);

                //PhrasesList list = new PhrasesList(v.getContext());
                List<Phrases> phrasesList = null;
                phrasesList = list.getPhrases();

                for (int i=0; i<phrasesList.size(); i++) {
                    TableRow tr = new TableRow(v.getContext());
                    tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

                    TextView phrases = new TextView(v.getContext());
                    phrases.setText(phrasesList.get(i).toString());
                    tr.addView(phrases);
                }
            }
        });
        return v;
    }
}
