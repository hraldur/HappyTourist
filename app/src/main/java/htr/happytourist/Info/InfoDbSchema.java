package htr.happytourist.Info;

/**
 * Created by hlingunnlaugsdottir on 30/03/16.
 */


public class InfoDbSchema {
    public static final class PhrasesTable {
        public static final String NAME = "phrases";
        public static final class Cols {
            public static final String ENG = "English";
            public static final String ISL = "Icelandic";
        }
    }

    public static final class UsefulPhoneNumbersTable {
        public static final String NAME = "userfulPhoneNumbers";
        public static final class Cols {
            public static final String OWNER = "Owner";
            public static final String PHONENUMBER = "Phone_Numbers";
        }
    }
}
