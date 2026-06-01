package com.instagram.common.viewpoint.core;

import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Nl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC0953Nl {

    @Nullable
    public static HandlerC0952Nk A00;
    public static final AtomicBoolean A01 = new AtomicBoolean();

    public static HandlerC0952Nk A00(C1451cu c1451cu) {
        if (A00 == null) {
            A00 = new HandlerC0952Nk(c1451cu);
        }
        return A00;
    }

    public static void A01(C1451cu c1451cu) {
        if (UA.A0F(c1451cu)) {
            A03(c1451cu);
        }
    }

    public static void A02(C1451cu c1451cu) {
        if (UA.A0E(c1451cu)) {
            A03(c1451cu);
        }
    }

    public static void A03(C1451cu c1451cu) {
        if (A01.compareAndSet(false, true)) {
            XJ.A01.execute(new C1687go(c1451cu));
        }
    }
}
