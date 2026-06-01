package androidx.room;

import androidx.room.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeSqliteStatementWithRefCount$1 extends l implements e6.l {
    final /* synthetic */ e6.l $block;
    final /* synthetic */ AutoClosingRoomOpenHelper.AutoClosingSupportSqliteStatement this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeSqliteStatementWithRefCount$1(AutoClosingRoomOpenHelper.AutoClosingSupportSqliteStatement autoClosingSupportSqliteStatement, e6.l lVar) {
        super(1);
        this.this$0 = autoClosingSupportSqliteStatement;
        this.$block = lVar;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [T, java.lang.Object] */
    @Override // e6.l
    public final T invoke(SupportSQLiteDatabase db) {
        k.e(db, "db");
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = db.compileStatement(this.this$0.sql);
        this.this$0.doBinds(supportSQLiteStatementCompileStatement);
        return this.$block.invoke(supportSQLiteStatementCompileStatement);
    }
}
