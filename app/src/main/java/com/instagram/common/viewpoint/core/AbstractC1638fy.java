package com.instagram.common.viewpoint.core;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.fy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1638fy extends QR {
    public static byte[] A03;
    public static String[] A04 = {"VI3k6vbyE", "wbKxmRtdnLanYPPQlq0AQ7UHjncjxjam", "7rHsxeXjhwTRluKKUSI3i7DNAgzyS", "RLsJgHk6VqLvU3GrilIJimxIkswsMvKT", "sHDfA32w1RYOD3HMFDMkWGxW2yjuY1ZH", "JEcuqbBofZsfD30FS8fTTaggCipMDK", "8NUawD4TiWbh8YzDjR1LHPIBKq0RidcG", "8EIjrQLLrDPWSel1MFlzfXR6TVhPBcGW"};
    public C05246g A00;
    public Scroller A01;
    public final QT A02 = new C1639fz(this);

    public static String A06(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 15);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A09() {
        A03 = new byte[]{-120, -75, 103, -80, -75, -70, -69, -88, -75, -86, -84, 103, -74, -83, 103, -106, -75, -115, -77, -80, -75, -82, -109, -80, -70, -69, -84, -75, -84, -71, 103, -88, -77, -71, -84, -88, -85, -64, 103, -70, -84, -69, 117};
    }

    public abstract int A0C(QO qo, int i2, int i8);

    public abstract View A0D(QO qo);

    @Deprecated
    public abstract C1656gH A0E(QO qo);

    public abstract int[] A0H(QO qo, View view);

    static {
        A09();
    }

    private final C1656gH A05(QO qo) {
        return A0E(qo);
    }

    private void A07() {
        this.A00.A1i(this.A02);
        this.A00.setOnFlingListener(null);
    }

    private void A08() throws IllegalStateException {
        if (this.A00.getOnFlingListener() == null) {
            this.A00.A1h(this.A02);
            this.A00.setOnFlingListener(this);
            return;
        }
        throw new IllegalStateException(A06(0, 43, 56));
    }

    private boolean A0A(QO qo, int i2, int i8) {
        C1656gH c1656gHA05;
        int iA0C;
        if (!(qo instanceof InterfaceC1018Qa) || (c1656gHA05 = A05(qo)) == null || (iA0C = A0C(qo, i2, i8)) == -1) {
            return false;
        }
        c1656gHA05.A0A(iA0C);
        qo.A1N(c1656gHA05);
        return true;
    }

    @Override // com.instagram.common.viewpoint.core.QR
    public final boolean A0B(int i2, int i8) {
        QO layoutManager = this.A00.getLayoutManager();
        if (layoutManager == null || this.A00.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.A00.getMinFlingVelocity();
        return (Math.abs(i8) > minFlingVelocity || Math.abs(i2) > minFlingVelocity) && A0A(layoutManager, i2, i8);
    }

    public final void A0F() {
        QO layoutManager;
        View viewA0D;
        if (this.A00 == null || (layoutManager = this.A00.getLayoutManager()) == null || (viewA0D = A0D(layoutManager)) == null) {
            return;
        }
        int[] iArrA0H = A0H(layoutManager, viewA0D);
        if (iArrA0H[0] != 0 || iArrA0H[1] != 0) {
            this.A00.A1e(iArrA0H[0], iArrA0H[1]);
        }
    }

    public final void A0G(C05246g c05246g) throws IllegalStateException {
        if (this.A00 == c05246g) {
            return;
        }
        C05246g c05246g2 = this.A00;
        if (A04[3].charAt(14) == 'w') {
            throw new RuntimeException();
        }
        A04[4] = "xzKGxret4GzWIxaR6oK37PWpSNYAUaFQ";
        if (c05246g2 != null) {
            A07();
        }
        this.A00 = c05246g;
        if (this.A00 != null) {
            A08();
            this.A01 = new Scroller(this.A00.getContext(), new DecelerateInterpolator());
            A0F();
        }
    }
}
