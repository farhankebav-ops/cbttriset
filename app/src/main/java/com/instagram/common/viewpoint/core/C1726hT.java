package com.instagram.common.viewpoint.core;

import android.view.View;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hT, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1726hT implements MX {
    public static byte[] A02;
    public static String[] A03 = {"ebJtInVgM8lwtLsL8CqjQvfHZTFWXyTj", "MRT4Iz3aNiJEaKRUIrDApfghDq01n6sB", "qhIcWii6jOsLbVLe4G", "jd0Ec4CahT7YYBjB568owPC0gY4s3zOU", "RPiMcfQYBdHC0SSG6XvNc0NsjlYurq5U", "E74vSWGMqEH8Jt4WlgBEkdQ8nTEO7fKB", "DEVdv4rr1ByH9p4ezSF9ryFdFyWOGnGy", "23RYwIDt1nJrIBpc57"};
    public final /* synthetic */ AnonymousClass72 A00;
    public final /* synthetic */ Runnable A01;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 78);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{93, 15, 93, 88, 15, 15, 10, 13, 32, 3, 12, 12, 7, 16, 66, 11, 15, 18, 16, 7, 17, 17, 11, 13, 12, 66, 4, 11, 16, 7, 6, 28, 29, 49, 18, 29, 29, 22, 1, 63, 28, 20, 20, 26, 29, 20, 58, 30, 3, 1, 22, 0, 0, 26, 28, 29};
    }

    static {
        A01();
    }

    public C1726hT(AnonymousClass72 anonymousClass72, Runnable runnable) {
        this.A00 = anonymousClass72;
        this.A01 = runnable;
    }

    @Override // com.instagram.common.viewpoint.core.MX
    public final void ACb(InterfaceC1789id interfaceC1789id) {
        this.A00.A02.A0F().A4S();
        this.A00.A07.A0C();
    }

    @Override // com.instagram.common.viewpoint.core.MX
    public final void ACc(InterfaceC1789id interfaceC1789id, View view) {
        this.A00.A02.A0F().A4R(interfaceC1789id == ((AbstractC1723hQ) this.A00).A00);
        if (interfaceC1789id != ((AbstractC1723hQ) this.A00).A00) {
            return;
        }
        this.A00.A0H().removeCallbacks(this.A01);
        MP mp = ((AbstractC1723hQ) this.A00).A01;
        AnonymousClass72 anonymousClass72 = this.A00;
        String[] strArr = A03;
        if (strArr[6].charAt(14) != strArr[5].charAt(14)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A03;
        strArr2[0] = "gfJNIdbF2FrCa8qL8kuytpSS0QUlrsrj";
        strArr2[1] = "KzSpIsxhAVssntgB7OlLodebxm4ynnXJ";
        ((AbstractC1723hQ) anonymousClass72).A01 = interfaceC1789id;
        this.A00.A01 = view;
        if (!this.A00.A0C) {
            this.A00.A07.A0F(interfaceC1789id);
        } else {
            this.A00.A07.A0E(view);
            this.A00.A0Q(mp);
        }
    }

    @Override // com.instagram.common.viewpoint.core.MX
    public final void ACd(InterfaceC1789id interfaceC1789id) {
        VF.A05(A00(31, 25, 61), A00(8, 23, 44), A00(0, 8, 37));
        this.A00.A02.A0F().A4U();
        this.A00.A07.A0D();
        this.A00.A0O();
    }

    @Override // com.instagram.common.viewpoint.core.MX
    public final void ADj(InterfaceC1789id interfaceC1789id, V1 v12) {
        this.A00.A02.A0F().A4T(interfaceC1789id == ((AbstractC1723hQ) this.A00).A00, v12.A03().getErrorCode());
        if (interfaceC1789id != ((AbstractC1723hQ) this.A00).A00) {
            return;
        }
        this.A00.A0H().removeCallbacks(this.A01);
        this.A00.A0Q(interfaceC1789id);
        this.A00.ADB(v12);
    }
}
