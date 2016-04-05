package htr.happytourist.Info;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hlingunnlaugsdottir on 30/03/16.
 */


public class PhrasesList {
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public PhrasesList(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new UsefulInfoHelper(mContext).getWritableDatabase();
    }

    private static ContentValues getContentValues(Phrases phrases) {
        ContentValues values = new ContentValues();
        values.put(InfoDbSchema.PhrasesTable.Cols.ISL, phrases.getISL());
        values.put(InfoDbSchema.PhrasesTable.Cols.ENG, phrases.getENG());
        return values;
    }

    private PhrasesCursorWrapper queryPhrases(String whereClause, String[] whereArgs){
        Cursor cursor = mDatabase.query(
                InfoDbSchema.PhrasesTable.NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );
        return new PhrasesCursorWrapper(cursor);
    }

    public void addPhrase(Phrases c) {
        ContentValues values = getContentValues(c);
        mDatabase.insert(InfoDbSchema.PhrasesTable.NAME, null, values);
    }

    public List<Phrases> getPhrases() {
        List<Phrases> phrases = new ArrayList<>();
        PhrasesCursorWrapper cursor = queryPhrases(null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            phrases.add(cursor.getPhrases());
            cursor.moveToNext();
        }
        cursor.close();

        return phrases;
    }
}

