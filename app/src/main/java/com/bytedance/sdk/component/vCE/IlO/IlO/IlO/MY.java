package com.bytedance.sdk.component.vCE.IlO.IlO.IlO;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.sdk.component.vCE.IlO.lEW;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
class MY {
    private C0062MY IlO;
    private Context MY;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class IlO extends AbstractCursor {
        private IlO() {
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String[] getColumnNames() {
            return new String[0];
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getCount() {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public double getDouble(int i2) {
            return 0.0d;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public float getFloat(int i2) {
            return 0.0f;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getInt(int i2) {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public long getLong(int i2) {
            return 0L;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public short getShort(int i2) {
            return (short) 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String getString(int i2) {
            return null;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public boolean isNull(int i2) {
            return true;
        }
    }

    public MY(Context context) {
        try {
            this.MY = context.getApplicationContext();
            if (this.IlO == null) {
                this.IlO = new C0062MY();
            }
        } catch (Throwable unused) {
        }
    }

    public C0062MY IlO() {
        return this.IlO;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.vCE.IlO.IlO.IlO.MY$MY, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class C0062MY {
        private volatile SQLiteDatabase MY = null;

        public C0062MY() {
        }

        private void IlO() {
            boolean zMY;
            try {
                if (this.MY != null && this.MY.isOpen()) {
                    return;
                }
                synchronized (this) {
                    try {
                        if (this.MY == null || !this.MY.isOpen()) {
                            this.MY = lEW.Bc().tV().IlO(lEW.Bc().vCE());
                            this.MY.setLockingEnabled(false);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } finally {
                if (!zMY) {
                }
            }
        }

        private boolean MY() {
            SQLiteDatabase sQLiteDatabase = this.MY;
            return sQLiteDatabase != null && sQLiteDatabase.inTransaction();
        }

        public void IlO(String str) throws SQLException {
            try {
                IlO();
                this.MY.execSQL(str);
            } catch (Throwable th) {
                if (MY()) {
                    throw th;
                }
            }
        }

        public Cursor IlO(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            try {
                IlO();
                return this.MY.query(str, strArr, str2, strArr2, str3, str4, str5);
            } catch (Throwable th) {
                IlO ilO = new IlO();
                if (MY()) {
                    throw th;
                }
                return ilO;
            }
        }

        public int IlO(String str, ContentValues contentValues, String str2, String[] strArr) throws Exception {
            try {
                IlO();
                return this.MY.update(str, contentValues, str2, strArr);
            } catch (Exception e) {
                if (MY()) {
                    throw e;
                }
                return 0;
            }
        }

        public long IlO(String str, String str2, ContentValues contentValues) throws Exception {
            try {
                IlO();
                return this.MY.insert(str, str2, contentValues);
            } catch (Exception e) {
                if (MY()) {
                    throw e;
                }
                return -1L;
            }
        }

        public synchronized void IlO(String str, String str2, List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> list) {
            JSONObject jSONObjectBc;
            try {
                try {
                    IlO();
                    this.MY.beginTransaction();
                    ContentValues contentValues = new ContentValues();
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        com.bytedance.sdk.component.vCE.IlO.tV.IlO ilO = list.get(i2);
                        if (ilO != null && (jSONObjectBc = ilO.Bc()) != null) {
                            contentValues.put("id", ilO.EO());
                            String strMY = lEW.Bc().zPa().MY(jSONObjectBc.toString());
                            if (!TextUtils.isEmpty(strMY)) {
                                contentValues.put("value", strMY);
                                contentValues.put("gen_time", Long.valueOf(System.currentTimeMillis()));
                                contentValues.put("retry", (Integer) 0);
                                contentValues.put("encrypt", (Integer) 1);
                                if (com.bytedance.sdk.component.vCE.IlO.EO.IlO.tV() && ilO.NV() > 0 && (ilO.tV() == 0 || ilO.tV() == 3)) {
                                    contentValues.put("channel", Integer.valueOf(ilO.NV()));
                                }
                                this.MY.insert(str, str2, contentValues);
                            }
                            contentValues.clear();
                        }
                    }
                    this.MY.setTransactionSuccessful();
                    list.size();
                    if (this.MY != null) {
                        this.MY.endTransaction();
                    }
                } catch (Exception e) {
                    list.size();
                    if (!MY()) {
                        if (this.MY != null) {
                            this.MY.endTransaction();
                        }
                    } else {
                        throw e;
                    }
                }
            } catch (Throwable th) {
                if (this.MY != null) {
                    this.MY.endTransaction();
                }
                throw th;
            }
        }

        public int IlO(String str, String str2, String[] strArr) throws Exception {
            try {
                IlO();
                return this.MY.delete(str, str2, strArr);
            } catch (Exception e) {
                if (MY()) {
                    throw e;
                }
                return 0;
            }
        }
    }
}
