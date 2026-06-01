package com.google.firebase.inappmessaging.display.internal.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.firebase.inappmessaging.display.R;
import com.google.firebase.inappmessaging.display.internal.Logging;
import com.google.firebase.inappmessaging.display.internal.layout.util.MeasureUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class ModalLayoutLandscape extends BaseModalLayout {
    private static final int ITEM_SPACING_DP = 24;
    private static final float MAX_IMG_WIDTH_PCT = 0.4f;
    private int barrierWidth;
    private View buttonChild;
    private View imageChild;
    private int leftContentHeight;
    private int rightContentHeight;
    private View scrollChild;
    private View titleChild;
    private int vertItemSpacing;

    public ModalLayoutLandscape(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void layoutCenterHorizontal(View view, int i2, int i8, int i9, int i10) {
        int measuredWidth = view.getMeasuredWidth() / 2;
        int i11 = i2 + ((i9 - i2) / 2);
        layoutChild(view, i11 - measuredWidth, i8, i11 + measuredWidth, i10);
    }

    @Override // com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i8, int i9, int i10) {
        int i11;
        int i12;
        super.onLayout(z2, i2, i8, i9, i10);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int measuredWidth = getMeasuredWidth() - getPaddingRight();
        int i13 = this.leftContentHeight;
        int i14 = this.rightContentHeight;
        if (i13 < i14) {
            i12 = (i14 - i13) / 2;
            i11 = 0;
        } else {
            i11 = (i13 - i14) / 2;
            i12 = 0;
        }
        Logging.logd("Layout image");
        int i15 = paddingTop + i12;
        int desiredWidth = getDesiredWidth(this.imageChild) + paddingLeft;
        layoutChild(this.imageChild, paddingLeft, i15, desiredWidth, getDesiredHeight(this.imageChild) + i15);
        int i16 = desiredWidth + this.barrierWidth;
        Logging.logd("Layout getTitle");
        int i17 = paddingTop + i11;
        int desiredHeight = getDesiredHeight(this.titleChild) + i17;
        layoutChild(this.titleChild, i16, i17, measuredWidth, desiredHeight);
        Logging.logd("Layout getBody");
        int i18 = desiredHeight + (this.titleChild.getVisibility() == 8 ? 0 : this.vertItemSpacing);
        int desiredHeight2 = getDesiredHeight(this.scrollChild) + i18;
        layoutChild(this.scrollChild, i16, i18, measuredWidth, desiredHeight2);
        Logging.logd("Layout button");
        layoutChild(this.buttonChild, i16, desiredHeight2 + (this.scrollChild.getVisibility() != 8 ? this.vertItemSpacing : 0));
    }

    @Override // com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i8) {
        super.onMeasure(i2, i8);
        this.imageChild = findChildById(R.id.image_view);
        this.titleChild = findChildById(R.id.message_title);
        this.scrollChild = findChildById(R.id.body_scroll);
        this.buttonChild = findChildById(R.id.button);
        int iMax = 0;
        this.barrierWidth = this.imageChild.getVisibility() == 8 ? 0 : dpToPixels(24);
        this.vertItemSpacing = dpToPixels(24);
        List listAsList = Arrays.asList(this.titleChild, this.scrollChild, this.buttonChild);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int iCalculateBaseWidth = calculateBaseWidth(i2);
        int iCalculateBaseHeight = calculateBaseHeight(i8) - paddingTop;
        int i9 = iCalculateBaseWidth - paddingRight;
        Logging.logd("Measuring image");
        MeasureUtils.measureAtMost(this.imageChild, (int) (i9 * MAX_IMG_WIDTH_PCT), iCalculateBaseHeight);
        int desiredWidth = getDesiredWidth(this.imageChild);
        int i10 = i9 - (this.barrierWidth + desiredWidth);
        float f4 = desiredWidth;
        Logging.logdPair("Max col widths (l, r)", f4, i10);
        Iterator it = listAsList.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() != 8) {
                i11++;
            }
        }
        int iMax2 = Math.max(0, (i11 - 1) * this.vertItemSpacing);
        int i12 = iCalculateBaseHeight - iMax2;
        Logging.logd("Measuring getTitle");
        MeasureUtils.measureAtMost(this.titleChild, i10, i12);
        Logging.logd("Measuring button");
        MeasureUtils.measureAtMost(this.buttonChild, i10, i12);
        Logging.logd("Measuring scroll view");
        MeasureUtils.measureAtMost(this.scrollChild, i10, (i12 - getDesiredHeight(this.titleChild)) - getDesiredHeight(this.buttonChild));
        this.leftContentHeight = getDesiredHeight(this.imageChild);
        this.rightContentHeight = iMax2;
        Iterator it2 = listAsList.iterator();
        while (it2.hasNext()) {
            this.rightContentHeight = getDesiredHeight((View) it2.next()) + this.rightContentHeight;
        }
        int iMax3 = Math.max(this.leftContentHeight + paddingTop, this.rightContentHeight + paddingTop);
        Iterator it3 = listAsList.iterator();
        while (it3.hasNext()) {
            iMax = Math.max(getDesiredWidth((View) it3.next()), iMax);
        }
        Logging.logdPair("Measured columns (l, r)", f4, iMax);
        int i13 = desiredWidth + iMax + this.barrierWidth + paddingRight;
        Logging.logdPair("Measured dims", i13, iMax3);
        setMeasuredDimension(i13, iMax3);
    }
}
