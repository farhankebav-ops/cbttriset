package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.work.WorkRequest;
import com.bytedance.sdk.component.utils.xF;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.activity.MY;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.component.reward.view.lEW;
import com.bytedance.sdk.openadsdk.core.AXM;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.model.OOq;
import com.bytedance.sdk.openadsdk.core.model.es;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.widget.MY;
import com.bytedance.sdk.openadsdk.core.xF;
import com.bytedance.sdk.openadsdk.tV.Bc;
import com.bytedance.sdk.openadsdk.utils.bWL;
import com.bytedance.sdk.openadsdk.utils.ea;
import com.bytedance.sdk.openadsdk.utils.pP;
import com.bytedance.sdk.openadsdk.utils.zLG;
import com.google.mlkit.common.MlKitException;
import com.ironsource.Q6;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import w.b;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc extends IlO {
    private static String bWL;
    private static String cL;
    private static String cl;
    private static String ea;
    private static String zPa;
    private int AXM;
    int Bc;
    protected int Cc;
    private String es;
    protected int vCE;
    private String xF;

    public Cc(MY my, oeT oet, int i2, int i8) {
        super(my, oet, i2, i8);
        this.AXM = -1;
    }

    private JSONObject dY() {
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
            jSONObject.put("media_extra", this.xF);
            jSONObject.put("video_duration", this.EO.MY.fdM().f4688d);
            jSONObject.put("play_start_ts", this.vCE);
            jSONObject.put("play_end_ts", this.Cc);
            jSONObject.put("duration", iPP);
            jSONObject.put("user_id", this.es);
            jSONObject.put("trans_id", pP.IlO().replace("-", ""));
            return jSONObject;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.IlO("TTAD.RewardAdScene", "", th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void lMM() {
        /*
            r3 = this;
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r0 = r3.EO
            com.bytedance.sdk.openadsdk.component.reward.IlO.cl r0 = r0.vAh
            r0.oc()
            com.bytedance.sdk.openadsdk.tV.Cc.MY.ea$IlO r0 = new com.bytedance.sdk.openadsdk.tV.Cc.MY.ea$IlO
            r0.<init>()
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r1 = r3.EO
            com.bytedance.sdk.openadsdk.component.reward.IlO.cl r1 = r1.vAh
            long r1 = r1.EV()
            r0.MY(r1)
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r1 = r3.EO
            com.bytedance.sdk.openadsdk.component.reward.IlO.cl r1 = r1.vAh
            long r1 = r1.kBB()
            r0.tV(r1)
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r1 = r3.EO
            com.bytedance.sdk.openadsdk.component.reward.IlO.cl r1 = r1.vAh
            long r1 = r1.ea()
            r0.EO(r1)
            r1 = 3
            r0.EO(r1)
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r1 = r3.EO
            com.bytedance.sdk.openadsdk.component.reward.IlO.cl r1 = r1.vAh
            int r1 = r1.vAh()
            r0.tV(r1)
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r1 = r3.EO
            com.bytedance.sdk.openadsdk.component.reward.IlO.cl r1 = r1.vAh
            long r1 = r1.MY()
            r0.IlO(r1)
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r1 = r3.EO
            com.bytedance.sdk.openadsdk.component.reward.IlO.cl r1 = r1.vAh
            v.a r1 = r1.Bc()
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r2 = r3.EO
            com.bytedance.sdk.openadsdk.component.reward.IlO.cl r2 = r2.vAh
            com.bytedance.sdk.openadsdk.tV.Bc r2 = r2.Cc()
            com.bytedance.sdk.openadsdk.tV.Cc.IlO.IlO.IlO(r1, r0, r2)
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r0 = r3.EO
            int r0 = r0.vCE
            com.bytedance.sdk.openadsdk.core.kBB.EO(r0)
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r0 = r3.EO
            com.bytedance.sdk.openadsdk.component.reward.IlO.cl r0 = r0.vAh
            java.lang.String r1 = "skip"
            r2 = 0
            r0.IlO(r1, r2)
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r0 = r3.EO
            boolean r0 = r0.EO
            if (r0 == 0) goto L8a
            r0 = 1
            r1 = 4
            r3.IlO(r0, r1)
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r0 = r3.EO
            com.bytedance.sdk.openadsdk.core.model.oeT r0 = r0.MY
            boolean r0 = com.bytedance.sdk.openadsdk.core.model.es.IlO(r0)
            if (r0 == 0) goto L8d
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r0 = r3.EO
            java.util.concurrent.atomic.AtomicBoolean r0 = r0.zPa
            boolean r0 = r0.get()
            if (r0 != 0) goto L8d
        L8a:
            r3.OOq()
        L8d:
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r0 = r3.EO
            com.bytedance.sdk.openadsdk.core.model.oeT r0 = r0.MY
            com.bytedance.sdk.openadsdk.core.EV.IlO r0 = r0.QfH()
            if (r0 == 0) goto La9
            com.bytedance.sdk.openadsdk.core.EV.tV r0 = r0.IlO()
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r1 = r3.EO
            com.bytedance.sdk.openadsdk.component.reward.IlO.cl r1 = r1.vAh
            long r1 = r1.EV()
            r0.vCE(r1)
            r0.Cc(r1)
        La9:
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r0 = r3.EO
            com.bytedance.sdk.openadsdk.core.model.oeT r0 = r0.MY
            r1 = 5
            com.bytedance.sdk.openadsdk.kBB.MY.Cc.IlO(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.Cc.lMM():void");
    }

    @Override // com.bytedance.sdk.openadsdk.activity.IlO
    public void Bc() {
        oc();
        if (this.lEW.vCE()) {
            this.EO.tl.NV();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.IlO
    public void EO() {
        final View viewNV = this.EO.DM.NV();
        if (viewNV != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.Cc.1
                /* JADX WARN: Removed duplicated region for block: B:28:0x00d6  */
                @Override // android.view.View.OnClickListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void onClick(android.view.View r5) {
                    /*
                        Method dump skipped, instruction units count: 270
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.Cc.AnonymousClass1.onClick(android.view.View):void");
                }
            };
            viewNV.setOnClickListener(onClickListener);
            viewNV.setTag(viewNV.getId(), onClickListener);
        }
        this.EO.YA.IlO(new com.bytedance.sdk.openadsdk.component.reward.top.MY() { // from class: com.bytedance.sdk.openadsdk.activity.Cc.2
            @Override // com.bytedance.sdk.openadsdk.component.reward.top.MY
            public void EO(View view) {
                View view2 = viewNV;
                if (view2 != null) {
                    view2.performClick();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.MY
            public void IlO(View view) {
                if (Cc.this.EO.MY.ey()) {
                    if (Cc.this.EO.DM.EV() != null) {
                        Cc.this.EO.MY.zLG(2);
                        Cc.this.EO.DM.cl();
                        return;
                    }
                    return;
                }
                com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = Cc.this.EO;
                if (!ilO.EO && ilO.MY.pbX() && !Cc.this.EO.MY.xJ()) {
                    Cc.this.EO.MY.zLG(13);
                    try {
                        Cc.this.EO.DM.cl();
                        return;
                    } catch (Exception unused) {
                    }
                }
                Cc cc = Cc.this;
                cc.IlO(OOq.EO(cc.EO.MY), false, (Runnable) null);
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.MY
            public void MY(View view) {
                Cc cc = Cc.this;
                cc.EO.vSq.IlO(cc.MY);
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.MY
            public void IlO(View view, String str) {
                com.bytedance.sdk.openadsdk.component.reward.MY.MY my = Cc.this.MY;
                if (my != null && my.tV() != null) {
                    Cc.this.MY.tV().IlO(Cc.this.EO.uvo);
                }
                Cc.this.EO.uvo = !r3.uvo;
                StringBuilder sb = new StringBuilder("will set is Mute ");
                sb.append(Cc.this.EO.uvo);
                sb.append(" mLastVolume=");
                sb.append(Cc.this.EO.dY.IlO());
                com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = Cc.this.EO;
                ilO.vAh.IlO(ilO.uvo, str);
                if (!OOq.es(Cc.this.EO.MY) || Cc.this.EO.NV.get()) {
                    com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO2 = Cc.this.EO;
                    ilO2.lMM.Cc(ilO2.uvo);
                    oeT oet = Cc.this.EO.MY;
                    if (oet == null || oet.QfH() == null || Cc.this.EO.MY.QfH().IlO() == null) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO3 = Cc.this.EO;
                    if (ilO3.vAh != null) {
                        if (ilO3.uvo) {
                            ilO3.MY.QfH().IlO().lEW(Cc.this.EO.vAh.EV());
                        } else {
                            ilO3.MY.QfH().IlO().DmF(Cc.this.EO.vAh.EV());
                        }
                    }
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.activity.IlO, com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public void IlO(Bundle bundle) {
    }

    @Override // com.bytedance.sdk.openadsdk.activity.IlO
    public void MY() {
        this.EO.YA.IlO(null, TTAdDislikeToast.getSkipText());
        this.EO.YA.Cc(true);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.vCE
    public boolean a_() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x003f  */
    @Override // com.bytedance.sdk.openadsdk.activity.IlO, com.bytedance.sdk.openadsdk.activity.vCE, com.bytedance.sdk.openadsdk.core.rp.tV.MY
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void bWL() {
        /*
            r8 = this;
            com.bytedance.sdk.openadsdk.core.model.oeT r0 = r8.lEW
            boolean r0 = r0.EJ()
            if (r0 != 0) goto La
            goto L97
        La:
            com.bytedance.sdk.openadsdk.core.settings.vCE r0 = com.bytedance.sdk.openadsdk.core.cl.tV()
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r1 = r8.EO
            int r1 = r1.vCE
            java.lang.String r1 = java.lang.String.valueOf(r1)
            com.bytedance.sdk.openadsdk.core.settings.MY r0 = r0.tl(r1)
            int r0 = r0.vCE
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r1 = r8.EO
            com.bytedance.sdk.openadsdk.core.model.oeT r1 = r1.MY
            boolean r1 = com.bytedance.sdk.openadsdk.core.model.OOq.es(r1)
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L41
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r1 = r8.EO
            com.bytedance.sdk.openadsdk.component.reward.IlO.cl r1 = r1.vAh
            double r4 = r1.YA()
            int r1 = r8.Bc
            double r6 = (double) r1
            double r6 = r6 / r4
            r4 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r4 = r4 - r6
            r6 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r4 = r4 * r6
            double r0 = (double) r0
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 < 0) goto L92
        L3f:
            r2 = r3
            goto L92
        L41:
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r1 = r8.EO
            com.bytedance.sdk.openadsdk.core.model.oeT r1 = r1.MY
            int r1 = r1.XvI()
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r4 = r8.EO
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
            if (r0 < 0) goto L60
            r0 = r3
            goto L61
        L60:
            r0 = r2
        L61:
            com.bytedance.sdk.openadsdk.core.settings.vCE r1 = com.bytedance.sdk.openadsdk.core.cl.tV()
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r4 = r8.EO
            int r4 = r4.vCE
            java.lang.String r4 = java.lang.String.valueOf(r4)
            int r1 = r1.IlO(r4)
            if (r1 != 0) goto L8f
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r1 = r8.EO
            com.bytedance.sdk.openadsdk.component.reward.IlO.es r1 = r1.lMM
            com.bytedance.sdk.openadsdk.core.vSq r1 = r1.rp()
            boolean r1 = r1.vCE()
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO r4 = r8.EO
            com.bytedance.sdk.openadsdk.component.reward.IlO.lEW r4 = r4.pP
            boolean r4 = r4.EO()
            if (r4 == 0) goto L8a
            r1 = r3
        L8a:
            if (r0 == 0) goto L92
            if (r1 == 0) goto L92
            goto L3f
        L8f:
            if (r1 != r3) goto L92
            r2 = r0
        L92:
            if (r2 == 0) goto L97
            r8.vAh()
        L97:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.Cc.bWL():void");
    }

    @Override // com.bytedance.sdk.openadsdk.activity.vCE
    public String b_() {
        return "rewarded_video";
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public void c_() {
        vSq();
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public void d_() {
        EO(2);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.IlO, com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public void rp() {
        vAh();
    }

    public void vAh() {
        EO(0);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.IlO, com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public void IlO(boolean z2) {
    }

    public void MY(long j, long j3) {
        if (j3 <= 0) {
            return;
        }
        if (this.AXM == -1) {
            this.AXM = Math.min(100, this.lEW.vSq());
        }
        if (((j / 1000.0f) / j3) * 100.0f >= this.AXM) {
            vAh();
        }
    }

    public void EO(final int i2) {
        if (pP().EV().getBoolean("reward_verify", false) || pP().ea() || pP().EV().getBoolean("user_has_give_up_reward", false)) {
            return;
        }
        pP().EV().putBoolean("reward_verify", true);
        if (cl.tV().ea(String.valueOf(this.EO.vCE))) {
            IlO(true, this.EO.MY.wPn(), this.EO.MY.OOq(), 0, "", i2);
        } else {
            cl.EO().IlO(dY(), new xF.MY() { // from class: com.bytedance.sdk.openadsdk.activity.Cc.6
                @Override // com.bytedance.sdk.openadsdk.core.xF.MY
                public void IlO(int i8, String str) {
                    Cc.this.IlO(false, 0, "", i8, str, i2);
                }

                @Override // com.bytedance.sdk.openadsdk.core.xF.MY
                public void IlO(AXM.MY my) {
                    boolean z2 = my.MY;
                    Cc.this.IlO(my.MY, my.EO.IlO(), my.EO.MY(), 0, "", i2);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.IlO, com.bytedance.sdk.openadsdk.activity.vCE
    public void IlO(Activity activity, MY.Cc cc) {
        super.IlO(activity, cc);
        if (activity.isFinishing()) {
            return;
        }
        Intent intent = activity.getIntent();
        this.xF = intent.getStringExtra("media_extra");
        this.es = intent.getStringExtra("user_id");
        try {
            if (cl == null) {
                cl = com.bytedance.sdk.component.utils.pP.IlO(this.EO.gQ, "tt_reward_msg");
                bWL = com.bytedance.sdk.component.utils.pP.IlO(this.EO.gQ, "tt_msgPlayable");
                zPa = com.bytedance.sdk.component.utils.pP.IlO(this.EO.gQ, "tt_negtiveBtnBtnText");
                cL = com.bytedance.sdk.component.utils.pP.IlO(this.EO.gQ, "tt_postiveBtnText");
                ea = com.bytedance.sdk.component.utils.pP.IlO(this.EO.gQ, "tt_postiveBtnTextPlayable");
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("TTAD.RewardAdScene", th.getMessage());
        }
        MY myPP = pP();
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.EO;
        if (ilO == null || myPP == null) {
            return;
        }
        ilO.PTq = myPP.MY;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.IlO, com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public void IlO(int i2) {
        if (i2 == 10000) {
            vAh();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public boolean IlO(long j, boolean z2) {
        Bc bc;
        if (this.lEW.vCE()) {
            lEW lew = this.EO.tl;
            if (lew != null && lew.IlO() != null) {
                bc = this.EO.tl.IlO().getAdShowTime();
            } else {
                bc = new Bc();
            }
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.EO;
            ilO.vAh.IlO(ilO.tl.MY(), bc);
            HashMap map = new HashMap();
            lEW lew2 = this.EO.tl;
            if (lew2 != null) {
                map.put("dynamic_show_type", Integer.valueOf(lew2.DmF()));
                JSONObject jSONObjectIlO = this.EO.tl.IlO((JSONObject) null);
                if (jSONObjectIlO != null) {
                    Iterator<String> itKeys = jSONObjectIlO.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        try {
                            map.put(next, jSONObjectIlO.get(next));
                        } catch (JSONException unused) {
                        }
                    }
                }
            }
            this.EO.vAh.IlO(new b() { // from class: com.bytedance.sdk.openadsdk.activity.Cc.3
                boolean IlO;

                @Override // w.b
                public void IlO(long j3, int i2) {
                    if (this.IlO) {
                        return;
                    }
                    this.IlO = true;
                    ((IlO) Cc.this).IlO.removeMessages(MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE);
                    Cc.this.hp();
                    Cc.this.EO.vAh.IlO(j3, j3);
                    Cc.this.EO.tl.MY(true);
                    if (Cc.this.EO.MY.vAh() == 36) {
                        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO2 = Cc.this.EO;
                        if (ilO2.EO) {
                            ilO2.kBB.EO().tV();
                            ea.MY();
                        }
                    }
                    if (Cc.this.EO.MY.vAh() == 21 && !Cc.this.EO.MY.NV()) {
                        Cc.this.EO.MY.MY(true);
                        Cc.this.EO.DM.cl();
                    }
                    Cc cc = Cc.this;
                    com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO3 = cc.EO;
                    if (ilO3.BO) {
                        MY myPP = cc.pP();
                        Cc cc2 = Cc.this;
                        myPP.IlO(cc2, cc2.MY(5));
                    } else if (ilO3.EO) {
                        if (!ilO3.MY.FNH()) {
                            Cc.this.IlO(false, 5);
                            if (!oeT.Cc(Cc.this.EO.MY)) {
                                Cc.this.EO.vAh.IlO("skip", true);
                            }
                        } else if (Cc.this.EO.tl.DmF() == 1) {
                            Cc.this.EO.YA.EO();
                        }
                    } else if (!ilO3.MY.FNH()) {
                        if (!oeT.Cc(Cc.this.EO.MY)) {
                            Cc.this.EO.vAh.IlO("skip", true);
                        }
                        Cc.this.OOq();
                    } else if (Cc.this.EO.tl.DmF() == 1) {
                        Cc.this.EO.YA.EO();
                    }
                    Cc.this.Cc = (int) (System.currentTimeMillis() / 1000);
                    Cc cc3 = Cc.this;
                    if (cc3.EO.BO) {
                        return;
                    }
                    cc3.vAh();
                }

                @Override // w.b
                public void MY(long j3, int i2) {
                    ((IlO) Cc.this).IlO.removeMessages(MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE);
                    es esVar = Cc.this.EO.DM.ea;
                    if (esVar != null) {
                        esVar.NV();
                    }
                    if (Cc.this.EO.vAh.vCE()) {
                        Cc.this.Cc();
                        return;
                    }
                    Cc.this.vAh();
                    Cc.this.EO.vAh.cL();
                    Cc.this.EO.tl.IlO(true);
                    MY myPP = Cc.this.pP();
                    Cc cc = Cc.this;
                    myPP.IlO(cc, cc.MY(3));
                }

                @Override // w.b
                public void IlO() {
                    ((IlO) Cc.this).IlO.removeMessages(MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE);
                    Cc.this.hp();
                    Cc.this.vAh();
                    MY myPP = Cc.this.pP();
                    Cc cc = Cc.this;
                    myPP.IlO(cc, cc.MY(6));
                }

                @Override // w.b
                public void IlO(long j3, long j8) {
                    com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO2 = Cc.this.EO;
                    if (!ilO2.KC && ilO2.vAh.vCE()) {
                        Cc.this.EO.vAh.xF();
                    }
                    if (Cc.this.EO.NV.get()) {
                        return;
                    }
                    ((IlO) Cc.this).IlO.removeMessages(MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE);
                    if (j3 != Cc.this.EO.vAh.rp()) {
                        Cc.this.hp();
                    }
                    if (Cc.this.EO.vAh.vCE()) {
                        Cc.this.EO.vAh.IlO(j3, j8);
                        int iMY = Cc.this.lEW.MY();
                        boolean z7 = Cc.this.EO.tl.lEW() && iMY != -1 && iMY >= 0;
                        Cc cc = Cc.this;
                        long j9 = j3 / 1000;
                        cc.Bc = (int) (cc.EO.vAh.YA() - j9);
                        int i2 = (int) j9;
                        if ((Cc.this.EO.xF.get() || Cc.this.EO.EV.get()) && Cc.this.EO.vAh.vCE()) {
                            Cc.this.EO.vAh.xF();
                        }
                        Cc cc2 = Cc.this;
                        int i8 = cc2.Bc;
                        if (i8 >= 0) {
                            cc2.EO.YA.IlO(String.valueOf(i8), null);
                        }
                        Cc.this.EO.DM.tV(i2);
                        Cc.this.IlO(j3, j8);
                        lEW lew3 = Cc.this.EO.tl;
                        if (lew3 != null && lew3.IlO() != null) {
                            Cc.this.EO.tl.IlO().setTime(String.valueOf(Cc.this.Bc), i2, 0, false);
                        }
                        Cc.this.IlO((j3 * 1.0f) / j8);
                        Cc cc3 = Cc.this;
                        if (cc3.Bc > 0) {
                            if (z7 && i2 >= iMY && cc3.EO.MY.vAh() != 5) {
                                Cc.this.EO.IlO(true);
                                Cc cc4 = Cc.this;
                                cc4.EO.YA.IlO(String.valueOf(cc4.Bc), TTAdDislikeToast.getSkipText());
                                Cc.this.EO.YA.Cc(true);
                                return;
                            }
                            Cc cc5 = Cc.this;
                            cc5.EO.YA.IlO(String.valueOf(cc5.Bc), null);
                        }
                    }
                }
            });
            boolean zIlO = this.EO.vAh.IlO(j, z2, map, this.MY);
            if (zIlO && !z2) {
                this.vCE = (int) (System.currentTimeMillis() / 1000);
            }
            return zIlO;
        }
        Bc bc2 = new Bc();
        bc2.IlO(System.currentTimeMillis(), 1.0f);
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO2 = this.EO;
        ilO2.vAh.IlO(ilO2.DM.vCE(), bc2);
        b bVar = new b() { // from class: com.bytedance.sdk.openadsdk.activity.Cc.4
            boolean IlO;

            @Override // w.b
            public void IlO(long j3, int i2) {
                bWL bwl;
                if (this.IlO) {
                    return;
                }
                this.IlO = true;
                ((IlO) Cc.this).IlO.removeMessages(MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE);
                Cc.this.hp();
                Cc cc = Cc.this;
                if (!cc.EO.BO) {
                    cc.vAh();
                }
                Cc.this.EO.vAh.IlO(j3, j3);
                Cc.this.EO.es.set(true);
                if (Cc.this.EO.MY.SU()) {
                    Cc.this.EO.MY.zLG(1);
                    Cc.this.EO.DM.cl();
                }
                if (Cc.this.EO.MY.vAh() == 21 && !Cc.this.EO.MY.NV()) {
                    Cc.this.EO.MY.MY(true);
                    Cc.this.EO.DM.cl();
                }
                Cc.this.Cc = (int) (System.currentTimeMillis() / 1000);
                Cc cc2 = Cc.this;
                com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO3 = cc2.EO;
                if (ilO3.BO) {
                    MY.Cc ccMY = cc2.MY(5);
                    ccMY.Cc = true;
                    Cc.this.pP().IlO(Cc.this, ccMY);
                    return;
                }
                if (es.tV(ilO3.MY) || es.MY(Cc.this.EO.MY) || es.Cc(Cc.this.EO.MY)) {
                    Cc.this.IlO(false, 5);
                    if (!es.MY(Cc.this.EO.MY) || (bwl = Cc.this.EO.ts) == null) {
                        return;
                    }
                    bwl.IlO(0L);
                    return;
                }
                if (es.IlO(Cc.this.EO.MY) && !Cc.this.EO.zPa.get()) {
                    Cc.this.EO.IlO(true);
                    Cc.this.EO.YA.Cc(true);
                    return;
                }
                com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO4 = Cc.this.EO;
                if (!ilO4.EO) {
                    if (ilO4.MY.FNH()) {
                        Cc.this.EO.YA.EO();
                        return;
                    }
                    if (!oeT.Cc(Cc.this.EO.MY)) {
                        Cc.this.EO.vAh.IlO("skip", true);
                    }
                    Cc.this.OOq();
                    return;
                }
                if (ilO4.MY.FNH()) {
                    Cc.this.EO.YA.EO();
                    return;
                }
                Cc.this.IlO(false, 5);
                if (oeT.Cc(Cc.this.EO.MY)) {
                    return;
                }
                Cc.this.EO.vAh.IlO("skip", true);
            }

            @Override // w.b
            public void MY(long j3, int i2) {
                ((IlO) Cc.this).IlO.removeMessages(MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE);
                es esVar = Cc.this.EO.DM.ea;
                if (esVar != null) {
                    esVar.NV();
                }
                if (Cc.this.EO.vAh.vCE()) {
                    Cc.this.Cc();
                    return;
                }
                Cc.this.EO.vAh.cL();
                Cc.this.vAh();
                MY myPP = Cc.this.pP();
                Cc cc = Cc.this;
                myPP.IlO(cc, cc.MY(3));
            }

            @Override // w.b
            public void IlO() {
                ((IlO) Cc.this).IlO.removeMessages(MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE);
                Cc.this.hp();
                Cc.this.vAh();
                MY myPP = Cc.this.pP();
                Cc cc = Cc.this;
                myPP.IlO(cc, cc.MY(6));
            }

            @Override // w.b
            public void IlO(long j3, long j8) {
                com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO3 = Cc.this.EO;
                if (!ilO3.KC && ilO3.vAh.vCE()) {
                    Cc.this.EO.vAh.xF();
                }
                if (Cc.this.EO.NV.get()) {
                    return;
                }
                ((IlO) Cc.this).IlO.removeMessages(MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE);
                if (j3 != Cc.this.EO.vAh.rp()) {
                    Cc.this.hp();
                }
                Cc.this.EO.vAh.IlO(j3, j8);
                Cc cc = Cc.this;
                long j9 = j3 / 1000;
                double d8 = j9;
                cc.Bc = (int) (cc.EO.vAh.YA() - d8);
                Cc cc2 = Cc.this;
                int i2 = cc2.Bc;
                if (i2 >= 0) {
                    cc2.EO.YA.IlO(String.valueOf(i2), null);
                }
                Cc cc3 = Cc.this;
                cc3.Bc = (int) (cc3.EO.vAh.YA() - d8);
                int i8 = (int) j9;
                int iMY = Cc.this.lEW.MY();
                boolean z7 = iMY >= 0;
                if ((Cc.this.EO.xF.get() || Cc.this.EO.EV.get()) && Cc.this.EO.vAh.vCE()) {
                    Cc.this.EO.vAh.xF();
                }
                Cc.this.EO.DM.tV(i8);
                Cc.this.IlO(j3, j8);
                Cc.this.IlO((j3 * 1.0f) / j8);
                Cc cc4 = Cc.this;
                if (cc4.Bc > 0) {
                    cc4.EO.YA.tV(true);
                    if (z7 && i8 >= iMY) {
                        Cc.this.EO.IlO(true);
                        Cc cc5 = Cc.this;
                        cc5.EO.YA.IlO(String.valueOf(cc5.Bc), TTAdDislikeToast.getSkipText());
                        Cc.this.EO.YA.Cc(true);
                        return;
                    }
                    Cc cc6 = Cc.this;
                    cc6.EO.YA.IlO(String.valueOf(cc6.Bc), null);
                }
            }
        };
        this.EO.vAh.IlO(bVar);
        es esVar = this.EO.DM.ea;
        if (esVar != null) {
            esVar.IlO(bVar);
        }
        boolean zIlO2 = this.EO.vAh.IlO(j, z2, null, this.MY);
        if (zIlO2 && !z2) {
            this.vCE = (int) (System.currentTimeMillis() / 1000);
        }
        return zIlO2;
    }

    public void IlO(long j, long j3) {
        if (this.EO.BO) {
            return;
        }
        oeT oet = this.lEW;
        if (oet != null && oet.vSq() >= 0 && this.lEW.EO() >= 0) {
            MY(j, this.lEW.EO());
            return;
        }
        if (j3 <= 0) {
            return;
        }
        long j8 = (((long) this.EO.Ea) * 1000) + j;
        if (this.AXM == -1) {
            this.AXM = cl.tV().tl(String.valueOf(this.EO.vCE)).vCE;
        }
        if (j3 >= WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS && j8 >= 27000) {
            vAh();
        } else if ((j8 * 100) / j3 >= this.AXM) {
            vAh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean IlO(final boolean z2, boolean z7, final Runnable runnable) {
        if (!z7 && pP().EV().getBoolean("user_has_give_up_reward", false) && (OOq.lEW(this.EO.MY) || runnable != null)) {
            if (runnable == null) {
                lMM();
            }
            return false;
        }
        if (!cl.tV().Bc(String.valueOf(this.EO.vCE))) {
            if (runnable == null) {
                if (z2) {
                    OOq();
                    return false;
                }
                lMM();
            }
            return false;
        }
        if (pP().EV().getBoolean("reward_verify", false)) {
            if (runnable == null) {
                if (OOq.lEW(this.EO.MY)) {
                    lMM();
                    return false;
                }
                if (z2) {
                    OOq();
                    return false;
                }
                lMM();
            }
            return false;
        }
        this.EO.xF.set(true);
        this.EO.vAh.xF();
        if (z2) {
            this.EO.pP.bWL();
        }
        final com.bytedance.sdk.openadsdk.core.widget.MY my = new com.bytedance.sdk.openadsdk.core.widget.MY(tl());
        this.MY.hp = my;
        if (z2) {
            my.IlO(bWL).MY(ea).EO(zPa);
        } else {
            my.IlO(cl).MY(cL).EO(zPa);
        }
        this.MY.hp.IlO(new MY.IlO() { // from class: com.bytedance.sdk.openadsdk.activity.Cc.5
            @Override // com.bytedance.sdk.openadsdk.core.widget.MY.IlO
            public void IlO() {
                Cc.this.EO.vAh.es();
                if (z2) {
                    Cc.this.EO.pP.Cc(1000);
                }
                my.dismiss();
                Cc.this.EO.xF.set(false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.MY.IlO
            public void MY() {
                my.dismiss();
                Cc.this.pP().EV().putBoolean("user_has_give_up_reward", true);
                Cc.this.EO.xF.set(false);
                Cc.this.EO.pP.vCE(Integer.MAX_VALUE);
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                    return;
                }
                if (!z2) {
                    Cc.this.lMM();
                    return;
                }
                if (OOq.lEW(Cc.this.EO.MY)) {
                    if (Cc.this.EO.pP.IlO()) {
                        Cc.this.EO.pP.IlO(5);
                        return;
                    } else {
                        Cc.this.lMM();
                        return;
                    }
                }
                Cc.this.EO.wPn.vCE();
                if (Cc.this.EO.pP.IlO()) {
                    Cc.this.EO.pP.IlO(4);
                }
                Cc.this.OOq();
            }
        }).show();
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.IlO, com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public void IlO(final String str, final JSONObject jSONObject) {
        if ("skipToNextAd".equals(str) && this.EO.ED != null && pP().lEW() == null && IlO(OOq.EO(this.EO.MY), false, new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.Cc.7
            @Override // java.lang.Runnable
            public void run() {
                Cc.super.IlO(str, jSONObject);
            }
        })) {
            return;
        }
        super.IlO(str, jSONObject);
    }
}
