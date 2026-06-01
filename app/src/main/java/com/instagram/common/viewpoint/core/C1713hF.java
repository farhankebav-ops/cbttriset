package com.instagram.common.viewpoint.core;

import android.os.Message;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hF, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1713hF extends AbstractRunnableC1151Vg {
    public final /* synthetic */ Message A00;
    public final /* synthetic */ AbstractC1711hD A01;

    public C1713hF(AbstractC1711hD abstractC1711hD, Message message) {
        this.A01 = abstractC1711hD;
        this.A00 = message;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1151Vg
    public final void A01() {
        this.A01.A05.A9b(this.A00);
    }
}
