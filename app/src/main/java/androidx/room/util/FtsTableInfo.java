package androidx.room.util;

import android.database.Cursor;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Set;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import n6.m;
import n7.b;
import r2.q;
import r5.l;
import r5.t;
import s5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class FtsTableInfo {
    public static final Companion Companion = new Companion(null);
    private static final String[] FTS_OPTIONS = {"tokenize=", "compress=", "content=", "languageid=", "matchinfo=", "notindexed=", "order=", "prefix=", "uncompress="};
    public final Set<String> columns;
    public final String name;
    public final Set<String> options;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private final Set<String> readColumns(SupportSQLiteDatabase supportSQLiteDatabase, String str) throws IOException {
            i iVar = new i();
            Cursor cursorQuery = supportSQLiteDatabase.query("PRAGMA table_info(`" + str + "`)");
            try {
                if (cursorQuery.getColumnCount() > 0) {
                    int columnIndex = cursorQuery.getColumnIndex("name");
                    while (cursorQuery.moveToNext()) {
                        String string = cursorQuery.getString(columnIndex);
                        k.d(string, "cursor.getString(nameIndex)");
                        iVar.add(string);
                    }
                }
                cursorQuery.close();
                return b.f(iVar);
            } finally {
            }
        }

        private final Set<String> readOptions(SupportSQLiteDatabase supportSQLiteDatabase, String str) throws IOException {
            Cursor cursorQuery = supportSQLiteDatabase.query("SELECT * FROM sqlite_master WHERE `name` = '" + str + '\'');
            try {
                String sql = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("sql")) : "";
                q.I(cursorQuery, null);
                k.d(sql, "sql");
                return parseOptions(sql);
            } finally {
            }
        }

        @VisibleForTesting
        public final Set<String> parseOptions(String createStatement) {
            Character ch;
            k.e(createStatement, "createStatement");
            if (createStatement.length() == 0) {
                return t.f13640a;
            }
            String strSubstring = createStatement.substring(m.x0(createStatement, '(', 0, 6) + 1, m.B0(createStatement, ')', 0, 6));
            k.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            ArrayList arrayList = new ArrayList();
            ArrayDeque arrayDeque = new ArrayDeque();
            int i2 = -1;
            int i8 = 0;
            int i9 = 0;
            while (i8 < strSubstring.length()) {
                char cCharAt = strSubstring.charAt(i8);
                int i10 = i9 + 1;
                if (cCharAt == '\'' || cCharAt == '\"' || cCharAt == '`') {
                    if (arrayDeque.isEmpty()) {
                        arrayDeque.push(Character.valueOf(cCharAt));
                    } else {
                        Character ch2 = (Character) arrayDeque.peek();
                        if (ch2 != null && ch2.charValue() == cCharAt) {
                            arrayDeque.pop();
                        }
                    }
                } else if (cCharAt == '[') {
                    if (arrayDeque.isEmpty()) {
                        arrayDeque.push(Character.valueOf(cCharAt));
                    }
                } else if (cCharAt == ']') {
                    if (!arrayDeque.isEmpty() && (ch = (Character) arrayDeque.peek()) != null && ch.charValue() == '[') {
                        arrayDeque.pop();
                    }
                } else if (cCharAt == ',' && arrayDeque.isEmpty()) {
                    String strSubstring2 = strSubstring.substring(i2 + 1, i9);
                    k.d(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    int length = strSubstring2.length() - 1;
                    int i11 = 0;
                    boolean z2 = false;
                    while (i11 <= length) {
                        boolean z7 = k.g(strSubstring2.charAt(!z2 ? i11 : length), 32) <= 0;
                        if (z2) {
                            if (!z7) {
                                break;
                            }
                            length--;
                        } else if (z7) {
                            i11++;
                        } else {
                            z2 = true;
                        }
                    }
                    arrayList.add(strSubstring2.subSequence(i11, length + 1).toString());
                    i2 = i9;
                }
                i8++;
                i9 = i10;
            }
            String strSubstring3 = strSubstring.substring(i2 + 1);
            k.d(strSubstring3, "this as java.lang.String).substring(startIndex)");
            arrayList.add(m.T0(strSubstring3).toString());
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i12 = 0;
            while (i12 < size) {
                Object obj = arrayList.get(i12);
                i12++;
                String str = (String) obj;
                String[] strArr = FtsTableInfo.FTS_OPTIONS;
                int length2 = strArr.length;
                int i13 = 0;
                while (true) {
                    if (i13 >= length2) {
                        break;
                    }
                    if (n6.t.n0(str, strArr[i13], false)) {
                        arrayList2.add(obj);
                        break;
                    }
                    i13++;
                }
            }
            return l.r1(arrayList2);
        }

        public final FtsTableInfo read(SupportSQLiteDatabase database, String tableName) {
            k.e(database, "database");
            k.e(tableName, "tableName");
            return new FtsTableInfo(tableName, readColumns(database, tableName), readOptions(database, tableName));
        }

        private Companion() {
        }
    }

    public FtsTableInfo(String name, Set<String> columns, Set<String> options) {
        k.e(name, "name");
        k.e(columns, "columns");
        k.e(options, "options");
        this.name = name;
        this.columns = columns;
        this.options = options;
    }

    @VisibleForTesting
    public static final Set<String> parseOptions(String str) {
        return Companion.parseOptions(str);
    }

    public static final FtsTableInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        return Companion.read(supportSQLiteDatabase, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FtsTableInfo)) {
            return false;
        }
        FtsTableInfo ftsTableInfo = (FtsTableInfo) obj;
        if (k.a(this.name, ftsTableInfo.name) && k.a(this.columns, ftsTableInfo.columns)) {
            return k.a(this.options, ftsTableInfo.options);
        }
        return false;
    }

    public int hashCode() {
        return this.options.hashCode() + ((this.columns.hashCode() + (this.name.hashCode() * 31)) * 31);
    }

    public String toString() {
        return "FtsTableInfo{name='" + this.name + "', columns=" + this.columns + ", options=" + this.options + "'}";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FtsTableInfo(String name, Set<String> columns, String createSql) {
        this(name, columns, Companion.parseOptions(createSql));
        k.e(name, "name");
        k.e(columns, "columns");
        k.e(createSql, "createSql");
    }
}
