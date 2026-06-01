package com.bytedance.sdk.openadsdk.EV.IlO;

import com.bytedance.sdk.component.IlO.cl;
import com.bytedance.sdk.component.IlO.tV;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.vSq;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EV extends com.bytedance.sdk.component.IlO.tV<JSONObject, JSONObject> {
    private long EO;
    private WeakReference<vSq> IlO;
    private oeT MY;
    private HashSet<Integer> tV = new HashSet<>();

    public EV(vSq vsq, oeT oet) {
        this.IlO = new WeakReference<>(vsq);
        this.MY = oet;
    }

    public static void IlO(cl clVar, final vSq vsq, final oeT oet) {
        clVar.IlO("requestDelayCallback", new tV.MY() { // from class: com.bytedance.sdk.openadsdk.EV.IlO.EV.1
            @Override // com.bytedance.sdk.component.IlO.tV.MY
            public com.bytedance.sdk.component.IlO.tV IlO() {
                return new EV(vsq, oet);
            }
        });
    }

    @Override // com.bytedance.sdk.component.IlO.tV
    public void IlO(JSONObject jSONObject, com.bytedance.sdk.component.IlO.vCE vce) throws Exception {
        vSq vsq = this.IlO.get();
        if (vsq != null && jSONObject != null) {
            vsq.IlO(new com.bytedance.sdk.openadsdk.rp.MY() { // from class: com.bytedance.sdk.openadsdk.EV.IlO.EV.2
                @Override // com.bytedance.sdk.openadsdk.rp.MY
                public void IlO(int i2) {
                    EV.this.tV.add(Integer.valueOf(i2));
                    if (EV.this.tV.size() >= EV.this.EO) {
                        try {
                            EV.this.IlO(new JSONObject());
                            EV.this.tV.clear();
                        } catch (Exception e) {
                            e.getMessage();
                        }
                    }
                }
            });
            if (jSONObject.optInt("delay", -1) < 0) {
                return;
            }
            this.EO = r2 / 1000;
            return;
        }
        EO();
    }
}
