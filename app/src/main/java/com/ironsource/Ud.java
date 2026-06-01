package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Ud extends U {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final String f7687s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final List<NetworkSettings> f7688t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Zd f7689u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final boolean f7690v;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public Ud(String str, List<? extends NetworkSettings> list, Zd configs, boolean z2) {
        kotlin.jvm.internal.k.e(configs, "configs");
        IronSource.a aVar = IronSource.a.REWARDED_VIDEO;
        C2496p2 c2496p2K = configs.k();
        kotlin.jvm.internal.k.d(c2496p2K, "configs.rewardedVideoAuctionSettings");
        super(aVar, str, list, c2496p2K, configs.g(), configs.h(), configs.j(), configs.b(), configs.c(), Vd.b(configs, z2), new H0(-1L), configs.l(), configs.f(), configs.o(), configs.n(), false, 32768, null);
        this.f7687s = str;
        this.f7688t = list;
        this.f7689u = configs;
        this.f7690v = z2;
    }

    public final Ud a(String str, List<? extends NetworkSettings> list, Zd configs, boolean z2) {
        kotlin.jvm.internal.k.e(configs, "configs");
        return new Ud(str, list, configs, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Ud)) {
            return false;
        }
        Ud ud = (Ud) obj;
        return kotlin.jvm.internal.k.a(this.f7687s, ud.f7687s) && kotlin.jvm.internal.k.a(this.f7688t, ud.f7688t) && kotlin.jvm.internal.k.a(this.f7689u, ud.f7689u) && this.f7690v == ud.f7690v;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    public int hashCode() {
        String str = this.f7687s;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<NetworkSettings> list = this.f7688t;
        int iHashCode2 = (this.f7689u.hashCode() + ((iHashCode + (list != null ? list.hashCode() : 0)) * 31)) * 31;
        boolean z2 = this.f7690v;
        ?? r02 = z2;
        if (z2) {
            r02 = 1;
        }
        return iHashCode2 + r02;
    }

    @Override // com.ironsource.U
    public List<NetworkSettings> j() {
        return this.f7688t;
    }

    @Override // com.ironsource.U
    public String o() {
        return this.f7687s;
    }

    public final String s() {
        return this.f7687s;
    }

    public final List<NetworkSettings> t() {
        return this.f7688t;
    }

    public String toString() {
        return "RewardedVideoAdDataManager(userId=" + this.f7687s + ", providerList=" + this.f7688t + ", configs=" + this.f7689u + ", isManual=" + this.f7690v + ")";
    }

    public final Zd u() {
        return this.f7689u;
    }

    public final boolean v() {
        return this.f7690v;
    }

    public final Zd w() {
        return this.f7689u;
    }

    public final boolean x() {
        return this.f7690v;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Ud a(Ud ud, String str, List list, Zd zd, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = ud.f7687s;
        }
        if ((i2 & 2) != 0) {
            list = ud.f7688t;
        }
        if ((i2 & 4) != 0) {
            zd = ud.f7689u;
        }
        if ((i2 & 8) != 0) {
            z2 = ud.f7690v;
        }
        return ud.a(str, list, zd, z2);
    }
}
