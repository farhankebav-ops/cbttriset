package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Process;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.vungle.ads.internal.protos.Sdk;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class ja {

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static int f2672 = 0;

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static char[] f2673 = {'P', 'F', 'f', 200, 193, 'X', 170, 168, 173, 176, 171, 163, 162, 135, 'b', 170, 178, 210};

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static int f2674 = 1;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private String f2675;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private String f2676;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private boolean f2677;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private String f2678;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private String f2679;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class b extends c {

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private final String f2680;

        public b(String str, String str2, String str3) {
            super(str, str2);
            this.f2680 = str3;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.ja
        /* JADX INFO: renamed from: ﻛ */
        public final String mo2625() {
            return m2629(this.f2680);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class c extends ja {

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private static int f2681 = 20;

        public c(String str, String str2) {
            super(str, m2630(125 - Color.argb(0, 0, 0, 0), (ViewConfiguration.getPressedStateDuration() >> 16) + 4, "�\ufffa\u0006\u0005", 1 - ExpandableListView.getPackedPositionType(0L), false).intern(), str2, m2630(119 - View.MeasureSpec.getSize(0), AndroidCharacter.getMirror('0') - '(', "\f\u000bￋ\u0002\u000b\u0000\u0007\u0010", 6 - Gravity.getAbsoluteGravity(0, 0), false).intern(), (byte) 0);
        }

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private static String m2630(int i2, int i8, String str, int i9, boolean z2) {
            String str2;
            Object charArray = str;
            if (str != null) {
                charArray = str.toCharArray();
            }
            char[] cArr = (char[]) charArray;
            synchronized (com.ironsource.adqualitysdk.sdk.i.e.f1927) {
                try {
                    char[] cArr2 = new char[i8];
                    com.ironsource.adqualitysdk.sdk.i.e.f1926 = 0;
                    while (true) {
                        int i10 = com.ironsource.adqualitysdk.sdk.i.e.f1926;
                        if (i10 >= i8) {
                            break;
                        }
                        com.ironsource.adqualitysdk.sdk.i.e.f1929 = cArr[i10];
                        cArr2[com.ironsource.adqualitysdk.sdk.i.e.f1926] = (char) (com.ironsource.adqualitysdk.sdk.i.e.f1929 + i2);
                        int i11 = com.ironsource.adqualitysdk.sdk.i.e.f1926;
                        cArr2[i11] = (char) (cArr2[i11] - f2681);
                        com.ironsource.adqualitysdk.sdk.i.e.f1926 = i11 + 1;
                    }
                    if (i9 > 0) {
                        com.ironsource.adqualitysdk.sdk.i.e.f1928 = i9;
                        char[] cArr3 = new char[i8];
                        System.arraycopy(cArr2, 0, cArr3, 0, i8);
                        int i12 = com.ironsource.adqualitysdk.sdk.i.e.f1928;
                        System.arraycopy(cArr3, 0, cArr2, i8 - i12, i12);
                        int i13 = com.ironsource.adqualitysdk.sdk.i.e.f1928;
                        System.arraycopy(cArr3, i13, cArr2, 0, i8 - i13);
                    }
                    if (z2) {
                        char[] cArr4 = new char[i8];
                        com.ironsource.adqualitysdk.sdk.i.e.f1926 = 0;
                        while (true) {
                            int i14 = com.ironsource.adqualitysdk.sdk.i.e.f1926;
                            if (i14 >= i8) {
                                break;
                            }
                            cArr4[i14] = cArr2[(i8 - i14) - 1];
                            com.ironsource.adqualitysdk.sdk.i.e.f1926 = i14 + 1;
                        }
                        cArr2 = cArr4;
                    }
                    str2 = new String(cArr2);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return str2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class d extends ja {

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private static int f2682 = -1699375103;

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private static char f2683;

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private static long f2684;

        public d(String str, String str2) {
            super(str, m2631("䇰㻪윱ⴚ", (char) (6855 - TextUtils.getTrimmedLength("")), "䒩瑖넆疒", Process.myTid() >> 22, "\u0000\u0000\u0000\u0000").intern(), str2, m2631("檏랁뮦紡", (char) Drawable.resolveOpacity(0, 0), "累\uda91琛麤皒ꇍ쥌吰", ViewConfiguration.getLongPressTimeout() >> 16, "\u0000\u0000\u0000\u0000").intern(), (byte) 0);
        }

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private static String m2631(String str, char c7, String str2, int i2, String str3) {
            String str4;
            Object charArray = str3;
            if (str3 != null) {
                charArray = str3.toCharArray();
            }
            char[] cArr = (char[]) charArray;
            Object charArray2 = str2;
            if (str2 != null) {
                charArray2 = str2.toCharArray();
            }
            char[] cArr2 = (char[]) charArray2;
            Object charArray3 = str;
            if (str != null) {
                charArray3 = str.toCharArray();
            }
            char[] cArr3 = (char[]) charArray3;
            synchronized (f.f2031) {
                try {
                    char[] cArr4 = (char[]) cArr3.clone();
                    char[] cArr5 = (char[]) cArr.clone();
                    cArr4[0] = (char) (c7 ^ cArr4[0]);
                    cArr5[2] = (char) (cArr5[2] + ((char) i2));
                    int length = cArr2.length;
                    char[] cArr6 = new char[length];
                    f.f2032 = 0;
                    while (true) {
                        int i8 = f.f2032;
                        if (i8 < length) {
                            int i9 = (i8 + 2) % 4;
                            int i10 = (i8 + 3) % 4;
                            int i11 = cArr4[i8 % 4] * 32718;
                            char c8 = cArr5[i9];
                            char c9 = (char) ((i11 + c8) % 65535);
                            f.f2030 = c9;
                            cArr5[i10] = (char) com.google.android.gms.ads.internal.client.a.w(cArr4[i10], 32718, c8, 65535);
                            cArr4[i10] = c9;
                            int i12 = f.f2032;
                            cArr6[i12] = (char) (((((long) (c9 ^ cArr2[i12])) ^ f2684) ^ ((long) f2682)) ^ ((long) f2683));
                            f.f2032 = i12 + 1;
                        } else {
                            str4 = new String(cArr6);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return str4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class e extends d {

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private final String f2685;

        public e(String str, String str2, String str3) {
            super(str, str2);
            this.f2685 = str3;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.ja
        /* JADX INFO: renamed from: ﻛ */
        public final String mo2625() {
            return m2629(this.f2685);
        }
    }

    public /* synthetic */ ja(String str, String str2, String str3, String str4, byte b8) {
        this(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private String m2619() {
        f2674 = (f2672 + 51) % 128;
        String strIntern = m2623("\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001", false, new int[]{5, 9, 63, 0}).intern();
        String strM2621 = m2621();
        if (this.f2677) {
            f2674 = (f2672 + 15) % 128;
            if (!TextUtils.isEmpty(strM2621)) {
                StringBuilder sbR = androidx.camera.core.processing.util.a.r(strIntern);
                sbR.append(m2623("\u0001\u0000\u0001\u0000", true, new int[]{14, 4, 96, 1}).intern());
                sbR.append(strM2621);
                strIntern = com.google.android.gms.ads.internal.client.a.z(sbR, m2623(null, true, new int[]{0, 1, 33, 1}));
            }
        }
        f2672 = (f2674 + 95) % 128;
        return strIntern;
    }

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private String m2620() {
        int i2 = (f2674 + 25) % 128;
        f2672 = i2;
        String str = this.f2676;
        int i8 = i2 + 75;
        f2674 = i8 % 128;
        if (i8 % 2 != 0) {
            return str;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static String m2621() {
        int i2 = f2674 + 93;
        f2672 = i2 % 128;
        if (i2 % 2 != 0) {
            aq.m530().mo542();
            throw null;
        }
        String strMo542 = aq.m530().mo542();
        int i8 = f2674 + 79;
        f2672 = i8 % 128;
        if (i8 % 2 != 0) {
            int i9 = 23 / 0;
        }
        return strMo542;
    }

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private String m2622() {
        int i2 = f2674;
        String str = this.f2679;
        int i8 = i2 + 59;
        f2672 = i8 % 128;
        if (i8 % 2 != 0) {
            int i9 = 21 / 0;
        }
        return str;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final String m2624() {
        int i2 = (f2674 + 27) % 128;
        f2672 = i2;
        String str = this.f2675;
        f2674 = (i2 + 101) % 128;
        return str;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public String mo2625() {
        StringBuilder sbR = androidx.camera.core.processing.util.a.r(m2619());
        sbR.append(this.f2678);
        sbR.append(m2623(null, true, new int[]{0, 1, 33, 1}).intern());
        sbR.append(this.f2679);
        sbR.append(m2623("\u0001", true, new int[]{1, 1, 95, 0}).intern());
        sbR.append(m2623("\u0001\u0000\u0001", false, new int[]{2, 3, 95, 2}).intern());
        sbR.append(m2623("\u0001", true, new int[]{1, 1, 95, 0}).intern());
        sbR.append(this.f2675);
        sbR.append(m2623("\u0001", true, new int[]{1, 1, 95, 0}).intern());
        sbR.append(this.f2676);
        String string = sbR.toString();
        int i2 = f2674 + 17;
        f2672 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 5 / 0;
        }
        return string;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final void m2626() {
        int i2 = f2672;
        this.f2677 = false;
        int i8 = i2 + 85;
        f2674 = i8 % 128;
        if (i8 % 2 == 0) {
            int i9 = 42 / 0;
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final String m2627() {
        f2674 = (f2672 + 57) % 128;
        String strReplace = mo2625().replace(m2623(null, true, new int[]{0, 1, 33, 1}).intern(), m2623("\u0001", true, new int[]{1, 1, 95, 0}).intern());
        int i2 = f2674 + 9;
        f2672 = i2 % 128;
        if (i2 % 2 == 0) {
            return strReplace;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final String m2628() {
        int i2 = f2672;
        int i8 = i2 + 85;
        f2674 = i8 % 128;
        if (i8 % 2 == 0) {
            throw null;
        }
        String str = this.f2678;
        int i9 = i2 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE;
        f2674 = i9 % 128;
        if (i9 % 2 != 0) {
            return str;
        }
        throw null;
    }

    private ja(String str, String str2, String str3, String str4) {
        this.f2678 = str;
        this.f2679 = str2;
        this.f2675 = str3;
        this.f2676 = str4;
        this.f2677 = true;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m2623(String str, boolean z2, int[] iArr) throws UnsupportedEncodingException {
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
                System.arraycopy(f2673, i2, cArr, 0, i8);
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

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final String m2629(String str) {
        StringBuilder sbR = androidx.camera.core.processing.util.a.r(m2619());
        sbR.append(m2628());
        sbR.append(m2623(null, true, new int[]{0, 1, 33, 1}).intern());
        sbR.append(m2623("\u0001\u0000\u0001", false, new int[]{2, 3, 95, 2}).intern());
        sbR.append(m2623(null, true, new int[]{0, 1, 33, 1}).intern());
        sbR.append(str);
        sbR.append(m2623(null, true, new int[]{0, 1, 33, 1}).intern());
        sbR.append(m2622());
        sbR.append(m2623("\u0001", true, new int[]{1, 1, 95, 0}).intern());
        sbR.append(m2623("\u0001\u0000\u0001", false, new int[]{2, 3, 95, 2}).intern());
        sbR.append(m2623("\u0001", true, new int[]{1, 1, 95, 0}).intern());
        sbR.append(m2624());
        sbR.append(m2623("\u0001", true, new int[]{1, 1, 95, 0}).intern());
        sbR.append(m2620());
        String string = sbR.toString();
        int i2 = f2674 + 55;
        f2672 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 87 / 0;
        }
        return string;
    }
}
