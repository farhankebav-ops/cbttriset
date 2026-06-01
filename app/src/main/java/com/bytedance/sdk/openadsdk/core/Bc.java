package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.utils.vSq;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Bc extends View implements vSq.IlO {
    private boolean Bc;
    private List<View> Cc;
    private final Handler DmF;
    private IlO EO;
    private ViewTreeObserver.OnGlobalLayoutListener EV;
    private boolean IlO;
    private boolean MY;
    private final AtomicBoolean NV;
    private final Runnable bWL;
    private boolean hp;
    private int lEW;
    private boolean rp;
    private View tV;

    @Nullable
    private List<View> vCE;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface IlO {
        void IlO();

        void IlO(View view);

        void IlO(boolean z2);

        void MY();
    }

    public Bc(Context context, View view, boolean z2) {
        super(cl.IlO());
        this.DmF = new com.bytedance.sdk.component.utils.vSq(bWL.MY().getLooper(), this);
        this.NV = new AtomicBoolean(true);
        this.hp = false;
        this.bWL = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Bc.3
            @Override // java.lang.Runnable
            public void run() {
                if (Bc.this.EO != null) {
                    Bc.this.EO.IlO(Bc.this.tV);
                }
            }
        };
        this.rp = z2;
        this.tV = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        this.EV = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.Bc.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (Bc.this.hp) {
                    return;
                }
                Bc.this.Cc();
                Bc.this.tV();
            }
        };
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.Bc = false;
        MY();
        if (this.EV != null) {
            getViewTreeObserver().addOnGlobalLayoutListener(this.EV);
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Cc();
        this.Bc = true;
        EO();
        IlO(false);
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        MY();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        EO();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        IlO ilO = this.EO;
        if (ilO != null) {
            ilO.IlO(z2);
        }
    }

    public void setAdType(int i2) {
        this.lEW = i2;
    }

    public void setCallback(IlO ilO) {
        this.EO = ilO;
    }

    public void setNeedCheckingShow(boolean z2) {
        this.MY = z2;
        if (!z2 && this.IlO) {
            Cc();
        } else {
            if (!z2 || this.IlO) {
                return;
            }
            tV();
        }
    }

    public void setRefClickViews(List<View> list) {
        this.Cc = list;
    }

    public void setRefCreativeViews(@Nullable List<View> list) {
        this.vCE = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cc() {
        if (this.IlO) {
            this.DmF.removeCallbacksAndMessages(null);
            this.IlO = false;
        }
    }

    private void EO() {
        IlO ilO;
        if (this.NV.getAndSet(true) || (ilO = this.EO) == null) {
            return;
        }
        ilO.MY();
    }

    private void MY() {
        IlO ilO;
        if (!this.NV.getAndSet(false) || (ilO = this.EO) == null) {
            return;
        }
        ilO.IlO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tV() {
        if (!this.MY || this.IlO) {
            return;
        }
        this.IlO = true;
        this.DmF.sendEmptyMessage(1);
    }

    private boolean vCE() {
        View view = this.tV;
        if (view instanceof com.bytedance.sdk.openadsdk.core.lEW.xF) {
            return ((com.bytedance.sdk.openadsdk.core.lEW.xF) view).xF();
        }
        return true;
    }

    public void IlO() {
        IlO(this.Cc, (com.bytedance.sdk.openadsdk.core.MY.EO) null);
        IlO(this.vCE, (com.bytedance.sdk.openadsdk.core.MY.EO) null);
    }

    public void IlO(List<View> list, com.bytedance.sdk.openadsdk.core.MY.EO eo) {
        if (com.bytedance.sdk.component.utils.hp.MY(list)) {
            for (View view : list) {
                if (view != null) {
                    view.setOnClickListener(eo);
                    view.setOnTouchListener(eo);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.component.utils.vSq.IlO
    public void IlO(Message message) {
        if (message.what == 1 && this.IlO) {
            if (vCE() && dY.IlO(this.tV, 20, this.lEW, this.rp)) {
                Cc();
                this.hp = true;
                bWL.EO().post(this.bWL);
                IlO(true);
                return;
            }
            this.DmF.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    private void IlO(final boolean z2) {
        final ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        com.bytedance.sdk.component.utils.DmF.MY().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Bc.2
            @Override // java.lang.Runnable
            public void run() {
                ViewTreeObserver viewTreeObserver2;
                if (Bc.this.EV != null && (viewTreeObserver2 = viewTreeObserver) != null) {
                    try {
                        viewTreeObserver2.removeOnGlobalLayoutListener(Bc.this.EV);
                    } catch (Exception unused) {
                    }
                }
                if (z2) {
                    Bc.this.EV = null;
                }
            }
        });
    }
}
