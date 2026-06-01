package com.ironsource;

import com.ironsource.C2530r3;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdRewardListener;
import com.ironsource.mediationsdk.logger.IronLog;

/* JADX INFO: renamed from: com.ironsource.q3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractC2514q3<Smash extends C2530r3<?>> extends AbstractC2462n3<Smash, AdapterAdRewardListener> implements U0 {
    public AbstractC2514q3(U u2, C2469na c2469na, C2270ca c2270ca) {
        super(u2, c2469na, c2270ca);
    }

    @Override // com.ironsource.U0
    public void a(C2530r3<?> c2530r3, C2434ld c2434ld) {
        IronLog.INTERNAL.verbose(b(c2530r3.k()));
        this.f9600t.b(c2434ld, c2530r3.f());
    }
}
