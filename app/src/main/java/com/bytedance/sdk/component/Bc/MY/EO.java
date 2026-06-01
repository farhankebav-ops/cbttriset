package com.bytedance.sdk.component.Bc.MY;

import android.text.TextUtils;
import com.bytedance.sdk.component.MY.IlO.EV;
import com.bytedance.sdk.component.MY.IlO.rp;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class EO {
    String Cc;
    protected EV EO;
    int vCE;
    protected String tV = null;
    protected final Map<String, String> Bc = new HashMap();
    protected String lEW = null;
    protected boolean DmF = false;

    public EO(EV ev) {
        this.EO = ev;
        try {
            EO(UUID.randomUUID().toString());
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void EO(String str) {
        this.tV = str;
    }

    public void IlO(String str) {
        this.Cc = str;
    }

    public void MY(String str) {
        this.lEW = str;
    }

    public void tV(Map<String, String> map) {
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.Bc.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public String EO() {
        return this.tV;
    }

    public void IlO(int i2) {
        this.vCE = i2;
    }

    public void MY(String str, String str2) {
        this.Bc.put(str, str2);
    }

    public void IlO(rp.IlO ilO) {
        if (ilO != null && this.Bc.size() > 0) {
            for (Map.Entry<String, String> entry : this.Bc.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    String value = entry.getValue();
                    if (value == null) {
                        value = "";
                    }
                    ilO.MY(key, value);
                }
            }
        }
    }

    public void MY() {
        EV ev;
        if (this.tV == null || (ev = this.EO) == null) {
            return;
        }
        com.bytedance.sdk.component.MY.IlO.tV tVVarIlO = ev.IlO();
        synchronized (tVVarIlO) {
            try {
                for (com.bytedance.sdk.component.MY.IlO.MY my : tVVarIlO.EO()) {
                    if (this.tV.equals(my.IlO().IlO())) {
                        my.EO();
                    }
                }
                for (com.bytedance.sdk.component.MY.IlO.MY my2 : tVVarIlO.tV()) {
                    if (this.tV.equals(my2.IlO().IlO())) {
                        my2.EO();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String tV() {
        return this.lEW;
    }
}
