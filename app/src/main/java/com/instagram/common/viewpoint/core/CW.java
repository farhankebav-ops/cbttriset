package com.instagram.common.viewpoint.core;

import android.os.Handler;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class CW {
    public final int A00;
    public final C2001mL A01;
    public final long A02;
    public final CopyOnWriteArrayList<CV> A03;

    public CW() {
        this(new CopyOnWriteArrayList(), 0, null, 0L);
    }

    public CW(CopyOnWriteArrayList<CV> copyOnWriteArrayList, int i2, C2001mL c2001mL, long j) {
        this.A03 = copyOnWriteArrayList;
        this.A00 = i2;
        this.A01 = c2001mL;
        this.A02 = j;
    }

    private long A00(long j) {
        long jA0P = AbstractC04664a.A0P(j);
        if (jA0P == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long mediaTimeMs = this.A02;
        return mediaTimeMs + jA0P;
    }

    @MetaExoPlayerCustomization(type = {"MERGED"}, value = "https://github.com/androidx/media/pull/1768")
    private final void A01(final CE ce, final CG cg, final int i2) {
        for (CV cv : this.A03) {
            final CX cx = cv.A01;
            AbstractC04664a.A1B(cv.A00, new Runnable() { // from class: com.facebook.ads.redexgen.X.CS
                @Override // java.lang.Runnable
                public final void run() {
                }
            });
        }
    }

    public final CW A02(int i2, C2001mL c2001mL, long j) {
        return new CW(this.A03, i2, c2001mL, j);
    }

    public final void A03(int i2, C2154or c2154or, int i8, Object obj, long j) {
        A0C(new CG(1, i2, c2154or, i8, obj, A00(j), -9223372036854775807L));
    }

    public final void A04(Handler handler, CX cx) {
        C3M.A01(handler);
        C3M.A01(cx);
        this.A03.add(new CV(handler, cx));
    }

    public final void A05(CE ce, int i2, int i8, C2154or c2154or, int i9, Object obj, long j, long j3) {
        A09(ce, new CG(i2, i8, c2154or, i9, obj, A00(j), A00(j3)));
    }

    @MetaExoPlayerCustomization(type = {"MERGED"}, value = "https://github.com/androidx/media/pull/1768")
    public final void A06(CE ce, int i2, int i8, C2154or c2154or, int i9, Object obj, long j, long j3, int i10) {
        A01(ce, new CG(i2, i8, c2154or, i9, obj, A00(j), A00(j3)), i10);
    }

    public final void A07(CE ce, int i2, int i8, C2154or c2154or, int i9, Object obj, long j, long j3, IOException iOException, boolean z2) {
        A0A(ce, new CG(i2, i8, c2154or, i9, obj, A00(j), A00(j3)), iOException, z2);
    }

    public final void A08(@MetaExoPlayerCustomization CE ce, @MetaExoPlayerCustomization int i2, int i8, C2154or c2154or, int i9, Object obj, long j, long j3, Object obj2, Object obj3) {
        A0B(ce, new CG(i2, i8, c2154or, i9, obj, A00(j), A00(j3)), obj2, obj3);
    }

    public final void A09(final CE ce, final CG cg) {
        for (CV cv : this.A03) {
            final CX listener = cv.A01;
            AbstractC04664a.A1B(cv.A00, new Runnable() { // from class: com.facebook.ads.redexgen.X.CT
                @Override // java.lang.Runnable
                public final void run() {
                    this.A02.A0E(listener, ce, cg);
                }
            });
        }
    }

    public final void A0A(final CE ce, final CG cg, final IOException iOException, final boolean z2) {
        for (CV cv : this.A03) {
            final CX cx = cv.A01;
            AbstractC04664a.A1B(cv.A00, new Runnable() { // from class: com.facebook.ads.redexgen.X.CO
                @Override // java.lang.Runnable
                public final void run() {
                    this.A02.A0F(cx, ce, cg, iOException, z2);
                }
            });
        }
    }

    public final void A0B(@MetaExoPlayerCustomization final CE ce, @MetaExoPlayerCustomization final CG cg, final Object obj, final Object obj2) {
        for (CV cv : this.A03) {
            final CX cx = cv.A01;
            AbstractC04664a.A1B(cv.A00, new Runnable() { // from class: com.facebook.ads.redexgen.X.CP
                @Override // java.lang.Runnable
                public final void run() {
                    this.A02.A0G(cx, ce, cg, obj, obj2);
                }
            });
        }
    }

    public final void A0C(final CG cg) {
        for (CV cv : this.A03) {
            final CX listener = cv.A01;
            AbstractC04664a.A1B(cv.A00, new Runnable() { // from class: com.facebook.ads.redexgen.X.CQ
                @Override // java.lang.Runnable
                public final void run() {
                    this.A01.A0H(listener, cg);
                }
            });
        }
    }

    public final void A0D(CX cx) {
        for (CV listenerAndHandler : this.A03) {
            if (listenerAndHandler.A01 == cx) {
                this.A03.remove(listenerAndHandler);
            }
        }
    }

    public final /* synthetic */ void A0E(CX cx, CE ce, CG cg) {
        cx.ADw(this.A00, this.A01, ce, cg);
    }

    public final /* synthetic */ void A0F(CX cx, CE ce, CG cg, IOException iOException, boolean z2) {
        cx.AE1(this.A00, this.A01, ce, cg, iOException, z2);
    }

    public final /* synthetic */ void A0G(CX cx, CE ce, CG cg, Object obj, Object obj2) {
        cx.ADy(this.A00, this.A01, ce, cg, obj, obj2);
    }

    public final /* synthetic */ void A0H(CX cx, CG cg) {
        cx.AD6(this.A00, this.A01, cg);
    }
}
