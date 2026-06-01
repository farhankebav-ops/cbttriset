package com.bytedance.sdk.component.adexpress.dynamic.MY;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.dynamic.tV.Bc;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    public static int IlO(Bc bc) {
        if (bc == null) {
            return 0;
        }
        String strDM = bc.DM();
        String strKBB = bc.kBB();
        if (TextUtils.isEmpty(strKBB) || TextUtils.isEmpty(strDM) || !strKBB.equals("creative")) {
            return 0;
        }
        if (strDM.equals("shake")) {
            return 2;
        }
        if (strDM.equals("twist")) {
            return 3;
        }
        return strDM.equals("slide") ? 1 : 0;
    }
}
