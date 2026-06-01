package com.bytedance.sdk.openadsdk.tV.IlO;

import android.content.Context;
import com.bytedance.sdk.component.utils.oeT;
import com.bytedance.sdk.component.vCE.IlO.IlO;
import com.bytedance.sdk.openadsdk.core.cl;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV {
    public static AtomicInteger IlO = new AtomicInteger(0);
    public static final AtomicBoolean MY = new AtomicBoolean(false);

    public static void EO() {
        try {
            com.bytedance.sdk.component.vCE.IlO.MY.tV();
            com.bytedance.sdk.component.vCE.IlO.MY.Cc();
        } catch (Throwable th) {
            oeT.EO("AdLogSwitchUtils", th.getMessage());
        }
    }

    public static void IlO(Context context, boolean z2) {
        if (MY.compareAndSet(false, true)) {
            com.bytedance.sdk.component.vCE.IlO.MY.IlO(new IlO.C0061IlO().IlO(new NV()).MY(com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO.EO()).EO(com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO.Cc()).IlO(com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO.tV()).IlO(z2).IlO(new EV()).IlO(lEW.IlO).MY(cl.tV().hp()).IlO(cl.tV().bWL()).IlO(cl.tV().Hg()).IlO(), context);
            MY();
        }
    }

    public static void MY() {
        com.bytedance.sdk.component.vCE.IlO.MY.EO();
    }

    public static void IlO(com.bytedance.sdk.openadsdk.tV.IlO ilO) {
        com.bytedance.sdk.component.vCE.IlO.tV.IlO.IlO ilO2 = new com.bytedance.sdk.component.vCE.IlO.tV.IlO.IlO(ilO.tV(), ilO);
        ilO2.MY(ilO.Cc() ? (byte) 1 : (byte) 2);
        ilO2.IlO((byte) 0);
        if (com.bytedance.sdk.component.vCE.IlO.MY.MY()) {
            IlO(cl.IlO(), com.bytedance.sdk.openadsdk.multipro.MY.EO());
        }
        com.bytedance.sdk.component.vCE.IlO.MY.IlO(ilO2);
    }

    public static com.bytedance.sdk.openadsdk.ea.EO.MY IlO() {
        return rp.IlO;
    }

    public static void IlO(final List<String> list, final int i2, final String str) {
        if (list == null || list.isEmpty()) {
            return;
        }
        com.bytedance.sdk.openadsdk.tV.EO.IlO(new com.bytedance.sdk.component.lEW.lEW("track") { // from class: com.bytedance.sdk.openadsdk.tV.IlO.tV.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.bytedance.sdk.component.vCE.IlO.MY.MY()) {
                    tV.IlO(cl.IlO(), com.bytedance.sdk.openadsdk.multipro.MY.EO());
                }
                com.bytedance.sdk.component.vCE.IlO.MY.IlO(com.bytedance.sdk.openadsdk.core.rp.IlO(cl.IlO()), list, true, i2, str);
            }
        });
    }

    public static void IlO(String str) {
        IlO(str, false);
    }

    public static void IlO(String str, boolean z2) {
        if (com.bytedance.sdk.component.vCE.IlO.MY.MY()) {
            IlO(cl.IlO(), com.bytedance.sdk.openadsdk.multipro.MY.EO());
        }
        com.bytedance.sdk.component.vCE.IlO.MY.IlO(str, z2);
    }
}
