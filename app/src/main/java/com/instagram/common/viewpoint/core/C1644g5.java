package com.instagram.common.viewpoint.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.g5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1644g5 implements InterfaceC1027Qj {
    public final /* synthetic */ QO A00;

    public C1644g5(QO qo) {
        this.A00 = qo;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1027Qj
    public final View A79(int i2) {
        return this.A00.A0v(i2);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1027Qj
    public final int A7B(View view) {
        return this.A00.A0l(view) + ((QP) view.getLayoutParams()).bottomMargin;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1027Qj
    public final int A7C(View view) {
        return this.A00.A0q(view) - ((QP) view.getLayoutParams()).topMargin;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1027Qj
    public final int A8Y() {
        return this.A00.A0Z() - this.A00.A0f();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1027Qj
    public final int A8Z() {
        return this.A00.A0i();
    }
}
