package androidx.sqlite.db.framework;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import e6.r;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements SQLiteDatabase.CursorFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4082b;

    public /* synthetic */ a(Object obj, int i2) {
        this.f4081a = i2;
        this.f4082b = obj;
    }

    @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
    public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        switch (this.f4081a) {
            case 0:
                return FrameworkSQLiteDatabase.query$lambda$1((SupportSQLiteQuery) this.f4082b, sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
            default:
                return FrameworkSQLiteDatabase.query$lambda$0((r) this.f4082b, sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
        }
    }
}
