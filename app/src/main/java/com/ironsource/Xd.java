package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdRewardListener;
import com.ironsource.mediationsdk.adunit.adapter.listener.RewardedVideoAdListener;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class Xd extends C2530r3<U0> implements RewardedVideoAdListener {
    public Xd(InterfaceC2591ud interfaceC2591ud, C2421l0 c2421l0, BaseAdAdapter<?, AdapterAdRewardListener> baseAdAdapter, C2461n2 c2461n2, U0 u02) {
        super(interfaceC2591ud, c2421l0, baseAdAdapter, new C2243b1(c2421l0.g(), c2421l0.g().getRewardedVideoSettings(), IronSource.a.REWARDED_VIDEO), c2461n2, u02);
    }
}
