package com.bytedance.sdk.openadsdk.component.DmF;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.adexpress.MY.bWL;
import com.bytedance.sdk.component.adexpress.MY.hp;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.lEW.kBB;
import com.bytedance.sdk.openadsdk.core.lEW.xF;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.mmj;
import org.json.JSONObject;
import w.b;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY extends xF {
    private final com.bytedance.sdk.openadsdk.component.lEW.IlO Bc;
    private final com.bytedance.sdk.openadsdk.component.IlO Cc;
    int EO;
    boolean IlO;
    boolean MY;
    private com.bytedance.sdk.openadsdk.component.vCE.IlO dY;
    private com.bytedance.sdk.openadsdk.component.lEW.EO lEW;
    private FrameLayout lMM;
    private b nvX;
    float tV;
    private final com.bytedance.sdk.openadsdk.component.vCE.MY vCE;

    public MY(@NonNull Context context, oeT oet, AdSlot adSlot, String str, com.bytedance.sdk.openadsdk.component.IlO ilO, com.bytedance.sdk.openadsdk.component.vCE.MY my, com.bytedance.sdk.openadsdk.component.lEW.IlO ilO2) {
        super(context, oet, adSlot, str, true, true);
        this.IlO = true;
        this.MY = false;
        this.EO = 0;
        this.tV = 1.0f;
        this.Cc = ilO;
        this.vCE = my;
        this.Bc = ilO2;
        if (oet == null || oet.eeU() == null) {
            return;
        }
        this.EO = oet.eeU().MY();
        this.tV = oet.eeU().IlO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EO(bWL bwl) {
        if (bwl == null) {
            return;
        }
        if (bwl.IlO() != null) {
            if (this.IlO) {
                bwl.IlO().setTag(com.bytedance.sdk.component.adexpress.dynamic.IlO.vCE, 1);
                ((FrameLayout) bwl.IlO()).removeAllViews();
                FrameLayout frameLayout = (FrameLayout) bwl.IlO();
                this.lMM = frameLayout;
                ((FrameLayout.LayoutParams) frameLayout.getLayoutParams()).gravity = 17;
                this.IlO = false;
                return;
            }
            return;
        }
        double dVCE = bwl.vCE();
        double dBc = bwl.Bc();
        double dLEW = bwl.lEW();
        double dDmF = bwl.DmF();
        int iMY = BS.MY(this.DmF, (float) dVCE);
        int iMY2 = BS.MY(this.DmF, (float) dBc);
        int iMY3 = BS.MY(this.DmF, (float) dLEW);
        int iMY4 = BS.MY(this.DmF, (float) dDmF);
        if ((dDmF != 0.0d && dLEW != 0.0d) || this.vSq.EO() == 7 || this.vSq.EO() == 10) {
            if ((this.vSq.EO() == 7 || this.vSq.EO() == 10) && (bwl instanceof com.bytedance.sdk.openadsdk.core.NV.Cc.MY)) {
                FrameLayout frameLayoutZPa = ((com.bytedance.sdk.openadsdk.core.NV.Cc.MY) bwl).zPa();
                if (frameLayoutZPa != null) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    layoutParams.gravity = 17;
                    frameLayoutZPa.addView(this.lMM, layoutParams);
                    return;
                }
                return;
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.lMM.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(iMY3, iMY4);
            }
            layoutParams2.width = iMY3;
            layoutParams2.height = iMY4;
            layoutParams2.topMargin = iMY2;
            layoutParams2.leftMargin = iMY;
            layoutParams2.setMarginStart(iMY);
            layoutParams2.setMarginEnd(layoutParams2.rightMargin);
            this.lMM.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF
    public void Bc() {
        this.ea = true;
        this.lMM = new FrameLayout(this.DmF);
        if (!com.bytedance.sdk.openadsdk.core.NV.tV.IlO(this.rp) && !com.bytedance.sdk.openadsdk.core.NV.tV.MY(this.rp)) {
            addView(this.lMM, new FrameLayout.LayoutParams(-1, -1));
        }
        super.Bc();
        setVideoFrameChangeListener(new com.bytedance.sdk.openadsdk.rp.Bc() { // from class: com.bytedance.sdk.openadsdk.component.DmF.MY.1
            @Override // com.bytedance.sdk.openadsdk.rp.Bc
            public void IlO(bWL bwl) {
                MY.this.MY(bwl);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF, com.bytedance.sdk.openadsdk.core.lEW.bWL
    public int Cc() {
        com.bytedance.sdk.openadsdk.component.lEW.EO eo = this.lEW;
        if (eo != null && eo.Bc()) {
            return 1;
        }
        com.bytedance.sdk.openadsdk.component.lEW.EO eo2 = this.lEW;
        if (eo2 != null && eo2.vCE()) {
            return 3;
        }
        com.bytedance.sdk.openadsdk.component.lEW.EO eo3 = this.lEW;
        if (eo3 != null && eo3.Cc()) {
            return 2;
        }
        com.bytedance.sdk.openadsdk.component.lEW.EO eo4 = this.lEW;
        if (eo4 != null && eo4.EO()) {
            return 4;
        }
        com.bytedance.sdk.openadsdk.component.lEW.EO eo5 = this.lEW;
        return (eo5 == null || !eo5.tV()) ? 3 : 5;
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF, com.bytedance.sdk.openadsdk.core.lEW.bWL
    public void IlO(int i2, String str) {
    }

    public void MY(final bWL bwl) {
        if (bwl == null) {
            return;
        }
        mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.DmF.MY.2
            @Override // java.lang.Runnable
            public void run() {
                MY.this.EO(bwl);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF
    public int getDynamicShowType() {
        if (this.vSq == null) {
            return 1;
        }
        return super.getDynamicShowType();
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF
    public int getRenderTimeout() {
        return com.bytedance.sdk.openadsdk.component.Bc.IlO.IlO(this.rp, cl.tV().vCE(String.valueOf(this.rp.hFV())));
    }

    public FrameLayout getVideoFrameLayout() {
        return this.lMM;
    }

    public void setExpressVideoListenerProxy(b bVar) {
        this.nvX = bVar;
    }

    public void setTopListener(com.bytedance.sdk.openadsdk.component.vCE.IlO ilO) {
        this.dY = ilO;
    }

    public void setVideoManager(com.bytedance.sdk.openadsdk.component.lEW.EO eo) {
        this.lEW = eo;
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF, com.bytedance.sdk.openadsdk.core.lEW.bWL
    public long tV() {
        return this.Bc.EO();
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF, com.bytedance.sdk.openadsdk.core.lEW.bWL
    public void vCE() {
        com.bytedance.sdk.openadsdk.component.vCE.IlO ilO = this.dY;
        if (ilO != null) {
            ilO.MY(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF, com.bytedance.sdk.openadsdk.core.lEW.bWL
    public void MY() {
        super.MY();
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF, com.bytedance.sdk.component.adexpress.MY.ea
    public void IlO(com.bytedance.sdk.component.adexpress.MY.tV<? extends View> tVVar, bWL bwl) {
        this.vSq = tVVar;
        if (tVVar instanceof kBB) {
            kBB kbb = (kBB) tVVar;
            if (kbb.zPa() != null) {
                kbb.zPa().IlO((com.bytedance.sdk.openadsdk.core.lEW.bWL) this);
            }
        }
        if (bwl != null && bwl.EO()) {
            MY(bwl);
        }
        super.IlO(tVVar, bwl);
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF
    public void MY(JSONObject jSONObject) {
        oeT oet = this.rp;
        boolean z2 = oet != null && oet.nvX() == 0;
        oeT oet2 = this.rp;
        com.bytedance.sdk.openadsdk.component.Bc.IlO.IlO(jSONObject, oet2 != null ? oet2.hFV() : 0, z2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF, com.bytedance.sdk.openadsdk.core.lEW.bWL
    public void IlO() {
        com.bytedance.sdk.openadsdk.component.vCE.IlO ilO = this.dY;
        if (ilO != null) {
            ilO.IlO(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF, com.bytedance.sdk.openadsdk.core.lEW.bWL
    public boolean IlO(JSONObject jSONObject) {
        oeT oet;
        if (jSONObject == null) {
            this.MY = false;
            return false;
        }
        int i2 = this.EO;
        if (i2 != 1 && i2 != 2) {
            this.MY = false;
            return false;
        }
        int iOptInt = jSONObject.optInt("switch", 0);
        float fOptDouble = (float) jSONObject.optDouble("speed", 0.0d);
        this.tV = fOptDouble;
        if (fOptDouble <= 0.0f && (oet = this.rp) != null && oet.eeU() != null) {
            this.tV = this.rp.eeU().IlO();
        }
        boolean z2 = iOptInt == 1;
        this.MY = z2;
        com.bytedance.sdk.openadsdk.component.vCE.MY my = this.vCE;
        if (my != null) {
            my.IlO(this.EO, this.tV, z2);
            com.bytedance.sdk.openadsdk.component.lEW.EO eo = this.lEW;
            if (eo != null && eo.MY() != null && this.Bc != null) {
                this.lEW.MY().IlO(this.Bc.IlO());
                com.bytedance.sdk.component.utils.oeT.IlO("PAGAppOpenAdExpressView", "isAccelerate =" + this.MY + ",total duration = " + this.lEW.MY().zPa());
            }
        }
        if (this.EO == 1) {
            return true;
        }
        if (!this.MY) {
            this.tV = 1.0f;
        }
        com.bytedance.sdk.openadsdk.component.lEW.EO eo2 = this.lEW;
        if (eo2 != null) {
            return eo2.IlO(this.tV);
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF, com.bytedance.sdk.openadsdk.core.lEW.bWL
    public void IlO(int i2) {
        com.bytedance.sdk.openadsdk.component.lEW.EO eo = this.lEW;
        if (eo == null) {
            return;
        }
        if (i2 != 1) {
            if (i2 == 2) {
                eo.lEW();
                this.vCE.tV();
                return;
            } else if (i2 == 3) {
                eo.DmF();
                this.vCE.EO();
                return;
            } else if (i2 == 4) {
                eo.NV();
                return;
            } else if (i2 != 5) {
                return;
            }
        }
        if (eo.Cc() || this.lEW.vCE()) {
            return;
        }
        this.lEW.IlO(getVideoFrameLayout(), this.Cc, this.rp);
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF, com.bytedance.sdk.openadsdk.core.lEW.bWL
    public long EO() {
        return this.Bc.EO();
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF, com.bytedance.sdk.component.adexpress.MY.lEW
    public void IlO(View view, int i2, com.bytedance.sdk.component.adexpress.EO eo) {
        if (i2 != -1 && eo != null && i2 == 3) {
            vCE();
        } else {
            super.IlO(view, i2, eo);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF
    public void IlO(hp.IlO ilO) {
        ilO.Cc(com.bytedance.sdk.openadsdk.component.Bc.IlO.IlO());
    }
}
