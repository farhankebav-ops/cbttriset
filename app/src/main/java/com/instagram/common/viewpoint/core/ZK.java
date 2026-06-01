package com.instagram.common.viewpoint.core;

import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class ZK implements View.OnClickListener {
    public final /* synthetic */ ZO A00;

    public ZK(ZO zo) {
        this.A00 = zo;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return;
        }
        try {
            if (!this.A00.A09.canGoBack()) {
                return;
            }
            this.A00.A09.goBack();
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
        }
    }
}
