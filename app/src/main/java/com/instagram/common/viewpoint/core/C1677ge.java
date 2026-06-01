package com.instagram.common.viewpoint.core;

import android.graphics.drawable.Drawable;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ge, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1677ge implements OF {
    public Drawable A00;
    public final /* synthetic */ OE A01;

    public C1677ge(OE oe) {
        this.A01 = oe;
    }

    @Override // com.instagram.common.viewpoint.core.OF
    public final Drawable A76() {
        return this.A00;
    }

    @Override // com.instagram.common.viewpoint.core.OF
    public final OE A77() {
        return this.A01;
    }

    @Override // com.instagram.common.viewpoint.core.OF
    public final boolean A8i() {
        return this.A01.getPreventCornerOverlap();
    }

    @Override // com.instagram.common.viewpoint.core.OF
    public final boolean A9J() {
        return this.A01.getUseCompatPadding();
    }

    @Override // com.instagram.common.viewpoint.core.OF
    public final void AIa(Drawable drawable) {
        this.A00 = drawable;
        this.A01.setBackgroundDrawable(drawable);
    }

    @Override // com.instagram.common.viewpoint.core.OF
    public final void AJ1(int i2, int i8, int i9, int i10) {
        this.A01.A05.set(i2, i8, i9, i10);
        super/*android.widget.FrameLayout*/.setPadding(this.A01.A04.left + i2, this.A01.A04.top + i8, this.A01.A04.right + i9, this.A01.A04.bottom + i10);
    }
}
