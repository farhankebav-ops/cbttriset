package com.instagram.common.viewpoint.core;

import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.nJ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public enum EnumC2061nJ implements Iterator<Object> {
    A03;

    public static byte[] A00;
    public static String[] A01 = {"MtVTs5cDzTkaqvg8NuH3vwobapVBE0st", "ArMYDbI1ZOKb1PqTCippk6Br36HImDMz", "toSUZKKd1UGhUJ4QalyaWathzboIF5UW", "VPzDHjdriWPgU4d", "Di5eRoJ6h3CuCR5uxiNB2s29p0t6qO11", "B6Kcd5hxdA7PPWxpRUkmfJ1syAdRnb1r", "u5nu3DOOZeH", "WD4F9WHgG47OHFbe2E6bcqFaZ5qcCEPl"};

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            int i11 = (bArrCopyOfRange[i10] ^ i9) ^ Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE;
            if (A01[4].charAt(4) != 'R') {
                throw new RuntimeException();
            }
            A01[6] = "SHVGlB8lB2rly5Sbj1O4M1TTC2AUnN6";
            bArrCopyOfRange[i10] = (byte) i11;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{98, 101, 120, 127, 106, 101, 104, 110};
    }

    static {
        A01();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        AbstractC1966ll.A04(false);
    }
}
