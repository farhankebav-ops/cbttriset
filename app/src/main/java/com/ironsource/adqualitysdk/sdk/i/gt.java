package com.ironsource.adqualitysdk.sdk.i;

import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.ogury.ad.OguryReward;
import com.vungle.ads.internal.protos.Sdk;
import io.presage.Presage;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class gt extends gk {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int[] f2222 = {930799085, -283775668, 784808802, 1550604047, 679766051, 1084462479, -1476998636, 2064875382, -1717347803, 27682390, 17009683, 96445115, 156809764, 829696164, -1734920438, 1436704840, 304865201, 231600766};

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f2223 = 1;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static int f2224;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class b extends gk {

        /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
        private static int f2225 = 1;

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private static char f2226 = 35782;

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private static int f2227 = 0;

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private static char f2228 = 55659;

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private static char f2229 = 46870;

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private static char f2230 = 9662;

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private static String m2273(String str, int i2) {
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
                                char c9 = (char) (c7 - (((c8 + i9) ^ ((c8 << 4) + f2226)) ^ ((c8 >>> 5) + f2230)));
                                cArr3[1] = c9;
                                cArr3[0] = (char) (c8 - (((c9 >>> 5) + f2229) ^ ((c9 + i9) ^ ((c9 << 4) + f2228))));
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

        @Override // com.ironsource.adqualitysdk.sdk.i.gk
        /* JADX INFO: renamed from: ﻐ */
        public final String mo2240() {
            f2227 = (f2225 + 73) % 128;
            String strIntern = m2273("ڗ輂炌ዬזּ\ue792", 5 - (ViewConfiguration.getTapTimeout() >> 16)).intern();
            f2225 = (f2227 + 15) % 128;
            return strIntern;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.gk
        /* JADX INFO: renamed from: ﻛ */
        public final Class mo2241() {
            int i2 = f2225;
            f2227 = (i2 + 99) % 128;
            int i8 = i2 + 115;
            f2227 = i8 % 128;
            if (i8 % 2 == 0) {
                return OguryReward.class;
            }
            throw null;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.gk
        /* JADX INFO: renamed from: ﾇ */
        public final bg mo2242() {
            bz bzVar = new bz(mo2240());
            int i2 = f2225 + 87;
            f2227 = i2 % 128;
            if (i2 % 2 != 0) {
                int i8 = 32 / 0;
            }
            return bzVar;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.gk
        /* JADX INFO: renamed from: ﾒ */
        public final String mo2243() {
            int i2 = f2227 + 113;
            f2225 = i2 % 128;
            return m2273("\uf226\udf8a⹍팛ڗ輂炌ዬ耪浌\ued3a閪㰮پ戴䐂⋣搷韺쾇敞䥆\uf177\ue0e5", i2 % 2 == 0 ? ViewConfiguration.getLongPressTimeout() * TypedValues.Custom.TYPE_STRING : 24 - (ViewConfiguration.getLongPressTimeout() >> 16)).intern();
        }
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻐ */
    public final String mo2240() {
        int i2 = f2224 + 89;
        f2223 = i2 % 128;
        return (i2 % 2 == 0 ? m2272(new int[]{-570995582, 1365358459, -1604324763, -1424340170}, 5 / View.combineMeasuredStates(1, 1)) : m2272(new int[]{-570995582, 1365358459, -1604324763, -1424340170}, View.combineMeasuredStates(0, 0) + 5)).intern();
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻛ */
    public final Class mo2241() {
        int i2 = f2224 + 5;
        f2223 = i2 % 128;
        if (i2 % 2 != 0) {
            return Presage.class;
        }
        int i8 = 79 / 0;
        return Presage.class;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾇ */
    public final bg mo2242() {
        ca caVar = new ca(mo2240());
        f2223 = (f2224 + 19) % 128;
        return caVar;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾒ */
    public final String mo2243() {
        int i2 = f2223 + 1;
        f2224 = i2 % 128;
        String strIntern = (i2 % 2 != 0 ? m2272(new int[]{120849321, 2086902534, -1074874137, -1111997718, -1521863757, 663215572, -1074874137, -1111997718, -1671005845, -2080980542}, ExpandableListView.getPackedPositionChild(0L) * Sdk.SDKError.Reason.TPAT_ERROR_VALUE) : m2272(new int[]{120849321, 2086902534, -1074874137, -1111997718, -1521863757, 663215572, -1074874137, -1111997718, -1671005845, -2080980542}, 17 - ExpandableListView.getPackedPositionChild(0L))).intern();
        int i8 = f2224 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE;
        f2223 = i8 % 128;
        if (i8 % 2 == 0) {
            int i9 = 68 / 0;
        }
        return strIntern;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m2272(int[] iArr, int i2) {
        String str;
        synchronized (d.f1664) {
            try {
                char[] cArr = new char[4];
                char[] cArr2 = new char[iArr.length << 1];
                int[] iArr2 = (int[]) f2222.clone();
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
