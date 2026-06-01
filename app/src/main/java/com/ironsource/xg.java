package com.ironsource;

import com.ironsource.F;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class xg implements E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final V0 f10531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AbstractC2595v0 f10532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Fg f10533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Ag f10534d;
    private F e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Hg f10535f;
    private final List<AbstractC2662z> g;
    private AbstractC2662z h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f10536i;

    public xg(V0 adTools, AbstractC2595v0 adUnitData, Fg listener) {
        kotlin.jvm.internal.k.e(adTools, "adTools");
        kotlin.jvm.internal.k.e(adUnitData, "adUnitData");
        kotlin.jvm.internal.k.e(listener, "listener");
        this.f10531a = adTools;
        this.f10532b = adUnitData;
        this.f10533c = listener;
        this.f10534d = Ag.f6345d.a(adTools, adUnitData);
        this.g = new ArrayList();
    }

    private final boolean e() {
        return this.h != null;
    }

    private final void f() {
        F f4 = this.e;
        F.b bVarD = f4 != null ? f4.d() : null;
        if (bVarD == null || bVarD.e()) {
            this.f10533c.a(509, "Mediation No fill");
            return;
        }
        if (!bVarD.f()) {
            Iterator<AbstractC2662z> it = bVarD.a().iterator();
            while (it.hasNext()) {
                it.next().a(this);
            }
        } else {
            Hg hg = this.f10535f;
            if (hg != null) {
                hg.a();
            }
        }
    }

    public final AbstractC2662z c() {
        F.c cVarC;
        F f4 = this.e;
        if (f4 == null || (cVarC = f4.c()) == null) {
            return null;
        }
        return cVarC.c();
    }

    public final boolean d() {
        Iterator<AbstractC2662z> it = this.g.iterator();
        while (it.hasNext()) {
            if (it.next().z()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a implements Bg {
        public a() {
        }

        @Override // com.ironsource.Bg
        public void a(Cg waterfallInstances) {
            kotlin.jvm.internal.k.e(waterfallInstances, "waterfallInstances");
            if (xg.this.f10536i) {
                return;
            }
            xg.this.a(waterfallInstances);
        }

        @Override // com.ironsource.Bg
        public void a(int i2, String errorReason) {
            kotlin.jvm.internal.k.e(errorReason, "errorReason");
            if (xg.this.f10536i) {
                return;
            }
            xg.this.f10533c.a(i2, errorReason);
        }
    }

    private final void c(AbstractC2662z abstractC2662z) {
        d(abstractC2662z);
        b();
    }

    public final void b() {
        IronLog.INTERNAL.verbose(C2459n0.a(this.f10531a, "dispose", (String) null, 2, (Object) null));
        Iterator<T> it = this.g.iterator();
        while (it.hasNext()) {
            ((AbstractC2662z) it.next()).c();
        }
        this.g.clear();
        this.f10531a.e().h().a();
    }

    private final void d(AbstractC2662z abstractC2662z) {
        this.h = abstractC2662z;
        this.g.remove(abstractC2662z);
    }

    public final void a(C adInstanceFactory) {
        kotlin.jvm.internal.k.e(adInstanceFactory, "adInstanceFactory");
        this.f10534d.a(adInstanceFactory, new a());
    }

    public final void a(I adInstancePresenter) {
        AbstractC2662z abstractC2662zC;
        kotlin.jvm.internal.k.e(adInstancePresenter, "adInstancePresenter");
        F f4 = this.e;
        F.c cVarC = f4 != null ? f4.c() : null;
        if (cVarC == null || (abstractC2662zC = cVarC.c()) == null) {
            return;
        }
        c(abstractC2662zC);
        Hg hg = this.f10535f;
        if (hg != null) {
            hg.a(cVarC.c(), cVarC.d());
        }
        cVarC.c().a(adInstancePresenter);
    }

    public final void b(AbstractC2662z instance) {
        kotlin.jvm.internal.k.e(instance, "instance");
        Hg hg = this.f10535f;
        if (hg != null) {
            hg.a(instance, this.f10532b.l(), this.f10532b.o());
        }
    }

    public final void a() {
        this.f10536i = true;
        AbstractC2662z abstractC2662z = this.h;
        if (abstractC2662z != null) {
            abstractC2662z.b();
        }
    }

    @Override // com.ironsource.E
    public void a(AbstractC2662z instance) {
        kotlin.jvm.internal.k.e(instance, "instance");
        if (!this.f10536i && !e()) {
            Hg hg = this.f10535f;
            if (hg != null) {
                hg.a(instance);
            }
            this.g.add(instance);
            if (this.g.size() == 1) {
                Hg hg2 = this.f10535f;
                if (hg2 != null) {
                    hg2.b(instance);
                }
                this.f10533c.b(instance);
                return;
            }
            F f4 = this.e;
            if (f4 == null || !f4.a(instance)) {
                return;
            }
            this.f10533c.a(instance);
            return;
        }
        instance.c();
    }

    @Override // com.ironsource.E
    public void a(IronSourceError error, AbstractC2662z instance) {
        kotlin.jvm.internal.k.e(error, "error");
        kotlin.jvm.internal.k.e(instance, "instance");
        if (this.f10536i) {
            return;
        }
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Cg cg) {
        F fA = F.f6730c.a(this.f10532b, cg);
        this.e = fA;
        this.f10535f = Hg.f6951c.a(this.f10531a, this.f10532b, this.f10534d.a(), cg, fA);
        f();
    }
}
