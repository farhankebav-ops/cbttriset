package com.bytedance.sdk.openadsdk.component.reward.IlO;

import android.os.SystemClock;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.pP;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.ironsource.C2300e4;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class ea {
    private volatile long Bc;
    private String DmF;
    private FrameLayout EO;
    final oeT IlO;
    private final IlO MY;
    private com.bytedance.adsdk.ugeno.MY.EO bWL;
    private boolean cl;
    private com.bytedance.adsdk.ugeno.MY.EO hp;
    private volatile long lEW;
    private volatile long vCE;
    private final AtomicBoolean tV = new AtomicBoolean(false);
    private final AtomicBoolean Cc = new AtomicBoolean(false);
    private final AtomicBoolean NV = new AtomicBoolean(false);
    private long EV = 0;
    private long rp = 0;
    private String ea = null;
    private boolean zPa = false;

    public ea(IlO ilO) {
        this.MY = ilO;
        this.IlO = ilO.MY;
        this.DmF = ilO.Cc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWL() {
        com.bytedance.sdk.openadsdk.core.NV.Bc.IlO ilOXqE;
        oeT oet = this.IlO;
        if (oet == null || (ilOXqE = oet.xqE()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.NV.tV.MY my = new com.bytedance.sdk.openadsdk.core.NV.tV.MY(this.MY.BS, this.IlO, ilOXqE, this.DmF, new com.bytedance.sdk.openadsdk.core.NV.vCE.MY() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.ea.3
            @Override // com.bytedance.sdk.openadsdk.core.NV.vCE.MY
            public void IlO() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.NV.vCE.EO
            public void MY(String str) {
                ea eaVar = ea.this;
                com.bytedance.sdk.openadsdk.tV.EO.IlO(eaVar.IlO, true, eaVar.DmF, "success", SystemClock.elapsedRealtime() - ea.this.rp, str, "endcard", 0, null);
            }

            @Override // com.bytedance.sdk.openadsdk.core.NV.vCE.EO
            public void IlO(String str) {
                ea.this.rp = SystemClock.elapsedRealtime();
            }

            @Override // com.bytedance.sdk.openadsdk.core.NV.vCE.EO
            public void IlO(int i2, String str, String str2) {
                ea.this.Cc.set(false);
                ea eaVar = ea.this;
                com.bytedance.sdk.openadsdk.tV.EO.IlO(eaVar.IlO, true, eaVar.DmF, C2300e4.f.e, SystemClock.elapsedRealtime() - ea.this.rp, str2, "endcard", i2, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.NV.vCE.MY
            public void IlO(int i2, String str) {
                ea.this.Cc.set(false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.NV.vCE.MY
            public void IlO(com.bytedance.adsdk.ugeno.MY.EO<View> eo) {
                ea.this.bWL = eo;
                ea.this.Cc.set(true);
            }
        });
        my.IlO(new com.bytedance.sdk.openadsdk.core.NV.vCE.IlO() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.ea.4
            @Override // com.bytedance.sdk.openadsdk.core.NV.vCE.IlO
            public String IlO() {
                return "overlay";
            }

            @Override // com.bytedance.sdk.openadsdk.core.NV.vCE.IlO
            public void MY() {
                ea.this.zPa = true;
                ea.this.MY.DM.NV().performClick();
            }
        });
        my.IlO();
        my.IlO(this.MY.DM.NV());
    }

    public void EV() {
        com.bytedance.sdk.openadsdk.tV.EO.IlO(SystemClock.elapsedRealtime() - this.lEW, this.IlO, this.DmF);
    }

    public void NV() {
        com.bytedance.sdk.openadsdk.tV.EO.EO(this.IlO, this.DmF);
    }

    public boolean hp() {
        return this.Cc.get();
    }

    public boolean rp() {
        return this.tV.get();
    }

    public void Bc() {
        NV();
        DmF();
        com.bytedance.adsdk.ugeno.MY.EO eo = this.hp;
        if (eo != null) {
            this.EO.addView(eo.EV(), new FrameLayout.LayoutParams(this.hp.nvX(), this.hp.YA()));
        }
    }

    public void Cc() {
        this.vCE = SystemClock.elapsedRealtime();
        com.bytedance.sdk.openadsdk.tV.EO.IlO(this.IlO, this.DmF);
    }

    public void DmF() {
        if (this.lEW <= 0 || this.Bc <= 0 || this.NV.getAndSet(true)) {
            return;
        }
        com.bytedance.sdk.openadsdk.tV.EO.MY(this.Bc - this.lEW, this.IlO, this.DmF, this.ea);
    }

    public void lEW() {
        com.bytedance.adsdk.ugeno.MY.EO eo = this.bWL;
        if (eo != null) {
            this.EO.addView(eo.EV(), new FrameLayout.LayoutParams(this.bWL.nvX(), this.bWL.YA()));
        }
    }

    public boolean tV() {
        return this.zPa;
    }

    public void vCE() {
        this.lEW = SystemClock.elapsedRealtime();
    }

    public void EO() {
        com.bytedance.sdk.openadsdk.core.NV.Bc.IlO ilOQtY;
        oeT oet = this.IlO;
        if (oet == null || (ilOQtY = oet.QtY()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.NV.tV.MY my = new com.bytedance.sdk.openadsdk.core.NV.tV.MY(this.MY.BS, this.IlO, ilOQtY, this.DmF, new com.bytedance.sdk.openadsdk.core.NV.vCE.MY() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.ea.1
            @Override // com.bytedance.sdk.openadsdk.core.NV.vCE.EO
            public void IlO(String str) {
                ea.this.EV = SystemClock.elapsedRealtime();
            }

            @Override // com.bytedance.sdk.openadsdk.core.NV.vCE.EO
            public void MY(String str) {
                ea.this.ea = str;
                ea eaVar = ea.this;
                com.bytedance.sdk.openadsdk.tV.EO.IlO(eaVar.IlO, false, eaVar.DmF, "success", SystemClock.elapsedRealtime() - ea.this.EV, str, "endcard", 0, null);
            }

            @Override // com.bytedance.sdk.openadsdk.core.NV.vCE.EO
            public void IlO(int i2, String str, String str2) {
                ea.this.ea = str2;
                ea.this.tV.set(false);
                ea eaVar = ea.this;
                com.bytedance.sdk.openadsdk.tV.EO.IlO(eaVar.IlO, false, eaVar.DmF, C2300e4.f.e, SystemClock.elapsedRealtime() - ea.this.EV, str2, "endcard", i2, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.NV.vCE.MY
            public void IlO() {
                ea.this.Cc();
            }

            @Override // com.bytedance.sdk.openadsdk.core.NV.vCE.MY
            public void IlO(int i2, String str) {
                ea.this.tV.set(false);
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                ea eaVar = ea.this;
                com.bytedance.sdk.openadsdk.tV.EO.IlO(eaVar.IlO, eaVar.DmF, jElapsedRealtime - ea.this.vCE, i2, str, (String) null);
            }

            @Override // com.bytedance.sdk.openadsdk.core.NV.vCE.MY
            public void IlO(com.bytedance.adsdk.ugeno.MY.EO<View> eo) {
                ea.this.hp = eo;
                ea.this.tV.set(true);
                ea.this.Bc = SystemClock.elapsedRealtime();
                if (ea.this.MY.lMM.tl()) {
                    View viewNV = ea.this.MY.DM.NV();
                    if (viewNV instanceof com.bytedance.sdk.openadsdk.core.Cc.tV) {
                        ((com.bytedance.sdk.openadsdk.core.Cc.tV) viewNV).setImageResource(pP.tV(ea.this.MY.gQ, "tt_skip_btn"));
                    }
                }
                ea.this.bWL();
                ea.this.DmF();
                ea eaVar = ea.this;
                com.bytedance.sdk.openadsdk.tV.EO.IlO(eaVar.IlO, eaVar.DmF, ea.this.Bc - ea.this.vCE);
            }
        });
        if (this.IlO.xqE() != null) {
            my.IlO(new com.bytedance.sdk.openadsdk.core.NV.vCE.IlO() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.ea.2
                @Override // com.bytedance.sdk.openadsdk.core.NV.vCE.IlO
                public String IlO() {
                    return "normal";
                }

                @Override // com.bytedance.sdk.openadsdk.core.NV.vCE.IlO
                public void MY() {
                }
            });
        }
        my.IlO();
        my.IlO(this.MY.DM.NV());
    }

    public void MY() {
        this.EO = (FrameLayout) this.MY.zLG.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.ea);
    }

    public void IlO() {
        if (this.cl) {
            return;
        }
        this.cl = true;
        MY();
    }

    public void IlO(int i2) {
        BS.IlO((View) this.EO, i2);
    }
}
