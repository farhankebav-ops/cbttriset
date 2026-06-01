package com.instagram.common.viewpoint.core;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aR, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1298aR {
    public static final int A00 = XP.A00();

    public static void A00(C1477dL c1477dL, ViewGroup viewGroup, String str) {
        new KZ(viewGroup, c1477dL).A07(str);
        View view = new View(c1477dL);
        view.setId(A00);
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        XP.A0P(view, c1477dL);
        viewGroup.addView(view, 0);
    }
}
