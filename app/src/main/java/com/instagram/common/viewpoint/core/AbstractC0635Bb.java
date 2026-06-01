package com.instagram.common.viewpoint.core;

import android.util.Log;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Bb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC0635Bb implements InterfaceC1653gE {
    public int A00;

    @Override // com.instagram.common.viewpoint.core.InterfaceC1653gE
    public final void A9l(String str, String str2) {
        Log.i(str, str2);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1653gE
    public final void A9m(String str, String str2, Throwable th) {
        Log.i(str, str2, th);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1653gE
    public final boolean AAP(int i2) {
        return this.A00 <= i2;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1653gE
    public final void AIo(int i2) {
        this.A00 = i2;
    }
}
