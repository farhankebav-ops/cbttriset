package com.instagram.common.viewpoint.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Yt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1240Yt implements View.OnClickListener {
    public final /* synthetic */ C1242Yv A00;

    public ViewOnClickListenerC1240Yt(C1242Yv c1242Yv) {
        this.A00 = c1242Yv;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return;
        }
        try {
            this.A00.A02.A9U();
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
        }
    }
}
