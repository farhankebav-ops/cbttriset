package com.instagram.common.viewpoint.core;

import android.os.Bundle;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.p0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2162p0 implements C1S {
    public static byte[] A06;
    public static String[] A07 = {"HSHJbKu4LLVwlp8kAtKM", "V6sGPCPiRhBLh6", "pDYVgvWCLxIG9LT", "RWHl9GQtcXYH3V7mNtlpSVait36OCwJs", "0F7", "tg3oN59jNUBk8XSE4kwfd", "NBkHOFenkRKh7SKHrVJVIcIm0kDLsOxD", "OSER18TpRPMUQAQSprsMKIJx0xqzVeT1"};
    public static final C2162p0 A08;
    public static final C1R<C2162p0> A09;
    public static final C2163p1 A0A;
    public static final String A0B;
    public static final String A0C;
    public static final String A0D;
    public static final String A0E;
    public final int A00;
    public final int A01;
    public final long A02;
    public final long A03;
    public final Object A04;

    @MetaExoPlayerCustomization("Change back to private after AdsMediaSource fully upgraded")
    public final C2163p1[] A05;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C2162p0 A00(Bundle bundle) {
        C2163p1[] c2163p1Arr;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(A0B);
        if (parcelableArrayList == null) {
            c2163p1Arr = new C2163p1[0];
        } else {
            c2163p1Arr = new C2163p1[parcelableArrayList.size()];
            for (int i2 = 0; i2 < parcelableArrayList.size(); i2++) {
                c2163p1Arr[i2] = (C2163p1) C2163p1.A09.A6X((Bundle) parcelableArrayList.get(i2));
            }
        }
        return new C2162p0(null, c2163p1Arr, bundle.getLong(A0C, A08.A02), bundle.getLong(A0D, A08.A03), bundle.getInt(A0E, A08.A01));
    }

    public static String A02(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            int i11 = bArrCopyOfRange[i10] ^ i9;
            String[] strArr = A07;
            if (strArr[5].length() == strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A07;
            strArr2[5] = "7EQT2aPGHNOftenQ9VAvD";
            strArr2[1] = "79Hg5O6oUNL8gh";
            bArrCopyOfRange[i10] = (byte) (i11 ^ 28);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A06 = new byte[]{70, 74, 63, 51, 114, 119, 84, 97, 124, 102, 99, 96, 46, 72, 116, 120, 57, 60, 10, 61, 43, 45, 53, 61, 8, 55, 43, 49, 44, 49, 55, 54, 13, 43, 101, 47, 35, 98, 103, 112, 62, 88, 13, 1, 69, 84, 83, 64, 85, 72, 78, 79, 116, 82, 28, 1, 36, 16, 44, 33, 57, 34, 33, 35, 43, 19, 52, 33, 52, 37, 104, 33, 36, 51, 9, 36, 125, 80, 36, 29, 24, 84, 15, 8, 29, 8, 25, 65, 91, 94, 125, 72, 85, 79, 74, 18, 78, 83, 87, 95, 111, 73, 7};
    }

    static {
        A03();
        A08 = new C2162p0(null, new C2163p1[0], 0L, -9223372036854775807L, 0);
        A0A = new C2163p1(0L).A06(0);
        A0B = AbstractC04664a.A0h(1);
        A0C = AbstractC04664a.A0h(2);
        A0D = AbstractC04664a.A0h(3);
        A0E = AbstractC04664a.A0h(4);
        A09 = new C1R() { // from class: com.facebook.ads.redexgen.X.p3
            @Override // com.instagram.common.viewpoint.core.C1R
            public final C1S A6X(Bundle bundle) {
                return C2162p0.A00(bundle);
            }
        };
    }

    public C2162p0(Object obj, C2163p1[] c2163p1Arr, long j, long j3, int i2) {
        this.A04 = obj;
        this.A02 = j;
        this.A03 = j3;
        this.A00 = c2163p1Arr.length + i2;
        this.A05 = c2163p1Arr;
        this.A01 = i2;
    }

    private boolean A04(long j, long j3, int i2) {
        if (j == Long.MIN_VALUE) {
            return false;
        }
        long j8 = A07(i2).A03;
        if (j8 != Long.MIN_VALUE) {
            return j < j8;
        }
        if (A07[3].charAt(17) != 't') {
            throw new RuntimeException();
        }
        String[] strArr = A07;
        strArr[5] = "6w59Aw8BMojzvOgPymJyT";
        strArr[1] = "Ceso9EO8QL9NfZ";
        return j3 == -9223372036854775807L || j < j3;
    }

    public final int A05(long j, long j3) {
        if (j == Long.MIN_VALUE || (j3 != -9223372036854775807L && j >= j3)) {
            return -1;
        }
        int index = this.A01;
        while (index < this.A00 && ((A07(index).A03 != Long.MIN_VALUE && A07(index).A03 <= j) || !A07(index).A08())) {
            index++;
        }
        if (index < this.A00) {
            return index;
        }
        return -1;
    }

    public final int A06(long j, long j3) {
        int i2 = this.A00 - 1;
        while (i2 >= 0 && A04(j, j3, i2)) {
            i2--;
        }
        if (i2 < 0 || !A07(i2).A07()) {
            return -1;
        }
        return i2;
    }

    public final C2163p1 A07(int i2) {
        if (i2 < this.A01) {
            return A0A;
        }
        return this.A05[i2 - this.A01];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C2162p0 c2162p0 = (C2162p0) obj;
        if (AbstractC04664a.A1E(this.A04, c2162p0.A04) && this.A00 == c2162p0.A00 && this.A02 == c2162p0.A02 && this.A03 == c2162p0.A03 && this.A01 == c2162p0.A01) {
            C2163p1[] c2163p1Arr = this.A05;
            String[] strArr = A07;
            if (strArr[5].length() == strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A07;
            strArr2[5] = "16faulxPxX0sTjyZsuY2d";
            strArr2[1] = "99yT7gYz4zzQy1";
            if (Arrays.equals(c2163p1Arr, c2162p0.A05)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int result = this.A00;
        int i2 = result * 31;
        int result2 = this.A04 == null ? 0 : this.A04.hashCode();
        int i8 = (((i2 + result2) * 31) + ((int) this.A02)) * 31;
        int result3 = (int) this.A03;
        int result4 = (((i8 + result3) * 31) + this.A01) * 31;
        int result5 = Arrays.hashCode(this.A05);
        return result4 + result5;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(A02(55, 22, 92));
        sb.append(this.A04);
        sb.append(A02(14, 21, 68));
        sb.append(this.A02);
        sb.append(A02(2, 12, 15));
        int i2 = 0;
        while (true) {
            C2163p1[] c2163p1Arr = this.A05;
            String[] strArr = A07;
            String str = strArr[0];
            String str2 = strArr[2];
            int i8 = str.length();
            if (i8 == str2.length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A07;
            strArr2[0] = "HwwbQlKsFzrVvgzZA70k";
            strArr2[2] = "CWSfdfe0R8gD4PU";
            int length = c2163p1Arr.length;
            String strA02 = A02(77, 2, 17);
            if (i2 < length) {
                sb.append(A02(88, 15, 38));
                sb.append(this.A05[i2].A03);
                sb.append(A02(35, 7, 31));
                int i9 = 0;
                while (true) {
                    int length2 = this.A05[i2].A05.length;
                    String strA022 = A02(0, 2, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE);
                    if (i9 < length2) {
                        sb.append(A02(79, 9, 96));
                        int i10 = this.A05[i2].A05[i9];
                        switch (i10) {
                            case 0:
                                sb.append('_');
                                break;
                            case 1:
                                sb.append('R');
                                break;
                            case 2:
                                sb.append('S');
                                break;
                            case 3:
                                sb.append('P');
                                break;
                            case 4:
                                sb.append('!');
                                break;
                            default:
                                sb.append('?');
                                break;
                        }
                        sb.append(A02(42, 13, 61));
                        sb.append(this.A05[i2].A06[i9]);
                        sb.append(')');
                        int i11 = this.A05[i2].A05.length;
                        if (i9 < i11 - 1) {
                            sb.append(strA022);
                        }
                        i9++;
                    } else {
                        sb.append(strA02);
                        String[] strArr3 = A07;
                        String str3 = strArr3[5];
                        String str4 = strArr3[1];
                        int i12 = str3.length();
                        if (i12 == str4.length()) {
                            throw new RuntimeException();
                        }
                        String[] strArr4 = A07;
                        strArr4[0] = "tpRIwkkikLxaZqXNkXQj";
                        strArr4[2] = "ureQIhKfJpTfNVp";
                        if (i2 < this.A05.length - 1) {
                            sb.append(strA022);
                        }
                        i2++;
                    }
                }
            } else {
                sb.append(strA02);
                return sb.toString();
            }
        }
    }
}
