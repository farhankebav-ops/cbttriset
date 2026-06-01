package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;
import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class SharedSQLiteStatement$stmt$2 extends l implements e6.a {
    final /* synthetic */ SharedSQLiteStatement this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharedSQLiteStatement$stmt$2(SharedSQLiteStatement sharedSQLiteStatement) {
        super(0);
        this.this$0 = sharedSQLiteStatement;
    }

    @Override // e6.a
    public final SupportSQLiteStatement invoke() {
        return this.this$0.createNewStatement();
    }
}
