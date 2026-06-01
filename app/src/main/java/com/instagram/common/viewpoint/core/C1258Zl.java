package com.instagram.common.viewpoint.core;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1258Zl extends FrameLayout {
    public int A00;
    public int A01;
    public final ImageView A02;
    public final ImageView A03;

    public C1258Zl(C1477dL c1477dL) {
        super(c1477dL);
        this.A03 = new ImageView(c1477dL);
        this.A02 = new ImageView(c1477dL);
        A00();
    }

    public C1258Zl(C1477dL c1477dL, AttributeSet attributeSet) {
        super(c1477dL, attributeSet);
        this.A03 = new ImageView(c1477dL, attributeSet);
        this.A02 = new ImageView(c1477dL, attributeSet);
        A00();
    }

    public C1258Zl(C1477dL c1477dL, AttributeSet attributeSet, int i2) {
        super(c1477dL, attributeSet, i2);
        this.A03 = new ImageView(c1477dL, attributeSet, i2);
        this.A02 = new ImageView(c1477dL, attributeSet, i2);
        A00();
    }

    public C1258Zl(C1477dL c1477dL, AttributeSet attributeSet, int i2, int i8) {
        super(c1477dL, attributeSet, i2, i8);
        this.A03 = new ImageView(c1477dL, attributeSet, i2, i8);
        this.A02 = new ImageView(c1477dL, attributeSet, i2, i8);
        A00();
    }

    private void A00() {
        addView(this.A02, new FrameLayout.LayoutParams(-1, -1));
        addView(this.A03, new FrameLayout.LayoutParams(-2, -2));
        EnumC1185Wq.A04(this.A03, EnumC1185Wq.A0B);
        setId(XP.A00());
    }

    public ImageView getBodyImageView() {
        return this.A03;
    }

    public int getImageHeight() {
        return this.A00;
    }

    public int getImageWidth() {
        return this.A01;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i2, int i8, int i9, int i10) {
        if (this.A01 <= 0 || this.A00 <= 0) {
            super.onLayout(z2, i2, i8, i9, i10);
            return;
        }
        int i11 = i9 - i2;
        int i12 = i10 - i8;
        float fMin = Math.min(i11 / this.A01, i12 / this.A00);
        int i13 = (int) (this.A01 * fMin);
        int i14 = (int) (this.A00 * fMin);
        this.A02.layout(i2, i8, i9, i10);
        int blurBorderViewHeight = (i11 / 2) + i2;
        int blurBorderViewWidth = (i12 / 2) + i8;
        this.A03.layout(blurBorderViewHeight - (i13 / 2), blurBorderViewWidth - (i14 / 2), (i13 / 2) + blurBorderViewHeight, blurBorderViewWidth + (i14 / 2));
        this.A02.setVisibility(0);
    }

    public void setImage(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap2 != null) {
            XP.A0Q(this.A02, new BitmapDrawable(getContext().getResources(), bitmap2));
        } else {
            XP.A0K(this.A02, 0);
        }
        if (bitmap != null) {
            this.A01 = bitmap.getWidth();
            this.A00 = bitmap.getHeight();
            this.A03.setImageBitmap(Bitmap.createBitmap(bitmap));
            return;
        }
        this.A03.setImageDrawable(null);
    }
}
