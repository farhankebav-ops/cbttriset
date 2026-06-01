package com.bytedance.sdk.openadsdk.component.reward.IlO;

import android.os.Handler;
import android.os.Message;
import com.bytedance.sdk.component.utils.oeT;
import com.bytedance.sdk.component.utils.pP;
import com.bytedance.sdk.openadsdk.core.model.OOq;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Bc extends NV implements Handler.Callback {
    int Cc;
    int EO;
    boolean IlO;
    long MY;
    private final Handler es;
    int tV;
    boolean vCE;

    public Bc(IlO ilO) {
        super(ilO);
        this.es = new Handler(this);
        this.IlO = false;
        this.MY = 0L;
        this.EO = 0;
        this.tV = 0;
        this.Cc = 0;
        this.vCE = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rp() {
        boolean z2 = false;
        boolean z7 = (1.0f - (((float) this.EO) / ((float) this.tV))) * 100.0f >= ((float) com.bytedance.sdk.openadsdk.core.cl.tV().tl(String.valueOf(this.EV.vCE)).vCE);
        int iIlO = com.bytedance.sdk.openadsdk.core.cl.tV().IlO(String.valueOf(this.EV.vCE));
        if (iIlO == 0) {
            com.bytedance.sdk.openadsdk.xF.IlO.IlO ilO = this.cl;
            boolean zVCE = ilO != null ? ilO.vCE() : false;
            if (this.bWL) {
                zVCE = true;
            }
            if (z7 && zVCE) {
                z2 = true;
            }
        } else if (iIlO == 1) {
            z2 = z7;
        }
        if (z2) {
            this.EV.ssS.IlO(true);
        }
    }

    public int Bc() {
        return this.EO;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.IlO.NV
    public void Cc() {
        if (this.hp) {
            super.Cc();
            if (OOq.EO(this.EV.MY)) {
                this.EV.HSR.removeMessages(600);
            }
            this.es.removeMessages(900);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.IlO.NV
    public boolean DmF() {
        return this.vCE;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.IlO.NV
    public void EO() {
        if (this.hp) {
            this.Bc = true;
            this.cl.IlO();
            if (OOq.NV(this.DmF)) {
                this.EV.lMM.vCE();
            }
            this.tV = this.DmF.XvI();
            this.Cc = com.bytedance.sdk.openadsdk.core.cl.tV().IlO(String.valueOf(this.EV.vCE), this.DmF.EJ());
            this.MY = System.currentTimeMillis();
            Handler handler = this.es;
            handler.sendMessage(handler.obtainMessage(900, this.tV, 0));
            this.EV.ssS.EV();
            com.bytedance.sdk.openadsdk.component.reward.EV ev = this.EV.PTq;
            if (ev != null) {
                ev.IlO(this.tV);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.IlO.NV
    public com.bytedance.sdk.openadsdk.rp.vCE MY() {
        return new com.bytedance.sdk.openadsdk.rp.vCE() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.Bc.1
            @Override // com.bytedance.sdk.openadsdk.rp.vCE
            public void IlO() {
                Bc.this.rp();
            }
        };
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 900 && this.Bc && OOq.EO(this.EV.MY) && !this.cL.get()) {
            int i2 = message.arg1;
            if (i2 > 0) {
                this.EV.YA.tV(true);
                int i8 = this.Cc - (this.tV - i2);
                if (i8 == i2) {
                    this.EV.YA.IlO(String.valueOf(i2), null);
                } else if (i8 > 0) {
                    this.EV.YA.IlO(String.valueOf(i2), String.format(pP.IlO(this.EV.BS.getApplicationContext(), "tt_skip_ad_time_text"), Integer.valueOf(i8)));
                } else {
                    this.vCE = true;
                    if (OOq.NV(this.EV.MY)) {
                        this.EV.YA.EO();
                        this.EV.YA.Cc(true);
                    } else {
                        this.EV.es.set(true);
                        this.EV.qz.ea();
                    }
                }
                Message messageObtain = Message.obtain();
                messageObtain.what = 900;
                int i9 = i2 - 1;
                messageObtain.arg1 = i9;
                this.es.sendMessageDelayed(messageObtain, 1000L);
                this.EO = i9;
            } else {
                this.vCE = true;
                if (!OOq.NV(this.DmF) || (OOq.vAh(this.DmF) && this.cl.Cc())) {
                    this.EV.YA.tV(false);
                    this.EV.es.set(true);
                    this.EV.qz.ea();
                } else {
                    this.EV.YA.EO();
                    this.EV.YA.Cc(true);
                }
                com.bytedance.sdk.openadsdk.xF.IlO.IlO ilO = this.cl;
                if (ilO == null || ilO.Cc()) {
                    this.bWL = true;
                }
            }
            rp();
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.IlO.NV
    public void lEW() {
        if (this.hp) {
            this.es.removeMessages(900);
            this.es.removeMessages(600);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.IlO.NV
    public void tV() {
        com.bytedance.sdk.openadsdk.core.widget.MY my;
        if (this.hp) {
            super.tV();
            if (DeviceUtils.Bc() == 0) {
                this.EV.uvo = true;
            }
            IlO ilO = this.EV;
            if (ilO.uvo) {
                ilO.YA.MY(true);
                EO(true);
            }
            com.bytedance.sdk.openadsdk.component.reward.MY.MY my2 = this.EV.qz;
            if ((my2 == null || (my = my2.hp) == null || !my.isShowing()) && Bc() > 0) {
                IlO(0L);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.IlO.NV
    public void vCE() {
        if (this.hp && !this.ea) {
            super.vCE();
            this.es.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.IlO.NV
    public void IlO() {
        if (this.hp && !this.rp) {
            super.IlO();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.IlO.NV
    public void IlO(boolean z2) {
        if (this.zPa != null) {
            try {
                com.bytedance.sdk.openadsdk.xF.IlO.MY myIlO = com.bytedance.sdk.openadsdk.xF.IlO.tV.IlO().IlO(this.DmF, this.zPa, MY());
                this.cl = myIlO;
                myIlO.IlO(this.EV.ssS);
            } catch (Throwable unused) {
                oeT.EO("RVIVPlayableNewManager", "PreRender injection exception");
            }
            if (this.cl == null) {
                super.IlO(z2);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.IlO.NV
    public void IlO(int i2) {
        this.EO = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.IlO.NV
    public void IlO(long j) {
        if (this.hp && this.Bc) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 900;
            messageObtain.arg1 = Bc();
            this.es.sendMessageDelayed(messageObtain, j);
        }
    }
}
