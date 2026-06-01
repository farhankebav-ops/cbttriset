package com.bytedance.sdk.component.Cc.Cc;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EV extends IlO {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v6 */
    @Override // com.bytedance.sdk.component.Cc.Cc.DmF
    public void IlO(com.bytedance.sdk.component.Cc.EO.EO eo) {
        com.bytedance.sdk.component.Cc.EO.EO eo2;
        final com.bytedance.sdk.component.Cc.EO.vCE vceCL = eo.cL();
        com.bytedance.sdk.component.Cc.tV tVVarTV = vceCL.tV();
        eo.IlO(false);
        try {
            com.bytedance.sdk.component.Cc.vCE vceIlO = tVVarTV.IlO(new com.bytedance.sdk.component.Cc.MY.MY(eo.IlO(), eo.hp(), eo.bWL(), eo.AXM()));
            int iMY = vceIlO.MY();
            eo.IlO(vceIlO.IlO());
            eo2 = 200;
            try {
                if (vceIlO.MY() != 200) {
                    String.valueOf(vceIlO);
                    Object objEO = vceIlO.EO();
                    IlO(iMY, vceIlO.tV(), objEO instanceof Throwable ? (Throwable) objEO : null, eo);
                    return;
                }
                final byte[] bArr = (byte[]) vceIlO.EO();
                eo.IlO(new MY(bArr, vceIlO));
                final String strDmF = eo.DmF();
                final com.bytedance.sdk.component.Cc.MY myEs = eo.es();
                if (myEs.Cc()) {
                    vceCL.MY(eo.es()).IlO(strDmF, bArr);
                }
                final com.bytedance.sdk.component.Cc.EO.EO eo3 = eo;
                try {
                    vceCL.Bc().submit(new Runnable() { // from class: com.bytedance.sdk.component.Cc.Cc.EV.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (myEs.Bc()) {
                                vceCL.EO(eo3.es()).IlO(strDmF, bArr);
                            }
                        }
                    });
                    return;
                } catch (Throwable th) {
                    th = th;
                    eo2 = eo3;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            eo2 = eo;
        }
        IlO(1004, "net request failed!", th, eo2);
    }

    private void IlO(int i2, String str, Throwable th, com.bytedance.sdk.component.Cc.EO.EO eo) {
        eo.IlO(new lEW(i2, str, th));
    }

    @Override // com.bytedance.sdk.component.Cc.Cc.DmF
    public String IlO() {
        return "net_request";
    }
}
