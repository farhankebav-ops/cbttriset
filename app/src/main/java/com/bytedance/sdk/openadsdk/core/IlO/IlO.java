package com.bytedance.sdk.openadsdk.core.IlO;

import androidx.camera.core.processing.util.a;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.cl.EO;
import com.bytedance.sdk.openadsdk.cl.tV;
import com.bytedance.sdk.openadsdk.core.xF;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.bytedance.sdk.openadsdk.utils.zLG;
import com.vungle.ads.internal.Constants;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO implements xF.IlO {
    private final xF.IlO IlO;
    private final AdSlot MY;

    public IlO(xF.IlO ilO, AdSlot adSlot) {
        this.IlO = ilO;
        this.MY = adSlot;
    }

    @Override // com.bytedance.sdk.openadsdk.core.xF.IlO
    public void IlO(final int i2, final String str) {
        AdSlot adSlot;
        if (this.IlO != null) {
            if (mmj.vCE() || !((adSlot = this.MY) == null || adSlot.getDurationSlotType() == 5 || com.bytedance.sdk.openadsdk.AXM.IlO.IlO("getads_callback_async", 0) != 1)) {
                this.IlO.IlO(i2, str);
            } else {
                mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.IlO.IlO.1
                    @Override // java.lang.Runnable
                    public void run() {
                        IlO.this.IlO.IlO(i2, str);
                    }
                });
            }
            AdSlot adSlot2 = this.MY;
            if (adSlot2 == null || adSlot2.isPreload()) {
                return;
            }
            EO.EO(new tV() { // from class: com.bytedance.sdk.openadsdk.core.IlO.IlO.2
                @Override // com.bytedance.sdk.openadsdk.cl.tV
                public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                    com.bytedance.sdk.openadsdk.cl.MY.IlO ilOD = a.d(Constants.LOAD_AD);
                    ilOD.EO(IlO.this.MY.getCodeId());
                    ilOD.tV(zLG.EO(IlO.this.MY.getDurationSlotType()));
                    ilOD.IlO(BuildConfig.VERSION_NAME);
                    ilOD.Bc(zLG.IlO(IlO.this.MY).toString());
                    return ilOD;
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.xF.IlO
    public void IlO(final com.bytedance.sdk.openadsdk.core.model.IlO ilO, final com.bytedance.sdk.openadsdk.core.model.EO eo) {
        AdSlot adSlot;
        if (this.IlO != null) {
            if (!mmj.vCE() && ((adSlot = this.MY) == null || adSlot.getDurationSlotType() == 5 || com.bytedance.sdk.openadsdk.AXM.IlO.IlO("getads_callback_async", 0) != 1)) {
                mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.IlO.IlO.3
                    @Override // java.lang.Runnable
                    public void run() {
                        IlO.this.IlO.IlO(ilO, eo);
                    }
                });
            } else {
                this.IlO.IlO(ilO, eo);
            }
            AdSlot adSlot2 = this.MY;
            if (adSlot2 == null || adSlot2.isPreload()) {
                return;
            }
            EO.MY(new tV() { // from class: com.bytedance.sdk.openadsdk.core.IlO.IlO.4
                @Override // com.bytedance.sdk.openadsdk.cl.tV
                public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                    com.bytedance.sdk.openadsdk.cl.MY.IlO ilOD = a.d(Constants.LOAD_AD);
                    ilOD.EO(IlO.this.MY.getCodeId());
                    ilOD.tV(zLG.EO(IlO.this.MY.getDurationSlotType()));
                    ilOD.IlO(BuildConfig.VERSION_NAME);
                    ilOD.Bc(zLG.IlO(IlO.this.MY).toString());
                    return ilOD;
                }
            });
        }
    }
}
