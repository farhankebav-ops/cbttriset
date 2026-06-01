package com.iab.omid.library.unity3d.walking.async;

import com.iab.omid.library.unity3d.walking.async.b;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final HashSet<String> f6147c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final JSONObject f6148d;
    protected final long e;

    public a(b.InterfaceC0159b interfaceC0159b, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(interfaceC0159b);
        this.f6147c = new HashSet<>(hashSet);
        this.f6148d = jSONObject;
        this.e = j;
    }
}
