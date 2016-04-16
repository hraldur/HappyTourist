package htr.happytourist.Reviews;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import htr.happytourist.Info.InfoCursorWrapper;
import htr.happytourist.Info.UsefulInfoHelper;

/**
 * Created by hlingunnlaugsdottir on 15/04/16.
 */
public class ReviewsList {
    private Context mContext;
    private SQLiteDatabase mDatabase;

    //Constructor
    public ReviewsList(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new ReviewsHelper(mContext).getWritableDatabase();
    }

    private static ContentValues getContentValues(Reviews reviews) {
        ContentValues values = new ContentValues();
        values.put(ReviewsDbSchema.ReviewsTable.Cols.REVIEW, reviews.getReview());
        values.put(ReviewsDbSchema.ReviewsTable.Cols.USER, reviews.getUser());
        values.put(ReviewsDbSchema.ReviewsTable.Cols.DATE, reviews.getDate());
        return values;
    }

    private ReviewsCursorWrapper queryPhrases(String whereClause, String[] whereArgs){
        Cursor cursor = mDatabase.query("Reviews", new String[] {ReviewsDbSchema.ReviewsTable.Cols.REVIEW, ReviewsDbSchema.ReviewsTable.Cols.USER, ReviewsDbSchema.ReviewsTable.Cols.DATE}, null, null, null, null, null);
        return new ReviewsCursorWrapper(cursor);
    }


    //Method to add submitted reviews to the reviews.db table Reviews
    public void addReview(Reviews r) {
        ContentValues values = getContentValues(r);
        mDatabase.insert(ReviewsDbSchema.ReviewsTable.NAME, null, values);
    }

    //Method to retrieve all submitted reviews from the reviews.db table Reviews
    public List<Reviews> getReviews() {
        List<Reviews> reviews = new ArrayList<>();

        ReviewsCursorWrapper cursor = queryPhrases(null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            reviews.add(cursor.getReviews());
            cursor.moveToNext();
        }
        cursor.close();

        return reviews;
    }
}
