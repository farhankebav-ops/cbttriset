package com.instagram.common.viewpoint.core;

import android.util.Pair;
import com.vungle.ads.internal.protos.Sdk;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Kn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC0878Kn {
    public static byte[] A00;
    public static String[] A01 = {"sX38XYxjSWs23SpIJtTv7zqsiULa6NDN", "GVdzvLjErUQlCiFlI6sj0UXKxa4oVMD1", "mIptDDVqgJzdzMBxnTdyNQyM9U5NEVN", "EbHk890dVqPqb4rol71PU8NjsI2mWG9N", "NaaYWHcYaAW6JEQtPhbZM5A", "ny7KRitGLB3lrMhzsw8kbWX2NySq0vmW", "JAavj5eiIDuEB7ikgcXMWWkFbaDdUxIE", "svQ0hoJoeE45w1Y6xC2"};

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C0876Kl A02(InterfaceC1943lN interfaceC1943lN) throws IOException {
        byte[] bArr;
        C4J c4j = new C4J(16);
        C0877Km c0877KmA03 = A03(1718449184, interfaceC1943lN, c4j);
        C3M.A08(c0877KmA03.A01 >= 16);
        interfaceC1943lN.AG9(c4j.A0l(), 0, 16);
        c4j.A0f(0);
        int iA0G = c4j.A0G();
        int iA0G2 = c4j.A0G();
        int iA0F = c4j.A0F();
        int iA0F2 = c4j.A0F();
        int iA0G3 = c4j.A0G();
        int iA0G4 = c4j.A0G();
        int i2 = ((int) c0877KmA03.A01) - 16;
        if (i2 > 0) {
            bArr = new byte[i2];
            interfaceC1943lN.AG9(bArr, 0, i2);
        } else {
            bArr = AbstractC04664a.A07;
        }
        interfaceC1943lN.AJJ((int) (interfaceC1943lN.A8a() - interfaceC1943lN.A8f()));
        return new C0876Kl(iA0G, iA0G2, iA0F, iA0F2, iA0G3, iA0G4, bArr);
    }

    public static String A04(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 67);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A00 = new byte[]{59, 16, 13, 22, 19, 88, 17, 11, 88, 12, 23, 23, 88, 20, 25, 10, 31, 29, 88, 80, 6, 74, 63, 58, 83, 81, 88, 12, 23, 88, 11, 19, 17, 8, 67, 88, 17, 28, 66, 88, 45, 3, 10, 11, 22, 13, 10, 3, 68, 17, 10, 15, 10, 11, 19, 10, 68, 51, 37, 50, 68, 7, 12, 17, 10, 15, 94, 68, 105, 82, 79, 73, 76, 76, 83, 78, 72, 89, 88, 28, 90, 83, 78, 81, 28, 72, 69, 76, 89, 6, 28, 105, 95, 72, 118, 91, 95, 90, 91, 76, 108, 91, 95, 90, 91, 76};
    }

    static {
        A05();
    }

    public static long A00(InterfaceC1943lN interfaceC1943lN) throws IOException {
        C4J c4j = new C4J(8);
        C0877Km chunkHeader = C0877Km.A00(interfaceC1943lN, c4j);
        if (chunkHeader.A00 != 1685272116) {
            interfaceC1943lN.AI1();
            return -1L;
        }
        interfaceC1943lN.A3z(8);
        c4j.A0f(0);
        interfaceC1943lN.AG9(c4j.A0l(), 0, 8);
        long sampleDataSize = c4j.A0N();
        interfaceC1943lN.AJJ(((int) chunkHeader.A01) + 8);
        return sampleDataSize;
    }

    public static Pair<Long, Long> A01(InterfaceC1943lN interfaceC1943lN) throws IOException {
        interfaceC1943lN.AI1();
        C0877Km c0877KmA03 = A03(1684108385, interfaceC1943lN, new C4J(8));
        interfaceC1943lN.AJJ(8);
        return Pair.create(Long.valueOf(interfaceC1943lN.A8f()), Long.valueOf(c0877KmA03.A01));
    }

    public static C0877Km A03(int i2, InterfaceC1943lN interfaceC1943lN, C4J c4j) throws IOException {
        C0877Km c0877KmA00 = C0877Km.A00(interfaceC1943lN, c4j);
        while (c0877KmA00.A00 != i2) {
            AnonymousClass44.A07(A04(91, 15, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE), A04(40, 28, 39) + c0877KmA00.A00);
            long j = c0877KmA00.A01 + 8;
            if (j <= 2147483647L) {
                interfaceC1943lN.AJJ((int) j);
                c0877KmA00 = C0877Km.A00(interfaceC1943lN, c4j);
            } else {
                throw C04222i.A00(A04(0, 40, 59) + c0877KmA00.A00);
            }
        }
        return c0877KmA00;
    }

    public static boolean A06(InterfaceC1943lN interfaceC1943lN) throws IOException {
        C4J c4j = new C4J(8);
        C0877Km c0877KmA00 = C0877Km.A00(interfaceC1943lN, c4j);
        if (c0877KmA00.A00 != 1380533830) {
            int i2 = c0877KmA00.A00;
            if (A01[1].charAt(26) == 'h') {
                throw new RuntimeException();
            }
            A01[4] = "7d3HBnqB6pKujyEoyh9Hov6";
            if (i2 != 1380333108) {
                return false;
            }
        }
        interfaceC1943lN.AG9(c4j.A0l(), 0, 4);
        c4j.A0f(0);
        int iA0C = c4j.A0C();
        if (iA0C != 1463899717) {
            AnonymousClass44.A05(A04(91, 15, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE), A04(68, 23, 127) + iA0C);
            return false;
        }
        return true;
    }
}
