package com.unity3d.ads.beta;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import r5.s;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class LoadOptions {
    private final String adMarkup;
    private final Map<String, String> extras;
    private final String placementId;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder {
        private String adMarkup;
        private final Map<String, String> extras;
        private final String placementId;

        public Builder(String placementId) {
            k.e(placementId, "placementId");
            this.placementId = placementId;
            this.extras = new LinkedHashMap();
        }

        public final LoadOptions build() {
            return new LoadOptions(this.placementId, this.adMarkup, this.extras);
        }

        public final Builder withAdMarkup(String adMarkup) {
            k.e(adMarkup, "adMarkup");
            this.adMarkup = adMarkup;
            return this;
        }

        public final Builder withExtras(Map<String, String> extras) {
            k.e(extras, "extras");
            this.extras.putAll(extras);
            return this;
        }
    }

    public LoadOptions(String placementId, String str, Map<String, String> extras) {
        k.e(placementId, "placementId");
        k.e(extras, "extras");
        this.placementId = placementId;
        this.adMarkup = str;
        this.extras = extras;
    }

    public final String getAdMarkup() {
        return this.adMarkup;
    }

    public final Map<String, String> getExtras() {
        return this.extras;
    }

    public final String getPlacementId() {
        return this.placementId;
    }

    public /* synthetic */ LoadOptions(String str, String str2, Map map, int i2, f fVar) {
        this(str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? s.f13639a : map);
    }
}
