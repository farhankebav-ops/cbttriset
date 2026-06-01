package com.instagram.common.viewpoint.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C6 implements InterfaceC1591fD {
    @Override // com.instagram.common.viewpoint.core.InterfaceC1591fD
    public final long A5e() {
        return System.nanoTime();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1591fD
    public final void AJK(Object obj, long j) throws InterruptedException {
        obj.wait(j);
    }
}
