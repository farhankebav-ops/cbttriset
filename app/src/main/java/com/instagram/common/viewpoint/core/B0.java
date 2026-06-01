package com.instagram.common.viewpoint.core;

import com.google.common.collect.ParametricNullness;
import java.util.Comparator;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class B0 extends AbstractC1985m4 {
    public B0() {
        super(null);
    }

    private final AbstractC1985m4 A00(int result) {
        if (result < 0) {
            return AbstractC1985m4.A02;
        }
        if (result > 0) {
            return AbstractC1985m4.A01;
        }
        return AbstractC1985m4.A00;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1985m4
    public final int A05() {
        return 0;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1985m4
    public final AbstractC1985m4 A06(int left, int right) {
        return A00(AD.A01(left, right));
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1985m4
    public final AbstractC1985m4 A07(long left, long right) {
        return A00(AbstractC2210q7.A01(left, right));
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1985m4
    public final <T> AbstractC1985m4 A08(@ParametricNullness T left, @ParametricNullness T right, Comparator<T> comparator) {
        return A00(comparator.compare(left, right));
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1985m4
    public final AbstractC1985m4 A09(boolean left, boolean right) {
        return A00(PD.A00(left, right));
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1985m4
    public final AbstractC1985m4 A0A(boolean left, boolean right) {
        return A00(PD.A00(right, left));
    }
}
