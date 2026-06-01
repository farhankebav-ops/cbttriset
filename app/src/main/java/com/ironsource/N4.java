package com.ironsource;

import com.ironsource.AbstractC2547s3;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class N4<Smash extends AbstractC2547s3<?>> extends Kg<Smash> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N4(int i2, boolean z2, List<? extends Smash> waterfall) {
        super(i2, z2, waterfall);
        kotlin.jvm.internal.k.e(waterfall, "waterfall");
    }

    @Override // com.ironsource.Kg
    public void c(Smash smash) {
        kotlin.jvm.internal.k.e(smash, "smash");
        IronLog.INTERNAL.verbose(smash.g().name() + " - Smash " + smash.k() + " is ready to load");
        smash.a(true);
        c().add(smash);
    }
}
