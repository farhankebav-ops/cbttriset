package com.bytedance.sdk.openadsdk.core.NV.MY;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY extends com.bytedance.adsdk.ugeno.DmF.vCE.MY {
    private String BES;
    private String La;

    public MY(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.DmF.vCE.MY
    public void Bc(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "null")) {
            str = "";
        }
        if (TextUtils.isEmpty(this.La) || TextUtils.equals(this.La, "null")) {
            this.La = "";
        }
        if (TextUtils.isEmpty(this.BES) || TextUtils.equals(this.BES, "null")) {
            this.BES = "";
        }
        String str2 = this.BES + str + this.La;
        ((com.bytedance.adsdk.ugeno.DmF.vCE.MY) this).IlO = str2;
        ((com.bytedance.adsdk.ugeno.DmF.vCE.IlO) this.Cc).setText(str2);
        try {
            float f4 = this.lMM ? this.OOq : this.tl;
            float f8 = this.nvX ? this.wPn : this.tl;
            float fMeasureText = ((com.bytedance.adsdk.ugeno.DmF.vCE.IlO) this.Cc).getPaint().measureText(((com.bytedance.adsdk.ugeno.DmF.vCE.MY) this).IlO);
            if (fMeasureText >= 0.0f) {
                Cc((int) (f4 + fMeasureText + f8));
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.DmF.vCE.MY, com.bytedance.adsdk.ugeno.MY.EO
    public void IlO(String str, String str2) {
        super.IlO(str, str2);
        str.getClass();
        if (str.equals("before")) {
            this.BES = str2;
        } else if (str.equals("after")) {
            this.La = str2;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.DmF.vCE.MY, com.bytedance.adsdk.ugeno.MY.EO
    public void MY() {
        super.MY();
        if (TextUtils.isEmpty(this.La) || TextUtils.equals(this.La, "null")) {
            this.La = "";
        }
        if (TextUtils.isEmpty(this.BES) || TextUtils.equals(this.BES, "null")) {
            this.BES = "";
        }
        String str = this.BES + this.La;
        ((com.bytedance.adsdk.ugeno.DmF.vCE.MY) this).IlO = str;
        ((com.bytedance.adsdk.ugeno.DmF.vCE.IlO) this.Cc).setText(str);
        ((com.bytedance.adsdk.ugeno.DmF.vCE.IlO) this.Cc).setGravity(17);
    }
}
