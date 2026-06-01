package com.ironsource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class I4 extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static H4 f6968a = new H4();

    public I4(Context context) {
        super(context, "reports", (SQLiteDatabase.CursorFactory) null, 1);
    }

    public static void a(P5 p52) {
        SQLiteDatabase sQLiteDatabaseA;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabaseA = f6968a.a(true, new I4(C2531r4.d().a()));
        } catch (Throwable th) {
            th = th;
        }
        try {
            sQLiteDatabaseA.beginTransaction();
            ContentValues contentValues = new ContentValues();
            String strE = p52.e();
            String strB = p52.b();
            String strD = p52.d();
            contentValues.put("stack_trace", strE);
            contentValues.put("crash_date", strB);
            contentValues.put("crashType", strD);
            sQLiteDatabaseA.insert("REPORTS", null, contentValues);
            sQLiteDatabaseA.setTransactionSuccessful();
            sQLiteDatabaseA.endTransaction();
            sQLiteDatabaseA.close();
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = sQLiteDatabaseA;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
                sQLiteDatabase.close();
            }
            throw th;
        }
    }

    public static P5 b(int i2) throws Throwable {
        SQLiteDatabase sQLiteDatabaseA;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabaseA = f6968a.a(new I4(C2531r4.d().a()));
        } catch (Throwable th) {
            th = th;
        }
        try {
            Cursor cursorRawQuery = sQLiteDatabaseA.rawQuery("SELECT * FROM REPORTSWHERE id= " + i2 + ";", null);
            int i8 = cursorRawQuery.getInt(0);
            String string = cursorRawQuery.getString(1);
            String string2 = cursorRawQuery.getString(2);
            String string3 = cursorRawQuery.getString(3);
            cursorRawQuery.close();
            P5 p52 = new P5(i8, string, string2, string3);
            sQLiteDatabaseA.close();
            return p52;
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = sQLiteDatabaseA;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            throw th;
        }
    }

    public static Cursor c() throws Throwable {
        SQLiteDatabase sQLiteDatabaseA;
        I4 i42 = new I4(C2531r4.d().a());
        new ArrayList();
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabaseA = f6968a.a(i42);
        } catch (Throwable th) {
            th = th;
        }
        try {
            Cursor cursorRawQuery = sQLiteDatabaseA.rawQuery("SELECT * FROM REPORTS;", null);
            sQLiteDatabaseA.close();
            return cursorRawQuery;
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = sQLiteDatabaseA;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            throw th;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS REPORTS(id INTEGER PRIMARY KEY AUTOINCREMENT , stack_trace TEXT NOT NULL, crash_date TEXT NOT NULL,crashType TEXT NOT NULL );");
    }

    public static List<P5> b() {
        I4 i42 = new I4(C2531r4.d().a());
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase sQLiteDatabaseA = f6968a.a(i42);
            try {
                Cursor cursorRawQuery = sQLiteDatabaseA.rawQuery("SELECT * FROM REPORTS ;", null);
                if (cursorRawQuery.moveToFirst()) {
                    do {
                        arrayList.add(new P5(cursorRawQuery.getInt(0), cursorRawQuery.getString(1), cursorRawQuery.getString(2), cursorRawQuery.getString(3)));
                    } while (cursorRawQuery.moveToNext());
                }
                cursorRawQuery.close();
                sQLiteDatabaseA.close();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                sQLiteDatabase = sQLiteDatabaseA;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static Cursor a(int i2) throws Throwable {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase sQLiteDatabaseA = f6968a.a(new I4(C2531r4.d().a()));
            try {
                Cursor cursorRawQuery = sQLiteDatabaseA.rawQuery("SELECT * FROM REPORTSWHERE id= " + i2 + ";", null);
                sQLiteDatabaseA.close();
                return cursorRawQuery;
            } catch (Throwable th) {
                th = th;
                sQLiteDatabase = sQLiteDatabaseA;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void a() {
        SQLiteDatabase sQLiteDatabaseA = null;
        try {
            sQLiteDatabaseA = f6968a.a(true, new I4(C2531r4.d().a()));
            sQLiteDatabaseA.execSQL("DELETE FROM REPORTS WHERE id >= 0;");
            sQLiteDatabaseA.close();
        } catch (Throwable th) {
            if (sQLiteDatabaseA != null) {
                sQLiteDatabaseA.close();
            }
            throw th;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i8) {
    }
}
