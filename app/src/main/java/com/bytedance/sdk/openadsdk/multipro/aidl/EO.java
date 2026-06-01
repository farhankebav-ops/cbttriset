package com.bytedance.sdk.openadsdk.multipro.aidl;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO implements Cursor {
    int EO = 0;
    Map<String, List<String>> IlO;
    String[] MY;

    public EO(Map<String, List<String>> map) {
        if (map == null || map.keySet() == null) {
            this.IlO = new HashMap();
            return;
        }
        this.IlO = map;
        try {
            this.MY = (String[]) map.keySet().toArray(new String[map.keySet().size()]);
        } catch (Exception unused) {
        }
    }

    @Override // android.database.Cursor
    public byte[] getBlob(int i2) {
        return new byte[0];
    }

    @Override // android.database.Cursor
    public int getColumnCount() {
        String[] strArr = this.MY;
        if (strArr != null) {
            return strArr.length;
        }
        return 0;
    }

    @Override // android.database.Cursor
    public int getColumnIndex(String str) {
        String[] strArr = this.MY;
        if (strArr == null || strArr.length == 0) {
            return -1;
        }
        int i2 = 0;
        while (true) {
            String[] strArr2 = this.MY;
            if (i2 >= strArr2.length) {
                return 0;
            }
            if (str.equals(strArr2[i2])) {
                return i2;
            }
            i2++;
        }
    }

    @Override // android.database.Cursor
    public int getColumnIndexOrThrow(String str) throws IllegalArgumentException {
        return 0;
    }

    @Override // android.database.Cursor
    public String getColumnName(int i2) {
        if (i2 < 0) {
            return "";
        }
        String[] strArr = this.MY;
        return i2 < strArr.length ? strArr[i2] : "";
    }

    @Override // android.database.Cursor
    public String[] getColumnNames() {
        return this.MY;
    }

    @Override // android.database.Cursor
    public int getCount() {
        try {
            String[] strArr = this.MY;
            if (strArr != null && strArr.length != 0) {
                return this.IlO.get(strArr[0]).size();
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // android.database.Cursor
    public double getDouble(int i2) {
        try {
            return Double.parseDouble(getString(i2));
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    @Override // android.database.Cursor
    public Bundle getExtras() {
        return null;
    }

    @Override // android.database.Cursor
    public float getFloat(int i2) {
        try {
            return Float.parseFloat(getString(i2));
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    @Override // android.database.Cursor
    public int getInt(int i2) {
        try {
            return Integer.parseInt(getString(i2));
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // android.database.Cursor
    public long getLong(int i2) {
        try {
            return Long.parseLong(getString(i2));
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // android.database.Cursor
    public Uri getNotificationUri() {
        return null;
    }

    @Override // android.database.Cursor
    public int getPosition() {
        return this.EO;
    }

    @Override // android.database.Cursor
    public short getShort(int i2) {
        try {
            return Short.parseShort(getString(i2));
        } catch (Exception unused) {
            return (short) 0;
        }
    }

    @Override // android.database.Cursor
    public String getString(int i2) {
        return (i2 < 0 || i2 >= getColumnCount()) ? "" : this.IlO.get(this.MY[i2]).get(getPosition());
    }

    @Override // android.database.Cursor
    public int getType(int i2) {
        return 0;
    }

    @Override // android.database.Cursor
    public boolean getWantsAllOnMoveCalls() {
        return false;
    }

    @Override // android.database.Cursor
    public boolean isAfterLast() {
        return false;
    }

    @Override // android.database.Cursor
    public boolean isBeforeFirst() {
        return false;
    }

    @Override // android.database.Cursor
    public boolean isClosed() {
        return false;
    }

    @Override // android.database.Cursor
    public boolean isFirst() {
        return this.EO == 0;
    }

    @Override // android.database.Cursor
    public boolean isLast() {
        return this.EO == getCount() - 1;
    }

    @Override // android.database.Cursor
    public boolean isNull(int i2) {
        return getString(i2) == null;
    }

    @Override // android.database.Cursor
    public boolean move(int i2) {
        if (this.EO + i2 >= getCount()) {
            return false;
        }
        this.EO += i2;
        return true;
    }

    @Override // android.database.Cursor
    public boolean moveToFirst() {
        if (getCount() <= 0) {
            return false;
        }
        this.EO = 0;
        return true;
    }

    @Override // android.database.Cursor
    public boolean moveToLast() {
        if (getCount() <= 0) {
            return false;
        }
        this.EO = this.IlO.get(this.MY[0]).size() - 1;
        return true;
    }

    @Override // android.database.Cursor
    public boolean moveToNext() {
        if (this.EO + 1 >= getCount()) {
            return false;
        }
        this.EO++;
        return true;
    }

    @Override // android.database.Cursor
    public boolean moveToPosition(int i2) {
        if (i2 >= getCount()) {
            return false;
        }
        this.EO = i2;
        return true;
    }

    @Override // android.database.Cursor
    public boolean moveToPrevious() {
        int i2 = this.EO;
        if (i2 - 1 < 0) {
            return false;
        }
        this.EO = i2 - 1;
        return true;
    }

    @Override // android.database.Cursor
    public boolean requery() {
        return false;
    }

    @Override // android.database.Cursor
    public Bundle respond(Bundle bundle) {
        return null;
    }

    @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // android.database.Cursor
    public void deactivate() {
    }

    @Override // android.database.Cursor
    public void registerContentObserver(ContentObserver contentObserver) {
    }

    @Override // android.database.Cursor
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
    }

    @Override // android.database.Cursor
    public void setExtras(Bundle bundle) {
    }

    @Override // android.database.Cursor
    public void unregisterContentObserver(ContentObserver contentObserver) {
    }

    @Override // android.database.Cursor
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
    }

    @Override // android.database.Cursor
    public void copyStringToBuffer(int i2, CharArrayBuffer charArrayBuffer) {
    }

    @Override // android.database.Cursor
    public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
    }
}
