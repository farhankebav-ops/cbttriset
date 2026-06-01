package com.bytedance.adsdk.IlO.MY.MY.IlO;

import a1.a;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class AXM implements com.bytedance.adsdk.IlO.MY.MY.IlO {
    private final String IlO;

    public AXM(String str) {
        this.IlO = str;
    }

    @Override // com.bytedance.adsdk.IlO.MY.MY.IlO
    public Object IlO(Map<String, JSONObject> map) {
        return this.IlO;
    }

    @Override // com.bytedance.adsdk.IlO.MY.MY.IlO
    public String MY() {
        return a.r(new StringBuilder("'"), this.IlO, "'");
    }

    public String toString() {
        return MY();
    }

    @Override // com.bytedance.adsdk.IlO.MY.MY.IlO
    public com.bytedance.adsdk.IlO.MY.tV.Cc IlO() {
        return com.bytedance.adsdk.IlO.MY.tV.vCE.STRING;
    }
}
