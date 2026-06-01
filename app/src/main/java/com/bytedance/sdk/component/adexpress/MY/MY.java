package com.bytedance.sdk.component.adexpress.MY;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.adexpress.MY.NV;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY implements NV {
    private hp Cc;
    private ThemeStatusBroadcastReceiver EO;
    private Context IlO;
    private com.bytedance.sdk.component.adexpress.dynamic.IlO.IlO MY;
    private lEW tV;
    private int vCE;

    public MY(Context context, hp hpVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z2, com.bytedance.sdk.component.adexpress.dynamic.Cc.lEW lew, lEW lew2, com.bytedance.sdk.component.adexpress.dynamic.vCE.IlO ilO, com.bytedance.sdk.component.adexpress.dynamic.IlO.IlO ilO2) {
        this.IlO = context;
        this.Cc = hpVar;
        this.EO = themeStatusBroadcastReceiver;
        this.tV = lew2;
        if (ilO2 != null) {
            this.MY = ilO2;
        } else {
            this.MY = new com.bytedance.sdk.component.adexpress.dynamic.IlO.IlO(context, themeStatusBroadcastReceiver, z2, lew, hpVar, ilO);
        }
        this.MY.IlO(this.tV);
        if (lew instanceof com.bytedance.sdk.component.adexpress.dynamic.Cc.Bc) {
            this.vCE = 3;
        } else {
            this.vCE = 2;
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.NV
    public boolean IlO(final NV.IlO ilO) {
        this.Cc.Cc().IlO(this.vCE);
        this.MY.IlO(new Bc() { // from class: com.bytedance.sdk.component.adexpress.MY.MY.1
            @Override // com.bytedance.sdk.component.adexpress.MY.Bc
            public void IlO(View view, bWL bwl) {
                if (ilO.EO()) {
                    return;
                }
                MY.this.Cc.Cc().Cc(MY.this.vCE);
                MY.this.Cc.Cc().vCE(MY.this.vCE);
                MY.this.Cc.Cc().NV();
                ea eaVarMY = ilO.MY();
                if (eaVarMY == null) {
                    return;
                }
                eaVarMY.IlO(MY.this.MY, bwl);
                ilO.IlO(true);
            }

            @Override // com.bytedance.sdk.component.adexpress.MY.Bc
            public void IlO(int i2, String str) {
                MY.this.Cc.Cc().IlO(MY.this.vCE, i2, str, ilO.MY(MY.this));
                if (ilO.MY(MY.this)) {
                    ilO.IlO(MY.this);
                    return;
                }
                ea eaVarMY = ilO.MY();
                if (eaVarMY == null) {
                    return;
                }
                eaVarMY.a_(i2);
            }
        });
        return true;
    }

    public com.bytedance.sdk.component.adexpress.dynamic.tV MY() {
        com.bytedance.sdk.component.adexpress.dynamic.IlO.IlO ilO = this.MY;
        if (ilO != null) {
            return ilO.tV();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.NV
    public void IlO() {
        com.bytedance.sdk.component.adexpress.dynamic.IlO.IlO ilO = this.MY;
        if (ilO != null) {
            ilO.MY();
        }
    }
}
