package com.onesignal.core.internal.database.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;
import com.onesignal.core.internal.database.IDatabase;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.session.internal.outcomes.impl.OutcomeTableProvider;
import com.onesignal.session.internal.outcomes.impl.OutcomesDbContract;
import e6.l;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import n6.t;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class OSDatabase extends SQLiteOpenHelper implements IDatabase {
    private static final String COMMA_SEP = ",";
    private static final String DATABASE_NAME = "OneSignal.db";
    private static final int DB_OPEN_RETRY_BACKOFF = 400;
    private static final int DB_OPEN_RETRY_MAX = 5;
    private static final int DB_VERSION = 9;
    public static final int DEFAULT_TTL_IF_NOT_IN_PAYLOAD = 259200;
    private static final String FLOAT_TYPE = " FLOAT";
    private static final String INTEGER_PRIMARY_KEY_TYPE = " INTEGER PRIMARY KEY";
    private static final String INT_TYPE = " INTEGER";
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE notification (_id INTEGER PRIMARY KEY,notification_id TEXT,android_notification_id INTEGER,group_id TEXT,collapse_id TEXT,is_summary INTEGER DEFAULT 0,opened INTEGER DEFAULT 0,dismissed INTEGER DEFAULT 0,title TEXT,message TEXT,full_data TEXT,created_time TIMESTAMP DEFAULT (strftime('%s', 'now')),expire_time TIMESTAMP);";
    private static final String SQL_CREATE_IN_APP_MESSAGE_ENTRIES = "CREATE TABLE in_app_message (_id INTEGER PRIMARY KEY,display_quantity INTEGER,last_display INTEGER,message_id TEXT,displayed_in_session INTEGER,click_ids TEXT);";
    private static final String TEXT_TYPE = " TEXT";
    private static final String TIMESTAMP_TYPE = " TIMESTAMP";
    private final OutcomeTableProvider _outcomeTableProvider;
    public static final Companion Companion = new Companion(null);
    private static final Object LOCK = new Object();
    private static final String[] SQL_INDEX_ENTRIES = {OneSignalDbContract.NotificationTable.INDEX_CREATE_NOTIFICATION_ID, OneSignalDbContract.NotificationTable.INDEX_CREATE_ANDROID_NOTIFICATION_ID, OneSignalDbContract.NotificationTable.INDEX_CREATE_GROUP_ID, OneSignalDbContract.NotificationTable.INDEX_CREATE_COLLAPSE_ID, OneSignalDbContract.NotificationTable.INDEX_CREATE_CREATED_TIME, OneSignalDbContract.NotificationTable.INDEX_CREATE_EXPIRE_TIME};

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    public /* synthetic */ OSDatabase(OutcomeTableProvider outcomeTableProvider, Context context, int i2, int i8, f fVar) {
        this(outcomeTableProvider, context, (i8 & 4) != 0 ? 9 : i2);
    }

    private final SQLiteDatabase getSQLiteDatabase() {
        SQLiteDatabase writableDatabase;
        synchronized (LOCK) {
            try {
                writableDatabase = getWritableDatabase();
                k.d(writableDatabase, "{\n                writableDatabase\n            }");
            } catch (SQLiteCantOpenDatabaseException e) {
                throw e;
            } catch (SQLiteDatabaseLockedException e4) {
                throw e4;
            }
        }
        return writableDatabase;
    }

    private final SQLiteDatabase getSQLiteDatabaseWithRetries() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (LOCK) {
            int i2 = 0;
            while (true) {
                try {
                    sQLiteDatabase = getSQLiteDatabase();
                } catch (SQLiteCantOpenDatabaseException e) {
                    i2++;
                    if (i2 >= 5) {
                        throw e;
                    }
                    SystemClock.sleep(i2 * 400);
                } catch (SQLiteDatabaseLockedException e4) {
                    i2++;
                    if (i2 >= 5) {
                        throw e4;
                    }
                    SystemClock.sleep(i2 * 400);
                }
            }
        }
        return sQLiteDatabase;
    }

    private final synchronized void internalOnUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i8) {
        if (i2 < 2 && i8 >= 2) {
            try {
                upgradeToV2(sQLiteDatabase);
            } catch (Throwable th) {
                throw th;
            }
        }
        if (i2 < 3 && i8 >= 3) {
            upgradeToV3(sQLiteDatabase);
        }
        if (i2 < 4 && i8 >= 4) {
            upgradeToV4(sQLiteDatabase);
        }
        if (i2 < 5 && i8 >= 5) {
            upgradeToV5(sQLiteDatabase);
        }
        if (i2 == 5 && i8 >= 6) {
            upgradeFromV5ToV6(sQLiteDatabase);
        }
        if (i2 < 7 && i8 >= 7) {
            upgradeToV7(sQLiteDatabase);
        }
        if (i2 < 8 && i8 >= 8) {
            upgradeToV8(sQLiteDatabase);
        }
        if (i2 < 9 && i8 >= 9) {
            upgradeToV9(sQLiteDatabase);
        }
    }

    private final void safeExecSQL(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL(str);
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
    }

    private final void upgradeFromV5ToV6(SQLiteDatabase sQLiteDatabase) {
        this._outcomeTableProvider.upgradeOutcomeTableRevision1To2(sQLiteDatabase);
    }

    private final void upgradeToV2(SQLiteDatabase sQLiteDatabase) {
        safeExecSQL(sQLiteDatabase, "ALTER TABLE notification ADD COLUMN collapse_id TEXT;");
        safeExecSQL(sQLiteDatabase, OneSignalDbContract.NotificationTable.INDEX_CREATE_GROUP_ID);
    }

    private final void upgradeToV3(SQLiteDatabase sQLiteDatabase) {
        safeExecSQL(sQLiteDatabase, "ALTER TABLE notification ADD COLUMN expire_time TIMESTAMP;");
        safeExecSQL(sQLiteDatabase, "UPDATE notification SET expire_time = created_time + 259200;");
        safeExecSQL(sQLiteDatabase, OneSignalDbContract.NotificationTable.INDEX_CREATE_EXPIRE_TIME);
    }

    private final void upgradeToV4(SQLiteDatabase sQLiteDatabase) {
        safeExecSQL(sQLiteDatabase, OutcomesDbContract.SQL_CREATE_OUTCOME_ENTRIES_V1);
    }

    private final void upgradeToV5(SQLiteDatabase sQLiteDatabase) {
        safeExecSQL(sQLiteDatabase, OutcomesDbContract.SQL_CREATE_UNIQUE_OUTCOME_ENTRIES_V1);
        upgradeFromV5ToV6(sQLiteDatabase);
    }

    private final void upgradeToV7(SQLiteDatabase sQLiteDatabase) {
        safeExecSQL(sQLiteDatabase, SQL_CREATE_IN_APP_MESSAGE_ENTRIES);
    }

    private final synchronized void upgradeToV8(SQLiteDatabase sQLiteDatabase) {
        this._outcomeTableProvider.upgradeOutcomeTableRevision2To3(sQLiteDatabase);
        this._outcomeTableProvider.upgradeCacheOutcomeTableRevision1To2(sQLiteDatabase);
    }

    private final void upgradeToV9(SQLiteDatabase sQLiteDatabase) {
        this._outcomeTableProvider.upgradeOutcomeTableRevision3To4(sQLiteDatabase);
    }

    @Override // com.onesignal.core.internal.database.IDatabase
    public void delete(String table, String str, String[] strArr) {
        k.e(table, "table");
        synchronized (LOCK) {
            SQLiteDatabase sQLiteDatabaseWithRetries = getSQLiteDatabaseWithRetries();
            try {
                try {
                    sQLiteDatabaseWithRetries.beginTransaction();
                    sQLiteDatabaseWithRetries.delete(table, str, strArr);
                    sQLiteDatabaseWithRetries.setTransactionSuccessful();
                } catch (SQLiteException e) {
                    Logging.error("Error deleting on table: " + table + " with whereClause: " + str + " and whereArgs: " + strArr, e);
                } catch (IllegalStateException e4) {
                    Logging.error("Error under delete transaction under table: " + table + " with whereClause: " + str + " and whereArgs: " + strArr, e4);
                }
                try {
                    sQLiteDatabaseWithRetries.endTransaction();
                } catch (SQLiteException e8) {
                    Logging.error("Error closing transaction! ", e8);
                } catch (IllegalStateException e9) {
                    Logging.error("Error closing transaction! ", e9);
                }
            } catch (Throwable th) {
                try {
                    sQLiteDatabaseWithRetries.endTransaction();
                } catch (SQLiteException e10) {
                    Logging.error("Error closing transaction! ", e10);
                } catch (IllegalStateException e11) {
                    Logging.error("Error closing transaction! ", e11);
                }
                throw th;
            }
        }
    }

    @Override // com.onesignal.core.internal.database.IDatabase
    public void insert(String table, String str, ContentValues contentValues) {
        k.e(table, "table");
        synchronized (LOCK) {
            SQLiteDatabase sQLiteDatabaseWithRetries = getSQLiteDatabaseWithRetries();
            try {
                try {
                    sQLiteDatabaseWithRetries.beginTransaction();
                    sQLiteDatabaseWithRetries.insert(table, str, contentValues);
                    sQLiteDatabaseWithRetries.setTransactionSuccessful();
                } catch (SQLiteException e) {
                    Logging.error("Error inserting on table: " + table + " with nullColumnHack: " + str + " and values: " + contentValues, e);
                } catch (IllegalStateException e4) {
                    Logging.error("Error under inserting transaction under table: " + table + " with nullColumnHack: " + str + " and values: " + contentValues, e4);
                }
                try {
                    sQLiteDatabaseWithRetries.endTransaction();
                } catch (SQLiteException e8) {
                    Logging.error("Error closing transaction! ", e8);
                } catch (IllegalStateException e9) {
                    Logging.error("Error closing transaction! ", e9);
                }
            } catch (Throwable th) {
                try {
                    sQLiteDatabaseWithRetries.endTransaction();
                } catch (SQLiteException e10) {
                    Logging.error("Error closing transaction! ", e10);
                } catch (IllegalStateException e11) {
                    Logging.error("Error closing transaction! ", e11);
                }
                throw th;
            }
        }
    }

    @Override // com.onesignal.core.internal.database.IDatabase
    public void insertOrThrow(String table, String str, ContentValues contentValues) throws SQLException {
        k.e(table, "table");
        synchronized (LOCK) {
            SQLiteDatabase sQLiteDatabaseWithRetries = getSQLiteDatabaseWithRetries();
            try {
                try {
                    sQLiteDatabaseWithRetries.beginTransaction();
                    sQLiteDatabaseWithRetries.insertOrThrow(table, str, contentValues);
                    sQLiteDatabaseWithRetries.setTransactionSuccessful();
                } catch (SQLiteException e) {
                    Logging.error("Error inserting or throw on table: " + table + " with nullColumnHack: " + str + " and values: " + contentValues, e);
                } catch (IllegalStateException e4) {
                    Logging.error("Error under inserting or throw transaction under table: " + table + " with nullColumnHack: " + str + " and values: " + contentValues, e4);
                }
                try {
                    sQLiteDatabaseWithRetries.endTransaction();
                } catch (SQLiteException e8) {
                    Logging.error("Error closing transaction! ", e8);
                } catch (IllegalStateException e9) {
                    Logging.error("Error closing transaction! ", e9);
                }
            } catch (Throwable th) {
                try {
                    sQLiteDatabaseWithRetries.endTransaction();
                } catch (SQLiteException e10) {
                    Logging.error("Error closing transaction! ", e10);
                } catch (IllegalStateException e11) {
                    Logging.error("Error closing transaction! ", e11);
                }
                throw th;
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase db) {
        k.e(db, "db");
        db.execSQL(SQL_CREATE_ENTRIES);
        db.execSQL(OutcomesDbContract.SQL_CREATE_OUTCOME_ENTRIES_V4);
        db.execSQL(OutcomesDbContract.SQL_CREATE_UNIQUE_OUTCOME_ENTRIES_V2);
        db.execSQL(SQL_CREATE_IN_APP_MESSAGE_ENTRIES);
        for (String str : SQL_INDEX_ENTRIES) {
            db.execSQL(str);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase db, int i2, int i8) throws IOException {
        k.e(db, "db");
        Logging.warn$default("SDK version rolled back! Clearing OneSignal.db as it could be in an unexpected state.", null, 2, null);
        Cursor cursorRawQuery = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);
        try {
            ArrayList arrayList = new ArrayList(cursorRawQuery.getCount());
            while (cursorRawQuery.moveToNext()) {
                String string = cursorRawQuery.getString(0);
                k.d(string, "it.getString(0)");
                arrayList.add(string);
            }
            int size = arrayList.size();
            int i9 = 0;
            while (i9 < size) {
                Object obj = arrayList.get(i9);
                i9++;
                String str = (String) obj;
                if (!t.n0(str, "sqlite_", false)) {
                    db.execSQL("DROP TABLE IF EXISTS " + str);
                }
            }
            cursorRawQuery.close();
            onCreate(db);
        } finally {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase db, int i2, int i8) {
        k.e(db, "db");
        Logging.debug$default("OneSignal Database onUpgrade from: " + i2 + " to: " + i8, null, 2, null);
        try {
            internalOnUpgrade(db, i2, i8);
        } catch (SQLiteException e) {
            Logging.error("Error in upgrade, migration may have already run! Skipping!", e);
        }
    }

    @Override // com.onesignal.core.internal.database.IDatabase
    public void query(String table, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5, l action) throws IOException {
        Cursor cursorQuery;
        k.e(table, "table");
        k.e(action, "action");
        synchronized (LOCK) {
            try {
                if (str5 == null) {
                    cursorQuery = getSQLiteDatabaseWithRetries().query(table, strArr, str, strArr2, str2, str3, str4);
                    k.d(cursorQuery, "getSQLiteDatabaseWithRet…By,\n                    )");
                } else {
                    cursorQuery = getSQLiteDatabaseWithRetries().query(table, strArr, str, strArr2, str2, str3, str4, str5);
                    k.d(cursorQuery, "getSQLiteDatabaseWithRet…it,\n                    )");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        try {
            action.invoke(new DatabaseCursor(cursorQuery));
            cursorQuery.close();
        } finally {
        }
    }

    @Override // com.onesignal.core.internal.database.IDatabase
    public int update(String table, ContentValues values, String str, String[] strArr) {
        k.e(table, "table");
        k.e(values, "values");
        String string = values.toString();
        k.d(string, "values.toString()");
        int iUpdate = 0;
        if (string.length() == 0) {
            return 0;
        }
        synchronized (LOCK) {
            SQLiteDatabase sQLiteDatabaseWithRetries = getSQLiteDatabaseWithRetries();
            try {
                try {
                    sQLiteDatabaseWithRetries.beginTransaction();
                    iUpdate = sQLiteDatabaseWithRetries.update(table, values, str, strArr);
                    sQLiteDatabaseWithRetries.setTransactionSuccessful();
                } catch (SQLiteException e) {
                    Logging.error("Error updating on table: " + table + " with whereClause: " + str + " and whereArgs: " + strArr, e);
                } catch (IllegalStateException e4) {
                    Logging.error("Error under update transaction under table: " + table + " with whereClause: " + str + " and whereArgs: " + strArr, e4);
                }
                try {
                    try {
                        sQLiteDatabaseWithRetries.endTransaction();
                    } catch (IllegalStateException e8) {
                        Logging.error("Error closing transaction! ", e8);
                    }
                } catch (SQLiteException e9) {
                    Logging.error("Error closing transaction! ", e9);
                }
            } catch (Throwable th) {
                try {
                    try {
                        sQLiteDatabaseWithRetries.endTransaction();
                    } catch (IllegalStateException e10) {
                        Logging.error("Error closing transaction! ", e10);
                    }
                } catch (SQLiteException e11) {
                    Logging.error("Error closing transaction! ", e11);
                }
                throw th;
            }
        }
        return iUpdate;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OSDatabase(OutcomeTableProvider _outcomeTableProvider, Context context, int i2) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, i2);
        k.e(_outcomeTableProvider, "_outcomeTableProvider");
        this._outcomeTableProvider = _outcomeTableProvider;
    }
}
