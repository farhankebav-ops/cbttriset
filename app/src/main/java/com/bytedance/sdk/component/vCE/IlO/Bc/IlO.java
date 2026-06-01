package com.bytedance.sdk.component.vCE.IlO.Bc;

import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.sdk.component.vCE.IlO.Cc;
import com.bytedance.sdk.component.vCE.IlO.lEW;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    private static int EO = 3000;
    private static volatile HandlerThread IlO;
    private static volatile Handler MY;

    static {
        EO();
    }

    private static void EO() {
        HandlerThread handlerThreadIlO;
        Cc ccZPa = lEW.Bc().zPa();
        if (ccZPa != null && (handlerThreadIlO = ccZPa.IlO("csj_ad_log", 10)) != null) {
            IlO = handlerThreadIlO;
            return;
        }
        HandlerThread handlerThread = new HandlerThread("csj_ad_log", 10);
        IlO = handlerThread;
        handlerThread.start();
    }

    public static Handler IlO() {
        if (IlO == null || !IlO.isAlive()) {
            synchronized (IlO.class) {
                try {
                    if (IlO == null || !IlO.isAlive()) {
                        EO();
                        MY = new Handler(IlO.getLooper());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else if (MY == null) {
            synchronized (IlO.class) {
                try {
                    if (MY == null) {
                        MY = new Handler(IlO.getLooper());
                    }
                } finally {
                }
            }
        }
        return MY;
    }

    public static int MY() {
        if (EO <= 0) {
            EO = 3000;
        }
        return EO;
    }
}
