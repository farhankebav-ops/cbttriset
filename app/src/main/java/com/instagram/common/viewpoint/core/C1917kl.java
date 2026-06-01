package com.instagram.common.viewpoint.core;

import android.net.Uri;
import com.facebook.ads.androidx.media3.common.Metadata;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.Id3Frame;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.MlltFrame;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.TextInformationFrame;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.kl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
@MetaExoPlayerCustomization("DoNotStrip")
public final class C1917kl implements GX {
    public static byte[] A0K;
    public static String[] A0L = {"", "XN01ItT2bHY64Udo8U0rv5VGSzBxMc17", "LZob5GHcOm1BKJQ2vQEKg44UBdoAB", "Ux8BYUlKxCzUFwXHW791pvzO", "", "EYpHAHesBPuZwNRi93BVygfvwpQNuwRz", "BndnCdJGei78P0VEYjqxuWcWalVGolEJ", "FxTwI"};
    public static final InterfaceC0763Gb A0M;
    public static final InterfaceC0790Hc A0N;
    public int A00;
    public int A01;
    public long A02;
    public long A03;
    public long A04;
    public long A05;
    public Metadata A06;
    public GY A07;
    public H1 A08;
    public H1 A09;
    public InterfaceC1916kk A0A;
    public boolean A0B;
    public boolean A0C;
    public final int A0D;
    public final long A0E;
    public final C4J A0F;
    public final C0770Gi A0G;
    public final C0772Gk A0H;
    public final C0773Gl A0I;
    public final H1 A0J;

    public static String A09(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0K, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 44);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0B() {
        A0K = new byte[]{-78, -60, -64, -47, -62, -57, -60, -61, 127, -45, -50, -50, 127, -52, -64, -51, -40, 127, -63, -40, -45, -60, -46, -115, -27, -35, -42, -33};
        if (A0L[5].charAt(24) == 'i') {
            throw new RuntimeException();
        }
        String[] strArr = A0L;
        strArr[1] = "rBULd6kp2sYKxjbrN7jKkVDhSodb4v28";
        strArr[6] = "gBWiztBtWh7JHxCzKYVaG6CraVXBuCHm";
    }

    static {
        A0B();
        A0M = new InterfaceC0763Gb() { // from class: com.facebook.ads.redexgen.X.kn
            @Override // com.instagram.common.viewpoint.core.InterfaceC0763Gb
            public final GX[] A5F() {
                return C1917kl.A0G();
            }

            @Override // com.instagram.common.viewpoint.core.InterfaceC0763Gb
            public final /* synthetic */ GX[] A5G(Uri uri, Map map) {
                return AbstractC0762Ga.A01(this, uri, map);
            }
        };
        A0N = new InterfaceC0790Hc() { // from class: com.facebook.ads.redexgen.X.km
            @Override // com.instagram.common.viewpoint.core.InterfaceC0790Hc
            public final boolean A6I(int i2, int i8, int i9, int i10, int i11) {
                return C1917kl.A0C(i2, i8, i9, i10, i11);
            }
        };
    }

    @MetaExoPlayerCustomization("DoNotStrip")
    public C1917kl() {
        this(0);
    }

    @MetaExoPlayerCustomization("DoNotStrip")
    public C1917kl(int i2) {
        this(i2, -9223372036854775807L);
    }

    @MetaExoPlayerCustomization("DoNotStrip")
    public C1917kl(int i2, long j) {
        this.A0D = (i2 & 2) != 0 ? i2 | 1 : i2;
        this.A0E = j;
        this.A0F = new C4J(10);
        this.A0I = new C0773Gl();
        this.A0G = new C0770Gi();
        this.A02 = -9223372036854775807L;
        this.A0H = new C0772Gk();
        this.A0J = new C1944lO();
        this.A08 = this.A0J;
    }

    public static int A00(C4J c4j, int i2) {
        if (c4j.A0A() >= i2 + 4) {
            c4j.A0f(i2);
            if (A0L[5].charAt(24) == 'i') {
                throw new RuntimeException();
            }
            A0L[3] = "hnNDf1WGfP5HptxyzX0WY3yEy4CiO";
            int iA0C = c4j.A0C();
            if (iA0C == 1483304551 || iA0C == 1231971951) {
                return iA0C;
            }
        }
        if (c4j.A0A() >= 40) {
            c4j.A0f(36);
            return c4j.A0C() == 1447187017 ? 1447187017 : 0;
        }
        return 0;
    }

