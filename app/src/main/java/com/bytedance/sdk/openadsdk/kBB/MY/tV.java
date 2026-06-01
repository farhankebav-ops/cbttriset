package com.bytedance.sdk.openadsdk.kBB.MY;

import com.bytedance.sdk.openadsdk.core.EV.MY.EO;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.kBB.MY.Cc;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.bytedance.sdk.openadsdk.utils.zLG;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV {
    public static void IlO(final oeT oet, final IlO ilO, final Cc.IlO ilO2) {
        oet.NI();
        mmj.EO(new com.bytedance.sdk.component.lEW.lEW("mrc_report") { // from class: com.bytedance.sdk.openadsdk.kBB.MY.tV.1
            @Override // java.lang.Runnable
            public void run() {
                if (oet.ct()) {
                    if (oet.pS()) {
                        com.bytedance.sdk.openadsdk.core.EV.MY.EO.IlO(oet.qvT(), new EO.MY("show_urls", oet));
                    } else {
                        com.bytedance.sdk.openadsdk.tV.EO.IlO(oet);
                    }
                }
                String strIlO = zLG.IlO(oet);
                JSONObject jSONObject = new JSONObject();
                IlO ilO3 = ilO;
                if (ilO3 != null) {
                    try {
                        jSONObject.put("root_view", IlO.IlO(ilO3));
                        Cc.IlO ilO4 = ilO2;
                        if (ilO4 != null) {
                            int i2 = ilO4.IlO;
                            if (i2 != -1) {
                                jSONObject.put("dynamic_show_type", i2);
                            }
                            int i8 = ilO2.MY;
                            if (i8 != -1) {
                                com.bytedance.sdk.openadsdk.tV.EO.IlO(i8 + 1, jSONObject);
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
                com.bytedance.sdk.openadsdk.tV.EO.MY(oet, strIlO, "mrc_show", jSONObject);
            }
        });
    }
}
