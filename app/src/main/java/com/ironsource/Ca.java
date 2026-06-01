package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdInfo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface Ca {
    void b(IronSourceError ironSourceError);

    void e(IronSourceError ironSourceError);

    void k();

    void l();

    void n();

    void onAdClicked();

    void onAdLeftApplication();

    void onAdLoaded(LevelPlayAdInfo levelPlayAdInfo);
}
