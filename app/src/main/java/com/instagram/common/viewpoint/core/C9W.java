package com.instagram.common.viewpoint.core;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import androidx.core.location.LocationRequestCompat;
import com.facebook.ads.androidx.media3.common.Timeline;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.vungle.ads.internal.protos.Sdk;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9W, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C9W implements Handler.Callback, InterfaceC2003mN, EJ, CK, InterfaceC05055n, InterfaceC05436z {
    public static byte[] A0x;
    public static String[] A0y = {"EvYOBb0fNCsu7OcAaOZNwoEPwn2", "8jIqnMhTOhQ3fU", "vmW", "edZR1F4oYcKYyzs7tUfX3dHGMGqqrKBY", "TI8UsWNSVk9Jh7srInWeHwVEqkc209d4", "AVB8fiMNMM9Dy8Zuh880FwllBoFt5PF1", "1mkHXRje2n0Pvvw2j", "LF2w13BN71krhrKRtprOb2x3jYcy1FYO"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public long A04;
    public long A06;
    public AnonymousClass67 A07;
    public C6B A08;
    public C05416x A0A;

    @MetaExoPlayerCustomization("D18870411: Adding start stall debug reason")
    public InterfaceC2064nM A0B;
    public C7I A0C;
    public CL A0D;
    public boolean A0G;
    public boolean A0H;
    public boolean A0I;
    public boolean A0K;
    public boolean A0M;
    public boolean A0N;
    public boolean A0O;
    public boolean A0P;
    public boolean A0Q;
    public boolean A0R;
    public boolean A0S;
    public boolean A0T;
    public boolean A0U;
    public boolean A0V;
    public InterfaceC2064nM[] A0W;
    public final long A0Y;
    public final long A0Z;
    public final Handler A0a;
    public final HandlerThread A0b;
    public final C2125oN A0c;
    public final C2123oL A0d;
    public final C3T A0e;
    public final InterfaceC04613v A0f;
    public final C2072nU A0g;
    public final C6A A0h;
    public final C6S A0i;
    public final C2058nG A0k;
    public final EK A0l;
    public final EL A0m;
    public final EU A0n;
    public final AnonymousClass91 A0o;
    public final ArrayList<AnonymousClass69> A0p;
    public final boolean A0q;
    public final boolean A0r;
    public final boolean A0s;
    public final boolean A0t;
    public final boolean A0u;
    public final InterfaceC2064nM[] A0v;
    public final C7D[] A0w;
    public long A05 = -9223372036854775807L;

    @MetaExoPlayerCustomization("D18870411: Adding start stall debug reason")
    public EnumC1730hX A0E = EnumC1730hX.A09;

    @MetaExoPlayerCustomization("D63737392: Added for negative testing")
    public boolean A0J = false;

    @MetaExoPlayerCustomization("D63737392: Added for negative testing")
    public C05386u A09 = null;

    @MetaExoPlayerCustomization("D63737392: Added for negative testing")
    public boolean A0L = false;

    @MetaExoPlayerCustomization("D71523094: Added for negative testing")
    public Integer A0F = null;
    public final C05206c A0j = new C05206c();

    @MetaExoPlayerCustomization
    public final int A0X = A00();

    public static String A0D(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0x, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            byte b8 = bArrCopyOfRange[i10];
            if (A0y[1].length() == 31) {
                throw new RuntimeException();
            }
            String[] strArr = A0y;
            strArr[2] = "wOV";
            strArr[6] = "lGv9KfQpa0xBFnWlu";
            bArrCopyOfRange[i10] = (byte) ((b8 - i9) - 57);
        }
        return new String(bArrCopyOfRange);
    }

    /* JADX WARN: Code restructure failed: missing block: B:186:0x03ab, code lost:
    
        r24.A0R = r24.A0P;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x03bb, code lost:
    
        if (com.instagram.common.viewpoint.core.C9W.A0y[5].charAt(1) == 'q') goto L220;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x03bd, code lost:
    
        r2 = com.instagram.common.viewpoint.core.C9W.A0y;
        r2[4] = "Uyz0TdICBPSSMiRUHh3H6S4m2yqjGOAg";
        r2[3] = "3B1Lhsj2yRloVQBWBzqqqLZ9kauiXzuH";
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x03cb, code lost:
    
        if (r24.A0B == null) goto L193;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x03d4, code lost:
    
        if (r24.A0B.A9F() != 1) goto L193;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x03d6, code lost:
    
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x03d7, code lost:
    
        A0W(2, r8);
        A0O();
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x043f, code lost:
    
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x044b, code lost:
    
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 25 out of bounds for length 25
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    /* JADX WARN: Removed duplicated region for block: B:123:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01fa  */
    @com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization("D18870411: Adding start stall debug reason")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0F() throws java.io.IOException, com.instagram.common.viewpoint.core.C9Y {
        /*
            Method dump skipped, instruction units count: 1100
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C9W.A0F():void");
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0P() throws java.io.IOException, com.instagram.common.viewpoint.core.C9Y {
        /*
            Method dump skipped, instruction units count: 560
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C9W.A0P():void");
    }

    public static void A0R() {
        A0x = new byte[]{-108, -57, -66, -97, -69, -80, -56, -76, -63, -104, -68, -65, -69, -104, -67, -61, -76, -63, -67, -80, -69, -15, 36, 27, -4, 24, 13, 37, 17, 30, -11, 25, 28, 24, -11, 26, 32, 17, 30, 26, 13, 24, -26, -12, 13, 26, 16, 24, 17, 30, -87, -57, -50, -49, -46, -55, -50, -57, -128, -51, -59, -45, -45, -63, -57, -59, -45, -128, -45, -59, -50, -44, -128, -63, -58, -44, -59, -46, -128, -46, -59, -52, -59, -63, -45, -59, -114, -107, -70, -64, -79, -66, -70, -83, -72, 108, -66, -63, -70, -64, -75, -71, -79, 108, -79, -66, -66, -69, -66, 122, -54, -26, -37, -13, -36, -37, -35, -27, -102, -33, -20, -20, -23, -20, -88, -114, -86, -97, -73, -96, -97, -95, -87, -114, -83, -79, -89, -78, -89, -83, -84, -117, -79, 120, 94, 99, -94, 106, 94, -96, -77, -92, -92, -93, -80, -93, -94, -126, -77, -80, -97, -78, -89, -83, -84, -117, -79, 120, 94, 99, -94, 106, 94, -84, -93, -74, -78, -118, -83, -97, -94, -114, -83, -79, -89, -78, -89, -83, -84, -117, -79, 120, 94, 99, -94, -76, -48, -42, -45, -60, -58, -127, -58, -45, -45, -48, -45, -113, -72, -39, -44, -43, -123, -53, -58, -50, -47, -54, -55, -109, -78, -97, -91, -84, -67, -59, -56, -57, -54, -71, -54, -63, -60, -47, 120, -63, -65, -58, -57, -54, -63, -58, -65, 120, -53, -52, -54, -67, -71, -59, 120, -67, -54, -54, -57, -54, -110, 120, -108, -78, -71, -87, -82, -89, 96, -76, -81, 96, -77, -91, -82, -92, 96, -83, -91, -77, -77, -95, -89, -91, 96, -81, -82, 96, -95, 96, -92, -91, -95, -92, 96, -76, -88, -78, -91, -95, -92, 110, 5, 30, 21, 40, 32, 21, 19, 36, 21, 20, -48, 21, 34, 34, 31, 34, -48, 20, 21, 28, 25, 38, 21, 34, 25, 30, 23, -48, 29, 21, 35, 35, 17, 23, 21, -48, 31, 30, -48, 21, 40, 36, 21, 34, 30, 17, 28, -48, 36, 24, 34, 21, 17, 20, -34, -34, -23, -51, -23, -25, -33, -47, -23, -20, -27, 37, 29, 28, 33, 25, 8, 29, 42, 33, 39, 28, 1, 28, -70, -81, -68, -77, -71, -82, -102, -71, -67, -77, -66, -77, -71, -72, -97, -67, -18, -31, -20, -24, -35, -33, -31, -49, -16, -18, -31, -35, -23};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 18 out of bounds for length 16
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    /* JADX WARN: Removed duplicated region for block: B:84:0x021b A[PHI: r8
  0x021b: PHI (r8v4 com.facebook.ads.redexgen.X.mL) = (r8v2 com.facebook.ads.redexgen.X.mL), (r8v6 com.facebook.ads.redexgen.X.mL) binds: [B:93:0x024d, B:83:0x0219] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0e(com.instagram.common.viewpoint.core.AnonymousClass68 r15) throws com.instagram.common.viewpoint.core.C9Y {
        /*
            Method dump skipped, instruction units count: 640
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C9W.A0e(com.facebook.ads.redexgen.X.68):void");
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 22 out of bounds for length 20
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    private void A0f(C6B c6b) throws Throwable {
        long jLongValue;
        C2001mL c2001mLA0K;
        long jLongValue2;
        boolean z2;
        this.A0h.A03(1);
        Pair<Object, Long> pairA09 = A09(c6b, true);
        if (pairA09 == null) {
            c2001mLA0K = A0A();
            jLongValue2 = -9223372036854775807L;
            jLongValue = -9223372036854775807L;
            z2 = true;
        } else {
            Object obj = pairA09.first;
            jLongValue = ((Long) pairA09.second).longValue();
            c2001mLA0K = this.A0j.A0K(this.A0A.A03, obj, jLongValue);
            if (c2001mLA0K.A00()) {
                jLongValue2 = 0;
                z2 = true;
            } else {
                jLongValue2 = ((Long) pairA09.second).longValue();
                z2 = c6b.A01 == -9223372036854775807L;
            }
        }
        try {
            try {
                if (this.A0D == null || this.A02 > 0) {
                    this.A08 = c6b;
                    this.A07 = null;
                } else {
                    try {
                        if (jLongValue2 == -9223372036854775807L) {
                            A0V(4);
                            A13(false, true, false);
                        } else {
                            long jA6j = jLongValue2;
                            if (c2001mLA0K.equals(this.A0A.A05)) {
                                C6Y c6yA0F = this.A0j.A0F();
                                if (c6yA0F != null && jA6j != 0) {
                                    jA6j = c6yA0F.A07.A6j(jA6j, this.A0C);
                                }
                                if (AbstractC04121w.A01(jA6j) == AbstractC04121w.A01(this.A0A.A0C)) {
                                    this.A0A = this.A0A.A06(c2001mLA0K, this.A0A.A0C, jLongValue, A01());
                                    if (z2) {
                                        this.A0h.A04(2);
                                        return;
                                    }
                                    return;
                                }
                            }
                            long jA06 = A06(c2001mLA0K, jA6j);
                            z2 |= jLongValue2 != jA06;
                            jLongValue2 = jA06;
                        }
                    } catch (Throwable th) {
                        th = th;
                        this.A0A = this.A0A.A06(c2001mLA0K, jLongValue2, jLongValue, A01());
                        if (z2) {
                            this.A0h.A04(2);
                        }
                        throw th;
                    }
                }
                this.A0A = this.A0A.A06(c2001mLA0K, jLongValue2, jLongValue, A01());
                if (z2) {
                    this.A0h.A04(2);
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    static {
        A0R();
    }

    public C9W(InterfaceC2064nM[] interfaceC2064nMArr, EK ek, EL el, C6S c6s, EU eu, boolean z2, int i2, boolean z7, Handler handler, C3T c3t, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, long j, boolean z14, int i8, boolean z15, boolean z16, boolean z17, boolean z18, boolean z19, boolean z20, C05567m c05567m) {
        this.A0v = interfaceC2064nMArr;
        this.A0l = ek;
        this.A0m = el;
        this.A0i = c6s;
        this.A0n = eu;
        this.A0P = z2;
        this.A03 = i2;
        this.A0V = z7;
        this.A0a = handler;
        this.A0e = c3t;
        this.A0U = z8;
        this.A0H = z9;
        this.A0G = z10;
        this.A0M = z11;
        this.A0I = z12;
        this.A0T = z13;
        this.A0Z = j;
        this.A0q = z14;
        this.A00 = i8;
        this.A0u = z16;
        this.A0s = z15;
        this.A0O = z17;
        this.A0Q = z18;
        this.A0K = z19;
        this.A0t = z20;
        this.A0N = j > 0;
        this.A0Y = c6s.A6s(c05567m);
        this.A0r = c6s.AI3(c05567m);
        this.A0C = C7I.A03;
        this.A0A = new C05416x(Timeline.A02, -9223372036854775807L, C1991mA.A06, el);
        this.A0h = new C6A();
        this.A0w = new C7D[interfaceC2064nMArr.length];
        for (int i9 = 0; i9 < interfaceC2064nMArr.length; i9++) {
            interfaceC2064nMArr[i9].AA1(i9, c05567m);
            this.A0w[i9] = interfaceC2064nMArr[i9].A75();
        }
        this.A0g = new C2072nU(this, c3t);
        this.A0k = new C2058nG(c3t);
        this.A0o = z16 ? new AnonymousClass91(c3t) : null;
        this.A0p = new ArrayList<>();
        this.A0W = new InterfaceC2064nM[0];
        this.A0d = new C2123oL();
        this.A0c = new C2125oN();
        ek.A02(this, eu);
        this.A0b = new HandlerThread(A0D(21, 29, 115), -16);
        this.A0b.start();
        this.A0f = c3t.A5H(this.A0b.getLooper(), this);
    }

    @MetaExoPlayerCustomization
    private int A00() {
        int exoplayerThreadPollingIntervalMs = MetaExoPlayerUpgradeConfig.A00(EnumC1754i3.A04);
        if (exoplayerThreadPollingIntervalMs > 0) {
            return exoplayerThreadPollingIntervalMs;
        }
        return 10;
    }

    private long A01() {
        return A04(this.A0A.A0B);
    }

    private final long A02() {
        long loadingPeriodStartPositionUs;
        C6Y c6yA0E = this.A0j.A0E();
        if (c6yA0E == null) {
            loadingPeriodStartPositionUs = 0;
        } else {
            loadingPeriodStartPositionUs = A05(c6yA0E);
        }
        if (c6yA0E == null || loadingPeriodStartPositionUs == -9223372036854775807L) {
            return 0L;
        }
        return c6yA0E.A0C(loadingPeriodStartPositionUs);
    }

    private final long A03() {
        long jA0C;
        C6Y c6yA0F = this.A0j.A0F();
        if (c6yA0F == null) {
            jA0C = 0;
        } else {
            jA0C = c6yA0F.A0C(c6yA0F.A0D(this.A06));
        }
        return jA0C + A02();
    }

    private long A04(long j) {
        C6Y c6yA0E = this.A0j.A0E();
        if (c6yA0E == null) {
            return 0L;
        }
        return j - c6yA0E.A0D(this.A06);
    }

    private final long A05(C6Y c6y) {
        long jMin = LocationRequestCompat.PASSIVE_INTERVAL;
        InterfaceC0675Cr[] interfaceC0675CrArr = c6y.A09;
        for (int i2 = 0; i2 < interfaceC0675CrArr.length; i2++) {
            if (interfaceC0675CrArr[i2] instanceof InterfaceC0676Cs) {
                long periodStartPositionUs = ((InterfaceC0676Cs) interfaceC0675CrArr[i2]).A81();
                jMin = Math.min(jMin, periodStartPositionUs);
            }
        }
        if (jMin == LocationRequestCompat.PASSIVE_INTERVAL) {
            return -9223372036854775807L;
        }
        return jMin;
    }

    private long A06(C2001mL c2001mL, long j) throws C9Y {
        return A07(false, c2001mL, j, this.A0j.A0F() != this.A0j.A0G());
    }

    private long A07(boolean z2, C2001mL c2001mL, long j, boolean z7) throws C9Y {
        A0O();
        this.A0R = false;
        A0V(2);
        C6Y c6yA0F = this.A0j.A0F();
        C6Y c6yA0B = c6yA0F;
        while (true) {
            if (c6yA0B == null) {
                break;
            }
            if (A18(c2001mL, j, c6yA0B)) {
                this.A0j.A0S(c6yA0B);
                break;
            }
            c6yA0B = this.A0j.A0B();
        }
        if (c6yA0F != c6yA0B || z7) {
            for (InterfaceC2064nM interfaceC2064nM : this.A0W) {
                A0l(interfaceC2064nM);
            }
            this.A0W = new InterfaceC2064nM[0];
            if (A0y[1].length() == 31) {
                throw new RuntimeException();
            }
            String[] strArr = A0y;
            strArr[4] = "70t8rv27mnV5UL6KHl8v284ienTbIO4o";
            strArr[3] = "4hBvGCC7ZdKRW68bijyzpqxjpy9h3CGi";
            c6yA0F = null;
        }
        if (c6yA0B != null) {
            A0g(c6yA0F);
            if (c6yA0B.A01) {
                j = c6yA0B.A07.AIO(j, z2);
                c6yA0B.A07.A5s(j - this.A0Y, this.A0r);
            }
            A0Y(j);
            A0w(this.A0G);
        } else {
            this.A0j.A0M(true);
            A0Y(j);
        }
        A0v(false);
        this.A0f.AIQ(2);
        return j;
    }

    private Pair<Object, Long> A08(Timeline timeline, int i2, long j) {
        return timeline.A0D(this.A0d, this.A0c, i2, j);
    }

    private Pair<Object, Long> A09(C6B c6b, boolean z2) {
        int iA0A;
        Timeline timeline = this.A0A.A03;
        Timeline timeline2 = c6b.A02;
        if (timeline.A0N()) {
            return null;
        }
        if (timeline2.A0N()) {
            timeline2 = timeline;
        }
        try {
            Pair<Object, Long> periodPosition = timeline2.A0E(this.A0d, this.A0c, c6b.A00, c6b.A01);
            if (timeline == timeline2 || (iA0A = timeline.A0A(periodPosition.first)) != -1) {
                return periodPosition;
            }
            if (!z2 || A0C(periodPosition.first, timeline2, timeline) == null) {
                return null;
            }
            return A08(timeline, timeline.A0H(iA0A, this.A0c).A00, -9223372036854775807L);
        } catch (IndexOutOfBoundsException unused) {
            throw new C2E(timeline, c6b.A00, c6b.A01);
        }
    }

    private C2001mL A0A() {
        Timeline timeline = this.A0A.A03;
        if (timeline.A0N()) {
            return C05416x.A0E;
        }
        return new C2001mL(timeline.A0M(timeline.A0K(timeline.A0B(this.A0V), this.A0d).A00));
    }

    @MetaExoPlayerCustomization(type = {"NEW_METHOD"}, value = "D71523094: Added for negative testing")
    private final Integer A0B() {
        C05376t playbackLatencyConfig;
        if (this.A09 == null || (playbackLatencyConfig = this.A09.A02()) == null) {
            String[] strArr = A0y;
            if (strArr[2].length() != strArr[6].length()) {
                A0y[7] = "1rqbEBrQgQNr61xUccdMybR9UEwvq3L8";
                return null;
            }
        } else {
            int iA00 = playbackLatencyConfig.A00();
            if (A0y[0].length() != 16) {
                String[] strArr2 = A0y;
                strArr2[2] = "KUZ";
                strArr2[6] = "wQAKuizVIm50S6vdz";
                return Integer.valueOf(iA00);
            }
        }
        throw new RuntimeException();
    }

    private Object A0C(Object obj, Timeline timeline, Timeline timeline2) {
        int iA0A = timeline.A0A(obj);
        int i2 = -1;
        int maxIterations = timeline.A06();
        for (int newPeriodIndex = 0; newPeriodIndex < maxIterations && i2 == -1 && (iA0A = timeline.A09(iA0A, this.A0c, this.A0d, this.A03, this.A0V)) != -1; newPeriodIndex++) {
            i2 = timeline2.A0A(timeline.A0M(iA0A));
        }
        if (i2 == -1) {
            return null;
        }
        return timeline2.A0M(i2);
    }

    private void A0E() {
        C6Y c6yA0E = this.A0j.A0E();
        if (c6yA0E == null) {
            return;
        }
        c6yA0E.A07.A4k(c6yA0E.A0D(this.A06));
    }

    private void A0G() {
        A0V(4);
        A13(false, true, false);
    }

    private void A0H() {
        int i2;
        if (this.A0h.A06(this.A0A)) {
            Handler handler = this.A0a;
            int i8 = this.A0h.A01;
            if (this.A0h.A03) {
                i2 = this.A0h.A00;
            } else {
                i2 = -1;
            }
            handler.obtainMessage(0, i8, i2, this.A0A).sendToTarget();
            this.A0h.A05(this.A0A);
        }
    }

    private void A0I() throws IOException {
        C6Y c6yA0E = this.A0j.A0E();
        C6Y readingPeriodHolder = this.A0j.A0G();
        if (c6yA0E != null && !c6yA0E.A02) {
            if (readingPeriodHolder != null) {
                C6Y loadingPeriodHolder = readingPeriodHolder.A0I();
                if (loadingPeriodHolder != c6yA0E) {
                    return;
                }
            }
            for (InterfaceC2064nM interfaceC2064nM : this.A0W) {
                if (!interfaceC2064nM.A9h()) {
                    return;
                }
            }
            c6yA0E.A07.ABt();
        }
    }

    private void A0J() throws IOException {
        this.A0j.A0L(this.A06);
        if (this.A0j.A0O()) {
            C6Z c6zA0H = this.A0j.A0H(this.A06, this.A0A);
            if (c6zA0H == null) {
                this.A0D.ABu();
                return;
            }
            this.A0j.A0J(this.A0w, this.A0t ? 60000000L : 0L, this.A0l, this.A0i.A6n(), this.A0D, c6zA0H, this.A0m).AGL(this, c6zA0H.A03);
            A0y(true);
            A0v(false);
        }
    }

    private void A0K() {
        A13(true, true, true);
        this.A0i.AEu(C05567m.A03);
        A0V(1);
        this.A0b.quit();
        synchronized (this) {
            this.A0S = true;
            notifyAll();
        }
    }

    private void A0L() throws C9Y {
        boolean z2;
        if (!this.A0j.A0N()) {
            return;
        }
        float f4 = this.A0g.A8e().A01;
        C6Y periodHolder = this.A0j.A0G();
        boolean z7 = true;
        for (C6Y c6yA0F = this.A0j.A0F(); c6yA0F != null && c6yA0F.A02; c6yA0F = c6yA0F.A0I()) {
            EL elA0L = c6yA0F.A0L(f4, this.A0A.A03);
            if (elA0L != null) {
                if (z7) {
                    C6Y c6yA0F2 = this.A0j.A0F();
                    boolean zA0S = this.A0j.A0S(c6yA0F2);
                    boolean[] zArr = new boolean[this.A0v.length];
                    long jA0G = c6yA0F2.A0G(elA0L, this.A0A.A0C, zA0S, zArr);
                    if (this.A0A.A00 != 4 && jA0G != this.A0A.A0C) {
                        this.A0A = this.A0A.A06(this.A0A.A05, jA0G, this.A0A.A01, A01());
                        this.A0h.A04(4);
                        A0Y(jA0G);
                    }
                    int i2 = 0;
                    boolean[] zArr2 = new boolean[this.A0v.length];
                    for (int i8 = 0; i8 < this.A0v.length; i8++) {
                        InterfaceC2064nM interfaceC2064nM = this.A0v[i8];
                        zArr2[i8] = interfaceC2064nM.A92() != 0;
                        InterfaceC0675Cr interfaceC0675Cr = c6yA0F2.A09[i8];
                        if (interfaceC0675Cr != null) {
                            i2++;
                        }
                        if (zArr2[i8]) {
                            InterfaceC0675Cr interfaceC0675CrA95 = interfaceC2064nM.A95();
                            if (A0y[7].charAt(12) == '2') {
                                throw new RuntimeException();
                            }
                            A0y[1] = "PyyQ9suxdi7C";
                            if (interfaceC0675Cr != interfaceC0675CrA95) {
                                A0l(interfaceC2064nM);
                            } else if (zArr[i8]) {
                                interfaceC2064nM.AI2(this.A06);
                            }
                        }
                    }
                    this.A0A = this.A0A.A07(c6yA0F2.A0J(), c6yA0F2.A0K());
                    A14(zArr2, i2);
                    z2 = false;
                } else {
                    this.A0j.A0S(c6yA0F);
                    if (c6yA0F.A02) {
                        z2 = false;
                        c6yA0F.A0F(elA0L, Math.max(c6yA0F.A00.A03, c6yA0F.A0D(this.A06)), false);
                    } else {
                        z2 = false;
                    }
                }
                A0v(true);
                if (this.A0A.A00 != 4) {
                    A0w(z2);
                    A0Q();
                    this.A0f.AIQ(2);
                    return;
                }
                return;
            }
            if (c6yA0F == periodHolder) {
                z7 = false;
            }
        }
    }

    private void A0M() {
        for (int size = this.A0p.size() - 1; size >= 0; size--) {
            if (!A16(this.A0p.get(size))) {
                this.A0p.get(size).A03.A0A(false);
                this.A0p.remove(size);
            }
        }
        Collections.sort(this.A0p);
    }

    private void A0N() throws C9Y {
        this.A0R = false;
        this.A0g.A05();
        this.A0k.A00();
        if (this.A0u) {
            this.A0o.A00();
        }
        for (InterfaceC2064nM interfaceC2064nM : this.A0W) {
            interfaceC2064nM.start();
        }
    }

    private void A0O() throws C9Y {
        this.A0g.A06();
        this.A0k.A01();
        if (this.A0u) {
            this.A0o.A01();
        }
        for (InterfaceC2064nM interfaceC2064nM : this.A0W) {
            A0m(interfaceC2064nM);
        }
    }

    private void A0Q() throws C9Y {
        if (!this.A0j.A0N()) {
            return;
        }
        C6Y c6yA0F = this.A0j.A0F();
        long jAGg = c6yA0F.A07.AGg();
        if (jAGg != -9223372036854775807L) {
            A0Y(jAGg);
            if (jAGg != this.A0A.A0C) {
                this.A0A = this.A0A.A06(this.A0A.A05, jAGg, this.A0A.A01, A01());
                this.A0h.A04(4);
            }
        } else {
            C2072nU c2072nU = this.A0g;
            C6Y playingPeriodHolder = this.A0j.A0G();
            this.A06 = c2072nU.A04(c6yA0F != playingPeriodHolder);
            long jA0D = c6yA0F.A0D(this.A06);
            A0Z(this.A0A.A0C, jA0D);
            this.A0A.A0C = jA0D;
        }
        C6Y playingPeriodHolder2 = this.A0j.A0E();
        this.A0A.A0B = playingPeriodHolder2.A09();
        this.A0A.A0D = A01();
        this.A0A.A0D = c6yA0F.A0C(this.A0A.A0C);
    }

    private void A0S(byte b8) {
        C6Y c6yA0E = this.A0j.A0E();
        if (c6yA0E != null && this.A0U) {
            c6yA0E.A07.AJq(b8);
        }
    }

    private void A0T(float f4) {
        for (C6Y c6yA0D = this.A0j.A0D(); c6yA0D != null && c6yA0D.A02; c6yA0D = c6yA0D.A0I()) {
            for (InterfaceC1964lj interfaceC1964lj : c6yA0D.A0K().A04) {
                if (interfaceC1964lj != null) {
                    interfaceC1964lj.AEc(f4);
                }
            }
        }
    }

    private void A0U(int i2) throws C9Y {
        this.A03 = i2;
        if (!this.A0j.A0P(this.A0A.A03, i2)) {
            if (A0y[0].length() == 16) {
                throw new RuntimeException();
            }
            A0y[5] = "F0pbcDG7mrKSFF2ySsjJdp1en5xQxzay";
            A0x(true);
        }
        A0v(false);
    }

    private void A0V(int i2) {
        if (this.A0A.A00 != i2) {
            this.A0A = this.A0A.A01(i2);
            if (i2 == 2) {
                this.A04 = System.currentTimeMillis();
            } else {
                this.A04 = -1L;
            }
        }
    }

    private void A0W(int i2, boolean z2) {
        if (this.A0A.A00 != i2) {
            C05416x c05416xA03 = this.A0A.A03(i2, z2);
            if (A0y[1].length() == 31) {
                throw new RuntimeException();
            }
            A0y[1] = "pTubBuiOOGTe";
            this.A0A = c05416xA03;
            if (i2 == 2) {
                this.A04 = System.currentTimeMillis();
            } else {
                this.A04 = -1L;
            }
        }
    }

    private void A0X(int i2, boolean playing, int i8) throws C9Y {
        C6Y c6yA0F = this.A0j.A0F();
        InterfaceC2064nM interfaceC2064nM = this.A0v[i2];
        this.A0W[i8] = interfaceC2064nM;
        if (interfaceC2064nM.A92() == 0) {
            C6Y c6yA0G = this.A0j.A0G();
            C6Y playingPeriodHolder = this.A0j.A0F();
            boolean z2 = c6yA0G == playingPeriodHolder;
            C7G c7g = c6yA0F.A0K().A03[i2];
            C2154or[] c2154orArrA1A = A1A(c6yA0F.A0K().A04[i2]);
            boolean z7 = this.A0P && this.A0A.A00 == 3;
            interfaceC2064nM.A6D(c7g, c2154orArrA1A, c6yA0F.A09[i2], this.A06, !playing && z7, z2, c6yA0G.A0H(this.A0K), c6yA0F.A0B());
            this.A0g.A09(interfaceC2064nM);
            if (z7) {
                interfaceC2064nM.start();
            }
        }
    }

    private void A0Y(long j) throws C9Y {
        long jA0E;
        if (this.A0j.A0N()) {
            jA0E = this.A0j.A0F().A0E(j);
        } else {
            jA0E = ((long) (this.A0t ? 60000000 : 0)) + j;
        }
        this.A06 = jA0E;
        this.A0g.A07(this.A06);
        for (InterfaceC2064nM interfaceC2064nM : this.A0W) {
            long j3 = this.A06;
            String[] strArr = A0y;
            if (strArr[2].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            A0y[5] = "3LWS1la82nevxXslk8B3HGv7gilut34u";
            interfaceC2064nM.AI2(j3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0108 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00fd A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0Z(long r8, long r10) throws com.instagram.common.viewpoint.core.C9Y {
        /*
            Method dump skipped, instruction units count: 389
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C9W.A0Z(long, long):void");
    }

    private void A0a(long j, long j3) {
        this.A0f.AHj(2);
        this.A0f.AIR(2, j + j3);
    }

    private void A0b(C2138ob c2138ob) {
        this.A0g.AIt(c2138ob);
        if (this.A0o != null) {
            this.A0o.AIt(c2138ob);
        }
        if (this.A0k != null) {
            this.A0k.AIt(c2138ob);
        }
    }

    private void A0c(AnonymousClass67 anonymousClass67) throws C9Y {
        throw new NullPointerException(A0D(376, 16, 17));
    }

    private void A0d(AnonymousClass67 anonymousClass67, boolean z2) throws C9Y {
        this.A0h.A03(1);
        throw new NullPointerException(A0D(363, 13, 127));
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0g(com.instagram.common.viewpoint.core.C6Y r10) throws com.instagram.common.viewpoint.core.C9Y {
        /*
            r9 = this;
            com.facebook.ads.redexgen.X.6c r0 = r9.A0j
            com.facebook.ads.redexgen.X.6Y r5 = r0.A0F()
            if (r5 == 0) goto La
            if (r10 != r5) goto Lb
        La:
            return
        Lb:
            r4 = 0
            com.facebook.ads.redexgen.X.nM[] r0 = r9.A0v
            int r0 = r0.length
            boolean[] r3 = new boolean[r0]
            java.lang.String[] r2 = com.instagram.common.viewpoint.core.C9W.A0y
            r0 = 4
            r1 = r2[r0]
            r0 = 3
            r2 = r2[r0]
            r0 = 1
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto La5
            java.lang.String[] r2 = com.instagram.common.viewpoint.core.C9W.A0y
            java.lang.String r1 = ""
            r0 = 0
            r2[r0] = r1
            r6 = 0
        L2c:
            com.facebook.ads.redexgen.X.nM[] r0 = r9.A0v
            int r0 = r0.length
            if (r6 >= r0) goto L91
            com.facebook.ads.redexgen.X.nM[] r0 = r9.A0v
            r7 = r0[r6]
            int r0 = r7.A92()
            if (r0 == 0) goto L8f
            r0 = 1
        L3c:
            r3[r6] = r0
            com.facebook.ads.redexgen.X.EL r0 = r5.A0K()
            boolean r0 = r0.A00(r6)
            if (r0 == 0) goto L4a
            int r4 = r4 + 1
        L4a:
            boolean r0 = r3[r6]
            if (r0 == 0) goto L85
            com.facebook.ads.redexgen.X.EL r8 = r5.A0K()
            java.lang.String[] r1 = com.instagram.common.viewpoint.core.C9W.A0y
            r0 = 5
            r1 = r1[r0]
            r0 = 1
            char r1 = r1.charAt(r0)
            r0 = 113(0x71, float:1.58E-43)
            if (r1 == r0) goto L88
            java.lang.String[] r2 = com.instagram.common.viewpoint.core.C9W.A0y
            java.lang.String r1 = "5yNp1I7g7IY9vjHrSpd0TTAHnxoP5q4N"
            r0 = 4
            r2[r0] = r1
            java.lang.String r1 = "spEmpaFlzQc3LcHeWE04rIrq6t30lchN"
            r0 = 3
            r2[r0] = r1
            boolean r0 = r8.A00(r6)
            if (r0 == 0) goto L82
        L72:
            boolean r0 = r7.AAE()
            if (r0 == 0) goto L85
            com.facebook.ads.redexgen.X.Cr r1 = r7.A95()
            com.facebook.ads.redexgen.X.Cr[] r0 = r10.A09
            r0 = r0[r6]
            if (r1 != r0) goto L85
        L82:
            r9.A0l(r7)
        L85:
            int r6 = r6 + 1
            goto L2c
        L88:
            boolean r0 = r8.A00(r6)
            if (r0 == 0) goto L82
            goto L72
        L8f:
            r0 = 0
            goto L3c
        L91:
            com.facebook.ads.redexgen.X.6x r2 = r9.A0A
            com.facebook.ads.redexgen.X.mA r1 = r5.A0J()
            com.facebook.ads.redexgen.X.EL r0 = r5.A0K()
            com.facebook.ads.redexgen.X.6x r0 = r2.A07(r1, r0)
            r9.A0A = r0
            r9.A14(r3, r4)
            return
        La5:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C9W.A0g(com.facebook.ads.redexgen.X.6Y):void");
    }

    private void A0h(AnonymousClass71 anonymousClass71) throws C9Y {
        if (anonymousClass71.A0D()) {
            return;
        }
        try {
            anonymousClass71.A05().A9a(anonymousClass71.A01(), anonymousClass71.A09());
        } finally {
            anonymousClass71.A0A(true);
        }
    }

    private void A0i(AnonymousClass71 anonymousClass71) throws C9Y {
        if (anonymousClass71.A02() == -9223372036854775807L) {
            A0j(anonymousClass71);
            return;
        }
        if (this.A0D == null || this.A02 > 0) {
            this.A0p.add(new AnonymousClass69(anonymousClass71));
            return;
        }
        AnonymousClass69 anonymousClass69 = new AnonymousClass69(anonymousClass71);
        if (A16(anonymousClass69)) {
            this.A0p.add(anonymousClass69);
            Collections.sort(this.A0p);
        } else {
            anonymousClass71.A0A(false);
        }
    }

    private void A0j(AnonymousClass71 anonymousClass71) throws C9Y {
        if (anonymousClass71.A03() == this.A0f.A8J()) {
            A0h(anonymousClass71);
            if (this.A0A.A00 == 3 || this.A0A.A00 == 2) {
                this.A0f.AIQ(2);
                return;
            }
            return;
        }
        this.A0f.ACA(15, anonymousClass71).A02();
    }

    private void A0k(final AnonymousClass71 anonymousClass71) {
        Looper looperA03 = anonymousClass71.A03();
        if (!looperA03.getThread().isAlive()) {
            Log.w(A0D(Sdk.SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE, 3, 37), A0D(258, 40, 7));
            anonymousClass71.A0A(false);
        } else {
            this.A0e.A5H(looperA03, null).A03(new Runnable() { // from class: com.facebook.ads.redexgen.X.65
                @Override // java.lang.Runnable
                public final void run() {
                    this.A00.A1E(anonymousClass71);
                }
            });
        }
    }

    private void A0l(InterfaceC2064nM interfaceC2064nM) throws C9Y {
        this.A0g.A08(interfaceC2064nM);
        A0m(interfaceC2064nM);
        interfaceC2064nM.A5p();
    }

    private void A0m(InterfaceC2064nM interfaceC2064nM) throws C9Y {
        if (interfaceC2064nM.A92() == 2) {
            interfaceC2064nM.stop();
        }
    }

    private void A0n(C7I c7i) {
        this.A0C = c7i;
    }

    private void A0o(InterfaceC2002mM interfaceC2002mM) {
        if (!this.A0j.A0T(interfaceC2002mM)) {
            return;
        }
        this.A0j.A0L(this.A06);
        A0w(false);
    }

    private void A0p(InterfaceC2002mM interfaceC2002mM) throws C9Y {
        byte b8;
        if (!this.A0j.A0T(interfaceC2002mM)) {
            return;
        }
        C6Y c6yA0E = this.A0j.A0E();
        c6yA0E.A0N(this.A0g.A8e().A01, this.A0A.A03);
        A0s(c6yA0E.A0J(), c6yA0E.A0K());
        if (!this.A0j.A0N()) {
            C6Y loadingPeriodHolder = this.A0j.A0B();
            A0Y(loadingPeriodHolder.A00.A03);
            A0g(null);
        }
        if (this.A0M || this.A0P) {
            b8 = 0;
        } else {
            b8 = 2;
        }
        A0S(b8);
        A10(this.A0P);
        if (A0y[7].charAt(12) == '2') {
            throw new RuntimeException();
        }
        A0y[5] = "0JHOWU68jltYXS7XBlXTYuPeT3LWkLA2";
        A0w(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.instagram.common.viewpoint.core.InterfaceC0678Cu
    /* JADX INFO: renamed from: A0q, reason: merged with bridge method [inline-methods] */
    public final void ACs(InterfaceC2002mM interfaceC2002mM) {
        this.A0f.ACA(10, interfaceC2002mM).A02();
    }

    private void A0r(CL cl, boolean z2, boolean z7) {
        this.A02++;
        A13(true, z2, z7);
        this.A0i.AEj(C05567m.A03);
        this.A0D = cl;
        A0V(2);
        cl.AGN(this, null);
        this.A0f.AIQ(2);
    }

    private void A0s(C1991mA c1991mA, EL el) {
        this.A0i.AFV(new C6R(C05567m.A03, this.A0A.A03, this.A0A.A04, this.A0A.A0C, A01(), this.A0g.A8e().A01, this.A0P, this.A0R, -9223372036854775807L, this.A04), c1991mA, el.A04);
    }

    @MetaExoPlayerCustomization("D18870411: Adding start stall debug reason")
    private void A0t(EnumC1730hX enumC1730hX, boolean z2) {
        if (this.A0A.A00 != 3) {
            this.A0A = this.A0A.A02(3, enumC1730hX, z2);
            this.A04 = -1L;
        }
    }

    @MetaExoPlayerCustomization(type = {"NEW_METHOD"}, value = "D63737392: Added for negative testing")
    private void A0u(String str) {
        boolean z2 = false;
        if (str == null) {
            this.A0J = false;
            this.A09 = null;
            return;
        }
        if (str != null && str.length() > 0) {
            z2 = true;
        }
        this.A0J = z2;
        this.A09 = new C05386u(str);
    }

    private void A0v(boolean z2) {
        C2001mL c2001mL;
        C6Y c6yA0E = this.A0j.A0E();
        if (c6yA0E == null) {
            C05416x c05416x = this.A0A;
            if (A0y[1].length() == 31) {
                throw new RuntimeException();
            }
            String[] strArr = A0y;
            strArr[2] = "b0w";
            strArr[6] = "WyMJg745VdMbfing6";
            c2001mL = c05416x.A05;
        } else {
            c2001mL = c6yA0E.A00.A04;
        }
        C2001mL loadingMediaPeriodId = this.A0A.A04;
        boolean loadingMediaPeriodChanged = !loadingMediaPeriodId.equals(c2001mL);
        if (loadingMediaPeriodChanged) {
            this.A0A = this.A0A.A05(c2001mL);
        }
        if ((loadingMediaPeriodChanged || z2) && c6yA0E != null && c6yA0E.A02) {
            A0s(c6yA0E.A0J(), c6yA0E.A0K());
        }
    }

    @MetaExoPlayerCustomization("Customized Buffered Duration MS D23157182")
    private void A0w(boolean z2) {
        long jA0C;
        C6Y c6yA0E = this.A0j.A0E();
        long jA0A = c6yA0E.A0A();
        if (jA0A == Long.MIN_VALUE) {
            A0y(false);
            return;
        }
        long jA0D = c6yA0E.A0D(this.A06);
        if (!this.A0s || c6yA0E == this.A0j.A0F() || this.A0j.A0F() == null) {
            jA0C = c6yA0E.A0C(jA0D);
            if (this.A0O) {
                for (C6Y c6yA0F = this.A0j.A0F(); c6yA0F != null && c6yA0F != c6yA0E; c6yA0F = c6yA0F.A0I()) {
                    long nextLoadPositionUs = this.A06;
                    jA0C += c6yA0F.A0C(c6yA0F.A0D(nextLoadPositionUs));
                }
            }
        } else {
            jA0C = A02();
        }
        Timeline timeline = this.A0A.A03;
        C2001mL c2001mL = c6yA0E.A00.A04;
        float f4 = this.A0g.A8e().A01;
        boolean z7 = this.A0P || z2;
        boolean z8 = this.A0R;
        long nextLoadPositionUs2 = this.A04;
        boolean zAJB = this.A0i.AJB(new C6R(null, timeline, c2001mL, jA0D, jA0C, f4, z7, z8, -9223372036854775807L, nextLoadPositionUs2));
        if (this.A0T && this.A0P && this.A0R && !zAJB && this.A0A.A00 == 2) {
            Long lValueOf = Long.valueOf(jA0D / 1000);
            Long lValueOf2 = Long.valueOf(jA0C / 1000);
            Long lValueOf3 = Long.valueOf(jA0A / 1000);
            String[] strArr = A0y;
            if (strArr[4].charAt(1) == strArr[3].charAt(1)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0y;
            strArr2[2] = "Frr";
            strArr2[6] = "mfKzHFhLmxUYLc6Gx";
            this.A0a.obtainMessage(5, AbstractC04664a.A0n(A0D(Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE, 70, 5), lValueOf, lValueOf2, lValueOf3)).sendToTarget();
            this.A0T = false;
        }
        A0y(zAJB);
        if (zAJB) {
            c6yA0E.A0O(this.A06);
        }
    }

    private void A0x(boolean z2) throws C9Y {
        C2001mL c2001mL = this.A0j.A0F().A00.A04;
        long jA07 = A07(false, c2001mL, this.A0A.A0C, true);
        if (jA07 != this.A0A.A0C) {
            this.A0A = this.A0A.A06(c2001mL, jA07, this.A0A.A01, A01());
            if (z2) {
                C6A c6a = this.A0h;
                String[] strArr = A0y;
                if (strArr[4].charAt(1) == strArr[3].charAt(1)) {
                    throw new RuntimeException();
                }
                A0y[5] = "dnthUoDEzHvBWSE2tp3YAJwgKJx1FOWZ";
                c6a.A04(4);
            }
        }
    }

    private void A0y(boolean z2) {
        if (this.A0A.A0A != z2) {
            this.A0A = this.A0A.A08(z2);
        }
    }

    private void A0z(boolean z2) throws C9Y {
        try {
            this.A0R = false;
            this.A0P = z2;
            A10(z2);
            if (!z2) {
                A0O();
                A0Q();
                A0S((byte) 2);
                if (this.A0I) {
                    A0E();
                }
            } else {
                A0S((byte) 0);
                if (this.A0A.A00 != 3) {
                    if (this.A0A.A00 == 2) {
                        this.A0f.AIQ(2);
                    }
                } else {
                    A0N();
                    this.A0f.AIQ(2);
                }
            }
        } finally {
            this.A0a.obtainMessage(3, Boolean.valueOf(z2)).sendToTarget();
        }
    }

    @MetaExoPlayerCustomization("D19875605 Prevent further error loading once pausing video")
    private void A10(boolean z2) {
        C6Y loadingPeriod = this.A0j.A0E();
        if (loadingPeriod == null) {
            return;
        }
        loadingPeriod.A07.AIs(z2);
    }

    private void A11(boolean z2) throws C9Y {
        this.A0V = z2;
        if (!this.A0j.A0R(this.A0A.A03, z2)) {
            A0x(true);
        }
        A0v(false);
    }

    private void A12(boolean z2, boolean z7) {
        A13(true, z2, z2);
        this.A0h.A03(this.A02 + (z7 ? 1 : 0));
        this.A02 = 0;
        this.A0i.AFN(C05567m.A03);
        A0V(1);
    }

    private void A13(boolean z2, boolean z7, boolean z8) {
        long j;
        C1991mA c1991mA;
        EL el;
        this.A0f.AHj(2);
        this.A0R = false;
        this.A0g.A06();
        this.A0k.A01();
        if (this.A0u) {
            this.A0o.A01();
        }
        this.A06 = this.A0t ? 60000000L : 0L;
        for (InterfaceC2064nM interfaceC2064nM : this.A0W) {
            try {
                A0l(interfaceC2064nM);
            } catch (C9Y | RuntimeException e) {
                Log.e(A0D(0, 21, 22), A0D(Sdk.SDKError.Reason.INVALID_BID_PAYLOAD_VALUE, 12, 44), e);
            }
        }
        this.A0W = new InterfaceC2064nM[0];
        this.A0j.A0M(!z7);
        A0y(false);
        if (z7) {
            this.A08 = null;
        }
        if (z8) {
            Iterator<AnonymousClass69> it = this.A0p.iterator();
            while (it.hasNext()) {
                it.next().A03.A0A(false);
            }
            this.A0p.clear();
            this.A01 = 0;
        }
        C2001mL c2001mLA0A = z7 ? A0A() : this.A0A.A05;
        long j3 = -9223372036854775807L;
        if (z7) {
            j = -9223372036854775807L;
        } else {
            C05416x c05416x = this.A0A;
            if (A0y[5].charAt(1) != 'q') {
                String[] strArr = A0y;
                strArr[4] = "7gx390g1msf1u5QKnR2KjvR4WQmRx8YK";
                strArr[3] = "VlC7tbQkEF507tv73u1W2v85d7ApXXNM";
                j = c05416x.A0C;
            } else {
                A0y[5] = "C79IK8sPJjEkg2u4SoGimfUAaE3F5yew";
                j = c05416x.A0C;
            }
        }
        if (!z7) {
            C05416x c05416x2 = this.A0A;
            if (A0y[5].charAt(1) == 'q') {
                throw new RuntimeException();
            }
            String[] strArr2 = A0y;
            strArr2[2] = "uSR";
            strArr2[6] = "FwoZ6mA9qzJ4hrvJt";
            j3 = c05416x2.A01;
        }
        Timeline timeline = z8 ? Timeline.A02 : this.A0A.A03;
        int i2 = this.A0A.A00;
        if (z8) {
            c1991mA = C1991mA.A06;
        } else {
            C05416x c05416x3 = this.A0A;
            if (A0y[7].charAt(12) == '2') {
                throw new RuntimeException();
            }
            A0y[5] = "yizxhFEcEwEbIh7DB6ScCbr86G64zHmf";
            c1991mA = c05416x3.A06;
        }
        if (z8) {
            el = this.A0m;
        } else {
            el = this.A0A.A07;
        }
        this.A0A = new C05416x(timeline, c2001mLA0A, j, j3, i2, false, c1991mA, el, c2001mLA0A, j, 0L, j);
        if (z2 && this.A0D != null) {
            this.A0D.AH1(this);
            this.A0D = null;
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x000f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A14(boolean[] r6, int r7) throws com.instagram.common.viewpoint.core.C9Y {
        /*
            r5 = this;
            com.facebook.ads.redexgen.X.nM[] r0 = new com.instagram.common.viewpoint.core.InterfaceC2064nM[r7]
            r5.A0W = r0
            r4 = 0
            com.facebook.ads.redexgen.X.6c r0 = r5.A0j
            com.facebook.ads.redexgen.X.6Y r3 = r0.A0F()
            r2 = 0
        Lc:
            com.facebook.ads.redexgen.X.nM[] r0 = r5.A0v
            int r0 = r0.length
            if (r2 >= r0) goto L26
            com.facebook.ads.redexgen.X.EL r0 = r3.A0K()
            boolean r0 = r0.A00(r2)
            if (r0 == 0) goto L23
            boolean r1 = r6[r2]
            int r0 = r4 + 1
            r5.A0X(r2, r1, r4)
            r4 = r0
        L23:
            int r2 = r2 + 1
            goto Lc
        L26:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C9W.A14(boolean[], int):void");
    }

    private boolean A15() {
        C6Y playingPeriodHolder = this.A0j.A0F();
        C6Y c6yA0I = playingPeriodHolder.A0I();
        long j = playingPeriodHolder.A00.A00;
        return j == -9223372036854775807L || this.A0A.A0C < j || (c6yA0I != null && (c6yA0I.A02 || c6yA0I.A00.A04.A00()));
    }

    private boolean A16(AnonymousClass69 anonymousClass69) {
        if (anonymousClass69.A02 == null) {
            Pair<Object, Long> pairA09 = A09(new C6B(anonymousClass69.A03.A04(), anonymousClass69.A03.A00(), AbstractC04121w.A00(anonymousClass69.A03.A02())), false);
            if (pairA09 == null) {
                return false;
            }
            int iA0A = this.A0A.A03.A0A(pairA09.first);
            if (A0y[5].charAt(1) != 'q') {
                A0y[5] = "NfGCtpMsHKBVYsn3O7a8Zqq9gxyOlhFa";
                anonymousClass69.A01(iA0A, ((Long) pairA09.second).longValue(), pairA09.first);
                return true;
            }
            throw new RuntimeException();
        }
        int iA0A2 = this.A0A.A03.A0A(anonymousClass69.A02);
        if (iA0A2 == -1) {
            return false;
        }
        anonymousClass69.A00 = iA0A2;
        return true;
    }

    private boolean A17(InterfaceC2064nM interfaceC2064nM) {
        C6Y c6yA0G = this.A0j.A0G();
        C6Y readingPeriodHolder = c6yA0G.A0I();
        if (readingPeriodHolder != null) {
            C6Y readingPeriodHolder2 = c6yA0G.A0I();
            if (readingPeriodHolder2.A02 && interfaceC2064nM.A9h()) {
                return true;
            }
        }
        return false;
    }

    private boolean A18(C2001mL c2001mL, long j, C6Y c6y) {
        if (!c2001mL.equals(c6y.A00.A04)) {
            return false;
        }
        boolean z2 = c6y.A02;
        if (A0y[1].length() == 31) {
            throw new RuntimeException();
        }
        A0y[1] = "z9";
        if (z2) {
            this.A0A.A03.A0J(this.A0A.A05.A04, this.A0c);
            int iA07 = this.A0c.A07(j);
            if (iA07 != -1) {
                long jA0D = this.A0c.A0D(iA07);
                C6Z c6z = c6y.A00;
                if (A0y[5].charAt(1) == 'q') {
                    A0y[5] = "RcBDfVPYXZ1IWswHj8kiKJAUw6BsFYM7";
                    if (jA0D == c6z.A01) {
                        return true;
                    }
                    return false;
                }
                String[] strArr = A0y;
                strArr[4] = "w6QknFDGuvwfcqywG7nwGfdAAoNokq6y";
                strArr[3] = "I5j8Ais0ITqpKL2oROmKoI7QN1W2GqI7";
                if (jA0D == c6z.A01) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00b4  */
    @com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomizations({@com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization("Customized Buffered Duration MS D23157182"), @com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization("D18870411: Adding start stall debug reason")})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A19(boolean r19) {
        /*
            r18 = this;
            r3 = r18
            com.facebook.ads.redexgen.X.nM[] r0 = r3.A0W
            int r0 = r0.length
            if (r0 != 0) goto Lc
            boolean r0 = r18.A15()
            return r0
        Lc:
            r9 = 0
            if (r19 != 0) goto L1c
            com.facebook.ads.redexgen.X.nM r0 = r3.A0B
            if (r0 == 0) goto L1b
            com.facebook.ads.redexgen.X.nM r0 = r3.A0B
            com.facebook.ads.redexgen.X.hX r0 = r0.A91()
            r3.A0E = r0
        L1b:
            return r9
        L1c:
            com.facebook.ads.redexgen.X.6x r0 = r3.A0A
            boolean r1 = r0.A0A
            r0 = 1
            if (r1 != 0) goto L24
            return r0
        L24:
            com.facebook.ads.redexgen.X.6c r0 = r3.A0j
            com.facebook.ads.redexgen.X.6Y r4 = r0.A0E()
            boolean r0 = r4.A0R()
            if (r0 == 0) goto Lb4
            com.facebook.ads.redexgen.X.6Z r5 = r4.A00
            java.lang.String[] r1 = com.instagram.common.viewpoint.core.C9W.A0y
            r0 = 7
            r1 = r1[r0]
            r0 = 12
            char r1 = r1.charAt(r0)
            r0 = 50
            if (r1 == r0) goto Lb6
            java.lang.String[] r2 = com.instagram.common.viewpoint.core.C9W.A0y
            java.lang.String r1 = "JVFQROlQoWGuZTJ8G1Kf7NjovTqMHrup"
            r0 = 5
            r2[r0] = r1
            boolean r0 = r5.A05
            if (r0 == 0) goto Lb4
            r8 = 1
        L4d:
            boolean r0 = r3.A0s
            if (r0 == 0) goto L67
            com.facebook.ads.redexgen.X.6c r0 = r3.A0j
            com.facebook.ads.redexgen.X.6Y r1 = r0.A0F()
            com.facebook.ads.redexgen.X.6c r0 = r3.A0j
            com.facebook.ads.redexgen.X.6Y r0 = r0.A0E()
            if (r1 == r0) goto L67
            com.facebook.ads.redexgen.X.6c r0 = r3.A0j
            com.facebook.ads.redexgen.X.6Y r0 = r0.A0F()
            if (r0 != 0) goto Laf
        L67:
            long r0 = r3.A06
            long r0 = r4.A0D(r0)
            long r11 = r4.A0C(r0)
        L71:
            long r6 = java.lang.System.currentTimeMillis()
            int r0 = r3.A00
            if (r0 <= 0) goto Lad
            long r4 = r3.A04
            r1 = 0
            int r0 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r0 <= 0) goto Lad
            long r0 = r3.A04
            long r6 = r6 - r0
            int r0 = r3.A00
            long r1 = (long) r0
            int r0 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r0 >= 0) goto Lad
            r15 = 1
        L8c:
            if (r8 != 0) goto La5
            com.facebook.ads.redexgen.X.6S r10 = r3.A0i
            com.facebook.ads.redexgen.X.nU r0 = r3.A0g
            com.facebook.ads.redexgen.X.ob r0 = r0.A8e()
            float r13 = r0.A01
            boolean r14 = r3.A0R
            r16 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            boolean r0 = r10.AJE(r11, r13, r14, r15, r16)
            if (r0 == 0) goto La6
        La5:
            r9 = 1
        La6:
            if (r9 != 0) goto Lac
            com.facebook.ads.redexgen.X.hX r0 = com.instagram.common.viewpoint.core.EnumC1730hX.A04
            r3.A0E = r0
        Lac:
            return r9
        Lad:
            r15 = 0
            goto L8c
        Laf:
            long r11 = r18.A03()
            goto L71
        Lb4:
            r8 = 0
            goto L4d
        Lb6:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C9W.A19(boolean):boolean");
    }

    public static C2154or[] A1A(EE ee) {
        int length = ee != null ? ee.length() : 0;
        C2154or[] c2154orArr = new C2154or[length];
        for (int i2 = 0; i2 < length; i2++) {
            c2154orArr[i2] = ee.A83(i2);
        }
        return c2154orArr;
    }

    public final Looper A1B() {
        return this.A0b.getLooper();
    }

    /* JADX WARN: Incorrect condition in loop: B:9:0x0010 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void A1C() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.A0S     // Catch: java.lang.Throwable -> L23
            if (r0 == 0) goto L7
            monitor-exit(r2)
            return
        L7:
            com.facebook.ads.redexgen.X.3v r1 = r2.A0f     // Catch: java.lang.Throwable -> L23
            r0 = 7
            r1.AIQ(r0)     // Catch: java.lang.Throwable -> L23
            r1 = 0
        Le:
            boolean r0 = r2.A0S     // Catch: java.lang.Throwable -> L23
            if (r0 != 0) goto L18
            r2.wait()     // Catch: java.lang.InterruptedException -> L16 java.lang.Throwable -> L23
            goto Le
        L16:
            r1 = 1
            goto Le
        L18:
            if (r1 == 0) goto L21
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L23
            r0.interrupt()     // Catch: java.lang.Throwable -> L23
        L21:
            monitor-exit(r2)
            return
        L23:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C9W.A1C():void");
    }

    public final void A1D(Timeline timeline, int i2, long j) {
        this.A0f.ACA(3, new C6B(timeline, i2, j)).A02();
    }

    public final /* synthetic */ void A1E(AnonymousClass71 anonymousClass71) {
        try {
            A0h(anonymousClass71);
        } catch (C9Y e) {
            Log.e(A0D(0, 21, 22), A0D(298, 55, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE), e);
            throw new RuntimeException(e);
        }
    }

    public final void A1F(CL cl, boolean z2, boolean z7) {
        this.A0f.AC9(0, z2 ? 1 : 0, z7 ? 1 : 0, cl).A02();
    }

    public final void A1G(boolean z2) {
        this.A0f.AC8(1, z2 ? 1 : 0, 0).A02();
    }

    public final void A1H(boolean z2) {
        this.A0f.AC8(6, z2 ? 1 : 0, 0).A02();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC05055n
    public final void AEb(C2138ob c2138ob) {
        this.A0a.obtainMessage(1, c2138ob).sendToTarget();
        A0T(c2138ob.A01);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2003mN
    public final void AEk(InterfaceC2002mM interfaceC2002mM) {
        this.A0f.ACA(9, interfaceC2002mM).A02();
    }

    @Override // com.instagram.common.viewpoint.core.CK
    public final void AFI(CL cl, Timeline timeline) {
        this.A0f.ACA(8, new AnonymousClass68(cl, timeline)).A02();
    }

    @Override // com.instagram.common.viewpoint.core.EJ
    public final void AFT() {
        this.A0f.AIQ(11);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC05436z
    public final synchronized void AIS(AnonymousClass71 anonymousClass71) {
        if (this.A0S) {
            Log.w(A0D(0, 21, 22), A0D(50, 37, 39));
            anonymousClass71.A0A(false);
        } else {
            this.A0f.ACA(14, anonymousClass71).A02();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) throws Throwable {
        String strA0D = A0D(0, 21, 22);
        try {
        } catch (C9Y e) {
            Log.e(strA0D, A0D(110, 15, 65), e);
            A12(false, false);
            this.A0a.obtainMessage(2, e).sendToTarget();
            A0H();
        } catch (IOException e4) {
            Log.e(strA0D, A0D(195, 13, 40), e4);
            A12(false, false);
            this.A0a.obtainMessage(2, C9Y.A01(e4, 2000)).sendToTarget();
            A0H();
        } catch (RuntimeException e8) {
            Log.e(strA0D, A0D(87, 23, 19), e8);
            A12(false, false);
            this.A0a.obtainMessage(2, C9Y.A02(e8)).sendToTarget();
            A0H();
        }
        switch (message.what) {
            case 0:
                A0r((CL) message.obj, message.arg1 != 0, message.arg2 != 0);
                A0H();
                return true;
            case 1:
                A0z(message.arg1 != 0);
                A0H();
                return true;
            case 2:
                A0F();
                A0H();
                return true;
            case 3:
                A0f((C6B) message.obj);
                A0H();
                return true;
            case 4:
                A0b((C2138ob) message.obj);
                A0H();
                return true;
            case 5:
                A0n((C7I) message.obj);
                A0H();
                return true;
            case 6:
                A12(message.arg1 != 0, true);
                A0H();
                return true;
            case 7:
                A0K();
                return true;
            case 8:
                A0e((AnonymousClass68) message.obj);
                A0H();
                return true;
            case 9:
                A0p((InterfaceC2002mM) message.obj);
                A0H();
                return true;
            case 10:
                A0o((InterfaceC2002mM) message.obj);
                A0H();
                return true;
            case 11:
                A0L();
                A0H();
                return true;
            case 12:
                A0U(message.arg1);
                A0H();
                return true;
            case 13:
                A11(message.arg1 != 0);
                A0H();
                return true;
            case 14:
                A0i((AnonymousClass71) message.obj);
                A0H();
                return true;
            case 15:
                A0k((AnonymousClass71) message.obj);
                A0H();
                return true;
            case 16:
                A0H();
                return true;
            case 17:
                A0d(null, false);
                throw null;
            case 18:
                A0c(null);
                throw null;
            case 19:
                A0u((String) message.obj);
                A0H();
                return true;
            default:
                return false;
        }
    }
}
