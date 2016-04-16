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
        db.execSQL("create table " + InfoDbSchema.UsefulPhoneNumbersTable.NAME + "(" + "_id integer primary key autoincrement, " +
                        InfoDbSchema.UsefulPhoneNumbersTable.Cols.OWNER + "," +
                        InfoDbSchema.UsefulPhoneNumbersTable.Cols.PHONENUMBER + ");"
        );
        setInfoDatabaseValues(db);
    }

    private void setInfoDatabaseValues(SQLiteDatabase db) {
        //arrays with common icelandic phrases
        String[] phrase1 = {"Hello", "Góðan Dag"};
        String[] phrase2 = {"Goodbye", "Bless"};
        String[] phrase3 = {"Thank you", "Takk fyrir"};
        String[] phrase4 = {"What can you recommend", "Hverju mælir þú með"};
        String[] phrase5 = {"Check please", "Reikninginn takk fyrir"};
        String[] phrase6 = {"I am looking for ", "Ég er að leita að"};
        String[] phrase7 = {"How are you" , "hvað segir þú gott"};
        String[] phrase8 = {"What's your name?", "Hvað heitir þú"};
        String[] phrase9 = {"My name is", "Ég heiti"};
        String[] phrase10 = {"Where are you from", "Hvaðan ert þú"};
        String[] phrase11 = {"I'm from", "Ég er frá"};
        String[] phrase12 = {"Pleased to meet you", "Gaman að kynnast þér"};
        String[] phrase13 = {"Good luck", "Gangi þér vel"};
        String[] phrase14 = {"Cheers", "Skál!"};
        String[] phrase15 = {"Bon appetit", "Verði þér að góðu"};
        String[] phrase16 = {"Yes", "já"};
        String[] phrase17 = {"No", "nei"};
        String[] phrase18 = { "Maybe", "kannski"};
        String[] phrase19 = {"Excuse me", "Afsakið"};
        String[] phrase20 = {"I love you", "Ég elska þig"};


        //one array with all the phrases
        String [][] phrasesList = new String[][] {phrase1, phrase2, phrase3, phrase4, phrase5, phrase6, phrase7, phrase8, phrase9, phrase10, phrase11, phrase12, phrase13, phrase14, phrase15, phrase16, phrase17, phrase18, phrase19, phrase20};

        //put phrases into the database using Content values
        for(int i=0; i<phrasesList.length;i++) {
            ContentValues phrasesValues = new ContentValues();
            phrasesValues.put(InfoDbSchema.CommonPhrasesTable.Cols.ENG, phrasesList[i][0]);
            phrasesValues.put(InfoDbSchema.CommonPhrasesTable.Cols.ISL, phrasesList[i][1]);

            db.insert(InfoDbSchema.CommonPhrasesTable.NAME, null, phrasesValues);
        }

        //arrays with useful icelandic phone numbers
        String[] phoneNumber1 = {"Emergency Phone", "112"};
        String[] phoneNumber2 = {"Reykjavik Police", "4441000"};
        String[] phoneNumber3 = {"Hreyfill Taxi", "5885522"};
        String[] phoneNumber4 = {"Bus", "5402700"};
        String[] phoneNumber5 = {"Search and rescue", "570-5900"};
        String[] phoneNumber6 = {"International Directory Inquiries", "1811"};
        String[] phoneNumber7 = {"E.R Emergency Room Landspítali Hospital", "543-2000"};
        String[] phoneNumber8 = {"Lost and found", "4441000"};
        String[] phoneNumber9 = {"Icelandic Bank", "4404000"};
        String[] phoneNumber10 = {"National Bank", "4104000"};

        //one array with all the phone numbers
        String [][] phoneNumbersList = new String[][] {phoneNumber1, phoneNumber2, phoneNumber3, phoneNumber4, phoneNumber5, phoneNumber6, phoneNumber7, phoneNumber8, phoneNumber9, phoneNumber10};

        //put phone numbers into the database using Content values
        for(int i=0; i<phoneNumbersList.length;i++){
            ContentValues usefulPhoneNumbersValues = new ContentValues();
            usefulPhoneNumbersValues.put(InfoDbSchema.UsefulPhoneNumbersTable.Cols.OWNER, phoneNumbersList[i][0]);
            usefulPhoneNumbersValues.put(InfoDbSchema.UsefulPhoneNumbersTable.Cols.PHONENUMBER, phoneNumbersList[i][1]);

            db.insert(InfoDbSchema.UsefulPhoneNumbersTable.NAME, null, usefulPhoneNumbersValues);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

