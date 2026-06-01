package com.bytedance.sdk.openadsdk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bykv.vk.openvk.IlO.IlO.IlO.EO.c;
import com.bytedance.sdk.component.utils.pP;
import com.bytedance.sdk.openadsdk.component.reward.IlO.lEW;
import com.bytedance.sdk.openadsdk.component.reward.MY.DmF;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.kBB;
import com.bytedance.sdk.openadsdk.core.model.OOq;
import com.bytedance.sdk.openadsdk.core.model.es;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.tV.Bc;
import com.bytedance.sdk.openadsdk.tV.Cc.MY.ea;
import com.bytedance.sdk.openadsdk.utils.bWL;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.google.mlkit.common.MlKitException;
import org.json.JSONObject;
import w.b;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class TTFullScreenVideoActivity extends TTBaseVideoActivity {
    private static com.bytedance.sdk.openadsdk.IlO.EO.MY hp;
    private boolean bWL;
    private com.bytedance.sdk.openadsdk.IlO.EO.MY rp;

    private boolean MY(oeT oet) {
        if (oet == null) {
            return false;
        }
        return cl.tV().es(String.valueOf(this.MY.vCE));
    }

    private void kBB() {
        if (this.lEW) {
            return;
        }
        this.lEW = true;
        com.bytedance.sdk.component.utils.oeT.IlO("BVA", "invoke callback onAdClose, ".concat(String.valueOf(this)));
        if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
            IlO("onAdClose");
            return;
        }
        com.bytedance.sdk.openadsdk.IlO.EO.MY my = this.rp;
        if (my != null) {
            my.MY();
        }
    }

    private void tV(int i2) {
        this.MY.YA.IlO(null, String.format(pP.IlO(cl.IlO(), "tt_skip_ad_time_text"), Integer.valueOf(i2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vAh() {
        com.bytedance.sdk.component.utils.oeT.IlO("BVA", "invoke callback onAdClicked, ".concat(String.valueOf(this)));
        if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
            IlO("onAdVideoBarClick");
            return;
        }
        com.bytedance.sdk.openadsdk.IlO.EO.MY my = this.rp;
        if (my != null) {
            my.onAdClicked();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void Cc() {
        /*
            r3 = this;
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r0 = r3.MY
            com.bytedance.sdk.openadsdk.core.model.oeT r0 = r0.MY
            boolean r0 = com.bytedance.sdk.openadsdk.core.model.oeT.Cc(r0)
            r1 = 0
            if (r0 != 0) goto L19
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r0 = r3.MY
            boolean r2 = r0.EO
            if (r2 != 0) goto L19
            com.bytedance.sdk.openadsdk.component.reward.IlO.bWL r0 = r0.YA
            java.lang.String r2 = "X"
            r0.IlO(r1, r2)
            goto L24
        L19:
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r0 = r3.MY
            com.bytedance.sdk.openadsdk.component.reward.IlO.bWL r0 = r0.YA
            java.lang.String r2 = com.bytedance.sdk.openadsdk.common.TTAdDislikeToast.getSkipText()
            r0.IlO(r1, r2)
        L24:
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r0 = r3.MY
            com.bytedance.sdk.openadsdk.component.reward.IlO.bWL r0 = r0.YA
            r1 = 1
            r0.Cc(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.Cc():void");
    }

    public void EO(int i2) {
        int iIlO = this.MY.MY.IlO();
        if (!cl.tV().Cc(String.valueOf(this.MY.vCE)) || (!oeT.Cc(this.MY.MY) && !this.MY.EO)) {
            if (i2 >= iIlO) {
                com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.MY;
                if (!ilO.ii) {
                    ilO.IlO(true);
                }
                Cc();
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO2 = this.MY;
        if (!ilO2.ii) {
            ilO2.IlO(true);
        }
        if (i2 > iIlO) {
            Cc();
        } else {
            tV(iIlO - i2);
            this.MY.YA.Cc(false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public void IlO(int i2) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public void c_() {
        if (this.MY.MY.La() != 100.0f) {
            this.bWL = true;
        }
        vAh();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public void es() {
        final View viewNV = this.MY.DM.NV();
        if (viewNV != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.3
                /* JADX WARN: Removed duplicated region for block: B:31:0x00ec  */
                @Override // android.view.View.OnClickListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void onClick(android.view.View r5) {
                    /*
                        Method dump skipped, instruction units count: 273
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.AnonymousClass3.onClick(android.view.View):void");
                }
            };
            viewNV.setOnClickListener(onClickListener);
            viewNV.setTag(viewNV.getId(), onClickListener);
        }
        this.MY.YA.IlO(new com.bytedance.sdk.openadsdk.component.reward.top.MY() { // from class: com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.4
            @Override // com.bytedance.sdk.openadsdk.component.reward.top.MY
            public void EO(View view) {
                View view2 = viewNV;
                if (view2 != null) {
                    view2.performClick();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.MY
            public void IlO(View view) {
                com.bytedance.sdk.openadsdk.component.reward.view.MY myIlO;
                if (OOq.vCE(TTFullScreenVideoActivity.this.MY.MY) || (OOq.Cc(TTFullScreenVideoActivity.this.MY.MY) && TTFullScreenVideoActivity.this.MY.pP.lEW(lEW.MY))) {
                    if (OOq.NV(TTFullScreenVideoActivity.this.MY.MY)) {
                        TTFullScreenVideoActivity.this.MY.pP.cl();
                        return;
                    }
                    View view2 = viewNV;
                    if (view2 != null) {
                        view2.performClick();
                        return;
                    } else {
                        TTFullScreenVideoActivity.this.finish();
                        return;
                    }
                }
                if (OOq.lEW(TTFullScreenVideoActivity.this.MY.MY) && (OOq.cL(TTFullScreenVideoActivity.this.MY.MY) || TTFullScreenVideoActivity.this.MY.NV.get())) {
                    if (TTFullScreenVideoActivity.this.MY.pP.IlO()) {
                        TTFullScreenVideoActivity.this.MY.pP.IlO(5);
                        return;
                    } else {
                        TTFullScreenVideoActivity.this.MY.lMM.lEW();
                        return;
                    }
                }
                if (OOq.cL(TTFullScreenVideoActivity.this.MY.MY) || (es.IlO(TTFullScreenVideoActivity.this.MY.MY) && !TTFullScreenVideoActivity.this.MY.zPa.get())) {
                    if (!OOq.lEW(TTFullScreenVideoActivity.this.MY.MY) && TTFullScreenVideoActivity.this.MY.pP.IlO()) {
                        TTFullScreenVideoActivity.this.MY.pP.IlO(4);
                    }
                    TTFullScreenVideoActivity.this.finish();
                    return;
                }
                if (TTFullScreenVideoActivity.this.MY.MY.ey()) {
                    if (TTFullScreenVideoActivity.this.MY.DM.EV() != null) {
                        TTFullScreenVideoActivity.this.MY.MY.zLG(2);
                        TTFullScreenVideoActivity.this.MY.DM.cl();
                        return;
                    }
                    return;
                }
                com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = TTFullScreenVideoActivity.this.MY;
                if (!ilO.EO && ilO.MY.pbX() && !TTFullScreenVideoActivity.this.MY.MY.xJ()) {
                    TTFullScreenVideoActivity.this.MY.MY.zLG(13);
                    try {
                        TTFullScreenVideoActivity.this.MY.DM.cl();
                        return;
                    } catch (Exception unused) {
                    }
                }
                ea.IlO ilO2 = new ea.IlO();
                ilO2.MY(TTFullScreenVideoActivity.this.MY.vAh.EV());
                ilO2.tV(TTFullScreenVideoActivity.this.MY.vAh.kBB());
                ilO2.EO(TTFullScreenVideoActivity.this.MY.vAh.ea());
                ilO2.EO(3);
                ilO2.tV(TTFullScreenVideoActivity.this.MY.vAh.vAh());
                ilO2.IlO(TTFullScreenVideoActivity.this.MY.vAh.MY());
                com.bytedance.sdk.openadsdk.tV.Cc.IlO.IlO.IlO(TTFullScreenVideoActivity.this.MY.vAh.Bc(), ilO2, TTFullScreenVideoActivity.this.MY.vAh.Cc());
                kBB.EO(TTFullScreenVideoActivity.this.MY.vCE);
                TTFullScreenVideoActivity.this.MY.vAh.IlO("skip", false);
                TTFullScreenVideoActivity.this.MY.YA.tV(false);
                com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO3 = TTFullScreenVideoActivity.this.MY;
                if (!ilO3.EO || (es.EO(ilO3.MY) && (myIlO = TTFullScreenVideoActivity.this.MY.tl.IlO()) != null && myIlO.tV == 0)) {
                    TTFullScreenVideoActivity.this.finish();
                } else {
                    TTFullScreenVideoActivity.this.IlO(true, 4);
                }
                oeT oet = TTFullScreenVideoActivity.this.MY.MY;
                if (oet != null && oet.QfH() != null) {
                    com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO4 = TTFullScreenVideoActivity.this.MY;
                    if (ilO4.vAh != null) {
                        ilO4.MY.QfH().IlO().vCE(TTFullScreenVideoActivity.this.MY.vAh.EV());
                        TTFullScreenVideoActivity.this.MY.MY.QfH().IlO().Cc(TTFullScreenVideoActivity.this.MY.vAh.EV());
                    }
                }
                com.bytedance.sdk.openadsdk.kBB.MY.Cc.IlO(TTFullScreenVideoActivity.this.MY.MY, 5);
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.MY
            public void MY(View view) {
                TTFullScreenVideoActivity tTFullScreenVideoActivity = TTFullScreenVideoActivity.this;
                tTFullScreenVideoActivity.MY.vSq.IlO(tTFullScreenVideoActivity.EO);
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.MY
            public void IlO(View view, String str) {
                TTFullScreenVideoActivity tTFullScreenVideoActivity = TTFullScreenVideoActivity.this;
                tTFullScreenVideoActivity.MY.uvo = !r0.uvo;
                com.bytedance.sdk.openadsdk.component.reward.MY.MY my = tTFullScreenVideoActivity.EO;
                if (my != null && my.tV() != null) {
                    TTFullScreenVideoActivity.this.EO.tV().IlO(TTFullScreenVideoActivity.this.MY.uvo);
                }
                com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = TTFullScreenVideoActivity.this.MY;
                ilO.vAh.IlO(ilO.uvo, str);
                if (!OOq.es(TTFullScreenVideoActivity.this.MY.MY) || TTFullScreenVideoActivity.this.MY.NV.get()) {
                    com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO2 = TTFullScreenVideoActivity.this.MY;
                    ilO2.lMM.Cc(ilO2.uvo);
                    com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO3 = TTFullScreenVideoActivity.this.MY;
                    ilO3.pP.vCE(ilO3.uvo);
                    oeT oet = TTFullScreenVideoActivity.this.MY.MY;
                    if (oet == null || oet.QfH() == null || TTFullScreenVideoActivity.this.MY.MY.QfH().IlO() == null) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO4 = TTFullScreenVideoActivity.this.MY;
                    if (ilO4.vAh != null) {
                        if (ilO4.uvo) {
                            ilO4.MY.QfH().IlO().lEW(TTFullScreenVideoActivity.this.MY.vAh.EV());
                        } else {
                            ilO4.MY.QfH().IlO().DmF(TTFullScreenVideoActivity.this.MY.vAh.EV());
                        }
                    }
                }
            }
        });
    }

    public void finalize() throws Throwable {
        super.finalize();
        hp = null;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void finish() {
        if (this.MY != null) {
            com.bytedance.sdk.openadsdk.vCE.MY.IlO().IlO("videoForceBreak", this.MY.MY);
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.MY;
            ilO.pP.IlO(ilO.HTA);
        }
        try {
            kBB();
        } catch (Exception unused) {
        }
        super.finish();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public void hp() {
        if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
            IlO("onAdShow");
        } else {
            com.bytedance.sdk.openadsdk.IlO.EO.MY my = this.rp;
            if (my != null) {
                my.IlO();
            }
        }
        if (AXM()) {
            this.MY.tl.NV();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.MY;
        if (ilO == null || oeT.Cc(ilO.MY)) {
            return;
        }
        c cVarFdM = this.MY.MY.fdM();
        if (cVarFdM == null) {
            c cVar = new c();
            cVar.f4688d = 10.0d;
            this.MY.MY.IlO(cVar);
        } else if (cVarFdM.f4688d <= 0.0d) {
            cVarFdM.f4688d = 10.0d;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        kBB();
        if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
            IlO("recycleRes");
        }
        this.rp = null;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        hp = this.rp;
        super.onSaveInstanceState(bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.MY;
        if (ilO == null || !MY(ilO.MY) || IlO(this.MY.MY)) {
            return;
        }
        if (this.bWL) {
            this.bWL = false;
            finish();
        } else if (this.MY.lMM.nvX()) {
            finish();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public boolean xF() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public void zPa() {
        com.bytedance.sdk.openadsdk.component.reward.view.MY myIlO;
        super.zPa();
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.MY;
        if (ilO == null || (myIlO = ilO.tl.IlO()) == null) {
            return;
        }
        myIlO.setJsbLandingPageOpenListener(new com.bytedance.sdk.openadsdk.core.widget.Cc() { // from class: com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.1
            @Override // com.bytedance.sdk.openadsdk.core.widget.Cc
            public void IlO() {
                TTFullScreenVideoActivity.this.vAh();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public void IlO(String str, JSONObject jSONObject) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public void IlO(boolean z2) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public void tV() {
        vAh();
        this.MY.MY.Ei();
        this.MY.MY.IlO(true);
        if (oeT.Cc(this.MY.MY)) {
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.MY;
            oeT oet = ilO.MY;
            com.bytedance.sdk.openadsdk.tV.EO.MY(oet, ilO.Cc, oet.VC());
        }
    }

    private void IlO(final String str) {
        mmj.EO(new com.bytedance.sdk.component.lEW.lEW("FullScreen_executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TTFullScreenVideoActivity.this.MY(1).executeFullVideoCallback(TTFullScreenVideoActivity.this.MY.quf, str);
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.oeT.EO("TTAD.FSVA", "fullscreen_interstitial_ad", "executeFullVideoCallback execute throw Exception : ", th);
                }
            }
        }, 5);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public void IlO(@NonNull Intent intent) {
        super.IlO(intent);
        this.MY.HTA = intent.getBooleanExtra("is_verity_playable", false);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public void IlO(Bundle bundle) {
        if (!com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
            this.rp = com.bytedance.sdk.openadsdk.core.pP.IlO().tV();
        }
        if (this.rp != null || bundle == null) {
            return;
        }
        this.rp = hp;
        hp = null;
    }

    public boolean IlO(long j, boolean z2) {
        Bc bc = new Bc();
        bc.IlO(System.currentTimeMillis(), 1.0f);
        com.bytedance.sdk.openadsdk.component.reward.MY.MY my = this.EO;
        if (my != null && (my instanceof DmF)) {
            this.MY.vAh.IlO(((DmF) my).oc(), bc);
        } else {
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.MY;
            ilO.vAh.IlO(ilO.DM.vCE(), bc);
        }
        b bVar = new b() { // from class: com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.5
            boolean IlO;

            @Override // w.b
            public void IlO(long j3, int i2) {
                bWL bwl;
                if (this.IlO) {
                    return;
                }
                this.IlO = true;
                TTFullScreenVideoActivity.this.tV.removeMessages(MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE);
                TTFullScreenVideoActivity.this.cL();
                TTFullScreenVideoActivity.this.MY.vAh.IlO(j3, j3);
                TTFullScreenVideoActivity.this.MY.es.set(true);
                if (TTFullScreenVideoActivity.this.MY.MY.vAh() == 36) {
                    com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO2 = TTFullScreenVideoActivity.this.MY;
                    if (ilO2.EO) {
                        ilO2.kBB.EO().tV();
                        com.bytedance.sdk.openadsdk.utils.ea.MY();
                    }
                }
                if (TTFullScreenVideoActivity.this.MY.MY.SU()) {
                    TTFullScreenVideoActivity.this.MY.MY.zLG(1);
                    TTFullScreenVideoActivity.this.MY.DM.cl();
                }
                if (TTFullScreenVideoActivity.this.MY.MY.vAh() == 21 && !TTFullScreenVideoActivity.this.MY.MY.NV()) {
                    TTFullScreenVideoActivity.this.MY.MY.MY(true);
                    TTFullScreenVideoActivity.this.MY.DM.cl();
                }
                com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO3 = TTFullScreenVideoActivity.this.MY;
                if (!ilO3.EO) {
                    if (ilO3.MY.FNH()) {
                        TTFullScreenVideoActivity.this.MY.YA.EO();
                        return;
                    }
                    if (!oeT.Cc(TTFullScreenVideoActivity.this.MY.MY)) {
                        TTFullScreenVideoActivity.this.MY.vAh.IlO("skip", true);
                    }
                    TTFullScreenVideoActivity.this.finish();
                    return;
                }
                if (ilO3.MY.FNH()) {
                    TTFullScreenVideoActivity.this.MY.YA.EO();
                    return;
                }
                TTFullScreenVideoActivity.this.IlO(false, 5);
                if (es.MY(TTFullScreenVideoActivity.this.MY.MY) && (bwl = TTFullScreenVideoActivity.this.MY.ts) != null) {
                    bwl.IlO(0L);
                }
                if (oeT.Cc(TTFullScreenVideoActivity.this.MY.MY)) {
                    return;
                }
                TTFullScreenVideoActivity.this.MY.vAh.IlO("skip", true);
            }

            @Override // w.b
            public void MY(long j3, int i2) {
                TTFullScreenVideoActivity.this.tV.removeMessages(MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE);
                es esVar = TTFullScreenVideoActivity.this.MY.DM.ea;
                if (esVar != null) {
                    esVar.NV();
                }
                if (TTFullScreenVideoActivity.this.MY.vAh.vCE()) {
                    TTFullScreenVideoActivity.this.cl();
                    return;
                }
                TTFullScreenVideoActivity.this.MY.vAh.cL();
                TTFullScreenVideoActivity tTFullScreenVideoActivity = TTFullScreenVideoActivity.this;
                if (!tTFullScreenVideoActivity.MY.EO) {
                    tTFullScreenVideoActivity.finish();
                    return;
                }
                tTFullScreenVideoActivity.IlO(false, true, 3);
                com.bytedance.sdk.openadsdk.component.reward.IlO.cl clVar = TTFullScreenVideoActivity.this.MY.vAh;
                clVar.IlO(!clVar.nvX() ? 1 : 0, 2);
            }

            @Override // w.b
            public void IlO() {
                TTFullScreenVideoActivity.this.tV.removeMessages(MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE);
                TTFullScreenVideoActivity.this.cL();
                TTFullScreenVideoActivity tTFullScreenVideoActivity = TTFullScreenVideoActivity.this;
                if (tTFullScreenVideoActivity.MY.EO) {
                    tTFullScreenVideoActivity.IlO(false, true, 6);
                } else {
                    tTFullScreenVideoActivity.finish();
                }
                com.bytedance.sdk.openadsdk.component.reward.IlO.cl clVar = TTFullScreenVideoActivity.this.MY.vAh;
                clVar.IlO(!clVar.nvX() ? 1 : 0, 1 ^ (TTFullScreenVideoActivity.this.MY.vAh.nvX() ? 1 : 0));
                TTFullScreenVideoActivity.this.MY.vAh.cL();
            }

            @Override // w.b
            public void IlO(long j3, long j8) {
                com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO2 = TTFullScreenVideoActivity.this.MY;
                if (!ilO2.KC && ilO2.vAh.vCE()) {
                    TTFullScreenVideoActivity.this.MY.vAh.xF();
                }
                if (TTFullScreenVideoActivity.this.MY.NV.get()) {
                    return;
                }
                TTFullScreenVideoActivity.this.tV.removeMessages(MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE);
                if (j3 != TTFullScreenVideoActivity.this.MY.vAh.rp()) {
                    TTFullScreenVideoActivity.this.cL();
                }
                TTFullScreenVideoActivity.this.MY.vAh.IlO(j3, j8);
                TTFullScreenVideoActivity tTFullScreenVideoActivity = TTFullScreenVideoActivity.this;
                long j9 = j3 / 1000;
                tTFullScreenVideoActivity.vCE = (int) (tTFullScreenVideoActivity.MY.vAh.YA() - j9);
                int i2 = (int) j9;
                if ((TTFullScreenVideoActivity.this.MY.xF.get() || TTFullScreenVideoActivity.this.MY.EV.get()) && TTFullScreenVideoActivity.this.MY.vAh.vCE()) {
                    TTFullScreenVideoActivity.this.MY.vAh.xF();
                }
                TTFullScreenVideoActivity.this.EO(i2);
                TTFullScreenVideoActivity tTFullScreenVideoActivity2 = TTFullScreenVideoActivity.this;
                int i8 = tTFullScreenVideoActivity2.vCE;
                if (i8 >= 0) {
                    tTFullScreenVideoActivity2.MY.YA.IlO(String.valueOf(i8), null);
                }
            }
        };
        this.MY.vAh.IlO(bVar);
        es esVar = this.MY.DM.ea;
        if (esVar != null) {
            esVar.IlO(bVar);
        }
        return this.MY.vAh.IlO(j, z2, null, this.EO);
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public void bWL() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public void d_() {
    }

    private boolean IlO(oeT oet) {
        return oet == null || oet.La() == 100.0f;
    }
}
