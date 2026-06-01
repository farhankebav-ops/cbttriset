package com.ironsource;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class Zd {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f7924o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<C2434ld> f7925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private H1 f7926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7927c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f7928d;
    private int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f7929f;
    private int g;
    private long h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f7930i;
    private boolean j;
    private boolean k;
    private C2434ld l;
    private C2496p2 m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f7931n;

    public Zd() {
        this.f7925a = new ArrayList<>();
        this.f7926b = new H1();
    }

    public void a(C2434ld c2434ld) {
        if (c2434ld != null) {
            this.f7925a.add(c2434ld);
            if (this.l == null) {
                this.l = c2434ld;
            } else if (c2434ld.a(0)) {
                this.l = c2434ld;
            }
        }
    }

    public int b() {
        return this.g;
    }

    public int c() {
        return this.f7929f;
    }

    public boolean d() {
        return this.f7931n;
    }

    public ArrayList<C2434ld> e() {
        return this.f7925a;
    }

    public boolean f() {
        return this.f7930i;
    }

    public int g() {
        return this.f7927c;
    }

    public int h() {
        return this.e;
    }

    public long i() {
        return TimeUnit.SECONDS.toMillis(this.e);
    }

    public boolean j() {
        return this.f7928d;
    }

    public C2496p2 k() {
        return this.m;
    }

    public long l() {
        return this.h;
    }

    public H1 m() {
        return this.f7926b;
    }

    public boolean n() {
        return this.k;
    }

    public boolean o() {
        return this.j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("RewardedVideoConfigurations{parallelLoad=");
        sb.append(this.f7927c);
        sb.append(", bidderExclusive=");
        return a1.a.t(sb, this.f7928d, '}');
    }

    public Zd(int i2, boolean z2, int i8, int i9, H1 h12, C2496p2 c2496p2, int i10, boolean z7, long j, boolean z8, boolean z9, boolean z10) {
        this.f7925a = new ArrayList<>();
        this.f7927c = i2;
        this.f7928d = z2;
        this.e = i8;
        this.f7926b = h12;
        this.f7929f = i9;
        this.m = c2496p2;
        this.g = i10;
        this.f7931n = z7;
        this.h = j;
        this.f7930i = z8;
        this.j = z9;
        this.k = z10;
    }

    public C2434ld a(String str) {
        ArrayList<C2434ld> arrayList = this.f7925a;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            C2434ld c2434ld = arrayList.get(i2);
            i2++;
            C2434ld c2434ld2 = c2434ld;
            if (c2434ld2.c().equals(str)) {
                return c2434ld2;
            }
        }
        return null;
    }

    public C2434ld a() {
        ArrayList<C2434ld> arrayList = this.f7925a;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            C2434ld c2434ld = arrayList.get(i2);
            i2++;
            C2434ld c2434ld2 = c2434ld;
            if (c2434ld2.d()) {
                return c2434ld2;
            }
        }
        return this.l;
    }
}
