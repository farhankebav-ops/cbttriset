package com.instagram.common.viewpoint.core;

import android.os.Process;
import android.text.TextUtils;
import java.lang.Thread;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Sl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1080Sl implements Thread.UncaughtExceptionHandler {
    public static byte[] A04;
    public final C1451cu A00;
    public final InterfaceC1087Ss A01;
    public final Thread.UncaughtExceptionHandler A02;
    public final Map<String, String> A03;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 48);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{-79, -51, -102, -74, -64, -64, -74, -69, -76, 109, -112, -68, -69, -63, -78, -59, -63, -102, -90, -92, 101, -99, -104, -102, -100, -103, -90, -90, -94, 101, -104, -101, -86, 2, 17, 0, 18, 7, 7, 9, -10, 8, 13, 4, -7, -20, -18, -37, -19, -14, -23, -34, -40, -36, -24, -35, -34};
    }

    public C1080Sl(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, C1451cu c1451cu, InterfaceC1079Sk interfaceC1079Sk) {
        this(uncaughtExceptionHandler, c1451cu, interfaceC1079Sk, AbstractC1088St.A00());
    }

    public C1080Sl(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, C1451cu c1451cu, InterfaceC1079Sk interfaceC1079Sk, InterfaceC1087Ss interfaceC1087Ss) {
        this.A02 = uncaughtExceptionHandler;
        if (c1451cu != null) {
            this.A00 = c1451cu;
            this.A03 = interfaceC1079Sk.A8z(c1451cu);
            this.A01 = interfaceC1087Ss;
            return;
        }
        throw new IllegalArgumentException(A00(2, 15, 29));
    }

    public static void A02() {
        try {
            Process.killProcess(Process.myPid());
        } catch (Throwable unused) {
        }
        try {
            System.exit(10);
        } catch (Throwable unused2) {
        }
    }

    private void A03(Thread thread, Throwable th) {
        if (this.A02 != null) {
            this.A02.uncaughtException(thread, th);
        } else {
            A02();
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            String strA03 = X7.A03(this.A00, th);
            if (!TextUtils.isEmpty(strA03)) {
                String stackTraceString = A00(17, 16, 7);
                if (strA03.contains(stackTraceString)) {
                    Map<String, String> mapA02 = new C1078Sj(strA03, this.A03).A02();
                    String strA00 = A00(38, 7, 100);
                    String stackTraceString2 = A00(33, 5, 111);
                    mapA02.put(strA00, stackTraceString2);
                    Throwable thA00 = AbstractRunnableC1151Vg.A00();
                    String strA002 = A00(45, 12, 73);
                    if (thA00 == th) {
                        String stackTraceString3 = A00(1, 1, 108);
                        mapA02.put(strA002, stackTraceString3);
                    } else {
                        String stackTraceString4 = A00(0, 1, 81);
                        mapA02.put(strA002, stackTraceString4);
                    }
                    this.A01.AKM(new C1094Sz(this.A00.A09().A01(), this.A00.A09().A02(), mapA02), this.A00);
                    if (U7.A24(this.A00)) {
                        U7.A0e(this.A00);
                    }
                }
            }
        } catch (Exception unused) {
        }
        A03(thread, th);
    }
}
