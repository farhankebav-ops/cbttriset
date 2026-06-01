package com.instagram.common.viewpoint.core;

import android.util.DisplayMetrics;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1179Wk {
    public static final AtomicReference<DisplayMetrics> A00 = new AtomicReference<>();

    public static DisplayMetrics A00() {
        if (A00.get() != null) {
            return A00.get();
        }
        return AbstractC1180Wl.A04;
    }
}
