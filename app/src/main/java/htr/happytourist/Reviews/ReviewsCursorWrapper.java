package htr.happytourist.Reviews;

import android.database.Cursor;
import android.database.CursorWrapper;

import htr.happytourist.Info.InfoDbSchema;

/**
 * Created by hlingunnlaugsdottir on 15/04/16.
 */
public class ReviewsCursorWrapper extends CursorWrapper {

    public ReviewsCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Reviews getReviews() {
        String review = getString(getColumnIndex(ReviewsDbSchema.ReviewsTable.Cols.REVIEW));
        String user = getString(getColumnIndex(ReviewsDbSchema.ReviewsTable.Cols.USER));
        String date = getString(getColumnIndex(ReviewsDbSchema.ReviewsTable.Cols.DATE));

        Reviews reviews = new Reviews();

        reviews.setReview(review);
        reviews.setUser(user);
        reviews.setDate(date);

        return reviews;
    }

}
