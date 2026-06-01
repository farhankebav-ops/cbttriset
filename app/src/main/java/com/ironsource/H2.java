package com.ironsource;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.AbstractC2497p3;
import com.ironsource.N0;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.AdapterUtils;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.LoadWhileShowSupportState;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class H2 extends AbstractC2497p3<L2, AdapterAdViewListener> implements InterfaceC2527r0, G2 {
    private C2245b3 K;
    private boolean L;
    private com.ironsource.mediationsdk.q M;
    private View N;
    private AbstractC2547s3<?> O;
    private FrameLayout.LayoutParams P;
    private final AtomicBoolean Q;
    private final AtomicBoolean R;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a implements E3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractC2547s3 f6898a;

        public a(AbstractC2547s3 abstractC2547s3) {
            this.f6898a = abstractC2547s3;
        }

        @Override // com.ironsource.E3
        public void a() {
            ((L2) this.f6898a).Q();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class b implements E3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractC2547s3 f6900a;

        public b(AbstractC2547s3 abstractC2547s3) {
            this.f6900a = abstractC2547s3;
        }

        @Override // com.ironsource.E3
        public void a() {
            ((L2) this.f6900a).Q();
            H2 h22 = H2.this;
            h22.f9599s.f6420i.j(h22.n());
            H2.this.Q.set(false);
            H2.this.W();
            IronLog.INTERNAL.verbose("start binding timer after impression, expected interval = " + H2.this.f9596o.h().b() + ", current timestamp = " + System.currentTimeMillis());
            H2.this.O().h();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6902a;

        static {
            int[] iArr = new int[N0.a.values().length];
            f6902a = iArr;
            try {
                iArr[N0.a.MANUAL_WITH_AUTOMATIC_RELOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6902a[N0.a.MANUAL_WITH_LOAD_ON_SHOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public H2(List<NetworkSettings> list, V2 v2, String str, C2469na c2469na, C2270ca c2270ca) {
        super(new I2(str, list, v2), c2469na, c2270ca);
        this.L = false;
        this.Q = new AtomicBoolean(true);
        this.R = new AtomicBoolean(false);
        this.K = N();
    }

    private C2353h3 P() {
        return (C2353h3) this.f9597q;
    }

    private ISBannerSize Q() {
        com.ironsource.mediationsdk.q qVar = this.M;
        if (qVar == null || qVar.getSize() == null) {
            return null;
        }
        return this.M.getSize().isSmart() ? AdapterUtils.isLargeScreen(ContextProvider.getInstance().getApplicationContext()) ? com.ironsource.mediationsdk.l.a() : ISBannerSize.BANNER : this.M.getSize();
    }

    private boolean S() {
        IronLog.INTERNAL.verbose(b(this.N + ", " + this.P + ", " + this.O));
        return (this.N == null || this.P == null || this.O == null) ? false : true;
    }

    private void U() {
        int i2 = c.f6902a[this.f9597q.b().a().ordinal()];
        if (i2 == 1) {
            P().k();
        } else {
            if (i2 != 2) {
                return;
            }
            P().r();
        }
    }

    private void V() {
        int i2 = c.f6902a[this.f9597q.b().a().ordinal()];
        if (i2 == 1) {
            P().k();
        } else {
            if (i2 != 2) {
                return;
            }
            P().q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        this.O = null;
        this.N = null;
        this.P = null;
    }

    public boolean R() {
        if (!this.M.isShown()) {
            IronLog.INTERNAL.verbose("banner or one of its parents are INVISIBLE or GONE");
            return false;
        }
        if (!this.M.hasWindowFocus()) {
            IronLog.INTERNAL.verbose("banner has no window focus");
            return false;
        }
        boolean globalVisibleRect = this.M.getGlobalVisibleRect(new Rect());
        IronLog.INTERNAL.verbose("visible = " + globalVisibleRect);
        return globalVisibleRect;
    }

    public void T() {
        com.ironsource.mediationsdk.q qVar = this.M;
        if (qVar != null) {
            a(qVar);
        }
    }

    @Override // com.ironsource.AbstractC2497p3
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public L2 a(NetworkSettings networkSettings, BaseAdAdapter<?, AdapterAdViewListener> baseAdAdapter, int i2, String str, C2461n2 c2461n2) {
        return new L2(this, new C2421l0(IronSource.a.BANNER, this.f9596o.o(), i2, this.g, str, this.e, this.f9593f, networkSettings, this.f9596o.n()), baseAdAdapter, this.M, this.f9594i, v(), c2461n2, this);
    }

    @Override // com.ironsource.G2
    public void c() {
        if (!R()) {
            IronLog.INTERNAL.verbose("banner is not visible, binding skipped");
            O().h();
            this.f9599s.f6419f.b(IronSourceError.ERROR_BN_BINDING_SKIP_INVISIBLE);
        } else {
            if (!S()) {
                IronLog.INTERNAL.verbose("Cannot bind banner view after interval, the next ad is not ready yet");
                this.Q.set(true);
                return;
            }
            IronLog.INTERNAL.verbose("done binding timer, binding view now, current timestamp = " + System.currentTimeMillis());
            c(this.O, this.N, this.P);
        }
    }

    @Override // com.ironsource.G2
    public void d() {
        if (!R()) {
            IronLog.INTERNAL.verbose("banner is not visible, starting the impression timeout timer again");
            O().e();
        } else if (this.R.compareAndSet(false, true)) {
            IronLog.INTERNAL.verbose("banner impression timeout reached, reloading banner manually");
            U();
            this.f9599s.j.b("banner impression timeout reached, reloading banner manually");
        }
    }

    @Override // com.ironsource.T0
    public void f(AbstractC2547s3<?> abstractC2547s3) {
        IronLog.INTERNAL.verbose(b(abstractC2547s3.k()));
        this.f9600t.f(abstractC2547s3.f());
    }

    @Override // com.ironsource.AbstractC2497p3
    public void g(AbstractC2547s3<?> abstractC2547s3) {
    }

    @Override // com.ironsource.AbstractC2497p3
    public void h(AbstractC2547s3<?> abstractC2547s3) {
    }

    @Override // com.ironsource.AbstractC2497p3
    public String l() {
        return "BN";
    }

    @Override // com.ironsource.AbstractC2497p3
    public String o() {
        return IronSourceConstants.OPW_BN_MANAGER_NAME;
    }

    @Override // com.ironsource.AbstractC2497p3
    public boolean v() {
        return this.L;
    }

    private void M() {
        int i2 = c.f6902a[this.f9597q.b().a().ordinal()];
        if (i2 == 1) {
            P().a();
        } else {
            if (i2 != 2) {
                return;
            }
            P().l();
            P().m();
            O().a();
            O().b();
        }
    }

    private C2245b3 N() {
        return new C2245b3(this.f9596o.h(), this.f9596o.g(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C2245b3 O() {
        return this.K;
    }

    @Override // com.ironsource.AbstractC2497p3
    public void a(Context context, com.ironsource.mediationsdk.i iVar, S1 s12) {
        if (this.f9591c == null) {
            IronLog.INTERNAL.error(b("mAuctionHandler is null"));
        } else {
            iVar.a(Q());
            this.f9591c.a(context, iVar, s12);
        }
    }

    @Override // com.ironsource.AbstractC2497p3
    public K0 g() {
        return new C2263c3();
    }

    @Override // com.ironsource.AbstractC2497p3
    public P0 h() {
        return new C2353h3(this.f9596o.h(), this);
    }

    @Override // com.ironsource.AbstractC2497p3
    public LoadWhileShowSupportState a(NetworkSettings networkSettings, AdapterBaseInterface adapterBaseInterface) {
        return LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_INSTANCE;
    }

    @Override // com.ironsource.AbstractC2497p3, com.ironsource.Gb
    public void b() {
        boolean z2;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(i());
        try {
            if (this.M == null) {
                ironLog.error("mIronSourceBanner is null");
                this.f9599s.f6419f.b(IronSourceError.ERROR_BN_RELOAD_SKIP_BANNER_LAYOUT_IS_NULL);
                return;
            }
            if (R()) {
                synchronized (this.f9604x) {
                    try {
                        if (a(AbstractC2497p3.f.SHOWING, AbstractC2497p3.f.READY_TO_LOAD)) {
                            ironLog.verbose("start reload");
                            z2 = true;
                            this.L = true;
                        } else {
                            ironLog.error("wrong state = " + this.p);
                            z2 = false;
                        }
                    } finally {
                    }
                }
                if (z2) {
                    a(this.M, this.f9594i);
                    return;
                }
                return;
            }
            if (this.f9596o.h().a() == N0.a.MANUAL_WITH_AUTOMATIC_RELOAD) {
                ironLog.verbose("banner is not visible, reload skipped");
                this.f9599s.f6419f.b(IronSourceError.ERROR_BN_RELOAD_SKIP_INVISIBLE);
            }
            U();
        } catch (Throwable th) {
            C2531r4.d().a(th);
            this.f9599s.j.c(th.getMessage());
        }
    }

    @Override // com.ironsource.AbstractC2497p3
    public void a(int i2, String str, boolean z2) {
        if (v()) {
            if (!z2) {
                this.f9599s.f6419f.a(C2426l5.a(this.f9595n), i2, str);
                com.ironsource.mediationsdk.n.a().b(this.f9596o.b(), new IronSourceError(i2, str));
            }
            if (v()) {
                a(AbstractC2497p3.f.SHOWING);
                V();
                return;
            }
            return;
        }
        super.a(i2, str, z2);
    }

    private void c(AbstractC2547s3<?> abstractC2547s3, View view, FrameLayout.LayoutParams layoutParams) {
        if (a(AbstractC2497p3.f.READY_TO_SHOW, AbstractC2497p3.f.SHOWING)) {
            this.R.set(false);
            O().e();
            ((L2) abstractC2547s3).R();
            com.ironsource.mediationsdk.l.a(this.M, view, layoutParams, new b(abstractC2547s3));
            return;
        }
        IronLog.INTERNAL.verbose("wrong state = " + this.p);
    }

    public void a(com.ironsource.mediationsdk.q qVar, C2434ld c2434ld) {
        String strConcat;
        IronLog.INTERNAL.verbose("placement = " + c2434ld);
        int iB = 510;
        if (!b(qVar)) {
            strConcat = "can't load banner - ".concat(qVar == null ? "banner is null" : "banner is destroyed");
        } else if (c2434ld != null && !TextUtils.isEmpty(c2434ld.c())) {
            if (this.E.c(ContextProvider.getInstance().getApplicationContext(), c2434ld, this.f9596o.b())) {
                strConcat = a1.a.m("placement ", c2434ld.c(), " is capped");
                iB = C2663z0.f(this.f9596o.b());
            } else {
                strConcat = null;
            }
        } else {
            strConcat = "can't load banner - ".concat(c2434ld == null ? "placement is null" : "placement name is empty");
            iB = C2663z0.b(this.f9596o.b());
        }
        if (!TextUtils.isEmpty(strConcat)) {
            IronLog.API.error(b(strConcat));
            a(iB, strConcat, false);
        } else {
            com.ironsource.mediationsdk.l.b(qVar);
            this.M = qVar;
            this.f9594i = c2434ld;
            A();
        }
    }

    @Override // com.ironsource.T0
    public void c(AbstractC2547s3<?> abstractC2547s3) {
        IronLog.INTERNAL.verbose(b(abstractC2547s3.k()));
        this.f9600t.b(abstractC2547s3.f());
    }

    public boolean b(com.ironsource.mediationsdk.q qVar) {
        return (qVar == null || qVar.b()) ? false : true;
    }

    private void b(AbstractC2547s3<?> abstractC2547s3, View view, FrameLayout.LayoutParams layoutParams) {
        ((L2) abstractC2547s3).R();
        com.ironsource.mediationsdk.l.a(this.M, view, layoutParams, new a(abstractC2547s3));
    }

    @Override // com.ironsource.T0
    public void b(AbstractC2547s3<?> abstractC2547s3) {
        IronLog.INTERNAL.verbose(b(abstractC2547s3.k()));
        this.f9600t.e(abstractC2547s3.f());
    }

    @Override // com.ironsource.AbstractC2497p3
    public JSONObject b(NetworkSettings networkSettings) {
        return networkSettings.getBannerSettings();
    }

    public void a(com.ironsource.mediationsdk.q qVar) {
        int iA;
        try {
            if (!b(qVar)) {
                IronLog.API.error("destroy banner failed - errorMessage = ".concat("can't destroy banner - ".concat(qVar == null ? "banner is null" : "banner is destroyed")));
                return;
            }
            IronLog.INTERNAL.verbose("destroying banner");
            M();
            L2 l22 = (L2) this.f9589a.d();
            if (l22 != null) {
                if (l22.r() != null) {
                    iA = l22.r().intValue();
                } else {
                    iA = this.C.a(this.f9596o.b());
                }
                this.f9599s.f6419f.a(iA);
                l22.P();
                this.f9589a.a(null);
                this.f9589a.b(null);
            }
            com.ironsource.mediationsdk.l.a(qVar);
            this.M = null;
            this.f9594i = null;
            this.L = false;
            if (P().o()) {
                this.Q.set(true);
                this.R.set(false);
                W();
            }
            a(AbstractC2497p3.f.READY_TO_LOAD);
        } catch (Throwable th) {
            C2531r4.d().a(th);
            String str = "destroyBanner - exception = " + th.getLocalizedMessage() + " state = " + this.p;
            IronLog.INTERNAL.error(b(str));
            D0 d0 = this.f9599s;
            if (d0 != null) {
                d0.j.g(str);
            }
        }
    }

    @Override // com.ironsource.AbstractC2497p3, com.ironsource.C0
    public Map<String, Object> a(A0 a02) {
        Map<String, Object> mapA = super.a(a02);
        if (b(this.M)) {
            com.ironsource.mediationsdk.l.a(mapA, this.M.getSize());
        }
        if (this.f9594i != null) {
            mapA.put("placement", n());
        }
        return mapA;
    }

    @Override // com.ironsource.InterfaceC2527r0
    public void a(AbstractC2547s3<?> abstractC2547s3, View view, FrameLayout.LayoutParams layoutParams) {
        IronLog.INTERNAL.verbose("mState = " + this.p);
        super.d(abstractC2547s3);
        if (this.f9596o.h().a() == N0.a.MANUAL_WITH_AUTOMATIC_RELOAD) {
            if (a(AbstractC2497p3.f.READY_TO_SHOW, AbstractC2497p3.f.SHOWING)) {
                this.f9589a.a(abstractC2547s3);
                this.f9589a.b(abstractC2547s3);
                b(abstractC2547s3, view, layoutParams);
                P().k();
                this.f9600t.c(abstractC2547s3.f());
                return;
            }
            return;
        }
        if (P().o()) {
            this.f9589a.b(abstractC2547s3);
            if (this.Q.get()) {
                c(abstractC2547s3, view, layoutParams);
            } else {
                this.O = abstractC2547s3;
                this.N = view;
                this.P = layoutParams;
            }
            this.f9600t.c(abstractC2547s3.f());
        }
    }

    @Override // com.ironsource.AbstractC2497p3, com.ironsource.Q0
    public void a(AbstractC2547s3<?> abstractC2547s3) {
        super.a(abstractC2547s3);
        if (P().o()) {
            if (this.R.compareAndSet(false, true)) {
                O().b();
                U();
            } else {
                IronLog.INTERNAL.verbose("Impression already recorded as receive, it can occur from network onAdOpened or from impression timeout timer - loading next ad already in progress");
            }
        }
    }

    @Override // com.ironsource.AbstractC2497p3
    public AdData a(NetworkSettings networkSettings, String str) {
        return AdData.createAdDataForNetworkAdapter(b(networkSettings), this.f9596o.b(), str, this.M);
    }
}
