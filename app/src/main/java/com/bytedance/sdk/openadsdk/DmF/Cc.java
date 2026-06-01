package com.bytedance.sdk.openadsdk.DmF;

import com.bytedance.sdk.component.Cc.DmF;
import com.bytedance.sdk.component.Cc.xF;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc implements xF {
    private static int IlO;
    private final String Cc;
    private long EO;
    private long MY = 0;
    private boolean tV;

    public Cc() {
        IlO++;
        this.Cc = "image_request_" + IlO;
    }

    @Override // com.bytedance.sdk.component.Cc.xF
    public void IlO(String str, DmF dmF) {
        if (!this.tV) {
            dmF.IlO();
            dmF.MY();
            dmF.EO();
            this.tV = true;
        }
        this.MY = System.currentTimeMillis();
        EO(str, dmF);
    }

    @Override // com.bytedance.sdk.component.Cc.xF
    public void MY(String str, DmF dmF) {
        this.EO += System.currentTimeMillis() - this.MY;
        EO(str, dmF);
    }

    private String EO(String str, DmF dmF) {
        return str;
    }
}
