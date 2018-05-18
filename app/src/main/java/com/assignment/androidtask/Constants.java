package com.assignment.androidtask;

public class Constants {

    public static final String PREF_NAME = "assignment_pref";
    public static final long NULL_INDEX = -1L;
    public static String BASE_URL = "https://jsonplaceholder.typicode.com/";

    public enum LoggedInMode {

        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_LOGGED_IN(1);

        private final int mType;

        LoggedInMode(int type) {
            mType = type;
        }

        public int getType() {
            return mType;
        }
    }
}
