package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.vungle.ads.internal.protos.Sdk;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class kd {

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f2957 = 0;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f2958 = 1;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static WeakReference<bb> f2959;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static char[] f2960 = {56106, 14784, 7820, 29550, 20523, 46837, 35807, 59609, 'T', 58041, 50679, 43010, 35657, 28053, 20643, 13294, 5683, 63769, 26250, ' ', 58083, 50677, 43022, 35656, 28050, 20706, 55269, 'E', 58041, 50660, 43022, 35678, 28119, 20661, 13284, 5676, 63819, 56270, ' ', 58018, 50680, 43029, 35657, 28048, 20656, 13292, 5676, 63818, 56193, 48855, 41386, 320};

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static long f2956 = 2265687379156984523L;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static void m2914(String str, String str2, Throwable th, boolean z2, boolean z7, boolean z8) {
        int i2 = f2957 + 55;
        f2958 = i2 % 128;
        try {
            if (i2 % 2 == 0) {
                throw null;
            }
            if (z2) {
                k.m2856(str, str2, z8);
                if (th != null) {
                    k.m2873(str, m2912((char) (56174 - Color.green(0)), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 8, ViewConfiguration.getKeyRepeatTimeout() >> 16).intern(), th, z8);
                }
            } else {
                k.m2873(str, str2, th, z8);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(m2912((char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), 11 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), 8 - TextUtils.getCapsMode("", 0, 0)).intern());
            sb.append(str);
            m2923(str, str2, sb.toString(), th, null, false, z7, z8);
            f2957 = (f2958 + 53) % 128;
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static void m2916(String str, String str2, String str3, Throwable th) {
        int i2 = f2957 + 27;
        f2958 = i2 % 128;
        int i8 = i2 % 2;
        try {
            m2918(str, str2, str3, th, false);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static Throwable m2917(Throwable th) {
        while (th.getCause() != null) {
            int i2 = f2957 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE;
            f2958 = i2 % 128;
            if (i2 % 2 == 0) {
                th.getCause();
                throw null;
            }
            th = th.getCause();
        }
        return th;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static void m2919(String str, String str2, Throwable th, boolean z2) {
        int i2 = f2958 + 73;
        f2957 = i2 % 128;
        int i8 = i2 % 2;
        try {
            m2920(str, str2, th, z2, false);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static void m2921(bb bbVar) {
        f2959 = new WeakReference<>(bbVar);
        int i2 = f2957 + 59;
        f2958 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static void m2915(String str, String str2, String str3, String str4) {
        int i2 = f2957 + 89;
        f2958 = i2 % 128;
        try {
            if (i2 % 2 == 0) {
                m2922(str, str2, str3, str4);
                throw null;
            }
            m2922(str, str2, str3, str4);
            f2958 = (f2957 + 67) % 128;
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static void m2920(String str, String str2, Throwable th, boolean z2, boolean z7) {
        int i2 = f2958 + 113;
        f2957 = i2 % 128;
        try {
            if (i2 % 2 != 0) {
                m2914(str, str2, th, z2, z7, false);
            } else {
                m2914(str, str2, th, z2, z7, false);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static void m2923(String str, String str2, String str3, Throwable th, JSONObject jSONObject, boolean z2, boolean z7, boolean z8) {
        String str4;
        if (z2) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(str3);
                sb.append(m2912((char) ((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 26288), -TextUtils.indexOf((CharSequence) "", '0', 0, 0), (-16777198) - Color.rgb(0, 0, 0)).intern());
                sb.append(str);
                String string = sb.toString();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str2);
                sb2.append(m2912((char) (Process.getGidForName("") + 1), 7 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 19).intern());
                sb2.append(string);
                sb2.append(m2912((char) ((ViewConfiguration.getScrollBarSize() >> 8) + 55244), 1 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 26).intern());
                k.m2873(str, sb2.toString(), th, z8);
                f2958 = (f2957 + 35) % 128;
                str4 = string;
            } catch (Throwable unused) {
                return;
            }
        } else {
            str4 = str3;
        }
        bb bbVar = f2959.get();
        if (bbVar != null) {
            int i2 = f2957 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE;
            f2958 = i2 % 128;
            if (i2 % 2 != 0) {
                bbVar.m856(str, str2, str4, Log.getStackTraceString(th), jSONObject, z7);
            } else {
                bbVar.m856(str, str2, str4, Log.getStackTraceString(th), jSONObject, z7);
                throw null;
            }
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static void m2918(String str, String str2, String str3, Throwable th, boolean z2) {
        int i2 = f2958 + 5;
        f2957 = i2 % 128;
        try {
            if (i2 % 2 != 0) {
                m2923(str, str2, str3, th, null, true, true, false);
            } else {
                m2923(str, str2, str3, th, null, false, false, false);
            }
            int i8 = f2957 + 1;
            f2958 = i8 % 128;
            if (i8 % 2 == 0) {
                throw null;
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static void m2913(String str, String str2, String str3, Throwable th, JSONObject jSONObject, boolean z2) {
        f2957 = (f2958 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE) % 128;
        try {
            m2923(str, str2, str3, th, jSONObject, true, false, z2);
            int i2 = f2957 + 19;
            f2958 = i2 % 128;
            if (i2 % 2 == 0) {
                throw null;
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m2912(char c7, int i2, int i8) {
        String str;
        synchronized (c.f1192) {
            try {
                char[] cArr = new char[i2];
                c.f1193 = 0;
                while (true) {
                    int i9 = c.f1193;
                    if (i9 < i2) {
                        cArr[i9] = (char) ((((long) f2960[i8 + i9]) ^ (((long) i9) * f2956)) ^ ((long) c7));
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

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static void m2922(String str, String str2, String str3, String str4) {
        String string = "";
        int i2 = f2958 + 93;
        f2957 = i2 % 128;
        try {
            if (i2 % 2 != 0) {
                int i8 = 44 / 0;
                if (TextUtils.isEmpty(str3)) {
                    return;
                }
            } else if (TextUtils.isEmpty(str3)) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            sb.append(m2912((char) (26288 - View.MeasureSpec.makeMeasureSpec(0, 0)), 1 - (ViewConfiguration.getEdgeSlop() >> 16), Drawable.resolveOpacity(0, 0) + 18).intern());
            sb.append(str);
            String string2 = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(m2912((char) Color.green(0), TextUtils.indexOf((CharSequence) "", '0') + 12, ExpandableListView.getPackedPositionGroup(0L) + 27).intern());
            sb2.append(string2);
            sb2.append(m2912((char) (ViewConfiguration.getTapTimeout() >> 16), 13 - (Process.myPid() >> 22), 38 - ((Process.getThreadPriority(0) + 20) >> 6)).intern());
            k.m2856(str, sb2.toString(), false);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str2);
            if (str4 != null) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(m2912((char) (TextUtils.getOffsetBefore("", 0) + 330), 1 - (ViewConfiguration.getScrollDefaultDelay() >> 16), Color.alpha(0) + 51).intern());
                sb4.append(str4);
                string = sb4.toString();
            }
            sb3.append(string);
            k.m2856(str, sb3.toString(), false);
            bb bbVar = f2959.get();
            if (bbVar != null) {
                f2958 = (f2957 + 57) % 128;
                bbVar.m851(str, str2, string2, str4);
            }
        } catch (Throwable unused) {
        }
    }
}
