package com.instagram.common.viewpoint.core;

import android.widget.ImageView;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class GD implements InterfaceC1261Zo {
    public final /* synthetic */ C4K A00;

    public GD(C4K c4k) {
        this.A00 = c4k;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1261Zo
    public final void ADT(C1260Zn c1260Zn) {
        if (this.A00.A02 != null && c1260Zn.A00() != null) {
            this.A00.A02.setImageBitmap(c1260Zn.A00());
            this.A00.A02.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.A00.A02.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        }
    }
}
