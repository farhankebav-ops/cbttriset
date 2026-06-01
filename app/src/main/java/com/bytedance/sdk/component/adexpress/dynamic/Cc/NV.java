package com.bytedance.sdk.component.adexpress.dynamic.Cc;

import com.bytedance.sdk.component.adexpress.dynamic.Cc.MY;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class NV {
    public static float IlO(float f4) {
        return (float) Math.ceil((f4 * 16.0f) / 16.0f);
    }

    public static List<MY.IlO> IlO(float f4, List<MY.IlO> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<MY.IlO> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((MY.IlO) it.next().clone());
        }
        int size = arrayList.size();
        boolean z2 = true;
        int i2 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i9 < size) {
            Object obj = arrayList.get(i9);
            i9++;
            MY.IlO ilO = (MY.IlO) obj;
            if (ilO.MY) {
                i2 = (int) (i2 + ilO.IlO);
            } else {
                i8 = (int) (i8 + ilO.IlO);
                z2 = false;
            }
        }
        if (!z2 || f4 <= i2) {
            float f8 = i2;
            float f9 = f4 < f8 ? f4 / f8 : 1.0f;
            float f10 = f4 > f8 ? (f4 - f8) / i8 : 0.0f;
            if (f10 > 1.0f) {
                ArrayList arrayList2 = new ArrayList();
                int size2 = arrayList.size();
                boolean z7 = false;
                int i10 = 0;
                while (i10 < size2) {
                    Object obj2 = arrayList.get(i10);
                    i10++;
                    MY.IlO ilO2 = (MY.IlO) obj2;
                    if (!ilO2.MY) {
                        float f11 = ilO2.EO;
                        if (f11 != 0.0f && ilO2.IlO * f10 > f11) {
                            ilO2.IlO = f11;
                            ilO2.MY = true;
                            z7 = true;
                        }
                    }
                    arrayList2.add(ilO2);
                }
                if (z7) {
                    return IlO(f4, arrayList2);
                }
            }
            int size3 = arrayList.size();
            int i11 = 0;
            int i12 = 0;
            while (i12 < size3) {
                Object obj3 = arrayList.get(i12);
                i12++;
                MY.IlO ilO3 = (MY.IlO) obj3;
                if (ilO3.MY) {
                    ilO3.IlO = IlO(ilO3.IlO * f9);
                } else {
                    ilO3.IlO = IlO(ilO3.IlO * f10);
                }
                i11 = (int) (i11 + ilO3.IlO);
            }
            float f12 = i11;
            if (f12 < f4) {
                float f13 = f4 - f12;
                for (int size4 = 0; size4 < arrayList.size() && f13 > 0.0f; size4 = (size4 + 1) % arrayList.size()) {
                    MY.IlO ilO4 = (MY.IlO) arrayList.get(size4);
                    if ((f4 < f8 && ilO4.MY) || (f4 > f8 && !ilO4.MY)) {
                        ilO4.IlO += 0.0625f;
                        f13 -= 0.0625f;
                    }
                }
            }
        }
        return arrayList;
    }
}
