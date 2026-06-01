package com.bytedance.sdk.openadsdk.component.reward.MY;

import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.model.OOq;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.model.vAh;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Bc {
    @NonNull
    public static MY IlO(com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO) {
        oeT oet = ilO.MY;
        return ((oet instanceof vAh) && ((vAh) oet).dvD()) ? new vCE(ilO) : OOq.cL(oet) ? new NV(ilO) : (!lEW.IlO(oet) || EO.IlO(oet)) ? DmF.IlO(oet) ? new DmF(ilO) : NV.IlO(oet) ? new NV(ilO) : tV.IlO(oet) ? new tV(ilO) : EO.IlO(oet) ? new EO(ilO) : new Cc(ilO) : new lEW(ilO);
    }
}
