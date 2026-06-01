package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ir, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC0830Ir extends AbstractC1311ae {
    public static byte[] A00;

    static {
        A0B();
    }

    public static String A0A(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 22);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0B() {
        A00 = new byte[]{106, 111, 111, 110, 127, 106, 98, 103, 120};
    }

    public abstract void A1P();

    public abstract void A1Q();

    public abstract void A1R();

    public abstract boolean A1S();

    public abstract boolean A1T();

    public AbstractC0830Ir(C1315ai c1315ai, boolean z2) {
        super(c1315ai, z2);
        if (U7.A17(c1315ai.A06())) {
            if (c1315ai.A0C() != null) {
                c1315ai.A0C().setCTAClickListener(getCtaButton());
            }
            getTitleDescContainer().setCTAClickListener(getCtaButton());
        }
    }

    public final void A1O() {
        if (U7.A17(this.A06.A06()) && this.A06.A0C() != null) {
            this.A06.A0C().setCTAClickListener(getCtaButton());
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1311ae
    public KE getCtaButton() {
        return super.getCtaButton();
    }

    public void setAdDetailsClickListener(AbstractC1268Zv abstractC1268Zv) {
        if (U7.A17(this.A06.A06()) && abstractC1268Zv != null) {
            abstractC1268Zv.setOnClickListener(AbstractC1302aV.A03(getCtaButton(), A0A(0, 9, 29)));
        }
    }

    public void setupNativeCtaExtension(C1444cn c1444cn) {
    }
}
