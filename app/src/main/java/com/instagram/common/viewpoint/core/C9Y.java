package com.instagram.common.viewpoint.core;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9Y, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C9Y extends C2140od {
    public static byte[] A07;
    public static final C1R<C9Y> A08;
    public static final String A09;
    public static final String A0A;
    public static final String A0B;
    public static final String A0C;
    public static final String A0D;
    public static final String A0E;
    public final boolean A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final C2154or A04;
    public final AbstractC04162a A05;
    public final String A06;

    public static /* synthetic */ C9Y A00(Bundle bundle) {
        return new C9Y(bundle);
    }

    public static String A05(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 61);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A07 = new byte[]{120, -67, -54, -54, -57, -54, -124, 120, -63, -58, -68, -67, -48, -107, -83, -95, -25, -16, -13, -18, -30, -11, -66, -37, -49, 21, 30, 33, 28, 16, 35, 14, 34, 36, 31, 31, 30, 33, 35, 20, 19, -20, -21, -47, -45, -26, -18, -16, -11, -26, -95, -26, -13, -13, -16, -13, -53, -25, -19, -22, -37, -35, -104, -35, -22, -22, -25, -22, -50, -25, -34, -15, -23, -34, -36, -19, -34, -35, -103, -21, -18, -25, -19, -30, -26, -34, -103, -34, -21, -21, -24, -21};
    }

    static {
        A07();
        A08 = new C1R() { // from class: com.facebook.ads.redexgen.X.nR
            @Override // com.instagram.common.viewpoint.core.C1R
            public final C1S A6X(Bundle bundle) {
                return C9Y.A00(bundle);
            }
        };
        A0E = AbstractC04664a.A0h(1001);
        A0D = AbstractC04664a.A0h(1002);
        A0C = AbstractC04664a.A0h(1003);
        A0A = AbstractC04664a.A0h(1004);
        A0B = AbstractC04664a.A0h(1005);
        A09 = AbstractC04664a.A0h(1006);
    }

    public C9Y(int i2, Throwable th, int i8) {
        this(i2, th, null, i8, null, -1, null, 4, false);
    }

    public C9Y(int i2, Throwable th, String str, int i8, String str2, int i9, C2154or c2154or, int i10, boolean z2) {
        this(A06(i2, th, str, str2, i9, c2154or, i10), th, i8, i2, str2, i9, c2154or, i10, null, SystemClock.elapsedRealtime(), z2);
    }

    public C9Y(Bundle bundle) {
        C2154or c2154or;
        super(bundle);
        this.A03 = bundle.getInt(A0E, 2);
        this.A06 = bundle.getString(A0D);
        this.A02 = bundle.getInt(A0C, -1);
        Bundle bundle2 = bundle.getBundle(A0A);
        if (bundle2 == null) {
            c2154or = null;
        } else {
            c2154or = (C2154or) C2154or.A0b.A6X(bundle2);
        }
        this.A04 = c2154or;
        this.A01 = bundle.getInt(A0B, 4);
        this.A00 = bundle.getBoolean(A09, false);
        this.A05 = null;
    }

    public C9Y(String str, Throwable th, int i2, int i8, String str2, int i9, C2154or c2154or, int i10, AbstractC04162a abstractC04162a, long j, boolean z2) {
        super(str, th, i2, j);
        C3M.A07(!z2 || i8 == 1);
        C3M.A07(th != null || i8 == 3);
        this.A03 = i8;
        this.A06 = str2;
        this.A02 = i9;
        this.A04 = c2154or;
        this.A01 = i10;
        this.A05 = abstractC04162a;
        this.A00 = z2;
    }

    public static C9Y A01(IOException iOException, int i2) {
        return new C9Y(0, iOException, i2);
    }

    @Deprecated
    public static C9Y A02(RuntimeException runtimeException) {
        return A03(runtimeException, 1000);
    }

    public static C9Y A03(RuntimeException runtimeException, int i2) {
        return new C9Y(2, runtimeException, i2);
    }

    public static C9Y A04(Throwable th, String str, int i2, C2154or c2154or, int i8, boolean z2, int i9) {
        int i10 = i8;
        if (c2154or == null) {
            i10 = 4;
        }
        return new C9Y(1, th, null, i9, str, i2, c2154or, i10, z2);
    }

    public static String A06(@MetaExoPlayerCustomization(type = {"NEW_METHOD_ARGS"}, value = "Throwable cause - linked with Error reporting") int i2, Throwable th, String str, String str2, int i8, C2154or c2154or, int i9) {
        String message;
        String strA05;
        if (str == null) {
            message = th == null ? null : th.getMessage();
        } else {
            message = str;
        }
        if (message != null) {
            return message;
        }
        switch (i2) {
            case 0:
                strA05 = A05(56, 12, 59);
                break;
            case 1:
                StringBuilder sbAppend = new StringBuilder().append(str2);
                String message2 = A05(0, 14, 27);
                StringBuilder sbAppend2 = sbAppend.append(message2).append(i8);
                String message3 = A05(14, 9, 68);
                StringBuilder sbAppend3 = sbAppend2.append(message3).append(c2154or);
                String message4 = A05(23, 19, 114);
                StringBuilder sbAppend4 = sbAppend3.append(message4);
                String message5 = AbstractC04664a.A0g(i9);
                strA05 = sbAppend4.append(message5).toString();
                break;
            case 2:
            default:
                strA05 = A05(68, 24, 60);
                break;
            case 3:
                strA05 = A05(44, 12, 68);
                break;
        }
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sbAppend5 = new StringBuilder().append(strA05);
            String message6 = A05(42, 2, 116);
            return sbAppend5.append(message6).append(str).toString();
        }
        return strA05;
    }
}
