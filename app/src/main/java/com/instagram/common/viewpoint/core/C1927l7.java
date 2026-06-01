package com.instagram.common.viewpoint.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.l7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1927l7 extends HI {
    public static byte[] A03;
    public static String[] A04 = {"hpDJt5h1KEOoxvwsMFQNYPr", "VSvt5SXm5usvlgrWoNvpXkXh8Dq", "BGFNPpHl8d5ErpIW7AfimlhS91R1U6wd", "7dPt9qHZlpxHIlw3mPQ6xbLk1XOmee", "0b", "V5zubMgZbVWtRFu8X", "n5IVAqV2SnF", "Sg4r6ty2QhZ"};
    public long A00;
    public long[] A01;
    public long[] A02;

    public static String A04(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 92);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0A() {
        A03 = new byte[]{-39, -22, -25, -42, -23, -34, -28, -29, -43, -40, -37, -44, -33, -34, -30, -40, -29, -40, -34, -35, -30, -32, -38, -18, -37, -25, -42, -30, -38, -24, -25, -26, -59, -35, -20, -39, -68, -39, -20, -39, 35, 24, 28, 20, 34};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.instagram.common.viewpoint.core.HI
    public final boolean A0C(C4J c4j, long j) {
        int i2;
        if (A00(c4j) != 2) {
            return false;
        }
        String strA05 = A05(c4j);
        if (A04[2].charAt(14) == 'f') {
            throw new RuntimeException();
        }
        A04[2] = "yhTvZHDsLiRhvHdxFLG6a7MHjxNmCRFd";
        if (!A04(30, 10, 28).equals(strA05) || c4j.A07() == 0 || A00(c4j) != 8) {
            return false;
        }
        HashMap<String, Object> mapA08 = A08(c4j);
        Object obj = mapA08.get(A04(0, 8, 25));
        if (obj instanceof Double) {
            double dDoubleValue = ((Double) obj).doubleValue();
            if (dDoubleValue > 0.0d) {
                this.A00 = (long) (dDoubleValue * 1000000.0d);
            }
        }
        Object obj2 = mapA08.get(A04(21, 9, 25));
        if (!(obj2 instanceof Map)) {
            return false;
        }
        Map map = (Map) obj2;
        Object obj3 = map.get(A04(8, 13, 19));
        Object obj4 = map.get(A04(40, 5, 83));
        if (!(obj3 instanceof List) || !(obj4 instanceof List)) {
            return false;
        }
        List list = (List) obj3;
        List list2 = (List) obj4;
        int size = list2.size();
        long[] jArr = new long[size];
        if (A04[3].length() != 20) {
            A04[1] = "ycK0oDKd1FWGh";
            this.A02 = jArr;
            this.A01 = new long[size];
            i2 = 0;
        } else {
            A04[3] = "l8UzOy1g7iACMRm";
            this.A02 = jArr;
            this.A01 = new long[size];
            i2 = 0;
        }
        while (i2 < size) {
            Object obj5 = list.get(i2);
            Object obj6 = list2.get(i2);
            if (!(obj6 instanceof Double) || !(obj5 instanceof Double)) {
                this.A02 = new long[0];
                this.A01 = new long[0];
                return false;
            }
            this.A02[i2] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
            this.A01[i2] = ((Double) obj5).longValue();
            i2++;
        }
        return false;
    }

    static {
        A0A();
    }

    public C1927l7() {
        super(new C1944lO());
        this.A00 = -9223372036854775807L;
        this.A02 = new long[0];
        this.A01 = new long[0];
    }

    public static int A00(C4J c4j) {
        return c4j.A0I();
    }

    public static Boolean A01(C4J c4j) {
        return Boolean.valueOf(c4j.A0I() == 1);
    }

    public static Double A02(C4J c4j) {
        return Double.valueOf(Double.longBitsToDouble(c4j.A0P()));
    }

    public static Object A03(C4J c4j, int i2) {
        switch (i2) {
            case 0:
                return A02(c4j);
            case 1:
                return A01(c4j);
            case 2:
                return A05(c4j);
            case 3:
                return A09(c4j);
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            default:
                return null;
            case 8:
                return A08(c4j);
            case 10:
                return A06(c4j);
            case 11:
                return A07(c4j);
        }
    }

    public static String A05(C4J c4j) {
        int iA0M = c4j.A0M();
        int iA09 = c4j.A09();
        c4j.A0g(iA0M);
        return new String(c4j.A0l(), iA09, iA0M);
    }

    public static ArrayList<Object> A06(C4J c4j) {
        int iA0L = c4j.A0L();
        ArrayList<Object> arrayList = new ArrayList<>(iA0L);
        for (int i2 = 0; i2 < iA0L; i2++) {
            int count = A00(c4j);
            Object objA03 = A03(c4j, count);
            if (objA03 != null) {
                arrayList.add(objA03);
            }
        }
        return arrayList;
    }

    public static Date A07(C4J c4j) {
        Date date = new Date((long) A02(c4j).doubleValue());
        c4j.A0g(2);
        return date;
    }

    public static HashMap<String, Object> A08(C4J c4j) {
        int iA0L = c4j.A0L();
        HashMap<String, Object> map = new HashMap<>(iA0L);
        for (int i2 = 0; i2 < iA0L; i2++) {
            String strA05 = A05(c4j);
            int count = A00(c4j);
            Object objA03 = A03(c4j, count);
            if (objA03 != null) {
                map.put(strA05, objA03);
            }
        }
        return map;
    }

    public static HashMap<String, Object> A09(C4J c4j) {
        HashMap<String, Object> map = new HashMap<>();
        while (true) {
            String strA05 = A05(c4j);
            int iA00 = A00(c4j);
            if (iA00 == 9) {
                return map;
            }
            Object objA03 = A03(c4j, iA00);
            if (objA03 != null) {
                map.put(strA05, objA03);
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.HI
    public final boolean A0B(C4J c4j) {
        return true;
    }

    public final long A0D() {
        return this.A00;
    }

    public final long[] A0E() {
        return this.A01;
    }

    public final long[] A0F() {
        return this.A02;
    }
}
