package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$execute$1 extends l implements e6.l {
    public static final AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$execute$1 INSTANCE = new AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$execute$1();

    public AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$execute$1() {
        super(1);
    }

    @Override // e6.l
    public final Object invoke(SupportSQLiteStatement statement) {
        k.e(statement, "statement");
        statement.execute();
        return null;
    }
}
