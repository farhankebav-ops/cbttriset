package com.google.firebase.inappmessaging.display.internal.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.firebase.inappmessaging.display.R;
import com.google.firebase.inappmessaging.display.internal.Logging;
import com.google.firebase.inappmessaging.display.internal.layout.util.MeasureUtils;
import com.google.firebase.inappmessaging.display.internal.layout.util.VerticalViewGroupMeasure;
import com.google.firebase.inappmessaging.display.internal.layout.util.ViewMeasure;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class ModalLayoutPortrait extends BaseModalLayout {
    private static final int ITEM_SPACING_DP = 24;
    private int vertItemSpacing;
    private VerticalViewGroupMeasure vgm;

    public ModalLayoutPortrait(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.vgm = new VerticalViewGroupMeasure();
    }

    private boolean isFlex(View view) {
        return view.getId() == R.id.body_scroll || view.getId() == R.id.image_view;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i8, int i9, int i10) {
        int i11;
        int i12;
        super.onLayout(z2, i2, i8, i9, i10);
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int size = getVisibleChildren().size();
        for (int i13 = 0; i13 < size; i13++) {
            View view = getVisibleChildren().get(i13);
            FrameLayout.LayoutParams layoutParams = getLayoutParams(view);
            int measuredHeight = view.getMeasuredHeight();
            int measuredWidth = view.getMeasuredWidth();
            int i14 = measuredHeight + paddingTop;
            if ((layoutParams.gravity & 1) == 1) {
                int i15 = (i9 - i2) / 2;
                int i16 = measuredWidth / 2;
                i12 = i15 - i16;
                i11 = i15 + i16;
            } else {
                i11 = paddingLeft + measuredWidth;
                i12 = paddingLeft;
            }
            Logging.logd("Layout child " + i13);
            Logging.logdPair("\t(top, bottom)", (float) paddingTop, (float) i14);
            Logging.logdPair("\t(left, right)", (float) i12, (float) i11);
            view.layout(i12, paddingTop, i11, i14);
            int measuredHeight2 = view.getMeasuredHeight() + paddingTop;
            if (i13 < size - 1) {
                measuredHeight2 += this.vertItemSpacing;
            }
            paddingTop = measuredHeight2;
        }
    }

    @Override // com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i8) {
        super.onMeasure(i2, i8);
        this.vertItemSpacing = dpToPixels(24);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int iCalculateBaseWidth = calculateBaseWidth(i2);
        int iCalculateBaseHeight = calculateBaseHeight(i8);
        int size = ((getVisibleChildren().size() - 1) * this.vertItemSpacing) + paddingTop;
        this.vgm.reset(iCalculateBaseWidth, iCalculateBaseHeight);
        for (int i9 = 0; i9 < getChildCount(); i9++) {
            View childAt = getChildAt(i9);
            this.vgm.add(childAt, isFlex(childAt));
        }
        Logging.logd("Screen dimens: " + getDisplayMetrics());
        Logging.logdPair("Max pct", getMaxWidthPct(), getMaxHeightPct());
        float f4 = (float) iCalculateBaseWidth;
        Logging.logdPair("Base dimens", f4, iCalculateBaseHeight);
        for (ViewMeasure viewMeasure : this.vgm.getViews()) {
            Logging.logd("Pre-measure child");
            viewMeasure.preMeasure(iCalculateBaseWidth, iCalculateBaseHeight);
        }
        int totalHeight = this.vgm.getTotalHeight() + size;
        Logging.logdNumber("Total reserved height", size);
        Logging.logdNumber("Total desired height", totalHeight);
        boolean z2 = totalHeight > iCalculateBaseHeight;
        Logging.logd("Total height constrained: " + z2);
        if (z2) {
            this.vgm.allocateSpace((iCalculateBaseHeight - size) - this.vgm.getTotalFixedHeight());
        }
        int i10 = iCalculateBaseWidth - paddingLeft;
        for (ViewMeasure viewMeasure2 : this.vgm.getViews()) {
            Logging.logd("Measuring child");
            MeasureUtils.measureAtMost(viewMeasure2.getView(), i10, viewMeasure2.getMaxHeight());
            size += getDesiredHeight(viewMeasure2.getView());
        }
        Logging.logdPair("Measured dims", f4, size);
        setMeasuredDimension(iCalculateBaseWidth, size);
    }
}
