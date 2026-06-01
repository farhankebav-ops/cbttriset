package com.bytedance.adsdk.ugeno.core.MY;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.Bc.DmF;
import com.bytedance.adsdk.ugeno.core.EV;
import com.bytedance.adsdk.ugeno.core.hp;
import com.bytedance.adsdk.ugeno.core.lEW;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY implements DmF.IlO {
    private com.bytedance.adsdk.ugeno.MY.EO Cc;
    private Context EO;
    private int IlO;
    private hp MY;
    private EV tV;
    private Handler vCE = new DmF(Looper.getMainLooper(), this);

    public MY(Context context, EV ev, com.bytedance.adsdk.ugeno.MY.EO eo) {
        this.EO = context;
        this.tV = ev;
        this.Cc = eo;
    }

    public void IlO(hp hpVar) {
        this.MY = hpVar;
    }

    public void IlO() {
        EV ev = this.tV;
        if (ev == null) {
            return;
        }
        try {
            int i2 = Integer.parseInt(com.bytedance.adsdk.ugeno.EO.MY.IlO(ev.EO().optString("delay"), this.Cc.rp()));
            this.IlO = i2;
            this.vCE.sendEmptyMessageDelayed(1001, i2);
        } catch (NumberFormatException unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.Bc.DmF.IlO
    public void IlO(Message message) {
        if (message.what != 1001) {
            return;
        }
        JSONObject jSONObjectEO = this.tV.EO();
        if (TextUtils.equals(jSONObjectEO.optString("type"), "onAnimation")) {
            String strOptString = jSONObjectEO.optString("nodeId");
            com.bytedance.adsdk.ugeno.MY.EO eo = this.Cc;
            com.bytedance.adsdk.ugeno.MY.EO EO = eo.MY(eo).EO(strOptString);
            new lEW(EO.EV(), com.bytedance.adsdk.ugeno.core.IlO.IlO(jSONObjectEO.optJSONObject("animatorSet"), EO)).IlO();
        } else {
            hp hpVar = this.MY;
            if (hpVar != null) {
                EV ev = this.tV;
                com.bytedance.adsdk.ugeno.MY.EO eo2 = this.Cc;
                hpVar.IlO(ev, eo2, eo2);
            }
        }
        this.vCE.removeMessages(1001);
    }
}
