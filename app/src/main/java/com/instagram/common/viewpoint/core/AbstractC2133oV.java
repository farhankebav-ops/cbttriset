package com.instagram.common.viewpoint.core;

import com.google.common.collect.ElementTypesAreNonnullByDefault;
import com.google.common.collect.ParametricNullness;
import java.util.Comparator;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.oV, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractC2133oV<T> implements Comparator<T> {
    @Override // java.util.Comparator
    public abstract int compare(@ParametricNullness T left, @ParametricNullness T right);

    public static <C extends Comparable> AbstractC2133oV<C> A03() {
        return AQ.A02;
    }

    public static <T> AbstractC2133oV<T> A04(Comparator<T> comparator) {
        if (comparator instanceof AbstractC2133oV) {
            return (AbstractC2133oV) comparator;
        }
        return new B2(comparator);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.ip != com.google.common.base.Function<F, ? extends T> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.oV != com.google.common.collect.Ordering<T> */
    public final <F> AbstractC2133oV<F> A05(InterfaceC1799ip<F, ? extends T> function) {
        return new BA(function, this);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.oV != com.google.common.collect.Ordering<T> */
    public <S extends T> AbstractC2133oV<S> A06() {
        return new AJ(this);
    }
}
