package com.ironsource;

import android.app.Activity;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdInfo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface E6 {
    void a(Activity activity);

    void a(C2567t6 c2567t6);

    void a(C2567t6 c2567t6, IronSourceError ironSourceError);

    void a(C2567t6 c2567t6, LevelPlayAdInfo levelPlayAdInfo);

    void b(C2567t6 c2567t6, IronSourceError ironSourceError);

    void b(C2567t6 c2567t6, LevelPlayAdInfo levelPlayAdInfo);

    void c(C2567t6 c2567t6, LevelPlayAdInfo levelPlayAdInfo);

    void loadAd();
}
