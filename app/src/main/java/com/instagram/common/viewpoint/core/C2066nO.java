package com.instagram.common.viewpoint.core;

import android.media.MediaFormat;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.nO, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2066nO implements FQ, InterfaceC0751Fp, AnonymousClass70 {
    public static byte[] A04;
    public static String[] A05 = {"s2pX1dUuV9yMGkOQMpNHWy9uhNawnk9Y", "g94kU4b", "NzGTwCFJguijRpsE4vnu2khyHl2vzHxI", "mcwg2", "3H7kdFWigyqN00XNlLPoaD6s2Om", "arwBjFb", "zwCIEju4cqvLZ8D4reT2LOc82uEYQHt6", "4voNbHG588W1rePZ0VIdJriIAfqG9T"};
    public FQ A00;
    public FQ A01;
    public InterfaceC0751Fp A02;
    public InterfaceC0751Fp A03;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 1);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{2, 0, 17, 51, 12, 1, 0, 10, 35, 23, 4, 8, 0, 40, 0, 17, 4, 1, 4, 17, 4, 41, 12, 22, 17, 0, 11, 0, 23};
    }

    static {
        A01();
    }

    public C2066nO() {
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass70
    public final void A9a(int i2, Object obj) {
        switch (i2) {
            case 7:
                this.A01 = (FQ) obj;
                return;
            case 8:
                this.A02 = (InterfaceC0751Fp) obj;
                return;
            case 10000:
                if (0 == 0) {
                    this.A00 = null;
                    this.A03 = null;
                    return;
                }
                throw new NullPointerException(A00(0, 29, 100));
            default:
                return;
        }
    }

    @Override // com.instagram.common.viewpoint.core.FQ
    public final void AFi(long j, long j3, C2154or c2154or, MediaFormat mediaFormat) {
        if (this.A00 != null) {
            FQ fq = this.A00;
            if (A05[0].charAt(20) != 'W') {
                throw new RuntimeException();
            }
            A05[4] = "rCzQpO90p93bI0FQ7tWj9IORt31";
            fq.AFi(j, j3, c2154or, mediaFormat);
        }
        if (this.A01 != null) {
            this.A01.AFi(j, j3, c2154or, mediaFormat);
        }
    }
}
