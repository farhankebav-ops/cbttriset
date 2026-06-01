package com.bytedance.sdk.openadsdk.core.lEW;

import com.bytedance.sdk.openadsdk.utils.mmj;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class hp implements com.bytedance.adsdk.ugeno.core.zPa, com.bytedance.sdk.component.adexpress.MY.DmF {
    private long Cc;
    private final com.bytedance.sdk.openadsdk.core.model.oeT EO;
    private final com.bytedance.sdk.openadsdk.tV.tV.Cc IlO;
    private final String MY;
    private final String tV;

    public hp(com.bytedance.sdk.openadsdk.tV.tV.Cc cc, String str, com.bytedance.sdk.openadsdk.core.model.oeT oet, String str2) {
        this.IlO = cc;
        this.MY = str;
        this.tV = str2;
        this.EO = oet;
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.DmF
    public void Bc() {
        this.IlO.IlO(true);
        this.IlO.hp();
        mmj.MY(new com.bytedance.sdk.component.lEW.lEW("native_success") { // from class: com.bytedance.sdk.openadsdk.core.lEW.hp.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.tV.EO.MY(hp.this.EO, hp.this.MY, "dynamic_backup_render", (JSONObject) null);
            }
        }, 10);
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.DmF
    public void Cc() {
        this.IlO.MY();
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.DmF
    public void DmF() {
        this.IlO.ea();
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.DmF
    public void EO(int i2) {
        if (i2 == 3) {
            this.IlO.tV("dynamic_sub_analysis2_end");
        } else {
            this.IlO.tV("dynamic_sub_analysis_end");
        }
    }

    public void EV() {
        this.IlO.EV();
        this.IlO.rp();
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.DmF
    public void NV() {
        this.IlO.MY();
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.DmF
    public void lEW() {
        this.IlO.bWL();
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.DmF
    public void tV() {
        this.IlO.IlO();
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.DmF
    public void vCE(int i2) {
        final String str;
        System.currentTimeMillis();
        if (i2 == 3) {
            this.IlO.Bc("dynamic_render2_success");
            str = "dynamic2_render";
        } else {
            this.IlO.Bc("dynamic_render_success");
            str = "dynamic_backup_native_render";
        }
        this.IlO.IlO(true);
        mmj.MY(new com.bytedance.sdk.component.lEW.lEW("dynamic_success") { // from class: com.bytedance.sdk.openadsdk.core.lEW.hp.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.tV.EO.MY(hp.this.EO, hp.this.MY, str, (JSONObject) null);
            }
        }, 10);
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.DmF
    public void Cc(int i2) {
        if (i2 == 3) {
            this.IlO.tV("dynamic_sub_render2_end");
        } else {
            this.IlO.tV("dynamic_sub_render_end");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.DmF
    public void IlO(boolean z2) {
        this.IlO.IlO(z2 ? 1 : 0);
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.DmF
    public void MY(int i2) {
        if (i2 == 3) {
            this.IlO.tV("dynamic_sub_analysis2_start");
        } else {
            this.IlO.tV("dynamic_sub_analysis_start");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.DmF
    public void tV(int i2) {
        if (i2 == 3) {
            this.IlO.tV("dynamic_sub_render2_start");
        } else {
            this.IlO.tV("dynamic_sub_render_start");
        }
    }

    @Override // com.bytedance.adsdk.ugeno.core.zPa
    public void EO() {
        this.IlO.Cc("ugen_sub_render_start");
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.DmF
    public void IlO(int i2, String str) {
        this.IlO.IlO(i2, str);
        EV.IlO("Web", i2, str, this.MY, this.tV, this.EO);
    }

    @Override // com.bytedance.adsdk.ugeno.core.zPa
    public void MY() {
        this.IlO.Cc("ugen_sub_analysis_end");
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.DmF
    public void IlO(int i2) {
        this.Cc = System.currentTimeMillis();
        if (i2 == 3) {
            this.IlO.EO("dynamic_render2_start");
        } else {
            this.IlO.EO("dynamic_render_start");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.DmF
    public void vCE() {
        this.IlO.EO();
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.DmF
    public void IlO(int i2, int i8, String str, boolean z2) {
        if (!z2) {
            this.IlO.IlO(true);
        }
        if (i2 == 3) {
            this.IlO.MY(i8, "dynamic_render2_error");
        } else {
            this.IlO.MY(i8, "dynamic_render_error");
        }
        EV.IlO("NDR", i8, str, this.MY, this.tV, this.EO);
    }

    @Override // com.bytedance.adsdk.ugeno.core.zPa
    public void IlO() {
        this.IlO.Cc("ugen_render_start");
        this.IlO.Cc("ugen_sub_analysis_start");
    }

    @Override // com.bytedance.adsdk.ugeno.core.zPa
    public void IlO(com.bytedance.adsdk.ugeno.core.ea eaVar) {
        if (eaVar.IlO() == 0) {
            this.IlO.Cc("ugen_sub_render_end");
            this.IlO.vCE("ugen_render_success");
        } else {
            this.IlO.EO(eaVar.IlO(), "ugen_render_error");
            EV.IlO("UGen", eaVar.IlO(), eaVar.MY(), this.MY, this.tV, this.EO);
        }
        this.IlO.IlO(true);
    }
}
