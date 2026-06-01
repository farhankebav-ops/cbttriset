package com.ironsource;

import com.ironsource.InterfaceC2249b7;
import com.ironsource.InterfaceC2303e7;
import com.ironsource.Vf;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: com.ironsource.k4, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface InterfaceC2407k4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f8831a = c.f8838a;

    /* JADX INFO: renamed from: com.ironsource.k4$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a implements InterfaceC2407k4 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final InterfaceC2231a7 f8832b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Vf f8833c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final AtomicBoolean f8834d;

        /* JADX INFO: renamed from: com.ironsource.k4$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class C0188a implements Vf.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ d f8835a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ a f8836b;

            public C0188a(d dVar, a aVar) {
                this.f8835a = dVar;
                this.f8836b = aVar;
            }

            @Override // com.ironsource.Vf.a
            public void a() {
                this.f8835a.a(new InterfaceC2303e7.a(new InterfaceC2249b7.a(this.f8836b.f8832b.b())));
                this.f8836b.f8834d.set(false);
            }
        }

        public a(InterfaceC2231a7 config, Vf timer) {
            kotlin.jvm.internal.k.e(config, "config");
            kotlin.jvm.internal.k.e(timer, "timer");
            this.f8832b = config;
            this.f8833c = timer;
            this.f8834d = new AtomicBoolean(false);
        }

        @Override // com.ironsource.InterfaceC2407k4
        public synchronized void a(d callback) {
            kotlin.jvm.internal.k.e(callback, "callback");
            if (this.f8834d.compareAndSet(false, true)) {
                this.f8833c.a(new C0188a(callback, this));
            }
        }

        @Override // com.ironsource.InterfaceC2407k4
        public synchronized void a() {
            this.f8833c.cancel();
            this.f8834d.set(false);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.k4$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b implements InterfaceC2407k4 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f8837b = new b();

        private b() {
        }

        @Override // com.ironsource.InterfaceC2407k4
        public void a() {
        }

        @Override // com.ironsource.InterfaceC2407k4
        public void a(d callback) {
            kotlin.jvm.internal.k.e(callback, "callback");
        }
    }

    /* JADX INFO: renamed from: com.ironsource.k4$d */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface d {
        void a(InterfaceC2303e7 interfaceC2303e7);
    }

    void a();

    void a(d dVar);

    /* JADX INFO: renamed from: com.ironsource.k4$c */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ c f8838a = new c();

        private c() {
        }

        public final InterfaceC2407k4 a(C2267c7 featureFlag) {
            kotlin.jvm.internal.k.e(featureFlag, "featureFlag");
            if (!featureFlag.b()) {
                return b.f8837b;
            }
            Z6 z62 = new Z6(featureFlag);
            Vf.b bVar = new Vf.b();
            bVar.b(z62.a());
            bVar.a(z62.a());
            return new a(z62, new Vf.d().a(bVar));
        }

        public final InterfaceC2407k4 a() {
            return b.f8837b;
        }
    }
}
