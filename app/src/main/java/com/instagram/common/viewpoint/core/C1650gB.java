package com.instagram.common.viewpoint.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.gB, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1650gB extends Q8 {
    public C1650gB(QO qo) {
        super(qo, null);
    }

    @Override // com.instagram.common.viewpoint.core.Q8
    public final int A06() {
        return this.A02.A0Z();
    }

    @Override // com.instagram.common.viewpoint.core.Q8
    public final int A07() {
        return this.A02.A0Z() - this.A02.A0f();
    }

    @Override // com.instagram.common.viewpoint.core.Q8
    public final int A08() {
        return this.A02.A0f();
    }

    @Override // com.instagram.common.viewpoint.core.Q8
    public final int A09() {
        return this.A02.A0a();
    }

    @Override // com.instagram.common.viewpoint.core.Q8
    public final int A0A() {
        return this.A02.A0i();
    }

    @Override // com.instagram.common.viewpoint.core.Q8
    public final int A0B() {
        return (this.A02.A0Z() - this.A02.A0i()) - this.A02.A0f();
    }

    @Override // com.instagram.common.viewpoint.core.Q8
    public final int A0C(View view) {
        return this.A02.A0l(view) + ((QP) view.getLayoutParams()).bottomMargin;
    }

    @Override // com.instagram.common.viewpoint.core.Q8
    public final int A0D(View view) {
        QP qp = (QP) view.getLayoutParams();
        return this.A02.A0n(view) + qp.topMargin + qp.bottomMargin;
    }

    @Override // com.instagram.common.viewpoint.core.Q8
    public final int A0E(View view) {
        QP qp = (QP) view.getLayoutParams();
        return this.A02.A0o(view) + qp.leftMargin + qp.rightMargin;
    }

    @Override // com.instagram.common.viewpoint.core.Q8
    public final int A0F(View view) {
        return this.A02.A0q(view) - ((QP) view.getLayoutParams()).topMargin;
    }

    @Override // com.instagram.common.viewpoint.core.Q8
    public final int A0G(View view) {
        this.A02.A1G(view, true, this.A01);
        return this.A01.bottom;
    }

    @Override // com.instagram.common.viewpoint.core.Q8
    public final int A0H(View view) {
        this.A02.A1G(view, true, this.A01);
        return this.A01.top;
    }

    @Override // com.instagram.common.viewpoint.core.Q8
    public final void A0J(int i2) {
        this.A02.A12(i2);
    }
}
