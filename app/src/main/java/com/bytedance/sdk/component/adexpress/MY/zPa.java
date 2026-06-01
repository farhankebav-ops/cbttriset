package com.bytedance.sdk.component.adexpress.MY;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.adexpress.MY.NV;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class zPa implements NV {
    private ScheduledFuture<?> Cc;
    private lEW EO;
    private Context IlO;
    private com.bytedance.sdk.component.adexpress.Cc.IlO MY;
    private hp tV;
    private AtomicBoolean vCE = new AtomicBoolean(false);

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
                zPa.this.MY.IlO(true);
                zPa.this.IlO(this.IlO, 107, null);
            }
        }
    }

    public zPa(Context context, hp hpVar, com.bytedance.sdk.component.adexpress.Cc.IlO ilO, lEW lew) {
        this.IlO = context;
        this.tV = hpVar;
        this.EO = lew;
        this.MY = ilO;
        ilO.IlO(this.EO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EO() {
        try {
            ScheduledFuture<?> scheduledFuture = this.Cc;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.Cc.cancel(false);
            this.Cc = null;
        } catch (Throwable unused) {
        }
    }

    public com.bytedance.sdk.component.adexpress.Cc.IlO MY() {
        return this.MY;
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.NV
    public boolean IlO(final NV.IlO ilO) {
        int iVCE = this.tV.vCE();
        if (iVCE < 0) {
            IlO(ilO, 107, "time is ".concat(String.valueOf(iVCE)));
        } else {
            this.Cc = com.bytedance.sdk.component.adexpress.tV.tV.IlO(new IlO(1, ilO), iVCE, TimeUnit.MILLISECONDS);
            this.MY.IlO(new Bc() { // from class: com.bytedance.sdk.component.adexpress.MY.zPa.1
                @Override // com.bytedance.sdk.component.adexpress.MY.Bc
                public void IlO(View view, bWL bwl) {
                    ea eaVarMY;
                    zPa.this.EO();
                    if (ilO.EO() || (eaVarMY = ilO.MY()) == null) {
                        return;
                    }
                    eaVarMY.IlO(zPa.this.MY, bwl);
                    ilO.IlO(true);
                }

                @Override // com.bytedance.sdk.component.adexpress.MY.Bc
                public void IlO(int i2, String str) {
                    zPa.this.IlO(ilO, i2, str);
                }
            });
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.NV
    public void IlO() {
        this.MY.tV();
        EO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(NV.IlO ilO, int i2, String str) {
        ea eaVarMY;
        if (ilO.EO() || this.vCE.get()) {
            return;
        }
        EO();
        this.tV.Cc().IlO(i2, str);
        if (ilO.MY(this)) {
            ilO.IlO(this);
        } else {
            if (ilO.EO() || (eaVarMY = ilO.MY()) == null) {
                return;
            }
            ilO.IlO(true);
            eaVarMY.a_(i2);
        }
        this.vCE.getAndSet(true);
    }
}
