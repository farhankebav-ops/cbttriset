package com.iab.omid.library.vungle.walking.async;

import com.iab.omid.library.vungle.walking.async.b;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final HashSet<String> f6256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final JSONObject f6257d;
    protected final long e;

    public a(b.InterfaceC0163b interfaceC0163b, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(interfaceC0163b);
        this.f6256c = new HashSet<>(hashSet);
        this.f6257d = jSONObject;
        this.e = j;
    }
}
