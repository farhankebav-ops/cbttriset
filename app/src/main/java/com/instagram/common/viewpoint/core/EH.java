package com.instagram.common.viewpoint.core;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class EH {
    public static String[] A00 = {"94gd2lHaz6driogpt3Nl1tWsjXgriMxS", "VA5F17cuoV6wg6So0a0DluDefxsQAbFW", "BZfou2TK48MMfd1yJcRZTZ4JcnnWlmHT", "ilV1kn3efEuJyycOIV0UyN70TAMLymqY", "v19hT7CAJaCb1rntEZC2LQpyBVrX3IkZ", "rkpPVUKbY", "FKwb9S", "XsKsPoEAnPyrLBiotdeURrQ5Q46xoiIz"};

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C2109o6 A01(EC ec, List<? extends EE>[] listArr) {
        C03971h c03971h = new C03971h();
        int i2 = 0;
        loop0: while (true) {
            boolean z2 = false;
            if (i2 >= ec.A02()) {
                C1991mA c1991mAA06 = ec.A06();
                for (int i8 = 0; i8 < c1991mAA06.A01; i8++) {
                    C2120oH c2120oHA05 = c1991mAA06.A05(i8);
                    int[] iArr = new int[c2120oHA05.A01];
                    Arrays.fill(iArr, 0);
                    c03971h.A04(new C2110o7(c2120oHA05, false, iArr, new boolean[c2120oHA05.A01]));
                }
                return new C2109o6(c03971h.A05());
            }
            C1991mA c1991mAA07 = ec.A07(i2);
            List<? extends EE> list = listArr[i2];
            int i9 = 0;
            while (i9 < c1991mAA07.A01) {
                C2120oH c2120oHA052 = c1991mAA07.A05(i9);
                int iA05 = ec.A05(i2, i9, z2);
                String[] strArr = A00;
                if (strArr[7].charAt(11) != strArr[0].charAt(11)) {
                    break loop0;
                }
                String[] strArr2 = A00;
                strArr2[7] = "wVGS7RX5kLdrLFKtRIe7uQsNtd1z6IxW";
                strArr2[0] = "7aERijPLyLRrdgSw5lQfoyda5cW2h3c0";
                boolean z7 = iA05 != 0;
                int[] iArr2 = new int[c2120oHA052.A01];
                boolean[] zArr = new boolean[c2120oHA052.A01];
                for (int i10 = 0; i10 < c2120oHA052.A01; i10++) {
                    iArr2[i10] = ec.A04(i2, i9, i10);
                    boolean z8 = false;
                    if (A00[5].length() != 9) {
                        break loop0;
                    }
                    String[] strArr3 = A00;
                    strArr3[2] = "3DHxmUKuGZITV4091m9MLUNqu1ZkNm0q";
                    strArr3[3] = "2BQZhu0LL1SbQMNt9wHOkoks63NLimX3";
                    int i11 = 0;
                    while (true) {
                        if (i11 < list.size()) {
                            EE ee = list.get(i11);
                            if (ee.A9D().equals(c2120oHA052) && ee.A9y(i10) != -1) {
                                z8 = true;
                                break;
                            }
                            i11++;
                        }
                    }
                    zArr[i10] = z8;
                }
                c03971h.A04(new C2110o7(c2120oHA052, z7, iArr2, zArr));
                i9++;
                z2 = false;
            }
            i2++;
        }
        throw new RuntimeException();
    }

    public static C2109o6 A00(EC ec, EE[] eeArr) {
        List listA01;
        List[] listArr = new List[eeArr.length];
        for (int i2 = 0; i2 < eeArr.length; i2++) {
            EE ee = eeArr[i2];
            if (ee != null) {
                listA01 = AbstractC0621Am.A04(ee);
            } else {
                listA01 = MetaExoPlayerCustomizedCollections.A01();
            }
            listArr[i2] = listA01;
        }
        return A01(ec, listArr);
    }
}
