package com.google.firebase.inappmessaging.display.internal;

import a1.a;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class ResizableImageView extends AppCompatImageView {
    private int mDensityDpi;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class Dimensions {
        final int h;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        final int f5616w;

        private Dimensions(int i2, int i8) {
            this.f5616w = i2;
            this.h = i8;
        }
    }

    public ResizableImageView(Context context) {
        super(context);
        init(context);
    }

    private Dimensions bound(int i2, int i8) {
        int maxWidth = getMaxWidth();
        int maxHeight = getMaxHeight();
        if (i2 > maxWidth) {
            Logging.logdNumber("Image: capping width", maxWidth);
            i8 = (i8 * maxWidth) / i2;
            i2 = maxWidth;
        }
        if (i8 > maxHeight) {
            Logging.logdNumber("Image: capping height", maxHeight);
            i2 = (i2 * maxHeight) / i8;
        } else {
            maxHeight = i8;
        }
        return new Dimensions(i2, maxHeight);
    }

    private void checkMinDim() {
        int iMax = Math.max(getMinimumWidth(), getSuggestedMinimumWidth());
        int iMax2 = Math.max(getMinimumHeight(), getSuggestedMinimumHeight());
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f4 = iMax;
        float f8 = iMax2;
        Logging.logdPair("Image: min width, height", f4, f8);
        float f9 = measuredWidth;
        float f10 = measuredHeight;
        Logging.logdPair("Image: actual width, height", f9, f10);
        float f11 = measuredWidth < iMax ? f4 / f9 : 1.0f;
        float f12 = measuredHeight < iMax2 ? f8 / f10 : 1.0f;
        if (f11 <= f12) {
            f11 = f12;
        }
        if (f11 > 1.0d) {
            int iCeil = (int) Math.ceil(f9 * f11);
            int iCeil2 = (int) Math.ceil(f10 * f11);
            StringBuilder sbW = a.w(measuredWidth, "Measured dimension (", "x", measuredHeight, ") too small.  Resizing to ");
            sbW.append(iCeil);
            sbW.append("x");
            sbW.append(iCeil2);
            Logging.logd(sbW.toString());
            Dimensions dimensionsBound = bound(iCeil, iCeil2);
            setMeasuredDimension(dimensionsBound.f5616w, dimensionsBound.h);
        }
    }

    private void init(@NonNull Context context) {
        this.mDensityDpi = (int) (context.getResources().getDisplayMetrics().density * 160.0f);
    }

    private void scalePxToDp(Drawable drawable) {
        Logging.logdPair("Image: intrinsic width, height", drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        Dimensions dimensionsBound = bound((int) Math.ceil((r0 * this.mDensityDpi) / 160), (int) Math.ceil((r5 * this.mDensityDpi) / 160));
        Logging.logdPair("Image: new target dimensions", dimensionsBound.f5616w, dimensionsBound.h);
        setMeasuredDimension(dimensionsBound.f5616w, dimensionsBound.h);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i8) {
        super.onMeasure(i2, i8);
        Drawable drawable = getDrawable();
        boolean adjustViewBounds = getAdjustViewBounds();
        if (drawable == null || !adjustViewBounds) {
            return;
        }
        scalePxToDp(drawable);
        checkMinDim();
    }

    public ResizableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ResizableImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init(context);
    }
}
