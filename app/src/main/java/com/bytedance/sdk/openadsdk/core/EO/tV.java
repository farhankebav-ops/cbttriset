package com.bytedance.sdk.openadsdk.core.EO;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.lEW.xF;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.kBB.MY.Cc;
import com.bytedance.sdk.openadsdk.utils.BS;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV extends com.bytedance.sdk.openadsdk.core.Cc.EO {
    protected boolean Bc;
    protected PAGBannerAdWrapperListener Cc;
    private boolean DmF;
    protected oeT EO;
    protected final Context IlO;
    protected xF MY;
    private int lEW;
    protected AdSlot tV;
    protected String vCE;

    public tV(@NonNull Context context, oeT oet, AdSlot adSlot, boolean z2) {
        super(context);
        this.vCE = "banner_ad";
        this.Bc = false;
        this.lEW = -1;
        this.DmF = false;
        if (oet != null && oet.oc() != 2) {
            oet.rp(1);
        }
        this.Bc = z2;
        this.IlO = context;
        this.EO = oet;
        this.tV = adSlot;
        EO();
        AdSlot adSlot2 = this.tV;
        if (adSlot2 != null) {
            IlO(adSlot2.getExpressViewAcceptedWidth(), this.tV.getExpressViewAcceptedHeight());
        }
    }

    public void Cc() {
        xF xFVar = this.MY;
        if (xFVar != null) {
            xFVar.bWL();
        }
    }

    public void EO() {
        xF xFVar = new xF(this.IlO, this.EO, this.tV, this.vCE) { // from class: com.bytedance.sdk.openadsdk.core.EO.tV.1
            @Override // com.bytedance.sdk.openadsdk.core.lEW.xF
            public Cc.IlO EO(int i2) {
                return tV.this.IlO(super.EO(i2));
            }
        };
        this.MY = xFVar;
        addView(xFVar, new ViewGroup.LayoutParams(-1, -1));
        PAGBannerAdWrapperListener pAGBannerAdWrapperListener = this.Cc;
        if (pAGBannerAdWrapperListener != null) {
            setExpressInteractionListener(pAGBannerAdWrapperListener);
        }
    }

    public xF getCurView() {
        return this.MY;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.MY == null) {
            EO();
        }
        com.bytedance.sdk.openadsdk.utils.tV.IlO(this, this.EO);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void setCurrentIndex(int i2) {
        this.lEW = i2;
    }

    public void setExpressInteractionListener(PAGBannerAdWrapperListener pAGBannerAdWrapperListener) {
        this.Cc = pAGBannerAdWrapperListener;
        xF xFVar = this.MY;
        if (xFVar != null) {
            xFVar.setJsbLandingPageOpenListener(new com.bytedance.sdk.openadsdk.core.widget.Cc() { // from class: com.bytedance.sdk.openadsdk.core.EO.tV.2
                @Override // com.bytedance.sdk.openadsdk.core.widget.Cc
                public void IlO() {
                    tV.this.Cc.onAdClicked();
                }
            });
            this.MY.setExpressInteractionListener(new PAGExpressAdWrapperListener() { // from class: com.bytedance.sdk.openadsdk.core.EO.tV.3
                @Override // com.bytedance.sdk.openadsdk.api.PAGAdWrapperListener
                public void onAdClicked() {
                    PAGBannerAdWrapperListener pAGBannerAdWrapperListener2;
                    oeT oet = tV.this.EO;
                    if (oet == null || !oet.Os() || (pAGBannerAdWrapperListener2 = tV.this.Cc) == null) {
                        return;
                    }
                    pAGBannerAdWrapperListener2.onAdClicked();
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
                public void onRenderFail(View view, String str, int i2) {
                    tV tVVar = tV.this;
                    PAGBannerAdWrapperListener pAGBannerAdWrapperListener2 = tVVar.Cc;
                    if (pAGBannerAdWrapperListener2 != null) {
                        pAGBannerAdWrapperListener2.onRenderFail(tVVar, str, i2);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
                public void onRenderSuccess(View view, float f4, float f8) {
                    xF xFVar2 = tV.this.MY;
                    if (xFVar2 != null) {
                        xFVar2.setSoundMute(true);
                    }
                    xF xFVar3 = tV.this.MY;
                    if (xFVar3 != null && !com.bytedance.sdk.openadsdk.core.NV.tV.IlO(xFVar3.getDynamicShowType())) {
                        tV.this.IlO(f4, f8);
                    }
                    if (tV.this.DmF) {
                        tV.this.MY.hp();
                    }
                    tV tVVar = tV.this;
                    PAGBannerAdWrapperListener pAGBannerAdWrapperListener2 = tVVar.Cc;
                    if (pAGBannerAdWrapperListener2 != null) {
                        pAGBannerAdWrapperListener2.onRenderSuccess(tVVar, f4, f8);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
                public void onAdDismissed() {
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
                public void onAdShow(View view, int i2) {
                }
            });
        }
    }

    public void setIsShow(boolean z2) {
        this.DmF = z2;
    }

    public void tV() {
        if (this.MY != null) {
            com.bytedance.sdk.openadsdk.core.DmF.MY().vCE(this.MY.getClosedListenerKey());
            removeView(this.MY);
            this.MY.zPa();
            this.MY = null;
        }
        com.bytedance.sdk.openadsdk.core.DmF.MY().vAh();
    }

    public Cc.IlO IlO(Cc.IlO ilO) {
        int i2;
        if (this.Bc && (i2 = this.lEW) >= 0) {
            ilO.MY = i2;
        }
        return ilO;
    }

    public void IlO(float f4, float f8) {
        int iMY = BS.MY(this.IlO, f4);
        int iMY2 = BS.MY(this.IlO, f8);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(iMY, iMY2);
        }
        layoutParams.width = iMY;
        layoutParams.height = iMY2;
        setLayoutParams(layoutParams);
    }
}
