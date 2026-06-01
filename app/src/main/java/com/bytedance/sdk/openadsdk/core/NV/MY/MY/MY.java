package com.bytedance.sdk.openadsdk.core.NV.MY.MY;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.MY.EO;
import com.bytedance.adsdk.ugeno.core.NV;
import com.bytedance.adsdk.ugeno.tV;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY extends com.bytedance.adsdk.ugeno.MY.IlO<IlO> {
    private JSONArray BES;
    private int La;
    private int eeU;

    public MY(Context context) {
        super(context);
        this.eeU = 0;
        this.La = 0;
    }

    private void EO() {
        List<EO<View>> list = ((com.bytedance.adsdk.ugeno.MY.IlO) this).IlO;
        if (list == null || list.isEmpty()) {
            return;
        }
        EO<View> eo = ((com.bytedance.adsdk.ugeno.MY.IlO) this).IlO.get(0);
        if (this.BES == null) {
            return;
        }
        for (int i2 = 0; i2 < this.BES.length(); i2++) {
            NV nv = new NV(this.MY);
            nv.IlO(this.cJK);
            try {
                JSONObject jSONObjectOptJSONObject = this.BES.optJSONObject(i2);
                if (jSONObjectOptJSONObject != null) {
                    if (jSONObjectOptJSONObject.has("$chunk")) {
                        this.tV.put("$item", jSONObjectOptJSONObject.optJSONArray("$chunk"));
                    } else {
                        this.tV.put("$item", jSONObjectOptJSONObject);
                    }
                    ((IlO) this.Cc).IlO(nv.IlO(eo.wPn(), this.tV, (JSONObject) null));
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void tV() {
        for (int i2 = 0; i2 < ((com.bytedance.adsdk.ugeno.MY.IlO) this).IlO.size(); i2++) {
            EO<View> eo = ((com.bytedance.adsdk.ugeno.MY.IlO) this).IlO.get(i2);
            if (eo != null) {
                NV nv = new NV(this.MY);
                nv.IlO(this.cJK);
                ((IlO) this.Cc).IlO(nv.IlO(eo.wPn(), this.tV, (JSONObject) null));
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T extends android.view.View, android.view.View] */
    @Override // com.bytedance.adsdk.ugeno.MY.EO
    public View IlO() {
        try {
            IlO ilO = new IlO(this.MY);
            this.Cc = ilO;
            ilO.IlO((tV) this);
        } catch (Throwable unused) {
            this.Cc = new View(this.MY);
        }
        return this.Cc;
    }

    @Override // com.bytedance.adsdk.ugeno.MY.IlO, com.bytedance.adsdk.ugeno.MY.EO
    public void MY() {
        super.MY();
        T t3 = this.Cc;
        if (t3 instanceof IlO) {
            ((IlO) t3).setOrientation(this.eeU);
            ((IlO) this.Cc).IlO(this);
            if (this.La == 1) {
                tV();
            } else {
                EO();
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.MY.EO
    public void IlO(String str, String str2) {
        super.IlO(str, str2);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        str.getClass();
        switch (str) {
            case "driveMode":
                this.La = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 0);
                break;
            case "direction":
                if (TextUtils.equals(str2, "vertical")) {
                    this.eeU = 1;
                    break;
                } else {
                    this.eeU = 0;
                    break;
                }
                break;
            case "dataList":
                this.BES = com.bytedance.adsdk.ugeno.Bc.MY.IlO(str2, (JSONArray) null);
                break;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.MY.IlO
    public void IlO(EO eo) {
        if (eo == null) {
            return;
        }
        ((com.bytedance.adsdk.ugeno.MY.IlO) this).IlO.add(eo);
    }

    @Override // com.bytedance.adsdk.ugeno.MY.IlO
    public void IlO(EO eo, ViewGroup.LayoutParams layoutParams) {
        if (eo == null) {
            return;
        }
        ((com.bytedance.adsdk.ugeno.MY.IlO) this).IlO.add(eo);
    }
}
