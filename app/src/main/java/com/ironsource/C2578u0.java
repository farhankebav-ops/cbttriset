package com.ironsource;

import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.List;

/* JADX INFO: renamed from: com.ironsource.u0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2578u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<NetworkSettings> f10323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final C2469na f10324c;

    /* JADX WARN: Multi-variable type inference failed */
    public C2578u0(String str, List<? extends NetworkSettings> providerList, C2469na publisherDataHolder) {
        kotlin.jvm.internal.k.e(providerList, "providerList");
        kotlin.jvm.internal.k.e(publisherDataHolder, "publisherDataHolder");
        this.f10322a = str;
        this.f10323b = providerList;
        this.f10324c = publisherDataHolder;
    }

    public final String a() {
        return this.f10322a;
    }

    public final List<NetworkSettings> b() {
        return this.f10323b;
    }

    public final C2469na c() {
        return this.f10324c;
    }

    public final List<NetworkSettings> d() {
        return this.f10323b;
    }

    public final C2469na e() {
        return this.f10324c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2578u0)) {
            return false;
        }
        C2578u0 c2578u0 = (C2578u0) obj;
        return kotlin.jvm.internal.k.a(this.f10322a, c2578u0.f10322a) && kotlin.jvm.internal.k.a(this.f10323b, c2578u0.f10323b) && kotlin.jvm.internal.k.a(this.f10324c, c2578u0.f10324c);
    }

    public final String f() {
        return this.f10322a;
    }

    public int hashCode() {
        String str = this.f10322a;
        return this.f10324c.hashCode() + ((this.f10323b.hashCode() + ((str == null ? 0 : str.hashCode()) * 31)) * 31);
    }

    public String toString() {
        return "AdUnitCommonData(userId=" + this.f10322a + ", providerList=" + this.f10323b + ", publisherDataHolder=" + this.f10324c + ")";
    }

    public final C2578u0 a(String str, List<? extends NetworkSettings> providerList, C2469na publisherDataHolder) {
        kotlin.jvm.internal.k.e(providerList, "providerList");
        kotlin.jvm.internal.k.e(publisherDataHolder, "publisherDataHolder");
        return new C2578u0(str, providerList, publisherDataHolder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ C2578u0 a(C2578u0 c2578u0, String str, List list, C2469na c2469na, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = c2578u0.f10322a;
        }
        if ((i2 & 2) != 0) {
            list = c2578u0.f10323b;
        }
        if ((i2 & 4) != 0) {
            c2469na = c2578u0.f10324c;
        }
        return c2578u0.a(str, list, c2469na);
    }
}
