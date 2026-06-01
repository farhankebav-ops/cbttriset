package com.instagram.common.viewpoint.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.eZ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1552eZ {
    public static boolean A00(View view) {
        return view.getBackground() == null || view.getBackground().getAlpha() <= 0;
    }
}
