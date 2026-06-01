package com.unity3d.mediation.adapters.levelplay;

import android.content.Context;
import com.ironsource.B3;
import com.ironsource.mediationsdk.adunit.adapter.BaseRewardedVideo;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.r;
import com.unity3d.mediation.adapters.levelplay.LevelPlayBaseAdapter;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class LevelPlayBaseRewardedVideo<NetworkAdapter extends LevelPlayBaseAdapter> extends BaseRewardedVideo<NetworkAdapter> implements B3 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LevelPlayBaseRewardedVideo(NetworkSettings networkSettings) {
        super(networkSettings);
        k.e(networkSettings, "networkSettings");
    }

    @Override // com.ironsource.B3
    public void collectBiddingData(AdData adData, Context context, BiddingDataCallback biddingDataCallback) {
        k.e(context, "context");
        k.e(biddingDataCallback, "biddingDataCallback");
    }

    public final String getDynamicUserId() {
        return r.m().l();
    }
}
