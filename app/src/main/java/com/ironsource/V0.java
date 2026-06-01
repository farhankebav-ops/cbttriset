package com.ironsource;

import com.ironsource.D0;
import com.ironsource.P8;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class V0 extends C2459n0 {
    private final C2459n0 g;
    private final R0 h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private InterfaceC2352h2 f7707i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V0(C2459n0 adTools, AbstractC2595v0 adUnitData, D0.b level) {
        super(adTools, level);
        kotlin.jvm.internal.k.e(adTools, "adTools");
        kotlin.jvm.internal.k.e(adUnitData, "adUnitData");
        kotlin.jvm.internal.k.e(level, "level");
        this.g = adTools;
        R0 r0A = C2627wf.a(adUnitData, adUnitData.e().c());
        kotlin.jvm.internal.k.d(r0A, "getAdUnitPerformance(\n  …auctionSavedHistoryLimit)");
        this.h = r0A;
    }

    public final void a(InterfaceC2352h2 interfaceC2352h2) {
        this.f7707i = interfaceC2352h2;
    }

    public final void c(AbstractRunnableC2382ie task) {
        kotlin.jvm.internal.k.e(task, "task");
        C2644xf.a(C2644xf.f10528a, task, 0L, 2, null);
    }

    public final String e(String serverData) {
        kotlin.jvm.internal.k.e(serverData, "serverData");
        String strC = com.ironsource.mediationsdk.d.b().c(serverData);
        kotlin.jvm.internal.k.d(strC, "getInstance().getDynamic…romServerData(serverData)");
        return strC;
    }

    public final R0 h() {
        return this.h;
    }

    public final InterfaceC2352h2 i() {
        return this.f7707i;
    }

    public final String j() {
        return com.ironsource.mediationsdk.r.m().l();
    }

    public final C2270ca k() {
        return C2627wf.a();
    }

    public final P8.a l() {
        return Mb.f7131s.a().h();
    }

    public final BaseAdAdapter<?, ?> a(A instanceData) {
        kotlin.jvm.internal.k.e(instanceData, "instanceData");
        return com.ironsource.mediationsdk.c.b().a(instanceData.u(), instanceData.h(), instanceData.i().b().b());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V0(V0 adUnitTools, D0.b level) {
        super(adUnitTools, level);
        kotlin.jvm.internal.k.e(adUnitTools, "adUnitTools");
        kotlin.jvm.internal.k.e(level, "level");
        this.g = adUnitTools.g;
        this.h = adUnitTools.h;
        this.f7707i = adUnitTools.f7707i;
    }

    public final BaseAdAdapter<?, ?> a(NetworkSettings providerSettings, IronSource.a adFormat, UUID adId) {
        kotlin.jvm.internal.k.e(providerSettings, "providerSettings");
        kotlin.jvm.internal.k.e(adFormat, "adFormat");
        kotlin.jvm.internal.k.e(adId, "adId");
        return com.ironsource.mediationsdk.c.b().a(providerSettings, adFormat, adId);
    }

    public final String a(long j, String instanceName) {
        kotlin.jvm.internal.k.e(instanceName, "instanceName");
        String strA = IronSourceUtils.a(j, instanceName);
        kotlin.jvm.internal.k.d(strA, "getTransId(timeStamp, instanceName)");
        return strA;
    }
}
