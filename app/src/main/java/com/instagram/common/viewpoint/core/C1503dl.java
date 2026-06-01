package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.dl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1503dl implements LA {
    public static byte[] A01;
    public static String[] A02 = {"DkadTd3hzRbbbOHMxE7l2HcIgF77c2Wg", "0ZuZJmAU8cZIcQf3szyGmXM5AilOTJtQ", "s7OtZpyonCiYFMYFU1WCjmQvHXym6FPj", "3vySfQzjuhiXchKud6RTPthf0ulaYdWV", "CDvhYqwZm7dYJUP65EPDHmFcAmisUun7", "F", "FueLju8lXT0mR7zmJE5", "4fFvsSsvSh6WJapTHyxRGbQ9SIVR6447"};
    public final /* synthetic */ C1451cu A00;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 23);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        byte[] bArr = {-89, -85, -97, -91, -93};
        String[] strArr = A02;
        if (strArr[4].charAt(11) == strArr[0].charAt(11)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[4] = "8YVOAkqjlCZIfPO923uAjm7vB9HJVDjx";
        strArr2[0] = "zjuPMStvlm1D7VGZIKzQB2odE0473uv0";
        A01 = bArr;
    }

    static {
        A01();
    }

    public C1503dl(C1451cu c1451cu) {
        this.A00 = c1451cu;
    }

    @Override // com.instagram.common.viewpoint.core.LA
    public final void AAq(Throwable th) {
        this.A00.A08().AAy(A00(0, 5, 39), AbstractC1090Sv.A1e, new C1091Sw(th));
    }

    @Override // com.instagram.common.viewpoint.core.LA
    public final void AB4(Throwable th) {
        this.A00.A08().AAy(A00(0, 5, 39), AbstractC1090Sv.A1g, new C1091Sw(th));
    }

    @Override // com.instagram.common.viewpoint.core.LA
    public final void AGk(String str, int i2, String str2, Long l, Long l8, C0886Kv c0886Kv) {
        SI.A05(this.A00, c0886Kv.A06, c0886Kv.A08, c0886Kv.A09, c0886Kv.A07, c0886Kv.A03, i2, str2, l, l8, null);
    }

    @Override // com.instagram.common.viewpoint.core.LA
    public final void AGl(String str, boolean z2, C0886Kv c0886Kv) {
        SI.A04(this.A00, new SH(c0886Kv.A06, c0886Kv.A08, c0886Kv.A07, c0886Kv.A03, str), z2);
    }
}
