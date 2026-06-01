package com.instagram.common.viewpoint.core;

import android.R;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class NL extends AbstractRunnableC1164Vt {
    public final /* synthetic */ Y0 A00;

    public NL(Y0 y02) {
        this.A00 = y02;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1164Vt
    public final void A07() {
        this.A00.A00.finish(3);
        this.A00.A00.A05().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
