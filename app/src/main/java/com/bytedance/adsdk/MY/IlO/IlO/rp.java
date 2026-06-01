package com.bytedance.adsdk.MY.IlO.IlO;

import android.graphics.Path;
import com.bytedance.adsdk.MY.EO.MY.DmF;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class rp implements NV, hp {
    private final String tV;
    private final com.bytedance.adsdk.MY.EO.MY.DmF vCE;
    private final Path IlO = new Path();
    private final Path MY = new Path();
    private final Path EO = new Path();
    private final List<hp> Cc = new ArrayList();

    /* JADX INFO: renamed from: com.bytedance.adsdk.MY.IlO.IlO.rp$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] IlO;

        static {
            int[] iArr = new int[DmF.IlO.values().length];
            IlO = iArr;
            try {
                iArr[DmF.IlO.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                IlO[DmF.IlO.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                IlO[DmF.IlO.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                IlO[DmF.IlO.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                IlO[DmF.IlO.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public rp(com.bytedance.adsdk.MY.EO.MY.DmF dmF) {
        this.tV = dmF.IlO();
        this.vCE = dmF;
    }

    @Override // com.bytedance.adsdk.MY.IlO.IlO.NV
    public void IlO(ListIterator<EO> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            EO eoPrevious = listIterator.previous();
            if (eoPrevious instanceof hp) {
                this.Cc.add((hp) eoPrevious);
                listIterator.remove();
            }
        }
    }

    @Override // com.bytedance.adsdk.MY.IlO.IlO.hp
    public Path tV() {
        this.EO.reset();
        if (this.vCE.EO()) {
            return this.EO;
        }
        int i2 = AnonymousClass1.IlO[this.vCE.MY().ordinal()];
        if (i2 == 1) {
            IlO();
        } else if (i2 == 2) {
            IlO(Path.Op.UNION);
        } else if (i2 == 3) {
            IlO(Path.Op.REVERSE_DIFFERENCE);
        } else if (i2 == 4) {
            IlO(Path.Op.INTERSECT);
        } else if (i2 == 5) {
            IlO(Path.Op.XOR);
        }
        return this.EO;
    }

    @Override // com.bytedance.adsdk.MY.IlO.IlO.EO
    public void IlO(List<EO> list, List<EO> list2) {
        for (int i2 = 0; i2 < this.Cc.size(); i2++) {
            this.Cc.get(i2).IlO(list, list2);
        }
    }

    private void IlO() {
        for (int i2 = 0; i2 < this.Cc.size(); i2++) {
            this.EO.addPath(this.Cc.get(i2).tV());
        }
    }

    private void IlO(Path.Op op) {
        this.MY.reset();
        this.IlO.reset();
        for (int size = this.Cc.size() - 1; size > 0; size--) {
            hp hpVar = this.Cc.get(size);
            if (hpVar instanceof tV) {
                tV tVVar = (tV) hpVar;
                List<hp> listMY = tVVar.MY();
                for (int size2 = listMY.size() - 1; size2 >= 0; size2--) {
                    Path pathTV = listMY.get(size2).tV();
                    pathTV.transform(tVVar.EO());
                    this.MY.addPath(pathTV);
                }
            } else {
                this.MY.addPath(hpVar.tV());
            }
        }
        hp hpVar2 = this.Cc.get(0);
        if (hpVar2 instanceof tV) {
            tV tVVar2 = (tV) hpVar2;
            List<hp> listMY2 = tVVar2.MY();
            for (int i2 = 0; i2 < listMY2.size(); i2++) {
                Path pathTV2 = listMY2.get(i2).tV();
                pathTV2.transform(tVVar2.EO());
                this.IlO.addPath(pathTV2);
            }
        } else {
            this.IlO.set(hpVar2.tV());
        }
        this.EO.op(this.IlO, this.MY, op);
    }
}
