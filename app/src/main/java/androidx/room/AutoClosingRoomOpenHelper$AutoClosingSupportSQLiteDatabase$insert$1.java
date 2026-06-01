package androidx.room;

import android.content.ContentValues;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$insert$1 extends l implements e6.l {
    final /* synthetic */ int $conflictAlgorithm;
    final /* synthetic */ String $table;
    final /* synthetic */ ContentValues $values;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$insert$1(String str, int i2, ContentValues contentValues) {
        super(1);
        this.$table = str;
        this.$conflictAlgorithm = i2;
        this.$values = contentValues;
    }

    @Override // e6.l
    public final Long invoke(SupportSQLiteDatabase db) {
        k.e(db, "db");
        return Long.valueOf(db.insert(this.$table, this.$conflictAlgorithm, this.$values));
    }
}
