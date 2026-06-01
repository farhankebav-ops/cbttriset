package com.instagram.common.viewpoint.core;

import com.ironsource.mediationsdk.demandOnly.b;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1156Vl {
    public static final Set<Object> A00 = Collections.newSetFromMap(new WeakHashMap());
    public static final AtomicBoolean A01 = new AtomicBoolean(true);
    public static final AtomicReference<InterfaceC1154Vj> A02 = new AtomicReference<>();

    public static void A00(Throwable th, Object obj) throws Throwable {
        if (A01.get()) {
            A00.add(obj);
            W0.A00().AAo(b.C0193b.f9083i, th);
            InterfaceC1154Vj contextRepairHelper = A02.get();
            if (contextRepairHelper != null) {
                contextRepairHelper.AHp(th, obj);
                return;
            }
            return;
        }
        throw th;
    }

    public static void A01(boolean z2, InterfaceC1154Vj interfaceC1154Vj) {
        A01.set(z2);
        A02.set(interfaceC1154Vj);
    }

    public static boolean A02(Object obj) {
        return A00.contains(obj);
    }
}
