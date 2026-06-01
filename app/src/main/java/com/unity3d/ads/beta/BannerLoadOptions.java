package com.unity3d.ads.beta;

import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import q5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class BannerLoadOptions {
    private final String adMarkup;
    private final i bannerSize;
    private final Map<String, String> extras;
    private final BannerShowListener listener;
    private final String placementId;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder {
        private String adMarkup;
        private final i bannerSize;
        private Map<String, String> extras;
        private BannerShowListener listener;
        private final String placementId;

        public Builder(String placementId, i bannerSize) {
            k.e(placementId, "placementId");
            k.e(bannerSize, "bannerSize");
            this.placementId = placementId;
            this.bannerSize = bannerSize;
        }

        public final BannerLoadOptions build() {
            return new BannerLoadOptions(this.placementId, this.bannerSize, this.adMarkup, this.extras, this.listener);
        }

        public final Builder withAdMarkup(String adMarkup) {
            k.e(adMarkup, "adMarkup");
            this.adMarkup = adMarkup;
            return this;
        }

        public final Builder withExtras(Map<String, String> extras) {
            k.e(extras, "extras");
            this.extras = extras;
            return this;
        }

        public final Builder withListener(BannerShowListener listener) {
            k.e(listener, "listener");
            this.listener = listener;
            return this;
        }
    }

    public BannerLoadOptions(String placementId, i bannerSize, String str, Map<String, String> map, BannerShowListener bannerShowListener) {
        k.e(placementId, "placementId");
        k.e(bannerSize, "bannerSize");
        this.placementId = placementId;
        this.bannerSize = bannerSize;
        this.adMarkup = str;
        this.extras = map;
        this.listener = bannerShowListener;
    }

    public final String getAdMarkup() {
        return this.adMarkup;
    }

    public final i getBannerSize() {
        return this.bannerSize;
    }

    public final Map<String, String> getExtras() {
        return this.extras;
    }

    public final BannerShowListener getListener() {
        return this.listener;
    }

    public final String getPlacementId() {
        return this.placementId;
    }

    public /* synthetic */ BannerLoadOptions(String str, i iVar, String str2, Map map, BannerShowListener bannerShowListener, int i2, f fVar) {
        this(str, iVar, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : map, (i2 & 16) != 0 ? null : bannerShowListener);
    }
}
