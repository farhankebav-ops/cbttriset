package com.iab.omid.library.bytedance2.walking;

import androidx.annotation.VisibleForTesting;
import com.iab.omid.library.bytedance2.walking.async.b;
import com.iab.omid.library.bytedance2.walking.async.d;
import com.iab.omid.library.bytedance2.walking.async.e;
import com.iab.omid.library.bytedance2.walking.async.f;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class b implements b.InterfaceC0151b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f5944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.iab.omid.library.bytedance2.walking.async.c f5945b;

    public b(com.iab.omid.library.bytedance2.walking.async.c cVar) {
        this.f5945b = cVar;
    }

    @Override // com.iab.omid.library.bytedance2.walking.async.b.InterfaceC0151b
    @VisibleForTesting
    public JSONObject a() {
        return this.f5944a;
    }

    public void b() {
        this.f5945b.b(new d(this));
    }

    @Override // com.iab.omid.library.bytedance2.walking.async.b.InterfaceC0151b
    @VisibleForTesting
    public void a(JSONObject jSONObject) {
        this.f5944a = jSONObject;
    }

    public void b(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.f5945b.b(new f(this, hashSet, jSONObject, j));
    }

    public void a(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.f5945b.b(new e(this, hashSet, jSONObject, j));
    }
}
