package com.ironsource.mediationsdk;

import com.ironsource.C2270ca;
import com.ironsource.C2334g2;
import com.ironsource.mediationsdk.IronSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IronSource.a f9190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList<C2334g2> f9191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f9192c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f9193d;
    private boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, Object> f9194f;
    private List<String> g;
    private int h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private h f9195i;
    private C2270ca j;
    private String k;
    private ISBannerSize l;
    private boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f9196n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f9197o;
    private String p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f9198q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Boolean f9199r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Double f9200s;

    public i(IronSource.a adUnit) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        this.f9190a = adUnit;
        this.f9191b = new ArrayList<>();
        this.f9193d = "";
        this.f9194f = new HashMap();
        this.g = new ArrayList();
        this.h = -1;
        this.k = "";
    }

    public final IronSource.a a() {
        return this.f9190a;
    }

    public final void b(boolean z2) {
        this.e = z2;
    }

    public final IronSource.a c() {
        return this.f9190a;
    }

    public final void d(String str) {
        kotlin.jvm.internal.k.e(str, "<set-?>");
        this.k = str;
    }

    public final h e() {
        return this.f9195i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i) && this.f9190a == ((i) obj).f9190a;
    }

    public final ISBannerSize f() {
        return this.l;
    }

    public final Double g() {
        return this.f9200s;
    }

    public final Map<String, Object> h() {
        return this.f9194f;
    }

    public int hashCode() {
        return this.f9190a.hashCode();
    }

    public final String j() {
        return this.f9193d;
    }

    public final ArrayList<C2334g2> k() {
        return this.f9191b;
    }

    public final List<String> l() {
        return this.g;
    }

    public final C2270ca n() {
        return this.j;
    }

    public final int o() {
        return this.h;
    }

    public final boolean p() {
        return this.f9196n;
    }

    public final boolean q() {
        return this.f9197o;
    }

    public final String r() {
        return this.k;
    }

    public final boolean s() {
        return this.m;
    }

    public final boolean t() {
        return this.e;
    }

    public String toString() {
        return "AuctionRequestParams(adUnit=" + this.f9190a + ")";
    }

    public final Boolean u() {
        return this.f9199r;
    }

    public final boolean v() {
        return this.f9192c;
    }

    public final i a(IronSource.a adUnit) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        return new i(adUnit);
    }

    public final void b(String str) {
        this.p = str;
    }

    public final void c(boolean z2) {
        this.f9192c = z2;
    }

    public final void d(boolean z2) {
        this.f9196n = z2;
    }

    public final void e(boolean z2) {
        this.f9197o = z2;
    }

    public static /* synthetic */ i a(i iVar, IronSource.a aVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            aVar = iVar.f9190a;
        }
        return iVar.a(aVar);
    }

    public final String b() {
        return this.f9198q;
    }

    public final void c(String str) {
        kotlin.jvm.internal.k.e(str, "<set-?>");
        this.f9193d = str;
    }

    public final String d() {
        return this.p;
    }

    public final void a(C2334g2 instanceInfo) {
        kotlin.jvm.internal.k.e(instanceInfo, "instanceInfo");
        this.f9191b.add(instanceInfo);
    }

    public final void a(Map<String, Object> map) {
        kotlin.jvm.internal.k.e(map, "<set-?>");
        this.f9194f = map;
    }

    public final void a(List<String> list) {
        kotlin.jvm.internal.k.e(list, "<set-?>");
        this.g = list;
    }

    public final void a(int i2) {
        this.h = i2;
    }

    public final void a(h hVar) {
        this.f9195i = hVar;
    }

    public final void a(C2270ca c2270ca) {
        this.j = c2270ca;
    }

    public final void a(ISBannerSize iSBannerSize) {
        this.l = iSBannerSize;
    }

    public final void a(boolean z2) {
        this.m = z2;
    }

    public final void a(String str) {
        this.f9198q = str;
    }

    public final void a(Boolean bool) {
        this.f9199r = bool;
    }

    public final void a(Double d8) {
        this.f9200s = d8;
    }

    public static /* synthetic */ void i() {
    }

    public static /* synthetic */ void m() {
    }
}
