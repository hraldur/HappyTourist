package htr.happytourist.Reviews;

/**
 * Created by hlingunnlaugsdottir on 15/04/16.
 */


//Definition of the schema from the reviews.db database
public class ReviewsDbSchema {

    //The Reviews table
    public static final class ReviewsTable{
        public static final String NAME = "Reviews";
        public static final class Cols{
            public static final String REVIEW = "Review";
            public static final String USER = "User";
            public static final String DATE = "Date";
        }
    }
}
