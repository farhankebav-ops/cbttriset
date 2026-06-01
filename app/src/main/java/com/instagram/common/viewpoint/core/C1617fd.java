package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.fd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1617fd extends AbstractRunnableC1151Vg {
    public final /* synthetic */ C1614fa A00;
    public final /* synthetic */ V1 A01;

    public C1617fd(C1614fa c1614fa, V1 v12) {
        this.A00 = c1614fa;
        this.A01 = v12;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1151Vg
    public final void A01() {
        if (this.A00.A00.A00() != null) {
            this.A00.A00.A00().onAdError(WT.A00(this.A01));
        }
    }
}
