package com.ironsource;

import com.ironsource.F;
import com.ironsource.mediationsdk.logger.IronLog;

/* JADX INFO: renamed from: com.ironsource.x3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2632x3 extends F {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2632x3(AbstractC2595v0 adUnitData, Cg waterfallInstances) {
        super(adUnitData, waterfallInstances);
        kotlin.jvm.internal.k.e(adUnitData, "adUnitData");
        kotlin.jvm.internal.k.e(waterfallInstances, "waterfallInstances");
    }

    @Override // com.ironsource.F
    public void a(AbstractC2662z instance, F.b loadSelection) {
        String strM;
        kotlin.jvm.internal.k.e(instance, "instance");
        kotlin.jvm.internal.k.e(loadSelection, "loadSelection");
        if (!instance.u()) {
            IronLog.INTERNAL.verbose(instance.d().name() + " - Instance " + instance.p() + " (non-bidder) is ready to load");
            loadSelection.a().add(instance);
            return;
        }
        loadSelection.a(true);
        if (loadSelection.e()) {
            strM = a1.a.m("Advanced Loading: Starting to load bidder ", instance.p(), ". No other instances will be loaded at the same time.");
            loadSelection.a().add(instance);
        } else {
            strM = a1.a.m("Advanced Loading: Won't start loading bidder ", instance.p(), " as a non bidder is being loaded");
        }
        IronLog.INTERNAL.verbose(instance.d().name() + " - " + strM);
    }

    @Override // com.ironsource.F
    public boolean a(F.b loadSelection) {
        kotlin.jvm.internal.k.e(loadSelection, "loadSelection");
        return super.a(loadSelection) || loadSelection.d();
    }
}
