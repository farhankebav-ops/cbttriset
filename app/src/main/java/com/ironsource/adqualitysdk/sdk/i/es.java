package com.ironsource.adqualitysdk.sdk.i;

import android.text.TextUtils;
import com.vungle.ads.internal.protos.Sdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class es extends el {

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static int f2003 = 1;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static char f2004 = 23816;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static char f2005 = 33497;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static char f2006 = 45237;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f2007 = 0;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static char f2008 = 13566;

    public es(ee eeVar, ee eeVar2, Cdo cdo) {
        super(eeVar, eeVar2, cdo);
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.el
    /* JADX INFO: renamed from: ﻛ */
    public final boolean mo2204(Object obj, Object obj2) {
        int i2 = f2003 + 103;
        int i8 = i2 % 128;
        f2007 = i8;
        if (i2 % 2 != 0) {
            throw null;
        }
        if (obj != obj2) {
            return false;
        }
        int i9 = i8 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE;
        f2003 = i9 % 128;
        return i9 % 2 != 0;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.el
    /* JADX INFO: renamed from: ｋ */
    public final boolean mo2205(int i2) {
        int i8 = f2007 + 3;
        int i9 = i8 % 128;
        f2003 = i9;
        if (i8 % 2 == 0) {
            throw null;
        }
        if (i2 == 0) {
            return true;
        }
        f2007 = (i9 + 97) % 128;
        return false;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.eg
    /* JADX INFO: renamed from: ﻛ */
    public final String mo2195() {
        f2003 = (f2007 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
        String strIntern = m2213("叟灇", TextUtils.getCapsMode("", 0, 0) + 2).intern();
        int i2 = f2007 + 29;
        f2003 = i2 % 128;
        if (i2 % 2 != 0) {
            return strIntern;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.el
    /* JADX INFO: renamed from: ｋ */
    public final boolean mo2206(String str, String str2) {
        f2003 = (f2007 + 67) % 128;
        boolean zEquals = str.equals(str2);
        f2003 = (f2007 + 113) % 128;
        return zEquals;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m2213(String str, int i2) {
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
                            char c9 = (char) (c7 - (((c8 + i9) ^ ((c8 << 4) + f2005)) ^ ((c8 >>> 5) + f2006)));
                            cArr3[1] = c9;
                            cArr3[0] = (char) (c8 - (((c9 >>> 5) + f2004) ^ ((c9 + i9) ^ ((c9 << 4) + f2008))));
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
}
