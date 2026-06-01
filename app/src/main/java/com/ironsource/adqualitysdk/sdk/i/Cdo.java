package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import com.vungle.ads.internal.protos.Sdk;

/* JADX INFO: renamed from: com.ironsource.adqualitysdk.sdk.i.do, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Cdo {

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static byte[] f1806 = {0};

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static short[] f1807 = null;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static int f1808 = 1;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static int f1809 = 0;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f1810 = 1205804016;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f1811 = 110;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static int f1812 = 1014574257;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private String f1813;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private int f1814;

    private Cdo(String str, int i2) {
        this.f1813 = str;
        this.f1814 = i2;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m2066(int i2, short s7, int i8, byte b8, int i9) {
        String string;
        synchronized (n.f2979) {
            try {
                StringBuilder sb = new StringBuilder();
                int i10 = f1811;
                int i11 = i2 + i10;
                int i12 = i11 == -1 ? 1 : 0;
                if (i12 != 0) {
                    byte[] bArr = f1806;
                    i11 = bArr != null ? (byte) (bArr[f1810 + i8] + i10) : (short) (f1807[f1810 + i8] + i10);
                }
                if (i11 > 0) {
                    n.f2984 = ((i8 + i11) - 2) + f1810 + i12;
                    n.f2982 = b8;
                    char c7 = (char) (i9 + f1812);
                    n.f2981 = c7;
                    sb.append(c7);
                    n.f2980 = n.f2981;
                    n.f2983 = 1;
                    while (n.f2983 < i11) {
                        byte[] bArr2 = f1806;
                        if (bArr2 != null) {
                            int i13 = n.f2984;
                            n.f2984 = i13 - 1;
                            n.f2981 = (char) (n.f2980 + (((byte) (bArr2[i13] + s7)) ^ n.f2982));
                        } else {
                            short[] sArr = f1807;
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

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static Cdo m2067(String str, int i2) {
        f1809 = (f1808 + 51) % 128;
        if (!q.m3013().m3032()) {
            return null;
        }
        Cdo cdo = new Cdo(str, i2);
        f1809 = (f1808 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE) % 128;
        return cdo;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1813);
        sb.append(m2066((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 110, (short) View.resolveSize(0, 0), View.combineMeasuredStates(0, 0) - 1205804016, (byte) (TextUtils.lastIndexOf("", '0', 0) + 1), (-1014574199) - Color.green(0)).intern());
        sb.append(this.f1814);
        String string = sb.toString();
        f1809 = (f1808 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE) % 128;
        return string;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final int m2068() {
        int i2 = f1809 + 47;
        f1808 = i2 % 128;
        if (i2 % 2 != 0) {
            return this.f1814;
        }
        throw null;
    }
}
