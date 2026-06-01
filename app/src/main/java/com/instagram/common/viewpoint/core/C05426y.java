package com.instagram.common.viewpoint.core;

import com.facebook.ads.CacheFlag;
import java.util.EnumSet;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6y, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C05426y extends AbstractC1723hQ {
    public C05426y(C1477dL c1477dL, NT nt) {
        super(c1477dL, nt);
    }

    private C1721hO A00(Runnable runnable) {
        return new C1721hO(this, runnable);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1723hQ
    public final AbstractC0930Mo A0I() {
        C1778iS successfullyLoadedAdapter = (C1778iS) this.A01;
        if (successfullyLoadedAdapter != null) {
            return successfullyLoadedAdapter.A09();
        }
        return null;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1723hQ
    public final void A0P() {
        C1778iS interstitialAdapter = (C1778iS) this.A01;
        interstitialAdapter.A0B();
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1723hQ
    public final void A0R(MP mp, TE te, TC tc, NU nu) {
        C1778iS c1778iS = (C1778iS) mp;
        C1722hP c1722hP = new C1722hP(this, nu, c1778iS);
        A0H().postDelayed(c1722hP, te.A05().A05());
        EnumSet<CacheFlag> enumSet = this.A08.A0B;
        if (enumSet == null) {
            enumSet = CacheFlag.ALL;
        }
        c1778iS.A0A(this.A0B, A00(c1722hP), nu, enumSet, this.A08.A04, this.A08.A05, this.A08.A02);
    }
}
