package com.instagram.common.viewpoint.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class E0 implements Comparable<E0> {
    public final boolean A00;
    public final boolean A01;

    public E0(C2154or c2154or, int i2) {
        this.A00 = (c2154or.A0H & 1) != 0;
        this.A01 = AnonymousClass92.A0S(i2, false);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final int compareTo(E0 e02) {
        return AbstractC1985m4.A01().A09(this.A01, e02.A01).A09(this.A00, e02.A00).A05();
    }
}
