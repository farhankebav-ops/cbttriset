package com.bytedance.sdk.openadsdk.component.reward.IlO;

import android.R;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.component.utils.oeT;
import com.bytedance.sdk.openadsdk.component.reward.IlO.tV;
import com.bytedance.sdk.openadsdk.core.MY.EO;
import com.bytedance.sdk.openadsdk.core.MY.IlO;
import com.bytedance.sdk.openadsdk.core.model.NV;
import com.bytedance.sdk.openadsdk.core.model.OOq;
import com.bytedance.sdk.openadsdk.core.model.vAh;
import com.bytedance.sdk.openadsdk.kBB.MY.Cc;
import com.bytedance.sdk.openadsdk.utils.BS;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EV {
    private final com.bytedance.sdk.openadsdk.core.MY.Cc EO;
    private final IlO IlO;
    private final com.bytedance.sdk.openadsdk.core.MY.MY MY;

    public EV(IlO ilO) {
        this.IlO = ilO;
        this.EO = IlO(ilO, ilO.MY);
        this.MY = new com.bytedance.sdk.openadsdk.core.MY.MY(ilO.BS, ilO.MY, ilO.Cc, ilO.tV ? 7 : 5) { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.EV.1
            @Override // com.bytedance.sdk.openadsdk.core.MY.MY, com.bytedance.sdk.openadsdk.core.MY.EO
            public void IlO(View view, float f4, float f8, float f9, float f10, SparseArray<EO.IlO> sparseArray, boolean z2) {
                try {
                    EV.this.IlO(view, f4, f8, f9, f10, sparseArray, this.oc, this.OOq, this.wPn);
                } catch (Exception e) {
                    oeT.EO("TTAD.RFReportManager", "onClickReport error :" + e.getMessage());
                }
                com.bytedance.sdk.openadsdk.kBB.MY.Cc.IlO(EV.this.IlO.MY, 9);
                EV.this.IlO.vAh.BS();
            }
        };
    }

    private JSONObject DmF() {
        try {
            long jAXM = this.IlO.vAh.AXM();
            int iOeT = this.IlO.vAh.oeT();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("duration", jAXM);
                jSONObject.put("percent", iOeT);
                return jSONObject;
            } catch (Throwable unused) {
                return jSONObject;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    private boolean lEW() {
        com.bytedance.sdk.openadsdk.core.model.oeT oet = this.IlO.MY;
        return oet != null && oet.Dxv() == 1;
    }

    public void Bc() {
        JSONObject jSONObject = new JSONObject();
        IlO(jSONObject);
        IlO ilO = this.IlO;
        com.bytedance.sdk.openadsdk.tV.EO.Cc(ilO.MY, ilO.Cc, jSONObject);
    }

    public com.bytedance.sdk.openadsdk.core.MY.Cc Cc() {
        return this.EO;
    }

    public com.bytedance.sdk.openadsdk.core.MY.Cc EO() {
        this.EO.IlO(this.IlO.BS.findViewById(R.id.content));
        this.EO.MY(this.IlO.zLG.findViewById(520093713));
        if (this.IlO.kBB.EO() != null) {
            this.EO.IlO(this.IlO.kBB.EO());
        }
        this.IlO.pP.IlO(this.EO);
        this.EO.IlO(new IlO.InterfaceC0087IlO() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.EV.3
            @Override // com.bytedance.sdk.openadsdk.core.MY.IlO.InterfaceC0087IlO
            public long getVideoProgress() {
                return EV.this.IlO.vAh.EV();
            }
        });
        com.bytedance.sdk.openadsdk.component.reward.view.NV nv = this.IlO.DM;
        com.bytedance.sdk.openadsdk.core.MY.Cc cc = this.EO;
        nv.IlO(cc, cc, this.MY);
        this.IlO.mmj.IlO(this.EO);
        return this.EO;
    }

    public void MY() {
        boolean z2;
        com.bytedance.sdk.openadsdk.component.reward.view.lEW lew;
        if (this.IlO.hp.get()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (!this.IlO.MY.vCE() || (lew = this.IlO.tl) == null) {
                z2 = false;
            } else {
                jSONObject.put("dynamic_show_type", lew.DmF());
                this.IlO.tl.IlO(jSONObject);
                z2 = true;
            }
            com.bytedance.sdk.openadsdk.core.model.oeT oet = this.IlO.MY;
            IlO(jSONObject);
            View viewFindViewById = this.IlO.BS.findViewById(R.id.content);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("width", viewFindViewById.getWidth());
                jSONObject2.put("height", viewFindViewById.getHeight());
                jSONObject2.put("alpha", viewFindViewById.getAlpha());
            } catch (Throwable unused) {
            }
            jSONObject.put("root_view", jSONObject2.toString());
            if (this.IlO.hp.compareAndSet(false, true)) {
                com.bytedance.sdk.openadsdk.tV.EO.IlO(oet, this.IlO.Cc, jSONObject);
                this.IlO.ssS.vCE();
                Cc.IlO ilO = new Cc.IlO(z2 ? this.IlO.tl.DmF() : -1);
                IlO(ilO);
                com.bytedance.sdk.openadsdk.kBB.MY.Cc.IlO(this.IlO.BS.findViewById(R.id.content), oet, ilO);
                com.bytedance.sdk.openadsdk.kBB.IlO.EO.IlO(oet);
            }
        } catch (JSONException e) {
            oeT.IlO("TTAD.RFReportManager", "reportShowWhenBindVideoAd error", e);
        }
    }

    public com.bytedance.sdk.openadsdk.core.MY.MY tV() {
        return this.MY;
    }

    public void vCE() {
        JSONObject jSONObject = new JSONObject();
        if (OOq.cL(this.IlO.MY)) {
            this.IlO.pP.IlO(jSONObject);
        }
        try {
            if (this.IlO.NV.get()) {
                jSONObject.put("endcard_content", this.IlO.lMM.EO() ? 1 : this.IlO.nvX.tV() ? 3 : this.IlO.lMM.tV() ? 2 : 0);
            } else {
                jSONObject.put("endCardNotShow", 1);
            }
        } catch (JSONException unused) {
        }
        IlO ilO = this.IlO;
        com.bytedance.sdk.openadsdk.tV.EO.MY(ilO.MY, ilO.Cc, "click_close", jSONObject);
    }

    public void IlO() {
        if (this.IlO.hp.get()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        com.bytedance.sdk.openadsdk.core.model.oeT oet = this.IlO.MY;
        IlO(jSONObject);
        if (this.IlO.hp.compareAndSet(false, true)) {
            com.bytedance.sdk.openadsdk.tV.EO.IlO(oet, this.IlO.Cc, jSONObject);
            this.IlO.ssS.vCE();
            Cc.IlO ilO = new Cc.IlO(-1);
            IlO(ilO);
            com.bytedance.sdk.openadsdk.kBB.MY.Cc.IlO(this.IlO.BS.findViewById(R.id.content), oet, ilO);
            com.bytedance.sdk.openadsdk.kBB.IlO.EO.IlO(oet);
        }
    }

    public void EO(boolean z2) {
        IlO ilO = this.IlO;
        if (ilO != null && z2 && ilO.MY.NLy() && !this.IlO.MY.TkD()) {
            this.IlO.MY.Bc(true);
            IlO ilO2 = this.IlO;
            com.bytedance.sdk.openadsdk.core.model.oeT oet = ilO2.MY;
            com.bytedance.sdk.openadsdk.tV.EO.IlO(oet, ilO2.Cc, oet.hjY());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.activity.vCE vce;
        com.bytedance.sdk.openadsdk.core.model.oeT oet = this.IlO.MY;
        if ((oet instanceof vAh) && ((vAh) oet).ar()) {
            try {
                jSONObject.put("choose_one_ad_real_show", true);
            } catch (JSONException e) {
                oeT.IlO("TTAD.RFReportManager", "reportShow json error", e);
            }
        }
        IlO ilO = this.IlO;
        if (!ilO.BO || (vce = ilO.ED) == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.tV.EO.IlO(vce.NV + 1, jSONObject);
        } catch (Throwable unused) {
        }
    }

    public void MY(boolean z2) {
        IlO ilO = this.IlO;
        if (ilO == null) {
            return;
        }
        if (!z2 && ilO.hp.get() && this.IlO.Tx > 0) {
            String strValueOf = String.valueOf(SystemClock.elapsedRealtime() - this.IlO.Tx);
            IlO ilO2 = this.IlO;
            com.bytedance.sdk.openadsdk.tV.EO.IlO(strValueOf, ilO2.MY, ilO2.Cc, ilO2.vAh.Cc());
            this.IlO.Tx = 0L;
        } else {
            this.IlO.Tx = SystemClock.elapsedRealtime();
        }
        com.bytedance.sdk.openadsdk.kBB.MY.Cc.IlO(this.IlO.MY, z2 ? 4 : 8);
        com.bytedance.sdk.openadsdk.kBB.IlO.EO.IlO(this.IlO.MY, z2 ? 4 : 8);
    }

    public void IlO(final Map<String, Object> map) {
        if (this.IlO.hp.get()) {
            return;
        }
        this.IlO.hp.set(true);
        final View viewFindViewById = this.IlO.BS.findViewById(R.id.content);
        if (viewFindViewById == null) {
            viewFindViewById = this.IlO.BS.getWindow().getDecorView();
        }
        viewFindViewById.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.EV.2
            @Override // java.lang.Runnable
            public void run() {
                Map map2;
                boolean z2 = false;
                if (EV.this.IlO.bWL.compareAndSet(false, true)) {
                    com.bytedance.sdk.openadsdk.core.model.oeT oet = EV.this.IlO.MY;
                    JSONObject jSONObject = null;
                    try {
                        jSONObject = map != null ? new JSONObject(map) : new JSONObject();
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("width", viewFindViewById.getWidth());
                        jSONObject2.put("height", viewFindViewById.getHeight());
                        jSONObject2.put("alpha", viewFindViewById.getAlpha());
                        jSONObject.put("root_view", jSONObject2.toString());
                        EV.this.IlO(jSONObject);
                    } catch (Throwable th) {
                        oeT.IlO("TTAD.RFReportManager", "run: ", th);
                    }
                    com.bytedance.sdk.openadsdk.tV.EO.IlO(oet, EV.this.IlO.Cc, jSONObject);
                    EV.this.IlO.ssS.vCE();
                    if (EV.this.IlO.tl != null && (map2 = map) != null && map2.containsKey("dynamic_show_type")) {
                        z2 = true;
                    }
                    Cc.IlO ilO = new Cc.IlO(z2 ? EV.this.IlO.tl.DmF() : -1);
                    EV.this.IlO(ilO);
                    com.bytedance.sdk.openadsdk.kBB.MY.Cc.IlO(EV.this.IlO.BS.findViewById(R.id.content), oet, ilO);
                    com.bytedance.sdk.openadsdk.kBB.IlO.EO.IlO(oet);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(Cc.IlO ilO) {
        com.bytedance.sdk.openadsdk.activity.vCE vce;
        IlO ilO2 = this.IlO;
        if (!ilO2.BO || (vce = ilO2.ED) == null) {
            return;
        }
        ilO.MY = vce.NV;
    }

    private void MY(View view, float f4, float f8, float f9, float f10, SparseArray<EO.IlO> sparseArray, int i2, int i8, int i9) {
        if (!lEW() || this.IlO.MY == null || view == null) {
            return;
        }
        int id = view.getId();
        if (id == com.bytedance.sdk.openadsdk.utils.zPa.Cc || id == com.bytedance.sdk.openadsdk.utils.zPa.tV || id == com.bytedance.sdk.openadsdk.utils.zPa.EO || id == com.bytedance.sdk.openadsdk.utils.zPa.MY || id == com.bytedance.sdk.openadsdk.utils.zPa.rp || id == com.bytedance.sdk.openadsdk.utils.zPa.cJK || id == com.bytedance.sdk.openadsdk.utils.zPa.cl || id == 520093705 || id == com.bytedance.sdk.openadsdk.utils.zPa.EV || id == 520093707 || id == com.bytedance.sdk.openadsdk.utils.zPa.Bc) {
            int iDmF = BS.DmF(com.bytedance.sdk.openadsdk.core.cl.IlO());
            com.bytedance.sdk.openadsdk.core.model.NV nvIlO = new NV.IlO().vCE(f4).Cc(f8).tV(f9).EO(f10).MY(System.currentTimeMillis()).IlO(0L).MY(BS.IlO(this.IlO.DM.EV())).IlO(BS.IlO((View) null)).EO(BS.EO(this.IlO.DM.EV())).tV(BS.EO((View) null)).tV(i8).Cc(i9).vCE(i2).IlO(sparseArray).MY(com.bytedance.sdk.openadsdk.core.DmF.MY().IlO() ? 1 : 2).EO(iDmF).IlO(BS.Bc(com.bytedance.sdk.openadsdk.core.cl.IlO())).MY(BS.lEW(com.bytedance.sdk.openadsdk.core.cl.IlO())).IlO();
            HashMap map = new HashMap();
            map.put("duration", Long.valueOf(this.IlO.vAh.EV()));
            IlO ilO = this.IlO;
            com.bytedance.sdk.openadsdk.tV.EO.IlO("click_other", ilO.MY, nvIlO, ilO.Cc, true, (Map<String, Object>) map, -1);
        }
    }

    public void IlO(boolean z2) {
        com.bytedance.sdk.openadsdk.core.model.oeT oet = this.IlO.MY;
        if (oet == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.ea.IlO.tV tVVarCc = com.bytedance.sdk.openadsdk.ea.IlO.tV.MY().IlO(z2 ? 7 : 8).EO(String.valueOf(oet.hFV())).Cc(this.IlO.MY.JAC());
        tVVarCc.MY(this.IlO.lMM.vAh()).vCE(this.IlO.lMM.kBB());
        tVVarCc.Bc(this.IlO.MY.KT()).tV(this.IlO.MY.ED());
        com.bytedance.sdk.openadsdk.ea.EO.IlO().MY(tVVarCc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(View view, float f4, float f8, float f9, float f10, SparseArray<EO.IlO> sparseArray, int i2, int i8, int i9) {
        if (view == null) {
            return;
        }
        if (view.getId() == com.bytedance.sdk.openadsdk.utils.zPa.Cc) {
            IlO("click_play_star_level", (JSONObject) null);
        } else if (view.getId() != com.bytedance.sdk.openadsdk.utils.zPa.tV && view.getId() != com.bytedance.sdk.openadsdk.utils.zPa.Bc) {
            if (view.getId() == com.bytedance.sdk.openadsdk.utils.zPa.EO) {
                IlO("click_play_source", (JSONObject) null);
            } else if (view.getId() == com.bytedance.sdk.openadsdk.utils.zPa.MY) {
                IlO("click_play_logo", (JSONObject) null);
            } else if (view.getId() != com.bytedance.sdk.openadsdk.utils.zPa.rp && view.getId() != com.bytedance.sdk.openadsdk.utils.zPa.cJK && view.getId() != com.bytedance.sdk.openadsdk.utils.zPa.cl) {
                if (view.getId() == 520093705) {
                    IlO("click_start_play", DmF());
                } else if (view.getId() == com.bytedance.sdk.openadsdk.utils.zPa.EV) {
                    IlO("click_video", DmF());
                } else if (view.getId() == 520093707 || view.getId() == com.bytedance.sdk.openadsdk.utils.zPa.lEW) {
                    IlO("fallback_endcard_click", DmF());
                }
            } else {
                IlO("click_start_play_bar", DmF());
            }
        } else {
            IlO("click_play_star_nums", (JSONObject) null);
        }
        MY(view, f4, f8, f9, f10, sparseArray, i2, i8, i9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(String str, JSONObject jSONObject) {
        IlO ilO = this.IlO;
        com.bytedance.sdk.openadsdk.core.model.oeT oet = ilO.MY;
        String str2 = ilO.Cc;
        if (!ilO.tV) {
            jSONObject = null;
        }
        com.bytedance.sdk.openadsdk.tV.EO.IlO(oet, str2, str, jSONObject);
    }

    public com.bytedance.sdk.openadsdk.core.MY.Cc IlO(final IlO ilO, final com.bytedance.sdk.openadsdk.core.model.oeT oet) {
        return new com.bytedance.sdk.openadsdk.core.MY.Cc(ilO.BS, oet, ilO.Cc, ilO.tV ? 7 : 5) { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.EV.4
            @Override // com.bytedance.sdk.openadsdk.core.MY.Cc
            public void IlO(View view, float f4, float f8, float f9, float f10, SparseArray<EO.IlO> sparseArray, int i2, int i8, int i9, boolean z2) {
                if (oet.xJ() && view != null) {
                    Object tag = view.getTag(570425345);
                    if (tag instanceof String) {
                        IlO((String) tag);
                    }
                }
                HashMap map = new HashMap();
                map.put("duration", Long.valueOf(ilO.vAh.EV()));
                if (ilO.NV.get()) {
                    map.put("click_scence", 2);
                } else if (OOq.cL(oet)) {
                    map.put("click_scence", 3);
                } else {
                    map.put("click_scence", 1);
                }
                IlO(map);
                ilO.ssS.c_();
                if (view.getId() == com.bytedance.sdk.openadsdk.utils.zPa.DYs && OOq.cL(oet)) {
                    JSONObject jSONObject = new JSONObject();
                    if (oet.fdM() != null) {
                        try {
                            jSONObject.put("playable_url", oet.fdM().h);
                        } catch (JSONException e) {
                            oeT.IlO("TTAD.RFReportManager", "onRewardBarClick json error", e);
                        }
                    }
                    com.bytedance.sdk.openadsdk.tV.EO.MY(oet, ilO.Cc, "click_playable_download_button_loading", jSONObject);
                }
                ilO.kBB.IlO(view, f4, f8, f9, f10, sparseArray, i2, i8, i9, new tV.IlO() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.EV.4.1
                    @Override // com.bytedance.sdk.openadsdk.component.reward.IlO.tV.IlO
                    public void IlO(String str, JSONObject jSONObject2) {
                        EV.this.IlO(str, jSONObject2);
                    }

                    @Override // com.bytedance.sdk.openadsdk.component.reward.IlO.tV.IlO
                    public void IlO(View view2, float f11, float f12, float f13, float f14, SparseArray<EO.IlO> sparseArray2, int i10, int i11, int i12) {
                        EV.this.IlO(view2, f11, f12, f13, f14, sparseArray2, i10, i11, i12);
                    }
                });
                com.bytedance.sdk.openadsdk.kBB.MY.Cc.IlO(oet, 9);
                ilO.vAh.BS();
            }
        };
    }
}
