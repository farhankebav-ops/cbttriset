package com.ironsource;

import com.ironsource.N0;
import com.ironsource.mediationsdk.logger.IronLog;

/* JADX INFO: renamed from: com.ironsource.b3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2245b3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final N0 f8031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final H0 f8032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final G2 f8033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final q5.f f8034d;
    private final q5.f e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f8035f;
    private final boolean g;
    private final boolean h;

    public C2245b3(N0 loadingData, H0 interactionData, G2 mListener) {
        kotlin.jvm.internal.k.e(loadingData, "loadingData");
        kotlin.jvm.internal.k.e(interactionData, "interactionData");
        kotlin.jvm.internal.k.e(mListener, "mListener");
        this.f8031a = loadingData;
        this.f8032b = interactionData;
        this.f8033c = mListener;
        this.f8034d = n7.b.C(new a());
        this.e = n7.b.C(new b());
        this.f8035f = loadingData.b() > 0;
        this.g = interactionData.b() > 0;
        this.h = loadingData.a() == N0.a.MANUAL_WITH_LOAD_ON_SHOW;
    }

    private final C2640xb c() {
        return (C2640xb) this.f8034d.getValue();
    }

    private final C2640xb d() {
        return (C2640xb) this.e.getValue();
    }

    private final void f() {
        if (this.h) {
            c().b();
        }
    }

    private final void g() {
        if (this.h) {
            d().b();
        }
    }

    public final void b() {
        IronLog.INTERNAL.verbose();
        g();
    }

    public final void e() {
        IronLog.INTERNAL.verbose();
        b(this.f8032b.b());
    }

    public final void h() {
        if (!this.f8035f) {
            IronLog.INTERNAL.verbose("banner reload interval is disabled");
        } else {
            IronLog.INTERNAL.verbose();
            a(this.f8031a.b());
        }
    }

    public final void a() {
        IronLog.INTERNAL.verbose();
        f();
    }

    private final void b(long j) {
        if (this.h && this.g) {
            d().a(j);
        }
    }

    private final void a(long j) {
        if (this.h && this.f8035f) {
            c().a(j);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.b3$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a extends kotlin.jvm.internal.l implements e6.a {
        public a() {
            super(0);
        }

        @Override // e6.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C2640xb invoke() {
            return new C2640xb(new zh(C2245b3.this, 0), com.ironsource.lifecycle.b.d(), new Wf());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(C2245b3 this$0) {
            kotlin.jvm.internal.k.e(this$0, "this$0");
            this$0.f8033c.c();
        }
    }

    /* JADX INFO: renamed from: com.ironsource.b3$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b extends kotlin.jvm.internal.l implements e6.a {
        public b() {
            super(0);
        }

        @Override // e6.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C2640xb invoke() {
            return new C2640xb(new zh(C2245b3.this, 1), com.ironsource.lifecycle.b.d(), new Wf());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(C2245b3 this$0) {
            kotlin.jvm.internal.k.e(this$0, "this$0");
            this$0.f8033c.d();
        }
    }
}
