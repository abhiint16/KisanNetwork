package abhishekint.com.kisannetwork.sqlite_database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhishek on 10-06-2018.
 */

public class SqLiteHelper extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "notes_db";

    public SqLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
// create notes table
        sqLiteDatabase.execSQL(SqlLiteInit.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
// Drop older table if existed
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + SqlLiteInit.TABLE_NAME);

        // Create tables again
        onCreate(sqLiteDatabase);
    }

    public List<SqlLiteInit> getAllData() {
        List<SqlLiteInit> sqlLiteInits = new ArrayList<>();

        // Select All Query. It will automatically return data in descending order of timestamp
        String selectQuery = "SELECT  * FROM " + SqlLiteInit.TABLE_NAME + " ORDER BY " +
                SqlLiteInit.COLUMN_TIMESTAMP + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                SqlLiteInit sqlLiteInit = new SqlLiteInit();
                sqlLiteInit.setName(cursor.getString(cursor.getColumnIndex(SqlLiteInit.COLUMN_NAME)));
                sqlLiteInit.setOtp(cursor.getString(cursor.getColumnIndex(SqlLiteInit.COLUMN_OTP)));
                sqlLiteInit.setTimestamp(cursor.getString(cursor.getColumnIndex(SqlLiteInit.COLUMN_TIMESTAMP)));

                sqlLiteInits.add(sqlLiteInit);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return sqlLiteInits;
    }

    public long insertAll(String name,String otp) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        //`timestamp` will be inserted automatically.
        // no need to add it
        values.put(SqlLiteInit.COLUMN_NAME, name);
        values.put(SqlLiteInit.COLUMN_OTP, otp);

        // insert row
        long id = db.insert(SqlLiteInit.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }
}
