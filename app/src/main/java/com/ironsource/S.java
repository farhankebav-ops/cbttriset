package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class S implements InterfaceC2457mg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InterfaceC2430l9 f7576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f7577c;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a extends kotlin.jvm.internal.l implements e6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f7578a = new a();

        public a() {
            super(0);
        }

        @Override // e6.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final IronSourceError invoke() {
            return C2668z5.f10625a.r();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b extends kotlin.jvm.internal.l implements e6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f7579a = new b();

        public b() {
            super(0);
        }

        @Override // e6.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final IronSourceError invoke() {
            return C2668z5.f10625a.o();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class c extends kotlin.jvm.internal.l implements e6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f7580a = new c();

        public c() {
            super(0);
        }

        @Override // e6.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final IronSourceError invoke() {
            return C2668z5.f10625a.n();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class d extends kotlin.jvm.internal.l implements e6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f7581a = new d();

        public d() {
            super(0);
        }

        @Override // e6.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final IronSourceError invoke() {
            return C2668z5.f10625a.q();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class e extends kotlin.jvm.internal.l implements e6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f7582a = new e();

        public e() {
            super(0);
        }

        @Override // e6.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final IronSourceError invoke() {
            return C2668z5.f10625a.o();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class f extends kotlin.jvm.internal.l implements e6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f7583a = new f();

        public f() {
            super(0);
        }

        @Override // e6.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final IronSourceError invoke() {
            return C2668z5.f10625a.g();
        }
    }

    public S(String adm, InterfaceC2430l9 interfaceC2430l9, boolean z2) {
        kotlin.jvm.internal.k.e(adm, "adm");
        this.f7575a = adm;
        this.f7576b = interfaceC2430l9;
        this.f7577c = z2;
    }

    @Override // com.ironsource.InterfaceC2457mg
    public final /* synthetic */ void a(boolean z2, e6.a aVar) {
        ni.a(this, z2, aVar);
    }

    @Override // com.ironsource.InterfaceC2457mg
    public void a() throws C2508pe {
        ni.a(this, this.f7577c, a.f7578a);
        ni.a(this, this.f7576b != null, b.f7579a);
        InterfaceC2430l9 interfaceC2430l9 = this.f7576b;
        if (interfaceC2430l9 != null) {
            if (interfaceC2430l9.f() == EnumC2468n9.NonBidder) {
                ni.a(this, this.f7575a.length() == 0, c.f7580a);
            }
            if (interfaceC2430l9.f() == EnumC2468n9.Bidder) {
                ni.a(this, this.f7575a.length() > 0, d.f7581a);
            }
            ni.a(this, interfaceC2430l9.f() != EnumC2468n9.NotSupported, e.f7582a);
            ni.a(this, interfaceC2430l9.e().length() > 0, f.f7583a);
        }
    }
}
