package com.bytedance.sdk.openadsdk.ea;

import com.bytedance.sdk.component.lEW.lEW;
import com.bytedance.sdk.openadsdk.core.vAh;
import com.bytedance.sdk.openadsdk.tV.IlO.vCE;
import com.bytedance.sdk.openadsdk.utils.mmj;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    /* JADX INFO: Access modifiers changed from: private */
    public static void EO() {
        com.bytedance.sdk.openadsdk.tV.IlO.IlO.MY();
        vCE.IlO();
        vAh.IlO();
    }

    public static void IlO() {
        if (mmj.vCE()) {
            mmj.IlO(new lEW("DailyTaskHelper") { // from class: com.bytedance.sdk.openadsdk.ea.IlO.1
                @Override // java.lang.Runnable
                public void run() {
                    IlO.EO();
                }
            });
        } else {
            EO();
        }
    }
}
