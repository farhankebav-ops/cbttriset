package com.bytedance.sdk.openadsdk.IlO.MY;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.xF;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.rp.MY.vCE;
import com.bytedance.sdk.openadsdk.core.zPa;
import com.bytedance.sdk.openadsdk.multipro.MY.IlO;
import com.bytedance.sdk.openadsdk.utils.zLG;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.util.List;
import w.a;
import w.d;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY extends lEW implements a, d, IlO.InterfaceC0114IlO {
    private final com.bytedance.sdk.openadsdk.multipro.MY.IlO DmF;
    private boolean EV;
    private boolean NV;
    private long hp;
    private EO lEW;
    private AdSlot rp;

    public MY(@NonNull Context context, @NonNull oeT oet, int i2, AdSlot adSlot) {
        super(context, oet, i2, true);
        this.NV = false;
        this.EV = true;
        this.Cc = i2;
        this.rp = adSlot;
        this.DmF = new com.bytedance.sdk.openadsdk.multipro.MY.IlO();
        IlO(this.vCE);
        IlO("embeded_ad");
        this.tV.IlO(this);
    }

    public View Cc() {
        com.bytedance.sdk.openadsdk.core.rp.MY.vCE vce;
        oeT oet = this.MY;
        if (oet != null && this.EO != null) {
            if (oeT.Cc(oet)) {
                try {
                    vce = new com.bytedance.sdk.openadsdk.core.rp.MY.vCE(this.EO, this.MY, this.IlO.IlO());
                    oeT oet2 = this.MY;
                    if (oet2 != null && oet2.xJ()) {
                        com.bytedance.sdk.openadsdk.core.EV.vCE vceIlO = vce.IlO((List<Pair<View, FriendlyObstructionPurpose>>) null);
                        IlO ilO = this.tV;
                        if (ilO != null) {
                            ilO.IlO(vceIlO);
                        }
                    }
                    this.IlO.IlO(vce.getNativeVideoController());
                    IlO ilO2 = this.tV;
                    if (ilO2 != null) {
                        ilO2.IlO(vce);
                    }
                    vce.setVideoAdClickListenerTTNativeAd(this);
                    vce.setAdCreativeClickListener(new vCE.IlO() { // from class: com.bytedance.sdk.openadsdk.IlO.MY.MY.1
                        @Override // com.bytedance.sdk.openadsdk.core.rp.MY.vCE.IlO
                        public void IlO(View view, int i2) {
                            zPa zpa = MY.this.IlO;
                            if (zpa != null) {
                                zpa.IlO(view, i2);
                            }
                        }
                    });
                    vce.setControllerStatusCallBack(new vCE.MY() { // from class: com.bytedance.sdk.openadsdk.IlO.MY.MY.2
                        @Override // com.bytedance.sdk.openadsdk.core.rp.MY.vCE.MY
                        public void IlO(boolean z2, long j, long j3, long j8, boolean z7) {
                            MY.this.DmF.IlO = z2;
                            MY.this.DmF.Cc = j;
                            MY.this.DmF.vCE = j3;
                            MY.this.DmF.Bc = j8;
                            MY.this.DmF.tV = z7;
                        }
                    });
                    vce.setVideoAdLoadListener(this);
                    vce.setVideoAdInteractionListener(this);
                    if (5 == this.Cc) {
                        vce.setIsAutoPlay(this.NV ? this.rp.isAutoPlay() : this.EV);
                    } else {
                        vce.setIsAutoPlay(this.EV);
                    }
                    vce.IlO(cl.tV().MY(String.valueOf(this.vCE)), "feedGetAdView");
                } catch (Exception e) {
                    ApmHelper.reportCustomError("", "getAdView null", e);
                    vce = null;
                }
                if (!oeT.Cc(this.MY) && vce != null && vce.IlO(0L, true, false)) {
                    return vce;
                }
                ApmHelper.reportCustomError(this.MY.uI() + "," + vce, "getAdView null", new RuntimeException());
            } else {
                vce = null;
                if (!oeT.Cc(this.MY)) {
                }
                ApmHelper.reportCustomError(this.MY.uI() + "," + vce, "getAdView null", new RuntimeException());
            }
        }
        return null;
    }

    @Override // w.a
    public void e_() {
        EO eo = this.lEW;
        if (eo != null) {
            eo.IlO(this);
        }
    }

    @Override // w.a
    public void f_() {
        EO eo = this.lEW;
        if (eo != null) {
            eo.MY(this);
        }
    }

    @Override // w.a
    public void h_() {
        EO eo = this.lEW;
        if (eo != null) {
            eo.EO(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.IlO.MY.lEW, com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd
    public void showPrivacyActivity() {
        IlO ilO = this.tV;
        if (ilO != null) {
            ilO.rp();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.MY.IlO.InterfaceC0114IlO
    public com.bytedance.sdk.openadsdk.multipro.MY.IlO vCE() {
        return this.DmF;
    }

    private void IlO(int i2) {
        int iMY = cl.tV().MY(i2);
        int iEO = xF.EO(cl.IlO());
        if (3 == iMY) {
            this.NV = false;
            this.EV = false;
        } else {
            if (1 == iMY && zLG.tV(iEO)) {
                this.NV = false;
            } else if (2 == iMY) {
                if (zLG.Cc(iEO) || zLG.tV(iEO) || zLG.vCE(iEO)) {
                    this.NV = false;
                }
            } else if (4 == iMY) {
                this.NV = true;
            } else if (5 == iMY && (zLG.tV(iEO) || zLG.vCE(iEO))) {
            }
            this.EV = true;
        }
        IlO ilO = this.tV;
        if (ilO != null) {
            ilO.IlO(this.NV);
        }
    }

    public MY(@NonNull Context context, @NonNull oeT oet, int i2, AdSlot adSlot, IlO ilO, zPa zpa) {
        super(context, oet, i2, false);
        this.NV = false;
        this.EV = true;
        this.tV = ilO;
        this.IlO = zpa;
        this.Cc = i2;
        this.rp = adSlot;
        this.DmF = new com.bytedance.sdk.openadsdk.multipro.MY.IlO();
        IlO(this.vCE);
        IlO("embeded_ad");
        ilO.IlO(this);
    }

    public void IlO(EO eo) {
        this.lEW = eo;
    }

    @Override // w.d
    public void IlO(int i2, int i8) {
        EO eo = this.lEW;
        if (eo != null) {
            eo.IlO(i2, i8);
        }
    }

    @Override // w.a
    public void IlO(long j, long j3) {
        this.hp = j;
    }

    @Override // com.bytedance.sdk.openadsdk.IlO.MY.lEW
    public void IlO(String str) {
        super.IlO(str);
    }

    @Override // w.a
    public void g_() {
    }
}