    @RequiresNonNull({"extractorOutput", "realTrackOutput"})
    private int A01(InterfaceC1943lN interfaceC1943lN) throws IOException {
        if (this.A01 == 0) {
            try {
                A0F(interfaceC1943lN, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.A0A == null) {
            this.A0A = A07(interfaceC1943lN);
            this.A07.AIN(this.A0A);
            this.A08.A6W(new C2D().A11(this.A0I.A06).A0h(4096).A0b(this.A0I.A01).A0m(this.A0I.A03).A0d(this.A0G.A00).A0e(this.A0G.A01).A0v((this.A0D & 8) != 0 ? null : this.A06).A14());
            this.A03 = interfaceC1943lN.A8f();
        } else if (this.A03 != 0) {
            long jA8f = interfaceC1943lN.A8f();
            if (jA8f < this.A03) {
                interfaceC1943lN.AJJ((int) (this.A03 - jA8f));
            }
        }
        return A02(interfaceC1943lN);
    }

    @RequiresNonNull({"realTrackOutput", "seeker"})
    private int A02(InterfaceC1943lN interfaceC1943lN) throws IOException {
        if (this.A00 == 0) {
            interfaceC1943lN.AI1();
            if (A0E(interfaceC1943lN)) {
                return -1;
            }
            this.A0F.A0f(0);
            int iA0C = this.A0F.A0C();
            int sampleHeaderData = this.A01;
            if (A0D(iA0C, sampleHeaderData)) {
                int sampleHeaderData2 = AbstractC0774Gm.A00(iA0C);
                if (sampleHeaderData2 != -1) {
                    this.A0I.A00(iA0C);
                    if (this.A02 == -9223372036854775807L) {
                        this.A02 = this.A0A.A99(interfaceC1943lN.A8f());
                        if (this.A0E != -9223372036854775807L) {
                            this.A02 += this.A0E - this.A0A.A99(0L);
                        }
                    }
                    int sampleHeaderData3 = this.A0I.A02;
                    this.A00 = sampleHeaderData3;
                    if (this.A0A instanceof C05637t) {
                        C05637t c05637t = (C05637t) this.A0A;
                        long j = this.A04;
                        int sampleHeaderData4 = this.A0I.A04;
                        long jA03 = A03(j + ((long) sampleHeaderData4));
                        long jA8f = interfaceC1943lN.A8f();
                        int sampleHeaderData5 = this.A0I.A02;
                        c05637t.A01(jA03, jA8f + ((long) sampleHeaderData5));
                        if (this.A0C && c05637t.A02(this.A05)) {
                            this.A0C = false;
                            this.A08 = this.A09;
                        }
                    }
                }
            }
            interfaceC1943lN.AJJ(1);
            this.A01 = 0;
            return 0;
        }
        int iAI5 = this.A08.AI5(interfaceC1943lN, this.A00, true);
        if (iAI5 == -1) {
            return -1;
        }
        int bytesAppended = this.A00;
        this.A00 = bytesAppended - iAI5;
        int bytesAppended2 = this.A00;
        if (bytesAppended2 > 0) {
            return 0;
        }
        this.A08.AIA(A03(this.A04), 1, this.A0I.A02, 0, null);
        if (A0L[5].charAt(24) == 'i') {
            throw new RuntimeException();
        }
        A0L[3] = "39D9RtME66Nzc4lHdRGQvnw";
        long j3 = this.A04;
        int bytesAppended3 = this.A0I.A04;
        this.A04 = j3 + ((long) bytesAppended3);
        this.A00 = 0;
        return 0;
    }

    private long A03(long j) {
        return this.A02 + ((1000000 * j) / ((long) this.A0I.A03));
    }

    public static long A04(Metadata metadata) {
        if (metadata != null) {
            int iA02 = metadata.A02();
            for (int i2 = 0; i2 < iA02; i2++) {
                Metadata.Entry entryA03 = metadata.A03(i2);
                if ((entryA03 instanceof TextInformationFrame) && ((Id3Frame) ((TextInformationFrame) entryA03)).A00.equals(A09(24, 4, 101))) {
                    return AbstractC04664a.A0O(Long.parseLong(((TextInformationFrame) entryA03).A02.get(0)));
                }
            }
            return -9223372036854775807L;
        }
        return -9223372036854775807L;
    }

    private C05647u A05(InterfaceC1943lN interfaceC1943lN, boolean z2) throws IOException {
        interfaceC1943lN.AG9(this.A0F.A0l(), 0, 4);
        this.A0F.A0f(0);
        this.A0I.A00(this.A0F.A0C());
        return new C05647u(interfaceC1943lN.A8G(), interfaceC1943lN.A8f(), this.A0I, z2);
    }

    public static C05627s A06(Metadata metadata, long j) {
        if (metadata != null) {
            int iA02 = metadata.A02();
            for (int i2 = 0; i2 < iA02; i2++) {
                Metadata.Entry entry = metadata.A03(i2);
                if (entry instanceof MlltFrame) {
                    return C05627s.A01(j, (MlltFrame) entry, A04(metadata));
                }
            }
            return null;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.instagram.common.viewpoint.core.InterfaceC1916kk A07(com.instagram.common.viewpoint.core.InterfaceC1943lN r13) throws java.io.IOException {
        /*
            r12 = this;
            r3 = r12
            com.facebook.ads.redexgen.X.kk r4 = r12.A08(r13)
            com.facebook.ads.androidx.media3.common.Metadata r2 = r3.A06
            long r0 = r13.A8f()
            com.facebook.ads.redexgen.X.7s r1 = A06(r2, r0)
            boolean r0 = r3.A0B
            if (r0 == 0) goto L19
            com.facebook.ads.redexgen.X.7r r0 = new com.facebook.ads.redexgen.X.7r
            r0.<init>()
            return r0
        L19:
            r5 = 0
            int r0 = r3.A0D
            r0 = r0 & 4
            if (r0 == 0) goto La9
            r10 = -1
            if (r1 == 0) goto L97
            long r6 = r1.A7l()
            long r10 = r1.A7b()
        L2c:
            com.facebook.ads.redexgen.X.7t r5 = new com.facebook.ads.redexgen.X.7t
            long r8 = r13.A8f()
            r5.<init>(r6, r8, r10)
        L35:
            r4 = 1
            java.lang.String[] r2 = com.instagram.common.viewpoint.core.C1917kl.A0L
            r0 = 1
            r1 = r2[r0]
            r0 = 6
            r2 = r2[r0]
            r0 = 10
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto Lb1
            java.lang.String[] r2 = com.instagram.common.viewpoint.core.C1917kl.A0L
            java.lang.String r1 = "puIT5"
            r0 = 7
            r2[r0] = r1
            java.lang.String r1 = ""
            r0 = 4
            r2[r0] = r1
            if (r5 == 0) goto L63
            boolean r0 = r5.AAa()
            if (r0 != 0) goto L88
            int r0 = r3.A0D
            r0 = r0 & r4
            if (r0 == 0) goto L88
        L63:
            int r5 = r3.A0D
            java.lang.String[] r1 = com.instagram.common.viewpoint.core.C1917kl.A0L
            r0 = 5
            r1 = r1[r0]
            r0 = 24
            char r1 = r1.charAt(r0)
            r0 = 105(0x69, float:1.47E-43)
            if (r1 == r0) goto L89
            java.lang.String[] r2 = com.instagram.common.viewpoint.core.C1917kl.A0L
            java.lang.String r1 = "yAfIM"
            r0 = 7
            r2[r0] = r1
            java.lang.String r1 = ""
            r0 = 4
            r2[r0] = r1
            r0 = r5 & 2
            if (r0 == 0) goto L95
        L84:
            com.facebook.ads.redexgen.X.7u r5 = r3.A05(r13, r4)
        L88:
            return r5
        L89:
            java.lang.String[] r2 = com.instagram.common.viewpoint.core.C1917kl.A0L
            java.lang.String r1 = "MGo95V6JQFDSGlQkmGWT48KfEqhrmySi"
            r0 = 5
            r2[r0] = r1
            r0 = r5 & 2
            if (r0 == 0) goto L95
            goto L84
        L95:
            r4 = 0
            goto L84
        L97:
            if (r4 == 0) goto La2
            long r6 = r4.A7l()
            long r10 = r4.A7b()
            goto L2c
        La2:
            com.facebook.ads.androidx.media3.common.Metadata r0 = r3.A06
            long r6 = A04(r0)
            goto L2c
        La9:
            if (r1 == 0) goto Lad
            r5 = r1
            goto L35
        Lad:
            if (r4 == 0) goto L35
            r5 = r4
            goto L35
        Lb1:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C1917kl.A07(com.facebook.ads.redexgen.X.lN):com.facebook.ads.redexgen.X.kk");
    }

    private InterfaceC1916kk A08(InterfaceC1943lN interfaceC1943lN) throws IOException {
        C4J c4j = new C4J(this.A0I.A02);
        interfaceC1943lN.AG9(c4j.A0l(), 0, this.A0I.A02);
        int i2 = 21;
        if ((this.A0I.A05 & 1) != 0) {
            if (this.A0I.A01 != 1) {
                i2 = 36;
            }
        } else if (this.A0I.A01 == 1) {
            i2 = 13;
        }
        int iA00 = A00(c4j, i2);
        if (iA00 == 1483304551 || iA00 == 1231971951) {
            C05577n c05577nA01 = C05577n.A01(interfaceC1943lN.A8G(), interfaceC1943lN.A8f(), this.A0I, c4j);
            if (c05577nA01 != null && !this.A0G.A03()) {
                interfaceC1943lN.AI1();
                interfaceC1943lN.A3z(i2 + 141);
                C4J frame = this.A0F;
                interfaceC1943lN.AG9(frame.A0l(), 0, 3);
                C4J frame2 = this.A0F;
                frame2.A0f(0);
                C0770Gi c0770Gi = this.A0G;
                C4J frame3 = this.A0F;
                c0770Gi.A04(frame3.A0K());
            }
            interfaceC1943lN.AJJ(this.A0I.A02);
            if (c05577nA01 != null && !c05577nA01.AAa() && iA00 == 1231971951) {
                C05647u c05647uA05 = A05(interfaceC1943lN, false);
                String[] strArr = A0L;
                String str = strArr[7];
                String str2 = strArr[4];
                int xingBase = str.length();
                if (xingBase == str2.length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0L;
                strArr2[1] = "bGvlWKvJjPQrySHefRGmEijHbVzYOxUK";
                strArr2[6] = "fU58RXvZc6f3KsNNOCISAUQgLzoCeDCK";
                return c05647uA05;
            }
            return c05577nA01;
        }
        if (iA00 == 1447187017) {
            C05607q c05607qA00 = C05607q.A00(interfaceC1943lN.A8G(), interfaceC1943lN.A8f(), this.A0I, c4j);
            interfaceC1943lN.AJJ(this.A0I.A02);
            return c05607qA00;
        }
        interfaceC1943lN.AI1();
        return null;
    }

    @EnsuresNonNull({"extractorOutput", "realTrackOutput"})
    private void A0A() {
        C3M.A02(this.A09);
    }

    public static /* synthetic */ boolean A0C(int i2, int i8, int i9, int i10, int i11) {
        if (i8 != 67 || i9 != 79 || i10 != 77 || (i11 != 77 && i2 != 2)) {
            if (i8 == 77) {
                if (A0L[5].charAt(24) == 'i') {
                    throw new RuntimeException();
                }
                String[] strArr = A0L;
                strArr[2] = "NxAl2v4obD3CfxY1bwrYNdaYMjSl6";
                strArr[0] = "";
                if (i9 != 76 || i10 != 76 || (i11 != 84 && i2 != 2)) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean A0D(int i2, long j) {
        return ((long) ((-128000) & i2)) == ((-128000) & j);
    }

    private boolean A0E(InterfaceC1943lN interfaceC1943lN) throws IOException {
        if (this.A0A != null) {
            long jA7b = this.A0A.A7b();
            if (jA7b != -1) {
                long dataEndPosition = interfaceC1943lN.A8a();
                if (dataEndPosition > jA7b - 4) {
                    return true;
                }
            }
        }
        try {
            return !interfaceC1943lN.AGA(this.A0F.A0l(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    private boolean A0F(InterfaceC1943lN interfaceC1943lN, boolean z2) throws IOException {
        int candidateSynchronizedHeaderData;
        int i2 = 0;
        int i8 = 0;
        int iA8a = 0;
        int searchedBytes = 0;
        int headerData = z2 ? 32768 : 131072;
        interfaceC1943lN.AI1();
        if (interfaceC1943lN.A8f() == 0) {
            int validFrameCount = this.A0D;
            int validFrameCount2 = (validFrameCount & 8) == 0 ? 1 : 0;
            this.A06 = this.A0H.A00(interfaceC1943lN, validFrameCount2 != 0 ? null : A0N);
            if (this.A06 != null) {
                this.A0G.A05(this.A06);
            }
            iA8a = (int) interfaceC1943lN.A8a();
            if (!z2) {
                interfaceC1943lN.AJJ(iA8a);
            }
        }
        while (true) {
            if (A0E(interfaceC1943lN)) {
                if (i2 <= 0) {
                    throw new EOFException();
                }
            } else {
                this.A0F.A0f(0);
                int iA0C = this.A0F.A0C();
                if ((i8 != 0 && !A0D(iA0C, i8)) || (candidateSynchronizedHeaderData = AbstractC0774Gm.A00(iA0C)) == -1) {
                    int candidateSynchronizedHeaderData2 = searchedBytes + 1;
                    if (searchedBytes == headerData) {
                        if (z2) {
                            return false;
                        }
                        throw C04222i.A01(A09(0, 24, 51), null);
                    }
                    i2 = 0;
                    i8 = 0;
                    if (z2) {
                        interfaceC1943lN.AI1();
                        int validFrameCount3 = iA8a + candidateSynchronizedHeaderData2;
                        interfaceC1943lN.A3z(validFrameCount3);
                    } else {
                        interfaceC1943lN.AJJ(1);
                    }
                    searchedBytes = candidateSynchronizedHeaderData2;
                } else {
                    i2++;
                    if (i2 == 1) {
                        this.A0I.A00(iA0C);
                        i8 = iA0C;
                    } else if (i2 == 4) {
                        break;
                    }
                    int validFrameCount4 = candidateSynchronizedHeaderData - 4;
                    interfaceC1943lN.A3z(validFrameCount4);
                }
            }
        }
        if (z2) {
            interfaceC1943lN.AJJ(iA8a + searchedBytes);
        } else {
            interfaceC1943lN.AI1();
        }
        this.A01 = i8;
        if (A0L[5].charAt(24) == 105) {
            throw new RuntimeException();
        }
        String[] strArr = A0L;
        strArr[7] = "Yv6sT";
        strArr[4] = "";
        return true;
    }

    public static /* synthetic */ GX[] A0G() {
        return new GX[]{new C1917kl()};
    }

    @Override // com.instagram.common.viewpoint.core.GX
    public final void AA4(GY gy) {
        this.A07 = gy;
        this.A09 = this.A07.AJh(0, 1);
        this.A08 = this.A09;
        this.A07.A6G();
    }

    @Override // com.instagram.common.viewpoint.core.GX
    public final int AGb(InterfaceC1943lN interfaceC1943lN, C0781Gt c0781Gt) throws IOException {
        A0A();
        int iA01 = A01(interfaceC1943lN);
        if (iA01 == -1 && (this.A0A instanceof C05637t)) {
            long jA03 = A03(this.A04);
            long durationUs = this.A0A.A7l();
            if (durationUs != jA03) {
                ((C05637t) this.A0A).A00(jA03);
                this.A07.AIN(this.A0A);
            }
        }
        return iA01;
    }

    @Override // com.instagram.common.viewpoint.core.GX
    public final void AGr() {
    }

    @Override // com.instagram.common.viewpoint.core.GX
    public final void AIM(long j, long j3) {
        this.A01 = 0;
        this.A02 = -9223372036854775807L;
        this.A04 = 0L;
        this.A00 = 0;
        this.A05 = j3;
        if ((this.A0A instanceof C05637t) && !((C05637t) this.A0A).A02(j3)) {
            this.A0C = true;
            this.A08 = this.A0J;
        }
    }

    @Override // com.instagram.common.viewpoint.core.GX
    public final boolean AJL(InterfaceC1943lN interfaceC1943lN) throws IOException {
        return A0F(interfaceC1943lN, true);
    }
}
