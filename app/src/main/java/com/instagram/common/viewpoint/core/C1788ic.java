package com.instagram.common.viewpoint.core;

import com.facebook.ads.internal.protocol.AdErrorType;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ic, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1788ic implements InterfaceC1048Re {
    public final /* synthetic */ int A00;
    public final /* synthetic */ C7L A01;
    public final /* synthetic */ C7L A02;
    public final /* synthetic */ TF A03;

    public C1788ic(C7L c7l, int i2, TF tf, C7L c7l2) {
        this.A01 = c7l;
        this.A00 = i2;
        this.A03 = tf;
        this.A02 = c7l2;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1048Re
    public final void ACM() {
        this.A01.A0C(this.A00, this.A03);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1048Re
    public final void ACN() {
        this.A01.A00.ADj(this.A02, V1.A00(AdErrorType.NO_FILL));
    }
}
