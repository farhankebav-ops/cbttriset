package com.bytedance.adsdk.MY.EO.EO;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.LongSparseArray;
import com.bytedance.adsdk.MY.EO.EO.Cc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY extends IlO {
    private com.bytedance.adsdk.MY.IlO.MY.IlO<Float, Float> Bc;
    private final RectF DmF;
    private final Paint EV;
    private final RectF NV;
    private final List<IlO> lEW;
    private boolean rp;

    /* JADX INFO: renamed from: com.bytedance.adsdk.MY.EO.EO.MY$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] IlO;

        static {
            int[] iArr = new int[Cc.MY.values().length];
            IlO = iArr;
            try {
                iArr[Cc.MY.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                IlO[Cc.MY.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public MY(com.bytedance.adsdk.MY.DmF dmF, Cc cc, List<Cc> list, com.bytedance.adsdk.MY.Bc bc, Context context) {
        int i2;
        IlO ilO;
        Cc.MY myRp;
        int i8;
        super(dmF, cc);
        this.lEW = new ArrayList();
        this.DmF = new RectF();
        this.NV = new RectF();
        this.EV = new Paint();
        this.rp = true;
        com.bytedance.adsdk.MY.EO.IlO.MY myAXM = cc.AXM();
        if (myAXM != null) {
            com.bytedance.adsdk.MY.IlO.MY.IlO<Float, Float> IlO = myAXM.IlO();
            this.Bc = IlO;
            IlO(IlO);
            this.Bc.IlO(this);
        } else {
            this.Bc = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(bc.hp().size());
        int size = list.size() - 1;
        IlO ilO2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            Cc cc2 = list.get(size);
            IlO IlO2 = IlO.IlO(this, cc2, dmF, bc, context);
            if (IlO2 != null) {
                longSparseArray.put(IlO2.MY().Cc(), IlO2);
                if (ilO2 != null) {
                    ilO2.IlO(IlO2);
                    ilO2 = null;
                } else {
                    this.lEW.add(0, IlO2);
                    if (cc2 != null && (myRp = cc2.rp()) != null && ((i8 = AnonymousClass1.IlO[myRp.ordinal()]) == 1 || i8 == 2)) {
                        ilO2 = IlO2;
                    }
                }
            }
            size--;
        }
        for (i2 = 0; i2 < longSparseArray.size(); i2++) {
            IlO ilO3 = (IlO) longSparseArray.get(longSparseArray.keyAt(i2));
            if (ilO3 != null && (ilO = (IlO) longSparseArray.get(ilO3.MY().hp())) != null) {
                ilO3.MY(ilO);
            }
        }
    }

    @Override // com.bytedance.adsdk.MY.EO.EO.IlO
    public void IlO(boolean z2) {
        super.IlO(z2);
        Iterator<IlO> it = this.lEW.iterator();
        while (it.hasNext()) {
            it.next().IlO(z2);
        }
    }

    public void MY(boolean z2) {
        this.rp = z2;
    }

    public List<IlO> rp() {
        return this.lEW;
    }

    @Override // com.bytedance.adsdk.MY.EO.EO.IlO
    public void MY(Canvas canvas, Matrix matrix, int i2) {
        super.MY(canvas, matrix, i2);
        com.bytedance.adsdk.MY.Cc.IlO("CompositionLayer#draw");
        this.NV.set(0.0f, 0.0f, this.EO.lEW(), this.EO.DmF());
        matrix.mapRect(this.NV);
        boolean z2 = this.MY.DmF() && this.lEW.size() > 1 && i2 != 255;
        if (z2) {
            this.EV.setAlpha(i2);
            com.bytedance.adsdk.MY.vCE.vCE.IlO(canvas, this.NV, this.EV);
        } else {
            canvas.save();
        }
        if (z2) {
            i2 = 255;
        }
        for (int size = this.lEW.size() - 1; size >= 0; size--) {
            if (((this.rp || !"__container".equals(this.EO.vCE())) && !this.NV.isEmpty()) ? canvas.clipRect(this.NV) : true) {
                this.lEW.get(size).IlO(canvas, matrix, i2);
            }
        }
        canvas.restore();
        com.bytedance.adsdk.MY.Cc.MY("CompositionLayer#draw");
    }

    @Override // com.bytedance.adsdk.MY.EO.EO.IlO, com.bytedance.adsdk.MY.IlO.IlO.Cc
    public void IlO(RectF rectF, Matrix matrix, boolean z2) {
        super.IlO(rectF, matrix, z2);
        for (int size = this.lEW.size() - 1; size >= 0; size--) {
            this.DmF.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.lEW.get(size).IlO(this.DmF, this.IlO, true);
            rectF.union(this.DmF);
        }
    }

    @Override // com.bytedance.adsdk.MY.EO.EO.IlO
    public void IlO(float f4) {
        super.IlO(f4);
        if (this.Bc != null) {
            f4 = ((this.EO.IlO().rp() * this.Bc.Bc().floatValue()) - this.EO.IlO().vCE()) / (this.MY.tl().cl() + 0.01f);
        }
        if (this.Bc == null) {
            f4 -= this.EO.EO();
        }
        if (this.EO.MY() != 0.0f && !"__container".equals(this.EO.vCE())) {
            f4 /= this.EO.MY();
        }
        for (int size = this.lEW.size() - 1; size >= 0; size--) {
            this.lEW.get(size).IlO(f4);
        }
    }
}
