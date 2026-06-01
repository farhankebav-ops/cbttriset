package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.BuildConfig;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeAdView;
import com.facebook.ads.NativeBannerAd;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.RewardedVideoAdListener;
import com.facebook.ads.internal.DisplayAdController;
import com.facebook.ads.internal.adapters.AdAdapter;
import com.facebook.ads.internal.dynamicloading.DynamicLoader;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.facebook.ads.internal.settings.AdSdkVersion;
import com.facebook.ads.internal.view.component.CircularProgressView;
import com.ironsource.adqualitysdk.sdk.i.bg;
import com.vungle.ads.internal.protos.Sdk;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class bp extends bg {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f972 = 1;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f973 = 0;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static char[] f974 = {'z', 261, 263, 270, 293, 291, 291, 'Q', 180, 204, 207, 204, 196, 203, 187, 176, 177, 183, 204, 207, 209, 206, 203, 202, 198, 201, '9', 'Y', 'R', 'Y', 'W', 'j', 'n', 'o', 'm', 'S', 'Q', 'g', 'n', 'i', '\'', 'W', 'j', 'n', 'o', 'm', 'S', 'R', 'P', 152, 145, 137, 142, 157, 150, 149, 150, 149, 154, 139, 139, 147, 144, 154, 150, 148, 151, 128, 'Z', 174, 169, 167, 170, 170, 154, 163, 182, 173, 165, 166, 165, 171, 179, 157, 154, 169, 165, 172, 160, 137, 'm', 145, 130, 132, 129, '^', 138, 140, 143, 'c', 129, 'f', 145, 139, 130, 138, 130, 128, '~', 130, 'e', '}', 'Z', 141, '~', 140, 139, '~', 135, '~', 141, 140, '3', 'f', 'l', 'Z', '[', 'l', 'f', 'g', 'i', 'h', 'd', 'Y', 'Y', 'l', 'u', 's', 'p', 'n', 'V', 'R', 'k', 'n', 'o', 'o', 'n', 'v', 'g', '_', 'g', 'n', 'e', 'f', 't', 'j', 'X', 'X', 'o', 21, 'D', 'E', 'I', '`', '[', '_', '`', ']', 'D', ','};

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f975 = 171;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class b extends WeakHashMap<View, WeakReference<Object>> implements hc<WeakHashMap<View, WeakReference<Object>>> {

        /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
        private static short[] f985 = null;

        /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
        private static int f986 = 0;

        /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
        private static byte[] f987 = {-68, -71, -29, 30, 122, -23, -44, -61, -77, -50, -41, -101, -26, -68, -22, -83, -3, -100, -55, -21, -77, -51, -51};

        /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
        private static int f988 = 1;

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private static int f989 = -854496880;

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private static int f990 = 91;

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private static int f991 = 1993697581;

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private ch f992;

        public b(WeakHashMap<View, WeakReference<Object>> weakHashMap, ch chVar) {
            super(weakHashMap);
            this.f992 = chVar;
        }

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private WeakHashMap<View, WeakReference<Object>> m1135() {
            int i2 = f986;
            int i8 = i2 + 107;
            f988 = i8 % 128;
            if (i8 % 2 == 0) {
                throw null;
            }
            int i9 = i2 + 31;
            f988 = i9 % 128;
            if (i9 % 2 != 0) {
                return this;
            }
            throw null;
        }

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private static String m1136(int i2, short s7, int i8, byte b8, int i9) {
            String string;
            synchronized (n.f2979) {
                try {
                    StringBuilder sb = new StringBuilder();
                    int i10 = f990;
                    int i11 = i2 + i10;
                    int i12 = i11 == -1 ? 1 : 0;
                    if (i12 != 0) {
                        byte[] bArr = f987;
                        i11 = bArr != null ? (byte) (bArr[f991 + i8] + i10) : (short) (f985[f991 + i8] + i10);
                    }
                    if (i11 > 0) {
                        n.f2984 = ((i8 + i11) - 2) + f991 + i12;
                        n.f2982 = b8;
                        char c7 = (char) (i9 + f989);
                        n.f2981 = c7;
                        sb.append(c7);
                        n.f2980 = n.f2981;
                        n.f2983 = 1;
                        while (n.f2983 < i11) {
                            byte[] bArr2 = f987;
                            if (bArr2 != null) {
                                int i13 = n.f2984;
                                n.f2984 = i13 - 1;
                                n.f2981 = (char) (n.f2980 + (((byte) (bArr2[i13] + s7)) ^ n.f2982));
                            } else {
                                short[] sArr = f985;
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

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private WeakReference<Object> m1137(View view, WeakReference<Object> weakReference) {
            f986 = (f988 + 83) % 128;
            bp.this.m885(this, this.f992, m1136(Color.green(0) - 92, (short) ((-78) - TextUtils.lastIndexOf("", '0', 0)), (-1993697581) - TextUtils.indexOf("", "", 0, 0), (byte) ((Process.myPid() >> 22) - 109), TextUtils.indexOf((CharSequence) "", '0') + 854496959).intern(), view, weakReference);
            WeakReference<Object> weakReference2 = (WeakReference) super.put(view, weakReference);
            int i2 = f988 + 51;
            f986 = i2 % 128;
            if (i2 % 2 == 0) {
                return weakReference2;
            }
            throw null;
        }

        @Override // java.util.WeakHashMap, java.util.AbstractMap, java.util.Map
        public /* synthetic */ Object put(Object obj, Object obj2) {
            int i2 = f988 + 45;
            f986 = i2 % 128;
            View view = (View) obj;
            WeakReference<Object> weakReference = (WeakReference) obj2;
            if (i2 % 2 != 0) {
                m1137(view, weakReference);
                throw null;
            }
            WeakReference<Object> weakReferenceM1137 = m1137(view, weakReference);
            f988 = (f986 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE) % 128;
            return weakReferenceM1137;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.hc
        /* JADX INFO: renamed from: ｋ */
        public final /* synthetic */ WeakHashMap<View, WeakReference<Object>> mo831() {
            f988 = (f986 + 97) % 128;
            WeakHashMap<View, WeakReference<Object>> weakHashMapM1135 = m1135();
            int i2 = f988 + 97;
            f986 = i2 % 128;
            if (i2 % 2 == 0) {
                return weakHashMapM1135;
            }
            throw null;
        }
    }

    public bp(String str) {
        super(str);
    }

    /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
    public static /* synthetic */ DynamicLoader m1115() {
        f973 = (f972 + 9) % 128;
        DynamicLoader dynamicLoaderM1118 = m1118();
        f973 = (f972 + 59) % 128;
        return dynamicLoaderM1118;
    }

    /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
    private static String m1116() {
        int i2 = f972 + 51;
        f973 = i2 % 128;
        int i8 = i2 % 2;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        String strIntern = (i8 != 0 ? m1123((jElapsedRealtime > 1L ? 1 : (jElapsedRealtime == 1L ? 0 : -1)) + 14141, KeyEvent.normalizeMetaState(1) * 50, "\u000b\u000b\u0007￮\u0001\u0013�\u000e\u0000\u0001\u0000\ufff2\u0005\u0000\u0001\u000b￡\n\u0000\uffdf�\u000e\u0000￩�\u000e\u0007\u0011\f\u0002�\uffff\u0001\ufffe", 41 / (ViewConfiguration.getScrollBarFadeDuration() >> 106), false) : m1123(272 - (jElapsedRealtime > 0L ? 1 : (jElapsedRealtime == 0L ? 0 : -1)), KeyEvent.normalizeMetaState(0) + 34, "\u000b\u000b\u0007￮\u0001\u0013�\u000e\u0000\u0001\u0000\ufff2\u0005\u0000\u0001\u000b￡\n\u0000\uffdf�\u000e\u0000￩�\u000e\u0007\u0011\f\u0002�\uffff\u0001\ufffe", 29 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), false)).intern();
        f972 = (f973 + 23) % 128;
        return strIntern;
    }

    /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
    private static String m1117() {
        int i2 = f972 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE;
        f973 = i2 % 128;
        return (i2 % 2 != 0 ? m1123(6951 << (ViewConfiguration.getWindowTouchSlop() >>> Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE), TextUtils.indexOf((CharSequence) "", '7', 0) * 80, "\f\ufffa\ufffe\u000b\ufffa\u0005\u000e￩", 4 >> (ViewConfiguration.getScrollDefaultDelay() >>> 53), false) : m1123((ViewConfiguration.getWindowTouchSlop() >> 8) + 278, 7 - TextUtils.indexOf((CharSequence) "", '0', 0), "\f\ufffa\ufffe\u000b\ufffa\u0005\u000e￩", (ViewConfiguration.getScrollDefaultDelay() >> 16) + 4, true)).intern();
    }

    /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
    private static DynamicLoader m1118() {
        f973 = (f972 + 23) % 128;
        DynamicLoader dynamicLoader = DynamicLoaderFactory.getDynamicLoader();
        int i2 = f972 + 89;
        f973 = i2 % 128;
        if (i2 % 2 == 0) {
            return dynamicLoader;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    public static /* synthetic */ String m1119() {
        int i2 = f972 + 77;
        f973 = i2 % 128;
        if (i2 % 2 == 0) {
            return m1117();
        }
        m1117();
        throw null;
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    public static /* synthetic */ String m1120() {
        int i2 = f972 + 85;
        f973 = i2 % 128;
        if (i2 % 2 == 0) {
            return m1116();
        }
        m1116();
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static /* synthetic */ String m1121(AdView adView) {
        f973 = (f972 + 27) % 128;
        String strM1125 = m1125(adView);
        int i2 = f973 + 43;
        f972 = i2 % 128;
        if (i2 % 2 != 0) {
            return strM1125;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ AdPlacementType m1122(AdAdapter adAdapter) {
        int i2 = f973 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE;
        f972 = i2 % 128;
        int i8 = i2 % 2;
        AdPlacementType adPlacementTypeM1130 = m1130(adAdapter);
        if (i8 == 0) {
            int i9 = 30 / 0;
        }
        return adPlacementTypeM1130;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ WeakHashMap m1127(bp bpVar, WeakHashMap weakHashMap, ch chVar) {
        f972 = (f973 + 105) % 128;
        WeakHashMap<View, WeakReference<Object>> weakHashMapM1132 = bpVar.m1132((WeakHashMap<View, WeakReference<Object>>) weakHashMap, chVar);
        f972 = (f973 + 63) % 128;
        return weakHashMapM1132;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ String m1131(Ad ad) {
        f973 = (f972 + 45) % 128;
        String strM1134 = m1134(ad);
        int i2 = f972 + 109;
        f973 = i2 % 128;
        if (i2 % 2 == 0) {
            return strM1134;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m1134(Ad ad) {
        f973 = (f972 + 61) % 128;
        String placementId = ad.getPlacementId();
        int i2 = f973 + 85;
        f972 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 56 / 0;
        }
        return placementId;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ void m1128(AdView adView, AdListener adListener) {
        f972 = (f973 + 33) % 128;
        m1124(adView, adListener);
        f973 = (f972 + 103) % 128;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ void m1133(InterstitialAd interstitialAd, InterstitialAdListener interstitialAdListener) {
        f973 = (f972 + 29) % 128;
        m1129(interstitialAd, interstitialAdListener);
        f973 = (f972 + 63) % 128;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﻐ */
    public final String mo825() {
        f972 = (f973 + 5) % 128;
        try {
            try {
                try {
                    String str = (String) hu.m2386().m2389().m2330(AdSdkVersion.class, String.class).get(null);
                    f973 = (f972 + 59) % 128;
                    return str;
                } catch (Throwable unused) {
                    return hu.m2386().m2388().m2439(BuildConfig.class, m1126("\u0001\u0000\u0001\u0000\u0000\u0001\u0001\u0000\u0000\u0000\u0000", true, new int[]{159, 11, 0, 9}).intern());
                }
            } catch (Throwable unused2) {
                return (String) hu.m2386().m2389().m2330(AdSdkVersion.class, String.class).get(null);
            }
        } catch (Throwable unused3) {
            return null;
        }
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﻛ */
    public final Class mo826(String str) {
        switch (str.hashCode()) {
            case -2107186802:
                if (str.equals(m1123(View.resolveSize(0, 0) + 272, 16 - KeyEvent.keyCodeFromString(""), "\u000f\u0004\u0011\u0000ￜ\uffff\uffe7\u0004\u000e\u000f\u0000\t\u0000\r￩￼", 15 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), false).intern())) {
                    return NativeAdListener.class;
                }
                return null;
            case -1585374524:
                if (str.equals(m1123(ExpandableListView.getPackedPositionType(0L) + 271, 23 - View.resolveSize(0, 0), "\u0001\u0000\u000e�\u0013\u0001￮\u000e\u0001\n\u0001\u0010\u000f\u0005￨\u0000\uffdd\u000b\u0001\u0000\u0005\ufff2\u0000", ImageFormat.getBitsPerPixel(0) + 8, true).intern())) {
                    return RewardedVideoAdListener.class;
                }
                return null;
            case -1513928064:
                if (!str.equals(m1123(View.MeasureSpec.getMode(0) + 270, (ViewConfiguration.getJumpTapTimeout() >> 16) + 40, "ￋ\u0003\ufffe\u0000\u0002\uffff\f\f\bￋ\ufffe\u0001\u0010ￋ\uffde\u0012\u0001\u0006\u0002\u000b\u0000\u0002￫\u0002\u0011\u0014\f\u000f\b\uffde\u0000\u0011\u0006\u0013\u0006\u0011\u0016\u0000\f\n", 37 - (ViewConfiguration.getKeyRepeatDelay() >> 16), false).intern())) {
                    return null;
                }
                int i2 = f973 + 7;
                f972 = i2 % 128;
                if (i2 % 2 == 0) {
                    return null;
                }
                return AudienceNetworkActivity.class;
            case -1256969519:
                if (str.equals(m1126("\u0001\u0000\u0000\u0001\u0001\u0000\u0000\u0001\u0001\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0000", true, new int[]{48, 20, 42, 0}).intern())) {
                    return CircularProgressView.class;
                }
                return null;
            case -501313640:
                if (str.equals(m1123(272 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), TextUtils.indexOf("", "") + 20, "￡￼\ufffe\u000f\n\r\u0014\uffdf\u0014\t￼\b\u0004\ufffe\uffe7\n￼\uffff\u0000\r", 7 - TextUtils.getOffsetAfter("", 0), false).intern())) {
                    return DynamicLoaderFactory.class;
                }
                return null;
            case -498709917:
                if (!str.equals(m1123(KeyEvent.getDeadChar(0, 0) + 274, 22 - (ViewConfiguration.getWindowTouchSlop() >> 8), "\r\ufffe\u000b\f\r\u0002\r\u0002\ufffa\u0005ￚ�￥\u0002\f\r\ufffe\u0007\ufffe\u000b￢\u0007", (ViewConfiguration.getScrollDefaultDelay() >> 16) + 20, false).intern())) {
                    return null;
                }
                f973 = (f972 + 107) % 128;
                return InterstitialAdListener.class;
            case -105717264:
                if (str.equals(m1123(269 - (ViewConfiguration.getDoubleTapTimeout() >> 16), 15 - TextUtils.getOffsetBefore("", 0), "\r\u0003\u0002\u0007\ufff4\u0002\u0003\u0002\u0010\uffff\u0015\u0003\ufff0\u0002\uffdf", 13 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), true).intern())) {
                    return RewardedVideoAd.class;
                }
                return null;
            case 2115:
                if (str.equals(m1123(253 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), 3 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), "\uffef\u0012", (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), true).intern())) {
                    return Ad.class;
                }
                return null;
            case 289409084:
                if (!str.equals(m1123(KeyEvent.getDeadChar(0, 0) + 271, 15 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), "\u0015\f\u0001\uffdd\u0000￬\b�\uffff\u0001\t\u0001\n\u0010\ufff0", Color.argb(0, 0, 0, 0) + 3, false).intern())) {
                    return null;
                }
                f972 = (f973 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE) % 128;
                return AdPlacementType.class;
            case 320151695:
                if (str.equals(m1123((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 272, Color.blue(0) + 14, "\u0003\u000e\u0003\ufffb\u0006ￛ\ufffe￣\b\u000e\uffff\f\r\u000e", 7 - View.getDefaultSize(0, 0), false).intern())) {
                    return InterstitialAd.class;
                }
                return null;
            case 435867927:
                if (str.equals(m1126("\u0001\u0001\u0000\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0000\u0001\u0001\u0000\u0001\u0000\u0000\u0001\u0000\u0000\u0001", true, new int[]{68, 21, 67, 0}).intern())) {
                    return al.m512();
                }
                return null;
            case 488344453:
                if (str.equals(m1126("\u0000\u0001\u0001\u0001\u0000\u0001\u0001", false, new int[]{0, 7, 179, 0}).intern())) {
                    return AdError.class;
                }
                return null;
            case 535330969:
                if (str.equals(m1123(274 - Color.alpha(0), 23 - (ViewConfiguration.getDoubleTapTimeout() >> 16), "\b\u0010\r\ufffe\uffe7\ufffe￼\u0007\ufffe\u0002�\u000eￚ\u0012\r\u0002\u000f\u0002\r￼ￚ\u0004\u000b", View.MeasureSpec.getSize(0) + 13, true).intern())) {
                    return AudienceNetworkActivity.class;
                }
                return null;
            case 553704929:
                if (str.equals(m1126("\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0000\u0001\u0001\u0000\u0001\u0000\u0000\u0001\u0001\u0000\u0001\u0001", false, new int[]{7, 19, 94, 0}).intern())) {
                    return DisplayAdController.class;
                }
                return null;
            case 1165508119:
                if (str.equals(m1123(271 - (ViewConfiguration.getJumpTapTimeout() >> 16), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 11, "\u000e\uffdd\u0000￨\u0005\u000f\u0010\u0001\n\u0001", ExpandableListView.getPackedPositionType(0L) + 1, false).intern())) {
                    return AdListener.class;
                }
                return null;
            case 1237162638:
                if (!str.equals(m1123(267 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), 22 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), "\u0002￩\f\u0002\u0006\ufff8\u0005￢\u0006\u0017\n\u0015\u0002\uffef￣\ufff5\u0011\u0002￮\t\u0014", 16 - TextUtils.getCapsMode("", 0, 0), true).intern())) {
                    return null;
                }
                int i8 = f972 + 47;
                f973 = i8 % 128;
                if (i8 % 2 != 0) {
                    return null;
                }
                return b.class;
            case 1476063628:
                if (!str.equals(m1123(((byte) KeyEvent.getModifierMetaStateMask()) + 268, 9 - KeyEvent.keyCodeFromString(""), "\u0004￡\u0012\u0005\u0014\u0010\u0001\u0004￡", 2 - Gravity.getAbsoluteGravity(0, 0), true).intern())) {
                    return null;
                }
                f973 = (f972 + 71) % 128;
                return AdAdapter.class;
            case 1838933446:
                if (str.equals(m1126("\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001", false, new int[]{26, 14, 0, 3}).intern())) {
                    return NativeBannerAd.class;
                }
                return null;
            case 1908493505:
                if (str.equals(m1123(265 - TextUtils.indexOf("", ""), KeyEvent.normalizeMetaState(0) + 23, "\u0011\u000f\uffd0\b\u0003\u0005\u0007\u0004\u0011\u0011\r\uffd0\u0003\u0006\u0015\uffd0￣\u0006\ufff8\u000b\u0007\u0019\u0005", 22 - (ViewConfiguration.getFadingEdgeLength() >> 16), false).intern())) {
                    return AdView.class;
                }
                return null;
            case 1955913096:
                if (str.equals(m1123(267 - TextUtils.indexOf("", "", 0), (ViewConfiguration.getScrollBarSize() >> 8) + 6, "\u0005\u0017￡\u0004\ufff6\t", (ViewConfiguration.getFadingEdgeLength() >> 16) + 2, false).intern())) {
                    return AdView.class;
                }
                return null;
            case 2035065003:
                if (str.equals(m1123(267 - (ViewConfiguration.getScrollDefaultDelay() >> 16), 12 - View.MeasureSpec.getSize(0), "￡\u0004￢\u0001\u0013\u0005￮\u0001\u0014\t\u0016\u0005", Color.blue(0) + 6, false).intern())) {
                    return NativeAdBase.class;
                }
                return null;
            case 2035668095:
                if (str.equals(m1123(270 - Gravity.getAbsoluteGravity(0, 0), 12 - TextUtils.getCapsMode("", 0, 0), "￫\u0014\u0002\u0006\ufff3\u0001\uffde\u0002\u0013\u0006\u0011\ufffe", 1 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), true).intern())) {
                    return NativeAdView.class;
                }
                return null;
            case 2110329530:
                if (str.equals(m1126("\u0000\u0001\u0001\u0001\u0001\u0001\u0000\u0001", false, new int[]{40, 8, 0, 0}).intern())) {
                    return NativeAd.class;
                }
                return null;
            default:
                return null;
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m1125(AdView adView) {
        f973 = (f972 + 63) % 128;
        String placementId = adView.getPlacementId();
        f973 = (f972 + 47) % 128;
        return placementId;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﾇ */
    public final Map<String, bg.a> mo827() {
        HashMap map = new HashMap();
        map.put(m1123((-16776946) - Color.rgb(0, 0, 0), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 24, "\u0002\u000b\u0011￦\u0001￣\u000f\f\n\uffde\u0001\ufff3\u0006\u0002\u0014\u0004\u0002\u0011￭\t\ufffe\u0000\u0002\n", ExpandableListView.getPackedPositionGroup(0L) + 15, false).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bp.4
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bp.m1121((AdView) list.get(0));
            }
        });
        map.put(m1126((String) null, true, new int[]{89, 20, 29, 5}).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bp.5
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bp.m1131((Ad) list.get(0));
            }
        });
        map.put(m1126((String) null, true, new int[]{109, 13, 25, 7}).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bp.3
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                bp.m1128((AdView) list.get(0), (AdListener) list.get(1));
                return null;
            }
        });
        map.put(m1126("\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000", false, new int[]{Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE, 37, 0, 0}).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bp.1
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bp.m1119();
            }
        });
        map.put(m1123(273 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), 42 - (ViewConfiguration.getTapTimeout() >> 16), "\u0001\u0013\uffff￥\n\u000f\u0005\f\ufffb\uffe7\ufffe\f\ufffb\uffdd\ufffe\b\uffdf\u0013\u000e\u0003\u0010\u0003\u000e�ￛ\u0005\f\t\u0011\u000e\uffff￨\uffff�\b\uffff\u0003\ufffe\u000fￛ\u000e\uffff", View.MeasureSpec.getMode(0) + 1, true).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bp.2
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bp.m1120();
            }
        });
        map.put(m1123(275 - (Process.myTid() >> 22), Drawable.resolveOpacity(0, 0) + 24, "\f�\u0006�\n\u000b�\f￡\u0006\f�\n\u000b\f\u0001\f\ufff9\u0004\uffd9￼￤\u0001\u000b", TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 6, false).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bp.6
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                bp.m1133((InterstitialAd) list.get(0), (InterstitialAdListener) list.get(1));
                return null;
            }
        });
        map.put(m1123((ViewConfiguration.getScrollBarSize() >> 8) + 272, (Process.myPid() >> 22) + 16, "\u0014\t￼\b\u0004\ufffe\uffe7\n￼\uffff\u0000\r\u0002\u0000\u000f\uffdf", 12 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), false).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bp.8
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bp.m1115();
            }
        });
        map.put(m1123(((byte) KeyEvent.getModifierMetaStateMask()) + 275, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 15, "￩\u0005\ufffa￼\ufffe\u0006\ufffe\u0007\r￭\u0012\t\ufffe\u0000\ufffe\r", MotionEvent.axisFromString("") + 14, false).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bp.7
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bp.m1122((AdAdapter) list.get(0));
            }
        });
        map.put(m1123(TextUtils.indexOf((CharSequence) "", '0', 0) + 269, 27 - View.resolveSizeAndState(0, 0, 0), "\u0003￠\u0004\u0015\b\u0013\u0000￭￡\ufff3\u0004\u0013\u0000\u0004\u0011\u0002\u000f\u0000￬\u0007\u0012\u0000\uffe7\n\u0000\u0004\ufff6", 16 - TextUtils.indexOf("", ""), true).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bp.9
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bp.m1127(bp.this, (WeakHashMap) list.get(0), chVar);
            }
        });
        f972 = (f973 + 29) % 128;
        return map;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static void m1129(InterstitialAd interstitialAd, InterstitialAdListener interstitialAdListener) {
        f972 = (f973 + 57) % 128;
        interstitialAd.setAdListener(interstitialAdListener);
        f973 = (f972 + 49) % 128;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m1126(String str, boolean z2, int[] iArr) throws UnsupportedEncodingException {
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
                System.arraycopy(f974, i2, cArr, 0, i8);
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

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static AdPlacementType m1130(AdAdapter adAdapter) {
        int i2 = f972 + 91;
        f973 = i2 % 128;
        int i8 = i2 % 2;
        AdPlacementType placementType = adAdapter.getPlacementType();
        if (i8 != 0) {
            int i9 = 39 / 0;
        }
        return placementType;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private WeakHashMap<View, WeakReference<Object>> m1132(WeakHashMap<View, WeakReference<Object>> weakHashMap, ch chVar) {
        b bVar = new b(weakHashMap, chVar);
        f972 = (f973 + 39) % 128;
        return bVar;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static void m1124(AdView adView, AdListener adListener) {
        int i2 = f973 + 79;
        f972 = i2 % 128;
        int i8 = i2 % 2;
        adView.setAdListener(adListener);
        if (i8 == 0) {
            throw null;
        }
        f972 = (f973 + 39) % 128;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m1123(int i2, int i8, String str, int i9, boolean z2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (e.f1927) {
            try {
                char[] cArr2 = new char[i8];
                e.f1926 = 0;
                while (true) {
                    int i10 = e.f1926;
                    if (i10 >= i8) {
                        break;
                    }
                    e.f1929 = cArr[i10];
                    cArr2[e.f1926] = (char) (e.f1929 + i2);
                    int i11 = e.f1926;
                    cArr2[i11] = (char) (cArr2[i11] - f975);
                    e.f1926 = i11 + 1;
                }
                if (i9 > 0) {
                    e.f1928 = i9;
                    char[] cArr3 = new char[i8];
                    System.arraycopy(cArr2, 0, cArr3, 0, i8);
                    int i12 = e.f1928;
                    System.arraycopy(cArr3, 0, cArr2, i8 - i12, i12);
                    int i13 = e.f1928;
                    System.arraycopy(cArr3, i13, cArr2, 0, i8 - i13);
                }
                if (z2) {
                    char[] cArr4 = new char[i8];
                    e.f1926 = 0;
                    while (true) {
                        int i14 = e.f1926;
                        if (i14 >= i8) {
                            break;
                        }
                        cArr4[i14] = cArr2[(i8 - i14) - 1];
                        e.f1926 = i14 + 1;
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
