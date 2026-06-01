package com.iab.omid.library.ironsrc.walking.async;

import android.os.AsyncTask;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b extends AsyncTask<Object, Void, String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f6047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final InterfaceC0155b f6048b;

    public interface a {
        void a(b bVar);
    }

    /* JADX INFO: renamed from: com.iab.omid.library.ironsrc.walking.async.b$b, reason: collision with other inner class name */
    public interface InterfaceC0155b {
        JSONObject a();

        void a(JSONObject jSONObject);
    }

    public b(InterfaceC0155b interfaceC0155b) {
        this.f6048b = interfaceC0155b;
    }

    public void a(a aVar) {
        this.f6047a = aVar;
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        a aVar = this.f6047a;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void a(ThreadPoolExecutor threadPoolExecutor) {
        executeOnExecutor(threadPoolExecutor, new Object[0]);
    }
}
