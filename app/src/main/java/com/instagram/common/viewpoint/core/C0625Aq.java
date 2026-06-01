package com.instagram.common.viewpoint.core;

import com.google.common.collect.ParametricNullness;
import java.util.Comparator;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Aq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0625Aq extends AbstractC1985m4 {
    public final int A00;

    public C0625Aq(int result) {
        super(null);
        this.A00 = result;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1985m4
    public final int A05() {
        return this.A00;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1985m4
    public final AbstractC1985m4 A06(int left, int right) {
        return this;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1985m4
    public final AbstractC1985m4 A07(long left, long right) {
        return this;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1985m4
    public final <T> AbstractC1985m4 A08(@ParametricNullness T left, @ParametricNullness T right, Comparator<T> comparator) {
        return this;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1985m4
    public final AbstractC1985m4 A09(boolean left, boolean right) {
        return this;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1985m4
    public final AbstractC1985m4 A0A(boolean left, boolean right) {
        return this;
    }
}
