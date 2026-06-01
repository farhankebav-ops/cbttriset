package com.bytedance.adsdk.IlO.MY.MY.IlO;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV extends cl {
    public tV() {
        super(com.bytedance.adsdk.IlO.MY.tV.EO.EQ);
    }

    @Override // com.bytedance.adsdk.IlO.MY.MY.IlO
    public Object IlO(Map<String, JSONObject> map) {
        Object objIlO = this.IlO.IlO(map);
        Object objIlO2 = this.MY.IlO(map);
        return (objIlO == null && objIlO2 == null) ? Boolean.TRUE : (objIlO != null || objIlO2 == null) ? (objIlO == null || objIlO2 != null) ? ((objIlO instanceof Number) && (objIlO2 instanceof Number)) ? Boolean.valueOf(com.bytedance.adsdk.IlO.MY.Cc.IlO.MY.IlO((Number) objIlO, (Number) objIlO2)) : Boolean.valueOf(objIlO.equals(objIlO2)) : Boolean.FALSE : Boolean.FALSE;
    }
}
