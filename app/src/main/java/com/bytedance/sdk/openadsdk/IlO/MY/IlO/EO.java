package com.bytedance.sdk.openadsdk.IlO.MY.IlO;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.IlO.MY.lEW;
import com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView;
import com.bytedance.sdk.openadsdk.core.NV.tV;
import com.bytedance.sdk.openadsdk.core.lEW.es;
import com.bytedance.sdk.openadsdk.core.lEW.xF;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.utils.BS;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO extends lEW {
    protected AdSlot DmF;
    protected String EV;
    protected xF NV;
    protected final Context lEW;
    private boolean rp;

    public EO(@NonNull Context context, oeT oet, AdSlot adSlot) {
        super(context, oet, 5, true);
        this.EV = "embeded_ad";
        this.rp = false;
        this.MY.rp(1);
        this.tV.IlO(this);
        this.lEW = context;
        this.DmF = adSlot;
        IlO();
        MY();
    }

    private void MY() {
        xF xFVar = this.NV;
        if (xFVar != null) {
            xFVar.setBackupListener(new com.bytedance.sdk.component.adexpress.MY.EO() { // from class: com.bytedance.sdk.openadsdk.IlO.MY.IlO.EO.1
                @Override // com.bytedance.sdk.component.adexpress.MY.EO
                public boolean IlO(ViewGroup viewGroup, int i2) {
                    IlO ilO = new IlO(EO.this.NV.getContext());
                    ilO.setExtraFuncationHelper(((lEW) EO.this).tV);
                    ilO.IlO(EO.this.NV);
                    return true;
                }
            });
        }
    }

    public void Cc() {
        xF xFVar = this.NV;
        if (xFVar != null) {
            xFVar.bWL();
        }
    }

    public void EO() {
        xF xFVar = this.NV;
        if (xFVar != null) {
            xFVar.setExpressInteractionListener(new PAGExpressAdWrapperListener() { // from class: com.bytedance.sdk.openadsdk.IlO.MY.IlO.EO.2
                @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
                public void onRenderSuccess(View view, float f4, float f8) {
                    if (!EO.this.NV.cL()) {
                        EO.this.IlO(f4, f8);
                        if (EO.this.rp) {
                            EO.this.NV.hp();
                            return;
                        }
                        return;
                    }
                    EO eo = EO.this;
                    Context context = eo.lEW;
                    oeT oet = ((lEW) eo).MY;
                    EO eo2 = EO.this;
                    com.bytedance.sdk.openadsdk.IlO.MY.MY my = new com.bytedance.sdk.openadsdk.IlO.MY.MY(context, oet, 5, eo2.DmF, ((lEW) eo2).tV, ((lEW) EO.this).IlO);
                    EO eo3 = EO.this;
                    if (eo3 instanceof MY) {
                        my.IlO(((es) eo3.tV()).getVideoAdListener());
                    }
                    ((lEW) EO.this).tV.IlO((com.bytedance.sdk.openadsdk.core.MY.IlO) EO.this.NV.getClickCreativeListener());
                    PAGMediaView pAGMediaViewDmF = ((lEW) EO.this).tV.DmF();
                    if (pAGMediaViewDmF == null) {
                        pAGMediaViewDmF = new PAGMediaView(EO.this.lEW);
                    }
                    EO.this.NV.addView(pAGMediaViewDmF);
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGAdWrapperListener
                public void onAdClicked() {
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
                public void onAdDismissed() {
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
                public void onAdShow(View view, int i2) {
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
                public void onRenderFail(View view, String str, int i2) {
                }
            });
        }
    }

    public xF tV() {
        return this.NV;
    }

    public void IlO() {
        this.NV = new xF(this.lEW, this.MY, this.DmF, this.EV);
        EO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(float f4, float f8) {
        xF xFVar = this.NV;
        if (xFVar != null && tV.IlO(xFVar.getDynamicShowType())) {
            ViewGroup.LayoutParams layoutParams = this.NV.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -1);
            } else {
                layoutParams.width = -1;
                layoutParams.height = -1;
            }
            this.NV.setLayoutParams(layoutParams);
            return;
        }
        int iMY = BS.MY(this.lEW, f4);
        int iMY2 = BS.MY(this.lEW, f8);
        ViewGroup.LayoutParams layoutParams2 = this.NV.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new ViewGroup.LayoutParams(iMY, iMY2);
        } else {
            layoutParams2.width = iMY;
            layoutParams2.height = iMY2;
        }
        this.NV.setLayoutParams(layoutParams2);
    }

    public void IlO(boolean z2) {
        this.rp = z2;
    }
}
