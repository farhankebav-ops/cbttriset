package com.ironsource;

import com.ironsource.D0;
import com.ironsource.InterfaceC2368i0;
import com.ironsource.InterfaceC2610vf;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.ironsource.o0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractC2477o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AbstractC2595v0 f9527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final W6 f9528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final V0 f9529c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private L0 f9530d;
    private InterfaceC2629x0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final xg f9531f;
    private final WeakReference<J0> g;
    private C2426l5 h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private InterfaceC2610vf.a f9532i;
    private final E5 j;

    /* JADX INFO: renamed from: com.ironsource.o0$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b implements Fg {
        public b() {
        }

        @Override // com.ironsource.Fg
        public void a(int i2, String errorReason) {
            kotlin.jvm.internal.k.e(errorReason, "errorReason");
            AbstractC2477o0.this.a(i2, errorReason);
        }

        @Override // com.ironsource.Fg
        public void b(AbstractC2662z instance) {
            kotlin.jvm.internal.k.e(instance, "instance");
            AbstractC2477o0.this.j.e().a(C2426l5.a(AbstractC2477o0.this.h), AbstractC2477o0.this.e().u());
            L0 l0J = AbstractC2477o0.this.j();
            if (l0J != null) {
                l0J.a(new C2544s0(AbstractC2477o0.this, instance.e()));
            }
            AbstractC2477o0.this.l();
        }

        @Override // com.ironsource.Fg
        public void a(AbstractC2662z instance) {
            kotlin.jvm.internal.k.e(instance, "instance");
            AbstractC2477o0.this.f().e().a().e(AbstractC2477o0.this.h());
            L0 l0J = AbstractC2477o0.this.j();
            if (l0J != null) {
                l0J.b(new C2544s0(AbstractC2477o0.this, instance.e()));
            }
            AbstractC2477o0.this.l();
        }
    }

    public AbstractC2477o0(C2459n0 adTools, AbstractC2595v0 adUnitData, J0 listener, W6 taskScheduler) {
        kotlin.jvm.internal.k.e(adTools, "adTools");
        kotlin.jvm.internal.k.e(adUnitData, "adUnitData");
        kotlin.jvm.internal.k.e(listener, "listener");
        kotlin.jvm.internal.k.e(taskScheduler, "taskScheduler");
        this.f9527a = adUnitData;
        this.f9528b = taskScheduler;
        V0 v02 = new V0(adTools, adUnitData, D0.b.MEDIATION);
        this.f9529c = v02;
        this.f9531f = new xg(v02, adUnitData, c());
        this.g = new WeakReference<>(listener);
        this.j = v02.e();
        IronLog.INTERNAL.verbose("adFormat = " + adUnitData.b().a() + ", adUnitId = " + adUnitData.b().c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        IronLog.INTERNAL.verbose(a("starting expiration scheduled task"));
        InterfaceC2610vf.a aVar = this.f9532i;
        if (aVar != null) {
            aVar.a();
        }
        long jB = this.f9529c.b(this.f9527a.b().e());
        W6 w6 = this.f9528b;
        ch chVar = new ch(this, 10);
        int i2 = o6.a.f13207d;
        this.f9532i = w6.a(chVar, r2.q.B0(jB, o6.c.f13211c));
    }

    public abstract C a();

    public final AbstractC2595v0 e() {
        return this.f9527a;
    }

    public final C2434ld g() {
        return this.f9527a.b().f();
    }

    public final String h() {
        return this.f9527a.l();
    }

    public final InterfaceC2629x0 i() {
        return this.e;
    }

    public final L0 j() {
        return this.f9530d;
    }

    public final xg k() {
        return this.f9531f;
    }

    private final b c() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(AbstractC2477o0 this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        L0 l02 = this$0.f9530d;
        if (l02 != null) {
            l02.a();
        }
    }

    public final void a(InterfaceC2629x0 interfaceC2629x0) {
        this.e = interfaceC2629x0;
    }

    public final void b(L0 l02) {
        this.f9530d = l02;
    }

    public InterfaceC2368i0 d() {
        if (this.f9531f.d()) {
            return InterfaceC2368i0.b.f8688a;
        }
        return new InterfaceC2368i0.a(null, 1, 0 == true ? 1 : 0);
    }

    public final V0 f() {
        return this.f9529c;
    }

    public void a(L0 loadListener) {
        kotlin.jvm.internal.k.e(loadListener, "loadListener");
        IronLog.INTERNAL.verbose(C2459n0.a(this.f9529c, (String) null, (String) null, 3, (Object) null));
        this.f9529c.a(b());
        this.f9530d = loadListener;
        this.j.a(this.f9527a.u());
        this.h = new C2426l5();
        this.f9531f.a(a());
    }

    public C2511q0 b() {
        return new C2511q0(this.f9527a.b());
    }

    /* JADX INFO: renamed from: com.ironsource.o0$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a implements D {
        public a() {
        }

        @Override // com.ironsource.D
        public void a(AbstractC2662z instance, IronSourceError error) {
            kotlin.jvm.internal.k.e(instance, "instance");
            kotlin.jvm.internal.k.e(error, "error");
            IronLog.INTERNAL.verbose(AbstractC2477o0.this.a(instance.q()));
            AbstractC2477o0.this.j.a().a(AbstractC2477o0.this.h(), error.getErrorCode(), error.getErrorMessage(), "");
            InterfaceC2629x0 interfaceC2629x0I = AbstractC2477o0.this.i();
            if (interfaceC2629x0I != null) {
                interfaceC2629x0I.c(error);
            }
        }

        @Override // com.ironsource.D
        public void b(AbstractC2662z instance) {
            kotlin.jvm.internal.k.e(instance, "instance");
            IronLog.INTERNAL.verbose(AbstractC2477o0.this.a(instance.q()));
            AbstractC2477o0.this.k().b(instance);
            AbstractC2477o0.this.j.a().g(AbstractC2477o0.this.h());
            AbstractC2477o0.this.f().l().b(AbstractC2477o0.this.e().b().a());
        }

        @Override // com.ironsource.D
        public void a(AbstractC2662z instance) {
            kotlin.jvm.internal.k.e(instance, "instance");
            AbstractC2477o0.this.j.a().a(AbstractC2477o0.this.h());
            J0 j02 = (J0) AbstractC2477o0.this.g.get();
            if (j02 != null) {
                j02.g();
            }
        }
    }

    public final void a(I adInstancePresenter, InterfaceC2629x0 displayListener) {
        kotlin.jvm.internal.k.e(adInstancePresenter, "adInstancePresenter");
        kotlin.jvm.internal.k.e(displayListener, "displayListener");
        this.e = displayListener;
        InterfaceC2610vf.a aVar = this.f9532i;
        if (aVar != null) {
            aVar.a();
        }
        this.f9531f.a(adInstancePresenter);
    }

    public /* synthetic */ AbstractC2477o0(C2459n0 c2459n0, AbstractC2595v0 abstractC2595v0, J0 j02, W6 w6, int i2, kotlin.jvm.internal.f fVar) {
        this(c2459n0, abstractC2595v0, j02, (i2 & 8) != 0 ? new W6(X6.a(c2459n0.a())) : w6);
    }

    public final void a(boolean z2) {
        IronLog.INTERNAL.verbose(C2459n0.a(this.f9529c, (String) null, (String) null, 3, (Object) null));
        this.f9531f.a();
        if (z2) {
            this.f9529c.e().e().a(this.f9529c.f());
        }
    }

    public final void a(int i2, String errorReason) {
        kotlin.jvm.internal.k.e(errorReason, "errorReason");
        IronLog.INTERNAL.verbose(a("errorCode = " + i2 + ", errorReason = " + errorReason));
        this.j.e().a(C2426l5.a(this.h), i2, errorReason, this.f9527a.u());
        L0 l02 = this.f9530d;
        if (l02 != null) {
            l02.a(new IronSourceError(i2, errorReason));
        }
    }

    public final String a(String str) {
        return C2459n0.a(this.f9529c, str, (String) null, 2, (Object) null);
    }
}
