package com.ironsource;

import com.ironsource.U0;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdRewardListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.ironsource.r3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2530r3<Listener extends U0> extends AbstractC2480o3<Listener> implements AdapterAdRewardListener {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private C2426l5 f9751r;

    /* JADX INFO: renamed from: com.ironsource.r3$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a extends AbstractRunnableC2382ie {
        public a() {
        }

        @Override // com.ironsource.AbstractRunnableC2382ie
        public void a() {
            C2530r3.this.U();
        }
    }

    public C2530r3(InterfaceC2591ud interfaceC2591ud, C2421l0 c2421l0, BaseAdAdapter<?, AdapterAdRewardListener> baseAdAdapter, C2243b1 c2243b1, C2461n2 c2461n2, Listener listener) {
        super(interfaceC2591ud, c2421l0, baseAdAdapter, c2243b1, c2461n2, listener);
    }

    @Override // com.ironsource.AbstractC2480o3, com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdClosed() {
        this.f9751r = new C2426l5();
        super.onAdClosed();
    }

    @Override // com.ironsource.AbstractC2547s3, com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public void onAdOpened() {
        this.f9751r = null;
        super.onAdOpened();
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdRewardListener
    public final /* synthetic */ void onAdRewarded(Map map) {
        b3.c.a(this, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        if (this.g == null) {
            IronLog.INTERNAL.verbose(a("placement is null "));
            D0 d0 = this.f9794d;
            if (d0 != null) {
                d0.j.g("mCurrentPlacement is null state = " + this.e);
                return;
            }
            return;
        }
        IronLog.INTERNAL.verbose(a("placement name = " + j()));
        if (this.f9794d != null) {
            HashMap map = new HashMap();
            if (com.ironsource.mediationsdk.r.m().r() != null) {
                for (String str : com.ironsource.mediationsdk.r.m().r().keySet()) {
                    map.put(a1.a.l("custom_", str), com.ironsource.mediationsdk.r.m().r().get(str));
                }
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f9794d.f6420i.a(j(), this.g.f(), this.g.e(), jCurrentTimeMillis, IronSourceUtils.a(jCurrentTimeMillis, c()), C2426l5.a(this.f9751r), map, com.ironsource.mediationsdk.r.m().l());
        }
        ((U0) this.f9792b).a((C2530r3<?>) this, this.g);
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdRewardListener
    public void onAdRewarded() {
        if (u().e()) {
            u().a(new a());
        } else {
            U();
        }
    }
}
