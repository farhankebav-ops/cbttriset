package com.bytedance.sdk.component.adexpress.dynamic.IlO;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.EO;
import com.bytedance.sdk.component.adexpress.MY.Bc;
import com.bytedance.sdk.component.adexpress.MY.EV;
import com.bytedance.sdk.component.adexpress.MY.bWL;
import com.bytedance.sdk.component.adexpress.MY.hp;
import com.bytedance.sdk.component.adexpress.MY.lEW;
import com.bytedance.sdk.component.adexpress.MY.tV;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicRootView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.mmj;
import com.bytedance.sdk.component.adexpress.dynamic.tV.vCE;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.utils.DmF;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO implements EV, tV<DynamicRootView> {
    private ScheduledFuture<?> Bc;
    private lEW Cc;
    private Context EO;
    private DynamicRootView IlO;
    private com.bytedance.sdk.component.adexpress.dynamic.Cc.lEW MY;
    private AtomicBoolean lEW = new AtomicBoolean(false);
    private Bc tV;
    private hp vCE;

    /* JADX INFO: renamed from: com.bytedance.sdk.component.adexpress.dynamic.IlO.IlO$IlO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class RunnableC0051IlO implements Runnable {
        private int MY;

        public RunnableC0051IlO(int i2) {
            this.MY = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.MY == 2) {
                IlO.this.IlO.callBackRenderFail(IlO.this.MY instanceof com.bytedance.sdk.component.adexpress.dynamic.Cc.Bc ? 127 : Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE, null);
            }
        }
    }

    public IlO(Context context, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z2, com.bytedance.sdk.component.adexpress.dynamic.Cc.lEW lew, hp hpVar, com.bytedance.sdk.component.adexpress.dynamic.vCE.IlO ilO) {
        this.EO = context;
        DynamicRootView dynamicRootView = new DynamicRootView(context, themeStatusBroadcastReceiver, z2, hpVar, ilO);
        this.IlO = dynamicRootView;
        this.MY = lew;
        this.vCE = hpVar;
        dynamicRootView.setRenderListener(this);
        this.vCE = hpVar;
    }

    private boolean Bc() {
        DynamicRootView dynamicRootView = this.IlO;
        return (dynamicRootView == null || dynamicRootView.getChildCount() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lEW() {
        try {
            ScheduledFuture<?> scheduledFuture = this.Bc;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.Bc.cancel(false);
            this.Bc = null;
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vCE() {
        this.vCE.Cc().MY(EO());
        JSONObject jSONObjectEO = this.vCE.EO();
        if (com.bytedance.sdk.component.adexpress.IlO.MY.MY.IlO(jSONObjectEO)) {
            this.MY.IlO(new com.bytedance.sdk.component.adexpress.dynamic.vCE.MY() { // from class: com.bytedance.sdk.component.adexpress.dynamic.IlO.IlO.2
                @Override // com.bytedance.sdk.component.adexpress.dynamic.vCE.MY
                public void IlO(final com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew) {
                    IlO.this.lEW();
                    IlO.this.vCE.Cc().EO(IlO.this.EO());
                    IlO.this.IlO(lew);
                    IlO.this.MY(lew);
                    if (Looper.getMainLooper() == Looper.myLooper()) {
                        IlO.this.EO(lew);
                    } else {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.IlO.IlO.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                IlO.this.EO(lew);
                            }
                        });
                    }
                    if (IlO.this.IlO == null || lew == null) {
                        return;
                    }
                    IlO.this.IlO.setBgColor(lew.IlO());
                    IlO.this.IlO.setBgMaterialCenterCalcColor(lew.MY());
                }
            });
            this.MY.IlO(this.vCE);
            return;
        }
        int i2 = this.MY instanceof com.bytedance.sdk.component.adexpress.dynamic.Cc.Bc ? Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE : 113;
        DynamicRootView dynamicRootView = this.IlO;
        StringBuilder sb = new StringBuilder("data null is ");
        sb.append(jSONObjectEO == null);
        dynamicRootView.callBackRenderFail(i2, sb.toString());
    }

    public DynamicRootView tV() {
        return this.IlO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MY(com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew) {
        float fBc;
        float fVCE;
        List<com.bytedance.sdk.component.adexpress.dynamic.tV.lEW> listEV;
        if (lew == null) {
            return;
        }
        List<com.bytedance.sdk.component.adexpress.dynamic.tV.lEW> listEV2 = lew.EV();
        if (listEV2 == null || listEV2.size() <= 0) {
            fBc = 0.0f;
        } else {
            fBc = 0.0f;
            for (com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew2 : listEV2) {
                if (lew2.Bc() > lew.Bc() - lew2.DmF() || (listEV = lew2.EV()) == null || listEV.size() <= 0) {
                    fVCE = 0.0f;
                } else {
                    fVCE = 0.0f;
                    for (com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew3 : listEV) {
                        if (lew3.NV().MY().equals("logo-union")) {
                            fVCE = lew3.NV().vCE();
                            fBc = ((lew.Bc() + (-fVCE)) - lew2.Bc()) + lew2.NV().Cc().eDn();
                        }
                    }
                }
                MY(lew2);
                if (fVCE <= -15.0f) {
                    lew2.vCE(lew2.DmF() - fVCE);
                    lew2.tV(lew2.Bc() + fVCE);
                    for (com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew4 : lew2.EV()) {
                        lew4.tV(lew4.Bc() - fVCE);
                    }
                }
            }
        }
        com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lewRp = lew.rp();
        if (lewRp == null) {
            return;
        }
        float fVCE2 = lew.vCE() - lewRp.vCE();
        float fBc2 = lew.Bc() - lewRp.Bc();
        lew.EO(fVCE2);
        lew.tV(fBc2);
        if (fBc > 0.0f) {
            lew.tV(lew.Bc() - fBc);
            lew.vCE(lew.DmF() + fBc);
            for (com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew5 : lew.EV()) {
                lew5.tV(lew5.Bc() + fBc);
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.tV
    public int EO() {
        return this.MY instanceof com.bytedance.sdk.component.adexpress.dynamic.Cc.Bc ? 3 : 2;
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.tV
    public void IlO(Bc bc) {
        this.tV = bc;
        int iVCE = this.vCE.vCE();
        if (iVCE < 0) {
            this.IlO.callBackRenderFail(this.MY instanceof com.bytedance.sdk.component.adexpress.dynamic.Cc.Bc ? 127 : Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE, "time is ".concat(String.valueOf(iVCE)));
            return;
        }
        this.Bc = com.bytedance.sdk.component.adexpress.tV.tV.IlO(new RunnableC0051IlO(2), iVCE, TimeUnit.MILLISECONDS);
        if (Looper.getMainLooper() == Looper.myLooper() && this.vCE.DmF() <= 0) {
            vCE();
        } else {
            DmF.MY().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.IlO.IlO.1
                @Override // java.lang.Runnable
                public void run() {
                    IlO.this.vCE();
                }
            }, this.vCE.DmF());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EO(com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew) {
        if (lew == null) {
            this.IlO.callBackRenderFail(this.MY instanceof com.bytedance.sdk.component.adexpress.dynamic.Cc.Bc ? Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE : 113, "layoutUnit is null");
            return;
        }
        this.vCE.Cc().tV(EO());
        try {
            this.IlO.render(lew, EO());
        } catch (Exception e) {
            int i2 = this.MY instanceof com.bytedance.sdk.component.adexpress.dynamic.Cc.Bc ? 128 : Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE;
            this.IlO.callBackRenderFail(i2, "exception is " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew) {
        List<com.bytedance.sdk.component.adexpress.dynamic.tV.lEW> listEV;
        if (lew == null || (listEV = lew.EV()) == null || listEV.size() <= 0) {
            return;
        }
        Collections.sort(listEV, new Comparator<com.bytedance.sdk.component.adexpress.dynamic.tV.lEW>() { // from class: com.bytedance.sdk.component.adexpress.dynamic.IlO.IlO.3
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
            public int compare(com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew2, com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew3) {
                vCE vceCc = lew2.NV().Cc();
                vCE vceCc2 = lew3.NV().Cc();
                if (vceCc == null || vceCc2 == null) {
                    return 0;
                }
                return vceCc.uI() >= vceCc2.uI() ? 1 : -1;
            }
        });
        for (com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew2 : listEV) {
            if (lew2 != null) {
                IlO(lew2);
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.tV
    /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
    public DynamicRootView Cc() {
        return tV();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void IlO(View view) {
        if (view == 0) {
            return;
        }
        if (view instanceof ViewGroup) {
            int i2 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i2 >= viewGroup.getChildCount()) {
                    break;
                }
                IlO(viewGroup.getChildAt(i2));
                i2++;
            }
        }
        if (view instanceof mmj) {
            ((mmj) view).MY();
        }
    }

    public void IlO(lEW lew) {
        this.Cc = lew;
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.EV
    public void IlO(bWL bwl) {
        if (this.lEW.get()) {
            return;
        }
        this.lEW.set(true);
        if (bwl.EO() && Bc()) {
            this.IlO.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.tV.IlO(Cc(), bwl);
            return;
        }
        this.tV.IlO(bwl.EV(), bwl.NV());
    }

    public void MY() {
        IlO(Cc());
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.EV
    public void IlO(View view, int i2, EO eo) {
        lEW lew = this.Cc;
        if (lew != null) {
            lew.IlO(view, i2, eo);
        }
    }
}
