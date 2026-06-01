package com.ironsource.adqualitysdk.sdk.i;

import com.vungle.ads.internal.protos.Sdk;
import java.io.UnsupportedEncodingException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class dc extends da {

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static char[] f1678 = {'\"', '[', 'r', 'p', 'p', 'I', 'A', 'j', 'k', 'c', 'j', 'n', 'k', 'j', 'C', 'F', 'i', 'l', 'n', 'k', 'i', 'B', 'I', 's', 'q', 'n', 'g', 'a', 'g', 'h'};

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f1679 = 0;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f1680 = 1;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    public final Object m1911(cp cpVar, List<Object> list, ds dsVar) {
        int i2 = f1680 + 57;
        f1679 = i2 % 128;
        if (i2 % 2 != 0) {
            p.m2963(m1915(cpVar, list, dsVar));
            int i8 = 81 / 0;
        } else {
            p.m2963(m1915(cpVar, list, dsVar));
        }
        int i9 = f1679 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE;
        f1680 = i9 % 128;
        if (i9 % 2 == 0) {
            int i10 = 26 / 0;
        }
        return null;
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    public final Object m1912(cp cpVar, List<Object> list, ds dsVar) {
        f1679 = (f1680 + 79) % 128;
        p.m2973(m1915(cpVar, list, dsVar), m1909(list));
        int i2 = f1679 + 59;
        f1680 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 64 / 0;
        }
        return null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final Object m1913(cp cpVar, List<Object> list, ds dsVar) {
        f1679 = (f1680 + 65) % 128;
        p.m2964(m1915(cpVar, list, dsVar));
        f1679 = (f1680 + 61) % 128;
        return null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final Object m1914(cp cpVar, List<Object> list, ds dsVar) {
        f1680 = (f1679 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE) % 128;
        p.m2969(m1915(cpVar, list, dsVar));
        int i2 = f1679 + 35;
        f1680 = i2 % 128;
        if (i2 % 2 != 0) {
            return null;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final iu m1915(final cp cpVar, List<Object> list, final ds dsVar) {
        final List<Object> listM1898;
        try {
            if (da.m1899(list, 0, iu.class)) {
                return (iu) da.m1896(list, 0, iu.class);
            }
            final dq dqVar = (dq) da.m1896(list, 0, dq.class);
            if (list.size() > 2) {
                listM1898 = da.m1898(list, 2);
            } else {
                listM1898 = da.m1898(list, 1);
                f1679 = (f1680 + 75) % 128;
            }
            iu iuVar = new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.dc.1
                @Override // com.ironsource.adqualitysdk.sdk.i.iu
                /* JADX INFO: renamed from: ﻐ */
                public final void mo306() {
                    listM1898.add(0, this);
                    dqVar.m2081(dsVar, cpVar, listM1898);
                    listM1898.remove(0);
                }
            };
            int i2 = f1679 + 115;
            f1680 = i2 % 128;
            if (i2 % 2 != 0) {
                return iuVar;
            }
            throw null;
        } catch (Exception e) {
            co.m1671(cpVar.m1723(), m1910("\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0000\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0001", false, new int[]{0, 30, 0, 0}).intern(), e);
            return null;
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final Object m1916(cp cpVar, List<Object> list, ds dsVar) {
        int i2 = f1679 + 111;
        f1680 = i2 % 128;
        if (i2 % 2 != 0) {
            p.m2970(m1915(cpVar, list, dsVar), m1909(list));
            return null;
        }
        p.m2970(m1915(cpVar, list, dsVar), m1909(list));
        throw null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final Object m1917(cp cpVar, List<Object> list, ds dsVar) {
        int i2 = f1679 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE;
        f1680 = i2 % 128;
        if (i2 % 2 != 0) {
            p.m2967(m1915(cpVar, list, dsVar));
            return null;
        }
        p.m2967(m1915(cpVar, list, dsVar));
        throw null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static long m1909(List<Object> list) {
        if (list.size() > 1) {
            f1679 = (f1680 + 1) % 128;
            if (da.m1899(list, 1, Integer.class)) {
                int i2 = f1679 + 51;
                f1680 = i2 % 128;
                int i8 = i2 % 2;
                return ((Integer) da.m1896(list, 1, Integer.class)).intValue();
            }
        }
        if (list.size() <= 2) {
            return 0L;
        }
        f1679 = (f1680 + 65) % 128;
        return ((Integer) da.m1896(list, 2, Integer.class)).intValue();
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m1910(String str, boolean z2, int[] iArr) throws UnsupportedEncodingException {
        String str2;
        Object bytes = str;
        if (str != null) {
            bytes = str.getBytes("ISO-8859-1");
        }
        byte[] bArr = (byte[]) bytes;
        synchronized (g.f2126) {
            try {
                int i2 = iArr[0];
                int i8 = iArr[1];
                int i9 = iArr[2];
                int i10 = iArr[3];
                char[] cArr = new char[i8];
                System.arraycopy(f1678, i2, cArr, 0, i8);
                if (bArr != null) {
                    char[] cArr2 = new char[i8];
                    g.f2125 = 0;
                    char c7 = 0;
                    while (true) {
                        int i11 = g.f2125;
                        if (i11 >= i8) {
                            break;
                        }
                        if (bArr[i11] == 1) {
                            cArr2[i11] = (char) (((cArr[i11] << 1) + 1) - c7);
                        } else {
                            cArr2[i11] = (char) ((cArr[i11] << 1) - c7);
                        }
                        c7 = cArr2[i11];
                        g.f2125 = i11 + 1;
                    }
                    cArr = cArr2;
                }
                if (i10 > 0) {
                    char[] cArr3 = new char[i8];
                    System.arraycopy(cArr, 0, cArr3, 0, i8);
                    int i12 = i8 - i10;
                    System.arraycopy(cArr3, 0, cArr, i12, i10);
                    System.arraycopy(cArr3, i10, cArr, 0, i12);
                }
                if (z2) {
                    char[] cArr4 = new char[i8];
                    g.f2125 = 0;
                    while (true) {
                        int i13 = g.f2125;
                        if (i13 >= i8) {
                            break;
                        }
                        cArr4[i13] = cArr[(i8 - i13) - 1];
                        g.f2125 = i13 + 1;
                    }
                    cArr = cArr4;
                }
                if (i9 > 0) {
                    g.f2125 = 0;
                    while (true) {
                        int i14 = g.f2125;
                        if (i14 >= i8) {
                            break;
                        }
                        cArr[i14] = (char) (cArr[i14] - iArr[2]);
                        g.f2125 = i14 + 1;
                    }
                }
                str2 = new String(cArr);
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }
}
