package com.ironsource;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Rb {
    public static final a m = new a(null);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f7559n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f7560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private H1 f7561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7562c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f7563d;
    private boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ArrayList<C2272cc> f7564f;
    private C2272cc g;
    private int h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private C2496p2 f7565i;
    private long j;
    private boolean k;
    private boolean l;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        private a() {
        }
    }

    public Rb(int i2, long j, boolean z2, H1 events, C2496p2 auctionSettings, int i8, long j3, boolean z7, boolean z8, boolean z9) {
        kotlin.jvm.internal.k.e(events, "events");
        kotlin.jvm.internal.k.e(auctionSettings, "auctionSettings");
        this.f7560a = z9;
        this.f7564f = new ArrayList<>();
        this.f7562c = i2;
        this.f7563d = j;
        this.e = z2;
        this.f7561b = events;
        this.h = i8;
        this.f7565i = auctionSettings;
        this.j = j3;
        this.k = z7;
        this.l = z8;
    }

    public final void a(H1 h12) {
        kotlin.jvm.internal.k.e(h12, "<set-?>");
        this.f7561b = h12;
    }

    public final int b() {
        return this.f7562c;
    }

    public final long c() {
        return this.f7563d;
    }

    public final C2496p2 d() {
        return this.f7565i;
    }

    public final C2272cc e() {
        ArrayList<C2272cc> arrayList = this.f7564f;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            C2272cc c2272cc = arrayList.get(i2);
            i2++;
            C2272cc c2272cc2 = c2272cc;
            if (c2272cc2.d()) {
                return c2272cc2;
            }
        }
        return this.g;
    }

    public final int f() {
        return this.h;
    }

    public final H1 g() {
        return this.f7561b;
    }

    public final long h() {
        return this.j;
    }

    public final boolean i() {
        return this.k;
    }

    public final boolean j() {
        return this.f7560a;
    }

    public final boolean k() {
        return this.l;
    }

    public String toString() {
        return "NativeAdConfigurations{parallelLoad=" + this.f7562c + ", bidderExclusive=" + this.e + "}";
    }

    public final void a(int i2) {
        this.f7562c = i2;
    }

    public final void b(int i2) {
        this.h = i2;
    }

    public final void c(boolean z2) {
        this.l = z2;
    }

    public final void a(long j) {
        this.f7563d = j;
    }

    public final void b(long j) {
        this.j = j;
    }

    public final boolean a() {
        return this.e;
    }

    public final void b(boolean z2) {
        this.k = z2;
    }

    public final void a(boolean z2) {
        this.e = z2;
    }

    public final void a(C2496p2 c2496p2) {
        kotlin.jvm.internal.k.e(c2496p2, "<set-?>");
        this.f7565i = c2496p2;
    }

    public final void a(C2272cc c2272cc) {
        if (c2272cc != null) {
            this.f7564f.add(c2272cc);
            if (this.g == null) {
                this.g = c2272cc;
            } else if (c2272cc.b() == 0) {
                this.g = c2272cc;
            }
        }
    }

    public final C2272cc a(String placementName) {
        kotlin.jvm.internal.k.e(placementName, "placementName");
        ArrayList<C2272cc> arrayList = this.f7564f;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            C2272cc c2272cc = arrayList.get(i2);
            i2++;
            C2272cc c2272cc2 = c2272cc;
            if (kotlin.jvm.internal.k.a(c2272cc2.c(), placementName)) {
                return c2272cc2;
            }
        }
        return null;
    }
}
