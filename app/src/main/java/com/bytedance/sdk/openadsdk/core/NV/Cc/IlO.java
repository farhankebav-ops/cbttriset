package com.bytedance.sdk.openadsdk.core.NV.Cc;

import com.bytedance.adsdk.ugeno.core.zPa;
import com.bytedance.sdk.component.adexpress.MY.hp;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO extends hp {
    private float EO;
    private JSONObject IlO;
    private zPa MY;
    private float tV;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.NV.Cc.IlO$IlO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class C0088IlO extends hp.IlO {
        private float EO;
        private JSONObject IlO;
        private zPa MY;
        private float tV;

        public C0088IlO MY(float f4) {
            this.tV = f4;
            return this;
        }

        public C0088IlO IlO(JSONObject jSONObject) {
            this.IlO = jSONObject;
            return this;
        }

        @Override // com.bytedance.sdk.component.adexpress.MY.hp.IlO
        /* JADX INFO: renamed from: MY, reason: merged with bridge method [inline-methods] */
        public IlO IlO() {
            return new IlO(this);
        }

        public C0088IlO IlO(zPa zpa) {
            this.MY = zpa;
            return this;
        }

        public C0088IlO IlO(float f4) {
            this.EO = f4;
            return this;
        }
    }

    public IlO(C0088IlO c0088IlO) {
        super(c0088IlO);
        this.IlO = c0088IlO.IlO;
        this.MY = c0088IlO.MY;
        this.EO = c0088IlO.EO;
        this.tV = c0088IlO.tV;
    }

    public zPa dY() {
        return this.MY;
    }

    public float oc() {
        return this.tV;
    }

    public JSONObject vSq() {
        return this.IlO;
    }

    public float wPn() {
        return this.EO;
    }
}
