package com.instagram.common.viewpoint.core;

import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.le, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1959le implements InterfaceC0713Ed {
    public final int A00;

    public C1959le() {
        this(-1);
    }

    public C1959le(int i2) {
        this.A00 = i2;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0713Ed
    public final int A8R(int i2) {
        if (this.A00 == -1) {
            if (i2 == 7) {
                return 6;
            }
            return 3;
        }
        return this.A00;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0713Ed
    public final long A8m(C0712Ec c0712Ec) {
        IOException iOException = c0712Ec.A03;
        if ((iOException instanceof C04222i) || (iOException instanceof FileNotFoundException) || (iOException instanceof C05909h) || (iOException instanceof C0723En) || C04914z.A00(iOException)) {
            return -9223372036854775807L;
        }
        return Math.min((c0712Ec.A00 - 1) * 1000, 5000);
    }
}
