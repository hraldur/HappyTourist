package htr.happytourist.Fragment;

import android.database.Cursor;
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

import htr.happytourist.Info.InfoDbSchema;
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

                UsefulInfoHelper infoHelper = new UsefulInfoHelper(v.getContext());
                SQLiteDatabase db = infoHelper.getReadableDatabase();

                Cursor cursor = db.query("Common_Phrases", new String[]{InfoDbSchema.CommonPhrasesTable.Cols.ENG, InfoDbSchema.CommonPhrasesTable.Cols.ISL}, null, null, null, null, null);

                try {
                    if (cursor.moveToFirst()) {
                        String eng = cursor.getString(0);
                        String ice = cursor.getString(1);

                        Phrases phraseText = new Phrases(eng, ice);

                        TableRow tr = new TableRow(v.getContext());
                        tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

                        TextView english = new TextView(v.getContext());
                        english.setText(eng);
                        tr.addView(english);

                        TextView icelandic = new TextView(v.getContext());
                        icelandic.setText(ice);
                        tr.addView(icelandic);

                        mViewUsefulInfo.addView(tr);
                    }
                } finally  {
                    cursor.close();
                    db.close();
                }
            }
        });
        return v;
    }
}
