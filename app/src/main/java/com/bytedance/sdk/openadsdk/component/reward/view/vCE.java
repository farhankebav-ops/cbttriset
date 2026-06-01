package com.bytedance.sdk.openadsdk.component.reward.view;

import android.view.View;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.component.reward.IlO.cl;
import com.bytedance.sdk.openadsdk.component.reward.IlO.xF;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.zPa;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE {
    private boolean Cc;
    private boolean EO;
    private final com.bytedance.sdk.openadsdk.component.reward.IlO.IlO IlO;

    @Nullable
    private RFEndCardBackUpLayout MY;
    private xF tV;

    public vCE(com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO) {
        this.IlO = ilO;
    }

    public boolean Cc() {
        xF xFVar = this.tV;
        if (xFVar != null) {
            return xFVar.EO();
        }
        return false;
    }

    public void EO() {
        xF xFVar = this.tV;
        if (xFVar != null) {
            xFVar.IlO();
        }
    }

    public void IlO() {
        if (this.EO) {
            return;
        }
        this.EO = true;
        RFEndCardBackUpLayout rFEndCardBackUpLayout = (RFEndCardBackUpLayout) this.IlO.zLG.findViewById(zPa.uI);
        this.MY = rFEndCardBackUpLayout;
        if (rFEndCardBackUpLayout != null) {
            rFEndCardBackUpLayout.init(this.IlO);
        }
        if (this.IlO.MY.xJ()) {
            this.tV = new xF(this.IlO);
        }
    }

    public void MY() {
        this.Cc = true;
        BS.IlO((View) this.MY, 0);
    }

    public void tV() {
        xF xFVar = this.tV;
        if (xFVar != null) {
            xFVar.MY();
        }
    }

    public boolean vCE() {
        return this.Cc;
    }

    public void IlO(com.bytedance.sdk.openadsdk.core.MY.Cc cc) {
        RFEndCardBackUpLayout rFEndCardBackUpLayout = this.MY;
        if (rFEndCardBackUpLayout == null) {
            return;
        }
        BS.IlO(rFEndCardBackUpLayout, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.vCE.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        }, "TTBaseVideoActivity#mFLEndCardBackupContainer");
        xF xFVar = this.tV;
        if (xFVar != null) {
            xFVar.IlO(cc);
        }
    }

    public boolean IlO(cl clVar) {
        this.Cc = true;
        xF xFVar = this.tV;
        if (xFVar == null || !xFVar.IlO(clVar)) {
            return false;
        }
        BS.IlO((View) this.MY, 0);
        return true;
    }

    public void IlO(int i2) {
        RFEndCardBackUpLayout rFEndCardBackUpLayout = this.MY;
        if (rFEndCardBackUpLayout == null) {
            return;
        }
        rFEndCardBackUpLayout.setShownAdCount(i2);
    }
}
