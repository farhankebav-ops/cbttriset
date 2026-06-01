package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Tv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1115Tv implements InterfaceC1261Zo {
    public final /* synthetic */ TD A00;

    public C1115Tv(TD td) {
        this.A00 = td;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1261Zo
    public final void ADT(C1260Zn c1260Zn) {
        this.A00.A0D.set(c1260Zn.A00() != null);
        if (this.A00.A0E.get() && this.A00.A02 != null) {
            this.A00.A02.AEW(c1260Zn.A00() != null);
        }
    }
}
