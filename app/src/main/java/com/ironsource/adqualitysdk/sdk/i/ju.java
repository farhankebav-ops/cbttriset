package com.ironsource.adqualitysdk.sdk.i;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.net.TrafficStats;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.vungle.ads.internal.protos.Sdk;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ju {

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static int f2897 = 1;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static int f2898;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static char f2899;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int[] f2900;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static JSONObject f2901;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static char[] f2902;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static JSONObject f2903;

    static {
        m2780();
        f2903 = null;
        f2897 = (f2898 + 31) % 128;
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static synchronized JSONObject m2777() {
        int i2 = f2897 + 45;
        int i8 = i2 % 128;
        f2898 = i8;
        if (i2 % 2 != 0) {
            throw null;
        }
        JSONObject jSONObject = f2901;
        int i9 = i8 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE;
        f2897 = i9 % 128;
        if (i9 % 2 != 0) {
            return jSONObject;
        }
        int i10 = 64 / 0;
        return jSONObject;
    }

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static synchronized JSONObject m2778() {
        try {
            int i2 = f2897 + 57;
            f2898 = i2 % 128;
            if (i2 % 2 != 0) {
                throw null;
            }
            if (f2903 == null) {
                JSONObject jSONObject = new JSONObject();
                f2903 = jSONObject;
                try {
                    jSONObject.put(m2788(1 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (byte) ((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 23), "\u008e").intern(), -1);
                    f2903.put(m2788(-(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (byte) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 59), "£").intern(), -1);
                    f2898 = (f2897 + 77) % 128;
                } catch (JSONException unused) {
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return f2903;
    }

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static JSONObject m2779() {
        JSONObject jSONObjectM2895;
        int i2 = f2898 + 85;
        f2897 = i2 % 128;
        if (i2 % 2 == 0) {
            jSONObjectM2895 = kc.m2895(m2777());
            int i8 = 32 / 0;
        } else {
            jSONObjectM2895 = kc.m2895(m2777());
        }
        f2897 = (f2898 + 99) % 128;
        return jSONObjectM2895;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static void m2780() {
        f2899 = (char) 6;
        f2902 = new char[]{'s', 'i', 'z', 'e', 'w', 'h', 'E', 'r', 'o', ' ', 'n', 'g', 't', 'd', 'M', 'c', 'f', 'm', 'a', 'v', 'y', 'l', 'u', ':', 'p', 'b', 'j', 'x', '{', '|', '}', '~', 127, 128, 129, 130};
        f2900 = new int[]{-987621748, -1321654493, 1422958705, -1068593843, 717159566, 742819251, -884975619, 1614354461, 167101010, -981258228, 810494223, -1393062046, -348849334, 93011835, -861775537, -2135240829, 1821754461, 776952998};
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int m2783() {
        f2897 = (f2898 + 59) % 128;
        int iOptInt = m2797().optInt(m2788((ViewConfiguration.getTapTimeout() >> 16) + 1, (byte) (59 - TextUtils.indexOf("", "", 0)), "£").intern());
        f2897 = (f2898 + 15) % 128;
        return iOptInt;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static String m2787() {
        f2898 = (f2897 + 19) % 128;
        String str = Build.VERSION.RELEASE;
        int i2 = f2897 + 85;
        f2898 = i2 % 128;
        if (i2 % 2 == 0) {
            return str;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int m2794() {
        JSONObject jSONObjectM2797;
        String strM2788;
        int i2 = f2898 + 11;
        f2897 = i2 % 128;
        if (i2 % 2 == 0) {
            jSONObjectM2797 = m2797();
            strM2788 = m2788(1 >> (AudioTrack.getMinVolume() > 2.0f ? 1 : (AudioTrack.getMinVolume() == 2.0f ? 0 : -1)), (byte) (18 << TextUtils.getOffsetAfter("", 0)), "\u008e");
        } else {
            jSONObjectM2797 = m2797();
            strM2788 = m2788((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 1, (byte) (TextUtils.getOffsetAfter("", 0) + 23), "\u008e");
        }
        return jSONObjectM2797.optInt(strM2788.intern());
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static void m2799(JSONObject jSONObject) {
        int i2 = f2898 + 59;
        f2897 = i2 % 128;
        try {
            jSONObject.put(i2 % 2 == 0 ? m2788(5 >> (AudioTrack.getMaxVolume() > 2.0f ? 1 : (AudioTrack.getMaxVolume() == 2.0f ? 0 : -1)), (byte) (70 >>> (TypedValue.complexToFloat(0) > 1.0f ? 1 : (TypedValue.complexToFloat(0) == 1.0f ? 0 : -1))), "\u0001\u0002\u0003\u0004").intern() : m2788(5 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (byte) ((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 55), "\u0001\u0002\u0003\u0004").intern(), m2797());
            int i8 = f2897 + 39;
            f2898 = i8 % 128;
            if (i8 % 2 != 0) {
                int i9 = 45 / 0;
            }
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static void m2781(Intent intent) {
        int intExtra;
        JSONObject jSONObject = new JSONObject();
        if (intent != null) {
            try {
                int intExtra2 = -1;
                jSONObject.put(m2789(new int[]{-1504877089, 2055656838}, ((Process.getThreadPriority(0) + 20) >> 6) + 4).intern(), intent.hasExtra(m2789(new int[]{-1426175675, -2089755528, -1418580371, 1512229099}, Color.alpha(0) + 7).intern()) ? intent.getIntExtra(m2789(new int[]{-1426175675, -2089755528, -1418580371, 1512229099}, (ViewConfiguration.getTapTimeout() >> 16) + 7).intern(), -1) : -1);
                if (intent.hasExtra(m2789(new int[]{256545144, -652770805, -293945302, -1738118186}, Color.rgb(0, 0, 0) + 16777221).intern())) {
                    int i2 = f2897 + 69;
                    f2898 = i2 % 128;
                    intExtra = intent.getIntExtra((i2 % 2 != 0 ? m2789(new int[]{256545144, -652770805, -293945302, -1738118186}, ExpandableListView.getPackedPositionType(0L) + 5) : m2789(new int[]{256545144, -652770805, -293945302, -1738118186}, ExpandableListView.getPackedPositionType(0L) + 5)).intern(), -1);
                } else {
                    intExtra = -1;
                }
                if (intent.hasExtra(m2789(new int[]{604685346, -50345784, 1095393866, -1119901557}, (ViewConfiguration.getDoubleTapTimeout() >> 16) + 5).intern())) {
                    int i8 = f2898 + 23;
                    f2897 = i8 % 128;
                    intExtra2 = intent.getIntExtra((i8 % 2 == 0 ? m2789(new int[]{604685346, -50345784, 1095393866, -1119901557}, 5 >> Color.green(0)) : m2789(new int[]{604685346, -50345784, 1095393866, -1119901557}, 5 - Color.green(0))).intern(), -1);
                }
                jSONObject.put(m2788((ViewConfiguration.getDoubleTapTimeout() >> 16) + 4, (byte) (92 - TextUtils.indexOf((CharSequence) "", '0', 0, 0)), "\u0018\r\u0016\u0014").intern(), Math.round((intExtra * 100.0f) / intExtra2));
            } catch (Throwable th) {
                String strIntern = m2789(new int[]{-528262895, 1951940106, 1096458556, 2054381121, -371264461, 1464597039}, 11 - (ViewConfiguration.getFadingEdgeLength() >> 16)).intern();
                StringBuilder sb = new StringBuilder();
                sb.append(m2788(37 - Color.argb(0, 0, 0, 0), (byte) ((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 70), "\u0007\b\b\t\b\n\u0013\f\u0013\u0007\u000b\u0006\u0007\u001b\u0018\u0012\u000f\u0000\b\u0013\u000f\u001b\u0001\u0015\t\u001b\u0003\u0006\u000e\u0006\b\u001b\u0002\u0006\u000b\u0016f").intern());
                sb.append(th.getLocalizedMessage());
                k.m2863(strIntern, sb.toString());
            }
        }
        m2782(jSONObject);
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static synchronized void m2791(Activity activity) {
        if (activity != null) {
            try {
                int i2 = f2898 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE;
                f2897 = i2 % 128;
                if (i2 % 2 == 0) {
                    m2795(activity.getApplicationContext());
                    throw null;
                }
                m2795(activity.getApplicationContext());
                f2897 = (f2898 + 1) % 128;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static void m2790(int i2, int i8) {
        int i9 = f2898 + 101;
        int i10 = i9 % 128;
        f2897 = i10;
        try {
            if (i9 % 2 == 0) {
                throw null;
            }
            if (i2 > 0) {
                f2898 = (i10 + 21) % 128;
                if (i8 > 0) {
                    f2898 = (i10 + 1) % 128;
                    JSONObject jSONObjectM2778 = m2778();
                    jSONObjectM2778.put(m2788((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 1, (byte) (23 - (ViewConfiguration.getKeyRepeatTimeout() >> 16)), "\u008e").intern(), i8);
                    jSONObjectM2778.put(m2788((ViewConfiguration.getKeyRepeatDelay() >> 16) + 1, (byte) (58 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))), "£").intern(), i2);
                }
            }
        } catch (Throwable th) {
            k.m2861(m2789(new int[]{-528262895, 1951940106, 1096458556, 2054381121, -371264461, 1464597039}, 10 - ImageFormat.getBitsPerPixel(0)).intern(), m2788(25 - View.MeasureSpec.getSize(0), (byte) (View.combineMeasuredStates(0, 0) + 10), "\u0007\b\b\t\b\n\u0001\u0004~~\u0004\u0007\u0006\n\u0003\f\t\u0001\u0004\t\u0006\u0003\u0002\u0003o").intern(), th);
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static void m2786(DisplayMetrics displayMetrics) {
        int i2 = (f2897 + 21) % 128;
        f2898 = i2;
        if (displayMetrics != null) {
            f2897 = (i2 + 111) % 128;
            m2790(displayMetrics.heightPixels, displayMetrics.widthPixels);
            f2898 = (f2897 + 113) % 128;
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static boolean m2800(int i2, int i8) {
        if (i2 < 0) {
            return false;
        }
        f2897 = (f2898 + 49) % 128;
        if (i8 < 0 || i2 > m2794() || i8 > m2783()) {
            return false;
        }
        f2898 = (f2897 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
        return true;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static void m2784(Context context, JSONObject jSONObject) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(m2788(TextUtils.indexOf("", "", 0, 0) + 8, (byte) ((ViewConfiguration.getFadingEdgeLength() >> 16) + 57), "\u0015\f\r\u0000\u0019\u0007\u000e\u0012").intern());
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            jSONObject.put(m2788((ViewConfiguration.getTapTimeout() >> 16) + 4, (byte) (114 - TextUtils.indexOf((CharSequence) "", '0', 0, 0)), "àà\u0013\u0014").intern(), memoryInfo.availMem / 1048576);
            jSONObject.put(m2789(new int[]{-1219946967, 216088382}, Drawable.resolveOpacity(0, 0) + 4).intern(), memoryInfo.threshold / 1048576);
            if (memoryInfo.lowMemory) {
                f2898 = (f2897 + 111) % 128;
                jSONObject.put(m2788(5 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (byte) (85 - View.MeasureSpec.getSize(0)), "ÂÂ\u0016\u0003").intern(), memoryInfo.lowMemory);
            }
            f2898 = (f2897 + 79) % 128;
            jSONObject.put(m2789(new int[]{171668047, 2089572700}, 4 - TextUtils.indexOf("", "", 0)).intern(), memoryInfo.totalMem / 1048576);
            f2897 = (f2898 + 81) % 128;
        } catch (Throwable th) {
            String strIntern = m2789(new int[]{-528262895, 1951940106, 1096458556, 2054381121, -371264461, 1464597039}, 12 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))).intern();
            StringBuilder sb = new StringBuilder();
            sb.append(m2788(28 - Color.argb(0, 0, 0, 0), (byte) (MotionEvent.axisFromString("") + 35), "\u0007\b\b\t\b\n\t\u0005\u0096\u0096\u0004\u0007\u0006\n\u000f\u0005\u000e\u000b\b\u0013\n\u0015\u0006\u0018\t\u0005\u0015\u000b").intern());
            sb.append(th.getLocalizedMessage());
            k.m2863(strIntern, sb.toString());
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static JSONObject m2797() {
        f2897 = (f2898 + 3) % 128;
        JSONObject jSONObjectM2895 = kc.m2895(m2778());
        int i2 = f2897 + 67;
        f2898 = i2 % 128;
        if (i2 % 2 == 0) {
            return jSONObjectM2895;
        }
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005d A[Catch: all -> 0x0085, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:5:0x0005, B:9:0x0037, B:21:0x005d, B:32:0x0087, B:39:0x00cc, B:7:0x001b, B:11:0x0043, B:34:0x0090, B:16:0x004d, B:35:0x00be, B:37:0x00c4), top: B:46:0x0005, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0087 A[Catch: all -> 0x0085, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:5:0x0005, B:9:0x0037, B:21:0x005d, B:32:0x0087, B:39:0x00cc, B:7:0x001b, B:11:0x0043, B:34:0x0090, B:16:0x004d, B:35:0x00be, B:37:0x00c4), top: B:46:0x0005, inners: #2 }] */
    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static synchronized void m2795(android.content.Context r8) {
        /*
            Method dump skipped, instruction units count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.ju.m2795(android.content.Context):void");
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static void m2798(Application application) {
        if (application != null) {
            f2898 = (f2897 + 113) % 128;
            m2795(application.getApplicationContext());
        }
        int i2 = f2897 + 21;
        f2898 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 59 / 0;
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static void m2793(JSONObject jSONObject) {
        f2897 = (f2898 + 89) % 128;
        try {
            long totalRxBytes = TrafficStats.getTotalRxBytes();
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            if (totalRxBytes != -1) {
                f2898 = (f2897 + 67) % 128;
                long totalRxBytes2 = TrafficStats.getTotalRxBytes();
                jSONObject.put(m2788(5 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (byte) (47 - KeyEvent.getDeadChar(0, 0)), "\u0010\n\u0006\u001e").intern(), Math.round((1000.0f / (jCurrentTimeMillis2 - jCurrentTimeMillis)) * (totalRxBytes2 - totalRxBytes)));
                jSONObject.put(m2789(new int[]{-215172321, 1427044895}, 4 - View.getDefaultSize(0, 0)).intern(), totalRxBytes2);
            }
        } catch (Throwable th) {
            k.m2861(m2789(new int[]{-528262895, 1951940106, 1096458556, 2054381121, -371264461, 1464597039}, View.MeasureSpec.getSize(0) + 11).intern(), m2789(new int[]{-1705886056, -1826727591, 797589685, -1286166327, 1858797760, -720480958, -17045760, 936675378, -1408998319, -617168103, 1426189348, -903785397, 2069931413, 765069197, 801103822, -1748127208, -186604150, 832934262}, (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 35).intern(), th);
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static synchronized void m2782(JSONObject jSONObject) {
        try {
            int i2 = f2898;
            int i8 = i2 + 47;
            f2897 = i8 % 128;
            if (i8 % 2 == 0) {
                f2901 = jSONObject;
                throw null;
            }
            f2901 = jSONObject;
            int i9 = i2 + 67;
            f2897 = i9 % 128;
            if (i9 % 2 == 0) {
                throw null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x018d A[Catch: all -> 0x007e, TRY_LEAVE, TryCatch #0 {all -> 0x007e, blocks: (B:3:0x000a, B:8:0x0059, B:15:0x00a5, B:17:0x018d, B:13:0x0081), top: B:22:0x000a }] */
    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m2785(android.content.Context r12, org.json.JSONObject r13, boolean r14) {
        /*
            Method dump skipped, instruction units count: 584
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.ju.m2785(android.content.Context, org.json.JSONObject, boolean):void");
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static void m2792(Context context, JSONObject jSONObject) {
        try {
            if (jx.m2815(context, m2789(new int[]{-2094081576, -483160789, 1456718699, -2056085882, 1557831852, 1026620856, 1101397770, -395056499, 543834413, -1747525398, -2057207892, -624301966, -1128406630, 289766243, 1975690035, 1401415066, 238754085, -662664844}, 36 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))).intern())) {
                f2897 = (f2898 + 43) % 128;
                WifiInfo connectionInfo = ((WifiManager) context.getSystemService(m2789(new int[]{1127874453, -568621529}, 5 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))).intern())).getConnectionInfo();
                jSONObject.put(m2788((Process.myPid() >> 22) + 4, (byte) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 96), "\n\u0016\u0006\u0012").intern(), connectionInfo.getSupplicantState());
                if (connectionInfo.getSupplicantState() == SupplicantState.COMPLETED) {
                    jSONObject.put(m2788((ViewConfiguration.getFadingEdgeLength() >> 16) + 4, (byte) (122 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))), "\n\u0016\u0006\u0001").intern(), connectionInfo.getRssi());
                    jSONObject.put(m2788(3 - TextUtils.lastIndexOf("", '0', 0), (byte) (22 - (Process.myPid() >> 22)), "\n\u0016\u0006\u001e").intern(), connectionInfo.getLinkSpeed());
                    f2897 = (f2898 + 51) % 128;
                }
            }
        } catch (Throwable th) {
            k.m2861(m2789(new int[]{-528262895, 1951940106, 1096458556, 2054381121, -371264461, 1464597039}, 11 - Color.green(0)).intern(), m2788(ExpandableListView.getPackedPositionType(0L) + 31, (byte) (33 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), "\u0007\b\b\t\b\n\u0013\f\u0013\u0007\u000b\u0006\n\u0003\u0004\r\u0003\u0007\u0004\u0007\u000e\n\u0006\u000f\t\n\u0001\u0015\u0004\t\u0094").intern(), th);
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static void m2796(JSONObject jSONObject) {
        f2897 = (f2898 + 47) % 128;
        JSONObject jSONObjectM2779 = m2779();
        if (jSONObjectM2779 != null) {
            f2897 = (f2898 + 113) % 128;
            kc.m2910(jSONObject, jSONObjectM2779);
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m2788(int i2, byte b8, String str) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (h.f2264) {
            try {
                char[] cArr2 = f2902;
                char c7 = f2899;
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

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m2789(int[] iArr, int i2) {
        String str;
        synchronized (d.f1664) {
            try {
                char[] cArr = new char[4];
                char[] cArr2 = new char[iArr.length << 1];
                int[] iArr2 = (int[]) f2900.clone();
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
