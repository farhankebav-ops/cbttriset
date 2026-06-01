package com.instagram.common.viewpoint.core;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class A9 implements InterfaceC2196pp {
    public final /* synthetic */ A8 A00;

    public A9(A8 a8) {
        this.A00 = a8;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2196pp
    public final void AF8() {
        ArrayList arrayList;
        synchronized (this.A00.A06) {
            arrayList = new ArrayList(this.A00.A06.size());
            for (Runnable runnable : this.A00.A06.values()) {
                if (runnable != null) {
                    arrayList.add(runnable);
                }
            }
            this.A00.A06.clear();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        if (this.A00.A01 != null) {
            this.A00.A01.AF8();
        }
    }
}
