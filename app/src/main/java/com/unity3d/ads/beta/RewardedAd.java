package com.unity3d.ads.beta;

import android.app.Activity;
import com.unity3d.ads.core.data.model.AdObject;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class RewardedAd {
    public static final Companion Companion = new Companion(null);
    private final AdObject adObject;
    private final LoadOptions loadOptions;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final void load(LoadOptions options, LoadListener<RewardedAd> listener) {
            k.e(options, "options");
            k.e(listener, "listener");
        }

        private Companion() {
        }
    }

    public RewardedAd(AdObject adObject, LoadOptions loadOptions) {
        k.e(adObject, "adObject");
        k.e(loadOptions, "loadOptions");
        this.adObject = adObject;
        this.loadOptions = loadOptions;
    }

    public static final void load(LoadOptions loadOptions, LoadListener<RewardedAd> loadListener) {
        Companion.load(loadOptions, loadListener);
    }

    public static /* synthetic */ void show$default(RewardedAd rewardedAd, Activity activity, ShowOptions showOptions, RewardedShowListener rewardedShowListener, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            showOptions = null;
        }
        rewardedAd.show(activity, showOptions, rewardedShowListener);
    }

    public final void show(Activity activity, ShowOptions showOptions, RewardedShowListener listener) {
        k.e(activity, "activity");
        k.e(listener, "listener");
    }
}
