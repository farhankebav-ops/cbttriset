package com.bytedance.sdk.openadsdk.core.lEW;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.rp.MY.vCE;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.bytedance.sdk.openadsdk.utils.zLG;
import w.a;
import w.d;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class es extends xF implements a, d {
    boolean Bc;
    int Cc;
    private com.bytedance.sdk.openadsdk.core.rp.MY.vCE DM;
    boolean EO;
    private ea IlO;
    int MY;
    private com.bytedance.sdk.openadsdk.IlO.MY.EO YA;
    private com.bytedance.sdk.openadsdk.multipro.MY.IlO dY;
    int lEW;
    private long lMM;
    private boolean mmj;
    private long nvX;
    boolean tV;
    boolean vCE;

    public es(@NonNull Context context, com.bytedance.sdk.openadsdk.core.model.oeT oet, AdSlot adSlot, String str, boolean z2) {
        super(context, oet, adSlot, str, false, true);
        this.MY = 1;
        this.EO = false;
        this.tV = true;
        this.vCE = true;
        this.Bc = true;
        this.lEW = -1;
        this.mmj = z2;
        DmF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EO(@NonNull com.bytedance.sdk.component.adexpress.MY.bWL bwl) {
        if (IlO(bwl, false)) {
            this.hp.removeAllViews();
            if (this.IlO != null) {
                int i2 = this.lEW;
                if ((i2 == 7 || i2 == 10) && (bwl instanceof com.bytedance.sdk.openadsdk.core.NV.Cc.MY)) {
                    FrameLayout frameLayoutZPa = ((com.bytedance.sdk.openadsdk.core.NV.Cc.MY) bwl).zPa();
                    if (frameLayoutZPa != null) {
                        frameLayoutZPa.removeAllViews();
                        frameLayoutZPa.addView(this.IlO, new FrameLayout.LayoutParams(-1, -1));
                    }
                } else if (bwl.IlO() == null) {
                    this.hp.addView(this.IlO);
                } else if (this.Bc) {
                    bwl.IlO().setTag(com.bytedance.sdk.component.adexpress.dynamic.IlO.vCE, 1);
                    ((FrameLayout) bwl.IlO()).removeAllViews();
                    ((FrameLayout) bwl.IlO()).addView(this.IlO, new FrameLayout.LayoutParams(-1, -1));
                    this.Bc = false;
                }
                this.IlO.IlO(0L, true, false);
                tV(this.Cc);
                if (!com.bytedance.sdk.component.utils.xF.tV(this.DmF) && !this.tV && this.vCE) {
                    this.IlO.Cc();
                }
                if (TextUtils.equals("embeded_ad", this.NV)) {
                    return;
                }
                setShowAdInteractionView(false);
            }
        }
    }

    private void oeT() {
        try {
            this.dY = new com.bytedance.sdk.openadsdk.multipro.MY.IlO();
            ea eaVar = new ea(this.DmF, this.rp, this.NV, this.OOq, this.mmj);
            this.IlO = eaVar;
            eaVar.setShouldCheckNetChange(false);
            this.IlO.setControllerStatusCallBack(new vCE.MY() { // from class: com.bytedance.sdk.openadsdk.core.lEW.es.2
                @Override // com.bytedance.sdk.openadsdk.core.rp.MY.vCE.MY
                public void IlO(boolean z2, long j, long j3, long j8, boolean z7) {
                    es.this.dY.IlO = z2;
                    es.this.dY.Cc = j;
                    es.this.dY.vCE = j3;
                    es.this.dY.Bc = j8;
                    es.this.dY.tV = z7;
                }
            });
            this.IlO.setVideoAdLoadListener(this);
            this.IlO.setVideoAdInteractionListener(this);
            if ("embeded_ad".equals(this.NV)) {
                this.IlO.setIsAutoPlay(this.EO ? this.EV.isAutoPlay() : this.tV);
            } else if ("open_ad".equals(this.NV)) {
                this.IlO.setIsAutoPlay(true);
            } else {
                this.IlO.setIsAutoPlay(this.tV);
            }
            if ("open_ad".equals(this.NV)) {
                this.IlO.IlO(true, "initVideo");
            } else {
                boolean zMY = com.bytedance.sdk.openadsdk.core.cl.tV().MY(String.valueOf(this.Cc));
                this.kBB = zMY;
                this.IlO.IlO(zMY, "initVideo");
            }
            this.IlO.tV();
        } catch (Exception unused) {
            this.IlO = null;
        }
    }

    private void setShowAdInteractionView(boolean z2) {
        ea eaVar = this.IlO;
        if (eaVar != null) {
            eaVar.setShowAdInteractionView(z2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF, com.bytedance.sdk.openadsdk.core.lEW.bWL
    public int Cc() {
        ea eaVar;
        if (this.MY == 3 && (eaVar = this.IlO) != null) {
            eaVar.tV();
        }
        ea eaVar2 = this.IlO;
        if (eaVar2 == null || !eaVar2.getNativeVideoController().hp()) {
            return this.MY;
        }
        return 1;
    }

    public void DmF() {
        this.hp = new FrameLayout(this.DmF);
        com.bytedance.sdk.openadsdk.core.model.oeT oet = this.rp;
        int iHFV = oet != null ? oet.hFV() : 0;
        this.Cc = iHFV;
        tV(iHFV);
        oeT();
        addView(this.hp, new FrameLayout.LayoutParams(-1, -1));
        if (getWebView() != null) {
            getWebView().setBackgroundColor(0);
        }
        setVideoFrameChangeListener(new com.bytedance.sdk.openadsdk.rp.Bc() { // from class: com.bytedance.sdk.openadsdk.core.lEW.es.1
            @Override // com.bytedance.sdk.openadsdk.rp.Bc
            public void IlO(final com.bytedance.sdk.component.adexpress.MY.bWL bwl) {
                mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.lEW.es.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        es.this.IlO(bwl, true);
                    }
                });
            }
        });
    }

    public void EV() {
        com.bytedance.sdk.openadsdk.core.rp.MY.vCE vce = this.DM;
        if (vce != null) {
            vce.ea();
            return;
        }
        ea eaVar = this.IlO;
        if (eaVar != null) {
            eaVar.ea();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF, com.bytedance.sdk.openadsdk.core.lEW.bWL
    public void IlO() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF, com.bytedance.sdk.openadsdk.core.lEW.bWL
    public void MY() {
    }

    public void NV() {
        com.bytedance.sdk.openadsdk.core.rp.MY.vCE vce = this.DM;
        if (vce != null) {
            vce.hp();
            return;
        }
        ea eaVar = this.IlO;
        if (eaVar != null) {
            eaVar.hp();
        }
    }

    @Override // w.a
    public void e_() {
        this.vCE = false;
        this.MY = 2;
        com.bytedance.sdk.openadsdk.IlO.MY.EO eo = this.YA;
        if (eo != null) {
            eo.IlO(null);
        }
    }

    @Override // w.a
    public void f_() {
        this.vCE = false;
        this.bWL = true;
        this.MY = 3;
        com.bytedance.sdk.openadsdk.IlO.MY.EO eo = this.YA;
        if (eo != null) {
            eo.MY(null);
        }
    }

    @Override // w.a
    public void g_() {
        this.vCE = false;
        this.bWL = false;
        this.MY = 2;
    }

    public ea getExpressVideoView() {
        return this.IlO;
    }

    public com.bytedance.sdk.openadsdk.IlO.MY.EO getVideoAdListener() {
        return this.YA;
    }

    @Nullable
    public com.bytedance.sdk.openadsdk.core.rp.MY.EO getVideoController() {
        ea eaVar = this.IlO;
        if (eaVar != null) {
            return eaVar.getNativeVideoController();
        }
        return null;
    }

    public com.bytedance.sdk.openadsdk.multipro.MY.IlO getVideoModel() {
        return this.dY;
    }

    @Override // w.a
    public void h_() {
        this.vCE = false;
        this.MY = 5;
        com.bytedance.sdk.component.adexpress.MY.MY my = this.oc;
        if (my != null && my.MY() != null) {
            this.oc.MY().onvideoComplate();
        }
        com.bytedance.sdk.openadsdk.IlO.MY.EO eo = this.YA;
        if (eo != null) {
            eo.EO(null);
        }
        com.bytedance.sdk.component.adexpress.MY.tV<? extends View> tVVar = this.vSq;
        if (tVVar instanceof com.bytedance.sdk.openadsdk.core.NV.Cc.EO) {
            ((com.bytedance.sdk.openadsdk.core.NV.Cc.EO) tVVar).onvideoComplate();
        }
    }

    public boolean lEW() {
        return this.mmj;
    }

    public void rp() {
        com.bytedance.sdk.openadsdk.core.rp.MY.EO videoController = getVideoController();
        if (videoController != null) {
            videoController.IlO(3, true);
        }
    }

    public void setBackupVideoView(com.bytedance.sdk.openadsdk.core.rp.MY.vCE vce) {
        this.DM = vce;
    }

    public void setVideoAdListener(com.bytedance.sdk.openadsdk.IlO.MY.EO eo) {
        this.YA = eo;
    }

    public void tV(int i2) {
        int iMY = com.bytedance.sdk.openadsdk.core.cl.tV().MY(i2);
        if (3 == iMY) {
            this.EO = false;
            this.tV = false;
        } else if (4 == iMY) {
            this.EO = true;
        } else {
            int iEO = com.bytedance.sdk.component.utils.xF.EO(com.bytedance.sdk.openadsdk.core.cl.IlO());
            if (1 == iMY) {
                this.EO = false;
                this.tV = zLG.tV(iEO);
            } else if (2 == iMY) {
                if (zLG.Cc(iEO) || zLG.tV(iEO) || zLG.vCE(iEO)) {
                    this.EO = false;
                    this.tV = true;
                }
            } else if (5 == iMY && (zLG.tV(iEO) || zLG.vCE(iEO))) {
                this.EO = false;
                this.tV = true;
            }
        }
        if (this.tV) {
            return;
        }
        this.MY = 3;
    }

    private void MY(final com.bytedance.sdk.component.adexpress.MY.bWL bwl) {
        if (bwl == null) {
            return;
        }
        mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.lEW.es.3
            @Override // java.lang.Runnable
            public void run() {
                es.this.EO(bwl);
            }
        });
    }

    private void MY(long j, long j3) {
        int iAbs = (int) Math.abs(((long) this.es) - j);
        int i2 = this.es;
        if (i2 < 0 || iAbs > 500 || i2 > j3 || iAbs >= 500 || this.AXM.contains(this.xF)) {
            return;
        }
        if (this.es > j) {
            postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.lEW.es.4
                @Override // java.lang.Runnable
                public void run() {
                    es.this.IlO.setCanInterruptVideoPlay(true);
                    es.this.IlO.performClick();
                    es esVar = es.this;
                    esVar.MY(esVar.es, esVar.xF);
                }
            }, iAbs);
        } else {
            this.IlO.setCanInterruptVideoPlay(true);
            this.IlO.performClick();
            MY(this.es, this.xF);
        }
        this.AXM.add(this.xF);
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF, com.bytedance.sdk.component.adexpress.MY.ea
    public void IlO(com.bytedance.sdk.component.adexpress.MY.tV<? extends View> tVVar, com.bytedance.sdk.component.adexpress.MY.bWL bwl) {
        this.vSq = tVVar;
        this.lEW = tVVar.EO();
        com.bytedance.sdk.component.adexpress.MY.tV<? extends View> tVVar2 = this.vSq;
        if ((tVVar2 instanceof kBB) && ((kBB) tVVar2).zPa() != null) {
            ((kBB) this.vSq).zPa().IlO((bWL) this);
        }
        if (bwl != null && bwl.EO()) {
            MY(bwl);
        }
        super.IlO(tVVar, bwl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean IlO(com.bytedance.sdk.component.adexpress.MY.bWL bwl, boolean z2) {
        int i2;
        double dVCE = bwl.vCE();
        double dBc = bwl.Bc();
        double dLEW = bwl.lEW();
        double dDmF = bwl.DmF();
        if ((dLEW == 0.0d || dDmF == 0.0d) && (i2 = this.lEW) != 7 && i2 != 10 && i2 != 9) {
            return false;
        }
        int iMY = BS.MY(this.DmF, (float) dVCE);
        int iMY2 = BS.MY(this.DmF, (float) dBc);
        int iMY3 = BS.MY(this.DmF, (float) dLEW);
        int iMY4 = BS.MY(this.DmF, (float) dDmF);
        float fMin = Math.min(Math.min(BS.MY(this.DmF, bwl.rp()), BS.MY(this.DmF, bwl.hp())), Math.min(BS.MY(this.DmF, bwl.bWL()), BS.MY(this.DmF, bwl.ea())));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hp.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(iMY3, iMY4);
        }
        layoutParams.width = iMY3;
        layoutParams.height = iMY4;
        layoutParams.topMargin = iMY2;
        layoutParams.leftMargin = iMY;
        layoutParams.setMarginStart(iMY);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        this.hp.setLayoutParams(layoutParams);
        BS.MY(this.hp, fMin);
        ea eaVar = this.IlO;
        if (eaVar == null || !z2) {
            return true;
        }
        eaVar.IlO(iMY3, iMY4);
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF, com.bytedance.sdk.openadsdk.core.lEW.bWL
    public long tV() {
        return this.lMM;
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF, com.bytedance.sdk.openadsdk.core.lEW.bWL
    public void vCE() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF, com.bytedance.sdk.openadsdk.core.lEW.bWL
    public long EO() {
        return this.lMM;
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF, com.bytedance.sdk.openadsdk.core.lEW.bWL
    public void IlO(boolean z2, String str) {
        ea eaVar;
        if (this.rp.Tgn() || (eaVar = this.IlO) == null) {
            return;
        }
        eaVar.IlO(z2, str);
        setSoundMute(z2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF, com.bytedance.sdk.openadsdk.core.lEW.bWL
    public void IlO(int i2) {
        ea eaVar = this.IlO;
        if (eaVar == null) {
            return;
        }
        if (i2 == 1) {
            eaVar.IlO(0L, true, false);
            return;
        }
        if (i2 == 2 || i2 == 3) {
            eaVar.setCanInterruptVideoPlay(true);
            this.IlO.performClick();
        } else if (i2 == 4) {
            eaVar.getNativeVideoController().tV();
        } else {
            if (i2 != 5) {
                return;
            }
            eaVar.IlO(0L, true, false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF, com.bytedance.sdk.component.adexpress.MY.lEW
    public void IlO(View view, int i2, com.bytedance.sdk.component.adexpress.EO eo) {
        if (i2 == -1 || eo == null) {
            return;
        }
        if (i2 == 11) {
            try {
                ea eaVar = this.IlO;
                if (eaVar != null) {
                    eaVar.setCanInterruptVideoPlay(true);
                    this.IlO.performClick();
                    if (this.bWL) {
                        this.IlO.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.xJ).setVisibility(0);
                        return;
                    }
                    return;
                }
                return;
            } catch (Exception unused) {
                return;
            }
        }
        super.IlO(view, i2, eo);
    }

    @Override // w.a
    public void IlO(long j, long j3) {
        this.vCE = false;
        int i2 = this.MY;
        if (i2 != 5 && i2 != 3 && j > this.lMM) {
            this.MY = 2;
        }
        this.lMM = j;
        this.nvX = j3;
        com.bytedance.sdk.component.adexpress.MY.MY my = this.oc;
        if (my != null && my.MY() != null) {
            this.oc.MY().setTimeUpdate(((int) (j3 - j)) / 1000);
        }
        com.bytedance.sdk.component.adexpress.MY.tV<? extends View> tVVar = this.vSq;
        if (tVVar instanceof com.bytedance.sdk.openadsdk.core.NV.Cc.EO) {
            ((com.bytedance.sdk.openadsdk.core.NV.Cc.EO) tVVar).setTimeUpdate(((int) (j3 - j)) / 1000);
        }
        MY(j, j3);
    }

    @Override // w.d
    public void IlO(int i2, int i8) {
        this.lMM = this.nvX;
        this.MY = 4;
        com.bytedance.sdk.openadsdk.IlO.MY.EO eo = this.YA;
        if (eo != null) {
            eo.IlO(i2, i8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.xF, com.bytedance.sdk.openadsdk.core.lEW.bWL
    public void IlO(int i2, String str) {
        this.es = i2;
        this.xF = str;
    }
}
