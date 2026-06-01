package com.bytedance.sdk.openadsdk.core.EO;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.core.lEW.es;
import com.bytedance.sdk.openadsdk.core.lEW.xF;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.kBB.MY.Cc;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO extends tV {
    private int DmF;
    private int NV;
    private com.bytedance.sdk.openadsdk.IlO.IlO.MY lEW;

    public EO(@NonNull Context context, oeT oet, AdSlot adSlot, boolean z2) {
        super(context, oet, adSlot, z2);
        this.DmF = 1;
        this.NV = -1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.EO.tV
    public void EO() {
        es esVar = new es(this.IlO, this.EO, this.tV, this.vCE, this.Bc) { // from class: com.bytedance.sdk.openadsdk.core.EO.EO.1
            @Override // com.bytedance.sdk.openadsdk.core.lEW.xF
            public Cc.IlO EO(int i2) {
                return EO.this.IlO(super.EO(i2));
            }
        };
        this.MY = esVar;
        com.bytedance.sdk.openadsdk.core.rp.MY.EO videoController = esVar.getVideoController();
        if (videoController != null) {
            videoController.tV(this.DmF);
        }
        addView(this.MY, new ViewGroup.LayoutParams(-1, -1));
        PAGBannerAdWrapperListener pAGBannerAdWrapperListener = this.Cc;
        if (pAGBannerAdWrapperListener != null) {
            setExpressInteractionListener(pAGBannerAdWrapperListener);
        }
        xF xFVar = this.MY;
        if (xFVar != null) {
            ((es) xFVar).setVideoAdListener(new com.bytedance.sdk.openadsdk.IlO.MY.EO() { // from class: com.bytedance.sdk.openadsdk.core.EO.EO.2
                @Override // com.bytedance.sdk.openadsdk.IlO.MY.EO
                public void EO(PAGNativeAd pAGNativeAd) {
                    if (EO.this.lEW != null) {
                        EO.this.lEW.IlO();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.IlO.MY.EO
                public void IlO(int i2, int i8) {
                }

                @Override // com.bytedance.sdk.openadsdk.IlO.MY.EO
                public void IlO(PAGNativeAd pAGNativeAd) {
                    if (EO.this.NV == 3) {
                        EO eo = EO.this;
                        eo.IlO(eo.lEW);
                    } else if (EO.this.NV == 2) {
                        EO.this.IlO();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.IlO.MY.EO
                public void MY(PAGNativeAd pAGNativeAd) {
                }
            });
        }
    }

    public com.bytedance.sdk.openadsdk.multipro.MY.IlO getVideoModel() {
        xF xFVar = this.MY;
        if (xFVar != null) {
            return ((es) xFVar).getVideoModel();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.EO.tV
    public void tV() {
        com.bytedance.sdk.openadsdk.core.rp.MY.EO videoController;
        xF xFVar = this.MY;
        if ((xFVar instanceof es) && (videoController = ((es) xFVar).getVideoController()) != null) {
            this.DmF = videoController.zLG();
        }
        super.tV();
    }

    public void IlO(com.bytedance.sdk.openadsdk.IlO.IlO.MY my) {
        xF xFVar = this.MY;
        if (xFVar != null) {
            ((es) xFVar).EV();
            this.lEW = my;
            this.NV = 3;
        }
    }

    public void MY() {
        xF xFVar = this.MY;
        if (xFVar != null) {
            ((es) xFVar).rp();
        }
    }

    public void IlO() {
        xF xFVar = this.MY;
        if (xFVar != null) {
            ((es) xFVar).NV();
            this.NV = 2;
        }
    }
}
