package com.bytedance.sdk.openadsdk.tV.IlO;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class hp implements com.bytedance.sdk.openadsdk.ea.MY {
    private final com.bytedance.sdk.component.vCE.IlO.vCE.tV IlO;
    private final boolean MY;

    public hp(boolean z2, com.bytedance.sdk.component.vCE.IlO.vCE.tV tVVar) {
        this.IlO = tVVar;
        this.MY = z2;
    }

    @Override // com.bytedance.sdk.openadsdk.ea.MY
    @Nullable
    public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
        if (this.IlO == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", this.MY);
        jSONObject.put("url", this.IlO.MY());
        int iTV = this.IlO.tV();
        if (iTV <= 0) {
            iTV = 0;
        }
        jSONObject.put("retry_times", iTV);
        jSONObject.put("ad_id", this.IlO.vCE());
        jSONObject.put("track_type", this.IlO.Cc());
        jSONObject.put("upload_scene", this.MY ? this.IlO.NV() ? 3 : this.IlO.tV() <= 0 ? 1 : 2 : 4);
        String strBc = this.IlO.Bc();
        if (!TextUtils.isEmpty(strBc)) {
            JSONArray jSONArray = new JSONArray();
            for (String str : strBc.split(",")) {
                jSONArray.put(str);
            }
            jSONObject.put("error_code", jSONArray);
        }
        String strDmF = this.IlO.DmF();
        if (!TextUtils.isEmpty(strDmF)) {
            JSONArray jSONArray2 = new JSONArray();
            for (String str2 : strDmF.split(",")) {
                jSONArray2.put(str2);
            }
            jSONObject.put("error_msg", jSONArray2);
        }
        return com.bytedance.sdk.openadsdk.ea.IlO.tV.MY().IlO("track_link_result").MY(jSONObject.toString());
    }
}
