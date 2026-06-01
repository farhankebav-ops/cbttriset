package com.iab.omid.library.unity3d.walking;

import androidx.annotation.VisibleForTesting;
import com.iab.omid.library.unity3d.walking.async.b;
import com.iab.omid.library.unity3d.walking.async.d;
import com.iab.omid.library.unity3d.walking.async.e;
import com.iab.omid.library.unity3d.walking.async.f;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class b implements b.InterfaceC0159b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f6155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.iab.omid.library.unity3d.walking.async.c f6156b;

    public b(com.iab.omid.library.unity3d.walking.async.c cVar) {
        this.f6156b = cVar;
    }

    @Override // com.iab.omid.library.unity3d.walking.async.b.InterfaceC0159b
    @VisibleForTesting
    public JSONObject a() {
        return this.f6155a;
    }

    public void b() {
        this.f6156b.b(new d(this));
    }

    @Override // com.iab.omid.library.unity3d.walking.async.b.InterfaceC0159b
    @VisibleForTesting
    public void a(JSONObject jSONObject) {
        this.f6155a = jSONObject;
    }

    public void b(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.f6156b.b(new f(this, hashSet, jSONObject, j));
    }

    public void a(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.f6156b.b(new e(this, hashSet, jSONObject, j));
    }
}
