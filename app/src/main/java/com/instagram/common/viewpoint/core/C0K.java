package com.instagram.common.viewpoint.core;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0K, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0K extends C03710h {
    public C05105s A00;
    public List<C1444cn> A01;

    public C0K(C1477dL c1477dL) {
        super(c1477dL);
        this.A00 = new C05105s(this, 1, null, null, null);
    }

    public final void A20(C1550eX c1550eX) {
        if (this.A00 != null) {
            this.A00.A0c(c1550eX);
        }
    }

    public C05105s getCarouselCardBehaviorHelper() {
        return this.A00;
    }

    public void setCardsInfo(ArrayList arrayList) {
        this.A01 = arrayList;
        this.A00.A0d(this.A01);
    }
}
