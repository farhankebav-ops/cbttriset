package com.ironsource;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class V2 {
    private static final int p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private H1 f7709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f7710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f7711c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f7712d;
    private ArrayList<C2371i3> e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private C2371i3 f7713f;
    private int g;
    private int h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private C2496p2 f7714i;
    private boolean j;
    private long k;
    private boolean l;
    private boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f7715n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f7716o;

    public V2() {
        this.f7709a = new H1();
        this.e = new ArrayList<>();
    }

    public int a() {
        return this.f7710b;
    }

    public long b() {
        return this.f7711c;
    }

    public boolean c() {
        return this.f7712d;
    }

    public C2496p2 d() {
        return this.f7714i;
    }

    public long e() {
        return this.k;
    }

    public int f() {
        return this.h;
    }

    public H1 g() {
        return this.f7709a;
    }

    public int h() {
        return this.g;
    }

    public C2371i3 i() {
        ArrayList<C2371i3> arrayList = this.e;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            C2371i3 c2371i3 = arrayList.get(i2);
            i2++;
            C2371i3 c2371i32 = c2371i3;
            if (c2371i32.d()) {
                return c2371i32;
            }
        }
        C2371i3 c2371i33 = this.f7713f;
        return c2371i33 != null ? c2371i33 : new C2482o5();
    }

    public long j() {
        return this.f7716o;
    }

    public boolean k() {
        return this.j;
    }

    public boolean l() {
        return this.l;
    }

    public boolean m() {
        return this.f7715n;
    }

    public boolean n() {
        return this.m;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("BannerConfigurations{parallelLoad=");
        sb.append(this.f7710b);
        sb.append(", bidderExclusive=");
        return a1.a.t(sb, this.f7712d, '}');
    }

    public void a(C2371i3 c2371i3) {
        if (c2371i3 != null) {
            this.e.add(c2371i3);
            if (this.f7713f == null) {
                this.f7713f = c2371i3;
            } else if (c2371i3.a(0)) {
                this.f7713f = c2371i3;
            }
        }
    }

    public V2(int i2, long j, boolean z2, H1 h12, int i8, C2496p2 c2496p2, int i9, boolean z7, long j3, boolean z8, boolean z9, boolean z10, long j8) {
        this.e = new ArrayList<>();
        this.f7710b = i2;
        this.f7711c = j;
        this.f7712d = z2;
        this.f7709a = h12;
        this.g = i8;
        this.h = i9;
        this.f7714i = c2496p2;
        this.j = z7;
        this.k = j3;
        this.l = z8;
        this.m = z9;
        this.f7715n = z10;
        this.f7716o = j8;
    }

    public C2371i3 a(String str) {
        ArrayList<C2371i3> arrayList = this.e;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            C2371i3 c2371i3 = arrayList.get(i2);
            i2++;
            C2371i3 c2371i32 = c2371i3;
            if (c2371i32.c().equals(str)) {
                return c2371i32;
            }
        }
        return null;
    }
}
