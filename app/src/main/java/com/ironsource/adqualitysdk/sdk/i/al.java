package com.ironsource.adqualitysdk.sdk.i;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Process;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class al {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static long f348 = 0;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f349 = 2091596816;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f350 = 1;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f351;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static char f352;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static void m508(Object obj, BroadcastReceiver broadcastReceiver) {
        f351 = (f350 + 69) % 128;
        try {
            jz.m2842(obj, m509("큸䘲搻헙", (char) (55652 - (ViewConfiguration.getScrollBarSize() >> 8)), "ű\ue474ὲ濔垆檦ﱊ踶\ue1e5놲谢됙텁澞\ud9a9䛓뙯㫥", ViewConfiguration.getWindowTouchSlop() >> 8, "\u0000\u0000\u0000\u0000").intern(), Arrays.asList(broadcastReceiver)).invoke(obj, broadcastReceiver);
            f350 = (f351 + 65) % 128;
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static void m510(Object obj, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        f351 = (f350 + 63) % 128;
        try {
            jz.m2842(obj, m509("ǟ酢ᕖ蘮", (char) (View.resolveSizeAndState(0, 0, 0) + 11797), "︅ᨛ쯁\u0dfdꀹ䝈뱪籄篜㮂\uea6b媮⦻膕鳸হ", Process.myTid() >> 22, "\u0000\u0000\u0000\u0000").intern(), Arrays.asList(broadcastReceiver, intentFilter)).invoke(obj, broadcastReceiver, intentFilter);
            f350 = (f351 + 1) % 128;
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static Object m511(Context context) {
        f350 = (f351 + 83) % 128;
        try {
            return jz.m2842(m512(), m509("罆\ue992ᆒ춫", (char) View.MeasureSpec.getMode(0), "쨪³\ue5af洨琏\ue270\ue289횢讯땘몑", (-1830186369) - (ViewConfiguration.getDoubleTapTimeout() >> 16), "\u0000\u0000\u0000\u0000").intern(), Arrays.asList(context)).invoke(null, context);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            f351 = (f350 + 39) % 128;
            return null;
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static Class m512() {
        f350 = (f351 + 9) % 128;
        Class clsM2840 = jz.m2840(m509("ｔ眆牢\ue5ca", (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16), "鵡劆崄⫗\uf86e䕗漖ﭝꃧ縣௦槾㉸㉒⨼\ud962傱誖茓㵋ꣴ辡⊘ᯇȇ瀛靎쟭\uf24b븼䎕䠪琩ର綮罻됈埥ᡤ膰\ueb8cÁ䀕\uec03鸈戀燩\ue5e2ᑦ氍ꅹ孚\ue056誋軤蛱\ue572妋\uf408\ude8b", KeyEvent.getMaxKeyCode() >> 16, "\u0000\u0000\u0000\u0000").intern(), false);
        f351 = (f350 + 73) % 128;
        return clsM2840;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m509(String str, char c7, String str2, int i2, String str3) {
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
                        cArr6[i12] = (char) (((((long) (c9 ^ cArr2[i12])) ^ f348) ^ ((long) f349)) ^ ((long) f352));
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
