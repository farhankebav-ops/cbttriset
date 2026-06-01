package androidx.camera.core.impl.utils.futures;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import j2.q;
import java.util.HashMap;
import java.util.concurrent.ScheduledExecutorService;
import p0.k;
import w0.g;
import w0.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements CallbackToFutureAdapter.Resolver, Continuation, x0.b, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f3637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3639c;

    public /* synthetic */ a(ConfigFetchHandler configFetchHandler, long j, HashMap map) {
        this.f3638b = configFetchHandler;
        this.f3637a = j;
        this.f3639c = map;
    }

    @Override // w0.g
    public Object apply(Object obj) {
        String str = (String) this.f3638b;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        int i2 = ((s0.c) this.f3639c).f13665a;
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(i2)});
        try {
            boolean z2 = cursorRawQuery.getCount() > 0;
            cursorRawQuery.close();
            long j = this.f3637a;
            if (z2) {
                sQLiteDatabase.execSQL("UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + " + j + " WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(i2)});
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("log_source", str);
            contentValues.put("reason", Integer.valueOf(i2));
            contentValues.put("events_dropped_count", Long.valueOf(j));
            sQLiteDatabase.insert("log_event_dropped", null, contentValues);
            return null;
        } catch (Throwable th) {
            cursorRawQuery.close();
            throw th;
        }
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return Futures.lambda$makeTimeoutFuture$3((q) this.f3638b, (ScheduledExecutorService) this.f3639c, this.f3637a, completer);
    }

    @Override // x0.b
    public Object execute() {
        v0.f fVar = (v0.f) this.f3638b;
        k kVar = (k) this.f3639c;
        w0.d dVar = fVar.f17583c;
        long time = fVar.g.getTime() + this.f3637a;
        i iVar = (i) dVar;
        iVar.getClass();
        iVar.e(new w0.f(time, kVar));
        return null;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        return ((ConfigFetchHandler) this.f3638b).lambda$fetch$0(this.f3637a, (HashMap) this.f3639c, task);
    }

    public /* synthetic */ a(Object obj, Object obj2, long j) {
        this.f3638b = obj;
        this.f3639c = obj2;
        this.f3637a = j;
    }
}
