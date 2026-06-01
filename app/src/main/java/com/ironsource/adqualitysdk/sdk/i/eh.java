package com.ironsource.adqualitysdk.sdk.i;

import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.vungle.ads.internal.protos.Sdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class eh extends ee {

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static int f1969 = 1;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f1970 = 0;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static long f1971 = 0;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f1972 = 0;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static char f1973 = 3970;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private ee f1974;

    public eh(ee eeVar, Cdo cdo) {
        super(cdo);
        this.f1974 = eeVar;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m2197(String str, char c7, String str2, int i2, String str3) {
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
                        cArr6[i12] = (char) (((((long) (c9 ^ cArr2[i12])) ^ f1971) ^ ((long) f1972)) ^ ((long) f1973));
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

    public final boolean equals(Object obj) {
        if (this == obj) {
            f1970 = (f1969 + 3) % 128;
            return true;
        }
        if (obj != null && eh.class == obj.getClass()) {
            eh ehVar = (eh) obj;
            ee eeVar = this.f1974;
            if (eeVar != null) {
                int i2 = f1970 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE;
                f1969 = i2 % 128;
                int i8 = i2 % 2;
                ee eeVar2 = ehVar.f1974;
                if (i8 != 0) {
                    return eeVar.equals(eeVar2);
                }
                eeVar.equals(eeVar2);
                throw null;
            }
            if (ehVar.f1974 == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = (f1970 + 93) % 128;
        f1969 = i2;
        ee eeVar = this.f1974;
        if (eeVar == null) {
            return 0;
        }
        f1970 = (i2 + 51) % 128;
        int iHashCode = eeVar.hashCode();
        int i8 = f1970 + 75;
        f1969 = i8 % 128;
        if (i8 % 2 == 0) {
            int i9 = 92 / 0;
        }
        return iHashCode;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(m2197("ĸ\uf3f0\uf3c8⫋", (char) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 52211), "㘰", (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) - 923537407, "\u0000\u0000\u0000\u0000").intern());
        sb.append(this.f1974);
        String strZ = com.google.android.gms.ads.internal.client.a.z(sb, m2197("鄦藛괱籔", (char) (KeyEvent.getDeadChar(0, 0) + 21677), "⚠", 830856080 - MotionEvent.axisFromString(""), "\u0000\u0000\u0000\u0000"));
        int i2 = f1970 + 59;
        f1969 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 63 / 0;
        }
        return strZ;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.ee
    /* JADX INFO: renamed from: ﻛ */
    public final du mo2156(ds dsVar, cp cpVar) {
        f1969 = (f1970 + 13) % 128;
        du duVarM2189 = this.f1974.m2189(dsVar, cpVar);
        f1969 = (f1970 + 97) % 128;
        return duVarM2189;
    }
}
