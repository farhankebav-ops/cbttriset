package com.bytedance.sdk.openadsdk.component;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.vSq;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdLoadListener;
import com.bytedance.sdk.openadsdk.component.vCE;
import com.bytedance.sdk.openadsdk.core.bWL;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.lEW;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.model.pP;
import com.bytedance.sdk.openadsdk.core.settings.hp;
import com.bytedance.sdk.openadsdk.core.xF;
import com.bytedance.sdk.openadsdk.utils.DM;
import com.bytedance.sdk.openadsdk.utils.mmj;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Bc implements vSq.IlO {
    private PAGAppOpenAdLoadListener Bc;
    private final vCE EO;
    private boolean EV;
    private final Context IlO;
    private final xF<com.bytedance.sdk.openadsdk.tV.IlO> MY;
    private int lEW;
    private AdSlot vCE;
    private final AtomicBoolean tV = new AtomicBoolean(false);
    private int Cc = 0;
    private volatile int DmF = 0;
    private final com.bytedance.sdk.openadsdk.core.model.vSq NV = new com.bytedance.sdk.openadsdk.core.model.vSq();

    public Bc(Context context) {
        if (context != null) {
            this.IlO = context.getApplicationContext();
        } else {
            this.IlO = cl.IlO();
        }
        this.MY = cl.EO();
        this.EO = vCE.IlO(this.IlO);
    }

    private void MY(@NonNull final AdSlot adSlot) {
        final DM dmMY = DM.MY();
        this.DmF = 1;
        pP pPVar = new pP();
        pPVar.NV = this.NV;
        pPVar.tV = 1;
        pPVar.lEW = 2;
        this.MY.IlO(adSlot, pPVar, 3, new xF.IlO() { // from class: com.bytedance.sdk.openadsdk.component.Bc.1
            @Override // com.bytedance.sdk.openadsdk.core.xF.IlO
            public void IlO(int i2, String str) {
                Bc.this.DmF = 3;
                Bc.this.IlO(new com.bytedance.sdk.openadsdk.component.Cc.MY(2, 100, i2, str));
            }

            @Override // com.bytedance.sdk.openadsdk.core.xF.IlO
            public void IlO(final com.bytedance.sdk.openadsdk.core.model.IlO ilO, com.bytedance.sdk.openadsdk.core.model.EO eo) {
                Bc.this.DmF = 2;
                if (ilO == null || ilO.tV() == null || ilO.tV().size() == 0) {
                    Bc.this.DmF = 3;
                    Bc.this.IlO(new com.bytedance.sdk.openadsdk.component.Cc.MY(2, 100, 20001, lEW.IlO(20001)));
                    eo.IlO(-3);
                    com.bytedance.sdk.openadsdk.core.model.EO.IlO(eo);
                    return;
                }
                final oeT oet = ilO.tV().get(0);
                long jAXM = oet.AXM();
                Bc.this.NV.MY = jAXM;
                boolean zBc = oeT.Bc(oet);
                if (oet.mV()) {
                    Bc.this.IlO(new com.bytedance.sdk.openadsdk.component.Cc.MY(1, 100, oet, ilO));
                    return;
                }
                if (zBc || oet.uAj()) {
                    Bc.this.IlO(new com.bytedance.sdk.openadsdk.component.Cc.MY(1, 100, oet, ilO));
                    if (oeT.Cc(oet)) {
                        Bc.this.IlO(oet, adSlot, false, ilO);
                        return;
                    } else {
                        Bc.this.IlO(oet, false, ilO);
                        return;
                    }
                }
                if (oeT.Cc(oet)) {
                    int iEV = cl.tV().EV();
                    if (iEV == 1 || iEV == 3) {
                        Bc.this.NV.MY = -1L;
                        Bc.this.NV.IlO(3);
                        Bc.this.IlO(new com.bytedance.sdk.openadsdk.component.Cc.MY(1, 100, oet, ilO));
                        Bc.this.IlO(oet, adSlot, false, ilO);
                        return;
                    }
                    Bc.this.IlO(oet, adSlot, !r0.NV.IlO, ilO);
                } else {
                    if (cl.tV().NV() == 1) {
                        Bc.this.NV.MY = -1L;
                        Bc.this.NV.IlO(3);
                        Bc.this.IlO(new com.bytedance.sdk.openadsdk.component.Cc.MY(1, 100, oet, ilO));
                        Bc.this.IlO(oet, false, ilO);
                        return;
                    }
                    Bc.this.IlO(oet, !r0.NV.IlO, ilO);
                }
                if (Bc.this.NV.IlO) {
                    com.bytedance.sdk.openadsdk.ea.EO.IlO(oet, dmMY.tV());
                    if (jAXM == 0) {
                        Bc.this.NV.IlO(2);
                        Bc.this.IlO(new com.bytedance.sdk.openadsdk.component.Cc.MY(1, 100, oet, ilO));
                    } else {
                        bWL.MY().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.Bc.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Bc.this.NV.IlO(2);
                                Bc.this.IlO(new com.bytedance.sdk.openadsdk.component.Cc.MY(1, 100, oet, ilO));
                            }
                        }, jAXM);
                    }
                }
            }
        });
    }

    public static Bc IlO(Context context) {
        return new Bc(context);
    }

    public void IlO(@NonNull AdSlot adSlot, com.bytedance.sdk.openadsdk.common.vCE vce, int i2) {
        if (vce == null) {
            return;
        }
        if (i2 <= 0) {
            i2 = 3500;
        }
        this.vCE = adSlot;
        this.NV.IlO = !TextUtils.isEmpty(adSlot.getBidAdm());
        if (vce instanceof PAGAppOpenAdLoadListener) {
            this.Bc = (PAGAppOpenAdLoadListener) vce;
        }
        this.Cc = IlO(this.vCE);
        this.lEW = i2;
        this.NV.IlO(DM.MY());
        if (this.NV.IlO || hp.aP().kBB(this.vCE.getCodeId()) == 0) {
            MY(this.vCE);
        }
        if (this.NV.IlO) {
            return;
        }
        new vSq(bWL.MY().getLooper(), this).sendEmptyMessageDelayed(1, i2);
        IlO();
    }

    private void IlO() {
        mmj.MY(new com.bytedance.sdk.component.lEW.lEW("tryGetAppOpenAdFromCache") { // from class: com.bytedance.sdk.openadsdk.component.Bc.2
            @Override // java.lang.Runnable
            public void run() {
                int iEV;
                oeT oetCc = Bc.this.EO.Cc(Bc.this.Cc);
                if (oetCc == null) {
                    Bc.this.IlO(false);
                    return;
                }
                if (oetCc.ssS() == null) {
                    oetCc.IlO(Bc.this.vCE);
                }
                boolean zCc = oeT.Cc(oetCc);
                if (oetCc.mV()) {
                    Bc.this.IlO(new com.bytedance.sdk.openadsdk.component.Cc.MY(1, 101, oetCc, (com.bytedance.sdk.openadsdk.core.model.IlO) null));
                    return;
                }
                if (!zCc && cl.tV().NV() == 1) {
                    Bc.this.IlO(new com.bytedance.sdk.openadsdk.component.Cc.MY(1, 101, oetCc, (com.bytedance.sdk.openadsdk.core.model.IlO) null));
                    return;
                }
                if (zCc && ((iEV = cl.tV().EV()) == 2 || iEV == 3)) {
                    Bc.this.IlO(new com.bytedance.sdk.openadsdk.component.Cc.MY(1, 101, oetCc, (com.bytedance.sdk.openadsdk.core.model.IlO) null));
                    return;
                }
                if (!Bc.this.EO.MY(Bc.this.Cc) && !Bc.this.EO.tV(Bc.this.Cc)) {
                    Bc.this.IlO(true);
                    return;
                }
                if (hp.aP().kBB(Bc.this.vCE.getCodeId()) == 0) {
                    Bc.this.EO.Bc(Bc.this.Cc);
                }
                if (zCc) {
                    if (!TextUtils.isEmpty(Bc.this.EO.IlO(oetCc))) {
                        Bc.this.IlO(new com.bytedance.sdk.openadsdk.component.Cc.MY(1, 101, oetCc, (com.bytedance.sdk.openadsdk.core.model.IlO) null));
                        return;
                    } else {
                        Bc.this.IlO(false);
                        com.bytedance.sdk.openadsdk.component.tV.IlO.MY(oetCc);
                        return;
                    }
                }
                if (Bc.this.EO.MY(oetCc)) {
                    Bc.this.IlO(new com.bytedance.sdk.openadsdk.component.Cc.MY(1, 101, oetCc, (com.bytedance.sdk.openadsdk.core.model.IlO) null));
                } else {
                    Bc.this.IlO(false);
                    com.bytedance.sdk.openadsdk.component.tV.IlO.MY(oetCc);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(boolean z2) {
        if (z2) {
            this.EO.Bc(this.Cc);
        }
        if (hp.aP().kBB(this.vCE.getCodeId()) == 1) {
            MY(this.vCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(@NonNull final oeT oet, AdSlot adSlot, final boolean z2, final com.bytedance.sdk.openadsdk.core.model.IlO ilO) {
        this.EO.IlO(oet, adSlot, this.NV, new vCE.EO() { // from class: com.bytedance.sdk.openadsdk.component.Bc.3
            @Override // com.bytedance.sdk.openadsdk.component.vCE.EO
            public void IlO() {
                Log.d("TTAppOpenAdLoadManager", "preLoadSuccess: video load success");
                if (z2) {
                    Bc.this.DmF = 4;
                    com.bytedance.sdk.openadsdk.component.Cc.MY my = new com.bytedance.sdk.openadsdk.component.Cc.MY(1, 100, oet, ilO);
                    my.IlO(true);
                    Bc.this.IlO(my);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.vCE.EO
            public void IlO(int i2, String str) {
                if (z2) {
                    Bc.this.DmF = 5;
                    Bc.this.IlO(new com.bytedance.sdk.openadsdk.component.Cc.MY(2, 100, 10003, lEW.IlO(10003)));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(@NonNull final oeT oet, final boolean z2, final com.bytedance.sdk.openadsdk.core.model.IlO ilO) {
        this.EO.IlO(oet, this.NV, new vCE.MY() { // from class: com.bytedance.sdk.openadsdk.component.Bc.4
            @Override // com.bytedance.sdk.openadsdk.component.vCE.MY
            public void IlO(com.bytedance.sdk.openadsdk.cL.IlO.EO eo) {
                Log.d("TTAppOpenAdLoadManager", "preLoadSuccess: image load success");
                if (z2) {
                    Bc.this.DmF = 4;
                    com.bytedance.sdk.openadsdk.component.Cc.MY my = new com.bytedance.sdk.openadsdk.component.Cc.MY(1, 100, oet, ilO);
                    my.IlO(true);
                    Bc.this.IlO(my);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.vCE.MY
            public void IlO() {
                Log.d("TTAppOpenAdLoadManager", "preLoadFail: image load fail");
                if (z2) {
                    Bc.this.DmF = 5;
                    Bc.this.IlO(new com.bytedance.sdk.openadsdk.component.Cc.MY(2, 100, 10003, lEW.IlO(10003)));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(com.bytedance.sdk.openadsdk.component.Cc.MY my) {
        int iEO = my.EO();
        int iTV = my.tV();
        if (this.tV.get()) {
            if (iEO == 1 && iTV == 100 && my.MY()) {
                vCE.IlO(cl.IlO()).IlO(new com.bytedance.sdk.openadsdk.component.Cc.IlO(this.Cc, my.Cc(), my.IlO()));
                if (this.EV) {
                    return;
                }
                com.bytedance.sdk.openadsdk.component.tV.IlO.IlO(my.Cc(), 1, this.NV);
                return;
            }
            return;
        }
        if (iEO != 1) {
            if (iEO == 2 || iEO == 3) {
                PAGAppOpenAdLoadListener pAGAppOpenAdLoadListener = this.Bc;
                if (pAGAppOpenAdLoadListener != null) {
                    pAGAppOpenAdLoadListener.onError(my.vCE(), my.Bc());
                }
                this.tV.set(true);
                if (iEO == 3) {
                    com.bytedance.sdk.openadsdk.component.tV.IlO.IlO(this.DmF, this.lEW);
                    return;
                }
                return;
            }
            return;
        }
        if (this.Bc != null) {
            this.Bc.onAdLoaded(new tV(this.IlO, my.Cc(), iTV == 101, this.vCE));
        }
        this.tV.set(true);
        if (iTV == 101) {
            com.bytedance.sdk.openadsdk.component.tV.IlO.IlO(my.Cc(), this.NV.IlO().tV());
            return;
        }
        if (iTV == 100) {
            com.bytedance.sdk.openadsdk.component.tV.IlO.IlO(my.Cc(), 0, this.NV);
            this.EV = true;
            if (this.NV.IlO || oeT.Bc(my.Cc())) {
                return;
            }
            oeT oetCc = my.Cc();
            if (hp.aP().kBB(this.vCE.getCodeId()) == 0 && oetCc != null && !oetCc.uAj()) {
                this.EO.IlO(this.vCE);
            } else {
                this.EO.IlO(new com.bytedance.sdk.openadsdk.component.Cc.IlO(this.Cc, my.Cc(), my.IlO()));
            }
        }
    }

    public int IlO(@NonNull AdSlot adSlot) {
        try {
            return Integer.parseInt(adSlot.getCodeId());
        } catch (Throwable unused) {
            return 0;
        }
    }

    @Override // com.bytedance.sdk.component.utils.vSq.IlO
    public void IlO(Message message) {
        if (message.what != 1 || this.tV.get()) {
            return;
        }
        IlO(new com.bytedance.sdk.openadsdk.component.Cc.MY(3, 102, 10002, lEW.IlO(10002)));
    }
}
