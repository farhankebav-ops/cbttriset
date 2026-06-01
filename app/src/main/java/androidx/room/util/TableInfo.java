package androidx.room.util;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.processing.util.a;
import androidx.room.ColumnInfo;
import androidx.room.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.google.android.gms.ads.AdError;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import n6.m;
import r5.t;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class TableInfo {
    public static final int CREATED_FROM_DATABASE = 2;
    public static final int CREATED_FROM_ENTITY = 1;
    public static final int CREATED_FROM_UNKNOWN = 0;
    public static final Companion Companion = new Companion(null);
    public final Map<String, Column> columns;
    public final Set<ForeignKey> foreignKeys;
    public final Set<Index> indices;
    public final String name;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final TableInfo read(SupportSQLiteDatabase database, String tableName) {
            k.e(database, "database");
            k.e(tableName, "tableName");
            return TableInfoKt.readTableInfo(database, tableName);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface CreatedFrom {
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final class ForeignKey {
        public final List<String> columnNames;
        public final String onDelete;
        public final String onUpdate;
        public final List<String> referenceColumnNames;
        public final String referenceTable;

        public ForeignKey(String referenceTable, String onDelete, String onUpdate, List<String> columnNames, List<String> referenceColumnNames) {
            k.e(referenceTable, "referenceTable");
            k.e(onDelete, "onDelete");
            k.e(onUpdate, "onUpdate");
            k.e(columnNames, "columnNames");
            k.e(referenceColumnNames, "referenceColumnNames");
            this.referenceTable = referenceTable;
            this.onDelete = onDelete;
            this.onUpdate = onUpdate;
            this.columnNames = columnNames;
            this.referenceColumnNames = referenceColumnNames;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ForeignKey)) {
                return false;
            }
            ForeignKey foreignKey = (ForeignKey) obj;
            if (k.a(this.referenceTable, foreignKey.referenceTable) && k.a(this.onDelete, foreignKey.onDelete) && k.a(this.onUpdate, foreignKey.onUpdate) && k.a(this.columnNames, foreignKey.columnNames)) {
                return k.a(this.referenceColumnNames, foreignKey.referenceColumnNames);
            }
            return false;
        }

        public int hashCode() {
            return this.referenceColumnNames.hashCode() + ((this.columnNames.hashCode() + a.b(a.b(this.referenceTable.hashCode() * 31, 31, this.onDelete), 31, this.onUpdate)) * 31);
        }

        public String toString() {
            return "ForeignKey{referenceTable='" + this.referenceTable + "', onDelete='" + this.onDelete + " +', onUpdate='" + this.onUpdate + "', columnNames=" + this.columnNames + ", referenceColumnNames=" + this.referenceColumnNames + '}';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class ForeignKeyWithSequence implements Comparable<ForeignKeyWithSequence> {
        private final String from;
        private final int id;
        private final int sequence;
        private final String to;

        public ForeignKeyWithSequence(int i2, int i8, String from, String to) {
            k.e(from, "from");
            k.e(to, "to");
            this.id = i2;
            this.sequence = i8;
            this.from = from;
            this.to = to;
        }

        public final String getFrom() {
            return this.from;
        }

        public final int getId() {
            return this.id;
        }

        public final int getSequence() {
            return this.sequence;
        }

        public final String getTo() {
            return this.to;
        }

        @Override // java.lang.Comparable
        public int compareTo(ForeignKeyWithSequence other) {
            k.e(other, "other");
            int i2 = this.id - other.id;
            return i2 == 0 ? this.sequence - other.sequence : i2;
        }
    }

    public TableInfo(String name, Map<String, Column> columns, Set<ForeignKey> foreignKeys, Set<Index> set) {
        k.e(name, "name");
        k.e(columns, "columns");
        k.e(foreignKeys, "foreignKeys");
        this.name = name;
        this.columns = columns;
        this.foreignKeys = foreignKeys;
        this.indices = set;
    }

    public static final TableInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        return Companion.read(supportSQLiteDatabase, str);
    }

    public boolean equals(Object obj) {
        Set<Index> set;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TableInfo)) {
            return false;
        }
        TableInfo tableInfo = (TableInfo) obj;
        if (!k.a(this.name, tableInfo.name) || !k.a(this.columns, tableInfo.columns) || !k.a(this.foreignKeys, tableInfo.foreignKeys)) {
            return false;
        }
        Set<Index> set2 = this.indices;
        if (set2 == null || (set = tableInfo.indices) == null) {
            return true;
        }
        return k.a(set2, set);
    }

    public int hashCode() {
        return this.foreignKeys.hashCode() + ((this.columns.hashCode() + (this.name.hashCode() * 31)) * 31);
    }

    public String toString() {
        return "TableInfo{name='" + this.name + "', columns=" + this.columns + ", foreignKeys=" + this.foreignKeys + ", indices=" + this.indices + '}';
    }

    public /* synthetic */ TableInfo(String str, Map map, Set set, Set set2, int i2, f fVar) {
        this(str, map, set, (i2 & 8) != 0 ? null : set2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TableInfo(String name, Map<String, Column> columns, Set<ForeignKey> foreignKeys) {
        this(name, columns, foreignKeys, t.f13640a);
        k.e(name, "name");
        k.e(columns, "columns");
        k.e(foreignKeys, "foreignKeys");
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Column {
        public static final Companion Companion = new Companion(null);
        public final int affinity;
        public final int createdFrom;
        public final String defaultValue;
        public final String name;
        public final boolean notNull;
        public final int primaryKeyPosition;
        public final String type;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(f fVar) {
                this();
            }

            private final boolean containsSurroundingParenthesis(String str) {
                if (str.length() == 0) {
                    return false;
                }
                int i2 = 0;
                int i8 = 0;
                int i9 = 0;
                while (i2 < str.length()) {
                    char cCharAt = str.charAt(i2);
                    int i10 = i9 + 1;
                    if (i9 == 0 && cCharAt != '(') {
                        return false;
                    }
                    if (cCharAt == '(') {
                        i8++;
                    } else if (cCharAt == ')' && i8 - 1 == 0 && i9 != str.length() - 1) {
                        return false;
                    }
                    i2++;
                    i9 = i10;
                }
                return i8 == 0;
            }

            @VisibleForTesting
            public final boolean defaultValueEquals(String current, String str) {
                k.e(current, "current");
                if (current.equals(str)) {
                    return true;
                }
                if (!containsSurroundingParenthesis(current)) {
                    return false;
                }
                String strSubstring = current.substring(1, current.length() - 1);
                k.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                return k.a(m.T0(strSubstring).toString(), str);
            }

            private Companion() {
            }
        }

        public Column(String name, String type, boolean z2, int i2, String str, int i8) {
            k.e(name, "name");
            k.e(type, "type");
            this.name = name;
            this.type = type;
            this.notNull = z2;
            this.primaryKeyPosition = i2;
            this.defaultValue = str;
            this.createdFrom = i8;
            this.affinity = findAffinity(type);
        }

        @VisibleForTesting
        public static final boolean defaultValueEquals(String str, String str2) {
            return Companion.defaultValueEquals(str, str2);
        }

        @ColumnInfo.SQLiteTypeAffinity
        private final int findAffinity(String str) {
            if (str == null) {
                return 5;
            }
            Locale US = Locale.US;
            k.d(US, "US");
            String upperCase = str.toUpperCase(US);
            k.d(upperCase, "this as java.lang.String).toUpperCase(locale)");
            if (m.q0(upperCase, "INT", false)) {
                return 3;
            }
            if (m.q0(upperCase, "CHAR", false) || m.q0(upperCase, "CLOB", false) || m.q0(upperCase, "TEXT", false)) {
                return 2;
            }
            if (m.q0(upperCase, "BLOB", false)) {
                return 5;
            }
            return (m.q0(upperCase, "REAL", false) || m.q0(upperCase, "FLOA", false) || m.q0(upperCase, "DOUB", false)) ? 4 : 1;
        }

        public boolean equals(Object obj) {
            String str;
            String str2;
            String str3;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Column) || this.primaryKeyPosition != ((Column) obj).primaryKeyPosition) {
                return false;
            }
            Column column = (Column) obj;
            if (!k.a(this.name, column.name) || this.notNull != column.notNull) {
                return false;
            }
            if (this.createdFrom == 1 && column.createdFrom == 2 && (str3 = this.defaultValue) != null && !Companion.defaultValueEquals(str3, column.defaultValue)) {
                return false;
            }
            if (this.createdFrom == 2 && column.createdFrom == 1 && (str2 = column.defaultValue) != null && !Companion.defaultValueEquals(str2, this.defaultValue)) {
                return false;
            }
            int i2 = this.createdFrom;
            return (i2 == 0 || i2 != column.createdFrom || ((str = this.defaultValue) == null ? column.defaultValue == null : Companion.defaultValueEquals(str, column.defaultValue))) && this.affinity == column.affinity;
        }

        public int hashCode() {
            return (((((this.name.hashCode() * 31) + this.affinity) * 31) + (this.notNull ? 1231 : 1237)) * 31) + this.primaryKeyPosition;
        }

        public final boolean isPrimaryKey() {
            return this.primaryKeyPosition > 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Column{name='");
            sb.append(this.name);
            sb.append("', type='");
            sb.append(this.type);
            sb.append("', affinity='");
            sb.append(this.affinity);
            sb.append("', notNull=");
            sb.append(this.notNull);
            sb.append(", primaryKeyPosition=");
            sb.append(this.primaryKeyPosition);
            sb.append(", defaultValue='");
            String str = this.defaultValue;
            if (str == null) {
                str = AdError.UNDEFINED_DOMAIN;
            }
            return a1.a.r(sb, str, "'}");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Column(String name, String type, boolean z2, int i2) {
            this(name, type, z2, i2, null, 0);
            k.e(name, "name");
            k.e(type, "type");
        }

        @ColumnInfo.SQLiteTypeAffinity
        public static /* synthetic */ void getAffinity$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final class Index {
        public static final Companion Companion = new Companion(null);
        public static final String DEFAULT_PREFIX = "index_";
        public final List<String> columns;
        public final String name;
        public List<String> orders;
        public final boolean unique;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(f fVar) {
                this();
            }

            private Companion() {
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, java.util.Collection, java.util.List<java.lang.String>] */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.util.List<java.lang.String>] */
        /* JADX WARN: Type inference failed for: r5v2, types: [java.util.ArrayList] */
        public Index(String name, boolean z2, List<String> columns, List<String> orders) {
            k.e(name, "name");
            k.e(columns, "columns");
            k.e(orders, "orders");
            this.name = name;
            this.unique = z2;
            this.columns = columns;
            this.orders = orders;
            if (orders.isEmpty()) {
                int size = columns.size();
                orders = new ArrayList<>(size);
                for (int i2 = 0; i2 < size; i2++) {
                    orders.add(Index.Order.ASC.name());
                }
            }
            this.orders = orders;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Index) {
                Index index = (Index) obj;
                if (this.unique == index.unique && k.a(this.columns, index.columns) && k.a(this.orders, index.orders)) {
                    return n6.t.n0(this.name, DEFAULT_PREFIX, false) ? n6.t.n0(index.name, DEFAULT_PREFIX, false) : k.a(this.name, index.name);
                }
            }
            return false;
        }

        public int hashCode() {
            return this.orders.hashCode() + ((this.columns.hashCode() + ((((n6.t.n0(this.name, DEFAULT_PREFIX, false) ? -1184239155 : this.name.hashCode()) * 31) + (this.unique ? 1 : 0)) * 31)) * 31);
        }

        public String toString() {
            return "Index{name='" + this.name + "', unique=" + this.unique + ", columns=" + this.columns + ", orders=" + this.orders + "'}";
        }

        public Index(String name, boolean z2, List<String> columns) {
            k.e(name, "name");
            k.e(columns, "columns");
            int size = columns.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(Index.Order.ASC.name());
            }
            this(name, z2, columns, arrayList);
        }
    }
}
