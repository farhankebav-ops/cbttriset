package com.google.android.gms.ads.preload;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.ResponseInfo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class PreloadCallbackV2 {
    public void onAdsExhausted(@NonNull String str) {
    }

    public void onAdFailedToPreload(@NonNull String str, @NonNull AdError adError) {
    }

    public void onAdPreloaded(@NonNull String str, @Nullable ResponseInfo responseInfo) {
    }
}
