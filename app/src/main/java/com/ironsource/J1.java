package com.ironsource;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class J1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, String> f6997a;

    public J1() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final Map<String, String> a() {
        return this.f6997a;
    }

    public final Map<String, String> b() {
        return this.f6997a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof J1) && kotlin.jvm.internal.k.a(this.f6997a, ((J1) obj).f6997a);
    }

    public int hashCode() {
        return this.f6997a.hashCode();
    }

    public String toString() {
        return "ApplicationExternalSettings(mediationTypes=" + this.f6997a + ")";
    }

    public J1(Map<String, String> mediationTypes) {
        kotlin.jvm.internal.k.e(mediationTypes, "mediationTypes");
        this.f6997a = mediationTypes;
    }

    public final J1 a(Map<String, String> mediationTypes) {
        kotlin.jvm.internal.k.e(mediationTypes, "mediationTypes");
        return new J1(mediationTypes);
    }

    public /* synthetic */ J1(Map map, int i2, kotlin.jvm.internal.f fVar) {
        this((i2 & 1) != 0 ? r5.s.f13639a : map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ J1 a(J1 j12, Map map, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            map = j12.f6997a;
        }
        return j12.a(map);
    }
}
