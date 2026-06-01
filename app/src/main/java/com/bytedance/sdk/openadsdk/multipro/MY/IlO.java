package com.bytedance.sdk.openadsdk.multipro.MY;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    public long Bc;
    public long Cc;
    public boolean EO;
    public boolean IlO;
    public boolean MY;
    public boolean tV;
    public long vCE;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.multipro.MY.IlO$IlO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface InterfaceC0114IlO {
        IlO vCE();
    }

    public IlO EO(boolean z2) {
        this.MY = z2;
        return this;
    }

    public IlO IlO(boolean z2) {
        this.tV = z2;
        return this;
    }

    public IlO MY(boolean z2) {
        this.IlO = z2;
        return this;
    }

    public IlO tV(boolean z2) {
        this.EO = z2;
        return this;
    }

    public IlO EO(long j) {
        this.Bc = j;
        return this;
    }

    public IlO IlO(long j) {
        this.Cc = j;
        return this;
    }

    public IlO MY(long j) {
        this.vCE = j;
        return this;
    }

    public JSONObject IlO() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isCompleted", this.IlO);
            jSONObject.put("isFromVideoDetailPage", this.MY);
            jSONObject.put("isFromDetailPage", this.EO);
            jSONObject.put("duration", this.Cc);
            jSONObject.put("totalPlayDuration", this.vCE);
            jSONObject.put("currentPlayPosition", this.Bc);
            jSONObject.put("isAutoPlay", this.tV);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static IlO IlO(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        IlO ilO = new IlO();
        ilO.MY(jSONObject.optBoolean("isCompleted"));
        ilO.EO(jSONObject.optBoolean("isFromVideoDetailPage"));
        ilO.tV(jSONObject.optBoolean("isFromDetailPage"));
        ilO.IlO(jSONObject.optLong("duration"));
        ilO.MY(jSONObject.optLong("totalPlayDuration"));
        ilO.EO(jSONObject.optLong("currentPlayPosition"));
        ilO.IlO(jSONObject.optBoolean("isAutoPlay"));
        return ilO;
    }
}
