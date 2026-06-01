package w0;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import p0.s;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class i implements d, x0.c, c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final m0.c f17669f = new m0.c("proto");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f17670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y0.a f17671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y0.a f17672c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f17673d;
    public final p5.a e;

    public i(y0.a aVar, y0.a aVar2, a aVar3, k kVar, p5.a aVar4) {
        this.f17670a = kVar;
        this.f17671b = aVar;
        this.f17672c = aVar2;
        this.f17673d = aVar3;
        this.e = aVar4;
    }

    public static Long b(SQLiteDatabase sQLiteDatabase, s sVar) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        p0.k kVar = (p0.k) sVar;
        ArrayList arrayList = new ArrayList(Arrays.asList(kVar.f13292a, String.valueOf(z0.a.a(kVar.f13294c))));
        byte[] bArr = kVar.f13293b;
        if (bArr != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(bArr, 0));
        } else {
            sb.append(" and extras is null");
        }
        Cursor cursorQuery = sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null);
        try {
            return !cursorQuery.moveToNext() ? null : Long.valueOf(cursorQuery.getLong(0));
        } finally {
            cursorQuery.close();
        }
    }

    public static String k(Iterable iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(((b) it.next()).f17660a);
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    public static Object l(Cursor cursor, g gVar) {
        try {
            return gVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    public final SQLiteDatabase a() {
        k kVar = this.f17670a;
        Objects.requireNonNull(kVar);
        y0.a aVar = this.f17672c;
        long time = aVar.getTime();
        while (true) {
            try {
                return kVar.getWritableDatabase();
            } catch (SQLiteDatabaseLockedException e) {
                if (aVar.getTime() >= ((long) this.f17673d.f17658c) + time) {
                    throw new x0.a("Timed out while trying to open db.", e);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f17670a.close();
    }

    public final Object e(g gVar) {
        SQLiteDatabase sQLiteDatabaseA = a();
        sQLiteDatabaseA.beginTransaction();
        try {
            Object objApply = gVar.apply(sQLiteDatabaseA);
            sQLiteDatabaseA.setTransactionSuccessful();
            return objApply;
        } finally {
            sQLiteDatabaseA.endTransaction();
        }
    }

    public final ArrayList g(SQLiteDatabase sQLiteDatabase, p0.k kVar, int i2) {
        ArrayList arrayList = new ArrayList();
        Long lB = b(sQLiteDatabase, kVar);
        if (lB == null) {
            return arrayList;
        }
        l(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline", "product_id", "pseudonymous_id", "experiment_ids_clear_blob", "experiment_ids_encrypted_blob"}, "context_id = ?", new String[]{lB.toString()}, null, null, null, String.valueOf(i2)), new androidx.camera.core.processing.h(this, arrayList, kVar, 10));
        return arrayList;
    }

    public final void i(long j, s0.c cVar, String str) {
        e(new androidx.camera.core.impl.utils.futures.a(str, cVar, j));
    }

    public final Object j(x0.b bVar) {
        SQLiteDatabase sQLiteDatabaseA = a();
        y0.a aVar = this.f17672c;
        long time = aVar.getTime();
        while (true) {
            try {
                sQLiteDatabaseA.beginTransaction();
                try {
                    Object objExecute = bVar.execute();
                    sQLiteDatabaseA.setTransactionSuccessful();
                    return objExecute;
                } finally {
                    sQLiteDatabaseA.endTransaction();
                }
            } catch (SQLiteDatabaseLockedException e) {
                if (aVar.getTime() >= ((long) this.f17673d.f17658c) + time) {
                    throw new x0.a("Timed out while trying to acquire the lock.", e);
                }
                SystemClock.sleep(50L);
            }
        }
    }
}
