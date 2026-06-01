package com.onesignal.location.internal.common;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class LocationConstants {
    public static final String ANDROID_BACKGROUND_LOCATION_PERMISSION_STRING = "android.permission.ACCESS_BACKGROUND_LOCATION";
    public static final String ANDROID_COARSE_LOCATION_PERMISSION_STRING = "android.permission.ACCESS_COARSE_LOCATION";
    public static final String ANDROID_FINE_LOCATION_PERMISSION_STRING = "android.permission.ACCESS_FINE_LOCATION";
    public static final long BACKGROUND_UPDATE_TIME_MS = 570000;
    public static final long FOREGROUND_UPDATE_TIME_MS = 270000;
    public static final LocationConstants INSTANCE = new LocationConstants();
    public static final long TIME_BACKGROUND_SEC = 600;
    public static final long TIME_FOREGROUND_SEC = 300;

    private LocationConstants() {
    }
}
