package com.ironsource.adqualitysdk.sdk.i;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class dt {

    /* JADX INFO: renamed from: 爫, reason: contains not printable characters */
    private static int f1861 = 1;

    /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
    private static boolean f1862;

    /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
    private static boolean f1863;

    /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
    private static int f1864;

    /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
    private static long f1865;

    /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
    private static int f1866;

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static final Pattern f1867;

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static final Pattern f1868;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static char[] f1869;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static final Pattern f1870;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static final List<String> f1871;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static final Pattern f1872;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static final Pattern f1873;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static final Pattern f1874;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static final Pattern f1875;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static final Pattern f1876;

    static {
        m2142();
        f1876 = Pattern.compile(m2143(null, 127 - TextUtils.getOffsetAfter("", 0), null, "\u009c\u0099\u0098\u0097\u009b\u0082\u009a\u0096\u0082\u0095\u0094\u0082\u008c\u0093\u0099\u0098\u0097\u0096\u0082\u0095\u0094\u0082\u008c\u0093\u0092").intern());
        f1875 = Pattern.compile(m2139("ဿၡ囡\ue408럭\uab6f♼ࣚ钽퉗愴₺ᤳ崨\uedeeꐂ鹊\ud892盒㥊", KeyEvent.getDeadChar(0, 0)).intern());
        f1872 = Pattern.compile(m2139("\udca5\udcfb艏䖉捆\u0a56蟽ꧣ堧ۼ삵膆햩覃䱯Ծ勐హ흓顶", View.MeasureSpec.getSize(0)).intern());
        f1873 = Pattern.compile(m2139("楘椆澡㦡軔\ude49\ufbcd緮\uedd9\ueb6f볲嗰怆搑〱턹\ue749\ue1dfꭢ", ViewConfiguration.getKeyRepeatDelay() >> 16).intern());
        f1874 = Pattern.compile(m2143(null, 127 - KeyEvent.keyCodeFromString(""), null, "\u009d\u0099\u009b\u0082\u009a\u0093\u0092").intern());
        f1867 = Pattern.compile(m2139("沙泇⏯塀슚Ñ驽ꍶ\ue85bꜽ\udd44譮旍⡛凬࿗\ue2d0귡쪃銅織㛎佱ᔱטּ멸쏖顺炔㿎䒍ᲂ췲䃀兩\ue797䤪", (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1).intern());
        f1870 = Pattern.compile(m2143(null, TextUtils.getCapsMode("", 0, 0) + 127, null, "\u009e\u009e\u0092").intern());
        f1868 = Pattern.compile(m2139("\ue51b\ue545\u0011妈\ue163䀹鮨\ue3ef懟", TextUtils.indexOf("", "", 0, 0)).intern());
        f1871 = Arrays.asList(m2143(null, 126 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), null, "\u009f\u008e").intern(), m2143(null, 127 - TextUtils.indexOf("", "", 0), null, "\u0084\u008d \u0084").intern(), m2143(null, (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 127, null, "  ¡\u008f").intern(), m2139("\uf680\uf6f2聘\ue4e1愓옚⛉日牊қ", (-1) - ExpandableListView.getPackedPositionChild(0L)).intern(), m2139("띳뜀\ue7b4颸ۯ㙍媔関㎹", (-1) - TextUtils.lastIndexOf("", '0')).intern(), m2143(null, 127 - TextUtils.getOffsetAfter("", 0), null, "¢\u0086\u0091").intern(), m2139("췐춳谹\udc54浶展Ṽﾼ䤀", 1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))).intern());
        int i2 = f1861 + 91;
        f1866 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 24 / 0;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:29:0x005f. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02e1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02a6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02c4 A[SYNTHETIC] */
    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<com.ironsource.adqualitysdk.sdk.i.dx> m2140(java.lang.String r18, java.lang.String r19, java.lang.String r20) {
        /*
            Method dump skipped, instruction units count: 806
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.dt.m2140(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static void m2142() {
        f1862 = true;
        f1863 = true;
        f1864 = 144;
        f1869 = new char[]{205, 189, 220, 245, 264, 258, 191, 213, 255, 176, 256, 241, 259, 249, 254, 247, 260, 238, 235, 266, 209, 234, 180, 239, 237, 192, 201, 186, 187, 182, 246, 252, 261, 265};
        f1865 = 5905120210776154414L;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m2143(String str, int i2, int[] iArr, String str2) throws UnsupportedEncodingException {
        Object bytes = str2;
        if (str2 != null) {
            bytes = str2.getBytes("ISO-8859-1");
        }
        byte[] bArr = (byte[]) bytes;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (m.f2978) {
            try {
                char[] cArr2 = f1869;
                int i8 = f1864;
                if (f1863) {
                    int length = bArr.length;
                    m.f2976 = length;
                    char[] cArr3 = new char[length];
                    m.f2977 = 0;
                    while (m.f2977 < m.f2976) {
                        int i9 = m.f2977;
                        int i10 = m.f2976 - 1;
                        int i11 = m.f2977;
                        cArr3[i9] = (char) (cArr2[bArr[i10 - i11] + i2] - i8);
                        m.f2977 = i11 + 1;
                    }
                    return new String(cArr3);
                }
                if (f1862) {
                    int length2 = cArr.length;
                    m.f2976 = length2;
                    char[] cArr4 = new char[length2];
                    m.f2977 = 0;
                    while (m.f2977 < m.f2976) {
                        int i12 = m.f2977;
                        int i13 = m.f2976 - 1;
                        int i14 = m.f2977;
                        cArr4[i12] = (char) (cArr2[cArr[i13 - i14] - i2] - i8);
                        m.f2977 = i14 + 1;
                    }
                    return new String(cArr4);
                }
                int length3 = iArr.length;
                m.f2976 = length3;
                char[] cArr5 = new char[length3];
                m.f2977 = 0;
                while (m.f2977 < m.f2976) {
                    int i15 = m.f2977;
                    int i16 = m.f2976 - 1;
                    int i17 = m.f2977;
                    cArr5[i15] = (char) (cArr2[iArr[i16 - i17] - i2] - i8);
                    m.f2977 = i17 + 1;
                }
                return new String(cArr5);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m2144(String str) {
        f1861 = (f1866 + 23) % 128;
        String strSubstring = str.substring(1, str.length() - 1);
        f1861 = (f1866 + 83) % 128;
        return strSubstring;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m2141(Pattern pattern, String str) {
        f1866 = (f1861 + 87) % 128;
        Matcher matcher = pattern.matcher(str);
        if (!matcher.find()) {
            return null;
        }
        int i2 = f1866 + 95;
        f1861 = i2 % 128;
        if (i2 % 2 != 0) {
            return str.substring(matcher.start(), matcher.end());
        }
        str.substring(matcher.start(), matcher.end());
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m2139(String str, int i2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (i.f2441) {
            try {
                char[] cArrM2497 = i.m2497(f1865, cArr, i2);
                i.f2442 = 4;
                while (true) {
                    int i8 = i.f2442;
                    if (i8 < cArrM2497.length) {
                        i.f2443 = i8 - 4;
                        cArrM2497[i8] = (char) (((long) (cArrM2497[i8] ^ cArrM2497[i8 % 4])) ^ (((long) r2) * f1865));
                        i.f2442 = i8 + 1;
                    } else {
                        str2 = new String(cArrM2497, 4, cArrM2497.length - 4);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }
}
