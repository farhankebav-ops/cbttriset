package com.ironsource;

import com.ironsource.AbstractC2547s3;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.List;

/* JADX INFO: renamed from: com.ironsource.y3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2649y3<Smash extends AbstractC2547s3<?>> extends Kg<Smash> {
    private boolean h;

    public /* synthetic */ C2649y3(int i2, boolean z2, List list, boolean z7, int i8, kotlin.jvm.internal.f fVar) {
        this(i2, z2, list, (i8 & 8) != 0 ? false : z7);
    }

    @Override // com.ironsource.Kg
    public void c(Smash smash) {
        String strM;
        kotlin.jvm.internal.k.e(smash, "smash");
        if (!smash.w()) {
            IronLog.INTERNAL.verbose(smash.g().name() + " - Smash " + smash.c() + " (non-bidder) is ready to load");
            smash.a(true);
            c().add(smash);
            return;
        }
        this.h = true;
        if (d() == 0) {
            strM = "Advanced Loading: Starting to load bidder " + smash.c() + ". No other instances will be loaded at the same time.";
            smash.a(true);
            c().add(smash);
        } else {
            strM = a1.a.m("Advanced Loading: Won't start loading bidder ", smash.c(), " as a non bidder is being loaded");
        }
        IronLog.INTERNAL.verbose(smash.g().name() + " - " + strM);
        IronSourceUtils.i(strM);
    }

    @Override // com.ironsource.Kg
    public boolean e() {
        return super.e() || this.h;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2649y3(int i2, boolean z2, List<? extends Smash> waterfall, boolean z7) {
        super(i2, z2, waterfall);
        kotlin.jvm.internal.k.e(waterfall, "waterfall");
        this.h = z7;
    }
}
