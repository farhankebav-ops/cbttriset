package com.bytedance.sdk.openadsdk.EV.IlO;

import androidx.annotation.NonNull;
import com.bytedance.sdk.component.IlO.cl;
import com.bytedance.sdk.component.IlO.tV;
import com.bytedance.sdk.openadsdk.core.vSq;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO extends com.bytedance.sdk.component.IlO.tV<JSONObject, JSONObject> {
    private final WeakReference<vSq> IlO;

    public EO(vSq vsq) {
        this.IlO = new WeakReference<>(vsq);
    }

    public static void IlO(cl clVar, final vSq vsq) {
        clVar.IlO("newClickEvent", new tV.MY() { // from class: com.bytedance.sdk.openadsdk.EV.IlO.EO.1
            @Override // com.bytedance.sdk.component.IlO.tV.MY
            public com.bytedance.sdk.component.IlO.tV IlO() {
                return new EO(vsq);
            }
        });
    }

    @Override // com.bytedance.sdk.component.IlO.tV
    public void IlO(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.component.IlO.vCE vce) throws Exception {
        vSq vsq = this.IlO.get();
        if (vsq == null) {
            EO();
        } else {
            vsq.Cc(jSONObject);
        }
    }
}
