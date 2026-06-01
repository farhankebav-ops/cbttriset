package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import com.ironsource.adqualitysdk.sdk.i.hd;
import com.ironsource.adqualitysdk.sdk.i.he;
import com.ironsource.adqualitysdk.sdk.i.hf;
import com.ironsource.adqualitysdk.sdk.i.hg;
import com.ironsource.adqualitysdk.sdk.i.hj;
import com.ironsource.adqualitysdk.sdk.i.hl;
import com.vungle.ads.internal.protos.Sdk;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class jy {

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static Field f2921 = null;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static int f2923 = 0;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static int f2924 = 1;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static Field f2926;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static Field f2927;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static Object f2928;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static Class f2929;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static Field f2930;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static char[] f2925 = {'n', 223, 225, 230, 216, 214, 233, 233, 225, 226, 228, 230, 235, 231, 225, 196, 205, 234, 226, 233, 205, 189, 219, 230, 228, 228, 238, 221, 210, 226, '8', 'o', 's', 'r', 'u', '~', '{', 'f', 'i', 'w', 'q', 'X', 191, 185, 184, 203, 199, 200, 188, 187, 207, 212, 205, 202, 202, 204, 208, 'o', 217, 224, 226, 222, 222, 222, 229, 227, 227, 188, 183, 222, 186, 182, 217, 223, 211, 204, 215, 217, 216, 203, '&', 'Y', 'd', 'f', 'e', 'R', 'Y', 'n', 'n', 'n', 'h', 'l', 'n', 'l', 'n', ']', 'Z', 'n', 's', 'l', 'i', 'i', 'k', 'k', 'k', 'r', 'p', 'p', 'I', 'D', 'k', 'G', 'I', 'k', 'j', 'n', 'f', 'b', 'd', 'Z', '^', 295, 286, 301, 300, 290, 261, 285, 286, 299, 282, 297, 286, 299, 265, 295, 264, 294, 299, 286, '&', 'Y', 'd', 'f', 'e', 'X', 'a', 'k', 'j', 'h', 'i', 'k', 'd', 'X', 'Z', 'n', 's', 'l', 'i', 'i', 'k', 'k', 'k', 'r', 'p', 'p', 'I', 'D', 'k', 'G', 'I', 'k', 'j', 'n', 'f', 'b', 'd', 'Z', '^', '2', 'k', 'r', 'p', 'p', 'I', 'D', 'k', 'G', 'I', 'k', 'j', 'n', 'f', 'b', 'd', 'Z', '^', '`', '\\', 'e', 'h', 'W', 'Y', 'n', 'n', 'n', 'h', 'l', 'l', 'X', 'Z', 'n', 's', 'l', 'i', 'i', 'k', '6', 'a', '_', 'g', 'n', 'u', '{', 242, 242, 227, 229, 243, 241, 241, 244, 251, 246, 226, 228};

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static int[] f2922 = {1654552811, 2045304733, 278502287, 1095197561, 1206507883, -1844055454, -154694945, -1432658167, 1441764189, -1744556576, -1273352611, 1509415091, 57957211, -1509121071, -314856548, -1104548576, -2139694448, -1044149115};

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static View.OnTouchListener m2816(View view) {
        try {
            Object objM2819 = m2819(view);
            if (objM2819 == null) {
                return null;
            }
            Class<?> cls = objM2819.getClass();
            synchronized (jv.class) {
                try {
                    if (f2921 == null) {
                        f2921 = m2823(cls, m2822(new int[]{250426305, -1854552254, 174592219, -187337143, 2047386578, 1241419519, -492695769, -1574963377}, 15 - TextUtils.indexOf((CharSequence) "", '0', 0, 0)).intern());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return (View.OnTouchListener) f2921.get(objM2819);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static void m2820(MediaPlayer mediaPlayer, hf.a aVar) {
        f2923 = (f2924 + 13) % 128;
        try {
            Field fieldM2823 = m2823(MediaPlayer.class, m2827(null, true, new int[]{Sdk.SDKError.Reason.TPAT_ERROR_VALUE, 19, 185, 17}).intern());
            MediaPlayer.OnPreparedListener onPreparedListener = (MediaPlayer.OnPreparedListener) fieldM2823.get(mediaPlayer);
            if (!(onPreparedListener instanceof hf)) {
                fieldM2823.set(mediaPlayer, new hf(onPreparedListener, aVar));
            }
            f2924 = (f2923 + 27) % 128;
        } catch (Exception e) {
            kd.m2919(m2822(new int[]{-1707449474, -1441527061, 591634003, 61502831, -1783278720, -776538056}, 12 - View.combineMeasuredStates(0, 0)).intern(), m2827("\u0001\u0000\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0000\u0001\u0001\u0000\u0001\u0000\u0000\u0000\u0001", false, new int[]{140, 39, 0, 21}).intern(), e, false);
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static View.OnClickListener m2821(View view) {
        try {
            Object objM2819 = m2819(view);
            if (objM2819 == null) {
                return null;
            }
            Class<?> cls = objM2819.getClass();
            synchronized (jv.class) {
                try {
                    if (f2927 == null) {
                        f2927 = m2823(cls, m2827("\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001", false, new int[]{41, 16, 97, 15}).intern());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return (View.OnClickListener) f2927.get(objM2819);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static void m2824(View view, hg.a aVar) {
        int i2 = f2923 + 7;
        f2924 = i2 % 128;
        if (i2 % 2 == 0) {
            m2821(view);
            throw null;
        }
        View.OnClickListener onClickListenerM2821 = m2821(view);
        if (!(onClickListenerM2821 instanceof hg)) {
            view.setOnClickListener(new hg(onClickListenerM2821, aVar));
        }
        int i8 = f2924 + 77;
        f2923 = i8 % 128;
        if (i8 % 2 != 0) {
            throw null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0018  */
    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<android.view.View> m2828() {
        /*
            Method dump skipped, instruction units count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.jy.m2828():java.util.List");
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static Object m2819(View view) {
        try {
            synchronized (jv.class) {
                try {
                    if (f2930 == null) {
                        f2930 = m2823(View.class, m2827("\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001", true, new int[]{Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 13, Sdk.SDKError.Reason.PRIVACY_URL_ERROR_VALUE, 0}).intern());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return f2930.get(view);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static void m2825(View view, hl.c cVar) {
        f2924 = (f2923 + 1) % 128;
        View.OnTouchListener onTouchListenerM2816 = m2816(view);
        if (onTouchListenerM2816 instanceof hl) {
            return;
        }
        view.setOnTouchListener(new hl(onTouchListenerM2816, cVar));
        f2923 = (f2924 + 37) % 128;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static void m2817(MediaPlayer mediaPlayer, hd.d dVar) {
        Field fieldM2823;
        MediaPlayer.OnInfoListener onInfoListener;
        int i2 = f2924 + 15;
        f2923 = i2 % 128;
        try {
            if (i2 % 2 != 0) {
                fieldM2823 = m2823(MediaPlayer.class, m2822(new int[]{1943601247, -1942616235, -2100079906, -1263559470, -1275788329, -1212074022, 1063346278, 148426215}, 12 >>> View.MeasureSpec.getSize(0)).intern());
                onInfoListener = (MediaPlayer.OnInfoListener) fieldM2823.get(mediaPlayer);
                if (onInfoListener instanceof hd) {
                    return;
                }
            } else {
                fieldM2823 = m2823(MediaPlayer.class, m2822(new int[]{1943601247, -1942616235, -2100079906, -1263559470, -1275788329, -1212074022, 1063346278, 148426215}, View.MeasureSpec.getSize(0) + 15).intern());
                onInfoListener = (MediaPlayer.OnInfoListener) fieldM2823.get(mediaPlayer);
                if (onInfoListener instanceof hd) {
                    return;
                }
            }
            fieldM2823.set(mediaPlayer, new hd(onInfoListener, dVar));
            f2923 = (f2924 + 41) % 128;
        } catch (Exception e) {
            kd.m2919(m2822(new int[]{-1707449474, -1441527061, 591634003, 61502831, -1783278720, -776538056}, 12 - Color.argb(0, 0, 0, 0)).intern(), m2822(new int[]{2016948475, -1418756443, 955326951, -368561244, 252132825, 2301349, 259336711, -2100658241, -131054661, 1765211421, -1017957212, -663049638, -2100079906, -1263559470, -1275788329, -1212074022, 1063346278, 148426215}, 35 - Gravity.getAbsoluteGravity(0, 0)).intern(), e, false);
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static Field m2823(Class cls, String str) {
        f2923 = (f2924 + 13) % 128;
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            f2924 = (f2923 + 61) % 128;
            return declaredField;
        } catch (Exception e) {
            kd.m2919(m2822(new int[]{-1707449474, -1441527061, 591634003, 61502831, -1783278720, -776538056}, 13 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))).intern(), m2822(new int[]{2016948475, -1418756443, 955326951, -368561244, -1738249110, 1879934454, -444072667, -992582106, -2113456868, -1763255163, -1312913038, 1055449515, -176758128, 1267805313}, 25 - View.MeasureSpec.getSize(0)).intern(), e, false);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0044, code lost:
    
        if (r0 != null) goto L11;
     */
    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.media.MediaPlayer m2826(android.widget.VideoView r6) {
        /*
            int r0 = com.ironsource.adqualitysdk.sdk.i.jy.f2924
            int r0 = r0 + 117
            int r1 = r0 % 128
            com.ironsource.adqualitysdk.sdk.i.jy.f2923 = r1
            int r0 = r0 % 2
            r1 = 6
            java.lang.Class<android.widget.VideoView> r2 = android.widget.VideoView.class
            r3 = 0
            if (r0 == 0) goto L2d
            int[] r0 = new int[r1]     // Catch: java.lang.Exception -> L2b
            r0 = {x0086: FILL_ARRAY_DATA , data: [1198095324, 659109241, -940578338, 1009080871, -1237471369, -972719139} // fill-array     // Catch: java.lang.Exception -> L2b
            r4 = 1
            int r4 = android.graphics.Color.red(r4)     // Catch: java.lang.Exception -> L2b
            int r4 = 94 - r4
            java.lang.String r0 = m2822(r0, r4)     // Catch: java.lang.Exception -> L2b
            java.lang.String r0 = r0.intern()     // Catch: java.lang.Exception -> L2b
            java.lang.reflect.Field r0 = m2823(r2, r0)     // Catch: java.lang.Exception -> L2b
            if (r0 == 0) goto L4d
            goto L46
        L2b:
            r6 = move-exception
            goto L56
        L2d:
            int[] r0 = new int[r1]     // Catch: java.lang.Exception -> L2b
            r0 = {x0096: FILL_ARRAY_DATA , data: [1198095324, 659109241, -940578338, 1009080871, -1237471369, -972719139} // fill-array     // Catch: java.lang.Exception -> L2b
            int r4 = android.graphics.Color.red(r3)     // Catch: java.lang.Exception -> L2b
            int r4 = r4 + 12
            java.lang.String r0 = m2822(r0, r4)     // Catch: java.lang.Exception -> L2b
            java.lang.String r0 = r0.intern()     // Catch: java.lang.Exception -> L2b
            java.lang.reflect.Field r0 = m2823(r2, r0)     // Catch: java.lang.Exception -> L2b
            if (r0 == 0) goto L4d
        L46:
            java.lang.Object r6 = r0.get(r6)     // Catch: java.lang.Exception -> L2b
            android.media.MediaPlayer r6 = (android.media.MediaPlayer) r6     // Catch: java.lang.Exception -> L2b
            return r6
        L4d:
            int r6 = com.ironsource.adqualitysdk.sdk.i.jy.f2923
            int r6 = r6 + 9
            int r6 = r6 % 128
            com.ironsource.adqualitysdk.sdk.i.jy.f2924 = r6
            goto L83
        L56:
            int[] r0 = new int[r1]
            r0 = {x00a6: FILL_ARRAY_DATA , data: [-1707449474, -1441527061, 591634003, 61502831, -1783278720, -776538056} // fill-array
            int r1 = android.view.ViewConfiguration.getMaximumDrawingCacheSize()
            int r1 = r1 >> 24
            int r1 = 12 - r1
            java.lang.String r0 = m2822(r0, r1)
            java.lang.String r0 = r0.intern()
            r1 = 115(0x73, float:1.61E-43)
            r2 = 5
            r4 = 57
            r5 = 23
            int[] r1 = new int[]{r4, r5, r1, r2}
            java.lang.String r2 = "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0001"
            java.lang.String r1 = m2827(r2, r3, r1)
            java.lang.String r1 = r1.intern()
            com.ironsource.adqualitysdk.sdk.i.kd.m2919(r0, r1, r6, r3)
        L83:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.jy.m2826(android.widget.VideoView):android.media.MediaPlayer");
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m2822(int[] iArr, int i2) {
        String str;
        synchronized (d.f1664) {
            try {
                char[] cArr = new char[4];
                char[] cArr2 = new char[iArr.length << 1];
                int[] iArr2 = (int[]) f2922.clone();
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

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static void m2830(MediaPlayer mediaPlayer, he.b bVar) {
        f2923 = (f2924 + 113) % 128;
        try {
            Field fieldM2823 = m2823(MediaPlayer.class, m2822(new int[]{301997266, 816003585, -664928304, 404213110, 1098061534, -1511375635, -633331493, -1237452946, 473380455, 168983151, 1273013730, 1866602811}, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 20).intern());
            MediaPlayer.OnCompletionListener onCompletionListener = (MediaPlayer.OnCompletionListener) fieldM2823.get(mediaPlayer);
            if (onCompletionListener instanceof he) {
                return;
            }
            fieldM2823.set(mediaPlayer, new he(onCompletionListener, bVar));
            f2924 = (f2923 + 37) % 128;
        } catch (Exception e) {
            kd.m2919(m2822(new int[]{-1707449474, -1441527061, 591634003, 61502831, -1783278720, -776538056}, 12 - View.combineMeasuredStates(0, 0)).intern(), m2827("\u0001\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0000\u0001\u0001\u0000\u0001\u0000\u0000\u0000\u0001", false, new int[]{80, 41, 0, 23}).intern(), e, false);
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static void m2818(MediaPlayer mediaPlayer, hj.e eVar) {
        f2923 = (f2924 + 43) % 128;
        try {
            Field fieldM2823 = m2823(MediaPlayer.class, m2822(new int[]{1542526115, 1720958894, 870891566, -1873840768, -664928304, 404213110, 1839365721, 1150317957, -1275788329, -1212074022, 1063346278, 148426215}, 23 - Color.alpha(0)).intern());
            MediaPlayer.OnSeekCompleteListener onSeekCompleteListener = (MediaPlayer.OnSeekCompleteListener) fieldM2823.get(mediaPlayer);
            if (!(onSeekCompleteListener instanceof hj)) {
                fieldM2823.set(mediaPlayer, new hj(onSeekCompleteListener, eVar));
            }
            int i2 = f2923 + 39;
            f2924 = i2 % 128;
            if (i2 % 2 == 0) {
                throw null;
            }
        } catch (Exception e) {
            kd.m2919(m2822(new int[]{-1707449474, -1441527061, 591634003, 61502831, -1783278720, -776538056}, TextUtils.getOffsetBefore("", 0) + 12).intern(), m2827("\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0000\u0001\u0001\u0000\u0001\u0000\u0000\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001", false, new int[]{179, 38, 0, 0}).intern(), e, false);
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static List<View> m2829(Class cls, Object obj) throws Exception {
        int i2 = (f2924 + 65) % 128;
        f2923 = i2;
        if (f2926 == null) {
            f2924 = (i2 + 53) % 128;
            Field declaredField = cls.getDeclaredField(m2827("\u0001\u0001\u0001\u0000\u0000\u0000", false, new int[]{Sdk.SDKError.Reason.AD_RESPONSE_TIMED_OUT_VALUE, 6, 0, 0}).intern());
            f2926 = declaredField;
            declaredField.setAccessible(true);
        }
        Object obj2 = f2926.get(obj);
        if (obj2 instanceof List) {
            return (List) f2926.get(obj);
        }
        if (obj2 instanceof View[]) {
            int i8 = f2923 + 63;
            f2924 = i8 % 128;
            if (i8 % 2 != 0) {
                return Arrays.asList((View[]) f2926.get(obj));
            }
            Arrays.asList((View[]) f2926.get(obj));
            throw null;
        }
        ArrayList arrayList = new ArrayList();
        int i9 = f2923 + 87;
        f2924 = i9 % 128;
        if (i9 % 2 != 0) {
            return arrayList;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m2827(String str, boolean z2, int[] iArr) throws UnsupportedEncodingException {
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
                System.arraycopy(f2925, i2, cArr, 0, i8);
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
