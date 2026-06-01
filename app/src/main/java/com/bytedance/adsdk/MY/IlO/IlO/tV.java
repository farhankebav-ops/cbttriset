package com.bytedance.adsdk.MY.IlO.IlO;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.bytedance.adsdk.MY.IlO.MY.IlO;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV implements Cc, hp, IlO.InterfaceC0025IlO {
    private final boolean Bc;
    private final RectF Cc;
    private final com.bytedance.adsdk.MY.DmF DmF;
    private final Matrix EO;
    private com.bytedance.adsdk.MY.IlO.MY.zPa EV;
    private final Paint IlO;
    private final RectF MY;
    private List<hp> NV;
    private final List<EO> lEW;
    private final Path tV;
    private final String vCE;

    public tV(com.bytedance.adsdk.MY.DmF dmF, com.bytedance.adsdk.MY.EO.EO.IlO ilO, com.bytedance.adsdk.MY.EO.MY.zPa zpa, com.bytedance.adsdk.MY.Bc bc) {
        this(dmF, ilO, zpa.IlO(), zpa.EO(), IlO(dmF, bc, ilO, zpa.MY()), IlO(zpa.MY()));
    }

    private boolean Cc() {
        int i2 = 0;
        for (int i8 = 0; i8 < this.lEW.size(); i8++) {
            if ((this.lEW.get(i8) instanceof Cc) && (i2 = i2 + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    private static List<EO> IlO(com.bytedance.adsdk.MY.DmF dmF, com.bytedance.adsdk.MY.Bc bc, com.bytedance.adsdk.MY.EO.EO.IlO ilO, List<com.bytedance.adsdk.MY.EO.MY.EO> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            EO eoIlO = list.get(i2).IlO(dmF, bc, ilO);
            if (eoIlO != null) {
                arrayList.add(eoIlO);
            }
        }
        return arrayList;
    }

    public Matrix EO() {
        com.bytedance.adsdk.MY.IlO.MY.zPa zpa = this.EV;
        if (zpa != null) {
            return zpa.tV();
        }
        this.EO.reset();
        return this.EO;
    }

    public List<hp> MY() {
        if (this.NV == null) {
            this.NV = new ArrayList();
            for (int i2 = 0; i2 < this.lEW.size(); i2++) {
                EO eo = this.lEW.get(i2);
                if (eo instanceof hp) {
                    this.NV.add((hp) eo);
                }
            }
        }
        return this.NV;
    }

    @Override // com.bytedance.adsdk.MY.IlO.IlO.hp
    public Path tV() {
        this.EO.reset();
        com.bytedance.adsdk.MY.IlO.MY.zPa zpa = this.EV;
        if (zpa != null) {
            this.EO.set(zpa.tV());
        }
        this.tV.reset();
        if (this.Bc) {
            return this.tV;
        }
        for (int size = this.lEW.size() - 1; size >= 0; size--) {
            EO eo = this.lEW.get(size);
            if (eo instanceof hp) {
                this.tV.addPath(((hp) eo).tV(), this.EO);
            }
        }
        return this.tV;
    }

    public tV(com.bytedance.adsdk.MY.DmF dmF, com.bytedance.adsdk.MY.EO.EO.IlO ilO, String str, boolean z2, List<EO> list, com.bytedance.adsdk.MY.EO.IlO.rp rpVar) {
        this.IlO = new com.bytedance.adsdk.MY.IlO.IlO();
        this.MY = new RectF();
        this.EO = new Matrix();
        this.tV = new Path();
        this.Cc = new RectF();
        this.vCE = str;
        this.DmF = dmF;
        this.Bc = z2;
        this.lEW = list;
        if (rpVar != null) {
            com.bytedance.adsdk.MY.IlO.MY.zPa zpaNV = rpVar.NV();
            this.EV = zpaNV;
            zpaNV.IlO(ilO);
            this.EV.IlO(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            EO eo = list.get(size);
            if (eo instanceof NV) {
                arrayList.add((NV) eo);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((NV) arrayList.get(size2)).IlO(list.listIterator(list.size()));
        }
    }

    public static com.bytedance.adsdk.MY.EO.IlO.rp IlO(List<com.bytedance.adsdk.MY.EO.MY.EO> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            com.bytedance.adsdk.MY.EO.MY.EO eo = list.get(i2);
            if (eo instanceof com.bytedance.adsdk.MY.EO.IlO.rp) {
                return (com.bytedance.adsdk.MY.EO.IlO.rp) eo;
            }
        }
        return null;
    }

    @Override // com.bytedance.adsdk.MY.IlO.MY.IlO.InterfaceC0025IlO
    public void IlO() {
        this.DmF.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.MY.IlO.IlO.EO
    public void IlO(List<EO> list, List<EO> list2) {
        ArrayList arrayList = new ArrayList(this.lEW.size() + list.size());
        arrayList.addAll(list);
        for (int size = this.lEW.size() - 1; size >= 0; size--) {
            EO eo = this.lEW.get(size);
            eo.IlO(arrayList, this.lEW.subList(0, size));
            arrayList.add(eo);
        }
    }

    @Override // com.bytedance.adsdk.MY.IlO.IlO.Cc
    public void IlO(Canvas canvas, Matrix matrix, int i2) {
        if (this.Bc) {
            return;
        }
        this.EO.set(matrix);
        com.bytedance.adsdk.MY.IlO.MY.zPa zpa = this.EV;
        if (zpa != null) {
            this.EO.preConcat(zpa.tV());
            i2 = (int) (((((this.EV.IlO() == null ? 100 : this.EV.IlO().Bc().intValue()) / 100.0f) * i2) / 255.0f) * 255.0f);
        }
        boolean z2 = this.DmF.DmF() && Cc() && i2 != 255;
        if (z2) {
            this.MY.set(0.0f, 0.0f, 0.0f, 0.0f);
            IlO(this.MY, this.EO, true);
            this.IlO.setAlpha(i2);
            com.bytedance.adsdk.MY.vCE.vCE.IlO(canvas, this.MY, this.IlO);
        }
        if (z2) {
            i2 = 255;
        }
        for (int size = this.lEW.size() - 1; size >= 0; size--) {
            EO eo = this.lEW.get(size);
            if (eo instanceof Cc) {
                ((Cc) eo).IlO(canvas, this.EO, i2);
            }
        }
        if (z2) {
            canvas.restore();
        }
    }

    @Override // com.bytedance.adsdk.MY.IlO.IlO.Cc
    public void IlO(RectF rectF, Matrix matrix, boolean z2) {
        this.EO.set(matrix);
        com.bytedance.adsdk.MY.IlO.MY.zPa zpa = this.EV;
        if (zpa != null) {
            this.EO.preConcat(zpa.tV());
        }
        this.Cc.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.lEW.size() - 1; size >= 0; size--) {
            EO eo = this.lEW.get(size);
            if (eo instanceof Cc) {
                ((Cc) eo).IlO(this.Cc, this.EO, z2);
                rectF.union(this.Cc);
            }
        }
    }
}
