package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class DmF implements bWL, Runnable {
    private final IlO Bc;
    private long Cc;
    private final AtomicBoolean DmF = new AtomicBoolean(false);
    private final Handler EO = new Handler(Looper.getMainLooper());
    private View IlO = tV();
    private final Activity MY;
    private boolean lEW;
    private long tV;
    private boolean vCE;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface IlO {
        View IlO();

        void MY();
    }

    private DmF(Activity activity, int i2, IlO ilO) {
        this.Bc = ilO;
        this.MY = activity;
        this.tV = i2;
    }

    private void Bc() {
        ViewParent parent = this.IlO.getParent();
        if (parent instanceof ViewGroup) {
            if (((ViewGroup) parent).indexOfChild(this.IlO) != r0.getChildCount() - 1) {
                this.IlO.bringToFront();
            }
        }
    }

    private void Cc() {
        this.lEW = false;
        this.Cc = SystemClock.elapsedRealtime();
        Handler handler = this.EO;
        if (handler != null) {
            handler.postDelayed(this, this.tV);
        }
    }

    public static bWL IlO(Activity activity, IlO ilO) {
        int iTN = com.bytedance.sdk.openadsdk.core.settings.hp.aP().tN();
        return iTN < 0 ? new bWL() { // from class: com.bytedance.sdk.openadsdk.utils.DmF.1
            @Override // com.bytedance.sdk.openadsdk.utils.bWL
            public void IlO() {
            }

            @Override // com.bytedance.sdk.openadsdk.utils.bWL
            public void IlO(long j) {
            }

            @Override // com.bytedance.sdk.openadsdk.utils.bWL
            public void EO() {
            }

            @Override // com.bytedance.sdk.openadsdk.utils.bWL
            public void MY() {
            }
        } : new DmF(activity, Math.min(iTN, 50) * 1000, ilO);
    }

    private View tV() {
        IlO ilO = this.Bc;
        if (ilO != null) {
            return ilO.IlO();
        }
        return null;
    }

    private void vCE() {
        Activity activity;
        View childAt;
        if (this.vCE || (activity = this.MY) == null || activity.isFinishing() || this.MY.isDestroyed()) {
            return;
        }
        if (this.IlO == null) {
            this.IlO = tV();
        }
        View view = this.IlO;
        if (view != null) {
            if (MY(view)) {
                IlO(this.IlO);
                View view2 = this.IlO;
                if ((view2 instanceof ViewGroup) && ((ViewGroup) view2).getChildCount() > 0 && (childAt = ((ViewGroup) this.IlO).getChildAt(0)) != null && MY(childAt)) {
                    IlO(childAt);
                }
                IlO ilO = this.Bc;
                if (ilO != null) {
                    ilO.MY();
                }
            }
            Bc();
        }
        this.vCE = true;
    }

    @Override // com.bytedance.sdk.openadsdk.utils.bWL
    public void EO() {
        if (this.vCE) {
            return;
        }
        this.vCE = true;
        Handler handler = this.EO;
        if (handler != null) {
            try {
                handler.removeCallbacks(this);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.oeT.EO(th.getMessage(), new Object[0]);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.utils.bWL
    public void MY() {
        if (this.Cc <= 0 || this.vCE) {
            return;
        }
        if (!this.lEW) {
            this.tV -= SystemClock.elapsedRealtime() - this.Cc;
        }
        this.lEW = true;
        if (this.tV <= 0) {
            vCE();
            return;
        }
        Handler handler = this.EO;
        if (handler != null) {
            try {
                handler.removeCallbacks(this);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.oeT.EO(th.getMessage(), new Object[0]);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        vCE();
    }

    @Override // com.bytedance.sdk.openadsdk.utils.bWL
    public void IlO(long j) {
        if (this.DmF.compareAndSet(false, true)) {
            if (j < 0) {
                j = 0;
            }
            this.tV += j;
            Cc();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.utils.bWL
    public void IlO() {
        if (this.Cc == 0 || !this.lEW) {
            return;
        }
        Cc();
    }

    private void IlO(View view) {
        view.setVisibility(0);
        view.setAlpha(1.0f);
    }

    private boolean MY(View view) {
        if (view == null) {
            return true;
        }
        return !view.isShown() || ((double) view.getAlpha()) <= 0.9d;
    }
}
