package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.bytedance.sdk.component.lEW.lEW;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.activity.MY;
import com.bytedance.sdk.openadsdk.component.reward.EV;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.utils.mmj;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class vCE {
    public int DmF;
    public boolean EV;
    private final MY IlO;
    public int NV;
    protected com.bytedance.sdk.openadsdk.rp.vCE hp = new com.bytedance.sdk.openadsdk.rp.vCE() { // from class: com.bytedance.sdk.openadsdk.activity.vCE.1
        @Override // com.bytedance.sdk.openadsdk.rp.vCE
        public void IlO() {
            vCE.this.bWL();
        }
    };
    protected final oeT lEW;
    protected IListenerManager rp;

    public vCE(MY my, oeT oet, int i2, int i8) {
        this.IlO = my;
        this.lEW = oet;
        this.DmF = i2;
        this.NV = i8;
    }

    public abstract View IlO();

    public void IlO(Activity activity) {
    }

    public void MY(Activity activity) {
    }

    public abstract void MY(boolean z2);

    public void OOq() {
        if (this.lEW != null) {
            com.bytedance.sdk.openadsdk.vCE.MY.IlO().IlO("videoForceBreak", this.lEW);
        }
        this.IlO.IlO(this);
    }

    public abstract boolean a_();

    public abstract String b_();

    public abstract boolean es();

    public boolean kBB() {
        MY my = this.IlO;
        return my != null && my.MY(this.DmF);
    }

    public void oc() {
        if (this.IlO.cl()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
            IlO("onAdShow");
        } else {
            this.IlO.bWL();
        }
        this.IlO.cL();
    }

    public abstract com.bytedance.sdk.openadsdk.component.reward.IlO.IlO oeT();

    public MY pP() {
        return this.IlO;
    }

    public void tV(Activity activity) {
    }

    public Activity tl() {
        return this.IlO.Cc();
    }

    public final void vSq() {
        if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
            IlO("onAdVideoBarClick");
        } else {
            this.IlO.rp();
        }
    }

    public void wPn() {
        if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
            IlO("onAdClose");
        } else {
            this.IlO.hp();
        }
    }

    public abstract String xF();

    private void MY(final String str) {
        mmj.EO(new lEW("FullScreen_executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.activity.vCE.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    vCE.this.tV(1).executeFullVideoCallback(vCE.this.xF(), str);
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.oeT.EO("Scene", "fullscreen_interstitial_ad", "executeFullVideoCallback execute throw Exception : ", th);
                }
            }
        }, 5);
    }

    public void IlO(Activity activity, Bundle bundle) {
    }

    public final IListenerManager tV(int i2) {
        if (this.rp == null) {
            this.rp = IListenerManager.Stub.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.IlO.IlO().IlO(i2));
        }
        return this.rp;
    }

    public void IlO(Activity activity, MY.Cc cc) {
    }

    public void IlO(vCE vce, vCE vce2, MY.Cc cc) {
    }

    public void IlO(boolean z2, boolean z7, boolean z8, int i2) {
        this.IlO.IlO(this, z2, z7, z8, i2);
    }

    public void IlO(String str) {
        if (a_()) {
            IlO(str, false, 0, "", 0, "");
        } else {
            MY(str);
        }
    }

    private void IlO(final String str, final boolean z2, final int i2, final String str2, final int i8, final String str3) {
        mmj.EO(new lEW("Reward_executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.activity.vCE.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    vCE.this.tV(0).executeRewardVideoCallback(vCE.this.xF(), str, z2, i2, str2, i8, str3);
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.oeT.EO("Scene", "rewarded_video", "executeRewardVideoCallback execute throw Exception : ", th);
                }
            }
        }, 5);
    }

    public final void IlO(boolean z2, int i2, String str, int i8, String str2, int i9) {
        if (this.IlO.ea()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
            IlO("onRewardVerify", z2, i2, str, i8, str2);
        } else {
            this.IlO.IlO(this, z2, i2, str, i8, str2);
        }
        EV.IlO(this.lEW, z2, i9);
    }

    public void bWL() {
    }

    public void cl() {
    }

    public void ea() {
    }

    public void Cc(Activity activity) {
    }

    public void EO(Activity activity) {
    }
}
