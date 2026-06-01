package com.instagram.common.viewpoint.core;

import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.kT, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1899kT extends AbstractC0838Iz {
    public static String[] A02 = {"WZkrugZ9k", "x4SWtznAL", "HpTT9hwXiF", "GejxPsVIqdMqn4uNSueU2CvK5QdcE", "kY6PJZpIMUpeuimCFjYxSQzMMPc04", "AyPx1MENxNPCbM7HZGi1kOnAmMtkHxm9", "mMmHuZ9NaaUgibHMJoRcA4q0AdWca5ys", "Hii3DdXYVzyt8ReiNrO7wglp0i"};
    public C0769Gh A00;
    public C1900kU A01;

    private int A00(C4J c4j) {
        int i2 = (c4j.A0l()[2] & 255) >> 4;
        if (i2 == 6 || i2 == 7) {
            c4j.A0g(4);
            String[] strArr = A02;
            String str = strArr[6];
            String str2 = strArr[5];
            int iCharAt = str.charAt(19);
            int blockSizeKey = str2.charAt(19);
            if (iCharAt == blockSizeKey) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[1] = "Cisj8wK8S";
            strArr2[0] = "koTyuZ08X";
            c4j.A0S();
        }
        int result = AbstractC0765Gd.A00(c4j, i2);
        c4j.A0f(0);
        return result;
    }

    public static boolean A01(C4J c4j) {
        return c4j.A07() >= 5 && c4j.A0I() == 127 && c4j.A0Q() == 1179402563;
    }

    public static boolean A02(byte[] bArr) {
        return bArr[0] == -1;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC0838Iz
    public final long A09(C4J c4j) {
        if (!A02(c4j.A0l())) {
            return -1L;
        }
        return A00(c4j);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC0838Iz
    public final void A0B(boolean z2) {
        super.A0B(z2);
        if (z2) {
            this.A00 = null;
            this.A01 = null;
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC0838Iz
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public final boolean A0C(C4J c4j, long j, C0837Iy c0837Iy) {
        byte[] bArrA0l = c4j.A0l();
        C0769Gh c0769Gh = this.A00;
        if (c0769Gh == null) {
            C0769Gh c0769Gh2 = new C0769Gh(bArrA0l, 17);
            this.A00 = c0769Gh2;
            c0837Iy.A00 = c0769Gh2.A08(Arrays.copyOfRange(bArrA0l, 9, c4j.A0A()), null);
            return true;
        }
        if ((bArrA0l[0] & 127) == 3) {
            C0768Gg c0768GgA03 = AbstractC0767Gf.A03(c4j);
            C0769Gh streamMetadata = c0769Gh.A09(c0768GgA03);
            this.A00 = streamMetadata;
            this.A01 = new C1900kU(streamMetadata, c0768GgA03);
            return true;
        }
        if (!A02(bArrA0l)) {
            return true;
        }
        if (this.A01 != null) {
            this.A01.A00(j);
            c0837Iy.A01 = this.A01;
        }
        C2154or c2154or = c0837Iy.A00;
        String[] strArr = A02;
        if (strArr[4].length() == strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[3] = "zwTfeKiQLRobCpiZaAgtU0oyP8s29";
        strArr2[2] = "wrCWS6iAkk";
        C3M.A01(c2154or);
        return false;
    }
}
