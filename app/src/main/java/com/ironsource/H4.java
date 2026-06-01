package com.ironsource;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class H4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6906a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f6907b = new Object();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        private a() {
        }
    }

    public final SQLiteDatabase a(SQLiteOpenHelper sqliteOpenHelper) {
        kotlin.jvm.internal.k.e(sqliteOpenHelper, "sqliteOpenHelper");
        return a(this, false, sqliteOpenHelper, 1, null);
    }

    public static /* synthetic */ SQLiteDatabase a(H4 h42, boolean z2, SQLiteOpenHelper sQLiteOpenHelper, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z2 = false;
        }
        return h42.a(z2, sQLiteOpenHelper);
    }

    public final SQLiteDatabase a(boolean z2, SQLiteOpenHelper sqliteOpenHelper) {
        SQLiteDatabase readableDatabase;
        kotlin.jvm.internal.k.e(sqliteOpenHelper, "sqliteOpenHelper");
        synchronized (f6907b) {
            try {
                if (z2) {
                    readableDatabase = sqliteOpenHelper.getWritableDatabase();
                } else {
                    readableDatabase = sqliteOpenHelper.getReadableDatabase();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return readableDatabase;
    }
}
