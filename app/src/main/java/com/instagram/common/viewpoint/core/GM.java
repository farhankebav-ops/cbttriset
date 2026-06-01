package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class GM extends AbstractRunnableC1164Vt {
    public static byte[] A02;
    public static String[] A03 = {"MrnT4Eks85vPuqQr37JMtu4NfaYgfi6f", "zfkVjNlCcNBydFIcz2mD", "Bee43nRREoDmuohWbk", "LYOPzNoZy5N5VpEZxT", "78Vp0AX9Eb5UezJBTqKvLg5S66jER", "qnB2IM", "Ag3pKfa1yi0C6RoVnqVP", "pygY9b2"};
    public final /* synthetic */ C4K A00;
    public final /* synthetic */ C3Q A01;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            byte b8 = bArrCopyOfRange[i10];
            if (A03[4].length() != 29) {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[2] = "zTo8qTO106BkbxhANT";
            strArr[3] = "z1bPe1QyN1GViRGZCE";
            bArrCopyOfRange[i10] = (byte) ((b8 - i9) - 15);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{125, -80, -95, -95, -96, -83, -92, -87, -94, 91, -92, -87, -97, -96, -95, -92, -87, -92, -81, -96, -89, -76};
    }

    static {
        A01();
    }

    public GM(C4K c4k, C3Q c3q) {
        this.A00 = c4k;
        this.A01 = c3q;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1164Vt
    public final void A07() {
        if (this.A00.A0X.getState() == EnumC1547eU.A02) {
            E1 e12 = this.A00.A0X;
            String[] strArr = A03;
            if (strArr[7].length() == strArr[0].length()) {
                throw new RuntimeException();
            }
            A03[1] = "EIUkH3ntVfUyNEjhHXbRpTHh";
            if (e12.getCurrentPositionInMillis() == A00()) {
                this.A00.A0V.AFg(A00(0, 22, 44));
            }
        }
    }
}
