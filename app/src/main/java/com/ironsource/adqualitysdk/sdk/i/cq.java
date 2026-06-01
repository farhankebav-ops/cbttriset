package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.os.Process;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.ironsource.adqualitysdk.sdk.i.cm;
import com.ironsource.adqualitysdk.sdk.i.hz;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class cq {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private cm f1517;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private hz.a f1518;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private List<String> f1519;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private int f1520;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final hz m1782(ia iaVar) {
        return this.f1518.m2472(iaVar, this.f1519, this.f1520);
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final cm m1781() {
        return this.f1517;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class b extends da implements ci {

        /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
        private static int f1522 = 1;

        /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
        private static int f1524 = 0;

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private static char f1527 = 6;

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private cm.b f1528;

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private cq f1529;

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private static char[] f1525 = {'s', 'e', 't', 'M', 'i', 'n', 'D', 'p', 'h', 'F', 'o', 'r', 'C', 'c', 'k', 'S', 'u', 'l', 'a', 'w', 'W', 'R', 'f', 'I', 'A', 'y', 'O', 'b', 'j', 'm', 'd', 'v', 'x', 'z', '{', '|'};

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private static long f1526 = 0;

        /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
        private static int f1521 = 0;

        /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
        private static char f1523 = 9283;

        public b(List<String> list, int i2) {
            cq cqVar = new cq();
            this.f1529 = cqVar;
            cqVar.f1518 = new hz.a();
            this.f1529.f1519 = list;
            this.f1529.f1520 = i2;
            this.f1528 = new cm.b();
        }

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private static String m1783(int i2, byte b8, String str) {
            String str2;
            Object charArray = str;
            if (str != null) {
                charArray = str.toCharArray();
            }
            char[] cArr = (char[]) charArray;
            synchronized (h.f2264) {
                try {
                    char[] cArr2 = f1525;
                    char c7 = f1527;
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

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private cq m1784() {
            cq cqVar;
            int i2 = f1522 + 91;
            f1524 = i2 % 128;
            if (i2 % 2 != 0) {
                this.f1529.f1517 = this.f1528.m1644();
                cqVar = this.f1529;
                int i8 = 42 / 0;
            } else {
                this.f1529.f1517 = this.f1528.m1644();
                cqVar = this.f1529;
            }
            int i9 = f1524 + 13;
            f1522 = i9 % 128;
            if (i9 % 2 == 0) {
                int i10 = 71 / 0;
            }
            return cqVar;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.ci
        /* JADX INFO: renamed from: ﾒ */
        public final Object mo886(String str, List<Object> list, ch chVar) {
            byte b8;
            f1524 = (f1522 + 53) % 128;
            switch (str.hashCode()) {
                case -1930334554:
                    if (!str.equals(m1783(15 - TextUtils.getTrimmedLength(""), (byte) (71 - Color.green(0)), "\u0001\u0002\u0003\u000e\u0000\u0013\u0007\u0011\u000b\u0014\u0000\u0004\u0013\u0006º").intern())) {
                        b8 = -1;
                    } else {
                        f1524 = (f1522 + 35) % 128;
                        b8 = 7;
                    }
                    break;
                case -1826216039:
                    b8 = !str.equals(m1785("芷⮍癈칀", (char) Color.blue(0), "ᶳ弖䘌튊䷵륇꼺ၙ곇痈", (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), "\u0000\u0000\u0000\u0000").intern()) ? (byte) -1 : (byte) 14;
                    break;
                case -994397843:
                    b8 = !str.equals(m1783(18 - (ViewConfiguration.getTouchSlop() >> 8), (byte) (55 - Color.green(0)), "\u0001\u0002\u0003\u0004\u0005\u0000\u0007\u0000\b\u0001\t\n\u000b\u0006\u0000\u0015\u0006\u0001").intern()) ? (byte) -1 : (byte) 6;
                    break;
                case -941967812:
                    if (!str.equals(m1785("᥅貦补Ⲋ", (char) (35464 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))), "쾏쀡丟ᒌ袧쫒⾂狥䎔㇀褑\udaad䦮ሷ歌x✕\uf846", (-1) - Process.getGidForName(""), "\u0000\u0000\u0000\u0000").intern())) {
                        b8 = -1;
                    } else {
                        int i2 = f1524 + 111;
                        f1522 = i2 % 128;
                        b8 = i2 % 2 != 0 ? (byte) 3 : (byte) 5;
                    }
                    break;
                case -770599694:
                    b8 = !str.equals(m1783((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 18, (byte) (Color.argb(0, 0, 0, 0) + 63), "\u0001\u0002\u0003\u0004\u0005\u0000\u0007\u0000\b\u0001\t\n\u000b\u0006\u000e\u0006\u0007\u0013ª").intern()) ? (byte) -1 : (byte) 0;
                    break;
                case -235079533:
                    b8 = !str.equals(m1783(18 - Color.alpha(0), (byte) ((ViewConfiguration.getScrollBarSize() >> 8) + 101), "\u0001\u0002\u0000\u000e\u0013\f\u0007\u0002\u001d\f\u000e\u001d\u001c\u001d\u0007\u0013\u0003\u0001").intern()) ? (byte) -1 : (byte) 12;
                    break;
                case -213689933:
                    if (!str.equals(m1783(TextUtils.lastIndexOf("", '0') + 24, (byte) (MotionEvent.axisFromString("") + 39), "\u0001\u0002\u0003\b\u000b\u0010\u0010\u000b\u0014\u0015\u0000\u0013\u000f\u0014\u0004\u0013\u0005\u0007\u0002\u0000\u0013\u0007\u0099").intern())) {
                        b8 = -1;
                    } else {
                        f1522 = (f1524 + 69) % 128;
                    }
                    break;
                case 46561673:
                    b8 = !str.equals(m1785("·\ud9e2箚ĕ", (char) (5500 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))), "呵\ufb0bĭፉ뉰⽝ᾚⓨ䚻數\ufb3d⫝̸糺⭀撞\ue030꼿", (-1696996861) - (ViewConfiguration.getLongPressTimeout() >> 16), "\u0000\u0000\u0000\u0000").intern()) ? (byte) -1 : (byte) 11;
                    break;
                case 94094958:
                    b8 = !str.equals(m1783(Color.argb(0, 0, 0, 0) + 5, (byte) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 56), "\u001c\u000f\u0005\u0010\u009d").intern()) ? (byte) -1 : (byte) 17;
                    break;
                case 841006591:
                    b8 = !str.equals(m1783((ViewConfiguration.getJumpTapTimeout() >> 16) + 25, (byte) (125 - TextUtils.indexOf((CharSequence) "", '0')), "\u0001\u0002\u0003\u0004\u0005\u0000\u0007\u0000\b\u0001\t\n\u000b\u0006\u0010\u0006êê\u0007\u0013\u0003\u0005\u000b\u0004ñ").intern()) ? (byte) -1 : (byte) 8;
                    break;
                case 902024524:
                    b8 = !str.equals(m1783(ImageFormat.getBitsPerPixel(0) + 11, (byte) (120 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), "\u0005\u0000\u0001\u0003\u0017\u0000\u0013\u0007\u001c\u0014").intern()) ? (byte) -1 : (byte) 15;
                    break;
                case 923334616:
                    b8 = !str.equals(m1783((-16777199) - Color.rgb(0, 0, 0), (byte) (78 - ExpandableListView.getPackedPositionChild(0L)), "\u000e\u0011\u0001\u0003\u000b\u001c\u000e\u0006\u0007\u0013\u000f\u0002\u0002\u0003\t\u000b³").intern()) ? (byte) -1 : (byte) 16;
                    break;
                case 1080975014:
                    if (!str.equals(m1785("ܒ映切慗", (char) KeyEvent.getDeadChar(0, 0), "蘳啲衡筘뛝\uda3d\ue824乄ꡊ眠졞\ue506т⦄\uf299ᓦΎ꿡붂罉⩷䏰", ViewConfiguration.getMaximumFlingVelocity() >> 16, "\u0000\u0000\u0000\u0000").intern())) {
                        b8 = -1;
                    } else {
                        f1524 = (f1522 + 27) % 128;
                        b8 = 9;
                    }
                    break;
                case 1083215325:
                    if (!str.equals(m1785("냷弖稘\uf85e", (char) ((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 24186), "箤㴛～酁אַ\ue115匷洦鋢촁\ue6e5섈㒟锶߾ཛ", ViewConfiguration.getWindowTouchSlop() >> 8, "\u0000\u0000\u0000\u0000").intern())) {
                        b8 = -1;
                    } else {
                        int i8 = f1524 + 113;
                        f1522 = i8 % 128;
                        b8 = i8 % 2 != 0 ? (byte) 13 : (byte) 107;
                    }
                    break;
                case 1202614773:
                    if (!str.equals(m1783(KeyEvent.normalizeMetaState(0) + 21, (byte) (120 - TextUtils.getOffsetAfter("", 0)), "\u0001\u0002\u0003\u000e\u0000\u0013\u0007\u0011\t\u000e\r\n\u0005\u0007\r\f\u0018\u0006\u0001\u0002ë").intern())) {
                        b8 = -1;
                    } else {
                        f1524 = (f1522 + 15) % 128;
                        b8 = 2;
                    }
                    break;
                case 1689765750:
                    b8 = !str.equals(m1785("왨㖌圢ⅽ", (char) (32087 - (ViewConfiguration.getPressedStateDuration() >> 16)), "漝鈽ꁠ㕴儎⪱\uddc8뾣ᆿ䣳僞؞憅\ud975㨚昏㰒眤ᝦ䖒㘀베愥㎠雭覃鮑똉", TextUtils.getOffsetAfter("", 0), "\u0000\u0000\u0000\u0000").intern()) ? (byte) -1 : (byte) 4;
                    break;
                case 1766229249:
                    if (!str.equals(m1783(25 - ExpandableListView.getPackedPositionChild(0L), (byte) ((ViewConfiguration.getJumpTapTimeout() >> 16) + 45), "\u0001\u0002\u0003\u0004\u0005\u0000\u0007\u0000\b\u0001\t\n\u000b\u0006\u0010\u0011\r\u0007\u0006\u0011\f\u0017  \u0002\u0001").intern())) {
                        b8 = -1;
                    } else {
                        f1524 = (f1522 + 9) % 128;
                        b8 = 1;
                    }
                    break;
                case 1833576080:
                    if (!str.equals(m1783(19 - TextUtils.lastIndexOf("", '0', 0, 0), (byte) (View.combineMeasuredStates(0, 0) + 1), "\u0001\u0002\u0003\u0004\u0005\u0000\u0007\u0000\b\u0001\t\n\u000b\u0006\u001d\u0006\u0006\u0017\u0018\u0001").intern())) {
                        b8 = -1;
                    } else {
                        int i9 = f1522 + 91;
                        f1524 = i9 % 128;
                        b8 = i9 % 2 == 0 ? (byte) 10 : (byte) 69;
                    }
                    break;
                default:
                    b8 = -1;
                    break;
            }
            switch (b8) {
                case 0:
                    this.f1529.f1518.m2470(((Integer) da.m1896(list, 0, Integer.class)).intValue());
                    return this;
                case 1:
                    this.f1529.f1518.m2464(((Integer) da.m1896(list, 0, Integer.class)).intValue());
                    return this;
                case 2:
                    this.f1529.f1518.m2466(((Boolean) da.m1896(list, 0, Boolean.class)).booleanValue());
                    return this;
                case 3:
                    this.f1529.f1518.m2460(((Integer) da.m1896(list, 0, Integer.class)).intValue());
                    return this;
                case 4:
                    this.f1529.f1518.m2462(((Integer) da.m1896(list, 0, Integer.class)).intValue());
                    return this;
                case 5:
                    this.f1529.f1518.m2468(((Boolean) da.m1896(list, 0, Boolean.class)).booleanValue());
                    return this;
                case 6:
                    this.f1529.f1518.m2467(((Integer) da.m1896(list, 0, Integer.class)).intValue());
                    return this;
                case 7:
                    this.f1529.f1518.m2463(((Boolean) da.m1896(list, 0, Boolean.class)).booleanValue());
                    return this;
                case 8:
                    this.f1529.f1518.m2457(((Integer) da.m1896(list, 0, Integer.class)).intValue());
                    int i10 = f1522 + 29;
                    f1524 = i10 % 128;
                    if (i10 % 2 != 0) {
                        int i11 = 63 / 0;
                    }
                    return this;
                case 9:
                    this.f1529.f1518.m2461(((Boolean) da.m1896(list, 0, Boolean.class)).booleanValue());
                    return this;
                case 10:
                    this.f1529.f1518.m2459(((Integer) da.m1896(list, 0, Integer.class)).intValue());
                    return this;
                case 11:
                    this.f1529.f1518.m2471(((Boolean) da.m1896(list, 0, Boolean.class)).booleanValue());
                    return this;
                case 12:
                    this.f1529.f1518.m2458(((Boolean) da.m1896(list, 0, Boolean.class)).booleanValue());
                    return this;
                case 13:
                    this.f1528.m1641((Class) da.m1896(list, 0, Class.class));
                    return this;
                case 14:
                    this.f1528.m1643((Class) da.m1896(list, 0, Class.class));
                    return this;
                case 15:
                    this.f1528.m1645((Class) da.m1896(list, 0, Class.class));
                    return this;
                case 16:
                    dq dqVar = (dq) da.m1896(list, 0, dq.class);
                    this.f1528.m1642(dqVar);
                    this.f1529.f1518.m2465(dqVar);
                    return this;
                case 17:
                    return m1784();
                default:
                    return null;
            }
        }

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private static String m1785(String str, char c7, String str2, int i2, String str3) {
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
                            cArr6[i12] = (char) (((((long) (c9 ^ cArr2[i12])) ^ f1526) ^ ((long) f1521)) ^ ((long) f1523));
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
}
