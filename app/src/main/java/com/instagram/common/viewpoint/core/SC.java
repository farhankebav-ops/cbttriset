package com.instagram.common.viewpoint.core;

import android.net.TrafficStats;
import java.util.Arrays;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class SC implements Callable<Boolean> {
    public static byte[] A02;
    public final SB A00;
    public final /* synthetic */ SF A01;

    static {
        A02();
    }

    public static String A01(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 41);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{-34, -46, -29, -36, -26, -31, -25, -38, -43, -42, -32};
    }

    public SC(SF sf, SB sb) {
        this.A01 = sf;
        this.A00 = sb;
    }

    private final Boolean A00() throws Throwable {
        String strA01;
        if (AbstractC1156Vl.A02(this)) {
            return null;
        }
        try {
            TrafficStats.setThreadStatsTag(61453);
            if (this.A00.A04) {
                strA01 = A01(0, 6, 72);
            } else {
                strA01 = A01(6, 5, 72);
            }
            String str = this.A00.A08;
            String creativeType = this.A00.A07;
            C0886Kv c0886Kv = new C0886Kv(str, creativeType, this.A00.A06, strA01, this.A00.A02, this.A00.A05);
            c0886Kv.A04 = this.A00.A03;
            c0886Kv.A02 = this.A00.A01;
            c0886Kv.A05 = this.A00.A04;
            if (SI.A06(this.A01.A04)) {
                SF.A0F.put(this.A00.A08, c0886Kv);
            }
            return Boolean.valueOf(SF.A03(this.A01.A04.A02()).AHw(c0886Kv) != null);
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
            return null;
        }
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Boolean call() throws Exception {
        if (AbstractC1156Vl.A02(this)) {
            return null;
        }
        try {
            return A00();
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
            return null;
        }
    }
}
