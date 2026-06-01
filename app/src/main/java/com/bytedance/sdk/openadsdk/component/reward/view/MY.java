package com.bytedance.sdk.openadsdk.component.reward.view;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.lEW.bWL;
import com.bytedance.sdk.openadsdk.core.lEW.kBB;
import com.bytedance.sdk.openadsdk.core.lEW.xF;
import com.bytedance.sdk.openadsdk.core.lEW.zPa;
import com.bytedance.sdk.openadsdk.core.model.es;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.model.vAh;
import com.bytedance.sdk.openadsdk.kBB.MY.Cc;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.mmj;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY extends xF {
    public static float IlO = 100.0f;
    private final com.bytedance.sdk.openadsdk.component.reward.IlO.IlO Cc;
    zPa EO;
    bWL MY;
    public int tV;
    private float vCE;

    public MY(com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO, AdSlot adSlot, String str) {
        super(ilO.BS, ilO.MY, adSlot, str, ilO.uvo, !ilO.BO);
        this.tV = 1;
        this.vCE = -1.0f;
        this.Cc = ilO;
        setVideoBusiness(ilO.ssS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EO(com.bytedance.sdk.component.adexpress.MY.bWL bwl) {
        if (bwl == null) {
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
                    frameLayoutZPa.addView(this.hp, layoutParams);
                    return;
                }
                return;
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.hp.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(iMY3, iMY4);
            }
            layoutParams2.width = iMY3;
            layoutParams2.height = iMY4;
            layoutParams2.topMargin = iMY2;
            layoutParams2.leftMargin = iMY;
            layoutParams2.setMarginStart(iMY);
            layoutParams2.setMarginEnd(layoutParams2.rightMargin);
            this.hp.setLayoutParams(layoutParams2);
        }
    }

    private void lEW() {
        setBackupListener(new com.bytedance.sdk.component.adexpress.MY.EO() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.MY.2
            @Override // com.bytedance.sdk.component.adexpress.MY.EO
            public boolean IlO(ViewGroup viewGroup, int i2) {
                try {
                    ((xF) viewGroup).cl();
                    MY.this.EO = new zPa(viewGroup.getContext());
                    MY my = MY.this;
                    my.EO.IlO(((xF) my).rp, (xF) viewGroup, MY.this.Cc.zLG);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF
    public void Bc() {
        this.ea = true;
        this.hp = new FrameLayout(this.DmF);
        if (!com.bytedance.sdk.openadsdk.core.NV.tV.IlO(this.rp) && !com.bytedance.sdk.openadsdk.core.NV.tV.MY(this.rp)) {
            addView(this.hp, new FrameLayout.LayoutParams(-1, -1));
        }
        super.Bc();
        com.bytedance.sdk.component.DmF.vCE webView = getWebView();
        if (webView != null) {
            webView.setBackgroundColor(0);
        }
        lEW();
        setVideoFrameChangeListener(new com.bytedance.sdk.openadsdk.rp.Bc() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.MY.1
            @Override // com.bytedance.sdk.openadsdk.rp.Bc
            public void IlO(com.bytedance.sdk.component.adexpress.MY.bWL bwl) {
                MY.this.MY(bwl);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF, com.bytedance.sdk.openadsdk.core.lEW.bWL
    public int Cc() {
        bWL bwl = this.MY;
        if (bwl != null) {
            return bwl.Cc();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        es esVar;
        NV nv = this.Cc.DM;
        if (nv != null && (esVar = nv.ea) != null && esVar.DmF()) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.vCE = motionEvent.getY();
            } else if (action == 1) {
            }
            if (BS.IlO(this.vCE, motionEvent.getY(), this.DmF)) {
                esVar.IlO(5);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public View getBackupContainerBackgroundView() {
        if (cL()) {
            return this.EO.getBackupContainerBackgroundView();
        }
        return null;
    }

    public FrameLayout getVideoFrameLayout() {
        return cL() ? this.EO.getVideoContainer() : this.hp;
    }

    public void setExpressVideoListenerProxy(bWL bwl) {
        this.MY = bwl;
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF, com.bytedance.sdk.openadsdk.core.lEW.bWL
    public long tV() {
        bWL bwl = this.MY;
        if (bwl != null) {
            return bwl.tV();
        }
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF, com.bytedance.sdk.openadsdk.core.lEW.bWL
    public void vCE() {
        bWL bwl = this.MY;
        if (bwl != null) {
            bwl.vCE();
        }
    }

    public void MY(final com.bytedance.sdk.component.adexpress.MY.bWL bwl) {
        if (bwl == null) {
            return;
        }
        mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.MY.3
            @Override // java.lang.Runnable
            public void run() {
                MY.this.EO(bwl);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF, com.bytedance.sdk.component.adexpress.MY.ea
    public void IlO(com.bytedance.sdk.component.adexpress.MY.tV<? extends View> tVVar, com.bytedance.sdk.component.adexpress.MY.bWL bwl) {
        this.vSq = tVVar;
        oeT oet = this.rp;
        if (oet != null && oet.pS()) {
            super.IlO(tVVar, bwl);
            return;
        }
        if (tVVar instanceof kBB) {
            kBB kbb = (kBB) tVVar;
            if (kbb.zPa() != null) {
                kbb.zPa().IlO((bWL) this);
            }
        }
        if (bwl != null && bwl.EO()) {
            MY(bwl);
            this.tV = tVVar.EO();
        }
        super.IlO(tVVar, bwl);
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF, com.bytedance.sdk.openadsdk.core.lEW.bWL
    public void MY() {
        bWL bwl = this.MY;
        if (bwl != null) {
            bwl.MY();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF, com.bytedance.sdk.openadsdk.core.lEW.bWL
    public void MY(int i2) {
        bWL bwl = this.MY;
        if (bwl != null) {
            bwl.MY(i2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF
    public boolean IlO(com.bytedance.sdk.component.adexpress.MY.bWL bwl) {
        oeT oet = this.rp;
        if ((oet instanceof vAh) && ((vAh) oet).dvD() && bwl.EO() && bwl.MY() == 1) {
            return false;
        }
        return super.IlO(bwl);
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF, com.bytedance.sdk.openadsdk.core.lEW.bWL
    public void IlO(String str, JSONObject jSONObject) {
        super.IlO(str, jSONObject);
        bWL bwl = this.MY;
        if (bwl != null) {
            bwl.IlO(str, jSONObject);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF, com.bytedance.sdk.openadsdk.core.lEW.bWL
    public void IlO(boolean z2, String str) {
        bWL bwl = this.MY;
        if (bwl != null) {
            bwl.IlO(z2, str);
        }
        setSoundMute(z2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF, com.bytedance.sdk.openadsdk.core.lEW.bWL
    public boolean IlO(JSONObject jSONObject) {
        Objects.toString(jSONObject);
        bWL bwl = this.MY;
        if (bwl != null) {
            return bwl.IlO(jSONObject);
        }
        return super.IlO(jSONObject);
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF, com.bytedance.sdk.openadsdk.core.lEW.bWL
    public long EO() {
        bWL bwl = this.MY;
        if (bwl != null) {
            return bwl.EO();
        }
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF, com.bytedance.sdk.openadsdk.core.lEW.bWL
    public void IlO() {
        bWL bwl = this.MY;
        if (bwl != null) {
            bwl.IlO();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF
    public Cc.IlO EO(int i2) {
        com.bytedance.sdk.openadsdk.activity.vCE vce;
        Cc.IlO ilOEO = super.EO(i2);
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.Cc;
        if (ilO.BO && (vce = ilO.ED) != null) {
            ilOEO.MY = vce.NV;
        }
        return ilOEO;
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF, com.bytedance.sdk.openadsdk.core.lEW.bWL
    public void IlO(int i2) {
        bWL bwl = this.MY;
        if (bwl != null) {
            bwl.IlO(i2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF, com.bytedance.sdk.openadsdk.core.lEW.bWL
    public void IlO(int i2, com.bytedance.sdk.component.adexpress.MY.bWL bwl) {
        bWL bwl2 = this.MY;
        if (bwl2 != null) {
            bwl2.IlO(i2, bwl);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF, com.bytedance.sdk.component.adexpress.MY.lEW
    public void IlO(View view, int i2, com.bytedance.sdk.component.adexpress.EO eo) {
        if (i2 != -1 && eo != null && i2 == 3) {
            vCE();
        } else {
            super.IlO(view, i2, eo);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF, com.bytedance.sdk.openadsdk.core.lEW.bWL
    public void IlO(int i2, String str) {
        bWL bwl = this.MY;
        if (bwl != null) {
            bwl.IlO(i2, str);
        }
    }
}
