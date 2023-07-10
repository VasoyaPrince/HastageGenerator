package wimble.hashtag.hashtagram.hashtaggenerate;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {
    private static String DB_NAME = "hashtag_database.db";
    private static String DB_PATH = "";
    private static final int DB_VERSION = 1;
    private final Context mContext;
    private SQLiteDatabase mDataBase;
    private boolean mNeedUpdate = false;

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    public DbHelper(Context context) {
        super(context, DB_NAME, (SQLiteDatabase.CursorFactory) null, 1);
        if (Build.VERSION.SDK_INT >= 17) {
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        } else {
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        }
        this.mContext = context;
        copyDataBase();
    }

    public void updateDataBase() throws IOException {
        if (this.mNeedUpdate) {
            File file = new File(DB_PATH + DB_NAME);
            if (file.exists()) {
                file.delete();
            }
            copyDataBase();
            this.mNeedUpdate = false;
        }
    }

    private boolean checkDataBase() {
        return new File(DB_PATH + DB_NAME).exists();
    }

    private void copyDataBase() {
        if (!checkDataBase()) {
            getReadableDatabase();
            close();
            try {
                copyDBFile();
            } catch (IOException unused) {
                throw new Error("ErrorCopyingDataBase");
            }
        }
    }

    private void copyDBFile() throws IOException {
        InputStream open = this.mContext.getAssets().open(DB_NAME);
        FileOutputStream fileOutputStream = new FileOutputStream(DB_PATH + DB_NAME);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = open.read(bArr);
            if (read > 0) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                fileOutputStream.flush();
                fileOutputStream.close();
                open.close();
                return;
            }
        }
    }

    public boolean openDataBase() throws SQLException {
        this.mDataBase = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null, 1);
        if (this.mDataBase != null) {
            return true;
        }
        return false;
    }

    public synchronized void close() {
        if (this.mDataBase != null) {
            this.mDataBase.close();
        }
        super.close();
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i2 > i) {
            this.mNeedUpdate = true;
        }
    }

    public Cursor getHashtagsCategories() {
        openDataBase();
        getReadableDatabase();
        Cursor cursor = null;
        try {
            cursor = this.mDataBase.rawQuery("SELECT * FROM tbl_hashtag_category", null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            this.mDataBase.close();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("tag", "exception " + e.toString());
            this.mDataBase.close();
        }
        return cursor;
    }

    public Cursor getAllHashtagsNameSpecificCategories(String str) {
        openDataBase();
        getReadableDatabase();
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.mDataBase;
            cursor = sQLiteDatabase.rawQuery("SELECT * FROM tbl_hashtag_name where category='" + str + "'", null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            this.mDataBase.close();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("tag", "exception " + e.toString());
            this.mDataBase.close();
        }
        return cursor;
    }

    public String getASpecificHashTagDetails(String str, String str2) {
        String str3;
        openDataBase();
        getReadableDatabase();
        try {
            Cursor rawQuery = this.mDataBase.rawQuery("SELECT * FROM tbl_hashtag_name where category='" + str2 + "' And tag_name='" + str + "'", null);
            if (rawQuery != null) {
                str3 = "";
                rawQuery.moveToFirst();
                do {
                    str3 = str3 + rawQuery.getString(3);
                } while (rawQuery.moveToNext());
            } else {
                str3 = "0";
            }
            this.mDataBase.close();
            return str3;
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("tag", "exception " + e.toString());
            this.mDataBase.close();
            return "-1";
        }
    }

    public String addNewHashTag(String str, String str2) {
        this.mDataBase = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null, 0);
        this.mDataBase.enableWriteAheadLogging();
        getWritableDatabase();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("category", "Other");
            contentValues.put("tag_name", str);
            contentValues.put("tag_name_detail", str2);
            this.mDataBase.insert("tbl_hashtag_name", null, contentValues);
            this.mDataBase.close();
            return "1";
        } catch (Exception e) {
            e.printStackTrace();
            return "-1";
        }
    }

    public ArrayList<String> getAllHashTags(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        openDataBase();
        getReadableDatabase();
        try {
            SQLiteDatabase sQLiteDatabase = this.mDataBase;
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM tbl_hashtag_name where tag_name_detail like '%" + str + "%'", null);
            if (rawQuery != null) {
                rawQuery.moveToFirst();
                do {
                    arrayList.add(rawQuery.getString(3));
                } while (rawQuery.moveToNext());
            }
            this.mDataBase.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
