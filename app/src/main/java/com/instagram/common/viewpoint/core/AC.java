package com.instagram.common.viewpoint.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class AC implements InterfaceC2207q2 {
    public final List<InterfaceC2208q3> A00 = new ArrayList();

    @Override // com.instagram.common.viewpoint.core.InterfaceC2207q2
    public final InterfaceC2208q3 A6a(int i2) {
        this.A00.get(i2);
        return null;
    }

    @Override // java.lang.Iterable
    public final Iterator<InterfaceC2208q3> iterator() {
        return this.A00.iterator();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2207q2
    public final int size() {
        return this.A00.size();
    }
}
