package com.instagram.common.viewpoint.core;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.mA, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1991mA implements C1S {
    public static byte[] A03;
    public static String[] A04 = {"kjXOolT", "y1uosoppcQ2KAnagmdUHUDs2pqKkNOP", "9S5fCrLfVI6Z6wWSlA", "LW4KLvv", "ESAoxwChDjEBJ2YD38hEjiU5IsN", "MD8cz6uZEkXt7x64XO0blzPRBkN5Dhm8", "wv8vTraLOdvtLK52tGc0aCYgNtDO0cFF", "ftZS2reRIxcEfCn6parOlN78mV3R9Y2K"};
    public static final C1R<C1991mA> A05;
    public static final C1991mA A06;
    public static final String A07;
    public int A00;
    public final int A01;
    public final AbstractC0621Am<C2120oH> A02;

    public static String A01(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 95);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        byte[] bArr = {119, 79, 86, 78, 83, 74, 86, 95, 26, 83, 94, 95, 84, 78, 83, 89, 91, 86, 26, 110, 72, 91, 89, 81, 125, 72, 85, 79, 74, 73, 26, 91, 94, 94, 95, 94, 26, 78, 85, 26, 85, 84, 95, 26, 110, 72, 91, 89, 81, 125, 72, 85, 79, 74, 123, 72, 72, 91, 67, 20, 81, 119, 100, 102, 110, 66, 119, 106, 112, 117, 68, 119, 119, 100, 124};
        if (A04[5].charAt(31) == 'Q') {
            throw new RuntimeException();
        }
        A04[4] = "LoVxB454";
        A03 = bArr;
    }

    static {
        A03();
        A06 = new C1991mA(new C2120oH[0]);
        A07 = AbstractC04664a.A0h(0);
        A05 = new C1R() { // from class: com.facebook.ads.redexgen.X.mB
            @Override // com.instagram.common.viewpoint.core.C1R
            public final C1S A6X(Bundle bundle) {
                return C1991mA.A00(bundle);
            }
        };
    }

    public C1991mA(C2120oH... c2120oHArr) {
        this.A02 = AbstractC0621Am.A07(c2120oHArr);
        this.A01 = c2120oHArr.length;
        A02();
    }

    public static /* synthetic */ C1991mA A00(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(A07);
        if (parcelableArrayList == null) {
            return new C1991mA(new C2120oH[0]);
        }
        return new C1991mA((C2120oH[]) C3S.A01(C2120oH.A06, parcelableArrayList).toArray(new C2120oH[0]));
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0007 */
    /* JADX WARN: Incorrect condition in loop: B:7:0x0011 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A02() {
        /*
            r7 = this;
            r6 = 0
        L1:
            com.facebook.ads.redexgen.X.Am<com.facebook.ads.redexgen.X.oH> r0 = r7.A02
            int r0 = r0.size()
            if (r6 >= r0) goto L50
            int r5 = r6 + 1
        Lb:
            com.facebook.ads.redexgen.X.Am<com.facebook.ads.redexgen.X.oH> r0 = r7.A02
            int r0 = r0.size()
            if (r5 >= r0) goto L4d
            com.facebook.ads.redexgen.X.Am<com.facebook.ads.redexgen.X.oH> r0 = r7.A02
            java.lang.Object r1 = r0.get(r6)
            com.facebook.ads.redexgen.X.oH r1 = (com.instagram.common.viewpoint.core.C2120oH) r1
            com.facebook.ads.redexgen.X.Am<com.facebook.ads.redexgen.X.oH> r0 = r7.A02
            java.lang.Object r0 = r0.get(r5)
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L4a
            r2 = 0
            r1 = 60
            r0 = 101(0x65, float:1.42E-43)
            java.lang.String r0 = A01(r2, r1, r0)
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            r4.<init>(r0)
            r2 = 60
            r1 = 15
            r0 = 90
            java.lang.String r3 = A01(r2, r1, r0)
            r2 = 0
            r1 = 0
            r0 = 115(0x73, float:1.61E-43)
            java.lang.String r0 = A01(r2, r1, r0)
            com.instagram.common.viewpoint.core.AnonymousClass44.A08(r3, r0, r4)
        L4a:
            int r5 = r5 + 1
            goto Lb
        L4d:
            int r6 = r6 + 1
            goto L1
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C1991mA.A02():void");
    }

    public final int A04(C2120oH c2120oH) {
        int index = this.A02.indexOf(c2120oH);
        if (index >= 0) {
            return index;
        }
        return -1;
    }

    public final C2120oH A05(int i2) {
        return this.A02.get(i2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1991mA c1991mA = (C1991mA) obj;
        return this.A01 == c1991mA.A01 && this.A02.equals(c1991mA.A02);
    }

    public final int hashCode() {
        if (this.A00 == 0) {
            this.A00 = this.A02.hashCode();
        }
        int i2 = this.A00;
        String[] strArr = A04;
        if (strArr[3].length() != strArr[0].length()) {
            throw new RuntimeException();
        }
        A04[6] = "ifk0Ba0Zppjn7MlaJBrmzFqZbJ0HKklT";
        return i2;
    }
}
