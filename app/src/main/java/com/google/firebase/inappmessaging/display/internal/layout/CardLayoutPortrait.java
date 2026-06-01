package com.google.firebase.inappmessaging.display.internal.layout;

import a1.a;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.firebase.inappmessaging.display.R;
import com.google.firebase.inappmessaging.display.internal.Logging;
import com.google.firebase.inappmessaging.display.internal.layout.util.MeasureUtils;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class CardLayoutPortrait extends BaseModalLayout {
    private static double IMAGE_MAX_HEIGHT_PCT = 0.8d;
    private View actionBarChild;
    private View imageChild;
    private View scrollChild;
    private View titleChild;

    public CardLayoutPortrait(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i8, int i9, int i10) {
        super.onLayout(z2, i2, i8, i9, i10);
        int size = getVisibleChildren().size();
        int measuredHeight = 0;
        for (int i11 = 0; i11 < size; i11++) {
            View view = getVisibleChildren().get(i11);
            int measuredHeight2 = view.getMeasuredHeight();
            int measuredWidth = view.getMeasuredWidth();
            int i12 = measuredHeight2 + measuredHeight;
            Logging.logd("Layout child " + i11);
            Logging.logdPair("\t(top, bottom)", (float) measuredHeight, (float) i12);
            Logging.logdPair("\t(left, right)", (float) 0, (float) measuredWidth);
            view.layout(0, measuredHeight, measuredWidth, i12);
            Logging.logdPair(a.h(i11, "Child ", " wants to be "), view.getMeasuredWidth(), view.getMeasuredHeight());
            measuredHeight += view.getMeasuredHeight();
        }
    }

    @Override // com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i8) {
        super.onMeasure(i2, i8);
        this.imageChild = findChildById(R.id.image_view);
        this.titleChild = findChildById(R.id.message_title);
        this.scrollChild = findChildById(R.id.body_scroll);
        this.actionBarChild = findChildById(R.id.action_bar);
        int iCalculateBaseWidth = calculateBaseWidth(i2);
        int iCalculateBaseHeight = calculateBaseHeight(i8);
        int iRoundToNearest = roundToNearest((int) (IMAGE_MAX_HEIGHT_PCT * ((double) iCalculateBaseHeight)), 4);
        Logging.logd("Measuring image");
        MeasureUtils.measureFullWidth(this.imageChild, iCalculateBaseWidth, iCalculateBaseHeight);
        if (getDesiredHeight(this.imageChild) > iRoundToNearest) {
            Logging.logd("Image exceeded maximum height, remeasuring image");
            MeasureUtils.measureFullHeight(this.imageChild, iCalculateBaseWidth, iRoundToNearest);
        }
        int desiredWidth = getDesiredWidth(this.imageChild);
        Logging.logd("Measuring title");
        MeasureUtils.measureFullWidth(this.titleChild, desiredWidth, iCalculateBaseHeight);
        Logging.logd("Measuring action bar");
        MeasureUtils.measureFullWidth(this.actionBarChild, desiredWidth, iCalculateBaseHeight);
        Logging.logd("Measuring scroll view");
        MeasureUtils.measureFullWidth(this.scrollChild, desiredWidth, ((iCalculateBaseHeight - getDesiredHeight(this.imageChild)) - getDesiredHeight(this.titleChild)) - getDesiredHeight(this.actionBarChild));
        int size = getVisibleChildren().size();
        int desiredHeight = 0;
        for (int i9 = 0; i9 < size; i9++) {
            desiredHeight += getDesiredHeight(getVisibleChildren().get(i9));
        }
        setMeasuredDimension(desiredWidth, desiredHeight);
    }
}
