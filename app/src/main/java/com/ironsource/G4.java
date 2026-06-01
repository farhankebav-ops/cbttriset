package com.ironsource;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class G4 extends SQLiteOpenHelper implements H7 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static G4 f6791f = null;
    private static final String g = " TEXT";
    private static final String h = " INTEGER";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f6792i = ",";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final H4 f6793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f6794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f6795c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f6796d;
    private final String e;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class a implements BaseColumns {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f6797a = "events";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f6798b = 4;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f6799c = "eventid";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String f6800d = "timestamp";
        public static final String e = "type";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final String f6801f = "data";
    }

    public G4(Context context, String str, int i2) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i2);
        this.f6793a = new H4();
        this.f6794b = 4;
        this.f6795c = 400;
        this.f6796d = "DROP TABLE IF EXISTS events";
        this.e = "CREATE TABLE events (_id INTEGER PRIMARY KEY,eventid INTEGER,timestamp INTEGER,type TEXT,data TEXT )";
    }

    public static synchronized G4 a(Context context, String str, int i2) {
        try {
            if (f6791f == null) {
                f6791f = new G4(context, str, i2);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f6791f;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034 A[Catch: all -> 0x0018, DONT_GENERATE, PHI: r1
  0x0034: PHI (r1v3 android.database.sqlite.SQLiteDatabase) = (r1v2 android.database.sqlite.SQLiteDatabase), (r1v4 android.database.sqlite.SQLiteDatabase) binds: [B:19:0x0032, B:8:0x0015] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0011, B:20:0x0034, B:18:0x002e, B:25:0x003c, B:27:0x0042, B:28:0x0045, B:16:0x001e), top: B:31:0x0001, inners: #1 }] */
    @Override // com.ironsource.H7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void b(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.String r0 = "type = ?"
            java.lang.String[] r4 = new java.lang.String[]{r4}     // Catch: java.lang.Throwable -> L18
            r1 = 1
            android.database.sqlite.SQLiteDatabase r1 = r3.a(r1)     // Catch: java.lang.Throwable -> L1c
            java.lang.String r2 = "events"
            r1.delete(r2, r0, r4)     // Catch: java.lang.Throwable -> L1a
            boolean r4 = r1.isOpen()     // Catch: java.lang.Throwable -> L18
            if (r4 == 0) goto L37
            goto L34
        L18:
            r4 = move-exception
            goto L46
        L1a:
            r4 = move-exception
            goto L1e
        L1c:
            r4 = move-exception
            r1 = 0
        L1e:
            com.ironsource.r4 r0 = com.ironsource.C2531r4.d()     // Catch: java.lang.Throwable -> L39
            r0.a(r4)     // Catch: java.lang.Throwable -> L39
            java.lang.String r0 = "IronSource"
            java.lang.String r2 = "Exception while clearing events: "
            android.util.Log.e(r0, r2, r4)     // Catch: java.lang.Throwable -> L39
            if (r1 == 0) goto L37
            boolean r4 = r1.isOpen()     // Catch: java.lang.Throwable -> L18
            if (r4 == 0) goto L37
        L34:
            r1.close()     // Catch: java.lang.Throwable -> L18
        L37:
            monitor-exit(r3)
            return
        L39:
            r4 = move-exception
            if (r1 == 0) goto L45
            boolean r0 = r1.isOpen()     // Catch: java.lang.Throwable -> L18
            if (r0 == 0) goto L45
            r1.close()     // Catch: java.lang.Throwable -> L18
        L45:
            throw r4     // Catch: java.lang.Throwable -> L18
        L46:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L18
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.G4.b(java.lang.String):void");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY,eventid INTEGER,timestamp INTEGER,type TEXT,data TEXT )");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i8) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS events");
        onCreate(sQLiteDatabase);
    }

    @Override // com.ironsource.H7
    public synchronized void a(List<C5> list, String str) {
        SQLiteDatabase sQLiteDatabaseA;
        if (list != null) {
            if (!list.isEmpty()) {
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    sQLiteDatabaseA = a(true);
                    try {
                        Iterator<C5> it = list.iterator();
                        while (it.hasNext()) {
                            ContentValues contentValuesA = a(it.next(), str);
                            if (sQLiteDatabaseA != null && contentValuesA != null) {
                                sQLiteDatabaseA.insert("events", null, contentValuesA);
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        sQLiteDatabase = sQLiteDatabaseA;
                        try {
                            C2531r4.d().a(th);
                            Log.e("IronSource", "Exception while saving events: ", th);
                            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                                sQLiteDatabaseA = sQLiteDatabase;
                            }
                        } catch (Throwable th2) {
                            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                                sQLiteDatabase.close();
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
                if (sQLiteDatabaseA != null && sQLiteDatabaseA.isOpen()) {
                    sQLiteDatabaseA.close();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x009d A[Catch: all -> 0x006f, PHI: r3
  0x009d: PHI (r3v2 android.database.sqlite.SQLiteDatabase) = (r3v1 android.database.sqlite.SQLiteDatabase), (r3v3 android.database.sqlite.SQLiteDatabase) binds: [B:41:0x009b, B:30:0x0076] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #3 {all -> 0x006f, blocks: (B:3:0x0001, B:24:0x0065, B:26:0x006b, B:29:0x0072, B:42:0x009d, B:36:0x008c, B:38:0x0092, B:40:0x0097, B:48:0x00a6, B:50:0x00ac, B:52:0x00b1, B:54:0x00b7, B:55:0x00ba, B:34:0x007c), top: B:64:0x0001, inners: #0 }] */
    @Override // com.ironsource.H7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.util.ArrayList<com.ironsource.C5> a(java.lang.String r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L6f
            r1.<init>()     // Catch: java.lang.Throwable -> L6f
            r0 = 0
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r11.a(r0)     // Catch: java.lang.Throwable -> L79
            java.lang.String r6 = "type = ?"
            java.lang.String[] r7 = new java.lang.String[]{r12}     // Catch: java.lang.Throwable -> L5f
            java.lang.String r10 = "timestamp ASC"
            java.lang.String r4 = "events"
            r8 = 0
            r9 = 0
            r5 = 0
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L5f
            int r12 = r2.getCount()     // Catch: java.lang.Throwable -> L5f
            if (r12 <= 0) goto L65
            r2.moveToFirst()     // Catch: java.lang.Throwable -> L5f
        L26:
            boolean r12 = r2.isAfterLast()     // Catch: java.lang.Throwable -> L5f
            if (r12 != 0) goto L62
            java.lang.String r12 = "eventid"
            int r12 = r2.getColumnIndex(r12)     // Catch: java.lang.Throwable -> L5f
            if (r12 >= 0) goto L35
            goto L26
        L35:
            int r12 = r2.getInt(r12)     // Catch: java.lang.Throwable -> L5f
            java.lang.String r0 = "timestamp"
            int r0 = r2.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L5f
            if (r0 >= 0) goto L42
            goto L26
        L42:
            long r4 = r2.getLong(r0)     // Catch: java.lang.Throwable -> L5f
            java.lang.String r0 = "data"
            int r0 = r2.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L5f
            if (r0 >= 0) goto L4f
            goto L26
        L4f:
            java.lang.String r0 = r2.getString(r0)     // Catch: java.lang.Throwable -> L5f
            com.ironsource.C5 r6 = new com.ironsource.C5     // Catch: java.lang.Throwable -> L5f
            r6.<init>(r12, r4, r0)     // Catch: java.lang.Throwable -> L5f
            r1.add(r6)     // Catch: java.lang.Throwable -> L5f
            r2.moveToNext()     // Catch: java.lang.Throwable -> L5f
            goto L26
        L5f:
            r0 = move-exception
            r12 = r0
            goto L7c
        L62:
            r2.close()     // Catch: java.lang.Throwable -> L5f
        L65:
            boolean r12 = r2.isClosed()     // Catch: java.lang.Throwable -> L6f
            if (r12 != 0) goto L72
            r2.close()     // Catch: java.lang.Throwable -> L6f
            goto L72
        L6f:
            r0 = move-exception
            r12 = r0
            goto Lbb
        L72:
            boolean r12 = r3.isOpen()     // Catch: java.lang.Throwable -> L6f
            if (r12 == 0) goto La0
            goto L9d
        L79:
            r0 = move-exception
            r12 = r0
            r3 = r2
        L7c:
            com.ironsource.r4 r0 = com.ironsource.C2531r4.d()     // Catch: java.lang.Throwable -> La2
            r0.a(r12)     // Catch: java.lang.Throwable -> La2
            java.lang.String r0 = "IronSource"
            java.lang.String r4 = "Exception while loading events: "
            android.util.Log.e(r0, r4, r12)     // Catch: java.lang.Throwable -> La2
            if (r2 == 0) goto L95
            boolean r12 = r2.isClosed()     // Catch: java.lang.Throwable -> L6f
            if (r12 != 0) goto L95
            r2.close()     // Catch: java.lang.Throwable -> L6f
        L95:
            if (r3 == 0) goto La0
            boolean r12 = r3.isOpen()     // Catch: java.lang.Throwable -> L6f
            if (r12 == 0) goto La0
        L9d:
            r3.close()     // Catch: java.lang.Throwable -> L6f
        La0:
            monitor-exit(r11)
            return r1
        La2:
            r0 = move-exception
            r12 = r0
            if (r2 == 0) goto Laf
            boolean r0 = r2.isClosed()     // Catch: java.lang.Throwable -> L6f
            if (r0 != 0) goto Laf
            r2.close()     // Catch: java.lang.Throwable -> L6f
        Laf:
            if (r3 == 0) goto Lba
            boolean r0 = r3.isOpen()     // Catch: java.lang.Throwable -> L6f
            if (r0 == 0) goto Lba
            r3.close()     // Catch: java.lang.Throwable -> L6f
        Lba:
            throw r12     // Catch: java.lang.Throwable -> L6f
        Lbb:
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L6f
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.G4.a(java.lang.String):java.util.ArrayList");
    }

    private ContentValues a(C5 c52, String str) {
        if (c52 == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues(4);
        contentValues.put("eventid", Integer.valueOf(c52.c()));
        contentValues.put("timestamp", Long.valueOf(c52.d()));
        contentValues.put("type", str);
        contentValues.put("data", c52.a());
        return contentValues;
    }

    private synchronized SQLiteDatabase a(boolean z2) throws Throwable {
        int i2 = 0;
        while (true) {
            try {
                if (z2) {
                    return this.f6793a.a(true, this);
                }
                return this.f6793a.a(false, this);
            } finally {
            }
        }
    }
}
