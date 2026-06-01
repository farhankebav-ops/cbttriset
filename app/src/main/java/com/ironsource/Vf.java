package com.ironsource;

import com.ironsource.Xf;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface Vf {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface a {
        void a();
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f7748a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f7749b;

        public final long a() {
            return this.f7749b;
        }

        public final long b() {
            return this.f7748a;
        }

        public final void a(long j) {
            this.f7749b = j;
        }

        public final void b(long j) {
            this.f7748a = j;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface c {
        Vf a(b bVar);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class d implements c {
        @Override // com.ironsource.Vf.c
        public Vf a(b timerConfig) {
            kotlin.jvm.internal.k.e(timerConfig, "timerConfig");
            return new e(new Xf(timerConfig.b()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class e implements Vf {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Xf f7750a;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class a implements Xf.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f7751a;

            public a(a aVar) {
                this.f7751a = aVar;
            }

            @Override // com.ironsource.Xf.a
            public void a() {
                this.f7751a.a();
            }
        }

        public e(Xf timer) {
            kotlin.jvm.internal.k.e(timer, "timer");
            this.f7750a = timer;
        }

        @Override // com.ironsource.Vf
        public void a(a callback) {
            kotlin.jvm.internal.k.e(callback, "callback");
            this.f7750a.a((Xf.a) new a(callback));
        }

        @Override // com.ironsource.Vf
        public void cancel() {
            this.f7750a.e();
        }
    }

    void a(a aVar);

    void cancel();
}
