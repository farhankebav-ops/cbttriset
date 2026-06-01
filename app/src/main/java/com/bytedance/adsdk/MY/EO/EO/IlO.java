package com.bytedance.adsdk.MY.EO.EO;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import androidx.core.view.ViewCompat;
import com.bytedance.adsdk.MY.EO.EO.Cc;
import com.bytedance.adsdk.MY.EO.MY.bWL;
import com.bytedance.adsdk.MY.EO.MY.lEW;
import com.bytedance.adsdk.MY.IlO.MY.IlO;
import com.bytedance.adsdk.MY.IlO.MY.zPa;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class IlO implements com.bytedance.adsdk.MY.IlO.IlO.Cc, IlO.InterfaceC0025IlO {
    private com.bytedance.adsdk.MY.IlO.MY.lEW AXM;
    float Cc;
    final Cc EO;
    private final Paint EV;
    final Matrix IlO;
    final com.bytedance.adsdk.MY.DmF MY;
    private boolean OOq;
    private final Paint bWL;
    private final RectF cL;
    private final RectF cl;
    private float dY;
    private final RectF ea;
    private final RectF es;
    private final Paint hp;
    private IlO kBB;
    private Paint oc;
    private com.bytedance.adsdk.MY.IlO.MY.tV oeT;
    private List<IlO> pP;
    private final Paint rp;
    final zPa tV;
    private final List<com.bytedance.adsdk.MY.IlO.MY.IlO<?, ?>> tl;
    private IlO vAh;
    BlurMaskFilter vCE;
    private final Matrix vSq;
    private boolean wPn;
    private final String xF;
    private final RectF zPa;
    private final Path Bc = new Path();
    private final Matrix lEW = new Matrix();
    private final Matrix DmF = new Matrix();
    private final Paint NV = new com.bytedance.adsdk.MY.IlO.IlO(1);

    /* JADX INFO: renamed from: com.bytedance.adsdk.MY.EO.EO.IlO$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] IlO;
        static final /* synthetic */ int[] MY;

        static {
            int[] iArr = new int[lEW.IlO.values().length];
            MY = iArr;
            try {
                iArr[lEW.IlO.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                MY[lEW.IlO.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                MY[lEW.IlO.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                MY[lEW.IlO.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[Cc.IlO.values().length];
            IlO = iArr2;
            try {
                iArr2[Cc.IlO.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                IlO[Cc.IlO.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                IlO[Cc.IlO.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                IlO[Cc.IlO.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                IlO[Cc.IlO.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                IlO[Cc.IlO.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                IlO[Cc.IlO.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public IlO(com.bytedance.adsdk.MY.DmF dmF, Cc cc) {
        PorterDuff.Mode mode = PorterDuff.Mode.DST_IN;
        this.EV = new com.bytedance.adsdk.MY.IlO.IlO(1, mode);
        PorterDuff.Mode mode2 = PorterDuff.Mode.DST_OUT;
        this.rp = new com.bytedance.adsdk.MY.IlO.IlO(1, mode2);
        com.bytedance.adsdk.MY.IlO.IlO ilO = new com.bytedance.adsdk.MY.IlO.IlO(1);
        this.hp = ilO;
        this.bWL = new com.bytedance.adsdk.MY.IlO.IlO(PorterDuff.Mode.CLEAR);
        this.ea = new RectF();
        this.zPa = new RectF();
        this.cl = new RectF();
        this.cL = new RectF();
        this.es = new RectF();
        this.IlO = new Matrix();
        this.tl = new ArrayList();
        this.OOq = true;
        this.Cc = 0.0f;
        this.vSq = new Matrix();
        this.dY = 1.0f;
        this.MY = dmF;
        this.EO = cc;
        this.xF = cc.vCE() + "#draw";
        if (cc.rp() == Cc.MY.INVERT) {
            ilO.setXfermode(new PorterDuffXfermode(mode2));
        } else {
            ilO.setXfermode(new PorterDuffXfermode(mode));
        }
        zPa zpaNV = cc.ea().NV();
        this.tV = zpaNV;
        zpaNV.IlO((IlO.InterfaceC0025IlO) this);
        if (cc.NV() != null && !cc.NV().isEmpty()) {
            com.bytedance.adsdk.MY.IlO.MY.lEW lew = new com.bytedance.adsdk.MY.IlO.MY.lEW(cc.NV());
            this.AXM = lew;
            Iterator<com.bytedance.adsdk.MY.IlO.MY.IlO<bWL, Path>> it = lew.MY().iterator();
            while (it.hasNext()) {
                it.next().IlO(this);
            }
            for (com.bytedance.adsdk.MY.IlO.MY.IlO<Integer, Integer> ilO2 : this.AXM.EO()) {
                IlO(ilO2);
                ilO2.IlO(this);
            }
        }
        rp();
    }

    private boolean bWL() {
        if (this.AXM.MY().isEmpty()) {
            return false;
        }
        for (int i2 = 0; i2 < this.AXM.IlO().size(); i2++) {
            if (this.AXM.IlO().get(i2).IlO() != lEW.IlO.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    private void ea() {
        if (this.pP != null) {
            return;
        }
        if (this.kBB == null) {
            this.pP = Collections.EMPTY_LIST;
            return;
        }
        this.pP = new ArrayList();
        for (IlO ilO = this.kBB; ilO != null; ilO = ilO.kBB) {
            this.pP.add(ilO);
        }
    }

    private void hp() {
        this.MY.invalidateSelf();
    }

    private void rp() {
        if (this.EO.tV().isEmpty()) {
            MY(true);
            return;
        }
        com.bytedance.adsdk.MY.IlO.MY.tV tVVar = new com.bytedance.adsdk.MY.IlO.MY.tV(this.EO.tV());
        this.oeT = tVVar;
        tVVar.IlO();
        this.oeT.IlO(new IlO.InterfaceC0025IlO() { // from class: com.bytedance.adsdk.MY.EO.EO.IlO.1
            @Override // com.bytedance.adsdk.MY.IlO.MY.IlO.InterfaceC0025IlO
            public void IlO() {
                IlO ilO = IlO.this;
                ilO.MY(ilO.oeT.DmF() == 1.0f);
            }
        });
        MY(this.oeT.Bc().floatValue() == 1.0f);
        IlO(this.oeT);
    }

    public boolean Bc() {
        com.bytedance.adsdk.MY.IlO.MY.lEW lew = this.AXM;
        return (lew == null || lew.MY().isEmpty()) ? false : true;
    }

    public String Cc() {
        Cc cc = this.EO;
        if (cc != null) {
            return cc.Bc();
        }
        return null;
    }

    public String DmF() {
        return this.EO.vCE();
    }

    public com.bytedance.adsdk.MY.Cc.NV EV() {
        return this.EO.kBB();
    }

    @Override // com.bytedance.adsdk.MY.IlO.IlO.EO
    public void IlO(List<com.bytedance.adsdk.MY.IlO.IlO.EO> list, List<com.bytedance.adsdk.MY.IlO.IlO.EO> list2) {
    }

    public Cc MY() {
        return this.EO;
    }

    public com.bytedance.adsdk.MY.EO.MY.IlO NV() {
        return this.EO.vAh();
    }

    public boolean lEW() {
        return this.OOq;
    }

    public Matrix tV() {
        return this.vSq;
    }

    public float vCE() {
        return this.dY;
    }

    private void tV(Canvas canvas, Matrix matrix, com.bytedance.adsdk.MY.IlO.MY.IlO<bWL, Path> ilO, com.bytedance.adsdk.MY.IlO.MY.IlO<Integer, Integer> ilO2) {
        com.bytedance.adsdk.MY.vCE.vCE.IlO(canvas, this.ea, this.EV);
        this.Bc.set(ilO.Bc());
        this.Bc.transform(matrix);
        this.NV.setAlpha((int) (ilO2.Bc().intValue() * 2.55f));
        canvas.drawPath(this.Bc, this.NV);
        canvas.restore();
    }

    public boolean EO() {
        return this.vAh != null;
    }

    public void MY(IlO ilO) {
        this.kBB = ilO;
    }

    private void Cc(Canvas canvas, Matrix matrix, com.bytedance.adsdk.MY.IlO.MY.IlO<bWL, Path> ilO, com.bytedance.adsdk.MY.IlO.MY.IlO<Integer, Integer> ilO2) {
        com.bytedance.adsdk.MY.vCE.vCE.IlO(canvas, this.ea, this.EV);
        canvas.drawRect(this.ea, this.NV);
        this.rp.setAlpha((int) (ilO2.Bc().intValue() * 2.55f));
        this.Bc.set(ilO.Bc());
        this.Bc.transform(matrix);
        canvas.drawPath(this.Bc, this.rp);
        canvas.restore();
    }

    private void EO(float f4) {
        this.MY.tl().EO().IlO(this.EO.vCE(), f4);
    }

    public static IlO IlO(MY my, Cc cc, com.bytedance.adsdk.MY.DmF dmF, com.bytedance.adsdk.MY.Bc bc, Context context) {
        switch (AnonymousClass2.IlO[cc.EV().ordinal()]) {
            case 1:
                return new Bc(dmF, cc, my, bc);
            case 2:
                return new MY(dmF, cc, bc.MY(cc.Bc()), bc, context);
            case 3:
                return new lEW(dmF, cc);
            case 4:
                if (IlO(dmF, cc, "text:")) {
                    return new EO(dmF, cc, context);
                }
                if (IlO(dmF, cc, "videoview:")) {
                    return new NV(dmF, cc, context);
                }
                return new tV(dmF, cc);
            case 5:
                return new vCE(dmF, cc);
            case 6:
                return new DmF(dmF, cc);
            default:
                Objects.toString(cc.EV());
                return null;
        }
    }

    private void MY(RectF rectF, Matrix matrix) {
        if (EO() && this.EO.rp() != Cc.MY.INVERT) {
            this.cL.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.vAh.IlO(this.cL, matrix, true);
            if (rectF.intersect(this.cL)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private void EO(Canvas canvas, Matrix matrix, com.bytedance.adsdk.MY.IlO.MY.IlO<bWL, Path> ilO, com.bytedance.adsdk.MY.IlO.MY.IlO<Integer, Integer> ilO2) {
        com.bytedance.adsdk.MY.vCE.vCE.IlO(canvas, this.ea, this.rp);
        canvas.drawRect(this.ea, this.NV);
        this.rp.setAlpha((int) (ilO2.Bc().intValue() * 2.55f));
        this.Bc.set(ilO.Bc());
        this.Bc.transform(matrix);
        canvas.drawPath(this.Bc, this.rp);
        canvas.restore();
    }

    public void MY(Canvas canvas, Matrix matrix, int i2) {
        IlO(i2);
    }

    private void MY(Canvas canvas, Matrix matrix, com.bytedance.adsdk.MY.IlO.MY.IlO<bWL, Path> ilO, com.bytedance.adsdk.MY.IlO.MY.IlO<Integer, Integer> ilO2) {
        com.bytedance.adsdk.MY.vCE.vCE.IlO(canvas, this.ea, this.NV);
        canvas.drawRect(this.ea, this.NV);
        this.Bc.set(ilO.Bc());
        this.Bc.transform(matrix);
        this.NV.setAlpha((int) (ilO2.Bc().intValue() * 2.55f));
        canvas.drawPath(this.Bc, this.rp);
        canvas.restore();
    }

    private static boolean IlO(com.bytedance.adsdk.MY.DmF dmF, Cc cc, String str) {
        com.bytedance.adsdk.MY.NV nvVCE;
        if (dmF == null || cc == null || str == null || (nvVCE = dmF.vCE(cc.Bc())) == null) {
            return false;
        }
        return str.equals(nvVCE.NV());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MY(boolean z2) {
        if (z2 != this.OOq) {
            this.OOq = z2;
            hp();
        }
    }

    public void IlO(boolean z2) {
        if (z2 && this.oc == null) {
            this.oc = new com.bytedance.adsdk.MY.IlO.IlO();
        }
        this.wPn = z2;
    }

    @Override // com.bytedance.adsdk.MY.IlO.MY.IlO.InterfaceC0025IlO
    public void IlO() {
        hp();
    }

    public BlurMaskFilter MY(float f4) {
        if (this.Cc == f4) {
            return this.vCE;
        }
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(f4 / 2.0f, BlurMaskFilter.Blur.NORMAL);
        this.vCE = blurMaskFilter;
        this.Cc = f4;
        return blurMaskFilter;
    }

    public void IlO(IlO ilO) {
        this.vAh = ilO;
    }

    public void IlO(com.bytedance.adsdk.MY.IlO.MY.IlO<?, ?> ilO) {
        if (ilO == null) {
            return;
        }
        this.tl.add(ilO);
    }

    @Override // com.bytedance.adsdk.MY.IlO.IlO.Cc
    public void IlO(RectF rectF, Matrix matrix, boolean z2) {
        this.ea.set(0.0f, 0.0f, 0.0f, 0.0f);
        ea();
        this.IlO.set(matrix);
        if (z2) {
            List<IlO> list = this.pP;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.IlO.preConcat(this.pP.get(size).tV.tV());
                }
            } else {
                IlO ilO = this.kBB;
                if (ilO != null) {
                    this.IlO.preConcat(ilO.tV.tV());
                }
            }
        }
        this.IlO.preConcat(this.tV.tV());
    }

    @Override // com.bytedance.adsdk.MY.IlO.IlO.Cc
    public void IlO(Canvas canvas, Matrix matrix, int i2) {
        Paint paint;
        Integer numBc;
        com.bytedance.adsdk.MY.Cc.IlO(this.xF);
        if (this.OOq && !this.EO.oeT()) {
            ea();
            com.bytedance.adsdk.MY.Cc.IlO("Layer#parentMatrix");
            this.vSq.set(matrix);
            this.lEW.reset();
            this.lEW.set(matrix);
            for (int size = this.pP.size() - 1; size >= 0; size--) {
                this.lEW.preConcat(this.pP.get(size).tV.tV());
            }
            com.bytedance.adsdk.MY.Cc.MY("Layer#parentMatrix");
            com.bytedance.adsdk.MY.IlO.MY.IlO<?, Integer> IlO = this.tV.IlO();
            int iIntValue = (int) ((((i2 / 255.0f) * ((IlO == null || (numBc = IlO.Bc()) == null) ? 100 : numBc.intValue())) / 100.0f) * 255.0f);
            if (!EO() && !Bc()) {
                this.lEW.preConcat(this.tV.tV());
                com.bytedance.adsdk.MY.Cc.IlO("Layer#drawLayer");
                MY(canvas, this.lEW, iIntValue);
                com.bytedance.adsdk.MY.Cc.MY("Layer#drawLayer");
                EO(com.bytedance.adsdk.MY.Cc.MY(this.xF));
                return;
            }
            com.bytedance.adsdk.MY.Cc.IlO("Layer#computeBounds");
            IlO(this.ea, this.lEW, false);
            MY(this.ea, matrix);
            this.lEW.preConcat(this.tV.tV());
            IlO(this.ea, this.lEW);
            this.zPa.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
            canvas.getMatrix(this.DmF);
            if (!this.DmF.isIdentity()) {
                Matrix matrix2 = this.DmF;
                matrix2.invert(matrix2);
                this.DmF.mapRect(this.zPa);
            }
            if (!this.ea.intersect(this.zPa)) {
                this.ea.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
            com.bytedance.adsdk.MY.Cc.MY("Layer#computeBounds");
            if (this.ea.width() >= 1.0f && this.ea.height() >= 1.0f) {
                com.bytedance.adsdk.MY.Cc.IlO("Layer#saveLayer");
                this.NV.setAlpha(255);
                com.bytedance.adsdk.MY.vCE.vCE.IlO(canvas, this.ea, this.NV);
                com.bytedance.adsdk.MY.Cc.MY("Layer#saveLayer");
                IlO(canvas);
                com.bytedance.adsdk.MY.Cc.IlO("Layer#drawLayer");
                MY(canvas, this.lEW, iIntValue);
                com.bytedance.adsdk.MY.Cc.MY("Layer#drawLayer");
                if (Bc()) {
                    IlO(canvas, this.lEW);
                }
                if (EO()) {
                    com.bytedance.adsdk.MY.Cc.IlO("Layer#drawMatte");
                    com.bytedance.adsdk.MY.Cc.IlO("Layer#saveLayer");
                    com.bytedance.adsdk.MY.vCE.vCE.IlO(canvas, this.ea, this.hp, 19);
                    com.bytedance.adsdk.MY.Cc.MY("Layer#saveLayer");
                    IlO(canvas);
                    this.vAh.IlO(canvas, matrix, iIntValue);
                    com.bytedance.adsdk.MY.Cc.IlO("Layer#restoreLayer");
                    canvas.restore();
                    com.bytedance.adsdk.MY.Cc.MY("Layer#restoreLayer");
                    com.bytedance.adsdk.MY.Cc.MY("Layer#drawMatte");
                }
                com.bytedance.adsdk.MY.Cc.IlO("Layer#restoreLayer");
                canvas.restore();
                com.bytedance.adsdk.MY.Cc.MY("Layer#restoreLayer");
            }
            if (this.wPn && (paint = this.oc) != null) {
                paint.setStyle(Paint.Style.STROKE);
                this.oc.setColor(-251901);
                this.oc.setStrokeWidth(4.0f);
                canvas.drawRect(this.ea, this.oc);
                this.oc.setStyle(Paint.Style.FILL);
                this.oc.setColor(1357638635);
                canvas.drawRect(this.ea, this.oc);
            }
            EO(com.bytedance.adsdk.MY.Cc.MY(this.xF));
            return;
        }
        com.bytedance.adsdk.MY.Cc.MY(this.xF);
    }

    private void IlO(Canvas canvas) {
        com.bytedance.adsdk.MY.Cc.IlO("Layer#clearLayer");
        RectF rectF = this.ea;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.bWL);
        com.bytedance.adsdk.MY.Cc.MY("Layer#clearLayer");
    }

    private void IlO(RectF rectF, Matrix matrix) {
        this.cl.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (Bc()) {
            int size = this.AXM.IlO().size();
            for (int i2 = 0; i2 < size; i2++) {
                com.bytedance.adsdk.MY.EO.MY.lEW lew = this.AXM.IlO().get(i2);
                Path pathBc = this.AXM.MY().get(i2).Bc();
                if (pathBc != null) {
                    this.Bc.set(pathBc);
                    this.Bc.transform(matrix);
                    int i8 = AnonymousClass2.MY[lew.IlO().ordinal()];
                    if (i8 == 1 || i8 == 2) {
                        return;
                    }
                    if ((i8 == 3 || i8 == 4) && lew.tV()) {
                        return;
                    }
                    this.Bc.computeBounds(this.es, false);
                    if (i2 == 0) {
                        this.cl.set(this.es);
                    } else {
                        RectF rectF2 = this.cl;
                        rectF2.set(Math.min(rectF2.left, this.es.left), Math.min(this.cl.top, this.es.top), Math.max(this.cl.right, this.es.right), Math.max(this.cl.bottom, this.es.bottom));
                    }
                }
            }
            if (rectF.intersect(this.cl)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public void IlO(int i2) {
        this.dY = (i2 / 255.0f) * ((this.tV.IlO() != null ? this.tV.IlO().Bc().intValue() : 100) / 100.0f);
    }

    private void IlO(Canvas canvas, Matrix matrix) {
        com.bytedance.adsdk.MY.Cc.IlO("Layer#saveLayer");
        com.bytedance.adsdk.MY.vCE.vCE.IlO(canvas, this.ea, this.EV, 19);
        if (Build.VERSION.SDK_INT < 28) {
            IlO(canvas);
        }
        com.bytedance.adsdk.MY.Cc.MY("Layer#saveLayer");
        for (int i2 = 0; i2 < this.AXM.IlO().size(); i2++) {
            com.bytedance.adsdk.MY.EO.MY.lEW lew = this.AXM.IlO().get(i2);
            com.bytedance.adsdk.MY.IlO.MY.IlO<bWL, Path> ilO = this.AXM.MY().get(i2);
            com.bytedance.adsdk.MY.IlO.MY.IlO<Integer, Integer> ilO2 = this.AXM.EO().get(i2);
            int i8 = AnonymousClass2.MY[lew.IlO().ordinal()];
            if (i8 != 1) {
                if (i8 == 2) {
                    if (i2 == 0) {
                        this.NV.setColor(ViewCompat.MEASURED_STATE_MASK);
                        this.NV.setAlpha(255);
                        canvas.drawRect(this.ea, this.NV);
                    }
                    if (lew.tV()) {
                        EO(canvas, matrix, ilO, ilO2);
                    } else {
                        IlO(canvas, matrix, ilO);
                    }
                } else if (i8 != 3) {
                    if (i8 == 4) {
                        if (lew.tV()) {
                            MY(canvas, matrix, ilO, ilO2);
                        } else {
                            IlO(canvas, matrix, ilO, ilO2);
                        }
                    }
                } else if (lew.tV()) {
                    Cc(canvas, matrix, ilO, ilO2);
                } else {
                    tV(canvas, matrix, ilO, ilO2);
                }
            } else if (bWL()) {
                this.NV.setAlpha(255);
                canvas.drawRect(this.ea, this.NV);
            }
        }
        com.bytedance.adsdk.MY.Cc.IlO("Layer#restoreLayer");
        canvas.restore();
        com.bytedance.adsdk.MY.Cc.MY("Layer#restoreLayer");
    }

    private void IlO(Canvas canvas, Matrix matrix, com.bytedance.adsdk.MY.IlO.MY.IlO<bWL, Path> ilO, com.bytedance.adsdk.MY.IlO.MY.IlO<Integer, Integer> ilO2) {
        this.Bc.set(ilO.Bc());
        this.Bc.transform(matrix);
        this.NV.setAlpha((int) (ilO2.Bc().intValue() * 2.55f));
        canvas.drawPath(this.Bc, this.NV);
    }

    private void IlO(Canvas canvas, Matrix matrix, com.bytedance.adsdk.MY.IlO.MY.IlO<bWL, Path> ilO) {
        this.Bc.set(ilO.Bc());
        this.Bc.transform(matrix);
        canvas.drawPath(this.Bc, this.rp);
    }

    public void IlO(float f4) {
        this.tV.IlO(f4);
        if (this.AXM != null) {
            for (int i2 = 0; i2 < this.AXM.MY().size(); i2++) {
                this.AXM.MY().get(i2).IlO(f4);
            }
        }
        com.bytedance.adsdk.MY.IlO.MY.tV tVVar = this.oeT;
        if (tVVar != null) {
            tVVar.IlO(f4);
        }
        IlO ilO = this.vAh;
        if (ilO != null) {
            ilO.IlO(f4);
        }
        for (int i8 = 0; i8 < this.tl.size(); i8++) {
            this.tl.get(i8).IlO(f4);
        }
    }
}
