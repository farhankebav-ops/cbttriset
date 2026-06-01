package sg.bigo.ads.common.m;

import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f15802a = {1, 3, 4, 2, 7, 9, 10};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f15803b = {2, 7, 9, 10};

    public static boolean a() {
        String str;
        String strValueOf;
        String strConcat;
        if (b()) {
            String strB = b.b();
            if (q.a((CharSequence) strB)) {
                sg.bigo.ads.common.t.a.a(0, 3, "GdprHelper", "purposeConsents is empty, so return true");
            } else {
                if (strB.length() < 11) {
                    strConcat = "purposeConsents length < 11, so return false";
                    sg.bigo.ads.common.t.a.a(0, 3, "GdprHelper", strConcat);
                    return false;
                }
                for (int i2 : f15802a) {
                    if (strB.charAt(i2 - 1) == '0') {
                        str = "purposeConsents return false ,the checkBit is: ";
                        strValueOf = String.valueOf(i2);
                        break;
                    }
                }
            }
            String strD = b.d();
            if (q.a((CharSequence) strD)) {
                sg.bigo.ads.common.t.a.a(0, 3, "GdprHelper", "purposeLegitimateInterests is empty, so return true");
            } else {
                if (strD.length() < 11) {
                    strConcat = "purposeLegitimateInterests length < 11, so return false";
                    sg.bigo.ads.common.t.a.a(0, 3, "GdprHelper", strConcat);
                    return false;
                }
                for (int i8 : f15803b) {
                    if (strD.charAt(i8 - 1) == '0') {
                        str = "purposeLegitimateInterests return false ,the checkBit is: ";
                        strValueOf = String.valueOf(i8);
                        strConcat = str.concat(strValueOf);
                        sg.bigo.ads.common.t.a.a(0, 3, "GdprHelper", strConcat);
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean b() {
        return b.c() == 1;
    }
}
