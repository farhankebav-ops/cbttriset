package com.instagram.common.viewpoint.core;

import android.media.AudioAttributes;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1N, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1N {
    public final AudioAttributes A00;

    public C1N(C2160oy c2160oy) {
        AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(c2160oy.A02).setFlags(c2160oy.A03).setUsage(c2160oy.A05);
        if (AbstractC04664a.A02 >= 29) {
            C1L.A00(usage, c2160oy.A01);
        }
        if (AbstractC04664a.A02 >= 32) {
            C1M.A00(usage, c2160oy.A04);
        }
        this.A00 = usage.build();
    }
}
