package com.bytedance.sdk.openadsdk.kBB.IlO;

import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.sdk.component.utils.lEW;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    private static Handler IlO;
    private static HandlerThread MY;

    public static Handler IlO() {
        try {
            HandlerThread handlerThread = MY;
            if (handlerThread == null || !handlerThread.isAlive()) {
                synchronized (IlO.class) {
                    try {
                        HandlerThread handlerThread2 = MY;
                        if (handlerThread2 == null || !handlerThread2.isAlive()) {
                            MY = lEW.IlO("csj_ev");
                            IlO = new Handler(MY.getLooper());
                        }
                    } finally {
                    }
                }
            } else if (IlO == null) {
                synchronized (IlO.class) {
                    try {
                        if (IlO == null) {
                            IlO = new Handler(MY.getLooper());
                        }
                    } finally {
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return IlO;
    }
}
