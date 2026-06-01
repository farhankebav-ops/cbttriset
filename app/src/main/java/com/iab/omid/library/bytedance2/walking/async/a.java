package com.iab.omid.library.bytedance2.walking.async;

import com.iab.omid.library.bytedance2.walking.async.b;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final HashSet<String> f5936c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final JSONObject f5937d;
    protected final long e;

    public a(b.InterfaceC0151b interfaceC0151b, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(interfaceC0151b);
        this.f5936c = new HashSet<>(hashSet);
        this.f5937d = jSONObject;
        this.e = j;
    }
}
