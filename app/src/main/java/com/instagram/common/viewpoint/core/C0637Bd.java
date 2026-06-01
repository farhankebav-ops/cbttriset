package com.instagram.common.viewpoint.core;

import android.util.Log;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Bd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0637Bd implements InterfaceC1653gE {
    public static byte[] A02;
    public static final C0637Bd A03;
    public String A01 = A01(1, 7, 98);
    public int A00 = 5;

    public static String A01(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 42);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A02 = new byte[]{-33, 1, -6, -9, -6, -5, 3, -6};
    }

    static {
        A05();
        A03 = new C0637Bd();
    }

    public static C0637Bd A00() {
        return A03;
    }

    private String A02(String str) {
        if (this.A01 != null) {
            return this.A01 + A01(0, 1, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE) + str;
        }
        return str;
    }

    public static String A03(String str, Throwable th) {
        return str + '\n' + A04(th);
    }

    public static String A04(Throwable th) {
        if (th == null) {
            return A01(0, 0, 21);
        }
        return Log.getStackTraceString(th);
    }

    private void A06(int i2, String str, String str2) {
        Log.println(i2, A02(str), str2);
    }

    private void A07(int i2, String str, String str2, Throwable th) {
        Log.println(i2, A02(str), A03(str2, th));
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1653gE
    public final void A9l(String str, String str2) {
        A06(4, str, str2);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1653gE
    public final void A9m(String str, String str2, Throwable th) {
        A07(4, str, str2, th);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1653gE
    public final boolean AAP(int i2) {
        return this.A00 <= i2;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1653gE
    public final void AIo(int i2) {
        this.A00 = i2;
    }
}
