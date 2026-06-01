package androidx.room.util;

import a1.a;
import android.database.Cursor;
import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.io.IOException;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ViewInfo {
    public static final Companion Companion = new Companion(null);
    public final String name;
    public final String sql;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final ViewInfo read(SupportSQLiteDatabase database, String viewName) throws IOException {
            ViewInfo viewInfo;
            k.e(database, "database");
            k.e(viewName, "viewName");
            Cursor cursorQuery = database.query("SELECT name, sql FROM sqlite_master WHERE type = 'view' AND name = '" + viewName + '\'');
            try {
                if (cursorQuery.moveToFirst()) {
                    String string = cursorQuery.getString(0);
                    k.d(string, "cursor.getString(0)");
                    viewInfo = new ViewInfo(string, cursorQuery.getString(1));
                } else {
                    viewInfo = new ViewInfo(viewName, null);
                }
                q.I(cursorQuery, null);
                return viewInfo;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    q.I(cursorQuery, th);
                    throw th2;
                }
            }
        }

        private Companion() {
        }
    }

    public ViewInfo(String name, String str) {
        k.e(name, "name");
        this.name = name;
        this.sql = str;
    }

    public static final ViewInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        return Companion.read(supportSQLiteDatabase, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ViewInfo)) {
            return false;
        }
        ViewInfo viewInfo = (ViewInfo) obj;
        if (k.a(this.name, viewInfo.name)) {
            String str = this.sql;
            String str2 = viewInfo.sql;
            if (str != null ? k.a(str, str2) : str2 == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = this.name.hashCode() * 31;
        String str = this.sql;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ViewInfo{name='");
        sb.append(this.name);
        sb.append("', sql='");
        return a.r(sb, this.sql, "'}");
    }
}
