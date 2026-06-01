package com.bytedance.adsdk.IlO;

import com.bytedance.adsdk.ugeno.EO.IlO;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY implements com.bytedance.adsdk.ugeno.EO.IlO {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO implements IlO.InterfaceC0029IlO {
        private com.bytedance.adsdk.IlO.MY.IlO IlO;
        private String MY;

        private IlO(String str) {
            this.MY = str;
            this.IlO = com.bytedance.adsdk.IlO.MY.IlO.IlO(str);
        }

        public static IlO IlO(String str) {
            return new IlO(str);
        }

        @Override // com.bytedance.adsdk.ugeno.EO.IlO.InterfaceC0029IlO
        public Object IlO(JSONObject jSONObject) {
            com.bytedance.adsdk.IlO.MY.IlO ilO = this.IlO;
            if (ilO == null) {
                return this.MY;
            }
            Object objIlO = ilO.IlO(jSONObject);
            return objIlO instanceof String ? objIlO : objIlO instanceof com.bytedance.adsdk.IlO.MY.IlO.IlO ? String.valueOf(DmF.IlO((com.bytedance.adsdk.IlO.MY.IlO.IlO) objIlO)) : String.valueOf(objIlO);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.EO.IlO
    public IlO.InterfaceC0029IlO IlO(String str) {
        return IlO.IlO(str);
    }
}
