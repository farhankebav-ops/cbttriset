package com.bytedance.adsdk.ugeno.core.MY;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.adsdk.ugeno.Bc.DmF;
import com.bytedance.adsdk.ugeno.core.EV;
import com.bytedance.adsdk.ugeno.core.hp;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE implements DmF.IlO {
    private Handler Bc = new DmF(Looper.getMainLooper(), this);
    private EV Cc;
    private hp EO;
    private boolean IlO;
    private int MY;
    private Context tV;
    private com.bytedance.adsdk.ugeno.MY.EO vCE;

    public vCE(Context context, EV ev, com.bytedance.adsdk.ugeno.MY.EO eo) {
        this.tV = context;
        this.Cc = ev;
        this.vCE = eo;
    }

    public void IlO(hp hpVar) {
        this.EO = hpVar;
    }

    public void IlO() {
        EV ev = this.Cc;
        if (ev == null) {
            return;
        }
        JSONObject jSONObjectEO = ev.EO();
        try {
            this.MY = Integer.parseInt(com.bytedance.adsdk.ugeno.EO.MY.IlO(jSONObjectEO.optString("interval", "8000"), this.vCE.rp()));
            this.IlO = jSONObjectEO.optBoolean("repeat");
            this.Bc.sendEmptyMessageDelayed(1001, this.MY);
        } catch (NumberFormatException unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.Bc.DmF.IlO
    public void IlO(Message message) {
        if (message.what != 1001) {
            return;
        }
        hp hpVar = this.EO;
        if (hpVar != null) {
            EV ev = this.Cc;
            com.bytedance.adsdk.ugeno.MY.EO eo = this.vCE;
            hpVar.IlO(ev, eo, eo);
        }
        if (this.IlO) {
            this.Bc.sendEmptyMessageDelayed(1001, this.MY);
        } else {
            this.Bc.removeMessages(1001);
        }
    }
}
