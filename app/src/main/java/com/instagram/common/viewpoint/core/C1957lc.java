package com.instagram.common.viewpoint.core;

import android.os.Looper;
import android.os.SystemClock;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1957lc {
    public static byte[] A03;
    public static String[] A04 = {"unLJAGqnT9K2C6pR52hzklfZHwTRg6Yr", "LeSEUls9Myr0akOYyr4ALINYOEymKOkL", "W8GYPv6JCblyMHrg4mb8qhrlE9HlP5p8", "LeDDfwbzgRXTDhaT1cwFWvWAB6ITTWPz", "taf7WKL89SeyG6P6BerDozU5lBYArJ2v", "", "BSTJObkWS6NqTAYjIRk7bCGrxc9Lgut2", "ohz3nwuOVveogY5495fLWWA936p3Bkwf"};
    public static final C0717Eh A05;
    public static final C0717Eh A06;
    public static final C0717Eh A07;
    public static final C0717Eh A08;
    public HandlerC0718Ei<? extends InterfaceC0719Ej> A00;
    public IOException A01;
    public final InterfaceExecutorC0735Ez A02;

    public static String A06(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 59);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A03 = new byte[]{62, 3, 20, 43, 23, 26, 2, 30, 9, 65, 55, 20, 26, 31, 30, 9, 65};
    }

    static {
        A07();
        A07 = A01(false, -9223372036854775807L);
        A08 = A01(true, -9223372036854775807L);
        A05 = new C0717Eh(2, -9223372036854775807L);
        A06 = new C0717Eh(3, -9223372036854775807L);
    }

    @MetaExoPlayerCustomization(type = {"MERGED"})
    public C1957lc(InterfaceExecutorC0735Ez interfaceExecutorC0735Ez) {
        this.A02 = interfaceExecutorC0735Ez;
    }

    @MetaExoPlayerCustomization(type = {"MERGED"})
    public C1957lc(String str) {
        this(AbstractC0734Ey.A00(AbstractC04664a.A0u(A06(0, 17, 64) + str), new C3X() { // from class: com.facebook.ads.redexgen.X.ld
            @Override // com.instagram.common.viewpoint.core.C3X
            public final void A31(Object obj) {
                ((ExecutorService) obj).shutdown();
            }
        }));
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Eg != com.facebook.ads.androidx.media3.exoplayer.upstream.Loader$Callback<T extends com.facebook.ads.redexgen.X.Ej> */
    @MetaExoPlayerCustomization("D14742363 Needed to accept supplied looper for Exo2DashLiveManifestFetcher manifest loading")
    private final <T extends InterfaceC0719Ej> long A00(Looper looper, T t3, InterfaceC0716Eg<T> interfaceC0716Eg, int i2) {
        C3M.A08(looper != null);
        this.A01 = null;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        new HandlerC0718Ei(this, looper, t3, interfaceC0716Eg, i2, jElapsedRealtime).A06(0L);
        return jElapsedRealtime;
    }

    public static C0717Eh A01(boolean z2, long j) {
        return new C0717Eh(z2 ? 1 : 0, j);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Eg != com.facebook.ads.androidx.media3.exoplayer.upstream.Loader$Callback<T extends com.facebook.ads.redexgen.X.Ej> */
    public final <T extends InterfaceC0719Ej> long A08(T t3, InterfaceC0716Eg<T> interfaceC0716Eg, int i2) {
        Looper looper = (Looper) C3M.A02(Looper.myLooper());
        return A00(looper, t3, interfaceC0716Eg, i2);
    }

    public final void A09() {
        ((HandlerC0718Ei) C3M.A02(this.A00)).A07(false);
    }

    public final void A0A() {
        this.A01 = null;
    }

    public final void A0B(int i2) throws IOException {
        if (this.A01 == null) {
            if (this.A00 != null) {
                HandlerC0718Ei<? extends InterfaceC0719Ej> handlerC0718Ei = this.A00;
                if (i2 == Integer.MIN_VALUE) {
                    HandlerC0718Ei<? extends InterfaceC0719Ej> handlerC0718Ei2 = this.A00;
                    String[] strArr = A04;
                    if (strArr[6].charAt(7) == strArr[1].charAt(7)) {
                        throw new RuntimeException();
                    }
                    A04[2] = "wo2YdO45DQEJfRTdGKzxAcazBLTDj4mX";
                    i2 = handlerC0718Ei2.A07;
                }
                handlerC0718Ei.A05(i2);
                return;
            }
            return;
        }
        throw this.A01;
    }

    public final void A0C(InterfaceC0720Ek interfaceC0720Ek) {
        if (this.A00 != null) {
            HandlerC0718Ei<? extends InterfaceC0719Ej> handlerC0718Ei = this.A00;
            String[] strArr = A04;
            if (strArr[5].length() == strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A04;
            strArr2[4] = "XVuhTdSnDMDRP6HltjyP328n9S8al0u6";
            strArr2[0] = "1piWh3nqPhJ4K6qVEs9qRP5dHkNT6n7u";
            handlerC0718Ei.A07(true);
        }
        if (interfaceC0720Ek != null) {
            this.A02.execute(new RunnableC0721El(interfaceC0720Ek));
        }
        this.A02.AGr();
    }

    public final boolean A0D() {
        return this.A01 != null;
    }

    public final boolean A0E() {
        return this.A00 != null;
    }
}
