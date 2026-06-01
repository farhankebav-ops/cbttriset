package com.bytedance.sdk.openadsdk.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE {
    private static final Object EO = new Object();
    private EO IlO;
    private Context MY;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class MY extends AbstractCursor {
        private MY() {
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

    public vCE(Context context) {
        try {
            this.MY = context == null ? cl.IlO() : context.getApplicationContext();
            if (this.IlO == null) {
                this.IlO = new EO();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context EO() {
        Context context = this.MY;
        return context == null ? cl.IlO() : context;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class EO {
        private SQLiteDatabase MY = null;

        public EO() {
        }

        private synchronized void Cc() {
            try {
                synchronized (vCE.EO) {
                    try {
                        SQLiteDatabase sQLiteDatabase = this.MY;
                        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                            vCE vce = vCE.this;
                            SQLiteDatabase writableDatabase = vce.new IlO(vce.EO()).getWritableDatabase();
                            this.MY = writableDatabase;
                            writableDatabase.setLockingEnabled(false);
                        }
                    } finally {
                    }
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.oeT.EO("DBHelper", th.getMessage());
                if (vCE()) {
                    throw th;
                }
            }
        }

        private synchronized boolean vCE() {
            SQLiteDatabase sQLiteDatabase = this.MY;
            if (sQLiteDatabase != null) {
                if (sQLiteDatabase.inTransaction()) {
                    return true;
                }
            }
            return false;
        }

        public synchronized void EO() {
            Cc();
            SQLiteDatabase sQLiteDatabase = this.MY;
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.setTransactionSuccessful();
        }

        public SQLiteDatabase IlO() {
            Cc();
            return this.MY;
        }

        public synchronized void MY() {
            Cc();
            SQLiteDatabase sQLiteDatabase = this.MY;
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.beginTransaction();
        }

        public synchronized void tV() {
            Cc();
            SQLiteDatabase sQLiteDatabase = this.MY;
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.endTransaction();
        }

        public synchronized void IlO(String str) throws SQLException {
            try {
                Cc();
                this.MY.execSQL(str);
            } catch (Throwable th) {
                if (vCE()) {
                    throw th;
                }
            }
        }

        public synchronized Cursor IlO(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            Cursor cursorQuery;
            try {
                Cc();
                cursorQuery = this.MY.query(str, strArr, str2, strArr2, str3, str4, str5);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.oeT.EO("DBHelper", th.getMessage());
                MY my = new MY();
                if (vCE()) {
                    throw th;
                }
                cursorQuery = my;
            }
            return cursorQuery;
        }

        public synchronized int IlO(String str, ContentValues contentValues, String str2, String[] strArr) {
            int iUpdate;
            try {
                Cc();
                iUpdate = this.MY.update(str, contentValues, str2, strArr);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.oeT.EO("DBHelper", e.getMessage());
                if (vCE()) {
                    throw e;
                }
                iUpdate = 0;
            }
            return iUpdate;
        }

        public synchronized long IlO(String str, String str2, ContentValues contentValues) {
            long jReplace;
            try {
                Cc();
                jReplace = this.MY.replace(str, str2, contentValues);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.oeT.EO("DBHelper", e.getMessage());
                if (vCE()) {
                    throw e;
                }
                jReplace = -1;
            }
            return jReplace;
        }

        public synchronized int IlO(String str, String str2, String[] strArr) {
            int iDelete;
            try {
                Cc();
                iDelete = this.MY.delete(str, str2, strArr);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.oeT.EO("DBHelper", e.getMessage());
                if (vCE()) {
                    throw e;
                }
                iDelete = 0;
            }
            return iDelete;
        }
    }

    public EO IlO() {
        return this.IlO;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class IlO extends SQLiteOpenHelper {
        final Context IlO;

        public IlO(Context context) {
            super(context, "ttopensdk.db", (SQLiteDatabase.CursorFactory) null, 11);
            this.IlO = context;
        }

        private void EO(SQLiteDatabase sQLiteDatabase) {
            ArrayList<String> arrayListTV = tV(sQLiteDatabase);
            if (arrayListTV == null || arrayListTV.size() <= 0) {
                return;
            }
            int size = arrayListTV.size();
            int i2 = 0;
            while (i2 < size) {
                String str = arrayListTV.get(i2);
                i2++;
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str + " ;");
            }
        }

        private void IlO(SQLiteDatabase sQLiteDatabase, Context context) {
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.tV.tV.IlO());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.tV.DmF.EO());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.tV.bWL.IlO());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.tV.hp.IlO());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.kBB.MY.IlO());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.tV.zPa.EO());
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.adexpress.IlO.MY.MY.EO());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.core.NV.IlO.EO.EO());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.tV.ea.IlO());
        }

        private void MY(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.core.NV.IlO.EO.tV());
        }

        private ArrayList<String> tV(SQLiteDatabase sQLiteDatabase) {
            ArrayList<String> arrayList = new ArrayList<>();
            Cursor cursorRawQuery = null;
            try {
                cursorRawQuery = sQLiteDatabase.rawQuery("select name from sqlite_master where type='table' order by name", null);
                if (cursorRawQuery != null) {
                    while (cursorRawQuery.moveToNext()) {
                        String string = cursorRawQuery.getString(0);
                        if (!string.equals("android_metadata") && !string.equals("sqlite_sequence")) {
                            arrayList.add(string);
                        }
                    }
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                    return arrayList;
                }
            } catch (Exception unused) {
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            } catch (Throwable th) {
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                throw th;
            }
            return arrayList;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                IlO(sQLiteDatabase, this.IlO);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.oeT.EO("DBHelper", th.getMessage());
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i8) {
            if (i2 > i8) {
                try {
                    EO(sQLiteDatabase);
                    IlO(sQLiteDatabase, vCE.this.MY);
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.oeT.EO(th.getMessage(), new Object[0]);
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x002c A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:3:0x0002, B:4:0x0005, B:5:0x000e, B:7:0x0012, B:8:0x0016, B:9:0x0021, B:10:0x002c, B:11:0x0037, B:12:0x0040), top: B:21:0x0002 }] */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0037 A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:3:0x0002, B:4:0x0005, B:5:0x000e, B:7:0x0012, B:8:0x0016, B:9:0x0021, B:10:0x002c, B:11:0x0037, B:12:0x0040), top: B:21:0x0002 }] */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0040 A[Catch: all -> 0x0043, TRY_LEAVE, TryCatch #0 {all -> 0x0043, blocks: (B:3:0x0002, B:4:0x0005, B:5:0x000e, B:7:0x0012, B:8:0x0016, B:9:0x0021, B:10:0x002c, B:11:0x0037, B:12:0x0040), top: B:21:0x0002 }] */
        /* JADX WARN: Removed duplicated region for block: B:6:0x0011  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0012 A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:3:0x0002, B:4:0x0005, B:5:0x000e, B:7:0x0012, B:8:0x0016, B:9:0x0021, B:10:0x002c, B:11:0x0037, B:12:0x0040), top: B:21:0x0002 }] */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0016 A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:3:0x0002, B:4:0x0005, B:5:0x000e, B:7:0x0012, B:8:0x0016, B:9:0x0021, B:10:0x002c, B:11:0x0037, B:12:0x0040), top: B:21:0x0002 }] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0021 A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:3:0x0002, B:4:0x0005, B:5:0x000e, B:7:0x0012, B:8:0x0016, B:9:0x0021, B:10:0x002c, B:11:0x0037, B:12:0x0040), top: B:21:0x0002 }] */
        @Override // android.database.sqlite.SQLiteOpenHelper
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onUpgrade(android.database.sqlite.SQLiteDatabase r1, int r2, int r3) {
            /*
                r0 = this;
                if (r2 <= r3) goto L5
                r0.EO(r1)     // Catch: java.lang.Throwable -> L43
            L5:
                com.bytedance.sdk.openadsdk.core.vCE r3 = com.bytedance.sdk.openadsdk.core.vCE.this     // Catch: java.lang.Throwable -> L43
                android.content.Context r3 = com.bytedance.sdk.openadsdk.core.vCE.MY(r3)     // Catch: java.lang.Throwable -> L43
                r0.IlO(r1, r3)     // Catch: java.lang.Throwable -> L43
                switch(r2) {
                    case 1: goto L40;
                    case 2: goto L37;
                    case 3: goto L2c;
                    case 4: goto L21;
                    case 5: goto L16;
                    case 6: goto L12;
                    default: goto L11;
                }     // Catch: java.lang.Throwable -> L43
            L11:
                goto L43
            L12:
                r0.IlO(r1)     // Catch: java.lang.Throwable -> L43
                goto L43
            L16:
                java.lang.String r3 = com.bytedance.sdk.openadsdk.tV.hp.IlO()     // Catch: java.lang.Throwable -> L43
                r1.execSQL(r3)     // Catch: java.lang.Throwable -> L43
                r0.IlO(r1)     // Catch: java.lang.Throwable -> L43
                goto L43
            L21:
                java.lang.String r3 = com.bytedance.sdk.component.adexpress.IlO.MY.MY.EO()     // Catch: java.lang.Throwable -> L43
                r1.execSQL(r3)     // Catch: java.lang.Throwable -> L43
                r0.IlO(r1)     // Catch: java.lang.Throwable -> L43
                goto L43
            L2c:
                java.lang.String r3 = com.bytedance.sdk.openadsdk.tV.bWL.IlO()     // Catch: java.lang.Throwable -> L43
                r1.execSQL(r3)     // Catch: java.lang.Throwable -> L43
                r0.IlO(r1)     // Catch: java.lang.Throwable -> L43
                goto L43
            L37:
                java.lang.String r3 = "DROP TABLE IF EXISTS 'ad_video_info';"
                r1.execSQL(r3)     // Catch: java.lang.Throwable -> L43
                r0.IlO(r1)     // Catch: java.lang.Throwable -> L43
                goto L43
            L40:
                r0.IlO(r1)     // Catch: java.lang.Throwable -> L43
            L43:
                r3 = 11
                if (r2 >= r3) goto L58
                r0.MY(r1)     // Catch: java.lang.Throwable -> L4e
                com.bytedance.sdk.openadsdk.kBB.MY.IlO(r1)     // Catch: java.lang.Throwable -> L4e
                goto L58
            L4e:
                r1 = move-exception
                java.lang.String r2 = "DBHelper"
                java.lang.String r1 = r1.getMessage()
                com.bytedance.sdk.component.utils.oeT.EO(r2, r1)
            L58:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.vCE.IlO.onUpgrade(android.database.sqlite.SQLiteDatabase, int, int):void");
        }

        private void IlO(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.tV.tV.MY());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.tV.DmF.tV());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.tV.bWL.MY());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.tV.hp.MY());
        }
    }
}
