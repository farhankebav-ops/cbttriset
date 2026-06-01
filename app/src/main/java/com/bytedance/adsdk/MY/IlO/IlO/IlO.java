package com.bytedance.adsdk.MY.IlO.IlO;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.bytedance.adsdk.MY.IlO.MY.IlO;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class IlO implements Cc, EV, IlO.InterfaceC0025IlO {
    float EO;
    private final com.bytedance.adsdk.MY.IlO.MY.IlO<?, Float> EV;
    protected final com.bytedance.adsdk.MY.EO.EO.IlO IlO;
    final Paint MY;
    private final float[] NV;
    private final com.bytedance.adsdk.MY.IlO.MY.IlO<?, Float> bWL;
    private com.bytedance.adsdk.MY.IlO.MY.EO cl;
    private com.bytedance.adsdk.MY.IlO.MY.IlO<ColorFilter, ColorFilter> ea;
    private final List<com.bytedance.adsdk.MY.IlO.MY.IlO<?, Float>> hp;
    private final com.bytedance.adsdk.MY.DmF lEW;
    private final com.bytedance.adsdk.MY.IlO.MY.IlO<?, Integer> rp;
    private com.bytedance.adsdk.MY.IlO.MY.IlO<Float, Float> zPa;
    private final PathMeasure tV = new PathMeasure();
    private final Path Cc = new Path();
    private final Path vCE = new Path();
    private final RectF Bc = new RectF();
    private final List<C0024IlO> DmF = new ArrayList();

    /* JADX INFO: renamed from: com.bytedance.adsdk.MY.IlO.IlO.IlO$IlO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C0024IlO {
        private final List<hp> IlO;
        private final oeT MY;

        private C0024IlO(oeT oet) {
            this.IlO = new ArrayList();
            this.MY = oet;
        }
    }

    public IlO(com.bytedance.adsdk.MY.DmF dmF, com.bytedance.adsdk.MY.EO.EO.IlO ilO, Paint.Cap cap, Paint.Join join, float f4, com.bytedance.adsdk.MY.EO.IlO.tV tVVar, com.bytedance.adsdk.MY.EO.IlO.MY my, List<com.bytedance.adsdk.MY.EO.IlO.MY> list, com.bytedance.adsdk.MY.EO.IlO.MY my2) {
        com.bytedance.adsdk.MY.IlO.IlO ilO2 = new com.bytedance.adsdk.MY.IlO.IlO(1);
        this.MY = ilO2;
        this.EO = 0.0f;
        this.lEW = dmF;
        this.IlO = ilO;
        ilO2.setStyle(Paint.Style.STROKE);
        ilO2.setStrokeCap(cap);
        ilO2.setStrokeJoin(join);
        ilO2.setStrokeMiter(f4);
        this.rp = tVVar.IlO();
        this.EV = my.IlO();
        if (my2 == null) {
            this.bWL = null;
        } else {
            this.bWL = my2.IlO();
        }
        this.hp = new ArrayList(list.size());
        this.NV = new float[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.hp.add(list.get(i2).IlO());
        }
        ilO.IlO(this.rp);
        ilO.IlO(this.EV);
        for (int i8 = 0; i8 < this.hp.size(); i8++) {
            ilO.IlO(this.hp.get(i8));
        }
        com.bytedance.adsdk.MY.IlO.MY.IlO<?, Float> ilO3 = this.bWL;
        if (ilO3 != null) {
            ilO.IlO(ilO3);
        }
        this.rp.IlO(this);
        this.EV.IlO(this);
        for (int i9 = 0; i9 < list.size(); i9++) {
            this.hp.get(i9).IlO(this);
        }
        com.bytedance.adsdk.MY.IlO.MY.IlO<?, Float> ilO4 = this.bWL;
        if (ilO4 != null) {
            ilO4.IlO(this);
        }
        if (ilO.NV() != null) {
            com.bytedance.adsdk.MY.IlO.MY.IlO<Float, Float> IlO = ilO.NV().IlO().IlO();
            this.zPa = IlO;
            IlO.IlO(this);
            ilO.IlO(this.zPa);
        }
        if (ilO.EV() != null) {
            this.cl = new com.bytedance.adsdk.MY.IlO.MY.EO(this, ilO, ilO.EV());
        }
    }

    @Override // com.bytedance.adsdk.MY.IlO.MY.IlO.InterfaceC0025IlO
    public void IlO() {
        this.lEW.invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0055  */
    @Override // com.bytedance.adsdk.MY.IlO.IlO.EO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void IlO(java.util.List<com.bytedance.adsdk.MY.IlO.IlO.EO> r8, java.util.List<com.bytedance.adsdk.MY.IlO.IlO.EO> r9) {
        /*
            r7 = this;
            int r0 = r8.size()
            int r0 = r0 + (-1)
            r1 = 0
            r2 = r1
        L8:
            if (r0 < 0) goto L22
            java.lang.Object r3 = r8.get(r0)
            com.bytedance.adsdk.MY.IlO.IlO.EO r3 = (com.bytedance.adsdk.MY.IlO.IlO.EO) r3
            boolean r4 = r3 instanceof com.bytedance.adsdk.MY.IlO.IlO.oeT
            if (r4 == 0) goto L1f
            com.bytedance.adsdk.MY.IlO.IlO.oeT r3 = (com.bytedance.adsdk.MY.IlO.IlO.oeT) r3
            com.bytedance.adsdk.MY.EO.MY.xF$IlO r4 = r3.MY()
            com.bytedance.adsdk.MY.EO.MY.xF$IlO r5 = com.bytedance.adsdk.MY.EO.MY.xF.IlO.INDIVIDUALLY
            if (r4 != r5) goto L1f
            r2 = r3
        L1f:
            int r0 = r0 + (-1)
            goto L8
        L22:
            if (r2 == 0) goto L27
            r2.IlO(r7)
        L27:
            int r8 = r9.size()
            int r8 = r8 + (-1)
            r0 = r1
        L2e:
            if (r8 < 0) goto L6c
            java.lang.Object r3 = r9.get(r8)
            com.bytedance.adsdk.MY.IlO.IlO.EO r3 = (com.bytedance.adsdk.MY.IlO.IlO.EO) r3
            boolean r4 = r3 instanceof com.bytedance.adsdk.MY.IlO.IlO.oeT
            if (r4 == 0) goto L55
            r4 = r3
            com.bytedance.adsdk.MY.IlO.IlO.oeT r4 = (com.bytedance.adsdk.MY.IlO.IlO.oeT) r4
            com.bytedance.adsdk.MY.EO.MY.xF$IlO r5 = r4.MY()
            com.bytedance.adsdk.MY.EO.MY.xF$IlO r6 = com.bytedance.adsdk.MY.EO.MY.xF.IlO.INDIVIDUALLY
            if (r5 != r6) goto L55
            if (r0 == 0) goto L4c
            java.util.List<com.bytedance.adsdk.MY.IlO.IlO.IlO$IlO> r3 = r7.DmF
            r3.add(r0)
        L4c:
            com.bytedance.adsdk.MY.IlO.IlO.IlO$IlO r0 = new com.bytedance.adsdk.MY.IlO.IlO.IlO$IlO
            r0.<init>(r4)
            r4.IlO(r7)
            goto L69
        L55:
            boolean r4 = r3 instanceof com.bytedance.adsdk.MY.IlO.IlO.hp
            if (r4 == 0) goto L69
            if (r0 != 0) goto L60
            com.bytedance.adsdk.MY.IlO.IlO.IlO$IlO r0 = new com.bytedance.adsdk.MY.IlO.IlO.IlO$IlO
            r0.<init>(r2)
        L60:
            java.util.List r4 = com.bytedance.adsdk.MY.IlO.IlO.IlO.C0024IlO.IlO(r0)
            com.bytedance.adsdk.MY.IlO.IlO.hp r3 = (com.bytedance.adsdk.MY.IlO.IlO.hp) r3
            r4.add(r3)
        L69:
            int r8 = r8 + (-1)
            goto L2e
        L6c:
            if (r0 == 0) goto L73
            java.util.List<com.bytedance.adsdk.MY.IlO.IlO.IlO$IlO> r8 = r7.DmF
            r8.add(r0)
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.MY.IlO.IlO.IlO.IlO(java.util.List, java.util.List):void");
    }

    @Override // com.bytedance.adsdk.MY.IlO.IlO.Cc
    public void IlO(Canvas canvas, Matrix matrix, int i2) {
        com.bytedance.adsdk.MY.Cc.IlO("StrokeContent#draw");
        if (com.bytedance.adsdk.MY.vCE.vCE.MY(matrix)) {
            com.bytedance.adsdk.MY.Cc.MY("StrokeContent#draw");
            return;
        }
        this.MY.setAlpha(com.bytedance.adsdk.MY.vCE.Cc.IlO((int) ((((i2 / 255.0f) * ((com.bytedance.adsdk.MY.IlO.MY.vCE) this.rp).DmF()) / 100.0f) * 255.0f), 0, 255));
        this.MY.setStrokeWidth(com.bytedance.adsdk.MY.vCE.vCE.IlO(matrix) * ((com.bytedance.adsdk.MY.IlO.MY.tV) this.EV).DmF());
        if (this.MY.getStrokeWidth() <= 0.0f) {
            com.bytedance.adsdk.MY.Cc.MY("StrokeContent#draw");
            return;
        }
        IlO(matrix);
        com.bytedance.adsdk.MY.IlO.MY.IlO<ColorFilter, ColorFilter> ilO = this.ea;
        if (ilO != null) {
            this.MY.setColorFilter(ilO.Bc());
        }
        com.bytedance.adsdk.MY.IlO.MY.IlO<Float, Float> ilO2 = this.zPa;
        if (ilO2 != null) {
            float fFloatValue = ilO2.Bc().floatValue();
            if (fFloatValue == 0.0f) {
                this.MY.setMaskFilter(null);
            } else if (fFloatValue != this.EO) {
                this.MY.setMaskFilter(this.IlO.MY(fFloatValue));
            }
            this.EO = fFloatValue;
        }
        com.bytedance.adsdk.MY.IlO.MY.EO eo = this.cl;
        if (eo != null) {
            eo.IlO(this.MY);
        }
        for (int i8 = 0; i8 < this.DmF.size(); i8++) {
            C0024IlO c0024IlO = this.DmF.get(i8);
            if (c0024IlO.MY != null) {
                IlO(canvas, c0024IlO, matrix);
            } else {
                com.bytedance.adsdk.MY.Cc.IlO("StrokeContent#buildPath");
                this.Cc.reset();
                for (int size = c0024IlO.IlO.size() - 1; size >= 0; size--) {
                    this.Cc.addPath(((hp) c0024IlO.IlO.get(size)).tV(), matrix);
                }
                com.bytedance.adsdk.MY.Cc.MY("StrokeContent#buildPath");
                com.bytedance.adsdk.MY.Cc.IlO("StrokeContent#drawPath");
                canvas.drawPath(this.Cc, this.MY);
                com.bytedance.adsdk.MY.Cc.MY("StrokeContent#drawPath");
            }
        }
        com.bytedance.adsdk.MY.Cc.MY("StrokeContent#draw");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void IlO(android.graphics.Canvas r17, com.bytedance.adsdk.MY.IlO.IlO.IlO.C0024IlO r18, android.graphics.Matrix r19) {
        /*
            Method dump skipped, instruction units count: 337
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.MY.IlO.IlO.IlO.IlO(android.graphics.Canvas, com.bytedance.adsdk.MY.IlO.IlO.IlO$IlO, android.graphics.Matrix):void");
    }

    @Override // com.bytedance.adsdk.MY.IlO.IlO.Cc
    public void IlO(RectF rectF, Matrix matrix, boolean z2) {
        com.bytedance.adsdk.MY.Cc.IlO("StrokeContent#getBounds");
        this.Cc.reset();
        for (int i2 = 0; i2 < this.DmF.size(); i2++) {
            C0024IlO c0024IlO = this.DmF.get(i2);
            for (int i8 = 0; i8 < c0024IlO.IlO.size(); i8++) {
                this.Cc.addPath(((hp) c0024IlO.IlO.get(i8)).tV(), matrix);
            }
        }
        this.Cc.computeBounds(this.Bc, false);
        float fDmF = ((com.bytedance.adsdk.MY.IlO.MY.tV) this.EV).DmF();
        RectF rectF2 = this.Bc;
        float f4 = fDmF / 2.0f;
        rectF2.set(rectF2.left - f4, rectF2.top - f4, rectF2.right + f4, rectF2.bottom + f4);
        rectF.set(this.Bc);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.bytedance.adsdk.MY.Cc.MY("StrokeContent#getBounds");
    }

    private void IlO(Matrix matrix) {
        com.bytedance.adsdk.MY.Cc.IlO("StrokeContent#applyDashPattern");
        if (this.hp.isEmpty()) {
            com.bytedance.adsdk.MY.Cc.MY("StrokeContent#applyDashPattern");
            return;
        }
        float fIlO = com.bytedance.adsdk.MY.vCE.vCE.IlO(matrix);
        for (int i2 = 0; i2 < this.hp.size(); i2++) {
            this.NV[i2] = this.hp.get(i2).Bc().floatValue();
            if (i2 % 2 == 0) {
                float[] fArr = this.NV;
                if (fArr[i2] < 1.0f) {
                    fArr[i2] = 1.0f;
                }
            } else {
                float[] fArr2 = this.NV;
                if (fArr2[i2] < 0.1f) {
                    fArr2[i2] = 0.1f;
                }
            }
            float[] fArr3 = this.NV;
            fArr3[i2] = fArr3[i2] * fIlO;
        }
        com.bytedance.adsdk.MY.IlO.MY.IlO<?, Float> ilO = this.bWL;
        this.MY.setPathEffect(new DashPathEffect(this.NV, ilO == null ? 0.0f : fIlO * ilO.Bc().floatValue()));
        com.bytedance.adsdk.MY.Cc.MY("StrokeContent#applyDashPattern");
    }
}
