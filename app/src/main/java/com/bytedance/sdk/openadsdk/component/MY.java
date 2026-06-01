package com.bytedance.sdk.openadsdk.component;

import android.app.Activity;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.MY.MY;
import com.bytedance.sdk.openadsdk.core.lEW.DmF;
import com.bytedance.sdk.openadsdk.core.lEW.lEW;
import com.bytedance.sdk.openadsdk.core.lEW.xF;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.ironsource.C2300e4;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY extends EO {
    private com.bytedance.sdk.openadsdk.component.DmF.MY bWL;
    private boolean ea;
    private final com.bytedance.sdk.openadsdk.component.vCE.MY hp;
    private com.bytedance.sdk.openadsdk.component.DmF.Bc zPa;

    public MY(Activity activity, oeT oet, FrameLayout frameLayout, IlO ilO, int i2, boolean z2, com.bytedance.sdk.openadsdk.component.lEW.IlO ilO2, com.bytedance.sdk.openadsdk.component.vCE.MY my) {
        super(activity, oet, frameLayout, ilO, i2, z2, ilO2);
        this.hp = my;
    }

    @Override // com.bytedance.sdk.openadsdk.component.EO
    public void Cc() {
        com.bytedance.sdk.openadsdk.component.DmF.MY my = this.bWL;
        if (my != null) {
            my.hp();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.EO
    public void EO() {
        super.EO();
        com.bytedance.sdk.openadsdk.component.DmF.MY my = this.bWL;
        if (my != null) {
            my.zPa();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.EO
    public void MY() {
        this.bWL.bWL();
    }

    @Override // com.bytedance.sdk.openadsdk.component.EO
    public int tV() {
        return this.bWL.getDynamicShowType();
    }

    @Override // com.bytedance.sdk.openadsdk.component.EO
    public void IlO(ViewGroup viewGroup) {
        Pair<Float, Float> pairIlO = com.bytedance.sdk.openadsdk.core.lEW.IlO.IlO.IlO(this.IlO.getWindow(), this.Bc);
        com.bytedance.sdk.openadsdk.component.DmF.MY my = new com.bytedance.sdk.openadsdk.component.DmF.MY(this.IlO, this.MY, new AdSlot.Builder().setCodeId(String.valueOf(this.MY.hFV())).setExpressViewAcceptedSize(((Float) pairIlO.first).floatValue(), ((Float) pairIlO.second).floatValue()).build(), "open_ad", this.Cc, this.hp, this.rp);
        this.bWL = my;
        my.setTopListener(this.Cc);
        this.bWL.setExpressVideoListenerProxy(this.Cc);
        this.bWL.setExpressInteractionListener(new PAGExpressAdWrapperListener() { // from class: com.bytedance.sdk.openadsdk.component.MY.1
            @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
            public void onRenderFail(View view, String str, int i2) {
                MY.this.Cc.tV();
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
            public void onRenderSuccess(View view, float f4, float f8) {
                if (MY.this.bWL.cL()) {
                    MY.this.ea = true;
                    if (MY.this.zPa != null) {
                        MY my2 = MY.this;
                        if (my2.tV == my2.zPa.getParent()) {
                            MY my3 = MY.this;
                            my3.tV.removeView(my3.zPa);
                        }
                    }
                    MY my4 = MY.this;
                    MY.super.IlO((ViewGroup) my4.tV);
                    MY.super.IlO();
                    MY.super.MY();
                    return;
                }
                if (MY.this.MY.mV()) {
                    MY.this.Cc.EO();
                    return;
                }
                MY my5 = MY.this;
                if (!my5.EO) {
                    my5.Cc.EO();
                } else if (!my5.IlO(my5.bWL.getVideoFrameLayout())) {
                    MY.this.Cc.tV();
                } else {
                    MY.this.bWL.setVideoManager(MY.this.Bc());
                    MY.this.Cc.EO();
                }
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
        });
        this.MY.rp(1);
        this.tV.addView(this.bWL, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.component.DmF.Bc bc = new com.bytedance.sdk.openadsdk.component.DmF.Bc(this.IlO);
        this.zPa = bc;
        this.tV.addView(bc);
        this.DmF = this.zPa.getTopDislike();
        this.NV = this.zPa.getTopSkip();
        this.EV = this.zPa.getTopCountDown();
    }

    @Override // com.bytedance.sdk.openadsdk.component.EO
    public void IlO() {
        DmF dmFIlO = com.bytedance.sdk.openadsdk.component.IlO.MY.IlO(this.MY, this.IlO, this.rp, this.bWL);
        dmFIlO.IlO(new MY.IlO() { // from class: com.bytedance.sdk.openadsdk.component.MY.2
            @Override // com.bytedance.sdk.openadsdk.core.MY.MY.IlO
            public void IlO(View view, int i2) {
                MY.this.Cc.Cc();
            }
        });
        this.bWL.setClickListener(dmFIlO);
        lEW lewMY = com.bytedance.sdk.openadsdk.component.IlO.MY.MY(this.MY, this.IlO, this.rp, this.bWL);
        this.bWL.setClickCreativeListener(lewMY);
        lewMY.IlO(new MY.IlO() { // from class: com.bytedance.sdk.openadsdk.component.MY.3
            @Override // com.bytedance.sdk.openadsdk.core.MY.MY.IlO
            public void IlO(View view, int i2) {
                MY.this.Cc.Cc();
            }
        });
        super.vCE();
        this.bWL.setBackupListener(new com.bytedance.sdk.component.adexpress.MY.EO() { // from class: com.bytedance.sdk.openadsdk.component.MY.4
            @Override // com.bytedance.sdk.component.adexpress.MY.EO
            public boolean IlO(ViewGroup viewGroup, int i2) {
                StringBuilder sb = new StringBuilder("isUseBackup() called with: view = [");
                sb.append(viewGroup);
                sb.append("], errCode = [");
                sb.append(i2);
                sb.append(C2300e4.i.e);
                try {
                    ((xF) viewGroup).cl();
                    new com.bytedance.sdk.openadsdk.component.DmF.IlO(MY.this.IlO).IlO((xF) MY.this.bWL);
                    return true;
                } catch (Exception e) {
                    Log.e("AppOpenAdExpressManager", "", e);
                    return false;
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.component.EO
    public void IlO(int i2, boolean z2) {
        super.IlO(i2, z2);
    }

    @Override // com.bytedance.sdk.openadsdk.component.EO
    public JSONObject IlO(JSONObject jSONObject) {
        return this.bWL.IlO(jSONObject, this.MY);
    }
}
