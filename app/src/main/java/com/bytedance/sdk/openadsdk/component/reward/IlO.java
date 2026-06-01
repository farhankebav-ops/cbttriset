package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.model.oeT;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    public static void IlO(com.bytedance.sdk.openadsdk.core.model.IlO ilO, int i2, boolean z2) {
        if (ilO == null || ilO.tV() == null || ilO.tV().size() <= 0) {
            return;
        }
        if (i2 >= ilO.tV().size()) {
            i2 = 0;
        }
        oeT oet = ilO.tV().get(i2);
        Context contextIlO = cl.IlO();
        IlO(oet, !TextUtils.isEmpty(z2 ? rp.IlO(contextIlO).IlO(oet) : tV.IlO(contextIlO).IlO(oet)), z2);
    }

    public static void IlO(final oeT oet, final boolean z2, final boolean z7) {
        com.bytedance.sdk.openadsdk.core.bWL.MY().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.1
            @Override // java.lang.Runnable
            public void run() {
                oeT oet2 = oet;
                if (oet2 == null || oet2.uAj()) {
                    return;
                }
                try {
                    Context contextIlO = cl.IlO();
                    AdSlot adSlotSsS = oet.ssS();
                    if (adSlotSsS != null) {
                        int iMY = Cc.MY();
                        if (iMY == 0 || iMY == 2) {
                            if (z7) {
                                hp.IlO(contextIlO).IlO(adSlotSsS.getCodeId(), oet);
                            } else {
                                Cc.IlO(contextIlO).IlO(adSlotSsS.getCodeId(), oet);
                            }
                        }
                        if (z2) {
                            if (z7) {
                                hp.IlO(contextIlO).IlO(adSlotSsS);
                            } else {
                                Cc.IlO(contextIlO).IlO(adSlotSsS);
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
