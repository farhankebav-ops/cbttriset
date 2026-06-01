package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class I2 extends U {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final String f6962s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final List<NetworkSettings> f6963t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final V2 f6964u;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public I2(String str, List<? extends NetworkSettings> list, V2 configs) {
        kotlin.jvm.internal.k.e(configs, "configs");
        IronSource.a aVar = IronSource.a.BANNER;
        C2496p2 c2496p2D = configs.d();
        kotlin.jvm.internal.k.d(c2496p2D, "configs.bannerAuctionSettings");
        super(aVar, str, list, c2496p2D, configs.a(), (int) (configs.b() / ((long) 1000)), configs.c(), configs.f(), -1, J2.b(configs), new H0(configs.j()), configs.e(), configs.l(), configs.n(), configs.m(), false, 32768, null);
        this.f6962s = str;
        this.f6963t = list;
        this.f6964u = configs;
    }

    public final I2 a(String str, List<? extends NetworkSettings> list, V2 configs) {
        kotlin.jvm.internal.k.e(configs, "configs");
        return new I2(str, list, configs);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof I2)) {
            return false;
        }
        I2 i2 = (I2) obj;
        return kotlin.jvm.internal.k.a(this.f6962s, i2.f6962s) && kotlin.jvm.internal.k.a(this.f6963t, i2.f6963t) && kotlin.jvm.internal.k.a(this.f6964u, i2.f6964u);
    }

    public int hashCode() {
        String str = this.f6962s;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<NetworkSettings> list = this.f6963t;
        return this.f6964u.hashCode() + ((iHashCode + (list != null ? list.hashCode() : 0)) * 31);
    }

    @Override // com.ironsource.U
    public List<NetworkSettings> j() {
        return this.f6963t;
    }

    @Override // com.ironsource.U
    public String o() {
        return this.f6962s;
    }

    public final String s() {
        return this.f6962s;
    }

    public final List<NetworkSettings> t() {
        return this.f6963t;
    }

    public String toString() {
        return "BannerAdManagerData(userId=" + this.f6962s + ", providerList=" + this.f6963t + ", configs=" + this.f6964u + ")";
    }

    public final V2 u() {
        return this.f6964u;
    }

    public final V2 v() {
        return this.f6964u;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ I2 a(I2 i2, String str, List list, V2 v2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = i2.f6962s;
        }
        if ((i8 & 2) != 0) {
            list = i2.f6963t;
        }
        if ((i8 & 4) != 0) {
            v2 = i2.f6964u;
        }
        return i2.a(str, list, v2);
    }
}
