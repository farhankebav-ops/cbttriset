package com.instagram.common.viewpoint.core;

import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Rd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1047Rd {
    public static byte[] A05;
    public static String[] A06 = {"G44uIPn0vHKMb4gl1i6iMEVLbqSJJUyD", "cz5xpykBJ1m8ZSm6Ol7HGwJnVK5b1rdS", "fqm0fYEu9uvyEWxP31e", "dx2BR1y0ksYiHtLvIo7bMHcN32t5U4TZ", "MCCBRMfsF", "YhS48tuwIgdy2ctxacKEWCI4SO0xjdaQ", "0eQRRAl5wHIowgG0OxNPv3O5UqdrKzzl", "B6gN4hzeX4EfdYzWeUb7VxyWyH55Crun"};
    public final String A00;
    public final String A01;
    public final String A02;
    public final String A03;
    public final boolean A04;

    public static String A01(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i2, i2 + i8);
        int i10 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A06;
            if (strArr[6].charAt(16) == strArr[0].charAt(16)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A06;
            strArr2[6] = "Lo0unCvqAQEGTbh5Ufe2FG7hEyoPqpU0";
            strArr2[0] = "fa5GimV0q5n2gfKUlxWuqDakVSXec8h9";
            if (i10 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 41);
            i10++;
        }
    }

    public static void A02() {
        byte[] bArr = {-49, -38, -41, -49, -31, -8, 11, 7, -8, 1, 6, -4, 2, 1, -67, -66, -62, -73, -67, -68, -81, -70, 10, 8, 11, -5, -12, -7, -16, -27, -49, -52, -58};
        String[] strArr = A06;
        if (strArr[6].charAt(16) == strArr[0].charAt(16)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A06;
        strArr2[3] = "m2BLFMiMxal3vAe0HMiMUws6NSaJ7WNn";
        strArr2[1] = "VhuX8M66i6sFD9sc5DI464Hg1o5sMy0a";
        A05 = bArr;
    }

    static {
        A02();
    }

    public C1047Rd(String str, String str2, String str3, boolean z2, String str4) {
        this.A03 = str;
        this.A02 = str2;
        this.A01 = str3;
        this.A04 = z2;
        this.A00 = str4;
    }

    public static C1047Rd A00(JSONObject jSONObject) throws JSONException {
        return new C1047Rd(jSONObject.getString(A01(30, 3, 49)), jSONObject.getString(A01(26, 4, 87)), jSONObject.optString(A01(5, 9, 106)), jSONObject.getString(A01(14, 8, 37)).equals(A01(22, 4, 109)), jSONObject.optString(A01(0, 5, 69)));
    }
}
