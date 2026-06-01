package com.mimikridev.utilmanager.security;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class Dataku {
    private static final String TAG = "Dataku";

    static {
        try {
            System.loadLibrary("mimikridev_native");
            Log.d(TAG, "Native library loaded");
        } catch (UnsatisfiedLinkError e) {
            Log.e(TAG, "Failed to load native library", e);
        }
    }

    public static native String SALT();

    public static native String SECRETPASSPHRASE();

    public static native String apiKey();

    public static native String apiKeyConfig();

    public static native String apiKeyStatistik();

    public static native String domainServer();

    public static native String keyEnkripsi();

    public static native String keyId();

    public static native String keyUnix();

    public static native String oneSignalId();

    public static native String urlApiServer();

    public static native String urlStatistik();
}
