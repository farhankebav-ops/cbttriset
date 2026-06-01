package com.ironsource.adqualitysdk.sdk.i;

import android.media.AudioTrack;
import com.ironsource.adqualitysdk.sdk.ISAdQualityDeviceIdType;
import com.vungle.ads.internal.protos.Sdk;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class as {

    /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
    private static boolean f419 = true;

    /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
    private static int f420 = 1;

    /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
    private static int f421 = 0;

    /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
    private static boolean f422 = true;

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static char[] f423 = {176, 177, 182, 193, 181, 167};

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static int f424 = 98;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private ISAdQualityDeviceIdType f427;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private String f430 = "";

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private String f429 = m612(null, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 126, null, "\u0083\u0086\u0085\u0084\u0083\u0082\u0081").intern();

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private boolean f431 = true;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private String f428 = "";

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private boolean f432 = false;

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private Map<String, String> f425 = new HashMap();

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private boolean f426 = false;

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    public final ISAdQualityDeviceIdType m613() {
        int i2 = f421;
        ISAdQualityDeviceIdType iSAdQualityDeviceIdType = this.f427;
        int i8 = i2 + 113;
        f420 = i8 % 128;
        if (i8 % 2 != 0) {
            return iSAdQualityDeviceIdType;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    public final Map<String, String> m614() {
        int i2 = f420 + 3;
        f421 = i2 % 128;
        if (i2 % 2 == 0) {
            return this.f425;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    public final void m615() {
        int i2 = f421 + 7;
        int i8 = i2 % 128;
        f420 = i8;
        this.f426 = i2 % 2 != 0;
        f421 = (i8 + 25) % 128;
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    public final boolean m616() {
        int i2 = f421;
        boolean z2 = this.f426;
        int i8 = i2 + 115;
        f420 = i8 % 128;
        if (i8 % 2 == 0) {
            int i9 = 95 / 0;
        }
        return z2;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final void m618(boolean z2) {
        int i2 = f420;
        this.f431 = z2;
        int i8 = i2 + 57;
        f421 = i8 % 128;
        if (i8 % 2 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final void m621(String str) {
        int i2 = (f421 + 113) % 128;
        f420 = i2;
        this.f430 = str;
        f421 = (i2 + 47) % 128;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final String m622() {
        int i2 = f421 + 85;
        f420 = i2 % 128;
        if (i2 % 2 != 0) {
            return this.f428;
        }
        int i8 = 93 / 0;
        return this.f428;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final String m624() {
        int i2 = f420;
        String str = this.f430;
        f421 = (i2 + 51) % 128;
        return str;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final synchronized void m627(String str) {
        try {
            int i2 = f420 + 95;
            int i8 = i2 % 128;
            f421 = i8;
            if (i2 % 2 != 0) {
                this.f429 = str;
                throw null;
            }
            this.f429 = str;
            int i9 = i8 + 21;
            f420 = i9 % 128;
            if (i9 % 2 == 0) {
                throw null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final void m617(String str) {
        int i2 = (f421 + 15) % 128;
        f420 = i2;
        this.f428 = str;
        int i8 = i2 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE;
        f421 = i8 % 128;
        if (i8 % 2 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final synchronized String m620() {
        String str;
        int i2 = f421 + 33;
        int i8 = i2 % 128;
        f420 = i8;
        if (i2 % 2 == 0) {
            throw null;
        }
        str = this.f429;
        int i9 = i8 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE;
        f421 = i9 % 128;
        if (i9 % 2 != 0) {
            throw null;
        }
        return str;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final void m623(boolean z2) {
        int i2 = f421;
        int i8 = i2 + 13;
        f420 = i8 % 128;
        int i9 = i8 % 2;
        this.f432 = z2;
        if (i9 == 0) {
            int i10 = 46 / 0;
        }
        f420 = (i2 + 53) % 128;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final void m625(ISAdQualityDeviceIdType iSAdQualityDeviceIdType) {
        int i2 = (f420 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE) % 128;
        f421 = i2;
        this.f427 = iSAdQualityDeviceIdType;
        f420 = (i2 + 81) % 128;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final boolean m628() {
        int i2 = (f420 + 5) % 128;
        f421 = i2;
        boolean z2 = this.f431;
        f420 = (i2 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE) % 128;
        return z2;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m612(String str, int i2, int[] iArr, String str2) throws UnsupportedEncodingException {
        Object bytes = str2;
        if (str2 != null) {
            bytes = str2.getBytes("ISO-8859-1");
        }
        byte[] bArr = (byte[]) bytes;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (m.f2978) {
            try {
                char[] cArr2 = f423;
                int i8 = f424;
                if (f422) {
                    int length = bArr.length;
                    m.f2976 = length;
                    char[] cArr3 = new char[length];
                    m.f2977 = 0;
                    while (m.f2977 < m.f2976) {
                        int i9 = m.f2977;
                        int i10 = m.f2976 - 1;
                        int i11 = m.f2977;
                        cArr3[i9] = (char) (cArr2[bArr[i10 - i11] + i2] - i8);
                        m.f2977 = i11 + 1;
                    }
                    return new String(cArr3);
                }
                if (f419) {
                    int length2 = cArr.length;
                    m.f2976 = length2;
                    char[] cArr4 = new char[length2];
                    m.f2977 = 0;
                    while (m.f2977 < m.f2976) {
                        int i12 = m.f2977;
                        int i13 = m.f2976 - 1;
                        int i14 = m.f2977;
                        cArr4[i12] = (char) (cArr2[cArr[i13 - i14] - i2] - i8);
                        m.f2977 = i14 + 1;
                    }
                    return new String(cArr4);
                }
                int length3 = iArr.length;
                m.f2976 = length3;
                char[] cArr5 = new char[length3];
                m.f2977 = 0;
                while (m.f2977 < m.f2976) {
                    int i15 = m.f2977;
                    int i16 = m.f2976 - 1;
                    int i17 = m.f2977;
                    cArr5[i15] = (char) (cArr2[iArr[i16 - i17] - i2] - i8);
                    m.f2977 = i17 + 1;
                }
                return new String(cArr5);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final boolean m619() {
        int i2 = (f421 + 23) % 128;
        f420 = i2;
        boolean z2 = this.f432;
        int i8 = i2 + 1;
        f421 = i8 % 128;
        if (i8 % 2 == 0) {
            return z2;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final void m626(Map<String, String> map) {
        int i2 = f420;
        int i8 = i2 + 33;
        f421 = i8 % 128;
        int i9 = i8 % 2;
        this.f425 = map;
        if (i9 != 0) {
            throw null;
        }
        int i10 = i2 + 31;
        f421 = i10 % 128;
        if (i10 % 2 != 0) {
            int i11 = 57 / 0;
        }
    }
}
