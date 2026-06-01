package com.onesignal.common;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class OneSignalWrapper {
    public static final OneSignalWrapper INSTANCE = new OneSignalWrapper();
    private static String sdkType;
    private static String sdkVersion;

    private OneSignalWrapper() {
    }

    public static final String getSdkType() {
        return sdkType;
    }

    public static final String getSdkVersion() {
        return sdkVersion;
    }

    public static final void setSdkType(String str) {
        sdkType = str;
    }

    public static final void setSdkVersion(String str) {
        sdkVersion = str;
    }

    public static /* synthetic */ void getSdkType$annotations() {
    }

    public static /* synthetic */ void getSdkVersion$annotations() {
    }
}
