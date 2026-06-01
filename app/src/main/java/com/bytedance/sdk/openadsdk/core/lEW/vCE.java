package com.bytedance.sdk.openadsdk.core.lEW;

import android.content.Context;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.openadsdk.utils.mmj;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE extends com.bytedance.sdk.component.adexpress.dynamic.IlO.IlO {
    private final com.bytedance.sdk.component.lEW.lEW EO;
    private final com.bytedance.sdk.component.adexpress.MY.hp IlO;
    private com.bytedance.sdk.component.adexpress.MY.Bc MY;
    private final Runnable tV;

    public vCE(Context context, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z2, com.bytedance.sdk.component.adexpress.dynamic.Cc.lEW lew, com.bytedance.sdk.component.adexpress.MY.hp hpVar, com.bytedance.sdk.component.adexpress.dynamic.vCE.IlO ilO) {
        super(context, themeStatusBroadcastReceiver, z2, lew, hpVar, ilO);
        this.EO = new com.bytedance.sdk.component.lEW.lEW("dynamic_render_template") { // from class: com.bytedance.sdk.openadsdk.core.lEW.vCE.1
            @Override // java.lang.Runnable
            public void run() {
                vCE.this.IlO.EO();
                com.bytedance.sdk.openadsdk.core.bWL.EO().post(vCE.this.tV);
            }
        };
        this.tV = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.lEW.vCE.2
            @Override // java.lang.Runnable
            public void run() {
                if (vCE.this.MY != null) {
                    vCE vce = vCE.this;
                    vCE.super.IlO(vce.MY);
                }
            }
        };
        this.IlO = hpVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.IlO.IlO
    public void MY() {
        super.MY();
        com.bytedance.sdk.openadsdk.core.bWL.EO().removeCallbacks(this.tV);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.IlO.IlO, com.bytedance.sdk.component.adexpress.MY.tV
    public void IlO(com.bytedance.sdk.component.adexpress.MY.Bc bc) {
        this.MY = bc;
        mmj.MY(this.EO);
    }
}
