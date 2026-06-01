package com.instagram.common.viewpoint.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.ironsource.C2253bb;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7R, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
@MetaExoPlayerCustomization("Exo version is final but in Meta code HeroLeastRecentlyUsedCacheEvictor extends this")
public final class C7R implements InterfaceC1806iw {
    public static byte[] A03;
    public static String[] A04 = {"jtWHdC1JS00IQCACyTEvOJEMPrvoo3Ob", "eCCt1HwS4IToKXyi1WzLFL1R4PlgsDM4", "yXgy4dLxj37Ni2Ba12KifyhgeRBIXCXp", "5p7nRT0g4n3u8StY", "28aCkGMBHBRgMUJ0i4knnGO", "XAmyqmpuCXa4X38XkweYk7F1knbiAlXr", "krkFdswQPRExlipS29WIEjh8hbH7SBjj", C2253bb.f8076u};

    @MetaExoPlayerCustomization("Exo version is private but in Meta code HeroLeastRecentlyUsedCacheEvictor extends this")
    public long A00;

    @MetaExoPlayerCustomization("Exo version is private but in Meta code HeroLeastRecentlyUsedCacheEvictor extends this")
    public final long A01;

    @MetaExoPlayerCustomization("Exo version is private but in Meta code HeroLeastRecentlyUsedCacheEvictor extends this")
    public final TreeSet<C0914Lx> A02 = new TreeSet<>(new Comparator() { // from class: com.facebook.ads.redexgen.X.MB
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return C7R.A00((C0914Lx) obj, (C0914Lx) obj2);
        }
    });

    public static String A01(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 28);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{46, 61, 34, 40, 63, 8, 42, 40, 35, 46};
    }

    static {
        A02();
    }

    public C7R(long j) {
        this.A01 = j;
    }

    @MetaExoPlayerCustomization("Exo version is private but in Meta code HeroLeastRecentlyUsedCacheEvictor extends this")
    public static int A00(C0914Lx c0914Lx, C0914Lx c0914Lx2) {
        if (c0914Lx.A00 - c0914Lx2.A00 == 0) {
            return c0914Lx.compareTo(c0914Lx2);
        }
        return c0914Lx.A00 < c0914Lx2.A00 ? -1 : 1;
    }

    private void A03(InterfaceC0904Ln interfaceC0904Ln, long j) {
        C4S.A02(A01(0, 10, 87));
        while (this.A00 + j > this.A01 && !this.A02.isEmpty()) {
            C0914Lx c0914LxFirst = this.A02.first();
            if (A04[1].charAt(10) != 'T') {
                throw new RuntimeException();
            }
            A04[4] = "DjrmhsDHxGC2SVigK1e7Rl2";
            interfaceC0904Ln.AHl(c0914LxFirst);
        }
        C4S.A00();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0903Lm
    public final void AFJ(InterfaceC0904Ln interfaceC0904Ln, C0914Lx c0914Lx) {
        this.A02.add(c0914Lx);
        this.A00 += c0914Lx.A01;
        A03(interfaceC0904Ln, 0L);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0903Lm
    public final void AFK(InterfaceC0904Ln interfaceC0904Ln, C0914Lx c0914Lx) {
        this.A02.remove(c0914Lx);
        this.A00 -= c0914Lx.A01;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0903Lm
    public final void AFL(InterfaceC0904Ln interfaceC0904Ln, C0914Lx c0914Lx, C0914Lx c0914Lx2) {
        AFK(interfaceC0904Ln, c0914Lx);
        AFJ(interfaceC0904Ln, c0914Lx2);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1806iw
    public final void AFM(InterfaceC0904Ln interfaceC0904Ln, String str, long j, long j3) {
        if (j3 != -1) {
            A03(interfaceC0904Ln, j3);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1806iw
    public final boolean AHz() {
        return true;
    }
}
