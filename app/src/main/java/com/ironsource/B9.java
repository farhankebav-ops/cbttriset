package com.ironsource;

import com.ironsource.N0;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class B9 extends U {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final String f6380s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final List<NetworkSettings> f6381t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final F9 f6382u;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public B9(String str, List<? extends NetworkSettings> list, F9 configs) {
        kotlin.jvm.internal.k.e(configs, "configs");
        IronSource.a aVar = IronSource.a.INTERSTITIAL;
        C2496p2 c2496p2G = configs.g();
        kotlin.jvm.internal.k.d(c2496p2G, "configs.interstitialAuctionSettings");
        super(aVar, str, list, c2496p2G, configs.c(), configs.d(), configs.f(), configs.b(), -1, new N0(N0.a.MANUAL, configs.g().j(), configs.g().b(), -1L), new H0(-1L), configs.h(), configs.k(), configs.m(), configs.l(), false, 32768, null);
        this.f6380s = str;
        this.f6381t = list;
        this.f6382u = configs;
    }

    public final B9 a(String str, List<? extends NetworkSettings> list, F9 configs) {
        kotlin.jvm.internal.k.e(configs, "configs");
        return new B9(str, list, configs);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof B9)) {
            return false;
        }
        B9 b9 = (B9) obj;
        return kotlin.jvm.internal.k.a(this.f6380s, b9.f6380s) && kotlin.jvm.internal.k.a(this.f6381t, b9.f6381t) && kotlin.jvm.internal.k.a(this.f6382u, b9.f6382u);
    }

    public int hashCode() {
        String str = this.f6380s;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<NetworkSettings> list = this.f6381t;
        return this.f6382u.hashCode() + ((iHashCode + (list != null ? list.hashCode() : 0)) * 31);
    }

    @Override // com.ironsource.U
    public List<NetworkSettings> j() {
        return this.f6381t;
    }

    @Override // com.ironsource.U
    public String o() {
        return this.f6380s;
    }

    public final String s() {
        return this.f6380s;
    }

    public final List<NetworkSettings> t() {
        return this.f6381t;
    }

    public String toString() {
        return "InterstitialAdManagerData(userId=" + this.f6380s + ", providerList=" + this.f6381t + ", configs=" + this.f6382u + ")";
    }

    public final F9 u() {
        return this.f6382u;
    }

    public final F9 v() {
        return this.f6382u;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ B9 a(B9 b9, String str, List list, F9 f9, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = b9.f6380s;
        }
        if ((i2 & 2) != 0) {
            list = b9.f6381t;
        }
        if ((i2 & 4) != 0) {
            f9 = b9.f6382u;
        }
        return b9.a(str, list, f9);
    }
}
