package com.ironsource.adqualitysdk.sdk.i;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Process;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.RequiresApi;
import com.vungle.ads.internal.protos.Sdk;
import java.lang.reflect.Field;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class kf {

    /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
    private static int f2962 = 1;

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static char[] f2963;

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static int f2964;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static long f2965;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static b f2966;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static b f2967;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static boolean f2968;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static boolean f2969;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static boolean f2970;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static boolean f2971;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static boolean f2972;

    static {
        m2954();
        f2972 = true;
        f2970 = true;
        f2971 = true;
        byte b8 = 0;
        f2968 = false;
        f2969 = false;
        f2966 = new b(b8);
        f2967 = new b(b8);
        f2962 = (f2964 + 109) % 128;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static synchronized av m2938() {
        av avVarMo545;
        try {
            int i2 = f2962 + 45;
            f2964 = i2 % 128;
            if (i2 % 2 != 0) {
                avVarMo545 = aq.m530().mo545();
                int i8 = 95 / 0;
            } else {
                avVarMo545 = aq.m530().mo545();
            }
        } catch (Throwable th) {
            throw th;
        }
        return avVarMo545;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static boolean m2945(WebView webView) {
        f2964 = (f2962 + 71) % 128;
        boolean z2 = m2950(webView) instanceof hh;
        int i2 = f2962 + 45;
        f2964 = i2 % 128;
        if (i2 % 2 == 0) {
            return z2;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static hs<WebViewClient> m2946(WebView webView) {
        int i2 = f2964 + 83;
        f2962 = i2 % 128;
        if (i2 % 2 != 0) {
            m2949(webView.getContext());
            return m2947(webView, m2943(), f2966);
        }
        m2949(webView.getContext());
        m2947(webView, m2943(), f2966);
        throw null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static WebViewClient m2950(WebView webView) {
        f2962 = (f2964 + 23) % 128;
        if (Build.VERSION.SDK_INT >= 26 && m2938().m642()) {
            int i2 = f2962 + 7;
            f2964 = i2 % 128;
            if (i2 % 2 != 0) {
                m2941(webView.getContext());
                throw null;
            }
            if (m2941(webView.getContext())) {
                return webView.getWebViewClient();
            }
        }
        hs<WebViewClient> hsVarM2946 = m2946(webView);
        if (hsVarM2946 == null) {
            throw new RuntimeException(m2944((char) ((Process.myPid() >> 22) + 13968), View.combineMeasuredStates(0, 0) + 33, AndroidCharacter.getMirror('0') - 22).intern());
        }
        WebViewClient webViewClientMo2359 = hsVarM2946.mo2359();
        f2964 = (f2962 + 87) % 128;
        return webViewClientMo2359;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static void m2954() {
        f2963 = new char[]{'j', 45038, 24424, 3788, 48719, 28072, 7464, 52352, 31752, 11379, 56236, 35648, 15042, 59938, 39358, 18761, 63633, 43019, 22625, 2047, 46852, 26265, '\"', 44966, 24375, 3734, 14035, 39280, 27131, 14417, 35016, 23349, 11245, 64013, 19144, 6897, 60783, 48603, 3136, 56563, 44821, 32660, 52738, 40633, 28407, 12648, 33227, 20584, 8374, 62240, 17309, 4617, 57954, 45733, 1362, 54730, 42039, 29869, 50964, 62779, 23192, 43539, 64441, 19232, 39133, 59397, 14821, 35104, 55577, 11911, 32307, 53160, 7963, 27901, 48252, 3562, 23876, 44318, 62103, 16955, 37806, 58199, 12514, 32892, 53734, 8603, 28931, 50856, 5739, 26588, 46912, 1277, 21627, 42466, 'W', 45034, 24444, 3835, 48725, 28078, 7469, 52412, 31756, 11374, 56314, 35670, 60031, 17863, 46422, 58616, 21620, 34769, 63235, 9915, 38439, 50782, 12743, 24950, 53472, 30, 29640, 41789, 4773, 16951, 45588, 60878, 23928, 36079, 64533, 12177, 40818, 52910, 16080, 28230, 55803, 2407, 30860, 43032, 'E', 45053, 24428, 3778, 48718, 28139, 7481, 52353, 31773, 11364, 56317, 35660, 15066, 59940, 39410, 18696, 63638, 43103, 22653, 2044, 46913, 26334, 5738, 50574, 29965, 9365, 54480, 33916, 13249, 58180, 37505, 16957, 61833, 41226, 20624, 249, 'E', 45053, 24428, 3778, 48718, 28139, 7485, 52364, 31756, 11379, 56319, 35659, 15059, 60003, 39345, 18701, 63641, 43034, 22624, 2025, 46860, 26333, 5667, 50620, 29956, 9363};
        f2965 = 6057517208486588303L;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static hs<WebChromeClient> m2939(WebView webView) {
        f2964 = (f2962 + 35) % 128;
        m2949(webView.getContext());
        hs<WebChromeClient> hsVarM2947 = m2947(webView, m2948(), f2967);
        f2964 = (f2962 + 73) % 128;
        return hsVarM2947;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static <T> hs<T> m2942(WebView webView, ia iaVar, List<String> list, int i2) {
        f2962 = (f2964 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE) % 128;
        hs<T> hsVarM2951 = m2951(webView, iaVar, list, i2);
        f2964 = (f2962 + 101) % 128;
        return hsVarM2951;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static void m2955(WebView webView, String str) {
        if (webView != null) {
            f2962 = (f2964 + 89) % 128;
            if (webView.getHandler() == null) {
                int i2 = f2962 + 3;
                f2964 = i2 % 128;
                if (i2 % 2 != 0) {
                    int i8 = 90 / 0;
                    if (webView.getRootView() == null) {
                        return;
                    }
                } else if (webView.getRootView() == null) {
                    return;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(m2944((char) Color.alpha(0), View.MeasureSpec.makeMeasureSpec(0, 0) + 22, ViewConfiguration.getMaximumDrawingCacheSize() >> 24).intern());
            sb.append(str);
            sb.append(m2944((char) (ViewConfiguration.getWindowTouchSlop() >> 8), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 4, 22 - View.resolveSizeAndState(0, 0, 0)).intern());
            webView.loadUrl(sb.toString());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class b {

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private boolean f2974;

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private boolean f2975;

        private b() {
            this.f2974 = false;
            this.f2975 = false;
        }

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private boolean m2957() {
            return this.f2974;
        }

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        public final void m2958() {
            this.f2975 = true;
        }

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        public final boolean m2959() {
            return m2957() || m2961();
        }

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        public final void m2960() {
            this.f2974 = true;
        }

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        public final boolean m2961() {
            return this.f2975;
        }

        public /* synthetic */ b(byte b8) {
            this();
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static ia m2943() {
        ia iaVar = new ia() { // from class: com.ironsource.adqualitysdk.sdk.i.kf.6
            @Override // com.ironsource.adqualitysdk.sdk.i.ia
            /* JADX INFO: renamed from: ﾇ */
            public final boolean mo1908(hs hsVar) {
                return WebViewClient.class.equals(hsVar.mo2360().getType());
            }
        };
        f2964 = (f2962 + 21) % 128;
        return iaVar;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m2944(char c7, int i2, int i8) {
        String str;
        synchronized (c.f1192) {
            try {
                char[] cArr = new char[i2];
                c.f1193 = 0;
                while (true) {
                    int i9 = c.f1193;
                    if (i9 < i2) {
                        cArr[i9] = (char) ((((long) f2963[i8 + i9]) ^ (((long) i9) * f2965)) ^ ((long) c7));
                        c.f1193 = i9 + 1;
                    } else {
                        str = new String(cArr);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    @RequiresApi(api = 26)
    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static boolean m2941(Context context) {
        boolean z2;
        int i2 = f2964 + 93;
        f2962 = i2 % 128;
        if (i2 % 2 != 0) {
            if (f2970) {
                try {
                    f2970 = false;
                    WebView webView = new WebView(context);
                    hh hhVar = new hh(null, new WebViewClient() { // from class: com.ironsource.adqualitysdk.sdk.i.kf.2
                    });
                    webView.setWebViewClient(hhVar);
                    if (hhVar == webView.getWebViewClient()) {
                        f2964 = (f2962 + 9) % 128;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    f2968 = z2;
                } catch (Throwable th) {
                    kd.m2919(m2944((char) View.MeasureSpec.makeMeasureSpec(0, 0), TextUtils.indexOf((CharSequence) "", '0', 0) + 13, 94 - TextUtils.indexOf("", "")).intern(), m2944((char) (ViewConfiguration.getFadingEdgeLength() >> 16), ImageFormat.getBitsPerPixel(0) + 37, 138 - View.MeasureSpec.getSize(0)).intern(), th, false);
                }
            }
            return f2968;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static void m2949(Context context) {
        f2962 = (f2964 + 63) % 128;
        if (f2972) {
            f2972 = false;
            try {
                WebView webView = new WebView(context);
                hh hhVar = new hh(null, new WebViewClient() { // from class: com.ironsource.adqualitysdk.sdk.i.kf.3
                });
                webView.setWebViewClient(hhVar);
                hk hkVar = new hk(null, new WebChromeClient() { // from class: com.ironsource.adqualitysdk.sdk.i.kf.5
                });
                webView.setWebChromeClient(hkVar);
                f2966 = m2952(webView, hhVar, m2943());
                f2967 = m2952(webView, hkVar, m2948());
                int i2 = f2962 + 53;
                f2964 = i2 % 128;
                if (i2 % 2 != 0) {
                    throw null;
                }
            } catch (Throwable th) {
                kd.m2919(m2944((char) KeyEvent.keyCodeFromString(""), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 11, 94 - (KeyEvent.getMaxKeyCode() >> 16)).intern(), m2944((char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 59961), View.resolveSizeAndState(0, 0, 0) + 32, Color.rgb(0, 0, 0) + 16777322).intern(), th, false);
            }
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static WebChromeClient m2953(WebView webView) {
        if (Build.VERSION.SDK_INT >= 26 && m2938().m639()) {
            int i2 = f2964 + 113;
            f2962 = i2 % 128;
            if (i2 % 2 != 0) {
                if (m2956(webView.getContext())) {
                    f2964 = (f2962 + 41) % 128;
                    WebChromeClient webChromeClient = webView.getWebChromeClient();
                    f2964 = (f2962 + 53) % 128;
                    return webChromeClient;
                }
            } else {
                m2956(webView.getContext());
                throw null;
            }
        }
        hs<WebChromeClient> hsVarM2939 = m2939(webView);
        if (hsVarM2939 != null) {
            return hsVarM2939.mo2359();
        }
        throw new RuntimeException(m2944((char) (TextUtils.indexOf((CharSequence) "", '0') + 62841), 35 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 59).intern());
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0044 A[PHI: r4
  0x0044: PHI (r4v11 java.lang.Object) = (r4v7 java.lang.Object), (r4v15 java.lang.Object) binds: [B:10:0x0036, B:7:0x002f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0076  */
    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static <T> com.ironsource.adqualitysdk.sdk.i.kf.b m2952(android.webkit.WebView r4, T r5, com.ironsource.adqualitysdk.sdk.i.ia r6) {
        /*
            com.ironsource.adqualitysdk.sdk.i.kf$b r0 = new com.ironsource.adqualitysdk.sdk.i.kf$b
            r1 = 0
            r0.<init>(r1)
            com.ironsource.adqualitysdk.sdk.i.av r2 = m2938()
            java.util.List r2 = r2.m643()
            com.ironsource.adqualitysdk.sdk.i.av r3 = m2938()
            int r3 = r3.m640()
            com.ironsource.adqualitysdk.sdk.i.hs r4 = m2942(r4, r6, r2, r3)
            if (r4 == 0) goto L79
            int r2 = com.ironsource.adqualitysdk.sdk.i.kf.f2964
            int r2 = r2 + 53
            int r3 = r2 % 128
            com.ironsource.adqualitysdk.sdk.i.kf.f2962 = r3
            int r2 = r2 % 2
            if (r2 != 0) goto L32
            java.lang.Object r4 = r4.mo2359()
            r2 = 31
            int r2 = r2 / r1
            if (r4 != r5) goto L44
            goto L38
        L32:
            java.lang.Object r4 = r4.mo2359()
            if (r4 != r5) goto L44
        L38:
            r0.m2960()
            int r4 = com.ironsource.adqualitysdk.sdk.i.kf.f2962
            int r4 = r4 + 69
            int r4 = r4 % 128
            com.ironsource.adqualitysdk.sdk.i.kf.f2964 = r4
            goto L79
        L44:
            com.ironsource.adqualitysdk.sdk.i.av r2 = m2938()
            java.util.List r2 = r2.m641()
            com.ironsource.adqualitysdk.sdk.i.av r3 = m2938()
            int r3 = r3.m644()
            com.ironsource.adqualitysdk.sdk.i.hs r4 = m2940(r4, r6, r2, r3)
            if (r4 == 0) goto L79
            int r6 = com.ironsource.adqualitysdk.sdk.i.kf.f2962
            int r6 = r6 + 17
            int r2 = r6 % 128
            com.ironsource.adqualitysdk.sdk.i.kf.f2964 = r2
            int r6 = r6 % 2
            if (r6 == 0) goto L70
            java.lang.Object r4 = r4.mo2359()
            r6 = 14
            int r6 = r6 / r1
            if (r4 != r5) goto L79
            goto L76
        L70:
            java.lang.Object r4 = r4.mo2359()
            if (r4 != r5) goto L79
        L76:
            r0.m2958()
        L79:
            int r4 = com.ironsource.adqualitysdk.sdk.i.kf.f2962
            int r4 = r4 + 61
            int r5 = r4 % 128
            com.ironsource.adqualitysdk.sdk.i.kf.f2964 = r5
            int r4 = r4 % 2
            if (r4 == 0) goto L88
            r4 = 30
            int r4 = r4 / r1
        L88:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.kf.m2952(android.webkit.WebView, java.lang.Object, com.ironsource.adqualitysdk.sdk.i.ia):com.ironsource.adqualitysdk.sdk.i.kf$b");
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static <T> hs<T> m2940(T t3, ia iaVar, List<String> list, int i2) {
        f2964 = (f2962 + 105) % 128;
        hs<T> hsVarM2951 = m2951(t3, iaVar, list, i2);
        int i8 = f2962 + 111;
        f2964 = i8 % 128;
        if (i8 % 2 == 0) {
            return hsVarM2951;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static <T> hs<T> m2947(WebView webView, ia iaVar, b bVar) {
        T tMo2359;
        int i2 = f2964 + 67;
        f2962 = i2 % 128;
        try {
        } catch (Throwable th) {
            kd.m2919(m2944((char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0)), (Process.myTid() >> 22) + 12, 93 - TextUtils.lastIndexOf("", '0', 0)).intern(), m2944((char) View.MeasureSpec.makeMeasureSpec(0, 0), TextUtils.getCapsMode("", 0, 0) + 26, TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 175).intern(), th, false);
        }
        if (i2 % 2 == 0) {
            bVar.m2959();
            throw null;
        }
        if (bVar.m2959()) {
            hs<T> hsVarM2942 = m2942(webView, iaVar, m2938().m643(), m2938().m640());
            if (bVar.m2961() && hsVarM2942 != null && (tMo2359 = hsVarM2942.mo2359()) != null) {
                int i8 = f2964 + 41;
                f2962 = i8 % 128;
                if (i8 % 2 != 0) {
                    if (!tMo2359.getClass().equals(hsVarM2942.mo2360().getType())) {
                        hs<T> hsVarM2940 = m2940(tMo2359, iaVar, m2938().m641(), m2938().m644());
                        f2962 = (f2964 + 51) % 128;
                        return hsVarM2940;
                    }
                } else {
                    tMo2359.getClass().equals(hsVarM2942.mo2360().getType());
                    throw null;
                }
            }
            return hsVarM2942;
        }
        return null;
    }

    @RequiresApi(api = 26)
    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static boolean m2956(Context context) {
        if (f2971) {
            boolean z2 = false;
            f2971 = false;
            WebView webView = new WebView(context);
            hk hkVar = new hk(null, new WebChromeClient() { // from class: com.ironsource.adqualitysdk.sdk.i.kf.4
            });
            webView.setWebChromeClient(hkVar);
            if (hkVar == webView.getWebChromeClient()) {
                int i2 = (f2962 + 19) % 128;
                f2964 = i2;
                z2 = true;
                f2962 = (i2 + 1) % 128;
            }
            f2969 = z2;
        }
        return f2969;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static <T> hs<T> m2951(Object obj, ia iaVar, final List<String> list, int i2) {
        hs<T> hsVarM2434 = hu.m2386().m2388().m2434(obj, iaVar, new hq() { // from class: com.ironsource.adqualitysdk.sdk.i.kf.1
            @Override // com.ironsource.adqualitysdk.sdk.i.hq
            /* JADX INFO: renamed from: ﾇ */
            public final Field[] mo2344(Object obj2) {
                hu.m2386().m2389();
                return hn.m2328(obj2.getClass(), true, -1, list);
            }
        }, list, i2);
        f2964 = (f2962 + 63) % 128;
        return hsVarM2434;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static ia m2948() {
        ia iaVar = new ia() { // from class: com.ironsource.adqualitysdk.sdk.i.kf.8
            @Override // com.ironsource.adqualitysdk.sdk.i.ia
            /* JADX INFO: renamed from: ﾇ */
            public final boolean mo1908(hs hsVar) {
                return WebChromeClient.class.equals(hsVar.mo2360().getType());
            }
        };
        f2964 = (f2962 + 59) % 128;
        return iaVar;
    }
}
