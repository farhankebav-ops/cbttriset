package com.instagram.common.viewpoint.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Yy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1245Yy implements View.OnClickListener {
    public final /* synthetic */ C1228Yh A00;
    public final /* synthetic */ LS A01;

    public ViewOnClickListenerC1245Yy(LS ls, C1228Yh c1228Yh) {
        this.A01 = ls;
        this.A00 = c1228Yh;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return;
        }
        try {
            this.A00.A01();
            this.A01.A0B.AEC(O4.A06);
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
        }
    }
}
