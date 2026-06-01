package com.ironsource;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.ironsource.of, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2492of extends K4 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2492of(AbstractC2595v0 adUnitData, Cg waterfallInstances) {
        super(adUnitData, waterfallInstances);
        kotlin.jvm.internal.k.e(adUnitData, "adUnitData");
        kotlin.jvm.internal.k.e(waterfallInstances, "waterfallInstances");
    }

    private final int b(AbstractC2662z abstractC2662z) {
        return abstractC2662z.h().l();
    }

    @Override // com.ironsource.F
    public boolean a(AbstractC2662z instance, Cg waterfallInstances) {
        kotlin.jvm.internal.k.e(instance, "instance");
        kotlin.jvm.internal.k.e(waterfallInstances, "waterfallInstances");
        return a(waterfallInstances) < b(instance);
    }

    private final int a(Cg cg) {
        Integer num;
        List<AbstractC2662z> listB = cg.b();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listB) {
            if (((AbstractC2662z) obj).w()) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            Integer numValueOf = Integer.valueOf(b((AbstractC2662z) it.next()));
            while (it.hasNext()) {
                Integer numValueOf2 = Integer.valueOf(b((AbstractC2662z) it.next()));
                if (numValueOf.compareTo(numValueOf2) > 0) {
                    numValueOf = numValueOf2;
                }
            }
            num = numValueOf;
        } else {
            num = null;
        }
        if (num != null) {
            return num.intValue();
        }
        return Integer.MAX_VALUE;
    }
}
