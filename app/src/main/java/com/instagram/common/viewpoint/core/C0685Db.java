package com.instagram.common.viewpoint.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Db, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0685Db implements InterfaceC1491dZ {
    public final View A00;
    public final C1477dL A01;

    public C0685Db(C1477dL c1477dL, View view) {
        this.A01 = c1477dL;
        this.A00 = view;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1491dZ
    public final double A9N() {
        C1551eY result = C1550eX.A0E(this.A00, 0, this.A01);
        return result.A00();
    }
}
