package com.instagram.common.viewpoint.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Yl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1232Yl implements View.OnClickListener {
    public final /* synthetic */ LV A00;

    public ViewOnClickListenerC1232Yl(LV lv) {
        this.A00 = lv;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return;
        }
        try {
            this.A00.A0B.AAh();
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
        }
    }
}
