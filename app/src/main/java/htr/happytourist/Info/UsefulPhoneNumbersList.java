package htr.happytourist.Info;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hlingunnlaugsdottir on 06/04/16.
 */
public class UsefulPhoneNumbersList {

    private Context mContext;
    private SQLiteDatabase mDatabase;

    public UsefulPhoneNumbersList(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new UsefulInfoHelper(mContext).getWritableDatabase();
    }

         /*
        private static ContentValues getContentValues(Phrases phrases) {
            ContentValues values = new ContentValues();
            values.put(InfoDbSchema.CommonPhrasesTable.Cols.ISL, phrases.getISL());
            values.put(InfoDbSchema.CommonPhrasesTable.Cols.ENG, phrases.getENG());
            return values;
        }
        */

    private InfoCursorWrapper queryUsefulPhoneNumbers(String whereClause, String[] whereArgs){
        Cursor cursor = mDatabase.query("Useful_Phone_Numbers", new String[]{InfoDbSchema.UsefulPhoneNumbersTable.Cols.OWNER, InfoDbSchema.UsefulPhoneNumbersTable.Cols.PHONENUMBER}, null, null, null, null, null);
        return new InfoCursorWrapper(cursor);
    }

    /*
    public void addPhrase(Phrases c) {
        ContentValues values = getContentValues(c);
        mDatabase.insert(InfoDbSchema.CommonPhrasesTable.NAME, null, values);
    }
    */

    public List<UsefulPhoneNumbers> getUsefulPhoneNumbers() {
        List<UsefulPhoneNumbers> usefulPhoneNumbers = new ArrayList<>();

        InfoCursorWrapper cursor = queryUsefulPhoneNumbers(null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            usefulPhoneNumbers.add(cursor.getUsefulPhoneNumbers());
            cursor.moveToNext();
        }
        cursor.close();

        return usefulPhoneNumbers;
    }
}
