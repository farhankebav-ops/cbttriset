package com.instagram.common.viewpoint.core;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1865jv implements GX {
    public static byte[] A0C;
    public static String[] A0D = {"Jp9jYTsvX0byW8PsTh8WCsi4kS5THTDZ", "u9JmQf2RUpXkbwKGcH1ldYLO1OaAnoG0", "zVRI5h7vLNN08I5W1BFePAuDidXDjkLB", "GupX0AjjIH906l5opBlPCY0Mrv7mkKOY", "YLyM9aD6SKjNKerJ1EloHyT", "oAaNr5RuznTKLecZmpLN", "Q5WjYzMQ2NaCiwYPtyRn68zXUmvTXGHf", "bi8dQH0GL9bk2fQxVP7KQMQdOg6RbrhP"};
    public static final InterfaceC0763Gb A0E;
    public int A00;
    public long A01;
    public long A02;
    public GY A03;
    public boolean A04;
    public boolean A05;
    public boolean A06;
    public final int A07;
    public final C4I A08;
    public final C4J A09;
    public final C4J A0A;
    public final C1864ju A0B;

    public static String A03(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0C, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 50);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A0C = new byte[]{39, 11, 6, 12, 5, 24, 7, 15, 14, 74, 43, 46, 62, 57, 74, 25, 30, 24, 15, 11, 7};
    }

    static {
        A04();
        A0E = new InterfaceC0763Gb() { // from class: com.facebook.ads.redexgen.X.jw
            @Override // com.instagram.common.viewpoint.core.InterfaceC0763Gb
            public final GX[] A5F() {
                return C1865jv.A07();
            }

            @Override // com.instagram.common.viewpoint.core.InterfaceC0763Gb
            public final /* synthetic */ GX[] A5G(Uri uri, Map map) {
                return AbstractC0762Ga.A01(this, uri, map);
            }
        };
    }

    public C1865jv() {
        this(0);
    }

    public C1865jv(int i2) {
        this.A07 = (i2 & 2) != 0 ? i2 | 1 : i2;
        this.A0B = new C1864ju(true);
        this.A09 = new C4J(2048);
        this.A00 = -1;
        this.A01 = -1L;
        this.A0A = new C4J(10);
        this.A08 = new C4I(this.A0A.A0l());
    }

    public static int A00(int i2, long j) {
        return (int) (((((long) i2) * 8) * 1000000) / j);
    }

    private int A01(InterfaceC1943lN interfaceC1943lN) throws IOException {
        int i2 = 0;
        while (true) {
            interfaceC1943lN.AG9(this.A0A.A0l(), 0, 10);
            this.A0A.A0f(0);
            if (this.A0A.A0K() != 4801587) {
                break;
            }
            this.A0A.A0g(3);
            int length = this.A0A.A0H();
            int firstFramePosition = length + 10;
            i2 += firstFramePosition;
            interfaceC1943lN.A3z(length);
        }
        interfaceC1943lN.AI1();
        interfaceC1943lN.A3z(i2);
        if (this.A01 == -1) {
            this.A01 = i2;
        }
        return i2;
    }

    private C1947lS A02(long j, boolean z2) {
        return new C1947lS(j, this.A01, A00(this.A00, this.A0B.A0J()), this.A00, z2);
    }

    @RequiresNonNull({"extractorOutput"})
    private void A05(long j, boolean z2) {
        if (this.A05) {
            return;
        }
        boolean z7 = (this.A07 & 1) != 0 && this.A00 > 0;
        String[] strArr = A0D;
        if (strArr[2].charAt(14) != strArr[3].charAt(14)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0D;
        strArr2[0] = "wRCLGMQDqXZHrYOEljE7cvu367IJP6qz";
        strArr2[1] = "FofxBB8LpAk5nYyyotl0uMBanfu6Lq1A";
        if (z7 && this.A0B.A0J() == -9223372036854775807L && !z2) {
            return;
        }
        if (!z7 || this.A0B.A0J() == -9223372036854775807L) {
            this.A03.AIN(new C1938lI(-9223372036854775807L));
        } else {
            this.A03.AIN(A02(j, (this.A07 & 2) != 0));
        }
        this.A05 = true;
    }

    private void A06(InterfaceC1943lN interfaceC1943lN) throws IOException {
        if (this.A04) {
            return;
        }
        this.A00 = -1;
        interfaceC1943lN.AI1();
        if (interfaceC1943lN.A8f() == 0) {
            A01(interfaceC1943lN);
        }
        int currentFrameSize = 0;
        long j = 0;
        while (true) {
            try {
                if (!interfaceC1943lN.AGA(this.A0A.A0l(), 0, 2, true)) {
                    break;
                }
                this.A0A.A0f(0);
                if (C1864ju.A0F(this.A0A.A0M())) {
                    if (!interfaceC1943lN.AGA(this.A0A.A0l(), 0, 4, true)) {
                        break;
                    }
                    this.A08.A08(14);
                    int iA04 = this.A08.A04(13);
                    int numValidFrames = A0D[7].charAt(7);
                    if (numValidFrames != 114) {
                        A0D[4] = "EiGF";
                        if (iA04 > 6) {
                            j += (long) iA04;
                            currentFrameSize++;
                            if (currentFrameSize == 1000 || !interfaceC1943lN.A40(iA04 - 6, true)) {
                                break;
                            }
                        } else {
                            this.A04 = true;
                            throw C04222i.A01(A03(0, 21, 88), null);
                        }
                    } else {
                        throw new RuntimeException();
                    }
                } else {
                    currentFrameSize = 0;
                    break;
                }
            } catch (EOFException unused) {
            }
        }
        interfaceC1943lN.AI1();
        if (currentFrameSize > 0) {
            this.A00 = (int) (j / ((long) currentFrameSize));
        } else {
            this.A00 = -1;
        }
        this.A04 = true;
    }

    public static /* synthetic */ GX[] A07() {
        return new GX[]{new C1865jv()};
    }

    @Override // com.instagram.common.viewpoint.core.GX
    public final void AA4(GY gy) {
        this.A03 = gy;
        this.A0B.A5U(gy, new C0869Ke(0, 1));
        gy.A6G();
    }

    @Override // com.instagram.common.viewpoint.core.GX
    public final int AGb(InterfaceC1943lN interfaceC1943lN, C0781Gt c0781Gt) throws IOException {
        C3M.A02(this.A03);
        long jA8G = interfaceC1943lN.A8G();
        if (((this.A07 & 2) == 0 && ((this.A07 & 1) == 0 || jA8G == -1)) ? false : true) {
            A06(interfaceC1943lN);
        }
        int bytesRead = interfaceC1943lN.read(this.A09.A0l(), 0, 2048);
        boolean z2 = bytesRead == -1;
        A05(jA8G, z2);
        if (z2) {
            return -1;
        }
        this.A09.A0f(0);
        this.A09.A0e(bytesRead);
        if (!this.A06) {
            this.A0B.AG6(this.A02, 4);
            this.A06 = true;
        }
        this.A0B.A52(this.A09);
        return 0;
    }

    @Override // com.instagram.common.viewpoint.core.GX
    public final void AGr() {
    }

    @Override // com.instagram.common.viewpoint.core.GX
    public final void AIM(long j, long j3) {
        this.A06 = false;
        this.A0B.AIL();
        this.A02 = j3;
    }

    @Override // com.instagram.common.viewpoint.core.GX
    public final boolean AJL(InterfaceC1943lN interfaceC1943lN) throws IOException {
        int headerPosition;
        int iA01 = A01(interfaceC1943lN);
        int i2 = iA01;
        int frameSize = 0;
        int syncBytes = 0;
        do {
            interfaceC1943lN.AG9(this.A0A.A0l(), 0, 2);
            this.A0A.A0f(0);
            int startPosition = this.A0A.A0M();
            if (!C1864ju.A0F(startPosition)) {
                syncBytes = 0;
                frameSize = 0;
                i2++;
                interfaceC1943lN.AI1();
                interfaceC1943lN.A3z(i2);
            } else {
                syncBytes++;
                String[] strArr = A0D;
                String str = strArr[2];
                String str2 = strArr[3];
                int headerPosition2 = str.charAt(14);
                int startPosition2 = str2.charAt(14);
                if (headerPosition2 != startPosition2) {
                    throw new RuntimeException();
                }
                A0D[7] = "vlF0iwwjiK26GT4HTqGcAOiXXpcsHbpg";
                if (syncBytes >= 4 && frameSize > 188) {
                    return true;
                }
                interfaceC1943lN.AG9(this.A0A.A0l(), 0, 4);
                this.A08.A08(14);
                C4I c4i = this.A08;
                int headerPosition3 = A0D[5].length();
                if (headerPosition3 == 4) {
                    throw new RuntimeException();
                }
                A0D[4] = "LrBCAcAc8FKB1NeW";
                int headerPosition4 = c4i.A04(13);
                if (headerPosition4 <= 6) {
                    syncBytes = 0;
                    frameSize = 0;
                    i2++;
                    interfaceC1943lN.AI1();
                    interfaceC1943lN.A3z(i2);
                } else {
                    int startPosition3 = headerPosition4 - 6;
                    interfaceC1943lN.A3z(startPosition3);
                    frameSize += headerPosition4;
                }
            }
            headerPosition = i2 - iA01;
        } while (headerPosition < 8192);
        return false;
    }
}
