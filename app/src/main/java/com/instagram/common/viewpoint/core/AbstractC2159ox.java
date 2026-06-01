package com.instagram.common.viewpoint.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ox, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC2159ox implements InterfaceC04392z {
    public final C2123oL A00 = new C2123oL();

    @MetaExoPlayerCustomization("Should be final")
    public abstract void A0H(int i2, long j);

    public final int A00() {
        long jA6z = A6z();
        long jA7k = A7k();
        if (jA6z == -9223372036854775807L || jA7k == -9223372036854775807L) {
            return 0;
        }
        if (jA7k == 0) {
            return 100;
        }
        return AbstractC04664a.A07((int) ((100 * jA6z) / jA7k), 0, 100);
    }

    public void A01() {
        AJV(false);
    }

    public final void A02() {
        A03(A7Z());
    }

    public final void A03(int i2) {
        A0H(i2, -9223372036854775807L);
    }

    public final void A04(long j) {
        A0H(A7Z(), j);
    }
}
