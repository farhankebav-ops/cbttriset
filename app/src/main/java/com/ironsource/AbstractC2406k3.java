package com.ironsource;

/* JADX INFO: renamed from: com.ironsource.k3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractC2406k3 implements InterfaceC2501p7 {

    /* JADX INFO: renamed from: com.ironsource.k3$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a extends AbstractC2406k3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f8817a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b firstReason) {
            super(null);
            kotlin.jvm.internal.k.e(firstReason, "firstReason");
            this.f8817a = firstReason;
        }

        public final a a(b firstReason) {
            kotlin.jvm.internal.k.e(firstReason, "firstReason");
            return new a(firstReason);
        }

        public final b d() {
            return this.f8817a;
        }

        public final b e() {
            return this.f8817a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && kotlin.jvm.internal.k.a(this.f8817a, ((a) obj).f8817a);
        }

        public int hashCode() {
            return this.f8817a.hashCode();
        }

        public String toString() {
            return "First(firstReason=" + this.f8817a + ")";
        }

        public static /* synthetic */ a a(a aVar, b bVar, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                bVar = aVar.f8817a;
            }
            return aVar.a(bVar);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.k3$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class b implements InterfaceC2501p7 {

        /* JADX INFO: renamed from: com.ironsource.k3$b$a */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f8818a = new a();

            private a() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.ironsource.k3$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class C0186b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0186b f8819a = new C0186b();

            private C0186b() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.ironsource.k3$b$c */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class c extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f8820a = new c();

            private c() {
                super(null);
            }
        }

        public /* synthetic */ b(kotlin.jvm.internal.f fVar) {
            this();
        }

        @Override // com.ironsource.InterfaceC2501p7
        public String a() {
            if (this instanceof a) {
                return "PublisherLoadFail";
            }
            if (this instanceof C0186b) {
                return "PublisherLoadSuccess";
            }
            if (this instanceof c) {
                return "ResumeAutoRefresh";
            }
            throw new e2.s(3);
        }

        private b() {
        }
    }

    /* JADX INFO: renamed from: com.ironsource.k3$c */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class c extends AbstractC2406k3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f8821a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d f8822b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(long j, d recurringReason) {
            super(null);
            kotlin.jvm.internal.k.e(recurringReason, "recurringReason");
            this.f8821a = j;
            this.f8822b = recurringReason;
        }

        public final c a(long j, d recurringReason) {
            kotlin.jvm.internal.k.e(recurringReason, "recurringReason");
            return new c(j, recurringReason);
        }

        public final long d() {
            return this.f8821a;
        }

        public final d e() {
            return this.f8822b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f8821a == cVar.f8821a && kotlin.jvm.internal.k.a(this.f8822b, cVar.f8822b);
        }

        public final d f() {
            return this.f8822b;
        }

        public final long g() {
            return this.f8821a;
        }

        public int hashCode() {
            long j = this.f8821a;
            return this.f8822b.hashCode() + (((int) (j ^ (j >>> 32))) * 31);
        }

        public String toString() {
            return "Recurring(reloadDuration=" + this.f8821a + ", recurringReason=" + this.f8822b + ")";
        }

        public static /* synthetic */ c a(c cVar, long j, d dVar, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = cVar.f8821a;
            }
            if ((i2 & 2) != 0) {
                dVar = cVar.f8822b;
            }
            return cVar.a(j, dVar);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.k3$d */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class d implements InterfaceC2501p7 {

        /* JADX INFO: renamed from: com.ironsource.k3$d$a */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class a extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f8823a = new a();

            private a() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.ironsource.k3$d$b */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class b extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f8824a = new b();

            private b() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.ironsource.k3$d$c */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class c extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f8825a = new c();

            private c() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.ironsource.k3$d$d, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class C0187d extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0187d f8826a = new C0187d();

            private C0187d() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.ironsource.k3$d$e */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class e extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final e f8827a = new e();

            private e() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.ironsource.k3$d$f */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class f extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final long f8828a;

            public f(long j) {
                super(null);
                this.f8828a = j;
            }

            public final f a(long j) {
                return new f(j);
            }

            public final long c() {
                return this.f8828a;
            }

            public final long d() {
                return this.f8828a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof f) && this.f8828a == ((f) obj).f8828a;
            }

            public int hashCode() {
                long j = this.f8828a;
                return (int) (j ^ (j >>> 32));
            }

            public String toString() {
                return "ResumeVisibility(notVisibleDuration=" + this.f8828a + ")";
            }

            public static /* synthetic */ f a(f fVar, long j, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    j = fVar.f8828a;
                }
                return fVar.a(j);
            }
        }

        /* JADX INFO: renamed from: com.ironsource.k3$d$g */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class g extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final g f8829a = new g();

            private g() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.ironsource.k3$d$h */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class h extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final h f8830a = new h();

            private h() {
                super(null);
            }
        }

        public /* synthetic */ d(kotlin.jvm.internal.f fVar) {
            this();
        }

        @Override // com.ironsource.InterfaceC2501p7
        public String a() {
            if (this instanceof f) {
                return "ResumeVisibility";
            }
            if (this instanceof a) {
                return "PublisherLoadFail";
            }
            if (this instanceof b) {
                return "PublisherLoadSuccess";
            }
            if (this instanceof e) {
                return "ResumeAutoRefresh";
            }
            if (this instanceof c) {
                return "ReloadFailAfterTimer";
            }
            if (this instanceof C0187d) {
                return "ReloadSuccessAfterTimer";
            }
            if (this instanceof g) {
                return "TimerAfterReloadFail";
            }
            if (this instanceof h) {
                return "TimerAfterReloadSuccess";
            }
            throw new e2.s(3);
        }

        public final long b() {
            if (this instanceof f) {
                return ((f) this).d();
            }
            return 0L;
        }

        private d() {
        }
    }

    public /* synthetic */ AbstractC2406k3(kotlin.jvm.internal.f fVar) {
        this();
    }

    @Override // com.ironsource.InterfaceC2501p7
    public String a() {
        if (this instanceof a) {
            return ((a) this).e().a();
        }
        if (this instanceof c) {
            return ((c) this).f().a();
        }
        throw new e2.s(3);
    }

    public final long b() {
        if (this instanceof a) {
            return 0L;
        }
        if (this instanceof c) {
            return ((c) this).f().b();
        }
        throw new e2.s(3);
    }

    public final long c() {
        if (this instanceof a) {
            return 0L;
        }
        if (this instanceof c) {
            return ((c) this).g();
        }
        throw new e2.s(3);
    }

    private AbstractC2406k3() {
    }
}
