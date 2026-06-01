package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity;
import com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.core.rp.tV.IlO;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class dY implements Handler.Callback, IlO.InterfaceC0108IlO {
    private boolean Bc;
    private final com.bytedance.sdk.openadsdk.component.reward.IlO.IlO Cc;
    private boolean DmF;
    private int NV;
    private boolean lEW;
    private int rp;
    private final com.bytedance.sdk.openadsdk.core.model.oeT tV;
    private boolean vCE;
    private float IlO = 1.0f;
    private int MY = 1000;
    private final Handler EO = new Handler(Looper.getMainLooper(), this);
    private int EV = 0;

    public dY(@NonNull com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO, @NonNull com.bytedance.sdk.openadsdk.core.model.oeT oet) {
        this.NV = 0;
        this.rp = 0;
        this.Cc = ilO;
        this.tV = oet;
        if (oet.EJ()) {
            if (oet.MY() >= 0) {
                this.rp = oet.MY();
            } else {
                this.rp = com.bytedance.sdk.openadsdk.core.cl.tV().DmF(String.valueOf(oet.hFV()));
            }
        } else if (oet.hS()) {
            if (oet.IlO() >= 0) {
                this.rp = oet.IlO();
            } else {
                this.rp = com.bytedance.sdk.openadsdk.core.cl.tV().cL(String.valueOf(oet.hFV()));
            }
        }
        this.NV = (int) ilO.vAh.YA();
        com.bytedance.sdk.component.utils.oeT.IlO("TTAD.TopLayoutHelper", "totalTime: " + this.NV + ", skipTime=" + this.rp);
    }

    public void Cc() {
        this.EO.removeMessages(1024);
        this.vCE = false;
        this.lEW = true;
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.Cc;
        if (ilO != null) {
            ilO.vAh.oc();
        }
    }

    public void EO() {
        if (this.vCE) {
            this.EO.removeMessages(1024);
            this.EO.sendEmptyMessage(1024);
            this.Bc = false;
        }
    }

    public boolean IlO() {
        return this.vCE;
    }

    public void MY() {
        this.EO.sendEmptyMessage(1024);
        this.Bc = false;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        if (message.what == 1024) {
            int i2 = this.NV;
            int i8 = this.EV;
            int i9 = i2 - i8;
            this.Cc.vAh.IlO(((long) i8) * 1000);
            com.bytedance.sdk.component.utils.oeT.IlO("TTAD.TopLayoutHelper", "handleMessage: currentTime= " + this.EV + ", mRemainTimeInSeconds=" + i9);
            if (i9 > 0) {
                Activity activity = this.Cc.BS;
                if (activity instanceof TTRewardVideoActivity) {
                    ((TTRewardVideoActivity) activity).MY(((long) this.EV) * 1000, this.NV);
                }
                com.bytedance.sdk.openadsdk.component.reward.view.lEW lew = this.Cc.tl;
                boolean z2 = false;
                if (lew != null && lew.IlO() != null) {
                    this.Cc.tl.IlO().setTime(String.valueOf(i9), this.EV, 0, false);
                }
                if (this.tV.EJ()) {
                    com.bytedance.sdk.openadsdk.component.reward.view.lEW lew2 = this.Cc.tl;
                    if (lew2 != null) {
                        if (lew2.lEW() && this.rp > 0) {
                            z2 = true;
                        }
                        this.DmF = z2;
                    }
                    if (!this.DmF || this.EV < this.rp || this.Cc.MY.vAh() == 5 || this.Cc.MY.vAh() == 33) {
                        this.Cc.YA.IlO(String.valueOf(i9), null);
                    } else {
                        this.Cc.IlO(true);
                        this.Cc.YA.IlO(String.valueOf(i9), TTAdDislikeToast.getSkipText());
                        this.Cc.YA.Cc(true);
                    }
                } else if (this.tV.hS() && (this.Cc.tl.lEW() || this.Cc.MY.pS())) {
                    Activity activity2 = this.Cc.BS;
                    if (activity2 instanceof TTFullScreenVideoActivity) {
                        ((TTFullScreenVideoActivity) activity2).EO(this.EV);
                    }
                    this.Cc.YA.tV(true);
                    this.Cc.YA.IlO(String.valueOf(i9), null);
                }
                this.EV++;
                if (this.Cc.vAh.EO()) {
                    com.bytedance.sdk.openadsdk.core.model.oc ocVarEeU = this.Cc.MY.eeU();
                    if (ocVarEeU != null) {
                        float fIlO = ocVarEeU.IlO();
                        this.IlO = fIlO;
                        if (fIlO <= 0.0f) {
                            this.IlO = 1.0f;
                        }
                    }
                } else {
                    this.IlO = 1.0f;
                }
                int i10 = (int) (1000.0f / this.IlO);
                com.bytedance.sdk.component.utils.oeT.IlO("TTAD.TopLayoutHelper", "handleMessage: next msg intervalInMillis = ".concat(String.valueOf(i10)));
                this.EO.sendEmptyMessageDelayed(message.what, i10);
            }
        }
        return true;
    }

    public void tV() {
        if (!this.vCE || this.Bc) {
            return;
        }
        this.EO.removeMessages(1024);
        this.Bc = true;
    }

    public void IlO(long j) {
        int iCeil = (int) Math.ceil(j / 1000.0d);
        if (this.Bc && !this.lEW) {
            this.EV = iCeil;
            EO();
        } else {
            if (this.vCE || this.lEW) {
                return;
            }
            this.EV = iCeil;
            this.vCE = true;
            MY();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.IlO.InterfaceC0108IlO
    public void IlO(int i2) {
        com.bytedance.sdk.component.utils.oeT.IlO("TTAD.TopLayoutHelper", "onPlayerStateChanged: ".concat(String.valueOf(i2)));
        if (i2 == 1) {
            EO();
            return;
        }
        if (i2 == 2) {
            tV();
        } else if (i2 == 3 || i2 == 4) {
            Cc();
        }
    }
}
