package com.example.android.pets.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public final class PetContract {

    //The "Content authority" is a name for the entire content provider, similar to the relationship between a domain name and its website.  A convenient string to use for the
    //content authority is the package name for the app, which is guaranteed to be unique on the device.
    public static final String CONTENT_AUTHORITY = "com.example.android.pets";//android manifest (provider)

    //Use CONTENT_AUTHORITY to create the base of all URI's which apps will use to contact the content provider.
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    // Possible path (appended to base content URI for possible URI's). For instance, content://com.example.android.pets/pets/ is a valid path for
    //looking at pet data. content://com.example.android.pets/staff/ will fail, as the ContentProvider hasn't been given any information on what to do with "staff".
    public static final String PATH_PETS = "pets";


    private PetContract() {
        //Empty constructor so that it can't be instantiated.
    }

    public static final class PetEntry implements BaseColumns {

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_PETS);//The content URI to access the pet data in the provider
        //The MIME type of the CONTENT_URI for a list of pets.
        public static final String CONTENT_LIST_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PETS;

        //The MIME type of the CONTENT_URI for a single pet.
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PETS;

        public final static String TABLE_NAME = "pets";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_PET_NAME = "name";
        public final static String COLUMN_PET_BREED = "breed";
        public final static String COLUMN_PET_GENDER = "gender";
        public final static String COLUMN_PET_WEIGHT = "weight";

        public final static int GENDER_UNKNOWN = 0;
        public final static int GENDER_MALE = 1;
        public final static int GENDER_FEMALE = 2;

        public static boolean isValidGender(int gender) {
            return gender == GENDER_UNKNOWN || gender == GENDER_MALE || gender == GENDER_FEMALE;
            //after making Contract for easier access and less error in spelling and stuff, we use SQLiteOpenHelper class to open,create and manage database connections.
        }
    }

}