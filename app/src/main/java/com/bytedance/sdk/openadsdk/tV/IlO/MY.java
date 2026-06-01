package com.bytedance.sdk.openadsdk.tV.IlO;

import com.ironsource.C2300e4;
import com.onesignal.session.internal.influence.impl.InfluenceConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {
    public int tV;
    public AtomicInteger IlO = new AtomicInteger(0);
    public AtomicInteger MY = new AtomicInteger(0);
    public AtomicLong EO = new AtomicLong(0);
    public AtomicInteger Cc = new AtomicInteger(0);
    public Map<Integer, Integer> vCE = new HashMap();
    public AtomicBoolean Bc = new AtomicBoolean(false);

    public MY(int i2) {
        this.tV = i2;
    }

    public JSONObject IlO() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", this.IlO.get());
            jSONObject.put(C2300e4.f.e, this.MY.get());
            jSONObject.put("type", this.tV);
            jSONObject.put("duration", this.EO.get() / ((long) this.IlO.get()));
            JSONObject jSONObject2 = new JSONObject();
            if (this.vCE.size() > 0) {
                for (Map.Entry<Integer, Integer> entry : this.vCE.entrySet()) {
                    jSONObject2.put(String.valueOf(entry.getKey()), entry.getValue());
                }
            }
            jSONObject.put("fail_error_code", jSONObject2);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject MY() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", this.IlO.get());
            jSONObject.put(C2300e4.f.e, this.MY.get());
            jSONObject.put("type", this.tV);
            jSONObject.put(InfluenceConstants.TIME, this.Cc.get());
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }
}
