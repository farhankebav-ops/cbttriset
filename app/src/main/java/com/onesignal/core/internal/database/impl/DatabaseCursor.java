package com.onesignal.core.internal.database.impl;

import android.database.Cursor;
import com.onesignal.core.internal.database.ICursor;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class DatabaseCursor implements ICursor {
    private final Cursor _cursor;

    public DatabaseCursor(Cursor _cursor) {
        k.e(_cursor, "_cursor");
        this._cursor = _cursor;
    }

    @Override // com.onesignal.core.internal.database.ICursor
    public int getCount() {
        return this._cursor.getCount();
    }

    @Override // com.onesignal.core.internal.database.ICursor
    public float getFloat(String column) {
        k.e(column, "column");
        Cursor cursor = this._cursor;
        return cursor.getFloat(cursor.getColumnIndex(column));
    }

    @Override // com.onesignal.core.internal.database.ICursor
    public int getInt(String column) {
        k.e(column, "column");
        Cursor cursor = this._cursor;
        return cursor.getInt(cursor.getColumnIndex(column));
    }

    @Override // com.onesignal.core.internal.database.ICursor
    public long getLong(String column) {
        k.e(column, "column");
        Cursor cursor = this._cursor;
        return cursor.getLong(cursor.getColumnIndex(column));
    }

    @Override // com.onesignal.core.internal.database.ICursor
    public Float getOptFloat(String column) {
        k.e(column, "column");
        int columnIndex = this._cursor.getColumnIndex(column);
        if (this._cursor.isNull(columnIndex)) {
            return null;
        }
        return Float.valueOf(this._cursor.getFloat(columnIndex));
    }

    @Override // com.onesignal.core.internal.database.ICursor
    public Integer getOptInt(String column) {
        k.e(column, "column");
        int columnIndex = this._cursor.getColumnIndex(column);
        if (this._cursor.isNull(columnIndex)) {
            return null;
        }
        return Integer.valueOf(this._cursor.getInt(columnIndex));
    }

    @Override // com.onesignal.core.internal.database.ICursor
    public Long getOptLong(String column) {
        k.e(column, "column");
        int columnIndex = this._cursor.getColumnIndex(column);
        if (this._cursor.isNull(columnIndex)) {
            return null;
        }
        return Long.valueOf(this._cursor.getLong(columnIndex));
    }

    @Override // com.onesignal.core.internal.database.ICursor
    public String getOptString(String column) {
        k.e(column, "column");
        int columnIndex = this._cursor.getColumnIndex(column);
        if (this._cursor.isNull(columnIndex)) {
            return null;
        }
        return this._cursor.getString(columnIndex);
    }

    @Override // com.onesignal.core.internal.database.ICursor
    public String getString(String column) {
        k.e(column, "column");
        Cursor cursor = this._cursor;
        String string = cursor.getString(cursor.getColumnIndex(column));
        k.d(string, "_cursor.getString(_cursor.getColumnIndex(column))");
        return string;
    }

    @Override // com.onesignal.core.internal.database.ICursor
    public boolean moveToFirst() {
        return this._cursor.moveToFirst();
    }

    @Override // com.onesignal.core.internal.database.ICursor
    public boolean moveToNext() {
        return this._cursor.moveToNext();
    }
}
