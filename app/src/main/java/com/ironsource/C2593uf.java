package com.ironsource;

import android.os.Handler;

/* JADX INFO: renamed from: com.ironsource.uf, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2593uf implements InterfaceC2327fd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f10401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f10402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f10403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f10404d;
    private long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final b f10405f;

    /* JADX INFO: renamed from: com.ironsource.uf$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f10406a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f10407b;

        public a(long j, long j3) {
            this.f10406a = j;
            this.f10407b = j3;
        }

        public final long a() {
            return this.f10406a;
        }

        public final long b() {
            return this.f10407b;
        }

        public final long c() {
            return this.f10406a;
        }

        public final long d() {
            return this.f10407b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f10406a == aVar.f10406a && this.f10407b == aVar.f10407b;
        }

        public int hashCode() {
            long j = this.f10406a;
            int i2 = ((int) (j ^ (j >>> 32))) * 31;
            long j3 = this.f10407b;
            return i2 + ((int) ((j3 >>> 32) ^ j3));
        }

        public String toString() {
            long j = this.f10406a;
            return a1.a.p(androidx.camera.core.processing.util.a.t("Status(remainingTime=", j, ", timePassed="), this.f10407b, ")");
        }

        public final a a(long j, long j3) {
            return new a(j, j3);
        }

        public static /* synthetic */ a a(a aVar, long j, long j3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = aVar.f10406a;
            }
            if ((i2 & 2) != 0) {
                j3 = aVar.f10407b;
            }
            return aVar.a(j, j3);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.uf$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b extends AbstractRunnableC2382ie {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Runnable f10408b;

        public b(Runnable runnable) {
            this.f10408b = runnable;
        }

        @Override // com.ironsource.AbstractRunnableC2382ie
        public void a() {
            this.f10408b.run();
        }
    }

    public C2593uf(Handler handler, Runnable task, long j) {
        kotlin.jvm.internal.k.e(handler, "handler");
        kotlin.jvm.internal.k.e(task, "task");
        this.f10401a = handler;
        this.f10402b = j;
        this.f10405f = new b(task);
        this.e = c();
        b();
    }

    private final long c() {
        return System.currentTimeMillis();
    }

    private final long d() {
        return this.f10402b - this.f10403c;
    }

    @Override // com.ironsource.InterfaceC2327fd
    public a a() {
        if (!e()) {
            long jC = c();
            this.e = jC;
            this.f10403c = (jC - this.f10404d) + this.f10403c;
            this.f10401a.removeCallbacks(this.f10405f);
        }
        return new a(d(), this.f10403c);
    }

    @Override // com.ironsource.InterfaceC2327fd
    public a b() {
        if (e()) {
            this.f10404d = c();
            this.e = 0L;
            this.f10401a.postDelayed(this.f10405f, d());
        }
        return new a(d(), this.f10403c);
    }

    public final boolean e() {
        return this.e > 0;
    }
}
