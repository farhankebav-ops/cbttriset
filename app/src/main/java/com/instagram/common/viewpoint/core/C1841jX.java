package com.instagram.common.viewpoint.core;

import android.net.Uri;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jX, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1841jX implements GX {
    public static byte[] A0J;
    public static String[] A0K = {"3dZ2NVLPQqqn6A0EUODs8QMiUtGNdx7Z", "xuFjaEC88iswWSp8XVRYQuG7fGDdMX6m", "rjdehGUhBmpCCREwTfVtgF2pvaVk7Y4r", "d6Khp0uOfqWTO1N40QwEt8A6fbOPCRXM", "7DUxEGbk65Je624GBbCgY3TRasgIHugx", "67QtD18zbra6Hv1RLsjBMCgdjZH6dqot", "3juCdNiTPJNnKT5EWnyWnOXcFndGfbid", "ecCIYKwUzA4Q5tjuLJWmpRk8GBJuqhXU"};
    public static final InterfaceC0763Gb A0L;
    public int A00;
    public int A01;
    public int A02;
    public GY A03;
    public C1845jb A04;
    public InterfaceC0870Kf A05;
    public boolean A06;
    public boolean A07;
    public boolean A08;
    public final int A09;
    public final int A0A;
    public final SparseArray<InterfaceC0870Kf> A0B;
    public final SparseBooleanArray A0C;
    public final SparseBooleanArray A0D;
    public final SparseIntArray A0E;
    public final C4J A0F;
    public final KY A0G;
    public final InterfaceC0867Kc A0H;
    public final List<C4R> A0I;

    public static String A0D(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0J, i2, i2 + i8);
        int i10 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A0K[5].charAt(9) == '6') {
                throw new RuntimeException();
            }
            A0K[5] = "URhJNiPfEIrBtOuckipDqR7YK4paNHr3";
            if (i10 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 30);
            i10++;
        }
    }

    public static void A0G() {
        A0J = new byte[]{64, 98, 109, 109, 108, 119, 35, 101, 106, 109, 103, 35, 112, 122, 109, 96, 35, 97, 122, 119, 102, 45, 35, 78, 108, 112, 119, 35, 111, 106, 104, 102, 111, 122, 35, 109, 108, 119, 35, 98, 35, 87, 113, 98, 109, 112, 115, 108, 113, 119, 35, 80, 119, 113, 102, 98, 110, 45};
    }

    static {
        A0G();
        A0L = new InterfaceC0763Gb() { // from class: com.facebook.ads.redexgen.X.ja
            @Override // com.instagram.common.viewpoint.core.InterfaceC0763Gb
            public final GX[] A5F() {
                return C1841jX.A0M();
            }

            @Override // com.instagram.common.viewpoint.core.InterfaceC0763Gb
            public final /* synthetic */ GX[] A5G(Uri uri, Map map) {
                return AbstractC0762Ga.A01(this, uri, map);
            }
        };
    }

    public C1841jX() {
        this(0);
    }

    public C1841jX(int i2) {
        this(1, i2, 112800);
    }

    public C1841jX(int i2, int i8, int i9) {
        this(i2, new C4R(0L), new C1863jt(i8), i9);
    }

    public C1841jX(int i2, C4R c4r, InterfaceC0867Kc interfaceC0867Kc, int i8) {
        this.A0H = (InterfaceC0867Kc) C3M.A01(interfaceC0867Kc);
        this.A0A = i8;
        this.A09 = i2;
        if (i2 == 1 || i2 == 2) {
            this.A0I = Collections.singletonList(c4r);
        } else {
            this.A0I = new ArrayList();
            this.A0I.add(c4r);
        }
        this.A0F = new C4J(new byte[9400], 0);
        this.A0C = new SparseBooleanArray();
        this.A0D = new SparseBooleanArray();
        this.A0B = new SparseArray<>();
        this.A0E = new SparseIntArray();
        this.A0G = new KY(i8);
        this.A03 = GY.A00;
        this.A01 = -1;
        A0F();
    }

    private int A00() throws C04222i {
        int iA09 = this.A0F.A09();
        int limit = this.A0F.A0A();
        int iA00 = AbstractC0871Kg.A00(this.A0F.A0l(), iA09, limit);
        this.A0F.A0f(iA00);
        int endOfPacket = iA00 + 188;
        if (endOfPacket > limit) {
            int i2 = this.A00;
            String[] strArr = A0K;
            String str = strArr[0];
            String str2 = strArr[6];
            int limit2 = str.charAt(22);
            int searchStart = str2.charAt(22);
            if (limit2 == searchStart) {
                throw new RuntimeException();
            }
            A0K[3] = "oFbhmyTyFkRbH7nwLSukkKpVMF9MBiPP";
            this.A00 = i2 + (iA00 - iA09);
            if (this.A09 == 2 && this.A00 > 376) {
                throw C04222i.A01(A0D(0, 58, 29), null);
            }
        } else {
            this.A00 = 0;
        }
        return endOfPacket;
    }

    public static /* synthetic */ int A02(C1841jX c1841jX) {
        int i2 = c1841jX.A02;
        c1841jX.A02 = i2 + 1;
        return i2;
    }

    private void A0F() {
        this.A0C.clear();
        this.A0B.clear();
        SparseArray<InterfaceC0870Kf> sparseArrayA5I = this.A0H.A5I();
        int size = sparseArrayA5I.size();
        for (int i2 = 0; i2 < size; i2++) {
            SparseArray<InterfaceC0870Kf> sparseArray = this.A0B;
            int initialPayloadReadersSize = A0K[7].charAt(31);
            if (initialPayloadReadersSize != 85) {
                throw new RuntimeException();
            }
            A0K[5] = "Ni66o4kKOCTyHVW4880FmErKiABvWzx3";
            int initialPayloadReadersSize2 = sparseArrayA5I.keyAt(i2);
            sparseArray.put(initialPayloadReadersSize2, sparseArrayA5I.valueAt(i2));
        }
        this.A0B.put(0, new C1847jd(new C1843jZ(this)));
        this.A05 = null;
    }

    private void A0H(long j) {
        if (!this.A06) {
            this.A06 = true;
            if (this.A0G.A08() != -9223372036854775807L) {
                this.A04 = new C1845jb(this.A0G.A09(), this.A0G.A08(), j, this.A01, this.A0A);
                this.A03.AIN(this.A04.A07());
            } else {
                this.A03.AIN(new C1938lI(this.A0G.A08()));
            }
        }
    }

    private boolean A0I(int i2) {
        return this.A09 == 2 || this.A08 || !this.A0D.get(i2, false);
    }

    private boolean A0J(InterfaceC1943lN interfaceC1943lN) throws IOException {
        byte[] bArrA0l = this.A0F.A0l();
        if (9400 - this.A0F.A09() < 188) {
            int bytesLeft = this.A0F.A07();
            if (bytesLeft > 0) {
                System.arraycopy(bArrA0l, this.A0F.A09(), bArrA0l, 0, bytesLeft);
            }
            this.A0F.A0j(bArrA0l, bytesLeft);
        }
        while (this.A0F.A07() < 188) {
            int iA0A = this.A0F.A0A();
            int limit = interfaceC1943lN.read(bArrA0l, iA0A, 9400 - iA0A);
            if (limit == -1) {
                return false;
            }
            this.A0F.A0e(iA0A + limit);
        }
        return true;
    }

    public static /* synthetic */ GX[] A0M() {
        return new GX[]{new C1841jX()};
    }

    @Override // com.instagram.common.viewpoint.core.GX
    public final void AA4(GY gy) {
        this.A03 = gy;
    }

    @Override // com.instagram.common.viewpoint.core.GX
    public final int AGb(InterfaceC1943lN interfaceC1943lN, C0781Gt c0781Gt) throws IOException {
        InterfaceC0870Kf payloadReader;
        int i2;
        long jA8G = interfaceC1943lN.A8G();
        if (this.A08) {
            if (((jA8G == -1 || this.A09 == 2) ? false : true) && !this.A0G.A0A()) {
                return this.A0G.A07(interfaceC1943lN, c0781Gt, this.A01);
            }
            A0H(jA8G);
            if (this.A07) {
                this.A07 = false;
                AIM(0L, 0L);
                if (interfaceC1943lN.A8f() != 0) {
                    c0781Gt.A00 = 0L;
                    return 1;
                }
            }
            C1845jb c1845jb = this.A04;
            if (A0K[3].charAt(3) != 'h') {
                throw new RuntimeException();
            }
            String[] strArr = A0K;
            strArr[0] = "sDiEMLnvjhOTPJNI7EdeGtcVnMMFmFVg";
            strArr[6] = "irXGtuFGajwAGmxrojJd4OjCXPAtU7cs";
            if (c1845jb != null && this.A04.A09()) {
                return this.A04.A06(interfaceC1943lN, c0781Gt);
            }
        }
        boolean zA0J = A0J(interfaceC1943lN);
        if (A0K[5].charAt(9) == '6') {
            throw new RuntimeException();
        }
        A0K[3] = "pbqhdVjd4r56PJWJm8ke7L1TPhAXhQlh";
        if (!zA0J) {
            return -1;
        }
        int iA00 = A00();
        int iA0A = this.A0F.A0A();
        if (iA00 > iA0A) {
            return 0;
        }
        int iA0C = this.A0F.A0C();
        if ((8388608 & iA0C) == 0) {
            int limit = 0 | ((4194304 & iA0C) != 0 ? 1 : 0);
            int packetHeaderFlags = (2096896 & iA0C) >> 8;
            int tsPacketHeader = (iA0C & 32) != 0 ? 1 : 0;
            if ((iA0C & 16) != 0) {
                payloadReader = this.A0B.get(packetHeaderFlags);
            } else {
                payloadReader = null;
            }
            if (payloadReader == null) {
                this.A0F.A0f(iA00);
                return 0;
            }
            if (this.A09 != 2) {
                int i8 = iA0C & 15;
                int i9 = this.A0E.get(packetHeaderFlags, i8 - 1);
                this.A0E.put(packetHeaderFlags, i8);
                if (i9 == i8) {
                    this.A0F.A0f(iA00);
                    return 0;
                }
                if (i8 != ((i9 + 1) & 15)) {
                    payloadReader.AIL();
                }
            }
            if (tsPacketHeader != 0) {
                int iA0I = this.A0F.A0I();
                if ((this.A0F.A0I() & 64) != 0) {
                    i2 = 2;
                } else {
                    i2 = 0;
                }
                limit |= i2;
                this.A0F.A0g(iA0I - 1);
            }
            boolean z2 = this.A08;
            if (A0I(packetHeaderFlags)) {
                this.A0F.A0e(iA00);
                payloadReader.A53(this.A0F, limit);
                this.A0F.A0e(iA0A);
            }
            if (this.A09 != 2 && !z2 && this.A08 && jA8G != -1) {
                this.A07 = true;
            }
            this.A0F.A0f(iA00);
            return 0;
        }
        this.A0F.A0f(iA00);
        return 0;
    }

    @Override // com.instagram.common.viewpoint.core.GX
    public final void AGr() {
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0064  */
    @Override // com.instagram.common.viewpoint.core.GX
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void AIM(long r16, long r18) {
        /*
            Method dump skipped, instruction units count: 210
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C1841jX.AIM(long, long):void");
    }

    @Override // com.instagram.common.viewpoint.core.GX
    public final boolean AJL(InterfaceC1943lN interfaceC1943lN) throws IOException {
        byte[] bArrA0l = this.A0F.A0l();
        interfaceC1943lN.AG9(bArrA0l, 0, 940);
        for (int i2 = 0; i2 < 188; i2++) {
            boolean isSyncBytePatternCorrect = true;
            int i8 = 0;
            while (true) {
                if (i8 >= 5) {
                    break;
                }
                int startPosCandidate = bArrA0l[(i8 * 188) + i2];
                if (startPosCandidate != 71) {
                    isSyncBytePatternCorrect = false;
                    break;
                }
                i8++;
            }
            if (isSyncBytePatternCorrect) {
                interfaceC1943lN.AJJ(i2);
                return true;
            }
        }
        return false;
    }
}
