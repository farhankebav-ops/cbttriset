package com.instagram.common.viewpoint.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.File;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Lx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C0914Lx implements Comparable<C0914Lx> {
    public static byte[] A06;

    @MetaExoPlayerCustomization
    public static final String A07;
    public final long A00;
    public final long A01;
    public final long A02;
    public final File A03;
    public final String A04;
    public final boolean A05;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 14);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A06 = new byte[]{15, 67, 78, 91, 21, 65, 17, 14, 18, 91, 65, 119, 36, 62, 45, 50, 109, 119, 65, 99, 97, 106, 103, 81, 114, 99, 108, 121};
    }

    static {
        A01();
        A07 = C0914Lx.class.getSimpleName();
    }

    public C0914Lx(String str, long j, long j3, long j8, File file) {
        this.A04 = str;
        this.A02 = j;
        this.A01 = j3;
        this.A05 = file != null;
        this.A03 = file;
        this.A00 = j8;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
    public final int compareTo(C0914Lx c0914Lx) {
        if (!this.A04.equals(c0914Lx.A04)) {
            return this.A04.compareTo(c0914Lx.A04);
        }
        long j = this.A02 - c0914Lx.A02;
        if (j == 0) {
            return 0;
        }
        return j < 0 ? -1 : 1;
    }

    public final boolean A03() {
        return !this.A05;
    }

    public final boolean A04() {
        return this.A01 == -1;
    }

    @MetaExoPlayerCustomization
    public final String toString() {
        return A00(18, 10, 12) + this.A04 + A00(0, 5, 33) + this.A00 + A00(5, 6, 111) + this.A02 + A00(11, 7, 89) + this.A01 + '}';
    }
}
