package com.instagram.common.viewpoint.core;

import android.net.Uri;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9d, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C05869d implements InterfaceC2089nl {
    public static byte[] A00;
    public static final InterfaceC04884w A01;
    public static final C05869d A02;

    public static /* synthetic */ C05869d A00() {
        return new C05869d();
    }

    public static String A01(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 126);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{23, 43, 38, 36, 34, 47, 40, 43, 35, 34, 53, 3, 38, 51, 38, 20, 40, 50, 53, 36, 34, 103, 36, 38, 41, 41, 40, 51, 103, 37, 34, 103, 40, 55, 34, 41, 34, 35};
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2089nl
    public final /* synthetic */ Map A8l() {
        return AbstractC04874v.A00(this);
    }

    static {
        A02();
        A02 = new C05869d();
        A01 = new InterfaceC04884w() { // from class: com.facebook.ads.redexgen.X.nb
            @Override // com.instagram.common.viewpoint.core.InterfaceC04884w
            public final InterfaceC2089nl A5A() {
                return C05869d.A00();
            }
        };
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2089nl
    public final void A3v(C5H c5h) {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2089nl
    public final Uri A9H() {
        return null;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2089nl
    public final long AFy(AnonymousClass56 anonymousClass56) throws IOException {
        throw new IOException(A01(0, 38, 57));
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2089nl
    public final void close() {
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass20
    public final int read(byte[] bArr, int i2, int i8) {
        throw new UnsupportedOperationException();
    }
}
