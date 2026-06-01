package androidx.room;

import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$needUpgrade$1 extends l implements e6.l {
    final /* synthetic */ int $newVersion;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$needUpgrade$1(int i2) {
        super(1);
        this.$newVersion = i2;
    }

    @Override // e6.l
    public final Boolean invoke(SupportSQLiteDatabase db) {
        k.e(db, "db");
        return Boolean.valueOf(db.needUpgrade(this.$newVersion));
    }
}
