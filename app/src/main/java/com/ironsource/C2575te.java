package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import java.util.List;

/* JADX INFO: renamed from: com.ironsource.te, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2575te {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<IronSource.a> f10308c;

    public C2575te(String appKey, String str, List<IronSource.a> legacyAdFormats) {
        kotlin.jvm.internal.k.e(appKey, "appKey");
        kotlin.jvm.internal.k.e(legacyAdFormats, "legacyAdFormats");
        this.f10306a = appKey;
        this.f10307b = str;
        this.f10308c = legacyAdFormats;
    }

    public final String a() {
        return this.f10306a;
    }

    public final String b() {
        return this.f10307b;
    }

    public final List<IronSource.a> c() {
        return this.f10308c;
    }

    public final String d() {
        return this.f10306a;
    }

    public final List<IronSource.a> e() {
        return this.f10308c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2575te)) {
            return false;
        }
        C2575te c2575te = (C2575te) obj;
        return kotlin.jvm.internal.k.a(this.f10306a, c2575te.f10306a) && kotlin.jvm.internal.k.a(this.f10307b, c2575te.f10307b) && kotlin.jvm.internal.k.a(this.f10308c, c2575te.f10308c);
    }

    public final String f() {
        return this.f10307b;
    }

    public int hashCode() {
        int iHashCode = this.f10306a.hashCode() * 31;
        String str = this.f10307b;
        return this.f10308c.hashCode() + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31);
    }

    public String toString() {
        String str = this.f10306a;
        String str2 = this.f10307b;
        List<IronSource.a> list = this.f10308c;
        StringBuilder sbZ = a1.a.z("SdkInitRequest(appKey=", str, ", userId=", str2, ", legacyAdFormats=");
        sbZ.append(list);
        sbZ.append(")");
        return sbZ.toString();
    }

    public final C2575te a(String appKey, String str, List<IronSource.a> legacyAdFormats) {
        kotlin.jvm.internal.k.e(appKey, "appKey");
        kotlin.jvm.internal.k.e(legacyAdFormats, "legacyAdFormats");
        return new C2575te(appKey, str, legacyAdFormats);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ C2575te a(C2575te c2575te, String str, String str2, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = c2575te.f10306a;
        }
        if ((i2 & 2) != 0) {
            str2 = c2575te.f10307b;
        }
        if ((i2 & 4) != 0) {
            list = c2575te.f10308c;
        }
        return c2575te.a(str, str2, list);
    }

    public final void a(List<? extends IronSource.a> adFormats) {
        kotlin.jvm.internal.k.e(adFormats, "adFormats");
        this.f10308c.clear();
        this.f10308c.addAll(adFormats);
    }

    public /* synthetic */ C2575te(String str, String str2, List list, int i2, kotlin.jvm.internal.f fVar) {
        this(str, (i2 & 2) != 0 ? null : str2, list);
    }
}
