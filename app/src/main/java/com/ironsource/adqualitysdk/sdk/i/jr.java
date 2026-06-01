package com.ironsource.adqualitysdk.sdk.i;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.ironsource.G5;
import com.ironsource.adqualitysdk.sdk.IronSourceAdQuality;
import com.vungle.ads.internal.protos.Sdk;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class jr {

    /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
    private static int f2872 = 1;

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static int f2873;

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static short[] f2874;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private Context f2880;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private as f2881;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private long f2882;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static char[] f2878 = {'0', 'h', 'p', ']', 'X', 'o', 204, 205, 195, 189, 150, 300, 301, 293, 287, ':', 'o', 'f', 's', 240, G5.T, 'w', '8', 'r', 's', 'k', ']', 140, '6', 'h', 'd', 'i', 'n', '0', 'g', 'i', 'k', 'p', 'l', 'f', '7', 'q', 't', 'D', 147, 154, 154, 'E', 145, 153, 147, 146, 153, 131, '|', 143, 143, 145, 143, 144, 151, 150, 127, 'x', 128, 137, 145, 140, 144, 148, 156, 139};

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static int f2879 = 1583583816;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static int f2875 = 61;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static int f2876 = 1556979606;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static byte[] f2877 = {-57, -46, 60, -38, -58, -16, -2, -49, -107, 107, 101, -103, -119, -102, 99, 105, -97, -107, 108, -53, 126, -122, -116, 119, -106, 112, 121, -48, 124, -116, -123, -116, 100, -124, 116, -118, -123, 97, -126, -116, -57, 120, -104, 111, -25, -50, -63, 39, -39, -115, 121, 51, -100, 122, 55, 52, -63, -126, 119, 37, -37, 53, -116, 119, 37, -57, 48, -123, 113, 49, -51, -51, -56, -53, -119, 102, -53, 53, -56, -27};

    public jr(Context context, as asVar, long j) {
        this.f2880 = context;
        this.f2881 = asVar;
        this.f2882 = j;
        new gn(context);
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m2761(int i2, short s7, int i8, byte b8, int i9) {
        String string;
        synchronized (n.f2979) {
            try {
                StringBuilder sb = new StringBuilder();
                int i10 = f2875;
                int i11 = i2 + i10;
                int i12 = i11 == -1 ? 1 : 0;
                if (i12 != 0) {
                    byte[] bArr = f2877;
                    i11 = bArr != null ? (byte) (bArr[f2879 + i8] + i10) : (short) (f2874[f2879 + i8] + i10);
                }
                if (i11 > 0) {
                    n.f2984 = ((i8 + i11) - 2) + f2879 + i12;
                    n.f2982 = b8;
                    char c7 = (char) (i9 + f2876);
                    n.f2981 = c7;
                    sb.append(c7);
                    n.f2980 = n.f2981;
                    n.f2983 = 1;
                    while (n.f2983 < i11) {
                        byte[] bArr2 = f2877;
                        if (bArr2 != null) {
                            int i13 = n.f2984;
                            n.f2984 = i13 - 1;
                            n.f2981 = (char) (n.f2980 + (((byte) (bArr2[i13] + s7)) ^ n.f2982));
                        } else {
                            short[] sArr = f2874;
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

    /* JADX INFO: renamed from: ﾇ */
    public JSONObject mo392(JSONObject jSONObject, boolean z2, boolean z7, boolean z8) throws JSONException {
        int i2 = f2873 + 97;
        f2872 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
        JSONObject jSONObjectM2895 = kc.m2895(jSONObject == null ? new JSONObject() : jSONObject);
        jSONObjectM2895.put(m2762("\u0001\u0001\u0000\u0001\u0000\u0000", false, new int[]{0, 6, 0, 0}).intern(), this.f2881.m624());
        String strM622 = this.f2881.m622();
        if (!TextUtils.isEmpty(strM622)) {
            jSONObjectM2895.put(m2762(null, true, new int[]{6, 4, 90, 3}).intern(), strM622);
        }
        if (z7) {
            int i8 = f2873 + 19;
            f2872 = i8 % 128;
            if (i8 % 2 != 0 ? this.f2882 > 0 : this.f2882 > 1) {
                jSONObjectM2895.put(m2761((-61) - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (short) ExpandableListView.getPackedPositionGroup(0L), (-1583583815) - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (byte) (46 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))), (ViewConfiguration.getPressedStateDuration() >> 16) - 1556979498).intern(), this.f2882);
                f2873 = (f2872 + 47) % 128;
            }
            jSONObjectM2895.put(m2762("\u0000\u0001\u0000\u0001\u0000", false, new int[]{10, 5, 189, 4}).intern(), this.f2881.m619());
            jSONObjectM2895.put(m2761((-62) - (KeyEvent.getMaxKeyCode() >> 16), (short) (AndroidCharacter.getMirror('0') - '0'), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1583583813, (byte) ((-5) - Drawable.resolveOpacity(0, 0)), (-1556979506) - View.combineMeasuredStates(0, 0)).intern(), this.f2881.m613());
            jSONObjectM2895.put(m2762("\u0001\u0000\u0001", false, new int[]{15, 3, 0, 0}).intern(), this.f2881.m620());
            jSONObjectM2895.put(m2762("\u0001\u0000", true, new int[]{18, 2, Sdk.SDKError.Reason.OMSDK_DOWNLOAD_JS_ERROR_VALUE, 0}).intern(), this.f2881.m628());
            jSONObjectM2895.put(m2762("\u0000\u0000", false, new int[]{20, 2, 0, 1}).intern(), ((double) Calendar.getInstance().getTimeZone().getRawOffset()) / 3600000.0d);
            jSONObjectM2895.put(m2762("\u0000\u0000\u0000\u0001\u0001", true, new int[]{22, 5, 0, 2}).intern(), IronSourceAdQuality.getSDKVersion());
            jSONObjectM2895.put(m2762("\u0001", false, new int[]{27, 1, 165, 0}).intern(), jx.m2813());
            jSONObjectM2895.put(m2762("\u0000\u0001\u0001\u0001\u0000", true, new int[]{28, 5, 0, 0}).intern(), Build.MODEL);
            jSONObjectM2895.put(m2761((-62) - (ViewConfiguration.getKeyRepeatDelay() >> 16), (short) (ViewConfiguration.getKeyRepeatTimeout() >> 16), (-1583583809) - (ViewConfiguration.getDoubleTapTimeout() >> 16), (byte) ((-104) - (ViewConfiguration.getTouchSlop() >> 8)), (-1556979497) - Color.argb(0, 0, 0, 0)).intern(), Build.MANUFACTURER);
            jSONObjectM2895.put(m2761((-62) - (ViewConfiguration.getDoubleTapTimeout() >> 16), (short) Color.red(0), (-1583583796) - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (byte) ((-124) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)), (-1556979494) - Color.green(0)).intern(), m2762("\u0001\u0001\u0000\u0000\u0001\u0000\u0001", false, new int[]{33, 7, 0, 0}).intern());
            jSONObjectM2895.put(m2762("\u0001\u0000\u0001", false, new int[]{40, 3, 0, 0}).intern(), ju.m2787());
            jx.m2812(this.f2880, jSONObjectM2895);
            ju.m2792(this.f2880, jSONObjectM2895);
            ju.m2785(this.f2880, jSONObjectM2895, z8);
            ju.m2796(jSONObjectM2895);
            ju.m2793(jSONObjectM2895);
            jSONObjectM2895.put(m2762("\u0001\u0001\u0000\u0001", false, new int[]{43, 4, 40, 2}).intern(), z2);
            ju.m2784(this.f2880, jSONObjectM2895);
            ju.m2799(jSONObjectM2895);
            try {
                JSONObject jSONObject2 = new JSONObject(this.f2881.m614());
                jSONObject2.remove(m2761(TextUtils.indexOf("", "", 0, 0) - 62, (short) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), (-1583583789) - View.MeasureSpec.makeMeasureSpec(0, 0), (byte) ((-113) - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)), (ViewConfiguration.getTouchSlop() >> 8) - 1556979509).intern());
                if (jSONObject2.length() > 0) {
                    f2872 = (f2873 + 55) % 128;
                    jSONObjectM2895.putOpt(m2761((ViewConfiguration.getScrollBarSize() >> 8) - 62, (short) (Color.rgb(0, 0, 0) + 16777216), (-1583583776) - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (byte) (TextUtils.getOffsetAfter("", 0) + 104), (-1556979497) - ((Process.getThreadPriority(0) + 20) >> 6)).intern(), jSONObject2);
                }
                return jSONObjectM2895;
            } catch (Exception e) {
                k.m2861(m2762("\u0001\u0000\u0000\u0000\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0001", false, new int[]{47, 25, 38, 15}).intern(), m2761(TextUtils.indexOf((CharSequence) "", '0', 0) - 61, (short) (TextUtils.lastIndexOf("", '0', 0) + 1), (-1583583772) - (ViewConfiguration.getScrollBarSize() >> 8), (byte) (TextUtils.lastIndexOf("", '0', 0, 0) - 55), Color.green(0) - 1556979537).intern(), (Throwable) e);
            }
        }
        return jSONObjectM2895;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final as m2763() {
        int i2 = f2872;
        as asVar = this.f2881;
        int i8 = i2 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE;
        f2873 = i8 % 128;
        if (i8 % 2 == 0) {
            return asVar;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m2762(String str, boolean z2, int[] iArr) throws UnsupportedEncodingException {
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
                System.arraycopy(f2878, i2, cArr, 0, i8);
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
}
