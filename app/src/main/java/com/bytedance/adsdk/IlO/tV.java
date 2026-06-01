package com.bytedance.adsdk.IlO;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV implements vCE {
    @Override // com.bytedance.adsdk.IlO.vCE
    /* JADX INFO: renamed from: MY, reason: merged with bridge method [inline-methods] */
    public String IlO(JSONObject jSONObject, Object[] objArr) {
        if (objArr == null || objArr.length < 2) {
            return null;
        }
        String strValueOf = String.valueOf(objArr[0]);
        if (TextUtils.isEmpty(strValueOf)) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(strValueOf);
            String strValueOf2 = String.valueOf(objArr[1]);
            if (TextUtils.isEmpty(strValueOf2)) {
                return null;
            }
            Object objIlO = com.bytedance.adsdk.IlO.MY.IlO.IlO(strValueOf2).IlO(jSONObject2);
            if (!TextUtils.isEmpty(String.valueOf(objIlO))) {
                return String.valueOf(objIlO);
            }
            if (objArr.length >= 3) {
                return String.valueOf(objArr[2]);
            }
            return null;
        } catch (JSONException unused) {
            return null;
        }
    }
}
