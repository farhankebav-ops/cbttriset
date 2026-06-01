package com.bytedance.sdk.component.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class wPn {
    private static final Object IlO = new Object();
    private static final Map<IlO, Object> MY = new ConcurrentHashMap();
    private static AtomicBoolean EO = new AtomicBoolean(false);
    private static volatile int tV = -1;
    private static volatile long Cc = 0;
    private static volatile int vCE = 60000;
    private static AXM Bc = null;
    private static final AtomicBoolean lEW = new AtomicBoolean(false);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface IlO {
        void IlO(Context context, Intent intent, boolean z2, int i2);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class MY extends BroadcastReceiver {
        private MY() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z2 = false;
            boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
            if (wPn.MY != null && wPn.MY.size() > 0) {
                z2 = true;
            }
            wPn.MY(context, intent, z2, booleanExtra);
        }
    }

    private static int EO(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    return type != 1 ? 1 : 4;
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                        return 2;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                    case 17:
                        return 3;
                    case 13:
                    case 18:
                    case 19:
                        AXM axm = Bc;
                        return (axm == null || !axm.IlO(context, telephonyManager)) ? 5 : 6;
                    case 20:
                        return 6;
                    default:
                        String subtypeName = activeNetworkInfo.getSubtypeName();
                        return (TextUtils.isEmpty(subtypeName) || !(subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000"))) ? 1 : 3;
                }
            }
            return 0;
        } catch (Throwable unused) {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void MY(final Context context, final Intent intent, final boolean z2, final boolean z7) {
        if (!z2 && z7) {
            tV = 0;
        } else if (lEW.compareAndSet(false, true)) {
            com.bytedance.sdk.component.lEW.vCE.MY(new com.bytedance.sdk.component.lEW.lEW("getNetworkType") { // from class: com.bytedance.sdk.component.utils.wPn.1
                @Override // java.lang.Runnable
                public void run() {
                    int unused = wPn.tV = z7 ? 0 : wPn.MY(context);
                    wPn.lEW.set(false);
                    if (z2) {
                        wPn.MY(context, intent, wPn.tV, z7);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void MY(Context context, Intent intent, int i2, boolean z2) {
        Map<IlO, Object> map = MY;
        if (map == null || map.size() <= 0) {
            return;
        }
        for (IlO ilO : map.keySet()) {
            if (ilO != null) {
                ilO.IlO(context, intent, !z2, i2);
            }
        }
    }

    public static int IlO(Context context, long j) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (Cc + j <= jElapsedRealtime) {
            return MY(context);
        }
        if (tV == -1) {
            return MY(context);
        }
        if (jElapsedRealtime - Cc >= vCE) {
            MY(context, (Intent) null, false, false);
        }
        return tV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int MY(Context context) {
        tV = EO(context);
        Cc = SystemClock.elapsedRealtime();
        return tV;
    }

    public static void IlO(IlO ilO, Context context) {
        if (ilO == null) {
            return;
        }
        if (!EO.get()) {
            try {
                context.registerReceiver(new MY(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                EO.set(true);
            } catch (Throwable unused) {
            }
        }
        MY.put(ilO, IlO);
    }

    public static void IlO(IlO ilO) {
        if (ilO == null) {
            return;
        }
        MY.remove(ilO);
    }
}
