package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.vungle.ads.internal.protos.Sdk;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class dg extends da implements ci {

    /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
    private static int f1702 = 1;

    /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
    private static int f1703 = 0;

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static int f1704 = 91;

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static char f1705 = 2978;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static int f1706;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static long f1707;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private String f1709;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private String f1710;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private boolean f1712;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private String f1713 = "";

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private double f1711 = -1.0d;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private boolean f1708 = false;

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private String m1929() {
        String strIntern;
        f1702 = (f1703 + 15) % 128;
        if (m1930()) {
            f1702 = (f1703 + 79) % 128;
            strIntern = m1934("硅뮶ﺺఱ", (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), "㕕놗\uf12c콮灹鞙尶鿫ⳏ㕾", ViewConfiguration.getScrollBarFadeDuration() >> 16, "\u0000\u0000\u0000\u0000").intern();
            f1702 = (f1703 + 63) % 128;
        } else {
            strIntern = m1934("櫀ၳᑭ리", (char) (TextUtils.getOffsetAfter("", 0) + 44052), "蘛ꖱﯧᆎ䓂嶃", ViewConfiguration.getMaximumFlingVelocity() >> 16, "\u0000\u0000\u0000\u0000").intern();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(m1937((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 190, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 9, "\u0000\u0001\tￊ\n\u000b\u0005\u0010�\u0005", ((Process.getThreadPriority(0) + 20) >> 6) + 3, true).intern());
        sb.append(this.f1713);
        return a0.d(sb, m1934("딽﹔ᒎ岭", (char) (44308 - Color.argb(0, 0, 0, 0)), "⍏", (-1895934795) - Drawable.resolveOpacity(0, 0), "\u0000\u0000\u0000\u0000"), strIntern);
    }

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private boolean m1930() {
        int i2 = (f1702 + 75) % 128;
        f1703 = i2;
        boolean z2 = this.f1712;
        f1702 = (i2 + 5) % 128;
        return z2;
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private String m1931() {
        String str;
        int i2 = f1702 + 99;
        int i8 = i2 % 128;
        f1703 = i8;
        if (i2 % 2 != 0) {
            str = this.f1709;
            int i9 = 90 / 0;
        } else {
            str = this.f1709;
        }
        f1702 = (i8 + 93) % 128;
        return str;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private String m1932() {
        int i2 = (f1702 + 87) % 128;
        f1703 = i2;
        String str = this.f1710;
        f1702 = (i2 + 45) % 128;
        return str;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private boolean m1935() {
        int i2 = f1703 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE;
        f1702 = i2 % 128;
        if (i2 % 2 != 0) {
            return this.f1708;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private String m1936() {
        int i2 = f1703;
        String str = this.f1713;
        f1702 = (i2 + 13) % 128;
        return str;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private void m1939(String str) {
        int i2 = f1702 + 13;
        int i8 = i2 % 128;
        f1703 = i8;
        int i9 = i2 % 2;
        this.f1713 = str;
        if (i9 != 0) {
            throw null;
        }
        f1702 = (i8 + 63) % 128;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final void m1941(String str) {
        int i2 = f1703;
        this.f1710 = str;
        f1702 = (i2 + 17) % 128;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private void m1933(boolean z2) {
        int i2 = f1702;
        this.f1712 = z2;
        f1703 = (i2 + 49) % 128;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final void m1942(boolean z2) {
        int i2 = f1702;
        this.f1708 = z2;
        f1703 = (i2 + 51) % 128;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final void m1943(String str) {
        int i2 = f1703;
        int i8 = i2 + 45;
        f1702 = i8 % 128;
        int i9 = i8 % 2;
        this.f1709 = str;
        if (i9 == 0) {
            throw null;
        }
        f1702 = (i2 + 9) % 128;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final void m1944(Double d8) {
        f1702 = (f1703 + 69) % 128;
        this.f1711 = d8.doubleValue();
        int i2 = f1703 + 105;
        f1702 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m1937(int i2, int i8, String str, int i9, boolean z2) {
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
                    cArr2[i11] = (char) (cArr2[i11] - f1704);
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

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private Double m1938() {
        int i2 = f1702 + 69;
        f1703 = i2 % 128;
        if (i2 % 2 == 0) {
            return Double.valueOf(this.f1711);
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final JSONObject m1940() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(ig.f2526, this.f1710);
            double d8 = this.f1711;
            if (d8 > -1.0d) {
                jSONObject2.put(ig.f2476, d8);
                f1702 = (f1703 + 71) % 128;
            }
            jSONObject2.put(ig.f2477, this.f1709);
        } catch (JSONException unused) {
        }
        try {
            if (jSONObject2.length() > 0) {
                int i2 = f1703 + 65;
                f1702 = i2 % 128;
                if (i2 % 2 != 0) {
                    if (this.f1708) {
                        jSONObject2.put(ig.f2474, true);
                    }
                    jSONObject.put(ig.f2475, jSONObject2);
                } else {
                    throw null;
                }
            }
        } catch (JSONException unused2) {
        }
        return jSONObject;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.ironsource.adqualitysdk.sdk.i.ci
    /* JADX INFO: renamed from: ﾒ */
    public final Object mo886(String str, List<Object> list, ch chVar) {
        byte b8;
        byte b9;
        int i2 = f1703 + 73;
        f1702 = i2 % 128;
        if (i2 % 2 != 0) {
            switch (str.hashCode()) {
                case -2010356102:
                    b8 = !str.equals(m1937(191 - TextUtils.indexOf((CharSequence) "", '0', 0), 20 - Process.getGidForName(""), "\t\u000f￩￼\b\u0000\u0002\u0000\u000f\uffdd\r\n￼\uffff\ufffe￼\u000e\u000f￠\u0011\u0000", 6 - (ViewConfiguration.getKeyRepeatDelay() >> 16), false).intern()) ? (byte) -1 : (byte) 12;
                    break;
                case -1679773410:
                    b8 = !str.equals(m1934("\ud8eb釫䴋賋", (char) (52044 - TextUtils.lastIndexOf("", '0')), "㢲蓺꿉틘\uffc0홋䉸⫋鶻덃čڕ椾봎", ViewConfiguration.getLongPressTimeout() >> 16, "\u0000\u0000\u0000\u0000").intern()) ? (byte) -1 : (byte) 8;
                    break;
                case -1457409854:
                    b8 = !str.equals(m1934("\uf5b5㧊璏薯", (char) (View.resolveSizeAndState(0, 0, 0) + 44916), "\uf859ᷤ⡄ৠ禥錑Ⱇ賂裏\u0feb\ueeb6䪎Ⲡ銬喫튐", (-1) - MotionEvent.axisFromString(""), "\u0000\u0000\u0000\u0000").intern()) ? (byte) -1 : (byte) 1;
                    break;
                case -1033133001:
                    b8 = !str.equals(m1934("吴覝\ue387⬐", (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16), "배\uf24fꂔ㵬㩝㖙搤㘪舤ﶅ⦨֛", KeyEvent.getMaxKeyCode() >> 16, "\u0000\u0000\u0000\u0000").intern()) ? (byte) -1 : (byte) 4;
                    break;
                case -869156349:
                    if (!str.equals(m1934("َᏬ◝䴑", (char) (Drawable.resolveOpacity(0, 0) + 4389), "\uf31c䞞㊆\ue563\udb06檨", ViewConfiguration.getMinimumFlingVelocity() >> 16, "\u0000\u0000\u0000\u0000").intern())) {
                        b8 = -1;
                    } else {
                        f1703 = (f1702 + 75) % 128;
                        b8 = 13;
                    }
                    break;
                case -303276684:
                    b8 = !str.equals(m1937(ExpandableListView.getPackedPositionGroup(0L) + 193, View.resolveSize(0, 0) + 22, "\uffff\u0001\uffff\u000e\uffe7\uffff\ufffe\u0003\ufffb\u000e\uffff\ufffe￨\uffff\u000e\u0011\t\f\u0005￨\ufffb\u0007", 1 - Color.green(0), false).intern()) ? (byte) -1 : (byte) 3;
                    break;
                case 91962794:
                    if (!str.equals(m1937(192 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 14 - KeyEvent.keyCodeFromString(""), "\u0000\b\u0000\ufffe￼\u0007￫\u000f\u0000\u0002\uffff￤\u000f\t", 10 - View.resolveSizeAndState(0, 0, 0), true).intern())) {
                        b8 = -1;
                    } else {
                        int i8 = f1702 + 59;
                        f1703 = i8 % 128;
                        b8 = i8 % 2 == 0 ? (byte) 9 : (byte) 44;
                    }
                    break;
                case 701278346:
                    if (!str.equals(m1937(192 - (ViewConfiguration.getScrollBarSize() >> 8), 17 - TextUtils.getOffsetBefore("", 0), "\u000f￤\u000e￡\u0010\u0007\u0007\u000e\ufffe\r\u0000\u0000\tￜ\uffff\u000e\u0000", 14 - TextUtils.lastIndexOf("", '0', 0, 0), false).intern())) {
                        b8 = -1;
                    } else {
                        int i9 = f1703 + 33;
                        f1702 = i9 % 128;
                        if (i9 % 2 != 0) {
                            b8 = 6;
                        } else {
                            b9 = 64;
                            b8 = b9;
                        }
                    }
                    break;
                case 1006114614:
                    b8 = !str.equals(m1934("䡊❳鑕尘", (char) (6292 - (KeyEvent.getMaxKeyCode() >> 16)), "囒۱\uf204鱪럔\uebef㋖陹罹墀\ue447脇㩣\ue324\udb22榡", (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), "\u0000\u0000\u0000\u0000").intern()) ? (byte) -1 : (byte) 0;
                    break;
                case 1009851624:
                    b8 = !str.equals(m1937((-16777023) - Color.rgb(0, 0, 0), 22 - (KeyEvent.getMaxKeyCode() >> 16), "\u000e\uffe7\uffff\ufffe\u0003\ufffb\u000e\uffff\ufffe￨\uffff\u000e\u0011\t\f\u0005￨\ufffb\u0007\uffff\r\uffff", 19 - ImageFormat.getBitsPerPixel(0), false).intern()) ? (byte) -1 : (byte) 2;
                    break;
                case 1314266045:
                    b8 = !str.equals(m1934("\ue016얓ᚐ꒕", (char) ((Process.getThreadPriority(0) + 20) >> 6), "㒥闟ᣕᙂ牐掠ᥭĤⳗ陣텶", (-1866099744) - View.resolveSizeAndState(0, 0, 0), "\u0000\u0000\u0000\u0000").intern()) ? (byte) -1 : (byte) 10;
                    break;
                case 1402845873:
                    if (!str.equals(m1937(194 - (ViewConfiguration.getScrollDefaultDelay() >> 16), 10 - ((byte) KeyEvent.getModifierMetaStateMask()), "ￜ\u000e\f\r\b\u0006\u0000\ufffe\r￢\f", (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 5, false).intern())) {
                        b8 = -1;
                    } else {
                        int i10 = f1703 + 19;
                        f1702 = i10 % 128;
                        b9 = i10 % 2 == 0 ? (byte) 25 : (byte) 11;
                        b8 = b9;
                    }
                    break;
                case 1641431166:
                    b8 = !str.equals(m1934("칚闼Ķ햨", (char) ((ViewConfiguration.getJumpTapTimeout() >> 16) + 43009), "맧憓ﳾ틀窙蕦볍頬헢\udb32ꔔ湬渀⭝랗⋘\uef3a", 915799246 - (ViewConfiguration.getDoubleTapTimeout() >> 16), "\u0000\u0000\u0000\u0000").intern()) ? (byte) -1 : (byte) 7;
                    break;
                case 1712841667:
                    if (!str.equals(m1937(192 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), TextUtils.indexOf("", "", 0, 0) + 12, "\uffff￭\u0000\u0011\u0000\t\u0010\u0000\u0002\u0000\u000fￜ", 9 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), false).intern())) {
                        b8 = -1;
                    } else {
                        f1702 = (f1703 + 3) % 128;
                        b8 = 5;
                    }
                    break;
                default:
                    b8 = -1;
                    break;
            }
            switch (b8) {
                case 0:
                    m1941((String) da.m1896(list, 0, String.class));
                    return null;
                case 1:
                    return m1932();
                case 2:
                    m1939((String) da.m1896(list, 0, String.class));
                    return null;
                case 3:
                    return m1936();
                case 4:
                    m1944((Double) da.m1896(list, 0, Double.class));
                    return null;
                case 5:
                    return m1938();
                case 6:
                    m1933(((Boolean) da.m1896(list, 0, Boolean.class)).booleanValue());
                    return null;
                case 7:
                    return Boolean.valueOf(m1930());
                case 8:
                    m1943((String) da.m1896(list, 0, String.class));
                    return null;
                case 9:
                    return m1931();
                case 10:
                    m1942(((Boolean) da.m1896(list, 0, Boolean.class)).booleanValue());
                    return Boolean.valueOf(m1935());
                case 11:
                    return Boolean.valueOf(m1935());
                case 12:
                    return m1929();
                case 13:
                    JSONObject jSONObjectM1940 = m1940();
                    int i11 = f1702 + 87;
                    f1703 = i11 % 128;
                    if (i11 % 2 != 0) {
                        int i12 = 57 / 0;
                    }
                    return jSONObjectM1940;
                default:
                    return null;
            }
        }
        str.hashCode();
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m1934(String str, char c7, String str2, int i2, String str3) {
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
                        cArr6[i12] = (char) (((((long) (c9 ^ cArr2[i12])) ^ f1707) ^ ((long) f1706)) ^ ((long) f1705));
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
}
