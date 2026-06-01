package com.instagram.common.viewpoint.core;

import android.os.SystemClock;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Bc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0636Bc implements InterfaceC1659gK {
    public static final C0636Bc A00 = new C0636Bc();

    public static C0636Bc A00() {
        return A00;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1659gK
    public final long AC6() {
        return SystemClock.elapsedRealtime();
    }
}
