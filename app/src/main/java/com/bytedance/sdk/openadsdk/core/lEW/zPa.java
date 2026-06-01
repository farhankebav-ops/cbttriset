package com.bytedance.sdk.openadsdk.core.lEW;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.utils.BS;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class zPa extends IlO {
    private FrameLayout IlO;
    private FrameLayout bWL;
    private xF hp;

    public zPa(@NonNull Context context) {
        super(context);
        this.MY = context;
    }

    private void EO() {
        com.bytedance.sdk.openadsdk.core.Cc.EO eo = new com.bytedance.sdk.openadsdk.core.Cc.EO(this.MY);
        this.IlO = eo;
        addView(eo, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.Cc.EO eo2 = new com.bytedance.sdk.openadsdk.core.Cc.EO(this.MY);
        this.bWL = eo2;
        this.IlO.addView(eo2, new FrameLayout.LayoutParams(-1, -1));
        this.bWL.removeAllViews();
    }

    private void MY() {
        this.Bc = BS.MY(this.MY, this.hp.getExpectExpressWidth());
        this.lEW = BS.MY(this.MY, this.hp.getExpectExpressWidth());
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.Bc, this.lEW);
        }
        layoutParams.width = this.Bc;
        layoutParams.height = this.lEW;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        this.EO.zLG();
        EO();
    }

    public void IlO(com.bytedance.sdk.openadsdk.core.model.oeT oet, xF xFVar, ViewGroup viewGroup) {
        if (oet == null) {
            return;
        }
        setBackgroundColor(-1);
        this.EO = oet;
        this.hp = xFVar;
        if (oet.OyN() == 7) {
            this.vCE = "rewarded_video";
        } else {
            this.vCE = "fullscreen_interstitial_ad";
        }
        MY();
        if (com.bytedance.sdk.openadsdk.core.model.es.EO(oet)) {
            this.hp.addView(this, new ViewGroup.LayoutParams(-1, -1));
        } else {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.hp.addView(this, layoutParams);
        }
        int i2 = com.bytedance.sdk.openadsdk.utils.zPa.VC;
        View viewFindViewById = viewGroup.findViewById(i2);
        if (viewFindViewById != null) {
            Object tag = viewFindViewById.getTag(i2);
            if (tag instanceof String) {
                String str = (String) tag;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                com.bytedance.sdk.openadsdk.cL.Bc.IlO().IlO(str, viewFindViewById);
            }
        }
    }

    public View getBackupContainerBackgroundView() {
        return this.IlO;
    }

    public FrameLayout getVideoContainer() {
        return this.bWL;
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.IlO
    public void IlO(View view, int i2, com.bytedance.sdk.openadsdk.core.model.bWL bwl) {
        xF xFVar = this.hp;
        if (xFVar != null) {
            xFVar.IlO(view, i2, bwl);
        }
    }
}
