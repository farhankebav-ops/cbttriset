package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.ironsource.adqualitysdk.sdk.i.bg;
import io.presage.Presage;
import io.presage.common.PresageSdk;
import io.presage.interstitial.PresageInterstitial;
import io.presage.interstitial.PresageInterstitialCallback;
import io.presage.interstitial.optinvideo.PresageOptinVideo;
import io.presage.interstitial.optinvideo.PresageOptinVideoCallback;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ca extends bg {

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static int f1195 = 1;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static int f1196 = 0;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f1197 = -1708596126;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static short[] f1198 = null;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f1199 = 244390236;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f1200 = 34;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static byte[] f1201 = {10, -54, -60, 60, -62, 58, -34, -19, 26, -60, 55, 58, -60, 58, -50, -50, -62, 62, -55, -22, -44, 13, -60, 55, 58, -60, 58, -50, -50, -62, 62, -55, -54, -12, 6, 49, -55, 33, -63, 60, -51, -115, 112, -55, 13, 64, 78, -74, 72, -80, 84, 103, -112, 78, -67, -80, 78, -80, 68, 68, 72, -76, 67, 96, 94, -128, -79, 2, -121, 78, -67, -80, 78, -80, 68, 68, 72, -76, 67, 64, 126, -116, -69, 67, -85, 75, -74, 71, 7, -6, 67, -12, -38, -44, 44, -46, 42, -50, -3, 10, -44, 39, 42, -44, 42, -34, -34, -46, 46, -39, -6, 63, -53, -27, -25, 31, -9, 23, -22, 59, -24, -36, -54, 53, 37, -35, 53, -43, 40, -7, -15, -73, 68, 73, -73, 73, -67, -67, -79, 77, -70, -103, 88, 66, -70, 82, -78, 79, -98, -7, -125, -119, 116, 125, -117, -128, -107, 92, -128, 115, 126, -128, 126, -118, -118, -122, 122, -115, -82, 111, 117, -115, 101, -123, 120, -87, -17, 40, 35, -39, 49, -54, 39, -41, 38, 3, -56, -36, 36, -52, 44, -47, 0, -9, 108, 102, -101, -110, 100, 111, 122, -80, 110, 101, -97, 119, -116, 97, -111, 96, 69, -114, -102, 98, -118, 106, -105, 70, -24, -80, 73, -109, 93, 74, -87, 82, -86, -85, 13, -117, 67, 88, -82, 87, -118, 114, -71, 69, -82, -125, 120, 87, -68, 81, 91, -71, 94, -83, 95, -91, 85, -83, -86, -93, -128, 96, 85, -109, 104, 87, -86, -88, 86, -92, -99, 97, 86, -82, 70, -90, 91, -86, -22, 23, -82, -33};

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static int[] f1194 = {429523600, 1499974250, -723680537, 1720019924, -1430292830, 1415148872, 699472325, -1951459174, -682477124, 1854681414, -2131493628, 1773502688, -580523385, -1773823622, 1905505384, 1450913745, -578549288, 1716067149};

    public ca(String str) {
        super(str);
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    public static /* synthetic */ Presage m1413() {
        int i2 = f1195 + 39;
        f1196 = i2 % 128;
        if (i2 % 2 == 0) {
            return m1414();
        }
        m1414();
        throw null;
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static Presage m1414() {
        int i2 = f1196 + 63;
        f1195 = i2 % 128;
        if (i2 % 2 == 0) {
            Presage.getInstance();
            throw null;
        }
        Presage presage = Presage.getInstance();
        int i8 = f1195 + 83;
        f1196 = i8 % 128;
        if (i8 % 2 == 0) {
            return presage;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ void m1416(PresageOptinVideo presageOptinVideo, PresageOptinVideoCallback presageOptinVideoCallback) {
        int i2 = f1196 + 21;
        f1195 = i2 % 128;
        int i8 = i2 % 2;
        m1417(presageOptinVideo, presageOptinVideoCallback);
        if (i8 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static void m1417(PresageOptinVideo presageOptinVideo, PresageOptinVideoCallback presageOptinVideoCallback) {
        int i2 = f1196 + 65;
        f1195 = i2 % 128;
        int i8 = i2 % 2;
        presageOptinVideo.setOptinVideoCallback(presageOptinVideoCallback);
        if (i8 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ void m1420(PresageInterstitial presageInterstitial, PresageInterstitialCallback presageInterstitialCallback) {
        int i2 = f1195 + 73;
        f1196 = i2 % 128;
        int i8 = i2 % 2;
        m1419(presageInterstitial, presageInterstitialCallback);
        if (i8 != 0) {
            throw null;
        }
        int i9 = f1196 + 77;
        f1195 = i9 % 128;
        if (i9 % 2 == 0) {
            throw null;
        }
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﻐ */
    public final String mo825() {
        String strMo881 = mo881();
        if (strMo881 == null) {
            return null;
        }
        f1195 = (f1196 + 107) % 128;
        String str = strMo881.split(m1415(new int[]{-1990836538, 1935152448}, 1 - (ViewConfiguration.getPressedStateDuration() >> 16)).intern())[0];
        f1195 = (f1196 + 63) % 128;
        return str;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﾇ */
    public final Map<String, bg.a> mo827() {
        HashMap map = new HashMap();
        map.put(m1415(new int[]{1066884616, -1774381027, 1164728445, -382356484, -1872369215, -2082468003, 2119769399, 724610906, -1465636368, 1627657779}, 18 - (Process.myTid() >> 22)).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.ca.5
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return ca.m1413();
            }
        });
        map.put(m1415(new int[]{1053480464, 312464122, 20540270, 1367573922, 557044023, 1740168388, -1709557147, 410028119, 1137006336, -2034667021, -193207869, 1652834209}, View.MeasureSpec.getSize(0) + 23).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.ca.3
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                ca.m1420((PresageInterstitial) list.get(0), (PresageInterstitialCallback) list.get(1));
                return null;
            }
        });
        map.put(m1415(new int[]{-1044102973, -1997217085, -236091042, -627515088, -121140098, -989056877, -1094809627, 456307685, 1986128876, -1319427628, -1270851319, -1585663026}, ExpandableListView.getPackedPositionGroup(0L) + 21).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.ca.1
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                ca.m1416((PresageOptinVideo) list.get(0), (PresageOptinVideoCallback) list.get(1));
                return null;
            }
        });
        int i2 = f1195 + 31;
        f1196 = i2 % 128;
        if (i2 % 2 == 0) {
            return map;
        }
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x02ae  */
    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﻛ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Class mo826(java.lang.String r18) {
        /*
            Method dump skipped, instruction units count: 934
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.ca.mo826(java.lang.String):java.lang.Class");
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m1415(int[] iArr, int i2) {
        String str;
        synchronized (d.f1664) {
            try {
                char[] cArr = new char[4];
                char[] cArr2 = new char[iArr.length << 1];
                int[] iArr2 = (int[]) f1194.clone();
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

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static void m1419(PresageInterstitial presageInterstitial, PresageInterstitialCallback presageInterstitialCallback) {
        int i2 = f1196 + 43;
        f1195 = i2 % 128;
        int i8 = i2 % 2;
        presageInterstitial.setInterstitialCallback(presageInterstitialCallback);
        if (i8 == 0) {
            int i9 = 35 / 0;
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m1418(int i2, short s7, int i8, byte b8, int i9) {
        String string;
        synchronized (n.f2979) {
            try {
                StringBuilder sb = new StringBuilder();
                int i10 = f1200;
                int i11 = i2 + i10;
                int i12 = i11 == -1 ? 1 : 0;
                if (i12 != 0) {
                    byte[] bArr = f1201;
                    if (bArr != null) {
                        i11 = (byte) (bArr[f1197 + i8] + i10);
                    } else {
                        i11 = (short) (f1198[f1197 + i8] + i10);
                    }
                }
                if (i11 > 0) {
                    n.f2984 = ((i8 + i11) - 2) + f1197 + i12;
                    n.f2982 = b8;
                    char c7 = (char) (i9 + f1199);
                    n.f2981 = c7;
                    sb.append(c7);
                    n.f2980 = n.f2981;
                    n.f2983 = 1;
                    while (n.f2983 < i11) {
                        byte[] bArr2 = f1201;
                        if (bArr2 != null) {
                            int i13 = n.f2984;
                            n.f2984 = i13 - 1;
                            n.f2981 = (char) (n.f2980 + (((byte) (bArr2[i13] + s7)) ^ n.f2982));
                        } else {
                            short[] sArr = f1198;
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

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﻛ */
    public final String mo881() {
        f1196 = (f1195 + 47) % 128;
        try {
            try {
                String str = (String) Class.forName(m1418(View.combineMeasuredStates(0, 0) - 35, (short) Drawable.resolveOpacity(0, 0), 1708596354 - (ViewConfiguration.getJumpTapTimeout() >> 16), (byte) ((KeyEvent.getMaxKeyCode() >> 16) - 88), (-244390132) - TextUtils.lastIndexOf("", '0', 0, 0)).intern()).getMethod(m1418((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) - 35, (short) ((-1) - TextUtils.lastIndexOf("", '0')), Color.rgb(0, 0, 0) + 1725373617, (byte) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 70), (-244390140) - TextUtils.lastIndexOf("", '0', 0)).intern(), null).invoke(null, null);
                int i2 = f1196 + 37;
                f1195 = i2 % 128;
                if (i2 % 2 != 0) {
                    return str;
                }
                throw null;
            } catch (Exception unused) {
                return PresageSdk.getAdsSdkVersion();
            }
        } catch (Throwable unused2) {
            return null;
        }
    }
}
