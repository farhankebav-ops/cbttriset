package com.bytedance.sdk.component.adexpress.vCE;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.GravityCompat;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class pP extends FrameLayout {
    private static final int DmF = (com.bytedance.sdk.component.adexpress.dynamic.Cc.EV.MY("", 0.0f, true)[1] / 2) + 1;
    private static final int NV = (com.bytedance.sdk.component.adexpress.dynamic.Cc.EV.MY("", 0.0f, true)[1] / 2) + 3;
    private double Bc;
    private Drawable Cc;
    private float EO;
    LinearLayout IlO;
    LinearLayout MY;
    private float lEW;
    private float tV;
    private Drawable vCE;

    public pP(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.IlO = new LinearLayout(getContext());
        this.MY = new LinearLayout(getContext());
        this.IlO.setOrientation(0);
        this.IlO.setGravity(GravityCompat.START);
        this.MY.setOrientation(0);
        this.MY.setGravity(GravityCompat.START);
        this.Cc = com.bytedance.sdk.component.utils.pP.EO(context, "tt_star_thick");
        this.vCE = com.bytedance.sdk.component.utils.pP.EO(context, "tt_star");
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams((int) this.EO, (int) this.tV));
        imageView.setPadding(1, DmF, 1, NV);
        return imageView;
    }

    public void IlO(double d8, int i2, int i8, int i9) {
        float f4 = i8;
        this.EO = (int) com.bytedance.sdk.component.adexpress.tV.Bc.EO(getContext(), f4);
        this.tV = (int) com.bytedance.sdk.component.adexpress.tV.Bc.EO(getContext(), f4);
        this.Bc = d8;
        this.lEW = i9;
        removeAllViews();
        for (int i10 = 0; i10 < 5; i10++) {
            ImageView starImageView = getStarImageView();
            starImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView.setColorFilter(i2, PorterDuff.Mode.SRC_IN);
            starImageView.setImageDrawable(getStarFillDrawable());
            this.MY.addView(starImageView);
        }
        for (int i11 = 0; i11 < 5; i11++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView2.setImageDrawable(getStarEmptyDrawable());
            this.IlO.addView(starImageView2);
        }
        addView(this.IlO);
        addView(this.MY);
        requestLayout();
    }

    public Drawable getStarEmptyDrawable() {
        return this.Cc;
    }

    public Drawable getStarFillDrawable() {
        return this.vCE;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i8) {
        super.onMeasure(i2, i8);
        this.IlO.measure(i2, i8);
        double d8 = this.Bc;
        float f4 = this.EO;
        this.MY.measure(View.MeasureSpec.makeMeasureSpec((int) (((d8 - ((double) ((int) d8))) * ((double) (f4 - 2.0f))) + ((double) ((((int) d8) * f4) + 1.0f))), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(this.IlO.getMeasuredHeight(), BasicMeasure.EXACTLY));
        if (this.lEW > 0.0f) {
            this.IlO.setPadding(0, ((int) (r7.getMeasuredHeight() - this.lEW)) / 2, 0, 0);
            this.MY.setPadding(0, ((int) (this.IlO.getMeasuredHeight() - this.lEW)) / 2, 0, 0);
        }
    }
}
