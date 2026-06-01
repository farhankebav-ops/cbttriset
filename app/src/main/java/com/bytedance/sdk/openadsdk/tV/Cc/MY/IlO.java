package com.bytedance.sdk.openadsdk.tV.Cc.MY;

import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.tV.Cc.MY.EO;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO<T extends EO> {
    private boolean Cc = false;
    private JSONObject EO;
    private oeT IlO;
    private String MY;
    private T tV;

    public IlO(oeT oet, String str, JSONObject jSONObject, T t3) {
        this.IlO = oet;
        this.MY = str;
        this.EO = jSONObject;
        this.tV = t3;
    }

    public boolean Cc() {
        return this.Cc;
    }

    public JSONObject EO() {
        if (this.EO == null) {
            this.EO = new JSONObject();
        }
        return this.EO;
    }

    public oeT IlO() {
        return this.IlO;
    }

    public String MY() {
        return this.MY;
    }

    public T tV() {
        return this.tV;
    }

    public void IlO(boolean z2) {
        this.Cc = z2;
    }
}
