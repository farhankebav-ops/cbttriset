package com.bytedance.adsdk.IlO.MY.MY.IlO;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class xF implements com.bytedance.adsdk.IlO.MY.MY.MY {
    private com.bytedance.adsdk.IlO.MY.MY.IlO EO;
    private com.bytedance.adsdk.IlO.MY.MY.IlO IlO;
    private com.bytedance.adsdk.IlO.MY.MY.IlO MY;

    @Override // com.bytedance.adsdk.IlO.MY.MY.MY
    public void EO(com.bytedance.adsdk.IlO.MY.MY.IlO ilO) {
        this.EO = ilO;
    }

    @Override // com.bytedance.adsdk.IlO.MY.MY.IlO
    public Object IlO(Map<String, JSONObject> map) {
        Object objIlO = this.IlO.IlO(map);
        if (objIlO == null) {
            return null;
        }
        return ((Boolean) objIlO).booleanValue() ? this.MY.IlO(map) : this.EO.IlO(map);
    }

    @Override // com.bytedance.adsdk.IlO.MY.MY.MY
    public void MY(com.bytedance.adsdk.IlO.MY.MY.IlO ilO) {
        this.MY = ilO;
    }

    public String toString() {
        return MY();
    }

    @Override // com.bytedance.adsdk.IlO.MY.MY.IlO
    public String MY() {
        return this.IlO.MY() + "?" + this.MY.MY() + ":" + this.EO.MY();
    }

    @Override // com.bytedance.adsdk.IlO.MY.MY.IlO
    public com.bytedance.adsdk.IlO.MY.tV.Cc IlO() {
        return com.bytedance.adsdk.IlO.MY.tV.vCE.OPERATOR_RESULT;
    }

    @Override // com.bytedance.adsdk.IlO.MY.MY.MY
    public void IlO(com.bytedance.adsdk.IlO.MY.MY.IlO ilO) {
        this.IlO = ilO;
    }
}
