package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Process;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.protobuf.ByteString;
import com.ironsource.InterfaceC2238ae;
import com.ironsource.adqualitysdk.sdk.i.bg;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.ads.IUnityAdsListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.ErrorState;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.request.WebRequestEvent;
import com.unity3d.services.core.webview.WebView;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.WebViewEventCategory;
import com.unity3d.services.core.webview.bridge.Invocation;
import com.unity3d.services.core.webview.bridge.NativeCallback;
import com.vungle.ads.internal.protos.Sdk;
import gatewayprotocol.v1.DiagnosticEventRequestOuterClass;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class cg extends bg {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static char[] f1299 = null;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static long f1300 = 0;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f1301 = 1;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f1302;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a extends WebViewApp implements hc<WebViewApp> {

        /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
        private static int f1320 = 1;

        /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
        private static int f1322;

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private ch f1325;

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private WebViewApp f1326;

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private static int[] f1323 = {-1170285487, -1138561264, -198867195, -1497985726, 1459861779, -1566080643, 1117944474, 1474987752, -2019057955, 640109965, 1604574411, -772586179, 965387663, 1895692417, 1986321995, 32763663, 528501071, 1421401831};

        /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
        private static boolean f1318 = true;

        /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
        private static boolean f1319 = true;

        /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
        private static int f1321 = 299;

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private static char[] f1324 = {386, 400, 397, 385, 404, 418, 364, 411, 345, 414, 375, 410, 396, 399, 402, 415, 369, 407, 416, 413, 376, 366, 372, 409, 421, 401};

        public a(WebViewApp webViewApp, ch chVar) {
            this.f1326 = webViewApp;
            this.f1325 = chVar;
        }

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private static String m1587(String str, int i2, int[] iArr, String str2) throws UnsupportedEncodingException {
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
                    char[] cArr2 = f1324;
                    int i8 = f1321;
                    if (f1319) {
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
                    if (f1318) {
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

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private WebViewApp m1588() {
            int i2 = f1320 + 71;
            f1322 = i2 % 128;
            if (i2 % 2 == 0) {
                return this.f1326;
            }
            throw null;
        }

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private static String m1589(int[] iArr, int i2) {
            String str;
            synchronized (d.f1664) {
                try {
                    char[] cArr = new char[4];
                    char[] cArr2 = new char[iArr.length << 1];
                    int[] iArr2 = (int[]) f1323.clone();
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

        @Override // com.unity3d.services.core.webview.WebViewApp
        public void addCallback(NativeCallback nativeCallback) {
            f1320 = (f1322 + 25) % 128;
            cg.this.m885(this, this.f1325, m1589(new int[]{1406909665, 1388404077, 615328213, 1543194299, 1664792108, -928845811, -1491177313, -1676484986, 2074400029, 2006359119, -104840683, 1242090750}, 22 - (ViewConfiguration.getTapTimeout() >> 16)).intern(), nativeCallback);
            WebViewApp webViewApp = this.f1326;
            if (webViewApp != null) {
                int i2 = f1320 + 89;
                f1322 = i2 % 128;
                int i8 = i2 % 2;
                webViewApp.addCallback(nativeCallback);
                if (i8 != 0) {
                    throw null;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x005b, code lost:
        
            return r5.f1326.getCallback(r6);
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x005c, code lost:
        
            com.ironsource.adqualitysdk.sdk.i.cg.a.f1322 = (com.ironsource.adqualitysdk.sdk.i.cg.a.f1320 + 57) % 128;
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0065, code lost:
        
            return null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:5:0x002f, code lost:
        
            if (r5.f1326 != null) goto L9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0053, code lost:
        
            if (r5.f1326 != null) goto L9;
         */
        @Override // com.unity3d.services.core.webview.WebViewApp
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.unity3d.services.core.webview.bridge.NativeCallback getCallback(java.lang.String r6) {
            /*
                r5 = this;
                int r0 = com.ironsource.adqualitysdk.sdk.i.cg.a.f1322
                int r0 = r0 + 121
                int r1 = r0 % 128
                com.ironsource.adqualitysdk.sdk.i.cg.a.f1320 = r1
                int r0 = r0 % 2
                r1 = 12
                r2 = 0
                if (r0 != 0) goto L32
                com.ironsource.adqualitysdk.sdk.i.cg r0 = com.ironsource.adqualitysdk.sdk.i.cg.this
                com.ironsource.adqualitysdk.sdk.i.ch r3 = r5.f1325
                int[] r1 = new int[r1]
                r1 = {x0066: FILL_ARRAY_DATA , data: [1406909665, 1388404077, 615328213, 1543194299, 1628306406, -2118019696, 711605486, 2153226, 2074400029, 2006359119, -104840683, 1242090750} // fill-array
                int r4 = android.view.KeyEvent.normalizeMetaState(r2)
                int r4 = r4 + 103
                java.lang.String r1 = m1589(r1, r4)
                java.lang.String r1 = r1.intern()
                java.lang.Object[] r4 = new java.lang.Object[r2]
                r4[r2] = r6
                r0.m885(r5, r3, r1, r4)
                com.unity3d.services.core.webview.WebViewApp r0 = r5.f1326
                if (r0 == 0) goto L5c
                goto L55
            L32:
                com.ironsource.adqualitysdk.sdk.i.cg r0 = com.ironsource.adqualitysdk.sdk.i.cg.this
                com.ironsource.adqualitysdk.sdk.i.ch r3 = r5.f1325
                int[] r1 = new int[r1]
                r1 = {x0082: FILL_ARRAY_DATA , data: [1406909665, 1388404077, 615328213, 1543194299, 1628306406, -2118019696, 711605486, 2153226, 2074400029, 2006359119, -104840683, 1242090750} // fill-array
                int r4 = android.view.KeyEvent.normalizeMetaState(r2)
                int r4 = r4 + 22
                java.lang.String r1 = m1589(r1, r4)
                java.lang.String r1 = r1.intern()
                r4 = 1
                java.lang.Object[] r4 = new java.lang.Object[r4]
                r4[r2] = r6
                r0.m885(r5, r3, r1, r4)
                com.unity3d.services.core.webview.WebViewApp r0 = r5.f1326
                if (r0 == 0) goto L5c
            L55:
                com.unity3d.services.core.webview.WebViewApp r0 = r5.f1326
                com.unity3d.services.core.webview.bridge.NativeCallback r6 = r0.getCallback(r6)
                return r6
            L5c:
                int r6 = com.ironsource.adqualitysdk.sdk.i.cg.a.f1320
                int r6 = r6 + 57
                int r6 = r6 % 128
                com.ironsource.adqualitysdk.sdk.i.cg.a.f1322 = r6
                r6 = 0
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.cg.a.getCallback(java.lang.String):com.unity3d.services.core.webview.bridge.NativeCallback");
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x005b, code lost:
        
            return r5.f1326.getConfiguration();
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x005c, code lost:
        
            r0 = com.ironsource.adqualitysdk.sdk.i.cg.a.f1320 + 13;
            com.ironsource.adqualitysdk.sdk.i.cg.a.f1322 = r0 % 128;
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0067, code lost:
        
            if ((r0 % 2) != 0) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0069, code lost:
        
            return null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x006a, code lost:
        
            throw null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:5:0x0031, code lost:
        
            if (r5.f1326 != null) goto L9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0053, code lost:
        
            if (r5.f1326 != null) goto L9;
         */
        @Override // com.unity3d.services.core.webview.WebViewApp
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.unity3d.services.core.configuration.Configuration getConfiguration() {
            /*
                r5 = this;
                int r0 = com.ironsource.adqualitysdk.sdk.i.cg.a.f1320
                int r0 = r0 + 119
                int r1 = r0 % 128
                com.ironsource.adqualitysdk.sdk.i.cg.a.f1322 = r1
                int r0 = r0 % 2
                r1 = 14
                java.lang.String r2 = ""
                if (r0 == 0) goto L34
                com.ironsource.adqualitysdk.sdk.i.cg r0 = com.ironsource.adqualitysdk.sdk.i.cg.this
                com.ironsource.adqualitysdk.sdk.i.ch r3 = r5.f1325
                int[] r1 = new int[r1]
                r1 = {x006c: FILL_ARRAY_DATA , data: [1406909665, 1388404077, 615328213, 1543194299, 1628306406, -2118019696, 1127110278, -1496948103, -1727947866, 1780543880, -1645439955, -1713991842, -514655758, -188498525} // fill-array
                r4 = 16
                int r2 = android.os.Process.getGidForName(r2)
                int r2 = r4 >> r2
                java.lang.String r1 = m1589(r1, r2)
                java.lang.String r1 = r1.intern()
                r2 = 1
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r0.m885(r5, r3, r1, r2)
                com.unity3d.services.core.webview.WebViewApp r0 = r5.f1326
                if (r0 == 0) goto L5c
                goto L55
            L34:
                com.ironsource.adqualitysdk.sdk.i.cg r0 = com.ironsource.adqualitysdk.sdk.i.cg.this
                com.ironsource.adqualitysdk.sdk.i.ch r3 = r5.f1325
                int[] r1 = new int[r1]
                r1 = {x008c: FILL_ARRAY_DATA , data: [1406909665, 1388404077, 615328213, 1543194299, 1628306406, -2118019696, 1127110278, -1496948103, -1727947866, 1780543880, -1645439955, -1713991842, -514655758, -188498525} // fill-array
                int r2 = android.os.Process.getGidForName(r2)
                int r2 = r2 + 28
                java.lang.String r1 = m1589(r1, r2)
                java.lang.String r1 = r1.intern()
                r2 = 0
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r0.m885(r5, r3, r1, r2)
                com.unity3d.services.core.webview.WebViewApp r0 = r5.f1326
                if (r0 == 0) goto L5c
            L55:
                com.unity3d.services.core.webview.WebViewApp r0 = r5.f1326
                com.unity3d.services.core.configuration.Configuration r0 = r0.getConfiguration()
                return r0
            L5c:
                int r0 = com.ironsource.adqualitysdk.sdk.i.cg.a.f1320
                int r0 = r0 + 13
                int r1 = r0 % 128
                com.ironsource.adqualitysdk.sdk.i.cg.a.f1322 = r1
                int r0 = r0 % 2
                r1 = 0
                if (r0 != 0) goto L6a
                return r1
            L6a:
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.cg.a.getConfiguration():com.unity3d.services.core.configuration.Configuration");
        }

        @Override // com.unity3d.services.core.webview.WebViewApp
        public ErrorState getErrorStateFromWebAppCode() {
            cg.this.m885(this, this.f1325, m1589(new int[]{1406909665, 1388404077, 615328213, 1543194299, 1628306406, -2118019696, 1968474541, -1226089396, 1062075408, -162192761, -2027477414, -161924335, -650525127, 1484275653, 1898852225, -1787491314, -2008920710, -564910710, 2042883686, -1484164558}, 39 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))).intern(), new Object[0]);
            WebViewApp webViewApp = this.f1326;
            if (webViewApp == null) {
                f1322 = (f1320 + 43) % 128;
                return null;
            }
            f1322 = (f1320 + 77) % 128;
            ErrorState errorStateFromWebAppCode = webViewApp.getErrorStateFromWebAppCode();
            int i2 = f1320 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE;
            f1322 = i2 % 128;
            if (i2 % 2 == 0) {
                return errorStateFromWebAppCode;
            }
            throw null;
        }

        @Override // com.unity3d.services.core.webview.WebViewApp
        public int getWebAppFailureCode() {
            f1320 = (f1322 + 35) % 128;
            cg.this.m885(this, this.f1325, m1587(null, (Process.myPid() >> 22) + 127, null, "\u0082\u008e\u008c\u0096\u0082\u0094\u0093\u0092\u0085\u008d\u0091\u0088\u0088\u0087\u0083\u0082\u0081\u0090\u0082\u008f\u0089\u0088\u0088\u0087\u0086\u0082\u0085\u0084\u0083\u0082\u0081").intern(), new Object[0]);
            WebViewApp webViewApp = this.f1326;
            if (webViewApp == null) {
                return 0;
            }
            f1322 = (f1320 + 11) % 128;
            return webViewApp.getWebAppFailureCode();
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0056, code lost:
        
            return r8.f1326.getWebAppFailureMessage();
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0057, code lost:
        
            com.ironsource.adqualitysdk.sdk.i.cg.a.f1320 = (com.ironsource.adqualitysdk.sdk.i.cg.a.f1322 + 99) % 128;
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x005f, code lost:
        
            return null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:5:0x002f, code lost:
        
            if (r8.f1326 != null) goto L9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x004e, code lost:
        
            if (r8.f1326 != null) goto L9;
         */
        @Override // com.unity3d.services.core.webview.WebViewApp
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String getWebAppFailureMessage() {
            /*
                r8 = this;
                int r0 = com.ironsource.adqualitysdk.sdk.i.cg.a.f1322
                int r0 = r0 + 37
                int r1 = r0 % 128
                com.ironsource.adqualitysdk.sdk.i.cg.a.f1320 = r1
                int r0 = r0 % 2
                java.lang.String r1 = "\u0082\u008f\u008d\u008a\u008a\u0082\u0095\u0082\u0094\u0093\u0092\u0085\u008d\u0091\u0088\u0088\u0087\u0083\u0082\u0081\u0090\u0082\u008f\u0089\u0088\u0088\u0087\u0086\u0082\u0085\u0084\u0083\u0082\u0081"
                r2 = -1
                r4 = 0
                if (r0 != 0) goto L32
                com.ironsource.adqualitysdk.sdk.i.cg r0 = com.ironsource.adqualitysdk.sdk.i.cg.this
                com.ironsource.adqualitysdk.sdk.i.ch r5 = r8.f1325
                long r6 = android.os.SystemClock.currentThreadTimeMillis()
                int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
                r3 = 39
                int r2 = r3 >>> r2
                java.lang.String r1 = m1587(r4, r2, r4, r1)
                java.lang.String r1 = r1.intern()
                r2 = 1
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r0.m885(r8, r5, r1, r2)
                com.unity3d.services.core.webview.WebViewApp r0 = r8.f1326
                if (r0 == 0) goto L57
                goto L50
            L32:
                com.ironsource.adqualitysdk.sdk.i.cg r0 = com.ironsource.adqualitysdk.sdk.i.cg.this
                com.ironsource.adqualitysdk.sdk.i.ch r5 = r8.f1325
                long r6 = android.os.SystemClock.currentThreadTimeMillis()
                int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
                int r2 = r2 + 126
                java.lang.String r1 = m1587(r4, r2, r4, r1)
                java.lang.String r1 = r1.intern()
                r2 = 0
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r0.m885(r8, r5, r1, r2)
                com.unity3d.services.core.webview.WebViewApp r0 = r8.f1326
                if (r0 == 0) goto L57
            L50:
                com.unity3d.services.core.webview.WebViewApp r0 = r8.f1326
                java.lang.String r0 = r0.getWebAppFailureMessage()
                return r0
            L57:
                int r0 = com.ironsource.adqualitysdk.sdk.i.cg.a.f1322
                int r0 = r0 + 99
                int r0 = r0 % 128
                com.ironsource.adqualitysdk.sdk.i.cg.a.f1320 = r0
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.cg.a.getWebAppFailureMessage():java.lang.String");
        }

        @Override // com.unity3d.services.core.webview.WebViewApp
        public WebView getWebView() {
            f1322 = (f1320 + 65) % 128;
            cg.this.m885(this, this.f1325, m1589(new int[]{1406909665, 1388404077, 615328213, 1543194299, 1628306406, -2118019696, 565703070, -2082207552, 1446001754, -327552021, -1398021761, -1886918072}, 21 - KeyEvent.getDeadChar(0, 0)).intern(), new Object[0]);
            WebViewApp webViewApp = this.f1326;
            if (webViewApp == null) {
                return null;
            }
            f1320 = (f1322 + 79) % 128;
            WebView webView = webViewApp.getWebView();
            int i2 = f1320 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE;
            f1322 = i2 % 128;
            if (i2 % 2 == 0) {
                return webView;
            }
            throw null;
        }

        @Override // com.unity3d.services.core.webview.WebViewApp
        public boolean invokeCallback(Invocation invocation) {
            f1320 = (f1322 + 17) % 128;
            cg.this.m885(this, this.f1325, m1589(new int[]{1406909665, 1388404077, 615328213, 1543194299, -480808359, 390075695, 1423608172, -980160843, -1913663720, -40474167, 487160106, -471779757, 492364301, 1322075700}, 25 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1))).intern(), invocation);
            WebViewApp webViewApp = this.f1326;
            if (webViewApp == null) {
                return false;
            }
            f1320 = (f1322 + 9) % 128;
            return webViewApp.invokeCallback(invocation);
        }

        @Override // com.unity3d.services.core.webview.WebViewApp, com.unity3d.services.core.webview.bridge.IWebViewBridgeInvoker
        public boolean invokeMethod(String str, String str2, Method method, Object... objArr) {
            f1322 = (f1320 + 107) % 128;
            cg.this.m885(this, this.f1325, m1589(new int[]{1406909665, 1388404077, 615328213, 1543194299, -480808359, 390075695, 1423608172, -980160843, 1978049394, 1274401561, -1745626511, -847275797}, 23 - TextUtils.getOffsetAfter("", 0)).intern(), str, str2, method, Arrays.asList(objArr));
            WebViewApp webViewApp = this.f1326;
            if (webViewApp == null) {
                int i2 = f1322 + 29;
                f1320 = i2 % 128;
                if (i2 % 2 != 0) {
                    return false;
                }
                throw null;
            }
            int i8 = f1322 + 1;
            f1320 = i8 % 128;
            if (i8 % 2 != 0) {
                return webViewApp.invokeMethod(str, str2, method, objArr);
            }
            webViewApp.invokeMethod(str, str2, method, objArr);
            throw null;
        }

        @Override // com.unity3d.services.core.webview.WebViewApp
        public boolean isWebAppInitialized() {
            cg.this.m885(this, this.f1325, m1589(new int[]{1406909665, 1388404077, 615328213, 1543194299, -480808359, 390075695, 769268510, -743147951, -949433588, 6512674, -1896035213, -1281841713, -1252744325, 1321835071, 1440042815, 274191691}, Gravity.getAbsoluteGravity(0, 0) + 30).intern(), new Object[0]);
            WebViewApp webViewApp = this.f1326;
            if (webViewApp != null) {
                f1320 = (f1322 + 5) % 128;
                return webViewApp.isWebAppInitialized();
            }
            int i2 = f1320 + 99;
            f1322 = i2 % 128;
            if (i2 % 2 != 0) {
                int i8 = 84 / 0;
            }
            return false;
        }

        @Override // com.unity3d.services.core.webview.WebViewApp
        public boolean isWebAppLoaded() {
            f1322 = (f1320 + 33) % 128;
            cg.this.m885(this, this.f1325, m1587(null, 127 - View.MeasureSpec.getSize(0), null, "\u008e\u0082\u008e\u008d\u008c\u008b\u0088\u0088\u0087\u0083\u0082\u0081\u008a\u0085\u0089\u0088\u0088\u0087\u0086\u0082\u0085\u0084\u0083\u0082\u0081").intern(), new Object[0]);
            WebViewApp webViewApp = this.f1326;
            if (webViewApp == null) {
                int i2 = f1322 + 77;
                f1320 = i2 % 128;
                if (i2 % 2 != 0) {
                    return false;
                }
                throw null;
            }
            int i8 = f1322 + 11;
            f1320 = i8 % 128;
            if (i8 % 2 != 0) {
                return webViewApp.isWebAppLoaded();
            }
            int i9 = 7 / 0;
            return webViewApp.isWebAppLoaded();
        }

        @Override // com.unity3d.services.core.webview.WebViewApp
        public void removeCallback(NativeCallback nativeCallback) {
            f1322 = (f1320 + 105) % 128;
            cg.this.m885(this, this.f1325, m1589(new int[]{1406909665, 1388404077, 615328213, 1543194299, 932353868, 1909558450, -992327090, 1596791009, -1913663720, -40474167, 487160106, -471779757, 492364301, 1322075700}, 25 - (ViewConfiguration.getJumpTapTimeout() >> 16)).intern(), nativeCallback);
            WebViewApp webViewApp = this.f1326;
            if (webViewApp != null) {
                int i2 = f1320 + 53;
                f1322 = i2 % 128;
                int i8 = i2 % 2;
                webViewApp.removeCallback(nativeCallback);
                if (i8 != 0) {
                    throw null;
                }
            }
            f1320 = (f1322 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE) % 128;
        }

        @Override // com.unity3d.services.core.webview.WebViewApp
        public void resetWebViewAppInitialization() {
            f1320 = (f1322 + 29) % 128;
            cg.this.m885(this, this.f1325, m1587(null, 127 - (Process.myTid() >> 22), null, "\u0098\u008c\u0085\u0090\u008d\u0099\u0085\u0092\u008d\u0085\u0090\u0085\u0098\u0097\u0088\u0088\u0087\u0086\u0082\u0085\u0084\u0083\u0082\u0081\u0090\u0082\u008a\u0082\u0094\u0089\u0088\u0088\u0087\u0086\u0082\u0085\u0084\u0083\u0082\u0081").intern(), new Object[0]);
            WebViewApp webViewApp = this.f1326;
            if (webViewApp != null) {
                int i2 = f1320 + 29;
                f1322 = i2 % 128;
                int i8 = i2 % 2;
                webViewApp.resetWebViewAppInitialization();
                if (i8 != 0) {
                    throw null;
                }
            }
        }

        @Override // com.unity3d.services.core.webview.WebViewApp
        public boolean sendEvent(Enum r8, Enum r9, Object... objArr) {
            cg.this.m885(this, this.f1325, m1589(new int[]{1406909665, 1388404077, 615328213, 1543194299, -1152175638, -1388237679, 1025264397, -1943275648, 1633500501, -1356054972}, 19 - ImageFormat.getBitsPerPixel(0)).intern(), r8, r9, Arrays.asList(objArr));
            WebViewApp webViewApp = this.f1326;
            if (webViewApp != null) {
                f1322 = (f1320 + 111) % 128;
                return webViewApp.sendEvent(r8, r9, objArr);
            }
            f1322 = (f1320 + 55) % 128;
            return false;
        }

        @Override // com.unity3d.services.core.webview.WebViewApp
        public void setConfiguration(Configuration configuration) {
            f1320 = (f1322 + 57) % 128;
            cg.this.m885(this, this.f1325, m1587(null, ExpandableListView.getPackedPositionGroup(0L) + 127, null, "\u0098\u008c\u0085\u0090\u008d\u0094\u0093\u008f\u0085\u009a\u0098\u008c\u0096\u0090\u0082\u008a\u0089\u0088\u0088\u0087\u0086\u0082\u0085\u0084\u0083\u0082\u0081").intern(), configuration);
            WebViewApp webViewApp = this.f1326;
            if (webViewApp != null) {
                int i2 = f1322 + 99;
                f1320 = i2 % 128;
                int i8 = i2 % 2;
                webViewApp.setConfiguration(configuration);
                if (i8 == 0) {
                    throw null;
                }
            }
        }

        @Override // com.unity3d.services.core.webview.WebViewApp
        public void setWebAppFailureCode(int i2) {
            cg.this.m885(this, this.f1325, m1589(new int[]{1406909665, 1388404077, 615328213, 1543194299, -1152175638, -1388237679, 565703070, -2082207552, -1472108064, 1986297276, -972001016, 803885174, -521341920, -970579840, -1849029912, 2084588056}, 31 - View.getDefaultSize(0, 0)).intern(), Integer.valueOf(i2));
            WebViewApp webViewApp = this.f1326;
            if (webViewApp != null) {
                webViewApp.setWebAppFailureCode(i2);
                f1320 = (f1322 + 71) % 128;
            }
            f1320 = (f1322 + 53) % 128;
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x005c  */
        @Override // com.unity3d.services.core.webview.WebViewApp
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void setWebAppFailureMessage(java.lang.String r8) {
            /*
                Method dump skipped, instruction units count: 210
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.cg.a.setWebAppFailureMessage(java.lang.String):void");
        }

        @Override // com.unity3d.services.core.webview.WebViewApp
        public void setWebAppInitialized(boolean z2) {
            int i2 = f1320 + 79;
            f1322 = i2 % 128;
            if (i2 % 2 != 0) {
                cg cgVar = cg.this;
                ch chVar = this.f1325;
                String strIntern = m1589(new int[]{1406909665, 1388404077, 615328213, 1543194299, -1152175638, -1388237679, 565703070, -2082207552, -1472108064, 1986297276, 475996148, 1215484391, 278768775, 232643121, 1558906879, -2137388718}, (Process.myPid() >>> 11) + 12).intern();
                Object[] objArr = new Object[1];
                objArr[1] = Boolean.valueOf(z2);
                cgVar.m885(this, chVar, strIntern, objArr);
                if (this.f1326 == null) {
                    return;
                }
            } else {
                cg.this.m885(this, this.f1325, m1589(new int[]{1406909665, 1388404077, 615328213, 1543194299, -1152175638, -1388237679, 565703070, -2082207552, -1472108064, 1986297276, 475996148, 1215484391, 278768775, 232643121, 1558906879, -2137388718}, (Process.myPid() >> 22) + 31).intern(), Boolean.valueOf(z2));
                if (this.f1326 == null) {
                    return;
                }
            }
            int i8 = f1320 + 105;
            f1322 = i8 % 128;
            if (i8 % 2 == 0) {
                this.f1326.setWebAppInitialized(z2);
            } else {
                this.f1326.setWebAppInitialized(z2);
                throw null;
            }
        }

        @Override // com.unity3d.services.core.webview.WebViewApp
        public void setWebAppLoaded(boolean z2) {
            f1322 = (f1320 + 13) % 128;
            cg.this.m885(this, this.f1325, m1589(new int[]{1406909665, 1388404077, 615328213, 1543194299, -1152175638, -1388237679, 565703070, -2082207552, -1472108064, 1986297276, -332573043, -843537318, 1440042815, 274191691}, ((byte) KeyEvent.getModifierMetaStateMask()) + 27).intern(), Boolean.valueOf(z2));
            WebViewApp webViewApp = this.f1326;
            if (webViewApp != null) {
                webViewApp.setWebAppLoaded(z2);
            }
            int i2 = f1322 + 35;
            f1320 = i2 % 128;
            if (i2 % 2 == 0) {
                throw null;
            }
        }

        @Override // com.unity3d.services.core.webview.WebViewApp
        public void setWebView(WebView webView) {
            cg.this.m885(this, this.f1325, m1587(null, 127 - TextUtils.getOffsetBefore("", 0), null, "\u0086\u0082\u0085\u0084\u0083\u0082\u0081\u0090\u0082\u008a\u0089\u0088\u0088\u0087\u0086\u0082\u0085\u0084\u0083\u0082\u0081").intern(), webView);
            WebViewApp webViewApp = this.f1326;
            if (webViewApp != null) {
                f1322 = (f1320 + 73) % 128;
                webViewApp.setWebView(webView);
            }
            f1320 = (f1322 + 47) % 128;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.hc
        /* JADX INFO: renamed from: ｋ */
        public final /* synthetic */ WebViewApp mo831() {
            int i2 = f1320 + 93;
            f1322 = i2 % 128;
            if (i2 % 2 == 0) {
                return m1588();
            }
            int i8 = 11 / 0;
            return m1588();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class b extends bg {

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private static int[] f1328 = {1456641366, 1715849551, 730908439, 712625275, 1149944947, -494526348, 1245976910, 1221184645, 1531029029, 148173886, -537863312, -515975588, 1243800742, 1629560840, -361866864, 2000957492, 135807205, -41764684};

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private static int f1329 = 0;

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private static int f1330 = 1;

        public b(String str) {
            super(str);
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.bg
        /* JADX INFO: renamed from: ﻐ */
        public final String mo825() {
            f1330 = (f1329 + 89) % 128;
            String version = UnityAds.getVersion();
            if (version == null) {
                return null;
            }
            f1330 = (f1329 + 73) % 128;
            return version.split(m1590(new int[]{-115556659, -1404145105}, (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))).intern())[0];
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.bg
        /* JADX INFO: renamed from: ﻛ */
        public final Class mo826(String str) {
            switch (str.hashCode()) {
                case 252148886:
                    if (!str.equals(m1590(new int[]{-398504568, -191285118, -1728033565, 324689086, 66247264, -658249073, 749376428, 1455528605}, TextUtils.lastIndexOf("", '0', 0) + 15).intern())) {
                        return null;
                    }
                    f1329 = (f1330 + 27) % 128;
                    return AdUnitActivity.class;
                case 961844241:
                    if (str.equals(m1590(new int[]{1938743376, 1621890904, -1313275372, -545253944, 1150455865, -83149990}, 10 - (Process.myPid() >> 22)).intern())) {
                        return BannerView.class;
                    }
                    return null;
                case 1067215379:
                    if (!str.equals(m1590(new int[]{572513398, -856800359, 1498170459, -1551571568, -579668477, 1230084082, -1545619221, 1429588682, -767059666, -1759850385, -266035738, 908905131, -899947032, 5180555, 497968464, 925429986, 1982520922, 583704129, -202841775, 1380055987}, 39 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))).intern())) {
                        return null;
                    }
                    f1330 = (f1329 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE) % 128;
                    return BannerView.class;
                case 1531208100:
                    if (str.equals(m1590(new int[]{572513398, -856800359, 1498170459, -1551571568, -579668477, 1230084082, -1545619221, 1429588682, -767059666, -1759850385, -414518670, -256375228, -1132674526, -736029744, 652925289, -818657219, -398504568, -191285118, -1728033565, 324689086, 66247264, -658249073, 749376428, 1455528605}, 46 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)).intern())) {
                        return AdUnitActivity.class;
                    }
                    return null;
                default:
                    return null;
            }
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.bg
        /* JADX INFO: renamed from: ﾇ */
        public final Map<String, bg.a> mo827() {
            HashMap map = new HashMap();
            int i2 = f1329 + 55;
            f1330 = i2 % 128;
            if (i2 % 2 == 0) {
                int i8 = 56 / 0;
            }
            return map;
        }

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private static String m1590(int[] iArr, int i2) {
            String str;
            synchronized (d.f1664) {
                try {
                    char[] cArr = new char[4];
                    char[] cArr2 = new char[iArr.length << 1];
                    int[] iArr2 = (int[]) f1328.clone();
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
    }

    static {
        char[] cArr = new char[1265];
        a0.o("\u0000-\u0000UåôË]°º\u0096\u0011|CaøGE,\u0085\u0012\u0004ømÝêÃA¨\u0093\u008e\btunl\u008bÍ¥dÞ\u0083ø(\u0012z\u000fÁ)|B |\u0006\u0096S³Î\u00aduÆ\u0092à\u0014\u001a[7êQOJ\u0084d$\u009eE»þÕkÎ\u008aè;\u0000UåôË]°º\u0096\u0011|CaøGE,\u0099\u0012?øjÝ÷ÃL¨«\u008e-tbYÓ?\u007f$¬\n\u001aðmÕÌ»X ³\u0086\u0014lFQÍ7M\u001c¬\u0002\u0017èbÍÃ³2\u0000UåôË]°º\u0096\u0011|CaøGE,\u0087\u0012\u000føfÝÈÃQ¨·\u008e\u001btGYÐ?JÌ\u0098)\u0014\u0007¯|gZÆ°\u0098\u00ad9\u008b\u009fàkÞç4¸\u0011\"\u0000WåÿËV°\u009c\u0096\r|saéGS,£\u0012\u001eøAÝèÃ]¨¼\u008e\u0018\u0000WåÿËV°\u0098\u0096\u0001|gaëGs,¦\u0012\u000føjÝêÃ{¨³\u008e\u0018tcYÇ?U$¦\n\u0017\u0000UåôË]°º\u0096\u0011|OaóGX,µ\u0012\u001eømÝäÃY¨¦\u008e\u0005tiYÎáj\u0004Ë*bQ\u0080w\u0010\u009d_\u0080é¦fÍ\u009aó'\u0019X<É\"dI\u0099o\u0014\u0095[¸øÞsÅ\u0099ë2\u0011C¥.@\u0082n*\u0015×3jÙ\u0002Ä´â-\u0089Ø·i]\u001d\u0000UåôË]°º\u0096\u0011|CaøGE,\u0087\u0012\u000føfÝÈÃQ¨·\u008e\u001bQ.´\u0086\u009a/áåÇt-\n0\u0090\u0016*}ÚCgæÙ\u0003f-ùV8p\u0099\u009aî\u0087E¡ÍÊ<ô\u009b\u001eê;o%ÔN3|¨\u0099\u0011·°ÌJêç\u0000\u009a\u0000UåôË]°º\u0096\u0011|@aýGX,¾\u0012\u000føvÝí÷ô\u0012U<üG\u001ba°\u008bá\u0096\\°ùÛ\u001få®\u000f×*l4ð_\ty¨(\u008bÍ2ã\u0093\u0098i¾ÄT¹I\u0006o\u0097\u0004v:ÔS\u0015¶¬\u0098\rã÷ÅZ/'2\u0083\u0014\b\u007fãAX\u0000BåûËZ° \u0096\r|paÙG@,µ\u0012\u0004øpsw\u0096Î¸oÃ\u0095å8\u000fE\u0012å4j_\u0096a+\u008bT®Å°hÛ\u0095\u0000BåûËZ° \u0096\r|païG{,¿\u0012\u000eøqÝòÃ]¨\u0091\u008e\u0003thYÆ?S$³\n\u001bðzÕÃ»H ¿\u0086\u001fld\u0000BåûËZ° \u0096\r|paÌGD,¿\u0012\u001aøaÝìÃL¨»\u008e\ttuo\u0090\u008a)¤\u0088ßrùß\u0013¢\u000e\u001e(\u008bCq}Ñ\u0097¢²%¬\u0085Çn\u0000BåûËZ° \u0096\r|paËGS,²\u0012:øhÝÿÃA¨·\u008e\u001etEYÏ?T$ \n\u000fðaÕÌ»Y ¤#NÆ÷èV\u0093¬µ\u0001_|BÕdH\u000f®1\tÛzþÑà[\u008bº\u00ad\u0005\u0000BåûËZ° \u0096\r|paÙGD,¢\u0012\u0005øvÝ×ÃV¨´\u008e\u0003æ\u001f\u0003¦-\u0007VýpP\u009a-\u0087\u0097¡\u0002Êèô@VÝ³K\u009dçæ^À£*Ò7K\u0011üz\u0017Dç®Þ\u008b\u000e\u0095õþ\tØ \"Î\u000fwiçr\u000f\\£¦\u0098\u0083~íãö\u0006Ð :Ñ\u0007haóJHT\u008e¾Ó\u009bvå\u0090Î\u0001(¸2æ\u001f\u007fy\u0099B\u0015\u0000BåûËZ° \u0096\r|paÊG_,µ\u0012\u001døGÝÿÃ[¨º\u008e\t\u0000IåÏËZ°§\u0096\u001c|{aÞGW,¾\u0012\u0004øaÝìÃt¨»\u008e\u001ftrYÅ?T$±\n\u001c\u0000BåûËZ° \u0096\r|paÊG_,µ\u0012\u001døMÝÒÃQ¨¡\u008e\u0018tcYÎ?_$¦\u0003\tæ°È\u0011³ë\u0095F\u007f;b\u0081D\u0014/þ\u0011Vû\u0003Þ¼À\u0000«í\u008dBw#Z\u008e<\u0003Û\f>µ\u0010\u0014kîMC§>º\u0084\u009c\u0011÷ûÉS#\u0005\u0006¼\u0018\u0012\u0000cåõËY°à\u0096\u001d|laõGB,©\u0012Yø`Ý°ÃK¨·\u008e\u001etpYÉ?Y$±\n\u001dð&ÕÀ»] ¸\u0086\u001eloQÖ7M\u001cö\u0002\u0004èeÍÃ³7\u0098ô~6doIÆ/,\u0014¹ú\u0004àFÅÃ«!\u0090©¾\u0012[»u\f\u000eö(OÂ5ßºù\u0007\u0092á¬PF\u0007c¯}\u000e\u0016Ð0QÊ7ç\u0083\u0081*\u009aé´IN,k\u009a\u0005\t\u001eû\u0000cåõËY°à\u0096\u001d|laõGB,©\u0012Yø`Ý°ÃY¨¶\u008e\u001ft(YÁ?^$¤\n\u0002ðiÕÛ»Y ¤\u0086^lLQÑ7R\u001c´\u0002!èoÍÔ³%\u0098¿~\u001adYIÍ/ \u0014\u008aú\u001fàuÅÝ«\u0000\u0090·v\u000b\\bAÀ''\f\u0099\u0000AåþË{°¬\u0096\u0002|gaÿGB\u0000AåôËP°¼\u0096\u0007|kaøGp,¥\u0012\u0006øhÝíÃ[¨ \u008e\ttcYÎ?m$±\n\fð^ÕË»Y ¡\u00861lnQô7R\u001c¹\u0002\u000bèiÍÔ\u000fBêãÄJ¿\u00ad\u0099\u0006sTnïHR#\u008b\u001d\u0012÷rÒíÌ`§µ\u0081\u000f{xVØ0C+°\u007f\u0080\u009a!´\u0088ÏoéÄ\u0003\u0096\u001e-8\u0090SGmÞ\u0087¢¢.¼¢×wñÍ\u000bº&\u001a@\u0081[rdº\u0081\u0005¯\u0089ÔZòá\u0018\u0094\u0005\u0006#¹\u0000CåöË]°«\u0096\u0006|vaÌGD,¿\u0012\u001aøaÝìÃL¨»\u008e\ttu\u0000DåóËU°©\u0096\u0006|maïGB,¹\u0012\tøAÝèÃ]¨¼\u008e\u0018ê\u001f\u000f\u0099!\fZñ|J\u0096-\u008b\u008b\u00ad\u0004Æõøo\u0012:7§)\u0019BÈdS\u009e#³\u0082Õ\tÎìà]\u001a,þj\u001bò5MN\u0080h\u0010\u0082}\u009fã¹^Ò³ì\u0013\u0006^#ö=WV\u0089p\b\u008an§ÚÁvÚ©ô\u0013\u0000cåèËQ°¯\u0096\u001c|gaÈGt,\u0087\u0012\u000føfÝÈÃQ¨·\u008e\u001btGYÐ?J\u0000såÿË@°\u008d\u0096\u001d|paîGS,¾\u0012\u001eøSÝûÃZ¨\u0084\u008e\u0005tcY×?{$¤\n\u001e\u0000gåÿË@°\u0089\u0096\t|oaùG\u007f,´\u0000gåÿË@°\u009b\u0096\u0006|kaèGO,\u0091\u0012\u000eøwÝÒÃQ¨¡\u008e\u0018tcYÎ?_$¦cÑ\u0086]¨âÓ9õ¤\u001fÉ\u0002J$íO3q¬\u009bÕ¾p óË\u0003íº\u0017Á:l\\ýG\u0004\u0000aåþËP°\u009b\u0096\u0006|kaèGO,\u0091\u0012\u000eøwÝÒÃQ¨¡\u008e\u0018tcYÎ?_$¦\u0000råÿËY°¡\u0096\u001e|gaÉGX,¹\u0012\u001eø}ÝßÃ\\¨¡\u008e toYÓ?N$±\n\u0000ðmÕÐ\u0000gåÿË@°\u0099\u0096\r|`aÊG_,µ\u0012\u001døAÝèÃ]¨¼\u008e\u0018tEYÁ?N$±\n\tðgÕÐ»E\u0000gåÿË@°\u0099\u0096\r|`aÎGS,¡\u0012\u001føaÝíÃL¨\u0097\u008e\u001atcYÎ?N\u0000gåÿË@°\u009e\u0096\u0004|caÿGS,½\u0012\u000føjÝêÃq¨¶Zx¿à\u0091_ê\u0093Ì\u0016&s;í\u001dLv½H9¢r\u0087ò\u0099Sò¨Ô\u001d.|\u0003Í\u0000såÿË@°\u008c\u0096\t|laòGS,¢\u0012&ømÝíÃL¨·\u008e\u0002tcYÒ\u0000gåÿË@°\u0081\u0096\u0018|raóGD,¤\u0012\u001føjÝ÷ÃL¨«\u008e%tbÇ*\"²\f\rwÓQI».¦²\u0080\u001eëðÕB?'\u001a§\u0004<oûIg³9\u009e\u0082ø\u001aãØÍG7\n\u0012\u008d|\u001bgþA^«3Z\b¿\u0090\u0091/êíÌh&\f;\u0097\u001d\u0016vÏHq¢\u0002\u0087\u009e\u00999òÎ\u0016\u008bó\u0013Ý¬¦f\u0080åj\u009aw\u0011Zì¿t\u0091Ëê\u0002Ì\u0082&ä;r\u001dôv?H§¢ý\u0087z\u0099Þò\u001aÔ\u008b.ä\u0003Neß~+Pµªñ\u008fFáÇú8Ü\u00896õ\u000bFmÐF \u0000gåÿË@°\u009e\u0096\u0004|caÿGS,½\u0012\u000føjÝêÃq¨¶\u008e*ttYÏ?W$\u0090\n\u0007ðiÕÅ»R ¹\u0086\u0003l~QÍ7]\u001c\u009d\u0002\u0004èiÍÈ³4\u0000gåÿË@°\u009d\u0096\u001c|paõGX,·\u0012>øeÝùÃK\u0000AåÞËa°\u0080\u0096!|V\u009eO{ÊUi.\u0092\b>âKÿÉÙn²\u0090\u008c6fO\u001ddøéÖS\u00ad\u00ad\u008b\u001bag|þ\u0000RåßËg°\u0081\u0096$|TaÙ\u0000CåÛËw°\u0086\u0096-\u0000CåÕËz°\u0080\u0096-|AaÈG\u007f,\u0086\u0012#øPÝÇ_rºï\u0094Zï½É\b#d>ø\u0000BåÈË{°\u008f\u0096,|AaÝGe,\u0084ß!:¾\u0014\u001foæIF£6¾²\u0098\u0017óø\u0000CåÕËy°\u009e\u0096$|GaÈGsv@\u0093Ý½{Æ\u0084à+\n@", "ISO-8859-1", cArr, 0, 1265);
        f1299 = cArr;
        f1300 = -3107025183456303718L;
    }

    public cg(String str) {
        super(str);
    }

    /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
    private static Object m1552() {
        IUnityAdsListener listener;
        int i2 = f1302 + 39;
        f1301 = i2 % 128;
        if (i2 % 2 == 0) {
            listener = UnityAds.getListener();
            int i8 = 58 / 0;
        } else {
            listener = UnityAds.getListener();
        }
        f1301 = (f1302 + 101) % 128;
        return listener;
    }

    /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
    public static /* synthetic */ String m1553() {
        f1302 = (f1301 + 9) % 128;
        String strM1554 = m1554();
        int i2 = f1301 + 3;
        f1302 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 81 / 0;
        }
        return strM1554;
    }

    /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
    private static String m1554() {
        f1302 = (f1301 + 65) % 128;
        String gameId = ClientProperties.getGameId();
        f1302 = (f1301 + 109) % 128;
        return gameId;
    }

    /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
    public static /* synthetic */ Object m1555() {
        int i2 = f1301 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE;
        f1302 = i2 % 128;
        if (i2 % 2 == 0) {
            return m1552();
        }
        int i8 = 36 / 0;
        return m1552();
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static void m1558(IUnityAdsListener iUnityAdsListener) {
        f1302 = (f1301 + 47) % 128;
        UnityAds.removeListener(iUnityAdsListener);
        int i2 = f1302 + 91;
        f1301 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static UnityAdsLoadOptions m1559(AdObject adObject) {
        int i2 = f1301 + 77;
        f1302 = i2 % 128;
        if (i2 % 2 != 0) {
            adObject.getLoadOptions();
            throw null;
        }
        UnityAdsLoadOptions loadOptions = adObject.getLoadOptions();
        int i8 = f1302 + 99;
        f1301 = i8 % 128;
        if (i8 % 2 != 0) {
            return loadOptions;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    public static Object m1560() {
        f1302 = (f1301 + 45) % 128;
        WebViewApp currentApp = WebViewApp.getCurrentApp();
        int i2 = f1302 + 115;
        f1301 = i2 % 128;
        if (i2 % 2 != 0) {
            return currentApp;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static /* synthetic */ String m1564(AdObject adObject) {
        f1302 = (f1301 + 85) % 128;
        String strM1569 = m1569(adObject);
        f1301 = (f1302 + 19) % 128;
        return strM1569;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ void m1571(IUnityAdsListener iUnityAdsListener) {
        int i2 = f1301 + 81;
        f1302 = i2 % 128;
        int i8 = i2 % 2;
        m1558(iUnityAdsListener);
        if (i8 != 0) {
            int i9 = 72 / 0;
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ ByteString m1572(AdObject adObject) {
        int i2 = f1302 + 67;
        f1301 = i2 % 128;
        if (i2 % 2 != 0) {
            return m1583(adObject);
        }
        m1583(adObject);
        throw null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ UnityAdsLoadOptions m1577(AdObject adObject) {
        f1301 = (f1302 + 3) % 128;
        UnityAdsLoadOptions unityAdsLoadOptionsM1559 = m1559(adObject);
        f1302 = (f1301 + 19) % 128;
        return unityAdsLoadOptionsM1559;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static void m1585(IUnityAdsListener iUnityAdsListener) {
        int i2 = f1302 + 25;
        f1301 = i2 % 128;
        int i8 = i2 % 2;
        UnityAds.setListener(iUnityAdsListener);
        if (i8 == 0) {
            int i9 = 84 / 0;
        }
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    public static String m1557() {
        f1302 = (f1301 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
        String gameId = ClientProperties.getGameId();
        int i2 = f1301 + 51;
        f1302 = i2 % 128;
        if (i2 % 2 == 0) {
            return gameId;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static /* synthetic */ void m1567(BannerView bannerView, BannerView.IListener iListener) {
        f1301 = (f1302 + 57) % 128;
        m1582(bannerView, iListener);
        f1302 = (f1301 + 107) % 128;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ BannerView.IListener m1573(BannerView bannerView) {
        f1301 = (f1302 + 79) % 128;
        BannerView.IListener iListenerM1561 = m1561(bannerView);
        f1301 = (f1302 + 83) % 128;
        return iListenerM1561;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ String m1578(BannerView bannerView) {
        f1301 = (f1302 + 89) % 128;
        String strM1570 = m1570(bannerView);
        f1301 = (f1302 + 15) % 128;
        return strM1570;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0733  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0387  */
    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﻛ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Class mo826(java.lang.String r25) {
        /*
            Method dump skipped, instruction units count: 2250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.cg.mo826(java.lang.String):java.lang.Class");
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final Object m1586(Object obj, ch chVar) {
        a aVar = new a((WebViewApp) obj, chVar);
        int i2 = f1301 + 79;
        f1302 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 48 / 0;
        }
        return aVar;
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    public static Enum m1556(String str) {
        f1302 = (f1301 + 41) % 128;
        int iHashCode = str.hashCode();
        if (iHashCode == 183181625) {
            if (str.equals(m1563((char) (ViewConfiguration.getMaximumFlingVelocity() >> 16), 8 - TextUtils.getOffsetAfter("", 0), 1251 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)).intern())) {
                return WebRequestEvent.COMPLETE;
            }
            return null;
        }
        if (iHashCode != 2066319421 || !str.equals(m1563((char) (30215 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))), (Process.myPid() >> 22) + 6, 1259 - KeyEvent.keyCodeFromString("")).intern())) {
            return null;
        }
        int i2 = (f1302 + 71) % 128;
        f1301 = i2;
        f1302 = (i2 + 83) % 128;
        return WebRequestEvent.FAILED;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ Map m1574(DiagnosticEventRequestOuterClass.DiagnosticEvent diagnosticEvent) {
        f1302 = (f1301 + 109) % 128;
        Map mapM1565 = m1565(diagnosticEvent);
        f1302 = (f1301 + 71) % 128;
        return mapM1565;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ String m1579(DiagnosticEventRequestOuterClass.DiagnosticEvent diagnosticEvent) {
        int i2 = f1301 + 81;
        f1302 = i2 % 128;
        if (i2 % 2 != 0) {
            m1584(diagnosticEvent);
            throw null;
        }
        String strM1584 = m1584(diagnosticEvent);
        int i8 = f1301 + 5;
        f1302 = i8 % 128;
        if (i8 % 2 != 0) {
            int i9 = 46 / 0;
        }
        return strM1584;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static ByteString m1583(AdObject adObject) {
        int i2 = f1302 + 53;
        f1301 = i2 % 128;
        int i8 = i2 % 2;
        ByteString opportunityId = adObject.getOpportunityId();
        if (i8 == 0) {
            int i9 = 58 / 0;
        }
        f1301 = (f1302 + 99) % 128;
        return opportunityId;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﻐ */
    public final String mo825() {
        f1301 = (f1302 + 111) % 128;
        String version = UnityAds.getVersion();
        if (version == null) {
            f1302 = (f1301 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
            return null;
        }
        int i2 = f1301 + 59;
        f1302 = i2 % 128;
        return i2 % 2 != 0 ? version.split(m1563((char) (ViewConfiguration.getMaximumFlingVelocity() << 51), 1 - View.getDefaultSize(0, 1), (-1) - TextUtils.lastIndexOf("", 'v')).intern())[1] : version.split(m1563((char) (ViewConfiguration.getMaximumFlingVelocity() >> 16), View.getDefaultSize(0, 0) + 1, (-1) - TextUtils.lastIndexOf("", '0')).intern())[0];
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ JSONObject m1575(UnityAdsLoadOptions unityAdsLoadOptions) {
        f1301 = (f1302 + 37) % 128;
        JSONObject jSONObjectM1580 = m1580(unityAdsLoadOptions);
        int i2 = f1301 + 83;
        f1302 = i2 % 128;
        if (i2 % 2 == 0) {
            return jSONObjectM1580;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ void m1581(IUnityAdsListener iUnityAdsListener) {
        f1301 = (f1302 + 55) % 128;
        m1566(iUnityAdsListener);
        f1302 = (f1301 + 93) % 128;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m1584(DiagnosticEventRequestOuterClass.DiagnosticEvent diagnosticEvent) {
        int i2 = f1301 + 45;
        f1302 = i2 % 128;
        if (i2 % 2 != 0) {
            diagnosticEvent.getPlacementId();
            throw null;
        }
        String placementId = diagnosticEvent.getPlacementId();
        f1302 = (f1301 + 81) % 128;
        return placementId;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ void m1576(IUnityAdsListener iUnityAdsListener) {
        int i2 = f1302 + 109;
        f1301 = i2 % 128;
        int i8 = i2 % 2;
        m1585(iUnityAdsListener);
        if (i8 == 0) {
            throw null;
        }
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﾇ */
    public final Map<String, bg.a> mo827() {
        HashMap map = new HashMap();
        map.put(m1563((char) ((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 65037), Color.red(0) + 20, (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 806).intern(), new bg.a(this) { // from class: com.ironsource.adqualitysdk.sdk.i.cg.4
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return cg.m1560();
            }
        });
        map.put(m1563((char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 18, 826 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.cg.11
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return cg.this.m1586(list.get(0), chVar);
            }
        });
        map.put(m1563((char) (ViewConfiguration.getKeyRepeatDelay() >> 16), 20 - Color.blue(0), 843 - Color.red(0)).intern(), new bg.a(this) { // from class: com.ironsource.adqualitysdk.sdk.i.cg.13
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                cg.m1568(list.get(0));
                return null;
            }
        });
        map.put(m1563((char) (ViewConfiguration.getEdgeSlop() >> 16), (ViewConfiguration.getPressedStateDuration() >> 16) + 9, (-16776353) - Color.rgb(0, 0, 0)).intern(), new bg.a(this) { // from class: com.ironsource.adqualitysdk.sdk.i.cg.14
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return cg.m1557();
            }
        });
        map.put(m1563((char) (ViewConfiguration.getJumpTapTimeout() >> 16), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 19, TextUtils.lastIndexOf("", '0', 0, 0) + 873).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.cg.18
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return cg.m1555();
            }
        });
        map.put(m1563((char) (25505 - Process.getGidForName("")), (-16777197) - Color.rgb(0, 0, 0), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 891).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.cg.16
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                cg.m1576((IUnityAdsListener) list.get(0));
                return null;
            }
        });
        map.put(m1563((char) (MotionEvent.axisFromString("") + 1), 19 - TextUtils.getOffsetAfter("", 0), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 910).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.cg.17
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                cg.m1581((IUnityAdsListener) list.get(0));
                return null;
            }
        });
        map.put(m1563((char) (ViewConfiguration.getMaximumFlingVelocity() >> 16), View.MeasureSpec.getMode(0) + 22, View.resolveSizeAndState(0, 0, 0) + 929).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.cg.19
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                cg.m1571((IUnityAdsListener) list.get(0));
                return null;
            }
        });
        map.put(m1563((char) TextUtils.indexOf("", "", 0), 23 - (ViewConfiguration.getLongPressTimeout() >> 16), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 951).intern(), new bg.a(this) { // from class: com.ironsource.adqualitysdk.sdk.i.cg.20
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return cg.m1562((String) list.get(0));
            }
        });
        map.put(m1563((char) Color.argb(0, 0, 0, 0), ExpandableListView.getPackedPositionGroup(0L) + 18, 974 - (ViewConfiguration.getEdgeSlop() >> 16)).intern(), new bg.a(this) { // from class: com.ironsource.adqualitysdk.sdk.i.cg.5
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return cg.m1556((String) list.get(0));
            }
        });
        map.put(m1563((char) Color.blue(0), TextUtils.getOffsetBefore("", 0) + 14, (ViewConfiguration.getFadingEdgeLength() >> 16) + 992).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.cg.2
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return cg.m1578((BannerView) list.get(0));
            }
        });
        map.put(m1563((char) (23071 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1))), TextUtils.indexOf((CharSequence) "", '0', 0) + 18, View.resolveSizeAndState(0, 0, 0) + 1006).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.cg.1
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return cg.m1573((BannerView) list.get(0));
            }
        });
        map.put(m1563((char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), 18 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), 1023 - View.MeasureSpec.makeMeasureSpec(0, 0)).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.cg.3
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                cg.m1567((BannerView) list.get(0), (BannerView.IListener) list.get(1));
                return null;
            }
        });
        map.put(m1563((char) (ViewConfiguration.getEdgeSlop() >> 16), 16 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + IronSourceError.ERROR_IS_SHOW_EXCEPTION).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.cg.7
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return cg.m1572((AdObject) list.get(0));
            }
        });
        map.put(m1563((char) (51020 - Process.getGidForName("")), TextUtils.indexOf("", "", 0) + 26, 1056 - TextUtils.getOffsetAfter("", 0)).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.cg.6
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return cg.m1564((AdObject) list.get(0));
            }
        });
        map.put(m1563((char) (TextUtils.getOffsetBefore("", 0) + 23151), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 14, ImageFormat.getBitsPerPixel(0) + 1083).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.cg.9
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return cg.m1577((AdObject) list.get(0));
            }
        });
        map.put(m1563((char) (5868 - ExpandableListView.getPackedPositionType(0L)), TextUtils.indexOf("", "", 0) + 7, 1096 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1))).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.cg.8
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return cg.m1575((UnityAdsLoadOptions) list.get(0));
            }
        });
        map.put(m1563((char) (23179 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))), (ViewConfiguration.getJumpTapTimeout() >> 16) + 29, 1103 - KeyEvent.normalizeMetaState(0)).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.cg.10
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return cg.m1553();
            }
        });
        map.put(m1563((char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), 33 - (ViewConfiguration.getScrollBarSize() >> 8), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 1132).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.cg.15
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return cg.m1579((DiagnosticEventRequestOuterClass.DiagnosticEvent) list.get(0));
            }
        });
        map.put(m1563((char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1), Color.rgb(0, 0, 0) + 16777229, Color.green(0) + 1165).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.cg.12
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return cg.m1574((DiagnosticEventRequestOuterClass.DiagnosticEvent) list.get(0));
            }
        });
        f1301 = (f1302 + 23) % 128;
        return map;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static void m1566(IUnityAdsListener iUnityAdsListener) {
        f1301 = (f1302 + 29) % 128;
        UnityAds.addListener(iUnityAdsListener);
        f1301 = (f1302 + 87) % 128;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static void m1568(Object obj) {
        f1302 = (f1301 + 89) % 128;
        WebViewApp.setCurrentApp((a) obj);
        int i2 = f1302 + 35;
        f1301 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 74 / 0;
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static Enum m1562(String str) {
        switch (str.hashCode()) {
            case -1810696374:
                if (str.equals(m1563((char) ((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 57197), 9 - TextUtils.indexOf("", "", 0, 0), 1241 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))).intern())) {
                    return WebViewEventCategory.LIFECYCLE;
                }
                return null;
            case -1166291365:
                if (!str.equals(m1563((char) (TextUtils.getOffsetBefore("", 0) + 24353), View.MeasureSpec.getSize(0) + 7, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 1226).intern())) {
                    return null;
                }
                f1301 = (f1302 + 107) % 128;
                return WebViewEventCategory.STORAGE;
            case -276710660:
                if (str.equals(m1563((char) (40473 - (KeyEvent.getMaxKeyCode() >> 16)), View.resolveSize(0, 0) + 11, (ViewConfiguration.getScrollBarSize() >> 8) + 1184).intern())) {
                    return WebViewEventCategory.VIDEOPLAYER;
                }
                return null;
            case -54373961:
                if (str.equals(m1563((char) TextUtils.getCapsMode("", 0, 0), 12 - TextUtils.getOffsetAfter("", 0), 1214 - View.combineMeasuredStates(0, 0)).intern())) {
                    return WebViewEventCategory.CONNECTIVITY;
                }
                return null;
            case 63879010:
                if (!str.equals(m1563((char) View.resolveSizeAndState(0, 0, 0), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 5, 1209 - (Process.myTid() >> 22)).intern())) {
                    return null;
                }
                f1301 = (f1302 + 85) % 128;
                break;
                break;
            case 1167718561:
                if (str.equals(m1563((char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 9, (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 1232).intern())) {
                    return WebViewEventCategory.BROADCAST;
                }
                return null;
            case 1813675631:
                if (!str.equals(m1563((char) (7478 - KeyEvent.keyCodeFromString("")), 7 - Color.alpha(0), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 1195).intern())) {
                    return null;
                }
                int i2 = f1301 + 41;
                f1302 = i2 % 128;
                if (i2 % 2 == 0) {
                    return WebViewEventCategory.REQUEST;
                }
                break;
            case 1815350732:
                if (str.equals(m1563((char) (ViewConfiguration.getPressedStateDuration() >> 16), 7 - Color.alpha(0), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + InterfaceC2238ae.a.f8001c).intern())) {
                    return WebViewEventCategory.RESOLVE;
                }
                return null;
            case 1926303783:
                if (str.equals(m1563((char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 6, 1178 - View.resolveSize(0, 0)).intern())) {
                    return WebViewEventCategory.ADUNIT;
                }
                return null;
            default:
                return null;
        }
        return WebViewEventCategory.CACHE;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static void m1582(BannerView bannerView, BannerView.IListener iListener) {
        int i2 = f1301 + 39;
        f1302 = i2 % 128;
        int i8 = i2 % 2;
        bannerView.setListener(iListener);
        if (i8 != 0) {
            throw null;
        }
        int i9 = f1301 + 59;
        f1302 = i9 % 128;
        if (i9 % 2 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static JSONObject m1580(UnityAdsLoadOptions unityAdsLoadOptions) {
        int i2 = f1302 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE;
        f1301 = i2 % 128;
        if (i2 % 2 != 0) {
            return unityAdsLoadOptions.getData();
        }
        unityAdsLoadOptions.getData();
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static BannerView.IListener m1561(BannerView bannerView) {
        int i2 = f1302 + 45;
        f1301 = i2 % 128;
        if (i2 % 2 != 0) {
            return bannerView.getListener();
        }
        bannerView.getListener();
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static Map m1565(DiagnosticEventRequestOuterClass.DiagnosticEvent diagnosticEvent) {
        int i2 = f1301 + 57;
        f1302 = i2 % 128;
        if (i2 % 2 != 0) {
            diagnosticEvent.getStringTagsMap();
            throw null;
        }
        Map<String, String> stringTagsMap = diagnosticEvent.getStringTagsMap();
        int i8 = f1301 + 99;
        f1302 = i8 % 128;
        if (i8 % 2 == 0) {
            return stringTagsMap;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m1563(char c7, int i2, int i8) {
        String str;
        synchronized (c.f1192) {
            try {
                char[] cArr = new char[i2];
                c.f1193 = 0;
                while (true) {
                    int i9 = c.f1193;
                    if (i9 < i2) {
                        cArr[i9] = (char) ((((long) f1299[i8 + i9]) ^ (((long) i9) * f1300)) ^ ((long) c7));
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

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m1570(BannerView bannerView) {
        f1301 = (f1302 + 77) % 128;
        String placementId = bannerView.getPlacementId();
        f1302 = (f1301 + 39) % 128;
        return placementId;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m1569(AdObject adObject) {
        f1301 = (f1302 + 63) % 128;
        String placementId = adObject.getPlacementId();
        f1302 = (f1301 + 7) % 128;
        return placementId;
    }
}
