package pl.edu.agh.michalciolczyk;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyFirstSQLiteDatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "myFirstDatabase.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "myFirstTable";
    public static final String U_ID = "_id";
    public static final String USER_NAME = "userName";

    public MyFirstSQLiteDatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" + U_ID + " INTEGER PRIMARY KEY AUTOINCREMENT"
                + ", " + USER_NAME + " VARCHAR(255));");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP DATABASE IF EXISTS " + DATABASE_NAME + ";");
        onCreate(db);
    }
}
