package com.ironsource;

import android.text.TextUtils;
import com.ironsource.AbstractC2477o0;
import com.ironsource.D0;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.AdapterUtils;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.logger.IronLog;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class M2 extends AbstractC2477o0 {
    private final WeakReference<P2> k;
    private final a l;
    private final N2 m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M2(C2459n0 tools, N2 adUnitData, P2 listener) {
        String str;
        int iB;
        super(tools, adUnitData, listener, null, 8, null);
        kotlin.jvm.internal.k.e(tools, "tools");
        kotlin.jvm.internal.k.e(adUnitData, "adUnitData");
        kotlin.jvm.internal.k.e(listener, "listener");
        this.k = new WeakReference<>(listener);
        this.l = new a();
        this.m = adUnitData;
        C2434ld c2434ldG = g();
        IronLog.INTERNAL.verbose("placement = " + c2434ldG);
        if (c2434ldG == null || TextUtils.isEmpty(c2434ldG.c())) {
            str = String.format("can't load banner - %s", Arrays.copyOf(new Object[]{c2434ldG == null ? "placement is null" : "placement name is empty"}, 1));
            iB = C2663z0.b(adUnitData.b().a());
        } else {
            str = null;
            iB = 510;
        }
        if (str != null) {
            IronLog.API.error(a(str));
            a(iB, str);
        }
    }

    @Override // com.ironsource.AbstractC2477o0
    public C2511q0 b() {
        return new T2(this.m.b(), a(m()));
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class a extends AbstractC2477o0.a implements A2 {
        public a() {
            super();
        }

        @Override // com.ironsource.A2
        public void a(C2648y2 instance) {
            kotlin.jvm.internal.k.e(instance, "instance");
            IronLog.INTERNAL.verbose(M2.this.a(instance.q()));
            P2 p2 = (P2) M2.this.k.get();
            if (p2 != null) {
                p2.i();
            }
        }

        @Override // com.ironsource.AbstractC2477o0.a, com.ironsource.D
        public void b(AbstractC2662z instance) {
            kotlin.jvm.internal.k.e(instance, "instance");
            super.b(instance);
            InterfaceC2629x0 interfaceC2629x0I = M2.this.i();
            if (interfaceC2629x0I != null) {
                interfaceC2629x0I.f();
            }
        }

        @Override // com.ironsource.A2
        public void c(C2648y2 instance) {
            kotlin.jvm.internal.k.e(instance, "instance");
            IronLog.INTERNAL.verbose(M2.this.a(instance.q()));
            P2 p2 = (P2) M2.this.k.get();
            if (p2 != null) {
                p2.j();
            }
        }

        @Override // com.ironsource.A2
        public void b(C2648y2 instance) {
            kotlin.jvm.internal.k.e(instance, "instance");
            IronLog.INTERNAL.verbose(M2.this.a(instance.q()));
            P2 p2 = (P2) M2.this.k.get();
            if (p2 != null) {
                p2.m();
            }
        }
    }

    private final ISBannerSize m() {
        return f().a(this.m.b().h());
    }

    public final void a(pg pgVar, InterfaceC2629x0 displayListener) {
        kotlin.jvm.internal.k.e(displayListener, "displayListener");
        if (pgVar != null) {
            a(new C2(pgVar), displayListener);
        }
    }

    @Override // com.ironsource.AbstractC2477o0
    public C a() {
        return new ah(this, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AbstractC2662z a(M2 this$0, A instanceData, G adInstancePayload) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(instanceData, "instanceData");
        kotlin.jvm.internal.k.e(adInstancePayload, "adInstancePayload");
        return new C2648y2(new V0(this$0.f(), D0.b.PROVIDER), instanceData, adInstancePayload, this$0.l);
    }

    private final ISBannerSize a(ISBannerSize iSBannerSize) {
        if (!iSBannerSize.isSmart()) {
            return iSBannerSize;
        }
        if (AdapterUtils.isLargeScreen(ContextProvider.getInstance().getApplicationContext())) {
            return com.ironsource.mediationsdk.l.a();
        }
        return ISBannerSize.BANNER;
    }
}
