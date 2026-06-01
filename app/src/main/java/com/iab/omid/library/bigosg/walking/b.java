package com.iab.omid.library.bigosg.walking;

import androidx.annotation.VisibleForTesting;
import com.iab.omid.library.bigosg.walking.a.b;
import com.iab.omid.library.bigosg.walking.a.d;
import com.iab.omid.library.bigosg.walking.a.e;
import com.iab.omid.library.bigosg.walking.a.f;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class b implements b.InterfaceC0147b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f5840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.iab.omid.library.bigosg.walking.a.c f5841b;

    public b(com.iab.omid.library.bigosg.walking.a.c cVar) {
        this.f5841b = cVar;
    }

    public void a() {
        this.f5841b.b(new d(this));
    }

    @Override // com.iab.omid.library.bigosg.walking.a.b.InterfaceC0147b
    @VisibleForTesting
    public JSONObject b() {
        return this.f5840a;
    }

    @Override // com.iab.omid.library.bigosg.walking.a.b.InterfaceC0147b
    @VisibleForTesting
    public void a(JSONObject jSONObject) {
        this.f5840a = jSONObject;
    }

    public void b(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.f5841b.b(new e(this, hashSet, jSONObject, j));
    }

    public void a(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.f5841b.b(new f(this, hashSet, jSONObject, j));
    }
}
