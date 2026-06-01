package com.instagram.common.viewpoint.core;

import androidx.core.location.LocationRequestCompat;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7i, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC05527i extends AbstractC2075nX implements J7 {
    public long A00;
    public J7 A01;

    @Override // com.instagram.common.viewpoint.core.AbstractC2075nX
    public abstract void A0B();

    @Override // com.instagram.common.viewpoint.core.C5I
    public final void A0A() {
        super.A0A();
        this.A01 = null;
    }

    public final void A0C(long j, J7 j72, long j3) {
        super.A01 = j;
        this.A01 = j72;
        if (j3 == LocationRequestCompat.PASSIVE_INTERVAL) {
            j3 = super.A01;
        }
        this.A00 = j3;
    }

    @Override // com.instagram.common.viewpoint.core.J7
    public final List<C2105o2> A7P(long j) {
        return ((J7) C3M.A01(this.A01)).A7P(j - this.A00);
    }

    @Override // com.instagram.common.viewpoint.core.J7
    public final long A7v(int i2) {
        return ((J7) C3M.A01(this.A01)).A7v(i2) + this.A00;
    }

    @Override // com.instagram.common.viewpoint.core.J7
    public final int A7w() {
        return ((J7) C3M.A01(this.A01)).A7w();
    }

    @Override // com.instagram.common.viewpoint.core.J7
    public final int A8S(long j) {
        return ((J7) C3M.A01(this.A01)).A8S(j - this.A00);
    }
}
