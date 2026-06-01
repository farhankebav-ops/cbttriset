package com.instagram.common.viewpoint.core;

import android.net.Uri;
import androidx.core.location.LocationRequestCompat;
import com.facebook.ads.androidx.media3.common.Metadata;
import com.facebook.ads.androidx.media3.extractor.metadata.mp4.MotionPhotoMetadata;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.kY, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1904kY implements GX, InterfaceC0784Gw {
    public static byte[] A0Q;
    public static String[] A0R = {"uzhMW", "LbToze1ZyMStOzMPMggUyU89k761Fydj", "roznHbdGo", "zeOiwqyw9G80TO", "hwgMtT9WWej", "AZ5CtgA3jsgDmrh", "c4g75mNjYzBkznfgxB8HcDFPfSogi", "Prtl1ARtkjOsoD"};
    public static final InterfaceC0763Gb A0S;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public long A09;

    @MetaExoPlayerCustomization(type = {"NEW_CLASS_ARG"}, value = "D54927862 get video/audio duration for progressive")
    public long A0A;
    public long A0B;

    @MetaExoPlayerCustomization(type = {"NEW_CLASS_ARG"}, value = "D54927862 get video/audio duration for progressive")
    public long A0C;
    public C4J A0D;
    public GY A0E;
    public MotionPhotoMetadata A0F;
    public C0815Ic[] A0G;
    public long[][] A0H;
    public final int A0I;
    public final C4J A0J;
    public final C4J A0K;
    public final C4J A0L;
    public final C4J A0M;
    public final C0822Ij A0N;
    public final ArrayDeque<C1915kj> A0O;
    public final List<Metadata.Entry> A0P;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 25 out of bounds for length 24
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.restartVar(DebugInfoParser.java:193)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:141)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x016a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int A03(com.instagram.common.viewpoint.core.InterfaceC1943lN r22, com.instagram.common.viewpoint.core.C0781Gt r23) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C1904kY.A03(com.facebook.ads.redexgen.X.lN, com.facebook.ads.redexgen.X.Gt):int");
    }

    public static String A09(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0Q, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 83);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0C() {
        A0Q = new byte[]{-47, 4, -1, -3, -80, 3, -7, 10, -11, -80, -4, -11, 3, 3, -80, 4, -8, -15, -2, -80, -8, -11, -15, -12, -11, 2, -80, -4, -11, -2, -9, 4, -8, -80, -72, 5, -2, 3, 5, 0, 0, -1, 2, 4, -11, -12, -71, -66, 18, 55, 63, 42, 53, 50, 45, -23, 23, 10, 21, -23, 53, 46, 55, 48, 61, 49, -8, 12, -5, 0, 6, -58, -8, -6, -53, 49, 69, 52, 57, 63, -1, 68, 66, 69, 53, -3, 56, 52};
    }

    static {
        A0C();
        A0S = new InterfaceC0763Gb() { // from class: com.facebook.ads.redexgen.X.kZ
            @Override // com.instagram.common.viewpoint.core.InterfaceC0763Gb
            public final GX[] A5F() {
                return C1904kY.A0M();
            }

            @Override // com.instagram.common.viewpoint.core.InterfaceC0763Gb
            public final /* synthetic */ GX[] A5G(Uri uri, Map map) {
                return AbstractC0762Ga.A01(this, uri, map);
            }
        };
    }

    public C1904kY() {
        this(0);
    }

    public C1904kY(int i2) {
        this.A0I = i2;
        this.A04 = (i2 & 4) != 0 ? 3 : 0;
        this.A0N = new C0822Ij();
        this.A0P = new ArrayList();
        this.A0J = new C4J(16);
        this.A0O = new ArrayDeque<>();
        this.A0L = new C4J(AbstractC0778Gq.A03);
        this.A0K = new C4J(4);
        this.A0M = new C4J();
        this.A08 = -1;
        this.A0E = GY.A00;
        this.A0G = new C0815Ic[0];
    }

    public static int A00(int i2) {
        switch (i2) {
            case 1751476579:
                return 2;
            case 1903435808:
                if (A0R[6].length() != 29) {
                    throw new RuntimeException();
                }
                A0R[1] = "rbgKKZbH0NS3XFJda55b1nN6iCZjcLPR";
                return 1;
            default:
                if (A0R[6].length() != 29) {
                    throw new RuntimeException();
                }
                A0R[4] = "05jGjYjRxbz";
                return 0;
        }
    }

    private int A01(long j) {
        long j3 = LocationRequestCompat.PASSIVE_INTERVAL;
        int preferredTrackIndex = 1;
        int i2 = -1;
        long sampleOffset = LocationRequestCompat.PASSIVE_INTERVAL;
        long j8 = LocationRequestCompat.PASSIVE_INTERVAL;
        int i8 = 1;
        int trackIndex = -1;
        int i9 = 0;
        while (true) {
            C0815Ic[] c0815IcArr = this.A0G;
            String[] strArr = A0R;
            if (strArr[3].length() != strArr[7].length()) {
                throw new RuntimeException();
            }
            A0R[6] = "Fcko3uaud46cO6nUcug7HhLZFNYBY";
            if (i9 >= c0815IcArr.length) {
                if (j8 == LocationRequestCompat.PASSIVE_INTERVAL || i8 == 0) {
                    return i2;
                }
                long j9 = 10485760 + j8;
                if (A0R[1].charAt(1) == 'b') {
                    A0R[1] = "AbIM1W3wiFJMRqsWOI3P0CqvLybO2M00";
                    if (sampleOffset < j9) {
                        return i2;
                    }
                } else if (sampleOffset < j9) {
                    return i2;
                }
                return trackIndex;
            }
            C0815Ic c0815Ic = this.A0G[i9];
            int i10 = c0815Ic.A00;
            if (i10 != c0815Ic.A04.A01) {
                long j10 = c0815Ic.A04.A06[i10];
                long minAccumulatedBytes = ((long[][]) AbstractC04664a.A0f(this.A0H))[i9][i10];
                long j11 = j10 - j;
                int i11 = (j11 < 0 || j11 >= 262144) ? 1 : 0;
                if ((i11 == 0 && preferredTrackIndex != 0) || (i11 == preferredTrackIndex && j11 < j3)) {
                    preferredTrackIndex = i11;
                    j3 = j11;
                    i2 = i9;
                    if (A0R[6].length() != 29) {
                        String[] strArr2 = A0R;
                        strArr2[5] = "nNk7RawiIyahd9Y";
                        strArr2[0] = "017pL";
                        sampleOffset = minAccumulatedBytes;
                    } else {
                        A0R[1] = "1bC0in6G1ApWSL3PegJBmoVzHl6EE3tw";
                        sampleOffset = minAccumulatedBytes;
                    }
                }
                if (minAccumulatedBytes < j8) {
                    j8 = minAccumulatedBytes;
                    i8 = i11;
                    trackIndex = i9;
                }
            }
            i9++;
        }
    }

    public static int A02(C4J c4j) {
        c4j.A0f(8);
        int majorBrand = A00(c4j.A0C());
        if (majorBrand != 0) {
            return majorBrand;
        }
        c4j.A0g(4);
        while (c4j.A07() > 0) {
            int majorBrand2 = A00(c4j.A0C());
            if (majorBrand2 != 0) {
                return majorBrand2;
            }
        }
        return 0;
    }

    private int A04(InterfaceC1943lN interfaceC1943lN, C0781Gt c0781Gt) throws IOException {
        int iA07 = this.A0N.A07(interfaceC1943lN, c0781Gt, this.A0P);
        if (iA07 == 1 && c0781Gt.A00 == 0) {
            A0A();
        }
        return iA07;
    }

    public static int A05(C0828Ip c0828Ip, long j) {
        int iA00 = c0828Ip.A00(j);
        if (iA00 == -1) {
            return c0828Ip.A01(j);
        }
        return iA00;
    }

    public static long A06(C0828Ip c0828Ip, long j, long j3) {
        int iA05 = A05(c0828Ip, j);
        if (iA05 == -1) {
            return j3;
        }
        return Math.min(c0828Ip.A06[iA05], j3);
    }

    private final C0783Gv A07(long j, int i2) {
        long jA06;
        long j3;
        int mainTrackIndex;
        if (this.A0G.length == 0) {
            return new C0783Gv(C0785Gx.A04);
        }
        long j8 = -9223372036854775807L;
        long jA062 = -1;
        int i8 = i2 != -1 ? i2 : this.A03;
        if (i8 != -1) {
            C0828Ip c0828Ip = this.A0G[i8].A04;
            int iA05 = A05(c0828Ip, j);
            if (iA05 == -1) {
                return new C0783Gv(C0785Gx.A04);
            }
            j3 = c0828Ip.A07[iA05];
            jA06 = c0828Ip.A06[iA05];
            if (A0R[6].length() != 29) {
                throw new RuntimeException();
            }
            A0R[1] = "zbT5rN6sguJCvWwII8HLCHwSkH7sQNQT";
            if (j3 < j && iA05 < c0828Ip.A01 - 1 && (mainTrackIndex = c0828Ip.A01(j)) != -1 && mainTrackIndex != iA05) {
                j8 = c0828Ip.A07[mainTrackIndex];
                jA062 = c0828Ip.A06[mainTrackIndex];
            }
        } else {
            jA06 = LocationRequestCompat.PASSIVE_INTERVAL;
            if (A0R[4].length() != 11) {
                j3 = j;
            } else {
                A0R[2] = "SenK5aC";
                j3 = j;
            }
        }
        if (i2 == -1) {
            for (int i9 = 0; i9 < this.A0G.length; i9++) {
                if (i9 != this.A03) {
                    C0828Ip sampleTable = this.A0G[i9].A04;
                    jA06 = A06(sampleTable, j3, jA06);
                    if (j8 != -9223372036854775807L) {
                        jA062 = A06(sampleTable, j8, jA062);
                    }
                }
            }
        }
        C0785Gx c0785Gx = new C0785Gx(j3, jA06);
        if (j8 == -9223372036854775807L) {
            return new C0783Gv(c0785Gx);
        }
        return new C0783Gv(c0785Gx, new C0785Gx(j8, jA062));
    }

    public static /* synthetic */ C0825Im A08(C0825Im c0825Im) {
        return c0825Im;
    }

    private void A0A() {
        this.A04 = 0;
        this.A00 = 0;
    }

    private void A0B() {
        if (this.A02 == 2 && (this.A0I & 2) != 0) {
            this.A0E.AJh(0, 4).A6W(new C2D().A0v(this.A0F == null ? null : new Metadata(this.A0F)).A14());
            this.A0E.A6G();
            this.A0E.AIN(new C1938lI(-9223372036854775807L));
        }
    }

    private void A0D(long j) throws C04222i {
        while (!this.A0O.isEmpty() && this.A0O.peek().A00 == j) {
            C1915kj c1915kjPop = this.A0O.pop();
            if (((II) c1915kjPop).A00 == 1836019574) {
                A0G(c1915kjPop);
                this.A0O.clear();
                this.A04 = 2;
            } else if (!this.A0O.isEmpty()) {
                C1915kj containerAtom = this.A0O.peek();
                containerAtom.A08(c1915kjPop);
            }
        }
        if (this.A04 != 2) {
            A0A();
        }
    }

    private void A0E(long j) {
        if (this.A01 == 1836086884) {
            this.A0F = new MotionPhotoMetadata(0L, j, -9223372036854775807L, j + ((long) this.A00), this.A09 - ((long) this.A00));
        }
    }

    private void A0F(InterfaceC1943lN interfaceC1943lN) throws IOException {
        this.A0M.A0d(8);
        interfaceC1943lN.AG9(this.A0M.A0l(), 0, 8);
        IO.A0Q(this.A0M);
        interfaceC1943lN.AJJ(this.A0M.A09());
        interfaceC1943lN.AI1();
    }

    /* JADX WARN: Incorrect condition in loop: B:58:0x0138 */
    @com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "Adding average bitrate calculation logic")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0G(com.instagram.common.viewpoint.core.C1915kj r36) throws com.instagram.common.viewpoint.core.C04222i {
        /*
            Method dump skipped, instruction units count: 462
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C1904kY.A0G(com.facebook.ads.redexgen.X.kj):void");
    }

    private void A0H(C0815Ic c0815Ic, long j) {
        C0828Ip c0828Ip = c0815Ic.A04;
        int sampleIndex = c0828Ip.A00(j);
        if (sampleIndex == -1) {
            sampleIndex = c0828Ip.A01(j);
        }
        c0815Ic.A00 = sampleIndex;
        if (A0R[2].length() == 19) {
            throw new RuntimeException();
        }
        A0R[2] = "DxqZc2lJMNLNZhW19Xb8kO";
    }

    public static boolean A0I(int i2) {
        return i2 == 1836019574 || i2 == 1953653099 || i2 == 1835297121 || i2 == 1835626086 || i2 == 1937007212 || i2 == 1701082227 || i2 == 1835365473;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A0J(int r4) {
        /*
            r0 = 1835296868(0x6d646864, float:4.418049E27)
            if (r4 == r0) goto L8d
            r0 = 1836476516(0x6d766864, float:4.7662196E27)
            if (r4 == r0) goto L8d
            r3 = 1751411826(0x68646c72, float:4.3148E24)
            java.lang.String[] r1 = com.instagram.common.viewpoint.core.C1904kY.A0R
            r0 = 4
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 11
            if (r1 == r0) goto L20
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L20:
            java.lang.String[] r2 = com.instagram.common.viewpoint.core.C1904kY.A0R
            java.lang.String r1 = "UHuXZ9PGVGxrhu"
            r0 = 3
            r2[r0] = r1
            java.lang.String r1 = "Sv1JTBT1egKeuo"
            r0 = 7
            r2[r0] = r1
            if (r4 == r3) goto L8d
            r0 = 1937011556(0x73747364, float:1.9367383E31)
            if (r4 == r0) goto L8d
            r0 = 1937011827(0x73747473, float:1.9367711E31)
            if (r4 == r0) goto L8d
            r0 = 1937011571(0x73747373, float:1.9367401E31)
            if (r4 == r0) goto L8d
            r0 = 1668576371(0x63747473, float:4.5093966E21)
            if (r4 == r0) goto L8d
            r0 = 1701606260(0x656c7374, float:6.9788014E22)
            if (r4 == r0) goto L8d
            r0 = 1937011555(0x73747363, float:1.9367382E31)
            if (r4 == r0) goto L8d
            r0 = 1937011578(0x7374737a, float:1.936741E31)
            if (r4 == r0) goto L8d
            r0 = 1937013298(0x73747a32, float:1.9369489E31)
            if (r4 == r0) goto L8d
            r3 = 1937007471(0x7374636f, float:1.9362445E31)
            java.lang.String[] r1 = com.instagram.common.viewpoint.core.C1904kY.A0R
            r0 = 2
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 19
            if (r1 == r0) goto L91
            java.lang.String[] r2 = com.instagram.common.viewpoint.core.C1904kY.A0R
            java.lang.String r1 = "0EWWhWMRQ7MgS85x4CKboIorprSqD"
            r0 = 6
            r2[r0] = r1
            if (r4 == r3) goto L8d
        L6f:
            r0 = 1668232756(0x636f3634, float:4.4126776E21)
            if (r4 == r0) goto L8d
            r0 = 1953196132(0x746b6864, float:7.46037E31)
            if (r4 == r0) goto L8d
            r0 = 1718909296(0x66747970, float:2.8862439E23)
            if (r4 == r0) goto L8d
            r0 = 1969517665(0x75647461, float:2.8960062E32)
            if (r4 == r0) goto L8d
            r0 = 1801812339(0x6b657973, float:2.7741754E26)
            if (r4 == r0) goto L8d
            r0 = 1768715124(0x696c7374, float:1.7865732E25)
            if (r4 != r0) goto L8f
        L8d:
            r0 = 1
        L8e:
            return r0
        L8f:
            r0 = 0
            goto L8e
        L91:
            if (r4 == r3) goto L8d
            goto L6f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C1904kY.A0J(int):boolean");
    }

    private boolean A0K(InterfaceC1943lN interfaceC1943lN) throws IOException {
        C1915kj containerAtom;
        if (this.A00 == 0) {
            if (!interfaceC1943lN.AGh(this.A0J.A0l(), 0, 8, true)) {
                A0B();
                return false;
            }
            this.A00 = 8;
            this.A0J.A0f(0);
            this.A09 = this.A0J.A0Q();
            this.A01 = this.A0J.A0C();
        }
        if (this.A09 == 1) {
            if (A0R[2].length() == 19) {
                throw new RuntimeException();
            }
            A0R[2] = "uEfPCG8cZZkUCN4sq";
            interfaceC1943lN.readFully(this.A0J.A0l(), 8, 8);
            int headerBytesRemaining = this.A00;
            this.A00 = headerBytesRemaining + 8;
            this.A09 = this.A0J.A0R();
        } else if (this.A09 == 0) {
            long jA8G = interfaceC1943lN.A8G();
            if (jA8G == -1 && (containerAtom = this.A0O.peek()) != null) {
                jA8G = containerAtom.A00;
            }
            if (jA8G != -1) {
                this.A09 = (jA8G - interfaceC1943lN.A8f()) + ((long) this.A00);
            }
        }
        if (this.A09 >= this.A00) {
            if (A0I(this.A01)) {
                long jA8f = (interfaceC1943lN.A8f() + this.A09) - ((long) this.A00);
                if (this.A09 != this.A00 && this.A01 == 1835365473) {
                    A0F(interfaceC1943lN);
                }
                this.A0O.push(new C1915kj(this.A01, jA8f));
                if (this.A09 == this.A00) {
                    A0D(jA8f);
                } else {
                    A0A();
                }
            } else if (A0J(this.A01)) {
                C3M.A08(this.A00 == 8);
                C3M.A08(this.A09 <= 2147483647L);
                C4J c4j = new C4J((int) this.A09);
                C4J atomData = this.A0J;
                System.arraycopy(atomData.A0l(), 0, c4j.A0l(), 0, 8);
                this.A0D = c4j;
                this.A04 = 1;
            } else {
                A0E(interfaceC1943lN.A8f() - ((long) this.A00));
                this.A0D = null;
                this.A04 = 1;
            }
            return true;
        }
        throw C04222i.A00(A09(0, 48, 61));
    }

    private boolean A0L(InterfaceC1943lN interfaceC1943lN, C0781Gt c0781Gt) throws IOException {
        long j = this.A09 - ((long) this.A00);
        long atomEndPosition = interfaceC1943lN.A8f() + j;
        boolean z2 = false;
        C4J c4j = this.A0D;
        if (c4j != null) {
            interfaceC1943lN.readFully(c4j.A0l(), this.A00, (int) j);
            if (this.A01 == 1718909296) {
                this.A02 = A02(c4j);
            } else if (!this.A0O.isEmpty()) {
                this.A0O.peek().A09(new C1914ki(this.A01, c4j));
            }
        } else if (j < 262144) {
            interfaceC1943lN.AJJ((int) j);
        } else {
            long atomPayloadSize = interfaceC1943lN.A8f();
            c0781Gt.A00 = atomPayloadSize + j;
            z2 = true;
        }
        A0D(atomEndPosition);
        return z2 && this.A04 != 2;
    }

    public static /* synthetic */ GX[] A0M() {
        return new GX[]{new C1904kY()};
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long[][] A0N(com.instagram.common.viewpoint.core.C0815Ic[] r16) {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C1904kY.A0N(com.facebook.ads.redexgen.X.Ic[]):long[][]");
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0784Gw
    public final long A7l() {
        return this.A0B;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0784Gw
    public final C0783Gv A8t(long j) {
        return A07(j, -1);
    }

    @Override // com.instagram.common.viewpoint.core.GX
    public final void AA4(GY gy) {
        this.A0E = gy;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0784Gw
    public final boolean AAa() {
        return true;
    }

    @Override // com.instagram.common.viewpoint.core.GX
    public final int AGb(InterfaceC1943lN interfaceC1943lN, C0781Gt c0781Gt) throws IOException {
        while (true) {
            switch (this.A04) {
                case 0:
                    if (!A0K(interfaceC1943lN)) {
                        return -1;
                    }
                    break;
                    break;
                case 1:
                    if (A0L(interfaceC1943lN, c0781Gt)) {
                        return 1;
                    }
                    break;
                case 2:
                    return A03(interfaceC1943lN, c0781Gt);
                case 3:
                    return A04(interfaceC1943lN, c0781Gt);
                default:
                    throw new IllegalStateException();
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.GX
    public final void AGr() {
    }

    @Override // com.instagram.common.viewpoint.core.GX
    public final void AIM(long j, long j3) {
        this.A0O.clear();
        this.A00 = 0;
        this.A08 = -1;
        this.A05 = 0;
        this.A06 = 0;
        this.A07 = 0;
        if (j == 0) {
            int i2 = this.A04;
            String[] strArr = A0R;
            if (strArr[3].length() != strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0R;
            strArr2[3] = "BBO5nGzNDCjhdG";
            strArr2[7] = "Qq9RZt6cBQ724Z";
            if (i2 != 3) {
                A0A();
                return;
            } else {
                this.A0N.A08();
                this.A0P.clear();
                return;
            }
        }
        for (C0815Ic c0815Ic : this.A0G) {
            A0H(c0815Ic, j3);
            if (c0815Ic.A02 != null) {
                c0815Ic.A02.A02();
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.GX
    public final boolean AJL(InterfaceC1943lN interfaceC1943lN) throws IOException {
        return AbstractC0823Ik.A02(interfaceC1943lN, (this.A0I & 2) != 0);
    }
}
