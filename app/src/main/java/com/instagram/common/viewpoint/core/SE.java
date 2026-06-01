package com.instagram.common.viewpoint.core;

import android.graphics.Bitmap;
import android.net.TrafficStats;
import java.util.Arrays;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class SE implements Callable<Boolean> {
    public static byte[] A02;
    public final SD A00;
    public final /* synthetic */ SF A01;

    static {
        A02();
    }

    public static String A01(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 2);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{-35, -31, -43, -37, -39};
    }

    public SE(SF sf, SD sd) {
        this.A01 = sf;
        this.A00 = sd;
    }

    private final Boolean A00() throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return null;
        }
        try {
            TrafficStats.setThreadStatsTag(61453);
            C0886Kv c0886Kv = new C0886Kv(this.A00.A08, this.A00.A07, this.A00.A06, A01(0, 5, 114), this.A00.A02, this.A00.A03);
            c0886Kv.A01 = this.A00.A05;
            c0886Kv.A00 = this.A00.A04;
            if (SI.A06(this.A01.A04)) {
                SF.A0F.put(this.A00.A08, c0886Kv);
            }
            boolean precacheResult = false;
            if (this.A01.A08) {
                precacheResult = SF.A03(this.A01.A04.A02()).AHu(c0886Kv, false).A01();
            } else if (this.A01.A03.A0F(this.A00) != null) {
                precacheResult = true;
            }
            SL sl = this.A00.A01;
            if (sl != null && sl.A02()) {
                int iA00 = sl.A00();
                int iA01 = sl.A01();
                if (iA00 <= 0 || iA01 <= 0) {
                    if (this.A01.A08) {
                        A04(this.A00.A08, c0886Kv);
                    } else {
                        A03(this.A00.A04, this.A00.A05);
                    }
                } else if (this.A01.A08) {
                    c0886Kv.A00 = iA00;
                    c0886Kv.A01 = iA01;
                    A04(this.A00.A08, c0886Kv);
                } else {
                    A03(iA00, iA01);
                }
            }
            return Boolean.valueOf(precacheResult);
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
            return null;
        }
    }

    private void A03(int i2, int i8) {
        Bitmap bitmapA0G = this.A01.A03.A0G(this.A01.A04, this.A00.A08, i2, i8, this.A00.A02);
        if (bitmapA0G == null) {
            return;
        }
        this.A01.A07.put(this.A00.A08, bitmapA0G);
    }

    private void A04(String str, C0886Kv c0886Kv) {
        Bitmap bitmapA00 = SF.A03(this.A01.A04.A02()).AHu(c0886Kv, true).A00();
        if (bitmapA00 == null) {
            return;
        }
        this.A01.A07.put(str, bitmapA00);
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
