package com.bytedance.adsdk.IlO.MY.MY.IlO;

import a1.a;
import android.text.TextUtils;
import com.ironsource.C2300e4;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vAh implements com.bytedance.adsdk.IlO.MY.MY.IlO {
    private final String IlO;

    public vAh(String str) {
        this.IlO = str;
    }

    @Override // com.bytedance.adsdk.IlO.MY.MY.IlO
    public Object IlO(Map<String, JSONObject> map) {
        Object objIlO;
        if (map == null || map.size() <= 0 || (objIlO = IlO(this.IlO, map.get("default_key"))) == JSONObject.NULL) {
            return null;
        }
        return objIlO;
    }

    @Override // com.bytedance.adsdk.IlO.MY.MY.IlO
    public String MY() {
        return this.IlO;
    }

    public String toString() {
        return a.r(new StringBuilder("VariableNode [literals="), this.IlO, C2300e4.i.e);
    }

    @Override // com.bytedance.adsdk.IlO.MY.MY.IlO
    public com.bytedance.adsdk.IlO.MY.tV.Cc IlO() {
        return com.bytedance.adsdk.IlO.MY.tV.vCE.VARIABLE;
    }

    public Object IlO(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return IlO(str.split("\\."), 0, jSONObject);
    }

    private Object IlO(String[] strArr, int i2, JSONObject jSONObject) {
        Object objOpt;
        if (strArr != null && strArr.length > 0 && i2 < strArr.length && jSONObject != null) {
            String str = strArr[i2];
            int iIndexOf = str.indexOf(C2300e4.i.f8403d);
            int iIndexOf2 = str.indexOf(C2300e4.i.e);
            if (iIndexOf >= 0 && iIndexOf2 >= 0 && iIndexOf <= iIndexOf2) {
                String strSubstring = str.substring(0, iIndexOf);
                try {
                    int i8 = Integer.parseInt(str.substring(iIndexOf + 1, iIndexOf2));
                    Object objOpt2 = jSONObject.opt(strSubstring);
                    objOpt = objOpt2 instanceof JSONArray ? ((JSONArray) objOpt2).opt(i8) : null;
                } catch (NumberFormatException unused) {
                    return null;
                }
            } else {
                objOpt = jSONObject.opt(str);
            }
            if (i2 == strArr.length - 1) {
                return objOpt;
            }
            if (objOpt instanceof String) {
                try {
                    return IlO(strArr, i2 + 1, new JSONObject((String) objOpt));
                } catch (JSONException unused2) {
                    return objOpt;
                }
            }
            if (objOpt instanceof JSONObject) {
                return IlO(strArr, i2 + 1, (JSONObject) objOpt);
            }
        }
        return null;
    }
}
