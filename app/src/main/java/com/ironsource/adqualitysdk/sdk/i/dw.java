package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.media.AudioTrack;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class dw extends ee {

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static int f1891 = 0;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static short[] f1892 = null;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static int f1893 = 1;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f1894 = -1236290007;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static byte[] f1895 = {0, 0};

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f1896 = 84;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static int f1897 = 1606991690;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private ee[] f1898;

    public dw(List<ee> list, Cdo cdo) {
        super(cdo);
        ee[] eeVarArr = new ee[list.size()];
        this.f1898 = eeVarArr;
        list.toArray(eeVarArr);
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m2157(int i2, short s7, int i8, byte b8, int i9) {
        String string;
        synchronized (n.f2979) {
            try {
                StringBuilder sb = new StringBuilder();
                int i10 = f1896;
                int i11 = i2 + i10;
                int i12 = i11 == -1 ? 1 : 0;
                if (i12 != 0) {
                    byte[] bArr = f1895;
                    i11 = bArr != null ? (byte) (bArr[f1897 + i8] + i10) : (short) (f1892[f1897 + i8] + i10);
                }
                if (i11 > 0) {
                    n.f2984 = ((i8 + i11) - 2) + f1897 + i12;
                    n.f2982 = b8;
                    char c7 = (char) (i9 + f1894);
                    n.f2981 = c7;
                    sb.append(c7);
                    n.f2980 = n.f2981;
                    n.f2983 = 1;
                    while (n.f2983 < i11) {
                        byte[] bArr2 = f1895;
                        if (bArr2 != null) {
                            int i13 = n.f2984;
                            n.f2984 = i13 - 1;
                            n.f2981 = (char) (n.f2980 + (((byte) (bArr2[i13] + s7)) ^ n.f2982));
                        } else {
                            short[] sArr = f1892;
                            int i14 = n.f2984;
                            n.f2984 = i14 - 1;
                            n.f2981 = (char) (n.f2980 + (((short) (sArr[i14] + s7)) ^ n.f2982));
                        }
                        sb.append(n.f2981);
                        n.f2980 = n.f2981;
                        n.f2983++;
                    }
                }
                string = sb.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
        return string;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            f1893 = (f1891 + 107) % 128;
            return true;
        }
        if (obj == null || dw.class != obj.getClass()) {
            return false;
        }
        boolean zEquals = Arrays.equals(this.f1898, ((dw) obj).f1898);
        f1891 = (f1893 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE) % 128;
        return zEquals;
    }

    public final int hashCode() {
        f1891 = (f1893 + 3) % 128;
        int iHashCode = Arrays.hashCode(this.f1898);
        int i2 = f1891 + 7;
        f1893 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 85 / 0;
        }
        return iHashCode;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(m2157((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) - 83, (short) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 67), TextUtils.indexOf("", "", 0) - 1606991690, (byte) ((ViewConfiguration.getTouchSlop() >> 8) + 83), 1236290098 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1))).intern());
        sb.append(ee.m2188(this.f1898));
        String strZ = com.google.android.gms.ads.internal.client.a.z(sb, m2157(TextUtils.indexOf("", "", 0, 0) - 83, (short) (122 - Color.green(0)), (-1606991690) - (ViewConfiguration.getDoubleTapTimeout() >> 16), (byte) ((ViewConfiguration.getMinimumFlingVelocity() >> 16) - 97), 1236290100 - ExpandableListView.getPackedPositionType(0L)));
        int i2 = f1893 + 19;
        f1891 = i2 % 128;
        if (i2 % 2 == 0) {
            return strZ;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.ee
    /* JADX INFO: renamed from: ﻛ */
    public final du mo2156(ds dsVar, cp cpVar) {
        ArrayList arrayList = new ArrayList();
        ee[] eeVarArr = this.f1898;
        int length = eeVarArr.length;
        f1891 = (f1893 + 11) % 128;
        int i2 = 0;
        while (i2 < length) {
            int i8 = f1893 + 95;
            f1891 = i8 % 128;
            if (i8 % 2 != 0) {
                arrayList.add(eeVarArr[i2].m2189(dsVar, cpVar).m2153());
                i2 += 97;
            } else {
                arrayList.add(eeVarArr[i2].m2189(dsVar, cpVar).m2153());
                i2++;
            }
        }
        return new du(arrayList);
    }
}
