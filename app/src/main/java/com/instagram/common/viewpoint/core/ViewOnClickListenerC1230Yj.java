package com.instagram.common.viewpoint.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Yj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1230Yj implements View.OnClickListener {
    public final /* synthetic */ LV A00;

    public ViewOnClickListenerC1230Yj(LV lv) {
        this.A00 = lv;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return;
        }
        try {
            this.A00.A0B.AEC(O4.A04);
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
        }
    }
}
