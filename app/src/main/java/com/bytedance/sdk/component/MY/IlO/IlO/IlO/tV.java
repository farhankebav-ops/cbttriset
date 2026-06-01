package com.bytedance.sdk.component.MY.IlO.IlO.IlO;

import android.text.TextUtils;
import com.bytedance.sdk.component.MY.IlO.EV;
import com.bytedance.sdk.component.MY.IlO.rp;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV extends EV {
    public IlO DmF;
    public vCE lEW;

    public tV(EV.IlO ilO) {
        super(ilO);
        vCE vce = new vCE();
        this.lEW = vce;
        this.DmF = new IlO(vce.MY());
    }

    @Override // com.bytedance.sdk.component.MY.IlO.EV
    public com.bytedance.sdk.component.MY.IlO.tV IlO() {
        return this.lEW;
    }

    @Override // com.bytedance.sdk.component.MY.IlO.EV
    public com.bytedance.sdk.component.MY.IlO.MY IlO(rp rpVar) {
        rpVar.IlO(this);
        if (rpVar.MY() == null || rpVar.MY().IlO() == null || TextUtils.isEmpty(rpVar.MY().IlO().toString())) {
            return null;
        }
        if (IlO.IlO == null || !IlO.IlO.MY() || !this.DmF.Cc() || "setting".equals(rpVar.vCE())) {
            MY my = new MY(rpVar, this.lEW);
            this.lEW.EO().add(my);
            return my;
        }
        MY my2 = new MY(rpVar, this.DmF);
        this.DmF.EO().add(my2);
        return my2;
    }
}
