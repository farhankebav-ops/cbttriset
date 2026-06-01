package com.ironsource.adqualitysdk.sdk.i;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
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
import android.widget.ExpandableListView;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.ironsource.adqualitysdk.sdk.ISAdQualityAdListener;
import com.ironsource.adqualitysdk.sdk.ISAdQualityAdType;
import com.ironsource.adqualitysdk.sdk.ISAdQualityConfig;
import com.ironsource.adqualitysdk.sdk.ISAdQualityCustomMediationRevenue;
import com.ironsource.adqualitysdk.sdk.ISAdQualityInitError;
import com.ironsource.adqualitysdk.sdk.ISAdQualityInitListener;
import com.ironsource.adqualitysdk.sdk.ISAdQualityLogLevel;
import com.ironsource.adqualitysdk.sdk.ISAdQualitySegment;
import com.ironsource.adqualitysdk.sdk.IronSourceAdQuality;
import com.ironsource.adqualitysdk.sdk.i.aq;
import com.ironsource.adqualitysdk.sdk.i.jb;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class q extends IronSourceAdQuality {

    /* JADX INFO: renamed from: リ, reason: contains not printable characters */
    private static char[] f2992 = null;

    /* JADX INFO: renamed from: ヮ, reason: contains not printable characters */
    private static int f2993 = 1;

    /* JADX INFO: renamed from: 丫, reason: contains not printable characters */
    private static long f2994;

    /* JADX INFO: renamed from: 乁, reason: contains not printable characters */
    private static int f2995;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static q f2996;

    /* JADX INFO: renamed from: 爫, reason: contains not printable characters */
    private an f2997;

    /* JADX INFO: renamed from: טּ, reason: contains not printable characters */
    private iw f2999;

    /* JADX INFO: renamed from: סּ, reason: contains not printable characters */
    private aj f3000;

    /* JADX INFO: renamed from: ףּ, reason: contains not printable characters */
    private jb f3001;

    /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
    private ah f3002;

    /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
    private iy f3003;

    /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
    private aw f3004;

    /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
    private ISAdQualityAdListener f3005;

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private Context f3007;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private ISAdQualityConfig f3014;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private final as f3015 = new as();

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private boolean f3012 = false;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private boolean f3013 = false;

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private boolean f3008 = false;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private boolean f3009 = false;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private boolean f3010 = false;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private ISAdQualityLogLevel f3011 = ISAdQualityLogLevel.INFO;

    /* JADX INFO: renamed from: ﬤ, reason: contains not printable characters */
    private final Set<ISAdQualityInitListener> f2998 = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
    private final ak f3006 = new ak();

    /* JADX INFO: renamed from: com.ironsource.adqualitysdk.sdk.i.q$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class AnonymousClass4 implements at {

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        final /* synthetic */ boolean f3030;

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        final /* synthetic */ boolean f3031;

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        final /* synthetic */ Context f3032;

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        final /* synthetic */ boolean f3033;

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        final /* synthetic */ String f3034;

        /* JADX INFO: renamed from: com.ironsource.adqualitysdk.sdk.i.q$4$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public class AnonymousClass2 extends iu {

            /* JADX INFO: renamed from: com.ironsource.adqualitysdk.sdk.i.q$4$2$5, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
            public class AnonymousClass5 extends iu {

                /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
                private static int f3036 = 0;

                /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
                private static int f3038 = 1;

                /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
                private static char[] f3037 = {45744, 14244, 47243, 15851, 42624, 11046, 44043, 4470, 39509, 7340, 33193, 2809, 36827, 28734};

                /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
                private static long f3039 = 3711244186366346526L;

                public AnonymousClass5() {
                }

                /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
                private static String m3035(char c7, int i2, int i8) {
                    String str;
                    synchronized (c.f1192) {
                        try {
                            char[] cArr = new char[i8];
                            c.f1193 = 0;
                            while (true) {
                                int i9 = c.f1193;
                                if (i9 < i8) {
                                    cArr[i9] = (char) ((((long) f3037[i2 + i9]) ^ (((long) i9) * f3039)) ^ ((long) c7));
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

                @Override // com.ironsource.adqualitysdk.sdk.i.iu
                /* JADX INFO: renamed from: ﻐ */
                public final void mo306() {
                    q.m2983(q.this).m2643(m3035((char) (45782 - Color.blue(0)), (-1) - TextUtils.lastIndexOf("", '0', 0, 0), 14 - (Process.myPid() >> 22)).intern(), new jb.b() { // from class: com.ironsource.adqualitysdk.sdk.i.q.4.2.5.2

                        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
                        private static int f3041 = 1;

                        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
                        private static int f3042 = 0;

                        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
                        private static long f3043 = 7625254096969371826L;

                        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
                        private static String m3036(String str, int i2) {
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
                                            cArr2[i8] = (char) (((long) (cArr[i8] ^ (j.f2669 * i8))) ^ f3043);
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

                        @Override // com.ironsource.adqualitysdk.sdk.i.jb.b
                        /* JADX INFO: renamed from: ﾇ */
                        public final void mo2647(String str) {
                            int i2 = f3042 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE;
                            f3041 = i2 % 128;
                            if (i2 % 2 == 0) {
                                TextUtils.isEmpty(str);
                                throw null;
                            }
                            final boolean zIsEmpty = TextUtils.isEmpty(str);
                            if (zIsEmpty) {
                                q.m2983(q.this).m2641(m3036("郔틇ᓡ嚞飸\udaa9ᱍ幯耉숧Л䟄觻쮙", 16920 - Process.getGidForName("")).intern(), m3036("郔瀆兴㊾ᎃ", (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 57556).intern(), null);
                            }
                            p.m2964(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.q.4.2.5.2.2

                                /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
                                private static int f3045 = 121;

                                /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
                                private static int f3046 = 0;

                                /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
                                private static int f3047 = 1;

                                /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
                                private static String m3037(boolean z2, int i8, int i9, int i10, String str2) {
                                    String str3;
                                    Object charArray = str2;
                                    if (str2 != null) {
                                        charArray = str2.toCharArray();
                                    }
                                    char[] cArr = (char[]) charArray;
                                    synchronized (e.f1927) {
                                        try {
                                            char[] cArr2 = new char[i10];
                                            e.f1926 = 0;
                                            while (true) {
                                                int i11 = e.f1926;
                                                if (i11 >= i10) {
                                                    break;
                                                }
                                                e.f1929 = cArr[i11];
                                                cArr2[e.f1926] = (char) (e.f1929 + i9);
                                                int i12 = e.f1926;
                                                cArr2[i12] = (char) (cArr2[i12] - f3045);
                                                e.f1926 = i12 + 1;
                                            }
                                            if (i8 > 0) {
                                                e.f1928 = i8;
                                                char[] cArr3 = new char[i10];
                                                System.arraycopy(cArr2, 0, cArr3, 0, i10);
                                                int i13 = e.f1928;
                                                System.arraycopy(cArr3, 0, cArr2, i10 - i13, i13);
                                                int i14 = e.f1928;
                                                System.arraycopy(cArr3, i14, cArr2, 0, i10 - i14);
                                            }
                                            if (z2) {
                                                char[] cArr4 = new char[i10];
                                                e.f1926 = 0;
                                                while (true) {
                                                    int i15 = e.f1926;
                                                    if (i15 >= i10) {
                                                        break;
                                                    }
                                                    cArr4[i15] = cArr2[(i10 - i15) - 1];
                                                    e.f1926 = i15 + 1;
                                                }
                                                cArr2 = cArr4;
                                            }
                                            str3 = new String(cArr2);
                                        } catch (Throwable th) {
                                            throw th;
                                        }
                                    }
                                    return str3;
                                }

                                @Override // com.ironsource.adqualitysdk.sdk.i.iu
                                /* JADX INFO: renamed from: ﻐ */
                                public final void mo306() {
                                    f3047 = (f3046 + 67) % 128;
                                    ah ahVarM2984 = q.m2984(q.this);
                                    String strIntern = m3037(true, 2 - ExpandableListView.getPackedPositionChild(0L), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 229, 7 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), "\ufff3\u0004\b\b�\u0002�").intern();
                                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                    String strIntern2 = null;
                                    if (anonymousClass4.f3030) {
                                        String str2 = anonymousClass4.f3034;
                                        if (str2 != null) {
                                            int i8 = f3047 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE;
                                            f3046 = i8 % 128;
                                            if (i8 % 2 != 0) {
                                                throw null;
                                            }
                                            strIntern2 = str2;
                                        } else {
                                            strIntern2 = m3037(true, 1 - (ViewConfiguration.getPressedStateDuration() >> 16), 231 - TextUtils.indexOf("", "", 0), 4 - View.MeasureSpec.makeMeasureSpec(0, 0), "\u0000\ufffe\ufffe\u0007").intern();
                                            f3047 = (f3046 + 115) % 128;
                                        }
                                    }
                                    aw awVarM2989 = q.m2989(q.this);
                                    new gn(q.m2986(q.this));
                                    q.m2986(q.this);
                                    ahVarM2984.m458(strIntern, js.m2765(strIntern2, awVarM2989, zIsEmpty, q.m3025(q.this)));
                                    AnonymousClass4 anonymousClass42 = AnonymousClass4.this;
                                    if (anonymousClass42.f3031) {
                                        q.m2984(q.this).m460();
                                    }
                                    f3047 = (f3046 + 37) % 128;
                                }
                            });
                            f3042 = (f3041 + 113) % 128;
                        }
                    });
                    int i2 = f3038 + 105;
                    f3036 = i2 % 128;
                    if (i2 % 2 != 0) {
                        throw null;
                    }
                }
            }

            public AnonymousClass2() {
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                if (anonymousClass4.f3033) {
                    q.m2989(q.this).m707(AnonymousClass4.this.f3032, new AnonymousClass5());
                }
            }
        }

        public AnonymousClass4(boolean z2, Context context, boolean z7, String str, boolean z8) {
            this.f3033 = z2;
            this.f3032 = context;
            this.f3030 = z7;
            this.f3034 = str;
            this.f3031 = z8;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.at
        /* JADX INFO: renamed from: ﾇ */
        public final void mo383() {
            p.m2963(new AnonymousClass2());
        }
    }

    /* JADX INFO: renamed from: com.ironsource.adqualitysdk.sdk.i.q$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class AnonymousClass5 extends iu {

        /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
        private static int f3050 = 1579655598;

        /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
        private static int f3051 = 90;

        /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
        private static int f3052 = -915701493;

        /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
        private static byte[] f3053 = {-78, 89, -81, -124, 91, 85, -93, 85, -78, 122, -77, 125, -64, 122, -55, 39, -106, 109, -35, -46, -100, 101, 41, -42, 47, -118, 100, 36, -40, 50, -52, 32, -42, 37, 40, -42, 38, -8, 4, 55, 55, -118, -56, 54, -59, 38, -55, -57, 61, 50, 115, -116, 52, 117, -125, 55, 52, -59, 96, -116, -57, 52, -55, 0, -17, 54, -62, 21, -18, 54, 57, -58, 99, -113, -61, 60, -59, 96, -102, -56, 49, 62, -40, 6, 18, -56, 55, 55, -117, -57, 52, -55, 0, -17, 54, -62, 21, -18, 54, 57, -58, 99, -113, -61, 60, -59, 96, -116, -40, 58, -54, 123, -122, 63, 112, -101, 50, 54, 121, -122, 28, 19, -56, 55, 55, -19, -50, 50, -52, -53, 38, -35, -70, -105, 125, 98, -98, -102, -102, 105, 93, 124, -44, 107, 46, -91, -108, -107, -110, 97, -103, 98, -57, -56, -32, -44, -45, 123, -128, 45, 39, 104, -105, -41, 43, -37, 44, 63, -61, 47, 125, -5, 41, -33, -12, 43, 37, -45, 37, -62, 10, -61, 13, -64, 36, -56, -55, 63, -3, 105, -53, -59, 51, -59, 34, -22, 35, -19, 32, -60, -25, 119, 55, -53, 33, -33, 51, -59, 54, 59, -59, 53, -53, -121, 96, -51, 51, -50, -29};

        /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
        private static short[] f3054;

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private /* synthetic */ Application f3055;

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private /* synthetic */ String f3056;

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private /* synthetic */ Activity f3057;

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private /* synthetic */ ISAdQualityConfig f3059;

        public AnonymousClass5(ISAdQualityConfig iSAdQualityConfig, String str, Application application, Activity activity) {
            this.f3059 = iSAdQualityConfig;
            this.f3056 = str;
            this.f3055 = application;
            this.f3057 = activity;
        }

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private static String m3038(int i2, int i8, short s7, int i9, byte b8) {
            String string;
            synchronized (n.f2979) {
                try {
                    StringBuilder sb = new StringBuilder();
                    int i10 = f3051;
                    int i11 = i8 + i10;
                    int i12 = i11 == -1 ? 1 : 0;
                    if (i12 != 0) {
                        byte[] bArr = f3053;
                        i11 = bArr != null ? (byte) (bArr[f3052 + i2] + i10) : (short) (f3054[f3052 + i2] + i10);
                    }
                    if (i11 > 0) {
                        n.f2984 = ((i2 + i11) - 2) + f3052 + i12;
                        n.f2982 = b8;
                        char c7 = (char) (i9 + f3050);
                        n.f2981 = c7;
                        sb.append(c7);
                        n.f2980 = n.f2981;
                        n.f2983 = 1;
                        while (n.f2983 < i11) {
                            byte[] bArr2 = f3053;
                            if (bArr2 != null) {
                                int i13 = n.f2984;
                                n.f2984 = i13 - 1;
                                n.f2981 = (char) (n.f2980 + (((byte) (bArr2[i13] + s7)) ^ n.f2982));
                            } else {
                                short[] sArr = f3054;
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

        @Override // com.ironsource.adqualitysdk.sdk.i.iu
        /* JADX INFO: renamed from: ﻐ */
        public final void mo306() {
            int i2;
            Throwable th;
            String userId;
            Context applicationContext;
            q qVar;
            try {
                userId = this.f3059.getUserId();
                q.m3018(q.this, this.f3059.getLogLevel());
                String strIntern = m3038(915701493 - (ViewConfiguration.getFadingEdgeLength() >> 16), (ViewConfiguration.getFadingEdgeLength() >> 16) - 91, (short) ((-1) - MotionEvent.axisFromString("")), (-1579655533) - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (byte) (MotionEvent.axisFromString("") + 95)).intern();
                StringBuilder sb = new StringBuilder();
                try {
                    sb.append(m3038((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 915701505, (ViewConfiguration.getKeyRepeatDelay() >> 16) - 91, (short) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), View.resolveSize(0, 0) - 1579655525, (byte) ((-34) - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)))).intern());
                    sb.append(this.f3056);
                    k.m2854(strIntern, sb.toString());
                    ij.m2538(this.f3055.getApplicationContext()).m2545();
                    q.m3019(q.this, this.f3059.isTestMode());
                    if (this.f3059.isTestMode()) {
                        try {
                            k.m2868(m3038((ViewConfiguration.getJumpTapTimeout() >> 16) + 915701493, (-91) - (KeyEvent.getMaxKeyCode() >> 16), (short) (ViewConfiguration.getScrollBarSize() >> 8), (Process.myPid() >> 22) - 1579655533, (byte) (94 - KeyEvent.keyCodeFromString(""))).intern(), m3038(915701531 - (ViewConfiguration.getLongPressTimeout() >> 16), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) - 91, (short) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), (-1579655511) - (ViewConfiguration.getTouchSlop() >> 8), (byte) (TextUtils.indexOf("", "", 0) + 55)).intern());
                        } catch (Throwable th2) {
                            th = th2;
                            i2 = 915701493;
                            String strIntern2 = m3038(915701677 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (-91) - (ViewConfiguration.getTapTimeout() >> 16), (short) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), TextUtils.indexOf("", "", 0, 0) - 1579655529, (byte) (TextUtils.lastIndexOf("", '0') - 49)).intern();
                            kd.m2914(m3038(i2 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (-91) - (ViewConfiguration.getPressedStateDuration() >> 16), (short) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1), (ViewConfiguration.getMinimumFlingVelocity() >> 16) - 1579655533, (byte) (TextUtils.lastIndexOf("", '0') + 95)).intern(), strIntern2, th, true, false, true);
                            q.m3017(q.this, ISAdQualityInitError.EXCEPTION_ON_INIT, strIntern2);
                        }
                    }
                    try {
                        Class.forName(m3038(915701626 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (ViewConfiguration.getPressedStateDuration() >> 16) - 91, (short) (ViewCompat.MEASURED_STATE_MASK - Color.rgb(0, 0, 0)), (-1579655501) - Color.argb(0, 0, 0, 0), (byte) (View.combineMeasuredStates(0, 0) + 111)).intern());
                    } catch (Throwable unused) {
                    }
                    Activity activity = this.f3057;
                    if (activity != null) {
                        ju.m2791(activity);
                    } else {
                        ju.m2798(this.f3055);
                    }
                    q.m3025(q.this).m621(this.f3056);
                    q.m3025(q.this).m617(this.f3059.getInitializationSource());
                    q.m3025(q.this).m623(this.f3059.getCoppa());
                    q.m3025(q.this).m625(this.f3059.getDeviceIdType());
                    q.m3025(q.this).m626(this.f3059.getMetaData());
                    applicationContext = this.f3055.getApplicationContext();
                    q.m3022(q.this, applicationContext);
                    q.m3012(q.this, new iy(applicationContext));
                    qVar = q.this;
                    q.m2993(qVar);
                    i2 = 915701493;
                } catch (Throwable th3) {
                    th = th3;
                    i2 = 915701493;
                }
            } catch (Throwable th4) {
                th = th4;
                i2 = 915701493;
            }
            try {
                q.m2994(qVar, new jb(applicationContext, ak.m501(), "B0r1sW@sH3re"));
                aq.m530().mo562(applicationContext, q.m3003(q.this), q.m2993(q.this), new aq.a() { // from class: com.ironsource.adqualitysdk.sdk.i.q.5.2

                    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
                    private static char[] f3069 = {'I', 'S', 'A', 'd', 'Q', 'u', 'a', 'l', 'i', 't', 'y', ' ', 'D', 'K', 'c', 'o', 'n', 'f', 'g', 'm', 'e', 'N', 'w', 'r', 'k'};

                    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
                    private static int f3070 = 1;

                    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
                    private static char f3071 = 5;

                    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
                    private static int f3072;

                    @Override // com.ironsource.adqualitysdk.sdk.i.aq.a
                    /* JADX INFO: renamed from: ﻛ */
                    public final void mo568() {
                        q qVar2;
                        ISAdQualityInitError iSAdQualityInitError;
                        byte bMyTid;
                        int packedPositionChild;
                        int i8 = f3070 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE;
                        f3072 = i8 % 128;
                        if (i8 % 2 != 0) {
                            qVar2 = q.this;
                            iSAdQualityInitError = ISAdQualityInitError.NO_NETWORK_CONNECTION;
                            bMyTid = (byte) (62 >> (Process.myTid() << 23));
                            packedPositionChild = 98 >> ExpandableListView.getPackedPositionChild(0L);
                        } else {
                            qVar2 = q.this;
                            iSAdQualityInitError = ISAdQualityInitError.NO_NETWORK_CONNECTION;
                            bMyTid = (byte) (47 - (Process.myTid() >> 22));
                            packedPositionChild = ExpandableListView.getPackedPositionChild(0L) + 22;
                        }
                        q.m3017(qVar2, iSAdQualityInitError, m3040("\u0014\u0010\u0010\u0015\u0018\u0005\u0014\u0011\u0018\u0014\f\n\u0010\u0011\u000f\u0015\u0013\u000e\u0005\u0012\u009d", bMyTid, packedPositionChild).intern());
                    }

                    @Override // com.ironsource.adqualitysdk.sdk.i.aq.a
                    /* JADX INFO: renamed from: ﾇ */
                    public final void mo569() {
                        q qVar2;
                        ISAdQualityInitError iSAdQualityInitError;
                        byte deadChar;
                        int packedPositionChild;
                        int i8 = f3072 + 97;
                        f3070 = i8 % 128;
                        if (i8 % 2 == 0) {
                            qVar2 = q.this;
                            iSAdQualityInitError = ISAdQualityInitError.CONFIG_LOAD_TIMEOUT;
                            deadChar = (byte) (17 << KeyEvent.getDeadChar(1, 1));
                            packedPositionChild = 78 >> ExpandableListView.getPackedPositionChild(1L);
                        } else {
                            qVar2 = q.this;
                            iSAdQualityInitError = ISAdQualityInitError.CONFIG_LOAD_TIMEOUT;
                            deadChar = (byte) (KeyEvent.getDeadChar(0, 0) + 84);
                            packedPositionChild = ExpandableListView.getPackedPositionChild(0L) + 36;
                        }
                        q.m3017(qVar2, iSAdQualityInitError, m3040("\u0001\u0002\u0003\u0004\u0000\t\u0007\b\t\u0005\u000b\f\u0002\u000b\u000e\f\n\u0013\u0011\u0012\r\u0017\f\u0006\u0010\u0005\u0001\r\u0005\t\u000f\u0018\u0014\nÈ", deadChar, packedPositionChild).intern());
                        f3072 = (f3070 + 85) % 128;
                    }

                    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
                    private static String m3040(String str, byte b8, int i8) {
                        String str2;
                        Object charArray = str;
                        if (str != null) {
                            charArray = str.toCharArray();
                        }
                        char[] cArr = (char[]) charArray;
                        synchronized (h.f2264) {
                            try {
                                char[] cArr2 = f3069;
                                char c7 = f3071;
                                char[] cArr3 = new char[i8];
                                if (i8 % 2 != 0) {
                                    i8--;
                                    cArr3[i8] = (char) (cArr[i8] - b8);
                                }
                                if (i8 > 1) {
                                    h.f2267 = 0;
                                    while (true) {
                                        int i9 = h.f2267;
                                        if (i9 >= i8) {
                                            break;
                                        }
                                        h.f2269 = cArr[i9];
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
                                                int i10 = (h.f2266 * c7) + h.f2263;
                                                int i11 = (h.f2265 * c7) + h.f2262;
                                                int i12 = h.f2267;
                                                cArr3[i12] = cArr2[i10];
                                                cArr3[i12 + 1] = cArr2[i11];
                                            } else if (h.f2266 == h.f2265) {
                                                h.f2263 = androidx.camera.core.processing.util.a.C(h.f2263, c7, 1, c7);
                                                h.f2262 = androidx.camera.core.processing.util.a.C(h.f2262, c7, 1, c7);
                                                int i13 = (h.f2266 * c7) + h.f2263;
                                                int i14 = (h.f2265 * c7) + h.f2262;
                                                int i15 = h.f2267;
                                                cArr3[i15] = cArr2[i13];
                                                cArr3[i15 + 1] = cArr2[i14];
                                            } else {
                                                int i16 = (h.f2266 * c7) + h.f2262;
                                                int i17 = (h.f2265 * c7) + h.f2263;
                                                int i18 = h.f2267;
                                                cArr3[i18] = cArr2[i16];
                                                cArr3[i18 + 1] = cArr2[i17];
                                            }
                                        }
                                        h.f2267 += 2;
                                    }
                                }
                                str2 = new String(cArr3);
                            } catch (Throwable th5) {
                                throw th5;
                            }
                        }
                        return str2;
                    }
                }, q.m3021(q.this));
                q.m3002(q.this, new iw(applicationContext, q.m3003(q.this), q.m2993(q.this).m506()));
                final String strM2811 = jx.m2811(applicationContext);
                aq.m530().mo554(new at() { // from class: com.ironsource.adqualitysdk.sdk.i.q.5.5

                    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
                    private static int f3076 = 1;

                    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
                    private static int f3077 = 0;

                    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
                    private static char[] f3078 = {'s', 'o', 'm', 'l', 'a', 't', 'u', 'v', 'w'};

                    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
                    private static char f3079 = 3;

                    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
                    private static String m3041(String str, byte b8, int i8) {
                        String str2;
                        Object charArray = str;
                        if (str != null) {
                            charArray = str.toCharArray();
                        }
                        char[] cArr = (char[]) charArray;
                        synchronized (h.f2264) {
                            try {
                                char[] cArr2 = f3078;
                                char c7 = f3079;
                                char[] cArr3 = new char[i8];
                                if (i8 % 2 != 0) {
                                    i8--;
                                    cArr3[i8] = (char) (cArr[i8] - b8);
                                }
                                if (i8 > 1) {
                                    h.f2267 = 0;
                                    while (true) {
                                        int i9 = h.f2267;
                                        if (i9 >= i8) {
                                            break;
                                        }
                                        h.f2269 = cArr[i9];
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
                                                int i10 = (h.f2266 * c7) + h.f2263;
                                                int i11 = (h.f2265 * c7) + h.f2262;
                                                int i12 = h.f2267;
                                                cArr3[i12] = cArr2[i10];
                                                cArr3[i12 + 1] = cArr2[i11];
                                            } else if (h.f2266 == h.f2265) {
                                                h.f2263 = androidx.camera.core.processing.util.a.C(h.f2263, c7, 1, c7);
                                                h.f2262 = androidx.camera.core.processing.util.a.C(h.f2262, c7, 1, c7);
                                                int i13 = (h.f2266 * c7) + h.f2263;
                                                int i14 = (h.f2265 * c7) + h.f2262;
                                                int i15 = h.f2267;
                                                cArr3[i15] = cArr2[i13];
                                                cArr3[i15 + 1] = cArr2[i14];
                                            } else {
                                                int i16 = (h.f2266 * c7) + h.f2262;
                                                int i17 = (h.f2265 * c7) + h.f2263;
                                                int i18 = h.f2267;
                                                cArr3[i18] = cArr2[i16];
                                                cArr3[i18 + 1] = cArr2[i17];
                                            }
                                        }
                                        h.f2267 += 2;
                                    }
                                }
                                str2 = new String(cArr3);
                            } catch (Throwable th5) {
                                throw th5;
                            }
                        }
                        return str2;
                    }

                    @Override // com.ironsource.adqualitysdk.sdk.i.at
                    /* JADX INFO: renamed from: ﾇ */
                    public final void mo383() {
                        int i8 = f3077 + 95;
                        f3076 = i8 % 128;
                        if (i8 % 2 == 0) {
                            if (aq.m530().mo560(m3041("\u0001\u0002\u0002\u0000\u0004\u0005", (byte) (53 / (ViewConfiguration.getTouchSlop() + 9)), 17 % KeyEvent.normalizeMetaState(1)).intern(), strM2811)) {
                                return;
                            }
                        } else if (aq.m530().mo560(m3041("\u0001\u0002\u0002\u0000\u0004\u0005", (byte) ((ViewConfiguration.getTouchSlop() >> 8) + 115), KeyEvent.normalizeMetaState(0) + 6).intern(), strM2811)) {
                            return;
                        }
                        q.m2999(q.this);
                        f3077 = (f3076 + 45) % 128;
                    }
                });
                aq.m530().mo551(new at() { // from class: com.ironsource.adqualitysdk.sdk.i.q.5.3
                    @Override // com.ironsource.adqualitysdk.sdk.i.at
                    /* JADX INFO: renamed from: ﾇ */
                    public final void mo383() {
                        aq.m530().mo552(q.m2992(q.this));
                    }
                });
                q.m3007(q.this, applicationContext);
                q qVar2 = q.this;
                q.m3010(qVar2, new ah(applicationContext, q.m3025(qVar2), q.m2993(q.this), this.f3057 != null, strM2811, new r() { // from class: com.ironsource.adqualitysdk.sdk.i.q.5.1
                    @Override // com.ironsource.adqualitysdk.sdk.i.r
                    public void onEvent(final String str) {
                        p.m2964(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.q.5.1.2

                            /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
                            private static int f3061 = 0;

                            /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
                            private static char f3062 = 20664;

                            /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
                            private static int f3063 = 1;

                            /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
                            private static char f3064 = 15190;

                            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
                            private static char f3065 = 48610;

                            /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
                            private static char f3066 = 5058;

                            @Override // com.ironsource.adqualitysdk.sdk.i.iu
                            /* JADX INFO: renamed from: ﻐ */
                            public final void mo306() {
                                f3063 = (f3061 + 51) % 128;
                                q.m2989(q.this).m711(m3039("\u0e66ૣ虎⒍蔷\uda7b虎⒍䵋ᶓﱲႍ\r濣闬䋤셯ⴕཽ咁쟯닁燭왭", View.MeasureSpec.getSize(0) + 23).intern(), Collections.singletonList(str));
                                int i8 = f3063 + 23;
                                f3061 = i8 % 128;
                                if (i8 % 2 != 0) {
                                    throw null;
                                }
                            }

                            /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
                            private static String m3039(String str2, int i8) {
                                String str3;
                                Object charArray = str2;
                                if (str2 != null) {
                                    charArray = str2.toCharArray();
                                }
                                char[] cArr = (char[]) charArray;
                                synchronized (o.f2985) {
                                    try {
                                        char[] cArr2 = new char[cArr.length];
                                        o.f2986 = 0;
                                        char[] cArr3 = new char[2];
                                        while (true) {
                                            int i9 = o.f2986;
                                            if (i9 < cArr.length) {
                                                cArr3[0] = cArr[i9];
                                                cArr3[1] = cArr[i9 + 1];
                                                int i10 = 58224;
                                                for (int i11 = 0; i11 < 16; i11++) {
                                                    char c7 = cArr3[1];
                                                    char c8 = cArr3[0];
                                                    char c9 = (char) (c7 - (((c8 + i10) ^ ((c8 << 4) + f3064)) ^ ((c8 >>> 5) + f3062)));
                                                    cArr3[1] = c9;
                                                    cArr3[0] = (char) (c8 - (((c9 >>> 5) + f3065) ^ ((c9 + i10) ^ ((c9 << 4) + f3066))));
                                                    i10 -= 40503;
                                                }
                                                int i12 = o.f2986;
                                                cArr2[i12] = cArr3[0];
                                                cArr2[i12 + 1] = cArr3[1];
                                                o.f2986 = i12 + 2;
                                            } else {
                                                str3 = new String(cArr2, 0, i8);
                                            }
                                        }
                                    } catch (Throwable th5) {
                                        throw th5;
                                    }
                                }
                                return str3;
                            }
                        });
                    }
                }));
                if (!this.f3059.isUserIdSet()) {
                    q.m3025(q.this).m615();
                    userId = q.m2984(q.this).m455();
                }
                if (q.this.m3032()) {
                    q.m2984(q.this).m463(new ai() { // from class: com.ironsource.adqualitysdk.sdk.i.q.5.4
                        @Override // com.ironsource.adqualitysdk.sdk.i.ai
                        public void onEventReceived(JSONObject jSONObject) {
                            ip.m2553(q.m2986(q.this), ig.f2489, jSONObject, new Object[0]);
                        }
                    });
                }
                q.m2984(q.this).m464(new jb.d() { // from class: com.ironsource.adqualitysdk.sdk.i.q.5.9
                    @Override // com.ironsource.adqualitysdk.sdk.i.jb.d
                    /* JADX INFO: renamed from: ﾒ */
                    public final void mo2648() {
                        q.m2999(q.this);
                    }
                });
                az azVar = new az();
                q qVar3 = q.this;
                q.m3011(qVar3, new aw(q.m2992(qVar3), q.m2984(q.this), strM2811, azVar, new ISAdQualityInitListener() { // from class: com.ironsource.adqualitysdk.sdk.i.q.5.6
                    @Override // com.ironsource.adqualitysdk.sdk.ISAdQualityInitListener
                    public final void adQualitySdkInitFailed(ISAdQualityInitError iSAdQualityInitError, String str) {
                        q.m3017(q.this, iSAdQualityInitError, str);
                    }

                    @Override // com.ironsource.adqualitysdk.sdk.ISAdQualityInitListener
                    public final void adQualitySdkInitSuccess() {
                        q.m2988(q.this);
                    }
                }));
                q.m2989(q.this).m709(new ISAdQualityAdListener() { // from class: com.ironsource.adqualitysdk.sdk.i.q.5.8
                    @Override // com.ironsource.adqualitysdk.sdk.ISAdQualityAdListener
                    public final void adClosed(String str, ISAdQualityAdType iSAdQualityAdType) {
                        if (q.m2977(q.this) != null) {
                            q.m2977(q.this).adClosed(str, iSAdQualityAdType);
                        }
                    }

                    @Override // com.ironsource.adqualitysdk.sdk.ISAdQualityAdListener
                    public final void adDisplayed(String str, ISAdQualityAdType iSAdQualityAdType) {
                        if (q.m2977(q.this) != null) {
                            q.m2977(q.this).adDisplayed(str, iSAdQualityAdType);
                        }
                    }
                });
                q qVar4 = q.this;
                q.m3023(qVar4, new aj(q.m2989(qVar4)));
                q qVar5 = q.this;
                q.m3024(qVar5, new an(q.m2984(qVar5)));
                String strIntern3 = m3038(898924277 - Color.rgb(0, 0, 0), (-90) - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (short) View.getDefaultSize(0, 0), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) - 1579655533, (byte) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 93)).intern();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(m3038(915701645 - (ViewConfiguration.getScrollDefaultDelay() >> 16), TextUtils.indexOf((CharSequence) "", '0') - 90, (short) View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.getSize(0) - 1579655525, (byte) (ExpandableListView.getPackedPositionChild(0L) + 47)).intern());
                sb2.append(q.m2993(q.this).m505());
                k.m2858(strIntern3, sb2.toString());
                q qVar6 = q.this;
                Context context = this.f3057;
                if (context == null) {
                    context = applicationContext;
                }
                q.m3000(qVar6, context, userId);
                q.m2996(q.this, applicationContext);
                q.m2976(q.this);
                q.m2980(q.this);
            } catch (Throwable th5) {
                th = th5;
                th = th;
                String strIntern22 = m3038(915701677 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (-91) - (ViewConfiguration.getTapTimeout() >> 16), (short) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), TextUtils.indexOf("", "", 0, 0) - 1579655529, (byte) (TextUtils.lastIndexOf("", '0') - 49)).intern();
                kd.m2914(m3038(i2 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (-91) - (ViewConfiguration.getPressedStateDuration() >> 16), (short) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1), (ViewConfiguration.getMinimumFlingVelocity() >> 16) - 1579655533, (byte) (TextUtils.lastIndexOf("", '0') + 95)).intern(), strIntern22, th, true, false, true);
                q.m3017(q.this, ISAdQualityInitError.EXCEPTION_ON_INIT, strIntern22);
            }
        }
    }

    static {
        m2985();
        f2996 = null;
        int i2 = f2995 + 69;
        f2993 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 10 / 0;
        }
    }

    private q() {
    }

    /* JADX INFO: renamed from: ﬤ, reason: contains not printable characters */
    public static /* synthetic */ an m2974(q qVar) {
        int i2 = f2993 + 91;
        int i8 = i2 % 128;
        f2995 = i8;
        int i9 = i2 % 2;
        an anVar = qVar.f2997;
        if (i9 != 0) {
            throw null;
        }
        f2993 = (i8 + 69) % 128;
        return anVar;
    }

    /* JADX INFO: renamed from: טּ, reason: contains not printable characters */
    public static /* synthetic */ Set m2975(q qVar) {
        int i2 = (f2993 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE) % 128;
        f2995 = i2;
        Set<ISAdQualityInitListener> set = qVar.f2998;
        int i8 = i2 + 107;
        f2993 = i8 % 128;
        if (i8 % 2 != 0) {
            return set;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
    public static /* synthetic */ void m2976(q qVar) {
        f2993 = (f2995 + 43) % 128;
        qVar.m2997(true);
        f2993 = (f2995 + 39) % 128;
    }

    /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
    public static /* synthetic */ ISAdQualityAdListener m2977(q qVar) {
        int i2 = f2993;
        f2995 = (i2 + 71) % 128;
        ISAdQualityAdListener iSAdQualityAdListener = qVar.f3005;
        f2995 = (i2 + 11) % 128;
        return iSAdQualityAdListener;
    }

    /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
    public static /* synthetic */ void m2980(q qVar) {
        f2995 = (f2993 + 1) % 128;
        qVar.m3027(false);
        int i2 = f2995 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE;
        f2993 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
    public static /* synthetic */ boolean m2982(q qVar) {
        int i2 = f2993 + 1;
        f2995 = i2 % 128;
        if (i2 % 2 != 0) {
            qVar.m2981();
            throw null;
        }
        boolean zM2981 = qVar.m2981();
        f2995 = (f2993 + 83) % 128;
        return zM2981;
    }

    /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
    public static /* synthetic */ jb m2983(q qVar) {
        int i2 = (f2995 + 21) % 128;
        f2993 = i2;
        jb jbVar = qVar.f3001;
        int i8 = i2 + 75;
        f2995 = i8 % 128;
        if (i8 % 2 == 0) {
            return jbVar;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    public static void m2985() {
        char[] cArr = new char[1582];
        a0.o("\u0000Ic\u0087Çé+\u0018\u008f\u0001óQV\u0099º \u001eÉ\u0082\u0000æ1JO\u00ad´\u0011\u008fu¶Ù\u0005=.¡}\u0004\u009chÕÌñ0\b\u0094Qøv[\u0085¿\u0094#ë\u00873ë^Op²½\u0016ÔzôÞtBI¥\u008e\t·m\u0084Ñ\u001559\u0099Sü\u0080`èÄþ(\u0015\u008cdðwS\u008a·à\u001bà\u007f\u0011ãLGuªÄ\u000eùrïÖ\u0014:]\u009e~\u0001µeÄÉý-w\u0091mõpX¤¼Ä \u0015\u00843èEK\u008c¯¥\u0013Ïw\u001a\u0086må\u009cAÕ\u00ad%\t\u001dudÐ½<\u0094\u0098õ\u0004\u000b` Ì{ÅÅ¦\u000b\u0002eî\u0094J\u008d6Ý\u0093\u0015\u007f,ÛEG\u008c#½\u008fÃh8Ô\u0003°:\u001c\u0089ø¢dñÁ\u0010\u00adY\t}õ\u0084QÝ=ú\u009e\tz\u0018æeB¼.Î\u008aíw5ÓD¿u\u001bø\u0087Ç`\u0011Ì0¨D\u0014\u0091ð¤\u0017\u0005tËÐ¥<T\u0098Mä\u001dAÕ\u00adì\t\u0085\u0095Lñ}]pºï\u0006Ìb\u009fÎ\u0000*e¶6\u0013Í\u007f\u0084Ûµ'I\u0083\u0018ï)LÖ¨\u009d4ä\u0090}ü\u0019X<¥ü\u0001\u008fm¨É8U\u0007²Ñ\u001eòzÈÆV\"e\u008eLëÝwüÓµ?_\u009b}ç DÅ è\føhKô\u001eP0½Ñ\u0019Ôe¯ÁB-\u001b\u0089!\u0000CcµÇÆ+[\u008f$ó\u0004V\u0091º¢\u001eÉ\u0082\u0000æ!J}\u00ad\u009c\u0011\u00aduâÙ\t=`¡9\u0004ÈhõÌÃ0%\u0094\\ø][\u0095¿Õ#ä\u00875ëDO}²ø\u0016ÿzÄÞ\u001fB\b¥\u008b\t±m×ÑX5?\u0099Hü\u0081`¼Äø(\u001f\u008c3ðvSÂ\u0000CcµÇÆ+[\u008f$ó\u0004V\u0091º¢\u001eÉ\u0082\u0000æ!J}\u00ad\u009c\u0011\u00aduâÙ\t=`¡]\u0004»hýÌô05\u0094Møm[\u008c¿Ý#ü\u0087%ë\u0010OW²\u009c\u0016çz Þ#BA¥\u0088\t¸m\u0084Ñ\u001659\u0099Lü\u0098`èÄó(\u0002\u008cdð}S\u0081·°\u001bà\u007f\u0011ã\u001cGeª\u0097\u000eÝrþÖ@:]\u009el\u0001ò\u0000CcµÇÆ+[\u008f$ó\u0004V\u0091º¢\u001eÉ\u0082\u0000æ!J}\u00ad\u009c\u0011\u00aduâÙ\t=`¡9\u0004ÈhÝÌà0\u0014\u0094søi[\u0099¿\u0094#ë\u0087=ë^O#²¬\u0016\u008czâÞ1B\b¥\u0092\t¥mÈÑ\u00145l\u0099Oü\u0086`èÄù(\u001d\u008c4ðlS\u0095·îBç!)\u0085Gi¶Í¯±ÿ\u00147ø\u000e\\gÀ®¤\u009f\báï\u001aS!7\u0016\u009bµ\u007f\u008fãÉFf*s\u008eRr¸ÖóºÃ\u0019*ýca\u0006Å\u0081©ö\rßð\u0002Tf8A\u009c\u008d\u0000èç|\u0018 {nß\u00003ñ\u0097èë¸Np¢I\u0006 \u009aéþØR¦µ]\tfmQÁò%È¹\u008e\u001c!p;Ô\u001c(û\u008c´à\u0097C)§4;\u000f\u009fÜó\u00adW\u0084ªP\u000e)b\u0000ÆÇZ¤½q\u0011\u0019u`É±-Ë\u0081¦ä=xOÜ\u00100ü\u0094ÉèÑKq¯F\u0003]gòû½_\u008c²y\u00165j\nÎþ\"³\u0086Ï\u0003\u009f`QÄ?(Î\u008c×ð\u0087UO¹v\u001d\u001f\u0081ÖåçIê®u\u0012Vv\u0005Ú\u009a>á¢£\u0007MkJÏ53Ú\u0097\u009bû®XR¼\r )\u0084ä1\u0080R\u0012öz\u001a³¾\u009dÂ¤g\u0019\u008b\b/Q³¡×\u0089{Ð\u009c9 \u0010DAèì\f\u0090\u0090Ø5)YhýV\u0001«¥êÉÁ\u0000sc»ÇÇ+\u0011\u008f<óE\u0000 c£ÇÁ+\b\u008f8ó\u0004V\u008aº©\u001eÁ\u0082\u0007æ'Jr\u00adÊ\u0011äÝ)¾Ê\u001a¶ö\u007fRN.h\u008bçgÈÃ¹_l;P\u0097\u0019pòÌÏ¨Ô\u0004dàC|\u000fÙê&ÒE1áM\r\u0084©µÕ\u0093p\u001c\u009c>8C¤\u0097À¶lå\u008b\u00007sSzÿ\u0088\u001b²\u0087ñ\"6NOê'}\u009d\u001ekº\u0018V\u0085òú\u008eÚ+EÇzc\u001fÿÄ\u009bñ7§Ð\u000elo\b5¤×@ìÜêy_\u0015\u0006±nM\u0097éÆ\u0085\u009b&mÂ+^2úÓ\u0096\u009b2»Ïjk\u001b\u0007*£ó?ÖØqtJ\u00101¬\u0086Håä\u009f\u0081Y\u001d6¹1UÆñï\u008d².VÊqf=\u0002Ø\u009eÌõ\u008b\u0096i2\u000fÞ\u008ezï\u0006\u0083£YOjëRwÏ\u0013ô¿§XVä\u007f\u0080+,ÒÈûT¼ñ_\u009dN9\u000bÅåa«\rº®cJ\u0013Ö;râ\u001e\u008bº¢Gsã^\u008f\u0001+Â·±P\u000eü`\u0098\u0013$ÌÀñl\u0080\tC\u0095:1-ÝÃyú\u0005¦¦WB|î!\u008a\u009a\u0016É²¡_^û\u000b\u00870#ÕÏ\u0083k\u008fô}\u0090\u0007<$ØÃd\u009a\u0000õ\u0006\u000beôÁ\u009a-\u0019\u0089`õ\u0012PØ¼û\u0018Å\u0084XàiLy«Ö\u0017às³ß\u000e;q§q\u0002Ïn\u009cÊõ6O\u0092\bþ%]É¹Ñ%¢\u0081kíUI$´ð\u0010\u0099|±Øh\u0000Ec\u0086Çú+3\u008f\u0002ó\u0005VØº¹\u001eÓ\u0082\u0011æ:J<\u00ad¹\u0011\u0080u¸Ù\u0005=3¡4\u0004\u0086hÉÌü0\b\u0094\u0016ø,[°¿Ø#í\u0087=ëCOa²ø\u0016ÁzáÞ?BM¥Ü\t£mÑÑ\n5)\u0099\u0000ü\u0080`§Ä¼(\u0000\u008c%ðkS\u009f·à\u001bõ\u007fHãJGqª\u0088\u000eÑrèÖ@:Z\u009eg\u0001²e\u009dÉê--\u0091@õlXô¼Ý \u000f\u00845èVKØ¯\u0085\u0013äwTÛ<?s¢Ð\u0006\u008djËÎ-2$\u0096Eù\u009d]ÝÁü%\r\u0089LíuPÀ´ç\u0018Ì|\u0017à\u001e\u0089\u0014êÏN¤¢}\u0006Mz8ßã3Þ\u0097ø\u000bxoRÃ\u001c$¨\u0098Æü\u008cPw´A\u0000Ec\u0086Çú+3\u008f\u0002ó\u0005VØº\u0095\u001eÏ\u0082\u0001æoJn\u00ad\u0095\u0011äuíÙ\u001f=)¡z\u0004\u008fh\u009cÌä0\f\u0094]ø,[\u0084¿Ñ#î\u0087=ëEOh²¬\u0016\u008czõÞ'BM¥\u008e\tðmíÑ<5lÝ2¾è\u001aäö\fR).Y\u008b\u0097gµÃ\u009c_\u0005;5\u0097kp\u0089Ìø¨÷\u0004\u0005à.|mÙÔµÔ\u0011ãíXIT%q\u0086\u008fbÛþ´Z!6\f\u0092moªËÙ§í\u0003=\u009fQxÀÔ¹°Ë\f\u0001è\"D\u001c!¡½\u0090\u0019 õ\nQ7-v\u008eÐj¹Æé¢\u0017>H\u009a,w\u008dÓ×¯õ\u000b\u000eç\bC`Ü¯¸\u008c\u0014Ñð\u0017Lq(x\u0085\u0099aÁý\u0001Y 5Q\u0096\u0090r©Î\u009cª;\u0006\u0010âK\u007fÂ\u009a\u0092ùp]\u0016±Å\u0015»i¦Ì` F\u0084\u000f\u0018î|öÐ¶7W\u008bfï'CÞ§«;\u008c\u009egò<V{ªÚ\u000e\u0080b¢ÁY%_¹\n\u001dÓqÛÕ¦(`\u008c]àk\r¹nhÊ\u0001&û\u0082áþ\u0092[I·`\u0013'\u008fÎëüG« J\u0000icºÇÜ+R\u008f#óAV\u008bº¿\u001eé\u0082\u0010¢ÝÁ\u000fe`\u0089¶-\u009cQïô0\u0018\u0006¼b óD\u008aèÃ\u000fw³\t×S{ë\u009f\u0088\u0003Ó¦ Êyn@\u0092¹6øZÆù:\u0000sc»ÇÇ+\u0011\u008f<óEVÕº¿\u001eÅ\u0082\u0017æ:Jy\u00ad\u0084\u0011éu¬Ù\r=.¡u\u0004\u0084hÅÌä0\r\u0094[ø\u007fzÉ\u0019?½LQÑõ®\u0089\u008e,\u0001À#d^øÞ\u009c«0ø×\u000ek+\u000f`£\u0088G«Ûò~B\u0012B¶\u007fJ\u009dîÆ\u0082¦!\u0007ÅQYfý³\u0091\u009a5£Èrlo\u0000Y¤\u009f8Æß's/\u0017O«\u009eO¯ãÞ\u0086\u0007\u001ab¾ER¾ö\u0085\u008a²)\u0011Í+am\u0005Â\u0099Å=òÐ\u001btF\bb¬\u0085@Éäì{x\u0000Mc¡ÇÛ+\b\u008fpóWV\u009dº¸\u001e\u0080\u0082\u001dæ&Jh\u00ad\u0095\u0011¶uöÙ\r=,¡4\u0004\u009chÙÌã0\u0010\u0094\u0018øa[\u008f¿Ð#í\u0087|ëROa²¾\u0016ÃzòÞ1B\b¥\u0095\t¾mÍÑ\f5%\u0099Aü\u0098`¡Äæ(\u0019\u008c*ð\u007fSÍ\u0000acºÇÌ+\u000e\u008f?óMV\u009cºâ\u001eÉ\u0082\u001aæ<Jy\u00ad\u009e\u0011°u¶Ù\r=#¡`\u0004\u0081hÓÌþ0J\u0094zøM[´¿à#Í\u0087\u000eëiO[²\u009b\u0016äzÁÞ\u001aBo¥¹\t\u0094\u0000FcµÇÁ+\u0010\u008f5ó@VØº¸\u001eÏ\u0082Tæ:Jy\u00ad\u0097\u0011\u00aduëÙ\u0018=%¡f\u0004ÈhÞÌñ0\u0010\u0094Løi[\u0092¿Í#¨\u0087.ëUOg²½\u0016ÅzöÞ1BZ\u0000CcµÇÆ+[\u008f$ó\u0004V\u008bº©\u001eÔ\u0082Tæ)Jx\u00adÐ\u0011¨uñÙ\u001f=4¡q\u0004\u0086hÙÌâ0D\u0094\u0015ø,[©¿ç#É\u00878ëaOq²¹\u0016ÀzéÞ BQ¥Ü\t\u0083màÑ35l\u0099Wü\u0095`»Ä¼(\u0003\u008c,ðmS\u0098·¤\u001bû\u007f\u001fãRG>\u0091\u0084òrV\u0001º\u009c\u001eãbÃÇL+n\u008f\t\u0013×w¯Û¸<B\u0080pä+HÄ¬ê0ó\u0095Bù\u001e]3¡Ê\u0005\u009ei¿ÊN.\u001c²!\u0016»z\u0085Þ¦#i\u0087\u000eë)OæÓ\u008a4\u001b\u0098:üC@ö¤Ø\b¦mWñ^U.¹Ö\u001dïa¶Â_&~\u008asîür¿Ö\u009c;\u0003\u009f\bã*GÔ«Ó\u000f¼\u0090sô\u0002X7¼û\u0000\u0084d°É}-A\u0000CcµÇÆ+[\u008f$ó\u0004V\u008bº©\u001eÎ\u0082\u0010æhJ\u007f\u00ad\u0085\u0011·uìÙ\u0003=-¡4\u0004\u0085hÙÌô0\r\u0094Yøx[\u0089¿Û#æ\u0087|ëBOa²®\u0016ÉzîÞ!BM¥Ü\tým\u0084Ñ15\u001f\u0099aü\u0090`\u0099Äé(\u0011\u008c(ðqS\u0098·¹\u001b´\u007f;ãxG[ªÄ\u000eÑrÿÖ@:Z\u009eg\u0001¨e\u0090Éí-6\u0091EõtX½¼É \u0010\u00849è^K\u009d¯¨\u0013\u008e]ú>\f\u009a\u007fvâÒ\u009d®½\u000b2ç\u0010Cmßí»\u0082\u0017Àð.L\u0010(D\u0084»`\u008dü\u008dY|5%\u0091`m\u008eÉÀ¥Ñ\u0006\bâx~PÚ\u0089¶à\u0012Éï\u0018K5'j\u0083©\u001fÚøeT\u001e0|\u008c²hÕÄê¡%=\u0004\u0099Qu\u00adÑ\u0092\u00adÖ\u000e;êWMx.\u008e\u008aýf`Â\u001f¾?\u001b°÷\u0092SïÏo«\u0010\u0007Hà¥\\\u00998Ê\u00940p[ì\u0002Ió%Î\u0081ø}\u001eÙgµf\u0016®òînßÊ\u000e¦\u007f\u0002FÿÃ[Ä7ÿ\u0093$\u000f3è°D\u008a ì\u009ccx\u0004Ôs±º-\u0087\u0089Ãe$Á\b½M\u001eùú¦\u0099P=#Ñ¾uÁ\tá¬n@Lä1x±\u001cÎ°\u0096W{ëG\u008f\u0014#îÇ\u0085[Üþ-\u0092\u00106&ÊÀn¹\u0002¸¡pE0Ù\u0001}Ð\u0011¡µ\u0098H\u001dì\u001a\u0080!$ú¸í_póF\u0097a+üÏÅc·\u0006t\u009aL>\u001dÒìv\u0081\n\u0094©gMLá\u0005\u0085ä\u0019¸½\u0099Phô'\u0088\f,áÀÿ\u0000ic³ÇÆ+\u0013\u008f\"óAV§º¼\u001eÒ\u0082\u0011æ\u0017Ju\u00ad\u009e\u0011\u00aduìÙ3=#¡{\u0004\u0086hÚÌù0\u0003", "ISO-8859-1", cArr, 0, 1582);
        f2992 = cArr;
        f2994 = -7117028751992921132L;
    }

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    public static /* synthetic */ Context m2986(q qVar) {
        int i2 = (f2995 + 1) % 128;
        f2993 = i2;
        Context context = qVar.f3007;
        f2995 = (i2 + 81) % 128;
        return context;
    }

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    public static /* synthetic */ void m2988(q qVar) {
        f2993 = (f2995 + 99) % 128;
        qVar.m2979();
        f2993 = (f2995 + 9) % 128;
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    public static /* synthetic */ aw m2989(q qVar) {
        int i2 = f2995;
        f2993 = (i2 + 11) % 128;
        aw awVar = qVar.f3004;
        int i8 = i2 + 55;
        f2993 = i8 % 128;
        if (i8 % 2 != 0) {
            return awVar;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    public static /* synthetic */ iw m2992(q qVar) {
        int i2 = (f2993 + 103) % 128;
        f2995 = i2;
        iw iwVar = qVar.f2999;
        f2993 = (i2 + 27) % 128;
        return iwVar;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static /* synthetic */ ak m2993(q qVar) {
        int i2 = (f2993 + 19) % 128;
        f2995 = i2;
        ak akVar = qVar.f3006;
        f2993 = (i2 + 115) % 128;
        return akVar;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ void m2999(q qVar) {
        int i2 = f2993 + 47;
        f2995 = i2 % 128;
        int i8 = i2 % 2;
        qVar.m3001(true);
        f2993 = (f2995 + 5) % 128;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ iw m3002(q qVar, iw iwVar) {
        int i2 = f2993;
        f2995 = (i2 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE) % 128;
        qVar.f2999 = iwVar;
        int i8 = i2 + 19;
        f2995 = i8 % 128;
        if (i8 % 2 != 0) {
            int i9 = 49 / 0;
        }
        return iwVar;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ ah m3010(q qVar, ah ahVar) {
        int i2 = f2993 + 97;
        f2995 = i2 % 128;
        int i8 = i2 % 2;
        qVar.f3002 = ahVar;
        if (i8 == 0) {
            return ahVar;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ Context m3022(q qVar, Context context) {
        int i2 = f2993;
        f2995 = (i2 + 65) % 128;
        qVar.f3007 = context;
        f2995 = (i2 + 21) % 128;
        return context;
    }

    @Override // com.ironsource.adqualitysdk.sdk.IronSourceAdQuality
    public void changeUserId(String str) {
        String str2;
        boolean z2;
        try {
            if (!m3009(str)) {
                return;
            }
            if (str.equals(m2991().m620())) {
                z2 = false;
            } else {
                f2993 = (f2995 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE) % 128;
                z2 = true;
            }
            boolean zMo2687 = jf.m2685().mo2687();
            if (z2 && zMo2687) {
                int i2 = f2993 + 57;
                f2995 = i2 % 128;
                if (i2 % 2 != 0) {
                    this.f3002.m462();
                    int i8 = 32 / 0;
                } else {
                    this.f3002.m462();
                }
            }
            str2 = str;
            try {
                m3006(this.f3007, str2, z2, true, zMo2687);
                return;
            } catch (Exception e) {
                e = e;
            }
        } catch (Exception e4) {
            e = e4;
            str2 = str;
        }
        kd.m2914(m2998(Color.argb(0, 0, 0, 0) + 12, Color.blue(0) + 74, (char) (34348 - Gravity.getAbsoluteGravity(0, 0))).intern(), a0.d(new StringBuilder(), m2998((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 20, 529 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) ((ViewConfiguration.getKeyRepeatDelay() >> 16) + 9879)), str2), (Throwable) e, true, false, true);
    }

    @Override // com.ironsource.adqualitysdk.sdk.IronSourceAdQuality
    public void initialize(Context context, String str) {
        f2995 = (f2993 + 105) % 128;
        initialize(context, str, null);
        f2993 = (f2995 + 13) % 128;
    }

    @Override // com.ironsource.adqualitysdk.sdk.IronSourceAdQuality
    public void sendCustomMediationRevenue(ISAdQualityCustomMediationRevenue iSAdQualityCustomMediationRevenue) {
        if (!m3031()) {
            if (m2981()) {
                this.f3000.m497(iSAdQualityCustomMediationRevenue);
                return;
            } else {
                k.m2868(m2998(12 - View.resolveSize(0, 0), Drawable.resolveOpacity(0, 0) + 74, (char) (TextUtils.indexOf("", "", 0, 0) + 34348)).intern(), m2998(ExpandableListView.getPackedPositionType(0L) + 73, 1332 - View.combineMeasuredStates(0, 0), (char) KeyEvent.getDeadChar(0, 0)).intern());
                return;
            }
        }
        f2995 = (f2993 + 9) % 128;
        k.m2868(m2998(11 - Process.getGidForName(""), (Process.myPid() >> 22) + 74, (char) ((Process.myPid() >> 22) + 34348)).intern(), m2998(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 68, 1265 - (ViewConfiguration.getScrollBarSize() >> 8), (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 37318)).intern());
        int i2 = f2993 + 75;
        f2995 = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
    }

    @Override // com.ironsource.adqualitysdk.sdk.IronSourceAdQuality
    public void setAdListener(ISAdQualityAdListener iSAdQualityAdListener) {
        f2993 = (f2995 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
        if (!m3031()) {
            this.f3005 = iSAdQualityAdListener;
        } else {
            f2993 = (f2995 + 23) % 128;
            k.m2868(m2998(AndroidCharacter.getMirror('0') - '$', (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 73, (char) (34347 - MotionEvent.axisFromString(""))).intern(), m2998(AndroidCharacter.getMirror('0') + 5, ImageFormat.getBitsPerPixel(0) + 1213, (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16)).intern());
        }
    }

    @Override // com.ironsource.adqualitysdk.sdk.IronSourceAdQuality
    public void setConfig(ISAdQualityConfig iSAdQualityConfig) {
        f2995 = (f2993 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE) % 128;
        if (m3031()) {
            k.m2868(m2998(12 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), TextUtils.indexOf("", "", 0, 0) + 74, (char) (34348 - (ViewConfiguration.getMaximumFlingVelocity() >> 16))).intern(), m2998(48 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), Drawable.resolveOpacity(0, 0) + 1454, (char) (ImageFormat.getBitsPerPixel(0) + 19772)).intern());
            f2995 = (f2993 + 75) % 128;
        } else if (!m2978()) {
            this.f3014 = iSAdQualityConfig;
        } else {
            f2993 = (f2995 + 85) % 128;
            k.m2868(m2998((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 12, 75 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 34347)).intern(), m2998(58 - KeyEvent.getDeadChar(0, 0), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 1501, (char) ((Process.myTid() >> 22) + 64229)).intern());
        }
    }

    @Override // com.ironsource.adqualitysdk.sdk.IronSourceAdQuality
    public void setSegment(final ISAdQualitySegment iSAdQualitySegment) {
        if (!m3031()) {
            p.m2963(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.q.3

                /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
                private static short[] f3020 = null;

                /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
                private static int f3021 = 0;

                /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
                private static int f3022 = 1;

                /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
                private static byte[] f3023 = {-29, 21, 62, -31, -17, 25, -17, 8, -64, 9, -57, -97, -86, -66, 68, -88, 94, -83, -96, 94, -82, 80, 28, -7, 80, 84, 27, -8, 95, 28, -128, 82, -92, 102, -14, 80, 94, -88, 94, -71, 113, -72, 118, -69, 95, 124, -90, 88, -7, 83, 92, -83, 83, 87, -89, 6, -7, 90, -89, 6, -7, 24, -20, 88, 75, 0, 0};

                /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
                private static int f3024 = -21968128;

                /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
                private static int f3025 = -1340352550;

                /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
                private static int f3026 = 58;

                /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
                private static String m3034(int i2, byte b8, int i8, short s7, int i9) {
                    String string;
                    synchronized (n.f2979) {
                        try {
                            StringBuilder sb = new StringBuilder();
                            int i10 = f3026;
                            int i11 = i8 + i10;
                            int i12 = i11 == -1 ? 1 : 0;
                            if (i12 != 0) {
                                byte[] bArr = f3023;
                                i11 = bArr != null ? (byte) (bArr[f3024 + i9] + i10) : (short) (f3020[f3024 + i9] + i10);
                            }
                            if (i11 > 0) {
                                n.f2984 = ((i9 + i11) - 2) + f3024 + i12;
                                n.f2982 = b8;
                                char c7 = (char) (i2 + f3025);
                                n.f2981 = c7;
                                sb.append(c7);
                                n.f2980 = n.f2981;
                                n.f2983 = 1;
                                while (n.f2983 < i11) {
                                    byte[] bArr2 = f3023;
                                    if (bArr2 != null) {
                                        int i13 = n.f2984;
                                        n.f2984 = i13 - 1;
                                        n.f2981 = (char) (n.f2980 + (((byte) (bArr2[i13] + s7)) ^ n.f2982));
                                    } else {
                                        short[] sArr = f3020;
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

                @Override // com.ironsource.adqualitysdk.sdk.i.iu
                /* JADX INFO: renamed from: ﻐ */
                public final void mo306() {
                    if (!q.m2982(q.this)) {
                        k.m2868(m3034(ImageFormat.getBitsPerPixel(0) + 1340352616, (byte) (((byte) KeyEvent.getModifierMetaStateMask()) - 27), ((Process.getThreadPriority(0) + 20) >> 6) - 46, (short) KeyEvent.getDeadChar(0, 0), TextUtils.getOffsetBefore("", 0) + 21968128).intern(), m3034((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 1340352617, (byte) ((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 85), (-3) - (ViewConfiguration.getDoubleTapTimeout() >> 16), (short) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1), 21968139 - ExpandableListView.getPackedPositionGroup(0L)).intern());
                        f3022 = (f3021 + 27) % 128;
                    } else if (q.m2974(q.this) != null) {
                        f3022 = (f3021 + 99) % 128;
                        q.m2974(q.this).m520(iSAdQualitySegment);
                    }
                }
            });
            return;
        }
        f2995 = (f2993 + 23) % 128;
        k.m2868(m2998(13 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), TextUtils.getCapsMode("", 0, 0) + 74, (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 34347)).intern(), m2998(48 - TextUtils.indexOf((CharSequence) "", '0', 0), View.MeasureSpec.makeMeasureSpec(0, 0) + 1405, (char) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 23993)).intern());
        f2995 = (f2993 + 53) % 128;
    }

    @Override // com.ironsource.adqualitysdk.sdk.IronSourceAdQuality
    @Deprecated
    public void setUserConsent(boolean z2) {
        f2993 = (f2995 + 93) % 128;
        m2991().m618(z2);
        int i2 = f2995 + 107;
        f2993 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 58 / 0;
        }
    }

    @Override // com.ironsource.adqualitysdk.sdk.IronSourceAdQuality
    public synchronized void shutdown() {
        f2993 = (f2995 + 109) % 128;
        m3001(false);
        int i2 = f2995 + 27;
        f2993 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
    private synchronized boolean m2978() {
        boolean z2;
        int i2 = f2993;
        z2 = this.f3013;
        f2995 = (i2 + 55) % 128;
        return z2;
    }

    /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
    private void m2979() {
        p.m2967(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.q.2
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                for (ISAdQualityInitListener iSAdQualityInitListener : q.m2975(q.this)) {
                    if (iSAdQualityInitListener != null) {
                        iSAdQualityInitListener.adQualitySdkInitSuccess();
                    }
                }
                q.m2975(q.this).clear();
            }
        });
        int i2 = f2995 + 95;
        f2993 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
    private synchronized boolean m2981() {
        int i2 = f2993;
        boolean z2 = this.f3012;
        int i8 = i2 + 101;
        f2995 = i8 % 128;
        if (i8 % 2 == 0) {
            return z2;
        }
        int i9 = 79 / 0;
        return z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0026 A[PHI: r0
  0x0026: PHI (r0v5 java.util.Map<java.lang.String, java.lang.String>) = (r0v4 java.util.Map<java.lang.String, java.lang.String>), (r0v12 java.util.Map<java.lang.String, java.lang.String>) binds: [B:8:0x0024, B:5:0x0019] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.json.JSONObject m2987() {
        /*
            r8 = this;
            int r0 = com.ironsource.adqualitysdk.sdk.i.q.f2993
            int r0 = r0 + 51
            int r1 = r0 % 128
            com.ironsource.adqualitysdk.sdk.i.q.f2995 = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L1c
            com.ironsource.adqualitysdk.sdk.i.as r0 = r8.m2991()
            java.util.Map r0 = r0.m614()
            r3 = 71
            int r3 = r3 / r2
            if (r0 == 0) goto L81
            goto L26
        L1c:
            com.ironsource.adqualitysdk.sdk.i.as r0 = r8.m2991()
            java.util.Map r0 = r0.m614()
            if (r0 == 0) goto L81
        L26:
            java.lang.String r3 = ""
            int r4 = android.text.TextUtils.getTrimmedLength(r3)
            int r4 = 13 - r4
            int r5 = android.view.Gravity.getAbsoluteGravity(r2, r2)
            int r5 = r5 + 960
            int r6 = android.graphics.Color.alpha(r2)
            int r6 = r6 + 3544
            char r6 = (char) r6
            java.lang.String r4 = m2998(r4, r5, r6)
            java.lang.String r4 = r4.intern()
            boolean r4 = r0.containsKey(r4)
            if (r4 == 0) goto L81
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: org.json.JSONException -> L81
            int r5 = android.view.View.resolveSize(r2, r2)     // Catch: org.json.JSONException -> L81
            int r5 = 13 - r5
            r6 = 48
            int r2 = android.text.TextUtils.indexOf(r3, r6, r2, r2)     // Catch: org.json.JSONException -> L81
            int r2 = 959 - r2
            r6 = 0
            int r3 = android.widget.ExpandableListView.getPackedPositionType(r6)     // Catch: org.json.JSONException -> L81
            int r3 = 3544 - r3
            char r3 = (char) r3     // Catch: org.json.JSONException -> L81
            java.lang.String r2 = m2998(r5, r2, r3)     // Catch: org.json.JSONException -> L81
            java.lang.String r2 = r2.intern()     // Catch: org.json.JSONException -> L81
            java.lang.Object r0 = r0.get(r2)     // Catch: org.json.JSONException -> L81
            java.lang.String r0 = (java.lang.String) r0     // Catch: org.json.JSONException -> L81
            r4.<init>(r0)     // Catch: org.json.JSONException -> L81
            int r0 = com.ironsource.adqualitysdk.sdk.i.q.f2995
            int r0 = r0 + 119
            int r2 = r0 % 128
            com.ironsource.adqualitysdk.sdk.i.q.f2993 = r2
            int r0 = r0 % 2
            if (r0 == 0) goto L80
            return r4
        L80:
            throw r1
        L81:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.q.m2987():org.json.JSONObject");
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private synchronized boolean m2990() {
        int i2 = f2993 + 15;
        f2995 = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
        return this.f3009;
    }

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private synchronized as m2991() {
        as asVar;
        try {
            int i2 = f2995 + 105;
            f2993 = i2 % 128;
            if (i2 % 2 == 0) {
                asVar = this.f3015;
                int i8 = 2 / 0;
            } else {
                asVar = this.f3015;
            }
        } catch (Throwable th) {
            throw th;
        }
        return asVar;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static /* synthetic */ jb m2994(q qVar, jb jbVar) {
        int i2 = f2995 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE;
        f2993 = i2 % 128;
        int i8 = i2 % 2;
        qVar.f3001 = jbVar;
        if (i8 != 0) {
            return jbVar;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ void m3000(q qVar, Context context, String str) {
        f2995 = (f2993 + 65) % 128;
        qVar.m3006(context, str, true, false, true);
        int i2 = f2993 + 25;
        f2995 = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ iy m3003(q qVar) {
        int i2 = f2993;
        f2995 = (i2 + 45) % 128;
        iy iyVar = qVar.f3003;
        int i8 = i2 + 91;
        f2995 = i8 % 128;
        if (i8 % 2 == 0) {
            return iyVar;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ aw m3011(q qVar, aw awVar) {
        int i2 = f2993 + 103;
        f2995 = i2 % 128;
        int i8 = i2 % 2;
        qVar.f3004 = awVar;
        if (i8 != 0) {
            int i9 = 29 / 0;
        }
        return awVar;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ aj m3023(q qVar, aj ajVar) {
        int i2 = f2995 + 107;
        f2993 = i2 % 128;
        int i8 = i2 % 2;
        qVar.f3000 = ajVar;
        if (i8 == 0) {
            int i9 = 59 / 0;
        }
        return ajVar;
    }

    @Override // com.ironsource.adqualitysdk.sdk.IronSourceAdQuality
    public void initialize(Context context, String str, ISAdQualityConfig iSAdQualityConfig) {
        if (context instanceof Application) {
            int i2 = f2993 + 49;
            f2995 = i2 % 128;
            if (i2 % 2 == 0) {
                m3005((Application) context, str, iSAdQualityConfig);
                return;
            } else {
                m3005((Application) context, str, iSAdQualityConfig);
                throw null;
            }
        }
        if (context != null && (context.getApplicationContext() instanceof Application)) {
            m3005((Application) context.getApplicationContext(), str, iSAdQualityConfig);
            return;
        }
        if (!(context instanceof Activity)) {
            String strIntern = m2998((ViewConfiguration.getDoubleTapTimeout() >> 16) + 74, 1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) Color.alpha(0)).intern();
            k.m2868(m2998(12 - (ViewConfiguration.getTouchSlop() >> 8), 75 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) (34348 - Color.red(0))).intern(), strIntern);
            m3020(iSAdQualityConfig.getAdQualityInitListeners(), ISAdQualityInitError.EXCEPTION_ON_INIT, strIntern);
            return;
        }
        int i8 = f2993 + 31;
        f2995 = i8 % 128;
        if (i8 % 2 != 0) {
            m3014((Activity) context, str, iSAdQualityConfig);
            throw null;
        }
        m3014((Activity) context, str, iSAdQualityConfig);
        int i9 = f2993 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE;
        f2995 = i9 % 128;
        if (i9 % 2 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    public final synchronized aw m3029() {
        aw awVar;
        int i2 = f2995;
        int i8 = i2 + 7;
        f2993 = i8 % 128;
        if (i8 % 2 == 0) {
            throw null;
        }
        awVar = this.f3004;
        int i9 = i2 + 27;
        f2993 = i9 % 128;
        if (i9 % 2 == 0) {
            throw null;
        }
        return awVar;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static /* synthetic */ void m2996(q qVar, Context context) {
        int i2 = f2993 + 5;
        f2995 = i2 % 128;
        int i8 = i2 % 2;
        qVar.m2995(context);
        if (i8 != 0) {
            throw null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x002d, code lost:
    
        if (m3031() != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002f, code lost:
    
        com.ironsource.adqualitysdk.sdk.i.k.m2868(m2998(13 - (android.os.SystemClock.uptimeMillis() > 0 ? 1 : (android.os.SystemClock.uptimeMillis() == 0 ? 0 : -1)), 74 - android.graphics.Color.blue(0), (char) (android.widget.ExpandableListView.getPackedPositionType(0) + 34348)).intern(), m2998((android.graphics.PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (android.graphics.PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 36, 342 - android.graphics.Color.argb(0, 0, 0, 0), (char) ((android.view.ViewConfiguration.getTapTimeout() >> 16) + 17070)).intern());
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006e, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0073, code lost:
    
        if (m2981() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0075, code lost:
    
        com.ironsource.adqualitysdk.sdk.i.k.m2868(m2998((android.widget.ExpandableListView.getPackedPositionForGroup(0) > 0 ? 1 : (android.widget.ExpandableListView.getPackedPositionForGroup(0) == 0 ? 0 : -1)) + 12, android.graphics.Color.argb(0, 0, 0, 0) + 74, (char) (34348 - ((android.os.Process.getThreadPriority(0) + 20) >> 6))).intern(), m2998((android.util.TypedValue.complexToFloat(0) > 0.0f ? 1 : (android.util.TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 59, (android.view.ViewConfiguration.getDoubleTapTimeout() >> 16) + 378, (char) (6377 - (android.view.ViewConfiguration.getTouchSlop() >> 8))).intern());
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00bb, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00bc, code lost:
    
        r0 = m2998(28 - (android.view.ViewConfiguration.getKeyRepeatTimeout() >> 16), 437 - android.graphics.Color.argb(0, 0, 0, 0), (char) (981 - android.text.TextUtils.indexOf((java.lang.CharSequence) "", '0'))).intern();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00dd, code lost:
    
        if (r13 == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00df, code lost:
    
        r13 = new java.lang.StringBuilder();
        r13.append(r0);
        r13.append(m2998(android.view.View.MeasureSpec.getMode(0) + 24, (android.os.Process.myTid() >> 22) + 465, (char) (12704 - android.widget.ExpandableListView.getPackedPositionGroup(0))).intern());
        r0 = r13.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x010b, code lost:
    
        r13 = com.ironsource.adqualitysdk.sdk.i.aq.m530().mo561(m2998(6 - android.view.KeyEvent.getDeadChar(0, 0), 488 - android.text.TextUtils.indexOf((java.lang.CharSequence) "", '0', 0), (char) android.text.TextUtils.indexOf("", "")).intern());
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0136, code lost:
    
        if (android.text.TextUtils.isEmpty(r13) != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0138, code lost:
    
        r6 = new java.lang.StringBuilder();
        r6.append(r0);
        r6.append(m2998((android.view.KeyEvent.getMaxKeyCode() >> 16) + 14, (android.view.ViewConfiguration.getMinimumFlingVelocity() >> 16) + 495, (char) (android.view.ViewConfiguration.getTapTimeout() >> 16)).intern());
        r6.append(r13);
        r0 = r6.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0169, code lost:
    
        com.ironsource.adqualitysdk.sdk.i.q.f2993 = (com.ironsource.adqualitysdk.sdk.i.q.f2995 + 83) % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0171, code lost:
    
        com.ironsource.adqualitysdk.sdk.i.k.m2858(m2998(12 - (android.view.ViewConfiguration.getDoubleTapTimeout() >> 16), (android.view.ViewConfiguration.getWindowTouchSlop() >> 8) + 74, (char) (34348 - (android.view.ViewConfiguration.getJumpTapTimeout() >> 16))).intern(), r0);
        m3026(com.ironsource.adqualitysdk.sdk.ISAdQualityInitError.AD_QUALITY_SDK_WAS_SHUTDOWN, r0);
        r12.f3008 = true;
        com.ironsource.adqualitysdk.sdk.i.aq.m530().mo539();
        com.ironsource.adqualitysdk.sdk.i.ij.m2538(r12.f3007).m2544();
        r12.f3004.m705();
        r12.f3003.m2612();
        r12.f3002.m456();
        com.ironsource.adqualitysdk.sdk.i.hu.m2387();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x01c0, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001a, code lost:
    
        if (m3031() != false) goto L20;
     */
    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized void m3001(boolean r13) {
        /*
            Method dump skipped, instruction units count: 522
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.q.m3001(boolean):void");
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ void m3007(q qVar, Context context) {
        f2993 = (f2995 + 49) % 128;
        qVar.m3015(context);
        int i2 = f2993 + 15;
        f2995 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 10 / 0;
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ iy m3012(q qVar, iy iyVar) {
        int i2 = f2993 + 3;
        int i8 = i2 % 128;
        f2995 = i8;
        int i9 = i2 % 2;
        qVar.f3003 = iyVar;
        if (i9 != 0) {
            throw null;
        }
        f2993 = (i8 + 99) % 128;
        return iyVar;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ an m3024(q qVar, an anVar) {
        int i2 = f2993;
        int i8 = i2 + 71;
        f2995 = i8 % 128;
        int i9 = i8 % 2;
        qVar.f2997 = anVar;
        if (i9 != 0) {
            throw null;
        }
        int i10 = i2 + 11;
        f2995 = i10 % 128;
        if (i10 % 2 == 0) {
            return anVar;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private void m3005(Application application, String str, ISAdQualityConfig iSAdQualityConfig) {
        int i2 = f2995 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE;
        f2993 = i2 % 128;
        int i8 = i2 % 2;
        m3004(application, null, str, iSAdQualityConfig);
        if (i8 == 0) {
            int i9 = 43 / 0;
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ void m3017(q qVar, ISAdQualityInitError iSAdQualityInitError, String str) {
        f2995 = (f2993 + 27) % 128;
        qVar.m3026(iSAdQualityInitError, str);
        int i2 = f2995 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE;
        f2993 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ as m3025(q qVar) {
        f2995 = (f2993 + 75) % 128;
        as asVarM2991 = qVar.m2991();
        f2993 = (f2995 + 1) % 128;
        return asVarM2991;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final synchronized ISAdQualityLogLevel m3030() {
        ISAdQualityLogLevel iSAdQualityLogLevel;
        int i2 = (f2993 + 99) % 128;
        f2995 = i2;
        iSAdQualityLogLevel = this.f3011;
        f2993 = (i2 + 83) % 128;
        return iSAdQualityLogLevel;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private synchronized void m2997(boolean z2) {
        try {
            int i2 = f2993;
            int i8 = i2 + 49;
            f2995 = i8 % 128;
            if (i8 % 2 != 0) {
                this.f3012 = false;
            } else {
                this.f3012 = true;
            }
            int i9 = i2 + 111;
            f2995 = i9 % 128;
            if (i9 % 2 != 0) {
                throw null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private void m3004(Application application, Activity activity, String str, @Nullable ISAdQualityConfig iSAdQualityConfig) {
        f2993 = (f2995 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE) % 128;
        String strIntern = m2998(12 - ((Process.getThreadPriority(0) + 20) >> 6), TextUtils.lastIndexOf("", '0', 0) + 75, (char) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 34348)).intern();
        if (iSAdQualityConfig == null) {
            iSAdQualityConfig = new ISAdQualityConfig.Builder().build();
        }
        if (!m3028(iSAdQualityConfig)) {
            f2993 = (f2995 + 17) % 128;
            iSAdQualityConfig = ISAdQualityConfig.merge(this.f3014, iSAdQualityConfig);
        }
        ISAdQualityConfig iSAdQualityConfig2 = iSAdQualityConfig;
        if (m2978()) {
            String strIntern2 = m2998(41 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), 86 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) (Color.alpha(0) + 50572)).intern();
            k.m2858(strIntern, strIntern2);
            m3020(iSAdQualityConfig2.getAdQualityInitListeners(), ISAdQualityInitError.AD_QUALITY_ALREADY_INITIALIZED, strIntern2);
            f2995 = (f2993 + 99) % 128;
            return;
        }
        if (m2981()) {
            String strIntern3 = m2998(Color.green(0) + 59, (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 126, (char) (View.MeasureSpec.makeMeasureSpec(0, 0) + 5964)).intern();
            k.m2858(strIntern, strIntern3);
            m3020(iSAdQualityConfig2.getAdQualityInitListeners(), ISAdQualityInitError.AD_QUALITY_ALREADY_INITIALIZED, strIntern3);
            return;
        }
        if (m3031()) {
            f2993 = (f2995 + 43) % 128;
            String strIntern4 = m2998(48 - (Process.myTid() >> 22), 185 - Color.alpha(0), (char) KeyEvent.normalizeMetaState(0)).intern();
            k.m2868(strIntern, strIntern4);
            m3020(iSAdQualityConfig2.getAdQualityInitListeners(), ISAdQualityInitError.AD_QUALITY_SDK_WAS_SHUTDOWN, strIntern4);
            return;
        }
        if (TextUtils.isEmpty(iSAdQualityConfig2.getUserId()) && iSAdQualityConfig2.isUserIdSet()) {
            String strIntern5 = m2998((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 60, 233 - ((Process.getThreadPriority(0) + 20) >> 6), (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)))).intern();
            k.m2868(strIntern, strIntern5);
            m3020(iSAdQualityConfig2.getAdQualityInitListeners(), ISAdQualityInitError.ILLEGAL_USER_ID, strIntern5);
        } else {
            if (TextUtils.isEmpty(str)) {
                String strIntern6 = m2998(49 - View.MeasureSpec.getMode(0), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 293, (char) Color.green(0)).intern();
                k.m2868(strIntern, strIntern6);
                m3020(iSAdQualityConfig2.getAdQualityInitListeners(), ISAdQualityInitError.ILLEGAL_APP_KEY, strIntern6);
                f2995 = (f2993 + 33) % 128;
                return;
            }
            this.f2998.addAll(iSAdQualityConfig2.getAdQualityInitListeners());
            m3027(true);
            jf.m2685().mo2690(application, activity);
            jd.m2673().m2679();
            jh.m2711().m2715();
            p.m2963(new AnonymousClass5(iSAdQualityConfig2, str, application, activity));
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ void m3018(q qVar, ISAdQualityLogLevel iSAdQualityLogLevel) {
        int i2 = f2995 + 99;
        f2993 = i2 % 128;
        int i8 = i2 % 2;
        qVar.m3016(iSAdQualityLogLevel);
        if (i8 == 0) {
            throw null;
        }
        int i9 = f2993 + 95;
        f2995 = i9 % 128;
        if (i9 % 2 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final synchronized void m3033() {
        if (m3031()) {
            f2993 = (f2995 + 103) % 128;
            k.m2868(m2998(12 - Color.alpha(0), 74 - (ViewConfiguration.getScrollBarSize() >> 8), (char) (ExpandableListView.getPackedPositionGroup(0L) + 34348)).intern(), m2998(ExpandableListView.getPackedPositionChild(0L) + 61, ImageFormat.getBitsPerPixel(0) + IronSourceError.ERROR_RV_LOAD_FAIL_DUE_TO_INIT, (char) ((ViewConfiguration.getLongPressTimeout() >> 16) + 31370)).intern());
        } else if (m2981()) {
            f2993 = (f2995 + 7) % 128;
            k.m2868(m2998(Color.argb(0, 0, 0, 0) + 12, 74 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) (TextUtils.getOffsetBefore("", 0) + 34348)).intern(), m2998(48 - (ViewConfiguration.getJumpTapTimeout() >> 16), (Process.myPid() >> 22) + 1092, (char) Color.blue(0)).intern());
        } else {
            this.f3010 = true;
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private void m2995(Context context) {
        try {
            context.registerReceiver(new BroadcastReceiver() { // from class: com.ironsource.adqualitysdk.sdk.i.q.1
                @Override // android.content.BroadcastReceiver
                public final void onReceive(Context context2, Intent intent) {
                    ju.m2781(intent);
                }
            }, new IntentFilter(m2998(View.getDefaultSize(0, 0) + 37, 1139 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) (Process.myTid() >> 22)).intern()), null, p.m2966());
            int i2 = f2993 + 71;
            f2995 = i2 % 128;
            if (i2 % 2 != 0) {
                throw null;
            }
        } catch (Throwable th) {
            k.m2872(m2998(12 - View.getDefaultSize(0, 0), 74 - TextUtils.getOffsetBefore("", 0), (char) (34348 - (ViewConfiguration.getTapTimeout() >> 16))).intern(), m2998(Process.getGidForName("") + 36, (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 1177, (char) KeyEvent.keyCodeFromString("")).intern(), th);
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ void m3019(q qVar, boolean z2) {
        int i2 = f2993 + 105;
        f2995 = i2 % 128;
        int i8 = i2 % 2;
        qVar.m3008(z2);
        if (i8 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    public static /* synthetic */ ah m2984(q qVar) {
        int i2 = f2995;
        f2993 = (i2 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE) % 128;
        ah ahVar = qVar.f3002;
        f2993 = (i2 + 7) % 128;
        return ahVar;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ boolean m3021(q qVar) {
        f2993 = (f2995 + 95) % 128;
        boolean zM2990 = qVar.m2990();
        f2993 = (f2995 + 45) % 128;
        return zM2990;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static q m3013() {
        synchronized (q.class) {
            try {
                if (f2996 == null) {
                    f2996 = new q();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f2996;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private synchronized void m3027(boolean z2) {
        int i2 = (f2995 + 91) % 128;
        f2993 = i2;
        this.f3013 = z2;
        f2995 = (i2 + 47) % 128;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private void m3014(Activity activity, String str, ISAdQualityConfig iSAdQualityConfig) {
        f2993 = (f2995 + 75) % 128;
        m3004(activity.getApplication(), activity, str, iSAdQualityConfig);
        f2995 = (f2993 + 31) % 128;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private void m3026(ISAdQualityInitError iSAdQualityInitError, String str) {
        f2993 = (f2995 + 75) % 128;
        m3020(this.f2998, iSAdQualityInitError, str);
        int i2 = f2995 + 45;
        f2993 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private void m3015(Context context) {
        f2993 = (f2995 + 29) % 128;
        String strM2637 = this.f3001.m2637(m2998((ViewConfiguration.getTouchSlop() >> 8) + 10, View.MeasureSpec.getSize(0) + 973, (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask()))).intern());
        if (TextUtils.isEmpty(strM2637)) {
            return;
        }
        new jb(context, m2998(25 - Color.alpha(0), 983 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) (41641 - View.MeasureSpec.getMode(0))).intern(), m2998((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 23, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 1007, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1))).intern()).m2640(m2998(TextUtils.lastIndexOf("", '0', 0) + 11, 973 - TextUtils.indexOf("", "", 0), (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)))).intern(), strM2637);
        this.f3001.m2642(m2998(TextUtils.getOffsetAfter("", 0) + 10, (ViewConfiguration.getDoubleTapTimeout() >> 16) + 973, (char) ((-1) - ExpandableListView.getPackedPositionChild(0L))).intern());
        f2993 = (f2995 + 71) % 128;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private boolean m3028(ISAdQualityConfig iSAdQualityConfig) {
        f2993 = (f2995 + 57) % 128;
        if (this.f3014 == null) {
            return true;
        }
        try {
            String str = iSAdQualityConfig.getMetaData().get(m2998(12 - MotionEvent.axisFromString(""), View.resolveSize(0, 0) + 960, (char) (3545 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)))).intern());
            if (!TextUtils.isEmpty(str)) {
                return new JSONObject(str).optBoolean(m2998(View.getDefaultSize(0, 0) + 22, (ViewConfiguration.getKeyRepeatDelay() >> 16) + 1560, (char) Color.alpha(0)).intern());
            }
        } catch (Throwable unused) {
        }
        f2993 = (f2995 + 69) % 128;
        return false;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private synchronized void m3016(ISAdQualityLogLevel iSAdQualityLogLevel) {
        int i2 = f2995;
        this.f3011 = iSAdQualityLogLevel;
        f2993 = (i2 + 85) % 128;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private void m3020(final Set<ISAdQualityInitListener> set, final ISAdQualityInitError iSAdQualityInitError, final String str) {
        p.m2967(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.q.10
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                for (ISAdQualityInitListener iSAdQualityInitListener : set) {
                    if (iSAdQualityInitListener != null) {
                        iSAdQualityInitListener.adQualitySdkInitFailed(iSAdQualityInitError, str);
                    }
                }
                set.clear();
            }
        });
        int i2 = f2995 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE;
        f2993 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final synchronized boolean m3031() {
        boolean z2;
        int i2 = f2993;
        z2 = this.f3008;
        f2995 = (i2 + 33) % 128;
        return z2;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m2998(int i2, int i8, char c7) {
        String str;
        synchronized (c.f1192) {
            try {
                char[] cArr = new char[i2];
                c.f1193 = 0;
                while (true) {
                    int i9 = c.f1193;
                    if (i9 < i2) {
                        cArr[i9] = (char) ((((long) f2992[i8 + i9]) ^ (((long) i9) * f2994)) ^ ((long) c7));
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

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private boolean m3009(String str) {
        if (m3031()) {
            k.m2868(m2998((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 12, 74 - View.resolveSize(0, 0), (char) (TextUtils.getCapsMode("", 0, 0) + 34348)).intern(), m2998(View.combineMeasuredStates(0, 0) + 52, View.MeasureSpec.getMode(0) + 549, (char) ((ViewConfiguration.getTapTimeout() >> 16) + 32222)).intern());
            f2993 = (f2995 + 35) % 128;
            return false;
        }
        if (!m2981()) {
            f2995 = (f2993 + 115) % 128;
            k.m2868(m2998(12 - View.getDefaultSize(0, 0), 74 - ((Process.getThreadPriority(0) + 20) >> 6), (char) ((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 34348)).intern(), m2998((ViewConfiguration.getTapTimeout() >> 16) + 65, TextUtils.indexOf((CharSequence) "", '0') + 602, (char) (62930 - View.resolveSize(0, 0))).intern());
            return false;
        }
        if (!TextUtils.isEmpty(str)) {
            return true;
        }
        f2993 = (f2995 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE) % 128;
        k.m2868(m2998(TextUtils.indexOf("", "", 0) + 12, 74 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (char) (ImageFormat.getBitsPerPixel(0) + 34349)).intern(), m2998((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 34, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + TTAdConstant.STYLE_SIZE_RADIO_2_3, (char) (1605 - (KeyEvent.getMaxKeyCode() >> 16))).intern());
        return false;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private void m3006(Context context, String str, boolean z2, boolean z7, boolean z8) {
        int i2 = f2993 + 35;
        f2995 = i2 % 128;
        if (i2 % 2 == 0) {
            String strM620 = m2991().m620();
            m2991().m627(str);
            if (str == null) {
                f2993 = (f2995 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE) % 128;
                k.m2868(m2998(TextUtils.indexOf("", "", 0) + 12, (ViewConfiguration.getTapTimeout() >> 16) + 74, (char) (KeyEvent.normalizeMetaState(0) + 34348)).intern(), m2998(93 - View.MeasureSpec.getSize(0), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 700, (char) ((-1) - MotionEvent.axisFromString(""))).intern());
            } else if (!str.equals(m2998(18 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), 793 - View.combineMeasuredStates(0, 0), (char) (35189 - Color.argb(0, 0, 0, 0))).intern())) {
                String strIntern = m2998(Color.blue(0) + 12, 74 - TextUtils.indexOf("", "", 0, 0), (char) (34349 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)))).intern();
                StringBuilder sb = new StringBuilder();
                sb.append(m2998(32 - TextUtils.indexOf((CharSequence) "", '0'), 927 - (ViewConfiguration.getTouchSlop() >> 8), (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 39626)).intern());
                sb.append(str);
                k.m2854(strIntern, sb.toString());
            } else {
                String strIntern2 = m2998((ViewConfiguration.getLongPressTimeout() >> 16) + 12, 74 - Gravity.getAbsoluteGravity(0, 0), (char) (34348 - Color.green(0))).intern();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(m2998(View.resolveSize(0, 0) + 40, 810 - Color.argb(0, 0, 0, 0), (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1)).intern());
                sb2.append(str);
                sb2.append(m2998((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 76, (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 850, (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 56603)).intern());
                k.m2868(strIntern2, sb2.toString());
            }
            aq.m530().mo559(new AnonymousClass4(z2, context, z7, strM620, z8));
            JSONObject jSONObjectM2987 = m2987();
            if (jSONObjectM2987 != null) {
                int i8 = f2993 + 27;
                f2995 = i8 % 128;
                if (i8 % 2 == 0) {
                    aq.m530().mo555(jSONObjectM2987);
                    return;
                } else {
                    aq.m530().mo555(jSONObjectM2987);
                    throw null;
                }
            }
            aq.m530().mo558(context, m2991(), true);
            f2995 = (f2993 + 39) % 128;
            return;
        }
        m2991().m620();
        m2991().m627(str);
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final synchronized boolean m3032() {
        int i2 = (f2993 + 51) % 128;
        f2995 = i2;
        boolean z2 = this.f3010;
        int i8 = i2 + 1;
        f2993 = i8 % 128;
        if (i8 % 2 != 0) {
            return z2;
        }
        int i9 = 63 / 0;
        return z2;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private synchronized void m3008(boolean z2) {
        int i2 = (f2995 + 77) % 128;
        f2993 = i2;
        this.f3009 = z2;
        int i8 = i2 + 21;
        f2995 = i8 % 128;
        if (i8 % 2 != 0) {
            int i9 = 52 / 0;
        }
    }
}
