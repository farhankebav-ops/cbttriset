package com.ironsource;

import com.ironsource.N0;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.List;

/* JADX INFO: renamed from: com.ironsource.bc, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2254bc extends U {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final String f8081s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final List<NetworkSettings> f8082t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Rb f8083u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public C2254bc(String str, List<? extends NetworkSettings> list, Rb configs) {
        super(IronSource.a.NATIVE_AD, str, list, configs.d(), configs.b(), (int) (configs.c() / ((long) 1000)), configs.a(), configs.f(), -1, new N0(N0.a.MANUAL, configs.d().j(), configs.d().b(), -1L), new H0(-1L), configs.h(), configs.i(), configs.k(), configs.j(), false, 32768, null);
        kotlin.jvm.internal.k.e(configs, "configs");
        this.f8081s = str;
        this.f8082t = list;
        this.f8083u = configs;
    }

    public final C2254bc a(String str, List<? extends NetworkSettings> list, Rb configs) {
        kotlin.jvm.internal.k.e(configs, "configs");
        return new C2254bc(str, list, configs);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2254bc)) {
            return false;
        }
        C2254bc c2254bc = (C2254bc) obj;
        return kotlin.jvm.internal.k.a(this.f8081s, c2254bc.f8081s) && kotlin.jvm.internal.k.a(this.f8082t, c2254bc.f8082t) && kotlin.jvm.internal.k.a(this.f8083u, c2254bc.f8083u);
    }

    public int hashCode() {
        String str = this.f8081s;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<NetworkSettings> list = this.f8082t;
        return this.f8083u.hashCode() + ((iHashCode + (list != null ? list.hashCode() : 0)) * 31);
    }

    @Override // com.ironsource.U
    public List<NetworkSettings> j() {
        return this.f8082t;
    }

    @Override // com.ironsource.U
    public String o() {
        return this.f8081s;
    }

    public final String s() {
        return this.f8081s;
    }

    public final List<NetworkSettings> t() {
        return this.f8082t;
    }

    public String toString() {
        return "NativeAdManagerData(userId=" + this.f8081s + ", providerList=" + this.f8082t + ", configs=" + this.f8083u + ")";
    }

    public final Rb u() {
        return this.f8083u;
    }

    public final Rb v() {
        return this.f8083u;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ C2254bc a(C2254bc c2254bc, String str, List list, Rb rb, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = c2254bc.f8081s;
        }
        if ((i2 & 2) != 0) {
            list = c2254bc.f8082t;
        }
        if ((i2 & 4) != 0) {
            rb = c2254bc.f8083u;
        }
        return c2254bc.a(str, list, rb);
    }
}
