package com.bytedance.sdk.openadsdk.kBB.MY;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.kBB.MY.Cc;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class MY {
    private final int Bc;
    private final AtomicBoolean Cc;
    private volatile boolean DmF = false;
    protected final AtomicBoolean EO;
    protected WeakReference<View> IlO;
    protected oeT MY;
    private final Integer lEW;
    private final AtomicLong tV;
    private final Cc.IlO vCE;

    public MY(Integer num, View view, oeT oet, int i2, Cc.IlO ilO) {
        this.lEW = num;
        this.Bc = i2;
        this.MY = oet;
        this.vCE = ilO;
        IlO(view);
        this.EO = new AtomicBoolean(false);
        this.tV = new AtomicLong(-1L);
        this.Cc = new AtomicBoolean(false);
    }

    public static MY IlO(boolean z2, Integer num, View view, oeT oet, Cc.IlO ilO) {
        return z2 ? new lEW(num, view, oet, ilO) : new EO(num, view, oet, ilO);
    }

    public void Bc() {
        if (DmF()) {
            return;
        }
        if (!this.EO.get()) {
            lEW();
        } else if (!this.tV.compareAndSet(-1L, System.currentTimeMillis()) && System.currentTimeMillis() - this.tV.get() >= this.Bc) {
            tV();
        }
    }

    public IlO Cc() {
        WeakReference<View> weakReference = this.IlO;
        if (weakReference == null) {
            return new IlO(-1, -1, -1.0f);
        }
        View view = weakReference.get();
        return view == null ? new IlO(0, 0, 0.0f) : new IlO(view.getWidth(), view.getHeight(), view.getAlpha());
    }

    public boolean DmF() {
        return this.Cc.get();
    }

    public abstract boolean EO();

    public Integer EV() {
        return this.lEW;
    }

    public int MY() {
        if (DmF()) {
            return 1;
        }
        WeakReference<View> weakReference = this.IlO;
        View view = weakReference != null ? weakReference.get() : null;
        if (view == null || this.DmF) {
            return 3;
        }
        if (EV().equals(view.getTag(InputDeviceCompat.SOURCE_HDMI))) {
            return (EV().equals(view.getTag(InputDeviceCompat.SOURCE_HDMI)) && EO()) ? 1 : 2;
        }
        NV();
        Cc.MY(EV());
        return 3;
    }

    public abstract void MY(int i2);

    public void NV() {
        this.DmF = true;
        Bc.MY(this);
    }

    public void hp() {
        this.EO.set(false);
        lEW();
    }

    public void lEW() {
        this.tV.set(-1L);
    }

    public boolean rp() {
        return this.EO.get();
    }

    public void tV() {
        if (this.Cc.compareAndSet(false, true)) {
            tV.IlO(this.MY, Cc(), this.vCE);
        }
    }

    public abstract int vCE();

    public void IlO() {
        if (this.EO.compareAndSet(false, true)) {
            Bc.IlO(this);
        }
    }

    public void IlO(int i2) {
        if (i2 == 4) {
            IlO();
            return;
        }
        if (i2 == 8) {
            hp();
        } else if (i2 == 9) {
            tV();
        } else {
            MY(i2);
        }
    }

    public void IlO(View view) {
        if (view != null) {
            view.setTag(InputDeviceCompat.SOURCE_HDMI, EV());
        }
        this.IlO = new WeakReference<>(view);
    }
}
