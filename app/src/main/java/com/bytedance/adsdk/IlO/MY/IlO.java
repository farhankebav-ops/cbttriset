package com.bytedance.adsdk.IlO.MY;

import com.bytedance.adsdk.IlO.MY.EO.IlO.Bc;
import com.bytedance.adsdk.IlO.MY.EO.IlO.Cc;
import com.bytedance.adsdk.IlO.MY.EO.IlO.DmF;
import com.bytedance.adsdk.IlO.MY.EO.IlO.EO;
import com.bytedance.adsdk.IlO.MY.EO.IlO.MY;
import com.bytedance.adsdk.IlO.MY.EO.IlO.NV;
import com.bytedance.adsdk.IlO.MY.EO.IlO.lEW;
import com.bytedance.adsdk.IlO.MY.EO.IlO.tV;
import com.bytedance.adsdk.IlO.MY.EO.IlO.vCE;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    private static final com.bytedance.adsdk.IlO.MY.EO.IlO IlO;
    private String Cc;
    private com.bytedance.adsdk.IlO.MY.MY.IlO EO;
    private final com.bytedance.adsdk.IlO.MY.EO.IlO MY;
    private Deque<com.bytedance.adsdk.IlO.MY.MY.IlO> tV = new LinkedList();

    static {
        int i2 = 8;
        vCE[] vceArr = {new NV(), new tV(), new DmF(), new MY(), new Cc(), new com.bytedance.adsdk.IlO.MY.EO.IlO.IlO(), new Bc(), new EO(), new lEW()};
        final com.bytedance.adsdk.IlO.MY.EO.IlO ilO = new com.bytedance.adsdk.IlO.MY.EO.IlO() { // from class: com.bytedance.adsdk.IlO.MY.IlO.1
            @Override // com.bytedance.adsdk.IlO.MY.EO.IlO
            public int IlO(String str, int i8, Deque<com.bytedance.adsdk.IlO.MY.MY.IlO> deque) {
                return i8;
            }
        };
        while (i2 >= 0) {
            final vCE vce = vceArr[i2];
            i2--;
            ilO = new com.bytedance.adsdk.IlO.MY.EO.IlO() { // from class: com.bytedance.adsdk.IlO.MY.IlO.2
                @Override // com.bytedance.adsdk.IlO.MY.EO.IlO
                public int IlO(String str, int i8, Deque<com.bytedance.adsdk.IlO.MY.MY.IlO> deque) {
                    return vce.IlO(str, i8, deque, ilO);
                }
            };
        }
        IlO = ilO;
    }

    private IlO(String str, com.bytedance.adsdk.IlO.MY.EO.IlO ilO) {
        this.MY = ilO;
        this.Cc = str;
        try {
            IlO();
        } catch (Exception e) {
            throw new com.bytedance.adsdk.IlO.IlO.MY(str, e);
        }
    }

    public static IlO IlO(String str) {
        return new IlO(str, IlO);
    }

    private void IlO() {
        int length = this.Cc.length();
        int i2 = 0;
        while (i2 < length) {
            int iIlO = this.MY.IlO(this.Cc, i2, this.tV);
            if (iIlO == i2) {
                throw new IllegalArgumentException("Unrecognized expression, unrecognized characters encountered during parsing:" + this.Cc.substring(0, i2));
            }
            i2 = iIlO;
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            com.bytedance.adsdk.IlO.MY.MY.IlO ilOPollFirst = this.tV.pollFirst();
            if (ilOPollFirst == null) {
                this.EO = com.bytedance.adsdk.IlO.MY.Cc.MY.IlO(arrayList, this.Cc, i2);
                this.tV = null;
                return;
            }
            arrayList.add(0, ilOPollFirst);
        }
    }

    public <T> T IlO(JSONObject jSONObject) {
        HashMap map = new HashMap();
        map.put("default_key", jSONObject);
        return (T) IlO(map);
    }

    public <T> T IlO(Map<String, JSONObject> map) {
        return (T) this.EO.IlO(map);
    }
}
