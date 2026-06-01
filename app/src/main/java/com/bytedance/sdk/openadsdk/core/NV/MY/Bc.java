package com.bytedance.sdk.openadsdk.core.NV.MY;

import android.content.Context;
import android.view.View;
import com.bytedance.adsdk.ugeno.core.ea;
import com.bytedance.sdk.component.adexpress.MY.NV;
import com.bytedance.sdk.component.adexpress.MY.bWL;
import com.bytedance.sdk.component.adexpress.MY.hp;
import com.bytedance.sdk.component.adexpress.MY.lEW;
import com.bytedance.sdk.component.utils.oeT;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.vungle.ads.internal.protos.Sdk;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Bc implements NV {
    private AtomicBoolean Cc = new AtomicBoolean(false);
    private hp EO;
    private Context IlO;
    private com.bytedance.sdk.openadsdk.core.NV.Cc.EO MY;
    private ScheduledFuture<?> tV;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class IlO implements Runnable {
        private int EO;
        NV.IlO IlO;

        public IlO(int i2, NV.IlO ilO) {
            this.EO = i2;
            this.IlO = ilO;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.EO == 1) {
                Bc.this.MY.IlO(true);
                Bc.this.IlO(this.IlO, Sdk.SDKError.Reason.TPAT_RETRY_FAILED_VALUE, "real time out" + Bc.this.EO.vCE());
            }
        }
    }

    public Bc(Context context, com.bytedance.sdk.openadsdk.core.NV.Cc.EO eo, lEW lew, hp hpVar) {
        this.IlO = context;
        this.MY = eo;
        this.EO = hpVar;
        this.MY.IlO(lew);
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.NV
    public void IlO() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MY() {
        try {
            ScheduledFuture<?> scheduledFuture = this.tV;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.tV.cancel(false);
            this.tV = null;
        } catch (Throwable th) {
            oeT.EO("RenderInterceptor", "remove ugen time out task fail", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.NV
    public boolean IlO(final NV.IlO ilO) {
        int iVCE = this.EO.vCE();
        if (iVCE < 0) {
            IlO(ilO, Sdk.SDKError.Reason.TPAT_RETRY_FAILED_VALUE, "time is ".concat(String.valueOf(iVCE)));
        } else {
            this.tV = mmj.IlO().schedule(new IlO(1, ilO), iVCE, TimeUnit.MILLISECONDS);
            this.MY.IlO(new com.bytedance.sdk.component.adexpress.MY.Bc() { // from class: com.bytedance.sdk.openadsdk.core.NV.MY.Bc.1
                @Override // com.bytedance.sdk.component.adexpress.MY.Bc
                public void IlO(View view, bWL bwl) {
                    Bc.this.MY();
                    if (ilO.EO()) {
                        return;
                    }
                    ea eaVar = new ea();
                    eaVar.IlO(0);
                    ((com.bytedance.sdk.openadsdk.core.NV.Cc.IlO) Bc.this.EO).dY().IlO(eaVar);
                    Bc.this.EO.Cc().NV();
                    com.bytedance.sdk.component.adexpress.MY.ea eaVarMY = ilO.MY();
                    if (eaVarMY == null) {
                        return;
                    }
                    eaVarMY.IlO(Bc.this.MY, bwl);
                    ilO.IlO(true);
                }

                @Override // com.bytedance.sdk.component.adexpress.MY.Bc
                public void IlO(int i2, String str) {
                    Bc.this.IlO(ilO, i2, str);
                }
            });
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(NV.IlO ilO, int i2, String str) {
        com.bytedance.sdk.component.adexpress.MY.ea eaVarMY;
        if (ilO.EO() || this.Cc.get()) {
            return;
        }
        MY();
        ea eaVar = new ea();
        eaVar.IlO(i2);
        eaVar.IlO(str);
        ((com.bytedance.sdk.openadsdk.core.NV.Cc.IlO) this.EO).dY().IlO(eaVar);
        if (ilO.MY(this)) {
            ilO.IlO(this);
        } else {
            if (ilO.EO() || (eaVarMY = ilO.MY()) == null) {
                return;
            }
            ilO.IlO(true);
            eaVarMY.a_(i2);
        }
        this.Cc.getAndSet(true);
    }
}
