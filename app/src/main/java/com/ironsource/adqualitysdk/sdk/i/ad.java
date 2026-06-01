package com.ironsource.adqualitysdk.sdk.i;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.webkit.WebView;
import android.widget.ExpandableListView;
import com.ironsource.adqualitysdk.sdk.i.az;
import com.vungle.ads.internal.protos.Sdk;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ad extends y<View, Activity> {

    /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
    private static int f113 = 0;

    /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
    private static int f114 = 1;

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static int f115 = 118;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private Class f118;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private is f121;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private View.OnLayoutChangeListener f122;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private jl f123;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private final Map<WebView, ab> f120 = new WeakHashMap();

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private final Map<View, ad> f124 = new WeakHashMap();

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private final Map<View, View.OnLayoutChangeListener> f116 = new WeakHashMap();

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private c f117 = new c();

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private final List<View> f119 = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class c {

        /* JADX INFO: renamed from: ヮ, reason: contains not printable characters */
        private static int f137 = 1;

        /* JADX INFO: renamed from: 丫, reason: contains not printable characters */
        private static int f138 = 0;

        /* JADX INFO: renamed from: 爫, reason: contains not printable characters */
        private static boolean f139 = true;

        /* JADX INFO: renamed from: ﬤ, reason: contains not printable characters */
        private static char[] f140 = {296, 299, 285, 304, 300, 318, 279, 298, 306, 302, 316, 313, 307, 301, 319, 310, 282, 309, 264, 268, 317, 315, 314, 272};

        /* JADX INFO: renamed from: טּ, reason: contains not printable characters */
        private static int f141 = 22;

        /* JADX INFO: renamed from: סּ, reason: contains not printable characters */
        private static boolean f142 = true;

        /* JADX INFO: renamed from: ףּ, reason: contains not printable characters */
        private static int f143 = 199;

        /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
        private boolean f144;

        /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
        private boolean f149;

        /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
        private boolean f150;

        /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
        private boolean f151;

        /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
        private boolean f152;

        /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
        private boolean f153;

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private String f154;

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private boolean f155;

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private String f156;

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private String f157;

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private String f158;

        /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
        private List<Integer> f148 = new ArrayList();

        /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
        private List<String> f145 = new ArrayList();

        /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
        private List<String> f146 = new ArrayList();

        /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
        private List<String> f147 = new ArrayList();

        public c() {
        }

        /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
        public static /* synthetic */ boolean m335(c cVar) {
            int i2 = f137 + 43;
            int i8 = i2 % 128;
            f138 = i8;
            int i9 = i2 % 2;
            boolean z2 = cVar.f150;
            if (i9 != 0) {
                throw null;
            }
            int i10 = i8 + 27;
            f137 = i10 % 128;
            if (i10 % 2 != 0) {
                return z2;
            }
            throw null;
        }

        /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
        public static /* synthetic */ List m336(c cVar) {
            int i2 = f137;
            int i8 = i2 + 73;
            f138 = i8 % 128;
            int i9 = i8 % 2;
            List<String> list = cVar.f147;
            if (i9 != 0) {
                throw null;
            }
            int i10 = i2 + 29;
            f138 = i10 % 128;
            if (i10 % 2 == 0) {
                return list;
            }
            throw null;
        }

        /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
        public static /* synthetic */ boolean m337(c cVar) {
            int i2 = f137;
            int i8 = i2 + 13;
            f138 = i8 % 128;
            int i9 = i8 % 2;
            boolean z2 = cVar.f155;
            if (i9 != 0) {
                throw null;
            }
            f138 = (i2 + 31) % 128;
            return z2;
        }

        /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
        public static /* synthetic */ boolean m338(c cVar) {
            int i2 = (f137 + 83) % 128;
            f138 = i2;
            boolean z2 = cVar.f151;
            f137 = (i2 + 37) % 128;
            return z2;
        }

        /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
        public static /* synthetic */ String m339(c cVar) {
            int i2 = f138 + 21;
            f137 = i2 % 128;
            int i8 = i2 % 2;
            String str = cVar.f157;
            if (i8 == 0) {
                int i9 = 56 / 0;
            }
            return str;
        }

        /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
        public static /* synthetic */ String m341(c cVar) {
            int i2 = f138 + 39;
            f137 = i2 % 128;
            int i8 = i2 % 2;
            String str = cVar.f158;
            if (i8 != 0) {
                return str;
            }
            throw null;
        }

        /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
        public static /* synthetic */ boolean m342(c cVar) {
            int i2 = f137;
            int i8 = i2 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE;
            f138 = i8 % 128;
            int i9 = i8 % 2;
            boolean z2 = cVar.f153;
            if (i9 != 0) {
                throw null;
            }
            int i10 = i2 + 49;
            f138 = i10 % 128;
            if (i10 % 2 == 0) {
                return z2;
            }
            throw null;
        }

        /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
        public static /* synthetic */ boolean m343(c cVar) {
            int i2 = f138 + 55;
            int i8 = i2 % 128;
            f137 = i8;
            int i9 = i2 % 2;
            boolean z2 = cVar.f144;
            if (i9 == 0) {
                throw null;
            }
            f138 = (i8 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE) % 128;
            return z2;
        }

        /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
        public static /* synthetic */ boolean m345(c cVar) {
            int i2 = f138 + 67;
            f137 = i2 % 128;
            int i8 = i2 % 2;
            boolean z2 = cVar.f152;
            if (i8 != 0) {
                return z2;
            }
            throw null;
        }

        /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
        public static /* synthetic */ String m346(c cVar) {
            int i2 = f137;
            f138 = (i2 + 105) % 128;
            String str = cVar.f156;
            f138 = (i2 + 3) % 128;
            return str;
        }

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        public static /* synthetic */ List m350(c cVar) {
            int i2 = (f137 + 67) % 128;
            f138 = i2;
            List<Integer> list = cVar.f148;
            int i8 = i2 + 97;
            f137 = i8 % 128;
            if (i8 % 2 == 0) {
                int i9 = 76 / 0;
            }
            return list;
        }

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        public static /* synthetic */ List m355(c cVar) {
            int i2 = f137 + 79;
            int i8 = i2 % 128;
            f138 = i8;
            int i9 = i2 % 2;
            List<String> list = cVar.f145;
            if (i9 != 0) {
                throw null;
            }
            int i10 = i8 + 73;
            f137 = i10 % 128;
            if (i10 % 2 != 0) {
                return list;
            }
            throw null;
        }

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        public static /* synthetic */ String m358(c cVar) {
            int i2 = (f137 + 97) % 128;
            f138 = i2;
            String str = cVar.f154;
            int i8 = i2 + 49;
            f137 = i8 % 128;
            if (i8 % 2 != 0) {
                return str;
            }
            throw null;
        }

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        public static /* synthetic */ boolean m362(c cVar) {
            int i2 = f138 + 15;
            int i8 = i2 % 128;
            f137 = i8;
            int i9 = i2 % 2;
            boolean z2 = cVar.f149;
            if (i9 == 0) {
                int i10 = 99 / 0;
            }
            f138 = (i8 + 93) % 128;
            return z2;
        }

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        public static /* synthetic */ List m366(c cVar) {
            int i2 = f138 + 99;
            int i8 = i2 % 128;
            f137 = i8;
            int i9 = i2 % 2;
            List<String> list = cVar.f146;
            if (i9 == 0) {
                int i10 = 9 / 0;
            }
            int i11 = i8 + 61;
            f138 = i11 % 128;
            if (i11 % 2 != 0) {
                int i12 = 4 / 0;
            }
            return list;
        }

        /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
        private c m340(boolean z2) {
            int i2 = (f137 + 81) % 128;
            f138 = i2;
            this.f151 = z2;
            int i8 = i2 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE;
            f137 = i8 % 128;
            if (i8 % 2 == 0) {
                int i9 = 37 / 0;
            }
            return this;
        }

        /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
        private c m344(boolean z2) {
            int i2 = f137 + 21;
            f138 = i2 % 128;
            if (i2 % 2 == 0) {
                this.f144 = z2;
                return this;
            }
            this.f144 = z2;
            throw null;
        }

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private c m348(boolean z2) {
            int i2 = f137 + 89;
            f138 = i2 % 128;
            if (i2 % 2 == 0) {
                this.f149 = z2;
                return this;
            }
            this.f149 = z2;
            int i8 = 96 / 0;
            return this;
        }

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private c m351(String str) {
            int i2 = f137 + 15;
            f138 = i2 % 128;
            if (i2 % 2 == 0) {
                this.f158 = str;
                return this;
            }
            this.f158 = str;
            int i8 = 56 / 0;
            return this;
        }

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private c m356(String str) {
            int i2 = f138 + 53;
            f137 = i2 % 128;
            if (i2 % 2 != 0) {
                this.f157 = str;
                return this;
            }
            this.f157 = str;
            throw null;
        }

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private c m359(String str) {
            int i2 = f138;
            this.f156 = str;
            int i8 = i2 + 111;
            f137 = i8 % 128;
            if (i8 % 2 != 0) {
                return this;
            }
            throw null;
        }

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private c m363(String str) {
            int i2 = f137 + 51;
            f138 = i2 % 128;
            if (i2 % 2 == 0) {
                this.f154 = str;
                return this;
            }
            this.f154 = str;
            throw null;
        }

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private c m357(boolean z2) {
            int i2 = f137;
            this.f150 = z2;
            int i8 = i2 + 79;
            f138 = i8 % 128;
            if (i8 % 2 == 0) {
                return this;
            }
            throw null;
        }

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private c m361(boolean z2) {
            int i2 = (f137 + 65) % 128;
            f138 = i2;
            this.f152 = z2;
            int i8 = i2 + 39;
            f137 = i8 % 128;
            if (i8 % 2 == 0) {
                int i9 = 50 / 0;
            }
            return this;
        }

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private c m365(boolean z2) {
            int i2 = f138;
            this.f155 = z2;
            f137 = (i2 + 113) % 128;
            return this;
        }

        public c(JSONObject jSONObject) {
            m363(jSONObject.optString(m349("\u0001\ufffe\u0002\n\ufffe￫\u0010\u0010\ufffe\t￠\u0014\u0002\u0006\ufff3", true, 15 - (ViewConfiguration.getDoubleTapTimeout() >> 16), 121 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (ViewConfiguration.getEdgeSlop() >> 16) + 2).intern()));
            m359(jSONObject.optString(m354(null, null, 127 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), "\u0085\u008a\u0081\u0089\u0088\u0081\u0087\u0086\u0085\u0084\u0083\u0082\u0081").intern()));
            m351(jSONObject.optString(m349("\u0004\b￣\t￮\r\u0004\u000e�\uffff", true, (ViewConfiguration.getJumpTapTimeout() >> 16) + 10, 125 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (ViewConfiguration.getFadingEdgeLength() >> 16) + 7).intern()));
            m365(jSONObject.optBoolean(m349("\uffff\ufff1\uffff￼\ufff0\u0003\uffff\u0011\uffdd\u0006\u0003\uffff\b\u000e\u000f\r", false, TextUtils.indexOf("", "") + 16, (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE, View.MeasureSpec.getSize(0) + 14).intern()));
            jSONObject.optBoolean(m349("\uffde\u0007\u0004\u0000\t\u000f\u0010\u000e\u0000\ufff2\u0000�\uffde\u0003\r\n\b\u0000", false, ExpandableListView.getPackedPositionGroup(0L) + 18, View.MeasureSpec.getSize(0) + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE, '6' - AndroidCharacter.getMirror('0')).intern());
            m356(jSONObject.optString(m354(null, null, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 126, "\u008f\u0084\u008e\u0085\u008c\u0087\u008d\u008c\u008b").intern()));
            m353(jSONObject.optBoolean(m349("\u0000\uffdd\u0001\u0012\u0005\u0010�￪\u000f\u0005", true, (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 10, TextUtils.getOffsetAfter("", 0) + Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE, ExpandableListView.getPackedPositionGroup(0L) + 10).intern()));
            m361(jSONObject.optBoolean(m354(null, null, (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 127, "\u0097\u0096\u0092\u0085\u0095\u0094\u008d\u008d\u0093\u0082\u0092\u0085\u0091\u0085\u0088\u008c\u0090\u008e").intern()));
            m348(jSONObject.optBoolean(m354(null, null, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 127, "\u0085\u0095\u0084\u0097\u008c\u008b\u0088\u0085\u008c").intern()));
            m357(jSONObject.optBoolean(m349("\u000b\n\u0006\uffff\b\ufff9\t\ufff7\f\ufff7￠\ufffb\t", true, TextUtils.getOffsetBefore("", 0) + 13, 128 - View.MeasureSpec.getSize(0), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 1).intern(), true));
            m340(jSONObject.optBoolean(m349("\u000b\ufffa￣\f\u000e\f\ufffe\uffde\u0011\r", false, 10 - Color.argb(0, 0, 0, 0), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE, Color.blue(0) + 4).intern()));
            m344(jSONObject.optBoolean(m349("\u0003\b￮\u0002\f\uffff\ufffb\ufffe\n\f\t�\uffff\r\r\ufff0\u0003\uffff\u0011\r￩\b\uffe7\ufffb", false, 23 - MotionEvent.axisFromString(""), 125 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), AndroidCharacter.getMirror('0') - '(').intern(), true));
            m352(kc.m2911(jSONObject.optJSONArray(m354(null, null, KeyEvent.keyCodeFromString("") + 127, "\u0097\u0082\u0098\u0086\u0085\u0084\u0095").intern())));
            m360(kc.m2911(jSONObject.optJSONArray(m349("\u000b�\u0001\f\u0001\u000e\u0001\f\ufffb\ufff9�\n\u0007\u0006\uffff￡\u0007￬", true, 17 - Process.getGidForName(""), 126 - TextUtils.getOffsetBefore("", 0), (KeyEvent.getMaxKeyCode() >> 16) + 10).intern())));
            m347(kc.m2911(jSONObject.optJSONArray(m349("\u0005\ufffe￠\u0006￫\n\u000e￼\u0000\r￼\t\u0006", true, View.MeasureSpec.getMode(0) + 13, 127 - (ViewConfiguration.getTapTimeout() >> 16), 9 - Process.getGidForName("")).intern())));
            m364(kc.m2911(jSONObject.optJSONArray(m349("￥\t￮\r\uffff\r\r\ufffb\u0006�\n\uffff\uffff", true, 13 - View.resolveSize(0, 0), (ViewConfiguration.getScrollBarSize() >> 8) + Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE, TextUtils.getCapsMode("", 0, 0) + 10).intern())));
        }

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private c m347(List<String> list) {
            int i2 = f137 + 89;
            int i8 = i2 % 128;
            f138 = i8;
            if (i2 % 2 != 0) {
                throw null;
            }
            if (list != null) {
                this.f146 = list;
                f137 = (i8 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE) % 128;
            }
            return this;
        }

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private c m353(boolean z2) {
            int i2 = f137;
            this.f153 = z2;
            f138 = (i2 + 71) % 128;
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x0015  */
        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private com.ironsource.adqualitysdk.sdk.i.ad.c m360(java.util.List<java.lang.String> r3) {
            /*
                r2 = this;
                int r0 = com.ironsource.adqualitysdk.sdk.i.ad.c.f138
                int r0 = r0 + 115
                int r1 = r0 % 128
                com.ironsource.adqualitysdk.sdk.i.ad.c.f137 = r1
                int r0 = r0 % 2
                if (r0 != 0) goto L13
                r0 = 38
                int r0 = r0 / 0
                if (r3 == 0) goto L17
                goto L15
            L13:
                if (r3 == 0) goto L17
            L15:
                r2.f145 = r3
            L17:
                int r1 = r1 + 91
                int r3 = r1 % 128
                com.ironsource.adqualitysdk.sdk.i.ad.c.f138 = r3
                int r1 = r1 % 2
                if (r1 == 0) goto L25
                r3 = 21
                int r3 = r3 / 0
            L25:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.ad.c.m360(java.util.List):com.ironsource.adqualitysdk.sdk.i.ad$c");
        }

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private c m364(List<String> list) {
            if (list != null) {
                f137 = (f138 + 105) % 128;
                this.f147 = list;
            }
            int i2 = f137 + 57;
            f138 = i2 % 128;
            if (i2 % 2 == 0) {
                return this;
            }
            throw null;
        }

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private static String m349(String str, boolean z2, int i2, int i8, int i9) {
            String str2;
            Object charArray = str;
            if (str != null) {
                charArray = str.toCharArray();
            }
            char[] cArr = (char[]) charArray;
            synchronized (e.f1927) {
                try {
                    char[] cArr2 = new char[i2];
                    e.f1926 = 0;
                    while (true) {
                        int i10 = e.f1926;
                        if (i10 >= i2) {
                            break;
                        }
                        e.f1929 = cArr[i10];
                        cArr2[e.f1926] = (char) (e.f1929 + i8);
                        int i11 = e.f1926;
                        cArr2[i11] = (char) (cArr2[i11] - f141);
                        e.f1926 = i11 + 1;
                    }
                    if (i9 > 0) {
                        e.f1928 = i9;
                        char[] cArr3 = new char[i2];
                        System.arraycopy(cArr2, 0, cArr3, 0, i2);
                        int i12 = e.f1928;
                        System.arraycopy(cArr3, 0, cArr2, i2 - i12, i12);
                        int i13 = e.f1928;
                        System.arraycopy(cArr3, i13, cArr2, 0, i2 - i13);
                    }
                    if (z2) {
                        char[] cArr4 = new char[i2];
                        e.f1926 = 0;
                        while (true) {
                            int i14 = e.f1926;
                            if (i14 >= i2) {
                                break;
                            }
                            cArr4[i14] = cArr2[(i2 - i14) - 1];
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

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private c m352(List<Integer> list) {
            int i2 = f137;
            f138 = (i2 + 99) % 128;
            if (list != null) {
                this.f148 = list;
            }
            f138 = (i2 + 37) % 128;
            return this;
        }

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private static String m354(String str, int[] iArr, int i2, String str2) throws UnsupportedEncodingException {
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
                    char[] cArr2 = f140;
                    int i8 = f143;
                    if (f142) {
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
                    if (f139) {
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

    public ad(JSONObject jSONObject, is isVar) {
        m327(jSONObject, isVar);
        m316();
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static /* synthetic */ Class m308(ad adVar) {
        int i2 = f114;
        f113 = (i2 + 23) % 128;
        Class cls = adVar.f118;
        f113 = (i2 + 29) % 128;
        return cls;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ View.OnLayoutChangeListener m312(ad adVar) {
        int i2 = f113 + 67;
        int i8 = i2 % 128;
        f114 = i8;
        int i9 = i2 % 2;
        View.OnLayoutChangeListener onLayoutChangeListener = adVar.f122;
        if (i9 == 0) {
            int i10 = 72 / 0;
        }
        int i11 = i8 + 33;
        f113 = i11 % 128;
        if (i11 % 2 == 0) {
            return onLayoutChangeListener;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ c m315(ad adVar) {
        int i2 = f114;
        int i8 = i2 + 59;
        f113 = i8 % 128;
        int i9 = i8 % 2;
        c cVar = adVar.f117;
        if (i9 != 0) {
            int i10 = 36 / 0;
        }
        int i11 = i2 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE;
        f113 = i11 % 128;
        if (i11 % 2 != 0) {
            int i12 = 19 / 0;
        }
        return cVar;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ List m320(ad adVar) {
        int i2 = f114;
        f113 = (i2 + 91) % 128;
        List<View> list = adVar.f119;
        f113 = (i2 + 33) % 128;
        return list;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ Map m323(ad adVar) {
        int i2 = f114 + 65;
        int i8 = i2 % 128;
        f113 = i8;
        int i9 = i2 % 2;
        Map<View, View.OnLayoutChangeListener> map = adVar.f116;
        if (i9 != 0) {
            int i10 = 29 / 0;
        }
        int i11 = i8 + 69;
        f114 = i11 % 128;
        if (i11 % 2 != 0) {
            return map;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private void m310(List<View> list) {
        int i2 = 0;
        while (i2 < list.size()) {
            f114 = (f113 + 11) % 128;
            m321(list.get(i2), this.f117);
            i2++;
            f113 = (f114 + 35) % 128;
        }
        int i8 = f114 + 21;
        f113 = i8 % 128;
        if (i8 % 2 != 0) {
            int i9 = 63 / 0;
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ void m314(ad adVar, List list) {
        f113 = (f114 + 59) % 128;
        adVar.m310((List<View>) list);
        f114 = (f113 + 69) % 128;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c3  */
    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m321(android.view.View r15, com.ironsource.adqualitysdk.sdk.i.ad.c r16) {
        /*
            Method dump skipped, instruction units count: 303
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.ad.m321(android.view.View, com.ironsource.adqualitysdk.sdk.i.ad$c):void");
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m322() {
        int i2 = (f113 + 31) % 128;
        f114 = i2;
        f113 = (i2 + 109) % 128;
        return null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.y
    /* JADX INFO: renamed from: ｋ */
    public final /* synthetic */ String mo291(Activity activity) {
        f113 = (f114 + 33) % 128;
        String strM322 = m322();
        f114 = (f113 + 49) % 128;
        return strM322;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ void m317(Activity activity, View view, Class cls, boolean z2, List list, List list2, List list3) {
        f113 = (f114 + 23) % 128;
        m324(activity, view, cls, z2, list, list2, list3);
        f114 = (f113 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE) % 128;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static <E extends View> void m324(Activity activity, View view, Class<E> cls, boolean z2, List<Integer> list, List<String> list2, List<E> list3) {
        int i2 = f113 + 19;
        f114 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
        if (view != null) {
            ke.m2929(view, cls, false, z2, list, list2, list3);
            return;
        }
        ke.m2927(activity, cls, z2, list, list2, list3);
        int i8 = f113 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE;
        f114 = i8 % 128;
        if (i8 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final void m325() {
        m3133((s) null);
        ji.m2724().m2728(this.f123);
        HashSet hashSet = new HashSet(this.f116.keySet());
        this.f116.clear();
        Iterator it = hashSet.iterator();
        f114 = (f113 + 81) % 128;
        while (it.hasNext()) {
            ((View) it.next()).removeOnLayoutChangeListener(this.f122);
            f113 = (f114 + 103) % 128;
        }
        f114 = (f113 + 61) % 128;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final void m327(JSONObject jSONObject, is isVar) {
        this.f117 = new c(jSONObject);
        this.f121 = isVar;
        f113 = (f114 + 65) % 128;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private boolean m311(View view) {
        if (this.f121 == null) {
            f113 = (f114 + 57) % 128;
            return true;
        }
        if (!m318(view, (List<String>) c.m336(this.f117)) || !this.f121.mo1775(view)) {
            return false;
        }
        f114 = (f113 + 43) % 128;
        return true;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private void m316() {
        this.f122 = new View.OnLayoutChangeListener() { // from class: com.ironsource.adqualitysdk.sdk.i.ad.4

            /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
            private static int f127 = 0;

            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            private static char[] f128 = {50331, 4645, 27050, 18233, 40584, 62508, 50104, 6402, 28836, 20010, 42403, 62250, 51876, 8242, 'E', 55027, 44400, 33772, 23158, 12453, 1903, 56809, 46120, 35558, 24932, 14279, 3693, 58612, 47969, 37370, 26724, 16082, 5498, 60402, 49786, 39154, 28531};

            /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
            private static long f129 = 610115343515309697L;

            /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
            private static int f130 = 1;

            /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
            private static String m334(char c7, int i2, int i8) {
                String str;
                synchronized (com.ironsource.adqualitysdk.sdk.i.c.f1192) {
                    try {
                        char[] cArr = new char[i8];
                        com.ironsource.adqualitysdk.sdk.i.c.f1193 = 0;
                        while (true) {
                            int i9 = com.ironsource.adqualitysdk.sdk.i.c.f1193;
                            if (i9 < i8) {
                                cArr[i9] = (char) ((((long) f128[i2 + i9]) ^ (((long) i9) * f129)) ^ ((long) c7));
                                com.ironsource.adqualitysdk.sdk.i.c.f1193 = i9 + 1;
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

            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i2, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
                f130 = (f127 + 31) % 128;
                try {
                    ad.this.m326(view);
                    int i15 = f127 + 1;
                    f130 = i15 % 128;
                    if (i15 % 2 == 0) {
                        throw null;
                    }
                } catch (Throwable th) {
                    kd.m2919(m334((char) (50380 - TextUtils.indexOf((CharSequence) "", '0', 0)), Color.green(0), 14 - Drawable.resolveOpacity(0, 0)).intern(), m334((char) (ViewConfiguration.getJumpTapTimeout() >> 16), 14 - Gravity.getAbsoluteGravity(0, 0), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 23).intern(), th, false);
                }
            }
        };
        this.f123 = new jl() { // from class: com.ironsource.adqualitysdk.sdk.i.ad.2
            @Override // com.ironsource.adqualitysdk.sdk.i.jl
            /* JADX INFO: renamed from: ﻛ */
            public final void mo259(View view) {
                view.removeOnLayoutChangeListener(ad.m312(ad.this));
                ad.m323(ad.this).remove(view);
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.jl
            /* JADX INFO: renamed from: ﾇ */
            public final void mo264(View view) {
                view.addOnLayoutChangeListener(ad.m312(ad.this));
                ad.m323(ad.this).put(view, ad.m312(ad.this));
            }
        };
        ji.m2724().m2727(this.f123);
        f114 = (f113 + 103) % 128;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m309(String str, boolean z2, int i2, int i8, int i9) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (e.f1927) {
            try {
                char[] cArr2 = new char[i2];
                e.f1926 = 0;
                while (true) {
                    int i10 = e.f1926;
                    if (i10 >= i2) {
                        break;
                    }
                    e.f1929 = cArr[i10];
                    cArr2[e.f1926] = (char) (e.f1929 + i8);
                    int i11 = e.f1926;
                    cArr2[i11] = (char) (cArr2[i11] - f115);
                    e.f1926 = i11 + 1;
                }
                if (i9 > 0) {
                    e.f1928 = i9;
                    char[] cArr3 = new char[i2];
                    System.arraycopy(cArr2, 0, cArr3, 0, i2);
                    int i12 = e.f1928;
                    System.arraycopy(cArr3, 0, cArr2, i2 - i12, i12);
                    int i13 = e.f1928;
                    System.arraycopy(cArr3, i13, cArr2, 0, i2 - i13);
                }
                if (z2) {
                    char[] cArr4 = new char[i2];
                    e.f1926 = 0;
                    while (true) {
                        int i14 = e.f1926;
                        if (i14 >= i2) {
                            break;
                        }
                        cArr4[i14] = cArr2[(i2 - i14) - 1];
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

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final void m326(final View view) {
        Activity activityM2926;
        try {
            if (this.f118 == null) {
                int i2 = f114 + 87;
                f113 = i2 % 128;
                if (i2 % 2 == 0) {
                    this.f118 = Class.forName(c.m358(this.f117));
                    f113 = (f114 + 105) % 128;
                } else {
                    this.f118 = Class.forName(c.m358(this.f117));
                    throw null;
                }
            }
            final Activity activityMo2688 = jf.m2685().mo2688();
            if (activityMo2688 == null) {
                return;
            }
            if (c.m355(this.f117).isEmpty() || (activityM2926 = ke.m2926(view)) == null || !c.m355(this.f117).contains(activityM2926.getClass().getName())) {
                p.m2963(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.ad.5
                    @Override // com.ironsource.adqualitysdk.sdk.i.iu
                    /* JADX INFO: renamed from: ﻐ */
                    public final void mo306() {
                        ad.m320(ad.this).clear();
                        ad.m317(activityMo2688, view, ad.m308(ad.this), c.m362(ad.m315(ad.this)), c.m350(ad.m315(ad.this)), c.m366(ad.m315(ad.this)), ad.m320(ad.this));
                        if (ke.m2936(view, ad.m308(ad.this), null, c.m350(ad.m315(ad.this)), c.m366(ad.m315(ad.this)))) {
                            ad.m320(ad.this).add(view);
                        }
                        final ArrayList arrayList = new ArrayList(ad.m320(ad.this));
                        if (c.m343(ad.m315(ad.this))) {
                            p.m2969(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.ad.5.1
                                @Override // com.ironsource.adqualitysdk.sdk.i.iu
                                /* JADX INFO: renamed from: ﻐ */
                                public final void mo306() {
                                    ad.m314(ad.this, arrayList);
                                }
                            });
                        } else {
                            ad.m314(ad.this, arrayList);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            String strIntern = m309("\u0001\uffde\u0014\u0002\u0006\ufff3\u000f\u0002\t\u0001\u000b\ufffe￥\u0010", true, 14 - Drawable.resolveOpacity(0, 0), 216 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 6).intern();
            StringBuilder sb = new StringBuilder();
            sb.append(m309("\b\u0006\u0015\u0015\n\u000f\b\uffc1\u0004\r\u0002\u0014\u0014\uffc1￦\u0013\u0013\u0010\u0013\uffc1", false, ExpandableListView.getPackedPositionChild(0L) + 21, ((byte) KeyEvent.getModifierMetaStateMask()) + 214, 14 - View.MeasureSpec.getMode(0)).intern());
            sb.append(c.m358(this.f117));
            sb.append(m309("￼￼\t", false, (Process.myTid() >> 22) + 3, 155 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), 1 - KeyEvent.normalizeMetaState(0)).intern());
            sb.append(th.getLocalizedMessage());
            k.m2863(strIntern, sb.toString());
            m325();
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m313(String str) {
        f114 = (f113 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE) % 128;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        List listAsList = Arrays.asList(str.split(m309("￢\u000f\u0011", true, (ViewConfiguration.getKeyRepeatDelay() >> 16) + 3, 194 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), Process.getGidForName("") + 3).intern()));
        if (listAsList.size() <= 3) {
            int i2 = f114 + 41;
            f113 = i2 % 128;
            if (i2 % 2 != 0) {
                int i8 = 29 / 0;
            }
            return str;
        }
        return TextUtils.join(m309("\u0000", true, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (-16777052) - Color.rgb(0, 0, 0), (ViewConfiguration.getJumpTapTimeout() >> 16) + 1).intern(), listAsList.subList(0, 3));
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static boolean m318(View view, List<String> list) {
        if (list != null) {
            f114 = (f113 + 23) % 128;
            if (!list.isEmpty()) {
                String name = view.getClass().getPackage().getName();
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    String strM313 = m313(it.next());
                    if (!TextUtils.isEmpty(strM313)) {
                        int i2 = f114 + 5;
                        f113 = i2 % 128;
                        if (i2 % 2 == 0) {
                            if (name.startsWith(strM313)) {
                                return true;
                            }
                        } else {
                            name.startsWith(strM313);
                            throw null;
                        }
                    }
                }
                int i8 = f114 + 43;
                f113 = i8 % 128;
                if (i8 % 2 == 0) {
                    return false;
                }
                throw null;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private s<WebView, Activity> m319() {
        az.e eVar = new az.e() { // from class: com.ironsource.adqualitysdk.sdk.i.ad.3
            @Override // com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
            public final /* bridge */ /* synthetic */ void mo328(JSONObject jSONObject, Object obj, Object obj2) {
                ad.this.mo328(jSONObject, (WebView) obj, (Activity) obj2);
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            public final /* bridge */ /* synthetic */ void mo330(JSONObject jSONObject, Object obj, Object obj2) {
                ad.this.mo330(jSONObject, (WebView) obj, (Activity) obj2);
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ｋ */
            public final /* bridge */ /* synthetic */ void mo293(JSONObject jSONObject, Object obj, Object obj2) {
                ad.this.mo293(jSONObject, (WebView) obj, (Activity) obj2);
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ﾇ */
            public final /* bridge */ /* synthetic */ void mo296(JSONObject jSONObject, Object obj, Object obj2) {
                ad.this.mo296(jSONObject, (WebView) obj, (Activity) obj2);
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
            public final /* bridge */ /* synthetic */ void mo332(JSONObject jSONObject, Object obj, Object obj2) {
                ad.this.mo332(jSONObject, (WebView) obj, (Activity) obj2);
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
            public final /* bridge */ /* synthetic */ void mo329(JSONObject jSONObject, Object obj, Object obj2, Object obj3) {
                ad.this.mo329(jSONObject, (WebView) obj, obj2, (Activity) obj3);
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
            public final /* bridge */ /* synthetic */ void mo331(JSONObject jSONObject, Object obj, Object obj2, Object obj3) {
                ad.this.mo331(jSONObject, (WebView) obj, obj2, (Activity) obj3);
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
            public final /* bridge */ /* synthetic */ void mo333(JSONObject jSONObject, Object obj, Object obj2, Object obj3) {
                ad.this.mo333(jSONObject, (WebView) obj, obj2, (Activity) obj3);
            }
        };
        int i2 = f114 + 77;
        f113 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 64 / 0;
        }
        return eVar;
    }
}
