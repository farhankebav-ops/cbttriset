package androidx.core.database;

import android.database.Cursor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class CursorKt {
    public static final byte[] getBlobOrNull(Cursor cursor, int i2) {
        if (cursor.isNull(i2)) {
            return null;
        }
        return cursor.getBlob(i2);
    }

    public static final Double getDoubleOrNull(Cursor cursor, int i2) {
        if (cursor.isNull(i2)) {
            return null;
        }
        return Double.valueOf(cursor.getDouble(i2));
    }

    public static final Float getFloatOrNull(Cursor cursor, int i2) {
        if (cursor.isNull(i2)) {
            return null;
        }
        return Float.valueOf(cursor.getFloat(i2));
    }

    public static final Integer getIntOrNull(Cursor cursor, int i2) {
        if (cursor.isNull(i2)) {
            return null;
        }
        return Integer.valueOf(cursor.getInt(i2));
    }

    public static final Long getLongOrNull(Cursor cursor, int i2) {
        if (cursor.isNull(i2)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i2));
    }

    public static final Short getShortOrNull(Cursor cursor, int i2) {
        if (cursor.isNull(i2)) {
            return null;
        }
        return Short.valueOf(cursor.getShort(i2));
    }

    public static final String getStringOrNull(Cursor cursor, int i2) {
        if (cursor.isNull(i2)) {
            return null;
        }
        return cursor.getString(i2);
    }
}
