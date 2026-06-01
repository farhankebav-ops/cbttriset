package w0;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class f implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f17665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p0.k f17666b;

    public /* synthetic */ f(long j, p0.k kVar) {
        this.f17665a = j;
        this.f17666b = kVar;
    }

    @Override // w0.g
    public final Object apply(Object obj) {
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(this.f17665a));
        p0.k kVar = this.f17666b;
        String str = kVar.f13292a;
        m0.e eVar = kVar.f13294c;
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{str, String.valueOf(z0.a.a(eVar))}) < 1) {
            contentValues.put("backend_name", str);
            contentValues.put(HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, Integer.valueOf(z0.a.a(eVar)));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }
}
