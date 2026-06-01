package com.bytedance.adsdk.MY.Bc;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.bytedance.adsdk.MY.Bc;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO<T> {
    public Float Bc;
    public final Interpolator Cc;
    public PointF DmF;
    public final Interpolator EO;
    private float EV;
    public final T IlO;
    public T MY;
    private final Bc NV;
    private int bWL;
    private float ea;
    private int hp;
    public PointF lEW;
    private float rp;
    public final Interpolator tV;
    public final float vCE;
    private float zPa;

    public IlO(Bc bc, T t3, T t7, Interpolator interpolator, float f4, Float f8) {
        this.EV = -3987645.8f;
        this.rp = -3987645.8f;
        this.hp = 784923401;
        this.bWL = 784923401;
        this.ea = Float.MIN_VALUE;
        this.zPa = Float.MIN_VALUE;
        this.lEW = null;
        this.DmF = null;
        this.NV = bc;
        this.IlO = t3;
        this.MY = t7;
        this.EO = interpolator;
        this.tV = null;
        this.Cc = null;
        this.vCE = f4;
        this.Bc = f8;
    }

    public float Bc() {
        if (this.rp == -3987645.8f) {
            this.rp = ((Float) this.MY).floatValue();
        }
        return this.rp;
    }

    public boolean Cc() {
        return this.EO == null && this.tV == null && this.Cc == null;
    }

    public int DmF() {
        if (this.bWL == 784923401) {
            this.bWL = ((Integer) this.MY).intValue();
        }
        return this.bWL;
    }

    public float EO() {
        Bc bc = this.NV;
        if (bc == null) {
            return 0.0f;
        }
        if (this.ea == Float.MIN_VALUE) {
            this.ea = (this.vCE - bc.vCE()) / this.NV.cl();
        }
        return this.ea;
    }

    public IlO<T> IlO(T t3, T t7) {
        return new IlO<>(t3, t7);
    }

    public int lEW() {
        if (this.hp == 784923401) {
            this.hp = ((Integer) this.IlO).intValue();
        }
        return this.hp;
    }

    public float tV() {
        if (this.NV == null) {
            return 1.0f;
        }
        if (this.zPa == Float.MIN_VALUE) {
            if (this.Bc == null) {
                this.zPa = 1.0f;
            } else {
                this.zPa = ((this.Bc.floatValue() - this.vCE) / this.NV.cl()) + EO();
            }
        }
        return this.zPa;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.IlO + ", endValue=" + this.MY + ", startFrame=" + this.vCE + ", endFrame=" + this.Bc + ", interpolator=" + this.EO + '}';
    }

    public float vCE() {
        if (this.EV == -3987645.8f) {
            this.EV = ((Float) this.IlO).floatValue();
        }
        return this.EV;
    }

    public boolean IlO(float f4) {
        return f4 >= EO() && f4 < tV();
    }

    public IlO(Bc bc, T t3, T t7, Interpolator interpolator, Interpolator interpolator2, float f4, Float f8) {
        this.EV = -3987645.8f;
        this.rp = -3987645.8f;
        this.hp = 784923401;
        this.bWL = 784923401;
        this.ea = Float.MIN_VALUE;
        this.zPa = Float.MIN_VALUE;
        this.lEW = null;
        this.DmF = null;
        this.NV = bc;
        this.IlO = t3;
        this.MY = t7;
        this.EO = null;
        this.tV = interpolator;
        this.Cc = interpolator2;
        this.vCE = f4;
        this.Bc = f8;
    }

    public IlO(Bc bc, T t3, T t7, Interpolator interpolator, Interpolator interpolator2, Interpolator interpolator3, float f4, Float f8) {
        this.EV = -3987645.8f;
        this.rp = -3987645.8f;
        this.hp = 784923401;
        this.bWL = 784923401;
        this.ea = Float.MIN_VALUE;
        this.zPa = Float.MIN_VALUE;
        this.lEW = null;
        this.DmF = null;
        this.NV = bc;
        this.IlO = t3;
        this.MY = t7;
        this.EO = interpolator;
        this.tV = interpolator2;
        this.Cc = interpolator3;
        this.vCE = f4;
        this.Bc = f8;
    }

    public IlO(T t3) {
        this.EV = -3987645.8f;
        this.rp = -3987645.8f;
        this.hp = 784923401;
        this.bWL = 784923401;
        this.ea = Float.MIN_VALUE;
        this.zPa = Float.MIN_VALUE;
        this.lEW = null;
        this.DmF = null;
        this.NV = null;
        this.IlO = t3;
        this.MY = t3;
        this.EO = null;
        this.tV = null;
        this.Cc = null;
        this.vCE = Float.MIN_VALUE;
        this.Bc = Float.valueOf(Float.MAX_VALUE);
    }

    private IlO(T t3, T t7) {
        this.EV = -3987645.8f;
        this.rp = -3987645.8f;
        this.hp = 784923401;
        this.bWL = 784923401;
        this.ea = Float.MIN_VALUE;
        this.zPa = Float.MIN_VALUE;
        this.lEW = null;
        this.DmF = null;
        this.NV = null;
        this.IlO = t3;
        this.MY = t7;
        this.EO = null;
        this.tV = null;
        this.Cc = null;
        this.vCE = Float.MIN_VALUE;
        this.Bc = Float.valueOf(Float.MAX_VALUE);
    }
}
