package com.bytedance.sdk.openadsdk.component.lEW;

import android.content.Context;
import android.widget.FrameLayout;
import b0.b;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.core.MY.IlO;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.tV.Cc.MY.ea;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO implements IlO.InterfaceC0087IlO {
    private boolean Cc = false;
    private oeT EO;
    private Context IlO;
    private FrameLayout MY;
    private MY tV;

    public EO(Context context) {
        this.IlO = context.getApplicationContext();
    }

    public boolean Bc() {
        MY my = this.tV;
        return my != null && my.hp();
    }

    public boolean Cc() {
        MY my = this.tV;
        return (my == null || my.NV() == null || !this.tV.NV().vCE()) ? false : true;
    }

    public void DmF() {
        try {
            if (vCE()) {
                EV();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("TTAppOpenVideoManager", "onContinue throw Exception :" + th.getMessage());
        }
    }

    public boolean EO() {
        return this.Cc;
    }

    public void EV() {
        MY my = this.tV;
        if (my != null) {
            my.MY();
        }
    }

    public void IlO(FrameLayout frameLayout, oeT oet) {
        this.MY = frameLayout;
        this.EO = oet;
        this.tV = new MY(this.IlO, frameLayout, oet);
    }

    public MY MY() {
        return this.tV;
    }

    public void NV() {
        MY my = this.tV;
        if (my == null) {
            return;
        }
        my.EO();
        this.tV = null;
    }

    public long bWL() {
        MY my = this.tV;
        if (my != null) {
            return my.vCE();
        }
        return 0L;
    }

    public long ea() {
        MY my = this.tV;
        if (my == null) {
            return 0L;
        }
        return this.tV.vCE() + my.lEW();
    }

    @Override // com.bytedance.sdk.openadsdk.core.MY.IlO.InterfaceC0087IlO
    public long getVideoProgress() {
        return hp();
    }

    public long hp() {
        MY my = this.tV;
        if (my != null) {
            return my.Cc();
        }
        return 0L;
    }

    public void lEW() {
        try {
            if (Cc()) {
                this.tV.IlO();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("TTAppOpenVideoManager", "open_ad", "AppOpenVideoManager onPause throw Exception :" + th.getMessage());
        }
    }

    public void rp() {
        MY my = this.tV;
        if (my == null) {
            return;
        }
        this.IlO = null;
        my.EO();
        this.tV = null;
    }

    public boolean tV() {
        MY my = this.tV;
        return (my == null || my.NV() == null || !this.tV.NV().MY()) ? false : true;
    }

    public boolean vCE() {
        MY my = this.tV;
        return (my == null || my.NV() == null || !this.tV.NV().Bc()) ? false : true;
    }

    public boolean IlO() {
        com.bytedance.sdk.openadsdk.core.rp.IlO.MY myIlO = oeT.IlO(((b) CacheDirFactory.getICacheDir(0)).d(), this.EO);
        myIlO.MY(this.EO.ED());
        myIlO.MY(this.MY.getWidth());
        myIlO.EO(this.MY.getHeight());
        myIlO.EO(this.EO.KT());
        myIlO.IlO(0L);
        myIlO.IlO(true);
        return this.tV.IlO(myIlO);
    }

    public void IlO(boolean z2) {
        this.Cc = z2;
    }

    public void IlO(w.b bVar) {
        MY my = this.tV;
        if (my != null) {
            my.IlO(bVar);
        }
    }

    public boolean IlO(FrameLayout frameLayout, com.bytedance.sdk.openadsdk.component.IlO ilO, oeT oet) {
        IlO(frameLayout, oet);
        IlO(ilO);
        try {
            return IlO();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("TTAppOpenVideoManager", "open_ad", "ttAppOpenAd playVideo error: " + th.getMessage());
            return false;
        }
    }

    public boolean IlO(float f4) {
        try {
            MY my = this.tV;
            if (my != null) {
                return my.IlO(f4);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("TTAppOpenVideoManager", "open_ad", "setPlaybackSpeed error: " + th.getMessage());
        }
        return false;
    }

    public void IlO(int i2) {
        if (this.tV != null) {
            ea.IlO ilO = new ea.IlO();
            ilO.MY(hp());
            ilO.tV(ea());
            ilO.EO(bWL());
            ilO.EO(i2);
            ilO.tV(this.tV.Bc());
            ilO.IlO(this.tV.zPa());
            this.tV.IlO(ilO);
        }
    }
}
