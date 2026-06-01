package com.ironsource;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: com.ironsource.ad, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2237ad implements M7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final J3 f7984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, Long> f7985b;

    public C2237ad(J3 storage) {
        kotlin.jvm.internal.k.e(storage, "storage");
        this.f7984a = storage;
        this.f7985b = new ConcurrentHashMap<>();
    }

    @Override // com.ironsource.M7
    public Long a(String identifier) {
        kotlin.jvm.internal.k.e(identifier, "identifier");
        Long l = this.f7985b.get(identifier);
        if (l != null) {
            return l;
        }
        Long lB = this.f7984a.b(identifier);
        if (lB == null) {
            return null;
        }
        long jLongValue = lB.longValue();
        this.f7985b.put(identifier, Long.valueOf(jLongValue));
        return Long.valueOf(jLongValue);
    }

    @Override // com.ironsource.M7
    public void a(long j, String identifier) {
        kotlin.jvm.internal.k.e(identifier, "identifier");
        this.f7985b.put(identifier, Long.valueOf(j));
        this.f7984a.a(identifier, j);
    }
}
