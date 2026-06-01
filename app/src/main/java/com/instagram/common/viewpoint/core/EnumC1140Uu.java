package com.instagram.common.viewpoint.core;

import com.facebook.ads.VideoAutoplayBehavior;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Uu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class EnumC1140Uu {
    public static byte[] A00;
    public static String[] A01 = {"t11qfTcdRX3vtzWg9o3D7yzOQIlsgekI", "6i20agDhmSdy9vSyuA65WoFMQBMnYQqu", "rdyvRl0mnrLy9iBwCAplKJJzDaMabc0M", "SOZt7VgRETJYcVg4", "xbstiP5KKiAzncux", "VTcuBCbEWMb14OGNQVtfuGUmCLIRmz1L", "NW0LuK6Vb9eH6jcO6lyYeFn7KSHSxynw", "5brGPIOfpSxIScBaveghLVMlb1271YeU"};
    public static final /* synthetic */ EnumC1140Uu[] A02;
    public static final EnumC1140Uu A03;
    public static final EnumC1140Uu A04;
    public static final EnumC1140Uu A05;

    public static String A01(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 33);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{88, 89, 90, 93, 73, 80, 72, 98, 107, 107, 2, 3};
    }

    static {
        A02();
        A03 = new EnumC1140Uu(A01(0, 7, 61), 0);
        A05 = new EnumC1140Uu(A01(10, 2, 108), 1);
        A04 = new EnumC1140Uu(A01(7, 3, 12), 2);
        A02 = A03();
    }

    public EnumC1140Uu(String str, int i2) {
    }

    public static VideoAutoplayBehavior A00(@Nullable EnumC1140Uu enumC1140Uu) {
        if (enumC1140Uu == null) {
            return VideoAutoplayBehavior.DEFAULT;
        }
        switch (C1139Ut.A00[enumC1140Uu.ordinal()]) {
            case 1:
                VideoAutoplayBehavior videoAutoplayBehavior = VideoAutoplayBehavior.DEFAULT;
                if (A01[1].charAt(31) != 'u') {
                    throw new RuntimeException();
                }
                String[] strArr = A01;
                strArr[2] = "tGhoRPzzdwkU9rBMhrkq51QPgJKMKCG7";
                strArr[7] = "oLzw2E9OShYSASB843fXRAiyIcSfpUGD";
                return videoAutoplayBehavior;
            case 2:
                return VideoAutoplayBehavior.ON;
            case 3:
                return VideoAutoplayBehavior.OFF;
            default:
                return VideoAutoplayBehavior.DEFAULT;
        }
    }

    public static /* synthetic */ EnumC1140Uu[] A03() {
        EnumC1140Uu[] enumC1140UuArr = new EnumC1140Uu[3];
        enumC1140UuArr[0] = A03;
        if (A01[5].charAt(31) != 'L') {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[3] = "zoiTRupMudK7uDXw";
        strArr[4] = "VFYrxWbIb3tlnjHn";
        enumC1140UuArr[1] = A05;
        enumC1140UuArr[2] = A04;
        return enumC1140UuArr;
    }

    public static EnumC1140Uu valueOf(String str) {
        return (EnumC1140Uu) Enum.valueOf(EnumC1140Uu.class, str);
    }

    public static EnumC1140Uu[] values() {
        return (EnumC1140Uu[]) A02.clone();
    }
}
