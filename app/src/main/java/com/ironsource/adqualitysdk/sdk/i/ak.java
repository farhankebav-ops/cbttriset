package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import com.vungle.ads.internal.protos.Sdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ak {

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static int f339 = 1;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static char f340;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static char f341;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static int f342;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static char f343;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static char f344;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private String f346 = m502("\ueccd헶ﹳꐞ\ude96쟝制⤇莇ࣖ┙녕壯뗩苾➓醹泽䎡鯏㘲㉛Ꞧ纪녢␒Ⅷ\uf14e㓼罺䅸彪랹\u0a12扣\uf6d5", 36 - (SystemClock.uptimeMillis() > 0 ? 1 : (SystemClock.uptimeMillis() == 0 ? 0 : -1))).intern();

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private String f345 = m502("\ueccd헶ﹳꐞ\ude96쟝制⤇ᯄ㷎┙녕壯뗩苾➓醹泽䎡鯏㘲㉛Ꞧ纪녢␒Ⅷ\uf14e㓼罺䅸彪랹\u0a12扣\uf6d5", TextUtils.indexOf("", "", 0, 0) + 35).intern();

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private String f347 = m502("\ueccd헶ﹳꐞ\ude96쟝制⤇⊘ﾉ┙녕壯뗩苾➓醹泽䎡鯏㘲㉛Ꞧ纪녢␒Ⅷ\uf14e㓼罺䅸彪랹\u0a12扣\uf6d5", 35 - TextUtils.getOffsetAfter("", 0)).intern();

    static {
        m500();
        m502("\uf1b4鷏儓ꪏꃙ襩ⶂ\u05f8앻힝鳐팿۞\ue064꯴\ud959", TextUtils.lastIndexOf("", '0', 0, 0) + 16).intern();
        int i2 = f342 + 83;
        f339 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    public ak() {
        m502("㘈䪫⋗ࢃ⡦䱄⋗ࢃ땱뼡꤄\uf2d8㨪鋂ꏇ叧", View.getDefaultSize(0, 0) + 15).intern();
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static void m500() {
        f341 = (char) 44332;
        f344 = (char) 28673;
        f340 = (char) 59201;
        f343 = (char) 21120;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static String m501() {
        f339 = (f342 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE) % 128;
        String strIntern = m502("㘈䪫⋗ࢃ⡦䱄⋗ࢃ땱뼡꤄\uf2d8㨪鋂ꏇ叧", Color.red(0) + 15).intern();
        int i2 = f339 + 87;
        f342 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 7 / 0;
        }
        return strIntern;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final String m505() {
        int i2 = f342;
        String str = this.f346;
        f339 = (i2 + 73) % 128;
        return str;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final String m507(String str) {
        int i2 = f339 + 75;
        f342 = i2 % 128;
        if (i2 % 2 != 0) {
            m503(this.f345, str);
            throw null;
        }
        String strM503 = m503(this.f345, str);
        int i8 = f339 + 73;
        f342 = i8 % 128;
        if (i8 % 2 != 0) {
            int i9 = 42 / 0;
        }
        return strM503;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m502(String str, int i2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (o.f2985) {
            try {
                char[] cArr2 = new char[cArr.length];
                o.f2986 = 0;
                char[] cArr3 = new char[2];
                while (true) {
                    int i8 = o.f2986;
                    if (i8 < cArr.length) {
                        cArr3[0] = cArr[i8];
                        cArr3[1] = cArr[i8 + 1];
                        int i9 = 58224;
                        for (int i10 = 0; i10 < 16; i10++) {
                            char c7 = cArr3[1];
                            char c8 = cArr3[0];
                            char c9 = (char) (c7 - (((c8 + i9) ^ ((c8 << 4) + f341)) ^ ((c8 >>> 5) + f340)));
                            cArr3[1] = c9;
                            cArr3[0] = (char) (c8 - (((c9 >>> 5) + f344) ^ ((c9 + i9) ^ ((c9 << 4) + f343))));
                            i9 -= 40503;
                        }
                        int i11 = o.f2986;
                        cArr2[i11] = cArr3[0];
                        cArr2[i11 + 1] = cArr3[1];
                        o.f2986 = i11 + 2;
                    } else {
                        str2 = new String(cArr2, 0, i2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m503(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = "";
        }
        sb.append(str);
        sb.append(m502("ၺ汞", 1 - Gravity.getAbsoluteGravity(0, 0)).intern());
        if (str2 != null) {
            f339 = (f342 + 11) % 128;
        } else {
            str2 = "";
        }
        sb.append(str2);
        String string = sb.toString();
        f339 = (f342 + 91) % 128;
        return string;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final String m504(String str) {
        int i2 = f339 + 51;
        f342 = i2 % 128;
        if (i2 % 2 != 0) {
            m503(this.f346, str);
            throw null;
        }
        String strM503 = m503(this.f346, str);
        f342 = (f339 + 33) % 128;
        return strM503;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final String m506() {
        int i2 = (f342 + 29) % 128;
        f339 = i2;
        String str = this.f347;
        f342 = (i2 + 25) % 128;
        return str;
    }
}
