package androidx.room;

import androidx.sqlite.db.SupportSQLiteDatabase;
import java.util.Locale;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setLocale$1 extends l implements e6.l {
    final /* synthetic */ Locale $locale;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setLocale$1(Locale locale) {
        super(1);
        this.$locale = locale;
    }

    @Override // e6.l
    public final Object invoke(SupportSQLiteDatabase db) {
        k.e(db, "db");
        db.setLocale(this.$locale);
        return null;
    }
}
