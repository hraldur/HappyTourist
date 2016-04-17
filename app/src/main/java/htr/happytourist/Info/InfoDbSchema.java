package htr.happytourist.Info;

/**
 * Created by hlingunnlaugsdottir on 30/03/16.
 */


public class InfoDbSchema {
    public static final class CommonPhrasesTable {
        public static final String NAME = "Common_Phrases";
        public static final class Cols {
            public static final String ENG = "English";
            public static final String ISL = "Icelandic";
        }
    }

    public static final class UsefulPhoneNumbersTable {
        public static final String NAME = "Useful_Phone_Numbers";
        public static final class Cols {
            public static final String OWNER = "Owner";
            public static final String PHONENUMBER = "Phone_Number";
        }
    }
}
