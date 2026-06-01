package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.ironsource.C2461n2;
import com.ironsource.mediationsdk.d;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vSq {
    public static void IlO(com.bytedance.sdk.openadsdk.core.model.oeT oet, Double d8) {
        if (oet == null || oet.tN() == null) {
            return;
        }
        Map<String, Object> mapTN = oet.tN();
        try {
            Object obj = oet.tN().get(TTAdConstant.SDK_BIDDING_TYPE);
            if (obj != null && Integer.parseInt(obj.toString()) == 2) {
                String strReplace = (String) mapTN.get(C2461n2.A);
                if (TextUtils.isEmpty(strReplace)) {
                    return;
                }
                if (d8 != null) {
                    strReplace = strReplace.replace("${AUCTION_BID_TO_WIN}", String.valueOf(d8));
                }
                com.bytedance.sdk.openadsdk.core.cl.EO().IlO(strReplace);
            }
        } catch (Throwable unused) {
            com.bytedance.sdk.component.utils.oeT.EO("report Win error", new Object[0]);
        }
    }

    public static void IlO(com.bytedance.sdk.openadsdk.core.model.oeT oet, Double d8, String str, String str2) {
        if (oet == null || oet.tN() == null) {
            return;
        }
        Map<String, Object> mapTN = oet.tN();
        try {
            Object obj = oet.tN().get(TTAdConstant.SDK_BIDDING_TYPE);
            if (obj != null && Integer.parseInt(obj.toString()) == 2) {
                String strReplace = (String) mapTN.get(C2461n2.f9474z);
                if (TextUtils.isEmpty(strReplace)) {
                    return;
                }
                if (d8 != null) {
                    strReplace = strReplace.replace(d.f9039n, String.valueOf(d8));
                }
                if (str != null) {
                    strReplace = strReplace.replace(d.l, str);
                }
                if (str2 != null) {
                    strReplace = strReplace.replace("${AUCTION_WINNER}", str2);
                }
                com.bytedance.sdk.openadsdk.core.cl.EO().IlO(strReplace);
            }
        } catch (Throwable unused) {
            com.bytedance.sdk.component.utils.oeT.EO("report Loss error", new Object[0]);
        }
    }
}
