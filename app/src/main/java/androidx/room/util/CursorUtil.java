package androidx.room.util;

import a1.a;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.MatrixCursor;
import android.os.Build;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import e6.l;
import java.io.IOException;
import kotlin.jvm.internal.k;
import n6.t;
import r5.j;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class CursorUtil {
    public static final Cursor copyAndClose(Cursor c7) throws IOException {
        k.e(c7, "c");
        try {
            MatrixCursor matrixCursor = new MatrixCursor(c7.getColumnNames(), c7.getCount());
            while (c7.moveToNext()) {
                Object[] objArr = new Object[c7.getColumnCount()];
                int columnCount = c7.getColumnCount();
                for (int i2 = 0; i2 < columnCount; i2++) {
                    int type = c7.getType(i2);
                    if (type == 0) {
                        objArr[i2] = null;
                    } else if (type == 1) {
                        objArr[i2] = Long.valueOf(c7.getLong(i2));
                    } else if (type == 2) {
                        objArr[i2] = Double.valueOf(c7.getDouble(i2));
                    } else if (type == 3) {
                        objArr[i2] = c7.getString(i2);
                    } else {
                        if (type != 4) {
                            throw new IllegalStateException();
                        }
                        objArr[i2] = c7.getBlob(i2);
                    }
                }
                matrixCursor.addRow(objArr);
            }
            c7.close();
            return matrixCursor;
        } finally {
        }
    }

    private static final int findColumnIndexBySuffix(Cursor cursor, String str) {
        if (Build.VERSION.SDK_INT > 25 || str.length() == 0) {
            return -1;
        }
        String[] columnNames = cursor.getColumnNames();
        k.d(columnNames, "columnNames");
        return findColumnIndexBySuffix(columnNames, str);
    }

    public static final int getColumnIndex(Cursor c7, String name) {
        k.e(c7, "c");
        k.e(name, "name");
        int columnIndex = c7.getColumnIndex(name);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        int columnIndex2 = c7.getColumnIndex("`" + name + '`');
        return columnIndex2 >= 0 ? columnIndex2 : findColumnIndexBySuffix(c7, name);
    }

    public static final int getColumnIndexOrThrow(Cursor c7, String name) {
        String strR0;
        k.e(c7, "c");
        k.e(name, "name");
        int columnIndex = getColumnIndex(c7, name);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        try {
            String[] columnNames = c7.getColumnNames();
            k.d(columnNames, "c.columnNames");
            strR0 = j.r0(columnNames);
        } catch (Exception e) {
            Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e);
            strR0 = "unknown";
        }
        throw new IllegalArgumentException(a.n("column '", name, "' does not exist. Available columns: ", strR0));
    }

    public static final <R> R useCursor(Cursor cursor, l block) throws IOException {
        k.e(cursor, "<this>");
        k.e(block, "block");
        try {
            R r7 = (R) block.invoke(cursor);
            cursor.close();
            return r7;
        } finally {
        }
    }

    public static final Cursor wrapMappedColumns(Cursor cursor, final String[] columnNames, final int[] mapping) {
        k.e(cursor, "cursor");
        k.e(columnNames, "columnNames");
        k.e(mapping, "mapping");
        if (columnNames.length == mapping.length) {
            return new CursorWrapper(cursor) { // from class: androidx.room.util.CursorUtil.wrapMappedColumns.2
                @Override // android.database.CursorWrapper, android.database.Cursor
                public int getColumnIndex(String columnName) {
                    k.e(columnName, "columnName");
                    String[] strArr = columnNames;
                    int[] iArr = mapping;
                    int length = strArr.length;
                    int i2 = 0;
                    int i8 = 0;
                    while (i2 < length) {
                        int i9 = i8 + 1;
                        if (t.g0(strArr[i2], columnName)) {
                            return iArr[i8];
                        }
                        i2++;
                        i8 = i9;
                    }
                    return super.getColumnIndex(columnName);
                }
            };
        }
        throw new IllegalStateException("Expected columnNames.length == mapping.length");
    }

    @VisibleForTesting(otherwise = 2)
    public static final int findColumnIndexBySuffix(String[] columnNames, String name) {
        k.e(columnNames, "columnNames");
        k.e(name, "name");
        String strConcat = ".".concat(name);
        String strF = androidx.camera.core.processing.util.a.f('`', ".", name);
        int length = columnNames.length;
        int i2 = 0;
        int i8 = 0;
        while (i2 < length) {
            String str = columnNames[i2];
            int i9 = i8 + 1;
            if (str.length() >= name.length() + 2 && (t.f0(str, strConcat, false) || (str.charAt(0) == '`' && t.f0(str, strF, false)))) {
                return i8;
            }
            i2++;
            i8 = i9;
        }
        return -1;
    }
}
