package com.ironsource.adqualitysdk.sdk.i;

import android.os.Process;
import android.view.KeyEvent;
import android.view.View;
import com.ironsource.adqualitysdk.sdk.i.bg;
import com.moloco.sdk.BuildConfig;
import com.moloco.sdk.publisher.Banner;
import com.moloco.sdk.publisher.BannerAdShowListener;
import com.moloco.sdk.publisher.Moloco;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class bu extends bg {

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static int f1050 = 0;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static int f1051 = 1;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static boolean f1052 = true;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static long f1053 = 4969089938057986733L;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f1054 = 68;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static char[] f1055 = {133, 168, 151, 172, 179, 187, 144, 173, 183, 184, 169, 178, 182, 134, 165, 138, 185, 176, 167, 141, 145, 170, 150, 186, 189, 177, 'r', 175, 188, 154, 171};

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static boolean f1056 = true;

    public bu(String str) {
        super(str);
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static Object m1215() {
        f1051 = (f1050 + 49) % 128;
        Moloco moloco = Moloco.INSTANCE;
        f1051 = (f1050 + 7) % 128;
        return moloco;
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    public static /* synthetic */ Object m1216() {
        f1051 = (f1050 + 55) % 128;
        Object objM1215 = m1215();
        f1051 = (f1050 + 97) % 128;
        return objM1215;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static /* synthetic */ void m1218(Banner banner, BannerAdShowListener bannerAdShowListener) {
        int i2 = f1051 + 51;
        f1050 = i2 % 128;
        int i8 = i2 % 2;
        m1221(banner, bannerAdShowListener);
        if (i8 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ BannerAdShowListener m1219(Banner banner) {
        int i2 = f1050 + 101;
        f1051 = i2 % 128;
        if (i2 % 2 != 0) {
            return m1222(banner);
        }
        m1222(banner);
        throw null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static BannerAdShowListener m1222(Banner banner) {
        int i2 = f1050 + 33;
        f1051 = i2 % 128;
        int i8 = i2 % 2;
        BannerAdShowListener adShowListener = banner.getAdShowListener();
        if (i8 == 0) {
            int i9 = 96 / 0;
        }
        return adShowListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:75:0x025b  */
    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﻛ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Class mo826(java.lang.String r10) {
        /*
            Method dump skipped, instruction units count: 794
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.bu.mo826(java.lang.String):java.lang.Class");
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﻐ */
    public final String mo825() {
        hy hyVarM2388;
        Class<BuildConfig> cls;
        String strM1217;
        int i2 = f1050 + 63;
        f1051 = i2 % 128;
        try {
            if (i2 % 2 == 0) {
                hyVarM2388 = hu.m2386().m2388();
                cls = BuildConfig.class;
                strM1217 = m1217("˳䞆蠧튓ᜭ妚ꉉ\ue4b1⤾玬됡", 23170 >> View.resolveSize(0, 1));
            } else {
                hyVarM2388 = hu.m2386().m2388();
                cls = BuildConfig.class;
                strM1217 = m1217("˳䞆蠧튓ᜭ妚ꉉ\ue4b1⤾玬됡", View.resolveSize(0, 0) + 17783);
            }
            return hyVarM2388.m2439(cls, strM1217.intern());
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﾇ */
    public final Map<String, bg.a> mo827() {
        HashMap map = new HashMap();
        map.put(m1220((String) null, ((Process.getThreadPriority(0) + 20) >> 6) + 127, (int[]) null, "\u008b\u0093\u008c\u008f\u008a\u0089\u008c\u0094\u009c\u0082\u0083\u0085\u0093\u0085\u0092\u0085\u0095\u008a\u008b\u009f").intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bu.4
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bu.m1216();
            }
        });
        map.put(m1217("ˊ\ueda3\udc0f첮뽠꿔鹁褥禇栯壧䭧㯁⪭ᔀ֤\uf474\ue4c5흟옹뚟ꄏ釭", 61291 - View.MeasureSpec.getMode(0)).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bu.1
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bu.m1219((Banner) list.get(0));
            }
        });
        map.put(m1220((String) null, ((byte) KeyEvent.getModifierMetaStateMask()) + 128, (int[]) null, "\u008d\u008b\u008c\u008b\u008a\u0089\u0088\u0087\u0086\u0085\u0084\u0083\u0082\u0081\u008d\u008b\u008c\u008c\u008f\u008e\u008a\u008b\u0089").intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bu.5
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                bu.m1218((Banner) list.get(0), (BannerAdShowListener) list.get(1));
                return null;
            }
        });
        f1050 = (f1051 + 39) % 128;
        return map;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m1217(String str, int i2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (j.f2671) {
            try {
                j.f2669 = i2;
                char[] cArr2 = new char[cArr.length];
                j.f2670 = 0;
                while (true) {
                    int i8 = j.f2670;
                    if (i8 < cArr.length) {
                        cArr2[i8] = (char) (((long) (cArr[i8] ^ (j.f2669 * i8))) ^ f1053);
                        j.f2670++;
                    } else {
                        str2 = new String(cArr2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static void m1221(Banner banner, BannerAdShowListener bannerAdShowListener) {
        f1050 = (f1051 + 31) % 128;
        banner.setAdShowListener(bannerAdShowListener);
        f1050 = (f1051 + 39) % 128;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m1220(String str, int i2, int[] iArr, String str2) throws UnsupportedEncodingException {
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
                char[] cArr2 = f1055;
                int i8 = f1054;
                if (f1052) {
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
                if (f1056) {
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
}
