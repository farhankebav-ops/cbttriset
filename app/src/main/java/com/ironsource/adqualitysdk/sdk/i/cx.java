package com.ironsource.adqualitysdk.sdk.i;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ExpandableListView;
import com.ironsource.adqualitysdk.sdk.i.hd;
import com.ironsource.adqualitysdk.sdk.i.he;
import com.ironsource.adqualitysdk.sdk.i.hf;
import com.ironsource.adqualitysdk.sdk.i.hg;
import com.ironsource.adqualitysdk.sdk.i.hj;
import com.ironsource.adqualitysdk.sdk.i.hl;
import com.ironsource.adqualitysdk.sdk.i.kb;
import com.vungle.ads.internal.protos.Sdk;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class cx extends da {

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static long f1546 = 851433484417322958L;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f1547 = 0;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int[] f1548 = {1118288015, -1673767315, 983316224, 1366779630, 1032796688, 1376531628, -1041341268, -394628743, -1299228687, 121839276, -890122640, -27708910, 1120250127, 988817531, -1930156042, -481586389, -1683870634, -1283673466};

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static int f1549 = 1;

    /* JADX INFO: renamed from: 爫, reason: contains not printable characters */
    public static WebChromeClient m1839(List<Object> list) {
        f1547 = (f1549 + 1) % 128;
        WebChromeClient webChromeClientM2953 = kf.m2953((WebView) da.m1896(list, 0, WebView.class));
        int i2 = f1547 + 43;
        f1549 = i2 % 128;
        if (i2 % 2 != 0) {
            return webChromeClientM2953;
        }
        throw null;
    }

    /* JADX INFO: renamed from: סּ, reason: contains not printable characters */
    public static WebViewClient m1840(List<Object> list) {
        int i2 = f1547 + 87;
        f1549 = i2 % 128;
        return kf.m2950((WebView) da.m1896(list, i2 % 2 == 0 ? 1 : 0, WebView.class));
    }

    /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
    public static jt m1841(List<Object> list) {
        WebView webView;
        String strM1852;
        int i2 = f1549 + 101;
        f1547 = i2 % 128;
        if (i2 % 2 != 0) {
            webView = (WebView) da.m1896(list, 0, WebView.class);
            strM1852 = m1852(new int[]{-919126917, 1499170816, 1333307641, 113421770, 132193366, -257775839}, (ViewConfiguration.getScrollBarFadeDuration() - 108) * 40);
        } else {
            webView = (WebView) da.m1896(list, 0, WebView.class);
            strM1852 = m1852(new int[]{-919126917, 1499170816, 1333307641, 113421770, 132193366, -257775839}, (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 9);
        }
        return jt.m2766(webView, strM1852.intern());
    }

    /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
    public static boolean m1842(List<Object> list) {
        int i2 = f1547 + 43;
        f1549 = i2 % 128;
        int i8 = i2 % 2;
        boolean zM2887 = kb.m2887(da.m1896(list, 0, Object.class));
        f1549 = (f1547 + 105) % 128;
        return zM2887;
    }

    /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
    public static Object m1843(List<Object> list) {
        f1547 = (f1549 + 49) % 128;
        ((jt) da.m1896(list, 0, jt.class)).m2771();
        f1547 = (f1549 + 67) % 128;
        return null;
    }

    /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
    public static Object m1844(List<Object> list) {
        hc hcVar;
        int i2 = f1549 + 95;
        f1547 = i2 % 128;
        if (i2 % 2 != 0) {
            hcVar = (hc) da.m1896(list, 1, hc.class);
            if (hcVar == null) {
                return null;
            }
        } else {
            hcVar = (hc) da.m1896(list, 0, hc.class);
            if (hcVar == null) {
                return null;
            }
        }
        f1547 = (f1549 + 71) % 128;
        Object objMo831 = hcVar.mo831();
        f1547 = (f1549 + 99) % 128;
        return objMo831;
    }

    /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
    public static Object m1845(List<Object> list) {
        int i2 = f1549 + 61;
        f1547 = i2 % 128;
        int i8 = i2 % 2;
        ((jt) da.m1896(list, 0, jt.class)).m2773();
        return null;
    }

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    public static View.OnTouchListener m1846(List<Object> list) {
        int i2 = f1547 + 103;
        f1549 = i2 % 128;
        View.OnTouchListener onTouchListenerM2816 = jy.m2816((View) da.m1896(list, i2 % 2 == 0 ? 1 : 0, View.class));
        f1549 = (f1547 + 111) % 128;
        return onTouchListenerM2816;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static Object m1847(List<Object> list) {
        f1547 = (f1549 + 65) % 128;
        jd.m2673().m2678((in) da.m1896(list, 0, in.class));
        f1547 = (f1549 + 63) % 128;
        return null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ List m1853(List list, Object[] objArr) {
        int i2 = f1549 + 111;
        f1547 = i2 % 128;
        int i8 = i2 % 2;
        List<Object> listM1848 = m1848(list, objArr);
        if (i8 != 0) {
            int i9 = 13 / 0;
        }
        return listM1848;
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    public final Object m1855(cp cpVar, List<Object> list, final ds dsVar) {
        final cp cpVar2;
        try {
            final dq dqVar = (dq) da.m1896(list, 0, dq.class);
            final dq dqVar2 = (dq) da.m1896(list, 1, dq.class);
            final List<Object> listM1898 = da.m1898(list, 2);
            final boolean zM1854 = m1854(list, 3);
            cpVar2 = cpVar;
            try {
                View.OnAttachStateChangeListener onAttachStateChangeListener = new View.OnAttachStateChangeListener() { // from class: com.ironsource.adqualitysdk.sdk.i.cx.4

                    /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
                    private static int f1609 = 1;

                    /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
                    private static byte[] f1610 = {65, -121, -127, 124, -117, -117, -49, 52, -109, 125, -113, 119, -121, -112, -93, 109, -124, 127, -109, 127, -85, 100, 119, -103, 115, -89, 113, -117, -120, 115, -122, -71, 89, -91, -75, 56, -117, -49, 52, -119, -125, -122, -77, 0};

                    /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
                    private static int f1611 = 0;

                    /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
                    private static short[] f1612 = null;

                    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
                    private static int f1613 = -1147442923;

                    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
                    private static int f1614 = 57;

                    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
                    private static int f1615 = -1256731704;

                    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
                    private void m1880(final dq dqVar3, View view) {
                        f1609 = (f1611 + 39) % 128;
                        try {
                            final List<Object> listM1853 = cx.m1853(listM1898, new Object[]{this, view});
                            if (!zM1854) {
                                p.m2964(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.cx.4.2
                                    @Override // com.ironsource.adqualitysdk.sdk.i.iu
                                    /* JADX INFO: renamed from: ﻐ */
                                    public final void mo306() {
                                        dq dqVar4 = dqVar3;
                                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                        dqVar4.m2081(dsVar, cpVar2, listM1853);
                                    }
                                });
                                return;
                            }
                            int i2 = f1611 + 51;
                            f1609 = i2 % 128;
                            if (i2 % 2 != 0) {
                                dqVar3.m2081(dsVar, cpVar2, listM1853);
                            } else {
                                dqVar3.m2081(dsVar, cpVar2, listM1853);
                                int i8 = 3 / 0;
                            }
                        } catch (Throwable th) {
                            String strM1723 = cpVar2.m1723();
                            StringBuilder sb = new StringBuilder();
                            sb.append(m1881(TextUtils.indexOf("", "", 0, 0) - 13, (short) (122 - (ViewConfiguration.getKeyRepeatTimeout() >> 16)), 1256731704 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (byte) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))), 1147442993 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))).intern());
                            sb.append(dqVar3.m2082());
                            co.m1671(strM1723, sb.toString(), th);
                        }
                    }

                    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
                    private static String m1881(int i2, short s7, int i8, byte b8, int i9) {
                        String string;
                        synchronized (n.f2979) {
                            try {
                                StringBuilder sb = new StringBuilder();
                                int i10 = f1614;
                                int i11 = i2 + i10;
                                int i12 = i11 == -1 ? 1 : 0;
                                if (i12 != 0) {
                                    byte[] bArr = f1610;
                                    i11 = bArr != null ? (byte) (bArr[f1615 + i8] + i10) : (short) (f1612[f1615 + i8] + i10);
                                }
                                if (i11 > 0) {
                                    n.f2984 = ((i8 + i11) - 2) + f1615 + i12;
                                    n.f2982 = b8;
                                    char c7 = (char) (i9 + f1613);
                                    n.f2981 = c7;
                                    sb.append(c7);
                                    n.f2980 = n.f2981;
                                    n.f2983 = 1;
                                    while (n.f2983 < i11) {
                                        byte[] bArr2 = f1610;
                                        if (bArr2 != null) {
                                            int i13 = n.f2984;
                                            n.f2984 = i13 - 1;
                                            n.f2981 = (char) (n.f2980 + (((byte) (bArr2[i13] + s7)) ^ n.f2982));
                                        } else {
                                            short[] sArr = f1612;
                                            int i14 = n.f2984;
                                            n.f2984 = i14 - 1;
                                            n.f2981 = (char) (n.f2980 + (((short) (sArr[i14] + s7)) ^ n.f2982));
                                        }
                                        sb.append(n.f2981);
                                        n.f2980 = n.f2981;
                                        n.f2983++;
                                    }
                                }
                                string = sb.toString();
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        return string;
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public final void onViewAttachedToWindow(View view) {
                        int i2 = f1611 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE;
                        f1609 = i2 % 128;
                        if (i2 % 2 == 0) {
                            m1880(dqVar, view);
                            int i8 = 39 / 0;
                        } else {
                            m1880(dqVar, view);
                        }
                        int i9 = f1611 + 107;
                        f1609 = i9 % 128;
                        if (i9 % 2 == 0) {
                            int i10 = 11 / 0;
                        }
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public final void onViewDetachedFromWindow(View view) {
                        int i2 = f1611 + 103;
                        f1609 = i2 % 128;
                        if (i2 % 2 != 0) {
                            m1880(dqVar2, view);
                        } else {
                            m1880(dqVar2, view);
                            throw null;
                        }
                    }
                };
                f1547 = (f1549 + 39) % 128;
                return onAttachStateChangeListener;
            } catch (Exception e) {
                e = e;
                co.m1671(cpVar2.m1723(), m1852(new int[]{-1474037151, 1295562398, 2139029484, 455272523, 1679272426, 1837458458, -596954435, -1849281249, -2003869176, 1413033541, 564003821, 375932223, -276479602, -1648457643, 299343328, -1221302323, 1907789489, 1942109040, 322496536, -1525851160, -709392744, -2088234470}, View.MeasureSpec.getSize(0) + 42).intern(), e);
                return null;
            }
        } catch (Exception e4) {
            e = e4;
            cpVar2 = cpVar;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003d, code lost:
    
        com.ironsource.adqualitysdk.sdk.i.jy.m2817(r0, new com.ironsource.adqualitysdk.sdk.i.cx.AnonymousClass9());
        com.ironsource.adqualitysdk.sdk.i.cx.f1547 = (com.ironsource.adqualitysdk.sdk.i.cx.f1549 + 19) % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x004d, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:?, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0023, code lost:
    
        if (m1854(r7, 4) != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0037, code lost:
    
        if (m1854(r7, 2) != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0039, code lost:
    
        com.ironsource.adqualitysdk.sdk.i.jy.m2817(r0, r1);
     */
    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m1858(java.util.List<java.lang.Object> r7) {
        /*
            r6 = this;
            int r0 = com.ironsource.adqualitysdk.sdk.i.cx.f1547
            int r0 = r0 + 35
            int r1 = r0 % 128
            com.ironsource.adqualitysdk.sdk.i.cx.f1549 = r1
            r1 = 2
            int r0 = r0 % r1
            java.lang.Class<com.ironsource.adqualitysdk.sdk.i.hd$d> r2 = com.ironsource.adqualitysdk.sdk.i.hd.d.class
            r3 = 0
            java.lang.Class<android.media.MediaPlayer> r4 = android.media.MediaPlayer.class
            r5 = 1
            if (r0 != 0) goto L26
            java.lang.Object r0 = com.ironsource.adqualitysdk.sdk.i.da.m1896(r7, r5, r4)
            android.media.MediaPlayer r0 = (android.media.MediaPlayer) r0
            java.lang.Object r1 = com.ironsource.adqualitysdk.sdk.i.da.m1896(r7, r3, r2)
            com.ironsource.adqualitysdk.sdk.i.hd$d r1 = (com.ironsource.adqualitysdk.sdk.i.hd.d) r1
            r2 = 4
            boolean r7 = m1854(r7, r2)
            if (r7 == 0) goto L3d
            goto L39
        L26:
            java.lang.Object r0 = com.ironsource.adqualitysdk.sdk.i.da.m1896(r7, r3, r4)
            android.media.MediaPlayer r0 = (android.media.MediaPlayer) r0
            java.lang.Object r2 = com.ironsource.adqualitysdk.sdk.i.da.m1896(r7, r5, r2)
            com.ironsource.adqualitysdk.sdk.i.hd$d r2 = (com.ironsource.adqualitysdk.sdk.i.hd.d) r2
            boolean r7 = m1854(r7, r1)
            r1 = r2
            if (r7 == 0) goto L3d
        L39:
            com.ironsource.adqualitysdk.sdk.i.jy.m2817(r0, r1)
            goto L4d
        L3d:
            com.ironsource.adqualitysdk.sdk.i.cx$9 r7 = new com.ironsource.adqualitysdk.sdk.i.cx$9
            r7.<init>()
            com.ironsource.adqualitysdk.sdk.i.jy.m2817(r0, r7)
            int r7 = com.ironsource.adqualitysdk.sdk.i.cx.f1549
            int r7 = r7 + 19
            int r7 = r7 % 128
            com.ironsource.adqualitysdk.sdk.i.cx.f1547 = r7
        L4d:
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.cx.m1858(java.util.List):java.lang.Object");
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    public final Object m1860(cp cpVar, List<Object> list, final ds dsVar) {
        final cp cpVar2;
        try {
            final dq dqVar = (dq) da.m1896(list, 0, dq.class);
            final List<Object> listM1898 = da.m1898(list, 1);
            final boolean zM1854 = m1854(list, 2);
            cpVar2 = cpVar;
            try {
                View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.ironsource.adqualitysdk.sdk.i.cx.2

                    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
                    private static int f1593 = 0;

                    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
                    private static int f1594 = 1;

                    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
                    private static char[] f1595 = {'E', 'r', 'o', ' ', 'i', 'n', 'O', 'L', 'a', 'y', 'u', 't', 'C', 'h', 'g', 'e', 's', 'd', 'F', 'G', 'H', 'I', 'J', 'K', 'M'};

                    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
                    private static char f1596 = 5;

                    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
                    private static String m1879(int i2, byte b8, String str) {
                        String str2;
                        Object charArray = str;
                        if (str != null) {
                            charArray = str.toCharArray();
                        }
                        char[] cArr = (char[]) charArray;
                        synchronized (h.f2264) {
                            try {
                                char[] cArr2 = f1595;
                                char c7 = f1596;
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

                    @Override // android.view.View.OnLayoutChangeListener
                    public final void onLayoutChange(View view, int i2, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
                        f1593 = (f1594 + 29) % 128;
                        try {
                            final List<Object> listM1853 = cx.m1853(listM1898, new Object[]{this, view, Integer.valueOf(i2), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14)});
                            if (!zM1854) {
                                p.m2964(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.cx.2.2
                                    @Override // com.ironsource.adqualitysdk.sdk.i.iu
                                    /* JADX INFO: renamed from: ﻐ */
                                    public final void mo306() {
                                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                        dqVar.m2081(dsVar, cpVar2, listM1853);
                                    }
                                });
                                int i15 = f1593 + 93;
                                f1594 = i15 % 128;
                                if (i15 % 2 == 0) {
                                    throw null;
                                }
                                return;
                            }
                            int i16 = f1594 + 1;
                            f1593 = i16 % 128;
                            if (i16 % 2 == 0) {
                                dqVar.m2081(dsVar, cpVar2, listM1853);
                            } else {
                                dqVar.m2081(dsVar, cpVar2, listM1853);
                                int i17 = 12 / 0;
                            }
                        } catch (Throwable th) {
                            String strM1723 = cpVar2.m1723();
                            StringBuilder sb = new StringBuilder();
                            sb.append(m1879(39 - TextUtils.getOffsetBefore("", 0), (byte) (TextUtils.getTrimmedLength("") + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE), "\u0001\u0002\u0002\u0003\u0002\u0004\u0000\t\u0001\b\u0006\b\t\u0005\u0000\f\f\r\u0012\r\t\n\u0011\u0005\u0001\u0013\n\u0010\n\u0014\u0002\u0004\u0000\t\u0013\u0001\u0012\u0010\u009d").intern());
                            sb.append(dqVar.m2082());
                            co.m1671(strM1723, sb.toString(), th);
                        }
                    }
                };
                f1547 = (f1549 + 63) % 128;
                return onLayoutChangeListener;
            } catch (Exception e) {
                e = e;
                co.m1671(cpVar2.m1723(), m1850("例ગ엪耠嬐ᘹ킯ꮑ曳ℬﰔ띾熤첆螴䈄ᴐ\ud859銩涆⣽\ue33c븈祐㎮躜䧾Р\udf1f驝咭⾈\ueadaꔠ怖㭊\uf5b0", (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 17707).intern(), e);
                return null;
            }
        } catch (Exception e4) {
            e = e4;
            cpVar2 = cpVar;
        }
    }

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    public final Object m1862(cp cpVar, List<Object> list, final ds dsVar) {
        final cp cpVar2;
        final dq dqVar;
        final List<Object> listM1898;
        try {
            dqVar = (dq) da.m1896(list, 0, dq.class);
            listM1898 = da.m1898(list, 1);
            cpVar2 = cpVar;
        } catch (Exception e) {
            e = e;
            cpVar2 = cpVar;
        }
        try {
            he.b bVar = new he.b() { // from class: com.ironsource.adqualitysdk.sdk.i.cx.17
                @Override // com.ironsource.adqualitysdk.sdk.i.he.b
                /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
                public final void mo1877(he heVar, MediaPlayer mediaPlayer) {
                    dqVar.m2081(dsVar, cpVar2, cx.m1853(listM1898, new Object[]{this, heVar, mediaPlayer}));
                }
            };
            f1547 = (f1549 + 25) % 128;
            return bVar;
        } catch (Exception e4) {
            e = e4;
            co.m1671(cpVar2.m1723(), m1850("例㛛뵲⎔ꨠჭ韇ṭ蒓ର\uf1bc磊ｴ斒\uec4c劊\ud9db䁽욙䴊㎒뫑ⅵꟶ⸃钳\u1bf7艽ࣉ輊疱ﳇ捂\ue9ec倔횲川쑃䫈ㄖ랥㻅ꕍ⯭鈟ᢧ", 31079 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1))).intern(), e);
            return null;
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final in m1865(final cp cpVar, List<Object> list, final ds dsVar) {
        final dq dqVar = (dq) da.m1896(list, 0, dq.class);
        final ArrayList arrayList = new ArrayList();
        if (list.size() > 1) {
            int i2 = f1549 + 105;
            f1547 = i2 % 128;
            int i8 = i2 % 2;
            arrayList.addAll((Collection) da.m1896(list, 1, List.class));
        }
        if (dqVar != null) {
            return new in() { // from class: com.ironsource.adqualitysdk.sdk.i.cx.1
                @Override // com.ironsource.adqualitysdk.sdk.i.in
                /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
                public final void mo1872() {
                    arrayList.add(0, this);
                    dqVar.m2081(dsVar, cpVar, arrayList);
                    arrayList.remove(0);
                }
            };
        }
        f1549 = (f1547 + 11) % 128;
        return null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final Object m1867(cp cpVar, List<Object> list, final ds dsVar) {
        final cp cpVar2;
        final dq dqVar;
        final List<Object> listM1898;
        try {
            dqVar = (dq) da.m1896(list, 0, dq.class);
            listM1898 = da.m1898(list, 1);
            cpVar2 = cpVar;
        } catch (Exception e) {
            e = e;
            cpVar2 = cpVar;
        }
        try {
            hg.a aVar = new hg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.cx.10
                @Override // com.ironsource.adqualitysdk.sdk.i.hg.a
                /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
                public final void mo1873(hg hgVar, View view) {
                    dqVar.m2081(dsVar, cpVar2, cx.m1853(listM1898, new Object[]{this, hgVar, view}));
                }
            };
            f1549 = (f1547 + 29) % 128;
            return aVar;
        } catch (Exception e4) {
            e = e4;
            co.m1671(cpVar2.m1723(), m1850("例蕵\uda2e⿺撘먃輛쓃᧣溾ꑠ滑컌Μ夐깟\ue337㣲ඛ䍪頔\uedf0⋤瞨䵵舄ퟨⲔ扁띿谥쇷ᚋ汕", (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 51913).intern(), e);
            return null;
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final Object m1869(cp cpVar, List<Object> list, final ds dsVar) {
        final cp cpVar2;
        try {
            final dq dqVar = (dq) da.m1896(list, 0, dq.class);
            final List<Object> listM1898 = da.m1898(list, 1);
            cpVar2 = cpVar;
            try {
                hl.c cVar = new hl.c() { // from class: com.ironsource.adqualitysdk.sdk.i.cx.11
                    @Override // com.ironsource.adqualitysdk.sdk.i.hl.c
                    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
                    public final boolean mo1874(hl hlVar, View view, MotionEvent motionEvent) {
                        return dqVar.m2081(dsVar, cpVar2, cx.m1853(listM1898, new Object[]{this, hlVar, view, motionEvent})).m2150();
                    }
                };
                int i2 = f1549 + 95;
                f1547 = i2 % 128;
                if (i2 % 2 == 0) {
                    return cVar;
                }
                throw null;
            } catch (Exception e) {
                e = e;
                co.m1671(cpVar2.m1723(), m1852(new int[]{-1474037151, 1295562398, 2139029484, 455272523, 1679272426, 1837458458, -502840595, 1924565872, -1125259155, 130205991, 970403393, -1490217833, -1134465792, 538067013, 322496536, -1525851160, -709392744, -2088234470}, View.MeasureSpec.getMode(0) + 34).intern(), e);
                return null;
            }
        } catch (Exception e4) {
            e = e4;
            cpVar2 = cpVar;
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static Object m1851(List<Object> list) {
        f1547 = (f1549 + 57) % 128;
        jd.m2673().m2677((in) da.m1896(list, 0, in.class));
        f1549 = (f1547 + 99) % 128;
        return null;
    }

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    public final Object m1859(cp cpVar, List<Object> list, final ds dsVar) {
        final cp cpVar2;
        final dq dqVar;
        final List<Object> listM1898;
        try {
            dqVar = (dq) da.m1896(list, 0, dq.class);
            listM1898 = da.m1898(list, 1);
            cpVar2 = cpVar;
        } catch (Exception e) {
            e = e;
            cpVar2 = cpVar;
        }
        try {
            hj.e eVar = new hj.e() { // from class: com.ironsource.adqualitysdk.sdk.i.cx.18
                @Override // com.ironsource.adqualitysdk.sdk.i.hj.e
                /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
                public final void mo1878(hj hjVar, MediaPlayer mediaPlayer) {
                    dqVar.m2081(dsVar, cpVar2, cx.m1853(listM1898, new Object[]{this, hjVar, mediaPlayer}));
                }
            };
            f1549 = (f1547 + 83) % 128;
            return eVar;
        } catch (Exception e4) {
            e = e4;
            co.m1671(cpVar2.m1723(), m1852(new int[]{-1474037151, 1295562398, 2139029484, 455272523, 1679272426, 1837458458, 807782759, 1040963414, 590624635, -968144267, -2054494323, 481852369, -357778542, 68073136, 231828459, 112086463, -366733791, 921154347, 1140713273, -228621096, -1851246817, 32597982, 366795816, -393311979}, (ViewConfiguration.getFadingEdgeLength() >> 16) + 48).intern(), e);
            return null;
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final Object m1864(cp cpVar, List<Object> list, final ds dsVar) {
        final cp cpVar2;
        final dq dqVar;
        final List<Object> listM1898;
        try {
            dqVar = (dq) da.m1896(list, 0, dq.class);
            listM1898 = da.m1898(list, 1);
            cpVar2 = cpVar;
        } catch (Exception e) {
            e = e;
            cpVar2 = cpVar;
        }
        try {
            hd.d dVar = new hd.d() { // from class: com.ironsource.adqualitysdk.sdk.i.cx.13
                @Override // com.ironsource.adqualitysdk.sdk.i.hd.d
                /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
                public final boolean mo1875(hd hdVar, MediaPlayer mediaPlayer, int i2, int i8) {
                    return dqVar.m2081(dsVar, cpVar2, cx.m1853(listM1898, new Object[]{this, hdVar, mediaPlayer, Integer.valueOf(i2), Integer.valueOf(i8)})).m2150();
                }
            };
            f1547 = (f1549 + 91) % 128;
            return dVar;
        } catch (Exception e4) {
            e = e4;
            co.m1671(cpVar2.m1723(), m1852(new int[]{-1474037151, 1295562398, 2139029484, 455272523, 1679272426, 1837458458, 807782759, 1040963414, 590624635, -968144267, -2054494323, 481852369, -357778542, 68073136, -1013425922, -860153078, -1851246817, 32597982, 366795816, -393311979}, 40 - (ViewConfiguration.getDoubleTapTimeout() >> 16)).intern(), e);
            return null;
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static View.OnClickListener m1849(List<Object> list) {
        int i2 = f1547 + 61;
        f1549 = i2 % 128;
        int i8 = i2 % 2;
        return jy.m2821((View) da.m1896(list, 0, View.class));
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0044, code lost:
    
        com.ironsource.adqualitysdk.sdk.i.jy.m2818(r0, new com.ironsource.adqualitysdk.sdk.i.cx.AnonymousClass3());
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x004c, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:?, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0022, code lost:
    
        if (m1854(r7, 5) != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0037, code lost:
    
        if (m1854(r7, 2) != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0039, code lost:
    
        com.ironsource.adqualitysdk.sdk.i.jy.m2818(r0, r1);
        com.ironsource.adqualitysdk.sdk.i.cx.f1549 = (com.ironsource.adqualitysdk.sdk.i.cx.f1547 + 5) % 128;
     */
    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m1863(java.util.List<java.lang.Object> r7) {
        /*
            r6 = this;
            int r0 = com.ironsource.adqualitysdk.sdk.i.cx.f1547
            int r0 = r0 + 43
            int r1 = r0 % 128
            com.ironsource.adqualitysdk.sdk.i.cx.f1549 = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 5
            java.lang.Class<com.ironsource.adqualitysdk.sdk.i.hj$e> r3 = com.ironsource.adqualitysdk.sdk.i.hj.e.class
            java.lang.Class<android.media.MediaPlayer> r4 = android.media.MediaPlayer.class
            r5 = 1
            if (r0 != 0) goto L25
            java.lang.Object r0 = com.ironsource.adqualitysdk.sdk.i.da.m1896(r7, r5, r4)
            android.media.MediaPlayer r0 = (android.media.MediaPlayer) r0
            java.lang.Object r1 = com.ironsource.adqualitysdk.sdk.i.da.m1896(r7, r5, r3)
            com.ironsource.adqualitysdk.sdk.i.hj$e r1 = (com.ironsource.adqualitysdk.sdk.i.hj.e) r1
            boolean r7 = m1854(r7, r2)
            if (r7 == 0) goto L44
            goto L39
        L25:
            r0 = 0
            java.lang.Object r0 = com.ironsource.adqualitysdk.sdk.i.da.m1896(r7, r0, r4)
            android.media.MediaPlayer r0 = (android.media.MediaPlayer) r0
            java.lang.Object r3 = com.ironsource.adqualitysdk.sdk.i.da.m1896(r7, r5, r3)
            com.ironsource.adqualitysdk.sdk.i.hj$e r3 = (com.ironsource.adqualitysdk.sdk.i.hj.e) r3
            boolean r7 = m1854(r7, r1)
            r1 = r3
            if (r7 == 0) goto L44
        L39:
            com.ironsource.adqualitysdk.sdk.i.jy.m2818(r0, r1)
            int r7 = com.ironsource.adqualitysdk.sdk.i.cx.f1547
            int r7 = r7 + r2
            int r7 = r7 % 128
            com.ironsource.adqualitysdk.sdk.i.cx.f1549 = r7
            goto L4c
        L44:
            com.ironsource.adqualitysdk.sdk.i.cx$3 r7 = new com.ironsource.adqualitysdk.sdk.i.cx$3
            r7.<init>()
            com.ironsource.adqualitysdk.sdk.i.jy.m2818(r0, r7)
        L4c:
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.cx.m1863(java.util.List):java.lang.Object");
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final Object m1870(List<Object> list) {
        View view = (View) da.m1896(list, 0, View.class);
        final hl.c cVar = (hl.c) da.m1896(list, 1, hl.c.class);
        if (m1854(list, 2)) {
            int i2 = f1547 + 95;
            f1549 = i2 % 128;
            if (i2 % 2 == 0) {
                jy.m2825(view, cVar);
                throw null;
            }
            jy.m2825(view, cVar);
        } else {
            jy.m2825(view, new hl.c() { // from class: com.ironsource.adqualitysdk.sdk.i.cx.12
                @Override // com.ironsource.adqualitysdk.sdk.i.hl.c
                /* JADX INFO: renamed from: ﻛ */
                public final boolean mo1874(final hl hlVar, final View view2, final MotionEvent motionEvent) {
                    p.m2964(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.cx.12.5
                        @Override // com.ironsource.adqualitysdk.sdk.i.iu
                        /* JADX INFO: renamed from: ﻐ */
                        public final void mo306() {
                            cVar.mo1874(hlVar, view2, motionEvent);
                        }
                    });
                    return false;
                }
            });
        }
        f1549 = (f1547 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE) % 128;
        return null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final Object m1871(cp cpVar, List<Object> list, final ds dsVar) {
        final cp cpVar2;
        final dq dqVar;
        final List<Object> listM1898;
        try {
            dqVar = (dq) da.m1896(list, 0, dq.class);
            listM1898 = da.m1898(list, 1);
            cpVar2 = cpVar;
        } catch (Exception e) {
            e = e;
            cpVar2 = cpVar;
        }
        try {
            hf.a aVar = new hf.a() { // from class: com.ironsource.adqualitysdk.sdk.i.cx.15
                @Override // com.ironsource.adqualitysdk.sdk.i.hf.a
                /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
                public final void mo1876(hf hfVar, MediaPlayer mediaPlayer) {
                    dqVar.m2081(dsVar, cpVar2, cx.m1853(listM1898, new Object[]{this, hfVar, mediaPlayer}));
                }
            };
            f1547 = (f1549 + 95) % 128;
            return aVar;
        } catch (Exception e4) {
            e = e4;
            co.m1671(cpVar2.m1723(), m1850("例將棊璐Őⵉ㧏얡퉳︼諴隮ꍤ俖寔桶琛Áⲁ㥎씂퇵ﶽ詺阣ꋿ使嬙柪玓AⰛ㣏쒧텽ﴻ觎閠ꉿ仇媓杓猅\u1fd5", 5051 - View.getDefaultSize(0, 0)).intern(), e);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003c A[PHI: r0 r2
  0x003c: PHI (r0v9 android.media.MediaPlayer) = (r0v5 android.media.MediaPlayer), (r0v11 android.media.MediaPlayer) binds: [B:8:0x0036, B:5:0x0022] A[DONT_GENERATE, DONT_INLINE]
  0x003c: PHI (r2v4 com.ironsource.adqualitysdk.sdk.i.hf$a) = (r2v2 com.ironsource.adqualitysdk.sdk.i.hf$a), (r2v6 com.ironsource.adqualitysdk.sdk.i.hf$a) binds: [B:8:0x0036, B:5:0x0022] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0038 A[PHI: r0 r2
  0x0038: PHI (r0v6 android.media.MediaPlayer) = (r0v5 android.media.MediaPlayer), (r0v11 android.media.MediaPlayer) binds: [B:8:0x0036, B:5:0x0022] A[DONT_GENERATE, DONT_INLINE]
  0x0038: PHI (r2v3 com.ironsource.adqualitysdk.sdk.i.hf$a) = (r2v2 com.ironsource.adqualitysdk.sdk.i.hf$a), (r2v6 com.ironsource.adqualitysdk.sdk.i.hf$a) binds: [B:8:0x0036, B:5:0x0022] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m1861(java.util.List<java.lang.Object> r6) {
        /*
            r5 = this;
            int r0 = com.ironsource.adqualitysdk.sdk.i.cx.f1549
            int r0 = r0 + 93
            int r1 = r0 % 128
            com.ironsource.adqualitysdk.sdk.i.cx.f1547 = r1
            r1 = 2
            int r0 = r0 % r1
            java.lang.Class<com.ironsource.adqualitysdk.sdk.i.hf$a> r2 = com.ironsource.adqualitysdk.sdk.i.hf.a.class
            java.lang.Class<android.media.MediaPlayer> r3 = android.media.MediaPlayer.class
            r4 = 1
            if (r0 == 0) goto L25
            java.lang.Object r0 = com.ironsource.adqualitysdk.sdk.i.da.m1896(r6, r4, r3)
            android.media.MediaPlayer r0 = (android.media.MediaPlayer) r0
            java.lang.Object r2 = com.ironsource.adqualitysdk.sdk.i.da.m1896(r6, r4, r2)
            com.ironsource.adqualitysdk.sdk.i.hf$a r2 = (com.ironsource.adqualitysdk.sdk.i.hf.a) r2
            r3 = 5
            boolean r6 = m1854(r6, r3)
            if (r6 == 0) goto L3c
            goto L38
        L25:
            r0 = 0
            java.lang.Object r0 = com.ironsource.adqualitysdk.sdk.i.da.m1896(r6, r0, r3)
            android.media.MediaPlayer r0 = (android.media.MediaPlayer) r0
            java.lang.Object r2 = com.ironsource.adqualitysdk.sdk.i.da.m1896(r6, r4, r2)
            com.ironsource.adqualitysdk.sdk.i.hf$a r2 = (com.ironsource.adqualitysdk.sdk.i.hf.a) r2
            boolean r6 = m1854(r6, r1)
            if (r6 == 0) goto L3c
        L38:
            com.ironsource.adqualitysdk.sdk.i.jy.m2820(r0, r2)
            goto L44
        L3c:
            com.ironsource.adqualitysdk.sdk.i.cx$5 r6 = new com.ironsource.adqualitysdk.sdk.i.cx$5
            r6.<init>()
            com.ironsource.adqualitysdk.sdk.i.jy.m2820(r0, r6)
        L44:
            int r6 = com.ironsource.adqualitysdk.sdk.i.cx.f1547
            int r6 = r6 + 19
            int r0 = r6 % 128
            com.ironsource.adqualitysdk.sdk.i.cx.f1549 = r0
            int r6 = r6 % r1
            r0 = 0
            if (r6 == 0) goto L51
            return r0
        L51:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.cx.m1861(java.util.List):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003b A[PHI: r0 r1
  0x003b: PHI (r0v8 android.view.View) = (r0v4 android.view.View), (r0v10 android.view.View) binds: [B:8:0x0035, B:5:0x0022] A[DONT_GENERATE, DONT_INLINE]
  0x003b: PHI (r1v4 com.ironsource.adqualitysdk.sdk.i.hg$a) = (r1v2 com.ironsource.adqualitysdk.sdk.i.hg$a), (r1v6 com.ironsource.adqualitysdk.sdk.i.hg$a) binds: [B:8:0x0035, B:5:0x0022] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0037 A[PHI: r0 r1
  0x0037: PHI (r0v5 android.view.View) = (r0v4 android.view.View), (r0v10 android.view.View) binds: [B:8:0x0035, B:5:0x0022] A[DONT_GENERATE, DONT_INLINE]
  0x0037: PHI (r1v3 com.ironsource.adqualitysdk.sdk.i.hg$a) = (r1v2 com.ironsource.adqualitysdk.sdk.i.hg$a), (r1v6 com.ironsource.adqualitysdk.sdk.i.hg$a) binds: [B:8:0x0035, B:5:0x0022] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m1866(java.util.List<java.lang.Object> r7) {
        /*
            r6 = this;
            int r0 = com.ironsource.adqualitysdk.sdk.i.cx.f1547
            r1 = 1
            int r0 = r0 + r1
            int r2 = r0 % 128
            com.ironsource.adqualitysdk.sdk.i.cx.f1549 = r2
            r2 = 2
            int r0 = r0 % r2
            java.lang.Class<com.ironsource.adqualitysdk.sdk.i.hg$a> r3 = com.ironsource.adqualitysdk.sdk.i.hg.a.class
            r4 = 0
            java.lang.Class<android.view.View> r5 = android.view.View.class
            if (r0 != 0) goto L25
            java.lang.Object r0 = com.ironsource.adqualitysdk.sdk.i.da.m1896(r7, r1, r5)
            android.view.View r0 = (android.view.View) r0
            java.lang.Object r1 = com.ironsource.adqualitysdk.sdk.i.da.m1896(r7, r4, r3)
            com.ironsource.adqualitysdk.sdk.i.hg$a r1 = (com.ironsource.adqualitysdk.sdk.i.hg.a) r1
            r3 = 5
            boolean r7 = m1854(r7, r3)
            if (r7 == 0) goto L3b
            goto L37
        L25:
            java.lang.Object r0 = com.ironsource.adqualitysdk.sdk.i.da.m1896(r7, r4, r5)
            android.view.View r0 = (android.view.View) r0
            java.lang.Object r1 = com.ironsource.adqualitysdk.sdk.i.da.m1896(r7, r1, r3)
            com.ironsource.adqualitysdk.sdk.i.hg$a r1 = (com.ironsource.adqualitysdk.sdk.i.hg.a) r1
            boolean r7 = m1854(r7, r2)
            if (r7 == 0) goto L3b
        L37:
            com.ironsource.adqualitysdk.sdk.i.jy.m2824(r0, r1)
            goto L4b
        L3b:
            com.ironsource.adqualitysdk.sdk.i.cx$14 r7 = new com.ironsource.adqualitysdk.sdk.i.cx$14
            r7.<init>()
            com.ironsource.adqualitysdk.sdk.i.jy.m2824(r0, r7)
            int r7 = com.ironsource.adqualitysdk.sdk.i.cx.f1547
            int r7 = r7 + 73
            int r7 = r7 % 128
            com.ironsource.adqualitysdk.sdk.i.cx.f1549 = r7
        L4b:
            int r7 = com.ironsource.adqualitysdk.sdk.i.cx.f1549
            int r7 = r7 + 55
            int r0 = r7 % 128
            com.ironsource.adqualitysdk.sdk.i.cx.f1547 = r0
            int r7 = r7 % r2
            r0 = 0
            if (r7 != 0) goto L58
            return r0
        L58:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.cx.m1866(java.util.List):java.lang.Object");
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m1850(String str, int i2) {
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
                        cArr2[i8] = (char) (((long) (cArr[i8] ^ (j.f2669 * i8))) ^ f1546);
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

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    public final Object m1856(List<Object> list) {
        f1547 = (f1549 + 5) % 128;
        MediaPlayer mediaPlayer = (MediaPlayer) da.m1896(list, 0, MediaPlayer.class);
        final he.b bVar = (he.b) da.m1896(list, 1, he.b.class);
        if (m1854(list, 2)) {
            f1547 = (f1549 + 75) % 128;
            jy.m2830(mediaPlayer, bVar);
            return null;
        }
        jy.m2830(mediaPlayer, new he.b() { // from class: com.ironsource.adqualitysdk.sdk.i.cx.8
            @Override // com.ironsource.adqualitysdk.sdk.i.he.b
            /* JADX INFO: renamed from: ｋ */
            public final void mo1877(final he heVar, final MediaPlayer mediaPlayer2) {
                p.m2964(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.cx.8.3
                    @Override // com.ironsource.adqualitysdk.sdk.i.iu
                    /* JADX INFO: renamed from: ﻐ */
                    public final void mo306() {
                        bVar.mo1877(heVar, mediaPlayer2);
                    }
                });
            }
        });
        return null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static List<Object> m1848(List<Object> list, Object... objArr) {
        ArrayList arrayList = new ArrayList(Arrays.asList(objArr));
        if (list != null) {
            f1549 = (f1547 + 71) % 128;
            arrayList.addAll(list);
            f1549 = (f1547 + 19) % 128;
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001c  */
    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean m1854(java.util.List<java.lang.Object> r3, int r4) {
        /*
            int r0 = com.ironsource.adqualitysdk.sdk.i.cx.f1549
            int r0 = r0 + 111
            int r1 = r0 % 128
            com.ironsource.adqualitysdk.sdk.i.cx.f1547 = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto L16
            int r0 = r3.size()
            r2 = 6
            int r2 = r2 / r1
            if (r0 <= r4) goto L39
            goto L1c
        L16:
            int r0 = r3.size()
            if (r0 <= r4) goto L39
        L1c:
            java.lang.Class<java.lang.Boolean> r0 = java.lang.Boolean.class
            java.lang.Object r3 = com.ironsource.adqualitysdk.sdk.i.da.m1896(r3, r4, r0)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L39
            int r3 = com.ironsource.adqualitysdk.sdk.i.cx.f1549
            int r3 = r3 + 111
            int r4 = r3 % 128
            com.ironsource.adqualitysdk.sdk.i.cx.f1547 = r4
            int r3 = r3 % 2
            if (r3 == 0) goto L37
            return r1
        L37:
            r3 = 1
            return r3
        L39:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.cx.m1854(java.util.List, int):boolean");
    }

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    public final Object m1857(cp cpVar, List<Object> list, final ds dsVar) {
        final cp cpVar2;
        try {
            final dq dqVar = (dq) da.m1896(list, 0, dq.class);
            final List<Object> listM1898 = da.m1898(list, 1);
            final boolean zM1854 = m1854(list, 2);
            cpVar2 = cpVar;
            try {
                BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.ironsource.adqualitysdk.sdk.i.cx.6
                    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
                    public static /* synthetic */ void m1882(AnonymousClass6 anonymousClass6, dq dqVar2, ds dsVar2, cp cpVar3, List list2, Context context, Intent intent) {
                        dqVar2.m2081(dsVar2, cpVar3, cx.m1853(list2, new Object[]{anonymousClass6, context, intent}));
                    }

                    @Override // android.content.BroadcastReceiver
                    public final void onReceive(final Context context, final Intent intent) {
                        if (zM1854) {
                            dqVar.m2081(dsVar, cpVar2, cx.m1853(listM1898, new Object[]{this, context, intent}));
                        } else {
                            p.m2964(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.cx.6.2
                                @Override // com.ironsource.adqualitysdk.sdk.i.iu
                                /* JADX INFO: renamed from: ﻐ */
                                public final void mo306() {
                                    AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                                    AnonymousClass6.m1882(anonymousClass6, dqVar, dsVar, cpVar2, listM1898, context, intent);
                                }
                            });
                        }
                    }
                };
                int i2 = f1547 + 77;
                f1549 = i2 % 128;
                if (i2 % 2 != 0) {
                    return broadcastReceiver;
                }
                throw null;
            } catch (Exception e) {
                e = e;
                co.m1671(cpVar2.m1723(), m1852(new int[]{-1474037151, 1295562398, 2139029484, 455272523, 1679272426, 1837458458, 1291975682, -2015985571, -1939559134, 519983309, -217131107, -1434860529, 1678521733, 446051979, 1287045291, -1580179805}, (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 32).intern(), e);
                return null;
            }
        } catch (Exception e4) {
            e = e4;
            cpVar2 = cpVar;
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m1852(int[] iArr, int i2) {
        String str;
        synchronized (d.f1664) {
            try {
                char[] cArr = new char[4];
                char[] cArr2 = new char[iArr.length << 1];
                int[] iArr2 = (int[]) f1548.clone();
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

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final Object m1868(final cp cpVar, List<Object> list) {
        final String simpleName;
        final boolean zBooleanValue = false;
        Class cls = (Class) da.m1896(list, 0, Class.class);
        Object objM1896 = da.m1896(list, 1, (Class<Object>) Object.class);
        if (list.size() > 2) {
            zBooleanValue = ((Boolean) da.m1896(list, 2, Boolean.class)).booleanValue();
        } else {
            f1547 = (f1549 + 41) % 128;
        }
        if (list.size() > 3) {
            simpleName = (String) da.m1896(list, 3, String.class);
            f1549 = (f1547 + 55) % 128;
        } else {
            simpleName = cls.getSimpleName();
        }
        return kb.m2888(cls, objM1896, new kb.c() { // from class: com.ironsource.adqualitysdk.sdk.i.cx.7

            /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
            private static int f1639 = 0;

            /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
            private static char f1640 = 0;

            /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
            private static int f1641 = 1;

            /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
            private static int f1642 = 0;

            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            private static long f1643 = 867508244022987069L;

            /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
            private static String m1883(String str, char c7, String str2, int i2, String str3) {
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
                                cArr6[i12] = (char) (((((long) (c9 ^ cArr2[i12])) ^ f1643) ^ ((long) f1642)) ^ ((long) f1640));
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

            @Override // com.ironsource.adqualitysdk.sdk.i.kb.c
            /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
            public final void mo1884(Object obj, Method method, Object[] objArr) {
                List arrayList;
                f1639 = (f1641 + 107) % 128;
                if (method != null) {
                    try {
                        StringBuilder sb = new StringBuilder();
                        sb.append(simpleName);
                        sb.append(m1883("䞷ﳯ⣅檑", (char) (37159 - TextUtils.lastIndexOf("", '0')), "碖", (-973279417) - KeyEvent.normalizeMetaState(0), "褽풶Ȧఊ").intern());
                        sb.append(method.getName());
                        String string = sb.toString();
                        hc hcVar = (hc) obj;
                        if (objArr != null) {
                            int i2 = f1639 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE;
                            f1641 = i2 % 128;
                            if (i2 % 2 == 0) {
                                Arrays.asList(objArr);
                                throw null;
                            }
                            arrayList = Arrays.asList(objArr);
                        } else {
                            arrayList = new ArrayList();
                        }
                        List<Object> listM1853 = cx.m1853(arrayList, new Object[]{hcVar});
                        ArrayList arrayList2 = new ArrayList();
                        if (zBooleanValue) {
                            f1641 = (f1639 + 57) % 128;
                            arrayList2.add(listM1853);
                            listM1853 = arrayList2;
                        }
                        cpVar.m1720().mo1591(string, listM1853);
                        f1639 = (f1641 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE) % 128;
                    } catch (Exception e) {
                        String strM1723 = cpVar.m1723();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(m1883("\ud9e9ඏ飈⨃", (char) (Process.getGidForName("") + 921), "嶃粀欋텁췟⌟箮Ꙃ씿꿦㉛㦅ዺ\uf259\uebdb", (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) - 938635303, "褽풶Ȧఊ").intern());
                        sb2.append(method.getName());
                        sb2.append(m1883("\ue54a윔\ue49c잯", (char) (ViewConfiguration.getLongPressTimeout() >> 16), "䠒汻띻ޞ⭰嗃\udae2춣ꡎ⥩ꩉ", KeyEvent.keyCodeFromString("") - 1664674587, "褽풶Ȧఊ").intern());
                        sb2.append(simpleName);
                        sb2.append(m1883("撒됣ㅓč", (char) Color.argb(0, 0, 0, 0), "㨦⋏ꇋ뢭怸矫뤓輦큖", 1404314469 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), "褽풶Ȧఊ").intern());
                        co.m1671(strM1723, sb2.toString(), e);
                    }
                }
            }
        });
    }
}
