package com.ironsource.adqualitysdk.sdk.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class cr extends da {

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static int f1530 = 0;

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static int f1531 = 1;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static short[] f1532 = null;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f1533 = 1475937969;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f1534 = 39;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f1535 = -372370128;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static byte[] f1536 = {0};

    /* JADX WARN: Removed duplicated region for block: B:14:0x00a9 A[PHI: r0
  0x00a9: PHI (r0v16 org.json.JSONObject) = (r0v15 org.json.JSONObject), (r0v19 org.json.JSONObject) binds: [B:13:0x00a7, B:9:0x0097] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object m1786(com.ironsource.adqualitysdk.sdk.i.cp r10, java.util.List<java.lang.Object> r11) {
        /*
            Method dump skipped, instruction units count: 238
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.cr.m1786(com.ironsource.adqualitysdk.sdk.i.cp, java.util.List):java.lang.Object");
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m1787(int i2, short s7, int i8, byte b8, int i9) {
        String string;
        synchronized (n.f2979) {
            try {
                StringBuilder sb = new StringBuilder();
                int i10 = f1534;
                int i11 = i2 + i10;
                int i12 = i11 == -1 ? 1 : 0;
                if (i12 != 0) {
                    byte[] bArr = f1536;
                    if (bArr != null) {
                        i11 = (byte) (bArr[f1533 + i8] + i10);
                    } else {
                        i11 = (short) (f1532[f1533 + i8] + i10);
                    }
                }
                if (i11 > 0) {
                    n.f2984 = ((i8 + i11) - 2) + f1533 + i12;
                    n.f2982 = b8;
                    char c7 = (char) (i9 + f1535);
                    n.f2981 = c7;
                    sb.append(c7);
                    n.f2980 = n.f2981;
                    n.f2983 = 1;
                    while (n.f2983 < i11) {
                        byte[] bArr2 = f1536;
                        if (bArr2 != null) {
                            int i13 = n.f2984;
                            n.f2984 = i13 - 1;
                            n.f2981 = (char) (n.f2980 + (((byte) (bArr2[i13] + s7)) ^ n.f2982));
                        } else {
                            short[] sArr = f1532;
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
}
