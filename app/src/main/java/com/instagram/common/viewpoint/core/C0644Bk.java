package com.instagram.common.viewpoint.core;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Bk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C0644Bk implements InterfaceC1557ee {
    public final /* synthetic */ C04071r A00;
    public final /* synthetic */ CountDownLatch A01;
    public final /* synthetic */ AtomicReference A02;
    public final /* synthetic */ AtomicReference A03;

    public C0644Bk(C04071r c04071r, AtomicReference atomicReference, AtomicReference atomicReference2, CountDownLatch countDownLatch) {
        this.A00 = c04071r;
        this.A03 = atomicReference;
        this.A02 = atomicReference2;
        this.A01 = countDownLatch;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1557ee
    public final void ACo(InterfaceC1555ec interfaceC1555ec) {
        C04071r.A06(interfaceC1555ec.A6v(), this.A03, this.A02);
        this.A01.countDown();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1557ee
    public final void ADC(Exception exc) {
        this.A02.set(exc);
        this.A01.countDown();
    }
}
