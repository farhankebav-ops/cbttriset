package com.instagram.common.viewpoint.core;

import java.util.NoSuchElementException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Aj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0618Aj<T> extends AbstractC2188pg<T> {
    public T A00;

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Aj != com.google.common.collect.Iterators$SingletonIterator<T> */
    public C0618Aj(T value) {
        this.A00 = value;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Aj != com.google.common.collect.Iterators$SingletonIterator<T> */
    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.A00 != null;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Aj != com.google.common.collect.Iterators$SingletonIterator<T> */
    @Override // java.util.Iterator
    public final T next() {
        T t3 = this.A00;
        this.A00 = null;
        if (t3 != null) {
            return t3;
        }
        throw new NoSuchElementException();
    }
}
