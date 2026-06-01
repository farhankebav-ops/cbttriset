package com.instagram.common.viewpoint.core;

import android.net.Uri;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.kR, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1897kR implements GX {
    public static byte[] A03;
    public static String[] A04 = {"IFBRawCVF0AWJOiiVagp2bzm1iWWQKSj", "auHMqC8YUXWsvqiTg7", "x05hwyQceYKgfv4KdHsaZDzMFYGIFABO", "EiWauAjA92n8uYBsDF1eTop4V9uY", "nHLlm8XHOjaWHtwU5p4BIc0GM3UweWlu", "dBwF9hq9j3gGLabp", "n4a5QuSOEmxq5i2DA2", "Zy0ftHIbrTR5qGqkd"};
    public static final InterfaceC0763Gb A05;
    public GY A00;
    public AbstractC0838Iz A01;
    public boolean A02;

    public static String A01(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i2, i2 + i8);
        int i10 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A04[3].length() == 20) {
                throw new RuntimeException();
            }
            A04[3] = "IEdap1c7a0gADNuxefg";
            if (i10 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 36);
            i10++;
        }
    }

    public static void A02() {
        A03 = new byte[]{96, 71, 79, 74, 67, 66, 6, 82, 73, 6, 66, 67, 82, 67, 84, 75, 79, 72, 67, 6, 68, 79, 82, 85, 82, 84, 67, 71, 75, 6, 82, 95, 86, 67};
    }

    static {
        A02();
        A05 = new InterfaceC0763Gb() { // from class: com.facebook.ads.redexgen.X.kS
            @Override // com.instagram.common.viewpoint.core.InterfaceC0763Gb
            public final GX[] A5F() {
                return C1897kR.A04();
            }

            @Override // com.instagram.common.viewpoint.core.InterfaceC0763Gb
            public final /* synthetic */ GX[] A5G(Uri uri, Map map) {
                return AbstractC0762Ga.A01(this, uri, map);
            }
        };
    }

    public static C4J A00(C4J c4j) {
        c4j.A0f(0);
        return c4j;
    }

    @EnsuresNonNullIf(expression = {"streamReader"}, result = true)
    private boolean A03(InterfaceC1943lN interfaceC1943lN) throws IOException {
        C0834Iv c0834Iv = new C0834Iv();
        if (!c0834Iv.A05(interfaceC1943lN, true) || (c0834Iv.A04 & 2) != 2) {
            return false;
        }
        int length = Math.min(c0834Iv.A00, 8);
        C4J c4j = new C4J(length);
        interfaceC1943lN.AG9(c4j.A0l(), 0, length);
        if (C1899kT.A01(A00(c4j))) {
            this.A01 = new C1899kT();
        } else if (C1894kO.A06(A00(c4j))) {
            this.A01 = new C1894kO();
        } else {
            if (!C1896kQ.A02(A00(c4j))) {
                return false;
            }
            this.A01 = new C1896kQ();
        }
        return true;
    }

    public static /* synthetic */ GX[] A04() {
        return new GX[]{new C1897kR()};
    }

    @Override // com.instagram.common.viewpoint.core.GX
    public final void AA4(GY gy) {
        this.A00 = gy;
    }

    @Override // com.instagram.common.viewpoint.core.GX
    public final int AGb(InterfaceC1943lN interfaceC1943lN, C0781Gt c0781Gt) throws IOException {
        C3M.A02(this.A00);
        if (this.A01 == null) {
            if (A03(interfaceC1943lN)) {
                interfaceC1943lN.AI1();
            } else {
                throw C04222i.A01(A01(0, 34, 2), null);
            }
        }
        boolean z2 = this.A02;
        if (A04[0].charAt(6) == 'U') {
            throw new RuntimeException();
        }
        A04[5] = "ISTJLhLpuA8o4P7J";
        if (!z2) {
            H1 h1AJh = this.A00.AJh(0, 1);
            this.A00.A6G();
            this.A01.A08(this.A00, h1AJh);
            this.A02 = true;
        }
        return this.A01.A04(interfaceC1943lN, c0781Gt);
    }

    @Override // com.instagram.common.viewpoint.core.GX
    public final void AGr() {
    }

    @Override // com.instagram.common.viewpoint.core.GX
    public final void AIM(long j, long j3) {
        if (this.A01 != null) {
            this.A01.A07(j, j3);
        }
    }

    @Override // com.instagram.common.viewpoint.core.GX
    public final boolean AJL(InterfaceC1943lN interfaceC1943lN) throws IOException {
        try {
            return A03(interfaceC1943lN);
        } catch (C04222i unused) {
            return false;
        }
    }
}
