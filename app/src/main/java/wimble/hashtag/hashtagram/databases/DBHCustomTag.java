package wimble.hashtag.hashtagram.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHCustomTag extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "customTagsDB";
    private static final String KEY_name = "name";
    private static final String KEY_tags = "tags";
    private static final String TABLE_NAME = "CustomTags";

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        sQLiteDatabase.disableWriteAheadLogging();
    }

    public DBHCustomTag(Context context) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 2);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE CustomTags(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,tags TEXT)");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS CustomTags");
        onCreate(sQLiteDatabase);
    }

    public void AddtoPosts(ItemsPost itemsPost) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_name, itemsPost.getName());
        contentValues.put(KEY_tags, itemsPost.getTags());
        writableDatabase.insert(TABLE_NAME, null, contentValues);
        writableDatabase.close();
    }

    public List<ItemsPost> getAllPost() {
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = getWritableDatabase().rawQuery("SELECT * FROM CustomTags", null);
        if (rawQuery.moveToFirst()) {
            do {
                ItemsPost itemsPost = new ItemsPost(rawQuery.getString(1), rawQuery.getString(2));
                itemsPost.setId(rawQuery.getInt(0));
                itemsPost.setName(rawQuery.getString(1));
                itemsPost.setTags(rawQuery.getString(2));
                arrayList.add(itemsPost);
            } while (rawQuery.moveToNext());
        }
        return arrayList;
    }

    public void removeSingleContact(String title) {
        SQLiteDatabase database = this.getWritableDatabase();
        database.execSQL("DELETE FROM " + TABLE_NAME + " WHERE " + KEY_name + "= '" + title + "'");
        database.close();
    }

}