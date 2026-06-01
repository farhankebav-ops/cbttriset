package com.iab.omid.library.ironsrc.walking;

import androidx.annotation.VisibleForTesting;
import com.iab.omid.library.ironsrc.walking.async.b;
import com.iab.omid.library.ironsrc.walking.async.d;
import com.iab.omid.library.ironsrc.walking.async.e;
import com.iab.omid.library.ironsrc.walking.async.f;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class b implements b.InterfaceC0155b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f6053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.iab.omid.library.ironsrc.walking.async.c f6054b;

    public b(com.iab.omid.library.ironsrc.walking.async.c cVar) {
        this.f6054b = cVar;
    }

    @Override // com.iab.omid.library.ironsrc.walking.async.b.InterfaceC0155b
    @VisibleForTesting
    public JSONObject a() {
        return this.f6053a;
    }

    public void b() {
        this.f6054b.b(new d(this));
    }

    @Override // com.iab.omid.library.ironsrc.walking.async.b.InterfaceC0155b
    @VisibleForTesting
    public void a(JSONObject jSONObject) {
        this.f6053a = jSONObject;
    }

    public void b(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.f6054b.b(new f(this, hashSet, jSONObject, j));
    }

    public void a(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.f6054b.b(new e(this, hashSet, jSONObject, j));
    }
}
