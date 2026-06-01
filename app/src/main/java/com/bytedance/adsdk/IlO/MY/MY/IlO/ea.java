package com.bytedance.adsdk.IlO.MY.MY.IlO;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class ea implements com.bytedance.adsdk.IlO.MY.MY.IlO {
    private Number IlO;

    public ea(String str) {
        if (str.indexOf(46) < 0) {
            try {
                this.IlO = Integer.valueOf(str);
            } catch (NumberFormatException unused) {
                this.IlO = Long.valueOf(str);
            }
        } else {
            Float fValueOf = Float.valueOf(str);
            this.IlO = fValueOf;
            if (Float.isInfinite(fValueOf.floatValue())) {
                this.IlO = Double.valueOf(str);
            }
        }
    }

    @Override // com.bytedance.adsdk.IlO.MY.MY.IlO
    public Object IlO(Map<String, JSONObject> map) {
        return this.IlO;
    }

    @Override // com.bytedance.adsdk.IlO.MY.MY.IlO
    public String MY() {
        return this.IlO.toString();
    }

    public String toString() {
        return MY();
    }

    @Override // com.bytedance.adsdk.IlO.MY.MY.IlO
    public com.bytedance.adsdk.IlO.MY.tV.Cc IlO() {
        return com.bytedance.adsdk.IlO.MY.tV.vCE.NUMBER;
    }
}
