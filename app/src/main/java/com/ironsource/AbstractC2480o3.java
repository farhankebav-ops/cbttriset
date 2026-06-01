package com.ironsource;

import android.app.Activity;
import com.ironsource.AbstractC2547s3;
import com.ironsource.I0;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAdFullScreenInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: renamed from: com.ironsource.o3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractC2480o3<Listener extends I0> extends AbstractC2547s3<Listener> implements AdapterAdInteractionListener {

    /* JADX INFO: renamed from: com.ironsource.o3$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a extends AbstractRunnableC2382ie {
        public a() {
        }

        @Override // com.ironsource.AbstractRunnableC2382ie
        public void a() {
            AbstractC2480o3.this.P();
        }
    }

    /* JADX INFO: renamed from: com.ironsource.o3$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class b extends AbstractRunnableC2382ie {
        public b() {
        }

        @Override // com.ironsource.AbstractRunnableC2382ie
        public void a() {
            AbstractC2480o3.this.S();
        }
    }

    /* JADX INFO: renamed from: com.ironsource.o3$c */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class c extends AbstractRunnableC2382ie {
        public c() {
        }

        @Override // com.ironsource.AbstractRunnableC2382ie
        public void a() {
            AbstractC2480o3.this.Q();
        }
    }

    /* JADX INFO: renamed from: com.ironsource.o3$d */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class d extends AbstractRunnableC2382ie {
        public d() {
        }

        @Override // com.ironsource.AbstractRunnableC2382ie
        public void a() {
            AbstractC2480o3.this.T();
        }
    }

    /* JADX INFO: renamed from: com.ironsource.o3$e */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class e extends AbstractRunnableC2382ie {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f9541b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f9542c;

        public e(int i2, String str) {
            this.f9541b = i2;
            this.f9542c = str;
        }

        @Override // com.ironsource.AbstractRunnableC2382ie
        public void a() {
            AbstractC2480o3.this.b(this.f9541b, this.f9542c);
        }
    }

    public AbstractC2480o3(InterfaceC2591ud interfaceC2591ud, C2421l0 c2421l0, BaseAdAdapter<?, ?> baseAdAdapter, C2243b1 c2243b1, C2461n2 c2461n2, Listener listener) {
        super(interfaceC2591ud, c2421l0, baseAdAdapter, c2243b1, c2461n2, listener);
    }

    @Override // com.ironsource.AbstractC2547s3
    public boolean B() {
        Object obj;
        if (this.k == null || !y()) {
            return false;
        }
        try {
            obj = this.f9793c;
        } catch (Throwable th) {
            C2531r4.d().a(th);
            String str = "isReadyToShow - exception = " + th.getMessage() + " - state = " + this.e;
            IronLog.INTERNAL.error(a(str));
            D0 d0 = this.f9794d;
            if (d0 != null) {
                d0.j.g(str);
            }
        }
        if (obj instanceof AdapterAdFullScreenInterface) {
            return ((AdapterAdFullScreenInterface) obj).isAdAvailable(this.k);
        }
        IronLog.INTERNAL.error(a("isReadyToShow - adapter not instance of AdapterAdFullScreenInterface"));
        D0 d02 = this.f9794d;
        if (d02 != null) {
            d02.j.g("isReadyToShow - adapter not instance of AdapterAdFullScreenInterface");
        }
        return false;
    }

    public void a(Activity activity, C2434ld c2434ld) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a("placementName = " + c2434ld.c()));
        try {
            this.g = c2434ld;
            a(AbstractC2547s3.h.SHOWING);
            this.f9794d.f6420i.a(activity, j());
            Object obj = this.f9793c;
            if (obj instanceof AdapterAdFullScreenInterface) {
                ((AdapterAdFullScreenInterface) obj).showAd(this.k, activity, this);
                return;
            }
            ironLog.error(a("showAd - adapter not instance of AdapterAdFullScreenInterface"));
            D0 d0 = this.f9794d;
            if (d0 != null) {
                d0.j.g("showAd - adapter not instance of AdapterAdFullScreenInterface");
            }
        } catch (Throwable th) {
            C2531r4.d().a(th);
            a(AbstractC2547s3.h.FAILED);
            String str = "showAd - exception = " + th.getMessage() + " - state = " + this.e;
            IronLog.INTERNAL.error(a(str));
            D0 d02 = this.f9794d;
            if (d02 != null) {
                d02.j.g(str);
            }
            onAdShowFailed(C2663z0.h(this.f9791a.a()), str);
        }
    }

    public void b(boolean z2) {
        D0 d0 = this.f9794d;
        if (d0 != null) {
            d0.f6420i.a(z2);
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public final /* synthetic */ void onAdClosed(Map map) {
        b3.a.a(this, map);
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public final /* synthetic */ void onAdEnded(Map map) {
        b3.a.b(this, map);
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public void onAdShowFailed(int i2, String str) {
        if (u().e()) {
            u().a(new e(i2, str));
        } else {
            b(i2, str);
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public final /* synthetic */ void onAdStarted(Map map) {
        b3.a.c(this, map);
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public final /* synthetic */ void onAdVisible(Map map) {
        b3.a.d(this, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(d());
        synchronized (this.f9799q) {
            try {
                if (this.e == AbstractC2547s3.h.SHOWING) {
                    a(AbstractC2547s3.h.NONE);
                    if (this.f9794d != null) {
                        String string = "";
                        if (this.f9791a.a() == IronSource.a.REWARDED_VIDEO) {
                            String strF = ((I0) this.f9792b).f();
                            StringBuilder sb = new StringBuilder("otherInstanceAvailable = ");
                            sb.append(strF.length() > 0 ? "true|".concat(strF) : "false");
                            string = sb.toString();
                        }
                        this.f9794d.f6420i.a(j(), string);
                    }
                    ((I0) this.f9792b).a((AbstractC2480o3<?>) this);
                    return;
                }
                ironLog.error("unexpected ad closed for " + k() + " - state = " + this.e);
                D0 d0 = this.f9794d;
                if (d0 != null) {
                    d0.j.l("unexpected ad closed - state = " + this.e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        IronLog.INTERNAL.verbose(d());
        D0 d0 = this.f9794d;
        if (d0 != null) {
            d0.f6420i.d(j());
        }
        ((I0) this.f9792b).c(this);
    }

    private void R() {
        IronLog.INTERNAL.verbose(d());
        ((I0) this.f9792b).b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        IronLog.INTERNAL.verbose(d());
        D0 d0 = this.f9794d;
        if (d0 != null) {
            d0.f6420i.i(j());
        }
        ((I0) this.f9792b).d((AbstractC2480o3<?>) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        IronLog.INTERNAL.verbose(d());
        D0 d0 = this.f9794d;
        if (d0 != null) {
            d0.f6420i.k(j());
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdClosed() {
        if (u().e()) {
            u().a(new a());
        } else {
            P();
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdEnded() {
        if (u().e()) {
            u().a(new c());
        } else {
            Q();
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdStarted() {
        if (u().e()) {
            u().a(new b());
        } else {
            S();
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdVisible() {
        if (u().e()) {
            u().a(new d());
        } else {
            T();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a("error = " + i2 + ", " + str));
        AbstractC2547s3.h hVar = this.e;
        if (hVar == AbstractC2547s3.h.SHOWING) {
            a(AbstractC2547s3.h.FAILED);
            D0 d0 = this.f9794d;
            if (d0 != null) {
                d0.f6420i.a(j(), i2, str, "");
            }
            ((I0) this.f9792b).a(new IronSourceError(i2, str), (AbstractC2480o3<?>) this);
            return;
        }
        String strA = a(hVar, i2, str);
        ironLog.error(a(strA));
        D0 d02 = this.f9794d;
        if (d02 != null) {
            d02.j.t(strA);
        }
    }

    public static String a(AbstractC2547s3.h hVar, int i2, String str) {
        Locale locale = Locale.ENGLISH;
        return "unexpected show failed, state - " + hVar + ", error - " + i2 + " " + str;
    }
}
