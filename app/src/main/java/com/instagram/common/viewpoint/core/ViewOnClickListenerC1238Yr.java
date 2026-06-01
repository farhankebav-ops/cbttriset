package com.instagram.common.viewpoint.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Yr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1238Yr implements View.OnClickListener {
    public final /* synthetic */ O6 A00;
    public final /* synthetic */ C1228Yh A01;
    public final /* synthetic */ LU A02;

    public ViewOnClickListenerC1238Yr(LU lu, C1228Yh c1228Yh, O6 o62) {
        this.A02 = lu;
        this.A01 = c1228Yh;
        this.A00 = o62;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return;
        }
        try {
            this.A01.A01();
            this.A02.A0B.AEP(this.A00);
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
        }
    }
}
