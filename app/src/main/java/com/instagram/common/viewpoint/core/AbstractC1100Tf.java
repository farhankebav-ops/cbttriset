package com.instagram.common.viewpoint.core;

import com.instagram.common.viewpoint.core.C1098Td;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Tf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1100Tf<T extends C1098Td> {
    public abstract Class<T> A01();

    public abstract void A03(T t3);

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Tf != com.facebook.ads.internal.events.EventSubscriber<T extends com.facebook.ads.redexgen.X.Td> */
    public final boolean A00(T event) {
        return true;
    }
}
