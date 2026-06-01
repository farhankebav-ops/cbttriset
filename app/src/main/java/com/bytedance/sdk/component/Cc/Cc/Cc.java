package com.bytedance.sdk.component.Cc.Cc;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc extends IlO {
    private byte[] IlO;
    private com.bytedance.sdk.component.Cc.vCE MY;

    public Cc(byte[] bArr, com.bytedance.sdk.component.Cc.vCE vce) {
        this.IlO = bArr;
        this.MY = vce;
    }

    @Override // com.bytedance.sdk.component.Cc.Cc.DmF
    public void IlO(com.bytedance.sdk.component.Cc.EO.EO eo) {
        com.bytedance.sdk.component.Cc.EO.vCE vceCL = eo.cL();
        com.bytedance.sdk.component.Cc.EO.MY.IlO IlO = vceCL.IlO(eo);
        try {
            eo.AXM();
            Bitmap bitmapIlO = IlO.IlO(this.IlO);
            if (bitmapIlO == null) {
                IlO(1002, "decode failed bitmap null", null, eo);
                return;
            }
            eo.IlO(new hp(bitmapIlO, this.MY, false));
            vceCL.IlO(eo.es()).IlO(eo.NV(), bitmapIlO);
        } catch (Throwable th) {
            IlO(1002, "decode failed:" + th.getMessage(), th, eo);
        }
    }

    private void IlO(int i2, String str, Throwable th, com.bytedance.sdk.component.Cc.EO.EO eo) {
        if (this.MY == null) {
            eo.IlO(new EV());
        } else {
            eo.IlO(new lEW(i2, str, th));
        }
    }

    @Override // com.bytedance.sdk.component.Cc.Cc.DmF
    public String IlO() {
        return "decode";
    }
}
