package com.ironsource.adqualitysdk.sdk.i;

import android.os.Process;
import android.text.AndroidCharacter;
import android.view.View;
import android.view.ViewConfiguration;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ironsource.adqualitysdk.sdk.i.az;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class jp {

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static boolean f2853 = true;

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static boolean f2854 = true;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static int f2855 = 1;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static int f2856 = 0;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static char[] f2857 = {216, 230, 227, 215, 234, 248, 198, 249, 245, 239, 244, 240, 243, 161, 232, 196, 237, 233, 238};

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f2858 = 129;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private WeakReference<az.e> f2859;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private boolean f2860;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private WeakReference<WebView> f2861;

    public jp(WebView webView) {
        this.f2861 = new WeakReference<>(webView);
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private void m2747(az.e eVar) {
        this.f2859 = new WeakReference<>(eVar);
        f2855 = (f2856 + 43) % 128;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static void m2748(az.e eVar) {
        new WeakReference(eVar);
        f2856 = (f2855 + 105) % 128;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
    
        if ((r0 % 2) != 0) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0024, code lost:
    
        r1 = 95 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002e, code lost:
    
        return r4.f2859.get();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0037, code lost:
    
        return r4.f2859.get();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0038, code lost:
    
        com.ironsource.adqualitysdk.sdk.i.jp.f2856 = (r2 + com.vungle.ads.internal.protos.Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003f, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
    
        if (r4.f2859 != null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0017, code lost:
    
        if (r4.f2859 != null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
    
        r0 = r0 + 95;
        com.ironsource.adqualitysdk.sdk.i.jp.f2855 = r0 % 128;
     */
    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.ironsource.adqualitysdk.sdk.i.az.e m2749() {
        /*
            r4 = this;
            int r0 = com.ironsource.adqualitysdk.sdk.i.jp.f2856
            int r1 = r0 + 119
            int r2 = r1 % 128
            com.ironsource.adqualitysdk.sdk.i.jp.f2855 = r2
            int r1 = r1 % 2
            if (r1 != 0) goto L15
            java.lang.ref.WeakReference<com.ironsource.adqualitysdk.sdk.i.az$e> r1 = r4.f2859
            r3 = 17
            int r3 = r3 / 0
            if (r1 == 0) goto L38
            goto L19
        L15:
            java.lang.ref.WeakReference<com.ironsource.adqualitysdk.sdk.i.az$e> r1 = r4.f2859
            if (r1 == 0) goto L38
        L19:
            r1 = 95
            int r0 = r0 + r1
            int r2 = r0 % 128
            com.ironsource.adqualitysdk.sdk.i.jp.f2855 = r2
            int r0 = r0 % 2
            if (r0 != 0) goto L2f
            java.lang.ref.WeakReference<com.ironsource.adqualitysdk.sdk.i.az$e> r0 = r4.f2859
            java.lang.Object r0 = r0.get()
            com.ironsource.adqualitysdk.sdk.i.az$e r0 = (com.ironsource.adqualitysdk.sdk.i.az.e) r0
            int r1 = r1 / 0
            return r0
        L2f:
            java.lang.ref.WeakReference<com.ironsource.adqualitysdk.sdk.i.az$e> r0 = r4.f2859
            java.lang.Object r0 = r0.get()
            com.ironsource.adqualitysdk.sdk.i.az$e r0 = (com.ironsource.adqualitysdk.sdk.i.az.e) r0
            return r0
        L38:
            int r2 = r2 + 125
            int r2 = r2 % 128
            com.ironsource.adqualitysdk.sdk.i.jp.f2856 = r2
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.jp.m2749():com.ironsource.adqualitysdk.sdk.i.az$e");
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final WebView m2752() {
        int i2 = f2855 + 95;
        f2856 = i2 % 128;
        if (i2 % 2 == 0) {
            return this.f2861.get();
        }
        int i8 = 0 / 0;
        return this.f2861.get();
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final void m2753(WebViewClient webViewClient) {
        int i2 = f2856 + 83;
        f2855 = i2 % 128;
        if (i2 % 2 == 0) {
            m2752();
            throw null;
        }
        WebView webViewM2752 = m2752();
        if (webViewM2752 != null) {
            try {
                hh hhVar = new hh(kf.m2950(webViewM2752), webViewClient);
                m2747(hhVar);
                webViewM2752.setWebViewClient(hhVar);
                this.f2860 = true;
                int i8 = f2855 + 35;
                f2856 = i8 % 128;
                if (i8 % 2 != 0) {
                    throw null;
                }
                return;
            } catch (Exception e) {
                kd.m2919(m2746(null, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 127, null, "\u008a\u008c\u0085\u008b\u008a\u0082\u0089\u0088\u0087\u0086\u0082\u0085\u0084\u0083\u0082\u0081").intern(), m2746(null, View.MeasureSpec.getSize(0) + 127, null, "\u0089\u008a\u0082\u0085\u0091\u0090\u0086\u0082\u0085\u0084\u0083\u0082\u0081\u008e\u008f\u008a\u0085\u0089\u0089\u0082\u008f\u008e\u008d\u008c\u008d\u008d\u0087").intern(), e, false);
            }
        }
        this.f2860 = false;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final void m2750(WebChromeClient webChromeClient) {
        int i2 = f2855 + 19;
        f2856 = i2 % 128;
        if (i2 % 2 != 0) {
            m2752();
            throw null;
        }
        WebView webViewM2752 = m2752();
        if (webViewM2752 != null) {
            try {
                if (kf.m2953(webViewM2752) != null) {
                    int i8 = f2856 + 91;
                    f2855 = i8 % 128;
                    if (i8 % 2 != 0) {
                        return;
                    } else {
                        throw null;
                    }
                }
                return;
            } catch (Exception e) {
                kd.m2919(m2746(null, 175 - AndroidCharacter.getMirror('0'), null, "\u008a\u008c\u0085\u008b\u008a\u0082\u0089\u0088\u0087\u0086\u0082\u0085\u0084\u0083\u0082\u0081").intern(), m2746(null, 127 - ((Process.getThreadPriority(0) + 20) >> 6), null, "\u0089\u008a\u0082\u0085\u0091\u0090\u0082\u0093\u008c\u008d\u0092\u0090\u0083\u0082\u0081\u008e\u008f\u008a\u0085\u0089\u0089\u0082\u008f\u008e\u008d\u008c\u008d\u008d\u0087").intern(), e, false);
            }
        }
        f2855 = (f2856 + 95) % 128;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final boolean m2751() {
        int i2 = f2856;
        boolean z2 = this.f2860;
        int i8 = i2 + 25;
        f2855 = i8 % 128;
        if (i8 % 2 != 0) {
            return z2;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m2746(String str, int i2, int[] iArr, String str2) throws UnsupportedEncodingException {
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
                char[] cArr2 = f2857;
                int i8 = f2858;
                if (f2854) {
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
                if (f2853) {
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
