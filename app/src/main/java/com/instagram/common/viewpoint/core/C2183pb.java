package com.instagram.common.viewpoint.core;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.pb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2183pb {
    public static C2183pb A03 = null;
    public final ViewpointQeConfig A00;
    public final ViewpointRegistry A01;
    public final C2194pm A02;

    public C2183pb(ViewpointQeConfig viewpointQeConfig, AbstractC2199ps abstractC2199ps, C2194pm c2194pm, ViewpointRegistry viewpointRegistry) {
        this.A00 = viewpointQeConfig;
        this.A01 = viewpointRegistry;
        this.A02 = c2194pm;
        abstractC2199ps.A03(new A4(c2194pm));
    }

    public static C2183pb A00(ViewpointQeConfig viewpointQeConfig, AbstractC2199ps abstractC2199ps, InterfaceC2204px interfaceC2204px, A6 a62) {
        C2183pb localsTestInstance = A03;
        if (localsTestInstance != null) {
            return localsTestInstance;
        }
        ViewpointRegistry viewpointRegistry = new ViewpointRegistry(viewpointQeConfig);
        return new C2183pb(viewpointQeConfig, abstractC2199ps, new C2194pm(viewpointQeConfig, interfaceC2204px, C0640Bg.A00, a62, viewpointRegistry, new Handler(Looper.getMainLooper())), viewpointRegistry);
    }

    public final void A01(InterfaceC2198pr interfaceC2198pr) {
        this.A02.A0E(interfaceC2198pr);
    }

    public final void A02(InterfaceC2196pp interfaceC2196pp) {
        this.A02.A0F(interfaceC2196pp);
    }

    public final void A03(DspViewableNode dspViewableNode) {
        A04(dspViewableNode, null);
    }

    public final void A04(DspViewableNode dspViewableNode, C2205q0 c2205q0) {
        if (this.A00.A00 && c2205q0 != null) {
            this.A01.A06(dspViewableNode, c2205q0);
        } else {
            this.A01.A05(dspViewableNode);
        }
    }

    public final void A05(DspViewableNode dspViewableNode, C2205q0 c2205q0, C2201pu c2201pu) {
        if (this.A00.A00 && c2205q0 != null) {
            this.A01.A07(dspViewableNode, c2205q0, c2201pu);
        } else {
            this.A01.A08(dspViewableNode, c2201pu);
        }
    }

    public final void A06(DspViewableNode dspViewableNode, C2201pu c2201pu) {
        A05(dspViewableNode, null, c2201pu);
    }
}
