package com.instagram.common.viewpoint.core;

import android.animation.ObjectAnimator;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.a2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1275a2 implements Runnable {
    public static byte[] A01;
    public final /* synthetic */ C05085q A00;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 45);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{12, 1, 29, 5, 12};
    }

    public RunnableC1275a2(C05085q c05085q) {
        this.A00 = c05085q;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        String strA00 = A00(0, 5, 64);
        if (AbstractC1156Vl.A02(this)) {
            return;
        }
        try {
            this.A00.A0T.A0F().AJx();
            ObjectAnimator.ofFloat(this.A00.A0Q, strA00, 1.0f, 0.0f).setDuration(100L).start();
            ObjectAnimator.ofFloat(this.A00.A0P, strA00, 1.0f, 0.0f).setDuration(100L).start();
            ObjectAnimator duration = ObjectAnimator.ofFloat(((AbstractC1268Zv) this.A00).A09, strA00, 1.0f, 0.0f).setDuration(100L);
            duration.addListener(new C1274a1(this));
            duration.start();
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
        }
    }
}
