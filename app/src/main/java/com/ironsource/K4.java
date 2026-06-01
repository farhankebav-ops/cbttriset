package com.ironsource;

import com.ironsource.F;
import com.ironsource.mediationsdk.logger.IronLog;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class K4 extends F {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K4(AbstractC2595v0 adUnitData, Cg waterfallInstances) {
        super(adUnitData, waterfallInstances);
        kotlin.jvm.internal.k.e(adUnitData, "adUnitData");
        kotlin.jvm.internal.k.e(waterfallInstances, "waterfallInstances");
    }

    @Override // com.ironsource.F
    public void a(AbstractC2662z instance, F.b loadSelection) {
        kotlin.jvm.internal.k.e(instance, "instance");
        kotlin.jvm.internal.k.e(loadSelection, "loadSelection");
        IronLog.INTERNAL.verbose(instance.d().name() + " - Instance " + instance.q() + " is ready to load");
        loadSelection.a().add(instance);
    }
}
