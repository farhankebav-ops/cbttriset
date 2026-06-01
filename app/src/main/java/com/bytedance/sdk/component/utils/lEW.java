package com.bytedance.sdk.component.utils;

import android.os.HandlerThread;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class lEW {
    private static HandlerThread IlO;

    public static void IlO(HandlerThread handlerThread) {
        IlO = handlerThread;
    }

    public static HandlerThread IlO(String str) {
        return IlO(str, 0);
    }

    public static HandlerThread IlO(String str, int i2) {
        if (com.bytedance.sdk.component.lEW.DmF.sCrashHappened) {
            return IlO;
        }
        try {
            HandlerThread handlerThread = new HandlerThread(str, i2) { // from class: com.bytedance.sdk.component.utils.lEW.1
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
            handlerThread.start();
            return handlerThread;
        } catch (Throwable th) {
            oeT.IlO("HandlerThreadUtils", "new handlerThread error", th);
            return IlO;
        }
    }
}
