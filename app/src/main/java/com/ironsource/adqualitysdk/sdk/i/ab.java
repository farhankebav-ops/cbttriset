package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.webkit.WebView;
import com.ironsource.adqualitysdk.sdk.i.az;
import com.vungle.ads.internal.protos.Sdk;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class ab<T> extends y<WebView, T> implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
    private static int f80 = 1;

    /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
    private static char f81 = 8211;

    /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
    private static int f82 = 0;

    /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
    private static char f83 = 31785;

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static char f84 = 56070;

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static char f85 = 9889;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private jq f86;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private Map<WebView, jt> f87 = new WeakHashMap();

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private List<jm> f88 = new ArrayList();

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private List<String> f89;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private boolean f90;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private String f91;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private boolean f92;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private jt f93;

    /* JADX INFO: renamed from: com.ironsource.adqualitysdk.sdk.i.ab$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class AnonymousClass2 implements jm {

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private static int f94 = 0;

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private static long f95 = -497769966198334775L;

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private static int f96 = 1;

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private static int[] f97 = {1055209900, -1408402207, -1655861278, 1844985199, -724628077, 312100386, -1947292554, 2127500896, 148328153, 561096222, 1548267381, -214468353, -1874008870, -1806255890, 1494073661, -1257785110, 958543292, 1782933041};

        public AnonymousClass2() {
        }

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private void m298(final WebView webView, final String str, final boolean z2) {
            p.m2969(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.ab.2.3
                @Override // com.ironsource.adqualitysdk.sdk.i.iu
                /* JADX INFO: renamed from: ﻐ */
                public final void mo306() {
                    final String originalUrl = webView.getOriginalUrl();
                    final Object objMo297 = ab.this.mo297(webView);
                    p.m2963(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.ab.2.3.3

                        /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
                        private static int f107 = 1;

                        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
                        private static int[] f108 = {-1833447589, -321657379, 151317490, -382395043, 491605187, -1104880914, 1966767750, 661928265, -540506400, -1177989174, -250528450, -1641512400, -1062856170, 1211890969, 217875166, 1535584811, 1436942021, 1256337210};

                        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
                        private static int f109;

                        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
                        private static String m307(int[] iArr, int i2) {
                            String str2;
                            synchronized (d.f1664) {
                                try {
                                    char[] cArr = new char[4];
                                    char[] cArr2 = new char[iArr.length << 1];
                                    int[] iArr2 = (int[]) f108.clone();
                                    d.f1665 = 0;
                                    while (true) {
                                        int i8 = d.f1665;
                                        if (i8 < iArr.length) {
                                            int i9 = iArr[i8];
                                            char c7 = (char) (i9 >> 16);
                                            cArr[0] = c7;
                                            char c8 = (char) i9;
                                            cArr[1] = c8;
                                            char c9 = (char) (iArr[i8 + 1] >> 16);
                                            cArr[2] = c9;
                                            char c10 = (char) iArr[i8 + 1];
                                            cArr[3] = c10;
                                            d.f1663 = (c7 << 16) + c8;
                                            d.f1666 = (c9 << 16) + c10;
                                            d.m1895(iArr2);
                                            for (int i10 = 0; i10 < 16; i10++) {
                                                int i11 = d.f1663 ^ iArr2[i10];
                                                d.f1663 = i11;
                                                int iM1894 = d.m1894(i11) ^ d.f1666;
                                                int i12 = d.f1663;
                                                d.f1663 = iM1894;
                                                d.f1666 = i12;
                                            }
                                            int i13 = d.f1663;
                                            int i14 = d.f1666;
                                            d.f1663 = i14;
                                            d.f1666 = i13;
                                            int i15 = i13 ^ iArr2[16];
                                            d.f1666 = i15;
                                            int i16 = i14 ^ iArr2[17];
                                            d.f1663 = i16;
                                            cArr[0] = (char) (i16 >>> 16);
                                            cArr[1] = (char) i16;
                                            cArr[2] = (char) (i15 >>> 16);
                                            cArr[3] = (char) i15;
                                            d.m1895(iArr2);
                                            int i17 = d.f1665;
                                            cArr2[i17 << 1] = cArr[0];
                                            cArr2[(i17 << 1) + 1] = cArr[1];
                                            cArr2[(i17 << 1) + 2] = cArr[2];
                                            cArr2[(i17 << 1) + 3] = cArr[3];
                                            d.f1665 = i17 + 2;
                                        } else {
                                            str2 = new String(cArr2, 0, i2);
                                        }
                                    }
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            return str2;
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // com.ironsource.adqualitysdk.sdk.i.iu
                        /* JADX INFO: renamed from: ﻐ */
                        public final void mo306() {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put(ig.f2511, str);
                                jSONObject.put(ig.f2509, m307(new int[]{-1093468707, -1184874988}, TextUtils.indexOf((CharSequence) "", '0', 0) + 4).intern());
                                jSONObject.put(ig.f2519, originalUrl);
                                if (z2) {
                                    f109 = (f107 + 87) % 128;
                                    jSONObject.put(ig.f2518, true);
                                }
                                f109 = (f107 + 115) % 128;
                            } catch (JSONException e) {
                                String strIntern = m307(new int[]{2064591548, -1891404573, -454032359, -2120222581, 2088671300, 153185008, 988244711, -1187597234}, 16 - Color.argb(0, 0, 0, 0)).intern();
                                StringBuilder sb = new StringBuilder();
                                sb.append(m307(new int[]{-306652385, -1314805208, 1606296723, 535034762, -1144467017, 1157631943, -2048591997, -1710748438, -524071306, -664469547, 99119517, -1683860844, 1689526059, 298999620}, 27 - Color.green(0)).intern());
                                sb.append(e.getLocalizedMessage());
                                k.m2863(strIntern, sb.toString());
                            }
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            ab abVar = ab.this;
                            abVar.mo333(jSONObject, webView, ab.m286(abVar), objMo297);
                        }
                    });
                }
            });
            f94 = (f96 + 87) % 128;
        }

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        public static /* synthetic */ void m300(AnonymousClass2 anonymousClass2, WebView webView, String str, boolean z2) {
            f94 = (f96 + 5) % 128;
            anonymousClass2.m298(webView, str, z2);
            f94 = (f96 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.ironsource.adqualitysdk.sdk.i.jm
        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        public final void mo302(WebView webView, String str, String str2) {
            String strSubstring = str2.substring(0, str2.indexOf(63));
            String strSubstring2 = str2.substring(str2.indexOf(63) + 1);
            if (strSubstring.equals(m299("\udaba旖ꑽ\ue4eb✄枻", Color.alpha(0) + 49003).intern())) {
                ab.m283(ab.this, webView);
                return;
            }
            if (strSubstring.equals(m301(new int[]{1674931626, -602125259, -2020799924, -426679219}, Color.red(0) + 6).intern())) {
                JSONObject jSONObjectM280 = ab.m280(strSubstring2);
                ab abVar = ab.this;
                abVar.m292(jSONObjectM280, webView, abVar.mo297(webView));
                return;
            }
            if (strSubstring.equals(m299("\udaba쪄龎\uea01驌讵", 4153 - Drawable.resolveOpacity(0, 0)).intern())) {
                JSONObject jSONObjectM2802 = ab.m280(strSubstring2);
                ab abVar2 = ab.this;
                abVar2.mo329(jSONObjectM2802, webView, ab.m286(abVar2), ab.this.mo297(webView));
                return;
            }
            if (!strSubstring.equals(m301(new int[]{1674931626, -602125259, 2100816822, 1322208804}, (ViewConfiguration.getPressedStateDuration() >> 16) + 6).intern())) {
                if (strSubstring.equals(m301(new int[]{1674931626, -602125259, -1165134394, -710476610}, Color.rgb(0, 0, 0) + 16777222).intern())) {
                    f96 = (f94 + 79) % 128;
                    JSONObject jSONObjectM2803 = ab.m280(strSubstring2);
                    kd.m2915(jSONObjectM2803.optString(m301(new int[]{-2144618583, -2106877766}, 3 - (ViewConfiguration.getWindowTouchSlop() >> 8)).intern()), jSONObjectM2803.optString(m299("\udaac⚌⋊⸟⩲", (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 64567).intern()), jSONObjectM2803.optString(m299("\udaac謜秤⹓鰱䋯", (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 20903).intern()), jSONObjectM2803.optString(m301(new int[]{-1404576880, -204660285, -40981655, -1054455548}, (Process.myTid() >> 22) + 5).intern()));
                    return;
                }
                return;
            }
            int i2 = f94 + 25;
            f96 = i2 % 128;
            if (i2 % 2 != 0) {
                JSONObject jSONObjectM2804 = ab.m280(strSubstring2);
                jSONObjectM2804.remove(ig.f2520);
                ab abVar3 = ab.this;
                abVar3.mo332(jSONObjectM2804, webView, abVar3.mo297(webView));
                return;
            }
            JSONObject jSONObjectM2805 = ab.m280(strSubstring2);
            jSONObjectM2805.remove(ig.f2520);
            ab abVar4 = ab.this;
            abVar4.mo332(jSONObjectM2805, webView, abVar4.mo297(webView));
            throw null;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.jm
        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        public final void mo304(WebView webView) {
            int i2 = f96 + 99;
            f94 = i2 % 128;
            if (i2 % 2 == 0) {
                ab.m283(ab.this, webView);
            } else {
                ab.m283(ab.this, webView);
                int i8 = 20 / 0;
            }
        }

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private static String m299(String str, int i2) {
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
                            cArr2[i8] = (char) (((long) (cArr[i8] ^ (j.f2669 * i8))) ^ f95);
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

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.ironsource.adqualitysdk.sdk.i.jm
        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        public final void mo305(WebView webView, String str) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ig.f2521, str);
                jSONObject.put(ig.f2514, ig.f2513);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(ig.f2522, jSONObject);
                ab abVar = ab.this;
                abVar.mo331(jSONObject2, webView, this, abVar.mo297(webView));
                f94 = (f96 + 115) % 128;
            } catch (Exception e) {
                kd.m2919(m301(new int[]{-690014451, 1247474889, 575463023, 1687671669, -358889272, 1871995032, -1829202267, 1399157597}, 16 - Gravity.getAbsoluteGravity(0, 0)).intern(), m299("\uda8c⧌㱕Ãᝧᮺ湠狺䄔喇堛경댳螥詫饇\uedda\uf04d쒷쭹\udff3≯㚝Ԍু᰼悬眫箣", 62327 - (ViewConfiguration.getTapTimeout() >> 16)).intern(), e, false);
            }
        }

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private static String m301(int[] iArr, int i2) {
            String str;
            synchronized (d.f1664) {
                try {
                    char[] cArr = new char[4];
                    char[] cArr2 = new char[iArr.length << 1];
                    int[] iArr2 = (int[]) f97.clone();
                    d.f1665 = 0;
                    while (true) {
                        int i8 = d.f1665;
                        if (i8 < iArr.length) {
                            int i9 = iArr[i8];
                            char c7 = (char) (i9 >> 16);
                            cArr[0] = c7;
                            char c8 = (char) i9;
                            cArr[1] = c8;
                            char c9 = (char) (iArr[i8 + 1] >> 16);
                            cArr[2] = c9;
                            char c10 = (char) iArr[i8 + 1];
                            cArr[3] = c10;
                            d.f1663 = (c7 << 16) + c8;
                            d.f1666 = (c9 << 16) + c10;
                            d.m1895(iArr2);
                            for (int i10 = 0; i10 < 16; i10++) {
                                int i11 = d.f1663 ^ iArr2[i10];
                                d.f1663 = i11;
                                int iM1894 = d.m1894(i11) ^ d.f1666;
                                int i12 = d.f1663;
                                d.f1663 = iM1894;
                                d.f1666 = i12;
                            }
                            int i13 = d.f1663;
                            int i14 = d.f1666;
                            d.f1663 = i14;
                            d.f1666 = i13;
                            int i15 = i13 ^ iArr2[16];
                            d.f1666 = i15;
                            int i16 = i14 ^ iArr2[17];
                            d.f1663 = i16;
                            cArr[0] = (char) (i16 >>> 16);
                            cArr[1] = (char) i16;
                            cArr[2] = (char) (i15 >>> 16);
                            cArr[3] = (char) i15;
                            d.m1895(iArr2);
                            int i17 = d.f1665;
                            cArr2[i17 << 1] = cArr[0];
                            cArr2[(i17 << 1) + 1] = cArr[1];
                            cArr2[(i17 << 1) + 2] = cArr[2];
                            cArr2[(i17 << 1) + 3] = cArr[3];
                            d.f1665 = i17 + 2;
                        } else {
                            str = new String(cArr2, 0, i2);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return str;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.jm
        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        public final void mo303(final WebView webView, final String str, final boolean z2) {
            p.m2963(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.ab.2.2
                @Override // com.ironsource.adqualitysdk.sdk.i.iu
                /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
                public final void mo306() {
                    if (ab.m285(ab.this)) {
                        if (ab.m279(ab.this) == null || ab.m279(ab.this).isEmpty()) {
                            AnonymousClass2.m300(AnonymousClass2.this, webView, str, z2);
                            return;
                        }
                        Iterator it = ab.m279(ab.this).iterator();
                        while (it.hasNext()) {
                            if (str.startsWith((String) it.next())) {
                                AnonymousClass2.m300(AnonymousClass2.this, webView, str, z2);
                                return;
                            }
                        }
                    }
                }
            });
            f96 = (f94 + 53) % 128;
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ List m279(ab abVar) {
        int i2 = f82 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE;
        f80 = i2 % 128;
        int i8 = i2 % 2;
        List<String> list = abVar.f89;
        if (i8 != 0) {
            return list;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ void m283(ab abVar, WebView webView) {
        int i2 = f82 + 17;
        f80 = i2 % 128;
        int i8 = i2 % 2;
        abVar.m275(webView);
        if (i8 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ az.e m286(ab abVar) {
        f80 = (f82 + 3) % 128;
        az.e eVarM282 = abVar.m282();
        int i2 = f82 + 11;
        f80 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 10 / 0;
        }
        return eVarM282;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i2, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
        int i15 = f82;
        int i16 = i15 + 65;
        f80 = i16 % 128;
        try {
            if (i16 % 2 == 0) {
                throw null;
            }
            if (view instanceof WebView) {
                f80 = (i15 + 81) % 128;
                WebView webView = (WebView) view;
                if (this.f87.containsKey(webView)) {
                    int i17 = f82 + 67;
                    f80 = i17 % 128;
                    if (i17 % 2 == 0) {
                        m275(webView);
                        throw null;
                    }
                    m275(webView);
                }
            }
            f82 = (f80 + 93) % 128;
        } catch (Throwable th) {
            kd.m2919(m278("ﵛ蜮碝㬓重盃뀇㈏\u3104ܨ壖Ź\ue8f3풵䎙틵", 16 - KeyEvent.getDeadChar(0, 0)).intern(), m278("駧鴫ᷕ罪\udea6㈾ꕍ斑\ue145㣖⾆욉볨⌶퀊\uee39勜ᄠ圠툸일ᮚ㽶諘", Gravity.getAbsoluteGravity(0, 0) + 23).intern(), th, false);
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final void m287() {
        for (WebView webView : this.f87.keySet()) {
            webView.removeOnLayoutChangeListener(this);
            jt jtVar = this.f87.get(webView);
            Iterator<jm> it = this.f88.iterator();
            while (it.hasNext()) {
                f80 = (f82 + 99) % 128;
                jtVar.m2770(it.next());
            }
            f82 = (f80 + 43) % 128;
        }
        this.f88.clear();
        this.f93 = null;
        this.f87.clear();
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final void m289(String str, List<String> list, boolean z2, boolean z7, boolean z8) {
        this.f92 = z2;
        this.f86 = new jq(str, z8);
        this.f90 = z7;
        this.f89 = list;
        f80 = (f82 + 95) % 128;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public abstract T mo297(WebView webView);

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ JSONObject m280(String str) {
        int i2 = f80 + 107;
        f82 = i2 % 128;
        if (i2 % 2 == 0) {
            return m274(str);
        }
        m274(str);
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ironsource.adqualitysdk.sdk.i.y, com.ironsource.adqualitysdk.sdk.i.s
    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final /* synthetic */ void mo296(JSONObject jSONObject, Object obj, Object obj2) {
        f82 = (f80 + 35) % 128;
        m284(jSONObject, (WebView) obj, obj2);
        int i2 = f82 + 53;
        f80 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ boolean m285(ab abVar) {
        int i2 = f80;
        int i8 = i2 + 75;
        f82 = i8 % 128;
        int i9 = i8 % 2;
        boolean z2 = abVar.f90;
        if (i9 != 0) {
            int i10 = 97 / 0;
        }
        f82 = (i2 + 19) % 128;
        return z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ironsource.adqualitysdk.sdk.i.y, com.ironsource.adqualitysdk.sdk.i.s
    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final /* bridge */ /* synthetic */ void mo293(JSONObject jSONObject, Object obj, Object obj2) {
        f82 = (f80 + 31) % 128;
        m292(jSONObject, (WebView) obj, obj2);
        int i2 = f80 + 75;
        f82 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 54 / 0;
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private jm m277() {
        AnonymousClass2 anonymousClass2 = new AnonymousClass2();
        f80 = (f82 + 5) % 128;
        return anonymousClass2;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private az.e m282() {
        jt jtVar = this.f93;
        if (jtVar == null) {
            return null;
        }
        f80 = (f82 + 91) % 128;
        az.e eVarM2768 = jtVar.m2768();
        f80 = (f82 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
        return eVarM2768;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private void m281(WebView webView) {
        f82 = (f80 + 15) % 128;
        this.f86.m2760(webView);
        f82 = (f80 + 53) % 128;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final WebView m288() {
        jt jtVar = this.f93;
        if (jtVar != null) {
            f82 = (f80 + 105) % 128;
            return jtVar.m2769();
        }
        int i2 = f80 + 17;
        f82 = i2 % 128;
        if (i2 % 2 == 0) {
            return null;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.y
    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final String mo291(T t3) {
        int i2 = (f80 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE) % 128;
        f82 = i2;
        String str = this.f91;
        f80 = (i2 + 87) % 128;
        return str;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final void m292(JSONObject jSONObject, WebView webView, T t3) {
        f80 = (f82 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE) % 128;
        m276(jSONObject, webView);
        super.mo293(jSONObject, webView, (Object) t3);
        int i2 = f82 + 3;
        f80 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final void m294(WebView webView) {
        int i2 = f80 + 87;
        f82 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 49 / 0;
            if (webView == null) {
                return;
            }
        } else if (webView == null) {
            return;
        }
        if (this.f87.containsKey(webView)) {
            return;
        }
        jt jtVarM2766 = jt.m2766(webView, m278("\udc68\ufdda㞦ᵘ욯⻦훇\ufbcb洍\ue505", ((Process.getThreadPriority(0) + 20) >> 6) + 9).intern());
        if (this.f93 == null) {
            int i9 = (f82 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE) % 128;
            f80 = i9;
            this.f93 = jtVarM2766;
            f82 = (i9 + 63) % 128;
        }
        this.f87.put(webView, jtVarM2766);
        jm jmVarM277 = m277();
        this.f88.add(jmVarM277);
        jtVarM2766.m2774(jmVarM277);
        m275(webView);
        webView.addOnLayoutChangeListener(this);
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final void m290(List<WebView> list) {
        if (list != null) {
            f80 = (f82 + 55) % 128;
            Iterator<WebView> it = list.iterator();
            while (it.hasNext()) {
                m294(it.next());
                f80 = (f82 + 105) % 128;
            }
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m278(String str, int i2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (o.f2985) {
            try {
                char[] cArr2 = new char[cArr.length];
                o.f2986 = 0;
                char[] cArr3 = new char[2];
                while (true) {
                    int i8 = o.f2986;
                    if (i8 < cArr.length) {
                        cArr3[0] = cArr[i8];
                        cArr3[1] = cArr[i8 + 1];
                        int i9 = 58224;
                        for (int i10 = 0; i10 < 16; i10++) {
                            char c7 = cArr3[1];
                            char c8 = cArr3[0];
                            char c9 = (char) (c7 - (((c8 + i9) ^ ((c8 << 4) + f81)) ^ ((c8 >>> 5) + f83)));
                            cArr3[1] = c9;
                            cArr3[0] = (char) (c8 - (((c9 >>> 5) + f84) ^ ((c9 + i9) ^ ((c9 << 4) + f85))));
                            i9 -= 40503;
                        }
                        int i11 = o.f2986;
                        cArr2[i11] = cArr3[0];
                        cArr2[i11 + 1] = cArr3[1];
                        o.f2986 = i11 + 2;
                    } else {
                        str2 = new String(cArr2, 0, i2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private void m275(WebView webView) {
        jt jtVar = this.f87.get(webView);
        if (this.f92 && jtVar.m2772()) {
            int i2 = f82 + 67;
            f80 = i2 % 128;
            if (i2 % 2 != 0) {
                if (!kf.m2945(webView)) {
                    f82 = (f80 + 97) % 128;
                    jtVar.m2773();
                }
                m281(webView);
                f80 = (f82 + 71) % 128;
            } else {
                kf.m2945(webView);
                throw null;
            }
        }
        int i8 = f80 + 59;
        f82 = i8 % 128;
        if (i8 % 2 != 0) {
            int i9 = 88 / 0;
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static JSONObject m274(String str) {
        f82 = (f80 + 99) % 128;
        try {
            String strDecode = URLDecoder.decode(str, m278("ᣂ㫪㓓\udfcaꕛ禍", 5 - (ViewConfiguration.getScrollDefaultDelay() >> 16)).intern());
            if (!TextUtils.isEmpty(strDecode)) {
                return new JSONObject(strDecode);
            }
        } catch (Exception e) {
            k.m2861(m278("ﵛ蜮碝㬓重盃뀇㈏\u3104ܨ壖Ź\ue8f3풵䎙틵", 16 - (ViewConfiguration.getMaximumFlingVelocity() >> 16)).intern(), m278("駧鴫ᷕ罪\udea6㈾⦌比\udc21ၸꕍ斑\ud803\uf395퍑⤰烠葧", ((Process.getThreadPriority(0) + 20) >> 6) + 18).intern(), (Throwable) e);
        }
        JSONObject jSONObject = new JSONObject();
        int i2 = f80 + 115;
        f82 = i2 % 128;
        if (i2 % 2 == 0) {
            return jSONObject;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static void m276(JSONObject jSONObject, WebView webView) {
        boolean z2;
        if (webView != null) {
            f80 = (f82 + 113) % 128;
            try {
                String str = ig.f2478;
                if (webView.getWindowToken() != null) {
                    f80 = (f82 + 19) % 128;
                    z2 = true;
                } else {
                    z2 = false;
                }
                jSONObject.put(str, z2);
            } catch (JSONException unused) {
            }
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final void m295(String str) {
        int i2 = f80 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE;
        int i8 = i2 % 128;
        f82 = i8;
        int i9 = i2 % 2;
        this.f91 = str;
        if (i9 != 0) {
            throw null;
        }
        int i10 = i8 + 41;
        f80 = i10 % 128;
        if (i10 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private void m284(JSONObject jSONObject, WebView webView, T t3) {
        f82 = (f80 + 113) % 128;
        jSONObject.remove(ig.f2520);
        super.mo296(jSONObject, webView, (Object) t3);
        f80 = (f82 + 1) % 128;
    }
}
