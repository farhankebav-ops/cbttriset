package com.unity3d.ads.core.data.manager;

import android.content.Context;
import com.unity3d.services.ads.gmascar.models.BiddingSignals;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.UnityBannerSize;
import gatewayprotocol.v1.AdFormatOuterClass;
import java.util.List;
import q5.x;
import t6.e;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface ScarManager {
    Object getSignals(List<? extends AdFormatOuterClass.AdFormat> list, c<? super BiddingSignals> cVar);

    Object getVersion(c<? super String> cVar);

    Object loadAd(String str, String str2, String str3, String str4, String str5, int i2, c<? super x> cVar);

    e loadBannerAd(Context context, BannerView bannerView, u3.c cVar, UnityBannerSize unityBannerSize, String str);

    e show(String str, String str2);
}
