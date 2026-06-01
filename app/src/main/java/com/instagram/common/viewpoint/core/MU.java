package com.instagram.common.viewpoint.core;

import com.facebook.ads.internal.protocol.AdPlacementType;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class MU {
    public static MP A00;

    public final MP A00(final C1477dL c1477dL, AdPlacementType adPlacementType) {
        if (A00 != null) {
            return A00;
        }
        switch (adPlacementType) {
            case BANNER:
                return new C7L();
            case MEDIUM_RECTANGLE:
                if (U7.A1N(c1477dL)) {
                    return new C7K();
                }
                return new C7L();
            case INTERSTITIAL:
                return new C1778iS();
            case NATIVE:
                return new C1773iN(c1477dL);
            case NATIVE_BANNER:
                return new C1773iN(c1477dL) { // from class: com.facebook.ads.redexgen.X.7F
                    @Override // com.instagram.common.viewpoint.core.C1773iN, com.instagram.common.viewpoint.core.MP
                    public final AdPlacementType A8c() {
                        return AdPlacementType.NATIVE_BANNER;
                    }
                };
            case REWARDED_VIDEO:
                return new C7B();
            default:
                return null;
        }
    }
}
