package com.bytedance.sdk.openadsdk.core.NV.EO;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.lEW.bWL;
import com.bytedance.sdk.openadsdk.core.model.ea;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.vSq;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {
    private oeT EO;
    private EO IlO;
    private Context MY;
    private com.bytedance.sdk.openadsdk.core.NV.EO.IlO tV;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO {
        public static EO IlO(Context context, oeT oet) {
            if (ea.IlO(oet)) {
                return new tV(context, oet);
            }
            return null;
        }
    }

    public MY(Context context, oeT oet) {
        this.MY = context;
        this.EO = oet;
    }

    public void EO() {
        EO eo = this.IlO;
        if (eo != null) {
            eo.EO();
        }
    }

    public void IlO(bWL bwl) {
        EO eoIlO = IlO.IlO(this.MY, this.EO);
        this.IlO = eoIlO;
        if (eoIlO != null) {
            eoIlO.IlO();
            this.IlO.IlO(bwl);
        }
    }

    public View MY() {
        EO eo = this.IlO;
        if (eo != null) {
            return eo.tV();
        }
        return null;
    }

    public void IlO(com.bytedance.sdk.openadsdk.core.NV.EO.IlO ilO) {
        this.tV = ilO;
        EO eo = this.IlO;
        if (eo != null) {
            eo.IlO(ilO);
        }
    }

    public void IlO(int i2) {
        vSq vsqCc;
        EO eo = this.IlO;
        if (!(eo instanceof tV) || (vsqCc = ((tV) eo).Cc()) == null || vsqCc.IlO() == null) {
            return;
        }
        vsqCc.IlO().IlO(i2);
    }

    public void IlO() {
        EO eo = this.IlO;
        if (eo != null) {
            eo.MY();
        }
    }
}
