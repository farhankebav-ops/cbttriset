package com.instagram.common.viewpoint.core;

import com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView;
import com.ironsource.Hc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class QK {
    public static byte[] A06;
    public static String[] A07 = {Hc.e, "BOchn05cOqPQPKgaZhD7MWqYHqoCKx7o", "EPTevQXo6AzOyuxFlfcAvx5eJdnVP8", "v", "6fNY9lNhy7nUhuOGP7YDUX6WqdzgNzMN", "SLjIMlZrt8LApw5SyAUFDc4ipDag7tTu", "zXvx6U5xIRhnU3fWG5rnYTWUnq20aSrc", "c4GOdlXhzm3270NA43EFNLoVECdVoF38"};
    public QI A04 = null;
    public ArrayList<RecyclerView.ItemAnimator.ItemAnimatorFinishedListener> A05 = new ArrayList<>();
    public long A00 = 120;
    public long A03 = 120;
    public long A02 = 250;
    public long A01 = 250;

    public static String A08(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            byte b8 = (byte) ((bArrCopyOfRange[i10] - i9) - 109);
            String[] strArr = A07;
            if (strArr[6].charAt(25) == strArr[5].charAt(25)) {
                throw new RuntimeException();
            }
            A07[2] = "awpTB9u15TkHVvPjjOCd09Fy8dol99E";
            bArrCopyOfRange[i10] = b8;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A09() {
        A06 = new byte[]{76, 75, 30, 75, 70, 74, 62, 81, 70, 76, 75, 80, 35, 70, 75, 70, 80, 69, 66, 65};
    }

    public abstract void A0H();

    public abstract void A0I();

    public abstract void A0L(AbstractC1024Qg abstractC1024Qg);

    public abstract boolean A0M();

    public abstract boolean A0N(AbstractC1024Qg abstractC1024Qg);

    public abstract boolean A0O(AbstractC1024Qg abstractC1024Qg, QJ qj, QJ qj2);

    public abstract boolean A0P(AbstractC1024Qg abstractC1024Qg, QJ qj, QJ qj2);

    public abstract boolean A0Q(AbstractC1024Qg abstractC1024Qg, QJ qj, QJ qj2);

    public abstract boolean A0R(AbstractC1024Qg abstractC1024Qg, AbstractC1024Qg abstractC1024Qg2, QJ qj, QJ qj2);

    static {
        A09();
    }

    public static int A06(AbstractC1024Qg abstractC1024Qg) {
        int i2 = abstractC1024Qg.A0C & 14;
        if (abstractC1024Qg.A0f()) {
            return 4;
        }
        int flags = i2 & 4;
        if (flags == 0) {
            int pos = abstractC1024Qg.A0P();
            int oldPos = abstractC1024Qg.A0M();
            if (pos != -1 && oldPos != -1 && pos != oldPos) {
                return i2 | 2048;
            }
            return i2;
        }
        return i2;
    }

    private final QJ A07() {
        return new QJ();
    }

    public final long A0A() {
        return this.A00;
    }

    public final long A0B() {
        return this.A01;
    }

    public final long A0C() {
        return this.A02;
    }

    public final long A0D() {
        return this.A03;
    }

    public final QJ A0E(C1021Qd c1021Qd, AbstractC1024Qg abstractC1024Qg) {
        return A07().A01(abstractC1024Qg);
    }

    public final QJ A0F(C1021Qd c1021Qd, AbstractC1024Qg abstractC1024Qg, int i2, List<Object> payloads) {
        return A07().A01(abstractC1024Qg);
    }

    public final void A0G() {
        int count = this.A05.size();
        if (0 < count) {
            this.A05.get(0);
            throw new NullPointerException(A08(0, 20, 112));
        }
        this.A05.clear();
    }

    public final void A0J(QI qi) {
        this.A04 = qi;
    }

    public final void A0K(AbstractC1024Qg abstractC1024Qg) {
        if (this.A04 != null) {
            this.A04.ACK(abstractC1024Qg);
        }
    }

    public boolean A0S(AbstractC1024Qg abstractC1024Qg, List<Object> payloads) {
        return A0N(abstractC1024Qg);
    }
}
