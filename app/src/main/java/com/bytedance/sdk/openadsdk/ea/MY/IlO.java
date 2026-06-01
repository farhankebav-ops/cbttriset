package com.bytedance.sdk.openadsdk.ea.MY;

import com.bytedance.sdk.component.lEW.EO;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.ea.IlO.tV;
import com.bytedance.sdk.openadsdk.ea.MY;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO implements EO {
    @Override // com.bytedance.sdk.component.lEW.EO
    public void IlO(final com.bytedance.sdk.component.lEW.MY.IlO ilO) {
        com.bytedance.sdk.openadsdk.ea.EO.IlO();
        com.bytedance.sdk.openadsdk.ea.EO.IlO("stats_sdk_thread_num", false, new MY() { // from class: com.bytedance.sdk.openadsdk.ea.MY.IlO.1
            @Override // com.bytedance.sdk.openadsdk.ea.MY
            public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                com.bytedance.sdk.component.lEW.MY.IlO ilO2;
                if (!cl.tV().KC() || (ilO2 = ilO) == null || ilO2.IlO() == null) {
                    return null;
                }
                return tV.MY().IlO("stats_sdk_thread_num").MY(ilO.IlO().toString());
            }
        });
    }
}
