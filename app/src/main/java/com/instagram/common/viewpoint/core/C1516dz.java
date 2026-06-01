package com.instagram.common.viewpoint.core;

import android.graphics.Paint;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.dz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1516dz extends Paint {
    public final /* synthetic */ C1517e0 A00;
    public final /* synthetic */ boolean A01;

    public C1516dz(C1517e0 c1517e0, boolean z2) {
        this.A00 = c1517e0;
        this.A01 = z2;
        setStyle(Paint.Style.FILL_AND_STROKE);
        setStrokeCap(Paint.Cap.ROUND);
        setStrokeWidth(3.0f);
        setAntiAlias(true);
        setColor(this.A01 ? -1 : -10066330);
    }
}
