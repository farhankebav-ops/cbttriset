package com.bytedance.sdk.openadsdk.core.settings;

import android.util.Log;
import com.bytedance.sdk.component.utils.oeT;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class DmF {
    private static final AtomicInteger IlO = new AtomicInteger(1);

    public static boolean IlO() {
        return IlO.get() == 1;
    }

    public static void IlO(int i2) {
        boolean z2 = true;
        if (i2 == 1 || i2 == 2) {
            try {
                AtomicInteger atomicInteger = IlO;
                if (atomicInteger.get() != i2) {
                    try {
                        atomicInteger.set(i2);
                    } catch (Throwable th) {
                        th = th;
                        oeT.EO("SdkSwitch", th.getMessage());
                    }
                } else {
                    z2 = false;
                }
            } catch (Throwable th2) {
                th = th2;
                z2 = false;
            }
            if (z2) {
                Log.e("SdkSwitch", "switch status changed: " + IlO());
                if (IlO()) {
                    com.bytedance.sdk.openadsdk.tV.IlO.tV.MY();
                } else {
                    com.bytedance.sdk.openadsdk.tV.IlO.tV.EO();
                }
            }
        }
    }
}
