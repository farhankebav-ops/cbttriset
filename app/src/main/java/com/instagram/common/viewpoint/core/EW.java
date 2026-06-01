package com.instagram.common.viewpoint.core;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class EW extends C1292aL {
    public final ImageView A00;
    public final C1477dL A01;

    public EW(C1477dL c1477dL) {
        super(c1477dL);
        this.A01 = c1477dL;
        setRadius(30);
        this.A00 = new ImageView(c1477dL);
        this.A00.setAdjustViewBounds(true);
        addView(this.A00, new RelativeLayout.LayoutParams(-2, -1));
    }

    public final /* synthetic */ void A00(C1260Zn c1260Zn) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = -2;
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.updateViewLayout(this, layoutParams);
        }
    }

    public void setUrl(String str) {
        KZ kz = new KZ(this.A00, this.A01);
        kz.A04();
        kz.A07(str);
        kz.A06(new InterfaceC1261Zo() { // from class: com.facebook.ads.redexgen.X.EX
            @Override // com.instagram.common.viewpoint.core.InterfaceC1261Zo
            public final void ADT(C1260Zn c1260Zn) {
                this.A00.A00(c1260Zn);
            }
        });
    }
}
