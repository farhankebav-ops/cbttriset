package androidx.room.util;

import android.database.Cursor;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.ironsource.G5;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import kotlin.jvm.internal.k;
import n7.b;
import r2.q;
import r5.j;
import r5.l;
import r5.s;
import s5.c;
import s5.f;
import s5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class TableInfoKt {
    private static final Map<String, TableInfo.Column> readColumns(SupportSQLiteDatabase supportSQLiteDatabase, String str) throws IOException {
        Cursor cursorQuery = supportSQLiteDatabase.query("PRAGMA table_info(`" + str + "`)");
        try {
            if (cursorQuery.getColumnCount() <= 0) {
                s sVar = s.f13639a;
                cursorQuery.close();
                return sVar;
            }
            int columnIndex = cursorQuery.getColumnIndex("name");
            int columnIndex2 = cursorQuery.getColumnIndex("type");
            int columnIndex3 = cursorQuery.getColumnIndex("notnull");
            int columnIndex4 = cursorQuery.getColumnIndex("pk");
            int columnIndex5 = cursorQuery.getColumnIndex("dflt_value");
            f fVar = new f();
            while (cursorQuery.moveToNext()) {
                String name = cursorQuery.getString(columnIndex);
                String type = cursorQuery.getString(columnIndex2);
                boolean z2 = cursorQuery.getInt(columnIndex3) != 0;
                int i2 = cursorQuery.getInt(columnIndex4);
                String string = cursorQuery.getString(columnIndex5);
                k.d(name, "name");
                k.d(type, "type");
                fVar.put(name, new TableInfo.Column(name, type, z2, i2, string, 2));
            }
            f fVarB = fVar.b();
            cursorQuery.close();
            return fVarB;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                q.I(cursorQuery, th);
                throw th2;
            }
        }
    }

    private static final List<TableInfo.ForeignKeyWithSequence> readForeignKeyFieldMappings(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex("from");
        int columnIndex4 = cursor.getColumnIndex(TypedValues.TransitionType.S_TO);
        c cVarN = q.N();
        while (cursor.moveToNext()) {
            int i2 = cursor.getInt(columnIndex);
            int i8 = cursor.getInt(columnIndex2);
            String string = cursor.getString(columnIndex3);
            k.d(string, "cursor.getString(fromColumnIndex)");
            String string2 = cursor.getString(columnIndex4);
            k.d(string2, "cursor.getString(toColumnIndex)");
            cVarN.add(new TableInfo.ForeignKeyWithSequence(i2, i8, string, string2));
        }
        c cVarO = q.o(cVarN);
        k.e(cVarO, "<this>");
        if (cVarO.a() <= 1) {
            return l.n1(cVarO);
        }
        Object[] array = cVarO.toArray(new Comparable[0]);
        Comparable[] comparableArr = (Comparable[]) array;
        if (comparableArr.length > 1) {
            Arrays.sort(comparableArr);
        }
        return j.X(array);
    }

    private static final Set<TableInfo.ForeignKey> readForeignKeys(SupportSQLiteDatabase supportSQLiteDatabase, String str) throws IOException {
        Cursor cursorQuery = supportSQLiteDatabase.query("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            int columnIndex = cursorQuery.getColumnIndex("id");
            int columnIndex2 = cursorQuery.getColumnIndex("seq");
            int columnIndex3 = cursorQuery.getColumnIndex(G5.Q);
            int columnIndex4 = cursorQuery.getColumnIndex("on_delete");
            int columnIndex5 = cursorQuery.getColumnIndex("on_update");
            List<TableInfo.ForeignKeyWithSequence> foreignKeyFieldMappings = readForeignKeyFieldMappings(cursorQuery);
            cursorQuery.moveToPosition(-1);
            i iVar = new i();
            while (cursorQuery.moveToNext()) {
                if (cursorQuery.getInt(columnIndex2) == 0) {
                    int i2 = cursorQuery.getInt(columnIndex);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj : foreignKeyFieldMappings) {
                        if (((TableInfo.ForeignKeyWithSequence) obj).getId() == i2) {
                            arrayList3.add(obj);
                        }
                    }
                    int size = arrayList3.size();
                    int i8 = 0;
                    while (i8 < size) {
                        Object obj2 = arrayList3.get(i8);
                        i8++;
                        TableInfo.ForeignKeyWithSequence foreignKeyWithSequence = (TableInfo.ForeignKeyWithSequence) obj2;
                        arrayList.add(foreignKeyWithSequence.getFrom());
                        arrayList2.add(foreignKeyWithSequence.getTo());
                    }
                    String string = cursorQuery.getString(columnIndex3);
                    k.d(string, "cursor.getString(tableColumnIndex)");
                    String string2 = cursorQuery.getString(columnIndex4);
                    k.d(string2, "cursor.getString(onDeleteColumnIndex)");
                    String string3 = cursorQuery.getString(columnIndex5);
                    k.d(string3, "cursor.getString(onUpdateColumnIndex)");
                    iVar.add(new TableInfo.ForeignKey(string, string2, string3, arrayList, arrayList2));
                }
            }
            i iVarF = b.f(iVar);
            cursorQuery.close();
            return iVarF;
        } finally {
        }
    }

    private static final TableInfo.Index readIndex(SupportSQLiteDatabase supportSQLiteDatabase, String str, boolean z2) throws IOException {
        Cursor cursorQuery = supportSQLiteDatabase.query("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndex = cursorQuery.getColumnIndex("seqno");
            int columnIndex2 = cursorQuery.getColumnIndex("cid");
            int columnIndex3 = cursorQuery.getColumnIndex("name");
            int columnIndex4 = cursorQuery.getColumnIndex("desc");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex4 != -1) {
                TreeMap treeMap = new TreeMap();
                TreeMap treeMap2 = new TreeMap();
                while (cursorQuery.moveToNext()) {
                    if (cursorQuery.getInt(columnIndex2) >= 0) {
                        int i2 = cursorQuery.getInt(columnIndex);
                        String columnName = cursorQuery.getString(columnIndex3);
                        String str2 = cursorQuery.getInt(columnIndex4) > 0 ? "DESC" : "ASC";
                        Integer numValueOf = Integer.valueOf(i2);
                        k.d(columnName, "columnName");
                        treeMap.put(numValueOf, columnName);
                        treeMap2.put(Integer.valueOf(i2), str2);
                    }
                }
                Collection collectionValues = treeMap.values();
                k.d(collectionValues, "columnsMap.values");
                List listN1 = l.n1(collectionValues);
                Collection collectionValues2 = treeMap2.values();
                k.d(collectionValues2, "ordersMap.values");
                TableInfo.Index index = new TableInfo.Index(str, z2, listN1, l.n1(collectionValues2));
                q.I(cursorQuery, null);
                return index;
            }
            q.I(cursorQuery, null);
            return null;
        } finally {
        }
    }

    private static final Set<TableInfo.Index> readIndices(SupportSQLiteDatabase supportSQLiteDatabase, String str) throws IOException {
        Cursor cursorQuery = supportSQLiteDatabase.query("PRAGMA index_list(`" + str + "`)");
        try {
            int columnIndex = cursorQuery.getColumnIndex("name");
            int columnIndex2 = cursorQuery.getColumnIndex("origin");
            int columnIndex3 = cursorQuery.getColumnIndex("unique");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                i iVar = new i();
                while (cursorQuery.moveToNext()) {
                    if ("c".equals(cursorQuery.getString(columnIndex2))) {
                        String name = cursorQuery.getString(columnIndex);
                        boolean z2 = true;
                        if (cursorQuery.getInt(columnIndex3) != 1) {
                            z2 = false;
                        }
                        k.d(name, "name");
                        TableInfo.Index index = readIndex(supportSQLiteDatabase, name, z2);
                        if (index == null) {
                            cursorQuery.close();
                            return null;
                        }
                        iVar.add(index);
                    }
                }
                i iVarF = b.f(iVar);
                cursorQuery.close();
                return iVarF;
            }
            cursorQuery.close();
            return null;
        } finally {
        }
    }

    public static final TableInfo readTableInfo(SupportSQLiteDatabase database, String tableName) {
        k.e(database, "database");
        k.e(tableName, "tableName");
        return new TableInfo(tableName, readColumns(database, tableName), readForeignKeys(database, tableName), readIndices(database, tableName));
    }
}
