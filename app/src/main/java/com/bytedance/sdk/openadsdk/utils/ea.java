package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.model.NV;
import com.bytedance.sdk.openadsdk.oem.IPMiBroadcastReceiver;
import com.ironsource.C2318f4;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class ea implements com.bytedance.sdk.openadsdk.oem.IlO {
    private static boolean EO;
    private static final ea IlO = new ea();
    private static com.bytedance.sdk.openadsdk.component.reward.IlO.IlO MY;

    public static void IlO(com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO) {
        com.bytedance.sdk.openadsdk.core.model.tl tlVarIWr = ilO.MY.IWr();
        if (tlVarIWr == null || !tlVarIWr.Bc()) {
            return;
        }
        MY = ilO;
        IPMiBroadcastReceiver iPMiBroadcastReceiverIlO = IPMiBroadcastReceiver.IlO(ilO.gQ);
        if (iPMiBroadcastReceiverIlO != null) {
            iPMiBroadcastReceiverIlO.IlO(IlO);
        }
    }

    public static void MY() {
        EO = true;
    }

    public static void IlO() {
        if (MY == null) {
            return;
        }
        MY = null;
        IPMiBroadcastReceiver iPMiBroadcastReceiverIlO = IPMiBroadcastReceiver.IlO(com.bytedance.sdk.openadsdk.core.cl.IlO());
        if (iPMiBroadcastReceiverIlO != null) {
            iPMiBroadcastReceiverIlO.IlO();
        }
        EO = false;
    }

    @Override // com.bytedance.sdk.openadsdk.oem.IlO
    public void IlO(String str, final int i2) {
        com.bytedance.sdk.openadsdk.core.model.tV tVVarVH;
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = MY;
        if (ilO == null || (tVVarVH = ilO.MY.VH()) == null) {
            return;
        }
        String strEO = tVVarVH.EO();
        if (TextUtils.isEmpty(strEO) || !strEO.equals(str)) {
            return;
        }
        mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.utils.ea.1
            @Override // java.lang.Runnable
            public void run() {
                int i8;
                if (ea.MY == null || (i8 = i2) <= 0 || i8 > 5) {
                    return;
                }
                boolean z2 = true;
                boolean z7 = i8 == 1;
                if (ea.EO) {
                    ea.MY.ssS.tV();
                    HashMap map = new HashMap();
                    map.put("click_scence", 4);
                    com.bytedance.sdk.openadsdk.tV.EO.IlO(C2318f4.f8523d, ea.MY.MY, new NV.IlO().IlO(), ea.MY.Cc, true, (Map<String, Object>) map, 1);
                } else {
                    z2 = z7;
                }
                if (z2) {
                    ea.IlO();
                }
            }
        });
    }
}
