package com.ironsource.adqualitysdk.sdk.i;

import android.media.AudioTrack;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class em extends ee {

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f1990 = 1;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f1991;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static int[] f1992 = {-2002080791, -51528864, -551116782, 786789840, -1949180761, -1005955512, -1042971662, -1042815385, -1248218234, 465343091, 258255428, 841309549, 1245560600, 513696751, 1664105015, -330481033, 1630909286, -1073472269};

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private String f1993;

    public em(String str, Cdo cdo) {
        super(cdo);
        this.f1993 = dy.m2174(str);
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m2207(int[] iArr, int i2) {
        String str;
        synchronized (d.f1664) {
            try {
                char[] cArr = new char[4];
                char[] cArr2 = new char[iArr.length << 1];
                int[] iArr2 = (int[]) f1992.clone();
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

    public final boolean equals(Object obj) {
        if (this == obj) {
            int i2 = f1991 + 103;
            f1990 = i2 % 128;
            return i2 % 2 != 0;
        }
        if (obj == null || em.class != obj.getClass()) {
            return false;
        }
        boolean zEquals = this.f1993.equals(((em) obj).f1993);
        f1990 = (f1991 + 53) % 128;
        return zEquals;
    }

    public final int hashCode() {
        int i2 = f1991 + 107;
        int i8 = i2 % 128;
        f1990 = i8;
        if (i2 % 2 == 0) {
            throw null;
        }
        String str = this.f1993;
        if (str != null) {
            int iHashCode = str.hashCode();
            f1991 = (f1990 + 55) % 128;
            return iHashCode;
        }
        int i9 = i8 + 11;
        f1991 = i9 % 128;
        if (i9 % 2 == 0) {
            return 0;
        }
        throw null;
    }

    public final String toString() {
        int i2 = f1990 + 77;
        f1991 = i2 % 128;
        if (i2 % 2 == 0) {
            return m2208();
        }
        m2208();
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final String m2208() {
        int i2 = f1990;
        int i8 = i2 + 5;
        f1991 = i8 % 128;
        if (i8 % 2 != 0) {
            throw null;
        }
        String str = this.f1993;
        f1991 = (i2 + 35) % 128;
        return str;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.ee
    /* JADX INFO: renamed from: ﻛ */
    public final du mo2156(ds dsVar, cp cpVar) {
        try {
            return new du(dsVar.m2136(m2208()));
        } catch (Exception e) {
            dq dqVarM1729 = cpVar.m1729(m2208());
            if (dqVarM1729 != null) {
                return new du(dqVarM1729);
            }
            String strM1723 = cpVar.m1723();
            StringBuilder sb = new StringBuilder();
            sb.append(m2207(new int[]{1870176689, 1525152017, -185096401, 1489983307, -397235227, 2021718326, 1488656948, -232627910, -478678032, 516040955, -1568532006, 1432229200, -1310798347, 851920209}, 28 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1))).intern());
            sb.append(this);
            sb.append(m2190());
            co.m1671(strM1723, sb.toString(), e);
            du duVar = new du(null);
            int i2 = f1990 + 97;
            f1991 = i2 % 128;
            if (i2 % 2 != 0) {
                int i8 = 50 / 0;
            }
            return duVar;
        }
    }
}
