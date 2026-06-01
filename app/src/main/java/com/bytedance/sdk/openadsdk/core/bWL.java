package com.bytedance.sdk.openadsdk.core;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.camera.core.processing.util.a;
import androidx.work.WorkRequest;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.ironsource.C2300e4;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class bWL {
    private static volatile HandlerThread Bc = null;
    public static long Cc = 0;
    public static volatile boolean IlO = false;
    public static AtomicBoolean MY = new AtomicBoolean(false);
    public static long EO = 0;
    private static volatile int vCE = 0;
    public static float tV = 1.0f;
    private static volatile Handler lEW = null;

    static {
        HandlerThread handlerThread = new HandlerThread("csj_init_handle", 10) { // from class: com.bytedance.sdk.openadsdk.core.bWL.1
            boolean IlO = false;

            @Override // java.lang.Thread
            public synchronized void start() {
                if (this.IlO) {
                    return;
                }
                this.IlO = true;
                super.start();
            }
        };
        Bc = handlerThread;
        handlerThread.start();
        com.bytedance.sdk.component.utils.lEW.IlO(Bc);
        Cc = System.currentTimeMillis();
    }

    public static void Bc() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - EO <= WorkRequest.MIN_BACKOFF_MILLIS) {
            return;
        }
        synchronized (bWL.class) {
            try {
                if (jElapsedRealtime - EO <= WorkRequest.MIN_BACKOFF_MILLIS) {
                    return;
                }
                EO = jElapsedRealtime;
                com.bytedance.sdk.component.utils.DmF.IlO().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.bWL.3
                    @Override // java.lang.Runnable
                    public void run() {
                        String strEO = com.bytedance.sdk.openadsdk.core.settings.hp.EO(cl.IlO());
                        if (TextUtils.equals(strEO, com.bytedance.sdk.openadsdk.core.settings.hp.tV)) {
                            return;
                        }
                        com.bytedance.sdk.openadsdk.core.settings.hp.aP().IlO(6, true);
                        com.bytedance.sdk.openadsdk.core.settings.hp.tV = strEO;
                    }
                });
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean Cc() {
        return tV() == 1;
    }

    public static Handler EO() {
        return new Handler(Looper.getMainLooper());
    }

    public static void IlO(long j) {
        Cc = j;
    }

    public static Handler MY() {
        if (Bc == null || !Bc.isAlive()) {
            synchronized (bWL.class) {
                try {
                    if (Bc == null || !Bc.isAlive()) {
                        Bc = com.bytedance.sdk.component.utils.lEW.IlO("csj_init_handle", -1);
                        lEW = new Handler(Bc.getLooper());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else if (lEW == null) {
            synchronized (bWL.class) {
                try {
                    if (lEW == null) {
                        lEW = new Handler(Bc.getLooper());
                    }
                } finally {
                }
            }
        }
        return lEW;
    }

    public static void lEW() {
        MY().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.bWL.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.cl.EO.IlO(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.core.bWL.4.1
                        @Override // com.bytedance.sdk.openadsdk.cl.tV
                        public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                            return a.d(C2300e4.a.f8295f);
                        }
                    });
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.oeT.EO("InitHelper", th.getMessage());
                }
            }
        });
    }

    public static int tV() {
        return vCE;
    }

    public static void vCE() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - EO <= WorkRequest.MIN_BACKOFF_MILLIS) {
            return;
        }
        EO = jElapsedRealtime;
        mmj.IlO(new com.bytedance.sdk.component.lEW.lEW("onSharedPreferenceChanged") { // from class: com.bytedance.sdk.openadsdk.core.bWL.2
            @Override // java.lang.Runnable
            public void run() {
                String strEO = com.bytedance.sdk.openadsdk.core.settings.hp.EO(cl.IlO());
                if (TextUtils.equals(strEO, com.bytedance.sdk.openadsdk.core.settings.hp.tV)) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.settings.hp.aP().IlO(6, true);
                com.bytedance.sdk.openadsdk.core.settings.hp.tV = strEO;
            }
        });
    }

    public static long IlO() {
        return Cc;
    }

    public static void IlO(int i2) {
        vCE = i2;
    }

    public static void IlO(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                if ("mediation".equals(jSONObject.optString("name", ""))) {
                    DmF.MY().MY(jSONObject.optString("value", ""));
                    return;
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("InitHelper", th.getMessage());
        }
    }
}
