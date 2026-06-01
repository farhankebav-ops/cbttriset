package com.bytedance.sdk.openadsdk.core.EO;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import com.bytedance.sdk.component.utils.vSq;
import com.bytedance.sdk.openadsdk.core.bWL;
import com.bytedance.sdk.openadsdk.core.dY;
import com.bytedance.sdk.openadsdk.utils.mmj;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE extends com.bytedance.adsdk.ugeno.vCE.IlO<View> implements vSq.IlO {
    private boolean Bc;
    private long Cc;
    private IlO DmF;
    private final ViewTreeObserver.OnScrollChangedListener EV;
    private final Runnable NV;
    private MY lEW;
    private final Handler tV;
    private boolean vCE;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface IlO {
        void IlO(boolean z2);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface MY {
        void IlO(boolean z2);
    }

    public vCE(Context context) {
        super(context);
        this.tV = new vSq(bWL.MY().getLooper(), this);
        this.vCE = true;
        this.Bc = true;
        this.NV = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EO.vCE.1
            @Override // java.lang.Runnable
            public void run() {
                if (vCE.this.DmF != null) {
                    vCE.this.DmF.IlO(vCE.this.Bc);
                }
            }
        };
        this.EV = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.core.EO.vCE.2
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                if (jElapsedRealtime - vCE.this.Cc > 500) {
                    vCE.this.Cc = jElapsedRealtime;
                    vCE.this.tV.sendEmptyMessageDelayed(1, 500L);
                }
            }
        };
    }

    private void Bc() {
        boolean zIlO = dY.IlO(this, 50, -1, false);
        this.Bc = zIlO;
        if (zIlO == this.vCE) {
            return;
        }
        this.vCE = zIlO;
        mmj.IlO(this.NV);
    }

    @Override // com.bytedance.adsdk.ugeno.vCE.IlO
    public View NV(int i2) {
        return (View) this.IlO.get(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnScrollChangedListener(this.EV);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this.EV);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        MY my = this.lEW;
        if (my != null) {
            my.IlO(z2);
        }
    }

    public void setSwiperVisibleChangeListener(IlO ilO) {
        this.DmF = ilO;
    }

    public void setSwiperWindowFocusChangedListener(MY my) {
        this.lEW = my;
    }

    @Override // com.bytedance.sdk.component.utils.vSq.IlO
    public void IlO(Message message) {
        if (message.what == 1) {
            Bc();
        }
    }
}
