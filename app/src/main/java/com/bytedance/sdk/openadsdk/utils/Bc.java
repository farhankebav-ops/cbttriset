package com.bytedance.sdk.openadsdk.utils;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.analytics.FirebaseAnalytics;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Bc {
    private static long EO = 0;
    static int IlO = -1;
    static float MY;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO {
        public final int IlO;
        public final float MY;

        public IlO(int i2, float f4) {
            this.IlO = i2;
            this.MY = f4;
        }
    }

    private static void IlO(Intent intent) {
        if (intent.getIntExtra("status", -1) == 2) {
            IlO = 1;
        } else {
            IlO = 0;
        }
        MY = (intent.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1) * 100) / intent.getIntExtra("scale", -1);
    }

    @NonNull
    public static IlO IlO() {
        if (EO == 0 || SystemClock.elapsedRealtime() - EO > RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS) {
            Intent intentRegisterReceiver = com.bytedance.sdk.openadsdk.core.cl.IlO().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            Log.d("BatteryDataWatcher", "obtainCurrentState: registerReceiver result is ".concat(String.valueOf(intentRegisterReceiver)));
            if (intentRegisterReceiver != null) {
                IlO(intentRegisterReceiver);
                EO = SystemClock.elapsedRealtime();
            }
        }
        return new IlO(IlO, MY);
    }
}
