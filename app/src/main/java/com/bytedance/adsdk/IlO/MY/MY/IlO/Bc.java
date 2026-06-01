package com.bytedance.adsdk.IlO.MY.MY.IlO;

import com.ironsource.C2300e4;
import com.ironsource.mediationsdk.metadata.a;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Bc implements com.bytedance.adsdk.IlO.MY.MY.IlO {
    private final Object IlO;

    public Bc(String str) {
        if (str.equalsIgnoreCase(a.g)) {
            this.IlO = Boolean.TRUE;
        } else if (str.equalsIgnoreCase("false")) {
            this.IlO = Boolean.FALSE;
        } else {
            if (!str.equalsIgnoreCase("null")) {
                throw new IllegalArgumentException();
            }
            this.IlO = null;
        }
    }

    @Override // com.bytedance.adsdk.IlO.MY.MY.IlO
    public Object IlO(Map<String, JSONObject> map) {
        return this.IlO;
    }

    @Override // com.bytedance.adsdk.IlO.MY.MY.IlO
    public String MY() {
        Object obj = this.IlO;
        return obj != null ? obj.toString() : "NULL";
    }

    public String toString() {
        return "KeywordNode [keywordValue=" + this.IlO + C2300e4.i.e;
    }

    @Override // com.bytedance.adsdk.IlO.MY.MY.IlO
    public com.bytedance.adsdk.IlO.MY.tV.Cc IlO() {
        return com.bytedance.adsdk.IlO.MY.tV.vCE.CONSTANT;
    }
}
