package com.ironsource;

import com.ironsource.InterfaceC2410k7;
import com.ironsource.mediationsdk.IronSource;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class r implements InterfaceC2410k7, InterfaceC2410k7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<IronSource.a, AtomicBoolean> f9728a = r5.x.f0(new q5.i(IronSource.a.REWARDED_VIDEO, new AtomicBoolean(false)), new q5.i(IronSource.a.INTERSTITIAL, new AtomicBoolean(false)), new q5.i(IronSource.a.BANNER, new AtomicBoolean(false)));

    @Override // com.ironsource.InterfaceC2410k7.a
    public void a(IronSource.a adFormat, boolean z2) {
        kotlin.jvm.internal.k.e(adFormat, "adFormat");
        AtomicBoolean atomicBoolean = this.f9728a.get(adFormat);
        if (atomicBoolean != null) {
            atomicBoolean.set(z2);
        }
    }

    @Override // com.ironsource.InterfaceC2410k7
    public boolean a(IronSource.a adFormat) {
        kotlin.jvm.internal.k.e(adFormat, "adFormat");
        AtomicBoolean atomicBoolean = this.f9728a.get(adFormat);
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        return false;
    }
}
