package com.instagram.common.viewpoint.core;

import com.google.common.collect.ElementTypesAreNonnullByDefault;
import com.google.common.collect.ParametricNullness;
import java.io.Serializable;
import java.util.Comparator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: assets/audience_network.dex */
@ElementTypesAreNonnullByDefault
public final class B2<T> extends AbstractC2133oV<T> implements Serializable {
    public static String[] A01 = {"jVomwQRsen5vglXLuhXzBdwbPq6Ybrnn", "4aFITO9kz2LhtcD79HHzI", "vi18DojAtNgr3DJJSarcVnM7GKn6nndK", "ML5KuQXC", "N0lS1ni31cQ1TBeJZ0107lcHpyRIIPod", "312TaVRQAIGqwiXD4iywzyjTEypEIgK4", "JELmBa89yxiLk2CDuF87Yo0NIlkJ44v9", "QWcb8PBY5hKO"};
    public static final long serialVersionUID = 0;
    public final Comparator<T> A00;

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.B2 != com.google.common.collect.ComparatorOrdering<T> */
    public B2(Comparator<T> comparator) {
        this.A00 = (Comparator) AbstractC1819jA.A04(comparator);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.B2 != com.google.common.collect.ComparatorOrdering<T> */
    @Override // com.instagram.common.viewpoint.core.AbstractC2133oV, java.util.Comparator
    public final int compare(@ParametricNullness T a8, @ParametricNullness T b8) {
        return this.A00.compare(a8, b8);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.B2 != com.google.common.collect.ComparatorOrdering<?> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.B2 != com.google.common.collect.ComparatorOrdering<T> */
    @Override // java.util.Comparator
    public final boolean equals(@CheckForNull Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof B2) {
            return this.A00.equals(((B2) object).A00);
        }
        String[] strArr = A01;
        if (strArr[0].charAt(22) == strArr[5].charAt(22)) {
            throw new RuntimeException();
        }
        A01[7] = "MG7YcOvDvuMg";
        return false;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.B2 != com.google.common.collect.ComparatorOrdering<T> */
    public final int hashCode() {
        return this.A00.hashCode();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.B2 != com.google.common.collect.ComparatorOrdering<T> */
    public final String toString() {
        return this.A00.toString();
    }
}
