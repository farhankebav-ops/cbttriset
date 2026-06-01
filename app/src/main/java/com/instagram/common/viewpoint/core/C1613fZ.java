package com.instagram.common.viewpoint.core;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.fZ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1613fZ implements RQ {
    public final /* synthetic */ ImageView A00;
    public final /* synthetic */ RS A01;
    public final /* synthetic */ C1020Qc A02;

    public C1613fZ(RS rs, ImageView imageView, C1020Qc c1020Qc) {
        this.A01 = rs;
        this.A00 = imageView;
        this.A02 = c1020Qc;
    }

    @Override // com.instagram.common.viewpoint.core.RQ
    public final void ADU(Drawable drawable) {
        C1020Qc.A0f(drawable, this.A00);
        this.A02.A1K(drawable);
    }
}
