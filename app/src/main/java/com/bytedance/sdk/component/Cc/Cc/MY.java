package com.bytedance.sdk.component.Cc.Cc;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY implements DmF {
    private byte[] IlO;
    private com.bytedance.sdk.component.Cc.vCE MY;

    public MY(byte[] bArr, com.bytedance.sdk.component.Cc.vCE vce) {
        this.IlO = bArr;
        this.MY = vce;
    }

    @Override // com.bytedance.sdk.component.Cc.Cc.DmF
    public void IlO(com.bytedance.sdk.component.Cc.EO.EO eo) {
        DmF cc;
        int iRp = eo.rp();
        eo.IlO(this.IlO.length);
        if (iRp == 2) {
            cc = com.bytedance.sdk.component.utils.vCE.IlO(this.IlO) ? new Cc(this.IlO, this.MY) : this.MY == null ? new EV() : new lEW(1001, "not image format", null);
        } else if (iRp != 3) {
            boolean zMY = com.bytedance.sdk.component.utils.vCE.MY(this.IlO);
            cc = (!zMY && com.bytedance.sdk.component.utils.vCE.IlO(this.IlO)) ? new Cc(this.IlO, this.MY) : new hp(this.IlO, this.MY, zMY);
        } else {
            byte[] bArr = this.IlO;
            cc = new hp(bArr, this.MY, com.bytedance.sdk.component.utils.vCE.MY(bArr));
        }
        eo.IlO(cc);
    }

    @Override // com.bytedance.sdk.component.Cc.Cc.DmF
    public String IlO() {
        return "image_type";
    }
}
