package com.bytedance.adsdk.MY.vCE;

import android.view.Choreographer;
import com.bytedance.adsdk.MY.Bc;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO extends IlO implements Choreographer.FrameCallback {
    private Bc NV;
    private float MY = 1.0f;
    private boolean EO = false;
    private long tV = 0;
    private float Cc = 0.0f;
    private float vCE = 0.0f;
    private int Bc = 0;
    private float lEW = -2.1474836E9f;
    private float DmF = 2.1474836E9f;
    protected boolean IlO = false;
    private boolean EV = false;

    private void AXM() {
        if (this.NV == null) {
            return;
        }
        float f4 = this.vCE;
        if (f4 < this.lEW || f4 > this.DmF) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.lEW), Float.valueOf(this.DmF), Float.valueOf(this.vCE)));
        }
    }

    private float es() {
        Bc bc = this.NV;
        if (bc == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / bc.rp()) / Math.abs(this.MY);
    }

    private boolean xF() {
        return NV() < 0.0f;
    }

    public float Bc() {
        return this.vCE;
    }

    public void DmF() {
        EO(-NV());
    }

    public void EO(boolean z2) {
        this.EV = z2;
    }

    public void EV() {
        this.IlO = true;
        IlO(xF());
        IlO((int) (xF() ? zPa() : ea()));
        this.tV = 0L;
        this.Bc = 0;
        cl();
    }

    public void IlO(Bc bc) {
        boolean z2 = this.NV == null;
        this.NV = bc;
        if (z2) {
            IlO(Math.max(this.lEW, bc.vCE()), Math.min(this.DmF, bc.Bc()));
        } else {
            IlO((int) bc.vCE(), (int) bc.Bc());
        }
        float f4 = this.vCE;
        this.vCE = 0.0f;
        this.Cc = 0.0f;
        IlO((int) f4);
        EO();
    }

    public void MY(float f4) {
        IlO(this.lEW, f4);
    }

    public float NV() {
        return this.MY;
    }

    public void bWL() {
        this.IlO = true;
        cl();
        this.tV = 0L;
        if (xF() && Bc() == ea()) {
            IlO(zPa());
        } else if (!xF() && Bc() == zPa()) {
            IlO(ea());
        }
        Cc();
    }

    public void cL() {
        tV(true);
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void cancel() {
        MY();
        cL();
    }

    public void cl() {
        if (isRunning()) {
            tV(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        cl();
        if (this.NV == null || !isRunning()) {
            return;
        }
        com.bytedance.adsdk.MY.Cc.IlO("LottieValueAnimator#doFrame");
        float fEs = (this.tV != 0 ? j - r1 : 0L) / es();
        float f4 = this.Cc;
        if (xF()) {
            fEs = -fEs;
        }
        float f8 = f4 + fEs;
        boolean zEO = Cc.EO(f8, ea(), zPa());
        float f9 = this.Cc;
        float fMY = Cc.MY(f8, ea(), zPa());
        this.Cc = fMY;
        if (this.EV) {
            fMY = (float) Math.floor(fMY);
        }
        this.vCE = fMY;
        this.tV = j;
        if (!this.EV || this.Cc != f9) {
            EO();
        }
        if (!zEO) {
            if (getRepeatCount() == -1 || this.Bc < getRepeatCount()) {
                IlO();
                this.Bc++;
                if (getRepeatMode() == 2) {
                    this.EO = !this.EO;
                    DmF();
                } else {
                    float fZPa = xF() ? zPa() : ea();
                    this.Cc = fZPa;
                    this.vCE = fZPa;
                }
                this.tV = j;
            } else {
                float fEa = this.MY < 0.0f ? ea() : zPa();
                this.Cc = fEa;
                this.vCE = fEa;
                cL();
                MY(xF());
            }
        }
        AXM();
        com.bytedance.adsdk.MY.Cc.MY("LottieValueAnimator#doFrame");
    }

    public float ea() {
        Bc bc = this.NV;
        if (bc == null) {
            return 0.0f;
        }
        float f4 = this.lEW;
        return f4 == -2.1474836E9f ? bc.vCE() : f4;
    }

    @Override // android.animation.ValueAnimator
    public float getAnimatedFraction() {
        float fEa;
        float fZPa;
        float fEa2;
        if (this.NV == null) {
            return 0.0f;
        }
        if (xF()) {
            fEa = zPa() - this.vCE;
            fZPa = zPa();
            fEa2 = ea();
        } else {
            fEa = this.vCE - ea();
            fZPa = zPa();
            fEa2 = ea();
        }
        return fEa / (fZPa - fEa2);
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(vCE());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        Bc bc = this.NV;
        if (bc == null) {
            return 0L;
        }
        return (long) bc.Cc();
    }

    public void hp() {
        cL();
        tV();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.IlO;
    }

    public void lEW() {
        this.NV = null;
        this.lEW = -2.1474836E9f;
        this.DmF = 2.1474836E9f;
    }

    public void rp() {
        cL();
        MY(xF());
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i2) {
        super.setRepeatMode(i2);
        if (i2 == 2 || !this.EO) {
            return;
        }
        this.EO = false;
        DmF();
    }

    public void tV(boolean z2) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z2) {
            this.IlO = false;
        }
    }

    public float vCE() {
        Bc bc = this.NV;
        if (bc == null) {
            return 0.0f;
        }
        return (this.vCE - bc.vCE()) / (this.NV.Bc() - this.NV.vCE());
    }

    public float zPa() {
        Bc bc = this.NV;
        if (bc == null) {
            return 0.0f;
        }
        float f4 = this.DmF;
        return f4 == 2.1474836E9f ? bc.Bc() : f4;
    }

    public void EO(float f4) {
        this.MY = f4;
    }

    @Override // com.bytedance.adsdk.MY.vCE.IlO
    public void MY() {
        super.MY();
        MY(xF());
    }

    public void IlO(float f4) {
        if (this.Cc == f4) {
            return;
        }
        float fMY = Cc.MY(f4, ea(), zPa());
        this.Cc = fMY;
        if (this.EV) {
            fMY = (float) Math.floor(fMY);
        }
        this.vCE = fMY;
        this.tV = 0L;
        EO();
    }

    public void IlO(int i2) {
        IlO(i2, (int) this.DmF);
    }

    public void IlO(float f4, float f8) {
        if (f4 <= f8) {
            Bc bc = this.NV;
            float fVCE = bc == null ? -3.4028235E38f : bc.vCE();
            Bc bc2 = this.NV;
            float fBc = bc2 == null ? Float.MAX_VALUE : bc2.Bc();
            float fMY = Cc.MY(f4, fVCE, fBc);
            float fMY2 = Cc.MY(f8, fVCE, fBc);
            if (fMY == this.lEW && fMY2 == this.DmF) {
                return;
            }
            this.lEW = fMY;
            this.DmF = fMY2;
            IlO((int) Cc.MY(this.vCE, fMY, fMY2));
            return;
        }
        throw new IllegalArgumentException("minFrame (" + f4 + ") must be <= maxFrame (" + f8 + ")");
    }
}
