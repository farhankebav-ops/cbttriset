package com.bytedance.sdk.openadsdk.component.reward.MY;

import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.MY.bWL;
import com.bytedance.sdk.openadsdk.component.reward.IlO.Cc;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.model.vAh;
import com.bytedance.sdk.openadsdk.core.vSq;
import com.bytedance.sdk.openadsdk.utils.mmj;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE extends MY implements com.bytedance.sdk.openadsdk.rp.lEW {
    private final vAh ea;
    private boolean zPa;

    public vCE(com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO) {
        super(ilO);
        this.ea = (vAh) ilO.MY;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.MY.MY
    public boolean Cc() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.MY.MY
    public void IlO(FrameLayout frameLayout) {
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.MY.IlO
    public boolean MY() {
        return this.zPa;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.MY.MY
    public void tl() {
        vSq jsObject;
        if (this.IlO.BS.isFinishing()) {
            return;
        }
        if (this.IlO.tl.lEW() || this.zPa) {
            super.tl();
            if (this.IlO.tl.lEW()) {
                OOq();
                this.IlO.mmj.MY();
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.component.reward.view.MY myIlO = this.IlO.tl.IlO();
        if (myIlO == null || (jsObject = myIlO.getJsObject()) == null) {
            return;
        }
        jsObject.IlO((com.bytedance.sdk.openadsdk.rp.lEW) this);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.MY.MY
    public boolean vCE() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.MY.MY
    public boolean wPn() {
        return false;
    }

    public static void IlO(oeT oet, boolean z2, String str) {
        HashMap map = new HashMap();
        map.put("is_backup", Boolean.valueOf(z2));
        com.bytedance.sdk.openadsdk.tV.EO.IlO("choose_ad_start_show", oet, str, map);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("req_id", oet.JAC());
            jSONObject.put("is_backup", z2);
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.openadsdk.ea.EO.IlO().IlO("choose_ad_start_show", jSONObject);
    }

    public void MY(boolean z2) {
        if (this.zPa) {
            return;
        }
        HashMap map = new HashMap();
        map.put("has_focus", Boolean.valueOf(z2));
        com.bytedance.sdk.openadsdk.tV.EO.IlO("choose_ad_focus_changed", this.ea, this.IlO.Cc, map);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.MY.MY
    public void IlO(com.bytedance.sdk.openadsdk.component.reward.view.Bc bc) {
        if (tV.IlO(this.ea)) {
            tV.IlO(this.ea, bc, this.IlO);
        } else {
            super.IlO(bc);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.rp.lEW
    public void IlO(int i2, long j) {
        this.zPa = true;
        int i8 = i2 - 1;
        this.ea.fdM(i8);
        com.bytedance.sdk.openadsdk.tV.EO.IlO(this.ea, this.IlO.Cc, i2, j);
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO(this.ea.iuH(), i8, this.IlO.tV);
        mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.MY.vCE.1
            @Override // java.lang.Runnable
            public void run() {
                vCE.this.tl();
                vCE vce = vCE.this;
                com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = vce.IlO;
                if (ilO.AK) {
                    vce.OOq();
                    vCE.this.IlO.mmj.MY();
                } else {
                    Cc.IlO ilOVCE = ilO.mmj.vCE();
                    if (ilOVCE != null) {
                        ilOVCE.zPa();
                    }
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.rp.Bc
    public void IlO(bWL bwl) {
        this.IlO.tl.IlO().MY(bwl);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.MY.MY
    public void Bc() {
    }
}
