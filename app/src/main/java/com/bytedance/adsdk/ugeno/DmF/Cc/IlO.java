package com.bytedance.adsdk.ugeno.DmF.Cc;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.GravityCompat;
import com.bytedance.adsdk.ugeno.Bc.lEW;
import com.bytedance.adsdk.ugeno.tV;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO extends FrameLayout {
    private Context Bc;
    private LinearLayout Cc;
    private double EO;
    private float IlO;
    private float MY;
    private tV lEW;
    private float tV;
    private LinearLayout vCE;

    public IlO(Context context) {
        super(context);
        this.Bc = context;
        this.Cc = new LinearLayout(context);
        this.vCE = new LinearLayout(context);
        this.Cc.setOrientation(0);
        this.Cc.setGravity(GravityCompat.START);
        this.vCE.setOrientation(0);
        this.vCE.setGravity(GravityCompat.START);
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) this.IlO, (int) this.MY);
        float f4 = this.tV;
        layoutParams.leftMargin = (int) f4;
        layoutParams.topMargin = 0;
        layoutParams.rightMargin = (int) f4;
        layoutParams.bottomMargin = 1;
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    public void IlO(double d8, int i2, int i8, float f4, int i9) {
        removeAllViews();
        this.Cc.removeAllViews();
        this.vCE.removeAllViews();
        this.IlO = (int) lEW.IlO(this.Bc, f4);
        this.MY = (int) lEW.IlO(this.Bc, f4);
        this.EO = d8;
        this.tV = i9;
        for (int i10 = 0; i10 < 5; i10++) {
            ImageView starImageView = getStarImageView();
            starImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView.setImageResource(com.bytedance.adsdk.ugeno.Bc.tV.IlO(this.Bc, "tt_ugen_rating_star"));
            starImageView.setColorFilter(i2, PorterDuff.Mode.SRC_IN);
            this.vCE.addView(starImageView);
        }
        for (int i11 = 0; i11 < 5; i11++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView2.setImageResource(com.bytedance.adsdk.ugeno.Bc.tV.IlO(this.Bc, "tt_ugen_rating_star"));
            starImageView2.setColorFilter(i8);
            this.Cc.addView(starImageView2);
        }
        addView(this.Cc);
        addView(this.vCE);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        tV tVVar = this.lEW;
        if (tVVar != null) {
            tVVar.Bc();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        tV tVVar = this.lEW;
        if (tVVar != null) {
            tVVar.lEW();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i8, int i9, int i10) {
        tV tVVar = this.lEW;
        if (tVVar != null) {
            tVVar.IlO(i2, i8, i9, i10);
        }
        super.onLayout(z2, i2, i8, i9, i10);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i8) {
        tV tVVar = this.lEW;
        if (tVVar != null) {
            tVVar.IlO(i2, i8);
        }
        super.onMeasure(i2, i8);
        this.Cc.measure(i2, i8);
        double dFloor = Math.floor(this.EO);
        float f4 = this.tV;
        float f8 = this.IlO;
        this.vCE.measure(View.MeasureSpec.makeMeasureSpec((int) (((this.EO - dFloor) * ((double) f8)) + (((double) (f4 + f4 + f8)) * dFloor) + ((double) f4)), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(this.Cc.getMeasuredHeight(), BasicMeasure.EXACTLY));
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i8, int i9, int i10) {
        super.onSizeChanged(i2, i8, i9, i10);
        tV tVVar = this.lEW;
        if (tVVar != null) {
            tVVar.MY(i2, i8, i9, i10);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
    }

    public void IlO(tV tVVar) {
        this.lEW = tVVar;
    }
}
