package com.instagram.common.viewpoint.core;

import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class R7 implements View.OnLongClickListener {
    public final /* synthetic */ C1630fq A00;
    public final /* synthetic */ C1259Zm A01;

    public R7(C1630fq c1630fq, C1259Zm c1259Zm) {
        this.A00 = c1630fq;
        this.A01 = c1259Zm;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        if (this.A00.A00 != null) {
            this.A01.setBounds(0, 0, this.A00.A00.getWidth(), this.A00.A00.getHeight());
            this.A01.A0D(!this.A01.A0E());
        }
        return true;
    }
}
