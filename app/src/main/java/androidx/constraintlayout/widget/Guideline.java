package androidx.constraintlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class Guideline extends View {
    private boolean mFilterRedundantCalls;

    public Guideline(Context context) {
        super(context);
        this.mFilterRedundantCalls = true;
        super.setVisibility(8);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i8) {
        setMeasuredDimension(0, 0);
    }

    public void setFilterRedundantCalls(boolean z2) {
        this.mFilterRedundantCalls = z2;
    }

    public void setGuidelineBegin(int i2) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (this.mFilterRedundantCalls && layoutParams.guideBegin == i2) {
            return;
        }
        layoutParams.guideBegin = i2;
        setLayoutParams(layoutParams);
    }

    public void setGuidelineEnd(int i2) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (this.mFilterRedundantCalls && layoutParams.guideEnd == i2) {
            return;
        }
        layoutParams.guideEnd = i2;
        setLayoutParams(layoutParams);
    }

    public void setGuidelinePercent(float f4) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (this.mFilterRedundantCalls && layoutParams.guidePercent == f4) {
            return;
        }
        layoutParams.guidePercent = f4;
        setLayoutParams(layoutParams);
    }

    public Guideline(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFilterRedundantCalls = true;
        super.setVisibility(8);
    }

    public Guideline(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mFilterRedundantCalls = true;
        super.setVisibility(8);
    }

    public Guideline(Context context, AttributeSet attributeSet, int i2, int i8) {
        super(context, attributeSet, i2);
        this.mFilterRedundantCalls = true;
        super.setVisibility(8);
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
    }
}
