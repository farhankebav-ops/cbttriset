package com.bytedance.sdk.openadsdk.component.reward.IlO;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.utils.BS;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class bWL {
    private boolean Cc = false;
    private final Activity EO;
    com.bytedance.sdk.openadsdk.component.reward.top.EO IlO;
    com.bytedance.sdk.component.adexpress.dynamic.tV MY;
    private final IlO tV;
    private boolean vCE;

    public bWL(IlO ilO) {
        this.EO = ilO.BS;
        this.tV = ilO;
    }

    public void Cc(boolean z2) {
        com.bytedance.sdk.openadsdk.component.reward.top.EO eo;
        if (this.vCE || (eo = this.IlO) == null) {
            return;
        }
        eo.setSkipEnable(z2);
    }

    public void EO(boolean z2) {
        com.bytedance.sdk.openadsdk.component.reward.top.EO eo;
        if (this.vCE || (eo = this.IlO) == null) {
            return;
        }
        eo.setShowSound(z2);
    }

    public void IlO() {
        if (this.Cc) {
            return;
        }
        this.Cc = true;
        IlO ilO = this.tV;
        com.bytedance.sdk.openadsdk.component.reward.top.EO eo = ilO.aa;
        if (eo != null) {
            this.IlO = eo;
            this.vCE = true;
        } else {
            this.IlO = (com.bytedance.sdk.openadsdk.component.reward.top.EO) ilO.zLG.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.Kn);
        }
        com.bytedance.sdk.openadsdk.component.reward.top.EO eo2 = this.IlO;
        if (eo2 != null) {
            eo2.IlO(this.tV.MY);
            if (this.tV.MY.xJ()) {
                IlO(false);
            } else {
                IlO(this.tV.MY.uF());
            }
        }
    }

    public void MY(boolean z2) {
        com.bytedance.sdk.openadsdk.component.reward.top.EO eo = this.IlO;
        if (eo != null) {
            eo.setSoundMute(z2);
        }
        com.bytedance.sdk.component.adexpress.dynamic.tV tVVar = this.MY;
        if (tVVar != null) {
            tVVar.setSoundMute(z2);
        }
    }

    public void tV(boolean z2) {
        com.bytedance.sdk.openadsdk.component.reward.top.EO eo;
        if (this.vCE || (eo = this.IlO) == null) {
            return;
        }
        eo.setShowSkip(z2);
    }

    public void Cc() {
        com.bytedance.sdk.openadsdk.component.reward.top.EO eo;
        if (this.vCE || (eo = this.IlO) == null) {
            return;
        }
        eo.setSkipInvisiable();
    }

    public void EO() {
        com.bytedance.sdk.openadsdk.component.reward.top.EO eo;
        if (this.vCE || (eo = this.IlO) == null) {
            return;
        }
        eo.showSkipButton();
    }

    public void tV() {
        com.bytedance.sdk.openadsdk.component.reward.top.EO eo = this.IlO;
        if (eo != null) {
            eo.clickSkip();
        }
    }

    public void MY() {
        com.bytedance.sdk.openadsdk.component.reward.top.EO eo;
        if (this.vCE || (eo = this.IlO) == null) {
            return;
        }
        eo.showCountDownText();
    }

    public void IlO(boolean z2) {
        com.bytedance.sdk.openadsdk.component.reward.top.EO eo;
        if (this.vCE || (eo = this.IlO) == null) {
            return;
        }
        eo.setShowDislike(z2);
    }

    public void IlO(String str, CharSequence charSequence) {
        com.bytedance.sdk.openadsdk.component.reward.top.EO eo;
        if (this.vCE || (eo = this.IlO) == null) {
            return;
        }
        eo.setTime(String.valueOf(str), charSequence);
    }

    public void IlO(CharSequence charSequence) {
        com.bytedance.sdk.openadsdk.component.reward.top.EO eo;
        if (this.vCE || (eo = this.IlO) == null) {
            return;
        }
        eo.setSkipText(charSequence);
    }

    public void IlO(String str) {
        com.bytedance.sdk.openadsdk.component.reward.top.EO eo = this.IlO;
        if (eo != null) {
            eo.clickSound(str);
        }
    }

    public void IlO(com.bytedance.sdk.openadsdk.component.reward.top.MY my) {
        com.bytedance.sdk.openadsdk.component.reward.top.EO eo = this.IlO;
        if (eo != null) {
            eo.setListener(my);
        }
    }

    public void IlO(com.bytedance.sdk.component.adexpress.dynamic.tV tVVar) {
        this.MY = tVVar;
    }

    public void IlO(int i2) {
        View viewFindViewById;
        com.bytedance.sdk.openadsdk.component.reward.top.EO eo = this.IlO;
        if (eo == null || eo.getITopLayout() == null || i2 == 0 || (viewFindViewById = this.IlO.getITopLayout().findViewById(520093713)) == null || !(viewFindViewById.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) || viewFindViewById.getWidth() <= 0 || viewFindViewById.getVisibility() != 0) {
            return;
        }
        int[] iArr = new int[2];
        viewFindViewById.getLocationOnScreen(iArr);
        int width = i2 - (viewFindViewById.getWidth() + iArr[0]);
        if (width < BS.MY(this.EO, 16.0f)) {
            ((ViewGroup.MarginLayoutParams) viewFindViewById.getLayoutParams()).rightMargin = (BS.MY(this.EO, 16.0f) - width) + ((ViewGroup.MarginLayoutParams) viewFindViewById.getLayoutParams()).rightMargin;
            viewFindViewById.requestLayout();
        }
    }
}
