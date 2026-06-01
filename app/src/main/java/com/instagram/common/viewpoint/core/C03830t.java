package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0t, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C03830t extends C05537j implements Comparable<C03830t> {
    public static String[] A01 = {"kvWdB3TE4F02CvBMsBFKzpbhVf73VbPo", "pIhQPOOT2xsrqrTjtTEUrnlklrU2j4Xx", "pdYckjhCIzgQgDgJpRux4fo9y3MK9tam", "XLFgtw4chSUawlDhyOF7PI6ZgPIPNXPT", "wXiI6RESjxFaJi9cRzlxvGX2h498oRyj", "Xh6QYYa7B1600WPBULoDPW4oSxfbsPz9", "bCs754CcQZSDfR1NSOnMEHTumHpSYrD0", "OFiOLoEO5ZOYdCRe7y5ePAMAMobk5MLR"};
    public long A00;

    public C03830t() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final int compareTo(C03830t c03830t) {
        if (A05() != c03830t.A05()) {
            return A05() ? 1 : -1;
        }
        long j = this.A01 - c03830t.A01;
        if (j == 0) {
            long j3 = this.A00;
            long delta = c03830t.A00;
            j = j3 - delta;
            if (j == 0) {
                return 0;
            }
        }
        String[] strArr = A01;
        if (strArr[7].charAt(9) != strArr[6].charAt(9)) {
            throw new RuntimeException();
        }
        A01[5] = "UnaoajjPsJhIzAMYj8TXxoU3mdsqoDpP";
        return j > 0 ? 1 : -1;
    }
}
