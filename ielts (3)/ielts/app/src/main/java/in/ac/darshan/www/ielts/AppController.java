package in.ac.darshan.www.ielts;

import android.app.Application;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import in.ac.darshan.www.ielts.dbhelper.DBHelper;

public class AppController extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        JSONArray jsonArray = Util.getJsonFromFile(this, "json/data.json");
        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase writableDatabase = dbHelper.getWritableDatabase();
        if (!dataExist(writableDatabase)) {
            writeDataInDB(writableDatabase, jsonArray);
        }
    }

    private boolean dataExist(SQLiteDatabase writableDatabase) {
        boolean hasElements = false;
        Cursor cursor = writableDatabase.query(DBHelper.TABLE_NAME, null, null, null, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                StringBuilder stringBuilder = new StringBuilder()
                        .append("{").append("\n")
                        .append("Id: " + cursor.getInt(cursor.getColumnIndex(DBHelper._ID))).append("\n")
                        .append("Component: " + cursor.getString(cursor.getColumnIndex(DBHelper._COMPONENT))).append("\n")
                        .append("MinMarks: " + cursor.getInt(cursor.getColumnIndex(DBHelper._MINMARKS))).append("\n")
                        .append("MaxMarks: " + cursor.getInt(cursor.getColumnIndex(DBHelper._MAXMARKS))).append("\n")
                        .append("Category: " + cursor.getString(cursor.getColumnIndex(DBHelper._CATEGORY))).append("\n")
                        .append("}");
                Log.d("MSG", stringBuilder.toString());
                hasElements = true;
            }
        }
        return hasElements;
    }

    private void writeDataInDB(SQLiteDatabase writableDatabase, JSONArray jsonArray) {
        try {
            for (int x = 0; x < jsonArray.length(); x++) {
                JSONObject jsonObject = jsonArray.getJSONObject(x);
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBHelper._COMPONENT, jsonObject.getString("component"));
                contentValues.put(DBHelper._BAND, jsonObject.getString("band"));
                contentValues.put(DBHelper._MINMARKS, jsonObject.getString("minMarks"));
                contentValues.put(DBHelper._MAXMARKS, jsonObject.getString("maxMarks"));
                contentValues.put(DBHelper._CATEGORY, jsonObject.getString("category"));
                writableDatabase.insert(DBHelper.TABLE_NAME, null, contentValues);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
