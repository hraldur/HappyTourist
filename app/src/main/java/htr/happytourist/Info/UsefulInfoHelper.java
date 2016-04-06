package htr.happytourist.Info;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hlingunnlaugsdottir on 30/03/16.
 */

public class UsefulInfoHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "info.db";
    
    public UsefulInfoHelper(Context context){
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTables(db);
    }

    private void createTables(SQLiteDatabase db) {
        //Creating phrases table in database
        db.execSQL("create table " + InfoDbSchema.CommonPhrasesTable.NAME + "(" + "_id integer primary key autoincrement, " +
                        InfoDbSchema.CommonPhrasesTable.Cols.ENG + "," +
                        InfoDbSchema.CommonPhrasesTable.Cols.ISL + ");"
        );

        //Create usefulphonenumbers table in database
        db.execSQL("create table" + InfoDbSchema.UsefulPhoneNumbersTable.NAME + "(" + "_id integer primary key autoincrement, " +
                        InfoDbSchema.UsefulPhoneNumbersTable.Cols.OWNER + "," +
                        InfoDbSchema.UsefulPhoneNumbersTable.Cols.PHONENUMBER + ");"
        );
        setPhrasesDatabaseValues(db);
    }

    private void setPhrasesDatabaseValues(SQLiteDatabase db) {
        ContentValues phrasesValues = new ContentValues();
        phrasesValues.put(InfoDbSchema.CommonPhrasesTable.Cols.ENG, "Good morning");
        phrasesValues.put(InfoDbSchema.CommonPhrasesTable.Cols.ISL, "Godan dag");

        ContentValues usefulPhoneNumbersValues = new ContentValues();
        usefulPhoneNumbersValues.put(InfoDbSchema.UsefulPhoneNumbersTable.Cols.OWNER, "Emergency");
        usefulPhoneNumbersValues.put(InfoDbSchema.UsefulPhoneNumbersTable.Cols.PHONENUMBER, (Integer) 112);

        db.insert(InfoDbSchema.CommonPhrasesTable.NAME, null, phrasesValues);
        db.insert(InfoDbSchema.UsefulPhoneNumbersTable.NAME, null, usefulPhoneNumbersValues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

