package htr.happytourist.Reviews;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hlingunnlaugsdottir on 15/04/16.
 */
public class ReviewsHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "reviews.db";

    public ReviewsHelper(Context context){
        super(context, DATABASE_NAME, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        createTable(db);
    }

    private void createTable(SQLiteDatabase db) {
        //Creating reviews table in database
        db.execSQL("create table " + ReviewsDbSchema.ReviewsTable.NAME + "(" + "_id integer primary key autoincrement, " +
        ReviewsDbSchema.ReviewsTable.Cols.REVIEW + "," +
        ReviewsDbSchema.ReviewsTable.Cols.USER + "," +
        ReviewsDbSchema.ReviewsTable.Cols.DATE + ");"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
