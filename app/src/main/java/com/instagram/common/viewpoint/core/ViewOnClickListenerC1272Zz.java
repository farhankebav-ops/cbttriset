package com.instagram.common.viewpoint.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1272Zz implements View.OnClickListener {
    public final /* synthetic */ KL A00;

    public ViewOnClickListenerC1272Zz(KL kl) {
        this.A00 = kl;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return;
        }
        try {
            if (this.A00.A0H.getVisibility() != 8) {
                this.A00.A0U();
                this.A00.A0F.removeCallbacks(this.A00.A0V);
                this.A00.A0p(8);
            } else {
                this.A00.A0p(0);
                this.A00.A0F.postDelayed(this.A00.A0V, 1500L);
            }
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
        }
    }
}
