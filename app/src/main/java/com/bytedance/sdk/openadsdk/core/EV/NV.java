package com.bytedance.sdk.openadsdk.core.EV;

import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class NV {
    private final String EO;
    private final String IlO;
    private final URL MY;
    private final String tV;

    private NV(String str, String str2, String str3, String str4) throws MalformedURLException {
        this.IlO = str2;
        this.MY = new URL(str);
        this.EO = str3;
        this.tV = str4;
    }

    public URL EO() {
        return this.MY;
    }

    public String IlO() {
        return this.IlO;
    }

    public String MY() {
        return this.EO;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NV)) {
            return false;
        }
        NV nv = (NV) obj;
        if (IlO(this.IlO, nv.IlO) && IlO(this.MY, nv.MY) && IlO(this.EO, nv.EO)) {
            return IlO(this.tV, nv.tV);
        }
        return false;
    }

    public int hashCode() {
        String str = this.IlO;
        int iHashCode = (this.MY.hashCode() + ((str != null ? str.hashCode() : 0) * 31)) * 31;
        String str2 = this.EO;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.tV;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public JSONObject tV() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("apiFramework", "omid");
            jSONObject.put("javascriptResourceUrl", this.MY.toString());
            if (!TextUtils.isEmpty(this.IlO)) {
                jSONObject.put("vendorKey", this.IlO);
            }
            if (!TextUtils.isEmpty(this.EO)) {
                jSONObject.put("verificationParameters", this.EO);
            }
            if (!TextUtils.isEmpty(this.tV)) {
                jSONObject.put("verificationNotExecuted", this.tV);
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    private boolean IlO(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    public static NV IlO(String str, String str2, String str3, String str4, String str5) {
        if ("omid".equalsIgnoreCase(str) && !TextUtils.isEmpty(str2)) {
            try {
                return new NV(str2, str3, str4, str5);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static NV IlO(JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("apiFramework");
            String strOptString2 = jSONObject.optString("javascriptResourceUrl");
            if ("omid".equalsIgnoreCase(strOptString) && !TextUtils.isEmpty(strOptString2)) {
                return new NV(strOptString2, jSONObject.optString("vendorKey"), jSONObject.optString("verificationParameters"), jSONObject.optString("verificationNotExecuted"));
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static Set<NV> IlO(JSONArray jSONArray) {
        HashSet hashSet = new HashSet();
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    hashSet.add(IlO(jSONArray.getJSONObject(i2)));
                } catch (Throwable unused) {
                }
            }
        }
        return hashSet;
    }
}
