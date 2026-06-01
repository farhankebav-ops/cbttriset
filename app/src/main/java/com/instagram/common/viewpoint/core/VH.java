package com.instagram.common.viewpoint.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class VH extends AbstractC1101Tg<String> {
    public final /* synthetic */ UP A00;
    public final /* synthetic */ VG A01;

    public VH(VG vg, UP up) {
        this.A01 = vg;
        this.A00 = up;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.instagram.common.viewpoint.core.AbstractC1101Tg
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A02(String str) {
        super.A02(str);
        if (this.A00.A0B()) {
            this.A01.A02.A5u();
        } else {
            this.A01.A02.A5t();
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1101Tg
    public final void A01(int i2, String str) {
        super.A01(i2, str);
    }
}
