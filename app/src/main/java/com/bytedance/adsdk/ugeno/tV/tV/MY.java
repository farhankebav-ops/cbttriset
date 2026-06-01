package com.bytedance.adsdk.ugeno.tV.tV;

import android.content.Context;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY extends IlO implements com.bytedance.adsdk.ugeno.tV.IlO.tV {
    private com.bytedance.adsdk.ugeno.tV.IlO.EO EV;

    public MY(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.tV.tV.IlO
    public boolean IlO(Object... objArr) {
        com.bytedance.adsdk.ugeno.tV.IlO.IlO ilOZLG = this.MY.zLG();
        if (ilOZLG == null) {
            return false;
        }
        com.bytedance.adsdk.ugeno.tV.IlO.EO eoIlO = ilOZLG.IlO(this.vCE);
        this.EV = eoIlO;
        if (eoIlO != null) {
            eoIlO.IlO(this);
            return false;
        }
        ilOZLG.IlO(this.vCE, new com.bytedance.adsdk.ugeno.tV.IlO.MY());
        return false;
    }

    @Override // com.bytedance.adsdk.ugeno.tV.IlO.tV
    public void IlO(String str) {
        Log.d("UGBaseEventMonitor", "receive: ");
        this.IlO.IlO(this.MY, this.vCE, this.EO.MY());
    }
}
