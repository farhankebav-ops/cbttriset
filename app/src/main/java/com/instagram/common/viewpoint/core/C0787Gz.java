package com.instagram.common.viewpoint.core;

import com.ironsource.Q6;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0787Gz {
    public static String[] A04 = {"L", "s7TlvRdnTwK3t9C", "ePgRnDLQ3Wbr1YpTz29pmTY6GtuG6NQq", Q6.f7482y0, "s7BgXoB9vXyEEiATAltma4vCqurgDW8q", "LgZyZC", "BLEIsLc40BPM2xLP7Ykzo3HzSA", "v9CVGsZVCVWkGaEQgXjK1D2fYLLUoPIW"};
    public final int A00;
    public final int A01;
    public final int A02;
    public final byte[] A03;

    public C0787Gz(int i2, byte[] bArr, int i8, int i9) {
        this.A01 = i2;
        this.A03 = bArr;
        this.A02 = i8;
        this.A00 = i9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0787Gz c0787Gz = (C0787Gz) obj;
        String[] strArr = A04;
        if (strArr[6].length() == strArr[3].length()) {
            throw new RuntimeException();
        }
        A04[1] = "oBkTGyhCOE";
        if (this.A01 == c0787Gz.A01 && this.A02 == c0787Gz.A02 && this.A00 == c0787Gz.A00 && Arrays.equals(this.A03, c0787Gz.A03)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int result = this.A01;
        int i2 = result * 31;
        int result2 = Arrays.hashCode(this.A03);
        int result3 = (((i2 + result2) * 31) + this.A02) * 31;
        int result4 = this.A00;
        return result3 + result4;
    }
}
