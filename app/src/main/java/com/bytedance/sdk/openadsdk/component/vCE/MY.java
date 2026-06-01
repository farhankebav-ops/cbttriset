package com.bytedance.sdk.openadsdk.component.vCE;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY implements Handler.Callback {
    private boolean Bc;
    private IlO EO;
    private long EV;
    private final com.bytedance.sdk.openadsdk.component.lEW.IlO MY;
    private long NV;
    private boolean rp;
    private Handler IlO = new Handler(Looper.myLooper(), this);
    private int tV = 0;
    private int Cc = 5;
    private int vCE = 0;
    private final int lEW = 1000;
    private int DmF = 1000;

    public MY(com.bytedance.sdk.openadsdk.component.lEW.IlO ilO) {
        this.MY = ilO;
    }

    public void Cc() {
        this.IlO.removeCallbacksAndMessages(null);
        this.IlO = null;
    }

    public void EO() {
        if (this.IlO != null) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 100;
            messageObtain.arg1 = this.tV;
            this.IlO.sendMessage(messageObtain);
        }
    }

    public void IlO(int i2) {
        this.tV = i2;
        int i8 = this.Cc - i2;
        this.MY.MY(i8);
        boolean z2 = true;
        if (i2 <= 0) {
            IlO ilO = this.EO;
            if (ilO != null && !this.Bc) {
                ilO.MY();
                this.Bc = true;
            }
            i2 = 0;
        }
        IlO ilO2 = this.EO;
        if (ilO2 != null) {
            int i9 = this.vCE;
            int i10 = i9 - i8;
            if (i2 != 0 && i8 < i9) {
                z2 = false;
            }
            ilO2.IlO(i10, z2);
        }
    }

    public void MY(int i2) {
        this.vCE = Math.min(i2, this.Cc);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        if (message.what == 100 && this.IlO != null) {
            int i2 = message.arg1;
            IlO(i2);
            if (i2 > 0) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 100;
                messageObtain.arg1 = i2 - 1;
                this.IlO.sendMessageDelayed(messageObtain, this.DmF);
            }
        }
        return true;
    }

    public void tV() {
        Handler handler = this.IlO;
        if (handler != null) {
            handler.removeMessages(100);
        }
    }

    public void MY() {
        Handler handler = this.IlO;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(100, this.Cc, 0));
        }
    }

    public void IlO(float f4) {
        int i2 = (int) f4;
        this.Cc = i2;
        if (i2 <= 0) {
            this.Cc = 5;
        }
    }

    public void IlO(IlO ilO) {
        this.EO = ilO;
    }

    public int IlO() {
        return this.vCE;
    }

    public void IlO(int i2, float f4, boolean z2) {
        com.bytedance.sdk.openadsdk.component.lEW.IlO ilO;
        if ((i2 == 1 || i2 == 2) && this.rp != z2) {
            this.rp = z2;
            if (i2 == 1 && (ilO = this.MY) != null) {
                ilO.IlO(z2);
            }
            if (z2) {
                try {
                    this.DmF = (int) (1000.0f / f4);
                    this.EV = System.currentTimeMillis();
                    return;
                } catch (Throwable unused) {
                }
            } else {
                long jCurrentTimeMillis = (System.currentTimeMillis() - this.EV) + this.NV;
                this.NV = jCurrentTimeMillis;
                com.bytedance.sdk.openadsdk.component.lEW.IlO ilO2 = this.MY;
                if (ilO2 != null) {
                    ilO2.IlO(jCurrentTimeMillis);
                }
            }
            this.DmF = 1000;
        }
    }
}
