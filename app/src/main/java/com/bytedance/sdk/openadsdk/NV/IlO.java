package com.bytedance.sdk.openadsdk.NV;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.es.IlO.IlO.Bc;
import com.bytedance.sdk.openadsdk.es.IlO.IlO.vCE;
import com.bytedance.sdk.openadsdk.utils.zLG;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO implements EO {
    private final Map<String, vCE> EO = new HashMap();
    private final oeT IlO;
    private final MY MY;

    private IlO(MY my, oeT oet) {
        this.MY = my;
        this.IlO = oet;
    }

    public static IlO IlO(MY my, oeT oet) {
        return new IlO(my, oet);
    }

    @Override // com.bytedance.sdk.openadsdk.NV.EO
    public void IlO() {
        this.EO.clear();
    }

    private oeT IlO(JSONObject jSONObject, String str) {
        String strIlO;
        if (jSONObject == null) {
            return null;
        }
        oeT oetLEW = oeT.lEW();
        oetLEW.Cc(jSONObject);
        if (!TextUtils.isEmpty(str)) {
            oetLEW.xF(str);
        }
        if (this.IlO != null) {
            String strIlO2 = oetLEW.VH() != null ? oetLEW.VH().IlO() : null;
            if (TextUtils.isEmpty(strIlO2)) {
                return this.IlO;
            }
            com.bytedance.sdk.openadsdk.core.model.tV tVVarVH = this.IlO.VH();
            if (tVVarVH != null && strIlO2.equals(tVVarVH.IlO())) {
                return this.IlO;
            }
            JSONObject jSONObject2 = new JSONObject();
            if (tVVarVH != null) {
                try {
                    strIlO = tVVarVH.IlO();
                } catch (JSONException unused) {
                }
            } else {
                strIlO = "null";
            }
            jSONObject2.put("lu", strIlO);
            jSONObject2.put("ju", strIlO2);
            oeT oet = this.IlO;
            com.bytedance.sdk.openadsdk.core.tV.IlO(oet, zLG.IlO(oet), -5, jSONObject2);
            if (tVVarVH != null && strIlO2.contains("play.google.com/store") && !strIlO2.contains("referrer")) {
                oetLEW.VH().IlO(tVVarVH.IlO());
            }
        }
        return oetLEW;
    }

    @Override // com.bytedance.sdk.openadsdk.NV.EO
    public void IlO(Context context, JSONObject jSONObject, String str, int i2, boolean z2) {
        JSONObject jSONObjectOptJSONObject;
        if (context == null || jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        IlO(context, IlO(jSONObjectOptJSONObject, str), jSONObjectOptJSONObject, i2, z2);
    }

    private void IlO(Context context, oeT oet, JSONObject jSONObject, int i2, boolean z2) {
        if (context != null && oet != null && oet.VH() != null && jSONObject != null && this.MY != null && this.EO.get(oet.VH().IlO()) == null) {
            String strMY = zLG.MY(i2);
            if (!TextUtils.isEmpty(strMY)) {
                this.EO.put(oet.VH().IlO(), IlO(context, oet, jSONObject, strMY, z2));
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.NV.EO
    public void IlO(Context context, JSONObject jSONObject, String str) {
        oeT oet;
        if (context == null || (oet = this.IlO) == null) {
            return;
        }
        Bc.IlO(context, oet, str).tV();
    }

    @Override // com.bytedance.sdk.openadsdk.NV.EO
    public void IlO(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        IlO(IlO(jSONObjectOptJSONObject, (String) null), jSONObjectOptJSONObject);
    }

    private void IlO(oeT oet, JSONObject jSONObject) {
        if (this.MY == null || oet == null || oet.VH() == null) {
            return;
        }
        String strIlO = oet.VH().IlO();
        if (this.EO.containsKey(strIlO)) {
            this.EO.remove(strIlO);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("message", "success");
                jSONObject2.put("status", "unsubscribed");
                jSONObject2.put("appad", jSONObject);
                this.MY.IlO("app_ad_event", jSONObject2);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.oeT.EO("JsAppAdDownloadManager", e.getMessage());
            }
        }
    }

    private vCE IlO(@NonNull Context context, @NonNull oeT oet, @NonNull JSONObject jSONObject, @NonNull String str, boolean z2) {
        vCE vceIlO = Bc.IlO(context, oet, str);
        vceIlO.IlO(true);
        return vceIlO;
    }
}
