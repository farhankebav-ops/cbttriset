package com.bytedance.sdk.openadsdk.tV.IlO;

import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.bytedance.sdk.openadsdk.utils.pP;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
class rp implements com.bytedance.sdk.openadsdk.ea.EO.MY {
    public static final rp IlO = new rp();

    private rp() {
    }

    @Override // com.bytedance.sdk.openadsdk.ea.EO.MY
    public void IlO(com.bytedance.sdk.openadsdk.ea.MY my) {
        IlO(my, false);
    }

    @Override // com.bytedance.sdk.openadsdk.ea.EO.MY
    public void IlO(final com.bytedance.sdk.openadsdk.ea.MY my, final boolean z2) {
        IlO(new com.bytedance.sdk.component.lEW.lEW("uploadLogEvent") { // from class: com.bytedance.sdk.openadsdk.tV.IlO.rp.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.ea.IlO.EO logStats = my.getLogStats();
                    if (logStats == null) {
                        return;
                    }
                    com.bytedance.sdk.component.vCE.IlO.tV.IlO.IlO ilO = new com.bytedance.sdk.component.vCE.IlO.tV.IlO.IlO(pP.IlO(), logStats.IlO());
                    ilO.EO((byte) 0);
                    ilO.MY(z2 ? (byte) 2 : (byte) 3);
                    ilO.IlO((byte) 1);
                    if (com.bytedance.sdk.component.vCE.IlO.MY.MY()) {
                        tV.IlO(cl.IlO(), com.bytedance.sdk.openadsdk.multipro.MY.EO());
                    }
                    com.bytedance.sdk.component.vCE.IlO.MY.IlO(ilO);
                } catch (Throwable unused) {
                }
            }
        });
    }

    private void IlO(com.bytedance.sdk.component.lEW.lEW lew) {
        if (lew == null) {
            return;
        }
        if (!mmj.Bc()) {
            mmj.MY(lew, 5);
        } else {
            lew.run();
        }
    }
}
