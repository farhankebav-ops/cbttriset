package com.instagram.common.viewpoint.core;

import java.util.concurrent.Callable;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class XZ implements Callable<Void> {
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int[] A06;

    public XZ(int[] iArr, int i2, int i8, int i9, int i10, int i11, int i12) {
        this.A06 = iArr;
        this.A05 = i2;
        this.A01 = i8;
        this.A02 = i9;
        this.A04 = i10;
        this.A00 = i11;
        this.A03 = i12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.Callable
    @Nullable
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final Void call() throws Exception {
        C0982Oq.A00(this.A06, this.A05, this.A01, this.A02, this.A04, this.A00, this.A03);
        return null;
    }
}
