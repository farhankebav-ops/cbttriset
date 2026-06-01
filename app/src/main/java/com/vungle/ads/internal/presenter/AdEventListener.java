package com.vungle.ads.internal.presenter;

import com.vungle.ads.VungleError;
import com.vungle.ads.internal.model.Placement;
import com.vungle.ads.internal.util.Logger;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class AdEventListener {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "AdEventListener";
    private boolean adRewarded;
    private Placement placement;
    private final AdPlayCallback playAdCallback;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    public AdEventListener(AdPlayCallback adPlayCallback, Placement placement) {
        this.playAdCallback = adPlayCallback;
        this.placement = placement;
    }

    public final void onError(VungleError error, String str) {
        k.e(error, "error");
        AdPlayCallback adPlayCallback = this.playAdCallback;
        if (adPlayCallback != null) {
            adPlayCallback.onFailure(error);
            Logger.Companion.e(TAG, "AdEventListener#PlayAdCallback " + str, error);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void onNext(String s7, String str, String str2) {
        Placement placement;
        AdPlayCallback adPlayCallback;
        AdPlayCallback adPlayCallback2;
        AdPlayCallback adPlayCallback3;
        AdPlayCallback adPlayCallback4;
        k.e(s7, "s");
        Logger.Companion companion = Logger.Companion;
        StringBuilder sbZ = a1.a.z("s=", s7, ", value=", str, ", id=");
        sbZ.append(str2);
        companion.d(TAG, sbZ.toString());
        switch (s7.hashCode()) {
            case -1912374177:
                if (s7.equals(MRAIDPresenter.SUCCESSFUL_VIEW) && (placement = this.placement) != null && placement.isRewardedVideo() && !this.adRewarded) {
                    this.adRewarded = true;
                    AdPlayCallback adPlayCallback5 = this.playAdCallback;
                    if (adPlayCallback5 != null) {
                        adPlayCallback5.onAdRewarded(str2);
                    }
                }
                break;
            case -1627831289:
                if (s7.equals("adViewed") && (adPlayCallback = this.playAdCallback) != null) {
                    adPlayCallback.onAdImpression(str2);
                }
                break;
            case 100571:
                if (s7.equals("end") && (adPlayCallback2 = this.playAdCallback) != null) {
                    adPlayCallback2.onAdEnd(str2);
                }
                break;
            case 3417674:
                if (s7.equals(MRAIDPresenter.OPEN)) {
                    if (k.a(str, "adClick")) {
                        AdPlayCallback adPlayCallback6 = this.playAdCallback;
                        if (adPlayCallback6 != null) {
                            adPlayCallback6.onAdClick(str2);
                        }
                        break;
                    } else if (k.a(str, "adLeftApplication") && (adPlayCallback3 = this.playAdCallback) != null) {
                        adPlayCallback3.onAdLeftApplication(str2);
                        break;
                    }
                }
                break;
            case 109757538:
                if (s7.equals("start") && (adPlayCallback4 = this.playAdCallback) != null) {
                    adPlayCallback4.onAdStart(str2);
                }
                break;
        }
    }
}
