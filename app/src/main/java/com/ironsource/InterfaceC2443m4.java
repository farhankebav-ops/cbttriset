package com.ironsource;

/* JADX INFO: renamed from: com.ironsource.m4, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface InterfaceC2443m4 {

    /* JADX INFO: renamed from: com.ironsource.m4$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a implements InterfaceC2443m4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f8950a;

        public a(boolean z2) {
            this.f8950a = z2;
        }

        @Override // com.ironsource.InterfaceC2443m4
        public void a() {
            A8.a(C2328fe.f8548x, new C2603v8().a(G5.y, Boolean.valueOf(this.f8950a)).a());
        }
    }

    /* JADX INFO: renamed from: com.ironsource.m4$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b implements InterfaceC2443m4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f8951a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f8952b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final InterfaceC2565t4 f8953c;

        public b(boolean z2, long j, InterfaceC2565t4 currentTimeProvider) {
            kotlin.jvm.internal.k.e(currentTimeProvider, "currentTimeProvider");
            this.f8951a = z2;
            this.f8952b = j;
            this.f8953c = currentTimeProvider;
        }

        @Override // com.ironsource.InterfaceC2443m4
        public void a() {
            C2603v8 c2603v8A = new C2603v8().a(G5.y, Boolean.valueOf(this.f8951a));
            if (this.f8952b > 0) {
                c2603v8A.a(G5.B, Long.valueOf(this.f8953c.a() - this.f8952b));
            }
            A8.a(C2328fe.f8547w, c2603v8A.a());
        }

        public final InterfaceC2565t4 b() {
            return this.f8953c;
        }
    }

    void a();
}
