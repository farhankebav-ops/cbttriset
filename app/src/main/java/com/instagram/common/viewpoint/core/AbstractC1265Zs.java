package com.instagram.common.viewpoint.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zs, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1265Zs {
    public static void A00(View view, boolean z2, View.OnClickListener onClickListener) {
        if (!z2) {
            view.setOnClickListener(onClickListener);
        } else {
            if (!z2) {
                return;
            }
            ViewOnClickListenerC1264Zr viewOnClickListenerC1264Zr = new ViewOnClickListenerC1264Zr(onClickListener);
            view.setOnClickListener(viewOnClickListenerC1264Zr);
            view.setOnTouchListener(new ViewOnTouchListenerC1263Zq(viewOnClickListenerC1264Zr));
        }
    }
}
