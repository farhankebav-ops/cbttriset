package com.bytedance.sdk.component.Cc.IlO;

import com.bytedance.sdk.component.Cc.DmF;
import com.bytedance.sdk.component.Cc.rp;
import com.bytedance.sdk.component.utils.zPa;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {
    public static rp IlO() {
        return new rp() { // from class: com.bytedance.sdk.component.Cc.IlO.MY.1
            private WeakHashMap<String, String> IlO = new WeakHashMap<>();

            @Override // com.bytedance.sdk.component.Cc.rp
            public String IlO(DmF dmF) {
                return IlO(dmF.IlO() + "#width=" + dmF.MY() + "#height=" + dmF.EO() + "#scaletype=" + dmF.tV() + "#bitmapConfig=" + dmF.Cc());
            }

            @Override // com.bytedance.sdk.component.Cc.rp
            public String MY(DmF dmF) {
                return IlO(dmF.IlO());
            }

            private String IlO(String str) {
                String str2 = this.IlO.get(str);
                if (str2 != null) {
                    return str2;
                }
                String strIlO = zPa.IlO(str);
                this.IlO.put(str, strIlO);
                return strIlO;
            }
        };
    }
}
