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
public class CardLayoutLandscape extends BaseModalLayout {
    private static double IMAGE_MAX_WIDTH_PCT = 0.6d;
    private View actionBarChild;
    private View imageChild;
    private View scrollChild;
    private View titleChild;

    public CardLayoutLandscape(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i8, int i9, int i10) {
        super.onLayout(z2, i2, i8, i9, i10);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        Logging.logd("Layout image");
        int desiredWidth = getDesiredWidth(this.imageChild);
        layoutChild(this.imageChild, 0, 0, desiredWidth, getDesiredHeight(this.imageChild));
        Logging.logd("Layout title");
        int desiredHeight = getDesiredHeight(this.titleChild);
        layoutChild(this.titleChild, desiredWidth, 0, measuredWidth, desiredHeight);
        Logging.logd("Layout scroll");
        layoutChild(this.scrollChild, desiredWidth, desiredHeight, measuredWidth, getDesiredHeight(this.scrollChild) + desiredHeight);
        Logging.logd("Layout action bar");
        layoutChild(this.actionBarChild, desiredWidth, measuredHeight - getDesiredHeight(this.actionBarChild), measuredWidth, measuredHeight);
    }

    @Override // com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i8) {
        super.onMeasure(i2, i8);
        this.imageChild = findChildById(R.id.image_view);
        this.titleChild = findChildById(R.id.message_title);
        this.scrollChild = findChildById(R.id.body_scroll);
        View viewFindChildById = findChildById(R.id.action_bar);
        this.actionBarChild = viewFindChildById;
        int iMax = 0;
        List listAsList = Arrays.asList(this.titleChild, this.scrollChild, viewFindChildById);
        int iCalculateBaseWidth = calculateBaseWidth(i2);
        int iCalculateBaseHeight = calculateBaseHeight(i8);
        int iRoundToNearest = roundToNearest((int) (IMAGE_MAX_WIDTH_PCT * ((double) iCalculateBaseWidth)), 4);
        Logging.logd("Measuring image");
        MeasureUtils.measureFullHeight(this.imageChild, iCalculateBaseWidth, iCalculateBaseHeight);
        if (getDesiredWidth(this.imageChild) > iRoundToNearest) {
            Logging.logd("Image exceeded maximum width, remeasuring image");
            MeasureUtils.measureFullWidth(this.imageChild, iRoundToNearest, iCalculateBaseHeight);
        }
        int desiredHeight = getDesiredHeight(this.imageChild);
        int desiredWidth = getDesiredWidth(this.imageChild);
        int i9 = iCalculateBaseWidth - desiredWidth;
        float f4 = desiredWidth;
        Logging.logdPair("Max col widths (l, r)", f4, i9);
        Logging.logd("Measuring title");
        MeasureUtils.measureAtMost(this.titleChild, i9, desiredHeight);
        Logging.logd("Measuring action bar");
        MeasureUtils.measureAtMost(this.actionBarChild, i9, desiredHeight);
        Logging.logd("Measuring scroll view");
        MeasureUtils.measureFullHeight(this.scrollChild, i9, (desiredHeight - getDesiredHeight(this.titleChild)) - getDesiredHeight(this.actionBarChild));
        Iterator it = listAsList.iterator();
        while (it.hasNext()) {
            iMax = Math.max(getDesiredWidth((View) it.next()), iMax);
        }
        Logging.logdPair("Measured columns (l, r)", f4, iMax);
        int i10 = desiredWidth + iMax;
        Logging.logdPair("Measured dims", i10, desiredHeight);
        setMeasuredDimension(i10, desiredHeight);
    }
}
