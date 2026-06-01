package com.bytedance.adsdk.ugeno.core;

import android.content.Context;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class DmF {
    private JSONObject EO;
    private Context IlO;
    private JSONObject MY;
    private Map<String, Object> tV;

    public void IlO(Context context) {
        this.IlO = context;
    }

    public void MY(JSONObject jSONObject) {
        this.EO = jSONObject;
    }

    public void IlO(JSONObject jSONObject) {
        this.MY = jSONObject;
    }

    public Map<String, Object> MY() {
        return this.tV;
    }

    public JSONObject IlO() {
        return this.EO;
    }

    public void IlO(Map<String, Object> map) {
        this.tV = map;
    }
}
