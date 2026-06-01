package com.bytedance.sdk.openadsdk.xF.IlO;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.rp.vCE;
import com.bytedance.sdk.openadsdk.utils.BS;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY extends IlO {
    private FrameLayout Cc;
    private vCE EO;
    private volatile boolean MY;
    private final FrameLayout tV;
    private String vCE;

    public MY(Context context, oeT oet, int i2, boolean z2, FrameLayout frameLayout, String str) {
        super(context, oet, i2, z2, frameLayout);
        this.tV = frameLayout;
        this.vCE = str;
        MY(false);
        int iEO = BS.EO(context);
        int iCc = BS.Cc(context);
        if (i2 == 1) {
            if (iEO <= iCc) {
                this.IlO.layout(0, 0, iEO, iCc);
                return;
            }
        } else {
            if (i2 != 2) {
                return;
            }
            if (iEO > iCc) {
                this.IlO.layout(0, 0, iEO, iCc);
                return;
            }
        }
        this.IlO.layout(0, 0, iCc, iEO);
    }

    public void Bc() {
        super.IlO(true, new vCE() { // from class: com.bytedance.sdk.openadsdk.xF.IlO.MY.1
            @Override // com.bytedance.sdk.openadsdk.rp.vCE
            public void IlO() {
                if (MY.this.EO != null) {
                    MY.this.EO.IlO();
                } else {
                    MY.this.MY = true;
                }
            }
        });
    }

    public String lEW() {
        return this.vCE;
    }

    public void IlO(FrameLayout frameLayout, vCE vce) {
        this.Cc = frameLayout;
        frameLayout.addView(this.tV);
        this.EO = vce;
        if (this.MY) {
            this.EO.IlO();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.xF.IlO.IlO
    public void IlO() {
        this.Cc.setVisibility(0);
        super.IlO();
    }
}
