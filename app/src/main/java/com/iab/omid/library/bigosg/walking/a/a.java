package com.iab.omid.library.bigosg.walking.a;

import com.iab.omid.library.bigosg.walking.a.b;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final HashSet<String> f5831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final JSONObject f5832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final long f5833c;

    public a(b.InterfaceC0147b interfaceC0147b, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(interfaceC0147b);
        this.f5831a = new HashSet<>(hashSet);
        this.f5832b = jSONObject;
        this.f5833c = j;
    }
}
