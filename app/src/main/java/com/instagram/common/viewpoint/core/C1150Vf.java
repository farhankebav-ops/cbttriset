package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1150Vf implements ViewpointAction<UE, UJ> {
    public VN A00;

    public C1150Vf(VN vn) {
        this.A00 = vn;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.pu != com.instagram.common.viewpoint.core.ViewpointData<com.facebook.ads.internal.impressionsecondchannel.model.Impression, com.facebook.ads.internal.impressionsecondchannel.state.ImpressionState> */
    @Override // com.instagram.common.viewpoint.core.ViewpointAction
    public final void A6J(C2201pu<UE, UJ> c2201pu, InterfaceC2192pk interfaceC2192pk) {
        switch (interfaceC2192pk.A9M(c2201pu)) {
            case A02:
            case A04:
                this.A00.A02(c2201pu, interfaceC2192pk);
                break;
        }
    }
}
