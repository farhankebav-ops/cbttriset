package com.ironsource;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: com.ironsource.lf, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2436lf implements T8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final J3 f8922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, Integer> f8923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<String, Long> f8924c;

    public C2436lf(J3 storage) {
        kotlin.jvm.internal.k.e(storage, "storage");
        this.f8922a = storage;
        this.f8923b = new ConcurrentHashMap<>();
        this.f8924c = new ConcurrentHashMap<>();
    }

    @Override // com.ironsource.T8
    public void a(int i2, String identifier) {
        kotlin.jvm.internal.k.e(identifier, "identifier");
        this.f8923b.put(identifier, Integer.valueOf(i2));
        this.f8922a.a(identifier, i2);
    }

    @Override // com.ironsource.T8
    public Long b(String identifier) {
        kotlin.jvm.internal.k.e(identifier, "identifier");
        Long l = this.f8924c.get(identifier);
        if (l != null) {
            return l;
        }
        Long lA = this.f8922a.a(identifier);
        if (lA == null) {
            return null;
        }
        long jLongValue = lA.longValue();
        this.f8924c.put(identifier, Long.valueOf(jLongValue));
        return Long.valueOf(jLongValue);
    }

    @Override // com.ironsource.T8
    public int a(String identifier) {
        kotlin.jvm.internal.k.e(identifier, "identifier");
        Integer num = this.f8923b.get(identifier);
        if (num != null) {
            return num.intValue();
        }
        Integer numC = this.f8922a.c(identifier);
        if (numC != null) {
            int iIntValue = numC.intValue();
            this.f8923b.put(identifier, Integer.valueOf(iIntValue));
            return iIntValue;
        }
        this.f8923b.put(identifier, 0);
        return 0;
    }

    @Override // com.ironsource.T8
    public void a(long j, String identifier) {
        kotlin.jvm.internal.k.e(identifier, "identifier");
        this.f8924c.put(identifier, Long.valueOf(j));
        this.f8922a.b(identifier, j);
    }
}
