package com.iab.omid.library.ironsrc.walking.async;

import com.iab.omid.library.ironsrc.walking.async.b;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final HashSet<String> f6045c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final JSONObject f6046d;
    protected final long e;

    public a(b.InterfaceC0155b interfaceC0155b, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(interfaceC0155b);
        this.f6045c = new HashSet<>(hashSet);
        this.f6046d = jSONObject;
        this.e = j;
    }
}
