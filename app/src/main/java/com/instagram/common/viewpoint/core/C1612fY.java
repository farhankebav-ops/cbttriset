package com.instagram.common.viewpoint.core;

import android.graphics.drawable.Drawable;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.fY, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1612fY extends AbstractRunnableC1164Vt {
    public final /* synthetic */ Drawable A00;
    public final /* synthetic */ RS A01;
    public final /* synthetic */ C1020Qc A02;

    public C1612fY(RS rs, C1020Qc c1020Qc, Drawable drawable) {
        this.A01 = rs;
        this.A02 = c1020Qc;
        this.A00 = drawable;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1164Vt
    public final void A07() {
        this.A02.A1K(this.A00);
    }
}
