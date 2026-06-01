package com.instagram.common.viewpoint.core;

import android.net.Uri;
import android.view.Surface;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.eF, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1532eF {
    public static byte[] A02;
    public final C9V A00;
    public final C1960lf A01 = new C1960lf();

    static {
        A02();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 50);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{-64, -54, -66, -64, 1, -1, 19, 17, 3, -64, -66, -40, -66, -64, -74, -64, -76, -74, 6, -7, 2, -8, -7, 6, -7, 6, -35, 2, -8, -7, 12, -74, -76, -50, -76, -74, -54, 37, -9, -6, 9, 16, -73, 2, -6, 8, 8, -10, -4, -6, -73, -75, -49, -75, -73, -75, 92, -82, -77, -86, -97, 92, 90, 116, 90, 92};
    }

    public C1532eF(C1477dL c1477dL) {
        EA trackSelectionFactory = new C1986m5(this.A01);
        AnonymousClass92 anonymousClass92 = new AnonymousClass92(trackSelectionFactory);
        C6S loadControl = new C2073nV();
        this.A00 = AbstractC05175z.A00(new C2070nS(c1477dL), anonymousClass92, loadControl, this.A01);
    }

    public static String A01(C2140od c2140od) {
        boolean z2 = c2140od instanceof C9Y;
        String strA00 = A00(36, 2, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE);
        String strA002 = A00(0, 14, 108);
        if (z2) {
            C9Y c9y = (C9Y) c2140od;
            return A00(55, 11, 8) + c9y.A03 + A00(14, 22, 98) + c9y.A02 + strA002 + c9y.getCause() + strA00;
        }
        return A00(41, 14, 99) + c2140od.getMessage() + strA002 + c2140od.getCause() + strA00;
    }

    public static boolean A03() {
        return true;
    }

    public final int A04() {
        return this.A00.A0I();
    }

    public final int A05() {
        return this.A00.A00();
    }

    public final long A06() {
        return this.A00.A7W();
    }

    public final long A07() {
        return this.A00.A7k();
    }

    public final C1530eD A08() {
        C2154or vf = this.A00.A0K();
        if (vf == null) {
            return null;
        }
        return new C1530eD(vf.A0L, vf.A0A);
    }

    public final void A09() {
        this.A00.A0L();
    }

    public final void A0A() {
        this.A00.A02();
    }

    public final void A0B() {
        this.A00.A01();
    }

    public final void A0C(float f4) {
        this.A00.A0M(f4);
    }

    public final void A0D(long j) {
        this.A00.A04(j);
    }

    public final void A0E(Surface surface) {
        this.A00.A0N(surface);
    }

    public final void A0F(C1451cu c1451cu, Uri uri) {
        if (U7.A2r(c1451cu, A03())) {
            C1536eJ cacheManager = C1536eJ.A06(c1451cu);
            InterfaceC04884w cachedDataSourceFactory = cacheManager.A0H(c1451cu);
            this.A00.A0Q(new AnonymousClass99(cachedDataSourceFactory).A04(uri));
            return;
        }
        CL mediaSource = new AnonymousClass99(new C2088nk(c1451cu, AbstractC04664a.A0j(c1451cu, A00(38, 3, 100)), this.A01)).A04(uri);
        this.A00.A0Q(mediaSource);
    }

    public final void A0G(InterfaceC1529eC interfaceC1529eC) {
        this.A00.A0O(new CR(this, interfaceC1529eC));
    }

    public final void A0H(final InterfaceC1531eE interfaceC1531eE) {
        this.A00.A0P(new InterfaceC2059nH() { // from class: com.facebook.ads.redexgen.X.27
            @Override // com.instagram.common.viewpoint.core.InterfaceC04754j
            public final void AFq(int i2, int i8, int i9, float f4) {
                interfaceC1531eE.AFq(i2, i8, i9, f4);
            }
        });
    }

    public final void A0I(boolean z2) {
        this.A00.A0S(z2);
    }

    public final boolean A0J() {
        return this.A00.A0T();
    }

    public final boolean A0K() {
        return this.A00.A0J() != null;
    }
}
