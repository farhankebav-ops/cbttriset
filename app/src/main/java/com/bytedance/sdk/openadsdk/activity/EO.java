package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.utils.vSq;
import com.bytedance.sdk.component.utils.xF;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.activity.MY;
import com.bytedance.sdk.openadsdk.component.reward.IlO.EV;
import com.bytedance.sdk.openadsdk.component.reward.MY.Bc;
import com.bytedance.sdk.openadsdk.component.reward.view.lEW;
import com.bytedance.sdk.openadsdk.core.AXM;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.model.OOq;
import com.bytedance.sdk.openadsdk.core.model.es;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.widget.MY;
import com.bytedance.sdk.openadsdk.core.xF;
import com.bytedance.sdk.openadsdk.utils.pP;
import com.bytedance.sdk.openadsdk.utils.zLG;
import com.ironsource.Q6;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO extends vCE implements vSq.IlO, com.bytedance.sdk.openadsdk.core.rp.tV.MY {
    private static String Bc;
    private static String Cc;
    private static String bWL;
    private static String tV;
    private static String vCE;
    private String AXM;
    protected com.bytedance.sdk.openadsdk.component.reward.IlO.IlO EO;
    protected final vSq IlO;

    @Nullable
    protected com.bytedance.sdk.openadsdk.component.reward.MY.MY MY;
    private boolean OOq;
    private boolean cL;
    private MY.Cc cl;
    private Bundle ea;
    private boolean es;
    private long kBB;
    private boolean oeT;
    private JSONObject pP;
    private int tl;
    private boolean vAh;
    private String xF;
    private int zPa;

    public EO(MY my, oeT oet, int i2, int i8) {
        super(my, oet, i2, i8);
        this.IlO = new vSq(Looper.getMainLooper(), this);
        this.zPa = 0;
        this.OOq = true;
        this.oeT = my.MY();
        this.vAh = my.IlO();
        IlO(oet, this.ea);
        if (this.oeT || this.vAh) {
            return;
        }
        try {
            AXM();
        } catch (Throwable unused) {
            OOq();
        }
    }

    private void AXM() {
        if (this.es) {
            return;
        }
        this.es = true;
        if ((this.vAh || this.oeT) && !kBB()) {
            this.EO.aa = pP().NV();
        }
        this.EO.zLG.IlO(this.MY);
        this.MY.IlO(this, this.IlO);
        this.MY.EV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YA() {
        MY.Cc cc = new MY.Cc(7, this.EO);
        cc.tV = this.EO.uvo;
        pP().MY(this, cc);
    }

    private void dY() {
        final View viewNV = this.EO.DM.NV();
        if (viewNV != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.EO.1
                /* JADX WARN: Removed duplicated region for block: B:29:0x00e1  */
                @Override // android.view.View.OnClickListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void onClick(android.view.View r5) {
                    /*
                        Method dump skipped, instruction units count: 284
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.EO.AnonymousClass1.onClick(android.view.View):void");
                }
            };
            viewNV.setOnClickListener(onClickListener);
            viewNV.setTag(viewNV.getId(), onClickListener);
        }
        this.EO.YA.IlO(new com.bytedance.sdk.openadsdk.component.reward.top.MY() { // from class: com.bytedance.sdk.openadsdk.activity.EO.2
            @Override // com.bytedance.sdk.openadsdk.component.reward.top.MY
            public void EO(View view) {
                View view2 = viewNV;
                if (view2 != null) {
                    view2.performClick();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.MY
            public void IlO(View view) {
                EO eo = EO.this;
                if (eo.IlO(OOq.EO(eo.EO.MY), false, (Runnable) null) || EO.this.lMM()) {
                    return;
                }
                if (OOq.Cc(EO.this.EO.MY)) {
                    if (OOq.NV(EO.this.EO.MY)) {
                        EO.this.EO.pP.cl();
                        return;
                    }
                    View view2 = viewNV;
                    if (view2 != null) {
                        view2.performClick();
                        return;
                    } else {
                        EO.this.OOq();
                        return;
                    }
                }
                if (OOq.lEW(EO.this.EO.MY)) {
                    if (EO.this.EO.pP.IlO()) {
                        EO.this.EO.pP.IlO(5);
                        return;
                    } else {
                        EO.this.EO.lMM.lEW();
                        return;
                    }
                }
                if (!OOq.cL(EO.this.EO.MY) && (!es.IlO(EO.this.EO.MY) || EO.this.EO.zPa.get())) {
                    EO.this.OOq();
                    return;
                }
                if (!OOq.lEW(EO.this.EO.MY) && EO.this.EO.pP.IlO()) {
                    EO.this.EO.pP.IlO(4);
                }
                EO.this.OOq();
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.MY
            public void MY(View view) {
                EO eo = EO.this;
                eo.EO.vSq.IlO(eo.MY);
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.MY
            public void IlO(View view, String str) {
                com.bytedance.sdk.openadsdk.component.reward.MY.MY my = EO.this.MY;
                if (my != null && my.tV() != null) {
                    EO.this.MY.tV().IlO(EO.this.EO.uvo);
                }
                EO.this.EO.uvo = !r3.uvo;
                StringBuilder sb = new StringBuilder("will set is Mute ");
                sb.append(EO.this.EO.uvo);
                sb.append(" mLastVolume=");
                sb.append(EO.this.EO.dY.IlO());
                com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = EO.this.EO;
                ilO.vAh.IlO(ilO.uvo, str);
                if (!OOq.es(EO.this.EO.MY) || EO.this.EO.NV.get()) {
                    com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO2 = EO.this.EO;
                    ilO2.lMM.Cc(ilO2.uvo);
                    oeT oet = EO.this.EO.MY;
                    if (oet != null && oet.QfH() != null && EO.this.EO.MY.QfH().IlO() != null) {
                        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO3 = EO.this.EO;
                        if (ilO3.vAh != null) {
                            if (ilO3.uvo) {
                                ilO3.MY.QfH().IlO().lEW(EO.this.EO.vAh.EV());
                            } else {
                                ilO3.MY.QfH().IlO().DmF(EO.this.EO.vAh.EV());
                            }
                        }
                    }
                    com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO4 = EO.this.EO;
                    ilO4.pP.vCE(ilO4.uvo);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean lMM() {
        if ((!this.vAh && !this.oeT) || kBB()) {
            return false;
        }
        try {
            com.bytedance.sdk.openadsdk.tV.EO.IlO(System.currentTimeMillis(), this.lEW, this.EO.Cc, "skip", new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.activity.EO.3
                @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
                public JSONObject IlO() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("duration", EO.this.kBB);
                        jSONObject.put("percent", EO.this.tl);
                        if (EO.this.pP != null) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("scene_type", EO.this.EO.IlO);
                            EO.this.pP.put("pag_json_data", jSONObject2.toString());
                            jSONObject.put("ad_extra_data", EO.this.pP);
                        }
                    } catch (Throwable unused) {
                    }
                    return jSONObject;
                }
            });
        } catch (Throwable unused) {
        }
        pP().IlO(this, true, false, false, 4);
        return true;
    }

    private JSONObject mmj() {
        JSONObject jSONObject = new JSONObject();
        int iPP = (int) this.EO.vAh.pP();
        try {
            jSONObject.put("oversea_version_type", 1);
            jSONObject.put("reward_name", this.EO.MY.OOq());
            jSONObject.put("reward_amount", this.EO.MY.wPn());
            jSONObject.put("network", xF.EO(this.EO.gQ));
            jSONObject.put("sdk_version", BuildConfig.VERSION_NAME);
            int iQuf = this.EO.MY.quf();
            String strEO = "unKnow";
            if (iQuf == 2) {
                strEO = zLG.MY();
            } else if (iQuf == 1) {
                strEO = zLG.EO();
            }
            jSONObject.put("user_agent", strEO);
            JSONObject jSONObjectDYs = this.EO.MY.DYs();
            jSONObjectDYs.put(Q6.U0, com.bytedance.sdk.openadsdk.es.IlO.MY.IlO.IlO().MY());
            jSONObject.put("extra", jSONObjectDYs);
            jSONObject.put("media_extra", this.AXM);
            jSONObject.put("video_duration", this.EO.MY.fdM().f4688d);
            jSONObject.put("play_start_ts", 0);
            jSONObject.put("play_end_ts", 0);
            jSONObject.put("duration", iPP);
            jSONObject.put("user_id", this.xF);
            jSONObject.put("trans_id", pP.IlO().replace("-", ""));
            return jSONObject;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.IlO("TTAD.EndCardScene", "", th);
            return null;
        }
    }

    private boolean nvX() {
        if (this.EO.NV.get() && this.EO.Bc) {
            return false;
        }
        if (this.lEW.vCE()) {
            return this.EO.NV.get();
        }
        return true;
    }

    private void vAh() {
        if (this.cL) {
            return;
        }
        this.cL = true;
        if (OOq.Bc(this.EO.MY) || com.bytedance.sdk.openadsdk.AXM.IlO.IlO("ivrv_new_arch_endcard_view_add_at_first", 0) == 1) {
            if (this.oeT || this.vAh) {
                pP().IlO(IlO(), kBB());
            } else {
                pP().IlO(IlO());
            }
        }
        this.MY.IlO(this.hp);
    }

    public void Bc() {
        com.bytedance.sdk.openadsdk.component.reward.MY.MY my = this.MY;
        if (my == null) {
            return;
        }
        my.OOq();
        this.EO.mmj.MY();
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public void EO(boolean z2) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public final void EV() {
        if (!this.EO.bWL.getAndSet(true) || OOq.cL(this.EO.MY)) {
            this.EO.wPn.IlO();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public void IlO(int i2) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public final View NV() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.vCE
    public boolean a_() {
        return this.EO.tV;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.vCE, com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public void bWL() {
        boolean z2 = false;
        boolean z7 = (1.0f - (this.EO.pP.MY() / ((float) this.EO.MY.XvI()))) * 100.0f >= ((float) cl.tV().tl(String.valueOf(this.EO.vCE)).vCE);
        int iIlO = cl.tV().IlO(String.valueOf(this.EO.vCE));
        if (iIlO == 0) {
            boolean zVCE = this.EO.lMM.rp().vCE();
            if (this.EO.pP.EO()) {
                zVCE = true;
            }
            z2 = z7 && zVCE;
        } else if (iIlO == 1) {
            z2 = z7;
        }
        if (z2) {
            Cc();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.vCE
    public String b_() {
        return this.EO.Cc;
    }

    public void cL() {
        if (kBB()) {
            return;
        }
        MY.Cc cc = new MY.Cc(8, this.EO);
        cc.tV = this.EO.uvo;
        if (pP() != null) {
            pP().IlO(this, cc);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public void c_() {
        vSq();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.vCE
    public void cl() {
        super.cl();
        com.bytedance.sdk.openadsdk.component.reward.MY.MY my = this.MY;
        if (my != null) {
            my.vAh();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public void d_() {
        MY(2);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.vCE
    public void ea() {
        super.ea();
        com.bytedance.sdk.openadsdk.component.reward.MY.MY my = this.MY;
        if (my == null) {
            return;
        }
        my.oeT();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.vCE
    public boolean es() {
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.EO;
        return ilO != null && ilO.vAh.vSq();
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public final void lEW() {
        if (pP() == null) {
            return;
        }
        this.EO.mmj.IlO(this.cl.IlO.getBoolean("isSkip", false), this.cl.IlO.getBoolean("force", false), this.cl.IlO.getBoolean("isFromLandingPage", false), this.MY, this.cl.MY);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.vCE
    public com.bytedance.sdk.openadsdk.component.reward.IlO.IlO oeT() {
        return this.EO;
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public void rp() {
        Cc();
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public final void vCE() {
        oc();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.vCE
    public String xF() {
        return this.EO.quf;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.vCE
    public final void Cc(Activity activity) {
        super.Cc(activity);
        com.bytedance.sdk.openadsdk.component.reward.MY.MY my = this.MY;
        if (my == null) {
            return;
        }
        my.xF();
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public void IlO(Bundle bundle) {
    }

    @Override // com.bytedance.sdk.openadsdk.activity.vCE
    public final void MY(Activity activity) {
        com.bytedance.sdk.openadsdk.component.reward.MY.MY my;
        super.MY(activity);
        if (this.EO == null || (my = this.MY) == null) {
            return;
        }
        my.cl();
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.EO;
        ilO.KC = true;
        ilO.OOq.MY(this.IlO);
        if (nvX()) {
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO2 = this.EO;
            ilO2.YA.IlO(ilO2.MY.uF());
        }
        this.EO.DM.ea();
        this.EO.lMM.oeT();
        this.EO.pP.hp();
        if (this.MY.MY()) {
            this.EO.vAh.IlO(this.MY);
            this.EO.vAh.IlO(false, this, this.zPa != 0);
        }
        this.zPa++;
        lEW lew = this.EO.tl;
        if (lew != null) {
            lew.Bc();
        }
        this.EO.OOq.IlO(this.IlO);
        this.MY.es();
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public final void tV() {
        vSq();
        this.EO.MY.Ei();
        this.EO.MY.IlO(true);
        if (oeT.Cc(this.EO.MY)) {
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.EO;
            oeT oet = ilO.MY;
            com.bytedance.sdk.openadsdk.tV.EO.MY(oet, ilO.Cc, oet.VC());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.vCE
    public void EO(Activity activity) {
        super.EO(activity);
        com.bytedance.sdk.openadsdk.component.reward.MY.MY my = this.MY;
        if (my == null) {
            return;
        }
        my.AXM();
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public boolean IlO(long j, boolean z2) {
        return false;
    }

    public void Cc() {
        MY(0);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.vCE
    public final void IlO(Activity activity, Bundle bundle) {
        this.ea = bundle;
        super.IlO(activity, bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.vCE
    public final void tV(Activity activity) {
        super.tV(activity);
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.EO;
        if (ilO == null) {
            return;
        }
        ilO.lMM.lMM();
        com.bytedance.sdk.openadsdk.utils.tV.IlO(activity, this.EO.MY);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.vCE
    public final View IlO() {
        return this.EO.zLG;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.vCE
    public void IlO(Activity activity, MY.Cc cc) {
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO;
        super.IlO(activity, cc);
        this.cl = cc;
        Intent intent = activity.getIntent();
        this.AXM = intent.getStringExtra("media_extra");
        this.xF = intent.getStringExtra("user_id");
        try {
            if (Bc == null) {
                Bc = com.bytedance.sdk.component.utils.pP.IlO(this.EO.gQ, "tt_reward_msg");
                tV = com.bytedance.sdk.component.utils.pP.IlO(this.EO.gQ, "tt_msgPlayable");
                vCE = com.bytedance.sdk.component.utils.pP.IlO(this.EO.gQ, "tt_negtiveBtnBtnText");
                bWL = com.bytedance.sdk.component.utils.pP.IlO(this.EO.gQ, "tt_postiveBtnText");
                Cc = com.bytedance.sdk.component.utils.pP.IlO(this.EO.gQ, "tt_postiveBtnTextPlayable");
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("TTAD.EndCardScene", th.getMessage());
        }
        if (cc != null && (ilO = cc.EO) != null) {
            this.EO.hp.set(ilO.hp.get());
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO2 = this.EO;
            ilO2.Tx = ilO.Tx;
            ilO2.uvo = ilO.uvo;
            if ((this.vAh || this.oeT) && !kBB()) {
                this.EO.rp.set(ilO.rp.get());
            }
            this.EO.bWL.set(ilO.bWL.get());
            this.EO.vAh.IlO(ilO.vAh.Cc());
            IlO(this.EO, ilO);
        }
        if (this.oeT || this.vAh) {
            try {
                AXM();
            } catch (Throwable unused) {
                OOq();
            }
        }
        MY myPP = pP();
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO3 = this.EO;
        if (ilO3 != null && myPP != null) {
            ilO3.PTq = myPP.MY;
        }
        vAh();
        dY();
        lEW();
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public final void DmF() {
    }

    public void MY(final int i2) {
        if (pP().EV().getBoolean("reward_verify", false) || pP().ea() || pP().EV().getBoolean("user_has_give_up_reward", false)) {
            return;
        }
        pP().EV().putBoolean("reward_verify", true);
        if (cl.tV().ea(String.valueOf(this.EO.vCE))) {
            IlO(true, this.EO.MY.wPn(), this.EO.MY.OOq(), 0, "", i2);
        } else {
            cl.EO().IlO(mmj(), new xF.MY() { // from class: com.bytedance.sdk.openadsdk.activity.EO.5
                @Override // com.bytedance.sdk.openadsdk.core.xF.MY
                public void IlO(int i8, String str) {
                    EO.this.IlO(false, 0, "", i8, str, i2);
                }

                @Override // com.bytedance.sdk.openadsdk.core.xF.MY
                public void IlO(AXM.MY my) {
                    EO.this.IlO(my.MY, my.EO.IlO(), my.EO.MY(), 0, "", i2);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.vCE
    public void MY(boolean z2) {
        EV ev;
        long j = this.OOq ? this.EO.Tx : 0L;
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.EO;
        if (ilO != null && (ev = ilO.wPn) != null) {
            ev.MY(z2);
            this.EO.wPn.EO(z2);
            if (z2 && j > 0) {
                this.EO.Tx = j;
            }
        }
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO2 = this.EO;
        if (ilO2 != null) {
            com.bytedance.sdk.openadsdk.component.reward.MY.MY my = ilO2.qz;
            if (my instanceof com.bytedance.sdk.openadsdk.component.reward.MY.vCE) {
                ((com.bytedance.sdk.openadsdk.component.reward.MY.vCE) my).MY(z2);
            }
        }
        if (z2) {
            this.OOq = false;
        }
    }

    private void IlO(com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO, com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO2) {
        if ((!this.oeT && !this.vAh) || kBB() || ilO == null || ilO2 == null) {
            return;
        }
        try {
            this.kBB = ilO2.vAh.rp();
            if (this.lEW.FNH()) {
                this.kBB = ilO2.EO();
            }
            this.tl = ilO2.vAh.oeT();
            this.pP = zLG.IlO(this.lEW, ilO2.vAh.ea(), ilO2.vAh.zPa());
        } catch (Throwable unused) {
        }
    }

    private void IlO(oeT oet, Bundle bundle) {
        Activity activityTl = tl();
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = new com.bytedance.sdk.openadsdk.component.reward.IlO.IlO(activityTl, this.IlO, oet, this, 2);
        this.EO = ilO;
        ilO.BO = pP().EO();
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO2 = this.EO;
        boolean z2 = this.oeT;
        ilO2.dm = z2;
        boolean z7 = this.vAh;
        ilO2.gm = z7;
        if (z2 || z7) {
            ilO2.aa = pP().NV();
        }
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO3 = this.EO;
        ilO3.ED = this;
        ilO3.dY = pP().es();
        com.bytedance.sdk.openadsdk.component.reward.IlO.MY.IlO(this.EO, activityTl.getIntent(), bundle);
        com.bytedance.sdk.openadsdk.component.reward.MY.MY myIlO = Bc.IlO(this.EO);
        this.MY = myIlO;
        this.EO.qz = myIlO;
        Objects.toString(myIlO);
    }

    @Override // com.bytedance.sdk.component.utils.vSq.IlO
    public final void IlO(Message message) {
        com.bytedance.sdk.openadsdk.component.reward.MY.MY my = this.MY;
        if (my == null) {
            return;
        }
        my.IlO(message);
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public void IlO(String str, JSONObject jSONObject) {
        if (str == null || !"skipToNextAd".equals(str) || pP() == null || kBB()) {
            return;
        }
        if (pP().lEW() == null && IlO(OOq.EO(this.EO.MY), false, new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.EO.4
            @Override // java.lang.Runnable
            public void run() {
                EO.this.YA();
            }
        })) {
            return;
        }
        YA();
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public void IlO(boolean z2) {
        if (z2) {
            Cc();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.vCE
    public void IlO(vCE vce, vCE vce2, MY.Cc cc) {
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO;
        super.IlO(vce, vce2, cc);
        if (!this.oeT && !this.vAh) {
            if (vce != null || vce2 == this) {
                return;
            }
            vAh();
            return;
        }
        if (vce2 instanceof IlO) {
            if (this.DmF == vce2.DmF + 1 || (vce == null && kBB())) {
                com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO2 = ((IlO) vce2).EO;
                if (ilO2 != null && (ilO = this.EO) != null) {
                    ilO.uvo = ilO2.uvo;
                }
                try {
                    AXM();
                } catch (Throwable unused) {
                    OOq();
                }
                vAh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean IlO(final boolean z2, boolean z7, final Runnable runnable) {
        if (!this.EO.tV || pP().EV().getBoolean("reward_verify", false) || pP().ea()) {
            return false;
        }
        if (!z7 && pP().EV().getBoolean("user_has_give_up_reward", false)) {
            return false;
        }
        if (!cl.tV().Bc(String.valueOf(this.EO.vCE))) {
            if (!z7) {
                return false;
            }
            if (runnable == null && z2) {
                OOq();
                return true;
            }
        }
        this.EO.xF.set(true);
        if (z2) {
            this.EO.pP.bWL();
        }
        final com.bytedance.sdk.openadsdk.core.widget.MY my = new com.bytedance.sdk.openadsdk.core.widget.MY(this.EO.BS);
        this.MY.hp = my;
        if (z2) {
            my.IlO(tV).MY(Cc).EO(vCE);
        } else {
            my.IlO(Bc).MY(bWL).EO(vCE);
        }
        this.MY.hp.IlO(new MY.IlO() { // from class: com.bytedance.sdk.openadsdk.activity.EO.6
            @Override // com.bytedance.sdk.openadsdk.core.widget.MY.IlO
            public void IlO() {
                if (z2) {
                    EO.this.EO.pP.Cc(1000);
                }
                my.dismiss();
                EO.this.EO.xF.set(false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.MY.IlO
            public void MY() {
                my.dismiss();
                EO.this.pP().EV().putBoolean("user_has_give_up_reward", true);
                EO.this.EO.xF.set(false);
                EO.this.EO.pP.vCE(Integer.MAX_VALUE);
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                    return;
                }
                if (!z2) {
                    EO.this.lMM();
                    return;
                }
                if (!OOq.lEW(EO.this.EO.MY)) {
                    EO.this.EO.wPn.vCE();
                    if (EO.this.EO.pP.IlO()) {
                        EO.this.EO.pP.IlO(4);
                    }
                    EO.this.OOq();
                    return;
                }
                if (EO.this.EO.pP.IlO()) {
                    EO.this.EO.pP.IlO(5);
                } else {
                    EO.this.EO.lMM.lEW();
                    EO.this.lMM();
                }
            }
        }).show();
        return true;
    }
}
