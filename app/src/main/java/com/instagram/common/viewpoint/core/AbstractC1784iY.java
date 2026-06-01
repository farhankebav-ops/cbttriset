package com.instagram.common.viewpoint.core;

import com.google.common.base.ElementTypesAreNonnullByDefault;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.iY, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractC1784iY {
    public static String[] A00 = {"lKk5JaLmUx95KK", "mYuNW", "CjAKdLXppofA1D702KwO", "uXJpTDaVRtNVAp70rLVfm", "1hSAC5HvnjUxrHV2J", "HaqnzSsBrGrjOCqNCVI", "GKVrteGYxon0I6T9VCiXJnLEHrJ03INP", "n4WaWuAzWRB0VbcGBeRJywBcIsl3WCc7"};

    public static int A00(char c7) {
        return (char) ((c7 | ' ') - 97);
    }

    public static String A01(String string) {
        int length = string.length();
        int i2 = 0;
        while (i2 < length) {
            if (A02(string.charAt(i2))) {
                char[] chars = string.toCharArray();
                while (i2 < length) {
                    char c7 = chars[i2];
                    if (A02(c7)) {
                        int length2 = c7 ^ ' ';
                        chars[i2] = (char) length2;
                    }
                    i2++;
                }
                String strValueOf = String.valueOf(chars);
                int i8 = A00[5].length();
                if (i8 == 28) {
                    throw new RuntimeException();
                }
                A00[5] = "jxLLbSZUx5pXLcCA85YTs8Y";
                return strValueOf;
            }
            i2++;
        }
        return string;
    }

    public static boolean A02(char c7) {
        return c7 >= 'A' && c7 <= 'Z';
    }

    public static boolean A03(CharSequence s12, CharSequence s22) {
        int length = s12.length();
        if (s12 == s22) {
            return true;
        }
        int length2 = s22.length();
        if (length != length2) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = s12.charAt(i2);
            char cCharAt2 = s22.charAt(i2);
            if (cCharAt != cCharAt2) {
                int iA00 = A00(cCharAt);
                if (A00[6].charAt(27) != '0') {
                    throw new RuntimeException();
                }
                A00[6] = "1S1N8LGAQqFvlHlBSY2lJ7CUB7v0Wvcl";
                if (iA00 < 26) {
                    int length3 = A00(cCharAt2);
                    if (iA00 == length3) {
                    }
                }
                return false;
            }
        }
        return true;
    }
}
