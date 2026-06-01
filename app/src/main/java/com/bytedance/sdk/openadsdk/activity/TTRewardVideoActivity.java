package com.bytedance.sdk.openadsdk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.work.WorkRequest;
import com.bytedance.sdk.component.lEW.lEW;
import com.bytedance.sdk.component.utils.oeT;
import com.bytedance.sdk.component.utils.xF;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.component.reward.EV;
import com.bytedance.sdk.openadsdk.core.AXM;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.model.OOq;
import com.bytedance.sdk.openadsdk.core.model.es;
import com.bytedance.sdk.openadsdk.core.widget.MY;
import com.bytedance.sdk.openadsdk.core.xF;
import com.bytedance.sdk.openadsdk.tV.Bc;
import com.bytedance.sdk.openadsdk.utils.bWL;
import com.bytedance.sdk.openadsdk.utils.ea;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.bytedance.sdk.openadsdk.utils.pP;
import com.bytedance.sdk.openadsdk.utils.zLG;
import com.google.mlkit.common.MlKitException;
import com.ironsource.Q6;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import w.b;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class TTRewardVideoActivity extends TTBaseVideoActivity {
    private static String cL;
    private static String cl;
    private static String ea;
    private static String es;
    private static com.bytedance.sdk.openadsdk.IlO.Cc.IlO oeT;
    private static String zPa;
    private String AXM;
    protected com.bytedance.sdk.openadsdk.IlO.Cc.IlO bWL;
    protected int hp;
    private boolean pP;
    protected int rp;
    private String xF;
    private final AtomicBoolean vAh = new AtomicBoolean(false);
    private int kBB = -1;

    private void OOq() {
        EV ev;
        if (this.lEW) {
            return;
        }
        this.lEW = true;
        oeT.IlO("BVA", "invoke callback onAdClose, ".concat(String.valueOf(this)));
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.MY;
        if (ilO != null && (ev = ilO.PTq) != null) {
            ev.tV();
        }
        if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
            IlO("onAdClose");
            return;
        }
        com.bytedance.sdk.openadsdk.IlO.Cc.IlO ilO2 = this.bWL;
        if (ilO2 != null) {
            ilO2.MY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void kBB() {
        /*
            Method dump skipped, instruction units count: 201
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.kBB():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pP() {
        oeT.IlO("BVA", "invoke callback onAdClicked, ".concat(String.valueOf(this)));
        if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
            IlO("onAdVideoBarClick");
            return;
        }
        com.bytedance.sdk.openadsdk.IlO.Cc.IlO ilO = this.bWL;
        if (ilO != null) {
            ilO.onAdClicked();
        }
    }

    private JSONObject tl() {
        JSONObject jSONObject = new JSONObject();
        int iPP = (int) this.MY.vAh.pP();
        try {
            jSONObject.put("oversea_version_type", 1);
            jSONObject.put("reward_name", this.MY.MY.OOq());
            jSONObject.put("reward_amount", this.MY.MY.wPn());
            jSONObject.put("network", xF.EO(getApplicationContext()));
            jSONObject.put("sdk_version", BuildConfig.VERSION_NAME);
            int iQuf = this.MY.MY.quf();
            String strEO = "unKnow";
            if (iQuf == 2) {
                strEO = zLG.MY();
            } else if (iQuf == 1) {
                strEO = zLG.EO();
            }
            jSONObject.put("user_agent", strEO);
            JSONObject jSONObjectDYs = this.MY.MY.DYs();
            jSONObjectDYs.put(Q6.U0, com.bytedance.sdk.openadsdk.es.IlO.MY.IlO.IlO().MY());
            jSONObject.put("extra", jSONObjectDYs);
            jSONObject.put("media_extra", this.xF);
            jSONObject.put("video_duration", this.MY.MY.fdM().f4688d);
            jSONObject.put("play_start_ts", this.rp);
            jSONObject.put("play_end_ts", this.hp);
            jSONObject.put("duration", iPP);
            jSONObject.put("user_id", this.AXM);
            jSONObject.put("trans_id", pP.IlO().replace("-", ""));
            return jSONObject;
        } catch (Throwable th) {
            oeT.IlO("TTAD.RVA", "", th);
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public void Cc() {
        this.MY.YA.IlO(null, TTAdDislikeToast.getSkipText());
        this.MY.YA.Cc(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public void IlO(String str, JSONObject jSONObject) {
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0036  */
    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void bWL() {
        /*
            r8 = this;
            com.bytedance.sdk.openadsdk.core.settings.vCE r0 = com.bytedance.sdk.openadsdk.core.cl.tV()
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r1 = r8.MY
            int r1 = r1.vCE
            java.lang.String r1 = java.lang.String.valueOf(r1)
            com.bytedance.sdk.openadsdk.core.settings.MY r0 = r0.tl(r1)
            int r0 = r0.vCE
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r1 = r8.MY
            com.bytedance.sdk.openadsdk.core.model.oeT r1 = r1.MY
            boolean r1 = com.bytedance.sdk.openadsdk.core.model.OOq.es(r1)
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L39
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r1 = r8.MY
            com.bytedance.sdk.openadsdk.component.reward.IlO.cl r1 = r1.vAh
            double r4 = r1.YA()
            int r1 = r8.vCE
            double r6 = (double) r1
            double r6 = r6 / r4
            r4 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r4 = r4 - r6
            r6 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r4 = r4 * r6
            double r0 = (double) r0
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 < 0) goto L36
            goto L37
        L36:
            r2 = r3
        L37:
            r3 = r2
            goto L8a
        L39:
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r1 = r8.MY
            com.bytedance.sdk.openadsdk.core.model.oeT r1 = r1.MY
            int r1 = r1.XvI()
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r4 = r8.MY
            com.bytedance.sdk.openadsdk.component.reward.IlO.lEW r4 = r4.pP
            float r4 = r4.MY()
            float r1 = (float) r1
            float r4 = r4 / r1
            r1 = 1065353216(0x3f800000, float:1.0)
            float r1 = r1 - r4
            r4 = 1120403456(0x42c80000, float:100.0)
            float r1 = r1 * r4
            float r0 = (float) r0
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 < 0) goto L58
            r0 = r2
            goto L59
        L58:
            r0 = r3
        L59:
            com.bytedance.sdk.openadsdk.core.settings.vCE r1 = com.bytedance.sdk.openadsdk.core.cl.tV()
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r4 = r8.MY
            int r4 = r4.vCE
            java.lang.String r4 = java.lang.String.valueOf(r4)
            int r1 = r1.IlO(r4)
            if (r1 != 0) goto L87
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r1 = r8.MY
            com.bytedance.sdk.openadsdk.component.reward.IlO.es r1 = r1.lMM
            com.bytedance.sdk.openadsdk.core.vSq r1 = r1.rp()
            boolean r1 = r1.vCE()
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r4 = r8.MY
            com.bytedance.sdk.openadsdk.component.reward.IlO.lEW r4 = r4.pP
            boolean r4 = r4.EO()
            if (r4 == 0) goto L82
            r1 = r2
        L82:
            if (r0 == 0) goto L36
            if (r1 == 0) goto L36
            goto L37
        L87:
            if (r1 != r2) goto L8a
            r3 = r0
        L8a:
            if (r3 == 0) goto L8f
            r8.vAh()
        L8f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.bWL():void");
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public void c_() {
        pP();
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public void d_() {
        EO(2);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public void es() {
        final View viewNV = this.MY.DM.NV();
        if (viewNV != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.4
                /* JADX WARN: Removed duplicated region for block: B:31:0x00ed  */
                @Override // android.view.View.OnClickListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void onClick(android.view.View r5) {
                    /*
                        Method dump skipped, instruction units count: 292
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.AnonymousClass4.onClick(android.view.View):void");
                }
            };
            viewNV.setOnClickListener(onClickListener);
            viewNV.setTag(viewNV.getId(), onClickListener);
        }
        this.MY.YA.IlO(new com.bytedance.sdk.openadsdk.component.reward.top.MY() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.5
            @Override // com.bytedance.sdk.openadsdk.component.reward.top.MY
            public void EO(View view) {
                View view2 = viewNV;
                if (view2 != null) {
                    view2.performClick();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.MY
            public void IlO(View view) {
                if (TTRewardVideoActivity.this.MY.MY.ey()) {
                    if (TTRewardVideoActivity.this.MY.DM.EV() != null) {
                        TTRewardVideoActivity.this.MY.MY.zLG(2);
                        TTRewardVideoActivity.this.MY.DM.cl();
                        return;
                    }
                    return;
                }
                com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = TTRewardVideoActivity.this.MY;
                if (!ilO.EO && ilO.MY.pbX() && !TTRewardVideoActivity.this.MY.MY.xJ()) {
                    TTRewardVideoActivity.this.MY.MY.zLG(13);
                    try {
                        TTRewardVideoActivity.this.MY.DM.cl();
                        return;
                    } catch (Exception unused) {
                    }
                }
                TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
                tTRewardVideoActivity.IlO(OOq.EO(tTRewardVideoActivity.MY.MY), false);
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.MY
            public void MY(View view) {
                TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
                tTRewardVideoActivity.MY.vSq.IlO(tTRewardVideoActivity.EO);
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.MY
            public void IlO(View view, String str) {
                com.bytedance.sdk.openadsdk.component.reward.MY.MY my = TTRewardVideoActivity.this.EO;
                if (my != null && my.tV() != null) {
                    TTRewardVideoActivity.this.EO.tV().IlO(TTRewardVideoActivity.this.MY.uvo);
                }
                TTRewardVideoActivity.this.MY.uvo = !r3.uvo;
                StringBuilder sb = new StringBuilder("will set is Mute ");
                sb.append(TTRewardVideoActivity.this.MY.uvo);
                sb.append(" mLastVolume=");
                sb.append(TTRewardVideoActivity.this.MY.dY.IlO());
                com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = TTRewardVideoActivity.this.MY;
                ilO.vAh.IlO(ilO.uvo, str);
                if (!OOq.es(TTRewardVideoActivity.this.MY.MY) || TTRewardVideoActivity.this.MY.NV.get()) {
                    com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO2 = TTRewardVideoActivity.this.MY;
                    ilO2.lMM.Cc(ilO2.uvo);
                    com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO3 = TTRewardVideoActivity.this.MY;
                    ilO3.pP.vCE(ilO3.uvo);
                    com.bytedance.sdk.openadsdk.core.model.oeT oet = TTRewardVideoActivity.this.MY.MY;
                    if (oet == null || oet.QfH() == null || TTRewardVideoActivity.this.MY.MY.QfH().IlO() == null) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO4 = TTRewardVideoActivity.this.MY;
                    if (ilO4.vAh != null) {
                        if (ilO4.uvo) {
                            ilO4.MY.QfH().IlO().lEW(TTRewardVideoActivity.this.MY.vAh.EV());
                        } else {
                            ilO4.MY.QfH().IlO().DmF(TTRewardVideoActivity.this.MY.vAh.EV());
                        }
                    }
                }
            }
        });
    }

    public void finalize() throws Throwable {
        super.finalize();
        oeT = null;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void finish() {
        if (this.MY != null) {
            com.bytedance.sdk.openadsdk.vCE.MY.IlO().IlO("videoForceBreak", this.MY.MY);
        }
        OOq();
        super.finish();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public void hp() {
        if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
            IlO("onAdShow");
        } else {
            com.bytedance.sdk.openadsdk.IlO.Cc.IlO ilO = this.bWL;
            if (ilO != null) {
                ilO.IlO();
            }
        }
        if (AXM()) {
            this.MY.tl.NV();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO;
        com.bytedance.sdk.openadsdk.core.model.oeT oet;
        super.onCreate(bundle);
        try {
            if (ea == null) {
                ea = com.bytedance.sdk.component.utils.pP.IlO(this, "tt_reward_msg");
                zPa = com.bytedance.sdk.component.utils.pP.IlO(this, "tt_msgPlayable");
                cl = com.bytedance.sdk.component.utils.pP.IlO(this, "tt_negtiveBtnBtnText");
                cL = com.bytedance.sdk.component.utils.pP.IlO(this, "tt_postiveBtnText");
                es = com.bytedance.sdk.component.utils.pP.IlO(this, "tt_postiveBtnTextPlayable");
            }
        } catch (Throwable th) {
            oeT.EO("TTAD.RVA", th.getMessage());
        }
        if (bundle == null || (ilO = this.MY) == null || (oet = ilO.MY) == null || !oet.AXI()) {
            return;
        }
        this.vAh.set(true);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        OOq();
        if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
            IlO("recycleRes");
        }
        this.bWL = null;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void onPause() {
        EV ev;
        super.onPause();
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.MY;
        if (ilO == null || (ev = ilO.PTq) == null) {
            return;
        }
        ev.IlO();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void onResume() {
        EV ev;
        super.onResume();
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.MY;
        if (ilO == null || (ev = ilO.PTq) == null) {
            return;
        }
        ev.MY();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO;
        if (bundle == null) {
            bundle = new Bundle();
        }
        oeT = this.bWL;
        if (this.vAh.get() && (ilO = this.MY) != null) {
            ilO.MY.SZ();
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public void rp() {
        vAh();
    }

    public void vAh() {
        EO(0);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public boolean xF() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public void zPa() {
        com.bytedance.sdk.openadsdk.component.reward.view.MY myIlO;
        super.zPa();
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.MY;
        if (ilO == null || (myIlO = ilO.tl.IlO()) == null) {
            return;
        }
        myIlO.setJsbLandingPageOpenListener(new com.bytedance.sdk.openadsdk.core.widget.Cc() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.2
            @Override // com.bytedance.sdk.openadsdk.core.widget.Cc
            public void IlO() {
                TTRewardVideoActivity.this.pP();
            }
        });
    }

    public void EO(final int i2) {
        if (this.vAh.get() || this.pP) {
            return;
        }
        this.vAh.set(true);
        EV ev = this.MY.PTq;
        if (ev != null) {
            ev.EO();
        }
        if (cl.tV().ea(String.valueOf(this.MY.vCE))) {
            IlO(true, this.MY.MY.wPn(), this.MY.MY.OOq(), 0, "", i2);
        } else {
            cl.EO().IlO(tl(), new xF.MY() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.9
                @Override // com.bytedance.sdk.openadsdk.core.xF.MY
                public void IlO(int i8, String str) {
                    TTRewardVideoActivity.this.IlO(false, 0, "", i8, str, i2);
                }

                @Override // com.bytedance.sdk.openadsdk.core.xF.MY
                public void IlO(AXM.MY my) {
                    boolean z2 = my.MY;
                    TTRewardVideoActivity.this.IlO(my.MY, my.EO.IlO(), my.EO.MY(), 0, "", i2);
                }
            });
        }
    }

    public void MY(long j, long j3) {
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.MY;
        boolean z2 = false;
        if (ilO != null) {
            if (ilO.MY.vSq() >= 0 && this.MY.MY.EO() >= 0) {
                z2 = true;
            }
            if (z2) {
                j3 = this.MY.MY.EO();
            }
        }
        long j8 = (((long) this.MY.Ea) * 1000) + j;
        if (z2) {
            IlO(j8, j3);
            return;
        }
        if (this.kBB == -1) {
            this.kBB = cl.tV().tl(String.valueOf(this.MY.vCE)).vCE;
        }
        if (j3 <= 0) {
            return;
        }
        if (j3 >= WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS && j8 >= 27000) {
            vAh();
        } else if ((j8 * 100) / j3 >= this.kBB) {
            vAh();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public void tV() {
        pP();
        this.MY.MY.Ei();
        this.MY.MY.IlO(true);
        if (com.bytedance.sdk.openadsdk.core.model.oeT.Cc(this.MY.MY)) {
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.MY;
            com.bytedance.sdk.openadsdk.core.model.oeT oet = ilO.MY;
            com.bytedance.sdk.openadsdk.tV.EO.MY(oet, ilO.Cc, oet.VC());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public void IlO() {
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO;
        super.IlO();
        if (this.vAh.get() || (ilO = this.MY) == null) {
            return;
        }
        ilO.PTq = new EV(new EV.IlO() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.1
            @Override // com.bytedance.sdk.openadsdk.component.reward.EV.IlO
            public void IlO() {
                if (TTRewardVideoActivity.this.vAh.get() || TTRewardVideoActivity.this.pP) {
                    return;
                }
                TTRewardVideoActivity.this.EO(1);
            }
        });
    }

    public void IlO(String str) {
        IlO(str, false, 0, "", 0, "");
    }

    private void IlO(final String str, final boolean z2, final int i2, final String str2, final int i8, final String str3) {
        mmj.EO(new lEW("Reward_executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TTRewardVideoActivity.this.MY(0).executeRewardVideoCallback(TTRewardVideoActivity.this.MY.quf, str, z2, i2, str2, i8, str3);
                } catch (Throwable th) {
                    oeT.EO("TTAD.RVA", "rewarded_video", "executeRewardVideoCallback execute throw Exception : ", th);
                }
            }
        }, 5);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public void IlO(Bundle bundle) {
        if (!com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
            this.bWL = com.bytedance.sdk.openadsdk.core.pP.IlO().EO();
        }
        if (this.bWL != null || bundle == null) {
            return;
        }
        this.bWL = oeT;
        oeT = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(final boolean z2, boolean z7) {
        if (!z7 && this.pP && this.MY.NV.get()) {
            if (OOq.lEW(this.MY.MY)) {
                this.MY.lMM.lEW();
                return;
            } else if (OOq.NV(this.MY.MY)) {
                this.MY.pP.cl();
                return;
            }
        }
        if (!cl.tV().Bc(String.valueOf(this.MY.vCE))) {
            if (!z7 && this.MY.NV.get()) {
                if (OOq.lEW(this.MY.MY)) {
                    this.MY.lMM.lEW();
                    return;
                } else if (OOq.NV(this.MY.MY)) {
                    this.MY.pP.cl();
                    return;
                }
            }
            if (z2) {
                finish();
                return;
            } else {
                kBB();
                return;
            }
        }
        if (this.vAh.get()) {
            if (this.MY.NV.get()) {
                if (OOq.lEW(this.MY.MY)) {
                    this.MY.lMM.lEW();
                    return;
                } else if (OOq.NV(this.MY.MY)) {
                    this.MY.pP.cl();
                    return;
                }
            }
            if (z2) {
                finish();
                return;
            } else {
                kBB();
                return;
            }
        }
        if (OOq.lEW(this.MY.MY) && this.MY.lMM.EV().getVisibility() == 0) {
            this.MY.lMM.lEW();
            return;
        }
        if (OOq.NV(this.MY.MY) && this.MY.lMM.NV().getVisibility() == 0) {
            this.MY.pP.cl();
            return;
        }
        this.MY.xF.set(true);
        this.MY.vAh.xF();
        if (z2) {
            this.MY.pP.bWL();
        }
        final com.bytedance.sdk.openadsdk.core.widget.MY my = new com.bytedance.sdk.openadsdk.core.widget.MY(this);
        this.EO.hp = my;
        if (z2) {
            my.IlO(zPa).MY(es).EO(cl);
        } else {
            my.IlO(ea).MY(cL).EO(cl);
        }
        this.EO.hp.IlO(new MY.IlO() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.6
            @Override // com.bytedance.sdk.openadsdk.core.widget.MY.IlO
            public void IlO() {
                TTRewardVideoActivity.this.MY.vAh.es();
                if (z2) {
                    TTRewardVideoActivity.this.MY.pP.Cc(1000);
                }
                my.dismiss();
                TTRewardVideoActivity.this.MY.xF.set(false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.MY.IlO
            public void MY() {
                my.dismiss();
                TTRewardVideoActivity.this.pP = true;
                TTRewardVideoActivity.this.MY.xF.set(false);
                TTRewardVideoActivity.this.MY.pP.vCE(Integer.MAX_VALUE);
                if (z2) {
                    if (OOq.cL(TTRewardVideoActivity.this.MY.MY)) {
                        if (OOq.lEW(TTRewardVideoActivity.this.MY.MY)) {
                            if (TTRewardVideoActivity.this.MY.pP.IlO()) {
                                TTRewardVideoActivity.this.MY.pP.IlO(5);
                                return;
                            } else {
                                TTRewardVideoActivity.this.MY.lMM.lEW();
                                return;
                            }
                        }
                        TTRewardVideoActivity.this.MY.wPn.vCE();
                        if (TTRewardVideoActivity.this.MY.pP.IlO()) {
                            TTRewardVideoActivity.this.MY.pP.IlO(4);
                        }
                        TTRewardVideoActivity.this.finish();
                        return;
                    }
                    if (OOq.vCE(TTRewardVideoActivity.this.MY.MY)) {
                        if (OOq.NV(TTRewardVideoActivity.this.MY.MY)) {
                            TTRewardVideoActivity.this.MY.pP.cl();
                            return;
                        } else {
                            TTRewardVideoActivity.this.MY.wPn.vCE();
                            TTRewardVideoActivity.this.finish();
                            return;
                        }
                    }
                }
                TTRewardVideoActivity.this.kBB();
            }
        }).show();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public void IlO(@NonNull Intent intent) {
        super.IlO(intent);
        this.xF = intent.getStringExtra("media_extra");
        this.AXM = intent.getStringExtra("user_id");
    }

    public boolean IlO(long j, boolean z2) {
        Bc bc = new Bc();
        bc.IlO(System.currentTimeMillis(), 1.0f);
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.MY;
        ilO.vAh.IlO(ilO.DM.vCE(), bc);
        b bVar = new b() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.7
            boolean IlO;

            @Override // w.b
            public void IlO(long j3, int i2) {
                bWL bwl;
                if (this.IlO) {
                    return;
                }
                this.IlO = true;
                TTRewardVideoActivity.this.tV.removeMessages(MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE);
                TTRewardVideoActivity.this.cL();
                TTRewardVideoActivity.this.vAh();
                TTRewardVideoActivity.this.MY.vAh.IlO(j3, j3);
                TTRewardVideoActivity.this.MY.es.set(true);
                if (TTRewardVideoActivity.this.MY.MY.vAh() == 36) {
                    com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO2 = TTRewardVideoActivity.this.MY;
                    if (ilO2.EO) {
                        ilO2.kBB.EO().tV();
                        ea.MY();
                    }
                }
                if (TTRewardVideoActivity.this.MY.MY.SU()) {
                    TTRewardVideoActivity.this.MY.MY.zLG(1);
                    TTRewardVideoActivity.this.MY.DM.cl();
                }
                if (TTRewardVideoActivity.this.MY.MY.vAh() == 21 && !TTRewardVideoActivity.this.MY.MY.NV()) {
                    TTRewardVideoActivity.this.MY.MY.MY(true);
                    TTRewardVideoActivity.this.MY.DM.cl();
                }
                TTRewardVideoActivity.this.hp = (int) (System.currentTimeMillis() / 1000);
                if (es.tV(TTRewardVideoActivity.this.MY.MY) || es.MY(TTRewardVideoActivity.this.MY.MY) || es.Cc(TTRewardVideoActivity.this.MY.MY)) {
                    TTRewardVideoActivity.this.IlO(false, 5);
                    if (!es.MY(TTRewardVideoActivity.this.MY.MY) || (bwl = TTRewardVideoActivity.this.MY.ts) == null) {
                        return;
                    }
                    bwl.IlO(0L);
                    return;
                }
                if (es.IlO(TTRewardVideoActivity.this.MY.MY) && !TTRewardVideoActivity.this.MY.zPa.get()) {
                    TTRewardVideoActivity.this.MY.IlO(true);
                    TTRewardVideoActivity.this.MY.YA.Cc(true);
                    return;
                }
                com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO3 = TTRewardVideoActivity.this.MY;
                if (!ilO3.EO) {
                    if (ilO3.MY.FNH()) {
                        TTRewardVideoActivity.this.MY.YA.EO();
                        return;
                    }
                    if (!com.bytedance.sdk.openadsdk.core.model.oeT.Cc(TTRewardVideoActivity.this.MY.MY)) {
                        TTRewardVideoActivity.this.MY.vAh.IlO("skip", true);
                    }
                    TTRewardVideoActivity.this.finish();
                    return;
                }
                if (ilO3.MY.FNH()) {
                    TTRewardVideoActivity.this.MY.YA.EO();
                    return;
                }
                TTRewardVideoActivity.this.IlO(false, 5);
                if (com.bytedance.sdk.openadsdk.core.model.oeT.Cc(TTRewardVideoActivity.this.MY.MY)) {
                    return;
                }
                TTRewardVideoActivity.this.MY.vAh.IlO("skip", true);
            }

            @Override // w.b
            public void MY(long j3, int i2) {
                TTRewardVideoActivity.this.tV.removeMessages(MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE);
                es esVar = TTRewardVideoActivity.this.MY.DM.ea;
                if (esVar != null) {
                    esVar.NV();
                }
                if (TTRewardVideoActivity.this.MY.vAh.vCE()) {
                    TTRewardVideoActivity.this.cl();
                    return;
                }
                TTRewardVideoActivity.this.MY.vAh.cL();
                TTRewardVideoActivity.this.vAh();
                TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
                if (tTRewardVideoActivity.MY.EO) {
                    tTRewardVideoActivity.IlO(false, true, 3);
                } else {
                    tTRewardVideoActivity.finish();
                }
                com.bytedance.sdk.openadsdk.component.reward.IlO.cl clVar = TTRewardVideoActivity.this.MY.vAh;
                clVar.IlO(!clVar.nvX() ? 1 : 0, 2);
            }

            @Override // w.b
            public void IlO() {
                TTRewardVideoActivity.this.tV.removeMessages(MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE);
                TTRewardVideoActivity.this.cL();
                TTRewardVideoActivity.this.vAh();
                TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
                if (tTRewardVideoActivity.MY.EO) {
                    tTRewardVideoActivity.IlO(false, true, 6);
                } else {
                    tTRewardVideoActivity.finish();
                }
                com.bytedance.sdk.openadsdk.component.reward.IlO.cl clVar = TTRewardVideoActivity.this.MY.vAh;
                clVar.IlO(!clVar.nvX() ? 1 : 0, 1 ^ (TTRewardVideoActivity.this.MY.vAh.nvX() ? 1 : 0));
                TTRewardVideoActivity.this.MY.vAh.cL();
            }

            @Override // w.b
            public void IlO(long j3, long j8) {
                com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO2 = TTRewardVideoActivity.this.MY;
                if (!ilO2.KC && ilO2.vAh.vCE()) {
                    TTRewardVideoActivity.this.MY.vAh.xF();
                }
                if (TTRewardVideoActivity.this.MY.NV.get()) {
                    return;
                }
                TTRewardVideoActivity.this.tV.removeMessages(MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE);
                if (j3 != TTRewardVideoActivity.this.MY.vAh.rp()) {
                    TTRewardVideoActivity.this.cL();
                }
                TTRewardVideoActivity.this.MY.vAh.IlO(j3, j8);
                TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
                long j9 = j3 / 1000;
                double d8 = j9;
                tTRewardVideoActivity.vCE = (int) (tTRewardVideoActivity.MY.vAh.YA() - d8);
                TTRewardVideoActivity tTRewardVideoActivity2 = TTRewardVideoActivity.this;
                int i2 = tTRewardVideoActivity2.vCE;
                if (i2 >= 0) {
                    tTRewardVideoActivity2.MY.YA.IlO(String.valueOf(i2), null);
                }
                TTRewardVideoActivity tTRewardVideoActivity3 = TTRewardVideoActivity.this;
                tTRewardVideoActivity3.vCE = (int) (tTRewardVideoActivity3.MY.vAh.YA() - d8);
                int i8 = (int) j9;
                int iMY = TTRewardVideoActivity.this.MY.MY.MY();
                boolean z7 = iMY >= 0;
                if ((TTRewardVideoActivity.this.MY.xF.get() || TTRewardVideoActivity.this.MY.EV.get()) && TTRewardVideoActivity.this.MY.vAh.vCE()) {
                    TTRewardVideoActivity.this.MY.vAh.xF();
                }
                TTRewardVideoActivity.this.MY.DM.tV(i8);
                TTRewardVideoActivity.this.MY(j3, j8);
                TTRewardVideoActivity tTRewardVideoActivity4 = TTRewardVideoActivity.this;
                if (tTRewardVideoActivity4.vCE > 0) {
                    tTRewardVideoActivity4.MY.YA.tV(true);
                    if (z7 && i8 >= iMY) {
                        TTRewardVideoActivity.this.MY.IlO(true);
                        TTRewardVideoActivity tTRewardVideoActivity5 = TTRewardVideoActivity.this;
                        tTRewardVideoActivity5.MY.YA.IlO(String.valueOf(tTRewardVideoActivity5.vCE), TTAdDislikeToast.getSkipText());
                        TTRewardVideoActivity.this.MY.YA.Cc(true);
                        return;
                    }
                    TTRewardVideoActivity tTRewardVideoActivity6 = TTRewardVideoActivity.this;
                    tTRewardVideoActivity6.MY.YA.IlO(String.valueOf(tTRewardVideoActivity6.vCE), null);
                }
            }
        };
        this.MY.vAh.IlO(bVar);
        es esVar = this.MY.DM.ea;
        if (esVar != null) {
            esVar.IlO(bVar);
        }
        boolean zIlO = this.MY.vAh.IlO(j, z2, null, this.EO);
        if (zIlO && !z2) {
            this.rp = (int) (System.currentTimeMillis() / 1000);
        }
        return zIlO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(final boolean z2, final int i2, final String str, final int i8, final String str2, final int i9) {
        oeT.IlO("BVA", "invoke callback onRewardVerify: " + z2 + ", " + i2 + ", " + str + ", " + i8 + ", " + str2 + "; " + this);
        if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
            IlO("onRewardVerify", z2, i2, str, i8, str2);
            EV.IlO(this.MY.MY, z2, i9);
        } else {
            mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.8
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.IlO.Cc.IlO ilO = TTRewardVideoActivity.this.bWL;
                    if (ilO != null) {
                        ilO.IlO(z2, i2, str, i8, str2);
                        EV.IlO(TTRewardVideoActivity.this.MY.MY, z2, i9);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public void IlO(int i2) {
        if (i2 == 10000) {
            vAh();
        }
    }

    public void IlO(long j, long j3) {
        if (j3 <= 0) {
            return;
        }
        if (this.kBB == -1) {
            this.kBB = Math.min(100, this.MY.MY.vSq());
        }
        if (((j / 1000.0f) / j3) * 100.0f >= this.kBB) {
            vAh();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public void IlO(boolean z2) {
        if (z2) {
            vAh();
            return;
        }
        if ((1.0d - (((double) this.vCE) / this.MY.vAh.YA())) * 100.0d >= cl.tV().tl(String.valueOf(this.MY.vCE)).vCE) {
            vAh();
        }
    }
}
