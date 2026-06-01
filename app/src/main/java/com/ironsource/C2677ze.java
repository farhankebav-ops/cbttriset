package com.ironsource;

import android.content.Context;
import com.ironsource.C2381id;
import com.ironsource.Mb;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.ze, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2677ze {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Qe f10648b;
    private static C2435le h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static C2473ne f10652i;
    private static boolean j;
    private static long k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2677ze f10647a = new C2677ze();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final q5.f f10649c = n7.b.C(a.f10653a);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f10650d = "ze";
    private static final De e = new De();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Ke f10651f = new Ke();
    private static final List<InterfaceC2541re> g = new ArrayList();

    /* JADX INFO: renamed from: com.ironsource.ze$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a extends kotlin.jvm.internal.l implements e6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f10653a = new a();

        public a() {
            super(0);
        }

        @Override // e6.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC2466n7 invoke() {
            return Mb.f7131s.d().k();
        }
    }

    /* JADX INFO: renamed from: com.ironsource.ze$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b implements InterfaceC2541re {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f10654a;

        public b(Context context) {
            this.f10654a = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(C2473ne error) {
            kotlin.jvm.internal.k.e(error, "$error");
            C2677ze.f10647a.a(error);
        }

        @Override // com.ironsource.InterfaceC2541re
        public void a(C2435le sdkConfig) {
            kotlin.jvm.internal.k.e(sdkConfig, "sdkConfig");
            C2677ze.e.a(new bj(2, this.f10654a, sdkConfig));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(Context applicationContext, C2435le sdkConfig) {
            kotlin.jvm.internal.k.e(sdkConfig, "$sdkConfig");
            C2677ze c2677ze = C2677ze.f10647a;
            kotlin.jvm.internal.k.d(applicationContext, "applicationContext");
            c2677ze.a(applicationContext, sdkConfig);
        }

        @Override // com.ironsource.InterfaceC2541re
        public void a(C2473ne error) {
            kotlin.jvm.internal.k.e(error, "error");
            C2677ze.e.a(new fj(error, 1));
        }
    }

    private C2677ze() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f() {
        f10647a.a(true);
    }

    public final void e() {
        e.c(new androidx.camera.core.processing.i(3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(C2592ue serverResponse) {
        kotlin.jvm.internal.k.e(serverResponse, "$serverResponse");
        C2435le c2435le = new C2435le(serverResponse);
        C2677ze c2677ze = f10647a;
        c2677ze.b(c2435le);
        c2677ze.a(c2435le);
    }

    private final InterfaceC2466n7 c() {
        return (InterfaceC2466n7) f10649c.getValue();
    }

    private final void d() {
        if (Mb.f7131s.d().g().g()) {
            C2256be.i().a(new C5(D5.EP_CONFIG_RECEIVED, (JSONObject) null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(C2473ne error) {
        kotlin.jvm.internal.k.e(error, "$error");
        f10647a.a(error);
    }

    private final void a(Context context, V9 v9, Me me) {
        v9.i(me.f().h());
        v9.c(me.f().d());
        A1 a1B = me.c().b();
        kotlin.jvm.internal.k.b(a1B);
        v9.a(a1B.a());
        v9.d(a1B.c().b());
        v9.b(a1B.k().b());
        v9.a(Boolean.valueOf(IronSourceUtils.c(context)));
        A1 a1B2 = me.c().b();
        kotlin.jvm.internal.k.b(a1B2);
        v9.b(a1B2.f().b());
    }

    public final void b(C2473ne error) {
        kotlin.jvm.internal.k.e(error, "error");
        e.c(new fj(error, 0));
    }

    private final void b(C2435le c2435le) {
        h = c2435le;
        a(false);
    }

    private final Be b() {
        if (h != null) {
            return Be.INITIATED;
        }
        if (f10652i != null) {
            return Be.INIT_FAILED;
        }
        if (j) {
            return Be.INIT_IN_PROGRESS;
        }
        return Be.NOT_INIT;
    }

    public final void a(Context context, C2575te initRequest, InterfaceC2541re listener) {
        kotlin.jvm.internal.k.e(context, "context");
        kotlin.jvm.internal.k.e(initRequest, "initRequest");
        kotlin.jvm.internal.k.e(listener, "listener");
        e.c(new a3.d(listener, context, initRequest, context.getApplicationContext(), 6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(InterfaceC2541re listener, Context context, C2575te initRequest, Context context2) {
        kotlin.jvm.internal.k.e(listener, "$listener");
        kotlin.jvm.internal.k.e(context, "$context");
        kotlin.jvm.internal.k.e(initRequest, "$initRequest");
        C2435le c2435le = h;
        if (c2435le != null) {
            f10647a.a(listener, c2435le);
            return;
        }
        g.add(listener);
        if (j) {
            return;
        }
        f10652i = null;
        f10647a.a(true);
        k = new Date().getTime();
        f10651f.a(context, initRequest, e, new b(context2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(InterfaceC2541re listener, C2435le sdkConfig) {
        kotlin.jvm.internal.k.e(listener, "$listener");
        kotlin.jvm.internal.k.e(sdkConfig, "$sdkConfig");
        listener.a(sdkConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(InterfaceC2541re listener, C2473ne error) {
        kotlin.jvm.internal.k.e(listener, "$listener");
        kotlin.jvm.internal.k.e(error, "$error");
        listener.a(error);
    }

    private final void b(Context context, C2435le c2435le) {
        Context context2;
        H1 h1B;
        Rb rbE;
        H1 h1G;
        V2 v2C;
        H1 h1G2;
        F9 f9D;
        H1 h1I;
        Zd zdF;
        H1 h1M;
        H1 h1B2;
        Me meD = c2435le.d();
        A1 a1B = meD.c().b();
        boolean zL = (a1B == null || (h1B2 = a1B.b()) == null) ? false : h1B2.l();
        V3 v3C = meD.c();
        boolean zL2 = (v3C == null || (zdF = v3C.f()) == null || (h1M = zdF.m()) == null) ? false : h1M.l();
        V3 v3C2 = meD.c();
        boolean zL3 = (v3C2 == null || (f9D = v3C2.d()) == null || (h1I = f9D.i()) == null) ? false : h1I.l();
        V3 v3C3 = meD.c();
        boolean zL4 = (v3C3 == null || (v2C = v3C3.c()) == null || (h1G2 = v2C.g()) == null) ? false : h1G2.l();
        V3 v3C4 = meD.c();
        boolean zL5 = (v3C4 == null || (rbE = v3C4.e()) == null || (h1G = rbE.g()) == null) ? false : h1G.l();
        if (zL) {
            A1 a1B2 = meD.c().b();
            if (a1B2 == null || (h1B = a1B2.b()) == null) {
                context2 = context;
            } else {
                context2 = context;
                a(f10647a, Mb.f7131s.d().q(), h1B, context2, meD, false, 16, null);
            }
        } else {
            context2 = context;
            Mb.f7131s.d().q().a(false);
        }
        if (zL2) {
            V3 v3C5 = meD.c();
            Zd zdF2 = v3C5 != null ? v3C5.f() : null;
            kotlin.jvm.internal.k.b(zdF2);
            H1 rewardedVideoConfig = zdF2.m();
            C2256be c2256beI = C2256be.i();
            kotlin.jvm.internal.k.d(c2256beI, "getInstance()");
            kotlin.jvm.internal.k.d(rewardedVideoConfig, "rewardedVideoConfig");
            a(this, c2256beI, rewardedVideoConfig, context2, meD, false, 16, null);
        } else {
            C2256be.i().a(false);
        }
        if (zL3) {
            V3 v3C6 = meD.c();
            F9 f9D2 = v3C6 != null ? v3C6.d() : null;
            kotlin.jvm.internal.k.b(f9D2);
            H1 interstitialConfig = f9D2.i();
            H9 h9I = H9.i();
            kotlin.jvm.internal.k.d(h9I, "getInstance()");
            kotlin.jvm.internal.k.d(interstitialConfig, "interstitialConfig");
            a(this, h9I, interstitialConfig, context2, meD, false, 16, null);
        } else if (zL4) {
            V3 v3C7 = meD.c();
            V2 v2C2 = v3C7 != null ? v3C7.c() : null;
            kotlin.jvm.internal.k.b(v2C2);
            H1 bannerConfig = v2C2.g();
            H9 h9I2 = H9.i();
            kotlin.jvm.internal.k.d(h9I2, "getInstance()");
            kotlin.jvm.internal.k.d(bannerConfig, "bannerConfig");
            a(this, h9I2, bannerConfig, context2, meD, false, 16, null);
        } else if (zL5) {
            V3 v3C8 = meD.c();
            Rb rbE2 = v3C8 != null ? v3C8.e() : null;
            kotlin.jvm.internal.k.b(rbE2);
            H1 h1G3 = rbE2.g();
            H9 h9I3 = H9.i();
            kotlin.jvm.internal.k.d(h9I3, "getInstance()");
            a(this, h9I3, h1G3, context2, meD, false, 16, null);
        } else {
            H9.i().a(false);
        }
        V3 v3C9 = meD.c();
        A1 a1B3 = v3C9 != null ? v3C9.b() : null;
        kotlin.jvm.internal.k.b(a1B3);
        C2398jd c2398jdI = a1B3.i();
        boolean zA = c2398jdI.a();
        String strB = c2398jdI.b();
        boolean zC = c2398jdI.c();
        int iD = c2398jdI.d();
        int[] iArrE = c2398jdI.e();
        int[] iArrF = c2398jdI.f();
        C2381id c2381id = C2381id.O;
        c2381id.a(zA);
        if (zA) {
            c2381id.b(strB, context2);
            c2381id.b(iArrE, context2);
            c2381id.c(iArrF, context2);
            c2381id.b(zC);
            c2381id.c(iD);
        }
    }

    public final void a(C2592ue serverResponse) {
        kotlin.jvm.internal.k.e(serverResponse, "serverResponse");
        e.c(new ch(serverResponse, 12));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(C2473ne c2473ne) {
        f10652i = c2473ne;
        a(false);
        Iterator<InterfaceC2541re> it = g.iterator();
        while (it.hasNext()) {
            a(it.next(), c2473ne);
        }
        g.clear();
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, "Mediation availability false reason: " + c2473ne, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Context context, C2435le c2435le) {
        b(c2435le);
        K1 k1A = c2435le.a();
        C2229a5 c2229a5 = C2229a5.f7951a;
        c2229a5.c(k1A.g());
        Mb.b bVar = Mb.f7131s;
        bVar.a().o().a(k1A.c());
        c2229a5.a(k1A.f());
        c2229a5.a(k1A.j());
        IronSourceThreadManager.INSTANCE.setUseSharedExecutorService(k1A.h());
        c().a(k1A);
        De de = e;
        a(context, de.c(), c2435le.d());
        de.a(new Date().getTime() - k, c2435le.f());
        Qe qe = new Qe();
        f10648b = qe;
        qe.a(c());
        IronSourceUtils.e(context, c2435le.d().toString());
        bVar.d().q().c(true);
        H9.i().c(true);
        C2256be.i().c(true);
        C2381id.O.c(true);
        b(context, c2435le);
        IronSourceLoggerManager.getLogger(0).setDebugLevel(c2435le.e().b());
        D1 d1B = c2435le.b();
        if (d1B.f()) {
            de.a(d1B);
        }
        a(c2435le);
        new C2381id.a().a();
        d();
    }

    private final void a(C2435le c2435le) {
        Iterator<InterfaceC2541re> it = g.iterator();
        while (it.hasNext()) {
            a(it.next(), c2435le);
        }
        g.clear();
    }

    private final void a(boolean z2) {
        j = z2;
        e.a(b());
    }

    private final void a(InterfaceC2541re interfaceC2541re, C2435le c2435le) {
        e.e(new dh(interfaceC2541re, c2435le, 2));
    }

    private final void a(InterfaceC2541re interfaceC2541re, C2473ne c2473ne) {
        e.e(new eh(interfaceC2541re, c2473ne, 1));
    }

    public static /* synthetic */ void a(C2677ze c2677ze, AbstractC2581u3 abstractC2581u3, H1 h12, Context context, Me me, boolean z2, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            z2 = true;
        }
        c2677ze.a(abstractC2581u3, h12, context, me, z2);
    }

    private final void a(AbstractC2581u3 abstractC2581u3, H1 h12, Context context, Me me, boolean z2) {
        abstractC2581u3.a(z2);
        abstractC2581u3.a(h12.c(), context);
        abstractC2581u3.b(h12.d(), context);
        abstractC2581u3.a(h12.f());
        abstractC2581u3.d(h12.e());
        abstractC2581u3.b(h12.a());
        abstractC2581u3.b(h12.i(), context);
        abstractC2581u3.c(h12.h(), context);
        abstractC2581u3.a(h12.j(), context);
        abstractC2581u3.d(h12.g(), context);
        A1 a1B = me.c().b();
        kotlin.jvm.internal.k.b(a1B);
        abstractC2581u3.a(a1B.j());
        abstractC2581u3.b(h12.k());
        abstractC2581u3.c(h12.b());
    }
}
