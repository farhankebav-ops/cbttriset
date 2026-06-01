package com.iab.omid.library.vungle.walking;

import androidx.annotation.VisibleForTesting;
import com.iab.omid.library.vungle.walking.async.b;
import com.iab.omid.library.vungle.walking.async.d;
import com.iab.omid.library.vungle.walking.async.e;
import com.iab.omid.library.vungle.walking.async.f;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class b implements b.InterfaceC0163b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f6264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.iab.omid.library.vungle.walking.async.c f6265b;

    public b(com.iab.omid.library.vungle.walking.async.c cVar) {
        this.f6265b = cVar;
    }

    @Override // com.iab.omid.library.vungle.walking.async.b.InterfaceC0163b
    @VisibleForTesting
    public JSONObject a() {
        return this.f6264a;
    }

    public void b() {
        this.f6265b.b(new d(this));
    }

    @Override // com.iab.omid.library.vungle.walking.async.b.InterfaceC0163b
    @VisibleForTesting
    public void a(JSONObject jSONObject) {
        this.f6264a = jSONObject;
    }

    public void b(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.f6265b.b(new f(this, hashSet, jSONObject, j));
    }

    public void a(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.f6265b.b(new e(this, hashSet, jSONObject, j));
    }
}
