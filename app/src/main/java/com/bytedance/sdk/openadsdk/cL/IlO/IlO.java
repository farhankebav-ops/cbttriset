package com.bytedance.sdk.openadsdk.cl.IlO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.bytedance.sdk.component.utils.oeT;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO extends SQLiteOpenHelper {
    private static volatile IlO MY;
    final Context IlO;

    private IlO(Context context) {
        super(context, "pag_monitor.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.IlO = context;
    }

    private static IlO EO() {
        if (MY == null) {
            synchronized (IlO.class) {
                try {
                    if (MY == null) {
                        MY = new IlO(com.bytedance.sdk.openadsdk.cl.IlO.IlO());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return MY;
    }

    public static SQLiteDatabase IlO() {
        try {
            IlO ilOEO = EO();
            if (ilOEO == null) {
                return null;
            }
            SQLiteDatabase writableDatabase = ilOEO.getWritableDatabase();
            if (writableDatabase.isOpen()) {
                return writableDatabase;
            }
            return null;
        } catch (Throwable th) {
            Log.i("MonitorSQLiteOpenHelper", th.getMessage());
            return null;
        }
    }

    public static SQLiteDatabase MY() {
        try {
            IlO ilOEO = EO();
            if (ilOEO == null) {
                return null;
            }
            SQLiteDatabase readableDatabase = ilOEO.getReadableDatabase();
            if (readableDatabase.isOpen()) {
                return readableDatabase;
            }
            return null;
        } catch (Throwable th) {
            Log.i("MonitorSQLiteOpenHelper", th.getMessage());
            return null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS monitor_table (_id INTEGER PRIMARY KEY AUTOINCREMENT,sdk_version TEXT ,scene TEXT ,start_count INTEGER default 0 , success_count INTEGER default 0  , fail_count INTEGER default 0  , rit TEXT  , tag TEXT  , label TEXT  , timestamp INTEGER default 0 ,mediation TEXT  , is_init INTEGER , extra TEXT )");
        } catch (Throwable th) {
            Log.e("MonitorSQLiteOpenHelper", th.getMessage());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i8) {
        try {
            if (i2 <= i8) {
                onCreate(sQLiteDatabase);
            } else {
                IlO(sQLiteDatabase);
                onCreate(sQLiteDatabase);
            }
        } catch (Throwable unused) {
        }
    }

    private void IlO(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> arrayListMY = MY(sQLiteDatabase);
        if (arrayListMY == null || arrayListMY.size() <= 0) {
            return;
        }
        int size = arrayListMY.size();
        int i2 = 0;
        while (i2 < size) {
            String str = arrayListMY.get(i2);
            i2++;
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str + " ;");
        }
    }

    private ArrayList<String> MY(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery("select name from sqlite_master where type='table' order by name", null);
            if (cursorRawQuery != null) {
                while (cursorRawQuery.moveToNext()) {
                    String string = cursorRawQuery.getString(0);
                    if (!string.equals("android_metadata") && !string.equals("sqlite_sequence")) {
                        arrayList.add(string);
                    }
                }
                cursorRawQuery.close();
            }
            return arrayList;
        } catch (Exception e) {
            oeT.EO("MonitorSQLiteOpenHelper", e.getMessage());
            return arrayList;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i8) {
    }
}
