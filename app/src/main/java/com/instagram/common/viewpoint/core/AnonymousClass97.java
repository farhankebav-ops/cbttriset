package com.instagram.common.viewpoint.core;

import android.net.Uri;
import com.facebook.ads.androidx.media3.common.Timeline;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.97, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass97 extends Timeline {
    public static byte[] A0D;
    public static final C2145oi A0E;
    public static final Object A0F;
    public final long A00;
    public final long A01;
    public final long A02;
    public final long A03;
    public final long A04;
    public final long A05;
    public final long A06;
    public final C2147ok A07;
    public final C2145oi A08;
    public final Object A09;
    public final boolean A0A;
    public final boolean A0B;
    public final boolean A0C;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0D, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 50);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A0D = new byte[]{-79, -57, -52, -59, -54, -61, -82, -61, -48, -57, -51, -62, -78, -57, -53, -61, -54, -57, -52, -61};
    }

    static {
        A01();
        A0F = new Object();
        A0E = new C2I().A03(A00(0, 20, 44)).A00(Uri.EMPTY).A05();
    }

    public AnonymousClass97(long j, long j3, long j8, long j9, long j10, long j11, long j12, boolean z2, boolean z7, boolean z8, Object obj, C2145oi c2145oi, C2147ok c2147ok) {
        this.A02 = j;
        this.A06 = j3;
        this.A00 = j8;
        this.A01 = j9;
        this.A04 = j10;
        this.A05 = j11;
        this.A03 = j12;
        this.A0B = z2;
        this.A0A = z7;
        this.A0C = z8;
        this.A09 = obj;
        this.A08 = (C2145oi) C3M.A01(c2145oi);
        this.A07 = c2147ok;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AnonymousClass97(long j, long j3, long j8, long j9, boolean z2, boolean z7, boolean z8, Object obj, C2145oi c2145oi) {
        C2147ok c2147ok;
        if (z8) {
            c2147ok = c2145oi.A02;
        } else {
            c2147ok = null;
        }
        this(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, j, j3, j8, j9, z2, z7, false, obj, c2145oi, c2147ok);
    }

    public AnonymousClass97(long j, boolean z2, boolean z7, boolean z8, Object obj, C2145oi c2145oi) {
        this(j, j, 0L, 0L, z2, z7, z8, obj, c2145oi);
    }

    @Override // com.facebook.ads.androidx.media3.common.Timeline
    public final int A06() {
        return 1;
    }

    @Override // com.facebook.ads.androidx.media3.common.Timeline
    public final int A07() {
        return 1;
    }

    @Override // com.facebook.ads.androidx.media3.common.Timeline
    public final int A0A(Object obj) {
        return A0F.equals(obj) ? 0 : -1;
    }

    @Override // com.facebook.ads.androidx.media3.common.Timeline
    public final C2125oN A0I(int i2, C2125oN c2125oN, boolean z2) {
        C3M.A00(i2, 0, 1);
        return c2125oN.A0F(null, z2 ? A0F : null, 0, this.A01, -this.A05);
    }

    @Override // com.facebook.ads.androidx.media3.common.Timeline
    public final C2123oL A0L(int i2, C2123oL c2123oL, long j) {
        C3M.A00(i2, 0, 1);
        long j3 = this.A03;
        if (this.A0A && !this.A0C && j != 0) {
            if (this.A04 == -9223372036854775807L) {
                j3 = -9223372036854775807L;
            } else {
                j3 += j;
                if (j3 > this.A04) {
                    j3 = -9223372036854775807L;
                }
            }
        }
        return c2123oL.A07(C2123oL.A0K, this.A08, this.A09, this.A02, this.A06, -9223372036854775807L, this.A0B, this.A0A, null, j3, this.A04, 0, 0, this.A05);
    }

    @Override // com.facebook.ads.androidx.media3.common.Timeline
    public final Object A0M(int i2) {
        C3M.A00(i2, 0, 1);
        return A0F;
    }
}
