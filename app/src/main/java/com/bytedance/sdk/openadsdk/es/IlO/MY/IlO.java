package com.bytedance.sdk.openadsdk.es.IlO.MY;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.work.PeriodicWorkRequest;
import com.bytedance.sdk.component.lEW.lEW;
import com.bytedance.sdk.openadsdk.core.settings.hp;
import com.bytedance.sdk.openadsdk.multipro.tV.tV;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.ironsource.Q6;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    private static volatile IlO Cc;
    private Boolean IlO = null;
    private AtomicLong MY = new AtomicLong(0);
    private int EO = 0;
    private String tV = "";

    private IlO() {
    }

    public static IlO IlO() {
        if (Cc == null) {
            synchronized (IlO.class) {
                try {
                    if (Cc == null) {
                        IlO ilO = new IlO();
                        Cc = ilO;
                        ilO.EO();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return Cc;
    }

    public boolean EO() {
        Boolean bool = this.IlO;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean zOOq = false;
        int iIlO = tV.IlO("pag_allow", Q6.U0, 0);
        if (iIlO == 0) {
            zOOq = hp.aP().OOq(Q6.U0);
        } else if (iIlO == 2) {
            zOOq = true;
        }
        Boolean boolValueOf = Boolean.valueOf(zOOq);
        this.IlO = boolValueOf;
        return boolValueOf.booleanValue();
    }

    public String MY() {
        return EO() ? this.tV : "";
    }

    public void MY(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                this.IlO = null;
                tV.IlO("pag_allows", Q6.U0, (Integer) 0);
                return;
            }
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (jSONArray.getString(i2).equals(Q6.U0)) {
                    tV.IlO("pag_allows", Q6.U0, (Integer) 2);
                    this.IlO = Boolean.TRUE;
                    return;
                }
            }
            this.IlO = Boolean.FALSE;
            tV.IlO("pag_allows", Q6.U0, (Integer) 1);
        } catch (Throwable unused) {
        }
    }

    public void IlO(String str) {
        this.tV = str;
    }

    public void IlO(boolean z2) {
        if (this.EO == 1 || !TextUtils.isEmpty(MY())) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (z2 || this.MY.get() <= jElapsedRealtime) {
            this.MY.set(jElapsedRealtime + PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS);
            mmj.IlO((lEW) new DeviceUtils.EO());
        }
    }

    public void IlO(int i2) {
        this.EO = i2;
    }

    public void IlO(JSONObject jSONObject) {
        if (!EO() || jSONObject == null) {
            return;
        }
        try {
            jSONObject.put(Q6.U0, this.tV);
        } catch (JSONException unused) {
        }
    }
}
