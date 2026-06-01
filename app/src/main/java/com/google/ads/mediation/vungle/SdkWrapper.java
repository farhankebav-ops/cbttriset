package com.google.ads.mediation.vungle;

import android.content.Context;
import com.vungle.ads.InitializationListener;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public interface SdkWrapper {
    String getBiddingToken(Context context);

    String getSdkVersion();

    void init(Context context, String str, InitializationListener initializationListener);

    boolean isInitialized();
}
