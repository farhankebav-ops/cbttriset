package com.instagram.common.viewpoint.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Yq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1237Yq implements View.OnClickListener {
    public final /* synthetic */ LU A00;

    public ViewOnClickListenerC1237Yq(LU lu) {
        this.A00 = lu;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return;
        }
        try {
            this.A00.A0B.A9U();
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
        }
    }
}
