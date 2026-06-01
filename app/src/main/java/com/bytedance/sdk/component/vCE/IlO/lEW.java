package com.bytedance.sdk.component.vCE.IlO;

import android.content.Context;
import com.vungle.ads.internal.signals.SignalManager;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class lEW {
    private static volatile com.bytedance.sdk.component.vCE.IlO.Cc.IlO NV;
    private static lEW hp;
    private volatile com.bytedance.sdk.component.vCE.IlO.IlO.Cc Bc;
    private volatile com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO Cc;
    private volatile Cc DmF;
    private volatile com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO EO;
    private volatile com.bytedance.sdk.component.vCE.IlO.MY.EO EV;
    private volatile Context IlO;
    private volatile com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO MY;
    private final AtomicBoolean bWL = new AtomicBoolean(false);
    private long ea;
    private volatile boolean lEW;
    private volatile Map<Integer, com.bytedance.sdk.component.vCE.IlO.MY.EO> rp;
    private volatile com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO tV;
    private volatile com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO vCE;

    private lEW() {
    }

    public static synchronized lEW Bc() {
        try {
            if (hp == null) {
                hp = new lEW();
            }
        } catch (Throwable th) {
            throw th;
        }
        return hp;
    }

    public static com.bytedance.sdk.component.vCE.IlO.Cc.IlO Cc() {
        if (NV == null) {
            synchronized (lEW.class) {
                try {
                    if (NV == null) {
                        NV = new com.bytedance.sdk.component.vCE.IlO.Cc.MY();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return NV;
    }

    public void DmF() {
        com.bytedance.sdk.component.vCE.IlO.MY.tV.IlO.MY();
    }

    public Map<Integer, com.bytedance.sdk.component.vCE.IlO.MY.EO> EO() {
        return this.rp;
    }

    public void EV() {
        com.bytedance.sdk.component.vCE.IlO.MY.tV.IlO.EO();
    }

    public boolean IlO() {
        return this.bWL.get();
    }

    public boolean MY() {
        return this.lEW;
    }

    public com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO NV() {
        return this.vCE;
    }

    public com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO bWL() {
        return this.tV;
    }

    public long cl() {
        return this.ea * SignalManager.TWENTY_FOUR_HOURS_MILLIS;
    }

    public com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO ea() {
        return this.Cc;
    }

    public com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO hp() {
        return this.EO;
    }

    public com.bytedance.sdk.component.vCE.IlO.MY.EO lEW() {
        return this.EV;
    }

    public com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO rp() {
        return this.MY;
    }

    public com.bytedance.sdk.component.vCE.IlO.IlO.Cc tV() {
        return this.Bc;
    }

    public Context vCE() {
        return this.IlO;
    }

    public Cc zPa() {
        return this.DmF;
    }

    public void EO(com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO ilO) {
        this.EO = ilO;
    }

    public void IlO(boolean z2) {
        this.bWL.set(z2);
    }

    public void MY(boolean z2) {
        this.lEW = z2;
    }

    public void tV(com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO ilO) {
        this.tV = ilO;
    }

    public void IlO(com.bytedance.sdk.component.vCE.IlO.IlO.Cc cc) {
        this.Bc = cc;
    }

    public void MY(com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO ilO) {
        this.MY = ilO;
    }

    public void IlO(Context context) {
        this.IlO = context;
    }

    public void IlO(com.bytedance.sdk.component.vCE.IlO.MY.EO eo) {
        this.EV = eo;
    }

    public void IlO(com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO ilO) {
        this.vCE = ilO;
    }

    public void Cc(com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO ilO) {
        this.Cc = ilO;
    }

    public void IlO(com.bytedance.sdk.component.vCE.IlO.tV.IlO ilO) {
        if (ilO == null) {
            return;
        }
        ilO.IlO(System.currentTimeMillis());
        com.bytedance.sdk.component.vCE.IlO.MY.tV.IlO.IlO(ilO, ilO.tV());
    }

    public void IlO(String str, boolean z2) {
        com.bytedance.sdk.component.vCE.IlO.vCE.IlO.IlO().IlO(str, z2);
    }

    public void IlO(String str, List<String> list, boolean z2, Map<String, String> map, int i2, String str2) {
        com.bytedance.sdk.component.vCE.IlO.vCE.IlO.IlO().IlO(str, list, z2, map, i2, str2);
    }

    public void IlO(Cc cc) {
        this.DmF = cc;
    }

    public void IlO(long j) {
        this.ea = j;
    }
}
