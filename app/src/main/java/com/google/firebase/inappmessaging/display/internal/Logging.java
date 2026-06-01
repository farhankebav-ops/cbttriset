package com.google.firebase.inappmessaging.display.internal;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class Logging {
    private static final String TAG = "FIAM.Display";

    public static void logd(String str) {
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, str);
        }
    }

    public static void logdHeader(String str) {
        logd("============ " + str + " ============");
    }

    public static void logdNumber(String str, float f4) {
        logd(str + ": " + f4);
    }

    public static void logdPair(String str, float f4, float f8) {
        logd(str + ": (" + f4 + ", " + f8 + ")");
    }

    public static void loge(String str) {
        Log.e(TAG, str);
    }

    public static void logi(String str) {
        if (Log.isLoggable(TAG, 4)) {
            Log.i(TAG, str);
        }
    }
}
