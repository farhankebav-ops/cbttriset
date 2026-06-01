package androidx.room;

import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setMaximumSize$1 extends l implements e6.l {
    final /* synthetic */ long $numBytes;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setMaximumSize$1(long j) {
        super(1);
        this.$numBytes = j;
    }

    @Override // e6.l
    public final Long invoke(SupportSQLiteDatabase db) {
        k.e(db, "db");
        return Long.valueOf(db.setMaximumSize(this.$numBytes));
    }
}
