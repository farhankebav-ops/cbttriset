package com.instagram.common.viewpoint.core;

import android.os.Handler;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8C, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C8C {
    public final Handler A00;
    public final C8D A01;

    public C8C(Handler handler, C8D c8d) {
        this.A00 = c8d != null ? (Handler) C3M.A01(handler) : null;
        this.A01 = c8d;
    }

    @MetaExoPlayerCustomization(type = {"NEW_METHOD"}, value = "New API")
    public final void A00(final int i2) {
        if (this.A00 != null) {
            this.A00.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.7y
                @Override // java.lang.Runnable
                public final void run() {
                }
            });
        }
    }

    public final void A01(final int i2, final long j, final long j3) {
        if (this.A00 != null) {
            this.A00.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.82
                @Override // java.lang.Runnable
                public final void run() {
                    this.A03.A02(i2, j, j3);
                }
            });
        }
    }

    public final /* synthetic */ void A02(int i2, long j, long j3) {
        ((C8D) AbstractC04664a.A0f(this.A01)).ACY(i2, j, j3);
    }

    public final void A03(final long j) {
        if (this.A00 != null) {
            this.A00.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.83
                @Override // java.lang.Runnable
                public final void run() {
                    this.A01.A04(j);
                }
            });
        }
    }

    public final /* synthetic */ void A04(long j) {
        ((C8D) AbstractC04664a.A0f(this.A01)).ACU(j);
    }

    public final void A05(final C2154or c2154or, final C05015j c05015j) {
        if (this.A00 != null) {
            this.A00.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.87
                @Override // java.lang.Runnable
                public final void run() {
                    this.A02.A06(c2154or, c05015j);
                }
            });
        }
    }

    public final /* synthetic */ void A06(C2154or c2154or, C05015j c05015j) {
        ((C8D) AbstractC04664a.A0f(this.A01)).ACS(c2154or);
        ((C8D) AbstractC04664a.A0f(this.A01)).ACT(c2154or, c05015j);
    }

    public final void A07(final C04985g c04985g) {
        c04985g.A02();
        if (this.A00 != null) {
            this.A00.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.85
                @Override // java.lang.Runnable
                public final void run() {
                    this.A01.A09(c04985g);
                }
            });
        }
    }

    public final void A08(final C04985g c04985g) {
        if (this.A00 != null) {
            this.A00.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.8B
                @Override // java.lang.Runnable
                public final void run() {
                    this.A01.A0A(c04985g);
                }
            });
        }
    }

    public final /* synthetic */ void A09(C04985g c04985g) {
        c04985g.A02();
        ((C8D) AbstractC04664a.A0f(this.A01)).ACQ(c04985g);
    }

    public final /* synthetic */ void A0A(C04985g c04985g) {
        ((C8D) AbstractC04664a.A0f(this.A01)).ACR(c04985g);
    }

    public final void A0B(final C8F c8f) {
        if (this.A00 != null) {
            this.A00.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.81
                @Override // java.lang.Runnable
                public final void run() {
                }
            });
        }
    }

    public final void A0C(final C8F c8f) {
        if (this.A00 != null) {
            this.A00.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.7x
                @Override // java.lang.Runnable
                public final void run() {
                }
            });
        }
    }

    public final void A0D(final Exception exc) {
        if (this.A00 != null) {
            this.A00.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.84
                @Override // java.lang.Runnable
                public final void run() {
                    this.A00.A0E(exc);
                }
            });
        }
    }

    public final /* synthetic */ void A0E(Exception exc) {
        ((C8D) AbstractC04664a.A0f(this.A01)).ACV(exc);
    }

    @MetaExoPlayerCustomization(type = {"NEW_METHOD"}, value = "New API")
    public final void A0F(final String str) {
        if (this.A00 != null) {
            this.A00.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.88
                @Override // java.lang.Runnable
                public final void run() {
                }
            });
        }
    }

    public final void A0G(final String str, final long j, final long j3) {
        if (this.A00 != null) {
            this.A00.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.7w
                @Override // java.lang.Runnable
                public final void run() {
                    this.A02.A0H(str, j, j3);
                }
            });
        }
    }

    public final /* synthetic */ void A0H(String str, long j, long j3) {
        ((C8D) AbstractC04664a.A0f(this.A01)).ACP(str, j, j3);
    }

    public final void A0I(final boolean z2) {
        if (this.A00 != null) {
            this.A00.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.80
                @Override // java.lang.Runnable
                public final void run() {
                    this.A00.A0J(z2);
                }
            });
        }
    }

    public final /* synthetic */ void A0J(boolean z2) {
        ((C8D) AbstractC04664a.A0f(this.A01)).AFF(z2);
    }

    @MetaExoPlayerCustomization(type = {"NEW_METHOD"}, value = "New API")
    public final void A0K(final byte[] bArr, final long j) {
        if (this.A00 != null) {
            this.A00.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.89
                @Override // java.lang.Runnable
                public final void run() {
                }
            });
        }
    }
}
