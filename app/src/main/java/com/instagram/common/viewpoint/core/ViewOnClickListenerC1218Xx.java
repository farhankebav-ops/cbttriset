package com.instagram.common.viewpoint.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1218Xx implements View.OnClickListener {
    public final /* synthetic */ C0959Nr A00;

    public ViewOnClickListenerC1218Xx(C0959Nr c0959Nr) {
        this.A00 = c0959Nr;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return;
        }
        try {
            if (this.A00.A01 != null && this.A00.A02.A02()) {
                this.A00.A01.ACC(this.A00);
            }
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
        }
    }
}
