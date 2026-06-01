package com.google.ads.mediation.facebook;

import com.facebook.ads.internal.settings.AdSdkVersion;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class FacebookSdkWrapper {
    public static final FacebookSdkWrapper INSTANCE = new FacebookSdkWrapper();

    private FacebookSdkWrapper() {
    }

    public static final String getSdkVersion() {
        return AdSdkVersion.BUILD;
    }

    public static /* synthetic */ void getSdkVersion$annotations() {
    }
}
