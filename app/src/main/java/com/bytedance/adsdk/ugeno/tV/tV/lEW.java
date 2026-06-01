package com.bytedance.adsdk.ugeno.tV.tV;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.bytedance.adsdk.ugeno.Bc.DmF;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class lEW extends IlO implements DmF.IlO {
    private int EV;
    private int bWL;
    private Handler hp;
    private int rp;

    public lEW(Context context) {
        super(context);
        this.rp = 0;
        this.hp = new com.bytedance.adsdk.ugeno.Bc.DmF(Looper.getMainLooper(), this);
        this.bWL = 0;
    }

    @Override // com.bytedance.adsdk.ugeno.tV.tV.IlO
    public boolean IlO(Object... objArr) {
        Map<String, String> map = this.Cc;
        if (map != null) {
            int iIlO = com.bytedance.adsdk.ugeno.Bc.EO.IlO(map.get("loop"), 0);
            this.EV = iIlO;
            if (iIlO <= 0) {
                this.bWL = -1;
            } else {
                this.bWL = iIlO;
            }
            this.rp = com.bytedance.adsdk.ugeno.Bc.EO.IlO(this.Cc.get("duration"), 0);
        }
        this.hp.sendEmptyMessageDelayed(1001, this.rp);
        return true;
    }

    @Override // com.bytedance.adsdk.ugeno.Bc.DmF.IlO
    public void IlO(Message message) {
        int i2;
        int i8;
        if (message.what != 1001) {
            return;
        }
        Log.d("UGBaseEventMonitor", "handleMsg: execute timer event" + this.bWL);
        this.IlO.IlO(this.MY, this.vCE, this.EO.MY());
        int i9 = this.bWL + (-1);
        this.bWL = i9;
        if (i9 < 0 && (i8 = this.rp) != 0) {
            this.hp.sendEmptyMessageDelayed(1001, i8);
        } else if (i9 > 0 && (i2 = this.rp) != 0) {
            this.hp.sendEmptyMessageDelayed(1001, i2);
        } else {
            this.hp.removeMessages(1001);
        }
    }
}
