package com.instagram.common.viewpoint.core;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.dw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1513dw implements S1 {
    public static byte[] A01;
    public static String[] A02 = {"XX81oR58WpEsQKvqY2LExbYJLqP9XswE", "az8CKzVkexBjitPsCylcg2AVWlGeK3EI", "bGZ3", "xIFKC7mmnDHSKxOkrjRNDYdlMsmKF1A7", "XScWVG1X4Mc8JZxVJlT03KGo8WKkDIiE", "ymPwCIBu7cN5wKkxYqt2Z3a", "4biB1nxlWznGwE3vHvSlKad", "lswyJVFYW7lcf"};
    public final Map<String, AbstractC1068Rz> A00 = new HashMap();

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i8);
        int i10 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A02;
            if (strArr[6].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[4] = "T1kvqoJ1cX6i4DSx7n80qqGN8Qg91HVj";
            strArr2[3] = "zM5VtNN21yuLINvrTPslJyIzIvAVUrXA";
            if (i10 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 74);
            i10++;
        }
    }

    public static void A01() {
        A01 = new byte[]{49, 42, 22, 49, 55, 44, 43, 34};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.instagram.common.viewpoint.core.S1
    public final synchronized String AHr() {
        StringBuilder sb;
        sb = new StringBuilder();
        Iterator<AbstractC1068Rz> it = this.A00.values().iterator();
        if (it.hasNext()) {
            it.next();
            throw new NullPointerException(A00(0, 8, 15));
        }
        return sb.toString();
    }

    static {
        A01();
    }

    @Override // com.instagram.common.viewpoint.core.S1
    public final synchronized void reset() {
        this.A00.clear();
    }
}
