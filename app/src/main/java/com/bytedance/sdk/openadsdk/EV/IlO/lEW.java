package com.bytedance.sdk.openadsdk.EV.IlO;

import com.bytedance.sdk.component.IlO.cl;
import com.bytedance.sdk.openadsdk.core.vSq;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class lEW extends com.bytedance.sdk.component.IlO.Cc<JSONObject, JSONObject> {
    private final vSq IlO;
    private final String MY;

    public lEW(vSq vsq, String str) {
        this.IlO = vsq;
        this.MY = str;
    }

    public static void IlO(cl clVar, vSq vsq) {
        clVar.IlO("endcardDynamicCreatives", new lEW(vsq, "endcardDynamicCreatives"));
        clVar.IlO("multiOpenCovert", new lEW(vsq, "multiOpenCovert"));
        clVar.IlO("skipToNextAd", new lEW(vsq, "skipToNextAd"));
        clVar.IlO("speedVideoOrTimer", new lEW(vsq, "speedVideoOrTimer"));
    }

    @Override // com.bytedance.sdk.component.IlO.Cc
    public JSONObject IlO(JSONObject jSONObject, com.bytedance.sdk.component.IlO.vCE vce) throws Exception {
        if ("endcardDynamicCreatives".equals(this.MY)) {
            return this.IlO.lEW(jSONObject);
        }
        if ("multiOpenCovert".equals(this.MY)) {
            this.IlO.DmF(jSONObject);
            return null;
        }
        if ("skipToNextAd".equals(this.MY)) {
            this.IlO.IlO(jSONObject, this.MY);
            return null;
        }
        if ("speedVideoOrTimer".equals(this.MY)) {
            return this.IlO.Bc(jSONObject);
        }
        return null;
    }
}
