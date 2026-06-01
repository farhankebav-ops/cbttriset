package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public interface CustomEventNative extends CustomEvent {
    void requestNativeAd(@NonNull Context context, @NonNull CustomEventNativeListener customEventNativeListener, @Nullable String str, @NonNull NativeMediationAdRequest nativeMediationAdRequest, @Nullable Bundle bundle);
}
