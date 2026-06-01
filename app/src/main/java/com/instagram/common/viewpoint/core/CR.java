package com.instagram.common.viewpoint.core;

import com.facebook.ads.androidx.media3.common.Timeline;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class CR implements InterfaceC04322s {
    public final /* synthetic */ InterfaceC1529eC A00;
    public final /* synthetic */ C1532eF A01;

    @Override // com.instagram.common.viewpoint.core.InterfaceC04322s
    public final /* synthetic */ void ACv(C2103o0 c2103o0) {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC04322s
    public final /* synthetic */ void ACw(List list) {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC04322s
    public final /* synthetic */ void AFQ(Timeline timeline, int i2) {
        AbstractC04312r.A00(this, timeline, i2);
    }

    public CR(C1532eF c1532eF, InterfaceC1529eC interfaceC1529eC) {
        this.A01 = c1532eF;
        this.A00 = interfaceC1529eC;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC04322s
    public final void AEb(C2138ob c2138ob) {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC04322s
    public final void AEd(C2140od c2140od) {
        this.A00.AEe(C1532eF.A01(c2140od), c2140od);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC04322s
    public final void AEf(boolean z2, int i2) {
        this.A00.AEf(z2, i2);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC04322s
    public final void AFB() {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC04322s
    public final void AFU(C2109o6 c2109o6) {
    }
}
