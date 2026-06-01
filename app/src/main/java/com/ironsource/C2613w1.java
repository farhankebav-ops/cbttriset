package com.ironsource;

/* JADX INFO: renamed from: com.ironsource.w1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2613w1 extends AbstractC2345gd {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f10467f = new a(null);
    private static final String g = "AppLifecycleTrigger";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.ironsource.lifecycle.b f10468d;
    private final InterfaceC2413ka e;

    /* JADX INFO: renamed from: com.ironsource.w1$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        private a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2613w1(com.ironsource.lifecycle.b lifeCycleObserver) {
        super(false, 1, null);
        kotlin.jvm.internal.k.e(lifeCycleObserver, "lifeCycleObserver");
        this.f10468d = lifeCycleObserver;
        b bVar = new b();
        this.e = bVar;
        lifeCycleObserver.a(bVar);
        a(lifeCycleObserver.e());
    }

    @Override // com.ironsource.AbstractC2345gd
    public String b() {
        return g;
    }

    public final void e() {
        this.f10468d.b(this.e);
    }

    /* JADX INFO: renamed from: com.ironsource.w1$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b implements InterfaceC2413ka {
        public b() {
        }

        @Override // com.ironsource.InterfaceC2413ka
        public void c() {
            C2613w1.this.a(false);
        }

        @Override // com.ironsource.InterfaceC2413ka
        public void d() {
            C2613w1.this.a(true);
        }

        @Override // com.ironsource.InterfaceC2413ka
        public void a() {
        }

        @Override // com.ironsource.InterfaceC2413ka
        public void b() {
        }
    }
}
