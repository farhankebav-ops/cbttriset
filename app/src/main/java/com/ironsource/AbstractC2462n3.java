package com.ironsource;

import android.app.Activity;
import com.ironsource.AbstractC2480o3;
import com.ironsource.AbstractC2497p3;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener;
import com.ironsource.mediationsdk.h;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.ironsource.n3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractC2462n3<Smash extends AbstractC2480o3<?>, Listener extends AdapterAdInteractionListener> extends AbstractC2497p3<Smash, Listener> implements I0 {

    /* JADX INFO: renamed from: com.ironsource.n3$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a extends AbstractRunnableC2382ie {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f9482b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ C2434ld f9483c;

        public a(Activity activity, C2434ld c2434ld) {
            this.f9482b = activity;
            this.f9483c = c2434ld;
        }

        @Override // com.ironsource.AbstractRunnableC2382ie
        public void a() {
            AbstractC2462n3.this.b(this.f9482b, this.f9483c);
        }
    }

    public AbstractC2462n3(U u2, C2469na c2469na, C2270ca c2270ca) {
        super(u2, c2469na, c2270ca);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(Activity activity, C2434ld c2434ld) {
        AbstractC2480o3 abstractC2480o3;
        IronSourceError ironSourceError;
        IronLog.INTERNAL.verbose(b("state = " + this.p));
        synchronized (this.f9604x) {
            try {
                this.f9594i = c2434ld;
                this.f9599s.f6420i.a(activity, n());
                AbstractC2497p3.f fVar = this.p;
                AbstractC2497p3.f fVar2 = AbstractC2497p3.f.SHOWING;
                abstractC2480o3 = null;
                if (fVar == fVar2) {
                    ironSourceError = new IronSourceError(C2663z0.g(this.f9596o.b()), "can't show ad while an ad is already showing");
                } else if (fVar != AbstractC2497p3.f.READY_TO_SHOW) {
                    ironSourceError = new IronSourceError(509, "show called while no ads are available");
                } else if (c2434ld == null) {
                    ironSourceError = new IronSourceError(C2663z0.b(this.f9596o.b()), "empty default placement");
                } else if (this.E.c(ContextProvider.getInstance().getApplicationContext(), c2434ld, this.f9596o.b())) {
                    ironSourceError = new IronSourceError(C2663z0.f(this.f9596o.b()), "placement " + c2434ld.c() + " is capped");
                } else {
                    ironSourceError = null;
                }
                if (ironSourceError != null) {
                    IronLog.API.error(b(ironSourceError.getErrorMessage()));
                    a(ironSourceError, "");
                } else {
                    List listB = this.f9589a.b();
                    Ig ig = new Ig(this.f9596o);
                    abstractC2480o3 = (AbstractC2480o3) ig.c(listB);
                    a(abstractC2480o3, (List<AbstractC2480o3>) ig.b(listB));
                    if (abstractC2480o3 != null) {
                        a(fVar2);
                        i(abstractC2480o3);
                    } else {
                        a(ErrorBuilder.buildNoAdsToShowError(this.f9596o.b().toString()), a(listB));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (abstractC2480o3 != null) {
            a(activity, (AbstractC2480o3<?>) abstractC2480o3, this.f9594i);
        }
    }

    public void a(Activity activity, C2434ld c2434ld) {
        if (e()) {
            a(new a(activity, c2434ld));
        } else {
            b(activity, c2434ld);
        }
    }

    @Override // com.ironsource.I0
    public void c(AbstractC2480o3<?> abstractC2480o3) {
        IronLog.INTERNAL.verbose(b(abstractC2480o3.k()));
        this.f9600t.a();
    }

    @Override // com.ironsource.I0
    public void d(AbstractC2480o3<?> abstractC2480o3) {
        IronLog.INTERNAL.verbose(b(abstractC2480o3.k()));
        this.f9600t.b();
    }

    @Override // com.ironsource.I0
    public String f() {
        StringBuilder sb = new StringBuilder();
        if (this.p == AbstractC2497p3.f.READY_TO_SHOW) {
            for (AbstractC2480o3 abstractC2480o3 : this.f9589a.b()) {
                if (abstractC2480o3.y()) {
                    sb.append(abstractC2480o3.c());
                    sb.append(";");
                }
            }
        }
        return sb.toString();
    }

    @Override // com.ironsource.AbstractC2497p3
    public boolean u() {
        if (!x()) {
            return false;
        }
        if (this.j && !IronSourceUtils.g(ContextProvider.getInstance().getApplicationContext())) {
            return false;
        }
        Iterator it = this.f9589a.b().iterator();
        while (it.hasNext()) {
            if (((AbstractC2480o3) it.next()).B()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.ironsource.AbstractC2497p3
    public boolean v() {
        return false;
    }

    public AbstractC2462n3(L7 l72, K7 k72, U u2, C2469na c2469na, C2270ca c2270ca) {
        super(l72, k72, u2, c2469na, c2270ca);
    }

    private void a(Smash smash, List<Smash> list) {
        for (Smash smash2 : list) {
            if (smash != null && smash2 == smash) {
                smash.b(true);
                return;
            }
            smash2.b(false);
            IronLog.INTERNAL.verbose(b(smash2.k() + " - not ready to show"));
        }
    }

    private String a(List<Smash> list) {
        StringBuilder sb = new StringBuilder();
        for (Smash smash : list) {
            if (smash.e() != null) {
                sb.append(smash.c());
                sb.append(":");
                sb.append(smash.e());
                sb.append(",");
            }
        }
        return sb.toString();
    }

    private void a(Activity activity, AbstractC2480o3<?> abstractC2480o3, C2434ld c2434ld) {
        if (this.f9596o.h().e()) {
            this.f9598r.a();
        }
        abstractC2480o3.a(activity, c2434ld);
    }

    private void a(IronSourceError ironSourceError, String str) {
        a(ironSourceError, (AbstractC2480o3<?>) null, str);
    }

    private void a(IronSourceError ironSourceError, AbstractC2480o3<?> abstractC2480o3, String str) {
        this.f9599s.f6420i.a(n(), ironSourceError.getErrorCode(), ironSourceError.getErrorMessage(), str);
        this.f9597q.g();
        this.f9600t.a(ironSourceError, abstractC2480o3 != null ? abstractC2480o3.f() : null);
        if (this.f9596o.h().e()) {
            b(false);
        }
    }

    @Override // com.ironsource.I0
    public void a(IronSourceError ironSourceError, AbstractC2480o3<?> abstractC2480o3) {
        IronLog.INTERNAL.verbose(b(abstractC2480o3.k() + " - error = " + ironSourceError));
        this.f9590b.put(abstractC2480o3.c(), h.a.ISAuctionPerformanceFailedToShow);
        a(AbstractC2497p3.f.READY_TO_LOAD);
        a(ironSourceError, abstractC2480o3, "");
    }

    @Override // com.ironsource.I0
    public void a(AbstractC2480o3<?> abstractC2480o3) {
        IronLog.INTERNAL.verbose(b(abstractC2480o3.k()));
        if (this.p == AbstractC2497p3.f.SHOWING) {
            a(AbstractC2497p3.f.READY_TO_LOAD);
        }
        this.f9597q.f();
        this.f9600t.a(abstractC2480o3.f());
    }

    @Override // com.ironsource.I0
    public void b(AbstractC2480o3<?> abstractC2480o3) {
        IronLog.INTERNAL.verbose(b(abstractC2480o3.k()));
        this.f9600t.g(abstractC2480o3.f());
    }
}
