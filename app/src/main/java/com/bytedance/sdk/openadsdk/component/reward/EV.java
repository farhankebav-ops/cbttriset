package com.bytedance.sdk.openadsdk.component.reward;

import android.os.SystemClock;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.utils.zLG;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EV {
    private boolean Cc;
    private long EO;
    private final IlO IlO;
    private long MY;
    private long tV;
    private boolean vCE;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface IlO {
        void IlO();
    }

    public EV(IlO ilO) {
        this.Cc = true;
        this.IlO = ilO;
        int iIlO = com.bytedance.sdk.openadsdk.AXM.IlO.IlO("reward_callback_fallback", 0);
        if (iIlO != 0) {
            this.Cc = false;
            if (iIlO == 2) {
                this.vCE = true;
            }
        }
    }

    public static void IlO(oeT oet, boolean z2, final int i2) {
        com.bytedance.sdk.openadsdk.tV.EO.IlO(System.currentTimeMillis(), oet, zLG.IlO(oet), z2 ? "reward_callback" : "reward_fail_callback", new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.component.reward.EV.1
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("reason", i2);
                    jSONObject2.put("pag_json_data", jSONObject3);
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } catch (Exception unused) {
                }
                return jSONObject;
            }
        });
    }

    public void EO() {
        this.Cc = true;
    }

    public void MY() {
        if (this.Cc) {
            return;
        }
        this.EO = SystemClock.elapsedRealtime();
    }

    public void tV() {
        if (this.IlO != null) {
            long jElapsedRealtime = (this.tV + (this.EO > 0 ? SystemClock.elapsedRealtime() - this.EO : 0L)) / 1000;
            if (this.Cc) {
                return;
            }
            if (this.vCE || jElapsedRealtime >= this.MY) {
                this.IlO.IlO();
            }
        }
    }

    public void IlO(long j) {
        if (j <= this.MY) {
            return;
        }
        this.MY = j;
    }

    public void IlO() {
        if (!this.Cc && this.EO > 0) {
            this.tV = (SystemClock.elapsedRealtime() - this.EO) + this.tV;
            this.EO = 0L;
        }
    }
}
