package com.bytedance.adsdk.ugeno;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.adsdk.ugeno.Bc.lEW;
import com.bytedance.adsdk.ugeno.core.NV;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class EO extends com.bytedance.adsdk.ugeno.MY.IlO<com.bytedance.adsdk.ugeno.vCE.MY> {
    private float Aw;
    private com.bytedance.adsdk.ugeno.MY.EO BC;
    private boolean BES;
    private JSONArray IRy;
    private boolean La;
    private boolean NST;
    private float Os;
    private float QfH;
    private float XvI;
    private int aP;
    private int ao;
    private String eDn;
    private String eeU;
    private float uF;
    private float xJ;

    public EO(Context context) {
        super(context);
        this.BES = true;
        this.La = true;
        this.Aw = 0.0f;
        this.uF = 2000.0f;
        this.eDn = "normal";
        this.NST = true;
        this.aP = Color.parseColor("#666666");
        this.ao = Color.parseColor("#ffffff");
    }

    @Override // com.bytedance.adsdk.ugeno.MY.EO
    public void IlO(JSONObject jSONObject) {
    }

    @Override // com.bytedance.adsdk.ugeno.MY.IlO, com.bytedance.adsdk.ugeno.MY.EO
    public void MY() {
        super.MY();
        JSONArray jSONArray = this.IRy;
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        ((com.bytedance.adsdk.ugeno.vCE.MY) this.Cc).Bc((int) this.xJ).lEW((int) this.QfH).DmF((int) this.Os).EO(this.NST).Cc(this.ao).vCE(this.aP).EO(this.eDn).tV(this.BES).Cc(this.XvI).IlO(this.La).tV((int) this.uF).EO(this.NST);
        for (int i2 = 0; i2 < this.IRy.length(); i2++) {
            NV nv = new NV(this.MY);
            nv.IlO(this.cJK);
            com.bytedance.adsdk.ugeno.MY.EO<View> eoMY = nv.MY(this.BC.wPn(), null);
            nv.MY(this.IRy.optJSONObject(i2));
            ((com.bytedance.adsdk.ugeno.vCE.MY) this.Cc).IlO(eoMY);
        }
        if (this.La) {
            ((com.bytedance.adsdk.ugeno.vCE.MY) this.Cc).EO();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.MY.EO
    public View IlO() {
        com.bytedance.adsdk.ugeno.vCE.MY my = new com.bytedance.adsdk.ugeno.vCE.MY(this.MY);
        this.Cc = my;
        my.IlO((tV) this);
        return this.Cc;
    }

    public void IlO(com.bytedance.adsdk.ugeno.vCE.EO eo) {
        T t3 = this.Cc;
        if (t3 != 0) {
            ((com.bytedance.adsdk.ugeno.vCE.MY) t3).setOnPageChangeListener(eo);
        }
    }

    public void IlO(int i2) {
        T t3 = this.Cc;
        if (t3 != 0) {
            ((com.bytedance.adsdk.ugeno.vCE.MY) t3).hp(i2);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.MY.IlO
    public void IlO(com.bytedance.adsdk.ugeno.MY.EO eo) {
        this.BC = eo;
    }

    @Override // com.bytedance.adsdk.ugeno.MY.EO
    public void IlO(String str, String str2) {
        super.IlO(str, str2);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        str.getClass();
        switch (str) {
            case "delayStart":
                this.Aw = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 0.0f);
                break;
            case "indicatorColor":
                this.aP = com.bytedance.adsdk.ugeno.Bc.IlO.IlO(str2);
                break;
            case "nextMargin":
                this.Os = lEW.IlO(this.MY, com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 0.0f));
                break;
            case "effect":
                this.eDn = str2;
                break;
            case "direction":
                this.eeU = str2;
                break;
            case "indicator":
                this.NST = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, true);
                break;
            case "previousMargin":
                this.QfH = lEW.IlO(this.MY, com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 0.0f));
                break;
            case "loop":
                this.BES = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, true);
                break;
            case "speed":
                this.uF = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 500.0f);
                break;
            case "pageCount":
                this.XvI = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 1.0f);
                break;
            case "pageMargin":
                this.xJ = lEW.IlO(this.MY, com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 0.0f));
                break;
            case "indicatorSelectedColor":
                this.ao = com.bytedance.adsdk.ugeno.Bc.IlO.IlO(str2);
                break;
            case "autoplay":
                this.La = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, true);
                break;
            case "dataList":
                this.IRy = com.bytedance.adsdk.ugeno.Bc.MY.IlO(str2, (JSONArray) null);
                break;
        }
    }
}
