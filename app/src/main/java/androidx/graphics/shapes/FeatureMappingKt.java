package androidx.graphics.shapes;

import androidx.graphics.shapes.Feature;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import k6.c;
import k6.d;
import kotlin.jvm.internal.k;
import q5.i;
import r2.q;
import r5.l;
import r5.m;
import r5.v;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class FeatureMappingKt {
    private static final String LOG_TAG = "FeatureMapping";

    public static final List<ProgressableFeature> doMapping(List<ProgressableFeature> f12, List<ProgressableFeature> f22) {
        k.e(f12, "f1");
        k.e(f22, "f2");
        Iterator it = new d(0, f22.size() - 1, 1).iterator();
        c cVar = (c) it;
        if (!cVar.f12714c) {
            throw new NoSuchElementException();
        }
        v vVar = (v) it;
        int iNextInt = vVar.nextInt();
        if (cVar.f12714c) {
            float fFeatureDistSquared = featureDistSquared(f12.get(0).getFeature(), f22.get(iNextInt).getFeature());
            do {
                int iNextInt2 = vVar.nextInt();
                float fFeatureDistSquared2 = featureDistSquared(f12.get(0).getFeature(), f22.get(iNextInt2).getFeature());
                if (Float.compare(fFeatureDistSquared, fFeatureDistSquared2) > 0) {
                    iNextInt = iNextInt2;
                    fFeatureDistSquared = fFeatureDistSquared2;
                }
            } while (cVar.f12714c);
        }
        int size = f12.size();
        int size2 = f22.size();
        ArrayList arrayListI0 = m.I0(f22.get(iNextInt));
        int i2 = iNextInt;
        for (int i8 = 1; i8 < size; i8++) {
            int i9 = iNextInt - (size - i8);
            if (i9 <= i2) {
                i9 += size2;
            }
            Iterator it2 = new d(i2 + 1, i9, 1).iterator();
            c cVar2 = (c) it2;
            if (!cVar2.f12714c) {
                throw new NoSuchElementException();
            }
            v vVar2 = (v) it2;
            int iNextInt3 = vVar2.nextInt();
            if (cVar2.f12714c) {
                float fFeatureDistSquared3 = featureDistSquared(f12.get(i8).getFeature(), f22.get(iNextInt3 % size2).getFeature());
                do {
                    int iNextInt4 = vVar2.nextInt();
                    float fFeatureDistSquared4 = featureDistSquared(f12.get(i8).getFeature(), f22.get(iNextInt4 % size2).getFeature());
                    if (Float.compare(fFeatureDistSquared3, fFeatureDistSquared4) > 0) {
                        iNextInt3 = iNextInt4;
                        fFeatureDistSquared3 = fFeatureDistSquared4;
                    }
                } while (cVar2.f12714c);
            }
            i2 = iNextInt3;
            arrayListI0.add(f22.get(i2 % size2));
        }
        return arrayListI0;
    }

    public static final float featureDistSquared(Feature f12, Feature f22) {
        k.e(f12, "f1");
        k.e(f22, "f2");
        if ((f12 instanceof Feature.Corner) && (f22 instanceof Feature.Corner) && ((Feature.Corner) f12).getConvex() != ((Feature.Corner) f22).getConvex()) {
            return Float.MAX_VALUE;
        }
        float anchor1X = (((Cubic) l.d1(f12.getCubics())).getAnchor1X() + ((Cubic) l.X0(f12.getCubics())).getAnchor0X()) / 2.0f;
        float anchor1Y = (((Cubic) l.d1(f12.getCubics())).getAnchor1Y() + ((Cubic) l.X0(f12.getCubics())).getAnchor0Y()) / 2.0f;
        float anchor1X2 = (((Cubic) l.d1(f22.getCubics())).getAnchor1X() + ((Cubic) l.X0(f22.getCubics())).getAnchor0X()) / 2.0f;
        float f4 = anchor1X - anchor1X2;
        float anchor1Y2 = anchor1Y - ((((Cubic) l.d1(f22.getCubics())).getAnchor1Y() + ((Cubic) l.X0(f22.getCubics())).getAnchor0Y()) / 2.0f);
        return (anchor1Y2 * anchor1Y2) + (f4 * f4);
    }

    public static final DoubleMapper featureMapper(List<ProgressableFeature> features1, List<ProgressableFeature> features2) {
        k.e(features1, "features1");
        k.e(features2, "features2");
        s5.c cVarN = q.N();
        int size = features1.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (features1.get(i2).getFeature() instanceof Feature.Corner) {
                cVarN.add(features1.get(i2));
            }
        }
        s5.c cVarO = q.o(cVarN);
        s5.c cVarN2 = q.N();
        int size2 = features2.size();
        for (int i8 = 0; i8 < size2; i8++) {
            if (features2.get(i8).getFeature() instanceof Feature.Corner) {
                cVarN2.add(features2.get(i8));
            }
        }
        s5.c cVarO2 = q.o(cVarN2);
        i iVar = cVarO.a() > cVarO2.a() ? new i(doMapping(cVarO2, cVarO), cVarO2) : new i(cVarO, doMapping(cVarO, cVarO2));
        List list = (List) iVar.f13498a;
        List list2 = (List) iVar.f13499b;
        s5.c cVarN3 = q.N();
        int size3 = list.size();
        for (int i9 = 0; i9 < size3 && i9 != list2.size(); i9++) {
            cVarN3.add(new i(Float.valueOf(((ProgressableFeature) list.get(i9)).getProgress()), Float.valueOf(((ProgressableFeature) list2.get(i9)).getProgress())));
        }
        i[] iVarArr = (i[]) q.o(cVarN3).toArray(new i[0]);
        return new DoubleMapper((i[]) Arrays.copyOf(iVarArr, iVarArr.length));
    }
}
