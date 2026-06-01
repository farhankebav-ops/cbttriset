package com.instagram.common.viewpoint.core;

import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class YZ implements View.OnClickListener {
    public final /* synthetic */ C1223Yc A00;

    public YZ(C1223Yc c1223Yc) {
        this.A00 = c1223Yc;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return;
        }
        try {
            if (this.A00.A05) {
                this.A00.A04.A4v();
            } else {
                this.A00.A04.A4w();
            }
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
        }
    }
}
