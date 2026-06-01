package com.bytedance.sdk.openadsdk.utils;

import android.content.res.Configuration;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class oc {
    private static String EO = null;
    private static String IlO = null;
    private static String MY = null;
    private static volatile boolean tV = true;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO extends com.bytedance.sdk.component.lEW.lEW {
        public static AtomicBoolean IlO = new AtomicBoolean(false);
        private static final AtomicLong MY = new AtomicLong(0);

        public IlO(String str, int i2) {
            super(str, i2);
        }

        public static void IlO() {
            if (IlO.get()) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            AtomicLong atomicLong = MY;
            if (jCurrentTimeMillis - atomicLong.get() < TTAdConstant.AD_MAX_EVENT_TIME) {
                return;
            }
            atomicLong.set(jCurrentTimeMillis);
            mmj.MY((com.bytedance.sdk.component.lEW.lEW) new IlO("UpdateSimStatusTask", 5));
        }

        @Override // java.lang.Runnable
        public void run() {
            IlO.set(true);
            oc.Cc();
            IlO.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Cc() {
        String simOperatorName;
        String simOperator;
        String strSubstring;
        if (com.bytedance.sdk.openadsdk.core.cl.IlO() == null) {
            return;
        }
        tV = true;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) com.bytedance.sdk.openadsdk.core.cl.IlO().getSystemService("phone");
            try {
                int simState = telephonyManager.getSimState();
                if (simState == 0 || simState == 1) {
                    tV = false;
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.oeT.EO("SimUtils", th.getMessage());
            }
            String str = null;
            try {
                simOperatorName = telephonyManager.getSimOperatorName();
            } catch (Throwable unused) {
                simOperatorName = null;
            }
            try {
                simOperator = telephonyManager.getNetworkOperator();
            } catch (Throwable unused2) {
                simOperator = null;
            }
            if (simOperator == null || simOperator.length() < 5) {
                try {
                    simOperator = telephonyManager.getSimOperator();
                } catch (Throwable unused3) {
                }
            }
            if (TextUtils.isEmpty(simOperator) || simOperator.length() <= 4) {
                strSubstring = null;
            } else {
                String strSubstring2 = simOperator.substring(0, 3);
                strSubstring = simOperator.substring(3);
                str = strSubstring2;
            }
            if (!TextUtils.isEmpty(simOperatorName)) {
                IlO = simOperatorName;
            }
            if (!TextUtils.isEmpty(str)) {
                MY = str;
            }
            if (TextUtils.isEmpty(strSubstring)) {
                return;
            }
            EO = strSubstring;
        } catch (Throwable unused4) {
        }
    }

    public static String EO() {
        IlO.IlO();
        return EO;
    }

    public static String IlO() {
        IlO.IlO();
        return IlO;
    }

    public static String MY() {
        try {
            IlO.IlO();
            if (!tV) {
                StringBuilder sb = new StringBuilder("getMCC");
                sb.append(tV ? "Have SIM card" : "No SIM card, MCC returns null");
                com.bytedance.sdk.component.utils.oeT.EO("MCC", sb.toString());
                return null;
            }
            Configuration configuration = com.bytedance.sdk.openadsdk.core.cl.IlO().getResources().getConfiguration();
            int i2 = configuration.mcc;
            String strValueOf = i2 != 0 ? String.valueOf(i2) : MY;
            com.bytedance.sdk.component.utils.oeT.EO("MCC", "config=" + configuration.mcc + ",sMCC=" + MY);
            return strValueOf;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("SimUtils", th.getMessage());
            return null;
        }
    }
}
