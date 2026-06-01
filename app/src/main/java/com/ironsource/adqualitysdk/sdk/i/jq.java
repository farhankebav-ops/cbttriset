package com.ironsource.adqualitysdk.sdk.i;

import android.webkit.WebView;
import com.vungle.ads.internal.protos.Sdk;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class jq {

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static int f2862 = 1;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static dn f2863;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f2864;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static char[] f2865 = {'{', 244, 245, 239, 232, 235, 240, 223, 226, 226, 228, 242, 235, 227, 224, 231, 226, 16, 'G', 'q', 'J', 'I', 'n', 'E', 'C', 'j', 'k', 'n', 'k', 'd', 'g', 'l', 'k', 'D', 'I', 'p', 'p', 'r', '[', '2', '-', 'X', 'n', 'g', '_', '\\', 'c', 'n', 'D', 146, 161, 160, 146, 139, 142, 147, 146, 153, 162, 163, 164, 152, 144, 142, 142, 157, 159, 's', 231, 232, 232, 240, 238, 232, 242, 247, 246, 245, 233, 227, '.', ']', 'X', 'N', 'T', 'P', 'I', 'S', 'V', 'N', 'P', '[', '.', '\\', '[', 'O', 'I', 'N', 'N', 'I', 'D', 'K', 'Q', 'P', 'X', 'T', 'N', 'X', '\"', '[', 'r', 'p', 'p', 'I', 'D', 'k', 'G', 'C', 'f', 'l', '_', '^', 'c', 'a', '\\', '[', 'l', 'g', 'd', 'k', 'W', '-'};

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private final String f2866;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private final boolean f2867;

    public jq(String str, boolean z2) {
        this.f2866 = str;
        this.f2867 = z2;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ String m2756(jq jqVar) {
        int i2 = f2862 + 83;
        f2864 = i2 % 128;
        if (i2 % 2 != 0) {
            jqVar.m2754();
            throw null;
        }
        String strM2754 = jqVar.m2754();
        int i8 = f2862 + 37;
        f2864 = i8 % 128;
        if (i8 % 2 != 0) {
            int i9 = 34 / 0;
        }
        return strM2754;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private String m2758() {
        String strReplace;
        String strIntern;
        dn dnVar;
        f2864 = (f2862 + 97) % 128;
        String strM2062 = f2863.m2062();
        try {
            String strReplace2 = strM2062.replace(m2757("\u0000\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0001\u0001", true, new int[]{48, 19, 71, 11}).intern(), m2755()).replace(m2757("\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0000\u0000\u0000", false, new int[]{67, 13, 154, 9}).intern(), f2863.m2065());
            if (this.f2867) {
                int i2 = f2862 + 111;
                f2864 = i2 % 128;
                if (i2 % 2 != 0) {
                    strIntern = m2757("\u0001\u0000\u0000\u0001\u0001\u0000\u0001\u0000\u0000\u0001\u0000\u0000", true, new int[]{80, 12, 0, 0}).intern();
                    dnVar = f2863;
                } else {
                    strIntern = m2757("\u0001\u0000\u0000\u0001\u0001\u0000\u0001\u0000\u0000\u0001\u0000\u0000", true, new int[]{80, 12, 0, 0}).intern();
                    dnVar = f2863;
                }
                strReplace = strReplace2.replace(strIntern, dnVar.m2064());
            } else {
                strReplace = strReplace2.replace(m2757("\u0001\u0000\u0000\u0001\u0001\u0000\u0001\u0000\u0000\u0001\u0000\u0000", true, new int[]{80, 12, 0, 0}).intern(), "");
                f2864 = (f2862 + 43) % 128;
            }
            return strReplace.replace(m2757("\u0001\u0000\u0000\u0000\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0000", false, new int[]{92, 16, 0, 1}).intern(), this.f2866);
        } catch (Throwable th) {
            String strIntern2 = m2757("\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0000", true, new int[]{0, 17, Sdk.SDKError.Reason.OMSDK_DOWNLOAD_JS_ERROR_VALUE, 0}).intern();
            StringBuilder sb = new StringBuilder();
            sb.append(m2757("\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0000", false, new int[]{108, 24, 0, 0}).intern());
            sb.append(th.getLocalizedMessage());
            k.m2863(strIntern2, sb.toString());
            return strM2062;
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static void m2759(dn dnVar) {
        int i2 = (f2864 + 91) % 128;
        f2862 = i2;
        f2863 = dnVar;
        f2864 = (i2 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE) % 128;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final void m2760(final WebView webView) {
        try {
            p.m2964(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.jq.4
                @Override // com.ironsource.adqualitysdk.sdk.i.iu
                /* JADX INFO: renamed from: ﻐ */
                public final void mo306() {
                    final String strM2756 = jq.m2756(jq.this);
                    p.m2967(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.jq.4.1
                        @Override // com.ironsource.adqualitysdk.sdk.i.iu
                        /* JADX INFO: renamed from: ﻐ */
                        public final void mo306() {
                            kf.m2955(webView, strM2756);
                        }
                    });
                }
            });
            f2864 = (f2862 + 39) % 128;
        } catch (Exception e) {
            String strIntern = m2757("\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0000", true, new int[]{0, 17, Sdk.SDKError.Reason.OMSDK_DOWNLOAD_JS_ERROR_VALUE, 0}).intern();
            StringBuilder sb = new StringBuilder();
            sb.append(m2757("\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0000\u0000\u0001\u0000\u0001\u0000", true, new int[]{17, 31, 0, 22}).intern());
            sb.append(e.getLocalizedMessage());
            k.m2863(strIntern, sb.toString());
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m2755() {
        f2864 = (f2862 + 115) % 128;
        String strM529 = aq.m530().mo543().m529();
        int i2 = f2864 + 3;
        f2862 = i2 % 128;
        if (i2 % 2 != 0) {
            return strM529;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private String m2754() {
        int i2 = f2864 + 111;
        f2862 = i2 % 128;
        if (i2 % 2 != 0) {
            String strM2504 = ic.m2504(m2758().getBytes());
            int i8 = f2862 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE;
            f2864 = i8 % 128;
            if (i8 % 2 == 0) {
                return strM2504;
            }
            throw null;
        }
        ic.m2504(m2758().getBytes());
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m2757(String str, boolean z2, int[] iArr) throws UnsupportedEncodingException {
        String str2;
        Object bytes = str;
        if (str != null) {
            bytes = str.getBytes("ISO-8859-1");
        }
        byte[] bArr = (byte[]) bytes;
        synchronized (g.f2126) {
            try {
                int i2 = iArr[0];
                int i8 = iArr[1];
                int i9 = iArr[2];
                int i10 = iArr[3];
                char[] cArr = new char[i8];
                System.arraycopy(f2865, i2, cArr, 0, i8);
                if (bArr != null) {
                    char[] cArr2 = new char[i8];
                    g.f2125 = 0;
                    char c7 = 0;
                    while (true) {
                        int i11 = g.f2125;
                        if (i11 >= i8) {
                            break;
                        }
                        if (bArr[i11] == 1) {
                            cArr2[i11] = (char) (((cArr[i11] << 1) + 1) - c7);
                        } else {
                            cArr2[i11] = (char) ((cArr[i11] << 1) - c7);
                        }
                        c7 = cArr2[i11];
                        g.f2125 = i11 + 1;
                    }
                    cArr = cArr2;
                }
                if (i10 > 0) {
                    char[] cArr3 = new char[i8];
                    System.arraycopy(cArr, 0, cArr3, 0, i8);
                    int i12 = i8 - i10;
                    System.arraycopy(cArr3, 0, cArr, i12, i10);
                    System.arraycopy(cArr3, i10, cArr, 0, i12);
                }
                if (z2) {
                    char[] cArr4 = new char[i8];
                    g.f2125 = 0;
                    while (true) {
                        int i13 = g.f2125;
                        if (i13 >= i8) {
                            break;
                        }
                        cArr4[i13] = cArr[(i8 - i13) - 1];
                        g.f2125 = i13 + 1;
                    }
                    cArr = cArr4;
                }
                if (i9 > 0) {
                    g.f2125 = 0;
                    while (true) {
                        int i14 = g.f2125;
                        if (i14 >= i8) {
                            break;
                        }
                        cArr[i14] = (char) (cArr[i14] - iArr[2]);
                        g.f2125 = i14 + 1;
                    }
                }
                str2 = new String(cArr);
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }
}
