package com.bytedance.adsdk.MY.IlO.IlO;

import a1.a;
import android.graphics.Path;
import android.graphics.PointF;
import com.bytedance.adsdk.MY.EO.MY.NV;
import com.bytedance.adsdk.MY.EO.MY.xF;
import com.bytedance.adsdk.MY.IlO.MY.IlO;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class bWL implements EV, hp, IlO.InterfaceC0025IlO {
    private final com.bytedance.adsdk.MY.IlO.MY.IlO<?, Float> Bc;
    private final boolean Cc;
    private final com.bytedance.adsdk.MY.IlO.MY.IlO<?, Float> DmF;
    private final com.bytedance.adsdk.MY.DmF EO;
    private final com.bytedance.adsdk.MY.IlO.MY.IlO<?, Float> EV;
    private final String MY;
    private final com.bytedance.adsdk.MY.IlO.MY.IlO<?, Float> NV;
    private boolean ea;
    private final com.bytedance.adsdk.MY.IlO.MY.IlO<?, Float> hp;
    private final com.bytedance.adsdk.MY.IlO.MY.IlO<?, PointF> lEW;
    private final com.bytedance.adsdk.MY.IlO.MY.IlO<?, Float> rp;
    private final NV.IlO tV;
    private final boolean vCE;
    private final Path IlO = new Path();
    private final MY bWL = new MY();

    /* JADX INFO: renamed from: com.bytedance.adsdk.MY.IlO.IlO.bWL$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] IlO;

        static {
            int[] iArr = new int[NV.IlO.values().length];
            IlO = iArr;
            try {
                iArr[NV.IlO.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                IlO[NV.IlO.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public bWL(com.bytedance.adsdk.MY.DmF dmF, com.bytedance.adsdk.MY.EO.EO.IlO ilO, com.bytedance.adsdk.MY.EO.MY.NV nv) {
        this.EO = dmF;
        this.MY = nv.IlO();
        NV.IlO ilOMY = nv.MY();
        this.tV = ilOMY;
        this.Cc = nv.NV();
        this.vCE = nv.EV();
        com.bytedance.adsdk.MY.IlO.MY.IlO<Float, Float> IlO = nv.EO().IlO();
        this.Bc = IlO;
        com.bytedance.adsdk.MY.IlO.MY.IlO<PointF, PointF> IlO2 = nv.tV().IlO();
        this.lEW = IlO2;
        com.bytedance.adsdk.MY.IlO.MY.IlO<Float, Float> IlO3 = nv.Cc().IlO();
        this.DmF = IlO3;
        com.bytedance.adsdk.MY.IlO.MY.IlO<Float, Float> IlO4 = nv.Bc().IlO();
        this.EV = IlO4;
        com.bytedance.adsdk.MY.IlO.MY.IlO<Float, Float> IlO5 = nv.DmF().IlO();
        this.hp = IlO5;
        NV.IlO ilO2 = NV.IlO.STAR;
        if (ilOMY == ilO2) {
            this.NV = nv.vCE().IlO();
            this.rp = nv.lEW().IlO();
        } else {
            this.NV = null;
            this.rp = null;
        }
        ilO.IlO(IlO);
        ilO.IlO(IlO2);
        ilO.IlO(IlO3);
        ilO.IlO(IlO4);
        ilO.IlO(IlO5);
        if (ilOMY == ilO2) {
            ilO.IlO(this.NV);
            ilO.IlO(this.rp);
        }
        IlO.IlO(this);
        IlO2.IlO(this);
        IlO3.IlO(this);
        IlO4.IlO(this);
        IlO5.IlO(this);
        if (ilOMY == ilO2) {
            this.NV.IlO(this);
            this.rp.IlO(this);
        }
    }

    private void Cc() {
        double d8;
        int iFloor = (int) Math.floor(this.Bc.Bc().floatValue());
        double radians = Math.toRadians((this.DmF == null ? 0.0d : r2.Bc().floatValue()) - 90.0d);
        double d9 = iFloor;
        float fFloatValue = this.hp.Bc().floatValue() / 100.0f;
        float fFloatValue2 = this.EV.Bc().floatValue();
        double d10 = fFloatValue2;
        float fCos = (float) (Math.cos(radians) * d10);
        float fSin = (float) (Math.sin(radians) * d10);
        this.IlO.moveTo(fCos, fSin);
        double d11 = (float) (6.283185307179586d / d9);
        double d12 = radians + d11;
        double dCeil = Math.ceil(d9);
        int i2 = 0;
        while (i2 < dCeil) {
            float fCos2 = (float) (Math.cos(d12) * d10);
            int i8 = i2;
            double d13 = d12;
            float fSin2 = (float) (Math.sin(d12) * d10);
            if (fFloatValue != 0.0f) {
                d8 = dCeil;
                double dAtan2 = (float) (Math.atan2(fSin, fCos) - 1.5707963267948966d);
                float fCos3 = (float) Math.cos(dAtan2);
                float fSin3 = (float) Math.sin(dAtan2);
                double dAtan22 = (float) (Math.atan2(fSin2, fCos2) - 1.5707963267948966d);
                float f4 = fFloatValue2 * fFloatValue * 0.25f;
                this.IlO.cubicTo(fCos - (f4 * fCos3), fSin - (f4 * fSin3), fCos2 + (((float) Math.cos(dAtan22)) * f4), fSin2 + (f4 * ((float) Math.sin(dAtan22))), fCos2, fSin2);
                fCos = fCos2;
                fSin = fSin2;
            } else {
                fSin = fSin2;
                d8 = dCeil;
                fCos = fCos2;
                this.IlO.lineTo(fCos, fSin);
            }
            d12 = d13 + d11;
            i2 = i8 + 1;
            dCeil = d8;
        }
        PointF pointFBc = this.lEW.Bc();
        this.IlO.offset(pointFBc.x, pointFBc.y);
        this.IlO.close();
    }

    private void EO() {
        float f4;
        float f8;
        int i2;
        float fCos;
        float fSin;
        float f9;
        float f10;
        double d8;
        float fA;
        int i8;
        float f11;
        double d9;
        float f12;
        float f13;
        double d10;
        float f14;
        float f15;
        float fFloatValue = this.Bc.Bc().floatValue();
        double radians = Math.toRadians((this.DmF == null ? 0.0d : r2.Bc().floatValue()) - 90.0d);
        double d11 = fFloatValue;
        float f16 = (float) (6.283185307179586d / d11);
        if (this.vCE) {
            f16 *= -1.0f;
        }
        float f17 = f16 / 2.0f;
        float f18 = fFloatValue - ((int) fFloatValue);
        int i9 = (f18 > 0.0f ? 1 : (f18 == 0.0f ? 0 : -1));
        if (i9 != 0) {
            radians += (double) ((1.0f - f18) * f17);
        }
        float fFloatValue2 = this.EV.Bc().floatValue();
        float fFloatValue3 = this.NV.Bc().floatValue();
        com.bytedance.adsdk.MY.IlO.MY.IlO<?, Float> ilO = this.rp;
        float fFloatValue4 = ilO != null ? ilO.Bc().floatValue() / 100.0f : 0.0f;
        com.bytedance.adsdk.MY.IlO.MY.IlO<?, Float> ilO2 = this.hp;
        float fFloatValue5 = ilO2 != null ? ilO2.Bc().floatValue() / 100.0f : 0.0f;
        if (i9 != 0) {
            fA = a.a(fFloatValue2, fFloatValue3, f18, fFloatValue3);
            f8 = 0.0f;
            i2 = i9;
            double d12 = fA;
            f4 = 2.0f;
            float fCos2 = (float) (Math.cos(radians) * d12);
            fSin = (float) (Math.sin(radians) * d12);
            this.IlO.moveTo(fCos2, fSin);
            d8 = radians + ((double) ((f16 * f18) / 2.0f));
            f9 = f18;
            fCos = fCos2;
            f10 = f17;
        } else {
            f4 = 2.0f;
            f8 = 0.0f;
            i2 = i9;
            double d13 = fFloatValue2;
            fCos = (float) (Math.cos(radians) * d13);
            fSin = (float) (d13 * Math.sin(radians));
            this.IlO.moveTo(fCos, fSin);
            f9 = f18;
            f10 = f17;
            d8 = radians + ((double) f10);
            fA = 0.0f;
        }
        double dCeil = Math.ceil(d11) * 2.0d;
        int i10 = 0;
        boolean z2 = false;
        double d14 = d8;
        float f19 = fSin;
        float f20 = fCos;
        double d15 = d14;
        while (true) {
            double d16 = i10;
            if (d16 >= dCeil) {
                PointF pointFBc = this.lEW.Bc();
                this.IlO.offset(pointFBc.x, pointFBc.y);
                this.IlO.close();
                return;
            }
            float f21 = z2 ? fFloatValue2 : fFloatValue3;
            if (fA == f8 || d16 != dCeil - 2.0d) {
                i8 = i10;
                f11 = f10;
            } else {
                i8 = i10;
                f11 = (f16 * f9) / f4;
            }
            if (fA == f8 || d16 != dCeil - 1.0d) {
                d9 = d16;
                f12 = f21;
            } else {
                d9 = d16;
                f12 = fA;
            }
            double d17 = f12;
            float fCos3 = (float) (Math.cos(d15) * d17);
            float f22 = f16;
            float fSin2 = (float) (Math.sin(d15) * d17);
            if (fFloatValue4 == f8 && fFloatValue5 == f8) {
                this.IlO.lineTo(fCos3, fSin2);
                f15 = fCos3;
                f14 = fSin2;
                f13 = f10;
                d10 = d15;
            } else {
                f13 = f10;
                d10 = d15;
                double dAtan2 = (float) (Math.atan2(f19, f20) - 1.5707963267948966d);
                float fCos4 = (float) Math.cos(dAtan2);
                float fSin3 = (float) Math.sin(dAtan2);
                float f23 = f20;
                float f24 = f19;
                f14 = fSin2;
                double dAtan22 = (float) (Math.atan2(fSin2, fCos3) - 1.5707963267948966d);
                float fCos5 = (float) Math.cos(dAtan22);
                float fSin4 = (float) Math.sin(dAtan22);
                float f25 = z2 ? fFloatValue4 : fFloatValue5;
                float f26 = z2 ? fFloatValue5 : fFloatValue4;
                float f27 = (z2 ? fFloatValue3 : fFloatValue2) * f25 * 0.47829f;
                float f28 = fCos4 * f27;
                float f29 = f27 * fSin3;
                float f30 = (z2 ? fFloatValue2 : fFloatValue3) * f26 * 0.47829f;
                float f31 = fCos5 * f30;
                float f32 = f30 * fSin4;
                if (i2 != 0) {
                    if (i8 == 0) {
                        f28 *= f9;
                        f29 *= f9;
                    } else if (d9 == dCeil - 1.0d) {
                        f31 *= f9;
                        f32 *= f9;
                    }
                }
                f15 = fCos3;
                this.IlO.cubicTo(f23 - f28, f24 - f29, fCos3 + f31, f14 + f32, f15, f14);
            }
            d15 = d10 + ((double) f11);
            z2 = !z2;
            i10 = i8 + 1;
            f10 = f13;
            f20 = f15;
            f19 = f14;
            f16 = f22;
        }
    }

    private void MY() {
        this.ea = false;
        this.EO.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.MY.IlO.MY.IlO.InterfaceC0025IlO
    public void IlO() {
        MY();
    }

    @Override // com.bytedance.adsdk.MY.IlO.IlO.hp
    public Path tV() {
        if (this.ea) {
            return this.IlO;
        }
        this.IlO.reset();
        if (this.Cc) {
            this.ea = true;
            return this.IlO;
        }
        int i2 = AnonymousClass1.IlO[this.tV.ordinal()];
        if (i2 == 1) {
            EO();
        } else if (i2 == 2) {
            Cc();
        }
        this.IlO.close();
        this.bWL.IlO(this.IlO);
        this.ea = true;
        return this.IlO;
    }

    @Override // com.bytedance.adsdk.MY.IlO.IlO.EO
    public void IlO(List<EO> list, List<EO> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            EO eo = list.get(i2);
            if (eo instanceof oeT) {
                oeT oet = (oeT) eo;
                if (oet.MY() == xF.IlO.SIMULTANEOUSLY) {
                    this.bWL.IlO(oet);
                    oet.IlO(this);
                }
            }
        }
    }
}
