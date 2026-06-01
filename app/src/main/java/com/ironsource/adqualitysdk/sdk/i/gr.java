package com.ironsource.adqualitysdk.sdk.i;

import android.os.Process;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import com.ironsource.mediationsdk.IronSource;
import com.vungle.ads.internal.protos.Sdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class gr extends gk {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static char[] f2211 = {'c', 'o', 'm', '.', 'i', 'r', 'n', 's', 'u', 'e', 'd', 'a', 't', 'k', 'I', 'S'};

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static char f2212 = 4;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f2213 = 1;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static int f2214;

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻐ */
    public final String mo2240() {
        f2213 = (f2214 + 17) % 128;
        String strIntern = m2270(10 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (byte) (66 - KeyEvent.normalizeMetaState(0)), "\u0005\u0006\u0002\u0005\u0005\u0003\t\u0004\u0001\b").intern();
        int i2 = f2214 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE;
        f2213 = i2 % 128;
        if (i2 % 2 != 0) {
            return strIntern;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻛ */
    public final Class mo2241() {
        f2213 = (f2214 + 71) % 128;
        return IronSource.class;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾇ */
    public final bg mo2242() {
        bw bwVar = new bw(mo2240());
        int i2 = f2214 + 87;
        f2213 = i2 % 128;
        if (i2 % 2 != 0) {
            return bwVar;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾒ */
    public final String mo2243() {
        int fadingEdgeLength;
        int iMyTid;
        int i2 = f2214 + 77;
        f2213 = i2 % 128;
        if (i2 % 2 == 0) {
            fadingEdgeLength = (ViewConfiguration.getFadingEdgeLength() / 67) + 105;
            iMyTid = 58 - (Process.myTid() * 126);
        } else {
            fadingEdgeLength = (ViewConfiguration.getFadingEdgeLength() >> 16) + 38;
            iMyTid = 46 - (Process.myTid() >> 22);
        }
        String strIntern = m2270(fadingEdgeLength, (byte) iMyTid, "\u0001\u0002\u0003\u0000\u0005\u0006\u0002\u0005\u0005\u0003\t\u0004\u0001\b\u0000\u0003\n\u000b\u0007\b\u0000\b\u0002\u0005\u0006\u000b\u000f\u0001\r\u0006\u0002\u0005\r\u0003\t\u0004\u0001\b").intern();
        int i8 = f2214 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE;
        f2213 = i8 % 128;
        if (i8 % 2 != 0) {
            return strIntern;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m2270(int i2, byte b8, String str) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (h.f2264) {
            try {
                char[] cArr2 = f2211;
                char c7 = f2212;
                char[] cArr3 = new char[i2];
                if (i2 % 2 != 0) {
                    i2--;
                    cArr3[i2] = (char) (cArr[i2] - b8);
                }
                if (i2 > 1) {
                    h.f2267 = 0;
                    while (true) {
                        int i8 = h.f2267;
                        if (i8 >= i2) {
                            break;
                        }
                        h.f2269 = cArr[i8];
                        h.f2268 = cArr[h.f2267 + 1];
                        if (h.f2269 == h.f2268) {
                            cArr3[h.f2267] = (char) (h.f2269 - b8);
                            cArr3[h.f2267 + 1] = (char) (h.f2268 - b8);
                        } else {
                            h.f2266 = h.f2269 / c7;
                            h.f2263 = h.f2269 % c7;
                            h.f2265 = h.f2268 / c7;
                            h.f2262 = h.f2268 % c7;
                            if (h.f2263 == h.f2262) {
                                h.f2266 = androidx.camera.core.processing.util.a.C(h.f2266, c7, 1, c7);
                                h.f2265 = androidx.camera.core.processing.util.a.C(h.f2265, c7, 1, c7);
                                int i9 = (h.f2266 * c7) + h.f2263;
                                int i10 = (h.f2265 * c7) + h.f2262;
                                int i11 = h.f2267;
                                cArr3[i11] = cArr2[i9];
                                cArr3[i11 + 1] = cArr2[i10];
                            } else if (h.f2266 == h.f2265) {
                                h.f2263 = androidx.camera.core.processing.util.a.C(h.f2263, c7, 1, c7);
                                h.f2262 = androidx.camera.core.processing.util.a.C(h.f2262, c7, 1, c7);
                                int i12 = (h.f2266 * c7) + h.f2263;
                                int i13 = (h.f2265 * c7) + h.f2262;
                                int i14 = h.f2267;
                                cArr3[i14] = cArr2[i12];
                                cArr3[i14 + 1] = cArr2[i13];
                            } else {
                                int i15 = (h.f2266 * c7) + h.f2262;
                                int i16 = (h.f2265 * c7) + h.f2263;
                                int i17 = h.f2267;
                                cArr3[i17] = cArr2[i15];
                                cArr3[i17 + 1] = cArr2[i16];
                            }
                        }
                        h.f2267 += 2;
                    }
                }
                str2 = new String(cArr3);
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }
}
