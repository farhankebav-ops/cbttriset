package com.ironsource;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class F9 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f6759n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<K9> f6760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private H1 f6761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f6762c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f6763d;
    private int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f6764f;
    private C2496p2 g;
    private boolean h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f6765i;
    private boolean j;
    private boolean k;
    private boolean l;
    private K9 m;

    public F9() {
        this.f6760a = new ArrayList<>();
        this.f6761b = new H1();
        this.g = new C2496p2();
    }

    public void a(K9 k9) {
        if (k9 != null) {
            this.f6760a.add(k9);
            if (this.m == null) {
                this.m = k9;
            } else if (k9.a(0)) {
                this.m = k9;
            }
        }
    }

    public int b() {
        return this.f6764f;
    }

    public int c() {
        return this.f6762c;
    }

    public int d() {
        return this.e;
    }

    public long e() {
        return TimeUnit.SECONDS.toMillis(this.e);
    }

    public boolean f() {
        return this.f6763d;
    }

    public C2496p2 g() {
        return this.g;
    }

    public long h() {
        return this.f6765i;
    }

    public H1 i() {
        return this.f6761b;
    }

    public boolean j() {
        return this.h;
    }

    public boolean k() {
        return this.j;
    }

    public boolean l() {
        return this.l;
    }

    public boolean m() {
        return this.k;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("InterstitialConfigurations{parallelLoad=");
        sb.append(this.f6762c);
        sb.append(", bidderExclusive=");
        return a1.a.t(sb, this.f6763d, '}');
    }

    public F9(int i2, boolean z2, int i8, H1 h12, C2496p2 c2496p2, int i9, boolean z7, long j, boolean z8, boolean z9, boolean z10) {
        this.f6760a = new ArrayList<>();
        this.f6762c = i2;
        this.f6763d = z2;
        this.e = i8;
        this.f6761b = h12;
        this.g = c2496p2;
        this.j = z8;
        this.k = z9;
        this.f6764f = i9;
        this.h = z7;
        this.f6765i = j;
        this.l = z10;
    }

    public K9 a(String str) {
        ArrayList<K9> arrayList = this.f6760a;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            K9 k9 = arrayList.get(i2);
            i2++;
            K9 k92 = k9;
            if (k92.c().equals(str)) {
                return k92;
            }
        }
        return null;
    }

    public K9 a() {
        ArrayList<K9> arrayList = this.f6760a;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            K9 k9 = arrayList.get(i2);
            i2++;
            K9 k92 = k9;
            if (k92.d()) {
                return k92;
            }
        }
        return this.m;
    }
}
