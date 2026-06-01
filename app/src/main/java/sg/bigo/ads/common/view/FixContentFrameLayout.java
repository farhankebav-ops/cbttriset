package sg.bigo.ads.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import sg.bigo.ads.common.p;

/* JADX INFO: loaded from: classes6.dex */
public class FixContentFrameLayout extends RoundedFrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f16069a;

    public static class a extends FrameLayout.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f16070a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f16071b;

        public a() {
            super(-1, -1);
        }
    }

    public FixContentFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof a) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new a();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new a();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i8) {
        p pVar;
        if (!this.f16069a) {
            super.onMeasure(i2, i8);
            return;
        }
        int defaultSize = View.getDefaultSize(Integer.MIN_VALUE, i2);
        int defaultSize2 = View.getDefaultSize(Integer.MIN_VALUE, i8);
        int childCount = getChildCount();
        int iMax = 0;
        int iMax2 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                a aVar = (a) childAt.getLayoutParams();
                if (aVar.f16070a <= 0 || aVar.f16071b <= 0) {
                    pVar = new p(defaultSize, defaultSize2);
                } else {
                    aVar.setMargins(0, 0, 0, 0);
                    pVar = p.a(aVar.f16070a, aVar.f16071b, defaultSize, defaultSize2);
                }
                iMax = Math.max(iMax, pVar.f15849b);
                iMax2 = Math.max(iMax2, pVar.f15850c);
                childAt.measure(View.MeasureSpec.makeMeasureSpec(Math.max(0, pVar.f15849b), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(Math.max(0, pVar.f15850c), BasicMeasure.EXACTLY));
            }
        }
        setMeasuredDimension(iMax, iMax2);
    }

    public void setFixContent(boolean z2) {
        if (z2) {
            setPadding(0, 0, 0, 0);
        }
        if (z2 != this.f16069a) {
            this.f16069a = z2;
            requestLayout();
        }
    }

    public FixContentFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* synthetic */ FrameLayout.LayoutParams generateDefaultLayoutParams() {
        return new a();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a();
    }

    public FixContentFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setFixContent(true);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* synthetic */ FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new a();
    }
}
