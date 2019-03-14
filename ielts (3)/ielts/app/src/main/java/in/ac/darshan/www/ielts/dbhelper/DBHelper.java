package in.ac.darshan.www.ielts.dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import in.ac.darshan.www.ielts.activities.ACADEMIC_MARK_TO_BAND;

/**
 * Created by Infiniti on 9/16/2018.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "Ielts_db";

    public static final String TABLE_NAME = "tblIelts";
    public static final String _ID = "_id";
    public static final String _COMPONENT = "_component";
    public static final String _BAND = "_band";
    public static final String _MINMARKS = "_minmarks";
    public static final String _MAXMARKS = "_maxmarks";
    public static final String _CATEGORY = "_category";

    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
            "(" +
            _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            _COMPONENT + " VARCHAR(30)," +
            _BAND + " INTEGER," +
            _MINMARKS + " INTEGER, " +
            _MAXMARKS + " INTEGER, " +
            _CATEGORY + " VARCHAR(30) " + ");";


    public DBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertUser(ContentValues cv) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME, null, cv);
        cv.clear();
        db.close();
    }

    public static float getBandByMarks(Context context, String component, String category, String marks) {
        DBHelper dbHelper=new DBHelper(context);
        SQLiteDatabase readableDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = readableDatabase.query(DBHelper.TABLE_NAME, new String[]{DBHelper._BAND}, "_component=? and _category=? and (_maxmarks>=? and _minmarks<=?)", new String[]{component,category,marks,marks}, null, null, null);
        while (cursor.moveToNext()){
            return cursor.getInt(cursor.getColumnIndex(_BAND));
        }
        return -1;
    }

    public static int getMinMarksByBand(Context context, String component, String category, String band) {
        DBHelper dbHelper=new DBHelper(context);
        SQLiteDatabase readableDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = readableDatabase.query(DBHelper.TABLE_NAME, new String[]{DBHelper._MINMARKS}, "_component=? and _category=? and _band=?", new String[]{component,category,band}, null, null, null);
        while (cursor.moveToNext()){
            return cursor.getInt(cursor.getColumnIndex(_MINMARKS));
        }
        return -1;
    }
    public static int getMaxMarksByBand(Context context, String component, String category, String band) {
        DBHelper dbHelper=new DBHelper(context);
        SQLiteDatabase readableDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = readableDatabase.query(DBHelper.TABLE_NAME, new String[]{DBHelper._MAXMARKS}, "_component=? and _category=? and _band=?", new String[]{component,category,band}, null, null, null);
        while (cursor.moveToNext()){
            return cursor.getInt(cursor.getColumnIndex(_MAXMARKS));
        }
        return -1;
    }
}
