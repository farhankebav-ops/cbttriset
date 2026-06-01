package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.ironsource.adqualitysdk.sdk.i.bg;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.warren.VungleApiClient;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.Placement;
import com.vungle.warren.persistence.Repository;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class cc extends bg {

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static int f1247 = 0;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static int f1248 = 1;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f1249 = 0;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static long f1250 = 0;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static char f1251 = 21465;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static long f1252 = -4595895092544068391L;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private String f1253;

    public cc(String str) {
        super(str);
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static Class m1498() {
        int i2 = f1247;
        f1248 = (i2 + 43) % 128;
        int i8 = i2 + 1;
        f1248 = i8 % 128;
        if (i8 % 2 != 0) {
            return VungleApiClient.class;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static Map<String, String> m1499(Advertisement advertisement) {
        int i2 = f1247 + 85;
        f1248 = i2 % 128;
        if (i2 % 2 == 0) {
            advertisement.getDownloadableUrls();
            throw null;
        }
        Map<String, String> downloadableUrls = advertisement.getDownloadableUrls();
        int i8 = f1247 + 97;
        f1248 = i8 % 128;
        if (i8 % 2 != 0) {
            return downloadableUrls;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static String m1500() {
        f1248 = (f1247 + 7) % 128;
        Class clsM1498 = m1498();
        hu.m2386().m2389();
        try {
            Iterator<Field> it = hu.m2386().m2389().m2331(clsM1498, hn.m2325().m2323(String.class).m2321(8).m2322(16).m2320()).iterator();
            while (it.hasNext()) {
                f1248 = (f1247 + 101) % 128;
                String str = (String) it.next().get(null);
                if (!str.startsWith(m1504("奈挩柛倚", (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1), "\uef0d⣐쐒\ued87ò\ud82bꛣ\ue2de늒憸ꐸꍴ", Process.myPid() >> 22, "\u0000\u0000\u0000\u0000").intern())) {
                    int i2 = f1248 + 73;
                    f1247 = i2 % 128;
                    if (i2 % 2 != 0) {
                        if (str.startsWith(m1504("\u20c5鮏ﶻ揾", (char) (PointF.length(1.0f, 0.0f) > 0.0f ? 1 : (PointF.length(1.0f, 0.0f) == 0.0f ? 0 : -1)), "\uea8d츋팵퐜텶킝䝕⓱㬊漨组", ImageFormat.getBitsPerPixel(0) - 1147433183, "\u0000\u0000\u0000\u0000").intern())) {
                        }
                    } else if (str.startsWith(m1504("\u20c5鮏ﶻ揾", (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), "\uea8d츋팵퐜텶킝䝕⓱㬊漨组", ImageFormat.getBitsPerPixel(0) - 1147433183, "\u0000\u0000\u0000\u0000").intern())) {
                    }
                }
                return str.split(m1504("ᨿՂ╆‟", (char) (7973 - (ViewConfiguration.getScrollBarFadeDuration() >> 16)), "ᙰ", (Process.myTid() >> 22) + 1174749722, "\u0000\u0000\u0000\u0000").intern())[0];
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static /* synthetic */ String m1501(Advertisement advertisement) {
        int i2 = f1248 + 63;
        f1247 = i2 % 128;
        if (i2 % 2 == 0) {
            return m1505(advertisement);
        }
        m1505(advertisement);
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static boolean m1506(Placement placement) {
        f1247 = (f1248 + 79) % 128;
        boolean zIsIncentivized = placement.isIncentivized();
        int i2 = f1247 + 53;
        f1248 = i2 % 128;
        if (i2 % 2 != 0) {
            return zIsIncentivized;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ Placement m1507(Repository repository, String str) {
        int i2 = f1247 + 37;
        f1248 = i2 % 128;
        int i8 = i2 % 2;
        Placement placementM1502 = m1502(repository, str);
        if (i8 == 0) {
            int i9 = 11 / 0;
        }
        return placementM1502;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ Map m1510(Advertisement advertisement) {
        f1248 = (f1247 + 85) % 128;
        Map<String, String> mapM1499 = m1499(advertisement);
        int i2 = f1248 + 19;
        f1247 = i2 % 128;
        if (i2 % 2 == 0) {
            return mapM1499;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﻛ */
    public final String mo881() {
        f1248 = (f1247 + 75) % 128;
        if (this.f1253 == null) {
            String strM1500 = m1500();
            this.f1253 = strM1500;
            m888(strM1500);
            f1247 = (f1248 + 47) % 128;
        }
        return this.f1253;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m1505(Advertisement advertisement) {
        int i2 = f1248 + 77;
        f1247 = i2 % 128;
        int i8 = i2 % 2;
        String campaign = advertisement.getCampaign();
        if (i8 != 0) {
            int i9 = 78 / 0;
        }
        return campaign;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ String m1508(Advertisement advertisement) {
        int i2 = f1247 + 93;
        f1248 = i2 % 128;
        if (i2 % 2 != 0) {
            return m1503(advertisement);
        }
        m1503(advertisement);
        throw null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ boolean m1511(Placement placement) {
        f1248 = (f1247 + 101) % 128;
        boolean zM1506 = m1506(placement);
        int i2 = f1248 + 33;
        f1247 = i2 % 128;
        if (i2 % 2 == 0) {
            return zM1506;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﻐ */
    public final String mo825() {
        String strMo881;
        int i2 = f1247 + 47;
        f1248 = i2 % 128;
        if (i2 % 2 == 0) {
            strMo881 = mo881();
            int i8 = 43 / 0;
            if (strMo881 == null) {
                return null;
            }
        } else {
            strMo881 = mo881();
            if (strMo881 == null) {
                return null;
            }
        }
        String str = strMo881.split(m1509("\ued05\ued2a\ue701갶\ue56f", (-16777215) - Color.rgb(0, 0, 0)).intern())[1];
        int i9 = f1247 + 95;
        f1248 = i9 % 128;
        if (i9 % 2 == 0) {
            int i10 = 25 / 0;
        }
        return str;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﾇ */
    public final Map<String, bg.a> mo827() {
        HashMap map = new HashMap();
        map.put(m1509("豊谭榪䴖驮펨\ue307跜ὂ\uf54a䜛\ue28dꫯے\uea7a瘠", (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.cc.3
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return cc.m1507((Repository) list.get(0), (String) list.get(1));
            }
        });
        map.put(m1509("㪡㫈됒邸ᖵ屎霦遼ꦦ⣠죍隽ᰀ\udb6f斦ȏ胨俙", View.combineMeasuredStates(0, 0) + 1).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.cc.5
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return Boolean.valueOf(cc.m1511((Placement) list.get(0)));
            }
        });
        map.put(m1504("Ԏຌ녲ꏩ", (char) (KeyEvent.keyCodeFromString("") + 59825), "\u1757퉼用枰በ簼碹蕙낱Λ푸\ue3a7㠈", TextUtils.lastIndexOf("", '0', 0, 0) + 1913555974, "\u0000\u0000\u0000\u0000").intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.cc.2
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return cc.m1508((Advertisement) list.get(0));
            }
        });
        map.put(m1504("\ua6fd댘⩫ⵅ", (char) View.getDefaultSize(0, 0), "ᴤ⛮찈甉㘃鬂ᚷ灏ၚ蛐뱝", 1806899366 - Color.alpha(0), "\u0000\u0000\u0000\u0000").intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.cc.1
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return cc.m1501((Advertisement) list.get(0));
            }
        });
        map.put(m1504("㥋鈻흍멸", (char) (30935 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))), "\ud83c씯겞᳞鹅㺶␟罱峯ဆ\udd35鞼꺵⯴楙\u0b4e\uf298좶䇟", 1301429049 - KeyEvent.keyCodeFromString(""), "\u0000\u0000\u0000\u0000").intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.cc.4
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return cc.m1510((Advertisement) list.get(0));
            }
        });
        int i2 = f1247 + 105;
        f1248 = i2 % 128;
        if (i2 % 2 != 0) {
            return map;
        }
        throw null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0483 A[RETURN] */
    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﻛ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Class mo826(java.lang.String r11) {
        /*
            Method dump skipped, instruction units count: 1290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.cc.mo826(java.lang.String):java.lang.Class");
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m1509(String str, int i2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (i.f2441) {
            try {
                char[] cArrM2497 = i.m2497(f1252, cArr, i2);
                i.f2442 = 4;
                while (true) {
                    int i8 = i.f2442;
                    if (i8 < cArrM2497.length) {
                        i.f2443 = i8 - 4;
                        cArrM2497[i8] = (char) (((long) (cArrM2497[i8] ^ cArrM2497[i8 % 4])) ^ (((long) r2) * f1252));
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

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m1503(Advertisement advertisement) {
        int i2 = f1248 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE;
        f1247 = i2 % 128;
        if (i2 % 2 == 0) {
            return advertisement.getAdMarketId();
        }
        advertisement.getAdMarketId();
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static Placement m1502(Repository repository, String str) {
        int i2 = f1248 + 25;
        f1247 = i2 % 128;
        if (i2 % 2 == 0) {
            return (Placement) repository.load(str, Placement.class).get();
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m1504(String str, char c7, String str2, int i2, String str3) {
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
                        cArr6[i12] = (char) (((((long) (c9 ^ cArr2[i12])) ^ f1250) ^ ((long) f1249)) ^ ((long) f1251));
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
