package com.instagram.common.viewpoint.core;

import android.net.Uri;
import android.util.Log;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7S, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C7S implements InterfaceC2089nl {
    public static byte[] A0M;
    public static String[] A0N = {"gtbAICrdQ5OiLd8QtlGJkysA4GOuQAyl", "NB4BeTTq5ijHDPStUBIG2cd4hjVw3Rms", "uuMr3aWTfRr6VJnGuPPVK2CIrmsp3XMP", "Eb6am5ksZvZ5Hz0HFQHbX0NWivmHdCO7", "qnDH", "QayiUw4ouBPhcoxDO7fR8OixzHh3DuJf", "V84YazX1IDZHbq2m95FMlzDl0u9g04ST", "S22pIk311xlkEmMZRooVtOw4dNPxaWRF"};
    public long A00;
    public long A01;
    public long A02;
    public long A03;
    public long A04;
    public Uri A05;
    public InterfaceC2089nl A06;
    public AnonymousClass56 A07;
    public AnonymousClass56 A08;

    @MetaExoPlayerCustomization
    public C0900Lj A09;
    public C0914Lx A0A;
    public boolean A0B;
    public boolean A0C;
    public final InterfaceC2089nl A0D;
    public final InterfaceC2089nl A0E;
    public final InterfaceC2089nl A0F;
    public final InterfaceC0904Ln A0G;
    public final InterfaceC0907Lq A0H;
    public final InterfaceC0913Lw A0I;
    public final boolean A0J;
    public final boolean A0K;
    public final boolean A0L;

    public static String A02(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0M, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            byte b8 = bArrCopyOfRange[i10];
            if (A0N[4].length() == 12) {
                throw new RuntimeException();
            }
            A0N[4] = "VXYuEglycDYgl";
            bArrCopyOfRange[i10] = (byte) ((b8 ^ i9) ^ 28);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A0M = new byte[]{25, 59, 57, 50, 63, 30, 59, 46, 59, 9, 53, 47, 40, 57, 63, 22, 58, 32, 57, 49, 59, 114, 33, 117, 32, 37, 49, 52, 33, 48, 117, 39, 48, 49, 60, 39, 48, 54, 33, 48, 49, 117, 0, 7, 28, 123, 117, 1, 61, 60, 38, 117, 56, 60, 50, 61, 33, 117, 54, 52, 32, 38, 48, 117, 39, 48, 57, 52, 33, 60, 35, 48, 117, 0, 7, 28, 38, 117, 50, 48, 33, 117, 39, 48, 38, 58, 57, 35, 48, 49, 117, 60, 59, 54, 58, 39, 39, 48, 54, 33, 57, 44, 123, 95, 94, 115, 81, 83, 88, 85, 84, 114, 73, 68, 85, 67, 98, 85, 81, 84};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 15 out of bounds for length 13
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.restartVar(DebugInfoParser.java:193)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:141)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    @Override // com.instagram.common.viewpoint.core.InterfaceC2089nl
    @MetaExoPlayerCustomization("usage of fbDataSpecExtension and the check for isInitSegment")
    public final long AFy(AnonymousClass56 anonymousClass56) throws IOException {
        try {
            String strA4d = this.A0I.A4d(anonymousClass56);
            AnonymousClass56 anonymousClass56A09 = anonymousClass56.A04().A08(strA4d).A09();
            this.A08 = anonymousClass56A09;
            this.A05 = A01(this.A0G, strA4d, anonymousClass56A09.A06);
            this.A03 = anonymousClass56.A04;
            this.A09 = new C0900Lj(anonymousClass56.A07);
            this.A0B = A00(anonymousClass56) != -1;
            boolean z2 = this.A0B;
            if (this.A0B) {
                this.A00 = -1L;
            } else {
                this.A00 = M7.A00(this.A0G.A7K(strA4d));
                if (this.A00 != -1) {
                    this.A00 -= anonymousClass56.A04;
                    if (this.A00 < 0) {
                        throw new C04914z(2008);
                    }
                }
            }
            boolean z7 = anonymousClass56.A07.A08 <= 0 && anonymousClass56.A07.A07 <= 0;
            if (anonymousClass56.A03 != -1) {
                this.A00 = this.A00 == -1 ? anonymousClass56.A03 : Math.min(this.A00, anonymousClass56.A03);
            }
            if (this.A00 > 0 || this.A00 == -1) {
                A06(anonymousClass56A09, false, z7);
            }
            return anonymousClass56.A03 != -1 ? anonymousClass56.A03 : this.A00;
        } catch (Throwable th) {
            A09(th);
            throw th;
        }
    }

    static {
        A05();
    }

    public C7S(InterfaceC0904Ln interfaceC0904Ln, final InterfaceC2089nl interfaceC2089nl, InterfaceC2089nl interfaceC2089nl2, final InterfaceC04864u interfaceC04864u, InterfaceC0913Lw interfaceC0913Lw, int i2, final AnonymousClass31 anonymousClass31, final int i8, InterfaceC0907Lq interfaceC0907Lq) {
        this.A0G = interfaceC0904Ln;
        this.A0D = interfaceC2089nl2;
        this.A0I = interfaceC0913Lw == null ? InterfaceC0913Lw.A00 : interfaceC0913Lw;
        this.A0J = (i2 & 1) != 0;
        this.A0L = (i2 & 2) != 0;
        this.A0K = (i2 & 4) != 0;
        if (interfaceC2089nl != null) {
            interfaceC2089nl = anonymousClass31 != null ? new InterfaceC2089nl(interfaceC2089nl, anonymousClass31, i8) { // from class: com.facebook.ads.redexgen.X.9c
                public static byte[] A03;
                public final int A00;
                public final AnonymousClass31 A01;
                public final InterfaceC2089nl A02;

                static {
                    A01();
                }

                public static String A00(int i9, int i10, int i11) {
                    byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i9, i9 + i10);
                    for (int i12 = 0; i12 < bArrCopyOfRange.length; i12++) {
                        bArrCopyOfRange[i12] = (byte) ((bArrCopyOfRange[i12] - i11) - 41);
                    }
                    return new String(bArrCopyOfRange);
                }

                public static void A01() {
                    A03 = new byte[]{1, 3, 0, -12, -10, -10, -11, -32, 3, -27, -7, 3, 0, 8};
                }

                {
                    this.A02 = (InterfaceC2089nl) C3M.A01(interfaceC2089nl);
                    C3M.A01(anonymousClass31);
                    this.A01 = null;
                    this.A00 = i8;
                }

                @Override // com.instagram.common.viewpoint.core.InterfaceC2089nl
                public final void A3v(C5H c5h) {
                    C3M.A01(c5h);
                    this.A02.A3v(c5h);
                }

                @Override // com.instagram.common.viewpoint.core.InterfaceC2089nl
                public final Map<String, List<String>> A8l() {
                    return this.A02.A8l();
                }

                @Override // com.instagram.common.viewpoint.core.InterfaceC2089nl
                public final Uri A9H() {
                    return this.A02.A9H();
                }

                @Override // com.instagram.common.viewpoint.core.InterfaceC2089nl
                public final long AFy(AnonymousClass56 anonymousClass56) throws IOException {
                    throw new NullPointerException(A00(0, 14, 104));
                }

                @Override // com.instagram.common.viewpoint.core.InterfaceC2089nl
                public final void close() throws IOException {
                    this.A02.close();
                }

                @Override // com.instagram.common.viewpoint.core.AnonymousClass20
                public final int read(byte[] bArr, int i9, int i10) throws IOException {
                    throw new NullPointerException(A00(0, 14, 104));
                }
            } : interfaceC2089nl;
            this.A0F = interfaceC2089nl;
            this.A0E = interfaceC04864u != null ? new InterfaceC2089nl(interfaceC2089nl, interfaceC04864u) { // from class: com.facebook.ads.redexgen.X.9a
                public static String[] A04 = {"wbGAhFLyG1O1BXRQkdAsuvRwjcG0JvdY", "WIGHUXkmdMwjKtYrGQHAEajnCcLVhsJc", "71g9TI5vzncmEyYDsqHRZQ5IIDSVhuCU", "Of7gEliA8dohBLU5UePsnNPr9luYUKIX", "Ip7oB5coOYYSe2wQ3nHh7WYhGK", "mFyxGR7YA7Uh54mquru9LT9AFg", "iYrL5ZFnNwboLBDSkDK7D5rnh7HwI2GN", "DEMvAgZEfGNSxO1Scy7Mz579azioI4xU"};
                public long A00;
                public boolean A01;
                public final InterfaceC04864u A02;
                public final InterfaceC2089nl A03;

                {
                    this.A03 = (InterfaceC2089nl) C3M.A01(interfaceC2089nl);
                    this.A02 = (InterfaceC04864u) C3M.A01(interfaceC04864u);
                }

                @Override // com.instagram.common.viewpoint.core.InterfaceC2089nl
                public final void A3v(C5H c5h) {
                    C3M.A01(c5h);
                    this.A03.A3v(c5h);
                }

                @Override // com.instagram.common.viewpoint.core.InterfaceC2089nl
                public final Map<String, List<String>> A8l() {
                    return this.A03.A8l();
                }

                @Override // com.instagram.common.viewpoint.core.InterfaceC2089nl
                public final Uri A9H() {
                    return this.A03.A9H();
                }

                @Override // com.instagram.common.viewpoint.core.InterfaceC2089nl
                public final long AFy(AnonymousClass56 anonymousClass56) throws IOException {
                    this.A00 = this.A03.AFy(anonymousClass56);
                    if (this.A00 == 0) {
                        return 0L;
                    }
                    long j = anonymousClass56.A03;
                    String[] strArr = A04;
                    if (strArr[4].length() != strArr[5].length()) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A04;
                    strArr2[2] = "8JYiy7Q3QOgUU9IJtNo1oEeVZYLkhQA2";
                    strArr2[1] = "C3hXJiAszWGMEEgz1C8EzdfpsF4hhGij";
                    if (j == -1 && this.A00 != -1) {
                        anonymousClass56 = anonymousClass56.A05(0L, this.A00);
                    }
                    this.A01 = true;
                    this.A02.AG0(anonymousClass56);
                    return this.A00;
                }

                @Override // com.instagram.common.viewpoint.core.InterfaceC2089nl
                public final void close() throws IOException {
                    try {
                        this.A03.close();
                    } finally {
                        if (this.A01) {
                            this.A01 = false;
                            this.A02.close();
                        }
                    }
                }

                @Override // com.instagram.common.viewpoint.core.AnonymousClass20
                public final int read(byte[] bArr, int i9, int i10) throws IOException {
                    if (this.A00 != 0) {
                        int i11 = this.A03.read(bArr, i9, i10);
                        if (i11 > 0) {
                            this.A02.write(bArr, i9, i11);
                            if (this.A00 != -1) {
                                this.A00 -= (long) i11;
                            }
                        }
                        return i11;
                    }
                    String[] strArr = A04;
                    if (strArr[4].length() != strArr[5].length()) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A04;
                    strArr2[0] = "tTmOA5hODgmGBNxF0mS11dvWTNwifcB6";
                    strArr2[3] = "mpSZqupnUd3dBB1VIyplsxMvqiIWybTS";
                    return -1;
                }
            } : null;
        } else {
            this.A0F = C05869d.A02;
            this.A0E = null;
        }
        this.A0H = interfaceC0907Lq;
    }

    private int A00(AnonymousClass56 anonymousClass56) {
        if (this.A0L && this.A0C) {
            return 0;
        }
        if (this.A0K && anonymousClass56.A03 == -1) {
            return 1;
        }
        return -1;
    }

    public static Uri A01(InterfaceC0904Ln interfaceC0904Ln, String str, Uri redirectedUri) {
        Uri redirectedUri2 = M7.A01(interfaceC0904Ln.A7K(str));
        return redirectedUri2 != null ? redirectedUri2 : redirectedUri;
    }

    private void A03() throws IOException {
        if (this.A06 == null) {
            return;
        }
        try {
            this.A06.close();
            this.A07 = null;
            this.A06 = null;
            if (A0N[5].charAt(3) == 'i') {
                String[] strArr = A0N;
                strArr[2] = "vHGwoIowQcJHPzt2zHibHrQYTuNv4ZzT";
                strArr[1] = "k7MJrtNgTHKuOTKhmFADSg5K1rHaIFar";
                if (this.A0A != null) {
                    InterfaceC0904Ln interfaceC0904Ln = this.A0G;
                    if (A0N[6].charAt(29) == '4') {
                        String[] strArr2 = A0N;
                        strArr2[2] = "npCyc8crYVBLSlKGvChDlZdzdxvHOR7S";
                        strArr2[1] = "yWpl1AKn1flVHx0rOJ2JJIdMQnxjFkRn";
                        interfaceC0904Ln.AGw(this.A0A);
                        this.A0A = null;
                        return;
                    }
                } else {
                    return;
                }
            }
            throw new RuntimeException();
        } catch (Throwable th) {
            this.A07 = null;
            this.A06 = null;
            if (this.A0A != null) {
                this.A0G.AGw(this.A0A);
                this.A0A = null;
            }
            throw th;
        }
    }

    private void A04() {
        if (0 != 0 && this.A04 > 0) {
            this.A0G.A72();
            throw new NullPointerException(A02(103, 17, 44));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00cb  */
    @com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization("Parameter isInitSegment and all ot is usages. Setting mFbDataSpecExtension in nextDataSpec. Call to maybeUpdateRedirectedUriMetadata at the end")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A06(com.instagram.common.viewpoint.core.AnonymousClass56 r22, boolean r23, boolean r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 555
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C7S.A06(com.facebook.ads.redexgen.X.56, boolean, boolean):void");
    }

    private void A07(String str) throws IOException {
        this.A00 = 0L;
        if (A0D()) {
            M9 m9 = new M9();
            M9.A00(m9, this.A03);
            this.A0G.A46(str, m9);
        }
    }

    @MetaExoPlayerCustomization
    private void A08(String str, Uri uri) {
        if (!A0D()) {
            return;
        }
        M9 m9 = new M9();
        if (!uri.equals(this.A05)) {
            Uri uri2 = this.A05;
            if (A0N[6].charAt(29) != '4') {
                throw new RuntimeException();
            }
            String[] strArr = A0N;
            strArr[0] = "HwBuIJEC6JIKumxqgSDJ0pUKIwQFYzQv";
            strArr[7] = "1FgFIXgVQckXZ73NbznNhujKeCbi6Slt";
            M9.A01(m9, uri2);
        } else {
            M9.A01(m9, null);
        }
        try {
            this.A0G.A46(str, m9);
        } catch (C0901Lk e) {
            String message = A02(15, 88, 73);
            Log.w(A02(0, 15, 70), message, e);
        }
    }

    private void A09(Throwable th) {
        if (A0B() || (th instanceof C0901Lk)) {
            this.A0C = true;
        }
    }

    private boolean A0A() {
        return this.A06 == this.A0F;
    }

    private boolean A0B() {
        return this.A06 == this.A0D;
    }

    private boolean A0C() {
        return !A0B();
    }

    private boolean A0D() {
        return this.A06 == this.A0E;
    }

    public final InterfaceC0904Ln A0E() {
        return this.A0G;
    }

    public final InterfaceC0913Lw A0F() {
        return this.A0I;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2089nl
    public final void A3v(C5H c5h) {
        C3M.A01(c5h);
        this.A0D.A3v(c5h);
        this.A0F.A3v(c5h);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2089nl
    public final Map<String, List<String>> A8l() {
        if (A0C()) {
            return this.A0F.A8l();
        }
        return Collections.emptyMap();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2089nl
    public final Uri A9H() {
        return this.A05;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2089nl
    public final void close() throws IOException {
        this.A08 = null;
        this.A05 = null;
        this.A03 = 0L;
        A04();
        try {
            A03();
        } catch (Throwable e) {
            A09(e);
            throw e;
        }
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass20
    public final int read(byte[] bArr, int i2, int i8) throws Throwable {
        if (i8 == 0) {
            return 0;
        }
        if (this.A00 == 0) {
            return -1;
        }
        AnonymousClass56 currentDataSpec = (AnonymousClass56) C3M.A01(this.A08);
        AnonymousClass56 anonymousClass56 = (AnonymousClass56) C3M.A01(this.A07);
        try {
            if (this.A03 >= this.A01) {
                A06(currentDataSpec, true, false);
            }
        } catch (Throwable th) {
            e = th;
        }
        try {
            int bytesRead = ((InterfaceC2089nl) C3M.A01(this.A06)).read(bArr, i2, i8);
            if (bytesRead != -1) {
                if (A0B()) {
                    this.A04 += (long) bytesRead;
                }
                this.A03 += (long) bytesRead;
                this.A02 += (long) bytesRead;
                if (this.A00 != -1) {
                    this.A00 -= (long) bytesRead;
                }
            } else if (A0C() && (anonymousClass56.A03 == -1 || this.A02 < anonymousClass56.A03)) {
                A07((String) AbstractC04664a.A0f(currentDataSpec.A08));
            } else if (this.A00 > 0 || this.A00 == -1) {
                A03();
                A06(currentDataSpec, false, false);
                return read(bArr, i2, i8);
            }
            return bytesRead;
        } catch (Throwable th2) {
            e = th2;
            A09(e);
            throw e;
        }
    }
}
