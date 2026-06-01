package com.bytedance.sdk.openadsdk.component.reward.IlO;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.MY.EO;
import com.bytedance.sdk.openadsdk.core.MY.MY;
import com.bytedance.sdk.openadsdk.core.model.OOq;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.utils.zLG;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE {
    private final IlO IlO;

    public vCE(IlO ilO) {
        this.IlO = ilO;
    }

    public void IlO(float[] fArr, final com.bytedance.sdk.openadsdk.core.rp.tV.MY my, final com.bytedance.sdk.openadsdk.component.reward.MY.MY my2) {
        com.bytedance.sdk.openadsdk.activity.vCE vce;
        com.bytedance.sdk.openadsdk.component.reward.view.lEW lew;
        Arrays.toString(fArr);
        AdSlot adSlotBuild = new AdSlot.Builder().setCodeId(String.valueOf(this.IlO.MY.hFV())).setExpressViewAcceptedSize(fArr[0], fArr[1]).build();
        IlO ilO = this.IlO;
        ilO.tl.IlO(adSlotBuild, ilO.DM.ea);
        IlO ilO2 = this.IlO;
        bWL bwl = ilO2.YA;
        if (bwl != null && (lew = ilO2.tl) != null) {
            bwl.IlO(lew.IlO());
        }
        this.IlO.tl.IlO(new com.bytedance.sdk.openadsdk.core.lEW.bWL() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.vCE.1
            @Override // com.bytedance.sdk.openadsdk.core.lEW.bWL
            public int Cc() {
                if (vCE.this.IlO.tl.EO()) {
                    return 4;
                }
                if (vCE.this.IlO.tl.tV()) {
                    return 5;
                }
                if (vCE.this.IlO.vAh.DmF()) {
                    return 1;
                }
                if (vCE.this.IlO.vAh.vCE()) {
                    return 2;
                }
                vCE.this.IlO.vAh.lEW();
                return 3;
            }

            @Override // com.bytedance.sdk.openadsdk.core.lEW.bWL
            public long EO() {
                return vCE.this.IlO.vAh.rp();
            }

            @Override // com.bytedance.sdk.openadsdk.core.lEW.bWL
            public void IlO(boolean z2, String str) {
                if (vCE.this.IlO.uvo != z2) {
                    vCE.this.IlO.YA.IlO(str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.lEW.bWL
            public void MY() {
                if (vCE.this.IlO.DM == null || vCE.this.IlO.DM.NV() == null) {
                    return;
                }
                vCE.this.IlO.DM.NV().performClick();
            }

            @Override // com.bytedance.sdk.openadsdk.core.lEW.bWL
            public long tV() {
                return vCE.this.IlO.vAh.IlO();
            }

            @Override // com.bytedance.sdk.openadsdk.core.lEW.bWL
            public void vCE() {
                vCE.this.IlO.vSq.IlO(my2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.lEW.bWL
            public void IlO() {
                vCE.this.IlO.YA.tV();
            }

            @Override // com.bytedance.sdk.openadsdk.core.lEW.bWL
            public void MY(int i2) {
                vCE.this.IlO.Ea = i2;
            }

            @Override // com.bytedance.sdk.openadsdk.core.lEW.bWL
            public void IlO(String str, JSONObject jSONObject) {
                if (vCE.this.IlO == null || vCE.this.IlO.ssS == null) {
                    return;
                }
                vCE.this.IlO.ssS.IlO(str, jSONObject);
            }

            @Override // com.bytedance.sdk.openadsdk.core.lEW.bWL
            public boolean IlO(JSONObject jSONObject) {
                if (vCE.this.IlO == null || vCE.this.IlO.vAh == null) {
                    return false;
                }
                return vCE.this.IlO.vAh.IlO(jSONObject);
            }

            @Override // com.bytedance.sdk.openadsdk.core.lEW.bWL
            public void IlO(int i2) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        vCE.this.IlO.vAh.lMM();
                        return;
                    }
                    if (i2 == 3) {
                        vCE.this.IlO.vAh.IlO(my);
                        return;
                    } else if (i2 == 4) {
                        vCE.this.IlO.vAh.cl();
                        return;
                    } else if (i2 != 5) {
                        return;
                    }
                }
                if (vCE.this.IlO.vAh.vCE() || vCE.this.IlO.vAh.lEW()) {
                    return;
                }
                my.IlO(0L, false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.lEW.bWL
            public void IlO(int i2, String str) {
                vCE.this.IlO.vAh.IlO(i2, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.lEW.bWL
            public void IlO(int i2, com.bytedance.sdk.component.adexpress.MY.bWL bwl2) {
                vCE.this.IlO.DM.IlO(i2, bwl2);
            }
        });
        this.IlO.tl.IlO(new PAGExpressAdWrapperListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.vCE.2
            @Override // com.bytedance.sdk.openadsdk.api.PAGAdWrapperListener
            public void onAdClicked() {
                if (vCE.this.IlO == null || vCE.this.IlO.MY == null || !vCE.this.IlO.MY.Os()) {
                    return;
                }
                my.c_();
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
            public void onRenderFail(View view, String str, int i2) {
                if (!vCE.this.IlO.MY.pS()) {
                    vCE.this.IlO.lMM.IlO(true);
                    vCE.this.IlO.lMM.Cc();
                }
                vCE.this.IlO.tl.Cc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.vCE.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        my2.IlO(false, false, false, 90);
                    }
                });
                vCE.this.IlO.DM.hp();
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
            public void onRenderSuccess(View view, float f4, float f8) {
                com.bytedance.sdk.openadsdk.core.model.es esVar;
                if (OOq.cL(vCE.this.IlO.MY)) {
                    return;
                }
                if (!vCE.this.IlO.MY.pS()) {
                    if (vCE.this.IlO.tl.lEW()) {
                        my2.IlO(true);
                        vCE.this.IlO.vAh.EO(false);
                    } else {
                        vCE.this.IlO.vAh.EO(true);
                    }
                    vCE.this.IlO.DM.IlO(8);
                    vCE.this.IlO.lMM.IlO(true);
                    vCE.this.IlO.lMM.Cc();
                    if (vCE.this.IlO.tl.lEW()) {
                        vCE.this.IlO.tl.MY().setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                        my2.IlO(vCE.this.IlO.DM.vCE());
                    } else if (vCE.this.IlO.MY.fdM() != null && my2.IlO()) {
                        vCE.this.IlO.Dxv = true;
                    }
                }
                my2.tl();
                if (com.bytedance.sdk.openadsdk.core.model.es.EO(vCE.this.IlO.MY) && (esVar = vCE.this.IlO.DM.ea) != null) {
                    esVar.EO();
                }
                if (my2 instanceof com.bytedance.sdk.openadsdk.component.reward.MY.vCE) {
                    com.bytedance.sdk.openadsdk.component.reward.MY.vCE.IlO(vCE.this.IlO.MY, vCE.this.IlO.tl.lEW(), vCE.this.IlO.Cc);
                    if (!vCE.this.IlO.tl.lEW()) {
                        vCE.this.IlO.ssS.vCE();
                    }
                }
                vCE.this.IlO.DM.hp();
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
            public void onAdDismissed() {
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
            public void onAdShow(View view, int i2) {
            }
        });
        IlO ilO3 = this.IlO;
        Activity activity = ilO3.BS;
        oeT oet = ilO3.MY;
        String str = ilO3.Cc;
        com.bytedance.sdk.openadsdk.core.lEW.DmF dmF = new com.bytedance.sdk.openadsdk.core.lEW.DmF(activity, oet, str, zLG.IlO(str)) { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.vCE.3
            @Override // com.bytedance.sdk.openadsdk.core.MY.MY, com.bytedance.sdk.openadsdk.core.MY.EO
            public void IlO(View view, float f4, float f8, float f9, float f10, SparseArray<EO.IlO> sparseArray, boolean z2) {
                super.IlO(view, f4, f8, f9, f10, sparseArray, z2);
            }
        };
        dmF.IlO(new MY.IlO() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.vCE.4
            @Override // com.bytedance.sdk.openadsdk.core.MY.MY.IlO
            public void IlO(View view, int i2) {
                my.c_();
            }
        });
        HashMap map = new HashMap();
        if (OOq.cL(this.IlO.MY)) {
            map.put("click_scence", 3);
        } else {
            map.put("click_scence", 1);
        }
        IlO ilO4 = this.IlO;
        if (ilO4.BO && (vce = ilO4.ED) != null) {
            int i2 = vce.NV + 1;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ad_show_order", i2);
                map.put("pag_json_data", jSONObject.toString());
            } catch (Throwable unused) {
            }
        }
        dmF.IlO(map);
        IlO ilO5 = this.IlO;
        Activity activity2 = ilO5.BS;
        oeT oet2 = ilO5.MY;
        String str2 = ilO5.Cc;
        com.bytedance.sdk.openadsdk.core.lEW.lEW lew2 = new com.bytedance.sdk.openadsdk.core.lEW.lEW(activity2, oet2, str2, zLG.IlO(str2)) { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.vCE.5
            @Override // com.bytedance.sdk.openadsdk.core.MY.IlO, com.bytedance.sdk.openadsdk.core.MY.MY, com.bytedance.sdk.openadsdk.core.MY.EO
            public void IlO(View view, float f4, float f8, float f9, float f10, SparseArray<EO.IlO> sparseArray, boolean z2) {
                HashMap map2 = new HashMap();
                map2.put("duration", Long.valueOf(vCE.this.IlO.vAh.EV()));
                IlO(map2);
                super.IlO(view, f4, f8, f9, f10, sparseArray, z2);
            }
        };
        lew2.IlO(new MY.IlO() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.vCE.6
            @Override // com.bytedance.sdk.openadsdk.core.MY.MY.IlO
            public void IlO(View view, int i8) {
                my.c_();
            }
        });
        HashMap map2 = new HashMap();
        if (OOq.cL(this.IlO.MY)) {
            map2.put("click_scence", 3);
        } else {
            map2.put("click_scence", 1);
        }
        lew2.IlO(map2);
        this.IlO.tl.IlO(dmF, lew2);
        FrameLayout.LayoutParams layoutParams = (this.IlO.MY.pS() || com.bytedance.sdk.openadsdk.core.NV.tV.IlO(this.IlO.MY.nvX()) || com.bytedance.sdk.openadsdk.core.model.es.EO(this.IlO.MY)) ? new FrameLayout.LayoutParams(-1, -1) : new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.IlO.DM.vCE().addView(this.IlO.tl.IlO(), layoutParams);
        if (!this.IlO.tl.lEW()) {
            my2.IlO(false);
        }
        this.IlO.tl.EV();
    }
}
