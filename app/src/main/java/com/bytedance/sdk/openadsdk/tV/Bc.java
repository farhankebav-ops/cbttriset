package com.bytedance.sdk.openadsdk.tV;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Bc {
    private long Cc;
    private long EO;
    private long IlO;
    private long MY;
    private long tV;

    public void Cc(long j) {
        if (this.Cc <= 0) {
            this.Cc = j;
        }
    }

    public void EO(long j) {
        if (this.EO <= 0) {
            this.EO = j;
        }
    }

    public void IlO(long j) {
        if (this.IlO <= 0) {
            this.IlO = j;
        }
    }

    public void MY(long j) {
        if (this.MY <= 0) {
            this.MY = j;
        }
    }

    public void tV(long j) {
        if (this.tV <= 0) {
            this.tV = j;
        }
    }

    public boolean IlO() {
        return this.IlO > 0;
    }

    public JSONObject MY() {
        return IlO((JSONObject) null);
    }

    public void IlO(long j, float f4) {
        if (f4 > 0.0f) {
            IlO(j);
        }
        double d8 = f4;
        if (d8 >= 0.25d) {
            IlO(j);
            MY(j);
        }
        if (d8 >= 0.5d) {
            IlO(j);
            MY(j);
            EO(j);
        }
        if (d8 >= 0.75d) {
            IlO(j);
            MY(j);
            EO(j);
            tV(j);
        }
        if (f4 >= 1.0f) {
            IlO(j);
            MY(j);
            EO(j);
            tV(j);
            Cc(j);
        }
    }

    public JSONObject IlO(JSONObject jSONObject) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Exception unused) {
            }
        }
        long j = this.IlO;
        if (j > 0) {
            jSONObject.put("show_start", j);
            long j3 = this.MY;
            if (j3 > 0) {
                jSONObject.put("show_firstQuartile", j3);
                long j8 = this.EO;
                if (j8 > 0) {
                    jSONObject.put("show_mid", j8);
                    long j9 = this.tV;
                    if (j9 > 0) {
                        jSONObject.put("show_thirdQuartile", j9);
                        long j10 = this.Cc;
                        if (j10 > 0) {
                            jSONObject.put("show_full", j10);
                        }
                    }
                }
            }
        }
        return jSONObject;
    }
}
