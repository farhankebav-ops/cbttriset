package com.ironsource.adqualitysdk.sdk.i;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class jx {

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static int f2913 = 0;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static int f2915 = 1;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static boolean f2916 = true;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static boolean f2918 = true;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f2919 = 119;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static char[] f2917 = {231, 229, 237, 151, 164, 220, 233, 230, 177, 186, 236, 227, 219, 158, 235, 216, 228, 224, 221, 225, 234, 165};

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static char f2914 = 6;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static char[] f2920 = {'A', 'p', 'U', 't', 'i', 'l', 's', 'C', 'o', 'u', 'd', 'n', '\'', ' ', 'a', 'b', 'e', 'I', 'f', 'j', 'c', 'r', 'k', 'g', 'm', '.', ':', 'v', 'y', '3', 'P', 'q', 'S', 'T', 'E', 'x'};

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m2810(String str, int i2, int[] iArr, String str2) throws UnsupportedEncodingException {
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
                char[] cArr2 = f2917;
                int i8 = f2919;
                if (f2916) {
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
                if (f2918) {
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

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static void m2812(Context context, JSONObject jSONObject) {
        long j;
        f2915 = (f2913 + 47) % 128;
        String strIntern = m2814(KeyEvent.getDeadChar(0, 0) + 8, (byte) (3 - (ViewConfiguration.getJumpTapTimeout() >> 16)), "\u0001\u0002\u0002\u0003\u0004\u0005\u0000\u000b").intern();
        String packageName = context.getPackageName();
        try {
            jSONObject.put(m2810(null, 128 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), null, "\u0082\u0081").intern(), packageName);
        } catch (JSONException e) {
            k.m2861(strIntern, m2814(34 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (byte) (115 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))), "\b\t\u000b\u0003\u000b\u0006\u000f\u0000\u000e\u000fØØ\u000e\u0010\n\u0006\u000b\u0004\u0011\f\u0007\u0010\u0005\n\u0014\u0006\u000f\u0001\u0007\u000e\u0012\u0007\t\u0006").intern(), (Throwable) e);
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            jSONObject.put(m2814(1 - MotionEvent.axisFromString(""), (byte) ((ViewConfiguration.getKeyRepeatDelay() >> 16) + 25), "\u0015\u0013").intern(), packageManager.getInstallerPackageName(packageName));
            f2913 = (f2915 + 9) % 128;
        } catch (JSONException e4) {
            StringBuilder sb = new StringBuilder();
            sb.append(m2814((ViewConfiguration.getKeyRepeatDelay() >> 16) + 52, (byte) (84 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)), "\b\t\u000b\u0003\u000b\u0006\u000f\u0000\u000e\u000f¸¸\u0010\u0001\u0006\u0007\u0002\u000fÀÀ\u000f\u0016\u0013\u0007\u0014\u001a\u0014\u0010\u0016\u0011\u0011\u0007\f\u001a\u0011\u000e\u0002\t\u0013\u0019\u0007\t\u0007\u001d\u000e\u0011ÆÆ\t\u0014\u0019\u000e").intern());
            sb.append(e4.getLocalizedMessage());
            k.m2852(strIntern, sb.toString());
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            jSONObject.put(m2814(Color.alpha(0) + 2, (byte) (83 - TextUtils.indexOf((CharSequence) "", '0', 0, 0)), "\u001a\u0015").intern(), Integer.toString(packageInfo.versionCode));
            jSONObject.put(m2810(null, AndroidCharacter.getMirror('0') + 'O', null, "\u0082\u0083").intern(), packageInfo.versionName);
            j = 0;
        } catch (PackageManager.NameNotFoundException e8) {
            j = 0;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(m2814(TextUtils.indexOf((CharSequence) "", '0', 0) + 34, (byte) (TextUtils.getCapsMode("", 0, 0) + 83), "\b\t\u000b\u0003\u000b\u0006\u000f\u0000\u0011\u0013\u000f\u0004\u0013\u0007\u0014\u001a\u0014\u0010\u0016\u0011\f\u0019\u0011\b\u0011\u0014\u000f\u0016\f\u0013\t\u0014s").intern());
            sb2.append(packageName);
            sb2.append(m2810(null, ((byte) KeyEvent.getModifierMetaStateMask()) + 128, null, "\u0084\u0089\u0087\u0088\u0087\u0087\u0086\u0084\u0085\u0084").intern());
            sb2.append(e8.getLocalizedMessage());
            k.m2852(strIntern, sb2.toString());
        } catch (JSONException e9) {
            StringBuilder sb3 = new StringBuilder();
            j = 0;
            sb3.append(m2814((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 46, (byte) (73 - (ViewConfiguration.getFadingEdgeLength() >> 16)), "\b\t\u000b\u0003\u000b\u0006\u000f\u0000\u000e\u000f\u00ad\u00ad\u000e\u000f¹¹\u000f\u0019\u000f\u0016\n\u0000\t\u0006\u0010\u0001\u0006\u0017\u0007\u000e\u0002\t\u0013\u0019\u0007\t\u0007\u001d\u000e\u0011»»\t\u0014\u0019\u000e").intern());
            sb3.append(e9.getLocalizedMessage());
            k.m2852(strIntern, sb3.toString());
        }
        try {
            jSONObject.put(m2814(3 - (ViewConfiguration.getGlobalActionKeyTimeout() > j ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == j ? 0 : -1)), (byte) (TextUtils.indexOf("", "") + 90), "\u000b\u0006").intern(), packageManager.getApplicationLabel(packageManager.getApplicationInfo(packageName, 0)).toString());
        } catch (PackageManager.NameNotFoundException e10) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(m2814(TextUtils.lastIndexOf("", '0') + 34, (byte) (84 - (ViewConfiguration.getGlobalActionKeyTimeout() > j ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == j ? 0 : -1))), "\b\t\u000b\u0003\u000b\u0006\u000f\u0000\u0011\u0013\u000f\u0004\u0013\u0007\u0014\u001a\u0014\u0010\u0016\u0011\f\u0019\u0011\b\u0011\u0014\u000f\u0016\f\u0013\t\u0014s").intern());
            sb4.append(packageName);
            sb4.append(m2810(null, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 126, null, "\u0084\u0089\u0087\u0088\u0087\u0087\u0086\u0084\u0085\u0084").intern());
            sb4.append(e10.getLocalizedMessage());
            k.m2852(strIntern, sb4.toString());
        } catch (JSONException e11) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(m2810(null, TextUtils.lastIndexOf("", '0', 0) + 128, null, "\u0084\u0089\u0087\u0088\u0087\u0087\u0086\u0084\u0096\u0082\u0088\u0095\u0094\u0084\u0088\u008f\u0084\u0088\u0093\u0082\u0092\u0084\u0086\u0091\u0090\u0082\u0084\u0081\u0081\u0090\u0084\u008d\u008d\u0090\u0084\u008f\u008e\u0082\u008d\u008c\u008b\u0088\u008a").intern());
            sb5.append(e11.getLocalizedMessage());
            k.m2852(strIntern, sb5.toString());
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static boolean m2815(Context context, String str) {
        if (context.checkCallingOrSelfPermission(str) == 0) {
            int i2 = f2915 + 113;
            f2913 = i2 % 128;
            return i2 % 2 == 0;
        }
        int i8 = f2913 + 47;
        f2915 = i8 % 128;
        if (i8 % 2 != 0) {
            return false;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static String m2813() {
        f2915 = (f2913 + 3) % 128;
        try {
            try {
                Class.forName(m2814(30 - Drawable.resolveOpacity(0, 0), (byte) (66 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))), "\u001a\u000e\u0019\u001a\n\u0006\u0005\u0004\u001d\u0018\u0007\u001c\u0002\u0000\u0010\u001a\u000f\u0016\u001a\u0001\n\u0005\u0004\u001b#\u0000\u0010\u001a\u000f\u0016").intern());
                String strIntern = m2814(1 - TextUtils.getOffsetAfter("", 0), (byte) ((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 78), "Ã").intern();
                int i2 = f2913 + 59;
                f2915 = i2 % 128;
                if (i2 % 2 != 0) {
                    return strIntern;
                }
                throw null;
            } catch (ClassNotFoundException unused) {
                Class.forName(m2814(60 - TextUtils.getCapsMode("", 0, 0), (byte) (97 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))), "\u001a\u000e\u0019\u001a\u0003\u0016\t\u0006\u0007\t\u000f\u001b\u0016\u000e\u001a\r\u0007\"\b\u000f\u0000\u0005\u0004\u001b\u0007\u000b\u0013\u001c\u0007\u000b\u0013\u001c\u0010\u0002\u0013\u001b\u0002\u000e\u0006\u001a\u0002\u0011\u0003\u001b\u0014\u001a\u0011\u0010\u0014\u001a\u001c\u0004!\u0005\u0011\n\n\u0000\t\u0006").intern());
                return m2814(1 - View.MeasureSpec.getSize(0), (byte) ((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 112), "Ñ").intern();
            }
        } catch (ClassNotFoundException unused2) {
            return m2814(-TextUtils.lastIndexOf("", '0', 0), (byte) (View.MeasureSpec.getSize(0) + 93), "Ë").intern();
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m2814(int i2, byte b8, String str) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (h.f2264) {
            try {
                char[] cArr2 = f2920;
                char c7 = f2914;
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
    public static String m2811(Context context) {
        f2915 = (f2913 + 13) % 128;
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        try {
            String str = packageManager.getPackageInfo(packageName, 0).versionName;
            int i2 = f2915 + 63;
            f2913 = i2 % 128;
            if (i2 % 2 == 0) {
                return str;
            }
            throw null;
        } catch (PackageManager.NameNotFoundException e) {
            String strIntern = m2814((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 7, (byte) (3 - (ViewConfiguration.getPressedStateDuration() >> 16)), "\u0001\u0002\u0002\u0003\u0004\u0005\u0000\u000b").intern();
            StringBuilder sb = new StringBuilder();
            sb.append(m2814((Process.myTid() >> 22) + 33, (byte) (83 - (ViewConfiguration.getPressedStateDuration() >> 16)), "\b\t\u000b\u0003\u000b\u0006\u000f\u0000\u0011\u0013\u000f\u0004\u0013\u0007\u0014\u001a\u0014\u0010\u0016\u0011\f\u0019\u0011\b\u0011\u0014\u000f\u0016\f\u0013\t\u0014s").intern());
            sb.append(packageName);
            sb.append(m2810(null, 127 - KeyEvent.getDeadChar(0, 0), null, "\u0084\u0089\u0087\u0088\u0087\u0087\u0086\u0084\u0085\u0084").intern());
            sb.append(e.getLocalizedMessage());
            k.m2852(strIntern, sb.toString());
            return null;
        }
    }
}
