package com.instagram.common.viewpoint.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ya, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1221Ya implements View.OnClickListener {
    public final /* synthetic */ C1223Yc A00;

    public ViewOnClickListenerC1221Ya(C1223Yc c1223Yc) {
        this.A00 = c1223Yc;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return;
        }
        try {
            this.A00.A04.AAg();
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
        }
    }
}
