package com.instagram.common.viewpoint.core;

import android.view.View;
import android.view.ViewGroup;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class YX extends View {

    @Nullable
    public YW A00;

    public YX(C1477dL c1477dL, YW yw) {
        super(c1477dL);
        this.A00 = yw;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i2) {
        YW yw = this.A00;
    }
}
