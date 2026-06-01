package com.ironsource.adqualitysdk.sdk.i;

import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class jw {

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static int f2907 = 1;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static char f2908 = 61094;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static char f2909 = 7370;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static char f2910 = 26522;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f2911 = 0;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static char f2912 = 48062;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m2808(String str, int i2) {
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
                            char c9 = (char) (c7 - (((c8 + i9) ^ ((c8 << 4) + f2910)) ^ ((c8 >>> 5) + f2912)));
                            cArr3[1] = c9;
                            cArr3[0] = (char) (c8 - (((c9 >>> 5) + f2909) ^ ((c9 + i9) ^ ((c9 << 4) + f2908))));
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
    public static String m2809(String str) {
        try {
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(new SecretKeySpec(m2808("▯ꖮ᧱妺㠥뵈ῴ症돟疅웘\uf70d\ue458\ud834\u0ef2淸涝\ue592僡Ꝕ任絰㫉솎ॾ\ue6b1䢊돣澣♉膨ᦠ鳪ﴞ", 33 - ExpandableListView.getPackedPositionChild(0L)).intern().getBytes(m2808("庎錹컻渶勼횰", 6 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))).intern()), mac.getAlgorithm()));
            String strM2504 = ic.m2504(mac.doFinal(str.replaceAll(m2808("ᱵ蹲", 1 - TextUtils.indexOf("", "", 0, 0)).intern(), "").replaceAll(m2808("\ue20fɰ", (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 1).intern(), "").getBytes(m2808("庎錹컻渶勼횰", (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 5).intern())));
            f2907 = (f2911 + 57) % 128;
            return strM2504;
        } catch (Exception e) {
            String strIntern = m2808("銏矺丛⼇ᮮ톈涀\uf3fc\udbef俚", AndroidCharacter.getMirror('0') - '\'').intern();
            StringBuilder sb = new StringBuilder();
            sb.append(m2808("㘃߄\ue99c\uefb0潈뙇ᱵ蹲", 7 - (ViewConfiguration.getFadingEdgeLength() >> 16)).intern());
            sb.append(e.getLocalizedMessage());
            k.m2863(strIntern, sb.toString());
            return null;
        }
    }
}
