package htr.happytourist.Info;

import android.database.Cursor;
import android.database.CursorWrapper;

/**
 * Created by hlingunnlaugsdottir on 31/03/16.
 */

public class PhrasesCursorWrapper extends CursorWrapper {

    public PhrasesCursorWrapper (Cursor cursor) {
        super(cursor);
    }

    public Phrases getPhrases() {
        String eng = getString(getColumnIndex(InfoDbSchema.CommonPhrasesTable.Cols.ENG));
        String isl = getString(getColumnIndex(InfoDbSchema.CommonPhrasesTable.Cols.ISL));

        Phrases phrases = new Phrases();

        phrases.setENG(eng);
        phrases.setISL(isl);

        return phrases;
    }
}
