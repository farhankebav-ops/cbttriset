package com.bytedance.sdk.component.adexpress.MY;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.adexpress.MY.NV;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE implements NV {
    private hp EO;
    private Context IlO;
    private IlO MY;

    public vCE(Context context, hp hpVar, IlO ilO) {
        this.IlO = context;
        this.MY = ilO;
        this.EO = hpVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.NV
    public void IlO() {
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.NV
    public boolean IlO(final NV.IlO ilO) {
        this.EO.Cc().vCE();
        this.MY.IlO(new Bc() { // from class: com.bytedance.sdk.component.adexpress.MY.vCE.1
            @Override // com.bytedance.sdk.component.adexpress.MY.Bc
            public void IlO(View view, bWL bwl) {
                if (ilO.EO()) {
                    return;
                }
                ea eaVarMY = ilO.MY();
                if (eaVarMY != null) {
                    eaVarMY.IlO(vCE.this.MY, bwl);
                }
                ilO.IlO(true);
            }

            @Override // com.bytedance.sdk.component.adexpress.MY.Bc
            public void IlO(int i2, String str) {
                ea eaVarMY = ilO.MY();
                if (eaVarMY != null) {
                    eaVarMY.a_(i2);
                }
            }
        });
        return true;
    }

    public void IlO(EO eo) {
        this.MY.IlO(eo);
    }
}
