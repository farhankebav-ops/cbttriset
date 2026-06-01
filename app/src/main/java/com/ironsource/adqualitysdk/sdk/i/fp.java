package com.ironsource.adqualitysdk.sdk.i;

import android.os.Process;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.vungle.ads.internal.protos.Sdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class fp extends fr {

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static char f2076 = 0;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static int f2077 = 1;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static int f2078 = 0;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static int f2079 = 0;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static long f2080 = -4804290414751191468L;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private fr f2081;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private ee f2082;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private ee f2083;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private ee f2084;

    public fp(ee eeVar, ee eeVar2, ee eeVar3, fr frVar) {
        this.f2083 = eeVar;
        this.f2082 = eeVar2;
        this.f2084 = eeVar3;
        this.f2081 = frVar;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static du m2234(ee eeVar, ds dsVar, cp cpVar) {
        int i2 = f2079;
        int i8 = i2 + 93;
        f2077 = i8 % 128;
        if (i8 % 2 == 0) {
            throw null;
        }
        if (eeVar != null) {
            f2077 = (i2 + 21) % 128;
            return eeVar.m2189(dsVar, cpVar);
        }
        du duVar = new du(null);
        int i9 = f2079 + 57;
        f2077 = i9 % 128;
        if (i9 % 2 != 0) {
            return duVar;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m2235(String str, char c7, String str2, int i2, String str3) {
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
                        cArr6[i12] = (char) (((((long) (c9 ^ cArr2[i12])) ^ f2080) ^ ((long) f2078)) ^ ((long) f2076));
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
        f2077 = (f2079 + 97) % 128;
        if (this == obj) {
            return true;
        }
        if (obj == null || fp.class != obj.getClass()) {
            f2079 = (f2077 + 27) % 128;
            return false;
        }
        fp fpVar = (fp) obj;
        ee eeVar = this.f2083;
        if (eeVar == null ? fpVar.f2083 != null : !eeVar.equals(fpVar.f2083)) {
            return false;
        }
        ee eeVar2 = this.f2082;
        if (eeVar2 == null ? fpVar.f2082 != null : !eeVar2.equals(fpVar.f2082)) {
            return false;
        }
        ee eeVar3 = this.f2084;
        if (eeVar3 == null ? fpVar.f2084 != null : !eeVar3.equals(fpVar.f2084)) {
            return false;
        }
        fr frVar = this.f2081;
        if (frVar == null) {
            if (fpVar.f2081 != null) {
                return false;
            }
            f2079 = (f2077 + 109) % 128;
            return true;
        }
        int i2 = f2079 + 71;
        f2077 = i2 % 128;
        int i8 = i2 % 2;
        fr frVar2 = fpVar.f2081;
        if (i8 != 0) {
            return frVar.equals(frVar2);
        }
        frVar.equals(frVar2);
        throw null;
    }

    public final int hashCode() {
        int iHashCode;
        int iHashCode2;
        int iHashCode3;
        int i2 = f2077 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE;
        int i8 = i2 % 128;
        f2079 = i8;
        if (i2 % 2 != 0) {
            throw null;
        }
        ee eeVar = this.f2083;
        if (eeVar != null) {
            int i9 = i8 + 61;
            f2077 = i9 % 128;
            if (i9 % 2 == 0) {
                eeVar.hashCode();
                throw null;
            }
            iHashCode = eeVar.hashCode();
        } else {
            iHashCode = 0;
        }
        int i10 = iHashCode * 31;
        ee eeVar2 = this.f2082;
        if (eeVar2 != null) {
            int i11 = f2077 + 65;
            f2079 = i11 % 128;
            if (i11 % 2 != 0) {
                iHashCode2 = eeVar2.hashCode();
                int i12 = 98 / 0;
            } else {
                iHashCode2 = eeVar2.hashCode();
            }
        } else {
            iHashCode2 = 0;
        }
        int i13 = (i10 + iHashCode2) * 31;
        ee eeVar3 = this.f2084;
        if (eeVar3 != null) {
            int i14 = f2077 + 41;
            f2079 = i14 % 128;
            if (i14 % 2 != 0) {
                iHashCode3 = eeVar3.hashCode();
                int i15 = 29 / 0;
            } else {
                iHashCode3 = eeVar3.hashCode();
            }
        } else {
            f2077 = (f2079 + 19) % 128;
            iHashCode3 = 0;
        }
        int i16 = (i13 + iHashCode3) * 31;
        fr frVar = this.f2081;
        return i16 + (frVar != null ? frVar.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(m2235("료臐\uf27e㠴", (char) (((Process.getThreadPriority(0) + 20) >> 6) + 13554), "菀\uec05豑ယ\ue46f", 2122436792 - (Process.myTid() >> 22), "\uee54滰뭒뵓").intern());
        ee eeVar = this.f2083;
        if (eeVar != null) {
            int i2 = f2079 + 45;
            f2077 = i2 % 128;
            if (i2 % 2 == 0) {
                sb.append(eeVar);
                int i8 = 98 / 0;
            } else {
                sb.append(eeVar);
            }
        }
        sb.append(m2235("蕉歕迳⯹", (char) (TextUtils.getOffsetBefore("", 0) + 63887), "璞㪛", ViewConfiguration.getScrollDefaultDelay() >> 16, "\uee54滰뭒뵓").intern());
        sb.append(this.f2082);
        sb.append(m2235("蕉歕迳⯹", (char) (KeyEvent.getDeadChar(0, 0) + 63887), "璞㪛", TextUtils.getCapsMode("", 0, 0), "\uee54滰뭒뵓").intern());
        ee eeVar2 = this.f2084;
        if (eeVar2 != null) {
            f2079 = (f2077 + 85) % 128;
            sb.append(eeVar2);
        }
        sb.append(m2235("鱘᷄ᒭඣ", (char) (41748 - TextUtils.indexOf("", "")), "適\uab17", View.MeasureSpec.getSize(0), "\uee54滰뭒뵓").intern());
        sb.append(this.f2081);
        return sb.toString();
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.fr
    /* JADX INFO: renamed from: ﻐ */
    public final du mo2225(ds dsVar, cp cpVar) {
        int i2 = f2077 + 71;
        f2079 = i2 % 128;
        if (i2 % 2 != 0) {
            m2234(this.f2083, dsVar, cpVar);
            throw null;
        }
        m2234(this.f2083, dsVar, cpVar);
        while (this.f2082.m2189(dsVar, cpVar).m2150()) {
            int i8 = f2079 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE;
            f2077 = i8 % 128;
            if (i8 % 2 == 0) {
                this.f2081.mo2225(dsVar, cpVar).m2154();
                throw null;
            }
            du duVarMo2225 = this.f2081.mo2225(dsVar, cpVar);
            if (duVarMo2225.m2154()) {
                break;
            }
            if (duVarMo2225.m2151()) {
                int i9 = f2079 + 23;
                f2077 = i9 % 128;
                if (i9 % 2 == 0) {
                    int i10 = 60 / 0;
                }
                return duVarMo2225;
            }
            m2234(this.f2084, dsVar, cpVar);
        }
        return new du(null);
    }
}
