package com.ironsource.adqualitysdk.sdk.i;

import com.vungle.ads.internal.protos.Sdk;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class cv extends da {

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static char[] f1543 = {'\"', '[', 'r', 'p', 'p', 'I', 'I', 's', 'q', 'n', 'k', 'k', 'j', 'C', 'F', 'g', 'h', 'O', 'J', 'j', 'p', '[', 'S', 'b', 'e', 'D', 'G', 'n', 'G', 'F', 'j', 'n', 's', 'P', 182, 205, 203, 203, 164, 164, 206, 204, 201, 198, 198, 197, 158, 158, 194, 197, 203, 199, 198, 164, 162, 201, 162, 161, 197, 201, 206};

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f1544 = 1;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static int f1545;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final Object m1833(cp cpVar, List<Object> list) {
        cp cpVar2;
        List list2 = (List) da.m1896(list, 0, List.class);
        try {
            dq dqVar = (dq) da.m1896(list, 1, dq.class);
            List<Object> arrayList = new ArrayList<>();
            if (list.size() > 2) {
                f1545 = (f1544 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE) % 128;
                if (da.m1899(list, 2, cp.class)) {
                    cpVar2 = (cp) da.m1896(list, 2, cp.class);
                    if (list.size() > 3) {
                        f1545 = (f1544 + 113) % 128;
                        arrayList = da.m1898(list, 3);
                    }
                } else {
                    arrayList = da.m1898(list, 2);
                    cpVar2 = cpVar;
                }
            } else {
                cpVar2 = cpVar;
            }
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < list2.size(); i2++) {
                arrayList.add(0, list2.get(i2));
                arrayList2.add(dqVar.m2081(cpVar2.m1722(), cpVar2, arrayList).m2153());
                arrayList.remove(0);
            }
            return arrayList2;
        } catch (Exception e) {
            co.m1671(cpVar.m1723(), m1832("\u0001\u0001\u0000\u0001\u0001\u0000\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0001\u0000\u0000\u0001\u0000\u0001", false, new int[]{0, 33, 0, 0}).intern(), e);
            return list2;
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final Object m1834(cp cpVar, List<Object> list) {
        cp cpVar2;
        List list2 = (List) da.m1896(list, 0, List.class);
        try {
            dq dqVar = (dq) da.m1896(list, 1, dq.class);
            List<Object> arrayList = new ArrayList<>();
            if (list.size() <= 2) {
                cpVar2 = cpVar;
            } else if (da.m1899(list, 2, cp.class)) {
                cpVar2 = (cp) da.m1896(list, 2, cp.class);
                if (list.size() > 3) {
                    f1544 = (f1545 + 99) % 128;
                    arrayList = da.m1898(list, 3);
                }
            } else {
                arrayList = da.m1898(list, 2);
                f1545 = (f1544 + 23) % 128;
                cpVar2 = cpVar;
            }
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < list2.size(); i2++) {
                arrayList.add(0, list2.get(i2));
                if (dqVar.m2081(cpVar2.m1722(), cpVar2, arrayList).m2150()) {
                    arrayList2.add(list2.get(i2));
                }
                arrayList.remove(0);
            }
            return arrayList2;
        } catch (Exception e) {
            co.m1671(cpVar.m1723(), m1832("\u0000\u0001\u0000\u0001\u0001\u0000\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0000\u0001\u0000\u0001", false, new int[]{33, 28, 91, 0}).intern(), e);
            return list2;
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final Object m1835(cp cpVar, List<Object> list) {
        f1544 = (f1545 + 101) % 128;
        m1833(cpVar, list);
        f1545 = (f1544 + 5) % 128;
        return null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m1832(String str, boolean z2, int[] iArr) throws UnsupportedEncodingException {
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
                System.arraycopy(f1543, i2, cArr, 0, i8);
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
