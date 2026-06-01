package com.bytedance.adsdk.IlO.MY.MY.IlO;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class NV implements com.bytedance.adsdk.IlO.MY.MY.IlO {
    private com.bytedance.adsdk.IlO.MY.IlO.IlO EO;
    private com.bytedance.adsdk.IlO.MY.MY.IlO[] IlO;
    private String MY;

    public NV(String str) {
        this.MY = str;
    }

    public void IlO(com.bytedance.adsdk.IlO.MY.MY.IlO[] ilOArr) {
        this.IlO = ilOArr;
    }

    @Override // com.bytedance.adsdk.IlO.MY.MY.IlO
    public String MY() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.MY);
        sb.append("(");
        com.bytedance.adsdk.IlO.MY.MY.IlO[] ilOArr = this.IlO;
        if (ilOArr != null && ilOArr.length > 0) {
            int i2 = 0;
            while (true) {
                com.bytedance.adsdk.IlO.MY.MY.IlO[] ilOArr2 = this.IlO;
                if (i2 >= ilOArr2.length) {
                    break;
                }
                sb.append(ilOArr2[i2].MY());
                sb.append(",");
                i2++;
            }
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.bytedance.adsdk.IlO.MY.MY.IlO
    public Object IlO(Map<String, JSONObject> map) {
        com.bytedance.adsdk.IlO.MY.IlO.IlO ilO = new com.bytedance.adsdk.IlO.MY.IlO.IlO();
        this.EO = ilO;
        ilO.IlO(this.MY);
        Object[] objArr = new Object[this.IlO.length];
        int i2 = 0;
        while (true) {
            com.bytedance.adsdk.IlO.MY.MY.IlO[] ilOArr = this.IlO;
            if (i2 >= ilOArr.length) {
                this.EO.IlO(objArr);
                return com.bytedance.adsdk.IlO.DmF.IlO(this.MY).IlO(map.get("default_key"), objArr);
            }
            com.bytedance.adsdk.IlO.MY.MY.IlO ilO2 = ilOArr[i2];
            if (ilO2 != null) {
                objArr[i2] = ilO2.IlO(map);
            }
            i2++;
        }
    }

    @Override // com.bytedance.adsdk.IlO.MY.MY.IlO
    public com.bytedance.adsdk.IlO.MY.tV.Cc IlO() {
        return com.bytedance.adsdk.IlO.MY.tV.MY.METHOD;
    }
}
