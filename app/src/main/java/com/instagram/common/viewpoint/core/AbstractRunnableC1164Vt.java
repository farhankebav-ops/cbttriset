package com.instagram.common.viewpoint.core;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractRunnableC1164Vt implements Runnable {
    public static byte[] A01;
    public static final AtomicBoolean A02;
    public static final AtomicBoolean A03;
    public static final AtomicReference<InterfaceC1154Vj> A04;
    public final C1152Vh A00;

    public static String A02(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 32);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A01 = new byte[]{44, 11, 16, 16, 31, 28, 18, 27, 94, 29, 12, 27, 31, 10, 27, 26, 80, 94, 42, 22, 12, 27, 31, 26, 68, 94};
    }

    public abstract void A07();

    static {
        A03();
        A02 = new AtomicBoolean();
        A03 = new AtomicBoolean(false);
        A04 = new AtomicReference<>();
    }

    public AbstractRunnableC1164Vt() {
        if (A03.get()) {
            this.A00 = C1169Vy.A01(new C1168Vx(A02(0, 26, 94) + Thread.currentThread().getName()));
        } else {
            this.A00 = null;
        }
    }

    public static void A04(boolean z2) {
        A03.set(z2);
    }

    public static void A05(boolean z2, InterfaceC1154Vj interfaceC1154Vj) {
        A02.set(z2);
        A04.set(interfaceC1154Vj);
    }

    public final C1152Vh A06() {
        return this.A00;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return;
        }
        try {
            if (A03.get()) {
                C1169Vy.A03(this);
            }
            try {
                A07();
            } catch (Throwable th) {
                if (A02.get()) {
                    W0.A00().AAo(3301, th);
                    InterfaceC1154Vj interfaceC1154Vj = A04.get();
                    if (interfaceC1154Vj != null) {
                        interfaceC1154Vj.AHp(th, this);
                    }
                } else {
                    throw th;
                }
            }
            if (A03.get()) {
                C1169Vy.A04(this);
            }
        } catch (Throwable th2) {
            AbstractC1156Vl.A00(th2, this);
        }
    }
}
