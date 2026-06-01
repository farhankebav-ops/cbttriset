package com.instagram.common.viewpoint.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class K8 implements Comparable<K8> {
    public final int A00;
    public final C0864Jz A01;

    public K8(int i2, C0864Jz c0864Jz) {
        this.A00 = i2;
        this.A01 = c0864Jz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final int compareTo(K8 k8) {
        return Integer.compare(this.A00, k8.A00);
    }
}
