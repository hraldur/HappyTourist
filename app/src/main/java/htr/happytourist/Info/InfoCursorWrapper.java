package htr.happytourist.Info;

import android.database.Cursor;
import android.database.CursorWrapper;

import htr.happytourist.Fragment.InfoFragment;

/**
 * Created by hlingunnlaugsdottir on 31/03/16.
 */

public class InfoCursorWrapper extends CursorWrapper {

    public InfoCursorWrapper(Cursor cursor) {
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

    public UsefulPhoneNumbers getUsefulPhoneNumbers() {
        String owner = getString(getColumnIndex(InfoDbSchema.UsefulPhoneNumbersTable.Cols.OWNER));
        String phoneNumber = getString(getColumnIndex(InfoDbSchema.UsefulPhoneNumbersTable.Cols.PHONENUMBER));

        UsefulPhoneNumbers usefulPhoneNumbers = new UsefulPhoneNumbers();

        usefulPhoneNumbers.setOWNER(owner);
        usefulPhoneNumbers.setPHONENUMBER(phoneNumber);

        return usefulPhoneNumbers;
    }
}
