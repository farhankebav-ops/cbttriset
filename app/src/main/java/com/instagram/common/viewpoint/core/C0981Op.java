package com.instagram.common.viewpoint.core;

import android.content.DialogInterface;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Op, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C0981Op extends AbstractRunnableC1164Vt {
    public final /* synthetic */ DialogInterface A00;
    public final /* synthetic */ DialogInterfaceOnClickListenerC1197Xc A01;

    public C0981Op(DialogInterfaceOnClickListenerC1197Xc dialogInterfaceOnClickListenerC1197Xc, DialogInterface dialogInterface) {
        this.A01 = dialogInterfaceOnClickListenerC1197Xc;
        this.A00 = dialogInterface;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1164Vt
    public final void A07() {
        if (this.A01.A01.A02 != null) {
            this.A01.A01.A02.AGD(VZ.A03(this.A01.A01.A00), new C1570er().A05(this.A01.A01.A02(this.A01.A00.getText().toString())).A08());
        }
        this.A00.cancel();
    }
}
