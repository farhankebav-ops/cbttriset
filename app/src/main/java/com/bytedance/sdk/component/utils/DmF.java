package com.bytedance.sdk.component.utils;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class DmF {
    private static volatile Handler IlO;

    public static Handler IlO() {
        return com.bytedance.sdk.component.lEW.IlO.IlO.IlO().MY();
    }

    public static Handler MY() {
        if (IlO == null) {
            synchronized (DmF.class) {
                try {
                    if (IlO == null) {
                        IlO = new Handler(Looper.getMainLooper());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return IlO;
    }
}
