package com.ironsource.adqualitysdk.sdk.i;

import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import com.tapjoy.Tapjoy;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class gs extends gk {

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static int f2215 = 1;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static int f2216 = 0;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static short[] f2217 = null;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f2218 = -306554342;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f2219 = 73033602;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static byte[] f2220 = {-35, -26, 45, -32, -34, 9, 118, -35, -26, 45, -32, 62, -87, 34, 49, -33, 35, 42, -13, 32, 2, 0, 0};

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static int f2221 = 109;

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻐ */
    public final String mo2240() {
        f2216 = (f2215 + 17) % 128;
        String strIntern = m2271((-103) - (ViewConfiguration.getScrollBarSize() >> 8), (short) (113 - TextUtils.getOffsetBefore("", 0)), TextUtils.getOffsetAfter("", 0) + 306554358, (byte) (65486 - AndroidCharacter.getMirror('0')), (-73033486) - View.MeasureSpec.getMode(0)).intern();
        int i2 = f2216 + 105;
        f2215 = i2 % 128;
        if (i2 % 2 != 0) {
            return strIntern;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻛ */
    public final Class mo2241() {
        int i2 = (f2216 + 45) % 128;
        f2215 = i2;
        int i8 = i2 + 47;
        f2216 = i8 % 128;
        if (i8 % 2 != 0) {
            int i9 = 37 / 0;
        }
        return Tapjoy.class;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾇ */
    public final bg mo2242() {
        ce ceVar = new ce(mo2240());
        int i2 = f2215 + 29;
        f2216 = i2 % 128;
        if (i2 % 2 == 0) {
            return ceVar;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾒ */
    public final String mo2243() {
        f2216 = (f2215 + 43) % 128;
        String strIntern = m2271((-92) - View.getDefaultSize(0, 0), (short) (TextUtils.indexOf("", "", 0, 0) - 10), 306554341 - TextUtils.indexOf((CharSequence) "", '0', 0), (byte) ((-38) - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), (ViewConfiguration.getPressedStateDuration() >> 16) - 73033503).intern();
        f2216 = (f2215 + 33) % 128;
        return strIntern;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m2271(int i2, short s7, int i8, byte b8, int i9) {
        String string;
        synchronized (n.f2979) {
            try {
                StringBuilder sb = new StringBuilder();
                int i10 = f2221;
                int i11 = i2 + i10;
                int i12 = i11 == -1 ? 1 : 0;
                if (i12 != 0) {
                    byte[] bArr = f2220;
                    i11 = bArr != null ? (byte) (bArr[f2218 + i8] + i10) : (short) (f2217[f2218 + i8] + i10);
                }
                if (i11 > 0) {
                    n.f2984 = ((i8 + i11) - 2) + f2218 + i12;
                    n.f2982 = b8;
                    char c7 = (char) (i9 + f2219);
                    n.f2981 = c7;
                    sb.append(c7);
                    n.f2980 = n.f2981;
                    n.f2983 = 1;
                    while (n.f2983 < i11) {
                        byte[] bArr2 = f2220;
                        if (bArr2 != null) {
                            int i13 = n.f2984;
                            n.f2984 = i13 - 1;
                            n.f2981 = (char) (n.f2980 + (((byte) (bArr2[i13] + s7)) ^ n.f2982));
                        } else {
                            short[] sArr = f2217;
                            int i14 = n.f2984;
                            n.f2984 = i14 - 1;
                            n.f2981 = (char) (n.f2980 + (((short) (sArr[i14] + s7)) ^ n.f2982));
                        }
                        sb.append(n.f2981);
                        n.f2980 = n.f2981;
                        n.f2983++;
                    }
                }
                string = sb.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
        return string;
    }
}
