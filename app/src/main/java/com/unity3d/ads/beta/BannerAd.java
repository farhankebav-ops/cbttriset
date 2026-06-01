package com.unity3d.ads.beta;

import com.unity3d.ads.core.data.model.AdObject;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class BannerAd {
    public static final Companion Companion = new Companion(null);
    private final AdObject adObject;
    private final BannerLoadOptions loadOptions;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final void load(BannerLoadOptions options, LoadListener<BannerAd> listener) {
            k.e(options, "options");
            k.e(listener, "listener");
        }

        private Companion() {
        }
    }

    public BannerAd(AdObject adObject, BannerLoadOptions loadOptions) {
        k.e(adObject, "adObject");
        k.e(loadOptions, "loadOptions");
        this.adObject = adObject;
        this.loadOptions = loadOptions;
    }

    public static final void load(BannerLoadOptions bannerLoadOptions, LoadListener<BannerAd> loadListener) {
        Companion.load(bannerLoadOptions, loadListener);
    }
}
