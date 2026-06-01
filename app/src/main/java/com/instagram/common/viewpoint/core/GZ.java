package com.instagram.common.viewpoint.core;

import java.io.EOFException;
import java.io.IOException;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class GZ {
    public static String[] A00 = {"", "JBqvX3ouZOOCqox6TCkHsUUnq79xKaTL", "x", "BIUpfUNI3eVa3mY8ect95XlwPu2Ofuw", "eTPSYv4hujFcnfJKGeeHsnhQxUvQ5rkD", "uOymuGwhHDkcqDuJ17", "MFseKYUy643KM5DvrPXxmzbMJL0nMbh3", "ti0zz4"};

    public static int A00(InterfaceC1943lN interfaceC1943lN, byte[] bArr, int i2, int i8) throws IOException {
        int i9 = 0;
        while (i9 < i8) {
            int totalBytesPeeked = i8 - i9;
            int iAG8 = interfaceC1943lN.AG8(bArr, i2 + i9, totalBytesPeeked);
            String[] strArr = A00;
            String str = strArr[1];
            String str2 = strArr[4];
            int iCharAt = str.charAt(19);
            int totalBytesPeeked2 = str2.charAt(19);
            if (iCharAt != totalBytesPeeked2) {
                throw new RuntimeException();
            }
            A00[6] = "xnIrdLQGczxEK23FHKuSo6llrjoojLCP";
            if (iAG8 == -1) {
                break;
            }
            i9 += iAG8;
        }
        return i9;
    }

    @Pure
    public static void A01(boolean z2, String str) throws C04222i {
        if (z2) {
        } else {
            throw C04222i.A01(str, null);
        }
    }

    public static boolean A02(InterfaceC1943lN interfaceC1943lN, int i2) throws IOException {
        try {
            interfaceC1943lN.AJJ(i2);
            if (A00[0].length() != 0) {
                throw new RuntimeException();
            }
            A00[3] = "SfDhdqvr0QmEID8ZIpBFjoMfbavps9";
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static boolean A03(InterfaceC1943lN interfaceC1943lN, byte[] bArr, int i2, int i8) throws IOException {
        try {
            interfaceC1943lN.readFully(bArr, i2, i8);
            return true;
        } catch (EOFException unused) {
            if (A00[0].length() != 0) {
                throw new RuntimeException();
            }
            A00[6] = "fFP2kzBTuIshDEJva9vOOxjFjEDNGXev";
            return false;
        }
    }

    public static boolean A04(InterfaceC1943lN interfaceC1943lN, byte[] bArr, int i2, int i8, boolean z2) throws IOException {
        try {
            return interfaceC1943lN.AGA(bArr, i2, i8, z2);
        } catch (EOFException e) {
            if (!z2) {
                throw e;
            }
            if (A00[3].length() == 20) {
                throw new RuntimeException();
            }
            String[] strArr = A00;
            strArr[7] = "24rmiB";
            strArr[5] = "kHyj46IkHv9Sbvkaop";
            return false;
        }
    }
}
