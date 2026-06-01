package com.ironsource;

import com.ironsource.O;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Q implements O, O.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ReadWriteLock f7400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, N> f7401b;

    public Q() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.ironsource.O
    public N a(String adId) {
        kotlin.jvm.internal.k.e(adId, "adId");
        this.f7400a.readLock().lock();
        try {
            return this.f7401b.get(adId);
        } finally {
            this.f7400a.readLock().unlock();
        }
    }

    public Q(ReadWriteLock readWriteLock) {
        kotlin.jvm.internal.k.e(readWriteLock, "readWriteLock");
        this.f7400a = readWriteLock;
        this.f7401b = new LinkedHashMap();
    }

    @Override // com.ironsource.O
    public List<N> a() {
        this.f7400a.readLock().lock();
        List<N> listN1 = r5.l.n1(this.f7401b.values());
        this.f7400a.readLock().unlock();
        return listN1;
    }

    public /* synthetic */ Q(ReadWriteLock readWriteLock, int i2, kotlin.jvm.internal.f fVar) {
        this((i2 & 1) != 0 ? new ReentrantReadWriteLock() : readWriteLock);
    }

    @Override // com.ironsource.O.a
    public void a(N adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        this.f7400a.writeLock().lock();
        try {
            if (this.f7401b.get(adInfo.c()) == null) {
                this.f7401b.put(adInfo.c(), adInfo);
            }
        } finally {
            this.f7400a.writeLock().unlock();
        }
    }

    @Override // com.ironsource.O.a
    public void a(JSONObject json, EnumC2439m0 adStatus, String adId) {
        kotlin.jvm.internal.k.e(json, "json");
        kotlin.jvm.internal.k.e(adStatus, "adStatus");
        kotlin.jvm.internal.k.e(adId, "adId");
        this.f7400a.writeLock().lock();
        try {
            N n2 = this.f7401b.get(adId);
            if (n2 == null) {
                this.f7400a.writeLock().unlock();
                return;
            }
            String bundleId = json.optString("bundleId");
            kotlin.jvm.internal.k.d(bundleId, "bundleId");
            if (bundleId.length() > 0) {
                n2.a(bundleId);
            }
            String dynamicDemandSourceId = json.optString("dynamicDemandSource");
            kotlin.jvm.internal.k.d(dynamicDemandSourceId, "dynamicDemandSourceId");
            if (dynamicDemandSourceId.length() > 0) {
                n2.a(W7.f7771b.a(dynamicDemandSourceId));
            }
            n2.a(adStatus);
            this.f7400a.writeLock().unlock();
        } catch (Throwable th) {
            this.f7400a.writeLock().unlock();
            throw th;
        }
    }

    @Override // com.ironsource.O.a
    public void a(EnumC2439m0 adStatus, String adId) {
        kotlin.jvm.internal.k.e(adStatus, "adStatus");
        kotlin.jvm.internal.k.e(adId, "adId");
        this.f7400a.writeLock().lock();
        try {
            N n2 = this.f7401b.get(adId);
            if (n2 == null) {
                return;
            }
            n2.a(adStatus);
            n2.a(System.currentTimeMillis() / 1000.0d);
        } finally {
            this.f7400a.writeLock().unlock();
        }
    }
}
