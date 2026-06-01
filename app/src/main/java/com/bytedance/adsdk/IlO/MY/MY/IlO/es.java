package com.bytedance.adsdk.IlO.MY.MY.IlO;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class es extends cl {
    private static final ThreadLocal<StringBuilder> tV = new ThreadLocal<StringBuilder>() { // from class: com.bytedance.adsdk.IlO.MY.MY.IlO.es.1
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
        public StringBuilder initialValue() {
            return new StringBuilder();
        }
    };

    public es() {
        super(com.bytedance.adsdk.IlO.MY.tV.EO.PLUS);
    }

    @Override // com.bytedance.adsdk.IlO.MY.MY.IlO
    public Object IlO(Map<String, JSONObject> map) {
        Object objIlO;
        Object objIlO2 = this.IlO.IlO(map);
        if (objIlO2 == null || (objIlO = this.MY.IlO(map)) == null) {
            return null;
        }
        if (!(objIlO2 instanceof String) && !(objIlO instanceof String)) {
            return com.bytedance.adsdk.IlO.MY.Cc.IlO.lEW.IlO((Number) objIlO2, (Number) objIlO);
        }
        StringBuilder sb = tV.get();
        sb.append(objIlO2);
        sb.append(objIlO);
        String string = sb.toString();
        sb.setLength(0);
        return string;
    }
}
