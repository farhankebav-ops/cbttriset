package com.bytedance.sdk.openadsdk.core.lEW;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.utils.BS;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class ea extends com.bytedance.sdk.openadsdk.core.rp.MY.vCE implements View.OnClickListener {
    private boolean cl;

    public ea(@NonNull Context context, @NonNull com.bytedance.sdk.openadsdk.core.model.oeT oet, String str, com.bytedance.sdk.openadsdk.tV.Bc bc, boolean z2) {
        super(context, oet, false, str, false, false, bc);
        this.cl = false;
        setOnClickListener(this);
        setNeedNativeVideoPlayBtnVisible(false);
        setNeedSelfManagerVideo(!z2);
    }

    private void cL() {
        BS.IlO((View) this.Bc, 0);
        BS.IlO((View) this.lEW, 0);
        BS.IlO((View) this.NV, 8);
    }

    private void es() {
        Bc();
        RelativeLayout relativeLayout = this.Bc;
        if (relativeLayout != null) {
            if (relativeLayout.getVisibility() == 0) {
                return;
            } else {
                com.bytedance.sdk.openadsdk.cL.Bc.IlO().IlO(this.IlO.fdM().f4689f, this.IlO.fdM().f4686b, this.IlO.fdM().f4685a, this.lEW, this.IlO);
            }
        }
        cL();
    }

    public void Cc() {
        Bc();
        BS.IlO((View) this.Bc, 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.vCE
    public void EO() {
        if (this.cl) {
            super.EO();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.vCE
    public void IlO(boolean z2) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.vCE
    public void MY() {
        if (!this.Cc || !kBB.MY(this.rp)) {
            this.tV = false;
        }
        super.MY();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView = this.DmF;
        if (imageView != null && imageView.getVisibility() == 0) {
            BS.Cc(this.Bc);
        }
        EO();
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.vCE, android.view.View
    public void onWindowFocusChanged(boolean z2) {
        ImageView imageView = this.DmF;
        if (imageView == null || imageView.getVisibility() != 0) {
            super.onWindowFocusChanged(z2);
        } else {
            es();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.vCE, android.view.View
    public void onWindowVisibilityChanged(int i2) {
        ImageView imageView = this.DmF;
        if (imageView == null || imageView.getVisibility() != 0) {
            super.onWindowVisibilityChanged(i2);
        } else {
            es();
        }
    }

    public void setCanInterruptVideoPlay(boolean z2) {
        this.cl = z2;
    }

    public void setShouldCheckNetChange(boolean z2) {
        com.bytedance.sdk.openadsdk.core.rp.MY.EO eo = this.MY;
        if (eo != null) {
            eo.Cc(z2);
        }
    }

    public void setShowAdInteractionView(boolean z2) {
        com.bytedance.sdk.openadsdk.core.rp.MY.Cc ccEV;
        com.bytedance.sdk.openadsdk.core.rp.MY.EO eo = this.MY;
        if (eo == null || (ccEV = eo.EV()) == null) {
            return;
        }
        ccEV.IlO(z2);
    }

    public void tV() {
        ImageView imageView = this.NV;
        if (imageView != null) {
            BS.IlO((View) imageView, 8);
        }
    }

    public void IlO(int i2, int i8) {
        com.bytedance.sdk.openadsdk.core.rp.MY.EO eo = this.MY;
        if (eo != null) {
            eo.MY(i2, i8);
        }
    }
}
