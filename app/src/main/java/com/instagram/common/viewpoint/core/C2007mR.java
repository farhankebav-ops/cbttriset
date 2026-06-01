package com.instagram.common.viewpoint.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.mR, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2007mR implements InterfaceC0659Cb {
    public static byte[] A03;
    public static String[] A04 = {"3Cx8VuBaAtU", "mtIvitx", "ijtxGWvqwx8wBPOmSGXshyr4piVUOT73", "1A2eWfmauMvQ3z4CiBElgktZxGJ5t0Vj", "NuAYfoZUoES6MxZb2vdyJB2K3PVOnnYD", "gczB0K5G5", "TBGYu08V4AAoblIa0rbrS9oc16PYokVw", "JGtQJ9cae1Y"};
    public GX A00;
    public InterfaceC1943lN A01;
    public final InterfaceC0763Gb A02;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 78);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{80, 89, 26, 22, 12, 21, 29, 89, 11, 28, 24, 29, 89, 13, 17, 28, 89, 10, 13, 11, 28, 24, 20, 87, 2, 35, 34, 41, 108, 35, 42, 108, 56, 36, 41, 108, 45, 58, 45, 37, 32, 45, 46, 32, 41, 108, 41, 52, 56, 62, 45, 47, 56, 35, 62, 63, 108, 100};
    }

    static {
        A01();
    }

    public C2007mR(InterfaceC0763Gb interfaceC0763Gb) {
        this.A02 = interfaceC0763Gb;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0659Cb
    @MetaExoPlayerCustomization("No op, we don't include mp3 extractor due to apk size")
    public final void A5q() {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0659Cb
    public final long A7S() {
        if (this.A01 != null) {
            return this.A01.A8f();
        }
        return -1L;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0068  */
    @Override // com.instagram.common.viewpoint.core.InterfaceC0659Cb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void AA3(@com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization(" To be replaced with DataReader after upstream is updated") com.instagram.common.viewpoint.core.InterfaceC2089nl r16, android.net.Uri r17, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r18, long r19, long r21, com.instagram.common.viewpoint.core.GY r23) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C2007mR.AA3(com.facebook.ads.redexgen.X.nl, android.net.Uri, java.util.Map, long, long, com.facebook.ads.redexgen.X.GY):void");
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0659Cb
    public final int AGc(C0781Gt c0781Gt) throws IOException {
        return ((GX) C3M.A01(this.A00)).AGb((InterfaceC1943lN) C3M.A01(this.A01), c0781Gt);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0659Cb
    public final void AGr() {
        if (this.A00 != null) {
            this.A00.AGr();
            this.A00 = null;
        }
        this.A01 = null;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0659Cb
    public final void AIM(long j, long j3) {
        ((GX) C3M.A01(this.A00)).AIM(j, j3);
    }
}
