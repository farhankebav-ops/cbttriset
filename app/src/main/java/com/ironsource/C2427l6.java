package com.ironsource;

import android.app.Activity;
import com.ironsource.C2300e4;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAdFullScreenInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdRewardListener;
import com.ironsource.mediationsdk.adunit.adapter.listener.InterstitialAdListener;
import com.ironsource.mediationsdk.adunit.adapter.listener.RewardedVideoAdListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.unity3d.mediation.rewarded.LevelPlayReward;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.l6, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2427l6 extends AbstractC2662z implements InterstitialAdListener, RewardedVideoAdListener, AdapterAdRewardListener {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private WeakReference<InterfaceC2445m6> f8913x;
    private C2426l5 y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2427l6(V0 adTools, A instanceData, G adInstancePayload, InterfaceC2445m6 listener) {
        super(adTools, instanceData, adInstancePayload, listener);
        kotlin.jvm.internal.k.e(adTools, "adTools");
        kotlin.jvm.internal.k.e(instanceData, "instanceData");
        kotlin.jvm.internal.k.e(adInstancePayload, "adInstancePayload");
        kotlin.jvm.internal.k.e(listener, "listener");
        this.f8913x = new WeakReference<>(listener);
    }

    private final void O() {
        IronLog.INTERNAL.verbose(AbstractC2662z.a(this, (String) null, 1, (Object) null));
        f().e().a().i(k());
    }

    private final void P() {
        IronLog.INTERNAL.verbose(AbstractC2662z.a(this, (String) null, 1, (Object) null));
        f().e().a().k(k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(C2427l6 this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        this$0.L();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(C2427l6 this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        this$0.O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(C2427l6 this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        this$0.P();
    }

    @Override // com.ironsource.AbstractC2662z
    public void A() {
        if (!(g() instanceof AdapterAdFullScreenInterface)) {
            IronLog.INTERNAL.error(a("adapter not instance of AdapterAdFullScreenInterface"));
            return;
        }
        Object objG = g();
        kotlin.jvm.internal.k.c(objG, "null cannot be cast to non-null type com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAdFullScreenInterface<com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener>");
        ((AdapterAdFullScreenInterface) objG).loadAd(n().g(), ContextProvider.getInstance().getActiveContext(), this);
    }

    @Override // com.ironsource.AbstractC2662z
    public void a(I adInstancePresenter) {
        kotlin.jvm.internal.k.e(adInstancePresenter, "adInstancePresenter");
        adInstancePresenter.a(this);
    }

    @Override // com.ironsource.AbstractC2662z
    public void c() {
        if (Mb.f7131s.d().g().i()) {
            if (!(g() instanceof AdapterAdFullScreenInterface)) {
                IronLog.INTERNAL.error(a("adapter not instance of AdapterAdFullScreenInterface"));
                return;
            }
            Object objG = g();
            kotlin.jvm.internal.k.c(objG, "null cannot be cast to non-null type com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAdFullScreenInterface<*>");
            ((AdapterAdFullScreenInterface) objG).destroyAd(n().g());
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

    @Override // com.ironsource.AbstractC2662z, com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public void onAdOpened() {
        onAdOpened(new LinkedHashMap());
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdRewardListener
    public final /* synthetic */ void onAdRewarded(Map map) {
        b3.c.a(this, map);
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public final /* synthetic */ void onAdStarted(Map map) {
        b3.a.c(this, map);
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public final /* synthetic */ void onAdVisible(Map map) {
        b3.a.d(this, map);
    }

    private final List<String> I() {
        JSONObject jSONObjectOptJSONObject = new S6().a(new String[]{Q6.f7470u}).optJSONObject(Q6.f7470u);
        r5.r rVar = r5.r.f13638a;
        if (jSONObjectOptJSONObject == null) {
            return rVar;
        }
        Object objOpt = jSONObjectOptJSONObject.opt(Q6.C);
        List list = objOpt instanceof List ? (List) objOpt : null;
        if (list == null) {
            return rVar;
        }
        ArrayList arrayList = new ArrayList(r5.n.L0(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(it.next()));
        }
        return arrayList;
    }

    private final Map<String, Object> J() {
        s5.f fVar = new s5.f();
        for (String str : I()) {
            List listK0 = n6.m.K0(str, new String[]{C2300e4.i.f8399b}, 2);
            if (listK0.size() < 2) {
                IronLog.INTERNAL.warning(a("\"" + str + "\" is not a valid key=value format"));
            } else {
                String str2 = (String) listK0.get(0);
                fVar.put("custom_" + str2, (String) listK0.get(1));
            }
        }
        return fVar.b();
    }

    private final void K() {
        this.y = new C2426l5();
        IronLog.INTERNAL.verbose(AbstractC2662z.a(this, (String) null, 1, (Object) null));
        f().e().a().a(k(), "");
        InterfaceC2445m6 interfaceC2445m6 = this.f8913x.get();
        if (interfaceC2445m6 != null) {
            interfaceC2445m6.b(this);
        }
        c();
    }

    private final void L() {
        IronLog.INTERNAL.verbose(AbstractC2662z.a(this, (String) null, 1, (Object) null));
        f().e().a().d(k());
    }

    private final void M() {
        Map<String, Object> mapJ = J();
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strA = f().a(jCurrentTimeMillis, p());
        long jA = C2426l5.a(this.y);
        LevelPlayReward levelPlayRewardA = Mb.f7131s.d().B().a(k(), n().i().b().c());
        if (levelPlayRewardA == null) {
            levelPlayRewardA = M4.f7115a.a();
        }
        LevelPlayReward levelPlayReward = levelPlayRewardA;
        f().e().a().a(k(), levelPlayReward.getName(), levelPlayReward.getAmount(), jCurrentTimeMillis, strA, jA, mapJ, f().j());
        InterfaceC2445m6 interfaceC2445m6 = this.f8913x.get();
        if (interfaceC2445m6 != null) {
            interfaceC2445m6.a(this, levelPlayReward);
        }
    }

    private final void N() {
        IronLog.INTERNAL.verbose(AbstractC2662z.a(this, (String) null, 1, (Object) null));
        InterfaceC2445m6 interfaceC2445m6 = this.f8913x.get();
        if (interfaceC2445m6 != null) {
            interfaceC2445m6.a(this);
        }
    }

    public final void a(Activity activity) {
        kotlin.jvm.internal.k.e(activity, "activity");
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a("placementName = " + k()));
        try {
            f().e().a().a(activity, k());
            if (!(g() instanceof AdapterAdFullScreenInterface)) {
                ironLog.error(a("showAd - adapter not instance of AdapterAdFullScreenInterface"));
                f().e().h().g("showAd - adapter not instance of AdapterAdFullScreenInterface");
            } else {
                Object objG = g();
                kotlin.jvm.internal.k.c(objG, "null cannot be cast to non-null type com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAdFullScreenInterface<com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener>");
                ((AdapterAdFullScreenInterface) objG).showAd(i(), activity, this);
            }
        } catch (Throwable th) {
            C2531r4.d().a(th);
            String strL = a1.a.l("showAd - exception = ", th.getMessage());
            IronLog.INTERNAL.error(a(strL));
            f().e().h().g(strL);
            a(C2663z0.h(n().h()), strL);
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdClosed() {
        a(new ki(this, 0));
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdEnded() {
        a(new ki(this, 1));
    }

    @Override // com.ironsource.AbstractC2662z, com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public void onAdOpened(Map<String, Object> extraData) {
        kotlin.jvm.internal.k.e(extraData, "extraData");
        super.onAdOpened(extraData);
        a(new ti(17, this, extraData));
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdRewardListener
    public void onAdRewarded() {
        a(new ki(this, 3));
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdStarted() {
        a(new ki(this, 4));
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdVisible() {
        a(new ki(this, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(C2427l6 this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        this$0.M();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C2427l6 this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        this$0.K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C2427l6 this$0, Map extraData) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(extraData, "$extraData");
        this$0.l().putAll(extraData);
        this$0.N();
    }
}
