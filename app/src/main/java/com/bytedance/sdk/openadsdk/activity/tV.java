package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.bytedance.sdk.component.utils.pP;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.kBB;
import com.bytedance.sdk.openadsdk.core.model.OOq;
import com.bytedance.sdk.openadsdk.core.model.es;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.tV.Cc.MY.ea;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV extends IlO {
    int Cc;
    private boolean vCE;

    public tV(MY my, oeT oet, int i2, int i8) {
        super(my, oet, i2, i8);
    }

    private void Cc(int i2) {
        this.EO.YA.IlO(null, new SpannableStringBuilder(String.format(pP.IlO(cl.IlO(), "tt_skip_ad_time_text"), Integer.valueOf(i2))));
    }

    @Override // com.bytedance.sdk.openadsdk.activity.IlO
    public void Bc() {
        oc();
        if (this.lEW.vCE()) {
            this.EO.tl.NV();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.IlO, com.bytedance.sdk.openadsdk.activity.vCE
    public void EO(Activity activity) {
        super.EO(activity);
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.EO;
        if (ilO == null || !MY(ilO.MY) || IlO(this.EO.MY)) {
            return;
        }
        if (this.vCE) {
            this.vCE = false;
            OOq();
        } else if (this.EO.lMM.nvX()) {
            OOq();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.IlO, com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public void IlO(Bundle bundle) {
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @Override // com.bytedance.sdk.openadsdk.activity.IlO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void MY() {
        /*
            r3 = this;
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r0 = r3.EO
            com.bytedance.sdk.openadsdk.core.model.oeT r0 = r0.MY
            boolean r0 = com.bytedance.sdk.openadsdk.core.model.oeT.Cc(r0)
            r1 = 0
            if (r0 != 0) goto L19
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r0 = r3.EO
            boolean r2 = r0.EO
            if (r2 != 0) goto L19
            com.bytedance.sdk.openadsdk.component.reward.IlO.bWL r0 = r0.YA
            java.lang.String r2 = "X"
            r0.IlO(r1, r2)
            goto L24
        L19:
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r0 = r3.EO
            com.bytedance.sdk.openadsdk.component.reward.IlO.bWL r0 = r0.YA
            java.lang.String r2 = com.bytedance.sdk.openadsdk.common.TTAdDislikeToast.getSkipText()
            r0.IlO(r1, r2)
        L24:
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r0 = r3.EO
            com.bytedance.sdk.openadsdk.component.reward.IlO.bWL r0 = r0.YA
            r1 = 1
            r0.Cc(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.tV.MY():void");
    }

    @Override // com.bytedance.sdk.openadsdk.activity.vCE
    public boolean a_() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.vCE
    public String b_() {
        return "fullscreen_interstitial_ad";
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public void c_() {
        if (this.EO.MY.La() != 100.0f) {
            this.vCE = true;
        }
        vSq();
    }

    private boolean IlO(oeT oet) {
        return oet == null || oet.La() == 100.0f;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0040  */
    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean IlO(long r10, boolean r12) {
        /*
            Method dump skipped, instruction units count: 247
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.tV.IlO(long, boolean):boolean");
    }

    private boolean MY(oeT oet) {
        if (oet == null) {
            return false;
        }
        return cl.tV().es(String.valueOf(this.EO.vCE));
    }

    @Override // com.bytedance.sdk.openadsdk.activity.IlO
    public void EO() {
        final View viewNV = this.EO.DM.NV();
        if (viewNV != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.tV.1
                /* JADX WARN: Removed duplicated region for block: B:28:0x00d5  */
                @Override // android.view.View.OnClickListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void onClick(android.view.View r5) {
                    /*
                        Method dump skipped, instruction units count: 250
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.tV.AnonymousClass1.onClick(android.view.View):void");
                }
            };
            viewNV.setOnClickListener(onClickListener);
            viewNV.setTag(viewNV.getId(), onClickListener);
        }
        this.EO.YA.IlO(new com.bytedance.sdk.openadsdk.component.reward.top.MY() { // from class: com.bytedance.sdk.openadsdk.activity.tV.2
            @Override // com.bytedance.sdk.openadsdk.component.reward.top.MY
            public void EO(View view) {
                View view2 = viewNV;
                if (view2 != null) {
                    view2.performClick();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.MY
            public void IlO(View view) {
                if (OOq.lEW(tV.this.EO.MY) && (OOq.cL(tV.this.EO.MY) || tV.this.EO.NV.get())) {
                    if (tV.this.EO.pP.IlO()) {
                        tV.this.EO.pP.IlO(5);
                        return;
                    } else {
                        tV.this.EO.lMM.lEW();
                        return;
                    }
                }
                if (OOq.cL(tV.this.EO.MY) || (es.IlO(tV.this.EO.MY) && !tV.this.EO.zPa.get())) {
                    if (!OOq.lEW(tV.this.EO.MY) && tV.this.EO.pP.IlO()) {
                        tV.this.EO.pP.IlO(4);
                    }
                    tV.this.OOq();
                    return;
                }
                if (tV.this.EO.MY.ey()) {
                    if (tV.this.EO.DM.EV() != null) {
                        tV.this.EO.MY.zLG(2);
                        tV.this.EO.DM.cl();
                        return;
                    }
                    return;
                }
                com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = tV.this.EO;
                if (!ilO.EO && ilO.MY.pbX() && !tV.this.EO.MY.xJ()) {
                    tV.this.EO.MY.zLG(13);
                    try {
                        tV.this.EO.DM.cl();
                        return;
                    } catch (Exception unused) {
                    }
                }
                tV.this.EO.vAh.oc();
                ea.IlO ilO2 = new ea.IlO();
                ilO2.MY(tV.this.EO.vAh.EV());
                ilO2.tV(tV.this.EO.vAh.kBB());
                ilO2.EO(tV.this.EO.vAh.ea());
                ilO2.EO(3);
                ilO2.tV(tV.this.EO.vAh.vAh());
                ilO2.IlO(tV.this.EO.vAh.MY());
                com.bytedance.sdk.openadsdk.tV.Cc.IlO.IlO.IlO(tV.this.EO.vAh.Bc(), ilO2, tV.this.EO.vAh.Cc());
                kBB.EO(tV.this.EO.vCE);
                tV.this.EO.vAh.IlO("skip", false);
                tV.this.EO.YA.tV(false);
                tV tVVar = tV.this;
                if (tVVar.EO.EO) {
                    tVVar.IlO(true, 4);
                } else {
                    tVVar.OOq();
                }
                oeT oet = tV.this.EO.MY;
                if (oet != null && oet.QfH() != null) {
                    com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO3 = tV.this.EO;
                    if (ilO3.vAh != null) {
                        ilO3.MY.QfH().IlO().vCE(tV.this.EO.vAh.EV());
                        tV.this.EO.MY.QfH().IlO().Cc(tV.this.EO.vAh.EV());
                    }
                }
                com.bytedance.sdk.openadsdk.kBB.MY.Cc.IlO(tV.this.EO.MY, 5);
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.MY
            public void MY(View view) {
                tV tVVar = tV.this;
                tVVar.EO.vSq.IlO(tVVar.MY);
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.MY
            public void IlO(View view, String str) {
                tV tVVar = tV.this;
                tVVar.EO.uvo = !r0.uvo;
                com.bytedance.sdk.openadsdk.component.reward.MY.MY my = tVVar.MY;
                if (my != null && my.tV() != null) {
                    tV.this.MY.tV().IlO(tV.this.EO.uvo);
                }
                com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = tV.this.EO;
                ilO.vAh.IlO(ilO.uvo, str);
                if (!OOq.es(tV.this.EO.MY) || tV.this.EO.NV.get()) {
                    com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO2 = tV.this.EO;
                    ilO2.lMM.Cc(ilO2.uvo);
                    oeT oet = tV.this.EO.MY;
                    if (oet == null || oet.QfH() == null || tV.this.EO.MY.QfH().IlO() == null) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO3 = tV.this.EO;
                    if (ilO3.vAh != null) {
                        if (ilO3.uvo) {
                            ilO3.MY.QfH().IlO().lEW(tV.this.EO.vAh.EV());
                        } else {
                            ilO3.MY.QfH().IlO().DmF(tV.this.EO.vAh.EV());
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EO(int i2) {
        int iIlO = this.EO.MY.IlO();
        if (!cl.tV().Cc(String.valueOf(this.EO.vCE)) || (!oeT.Cc(this.EO.MY) && !this.EO.EO)) {
            if (i2 >= iIlO) {
                com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.EO;
                if (!ilO.ii) {
                    ilO.IlO(true);
                }
                MY();
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO2 = this.EO;
        if (!ilO2.ii) {
            ilO2.IlO(true);
        }
        if (i2 <= iIlO) {
            Cc(iIlO - i2);
            this.EO.YA.Cc(false);
        } else {
            MY();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public void d_() {
    }
}
