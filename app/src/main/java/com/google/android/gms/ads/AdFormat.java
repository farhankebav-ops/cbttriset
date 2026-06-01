package com.google.android.gms.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public enum AdFormat {
    BANNER(0),
    INTERSTITIAL(1),
    REWARDED(2),
    REWARDED_INTERSTITIAL(3),
    NATIVE(4),
    APP_OPEN_AD(6);

    private final int zza;

    AdFormat(int i2) {
        this.zza = i2;
    }

    @Nullable
    public static AdFormat getAdFormat(int i2) {
        for (AdFormat adFormat : values()) {
            if (adFormat.getValue() == i2) {
                return adFormat;
            }
        }
        return null;
    }

    public int getValue() {
        return this.zza;
    }
}
