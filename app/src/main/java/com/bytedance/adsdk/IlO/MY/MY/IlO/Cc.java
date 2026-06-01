package com.bytedance.adsdk.IlO.MY.MY.IlO;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc extends cl {
    public Cc() {
        super(com.bytedance.adsdk.IlO.MY.tV.EO.GT_EQ);
    }

    @Override // com.bytedance.adsdk.IlO.MY.MY.IlO
    public Object IlO(Map<String, JSONObject> map) {
        Object objIlO;
        if (this.IlO.IlO(map) == null || (objIlO = this.MY.IlO(map)) == null) {
            return null;
        }
        return Boolean.valueOf(!((Boolean) com.bytedance.adsdk.IlO.MY.Cc.IlO.tV.IlO(r0, (Number) objIlO)).booleanValue());
    }
}
