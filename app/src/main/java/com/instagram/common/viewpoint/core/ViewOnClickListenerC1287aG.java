package com.instagram.common.viewpoint.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aG, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1287aG implements View.OnClickListener {
    public final /* synthetic */ C1289aI A00;

    public ViewOnClickListenerC1287aG(C1289aI c1289aI) {
        this.A00 = c1289aI;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return;
        }
        try {
            this.A00.A05();
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
        }
    }
}
