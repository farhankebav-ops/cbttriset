package com.bytedance.adsdk.ugeno.core;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EV {
    private EV Cc;
    private JSONObject EO;
    private com.bytedance.adsdk.ugeno.MY.EO IlO;
    private int MY;
    private EV tV;

    public JSONObject EO() {
        return this.EO;
    }

    public com.bytedance.adsdk.ugeno.MY.EO IlO() {
        return this.IlO;
    }

    public int MY() {
        return this.MY;
    }

    public EV tV() {
        return this.tV;
    }

    public String toString() {
        return "UGenEvent{mWidget=" + this.IlO + ", mEventType=" + this.MY + ", mEvent=" + this.EO + '}';
    }

    public void IlO(com.bytedance.adsdk.ugeno.MY.EO eo) {
        this.IlO = eo;
    }

    public void MY(EV ev) {
        this.Cc = ev;
    }

    public void IlO(int i2) {
        this.MY = i2;
    }

    public void IlO(JSONObject jSONObject) {
        this.EO = jSONObject;
    }

    public void IlO(EV ev) {
        this.tV = ev;
    }
}
