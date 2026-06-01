package com.ironsource;

import android.app.Activity;
import com.ironsource.D0;
import com.ironsource.InterfaceC2505pb;
import com.ironsource.InterfaceC2565t4;
import com.ironsource.InterfaceC2610vf;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlay;
import com.unity3d.mediation.LevelPlayAdInfo;
import com.unity3d.mediation.rewarded.LevelPlayReward;

/* JADX INFO: renamed from: com.ironsource.t6, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2567t6 implements InterfaceC2445m6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Mb f10271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final V0 f10272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AbstractC2595v0 f10273c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private InterfaceC2618w6 f10274d;
    private final e6.q e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final InterfaceC2610vf f10275f;
    private final InterfaceC2565t4 g;
    private b h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private a f10276i;
    private final xg j;
    private InterfaceC2610vf.a k;
    private Long l;

    /* JADX INFO: renamed from: com.ironsource.t6$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface a {
        void a(C2567t6 c2567t6, IronSourceError ironSourceError);

        void a(C2567t6 c2567t6, LevelPlayAdInfo levelPlayAdInfo);
    }

    /* JADX INFO: renamed from: com.ironsource.t6$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface b {
        void a(C2567t6 c2567t6);

        void b(C2567t6 c2567t6, IronSourceError ironSourceError);

        void b(C2567t6 c2567t6, LevelPlayAdInfo levelPlayAdInfo);

        void c(C2567t6 c2567t6, LevelPlayAdInfo levelPlayAdInfo);
    }

    /* JADX INFO: renamed from: com.ironsource.t6$d */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class d extends kotlin.jvm.internal.j implements e6.q {
        public d(Object obj) {
            super(3, obj, C2567t6.class, "createAdInstance", "createAdInstance(Lcom/unity3d/mediation/internal/ads/controllers/adunits/adinstances/AdInstanceData;Lcom/unity3d/mediation/internal/ads/controllers/adunits/adinstances/AdInstancePayload;Lcom/unity3d/mediation/internal/ads/controllers/adunits/adinstances/listeners/FullscreenAdInstanceListener;)Lcom/unity3d/mediation/internal/ads/controllers/adunits/adinstances/FullscreenAdInstance;", 0);
        }

        @Override // e6.q
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C2427l6 invoke(A p02, G p12, InterfaceC2445m6 p2) {
            kotlin.jvm.internal.k.e(p02, "p0");
            kotlin.jvm.internal.k.e(p12, "p1");
            kotlin.jvm.internal.k.e(p2, "p2");
            return ((C2567t6) this.receiver).a(p02, p12, p2);
        }
    }

    public C2567t6(Mb mediationServices, V0 adUnitTools, AbstractC2595v0 adUnitData, InterfaceC2618w6 fullscreenListener, zg zgVar, e6.q qVar, InterfaceC2610vf taskScheduler, InterfaceC2565t4 currentTimeProvider) {
        kotlin.jvm.internal.k.e(mediationServices, "mediationServices");
        kotlin.jvm.internal.k.e(adUnitTools, "adUnitTools");
        kotlin.jvm.internal.k.e(adUnitData, "adUnitData");
        kotlin.jvm.internal.k.e(fullscreenListener, "fullscreenListener");
        kotlin.jvm.internal.k.e(taskScheduler, "taskScheduler");
        kotlin.jvm.internal.k.e(currentTimeProvider, "currentTimeProvider");
        this.f10271a = mediationServices;
        this.f10272b = adUnitTools;
        this.f10273c = adUnitData;
        this.f10274d = fullscreenListener;
        this.e = qVar;
        this.f10275f = taskScheduler;
        this.g = currentTimeProvider;
        this.j = a(zgVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(C2567t6 this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        b bVar = this$0.h;
        if (bVar != null) {
            bVar.a(this$0);
        }
        this$0.j.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String c() {
        return this.f10273c.l();
    }

    private final InterfaceC2505pb<q5.x> f() {
        return !this.j.d() ? new InterfaceC2505pb.a(new IronSourceError(509, "show called while ad unit is not ready to show")) : this.f10271a.p().a(c(), b()).d() ? new InterfaceC2505pb.a(new IronSourceError(IronSourceError.ERROR_PLACEMENT_CAPPED, a1.a.m("placement ", c(), " is capped"))) : this.f10271a.f().a(this.f10273c.b().c()).d() ? new InterfaceC2505pb.a(new IronSourceError(IronSourceError.ERROR_AD_UNIT_CAPPED, a1.a.m("adUnitId ", this.f10273c.b().c(), " is capped"))) : new InterfaceC2505pb.b(q5.x.f13520a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        InterfaceC2610vf.a aVar = this.k;
        if (aVar != null) {
            aVar.a();
        }
        long jB = this.f10272b.b(b());
        InterfaceC2610vf interfaceC2610vf = this.f10275f;
        ch chVar = new ch(this, 11);
        int i2 = o6.a.f13207d;
        this.k = interfaceC2610vf.a(chVar, r2.q.B0(jB, o6.c.f13211c));
    }

    @Override // com.ironsource.D
    public void b(AbstractC2662z instance) {
        kotlin.jvm.internal.k.e(instance, "instance");
        this.j.b(instance);
        this.f10272b.e().a().g(c());
        this.f10271a.h().b(com.unity3d.mediation.a.a(b()));
    }

    public final InterfaceC2618w6 d() {
        return this.f10274d;
    }

    public final LevelPlayAdInfo e() {
        AbstractC2662z abstractC2662zC = this.j.c();
        if (abstractC2662zC != null) {
            return abstractC2662zC.e();
        }
        return null;
    }

    private final void h() {
        String strC = c();
        if (strC.length() > 0) {
            this.f10271a.a().b(strC, b());
            O3 o3A = this.f10271a.p().a(strC, b());
            if (o3A.d()) {
                this.f10272b.e().a().b(strC, o3A.e());
            }
        }
    }

    public final void a(InterfaceC2618w6 interfaceC2618w6) {
        kotlin.jvm.internal.k.e(interfaceC2618w6, "<set-?>");
        this.f10274d = interfaceC2618w6;
    }

    public final void a(b loadListener) {
        kotlin.jvm.internal.k.e(loadListener, "loadListener");
        IronLog.INTERNAL.verbose(C2459n0.a(this.f10272b, (String) null, (String) null, 3, (Object) null));
        this.h = loadListener;
        this.l = Long.valueOf(this.g.a());
        this.f10272b.a(new C2511q0(this.f10273c.b()));
        ah ahVar = new ah(this, 4);
        this.f10272b.e().e().a(this.f10273c.u());
        this.j.a(ahVar);
    }

    /* JADX INFO: renamed from: com.ironsource.t6$c */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class c implements Fg {
        public c() {
        }

        @Override // com.ironsource.Fg
        public void a(int i2, String errorReason) {
            Long lValueOf;
            kotlin.jvm.internal.k.e(errorReason, "errorReason");
            Long l = C2567t6.this.l;
            if (l != null) {
                lValueOf = Long.valueOf(C2567t6.this.g.a() - l.longValue());
            } else {
                lValueOf = null;
            }
            C2567t6.this.f10272b.e().e().a(lValueOf != null ? lValueOf.longValue() : 0L, i2, errorReason, C2567t6.this.f10273c.u());
            b bVar = C2567t6.this.h;
            if (bVar != null) {
                bVar.b(C2567t6.this, new IronSourceError(i2, errorReason));
            }
        }

        @Override // com.ironsource.Fg
        public void b(AbstractC2662z instance) {
            Long lValueOf;
            kotlin.jvm.internal.k.e(instance, "instance");
            Long l = C2567t6.this.l;
            if (l != null) {
                lValueOf = Long.valueOf(C2567t6.this.g.a() - l.longValue());
            } else {
                lValueOf = null;
            }
            C2567t6.this.f10272b.e().e().a(lValueOf != null ? lValueOf.longValue() : 0L, C2567t6.this.f10273c.u());
            C2567t6.this.g();
            b bVar = C2567t6.this.h;
            if (bVar != null) {
                bVar.b(C2567t6.this, instance.e());
            }
        }

        @Override // com.ironsource.Fg
        public void a(AbstractC2662z instance) {
            kotlin.jvm.internal.k.e(instance, "instance");
            C2567t6.this.f10272b.e().a().e(C2567t6.this.c());
            C2567t6.this.g();
            b bVar = C2567t6.this.h;
            if (bVar != null) {
                bVar.c(C2567t6.this, instance.e());
            }
        }
    }

    @Override // com.ironsource.InterfaceC2445m6
    public void b(C2427l6 fullscreenInstance) {
        kotlin.jvm.internal.k.e(fullscreenInstance, "fullscreenInstance");
        this.f10272b.e().a().b(c());
        this.f10274d.onClosed();
    }

    private final LevelPlay.AdFormat b() {
        return this.f10273c.b().e();
    }

    public /* synthetic */ C2567t6(Mb mb, V0 v02, AbstractC2595v0 abstractC2595v0, InterfaceC2618w6 interfaceC2618w6, zg zgVar, e6.q qVar, InterfaceC2610vf interfaceC2610vf, InterfaceC2565t4 interfaceC2565t4, int i2, kotlin.jvm.internal.f fVar) {
        this(mb, v02, abstractC2595v0, interfaceC2618w6, (i2 & 16) != 0 ? null : zgVar, (i2 & 32) != 0 ? null : qVar, (i2 & 64) != 0 ? new W6(X6.a(v02.a())) : interfaceC2610vf, (i2 & 128) != 0 ? new InterfaceC2565t4.a() : interfaceC2565t4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AbstractC2662z a(C2567t6 this$0, A instanceData, G adInstancePayload) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(instanceData, "instanceData");
        kotlin.jvm.internal.k.e(adInstancePayload, "adInstancePayload");
        e6.q dVar = this$0.e;
        if (dVar == null) {
            dVar = new d(this$0);
        }
        return (AbstractC2662z) dVar.invoke(instanceData, adInstancePayload, this$0);
    }

    public final void a(Activity activity, a displayListener) {
        kotlin.jvm.internal.k.e(activity, "activity");
        kotlin.jvm.internal.k.e(displayListener, "displayListener");
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(C2459n0.a(this.f10272b, (String) null, (String) null, 3, (Object) null));
        this.f10276i = displayListener;
        this.f10272b.e().a().a(activity, c());
        InterfaceC2505pb<q5.x> interfaceC2505pbF = f();
        if (interfaceC2505pbF instanceof InterfaceC2505pb.a) {
            IronSourceError ironSourceErrorB = ((InterfaceC2505pb.a) interfaceC2505pbF).b();
            ironLog.verbose(C2459n0.a(this.f10272b, ironSourceErrorB.getErrorMessage(), (String) null, 2, (Object) null));
            this.f10272b.e().a().a(c(), ironSourceErrorB.getErrorCode(), ironSourceErrorB.getErrorMessage(), "");
            displayListener.a(this, ironSourceErrorB);
            return;
        }
        InterfaceC2610vf.a aVar = this.k;
        if (aVar != null) {
            aVar.a();
        }
        this.j.a(new C2465n6(activity));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C2427l6 a(A a8, G g, InterfaceC2445m6 interfaceC2445m6) {
        return new C2427l6(new V0(this.f10272b, D0.b.PROVIDER), a8, g, interfaceC2445m6);
    }

    private final xg a(zg zgVar) {
        Fg fgA = a();
        if (zgVar != null) {
            return zgVar.a(fgA);
        }
        return new xg(this.f10272b, this.f10273c, fgA);
    }

    private final Fg a() {
        return new c();
    }

    @Override // com.ironsource.InterfaceC2445m6
    public void a(C2427l6 fullscreenInstance) {
        kotlin.jvm.internal.k.e(fullscreenInstance, "fullscreenInstance");
        a aVar = this.f10276i;
        if (aVar != null) {
            aVar.a(this, fullscreenInstance.e());
        }
        h();
        this.f10271a.l().b(this.f10273c.b().c());
    }

    @Override // com.ironsource.D
    public void a(AbstractC2662z instance, IronSourceError error) {
        kotlin.jvm.internal.k.e(instance, "instance");
        kotlin.jvm.internal.k.e(error, "error");
        IronLog.INTERNAL.verbose(C2459n0.a(this.f10272b, error.toString(), (String) null, 2, (Object) null));
        this.f10272b.e().a().a(c(), error.getErrorCode(), error.getErrorMessage(), "");
        a aVar = this.f10276i;
        if (aVar != null) {
            aVar.a(this, error);
        }
    }

    @Override // com.ironsource.InterfaceC2445m6
    public void a(C2427l6 fullscreenInstance, LevelPlayReward reward) {
        kotlin.jvm.internal.k.e(fullscreenInstance, "fullscreenInstance");
        kotlin.jvm.internal.k.e(reward, "reward");
        IronLog.INTERNAL.verbose(C2459n0.a(this.f10272b, fullscreenInstance.q(), (String) null, 2, (Object) null));
        this.f10274d.a(reward);
    }

    @Override // com.ironsource.D
    public void a(AbstractC2662z instance) {
        kotlin.jvm.internal.k.e(instance, "instance");
        this.f10272b.e().a().a(c());
        this.f10274d.g();
    }
}
