package com.instagram.common.viewpoint.core;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class ES {
    public final CopyOnWriteArrayList<ER> A00 = new CopyOnWriteArrayList<>();

    public final void A00(int i2, long j, long j3) {
        Iterator<ER> it = this.A00.iterator();
        if (it.hasNext()) {
            it.next();
            ER.A02(null);
            throw null;
        }
    }
}
