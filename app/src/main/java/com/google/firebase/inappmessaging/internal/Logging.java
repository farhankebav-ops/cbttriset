package com.google.firebase.inappmessaging.internal;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class Logging {
    public static final String TAG = "FIAM.Headless";

    public static void logd(String str) {
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, str);
        }
    }

    public static void loge(String str) {
        Log.e(TAG, str);
    }

    public static void logi(String str) {
        if (Log.isLoggable(TAG, 4)) {
            Log.i(TAG, str);
        }
    }

    public static void logw(String str) {
        Log.w(TAG, str);
    }
}
