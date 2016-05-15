package com.home.ubbs.foto.diary.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.home.ubbs.foto.diary.data.Album;
import com.home.ubbs.foto.diary.utils.Constants;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by udyatbhanu-mac on 7/10/15.
 */
public class PhotoDiarySQLHelper extends SQLiteOpenHelper {

    public PhotoDiarySQLHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, Constants.PHOTO_DIARY_DATABASE_NAME, null,
                Constants.DATABASE_VERSION);
    }

    public PhotoDiarySQLHelper(Context context) {
        super(context, Constants.PHOTO_DIARY_DATABASE_NAME, null,
                Constants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        db.execSQL("CREATE TABLE " + Constants.PHOTO_DIARY_TABLE_NAME + "("
                + Constants.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Constants.COLUMN_TITLE + " TEXT UNIQUE NOT NULL,"
                + Constants.COLUMN_DESCRIPTION + " TEXT UNIQUE NOT NULL,"
                + Constants.COLUMN_LOCATION + " LONG NOT NULL" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Constants.PHOTO_DIARY_TABLE_NAME);// 1) drop the old table


        // 2) create a new database
        onCreate(db);
    }


    /**
     * Add a new item
     */
    public void addAlbum(Album album) {
        SQLiteDatabase db = getWritableDatabase();
        // prepare values
        ContentValues values = new ContentValues();
        values.put(Constants.COLUMN_TITLE, album.getTitle());
        values.put(Constants.COLUMN_LOCATION, album.getLocation());
        values.put(Constants.COLUMN_DESCRIPTION, album.getDescription());

        // add the row
        db.insert(Constants.PHOTO_DIARY_TABLE_NAME, null, values);

        db.close();
    }




    /**
     * Get all the items from the db used to load the home list fragment
     * @return
     */
    public List<Album> getAllItems() {

        List<Album> items = new ArrayList<Album>();
        // obtain a readable database
        SQLiteDatabase db = getReadableDatabase();

        // send query
        Cursor cursor = db.query(Constants.PHOTO_DIARY_TABLE_NAME, new String[]{
                        Constants.COLUMN_TITLE,
                        Constants.COLUMN_LOCATION,
                        Constants.COLUMN_DESCRIPTION},
                null, null, null, null, null, null); // get all rows

        if (cursor != null) {
            // add items to the list
            for (cursor.moveToFirst(); cursor.isAfterLast() == false; cursor.moveToNext()) {
                items.add(new Album(cursor.getString(0), cursor.getString(1), cursor.getString(2)));
            }

            // close the cursor
            cursor.close();

        }
        // close the database connection
        db.close();

        // return the list
        return items;
    }
}
