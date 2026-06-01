package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.privacysandbox.ads.adservices.java.topics.TopicsManagerFutures;
import androidx.privacysandbox.ads.adservices.topics.GetTopicsRequest;
import com.google.android.gms.ads.MobileAds;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzehi {
    private final Context zza;

    public zzehi(Context context) {
        this.zza = context;
    }

    public final j2.q zza(boolean z2) {
        try {
            GetTopicsRequest getTopicsRequestBuild = new GetTopicsRequest.Builder().setAdsSdkName(MobileAds.ERROR_DOMAIN).setShouldRecordObservation(z2).build();
            TopicsManagerFutures topicsManagerFuturesFrom = TopicsManagerFutures.from(this.zza);
            return topicsManagerFuturesFrom != null ? topicsManagerFuturesFrom.getTopicsAsync(getTopicsRequestBuild) : zzgui.zzc(new IllegalStateException());
        } catch (Exception e) {
            return zzgui.zzc(e);
        }
    }
}
